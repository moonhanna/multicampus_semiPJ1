package sdr.cartdetail;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.CartDetailMapper;
import sdr.vo.CartDetailVO;

@Repository("cartdetaildao")
public class CartDetailDao implements Dao<String, CartDetailVO> {

	@Autowired
	CartDetailMapper cdm;

	@Override
	public void insert(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public CartDetailVO select(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> selectBrand(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> select() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> selectAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCart(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub
		cdm.insertCart(v);
	}

	@Override
	public ArrayList<CartDetailVO> selectAllCart(String k) throws Exception {
		return cdm.selectAllCart(k);
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return cdm.sumMoneyCart(k);
	}

	@Override
	public void modifyCart(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub
		cdm.modifyCart(v);

	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		cdm.deleteCart(k);
	}

	@Override
	public int countCart(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub
		return cdm.countCart(v);
	}

	@Override
	public void updateCart(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub
		cdm.updateCart(v);

	}

	@Override
	public CartDetailVO selectCart(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub
		return cdm.selectCart(v);
	}

	@Override
	public ArrayList<CartDetailVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return cdm.selectCartById(k);
	}

	@Override
	public ArrayList<CartDetailVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartDetailVO selectnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
