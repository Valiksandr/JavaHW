package ru.gb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise {
    protected class Student {
        String name;
        int grade;
        String subject;
    }

    protected List<Student> studentList = new ArrayList<>();
    private String description;
    private Scanner scanner;

    protected String inputString = "[" +
            "{ \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
            "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
            "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}" +
            "]";

    public Exercise(String description, Scanner scanner) {
        this.description = description;
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void run() {
        System.out.println(description);
        System.out.println("===============");
    }

    @Override
    public String toString() {
        return description;
    }

    protected List<Student> parseJSONArray(String inputString) {
        int leftBracketIdx = inputString.indexOf('[');
        if (leftBracketIdx == -1 || leftBracketIdx >= inputString.length() - 1) {
            System.out.println("Не найдено начало массива JSON");
            return null;
        }
        int rightBracketIdx = inputString.indexOf(']', leftBracketIdx + 1);
        if (rightBracketIdx == -1) {
            System.out.println("Не найдено завершение массива JSON");
            return null;
        }

        List<Student> sl = new ArrayList<>();

        for (int leftBraceIdx = inputString.indexOf('{', leftBracketIdx + 1); leftBraceIdx != -1; ) {
            int rightBraceIdx = inputString.indexOf('}', leftBraceIdx + 1);
            if (rightBraceIdx == -1)
                break;

            String[] studentInfo = inputString.
                    substring(leftBraceIdx + 1, rightBraceIdx).
                    trim().
                    replace("\"", "").
                    split(",");

            Student student = new Student();

            for (int i = 0; i < studentInfo.length; i++) {
                String[] topic = studentInfo[i].split(":");

                switch (topic[0].replace("\"", "")) {
                    case "фамилия":
                        student.name = topic[1];
                        break;
                    case "оценка":
                        student.grade = Integer.parseInt(topic[1]);
                        break;
                    case "предмет":
                        student.subject = topic[1];
                        break;
                }
            }
            leftBraceIdx = inputString.indexOf('{', leftBraceIdx + 1);
            sl.add(student);
        }
        return sl;
    }
}
