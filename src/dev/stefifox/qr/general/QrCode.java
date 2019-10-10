package dev.stefifox.qr.general;

import java.awt.image.BufferedImage;
import com.google.zxing.qrcode.QRCodeWriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * This class is a General version for QR_Generator Class
 * 
 * Library: zxing
 * License by: Google LLC.
 * License: Apache 2.0
 *
 * Annotation: For use that code import in your code zxing file contains in source zip; 
 * zxing library is proprieties of Google LLC. under Apache license 2.0
 * 
 * @author Stefano - Stefifox
 * @version 2.0
 */
public class QrCode {

	private static BufferedImage image;
	private static QRCodeWriter writer;
	
	/**
	 * This method generate a QrCode
	 * @param text A QrCode Text
	 * @param width A QrCode Width
	 * @param height A QrCode Height
	 * @param foreground A QrCode foreground
	 * @param background A QrCode background
	 * @return BufferedImage image 
	 */
	
	public static BufferedImage generate(String text, int width, int height, int foreground, int background) {
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
