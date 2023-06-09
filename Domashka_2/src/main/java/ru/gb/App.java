/*
Урок 2. Почему вы не можете не использовать API

1. Дана json строка
    [
        { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}
    ]

Задача написать метод(ы), который распарсить строку и выдаст
ответ вида:

Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

Используйте StringBuilder для подготовки ответа

2.  Создать метод, который запишет результат работы в файл.
Обработайте исключения и запишите ошибки в лог файл

3. *Получить исходную json строку из файла, используя FileReader или Scanner
 */
package ru.gb;

public final class App {
    public static void main(String[] args) {
        Lesson lesson = new Lesson_02("Урок 2. Почему вы не можете не использовать API");

        while (true) {
            int choice = lesson.menu();

            if (choice == -1)
                break;

            System.out.printf("Задание номер %d\n", choice + 1);
            System.out.println("===============");

            lesson.runExercise(choice);
            waitForEnter();
        }
    }

    private static void waitForEnter() {
        System.out.print("\nНажмите Enter для продолжения...");

        try {
            System.in.skip(System.in.available());
            System.in.read();
        } catch (Exception e) {
        }
        System.out.println();
    }
}

