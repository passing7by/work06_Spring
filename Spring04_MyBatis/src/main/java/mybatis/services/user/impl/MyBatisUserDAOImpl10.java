package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

public class MyBatisUserDAOImpl10 implements UserDAO{
	
	//의존 주입...SqlSession이 필요함...setter로 주입
	private SqlSession sqlSession;
	private static final String NS = "UserMapper10."; //. 여기서 찍어줌
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(NS+"addUser", user);
		sqlSession.commit(); //DML일 때는 반드시
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete(NS+"removeUser", userId);
		sqlSession.commit(); //DML일 때는 반드시
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update(NS+"updateUser", user);
		sqlSession.commit(); //DML일 때는 반드시
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = sqlSession.selectOne(NS+"getUser", userId);
		return user;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> list = sqlSession.selectList(NS+"getUserList", user);
		return list;
	}

}
