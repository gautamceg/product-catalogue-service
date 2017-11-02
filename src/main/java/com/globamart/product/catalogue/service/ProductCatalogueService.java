package com.globamart.product.catalogue.service;

import com.globamart.product.catalogue.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductCatalogueService {

	List<Product> getAllProduct();

	Product addProduct(Product product);

	List<Product> searchProduct(Map<String, String> allRequstParam);

	String deleteProduct(long id);

}