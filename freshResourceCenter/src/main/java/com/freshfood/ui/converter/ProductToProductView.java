package com.freshfood.ui.converter;

import java.text.DecimalFormat;

import org.springframework.core.convert.converter.Converter;

import com.freshfood.Product;
import com.freshfood.ui.ProductView;

public class ProductToProductView implements Converter<Product, ProductView> {

	@Override
	public ProductView convert(Product source) {
		ProductView productView = new ProductView();
		productView.setName(source.getName());
		productView.setCategoryName(source.getCategoryName());
		if (source.getDescription() != null) {
			productView.setDescription(source.getDescription());
		}
		productView.setPrice(source.getPrice());
		productView.setQuantity(1);
		return productView;
	}
}
