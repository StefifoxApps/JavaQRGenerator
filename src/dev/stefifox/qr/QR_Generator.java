package dev.stefifox.qr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QR_Generator {
	
	private QRCodeWriter writer;
	private BufferedImage image;
	private ImageIcon prewiew_im;
	
	public static int number = 0; 

	public QR_Generator() {
	    
		
	}
	
	public void Generator(String Text, int width, int  height) {
	    
		writer = new QRCodeWriter();
	    
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // create an empty image
	    int white = 0xffffff;
	    int black = 0x000000;
	    try {
	        BitMatrix bitMatrix = writer.encode(Text, BarcodeFormat.QR_CODE, width, height);
	        for (int i = 0; i < width; i++) {
	            for (int j = 0; j < height; j++) {
	                image.setRGB(i, j, bitMatrix.get(i, j) ? black : white); // set pixel one by one
	            }
	        }
	 
	        try {
	            ImageIO.write(image, "png", new File(Main.Default_Folder + "save\\Qr" + number +  ".png")); // save QR image to disk
	            number++;
	            new SaveSettings().N_Update();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    } catch (WriterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	public void preview(String Text, int width, int height) {
		
		writer = new QRCodeWriter();
	    
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // create an empty image
	    int white = 0xffffff;
	    int black = 0x000000;
		
	    try {
	        BitMatrix bitMatrix = writer.encode(Text, BarcodeFormat.QR_CODE, width, height);
	        for (int i = 0; i < width; i++) {
	            for (int j = 0; j < height; j++) {
	                image.setRGB(i, j, bitMatrix.get(i, j) ? black : white); // set pixel one by one
	            }
	        }
	 
	    } catch (WriterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 
	    
	   prewiew_im = new ImageIcon(image);
	    		
	   Frame.preview.setIcon(prewiew_im);
	    		
	}
	
}
