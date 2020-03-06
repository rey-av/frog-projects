package com.frog.takhsin.utils;

public abstract class Assert {

    public static <T> void notNull(T object, String errMessage) {
        if (object == null) {
            throw new NullPointerException(errMessage);
        }
    }


    public static void isTrue(boolean expression, String errMessage) {
        if (!expression) {
            throw new IllegalStateException(errMessage);
        }
    }

}
