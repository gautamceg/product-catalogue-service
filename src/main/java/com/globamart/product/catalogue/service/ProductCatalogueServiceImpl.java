package com.globamart.product.catalogue.service;

import com.globamart.product.catalogue.constants.ProductCataogue;
import com.globamart.product.catalogue.entity.Product;
import com.globamart.product.catalogue.repository.ProductCatalogueRepository;
import com.globamart.product.catalogue.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Service
public class ProductCatalogueServiceImpl implements ProductCatalogueService {
	
	
	@Autowired
	ProductCatalogueRepository productCatalogueRepository;
	
	@Autowired
	Validation validation;

	
	@Override
	public List<Product> getAllProduct() {
		return productCatalogueRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		if(product !=null)
			return productCatalogueRepository.save(product);
		return new Product();
	}

	@Override
	public List<Product> searchProduct(Map<String, String> allRequstParam) {
		if(!CollectionUtils.isEmpty(allRequstParam)){
			for(Entry<String, String> entry : allRequstParam.entrySet()){
				String param = entry.getKey();
				String val = entry.getValue();
				if(ProductCataogue.PRODUCT_TYPE.equalsIgnoreCase(param) && !StringUtils.isEmpty(val)){
					return productCatalogueRepository.findByProductType(val);
				}
			}
		}
		return null;
	}

	@Override
	public String deleteProduct(long id) {
		int result = productCatalogueRepository.deleteById(id);
		if(result != 0)
			return ProductCataogue.SUCCESS;
		return ProductCataogue.FAILED;
	}

}
