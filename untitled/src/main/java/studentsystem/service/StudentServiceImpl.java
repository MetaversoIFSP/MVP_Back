package studentsystem.service;

import studentsystem.model.Student;
import studentsystem.repository.StudentRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsystem.service.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<List<Student>> getAllStudents() {
    	var resp = studentRepository.findAll();
        return Optional.of(
        		resp.isEmpty() ? List.of(new Student())
        					   : resp.stream()
        					  		 .filter(Objects::nonNull)
        					  		 .map(Student::new)
        					  		 .collect(Collectors.toList()));
    }
}
