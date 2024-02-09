package ru.brovkin.sberspring1.data;

import org.springframework.beans.factory.InitializingBean;

import java.util.Map;

public class Student implements InitializingBean {

    private final String name;
    private boolean enrolled = false;
    private final Map<Subjects, Integer> marksMap;

    public Student(String name, Map<Subjects, Integer> marksMap) {
        this.name = name;
        this.marksMap = marksMap;
    }

    public String getName() {
        return name;
    }

    public Map<Subjects, Integer> getMarksMap() {
        return marksMap;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public double calculateAverageMark() {
        int sum = 0;
        for (int mark : marksMap.values()) {
            sum += mark;
        }
        return (double) sum / marksMap.size();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (calculateAverageMark() >= 3) {
            setEnrolled(true);
        }
    }

    @Override
    public String toString() {
        return "Student {" +
                "name='" + name + '\'' +
                ", enrolled=" + enrolled +
                ", marks map=" + marksMap +
                '}';
    }

}
