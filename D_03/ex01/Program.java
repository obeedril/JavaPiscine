package ex01;

public class Program {

    public static void main(String[] args) {
        
        if (args.length != 1 || !args[0].startsWith("--count="))
        {
            System.err.println("Wrong arguments");
            System.exit(-1);
        }
        int countThreads = Integer.parseInt(args[0].substring(8));

        Spor hen = new Spor(countThreads, "Hen");
        Spor egg = new Spor(countThreads, "Egg");

        egg.start();
        hen.start();

        try {
            egg.join();
            hen.join();
        } catch (InterruptedException excep){
            excep.printStackTrace();
        }

        }
    }
