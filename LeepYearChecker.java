import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для считывания ввода пользователя
        try {
            System.out.print("Введите год: "); // Выводим приглашение для ввода года
            int year = scanner.nextInt(); // Считываем введенный год
            if (year < 0) { // Проверяем, является ли год отрицательным
                throw new IllegalArgumentException("Год должен быть положительным числом"); // Генерируем исключение, если год отрицательный
            }
            if (isLeapYear(year)) { // Проверяем, является ли год високосным, вызывая метод isLeapYear
                System.out.println(year + " - високосный год"); // Выводим сообщение, если год високосный
            } else {
                System.out.println(year + " - не високосный год"); // Выводим сообщение, если год не високосный
            }
        } catch (Exception e) { // Обрабатываем исключение, если произошла ошибка при вводе года
            System.out.println("Ошибка: " + e.getMessage()); // Выводим сообщение об ошибке
        } finally {
            scanner.close(); // Закрываем объект Scanner для освобождения ресурсов
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) { // Проверяем, делится ли год на 4 без остатка
            if (year % 100 == 0) { // Проверяем, делится ли год на 100 без остатка
                if (year % 400 == 0) { // Проверяем, делится ли год на 400 без остатка
                    return true; // Год является високосным, если делится на 400 без остатка
                } else {
                    return false; // Год не является високосным, если делится на 100 без остатка, но не делится на 400 без остатка
                }
            } else {
                return true; // Год является високосным, если делится на 4 без остатка, но не делится на 100 без остатка
            }
        } else {
            return false; // Год не является високосным, если не делится на 4 без остатка
        }
    }
}
