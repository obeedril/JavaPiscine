import java.util.Scanner;

public class Program {
    static void printProgress(int count, long rating) {
        int tmp = 1;
        while (tmp < count) {
            long num = 0;
            if (count > 9 && tmp <= 9)
                System.out.print("Week  ");
            else
                System.out.print("Week ");
            System.out.print(tmp);
            System.out.print(" ");
            for (num = rating % 10; num > 0; num--)
                System.out.print("=");
            System.out.println(">");
            rating /= 10;
            tmp++;
        }
    }

    public static void main(String[] args) {
        long rating = 0;
        long num = 0;
        long min = 0;
        int count = 1;

        while (count <= 18) {
            Scanner s = new Scanner(System.in);
            String tmp = s.nextLine();
            if (tmp.equals("42"))
                break;
            else if (!tmp.equals("Week " + count)) {
                System.err.println("IllegalArgument!");
                System.exit(-1);
            } else {
                for (int i = 0; i < 5; i++) {
                    if (s.hasNextInt()) {
                        num = s.nextInt();
                        if (num < 1 || num > 9) {
                            System.err.println("IllegalArgument!");
                            System.exit(-1);
                        }
                        if (min == 0 || min > num) {
                            min = num;
                        }
                    } else {
                        System.err.println("IllegalArgument!");
                        System.exit(-1);
                    }
                }
                    for (int j = count - 1; j > 0; j--) {
                        min *= 10;
                    }
                    rating += min;
                    min = 0;
                    count++;
                }
            }
        printProgress(count, rating);
    }
}

