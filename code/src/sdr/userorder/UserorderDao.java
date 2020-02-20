package sdr.userorder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.UserorderMapper;
import sdr.vo.UserorderVO;

@Repository("userorderdao")
public class UserorderDao implements Dao<String, UserorderVO> {
	
	@Autowired
	UserorderMapper mp;

	@Override
	public void insert(UserorderVO v) throws Exception {
		mp.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		mp.delete(k);
	}

	@Override
	public void update(UserorderVO v) throws Exception {
		mp.update(v);
	}

	@Override
	public UserorderVO select(String k) throws Exception {
		return mp.select(k);
	}

	@Override
	public ArrayList<UserorderVO> select() throws Exception {
		return mp.selectall();
	}

	@Override
	public ArrayList<UserorderVO> selectBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserorderVO selectnew() throws Exception {
		return mp.selectnew();
	}

	@Override
	public ArrayList<UserorderVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> selectAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	public ArrayList<UserorderVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserorderVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UserorderVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
