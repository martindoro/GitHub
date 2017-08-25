package app;

import javax.swing.JFrame;

public class MouseFrame extends JFrame {
	private static final long serialVersionUID = 816553955965065655L;

	public MouseFrame() {
		add(new MouseComponent());
		pack();
	}
}
