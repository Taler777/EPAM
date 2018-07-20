package hometask02.task2;

/*
Напишите приложение, позволяющее вести учет канцелярских товаров на рабочем месте сотрудника.
Определите полную стоимость канцтоваров у определенного сотрудника
 */
public class Employee {
    private String name;
    private Pen pen;
    private Pencil pencil;
    private Stapler stapler;
    private PaperPunch paperPunch;
    private int value;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Pen pen) {
        this.name = name;
        this.pen = pen;
    }

    public Employee(String name, Pen pen, Pencil pencil) {
        this.name = name;
        this.pen = pen;
        this.pencil = pencil;
    }

    public Employee(String name, Pen pen, Pencil pencil, Stapler stapler) {
        this.name = name;
        this.pen = pen;
        this.pencil = pencil;
        this.stapler = stapler;
    }

    public Employee(String name, Pen pen, Pencil pencil, Stapler stapler, PaperPunch paperPunch) {
        this.name = name;
        this.pen = pen;
        this.pencil = pencil;
        this.stapler = stapler;
        this.paperPunch = paperPunch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public Pencil getPencil() {
        return pencil;
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }

    public Stapler getStapler() {
        return stapler;
    }

    public void setStapler(Stapler stapler) {
        this.stapler = stapler;
    }

    public PaperPunch getPaperPunch() {
        return paperPunch;
    }

    public void setPaperPunch(PaperPunch paperPunch) {
        this.paperPunch = paperPunch;
    }

    public int getOfficeGoodsValue() {
        if (pen != null) value += pen.getPrice();
        if (pencil != null) value += pencil.getPrice();
        if (stapler != null) value += stapler.getPrice();
        if (paperPunch != null) value += paperPunch.getPrice();
        return value;
    }
}