package sdr.mapper;

import java.util.ArrayList;

import sdr.vo.AnswerVO;

public interface AnswerMapper {
	public void insert(AnswerVO obj);

	public void delete(String obj);

	public void update(AnswerVO obj);
	
	public AnswerVO select(String k);

	public ArrayList<AnswerVO> selectall();
}
