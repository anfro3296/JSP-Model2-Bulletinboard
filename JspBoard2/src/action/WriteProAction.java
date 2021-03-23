package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//글쓰기-> /writePro.do
import ysh.board.*;//BoardDTO,BoardDAO때문에 필요
import java.sql.Timestamp;//추가할 부분(시간)

public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//액션클래스=>jsp에서 호출하는 메서드(자바코드)
		   //한글처리
		request.setCharacterEncoding("utf-8");
		
		BoardDTO article=new BoardDTO();
		
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPasswd(request.getParameter("passwd"));
		
		//Timestamp temp=new Timestamp(System.currentTimeMillis());//컴퓨터의 날짜,시간
		article.setReg_date(new Timestamp(System.currentTimeMillis()));//오늘 날짜를 계산->대신에 주석달고 now()
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr());//원격 ip주소 저장
		 
		BoardDAO dbPro=new BoardDAO();
		dbPro.insertArticle(article);
	return "/writePro.jsp";
	}

}
