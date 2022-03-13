package util;
import java.util.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.*;

// not d smartest idea is it?
public class Input extends KeyAdapter {
	private Hashtable<Integer, Boolean> key = new Hashtable<Integer, Boolean>();
	
	public Input() {
		super();

		for (int i = 0; i < 255; ++i)
			key.put(i, false);
	}

	public boolean get(Integer i) {
		return key.get(i);
	}

	public void keyPressed(KeyEvent e) {
		key.put(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		key.put(e.getKeyCode(), false);
	}
}