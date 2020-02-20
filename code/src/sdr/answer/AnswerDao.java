package sdr.answer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.AnswerMapper;
import sdr.vo.AnswerVO;

@Repository("answerdao")
public class AnswerDao implements Dao<String, AnswerVO> {
	
	@Autowired
	AnswerMapper mp;

	@Override
	public void insert(AnswerVO v) throws Exception {
		mp.insert(v);
		
	}

	@Override
	public void delete(String k) throws Exception {
		mp.delete(k);
	}

	@Override
	public void update(AnswerVO v) throws Exception {
		mp.update(v);
	}

	@Override
	public AnswerVO select(String k) throws Exception {
		return mp.select(k);
	}

	@Override
	public AnswerVO selectnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> selectBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> select() throws Exception {
		// TODO Auto-generated method stub
		return mp.selectall();
	}

	@Override
	public ArrayList<AnswerVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> selectAll(String k) throws Exception {
		return null;
	}

	@Override
	public void insertCart(AnswerVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<AnswerVO> selectAllCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(AnswerVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countCart(AnswerVO v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(AnswerVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnswerVO selectCart(AnswerVO v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<AnswerVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<AnswerVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
