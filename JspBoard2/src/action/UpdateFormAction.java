package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysh.board.*;

// /updateForm.do
public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
			//1.content.jsp->�ۼ�����ư Ŭ��->updateForm.jsp?num=3&pageNum=1
			int num=Integer.parseInt(request.getParameter("num"));//"3"=>3
			String pageNum=request.getParameter("pageNum");
			BoardDAO dbPro=new BoardDAO();
			//select * from board where num=?;
			BoardDTO article=dbPro.updateGetArticle(num);//��ȸ���� ����X
		
			//2.������ �޸𸮿� ����
			request.setAttribute("pageNum", pageNum);//${pageNum}
			request.setAttribute("article", article);
		
			return "/updateForm.jsp";
	}

}
