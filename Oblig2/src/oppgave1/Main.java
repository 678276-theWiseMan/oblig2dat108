package oppgave1;

import javax.swing.JOptionPane;

public class Main {

	static boolean stop = false;
	static volatile String userInput = "";

    public static void main(String[] args) {

   
        Thread console = new Thread(() -> {
        	
            while (!stop) {
                System.out.println(userInput); 
                
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
            
        });
  
        Thread joptpane = new Thread(() -> {
            while (!stop) {
            	
                String input = JOptionPane.showInputDialog(null, "text:");
                
                if (input.equalsIgnoreCase("quit")) {
                    stop = true;
                } else {
                    userInput = input;
                }
            }
            
        });

        console.start();
        joptpane.start();
    }
}
