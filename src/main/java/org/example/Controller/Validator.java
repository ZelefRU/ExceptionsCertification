package org.example.Controller;

import org.example.Exceptions.*;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void checkNumber(String input) throws PhoneNumberFormatException {
        long number;
        try {
            number = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new PhoneNumberFormatException("Не удалось преобразовать номер в число, проверьте что номер не содержит лишних символов, кроме + в начале");
        }
        if (number <= 10000000000L || number >= 100000000000L) {
            throw new PhoneNumberFormatException("Номер должен содержать 11 цифр!");
        }
    }

    public static void checkBrithDay(String birthDay) throws BirthDayFormatException {
        // Format dd.mm.yyyy
        String[] parts = birthDay.split("\\.");
        if (parts.length == 3) {
            int day = Integer.parseInt(parts[0]);
            if (day > 31 || day < 1) {
                throw new BirthDayFormatException("День должен быть от 1 до 31! Вы указали " + day);
            }
            int month = Integer.parseInt(parts[1]);
            if (month > 12 || month < 1) {
                throw new BirthDayFormatException("Месяц должен быть от 1 до 12! Вы указали " + month);
            }
            int year = Integer.parseInt(parts[2]);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (year > currentYear || year < 0) {
                throw new BirthDayFormatException(
                        String.format("Год должен быть больше 0 и не больше текущего (%s). Вы указали %s",
                                currentYear, year));
            }
        } else {
            throw new BirthDayFormatException("Дата должна быть в формате dd.mm.yyyy! Вы указали " + birthDay);
        }
    }

    public static void checkName(String name) throws NameFormatException {
        if (name.length() > 32 || name.length() < 2) {
            throw new NameFormatException("Имя не должно быть меньше 2 и больше 32 букв. Ваше имя " + name + ". Длинна " + name.length());
        } else {
            String regex = "^[a-zA-Zа-яА-Я]{3,31}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);

            // Проверяем, соответствует ли строка регулярному выражению
            if (matcher.matches()) {
            } else {
                throw new NameFormatException("Имя не прошло проверку на символы. Ваше имя " + name);
            }
        }
    }

    public static boolean checkGender(String c) throws GenderFormatException {
        if (c.equalsIgnoreCase("m") || c.equalsIgnoreCase("f")) {
            return true;
        } else {
            throw new GenderFormatException("Пол должен указываться одной буквой F или M на англисйком языке.");
        }
    }

    public static boolean checkArgumentsLength(String[] input) throws DataArgumentCountFormatException {
        if (input.length == 6) {
            return true;
        } else {
            throw new DataArgumentCountFormatException("Количество аргументов должно быть равным 6. Используйте пробелы только для разделения аргументов!");
        }
    }
}
