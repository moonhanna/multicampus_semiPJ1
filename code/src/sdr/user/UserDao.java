package sdr.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.UserMapper;
import sdr.vo.UserVO;
@Repository("userdao")
public class UserDao implements Dao<String, UserVO> {

	@Autowired//udao
	UserMapper um;
	
	@Override
	public void insert(UserVO v) throws Exception {
		um.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		um.delete(k);
	}

	@Override
	public void update(UserVO v) throws Exception {
		um.update(v);		
	}

	@Override
	public UserVO select(String k) throws Exception {
		return um.select(k);
	}

	@Override
	public ArrayList<UserVO> select() throws Exception {
		return um.selectall();
	}

	@Override
	public ArrayList<UserVO> selectBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> selectAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCart(UserVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(UserVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int countCart(UserVO v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(UserVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UserVO> selectAllCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO selectCart(UserVO v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO selectnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
