package dev.stefifox.qr;

import java.io.File;

public class Main {
	
	public static int Width = 700;
	public static int Width_Qr = 256; //Default QR Width
	public static int Height = 500; 
	public static int Height_Qr = 256; //Default QR Height
	public static String Title = "QR Generator";
	public static String Text_Qr = "null";
	
	public static String Version = "0.1";
	
	public static String Default_Folder = ".\\Qr_Generator\\"; //Default folder
	
	public static void main(String[] args) {
	
		if(new File(Default_Folder + "Settings.set").exists()) {
			System.out.println("Settings file [settings.set] foudn");
			//Load Settings
			new LoadSettings(); //Calling class for Loading all settings
		}else {
			//Generate Default Folder
			@SuppressWarnings("unused")
			boolean s0 = (new File(Default_Folder)).mkdir();
			//Generate QR Folder
			@SuppressWarnings("unused")
			boolean s2 = (new File(Default_Folder + "save")).mkdir();
			//Generate settings
			new SaveSettings(); //Calling class for Saving all settings 
		}
		
		new Frame(Width, Height, Title); //Calling class for JFrame generation
		
	}

}
