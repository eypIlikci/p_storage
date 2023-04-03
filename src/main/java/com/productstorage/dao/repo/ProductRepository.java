package com.productstorage.dao.repo;

import com.productstorage.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> {
    @Query("select case when count(p)>0 then true else false end  from Product p where p.name= :name")
    public Boolean isByName(@Param("name") String name);
    @Query("select case when count(p)>0 then true else false end  from Product p where p.name= :name and p.id <> :id")
    public Boolean isByNameAndId(@Param("name")String name,@Param("id")Long id);
}
