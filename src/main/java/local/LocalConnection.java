package local;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class LocalConnection {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("datasource");
        System.out.println(dataSource.getConnection());
    }
}
