package ru.jenia.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setFullName("Иванов Иван Иванович");
        ivan.setGroup("1А");
        ivan.setEnrollment(LocalDate.of(2009, 9, 1));
        System.out.println(ivan.getFullName() + " начал обучение в группе "
                + ivan.getGroup() + " с " + ivan.getEnrollment());
    }
}
