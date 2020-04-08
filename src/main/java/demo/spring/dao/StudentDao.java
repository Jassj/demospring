package demo.spring.dao;

import demo.spring.common.bean.Student;

import java.util.List;

public interface StudentDao {
    public int findAll();

    public Object findColumnById(String columnName, int id);

    public Student findStudentById(int id);

    public List<Student> findStudentByAge(int age);

    public void createStudent(Student student);
}
