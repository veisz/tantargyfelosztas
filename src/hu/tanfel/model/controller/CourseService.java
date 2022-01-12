package hu.tanfel.model.controller;

import hu.tanfel.model.domain.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {

    private final List<Course> courses;

    public CourseService(List<Course> courses) {
        this.courses = courses;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public int getTotalLessonCount() {
        return courses.stream()
                .mapToInt(Course::getWeelyLessonNumber)
                .sum();
    }

    public int getTeacherWeeklyLesson(String name) {
        return courses.stream()
                .filter(i -> i.getTeacher().equals(name))
                .mapToInt(Course::getWeelyLessonNumber)
                .sum();

    }

    public List<String> getMasterTeachers() {
        return courses.stream()
                .filter(i ->"osztalyfonoki".equals(i.getSubject()))
                .map(i -> String.format("%s - %s", i.getClassId(), i.getTeacher()))
                .collect(Collectors.toList());
    }

    public String getCourseStratus(String subject, String classId) {
        return getCertainCourseCount(subject, classId) == 1
                ? "Osztáyszinten tanulják."
                : "Csoportbontásban tanulják.";
    }

    public long getTeacherCount() {
        return courses.stream()
                .map(Course::getTeacher)
                .distinct()
                .count();
    }

    private long getCertainCourseCount(String subject, String classId) {
        return courses.stream()
                .filter(i -> i.getSubject().equals(subject) && i.getClassId().equals(classId))
                .count();
    }
}
