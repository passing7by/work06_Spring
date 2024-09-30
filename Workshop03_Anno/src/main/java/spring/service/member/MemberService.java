package spring.service.member;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberService {
	void registerMember(MemberVO memberVO) throws Exception;
	void updateMember(MemberVO memberVO) throws Exception;
	List<MemberVO> findMember(String id) throws Exception;
	List<MemberVO> findMember() throws Exception;
	boolean idExist(String id) throws Exception;
}
