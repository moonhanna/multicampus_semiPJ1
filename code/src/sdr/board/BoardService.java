package sdr.board;

import java.util.ArrayList;

import javax.annotation.Resource;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.BoardVO;

@org.springframework.stereotype.Service("boardservice")
public class BoardService implements Service<String, BoardVO> {

	@Resource(name = "boarddao")
	Dao<String, BoardVO> dao;

	
	@Override
	public void register(BoardVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(BoardVO v) throws Exception {
		dao.update(v);

	}

	@Override
	public BoardVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<BoardVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public ArrayList<BoardVO> getBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> getAll(String k) throws Exception {
		return dao.selectAll(k);
	}

	@Override
	public ArrayList<BoardVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectQA(k);
	}

	@Override
	public ArrayList<BoardVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectRV(k);
	}

	@Override
	public void removeBoard(int boardno) {
		dao.deleteBoard(boardno);
	}

	@Override
	public void insertCart(BoardVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BoardVO> selectAllCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(BoardVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countCart(BoardVO v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(BoardVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO selectCart(BoardVO v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
