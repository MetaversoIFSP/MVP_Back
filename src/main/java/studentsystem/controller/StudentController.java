package studentsystem.controller;

import studentsystem.model.Student;
import studentsystem.service.interfaces.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> add(@RequestBody Student student){
    	var nStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(nStudent);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> list(){
        return studentService.getAllStudents()
        					 .filter(Objects::nonNull)
        					 .map(ResponseEntity::ok)
        					 .orElseGet(() -> ResponseEntity.noContent().build());
    }
}
