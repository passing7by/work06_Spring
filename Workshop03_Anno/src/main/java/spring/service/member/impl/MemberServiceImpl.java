package spring.service.member.impl;

import java.util.List;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;
import spring.service.member.MemberService;

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) throws Exception{
		this.memberDAO = memberDAO;
	}

	@Override
	public void registerMember(MemberVO memberVO) throws Exception{
		memberDAO.registerMember(memberVO);		
	}

	@Override
	public void updateMember(MemberVO memberVO) throws Exception{
		memberDAO.updateMember(memberVO);		
	}

	@Override
	public List<MemberVO> findMember(String id) throws Exception{
		return memberDAO.findMember(id);
	}

	@Override
	public List<MemberVO> findMember() throws Exception{
		return memberDAO.findMember();
	}

	@Override
	public boolean idExist(String id) throws Exception{
		return memberDAO.idExist(id);
	}

}
