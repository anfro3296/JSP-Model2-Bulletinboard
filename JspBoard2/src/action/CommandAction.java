package action;

//기능은 다르지만 요청을 받아서 처리해주는 메서드를 공통으로 사용하기위해서 선언
import javax.servlet.http.*;//HttpServletRequest,HttpServletResponse

public interface CommandAction {

	//이동할 페이지의 경로와 페이지명이 필요=>반환값(String)->스프링(ModelAndView)					//Exception 상위->Thorwable
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable;
		
	
}
