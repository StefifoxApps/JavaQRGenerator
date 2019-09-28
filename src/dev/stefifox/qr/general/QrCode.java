/**
 * @author Stefano - Stefifox
 * This class is a General version for QR_Generator Class
 * Version 1.0
 * Library: zxing
 * License by: Google LLC.
 * License: Apache 2.0
 * 
 * Annotation: For use that code import in your code zxing file contains in source zip; 
 * zxing library is proprieties of Google LLC. under Apache license 2.0
 */

package dev.stefifox.qr.general;

import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCode {

	private String text;
	private int width;
	private int height;
	private int foreground;
	private int background;
	
	private BufferedImage image;
	private QRCodeWriter writer;
	
	
	public QrCode(String text, int width, int height, int foreground, int backgroud) { //This method generate a Qr Code Object
		
		this.text = text;
		this.width = width;
		this.height = height;
		
		this.foreground = foreground;
		this.background = backgroud;
		
	}
	
	public BufferedImage generate() {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		writer = new QRCodeWriter();
	    try {
	        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
	        for (int i = 0; i < width; i++) {
	            for (int j = 0; j < height; j++) {
	                image.setRGB(i, j, bitMatrix.get(i, j) ? foreground : background); // set pixel one by one
	            }
	        }
	 
	    } catch (WriterException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 
		
		return image;
	}

}