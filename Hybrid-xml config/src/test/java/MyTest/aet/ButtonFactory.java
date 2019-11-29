package utils;

import javax.swing.JButton;

public class ButtonFactory {
	public static JButton createButton(String text) {
		JButton button = new JButton(text);
		button.setContentAreaFilled(false);
		// set any other property ...
		return button;

	}
}
