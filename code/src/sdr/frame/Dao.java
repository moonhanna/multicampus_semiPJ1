package sdr.frame;

import java.util.ArrayList;

import sdr.vo.CartVO;


public interface Dao<K, V> {
	
	
	//메인, 제품 카탈로그 페이지, 필터 , 관련 페이지 
	public void insert(V v) throws Exception;

	public void delete(K k) throws Exception;

	public void update(V v) throws Exception;

	public V select(K k) throws Exception;
	
	public ArrayList<V> selectBrand(K k) throws Exception;

	public ArrayList<V> selectProdname(K k) throws Exception;
	
	public ArrayList<V> selectSpeccpu(K k) throws Exception;
	
	public ArrayList<V> select() throws Exception;

	public ArrayList<V> selectRank() throws Exception;
	
	public ArrayList<V> selectAll(K k) throws Exception;
	
	
	
	
	///Cart 와 관련한 dao  
	public void insertCart(V v) throws Exception;
	public ArrayList<V> selectAllCart(K k) throws Exception;
	public int sumMoneyCart(K k) throws Exception;
	public void modifyCart(V v) throws Exception;
	public void deleteCart(K k) throws Exception;
	public int countCart(V v) throws Exception;
	public void updateCart(V v) throws Exception;
	
	public V selectCart(V v)throws Exception;
	public ArrayList<V> selectCartById(K k) throws Exception;
	
	
	/// Board와 관련한 dao
	
	
	//동현이 함수 민재거랑 겹침 
	//public ArrayList<V> selectAll(K k) throws Exception;
	
	public ArrayList<V> selectQA(K k) throws Exception;
	
	public ArrayList<V> selectRV(K k) throws Exception;

	public void deleteBoard(int boardno);
	
	
	//////////////////한나씨 꺼 
	
	public V selectnew() throws Exception;
	
	
	
}
