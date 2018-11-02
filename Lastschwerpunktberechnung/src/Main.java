import java.awt.EventQueue;

/**
 * 
 */

/**
 * @author Timo.Nordhorn
 *
 */
public class Main {
	private static Building test = null;
	
	public Main() {}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("CHECK");
		
	}	
	
	private static void greetz() {
		System.out.println("Test 1.");
		System.out.println("Test 2");
		System.out.println("Test 3");
	}
}
