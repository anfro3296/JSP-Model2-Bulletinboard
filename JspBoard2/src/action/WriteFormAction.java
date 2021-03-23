package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /writeForm.do
public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.writeForm.jsp에서 작성한 자바코드 처리

	    //list.jsp(글쓰기)->신규글, content.jsp(글상세보기)->답변글쓰기
	    int num=0,ref=1,re_step=0,re_level=0;//writePro.jsp로 전달(insertArticle(article))
	    
	    //content.jsp에서 매개변수로 전달
	    if(request.getParameter("num")!=null){//0은 아니고 음수X=>양수
	    	num=Integer.parseInt(request.getParameter("num"));//"3"=>3
	    	ref=Integer.parseInt(request.getParameter("ref"));
	    	re_step=Integer.parseInt(request.getParameter("re_step"));
	    	re_level=Integer.parseInt(request.getParameter("re_level"));
	    	System.out.println("content.jsp에서 넘어온 매개변수 확인");
	    	System.out.println("num=>"+num+",ref=>"+ref);
	    	System.out.println("re_step=>"+re_step+",re_level=>"+re_level);
	    }
	 
		//2.처리결과->서버(request)에 저장
		request.setAttribute("num", num);//${num}
		request.setAttribute("ref", ref);//${ref}
		request.setAttribute("re_step", re_step);
		request.setAttribute("re_level", re_level);
		//3.페이지 이동->컨트롤러 클래스가 이동
		return "/writeForm.jsp";
	}

}
