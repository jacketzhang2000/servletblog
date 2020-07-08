package frank.dao;

import frank.model.Article;
import frank.exceeption.SystemException;
import frank.util.Contant;
import frank.util.DBUtil;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.List;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/10 17:09
 */
public class ArticleDAO {
    public static boolean insert(Article article){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=DBUtil.getConnection();
            String sql="insert into article(title, content, user_id,create_time)"+
                    " values(?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getUserId());
            ps.setTimestamp(4,new Timestamp(new Date().getTime()));
            int num=ps.executeUpdate();
            return num>=1;
        }catch (Exception e){
            throw new SystemException(Contant.INSERT_ARTICLAE_ERROR_CODE,"查询用户信息出错",e);
        }finally {
            DBUtil.close(connection,ps);
        }
    }

    public static List<Article> queryByUserId(Integer id) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        List<Article> articles=new ArrayList<>();

        try{
            connection=DBUtil.getConnection();
            String sql="select id,title,content,user_id,create_time"+
                    " from article where user_id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            resultSet=ps.executeQuery();
            while (resultSet.next()){
                Article article=new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()));
                articles.add(article);
            }
            return articles;
        }catch (Exception e){
            throw new SystemException("aquery001","查询文章列表出错",e);
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }

    public static Article queryArticleId(Integer id) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        try{
            connection=DBUtil.getConnection();
            String sql="select id,title,content,user_id,create_time"+
                    " from article where id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            resultSet=ps.executeQuery();
            Article article=new Article();
            while (resultSet.next()){
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()));
            }
            return article;
        }catch (Exception e){
            throw new SystemException("aquery002","查询文章详情出错",e);
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }

    public static boolean update(Article article) {
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=DBUtil.getConnection();
            String sql="update article set title=?, content=?"+
                    " where id=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getId());
            int num=ps.executeUpdate();
            return num>=1;
        }catch (Exception e){
            throw new SystemException("aupdate002","查询用户信息出错",e);
        }finally {
            DBUtil.close(connection,ps);
        }
    }

    public static boolean delete(int[] ids) {
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=DBUtil.getConnection();
            String sql="delete from article"+
                    " where id in(";
            for(int i=0;i<ids.length;i++){
                if(i==0){
                    sql+="?";
                }else {
                    sql+=",?";
                }
            }
            sql+=")";
           ps=connection.prepareStatement(sql);
            for(int i=0;i<ids.length;i++){
                ps.setInt(i+1,ids[i]);
            }
            int num=ps.executeUpdate();
            return num>=1;
        }catch (Exception e){
            throw new SystemException("adetele002","删除用户信息出错",e);
        }finally {
            DBUtil.close(connection,ps);
        }
    }
}
