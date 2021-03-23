package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//content.jsp->������ư->/deleteForm.do?num=2&pageNum=1 -> deletePro.jsp(deleteAritcle)
		int num=Integer.parseInt(request.getParameter("num"));//"3"=>3
		String pageNum=request.getParameter("pageNum");
		System.out.println("deleteForm.jsp�� num=>"+num+",pageNum=>"+pageNum);
		
		request.setAttribute("num", num);//������ �Խù� ��ȣ
		request.setAttribute("pageNum", pageNum);
		
		return "/deleteForm.jsp";
	}

}
