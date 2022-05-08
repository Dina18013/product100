package ru.netology.products.repository;

import ru.netology.products.domain.Product;

public class ProductRepository {

    Product[] products = new Product[0];

    public ProductRepository() {
    }

    public ProductRepository(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void add(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < length - 1; i++) {
            tmp[i] = products[i];
        }
        tmp[length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return getProducts();
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
