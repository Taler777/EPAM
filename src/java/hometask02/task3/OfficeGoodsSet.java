package hometask02.task3;

public class OfficeGoodsSet {
    Pen pen;
    Pencil pencil;
    Stapler stapler;
    PaperPunch paperPunch;

    public OfficeGoodsSet(String penName, int penPrice,
                          String pencilName, int pencilPrice,
                          String staplerName, int staplerPrice,
                          String paperPunchName, int paperPunchPrice ) {
        pen = new Pen(penName, penPrice);
        pencil = new Pencil(pencilName, pencilPrice);
        stapler = new Stapler(staplerName, staplerPrice);
        paperPunch = new PaperPunch(paperPunchName, paperPunchPrice);
    }
}
