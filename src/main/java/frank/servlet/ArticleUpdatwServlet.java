package frank.servlet;

import frank.dao.ArticleDAO;
import frank.exceeption.BusinessException;
import frank.model.Article;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/14 10:15
 */

@WebServlet("/articleUpdate")
public class ArticleUpdatwServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Article article= JSONUtil.deserialize(req.getInputStream(),Article.class);
        if(!ArticleDAO.update(article)){
            throw  new BusinessException("aupdate001","修改文章失败");

        }
        return null;
    }
}
