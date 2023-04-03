package com.productstorage.dao.repo;

import com.productstorage.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("select case when count(c)>0 then true else false end  from Category c where c.name= :name")
    public Boolean isByName(@Param("name") String name);
}
