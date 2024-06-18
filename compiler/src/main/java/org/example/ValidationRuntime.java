package org.example;

import java.lang.reflect.Field;

//task 4
public class ValidationRuntime {
    public static void conditionsValidation(Object publication) {
        Field[] allRequirement = publication.getClass().getDeclaredFields();
        for (Field requirement : allRequirement) {
            if (requirement.isAnnotationPresent(Validation.class)) {
                Validation validationAnnotation = requirement.getAnnotation(Validation.class);
                requirement.setAccessible(true);
                try {
                    if (requirement.getType() == String.class) {
                        String value = (String) requirement.get(publication);
                        if (validationAnnotation.notEmpty() && (value == null || value.isEmpty())) {
                            throw new RuntimeException("This field (" + requirement.getName() + ") is required :).");
                        }
                    } else if (requirement.getType() == int.class) {
                        int res = requirement.getInt(publication);
                        int min = validationAnnotation.min();
                        int max = validationAnnotation.max();
                        if (res < min || res > max) {
                            throw new RuntimeException("This field (" + requirement.getName() + ") must be between " + min + " and " + max + " :).");
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
