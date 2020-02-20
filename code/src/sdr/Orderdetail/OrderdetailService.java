package sdr.Orderdetail;

import java.util.ArrayList;

import javax.annotation.Resource;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.OrderdetailVO;

@org.springframework.stereotype.Service("orderdetailservice")
public class OrderdetailService implements Service<String, OrderdetailVO> {
	
	@Resource(name="orderdetaildao")
	Dao<String, OrderdetailVO> dao;

	@Override
	public void register(OrderdetailVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(OrderdetailVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public OrderdetailVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<OrderdetailVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public ArrayList<OrderdetailVO> getBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderdetailVO getnew() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectnew();
	}

	@Override
	public void insertCart(OrderdetailVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OrderdetailVO> selectAllCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(OrderdetailVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countCart(OrderdetailVO v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(OrderdetailVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderdetailVO selectCart(OrderdetailVO v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<OrderdetailVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> getAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OrderdetailVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
