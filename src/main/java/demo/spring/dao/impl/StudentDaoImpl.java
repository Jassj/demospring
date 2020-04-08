package demo.spring.dao.impl;

import demo.spring.common.bean.Student;
import demo.spring.dao.StudentDao;
import demo.spring.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int findAll() {
        String sql = "select count(1) from Student";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Object findColumnById(String columnName, int id) {
        String sql = "select " + columnName + " from Student where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, Object.class);
    }

    @Override
    public Student findStudentById(int id) {
        String sql = "select id, name, age from Student where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
    }

    @Override
    public List<Student> findStudentByAge(int age) {
        String sql = "select id, name, age from Student where age = ?";
        return jdbcTemplate.query(sql, new Object[]{age}, new StudentMapper());
    }

    @Override
    // 事务传播级别, 事务隔离级别, 事务超时时间(s), 事务回滚行为
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 30, rollbackFor = Exception.class)
    public void createStudent(Student student) {
        String name = student.getName();
        int age = student.getAge();
        String sql = "insert into Student (name, age) values (?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

}
