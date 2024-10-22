package com.pharmanet.pharmanet.presentation.controllers;

import com.pharmanet.pharmanet.presentation.dto.ProductDto;
import com.pharmanet.pharmanet.services.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> updatedProduct(@PathVariable Long id,  @RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(productService.updateProduct(id, productDto), HttpStatus.OK);
    }
}
