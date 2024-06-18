package org.example;

import static org.example.ValidationRuntime.conditionsValidation;

public class Main {
    public static void main(String[] args) {
        // for task 3. It will work after build
        Library library = new Library();

        Book book = new Book("Автор 1", "Книга", 2020, "12345678932145");
        Newspaper newspaper = new Newspaper("", "Газета", 2000, 128);
        Publication publication = new Publication("Автор 2", "Публікація", 2000);

        library.addPublication(book);
        library.addPublication(newspaper);
        library.addPublication(publication);

        for (Object publication1 : library.getPublications()) {
            System.out.println(publication1);
        }

        //task 4. Runtime annotation
        Publication publication2 = new Publication("", "Публікація 1", 2000);
        Publication publication3 = new Publication("Автор 3", "Публікація 2", 2024);
        Publication publication4 = new Publication("Автор 4", "Публікація 3", 100);
        try {
            conditionsValidation(publication2); //here catch exception about empty field author
            conditionsValidation(publication3);
            conditionsValidation(publication4); //here catch exception about wrong field year (min is 1500)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}