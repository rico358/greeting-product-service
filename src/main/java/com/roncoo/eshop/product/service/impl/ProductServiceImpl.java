package com.roncoo.eshop.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.eshop.product.amqp.RabbitMQSender;
import com.roncoo.eshop.product.mapper.ProductMapper;
import com.roncoo.eshop.product.model.Product;
import com.roncoo.eshop.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private RabbitMQSender rabbitsender;

	@Override
	public void add(Product product, String operationType) {
		productMapper.add(product);
		rabbitsender.send(operationType,
				"{\"event_type\": \"add\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");
	}

	@Override
	public void update(Product product, String operationType) {
		productMapper.update(product);
		rabbitsender.send(operationType,
				"{\"event_type\": \"update\", \"data_type\": \"product\", \"id\": " + product.getId() + "}");

	}

	@Override
	public void delete(Long id, String operationType) {
		productMapper.delete(id);
		rabbitsender.send(operationType,
				"{\"event_type\": \"delete\", \"data_type\": \"product\", \"id\": " + id + "}");
	}

	@Override
	public Product findById(Long id) {
		return productMapper.findById(id);
	}

	@Override
	public List<Product> findByIds(String ids) {
		return productMapper.findByIds(ids);
	}

}
