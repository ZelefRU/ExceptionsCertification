package org.example;

public class Test {

    public static void main(String[] args) {

        String name = "1234567890-1234567890-234567890";
        if (name != null && (name.length() > 2 || name.length() < 32)) {
            System.out.println(name.length());
            System.out.println("Yes");
        } else {
            System.out.println(name);
        }
    }
}
