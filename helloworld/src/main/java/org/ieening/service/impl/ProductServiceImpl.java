package org.ieening.service.impl;

import org.ieening.dao.ProductDao;
import org.ieening.dao.impl.ProductDaoMysqlImpl;
import org.ieening.dao.impl.ProductDaoOracleImpl;
import org.ieening.entity.Product;
import org.ieening.service.ProductService;

public class ProductServiceImpl implements ProductService {
    // ProductDao productDao = new ProductDaoMysqlImpl();
    ProductDao productDao = new ProductDaoOracleImpl();

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getProductById() {
        System.out.println("");
        return productDao.selectProductById();
    }

}
