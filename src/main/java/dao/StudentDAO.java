package dao;

import entity.Student;

import java.util.List;

public interface StudentDAO {

    int insert(Student student);

    List<Student> findAll();
}
