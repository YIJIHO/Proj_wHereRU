package kosa.hdit5spring.whereru.user.service;

import org.springframework.stereotype.Service;

import kosa.hdit5spring.whereru.user.mapper.UserMapper;
import kosa.hdit5spring.whereru.user.vo.UserVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper mapper;

	@Override
	public boolean registerUser(UserVO userVO) {
	    String userId = userVO.getUserId();
	    String existUserId = mapper.selectUserIdByUserId(userId);
		System.out.println("register[service]:" + userVO);
	    
	    if (existUserId != null) {
	        throw new IllegalArgumentException("�̹� �����ϴ� �̸����Դϴ�.");
	    }

	    int cnt = mapper.insertUserByUserVO(userVO);
	    return cnt == 1;
	}
}
