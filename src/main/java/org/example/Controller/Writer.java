package org.example.Controller;

import org.example.Model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void write(User user) throws IOException {
        File file = new File(user.getLastName());
        try (FileWriter writer = new FileWriter(file);) {
            if (file.exists()) {
                System.out.println("append");
                writer.append(user.toString());
            } else {
                file.createNewFile();
                System.out.println("write");
                writer.append(user.toString());
            }
        }
    }
}
