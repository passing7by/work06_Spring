package spring.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spring.service.domain.MemberVO;


public class MyBatisMemberTestApp {
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		SqlSessionFactory factory = TestUtil.getFactory();
		session=factory.openSession();
		
		MemberVO memberVO = new MemberVO("user02", "pass02", "김지북", "서울");
		
		//1. registerMember(MemberVO)
		System.out.println(":: 1. registerMember(MemberVO)");
		session.insert("MemberMapper.registerMember", memberVO);
		session.commit();
		System.out.println("[등록 성공] : " + memberVO);
		
		memberVO.setName("김지남");
		//2. updateMember(MemberVO) - 해당 id를 가진 사람의 name을 수정
		System.out.println("\n:: 2. updateMember(MemberVO) - 해당 id를 가진 사람의 name을 수정");
		session.update("MemberMapper.updateMember", memberVO);
		session.commit();
		System.out.println("[수정 성공] : " + memberVO);
		
		//3. idExist(string)
		System.out.println("\n:: 3. idExist(string)");
		System.out.println("[id 입력] : " + memberVO.getId());
		boolean isExist1 = session.selectOne("MemberMapper.idExist", memberVO.getId());
		System.out.println("[id 존재 여부] : " + isExist1);
		
		System.out.println("\n:: 3. idExist(string)");
		System.out.println("[id 입력] : " + "user");
		boolean isExist2 = session.selectOne("MemberMapper.idExist", "user");
		System.out.println("[id 존재 여부] : " + isExist2);
		
		//4. deleteMember(Member.getId)
		System.out.println("\n:: 4. deleteMember(string(Member.getId))");
		System.out.println("[삭제할 id 입력] : " + memberVO.getId());
		session.delete("MemberMapper.deleteMember", memberVO.getId());
		session.commit();
		System.out.println("[삭제 성공]");	
		
		//5-1. findMember(string) - id로 검색
		System.out.println("\n:: 5-1. findMember(string) - id로 검색");
		List<MemberVO> listById = session.selectList("MemberMapper.findMember", "user");
		listById.forEach(m->System.out.println(m));
		
		//5-2. findMember() - 모든 Member 검색
		System.out.println("\n:: 5-2. findMember() - 모든 Member 검색");
		List<MemberVO> listAll = session.selectList("MemberMapper.findMember");
		listAll.forEach(m->System.out.println(m));
	} //main
} //MyBatisMemberTestApp



