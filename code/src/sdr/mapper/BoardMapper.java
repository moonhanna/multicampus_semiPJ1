package sdr.mapper;

import java.util.ArrayList;

import sdr.vo.BoardVO;

public interface BoardMapper {
	public void insert(BoardVO obj);

	public void delete(String obj);
	
	public void deleteBoard(int boardno);

	public void update(BoardVO obj);
	
	public BoardVO select(String k);

	public ArrayList<BoardVO> selectAll(String obj);
	
	public ArrayList<BoardVO> selectQA(String obj);
	
	public ArrayList<BoardVO> selectRV(String obj);

	public ArrayList<BoardVO> selectall();
}
