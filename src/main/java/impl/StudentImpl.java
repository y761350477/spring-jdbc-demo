package impl;

import dao.StudentDAO;
import entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("student")
public class StudentImpl implements StudentDAO {

    @Resource
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public int insert(Student student) {
        String sql = "INSERT student(name, age) VALUES(?, ?)";
        Object[] objects = new Object[2];
        objects[0] = student.getName();
        objects[1] = student.getAge();
        int i = jdbcTemplate.update(sql, objects);
        return i;
    }

    @Override
    public List<Student> findAll() {

        RowMapper rowMapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getString("age"));
                return student;
            }
        };
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, rowMapper);

    }
}
