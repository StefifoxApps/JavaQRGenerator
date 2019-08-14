package dev.stefifox.qr;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame {
	
	private JFrame Frame;
	private JPanel Panel;
	
	private JButton settings;
	private JButton generate;
	private JLabel info;
	private JLabel prev_text;
	
	private JLabel QR_W;
	private JLabel QR_H;
	private JTextArea QR_AW;
	private JTextArea QR_AH;
	
	public static JLabel preview = new JLabel();
	
	private JLabel S_info;
	
	private JSeparator Sep1;
	private JSeparator Sep2;
	
	private Dimension Dimension;
	
	private SpringLayout Layout;
	

	public Frame(int Width, int Height, String Title){
		
		Dimension = new Dimension(Width, Height);
		
		Frame = new JFrame(Title);
		Panel = new JPanel();
		Layout = new SpringLayout();
		
		settings = new JButton("Settings");
		generate = new JButton("Generate QR");
		
		info = new JLabel("QR Content", SwingConstants.CENTER);
		prev_text = new JLabel("QR Preview");
		S_info = new JLabel("QR Generator by Stefifox | OpenSource | Version: " +  Main.Version);
		
		QR_W = new JLabel("Width:");
		QR_H = new JLabel("Height:");
		
		QR_AW = new JTextArea(Integer.toString(Main.Width_Qr));
		QR_AH = new JTextArea(Integer.toString(Main.Height_Qr));
		
		Sep1 = new JSeparator(SwingConstants.VERTICAL);
		Sep2 = new JSeparator(SwingConstants.HORIZONTAL);
		
		Panel.setLayout(Layout);
		
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(Dimension);
		Frame.setResizable(false);
		//Frame.setIconImage(image);
		Frame.setVisible(true);
		
		Frame.add(Panel);
		
		//Add element to panel
		Panel.add(settings);
		Panel.add(prev_text);
		Panel.add(info);
		Panel.add(preview);
		
		Panel.add(generate);
		Panel.add(Sep1);
		
		Panel.add(Sep2);
		Panel.add(S_info);
		
		//Setting layout
		Layout.putConstraint(SpringLayout.EAST, settings, -15, SpringLayout.EAST, Panel);
		Layout.putConstraint(SpringLayout.SOUTH, settings, -5, SpringLayout.SOUTH, Panel);
		
		Layout.putConstraint(SpringLayout.WEST, prev_text, 15, SpringLayout.WEST, Panel);
		Layout.putConstraint(SpringLayout.NORTH, prev_text, 15, SpringLayout.NORTH, Panel);
		
		Layout.putConstraint(SpringLayout.EAST, Sep1, -(Main.Height/4), SpringLayout.EAST, Panel);
		Layout.putConstraint(SpringLayout.NORTH, Sep1, 5, SpringLayout.NORTH, Panel);
		Layout.putConstraint(SpringLayout.SOUTH, Sep1, -5, SpringLayout.NORTH, Sep2);
		
		Layout.putConstraint(SpringLayout.WEST, info, 5, SpringLayout.WEST, Sep1);
		Layout.putConstraint(SpringLayout.EAST, info, -5, SpringLayout.EAST, Panel);
		Layout.putConstraint(SpringLayout.NORTH, info, 5, SpringLayout.NORTH, Panel);
		
		Layout.putConstraint(SpringLayout.WEST, generate, 5, SpringLayout.WEST, Sep1);
		Layout.putConstraint(SpringLayout.EAST, generate, -5, SpringLayout.EAST, Panel);
		Layout.putConstraint(SpringLayout.NORTH, generate, 5, SpringLayout.SOUTH, info);
		
		Layout.putConstraint(SpringLayout.WEST, preview, 15, SpringLayout.WEST, Panel);
		Layout.putConstraint(SpringLayout.EAST, preview, -15, SpringLayout.EAST, Sep1);
		Layout.putConstraint(SpringLayout.NORTH, preview, 15, SpringLayout.NORTH, Panel);
		Layout.putConstraint(SpringLayout.SOUTH, preview, -15, SpringLayout.NORTH, Sep2);
		
		//Footer
		Layout.putConstraint(SpringLayout.WEST, Sep2, 5, SpringLayout.WEST, Panel);
		Layout.putConstraint(SpringLayout.EAST, Sep2, -5, SpringLayout.EAST, Panel);
		Layout.putConstraint(SpringLayout.SOUTH, Sep2, -5, SpringLayout.NORTH, settings);
		
		Layout.putConstraint(SpringLayout.WEST, S_info, 10, SpringLayout.WEST, Panel);
		Layout.putConstraint(SpringLayout.EAST, S_info, -5, SpringLayout.WEST, settings);
		Layout.putConstraint(SpringLayout.NORTH, S_info, 2, SpringLayout.SOUTH, Sep2);
		
		settings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new Settings();
				
			}
		});
		
		generate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Main.Width_Qr = Integer.parseInt(QR_AW.getText());
				Main.Height_Qr = Integer.parseInt(QR_AH.getText());
				
				//Generate QR
				new QR_Generator(Main.Text_Qr, Main.Width_Qr, Main.Height_Qr).preview(Main.Text_Qr, (int)((Main.Width/1.4)), (int)(Main.Height/1.4));
				
			}
		});
		
	}
	
}
