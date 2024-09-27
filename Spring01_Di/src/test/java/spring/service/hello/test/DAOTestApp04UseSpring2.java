package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;
import spring.service.hello.Hello;

public class DAOTestApp04UseSpring2 {

	/// main method
	public static void main(String[] args) {
		
		//1. 주문서를 읽어서 빈을 생성 ((1) new MemberDAOImpl를 dao라는 이름으로 /(2) 저장)
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") );
		System.out.println("-------------------------------");
		
		
		//2. Container 로 부터 hello 의 name 을 갖는 instance return 받기  
		MemberDAO dao = (MemberDAO)factory.getBean("dao"); //부모 타입으로 캐스팅
		dao.register("홍종각", "종각");
		dao.delete("kosta");
	}
	
}//end of class