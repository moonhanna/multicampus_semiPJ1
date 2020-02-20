package sdr.Orderdetail;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.OrderdetailMapper;
import sdr.vo.OrderdetailVO;

@Repository("orderdetaildao")
public class OrderdetailDao implements Dao<String, OrderdetailVO> {

	@Autowired
	OrderdetailMapper pm;
	
	@Override
	public void insert(OrderdetailVO v) throws Exception {
		pm.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		pm.delete(k);
	}

	@Override
	public void update(OrderdetailVO v) throws Exception {
		pm.update(v);
	}

	@Override
	public OrderdetailVO select(String k) throws Exception {
		return pm.select(k);
	}

	@Override
	public ArrayList<OrderdetailVO> select() throws Exception {
		return pm.selectall();
	}

	@Override
	public ArrayList<OrderdetailVO> selectBrand(String k) throws Exception {
		return null;
	}

	@Override
	public OrderdetailVO selectnew() throws Exception {
		// TODO Auto-generated method stub
		return pm.selectnew();
	}

	@Override
	public ArrayList<OrderdetailVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> selectAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	public ArrayList<OrderdetailVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderdetailVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OrderdetailVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
