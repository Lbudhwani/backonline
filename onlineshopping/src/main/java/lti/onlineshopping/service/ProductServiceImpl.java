package lti.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lti.onlineshopping.dao.ProductDaoImpl;
import lti.onlineshopping.dao.ProductDaoIntf;
import lti.onlineshopping.model.Category;
import lti.onlineshopping.model.Product;
import lti.onlineshopping.model.SubCategory;

@Service("productService")
public class ProductServiceImpl implements ProductServiceIntf {

	@Autowired
	ProductDaoIntf productDao;
	public boolean insertProduct(Product product) {
		System.out.println("Service is called");
		boolean flag=productDao.insertProduct(product);
		
		return flag;
	}

	public Category getCategory(String categoryname){
		System.out.println("Category service is called");
		Category c =productDao.getCategory(categoryname);
		return c;
	}

	public SubCategory getSubCategory(String scategoryname) {
		System.out.println("Category service is called");
		SubCategory s =productDao.getSubCategory(scategoryname);
		return s;
	}
	
	public List<Object[]> getUsers() {
		List<Object[]> list = productDao.getProducts();
		return list;
	}
	
	public List<Object[]> getmyUsers() {
		List<Object[]> list = new ProductDaoImpl().getProducts();
		return list;
	}
	public Product  fetchDetails(int prodid){
		Product product = productDao.fetchDetails(prodid);
		return product;
	}

}

