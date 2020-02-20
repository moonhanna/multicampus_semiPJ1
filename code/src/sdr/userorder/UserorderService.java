package sdr.userorder;

import java.util.ArrayList;

import javax.annotation.Resource;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.UserorderVO;

@org.springframework.stereotype.Service("userorderservice")
public class UserorderService implements Service<String, UserorderVO> {

	@Resource(name="userorderdao")
	Dao<String, UserorderVO> dao;
	
	@Override
	public void register(UserorderVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(UserorderVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public UserorderVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<UserorderVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public ArrayList<UserorderVO> getBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserorderVO getnew() throws Exception {
		return dao.selectnew();
	}


	@Override
	public void insertCart(UserorderVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UserorderVO> selectAllCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(UserorderVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countCart(UserorderVO v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(UserorderVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserorderVO selectCart(UserorderVO v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<UserorderVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> getAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UserorderVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
