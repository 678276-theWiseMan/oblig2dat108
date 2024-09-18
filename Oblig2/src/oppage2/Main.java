package oppage2;

public class Main {
	
	public static void main(String[] args) {
		
        String[] kokker = {"Anne", "Erik", "Knut"};
        String[] servitorer = {"Mia", "Per"};
        int kapasitet = 4;

        System.out.println("Vi starter ...");

        HamburgerBrett brett = new HamburgerBrett(kapasitet);

        for (String navn : kokker) {
            new Kokk(brett, navn).start();
        }

        for (String navn : servitorer) {
            new Servitor(brett, navn).start();
        }
    }
}