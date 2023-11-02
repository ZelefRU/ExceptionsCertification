package org.example.Controller;

import org.example.Exceptions.*;
import org.example.Model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.example.Controller.Validator.*;
import static org.example.Controller.Validator.checkName;

public class InputCorrectnessChecker {

    /**
     * Проверяем корректность введённых данных
     *
     * @param input Ввод пользователя
     * @return Булево значение (true/false)
     */
    public static void inputCorrectnessChecking(String input) throws DataArgumentCountFormatException, IOException {
        // Разбиваем строку на части
        String[] parts = input.split(" ");

        // Счётчик для ФИО
        int fullNamePartsCounter = 0;
        User user = new User();

        // Проверяем кол-во частей в строке
        if (checkArgumentsLength(parts)) {
            // Делаем отлов ошибок
            try {
                // Проверяем каждую часть и пытаемся преобразовать в нужный тип
                for (String part : parts) {
                    // Получение и проверка номера
                    if (part.startsWith("+")) {
                        checkNumber(part.substring(1));
                        long number = Long.parseLong(part.substring(1));
                        user.setNumber(number);
                        System.out.println("Number: +" + number);
                    }
                    // Получение пола
                    else if (part.equalsIgnoreCase("m") || part.equalsIgnoreCase("f")) {
                        checkGender(part);
                        char gender = part.charAt(0);
                        user.setGender(gender);
                        System.out.println("Gender: " + gender);
                    }
                    // Получение и проверка даты рождения
                    else if (part.contains(".")) {
                        checkBrithDay(part);
                        user.setBirthDay(part);
                        System.out.println("Birth day: " + part);
                    } else {
                        switch (fullNamePartsCounter++) {
                            case 0 -> {
                                checkName(part);
                                user.setLastName(part);
                                System.out.println("Last Name: " + part);
                            }
                            case 1 -> {
                                checkName(part);
                                user.setName(part);
                                System.out.println("Name: " + part);
                            }
                            case 2 -> {
                                checkName(part);
                                user.setSurName(part);
                                System.out.println("Surname: " + part);
                            }
                        }
                    }
                }
            } catch (BirthDayFormatException | NameFormatException | PhoneNumberFormatException |
                     GenderFormatException e) {
                throw new RuntimeException(e);
            }
        }
        Writer.write(user);
    }
}
