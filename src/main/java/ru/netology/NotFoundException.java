package ru.netology;

import java.util.IdentityHashMap;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Element with id: " + id + " not found");
    }


}

