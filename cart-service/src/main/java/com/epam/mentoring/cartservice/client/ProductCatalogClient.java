package com.epam.mentoring.cartservice.client;

import com.epam.mentoring.cartservice.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-catalog")
public interface ProductCatalogClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products/{productID}")
    Resource<Product> getProduct(@PathVariable("productID") Long productID);
}
