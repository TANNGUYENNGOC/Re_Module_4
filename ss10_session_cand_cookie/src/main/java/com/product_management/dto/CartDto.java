package com.product_management.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Long> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Long> productMap) {
        this.productMap = productMap;
    }


    public Map<ProductDto, Long> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Long> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) { //Kiểm tra sản phẩm tồn tại hay chưa
            // => Dựa vào id đã override equals & hashcode
            // update value + 1
            Long curentValue = productMap.get(productDto);
            productMap.replace(productDto,curentValue+1);
        }else {
            productMap.put(productDto,1L); //Lần đầu đc thêm vào
        }
    }
}
