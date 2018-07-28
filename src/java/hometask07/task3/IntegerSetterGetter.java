package hometask07.task3;

import java.util.Random;

public class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();
    private static int count;

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        synchronized (resource) {
            count++;
            System.out.println("Поток " + getName() + " хочет извлечь число.");
            number = resource.getELement();
            while (number == null) {
                System.out.println("Поток " + getName() + " ждет пока очередь заполнится.");
                if (count < 5) {
                    resource.wait();
                } else {
                    setIntegersIntoResource();
                }
                System.out.println("Поток " + getName() + " возобновил работу.");
                number = resource.getELement();
            }
            System.out.println("Поток " + getName() + " извлек число " + number);
            count--;
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);

        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}
