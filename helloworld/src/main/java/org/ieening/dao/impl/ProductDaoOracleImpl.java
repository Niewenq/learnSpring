package org.ieening.dao.impl;

import org.ieening.dao.ProductDao;
import org.ieening.entity.Product;

public class ProductDaoOracleImpl implements ProductDao {

    @Override
    public Product selectProductById() {
        System.out.println("search Product in oracle database");
        return new Product();
    }
}
