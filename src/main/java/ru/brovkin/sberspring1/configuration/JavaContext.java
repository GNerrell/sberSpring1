package ru.brovkin.sberspring1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.brovkin.sberspring1.data.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("ru.brovkin.sberspring1.data")
public class JavaContext {

    @Bean
    public Student firstStudent() {
        Map<Subjects, Integer> marksMap = new HashMap<>();

        marksMap.put(Subjects.MATHEMATICS, 3);
        marksMap.put(Subjects.PHYSICS, 2);
        marksMap.put(Subjects.CHEMISTRY, 2);

        return new Student("Jackob", marksMap);
    }

    @Bean
    public Student secondStudent() {
        Map<Subjects, Integer> marksMap = new HashMap<>();

        marksMap.put(Subjects.MATHEMATICS, 5);
        marksMap.put(Subjects.PHYSICS, 4);
        marksMap.put(Subjects.CHEMISTRY, 3);

        return new Student("Nataniel", marksMap);
    }

    @Bean
    public Student thirdStudent() {
        Map<Subjects, Integer> marksMap = new HashMap<>();

        marksMap.put(Subjects.MATHEMATICS, 4);
        marksMap.put(Subjects.PHYSICS, 2);
        marksMap.put(Subjects.CHEMISTRY, 2);

        return new Student("Jil", marksMap);
    }

    @Bean
    public static MarksChangerBeanPostProcessor marksChanger() {
        return new MarksChangerBeanPostProcessor();
    }

}
