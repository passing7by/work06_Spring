package mybatis.services.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
import mybatis.services.user.UserService;

@Service
public class MyBatisUserServiceImpl13 implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	//@Autowired 했기 때문에 setter 삭제
	
	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = userDAO.getUser(userId);
		return user;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> list = userDAO.getUserList(user);
		return list;
	}

}
