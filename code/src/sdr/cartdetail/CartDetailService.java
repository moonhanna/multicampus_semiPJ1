package sdr.cartdetail;

import java.util.ArrayList;

import javax.annotation.Resource;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.CartDetailVO;
import sdr.vo.UserorderVO;

@org.springframework.stereotype.Service("cartdetailService")
public class CartDetailService implements Service<String, CartDetailVO> {

	@Resource(name = "cartdetaildao")
	Dao<String, CartDetailVO> dao;

	@Override
	public void register(CartDetailVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(CartDetailVO v) throws Exception {
		dao.update(v);

	}

	@Override
	public CartDetailVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<CartDetailVO> getBrand(String k) throws Exception {
		return null;
	}

	// �옣諛붽뎄�땲 紐⑸줉?
	@Override
	public ArrayList<CartDetailVO> get() throws Exception {
		return dao.select();
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		return dao.sumMoneyCart(k);
	}

	@Override
	public int countCart(CartDetailVO v) throws Exception {
		return dao.countCart(v);

	}

	@Override
	public ArrayList<CartDetailVO> getProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> getSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> getRank() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> getAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll(k);
	}

	@Override
	public void insertCart(CartDetailVO v) throws Exception {
		dao.insertCart(v);
	}

	@Override
	public ArrayList<CartDetailVO> selectAllCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAllCart(k);
	}

	@Override
	public void modifyCart(CartDetailVO v) throws Exception {
		dao.modifyCart(v);

	}

	@Override
	public void deleteCart(String k) throws Exception {
		dao.deleteCart(k);

	}

	@Override
	public void updateCart(CartDetailVO v) throws Exception {
		dao.updateCart(v);

	}

	@Override
	public CartDetailVO selectCart(CartDetailVO v) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectCart(v);
	}

	@Override
	public ArrayList<CartDetailVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectCartById(k);
	}

	@Override
	public ArrayList<CartDetailVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartDetailVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBoard(int boardno) {
		// TODO Auto-generated method stub

	}

	@Override
	public CartDetailVO getnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
