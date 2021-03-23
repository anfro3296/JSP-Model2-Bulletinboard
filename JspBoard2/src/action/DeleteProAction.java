package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysh.board.*;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
			String pageNum=request.getParameter("pageNum");//BoardDTO의 멤버변수X
			int num=Integer.parseInt(request.getParameter("num"));
			String passwd=request.getParameter("passwd");
			System.out.println("deletePro.do의 num=>"+num+",passwd=>"+passwd);

			BoardDAO dbPro=new BoardDAO();
			int check=dbPro.deleteArticle(num,passwd);
			
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("check", check);
			
		return "/deletePro.jsp";
	}

}
