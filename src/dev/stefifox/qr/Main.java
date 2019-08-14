package dev.stefifox.qr;

import java.io.File;

public class Main {
	
	public static int Width = 1000;
	public static int Width_Qr = 256; //Default QR Width
	public static int Height = 500; 
	public static int Height_Qr = 256; //Default QR Height
	public static String Title = "QR Generator";
	public static String Text_Qr = "null";
	
	public static String Default_Folder = ".\\Qr_Generator\\";
	
	public static void main(String[] args) {
	
		if(new File(Default_Folder + "Settings.set").exists()) {
			System.out.println("Settings file [settings.set] foudn");
			new LoadSettings();
		}else {
			//Generate Default Folder
			@SuppressWarnings("unused")
			boolean s0 = (new File(Default_Folder)).mkdir();
			//Generate QR Temp Folder
			@SuppressWarnings("unused")
			boolean s1 = (new File(Default_Folder + "temp")).mkdir();
			//Generate QR Folder
			@SuppressWarnings("unused")
			boolean s2 = (new File(Default_Folder + "save")).mkdir();
			//Generate settings
			new SaveSettings();
		}
		
		new Frame(Width, Height, Title);
		new QR_Generator(Text_Qr, Width_Qr, Height_Qr);
	}

}
