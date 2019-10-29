package dev.stefifox.nogui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class Output {
	
	private String Default_Folder = ".\\QrGenerator\\";
	private String number;

	public Output(BufferedImage image) {
		
		if(!new File(Default_Folder).exists()) {
			//Generate Default Folder
			@SuppressWarnings("unused")
			boolean s0 = (new File(Default_Folder)).mkdir();
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddmmss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		
		number = dtf.format(now);
		
		try {
            ImageIO.write(image, "png", new File(Default_Folder + "Qr" + number +  ".png")); // save QR image to disk

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
	}
	
}
