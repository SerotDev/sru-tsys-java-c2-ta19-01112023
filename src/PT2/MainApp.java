package PT2;

public class MainApp {

	public static void main(String[] args) {
		//it tries to construct the window and show it
		try {
			Peliculas frame = new Peliculas();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
