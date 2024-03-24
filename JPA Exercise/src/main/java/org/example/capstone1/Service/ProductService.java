package org.example.capstone1.Service;


import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Product;
import org.example.capstone1.Repository.CategoryRepository;
import org.example.capstone1.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Boolean addProducts(Product product) {
        if (categoryRepository.existsById(product.getCategoryID())){
                productRepository.save(product);
                return true;
            }
        return false;
    }


    public Boolean updateProducts(Integer id, Product product) {
        Product product1=productRepository.getById(id);
        if (product1==null){
            return false;
        }
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setCategoryID(product.getCategoryID());
        productRepository.save(product1);
        return true;
    }

    public Boolean deleteProducts(Integer id) {
        Product product1=productRepository.getById(id);
        if (product1==null){
            return false;
        }
        productRepository.delete(product1);
        return true;
    }


}
