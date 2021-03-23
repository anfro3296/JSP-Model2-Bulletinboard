package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysh.board.*;

import java.util.*;//List

public class ListAction implements CommandAction {

	// /list.do로 요청이 들어왔을때 처리해주는 메서드
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum=request.getParameter("pageNum");
		//추가(검색분야,검색어)
		String search=request.getParameter("search");
		String searchtext=request.getParameter("searchtext");
		System.out.println("ListAction의 매개변수확인");
		System.out.println("pageNum=>"+pageNum+",search=>"+search+",searchtext=>"+searchtext);
		
		int count=0;//총레코드수
		List articleList=null;//화면에 출력할 레코드를 저장할 변수(=객체)
		  
		BoardDAO dbPro=new BoardDAO();
		count=dbPro.getArticleSearchCount(search, searchtext);//select count(*) from board
		System.out.println("현재 검색된 레코드수(count)=>"+count);
		
		//페이징처리의 결과를 저장할 객체선언
		Hashtable<String,Integer> pgList=dbPro.pageList(pageNum, count);
		  
		//최소 한개이상이라면
		if(count > 0){
			System.out.println(pgList.get("startRow")+pgList.get("endRow"));
			articleList=dbPro.getBoardArticles(pgList.get("startRow"), pgList.get("endRow"), search, searchtext);
		}else {//count=0이라면
			articleList=Collections.EMPTY_LIST;//아무것도 없는 빈 list객체를 반환
		  }
		 
		
		//2.처리한 결과를 서버메모리에 저장->이동할 페이지에 공유해서  사용할수 있도록 코딩
		//request.setAttribute("키명",저장할값)->request.getAttribute("키명)
			request.setAttribute("search", search);
			request.setAttribute("searchtext", searchtext);
			request.setAttribute("pgList", pgList);//페이징처리 10개의 정보
			request.setAttribute("articleList", articleList);
		//3.공유해서 이동할수 있도록 페이지를 지정
		return "/list.jsp";
	}

}
