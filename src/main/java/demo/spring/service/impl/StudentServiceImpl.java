package demo.spring.service.impl;

import demo.spring.common.bean.Student;
import demo.spring.dao.StudentDao;
import demo.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 * student 学生类实现方法
 * @author yuanjie 2020/04/07 21:32
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    public int queryStudentCount() {
       return studentDao.findAll();
    }

    @Override
    public Object queryColumnById(String columnName, int id) {
        return studentDao.findColumnById(columnName, id);
    }

    @Override
    public Student queryStudentById(int id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public List<Student> queryStudentByAge(int age) {
        return studentDao.findStudentByAge(age);
    }

}
