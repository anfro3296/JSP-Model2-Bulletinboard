package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysh.board.*;

// /updateForm.do
public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
			//1.content.jsp->글수정버튼 클릭->updateForm.jsp?num=3&pageNum=1
			int num=Integer.parseInt(request.getParameter("num"));//"3"=>3
			String pageNum=request.getParameter("pageNum");
			BoardDAO dbPro=new BoardDAO();
			//select * from board where num=?;
			BoardDTO article=dbPro.updateGetArticle(num);//조회수가 증가X
		
			//2.서버의 메모리에 저장
			request.setAttribute("pageNum", pageNum);//${pageNum}
			request.setAttribute("article", article);
		
			return "/updateForm.jsp";
	}

}
