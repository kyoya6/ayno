import game.Window;

public class Start {
	public static void main(String[] args) {
		new Thread(new Window(900, 540, "Odio Salim.")).start();
	}
}
