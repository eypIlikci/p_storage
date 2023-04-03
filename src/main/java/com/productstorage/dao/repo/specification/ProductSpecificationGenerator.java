package com.productstorage.dao.repo.specification;

import com.productstorage.model.dto.request.ProductFilterRequest;
import com.productstorage.model.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationGenerator {
    public static Specification<Product> filter(ProductFilterRequest filter){
        return ((root, query, cb) -> {
            List<Predicate> predicates=new ArrayList<>();
            if (filter.getCategoryId()!=null)
                predicates.add(cb.equal(root.join("category").get("id"),filter.getCategoryId()));
            if(filter.getStorageId()!=null)
                predicates.add(cb.equal(root.join("storage").get("id"),filter.getCategoryId()));
            if (filter.getStorageState()!=null)
                predicates.add(cb.equal(root.join("storage").get("state"),filter.getStorageState()));
            if (filter.getStorageCity()!=null)
                predicates.add(cb.equal(root.join("storage").get("city"),filter.getStorageCity()));
            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }
}
