package demo.spring.service;

import demo.spring.common.bean.Student;
import demo.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 * student service类声明
 * @author yuanjie 2020/04/07 21:29
 */
public interface StudentService {


    public int queryStudentCount();

    public Object queryColumnById(String columnName, int id);

    public Student queryStudentById(int id);

    public List<Student> queryStudentByAge(int age);

}
