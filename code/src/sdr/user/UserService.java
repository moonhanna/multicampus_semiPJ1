package sdr.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.UserVO;
@org.springframework.stereotype.Service("userservice")
public class UserService implements Service<String, UserVO> {

	@Resource(name="userdao")
	Dao<String,UserVO> dao;
	
	@Override
	public void register(UserVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public void modify(UserVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public UserVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<UserVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public ArrayList<UserVO> getBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> getAll(String k) throws Exception {
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
	public void deleteCart(String k) throws Exception {
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
	public ArrayList<UserVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO getnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
