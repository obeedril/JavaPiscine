package ex01;

public class Spor extends Thread{
    private int count;
    private String name;
    private static String lock;

    public Spor(int count, String name){
        this.count = count;
        this.name =name;
    }

    @Override
    public void run(){
        for (int i = 0; i < count;) {
            synchronized (Spor.class) {
                if (name.equals(lock)) {
                    try {
                        Spor.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name);
                lock = name;
                Spor.class.notifyAll();
                i++;
            }
        }
    }
}
