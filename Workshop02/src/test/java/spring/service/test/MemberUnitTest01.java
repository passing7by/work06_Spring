package spring.service.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MemberUnitTest01 {
	public static void main(String[] args) throws IOException {
		//사원 추가하는 로직을 호출
		//1. 폼으로부터 사원정보를 받아와야 하는데...받았다 치고
		MemberVO pvo = new MemberVO();
		
		pvo.setId("mybatis");
		pvo.setPassword("pass01");
		pvo.setName("Jinam");
		pvo.setAddress("seoul");
		
		//2. MyBatis 라이브러리 사용해서 작업을 진행
		/*
		 * 1. SqlMapConfig.xml을 먼저 읽어들임
		 * 2. SqlSessionFactory를 생성... 1. 을 입력
		 * 3. SqlSession 생성!!!!!!
		 * 4. SqlSession에 뭐리문을 실행하는 함수가 들어있음
		 * 
		 *    int insert() -->
		 *    		Connection --> PreparedStatement --> 바인딩 --> executeUpdate()
		 *    int delete()
		 *    int update()
		 *    int selectOne() : Object 로 리턴됨
		 *    int selectList() : List 로 리턴됨(ArrayList 아님)
		 */
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		System.out.println("---------SqlSession Creating---------");
		
		session.insert("MemberMapper.registerMember", pvo);
		
		System.out.println(pvo.getName()+" 님 등록 성공");
		
		session.commit();
		session.close();
	}
}