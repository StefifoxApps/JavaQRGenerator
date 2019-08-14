package dev.stefifox.qr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;


public class Settings {
	
	private JFrame Settings_Frame;
	private SpringLayout Layout;
	private JPanel Settings_Panel;
		
	private JButton Apply;
	private JButton Default;
	private JTextArea Width_Sett;
	private JTextArea Height_Sett;
	private JLabel Width_Info;
	private JLabel Height_info;
	private JLabel Warning;
		
	private Dimension dimension;
		
	public static int Default_Width = 1000;
	public static int Default_Height = 700;
		
	public Settings() {
			
		Settings_Frame = new JFrame("Settings");
		Settings_Panel = new JPanel();
		Apply = new JButton("Apply");
		Default = new JButton("Default settings");
		Layout = new SpringLayout();
			
		Width_Info = new JLabel("Witdh: ");
		Height_info = new JLabel("Height: ");
		Width_Sett = new JTextArea(Integer.toString(Main.Width));
		Height_Sett = new JTextArea(Integer.toString(Main.Height));
		Warning = new JLabel("There are unsaved modify");
			
		dimension = new Dimension(700, 500);
			
		Settings_Frame.setSize(dimension);
		Settings_Frame.setResizable(false);
		Settings_Frame.setVisible(true);
					
		Settings_Frame.add(Settings_Panel);
		Settings_Panel.setLayout(Layout);
			
		Warning.setForeground(Color.RED);
			
		Settings_Panel.add(Apply);
		Settings_Panel.add(Default);
		Settings_Panel.add(Width_Info);
		Settings_Panel.add(Height_info);
		Settings_Panel.add(Width_Sett);
		Settings_Panel.add(Height_Sett);
			
		//Width and Height
		Layout.putConstraint(SpringLayout.WEST, Width_Info, 15, SpringLayout.WEST, Settings_Panel);
		Layout.putConstraint(SpringLayout.EAST, Width_Info, -600, SpringLayout.EAST, Settings_Panel);
		Layout.putConstraint(SpringLayout.NORTH, Width_Info, 10, SpringLayout.NORTH, Settings_Panel);
		
		Layout.putConstraint(SpringLayout.WEST, Width_Sett, 50, SpringLayout.WEST, Width_Info);
		Layout.putConstraint(SpringLayout.EAST, Width_Sett, -550, SpringLayout.EAST, Settings_Panel);
		Layout.putConstraint(SpringLayout.NORTH, Width_Sett, 10, SpringLayout.NORTH, Settings_Panel);
			
		Layout.putConstraint(SpringLayout.WEST, Height_info, 15, SpringLayout.WEST, Settings_Panel);
		Layout.putConstraint(SpringLayout.EAST, Height_info, -600, SpringLayout.EAST, Settings_Panel);
		Layout.putConstraint(SpringLayout.NORTH, Height_info, 25, SpringLayout.NORTH, Width_Info);
			
		Layout.putConstraint(SpringLayout.WEST, Height_Sett, 50, SpringLayout.WEST, Height_info);
		Layout.putConstraint(SpringLayout.EAST, Height_Sett, -550, SpringLayout.EAST, Settings_Panel);
		Layout.putConstraint(SpringLayout.NORTH, Height_Sett, 25, SpringLayout.NORTH, Width_Info);
			
		//Apply Button
		Layout.putConstraint(SpringLayout.WEST, Apply, 600, SpringLayout.WEST, Settings_Panel);
		Layout.putConstraint(SpringLayout.EAST, Apply, -10, SpringLayout.EAST, Settings_Panel);
		Layout.putConstraint(SpringLayout.SOUTH, Apply, -10, SpringLayout.SOUTH, Settings_Panel);
		
		//Default settings button
		Layout.putConstraint(SpringLayout.WEST, Default, 450, SpringLayout.WEST, Settings_Panel);
		Layout.putConstraint(SpringLayout.EAST, Default, -100, SpringLayout.EAST, Apply);
		Layout.putConstraint(SpringLayout.SOUTH, Default, -10, SpringLayout.SOUTH, Settings_Panel);
			
		Apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Change value
				Main.Width = Integer.parseInt(Width_Sett.getText());
				Main.Height = Integer.parseInt(Height_Sett.getText());
				//Updating settings file
				new SaveSettings().Update();			
			}
		});		
			
		Default.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Call Default void and reset settings
				Default_Settings();
			}
		});
	}
		
	private void Default_Settings() {
			
		Width_Sett.setText(Integer.toString(Default_Width));
		Height_Sett.setText(Integer.toString(Default_Height));
			
	}

	
}
