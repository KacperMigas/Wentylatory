import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Urzadzenie urzadzenie1 = new Urzadzenie(25, 70);
        urzadzenie1.symulujPrace(8 * 60 * 60);

        Random rand = new Random();
        Urzadzenie urzadzenie2=new Urzadzenie(rand.nextInt(56) - 10
                ,rand.nextInt(81) + 10);
        urzadzenie2.symulujPrace(rand.nextInt(3) * 8 * 60 * 60);
    }
}