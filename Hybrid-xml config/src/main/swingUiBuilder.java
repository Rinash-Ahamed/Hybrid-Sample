package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.testng.annotations.Test;
import test.*;

public class swingUiBuilder extends BrowserFactory{

	static JFrame f;
	//BrowserFactory bf = new BrowserFactory();

	@SuppressWarnings("resource")
	public swingUiBuilder() throws IOException {

		f = new JFrame("Automation Enabled");
		f.setIconImage(ImageIO.read(new File("./files/icon.png")));

		JLabel label = new JLabel("Please select your choice of execution:");
		label.setBounds(20, 30, 250, 20);
		f.add(label);

		JRadioButton r, r1;
		r = new JRadioButton("Single");
		r.setBounds(250, 30, 60, 20);
		r1 = new JRadioButton("Parallel");
		r1.setBounds(320, 30, 80, 20);
		f.add(r);
		f.add(r1);
		ButtonGroup radio = new ButtonGroup();
		radio.add(r);
		radio.add(r1);
		
		JButton b, b1, b3;
		b = new JButton("Quit");
		b.setBounds(470, 250, 80, 40);
		f.add(b);

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		b3 = new JButton("Stop");
		b3.setBounds(470, 200, 80, 40);
		f.add(b3);
		b3.setVisible(false);

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				driver().quit();
			}
		});

		b1 = new JButton("Execute");
		b1.setBounds(470, 300, 80, 40);
		f.add(b1);
		
		JTextArea classMethod = new JTextArea();
		classMethod.setBounds(340, 65, 230, 80);
		classMethod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		f.add(classMethod);
		classMethod.setVisible(false);

		JLabel singleLabel, parallelLabel, pLabelText, sLabelText;
		singleLabel = new JLabel("Please select browser for execution");
		singleLabel.setBounds(20, 70, 250, 20);
		f.add(singleLabel);
		singleLabel.setVisible(false);

		String s1[] = { "Select Browser", "Chrome", "Firefox", "IE", "Edge" };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox browsers = new JComboBox(s1);
		browsers.setBounds(20, 100, 130, 20);
		browsers.setToolTipText("Select any browser");
		f.add(browsers);
		browsers.setVisible(false);

		JLabel chrome, ff, edge, ie, console, c1Label, c2Label, c3Label, c4Label;
		chrome = new JLabel();
		chrome.setForeground(Color.RED);
		chrome.setBounds(170, 93, 150, 30);
		f.add(chrome);
		chrome.setVisible(false);
		ff = new JLabel();
		ff.setForeground(Color.RED);
		ff.setBounds(170, 93, 150, 30);
		f.add(ff);
		ff.setVisible(false);
		edge = new JLabel();
		edge.setForeground(Color.RED);
		edge.setBounds(170, 93, 150, 30);
		f.add(edge);
		edge.setVisible(false);
		ie = new JLabel();
		ie.setForeground(Color.RED);
		ie.setBounds(170, 93, 150, 30);
		f.add(ie);
		ie.setVisible(false);

		browsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b1.setEnabled(true);
				b3.setEnabled(true);
				
				classMethod.setVisible(true);
				
				if (browsers.getSelectedItem().equals("Chrome")) {
					ImageIcon chromeUrl = new ImageIcon("./files/chrome.png");
					chrome.setText(browsers.getSelectedItem() + " Selected");
					chrome.setIcon(chromeUrl);
					chrome.setVisible(true);
					ff.setVisible(false);
					ie.setVisible(false);
					edge.setVisible(false);
				} else if (browsers.getSelectedItem().equals("Firefox")) {
					ImageIcon ffUrl = new ImageIcon("./files/firefox.png");
					ff.setText(browsers.getSelectedItem() + " Selected");
					ff.setIcon(ffUrl);
					chrome.setVisible(false);
					ff.setVisible(true);
					ie.setVisible(false);
					edge.setVisible(false);
				} else if (browsers.getSelectedItem().equals("IE")) {
					ImageIcon ieUrl = new ImageIcon("./files/explorer.png");
					ie.setText(browsers.getSelectedItem() + " Selected");
					ie.setIcon(ieUrl);
					chrome.setVisible(false);
					ff.setVisible(false);
					ie.setVisible(true);
					edge.setVisible(false);
				} else if (browsers.getSelectedItem().equals("Edge")) {
					ImageIcon edgeUrl = new ImageIcon("./files/edge.png");
					edge.setText(browsers.getSelectedItem() + " Selected");
					edge.setIcon(edgeUrl);
					chrome.setVisible(false);
					ff.setVisible(false);
					ie.setVisible(false);
					edge.setVisible(true);
				}
			}
		});

		parallelLabel = new JLabel("Please make your browser selection");
		parallelLabel.setBounds(20, 70, 250, 20);
		f.add(parallelLabel);
		parallelLabel.setVisible(false);

		pLabelText = new JLabel("<html>" + "Parallel MODE selected for excution" + "</html>");
		pLabelText.setForeground(Color.RED);
		pLabelText.setBounds(400, 30, 200, 30);
		pLabelText.setVisible(false);
		f.add(pLabelText);

		sLabelText = new JLabel("<html>" + "Single MODE selected for" + "<br>" + " excution" + "</html>");
		sLabelText.setForeground(Color.RED);
		sLabelText.setBounds(400, 30, 200, 30);
		sLabelText.setVisible(false);
		f.add(sLabelText);

		JCheckBox c1, c2, c3, c4;
		c1 = new JCheckBox("Chrome");
		c1.setBounds(20, 100, 80, 20);
		f.add(c1);
		c1.setVisible(false);

		c1Label = new JLabel();
		c1Label.setBounds(320, 90, 80, 40);
		c1Label.setVisible(false);
		f.add(c1Label);

		c2 = new JCheckBox("Firefox");
		c2.setBounds(100, 100, 80, 20);
		f.add(c2);
		c2.setVisible(false);

		c2Label = new JLabel();
		c2Label.setBounds(350, 90, 80, 40);
		c2Label.setVisible(false);
		f.add(c2Label);

		c3 = new JCheckBox("IE");
		c3.setBounds(180, 100, 40, 20);
		f.add(c3);

		c3Label = new JLabel();
		c3Label.setBounds(380, 90, 80, 40);
		c3Label.setVisible(false);
		f.add(c3Label);

		c3.setVisible(false);
		c4 = new JCheckBox("Edge");
		c4.setBounds(240, 100, 80, 20);
		f.add(c4);
		c4.setVisible(false);

		c4Label = new JLabel();
		c4Label.setBounds(410, 90, 80, 40);
		c4Label.setVisible(false);
		f.add(c4Label);

		c1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ImageIcon chromeUrl = new ImageIcon("./files/chrome.png");
					c1Label.setIcon(chromeUrl);
					c1Label.setVisible(true);
					System.out.println(c1.getText() + " enabled");
				} else {
					c1Label.setVisible(false);
					System.out.println(c1.getText() + " disabled");
				}
				;
			}
		});

		c2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ImageIcon ffUrl = new ImageIcon("./files/firefox.png");
					c2Label.setIcon(ffUrl);
					c2Label.setVisible(true);
					System.out.println(c2.getText() + " enabled");
				} else {
					c2Label.setVisible(false);
					System.out.println(c2.getText() + " disabled");
				}
				;
			}
		});

		c3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ImageIcon ieUrl = new ImageIcon("./files/explorer.png");
					c3Label.setIcon(ieUrl);
					c3Label.setVisible(true);
					System.out.println(c3.getText() + " enabled");
				} else {
					c3Label.setVisible(false);
					System.out.println(c3.getText() + " disabled");
				}
				;
			}
		});

		c4.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ImageIcon edgeUrl = new ImageIcon("./files/edge.png");
					c4Label.setIcon(edgeUrl);
					c4Label.setVisible(true);
					System.out.println(c4.getText() + " enabled");
				} else {
					c4Label.setVisible(false);
					System.out.println(c4.getText() + " disabled");
				}
				;
			}
		});
		
		JButton consoleButton, listenerButton;
		consoleButton = new JButton("Console");
		consoleButton.setBackground(Color.BLACK);
		consoleButton.setForeground(Color.WHITE);
		consoleButton.setBounds(120,132,80,15);
		f.add(consoleButton);
		consoleButton.setVisible(false);
		
		listenerButton = new JButton("Listener");
		listenerButton.setBounds(205,132,100,15);
		listenerButton.setBackground(Color.BLACK);
		listenerButton.setForeground(Color.WHITE);
		f.add(listenerButton);
		listenerButton.setVisible(false);

		r.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
						
					b1.setEnabled(true);
					b3.setEnabled(true);
					
					parallelLabel.setVisible(false);
					singleLabel.setVisible(true);
					browsers.setVisible(true);
					sLabelText.setVisible(true);
					pLabelText.setVisible(false);

					// checkBox
					c1.setVisible(false);
					c1.setSelected(false);
					c1Label.setVisible(false);
					c2.setVisible(false);
					c2.setSelected(false);
					c2Label.setVisible(false);
					c3.setVisible(false);
					c3.setSelected(false);
					c3Label.setVisible(false);
					c4.setVisible(false);
					c4.setSelected(false);
					c4Label.setVisible(false);
					
					//console
					consoleButton.setVisible(true);
					listenerButton.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		r1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					singleLabel.setVisible(false);
					parallelLabel.setVisible(true);
					pLabelText.setVisible(true);
					sLabelText.setVisible(false);

					// ComboBox
					browsers.setVisible(false);
					browsers.setSelectedIndex(0);
					chrome.setVisible(false);
					ff.setVisible(false);
					ie.setVisible(false);
					edge.setVisible(false);

					// checkBox
					c1.setVisible(true);
					c2.setVisible(true);
					c3.setVisible(true);
					c4.setVisible(true);
					
					//console
					consoleButton.setVisible(false);
					listenerButton.setVisible(false);
					
					classMethod.setVisible(false);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				b3.setVisible(true);
				
				if(r.isSelected() == false) {
					System.out.println("Please select any Mode before proceeding...");
					b1.setEnabled(false);
					b3.setEnabled(false);
				}

				if (r.isSelected()) {
					try {
						String executingIn = browsers.getSelectedItem() + " up and running";
						if (browsers.getSelectedItem().equals("Select Browser")) {
							System.out.println("Please select any Browser before proceeding...");
							// b1.setBorderPainted( false );
							// b1.setFocusPainted( false );
							b1.setEnabled(false);
							b3.setEnabled(false);
						} else if (browsers.getSelectedItem().equals("Chrome")) {
							System.out.println(executingIn);
							setBrowser(browsers.getSelectedItem().toString());
							driver().get(readData("url"));
							waitUntil(username, 50, "visibility");
							sendKeys(username, readData("Username"));
							sendKeys(password, readData("Password"));
							click(loginBT);
							Thread.sleep(5000);
						} else if (browsers.getSelectedItem().equals("IE")) {
							System.out.println(executingIn);
							setBrowser(browsers.getSelectedItem().toString());
						} else if (browsers.getSelectedItem().equals("Firefox")) {
							System.out.println(executingIn);
							setBrowser(browsers.getSelectedItem().toString());
						} else if (browsers.getSelectedItem().equals("edge")) {
							System.out.println(executingIn);
							setBrowser(browsers.getSelectedItem().toString());
						}
					} catch (Exception e1) {
						System.out.println("Exception in Single MODE");
					}
				}

				if (r1.isSelected()) {
					try {
						if (c1.isSelected() == true) {
							System.out.println(c1.getText() + " is Executable...");
							setBrowser(c1.getText());
						} else {
							System.out.println(c1.getText() + " is not selected for execution");
						}
						if (c1.isSelected() == true) {
							System.out.println(c2.getText() + " is Executable...");
							setBrowser(c2.getText());
						} else {
							System.out.println(c2.getText() + " is not selected for execution");
						}
						if (c1.isSelected() == true) {
							System.out.println(c3.getText() + " is Executable...");
							setBrowser(c3.getText());
						} else {
							System.out.println(c3.getText() + " is not selected for execution");
						}
						if (c1.isSelected() == true) {
							System.out.println(c4.getText() + " is Executable...");
							setBrowser(c4.getText());
						} else {
							System.out.println(c4.getText() + " is not selected for execution");
						}
					} catch (Exception e1) {
						System.out.println("Exception in Parallel MODE");
					}
				}
			}
		});

		console = new JLabel("Console Output:");
		console.setBounds(20, 130, 100, 20);
		f.add(console);
		
		ButtonGroup consoleBG = new ButtonGroup();
		consoleBG.add(consoleButton);
		consoleBG.add(listenerButton);

		JTextArea textOut, listemArea;
		textOut = new JTextArea();
		textOut.setBounds(20, 150, 430, 200);
		textOut.setBackground(Color.BLACK);
		textOut.setForeground(Color.WHITE);
		Font font = new Font("Verdana", Font.BOLD, 8);
		textOut.setFont(font);
//		JScrollPane scrollPane = new JScrollPane(textOut);
//		scrollPane.setBounds(20, 150, 430, 200);
//		scrollPane.setBackground(Color.black);
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.add(textOut);
//		scrollPane.setVisible(true);
		
		listemArea = new JTextArea();
		listemArea.setBounds(20, 150, 430, 200);
		listemArea.setBackground(Color.gray);
		listemArea.setForeground(Color.BLACK);
		Font fonts = new Font("Verdana", Font.BOLD, 8);
		listemArea.setFont(fonts);
				
		PrintStream printStream = new PrintStream(new CustomOutputStream(textOut));
		System.setOut(printStream);
		System.setErr(printStream);
				
		listenerButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {			
				textOut.setVisible(false);		
				listemArea.setVisible(true);
				
				PrintStream printStream1 = new PrintStream(new CustomOutputStream(listemArea));
				System.setOut(printStream1);
				System.setErr(printStream1);
			}
		});
		
		consoleButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				listemArea.setVisible(false);	
				textOut.setVisible(true);
			}
		});
		
		f.add(textOut);
		f.add(listemArea);
		//f.add(scrollPane);
	}
	
	@Test
	public void runClass(String className, String methodName)  {
		try {
			Class<?> clazz = Class.forName(className);
			clazz.newInstance();
			clazz.getMethod(methodName, String.class);
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (InstantiationException e) {	
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new swingUiBuilder();
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				f.setSize(600, 400);
				f.setLayout(null);
				f.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
				f.setVisible(true);
				f.setResizable(false);
			}
		});
	}

}
