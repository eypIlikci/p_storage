package com.productstorage.dao.repo;

import com.productstorage.model.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StorageRepository extends JpaRepository<Storage,Long> {
    @Query("select case when count(s)>0 then true else false end  from Storage s where s.name= :name")
    public Boolean isByName(@Param("name") String name);
}
