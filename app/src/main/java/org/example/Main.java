package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        // for task 3. It will work after build
        Library library = new Library();

        Book book = new Book("Автор 1", "Книга", 2020, "12345678932145");
        Newspaper newspaper = new Newspaper("Видавництво 1", "Газета", 2024, 128);
        Publication publication = new Publication("Автор 2", "Публікація", 1999);

        library.addPublication(book);
        library.addPublication(newspaper);
        library.addPublication(publication);

        for (Object publication1 : library.getPublications()) {
            System.out.println(publication1);
        }
    }

}