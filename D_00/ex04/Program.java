import java.util.Scanner;

public class Program {

    static void printHistogram(char[] symbols, int[] countSym, int count) {
        int max = 0;

        for (int i = 0; i < count; i++) {
            if (max == 0 || countSym[i] > max) {
                max = countSym[i];
            }
        }
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < count; i++) {
                if (countSym[i] > countSym[i - 1]) {
                    int tmp = countSym[i];
                    char tmpChar = symbols[i];
                    countSym[i] = countSym[i - 1];
                    symbols[i] = symbols[i - 1];
                    countSym[i - 1] = tmp;
                    symbols[i - 1] = tmpChar;
                    needIteration = true;
                }
                if (countSym[i] == countSym[i - 1]) {
                    if (symbols[i] < symbols[i - 1]) {
                        char sym = symbols[i - 1];
                        symbols[i - 1] = symbols[i];
                        symbols[i] = sym;
                    }
                }
            }
        }
        char arr [][];
        arr = new char [12][10];
        int x = 0;
        int y = 0;
        if (count > 10)
            count = 10;
        for (x = 0; x < count; x++) {
            while (y - 1 < 10 - countSym[x] * 10 / max) {
                arr[y][x] = ' ';
                y++;
            }
            while (y < 11) {
                arr[y][x] = '#';

                y++;
            }
            arr[y][x] = symbols[x];
            y = 0;
        }

        for (x = 0; x < 12; x++) {
            for (y = 0; y < count; y++){
                if (arr[x][y] == ' ' && arr[x+1][y] != ' ') {
                    if (countSym[y] < 10){
                        System.out.print(' ');
                    }
                    System.out.print(countSym[y]);
                }
                else {
                    System.out.print(' ');
                    System.out.print((arr[x][y]));
                }
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int length = str.length();
        char[] result = str.toCharArray();
        char[] symbols;
        int[] countSym;
        int count = 0;
        symbols = new char[65535];
        countSym = new int[65535];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 65534; j++) {
                if (result[i] != 0 && symbols[j] == 0) {
                    symbols[j] = result[i];
                    countSym[j]++;
                    count++;
                    break;
                } else if (result[i] != 0 && result[i] == symbols[j]) {
                    countSym[j]++;
                    break;
                }
            }
        }
        printHistogram(symbols, countSym, count);
    }
}
