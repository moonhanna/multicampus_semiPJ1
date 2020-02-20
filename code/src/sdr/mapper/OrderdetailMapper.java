package sdr.mapper;

import java.util.ArrayList;

import sdr.vo.OrderdetailVO;

public interface OrderdetailMapper {
	
	public void insert(OrderdetailVO obj);
	public void delete(String obj);
	public void update(OrderdetailVO obj);
	public OrderdetailVO select(String obj);
	public OrderdetailVO selectnew();
	public ArrayList<OrderdetailVO> selectall();


}
