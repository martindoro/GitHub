package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JComponent;

public class MouseComponent extends JComponent {
	private static final long serialVersionUID = 3099188957652043796L;

	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;

	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		repaint();

	}
	public MouseComponent() {
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
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
			int blue = getBackground().getBlue() + rotation;
			if (blue > 255)
				blue = 255;
			if (blue < 0)
				blue = 0;
			setBackground(new Color(red, green, blue));
			repaint();
		}

	}

	private class MouseMotionHandler extends MouseAdapter {

		@Override
		public void mouseMoved(MouseEvent event) {
			int x = (event.getX() / getWidth()) * 255;
			int y = (event.getY() / getHeight()) * 255;
			int blue = getBackground().getBlue();
			setBackground(new Color(x, y, blue));
			repaint();
		}
	}
}
