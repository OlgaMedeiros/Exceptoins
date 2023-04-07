package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Repository repository = new Repository();
    ProductManager manager = new ProductManager(repository);

    Product book1 = new Book("1984", "Орвелл", 10, 100);
    Product book2 = new Book("Сила подсознания", " Диспенза", 11, 300);
    Product book3 = new Book("Девушка из Германии", "Корреа", 12, 500);
    Product smartphone1 = new ru.netology.Smartphone("Самсунг", 13, 1000, "Китай");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
    }

    @Test
    public void shouldSearchByName() {   // найти книгу по названию книги
        String name = "1984";

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("1984");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByAuthor() {   // найти книгу по имени автора
        String author = "Орвелл";

        Product[] expected = new Book[]{};
        Product[] actual = manager.searchBy("Орвелл");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFabricator() {   // найти книгу по производителю
        String fabricator = "Китай";

        Product[] expected = new Book[]{};
        Product[] actual = manager.searchBy("Китай");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNotExistProduct() {    //найти несуществующую книгу
        String notName = "Нет такой книги";
        Product[] expected = {};
        Product[] actual = manager.searchBy("Нет такой книги");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProduct() {   // найти продукт в поиске
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Сила подсознания");


        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldMatchesTrue() {  // соответствие продукта согласно запроса
        boolean expected = true;
        boolean actual = manager.matches(book1, "1984");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldMatchesFalse() {   //соответствие или нет продукта согласно запроса
        boolean expected = false;
        boolean actual = manager.matches(book1, "C");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setId() {   // проверка соответствия по Id
        Book book = new Book("Девушка из Германии", "Корреа", 12, 500);

        book.setId(12);

        int expected = 12;
        int actual = book.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setName() {    // проверка соответствия имени
        Book book = new Book("Девушка из Германии", "Корреа", 12, 500);

        book.setName("Девушка из Германии");

        String expected = "Девушка из Германии";
        String actual = book.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setSmartphoneName() {    // проверка соответствия названия телефона
        ru.netology.Smartphone smartphone = new ru.netology.Smartphone("Самсунг", 13, 1000, "Китай");

        smartphone.setName("Самсунг");

        String expected = "Самсунг";
        String actual = smartphone.getName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setSmartphoneFabricator() {    // проверка соответствия производителя
        ru.netology.Smartphone smartphone = new ru.netology.Smartphone("Самсунг", 13, 1000, "Китай");

        smartphone.setFabricator("Китай");

        String expected = "Китай";
        String actual = smartphone.getFabricator();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setPrice() {    // проверка соответствия цены
        Book book = new Book("Девушка из Германии", "Корреа", 12, 500);

        book.setPrice(500);

        int expected = 500;
        int actual = book.getPrice();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void setAuthor() {   // проверка соответствия автора
        Book book = new Book("Девушка из Германии", "Корреа", 12, 500);

        book.setAuthor("Корреа");

        String expected = "Корреа";
        String actual = book.getAuthor();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldSearchBook() {   // находится один товар

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("1984");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNotProduct() {  //  Отсутствие продукта
        Product[] expected = {};
        Product[] actual = manager.searchBy("нет продукта");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch2Product() {  //   поиск двух продуктов по букве
        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("и");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch1Product() {  //    поиск одного продукта по цифре
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("8");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProduct0() {  //  книга Пушкина не найдена
        Product[] expected = {};
        Product[] actual = manager.searchBy("Пушкин");

        Assertions.assertArrayEquals(expected, actual);
    }


}
