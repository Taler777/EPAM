package hometask02.task3;

/*
Задание 3. Наследование

Разработайте иерархию канцелярских товаров. Создайте “набор новичка”, используя созданную иерархию.

 */
public class MainOfficeGoods {
    public String penName = "Parker";
    private int penPrice = 10;
    private String pencilName = "Kooh-i-noor";
    private int pencilPrice = 5;
    private String staplerName = "Maped";
    private int staplerPrice = 15;
    private String paperPunchName = "Leiz";
    private int paperPunchPrice = 20;
    private OfficeGoodsSet officeGoodsSet;

    public static void main(String[] args) {
        MainOfficeGoods mainOfficeGoods = new MainOfficeGoods();
        mainOfficeGoods.makeOfficeGoodsSet();
    }

    public void makeOfficeGoodsSet() {
        officeGoodsSet = new OfficeGoodsSet(penName, penPrice, pencilName, pencilPrice,
                staplerName, staplerPrice, paperPunchName, paperPunchPrice);
    }
}
