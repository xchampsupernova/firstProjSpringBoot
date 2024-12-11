package com.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentRepo studentRepo;
    @InjectMocks
    StudentService studentService;

    @BeforeAll
    public static void init(){
        System.out.println("Before All");
    }

    @BeforeEach
    public void methodCalled(){
        System.out.println("A method has been invoked");
    }

    @Test
    void shouldAddStudentSuccessfully(){
        Student s = new Student();
        s.setName("Simone");
        s.setSurname("Cuccaro");
        s.setAge(24);
        s.setMedia(24.96);
        s.setSubject("Informatica");
        s.setGrad(true);

        Mockito.when(studentRepo.save(Mockito.any(Student.class))).thenAnswer(invocation -> {
            Student savedStudent = invocation.getArgument(0);
            savedStudent.setId(1); // Simulate setting the ID by the database
            return savedStudent;
        });

        NewStudentRequest newStudentRequest = new NewStudentRequest(s.getName(), s.getSurname(), s.getAge(), s.getSubject(), s.getMedia(), s.getGrad());
        Student studentAdded = studentService.addStudent(newStudentRequest);

        Assertions.assertNotNull(studentAdded.getId());
        Assertions.assertEquals("Simone", studentAdded.getName());
    }

    @Test
    public void shouldDeleteStudentSuccessfully(){
        doNothing().when(studentRepo).deleteById(1);
        studentService.deleteStudent(1);
        Mockito.verify(studentRepo,times(1)).deleteById(1);
    }

}
