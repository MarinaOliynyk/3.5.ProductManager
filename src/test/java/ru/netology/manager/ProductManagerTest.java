package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(1, "Java. Полное руководство", 2670, "Шилдт Герберт");
    private Product second = new Book(2, "Программирование на Java для начинающих", 596, "Васильев Алексей Николаевич");
    private Product third = new Book(3, "Java. Руководство для начинающих", 1800, "Шилдт Герберт");
    private Product fourth = new Book(4, "Huawei. Лидерство", 714, "Huawei");
    private Product fifth = new Smartphone(5, "Apple iPhone XR 128Gb Red", 52990, "Apple");
    private Product sixth = new Smartphone(6, "Huawei P30Pro", 44897, "Huawei");
    private Product seventh = new Smartphone(7, "Apple iPhone 12 Pro Max 128Gb pacific blue", 91990, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
    }

    @Test
    public void searchBookByAuthor() {
        Product[] actual = manager.searchBy("Шилдт Герберт");
        Product[] expected = new Product[]{first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBookByName() {
        Product[] actual = manager.searchBy("Программирование на Java для начинающих");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{fifth, seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSmartphoneByName() {
        Product[] actual = manager.searchBy("Huawei P30Pro");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductByProducer() {
        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = new Product[]{fourth, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductNonList() {
        Product[] actual = manager.searchBy(null);
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}

