package sdr.mapper;

import java.util.ArrayList;

import sdr.vo.UserorderVO;

public interface UserorderMapper {
	
	public void insert(UserorderVO obj);
	public void delete(String obj);
	public void update(UserorderVO obj);
	public UserorderVO select(String obj);
	public UserorderVO selectnew();
	public ArrayList<UserorderVO> selectall();


}
