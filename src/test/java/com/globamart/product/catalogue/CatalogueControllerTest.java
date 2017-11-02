package com.globamart.product.catalogue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globamart.product.catalogue.controller.CatalogueController;
import com.globamart.product.catalogue.entity.Product;
import com.globamart.product.catalogue.service.ProductCatalogueService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Application.class)
public class CatalogueControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	ProductCatalogueService productCatalogueService;
	
	@MockBean
	CatalogueController target;
	
	
	List<Product> productList;
	
	Product p1;

	private Map<String, String> allRequstParam;
	
	ObjectMapper objectMapper;

	@Before
	public void setUp() throws Exception {
		p1 = new Product();
		p1.setId(1);
		p1.setName("some name");
		p1.setDescription("some description");
		p1.setProductType("some product type");
		p1.setQuantityPerUnit(1);
		p1.setUnitPrice(100);
		p1.setUnitsInStock(100);
		p1.setDiscontinued(false);
		
		productList = new ArrayList<>();
		productList.add(p1);
		
		
		allRequstParam = new HashMap<>();
		allRequstParam.put("productType","cosmetics");
		
		objectMapper = new ObjectMapper();
	}

	
	@Test
	public void testGetAllProduct() throws Exception{
		given(target.getAllProduct()).willReturn(productList);
		
		mockMvc.perform(get("/v1/product/all"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)));
	}
	
	@Test
	public void testSearchProductByType() throws Exception{
		given(target.searchProduct(allRequstParam)).willReturn(productList);
		
		mockMvc.perform(post("/v1/product").
				contentType(MediaType.APPLICATION_JSON)
				.param("productType", "cosmetics")
				.content(objectMapper.writeValueAsString(p1)))
		.andExpect(status().isOk());
	}
	

}
