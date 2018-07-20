package hometask02.task6;

public class AtomicSubmarine {
    public boolean motion;

    class Engine {
        void start() {
            motion = true;
        }
    }

    public static void main(String[] args) {
        AtomicSubmarine as = new AtomicSubmarine();
        as.startEngine();
    }

    public void startEngine() {
        Engine engine = new Engine();
        engine.start();
        if (motion==true) System.out.println("The submarine is swimming.");

    }
}
