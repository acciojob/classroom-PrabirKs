package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
@Component
public class StudentRepository {
    //creating storage for each
    private HashMap<String,Student> studentDB ;
    private HashMap<String,Teacher> TeacherDB ;
    private HashMap<String, List<String>> TeacherStudentDB ;

    public StudentRepository() {
        this.studentDB = new HashMap<String,Student>();
        this.TeacherDB = new HashMap<String,Teacher>();
        this.TeacherStudentDB = new HashMap<String,List<String>>();
    }

    public void storeStudent(Student student){
        studentDB.put(student.getName(),student) ;
    }

    public void storeTeacher(Teacher teacher){
        TeacherDB.put(teacher.getName(),teacher) ;
    }
    public void storeTeacherStudentPair(String teacher,String student){
         List<String> studentList = new ArrayList<>() ;
        if(studentDB.containsKey(student) && TeacherDB.containsKey(teacher)){

            if (TeacherStudentDB.containsKey(teacher)) {
                studentList = TeacherStudentDB.get(teacher);
            }
            studentList.add(student) ;
            TeacherStudentDB.put(teacher,studentList) ;
        }
    }
    public Student getStudent(String student){
        return studentDB.get(student) ;
    }

    public Teacher getTeacher(String teacher){
        return TeacherDB.get(teacher) ;
    }

    public List<String> getStudentsOfTeacher(String teacher){
        List<String> studentList = new ArrayList<>() ;
        if(TeacherStudentDB.containsKey(teacher)){
            studentList = TeacherStudentDB.get(teacher) ;
        }
        return studentList ;
    }
    public List<String> getAllStudent(){
         List<String> students = new ArrayList<>(studentDB.keySet()) ;
         return students ;
    }
    public void deleteTeacher(String teacher){
        //first store all the student of teacher
        List<String> studentList = new ArrayList<>() ;
        if(TeacherStudentDB.containsKey(teacher)){
            studentList = TeacherStudentDB.get(teacher) ;
        }
        //removing the students
        for(String student : studentList){
            studentDB.remove(student) ;
        }
        //removing teacher
        TeacherStudentDB.remove(teacher) ;
        TeacherDB.remove(teacher) ;
    }

    public void deleteAllTeacher(){
        HashSet<String> studentList = new HashSet<>() ;
        for(String teacher : TeacherStudentDB.keySet()){
            for(String student : TeacherStudentDB.get(teacher)){
                studentList.add(student) ;
            }
        }

        for(String student : studentList){
            studentDB.remove(student) ;
        }
        TeacherStudentDB.clear();
        TeacherDB.clear();
    }

}
