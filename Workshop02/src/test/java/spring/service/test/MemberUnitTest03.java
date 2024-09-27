package spring.service.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MemberUnitTest03 {
	public static void main(String[] args) throws IOException {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		System.out.println("---------SqlSession Creating---------");
		
		//1. 파라미터로 string을 직접 주입
//		session.selectList("MemberMapper.getMember", "k")
//			   .forEach(c->System.out.println(c));
		
		//2. 파라미터로 memberVO를 주입한 뒤, mapping에서 getId로 값을 가져옴
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("k");
		session.selectList("MemberMapper.getMember", memberVO)
		   .forEach(c->System.out.println(c));

		
		session.commit();
		session.close();
	}
}