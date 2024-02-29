package devmaster.edu.vn.dao;

import java.util.List;

import devmaster.edu.vn.entity.Product;

public interface ProductDAO{
	public List <Product> getAllProduct();
	public Product getProductById(String id);
	public boolean insertProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deletProduct(String id);
}