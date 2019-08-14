package dev.stefifox.qr;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.html.ImageView;

public class Frame {
	
	private JFrame Frame;
	private JPanel Panel;
	
	private JButton settings;
	private ImageView preview;
	
	private Dimension Dimension;
	
	private SpringLayout Layout;
	

	public Frame(int Width, int Height, String Title){
		
		Dimension = new Dimension(Width, Height);
		
		Frame = new JFrame(Title);
		Panel = new JPanel();
		Layout = new SpringLayout();
		
		settings = new JButton("Settings");
		
		Panel.setLayout(Layout);
		
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(Dimension);
		Frame.setResizable(false);
		//Frame.setIconImage(image);
		Frame.setVisible(true);
		
		Frame.add(Panel);
		
		Panel.add(settings);
		
		
		settings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new Settings();
				
			}
		});
		
	}
	
}
