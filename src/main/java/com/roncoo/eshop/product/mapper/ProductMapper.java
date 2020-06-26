package com.roncoo.eshop.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.roncoo.eshop.product.model.Product;

public interface ProductMapper {
    
	@Insert("INSERT INTO product(id,name,brand_id,category_id) VALUES(#{id},#{name},#{brandId},#{categoryId})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	void add(Product product);
	
	@Update("UPDATE product SET name=#{name},brand_id=#{brandId},category_id=#{categoryId} WHERE id= #{id} ")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	void update(Product product);
	
	@Delete("DELETE FROM product WHERE id=#{id}")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	void delete(long id);
	
	@Select("SELECT * FROM product WHERE id=#{id} ")
	Product findById(long id);
	
	@Select("SELECT * FROM product WHERE id in (${ids}) ")
	List<Product> findByIds(@Param("ids") String ids);
}
