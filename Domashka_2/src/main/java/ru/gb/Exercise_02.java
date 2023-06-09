package ru.gb;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
Создать метод, который запишет результат работы в файл.
Обработайте исключения и запишите ошибки в лог файл
*/
public class Exercise_02 extends Exercise {
    public Exercise_02(String description, Scanner scanner) {
        super(description, scanner);
    }

    public void run() {
        super.run();

        Logger logger = Logger.getLogger(this.getClass().getName());
        try {
            FileHandler handler = new FileHandler("log.txt");
            logger.addHandler(handler);
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
            logger.setUseParentHandlers(false);

            FileWriter fileWriter = new FileWriter("Exercise_02.txt", false);

            fileWriter.write(String.format("Исходная строка: %s\n", inputString));

            if ((studentList = parseJSONArray(inputString)) == null)
                return;

            fileWriter.write("Разобранный вариант:\n");

            for(Student student: studentList)
            {
                StringBuilder sb = new StringBuilder();

                sb.append("Студент ");
                sb.append(student.name);
                sb.append(" получил ");
                sb.append(student.grade);
                sb.append(" по предмету ");
                sb.append(student.subject);

                fileWriter.write(String.format("\t%s\n", sb.toString()));
            }
            fileWriter.flush();
        } catch (Exception e) {
            logger.log(Level.SEVERE, Arrays.toString(e.getStackTrace()));
        }
    }
}
