package frank.servlet;

import frank.dao.ArticleDAO;
import frank.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/14 9:40
 */
@WebServlet("/articleDetail")
public class ArticleDetailServlet extends BaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer id=Integer.parseInt(req.getParameter("id"));
        Article article= ArticleDAO.queryArticleId(id);
        return article;
    }
}
