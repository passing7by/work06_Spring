package spring.service.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	
	//의존 주입...SqlSession이 필요함...setter로 주입
	private SqlSession sqlSession;
	private static final String NS = "MemberMapper."; //. 여기서 찍어줌
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int registerMember(MemberVO memberVO) throws Exception{
		int result = sqlSession.insert(NS+"registerMember", memberVO);
//		sqlSession.commit(); //DML일 때는 반드시
		return result;
	}

	@Override
	public int deleteMember(String id) throws Exception{
		int result = sqlSession.delete(NS+"deleteMember", id);
//		sqlSession.commit(); //DML일 때는 반드시
		return result;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws Exception{
		int result = sqlSession.update(NS+"updateMember", memberVO);
//		sqlSession.commit(); //DML일 때는 반드시
		return result;
	}

	@Override
	public List<MemberVO> findMember(String id) throws Exception{
		List<MemberVO> list = sqlSession.selectList(NS+"findMember", id);
		return list;
	}

	@Override
	public List<MemberVO> findMember() throws Exception{
		List<MemberVO> list = sqlSession.selectList(NS+"findMember");
		return list;
	}

	@Override
	public boolean idExist(String id) {
		boolean flag = sqlSession.selectOne(NS+"idExist", id);
		return flag;
	}

}
