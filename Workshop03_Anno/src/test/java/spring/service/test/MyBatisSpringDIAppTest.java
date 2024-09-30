package spring.service.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;
import spring.service.member.MemberService;

public class MyBatisSpringDIAppTest {
	public static void main(String[] args) throws Exception{

	ApplicationContext context =
		new ClassPathXmlApplicationContext(
							new String[] {	"/bean/memberservice.xml"	 }
								                                                    );
	
	MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
	MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
	
	MemberVO memberVO = new MemberVO("user02", "pass02", "김지북", "서울");

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//1.memberService.registerMember(MemberVO)
	System.out.println(":: 1. registerMember(MemberVO)");
	memberService.registerMember(memberVO);
	System.out.println("[등록 성공] : " + memberVO);
	
	System.out.println("\n///////////////////////////////////////////////////////////////////////////////////////");
	//2.memberService.updateMember(MemberVO) - 해당 id를 가진 사람의 name을 수정
	memberVO.setName("김지남");
	System.out.println(":: 2. updateMember(MemberVO) - 해당 id를 가진 사람의 name을 수정");
	memberService.updateMember(memberVO);
	System.out.println("[수정 성공] : " + memberVO);
	
	System.out.println("\n///////////////////////////////////////////////////////////////////////////////////////");
	//3.memberService.idExist(string)
	System.out.println("\n:: 3. idExist(string)");
	System.out.println("[id 입력] : " + memberVO.getId());
	boolean isExist1 = memberService.idExist(memberVO.getId());
	System.out.println("[id 존재 여부] : " + isExist1);
	
	System.out.println("\n:: 3. idExist(string)");
	System.out.println("[id 입력] : " + "user");
	boolean isExist2 = memberService.idExist("user");
	System.out.println("[id 존재 여부] : " + isExist2);
	
	System.out.println("\n///////////////////////////////////////////////////////////////////////////////////////");
	//4. memberDAO.deleteMember(Member.getId)
	System.out.println(":: 4. deleteMember(Member.getId)");
	System.out.println("[삭제할 id 입력] : " + memberVO.getId());
	memberDAO.deleteMember(memberVO.getId());
	System.out.println("[삭제 성공]");	

	System.out.println("\n///////////////////////////////////////////////////////////////////////////////////////");
	//5-1. memberService.findMember(string) - id로 검색
	System.out.println("\n:: 5-1. findMember(string) - id로 검색");
	List<MemberVO> listById = memberService.findMember("user");
	listById.forEach(m->System.out.println(m));
	
	//5-2. memberService.findMember() - 모든 Member 검색
	System.out.println("\n:: 5-2. findMember() - 모든 Member 검색");
	List<MemberVO> listAll = memberService.findMember();
	listAll.forEach(m->System.out.println(m));
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");	
	} //main
} //MyBatisSpringDIAppTest