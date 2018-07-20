package hometask02.task2;

public class MainEmployee {
    public static void main(String[] args) {
        Employee employee1 = new Employee("employee1");
        Employee employee2 = new Employee("employee2", new Pen(10));
        Employee employee3 = new Employee("employee2", new Pen(10), new Pencil(5));
        Employee employee4 = new Employee("employee2", new Pen(10), new Pencil(5), new Stapler(15));
        Employee employee5 = new Employee("employee2", new Pen(10), new Pencil(5), new Stapler(15),
                new PaperPunch(20));

        System.out.println("Employee1's office goods cost " + employee1.getOfficeGoodsValue()+ " euro.");
        System.out.println("Employee2's office goods cost " + employee2.getOfficeGoodsValue()+ " euro.");
        System.out.println("Employee3's office goods cost " + employee3.getOfficeGoodsValue()+ " euro.");
        System.out.println("Employee4's office goods cost " + employee4.getOfficeGoodsValue()+ " euro.");
        System.out.println("Employee5's office goods cost " + employee5.getOfficeGoodsValue()+ " euro.");
    }
}
