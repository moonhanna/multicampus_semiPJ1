package sdr.answer;

import java.util.ArrayList;

import javax.annotation.Resource;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.AnswerVO;

@org.springframework.stereotype.Service("answerservice")
public class AnswerService implements Service<String, AnswerVO> {
	
	@Resource(name = "answerdao")
	Dao<String, AnswerVO> dao;

	@Override
	public void register(AnswerVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(AnswerVO v) throws Exception {
		dao.update(v);;
	}

	@Override
	public AnswerVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public AnswerVO getnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> getBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public ArrayList<AnswerVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> getAll(String k) throws Exception {
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
	public ArrayList<AnswerVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AnswerVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<AnswerVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
