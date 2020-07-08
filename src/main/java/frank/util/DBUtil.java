package frank.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import frank.exceeption.SystemException;

import javax.sql.DataSource;


/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/7 10:47
 */
public class DBUtil {
    private static volatile DataSource DATA_SOURCE;
    private static final String URL="jdbc:mysql://localhost:3306/blogdemo";

    private static final String USERNAME ="root";
    private static final String PASSWORD="";

    private DBUtil(){

    }

    private static DataSource getDataSource(){
        if(DATA_SOURCE==null){
            synchronized (DBUtil.class){
                if (DATA_SOURCE==null){
                    DATA_SOURCE=new MysqlDataSource();
                    ((MysqlDataSource) DATA_SOURCE).setURL(URL);
                    ((MysqlDataSource) DATA_SOURCE).setUser(USERNAME);
                    ((MysqlDataSource) DATA_SOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATA_SOURCE;
    }
    public static Connection getConnection(){
        try {
             return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new SystemException(Contant.DB_ERROR_CODE,"获取数据库连接失败",e);
        }
    }
    public static void close(Connection connection, Statement statment, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statment!=null)
                statment.close();
            if(resultSet!=null)
                resultSet.close();
        }catch (Exception e){
            throw new SystemException(Contant.DB_ERROR_CODE,"释放资源失败",e);
        }
    }
    public static void close(Connection connection,Statement statement){
        close(connection,statement,null);
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
