package demo.spring.dao.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import demo.spring.common.bean.Student;
import demo.spring.dao.StudentDao;
import demo.spring.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int findAll() {
        String sql = "select count(1) from Student";
        int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return rowCount;
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

}
