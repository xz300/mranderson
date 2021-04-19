package Homework15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Students> students = new ArrayList<>(Arrays.asList(new Students("Alex", Arrays.asList
                        (new Courses("physic"), new Courses("biology"))),
                new Students("Andrey", Arrays.asList
                        (new Courses("physic"), new Courses("biology"), new Courses("testing"))),
                new Students("Pavel", Arrays.asList
                        (new Courses("physic"), new Courses("biology"), new Courses("testing"))),
                new Students("Vlad", Arrays.asList
                        (new Courses("physic"), new Courses("english"), new Courses("history"),
                                new Courses("testing")))));
        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet()));
        System.out.printf(" ");
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));
        System.out.printf(" ");
        Courses courses = new Courses("testing");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(courses))
                .collect(Collectors.toList()));
    }
}

// Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
//
// Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
// (любознательность определяется количеством курсов).
//
// Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
// которые посещают этот курс.