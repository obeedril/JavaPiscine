package ex02;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    static ArrayList<Integer> listInt = new ArrayList<>();
    static int first = 0;
    static int last = 0;
    static int Sumsum = 0;
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Wrong number of arguments");
            System.exit(-1);
        }

        int sizeArr = Integer.valueOf(args[0].substring(12));
        if (sizeArr > 2000000 || sizeArr <= 0) {
            System.err.println("Wrong size of the array");
            System.exit(-1);
        }
        int amountThr = Integer.valueOf(args[1].substring(15));
        if (amountThr > sizeArr || amountThr < 1) {
            System.err.println("Wrong numbers of threads");
            System.exit(-1);
        }
        Calculator calculator = new Calculator(sizeArr, amountThr);
        calculator.countGaps();
        Thread[] threads = new Thread[amountThr];
        Random random = new Random();
        int newSize = 0;
        for (int i = 0; i < sizeArr; i++) {
            listInt.add(random.nextInt(1000));
            newSize += listInt.get(i);
        }
        System.out.println("Sum: " + newSize);

//        for (int i = 0; i < sizeArr; i++) {
//            System.out.println(listInt.get(i));
//        }

        for (int i = 0; i < amountThr; i++) {
            if (calculator.getTail() == 0)
            {
                threads[i] = new MyThread(first, first + calculator.getElementsGaps());
                first += calculator.getElementsGaps();
            }
            else {
                if (i == amountThr - 1) {
                    threads[i] = new MyThread(first, first + calculator.getElementsTail());
                }
//                int k = first + calculator.getElementsGaps();
//                if (k > sizeArr) {
//                    k = sizeArr;
//                }
                else {
                    threads[i] = new MyThread(first, first + calculator.getElementsGaps());
                    first += calculator.getElementsGaps();
                }
            }
            threads[i].start();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + Sumsum);


    }
}
