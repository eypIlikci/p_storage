package com.productstorage.dao.repo;

import com.productstorage.model.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Long> {
    @Query("select h from History h where h.productId = :id")
    List<History> findByProductId(@Param("id")Long id);
}
