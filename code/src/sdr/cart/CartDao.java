package sdr.cart;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.CartMapper;
import sdr.vo.CartVO;

@Repository("cartdao")
public class CartDao implements Dao<String, CartVO>{
	
	@Autowired
	CartMapper cm;

	@Override
	public void insert(CartVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CartVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartVO select(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> selectBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> selectAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCart(CartVO v) throws Exception {
		// TODO Auto-generated method stub
		cm.insertCart(v);
	}

	@Override
	public ArrayList<CartVO> selectAllCart(String k ) throws Exception {
		// TODO Auto-generated method stub
		return cm.selectAllCart(k);
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return cm.sumMoneyCart(k);
	}

	@Override
	public void modifyCart(CartVO v) throws Exception {
		cm.modifyCart(v);
	}

	@Override
	public void deleteCart(String obj) throws Exception {
		// TODO Auto-generated method stub
		cm.deleteCart(obj);
	}

	@Override
	public int countCart(CartVO v) throws Exception {
		// TODO Auto-generated method stub
		return cm.countCart(v);
	}

	@Override
	public void updateCart(CartVO v) throws Exception {
		// TODO Auto-generated method stub
		cm.updateCart(v);
	}

	@Override
	public CartVO selectCart(CartVO v) throws Exception {
		// TODO Auto-generated method stub
		return cm.selectCart(v);
	}

	@Override
	public ArrayList<CartVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return cm.selectCartById(k);
	}

	@Override
	public ArrayList<CartVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartVO selectnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
