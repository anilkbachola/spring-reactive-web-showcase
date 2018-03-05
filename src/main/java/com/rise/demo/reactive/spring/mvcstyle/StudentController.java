package com.rise.demo.reactive.spring.mvcstyle;

import com.rise.demo.reactive.spring.mvcstyle.dao.Student;
import com.rise.demo.reactive.spring.mvcstyle.dao.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{studentId}")
    public Mono<Student> getStudent(@PathVariable(value = "studentId") Integer id) {
        return studentRepository.getStudent(id);
    }

    @PostMapping()
    public Mono<Student> createStudent(@RequestBody Student student) {
        return studentRepository.saveStudent(student);
    }

}
