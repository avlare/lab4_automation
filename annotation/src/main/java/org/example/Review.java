package org.example;

import java.lang.annotation.*;

// task 2.
//The logic should provide for the use at compilation.
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Review {
    String reviewer();
    String date();
    int rating();
}