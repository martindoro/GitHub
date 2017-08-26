package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

public class MouseComponent extends JPanel {
	private static final long serialVersionUID = 3099188957652043796L;

	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;

	public MouseComponent() {
		addMouseWheelListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String red = ("R " + getBackground().getRed());
		String green = ("G " + getBackground().getGreen());
		String blue = ("B " + getBackground().getBlue());
		g.drawString(red, 10, 50);
		g.drawString(green, 10, 70);
		g.drawString(blue, 10, 90);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseWheelMoved(MouseWheelEvent event) {
			int rotation = event.getWheelRotation();
			int red = getBackground().getRed();
			int green = getBackground().getGreen();
			int blue = (getBackground().getBlue() + rotation * 10);
			if (blue > 255) {
				blue = 255;
			}
			if (blue < 0) {
				blue = 0;
			}
			setBackground(new Color(red, green, blue));
			repaint();
		}

	}

	private class MouseMotionHandler extends MouseAdapter {

		@Override
		public void mouseMoved(MouseEvent event) {
			double x = (((double) event.getX() / (double) getWidth()) * 255);
			double y = (((double) event.getY() / (double) getHeight()) * 255);
			int blue = getBackground().getBlue();
			setBackground(new Color((int) x, (int) y, blue));
			repaint();
		}
	}
}
