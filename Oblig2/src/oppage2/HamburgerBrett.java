package oppage2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
	
	private Queue<Hamburger> brett = new LinkedList<>();
    private int antall;
    private int neste = 1;

    
    public HamburgerBrett(int antall) {
        this.antall = antall;
    }

    
    public synchronized void leggTil(String kokk) {
        while (brett.size() == antall) {
            System.out.println(kokk + " (kokk) klar med hamburger, men brett fullt. Venter!");
	            try {
					wait();
				} catch (InterruptedException e) {
			}
    }	
        Hamburger hamburger = new Hamburger(neste++);
        brett.add(hamburger);
        System.out.println(kokk + " (kokk) legger på hamburger " + hamburger + ". Brett: " + brett);
        notifyAll();
    }

    
    public synchronized void hent(String servitor){
        while (brett.isEmpty()) {
            System.out.println(servitor + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!");
            try {
				wait();
			} catch (InterruptedException e) {
			}
        }
        Hamburger hamburger = brett.poll();
        System.out.println(servitor + " (servitør) tar av hamburger " + hamburger + ". Brett: " + brett);
        notifyAll();
    }
}
