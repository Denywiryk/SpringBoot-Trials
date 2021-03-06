package com.deny.MySpringProject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //@Component
public class StudentService{

           private    final  StudentRepository studentRepository ;
                  @Autowired
           public StudentService(StudentRepository studentRepository) {

               this.studentRepository = studentRepository;
           }

           public List<Student> getSudent(){
                      return studentRepository.findAll();
    }

           public void addNewStudent( Student student) throws IllegalAccessException {

               Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
                        if  (studentOptional.isPresent()) {
                            throw  new IllegalAccessException("Email taken");
                        }
              studentRepository.save(student);
           }

    public void deleteStudent(Long studentId) {

                   boolean exists =   studentRepository.existsById(studentId);
                   if(!exists){
                       throw  new IllegalStateException(

                               "student with id "+ studentId +" does not exist"
                       );
                   }
                   studentRepository.deleteById(studentId);
    }
}

