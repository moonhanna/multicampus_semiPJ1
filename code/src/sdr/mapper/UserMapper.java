package sdr.mapper;

import java.util.ArrayList;

import sdr.vo.UserVO;

public interface UserMapper {
	public void insert(UserVO obj);
	public void delete(String obj);
	public void update(UserVO obj);
	public UserVO select(String obj);
	public ArrayList<UserVO> selectall();
}



