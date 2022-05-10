package ru.netology.products.repository;

import org.junit.jupiter.api.Test;
import ru.netology.products.domain.Book;
import ru.netology.products.domain.Product;
import ru.netology.products.domain.Smartphone;
import ru.netology.products.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {

    @Test
    void removeByIdCorrect() {
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product smartphone1 = new Smartphone(2, "iPhone", 50_000, "Apple");

        Product[] expected = new Product[]{book1};
        ProductRepository repository = new ProductRepository();
        repository.add(book1);
        repository.add(smartphone1);
        repository.removeById(2);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void removeByIdWrong() {
        Product book1 = new Book(1, "JAVA1", 100, "Дмитрий Иванов");
        Product smartphone1 = new Smartphone(2, "iPhone", 50_000, "Apple");

        ProductRepository repository = new ProductRepository();
        repository.add(book1);
        repository.add(smartphone1);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(3);
        });
    }
}