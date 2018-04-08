package app;

import entity.Student;
import impl.StudentImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        StudentImpl studentImpl = (StudentImpl) applicationContext.getBean("student");
        Student student = new Student();
        student.setName("YangChen-TEST");
        student.setAge("25");
        int insert = studentImpl.insert(student);
        System.out.println(insert);

        System.out.println(studentImpl.findAll().get(0).getName());
    }
}
