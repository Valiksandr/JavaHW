package ru.gb;

import java.util.List;
import java.util.Scanner;

/*
Дана json строка
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
*/

public class Exercise_01 extends Exercise {

    private List<Student> studentList;

    public Exercise_01(String description, Scanner scanner) {
        super(description, scanner);
    }

    public void run() {
        super.run();

        System.out.printf("Исходная строка: %s\n", inputString);
        if ((studentList = parseJSONArray(inputString)) == null)
            return;

        StringBuilder sb = new StringBuilder();

        for(Student student: studentList)
        {
            sb.append("Студент ");
            sb.append(student.name);
            sb.append(" получил ");
            sb.append(student.grade);
            sb.append(" по предмету ");
            sb.append(student.subject);
            sb.append("\n");
        }
        System.out.printf("Разобранный вариант:\n%s", sb.toString());
    }
}
