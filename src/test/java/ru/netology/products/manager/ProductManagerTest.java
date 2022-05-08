package ru.netology.products.manager;

import org.junit.jupiter.api.Test;
import ru.netology.products.domain.Book;
import ru.netology.products.domain.Product;
import ru.netology.products.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void add() {
        ProductManager manager = new ProductManager();
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product smartphone1 = new Smartphone(2, "iPhone", 50_000, "Apple");
        Product[] expected = new Product[]{book1, smartphone1};
        manager.add(book1);
        manager.add(smartphone1);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void addOneProduct() {
        ProductManager manager = new ProductManager();
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product[] expected = new Product[]{book1};
        manager.add(book1);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void addSomeProducts() {
        ProductManager manager = new ProductManager();
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product book2 = new Book(2, "JAVA2", 200, "Дмитрий Иванов");
        Product smartphone1 = new Smartphone(1, "iPhone", 50_000, "Apple");
        Product smartphone2 = new Smartphone(2, "iPhone", 100_000, "Apple");
        Product[] expected = new Product[]{book1, book2, smartphone1, smartphone2};
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void removeById() {
        ProductManager manager = new ProductManager();
        Product smartphone1 = new Smartphone(1, "iPhone", 50_000, "Apple");
        Product[] expected = new Product[0];
        manager.add(smartphone1);
        manager.removeById(1);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void removeByIdTwoProducts() {
        ProductManager manager = new ProductManager();
        Product smartphone1 = new Smartphone(1, "iPhone", 50_000, "Apple");
        Product smartphone2 = new Smartphone(2, "iPhone", 100_000, "Apple");
        Product[] expected = new Product[0];
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.removeById(1);
        manager.removeById(2);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void removeByIdDifferentProducts() {
        ProductManager manager = new ProductManager();
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product book2 = new Book(2, "JAVA2", 200, "Дмитрий Иванов");
        Product smartphone1 = new Smartphone(3, "iPhone", 50_000, "Apple");
        Product smartphone2 = new Smartphone(4, "iPhone", 100_000, "Apple");
        Product[] expected = new Product[]{smartphone2};

        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.removeById(1);
        manager.removeById(2);
        manager.removeById(3);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void searchByOneResult() {
        ProductManager manager = new ProductManager();
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product smartphone1 = new Smartphone(2, "iPhone", 50_000, "Apple");
        Product[] expected = new Product[]{book1};
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("JAVA1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTwoResults() {
        ProductManager manager = new ProductManager();
        Product book1 = new Book(1, "JAVA", 100, "Дмитрий Иванов");
        Product book2 = new Book(2, "JAVA", 200, "Дмитрий Иванов");
        Product[] expected = new Product[]{book1, book2};
        manager.add(book1);
        manager.add(book2);

        Product[] actual = manager.searchBy("JAVA");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNotResults() {
        ProductManager manager = new ProductManager();
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product book2 = new Book(2, "JAVA2", 200, "Дмитрий Иванов");
        Product[] expected = new Product[0];
        manager.add(book1);
        manager.add(book2);

        Product[] actual = manager.searchBy("JAVA3");
        assertArrayEquals(expected, actual);
    }
}