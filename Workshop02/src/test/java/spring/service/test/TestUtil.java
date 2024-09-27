package spring.service.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory까지만 받아오는 기능을 여기에 담는다
public class TestUtil {
	private static SqlSessionFactory factory = null;
	
	//생성자보다 먼저 진
	static {
		try {
			//1. 설정문서를 읽는다
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			//2. SqlSessionFactory 생성
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch (IOException e) {
			System.out.println(e);
		} //try-catch
	} //static

	public static SqlSessionFactory getFactory() {
		return factory;
	} //getFactory()
} //class (FactoryService)
