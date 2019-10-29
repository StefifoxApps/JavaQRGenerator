package dev.stefifox.nogui;

import java.awt.image.BufferedImage;
import java.util.Scanner;

import dev.stefifox.qr.general.*;

/**
 * This version are been made for no-gui OS; can be used for generate QRCODES only use terminal 
 * @version 1.0.1
 * @author Stefifox
 * @category Image coding
 */


public class Main {

	private static int select = -1;
	private static String text;
	private static int width;
	private static int height;
	
	private static BufferedImage image;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.println("Select an option\n0. Exit\n1. QrCode standard\n2. QrCode with height and width");
			select = input.nextInt();
			switch(select) {
				case 1:
					System.out.print("Text: ");
					text = input.next();
					image = QrCode.generate(text);
					break;
				case 2:
					System.out.print("Text: ");
					text = input.next();
					System.out.print("Width: ");
					width = input.nextInt();
					System.out.print("Height: ");
					height = input.nextInt();
					image = QrCode.generateWhite(text, width, height);
					break;
			}
			
			if(select > 0) {
				try {
					new Output(image);
				}catch(Exception e) {
					System.out.println("Can not be generated QrCode");
				}
			}
		}while(select != 0);
		
		System.out.println("Goodbye");

	}

}
