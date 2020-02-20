package sdr.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Service<K,V> {
	
	@Transactional
	public void register(V v) throws Exception;
	@Transactional
	public void remove(K k) throws Exception;
	@Transactional
	public void modify(V v) throws Exception;
	
	public V get(K k) throws Exception;
	
	public ArrayList<V> getBrand(K k) throws Exception;

	public ArrayList<V> getProdname(K k) throws Exception;
	public ArrayList<V> getSpeccpu(K k) throws Exception;

	public ArrayList<V> get() throws Exception;
	
	public ArrayList<V> getRank() throws Exception;
	
	public ArrayList<V> getAll(K k) throws Exception;
	
	/*
	 * 
	 * 
	 * 카트에서 추가 된 것 
	 * 
	 * */
	
	public void insertCart(V v) throws Exception;
	public ArrayList<V> selectAllCart(K k) throws Exception;
	public int sumMoneyCart(K k) throws Exception;
	public void modifyCart(V v) throws Exception;
	public void deleteCart(K k) throws Exception;
	public int countCart(V v) throws Exception;
	public void updateCart(V v) throws Exception;
	public V selectCart(V v)throws Exception;
	public ArrayList<V> selectCartById(K k) throws Exception;

	////// board, productdetail 추가 한 service // 
	

	/// 민재거랑 동현이거 겹침  
	//public ArrayList<V> getAll(K k) throws Exception;
	
	public ArrayList<V> getQA(K k) throws Exception;
	
	public ArrayList<V> getRV(K k) throws Exception;
	
	public void removeBoard(int boardno);
	
	
	
	
	
	/////한나씨꺼
	
	
	public V getnew() throws Exception;
}



