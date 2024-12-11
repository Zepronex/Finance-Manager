package main;

// Entry point of the finance manager 
// application

public class financeManager {
	public static void main(String args[]) {
		// Initialize the GUI on the Event Dispatch Thread
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				startApplicationGraphics gui = new startApplicationGraphics();
				gui.createAndShowGui(); // display gui after initializing components
			}

		});
	}

}
