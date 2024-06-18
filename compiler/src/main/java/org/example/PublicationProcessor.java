package org.example;

import com.squareup.javapoet.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.io.*;
import java.util.*;

@SupportedAnnotationTypes("org.example.GenerateLibrary")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class PublicationProcessor extends AbstractProcessor {

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateLibrary.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement typeElement = (TypeElement) element;
                try {
                    generateClass(typeElement);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private void generateClass(TypeElement typeElement) throws IOException {
        String packageName = processingEnv.getElementUtils().getPackageOf(typeElement).getQualifiedName().toString();
        generateLibraryClass(packageName);
    }

    private void generateLibraryClass(String packageName) throws IOException {
        FieldSpec publicationField = FieldSpec.builder(ParameterizedTypeName.get(List.class, Object.class), "publications", Modifier.PRIVATE)
                .initializer("new $T<>()", ArrayList.class)
                .build();

        MethodSpec constructor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .build();

        MethodSpec addPublication = MethodSpec.methodBuilder("addPublication")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Object.class, "publication")
                .addStatement("publications.add(publication)")
                .build();

        MethodSpec getPublications = MethodSpec.methodBuilder("getPublications")
                .addModifiers(Modifier.PUBLIC)
                .returns(ParameterizedTypeName.get(List.class, Object.class))
                .addStatement("return publications")
                .build();

        TypeSpec libraryClass = TypeSpec.classBuilder("Library")
                .addModifiers(Modifier.PUBLIC)
                .addField(publicationField)
                .addMethod(constructor)
                .addMethod(addPublication)
                .addMethod(getPublications)
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, libraryClass)
                .build();

        javaFile.writeTo(processingEnv.getFiler());
    }
}