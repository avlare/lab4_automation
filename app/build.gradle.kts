plugins {
    id("java")
}

group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":annotation"))
    implementation(project(":compiler"))
    annotationProcessor(project(":compiler"))
}

tasks.test {
    useJUnitPlatform()
}