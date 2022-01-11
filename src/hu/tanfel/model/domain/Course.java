package hu.tanfel.model.domain;

public class Course {

    private final String teacher;
    private final String subject;
    private final String classId;
    private final int weelyLessonNumber;

    public Course(String teacher, String subject, String classId, int weelyLessonNumber) {
        this.teacher = teacher;
        this.subject = subject;
        this.classId = classId;
        this.weelyLessonNumber = weelyLessonNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassId() {
        return classId;
    }

    public int getWeelyLessonNumber() {
        return weelyLessonNumber;
    }
}
