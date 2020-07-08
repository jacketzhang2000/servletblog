package frank.servlet;

import frank.dao.ArticleDAO;
import frank.exceeption.BaseException;
import frank.exceeption.BusinessException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/14 10:36
 */
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends BaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] idStr=req.getParameter("ids").split(",");
        int[] ids=new int[idStr.length];
        for(int i=0;i<idStr.length;i++){
            ids[i]=Integer.parseInt(idStr[i]);

        }
        if(!ArticleDAO.delete(ids))
            throw  new BusinessException("adelete001","文章删除失败");

        return null;
    }
}
