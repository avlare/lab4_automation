package org.example;

import java.lang.annotation.*;

// task 2.
//The logic should provide for the use at runtime.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validation {
    int min() default 1000;
    int max() default 3000;
    boolean notEmpty() default false;
}