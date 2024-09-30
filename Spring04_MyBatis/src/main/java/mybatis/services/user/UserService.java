package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

//데이터 가공과 연관되는 레이어...remove는 이와 상관 없으므로 삭제...select는 서비스레이어와 직결됨
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
