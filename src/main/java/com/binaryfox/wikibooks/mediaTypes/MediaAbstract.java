package com.binaryfox.wikibooks.mediaTypes;

public abstract class MediaAbstract {
    private String title;
    public MediaAbstract(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }
    private void setTitle(String title) throws IllegalArgumentException {
        if (checkStringInvalid(title)) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public static boolean checkStringInvalid(String string){
        return string == null || string.trim().isEmpty();
    }

    // this method is taking isbn numbers, removes dashes and spaces and returns the numbers in an Array to be used in the checkISBN methods
    public static int[] stringToIntArray(String string) {
        string = string.replaceAll("-", "").replaceAll(" ", "");
        int[] result = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            result[i] = Integer.parseInt(string.substring(i, i + 1));
        }
        return result;
    }

    public static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }

}
