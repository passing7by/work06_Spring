package spring.service.member;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	int registerMember(MemberVO memberVO) throws Exception;
	int deleteMember(String id) throws Exception;
	int updateMember(MemberVO memberVO) throws Exception;
	List<MemberVO> findMember(String id) throws Exception;
	List<MemberVO> findMember() throws Exception;
	boolean idExist(String id) throws Exception;
}
