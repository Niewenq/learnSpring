package org.ieening.controller;

import org.ieening.service.impl.ProductServiceImpl;

public class TestProductService {
    public static void main(String[] args) {
        ProductServiceImpl productServiceImpl = new ProductServiceImpl();
        productServiceImpl.getProductById();
    }
}
