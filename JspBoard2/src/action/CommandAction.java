package action;

//����� �ٸ����� ��û�� �޾Ƽ� ó�����ִ� �޼��带 �������� ����ϱ����ؼ� ����
import javax.servlet.http.*;//HttpServletRequest,HttpServletResponse

public interface CommandAction {

	//�̵��� �������� ��ο� ���������� �ʿ�=>��ȯ��(String)->������(ModelAndView)					//Exception ����->Thorwable
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable;
		
	
}
