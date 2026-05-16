package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private JsonUtil() {}

    public static String serializeStudent(Student student) {
        String serializeStudent = GSON.toJson(student);
        return serializeStudent;
    }

    public static Student deserializeStudent(String json) {
        Student student = GSON.fromJson(json, Student.class);
        return student;
    }

    public static String serializeUniversity(University university) {
        String serializeUniversity = GSON.toJson(university);
        return serializeUniversity;
    }
    public static University deserializeUniversity(String json) {
        University university = GSON.fromJson(json, University.class);
        return university;
    }
    public static String serializeStudentList(List<Student> students){
        return GSON.toJson(students);
    }
    public static List<Student> deserializeStudentList(String json){
        Type type = new TypeToken<List<Student>>(){}.getType();
        return GSON.fromJson(json, type);
    }
    public static String serializeUniversityList(List<University> universities){
        return GSON.toJson(universities);
    }
    public static List<University> deserializeUniversityList(String json){
        Type type = new TypeToken<List<University>>(){}.getType();
        return GSON.fromJson(json, type);
    }
}