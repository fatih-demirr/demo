package com.example.demo.domain.product;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list = productService.getAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        Optional<Product> optionalProduct = productService.getProductById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return ResponseEntity.ok().body(product);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        Product product1 = productService.createProduct(product);
        return ResponseEntity.ok().body(product1);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        if(productService.deleteProduct(id)){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable String id,
            @RequestBody Product product
    ){
        Optional<Product> optionalProduct = productService.getProductById(id);
        if(optionalProduct.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Product product1 = productService.updateProduct(id, product);
        return ResponseEntity.ok().body(product1);
    }

}
