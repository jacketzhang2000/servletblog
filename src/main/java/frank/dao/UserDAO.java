package frank.dao;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import frank.exceeption.SystemException;
import frank.model.User;
import frank.util.Contant;
import frank.util.DBUtil;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/10 16:45
 */
public class UserDAO {
    public static User queryByName(String name){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        try{
            connection=DBUtil.getConnection();
            String sql="select id,name,create_time from user where name=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(name);
                user.setCreateTime(
                        new Date(resultSet.getTimestamp("create_time").getTime()));
                return user;
            }
            return null;
        }catch (Exception e){
            throw new SystemException(Contant.QUERY_USER_ERROR_CODE,"查询用户信息出错",e);
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }
}
