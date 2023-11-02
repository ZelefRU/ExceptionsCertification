package org.example;

import org.example.Exceptions.*;

import java.io.IOException;
import java.util.Scanner;

import static org.example.Controller.InputCorrectnessChecker.inputCorrectnessChecking;
import static org.example.Controller.Validator.*;
import static org.example.Controller.Validator.checkName;

public class View {

    public static void showRequest() {
        System.out.print("""
                - Введите данные пользователя -
                Формат: Фамилия Имя Отчество ДатаРождения(dd.mm.yyyy) НомерТелефона(должен начинаться с +) Пол(F или M)
                Ввод:\s""");
        getAnswer();
    }

    // Иванов Иван Иванович 01.09.1999 +71239998877 M
    public static void getAnswer() {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            System.out.println(input);

            try {
                inputCorrectnessChecking(input);
            } catch (DataArgumentCountFormatException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
