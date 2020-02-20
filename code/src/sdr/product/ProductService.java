package sdr.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import sdr.frame.Dao;
import sdr.frame.Service;
import sdr.vo.ProductVO;

@org.springframework.stereotype.Service("productservice")
public class ProductService implements Service<String, ProductVO> {

	@Resource(name="productdao")
	Dao<String,ProductVO> dao;
	
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

	@Override
	public ArrayList<ProductVO> getAll(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCart(ProductVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sumMoneyCart(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCart(ProductVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCart(String k) throws Exception {
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
	public ArrayList<ProductVO> getQA(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductVO> getRV(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBoard(int boardno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductVO getnew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
