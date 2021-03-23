package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//추가
import ysh.board.*;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		// /content.do?num=2&pageNum=1
		//content.jsp에서 화면에 출력할 자바코드외의 나머지 코드
		 //list.jsp에서 링크->content.jsp?num=?&pageNum=?
			int num=Integer.parseInt(request.getParameter("num"));
		    String pageNum=request.getParameter("pageNum");
		    
		    BoardDAO dbPro=new BoardDAO();
		    BoardDTO article=dbPro.getArticle(num);//조회수증가,레코드
		    System.out.println("article=>"+article);
		    //링크문자열의 길이를 줄이기위해서 변수선언
		    int ref=article.getRef();
		    int re_step=article.getRe_step();
		    int re_level=article.getRe_level();
		    System.out.println("content.do의 매개변수 확인");
		    System.out.println("num=>"+num+",pageNum=>"+pageNum);
		    System.out.println("ref=>"+ref+",re_step=>"+re_step+",re_level=>"+re_level);
		    
		    //2.처리결과를 메모리에 저장
		    request.setAttribute("num", num);
		    request.setAttribute("pageNum", pageNum);
		    request.setAttribute("article", article);
		    //ref,re_step,re_level 전달X->article안에 포함이 되어있으니깐
		    
		return "/content.jsp";
	}

}
