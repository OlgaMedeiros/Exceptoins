
package ru.netology;

public class Smartphone extends Product {    //  Smartphone - дочерний класс; Product - родительский класс
    private String fabricator;
    private String name;

    public Smartphone(String name, int id, int price, String fabricator) {   //все поля, относящиеся к Smartphone
        super(id, name, price);       // (super-обращение к родит.классу) указываем общие поля с книгой
        this.fabricator = fabricator;   // поле относящееся только к Smartphone
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String producer) {
        this.fabricator = fabricator;
    }
}
