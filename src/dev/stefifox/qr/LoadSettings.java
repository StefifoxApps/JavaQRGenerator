package dev.stefifox.qr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LoadSettings {

	private static FileReader ReadFile;
	private static BufferedReader BufferRead;
	
	private static int StartWitdh;
	private static int StartHeight;
	
	public LoadSettings() {
		
		System.out.println("Loading settings...");
		
		try {
			ReadFile = new FileReader(Main.Default_Folder + "settings.set");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		
		BufferRead = new BufferedReader(ReadFile);
	
		try {
			StartWitdh = Integer.parseInt(BufferRead.readLine());
			System.out.println("Witdh: " + StartWitdh);
			StartHeight = Integer.parseInt(BufferRead.readLine());
			System.out.println("Height: " + StartHeight);;
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("----");
		
		Update_Main();
		
	}
	
	public void Update_Main() {
		
		Main.Width = StartWitdh;
		Main.Height = StartHeight;
		
	}
	
}
