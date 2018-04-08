package jdbc;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * JDBC的连接方式
 *
 * @author YC
 * @create 2018/3/18 15:54.
 */
public class DBCPConnection {

    public static void main(String[] args) throws SQLException {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/yc_database?useUnicode=true&amp;characterEncoding=utf-8");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("aA123");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxIdle(2);
        basicDataSource.setMaxActive(4);
        basicDataSource.setMaxWait(10000);

        Connection connection = basicDataSource.getConnection();
        System.out.println(connection);
        System.out.println(basicDataSource.getNumActive());
        System.out.println(basicDataSource.getNumIdle());
        basicDataSource.close();
    }
}
