package sdr.mapper;

import java.util.ArrayList;

import sdr.vo.CartDetailVO;



public interface CartDetailMapper {
 
	public void insert(CartDetailVO obj);
	public void delete(String obj);
	public void update(CartDetailVO v);
	public CartDetailVO select(String obj);
	public ArrayList<CartDetailVO> selectBrand(String obj);
	public ArrayList<CartDetailVO> selectall();
	public int sumMoneyCart(String obj);
	public int countCart(CartDetailVO obj);
	public void modifyCart(CartDetailVO obj);
	public void deleteCart(String obj);
	public void updateCart(CartDetailVO obj);
	public CartDetailVO selectCart(CartDetailVO obj);
	public ArrayList<CartDetailVO> selectCartById(String obj);
	public ArrayList<CartDetailVO> selectAllCart(String k);
	public void insertCart(CartDetailVO v);
	
	 
}
 