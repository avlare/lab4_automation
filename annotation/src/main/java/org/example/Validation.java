package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface Validation {
    int min() default 1000;
    int max() default 3000;
    boolean notEmpty() default false;
}