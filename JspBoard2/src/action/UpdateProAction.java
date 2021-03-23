package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysh.board.BoardDAO;
import ysh.board.BoardDTO;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			//�߰�
			String pageNum=request.getParameter("pageNum");//�����ҰԽù��� �������� �̵�
			BoardDTO article=new BoardDTO();
			
			article.setNum(Integer.parseInt(request.getParameter("num")));
			article.setWriter(request.getParameter("writer"));
			article.setEmail(request.getParameter("email"));
			article.setSubject(request.getParameter("subject"));
			article.setContent(request.getParameter("content"));
			article.setPasswd(request.getParameter("passwd"));
			
			BoardDAO dbPro=new BoardDAO();
			int check=dbPro.updateArticle(article);
			
			//2���� �������� �ʿ�
			request.setAttribute("pageNum",	pageNum);
			request.setAttribute("check", check);
			
		return "/updatePro.jsp";

	}

}
