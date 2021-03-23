package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ysh.board.*;

import java.util.*;//List

public class ListAction implements CommandAction {

	// /list.do�� ��û�� �������� ó�����ִ� �޼���
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum=request.getParameter("pageNum");
		//�߰�(�˻��о�,�˻���)
		String search=request.getParameter("search");
		String searchtext=request.getParameter("searchtext");
		System.out.println("ListAction�� �Ű�����Ȯ��");
		System.out.println("pageNum=>"+pageNum+",search=>"+search+",searchtext=>"+searchtext);
		
		int count=0;//�ѷ��ڵ��
		List articleList=null;//ȭ�鿡 ����� ���ڵ带 ������ ����(=��ü)
		  
		BoardDAO dbPro=new BoardDAO();
		count=dbPro.getArticleSearchCount(search, searchtext);//select count(*) from board
		System.out.println("���� �˻��� ���ڵ��(count)=>"+count);
		
		//����¡ó���� ����� ������ ��ü����
		Hashtable<String,Integer> pgList=dbPro.pageList(pageNum, count);
		  
		//�ּ� �Ѱ��̻��̶��
		if(count > 0){
			System.out.println(pgList.get("startRow")+pgList.get("endRow"));
			articleList=dbPro.getBoardArticles(pgList.get("startRow"), pgList.get("endRow"), search, searchtext);
		}else {//count=0�̶��
			articleList=Collections.EMPTY_LIST;//�ƹ��͵� ���� �� list��ü�� ��ȯ
		  }
		 
		
		//2.ó���� ����� �����޸𸮿� ����->�̵��� �������� �����ؼ�  ����Ҽ� �ֵ��� �ڵ�
		//request.setAttribute("Ű��",�����Ұ�)->request.getAttribute("Ű��)
			request.setAttribute("search", search);
			request.setAttribute("searchtext", searchtext);
			request.setAttribute("pgList", pgList);//����¡ó�� 10���� ����
			request.setAttribute("articleList", articleList);
		//3.�����ؼ� �̵��Ҽ� �ֵ��� �������� ����
		return "/list.jsp";
	}

}
