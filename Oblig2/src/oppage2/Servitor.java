package oppage2;

public class Servitor extends Thread{
	private final HamburgerBrett brett;
    private final String navn;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000 + (int) Math.random() * 5000);
                brett.hent(navn);
            }
        } catch (InterruptedException e) {
        }
    }
}
