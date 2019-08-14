package dev.stefifox.qr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class SaveSettings {
	
	private static int StartWitdh;
	private static int StartHeight;
	
	private static FileOutputStream Output1;
	public static PrintStream Print;
		
	public SaveSettings() {
			
		StartWitdh = Main.Width;
		StartHeight = Main.Height;

		//Verify if the file existing		
		if(!new File(Main.Default_Folder + "settings.set").exists()){
			New();
		}
		
	}
		
		private void New() {
			//Create new File
			
		System.out.println("Settings file [settings.set] didn't find");
		try{
			Output1 = new FileOutputStream(Main.Default_Folder + "settings.set");
			Print = new PrintStream(Output1);
		}
		catch(IOException e){
			System.out.println("Errore: "+ e);
			System.exit(1);
		}
			
		Print.println(StartWitdh);
		Print.println(StartHeight);
			
		try {
			Output1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void Update() {
					
		System.out.println("Updating settings...");
			
		try{
			Output1 = new FileOutputStream(Main.Default_Folder + "settings.set", false); //rewrite settings file
			Print = new PrintStream(Output1);
		}
		catch(IOException e){
			System.out.println("Erros: "+ e);
			System.exit(1);
		}
			
		Print.println(StartWitdh);
		System.out.println("New width: " +  StartWitdh);
		Print.println(StartHeight);
		System.out.println("New height: " +  StartHeight);

		try {
			Output1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
