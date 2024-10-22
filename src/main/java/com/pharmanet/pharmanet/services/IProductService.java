package com.pharmanet.pharmanet.services;


import com.pharmanet.pharmanet.presentation.dto.ProductDto;

import java.util.List;

public interface IProductService {
    ProductDto addProduct(ProductDto productDto);
    String deleteProduct(Long id);
    List<ProductDto> findAll();
    ProductDto updateProduct(Long id, ProductDto productDto);

}
