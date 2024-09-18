package oppage2;

public class Kokk extends Thread{
	private final HamburgerBrett brett;
    private final String navn;

    public Kokk(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000 + (int) Math.random() * 5000);
                brett.leggTil(navn);
            }
        } catch (InterruptedException e) {
        }
    }
}
