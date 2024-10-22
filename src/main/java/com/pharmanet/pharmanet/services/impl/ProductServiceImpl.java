package com.pharmanet.pharmanet.services.impl;

import com.pharmanet.pharmanet.entity.Product;
import com.pharmanet.pharmanet.exception.ResourceNotFoundException;
import com.pharmanet.pharmanet.presentation.dto.ProductDto;
import com.pharmanet.pharmanet.repositories.IProductRepository;
import com.pharmanet.pharmanet.services.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product productSaved = productRepository.save(product);
        return modelMapper.map(productSaved, ProductDto.class);
    }

    @Override
    public String deleteProduct(Long id) {
       productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no existe"));
       productRepository.deleteById(id);
       return "Eliminado con exito";
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = (List<Product>) this.productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no existe"));

        product.setId(product.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setExpirationDate(productDto.getExpirationDate());
        product.setDescription(productDto.getDescription());

        Product productUpdate = productRepository.save(product);
        return modelMapper.map(productUpdate, ProductDto.class);

    }
}
