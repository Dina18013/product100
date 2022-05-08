package ru.netology.products.repository;

import org.junit.jupiter.api.Test;
import ru.netology.products.domain.Book;
import ru.netology.products.domain.Product;
import ru.netology.products.domain.Smartphone;
import ru.netology.products.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void setRepositoryTwoProducts() {
        ProductRepository repository = new ProductRepository();
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product smartphone1 = new Smartphone(2, "iPhone", 50_000, "Apple");
        repository.setProducts(new Product[]{book1, smartphone1});

        Product[] expected = new Product[]{book1, smartphone1};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void setRepositoryOneProduct() {
        ProductRepository repository = new ProductRepository();
        Product book = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        repository.setProducts(new Product[]{book});

        Product[] expected = new Product[]{book};
        Product[] actual = repository.getProducts();

        assertArrayEquals(expected, actual);
    }
}