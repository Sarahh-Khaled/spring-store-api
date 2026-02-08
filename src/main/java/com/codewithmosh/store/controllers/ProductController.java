package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.ProductDTO;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController // ده بيعرف سبرينج إن الكلاس ده هو اللي هيستقبل طلبات الـ API
@RequestMapping("/products") // ده المسار اللي هنطلبه في المتصفح
public class ProductController {

    private final ProductRepository productRepository;

    // بنعمل Inject للـ Repository عشان نقدر نكلم الداتا بيز
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @GetMapping // ده معناه إننا لما نعمل GET request يرجعلنا القائمة
//    public List<Product> getAllProducts() {
//
//        return productRepository.findAll();
//   هنعدل الكود ده بالdtos }

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(product -> {
                    ProductDTO dto = new ProductDTO();
                    dto.setId(product.getId());
                    dto.setName(product.getName());
                    dto.setPrice(product.getPrice());
                    dto.setCategoryId(product.getCategory().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

}