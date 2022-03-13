package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.*;

import util.Input;

public class Window extends JFrame implements Runnable {
	public static int DELAY = 12;
	
	public boolean isRunning;
	public Input input;

	private Graphics _displayGraphics;
	private Image _displayImage;

	TestPlayer player;

	public Window(int w, int h, String t) {
		setSize(w, h);
		setTitle(t);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);

		isRunning = true;
		input = new Input();
		addKeyListener(input);

		player = new TestPlayer(120, 120);
	}

	public void paint(Graphics g) {
		_displayImage = createImage(getWidth(), getHeight());
		_displayGraphics = _displayImage.getGraphics();
		render(_displayGraphics);
		g.drawImage(_displayImage, 0, 0, this);
	}

	public void run() {
		while (isRunning) {
			try {
				Thread.sleep(DELAY);
				update();
				repaint();
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(new Color(36, 36, 48));
		g.fillRect(0, 0, getWidth(), getHeight());
		player.render(g);
	}

	public void update() {
		if (input.get(VK_ESCAPE)) quit();
		player.update(this);
	}

	public void quit() {
		isRunning = false;
		dispose(); // muere praga
	}
}

class TestPlayer {
	int x, y, w, h, v;
	Color color;

	TestPlayer(int pos_x, int pos_y) {
		x = pos_x;
		y = pos_y;
		w = 96;
		h = 96;
		v = 6;
		color = new Color(251, 160, 192);
	}

	public void update(Window wn) {
		if (wn.input.get(VK_LEFT))  x -= v;
		if (wn.input.get(VK_RIGHT)) x += v;
		if (wn.input.get(VK_UP))    y -= v;
		if (wn.input.get(VK_DOWN))  y += v;
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, w, h);
	}
}
