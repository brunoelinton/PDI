package techniques;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class VonKriesMedia {
	public BufferedImage media(BufferedImage imagemOriginal) {
		
		int linha, coluna, R = 0, G = 0, B = 0;
		double newR, newG, newB, avgR = 0, avgG = 0, avgB = 0, A, Bi, pixelTotal = 0;
		Color rgb, novo;
		BufferedImage imagemVon = new BufferedImage(imagemOriginal.getWidth(), imagemOriginal.getHeight(), imagemOriginal.getType());
		
		for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
			for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
				rgb = new Color(imagemOriginal.getRGB(linha, coluna));
				R = rgb.getRed() ;
				G = rgb.getGreen();
				B = rgb.getBlue();
				
				pixelTotal++;
				
				avgR = avgR + R;
				avgG = avgG + G;
				avgB = avgB + B;
			}
		}
		
		avgR = avgR / pixelTotal;
		avgG = avgG / pixelTotal;
		avgB = avgB / pixelTotal;
		
		if (avgB > avgR && avgB > avgG){
			A = avgB / avgR;
			Bi = avgB / avgG;
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));

					newG = rgb.getGreen() * Bi;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;					
					newR = rgb.getRed() * A;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					novo = new Color((int)newR, (int)newG, rgb.getBlue());
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		else if (avgR > avgB && avgR > avgG){
			A = avgR / avgB;
			Bi = avgR / avgG;
		
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));

					newG = rgb.getGreen() * Bi;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;					
					newB = rgb.getBlue() * A;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					novo = new Color(rgb.getRed(), (int)newG, (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		else if (avgG > avgB && avgG > avgR)
		{
			A = avgG / avgR;
			Bi = avgG / avgB;
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
				
					newB = rgb.getBlue() * Bi;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					newR = rgb.getRed() * A;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					novo = new Color((int)newR, rgb.getGreen(), (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		return imagemVon;
	}
}
