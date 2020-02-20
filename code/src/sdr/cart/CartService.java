package sdr.cart;

import java.util.ArrayList;

import javax.annotation.Resource;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.CartVO;
import sdr.vo.ProductVO;

@org.springframework.stereotype.Service("cartservice")
public class CartService implements Service<String, CartVO>{

	
	@Resource(name="cartdao")
	Dao<String,CartVO> dao;

	@Override
	public void register(CartVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CartVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public CartVO get(String k) throws Exception {
		return null;
	}

	@Override
	public ArrayList<CartVO> getBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> get() throws Exception {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public ArrayList<CartVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 
	 * 
	 *  	public void insert(CartVO obj);
	public void update(CartVO obj);
	public void delete(String obj);
	public ArrayList<CartVO> selectall();
	/*

	*/
	/*
	@Override
	public void register(ProductVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ProductVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ProductVO get(String k) throws Exception {
		return dao.select(k);
	}
	@Override
	public ArrayList<ProductVO> getBrand(String k) throws Exception {
		return dao.selectBrand(k);
	}

	@Override
	public ArrayList<ProductVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public ArrayList<ProductVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectRank();
	}

	@Override
	public ArrayList<ProductVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectProdname(k);
	}

	@Override
	public ArrayList<ProductVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpeccpu(k);
	}

*/

	@Override
	public ArrayList<CartVO> getAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll(k);
	}

	
	
	
	@Override
	public void insertCart(CartVO v) throws Exception {
		dao.insertCart(v);
	}

	@Override
	public ArrayList<CartVO> selectAllCart(String k) throws Exception {
		return dao.selectAllCart(k);
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		return dao.sumMoneyCart(k);
	}

	@Override
	public void modifyCart(CartVO v) throws Exception {
		dao.modifyCart(v);
	}


	@Override
	public int countCart(CartVO v) throws Exception {
		return dao.countCart(v);
	}

	@Override
	public void updateCart(CartVO v) throws Exception {
		dao.updateCart(v);
	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteCart(k);
		
	}

	@Override
	public CartVO selectCart(CartVO v) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectCart(v);
	}

	@Override
	public ArrayList<CartVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectCartById(k);
	}

	@Override
	public ArrayList<CartVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartVO getnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
