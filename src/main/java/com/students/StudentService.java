package com.students;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/by-subject")
    public List<Student> getStudentsBySubject(@RequestParam String subject) {
        return studentRepo.findStudentsByCourseSubject(subject);
    }

    @GetMapping("/by-degree")
    public List<Student> getStudentsByDegree(){
        return studentRepo.findStudentsByDegree();
    }

    @PostMapping
    public Student addStudent(@RequestBody NewStudentRequest request) {
        Student s = new Student();
        s.setAge(request.age());
        s.setGrad(request.grad());
        s.setName(request.name());
        s.setSurname(request.surname());
        s.setMedia(request.media());
        s.setSubject(request.subject());
        studentRepo.save(s);
        return s;
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer id) {
        studentRepo.deleteById(id);
    }

    @PutMapping("{studentId}")
    public void updateCustomer(@PathVariable("studentId") Integer id,
                               @RequestBody NewStudentRequest request) {
        Optional<Student> optionalCustomer = studentRepo.findById(id);
        if (optionalCustomer.isPresent()) {
            Student existingStudent = optionalCustomer.get();
            existingStudent.setName(request.name());
            existingStudent.setSurname(request.surname());
            existingStudent.setAge(request.age());
            existingStudent.setGrad(request.grad());
            existingStudent.setSubject(request.subject());
            existingStudent.setMedia(request.media());
            studentRepo.save(existingStudent);
        }
    }

}
