import exceptions.*;
import numerals.ArabNum;
import numerals.RomanNum;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws CountCharactersException, NoNumbersException,
            DifferentTypesOfNumbersException, MoreThanTenException, OperationException {

        Character w = null;
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию: ");

        while (scanner.hasNext()) {

            String s = scanner.nextLine().replaceAll(" ", "");
            if (!s.contains("+") && !s.contains("-") && !s.contains("*") && !s.contains("/")){
                throw new OperationException("Ошибочная операция");
            }

            String[] strings = s.split("(\\+|\\-|\\*|\\/)");
            if (strings.length > 2) {
                throw new CountCharactersException("Количество символов более 2");
            }
            Pattern pattern = Pattern.compile("(\\+|\\-|\\*|\\/)");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                w = matcher.group().charAt(0);
            }
            if (strings[0].matches("\\d|10") && strings[1].matches("\\d|10")) {
                int a = Integer.parseInt(strings[0]);
                int b = Integer.parseInt(strings[1]);

                if (w == '+') {
                    result = a + b;
                }
                if (w == '-') {
                    result = a - b;
                }
                if (w == '*') {
                    result = a * b;
                }
                if (w == '/') {
                    if (b == 0){
                        throw new  ArithmeticException("Деление на ноль - не математическая операция");
                    }
                    result = a / b;
                }
                System.out.println(result);
            }
            if (strings[0].matches("I|II|III|IV|V|VI|VII|VIII|IX|X") && strings[1].
                    matches("I|II|III|IV|V|VI|VII|VIII|IX|X")) {
                int a = ArabNum.arabNumerals(strings[0]);
                int b = ArabNum.arabNumerals(strings[1]);

                if (w == '+') {
                    result = a + b;
                }
                if (w == '-') {
                    result = a - b;
                }
                if (w == '*') {
                    result = a * b;
                }
                if (w == '/') {
                    result = a / b;
                }
                System.out.println(RomanNum.romanNumerals(result));
            }
            if (!strings[0].matches("I|II|III|IV|V|VI|VII|VIII|IX|X|\\d+") && !strings[1].
                    matches("I|II|III|IV|V|VI|VII|VIII|IX|X|\\d+")){
                throw new NoNumbersException("Вы ввели не цифры");
            }
            if (strings[0].matches("I|II|III|IV|V|VI|VII|VIII|IX|X") && strings[1].matches("\\d")){
                throw new DifferentTypesOfNumbersException("Вы ввели цифры разных типов (Введите либо арабские, либо римские");
            }
            if (strings[0].matches("\\d") && strings[1].matches("I|II|III|IV|V|VI|VII|VIII|IX|X")){
                throw new DifferentTypesOfNumbersException("Вы ввели цифры разных типов (Введите либо арабские, либо римские цифры");
            }
            if (strings[0].matches("^([11-99]{2,3})") || strings[1].matches("^([11-99]{2,3})")) {
                throw new MoreThanTenException("Введите число не превышающее десять");
            }
            System.out.println("Введите новую операцию");
        }
    }
}