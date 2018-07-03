package com.epam.mentoring.productcatalog.repository;

import com.epam.mentoring.productcatalog.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
