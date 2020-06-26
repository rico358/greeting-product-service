package com.roncoo.eshop.product.amqp;

public interface RabbitQueue {
	
	public static final String DATA_CHANGE_QUEUE = "data-change-queue";
	public static final String DIM_DATA_CHANGE_QUEUE = "dim-data-change-queue";
	public static final String FRESH_DATA_CHANGE_QUEUE = "fresh-data-change-queue";
	public static final String PRIORITY_DATA_CHANGE_QUEUE = "priority-data-change-queue";
}
