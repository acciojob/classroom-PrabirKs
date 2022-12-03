package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository ;

    public void addStudent(Student student){
        studentRepository.storeStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.storeTeacher(teacher);
    }

    public void addStudentTeacherPair(String student,String teacher){
        studentRepository.storeTeacherStudentPair(teacher,student);
    }

    public Student findStudent(String student){
        return studentRepository.getStudent(student) ;
    }

    public Teacher findTeacher(String teacher){
        return studentRepository.getTeacher(teacher) ;
    }

    public List<String> findStudentOfTeacher(String teacher){
        return studentRepository.getStudentsOfTeacher(teacher) ;
    }

    public List<String> findAllStudent(){
        return studentRepository.getAllStudent() ;
    }
    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeacher(){
        studentRepository.deleteAllTeacher();
    }
}
