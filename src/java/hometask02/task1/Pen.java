package hometask02.task1;

/*Разработайте спецификацию и создайте класс Ручка (Pen). Определите в этом классе
        методы equals(), hashCode() и toString().
*/

public class Pen {
    private String name;
    private String brand;
    private String type;
    private String inkColor;
    private int lenght;
    private int width;
    private int weight;
    private int price;

    public Pen(String name, String brand, String type, String inkColor, int lenght, int width, int weight) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.inkColor = inkColor;
        this.lenght = lenght;
        this.width = width;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int result;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + brand != null ? brand.hashCode() : 0;
        result = 31 * result + type != null ? type.hashCode() : 0;
        result = 31 * result + inkColor != null ? inkColor.hashCode() : 0;
        result = result + lenght + width + weight;
        return result;
    }

    @Override
    // without comparing of price - because it's depended on a lot
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return false;

        Pen pen = (Pen) obj;
        if (name != null ? !name.equals(pen.name) : pen.name != null) return false;
        if (brand != null ? !brand.equals(pen.brand) : pen.brand != null) return false;
        if (type != null ? !type.equals(pen.type) : pen.type != null) return false;
        if (inkColor != null ? !inkColor.equals(pen.inkColor) : pen.inkColor != null) return false;
        if (lenght != pen.lenght) return false;
        if (width != pen.width) return false;
        if (weight != pen.weight) return false;
        return true;
    }

    @Override
    public String toString() {
        return name + " " + brand + " " + type + " " + inkColor + " " + lenght + "mm " + width + "mm " + weight + "g";
    }
}
