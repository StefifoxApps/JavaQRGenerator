package dev.stefifox.qr;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextInput {

	private JFrame Frame;
	private JPanel Panel;
	public static JTextArea	Input = new JTextArea();
	private JButton Confirm;
	
	private SpringLayout Layout;
	
	private Dimension dimension;
		
	public TextInput() {
		
		Frame = new JFrame("Input area");
		Panel = new JPanel();
		Confirm = new JButton("Ok"); 
		
		Layout = new SpringLayout();
		
		dimension = new Dimension(500, 250);
		
		Frame.setSize(dimension);
		Frame.setResizable(false);
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Panel.setLayout(Layout);
		
		Frame.add(Panel);
		
		Panel.add(Input);
		Panel.add(Confirm);
		
		Layout.putConstraint(SpringLayout.WEST, Input, 5, SpringLayout.WEST, Panel);
		Layout.putConstraint(SpringLayout.EAST, Input, -5, SpringLayout.EAST, Panel);
		Layout.putConstraint(SpringLayout.NORTH, Input, 5, SpringLayout.NORTH, Panel);
		Layout.putConstraint(SpringLayout.SOUTH, Input, -15, SpringLayout.NORTH, Confirm);
		
		Layout.putConstraint(SpringLayout.WEST, Confirm, 230, SpringLayout.WEST, Panel);
		Layout.putConstraint(SpringLayout.EAST, Confirm, -5, SpringLayout.EAST, Panel);
		Layout.putConstraint(SpringLayout.SOUTH, Confirm, -5, SpringLayout.SOUTH, Panel);
		
		
		Confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				System.out.println("QR Text: "+ Input.getText());

				Frame.dispose();
			}
		});
	}
	
}
