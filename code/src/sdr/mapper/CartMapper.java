package sdr.mapper;

import java.util.ArrayList;

import sdr.vo.CartVO;

public interface CartMapper {
	public void insertCart(CartVO obj);
	public ArrayList<CartVO> selectAllCart(String obj);
	public int sumMoneyCart(String obj);
	public void modifyCart(CartVO obj);
	public void deleteCart(String obj);
	public int countCart(CartVO obj);
	public void updateCart(CartVO obj);
	public CartVO selectCart(CartVO obj);
	public ArrayList<CartVO> selectCartById(String obj);
}
