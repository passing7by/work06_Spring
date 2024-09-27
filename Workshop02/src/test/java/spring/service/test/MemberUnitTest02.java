package spring.service.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MemberUnitTest02 {
	public static void main(String[] args) throws IOException {
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		System.out.println("---------SqlSession Creating---------");
		
		session.selectList("MemberMapper.findAllMember")
			   .forEach(c->System.out.println(c));
		
		session.commit();
		session.close();
	}
}