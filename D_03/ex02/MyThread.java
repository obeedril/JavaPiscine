package ex02;

public class MyThread extends Thread {
    private int size;
    private int first;
    private int sum = 0;

    public MyThread(int first, int size) {
        this.size = size;
        this.first = first;
    }

    @Override
    public synchronized void run() {
        int f = first;
        for (;  first < size; first++) {
            sum += Program.listInt.get(first);
            Program.Sumsum += Program.listInt.get(first);
        }
        System.out.println(getName() + ": " + "from " + f + " to " + (size - 1) + " sum is " + sum);
    }

}
