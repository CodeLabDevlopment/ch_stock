package com.coffeehub.stock_ms.infrastructure.web.controller.v1;

import com.coffeehub.stock_ms.application.usecases.product.FindByProductIdCase;
import com.coffeehub.stock_ms.application.usecases.product.ListProductsCase;
import com.coffeehub.stock_ms.domain.model.Product;
import com.coffeehub.stock_ms.infrastructure.mapper.ProductMapper;
import com.coffeehub.stock_ms.infrastructure.web.response.v1.ProductDetails;
import com.coffeehub.stock_ms.infrastructure.web.response.v1.ProductResponseList;
import com.coffeehub.stock_ms.infrastructure.web.routes.ProductRoutesV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerV1 implements ProductRoutesV1 {

    private final FindByProductIdCase findProductByIdCase;
    private final ListProductsCase getProductsCase;

    @Override
    public ResponseEntity<List<ProductResponseList>> listProducts(String search) {
        List<Product> products = this.getProductsCase.execute(search);
        return ResponseEntity.ok().body(ProductMapper.toResponseList(products));
    }

    @Override
    public ResponseEntity<ProductDetails> getProductById(String productId) {
        Product product = this.findProductByIdCase.execute(productId);
        ProductDetails response = ProductMapper.toDetails(product);
        return ResponseEntity.ok().body(response);
    }

}
