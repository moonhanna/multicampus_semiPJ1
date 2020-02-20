package sdr.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.BoardMapper;
import sdr.vo.BoardVO;

@Repository("boarddao")
public class BoardDao implements Dao<String, BoardVO> {
	@Autowired
	BoardMapper bm;

	@Override
	public void insert(BoardVO v) throws Exception {
		bm.insert(v);

	}

	@Override
	public void delete(String k) throws Exception {
		bm.delete(k);
	}

	@Override
	public void update(BoardVO v) throws Exception {
		bm.update(v);
	}

	@Override
	public BoardVO select(String k) throws Exception {
		return bm.select(k);
	}

	@Override
	public ArrayList<BoardVO> selectBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> select() throws Exception {
		// TODO Auto-generated method stub
		return bm.selectall();
	}

	@Override
	public ArrayList<BoardVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BoardVO> selectAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return bm.selectAll(k);
	}
	@Override
	public ArrayList<BoardVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return bm.selectQA(k);
	}
	@Override
	public ArrayList<BoardVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return bm.selectRV(k);
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		bm.deleteBoard(boardno);
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
	public BoardVO selectnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
