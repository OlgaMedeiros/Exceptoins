
package ru.netology;
public class Book extends Exceptions {          //book - дочерний класс ; Product - родительский класс
    private String name;
    private String author;

    public Book(String name, String author, int id, int price) {   // все поля для Book
        super(id, name, price);  // все общие поля для книги и смартфона
        this.author = author;    // поле только для класса Book
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}