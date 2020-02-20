package sdr.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sdr.frame.Dao;
import sdr.mapper.ProductMapper;
import sdr.vo.ProductVO;

@Repository("productdao")
public class ProductDao implements Dao<String, ProductVO> {
	
	@Autowired
	ProductMapper pm;

	@Override
	public void insert(ProductVO v) throws Exception {
		pm.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		pm.delete(k);
	}

	@Override
	public void update(ProductVO v) throws Exception {
		pm.update(v);
	}

	@Override
	public ProductVO select(String k) throws Exception {
		return pm.select(k);
	}
	
	@Override
	public ArrayList<ProductVO> selectBrand(String k) throws Exception {
		return pm.selectBrand(k);
	}

	@Override
	public ArrayList<ProductVO> select() throws Exception {
		return pm.selectall();
	}

	@Override
	public ArrayList<ProductVO> selectRank() throws Exception {
		// TODO Auto-generated method stub
		return pm.selectRank();
	}

	@Override
	public ArrayList<ProductVO> selectProdname(String k) throws Exception {
		// TODO Auto-generated method stub
		return pm.selectProdname(k);
	}

	@Override
	public ArrayList<ProductVO> selectSpeccpu(String k) throws Exception {
		// TODO Auto-generated method stub
		return pm.selectSpeccpu(k);
	}

	@Override
	public ArrayList<ProductVO> selectAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCart(ProductVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(ProductVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int countCart(ProductVO v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(ProductVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ProductVO> selectAllCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductVO selectCart(ProductVO v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductVO> selectCartById(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductVO> selectQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductVO> selectRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductVO selectnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
