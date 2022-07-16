package ex00;

public class Program {

    public static void main(String[] args) {

        if (args.length != 1 || !args[0].startsWith("--count="))
        {
            System.err.println("Wrong arguments");
            System.exit(-1);
        }
        int countThreads = Integer.parseInt(args[0].substring(8));

        Hen hen = new Hen(countThreads);
        Egg egg = new Egg(countThreads);

        egg.start();
        hen.start();

        try {
            egg.join();
            hen.join();
        } catch (InterruptedException excep){
            excep.printStackTrace();
        }

        for (int i = 0; i < countThreads; i++){
            System.out.println("Human");
        }
    }
}
