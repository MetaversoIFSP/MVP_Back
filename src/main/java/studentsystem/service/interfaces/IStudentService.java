package studentsystem.service.interfaces;

import java.util.List;
import java.util.Optional;

import studentsystem.model.Student;

public interface IStudentService {
    public Student saveStudent(Student student);
    public Optional<List<Student>> getAllStudents();
}
