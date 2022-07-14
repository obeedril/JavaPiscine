import java.util.Scanner;

public class Program {
    static void primeNumber(int n) {
        int count = 1;
        int i = 2;
        while (i * i <= n && n % i != 0) {
            ++count;
            i++;
        }
        if ( i * i > n) {
            System.out.println("true " + count);
            return ;
        }
        System.out.println("false "+count);
        return;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter some integer:");
        int x = s.nextInt();
        if (x <= 1) {
            System.err.println("IllegalArgument!");
            System.exit(-1);
        }
        primeNumber(x);

    }
}

