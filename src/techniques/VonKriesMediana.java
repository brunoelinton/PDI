package techniques;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class VonKriesMediana {
public BufferedImage mediana(BufferedImage imagemOriginal) {
		
		int linha, coluna, R = 0, G = 0, B = 0;
		double newR, newG, newB, avgR = 0, avgG = 0, avgB = 0, A, Bi, pixelTotal = 0;
		Color rgb, novo;
		BufferedImage imagemVon = new BufferedImage(imagemOriginal.getWidth(), imagemOriginal.getHeight(), imagemOriginal.getType());
		
		// LOOP PARA OTER O TOTAL DE COR RGB PARA O C�LCULO DA M�DIA DE CADA CANAL
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
		
		// C�LCULO DA M�DIA
		avgR = avgR / pixelTotal;
		avgG = avgG / pixelTotal;
		avgB = avgB / pixelTotal;
		
		//	R < B < G
		// R � O VALOR M�NIMO, B O MEDIANO E G O M�XIMO
		if (avgB > avgR && avgB < avgG){
			
			// C�LCULO DA EQUA��O 4
			A = avgB / avgR;
			
			// C�LCULO DA EQUA��O 5
			Bi = avgB / avgG;
			
			// LOOP PARA OBTER A ATUALIZA��O DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR M�XIMO MULTIPLICADO PELA EQUA��O 5
					newG = rgb.getGreen() * Bi;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;	
					
					// VALOR M�NIMO MULTIPLICADO PELA EQUA��O 4
					newR = rgb.getRed() * A;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					
					// ATUALIZA��O DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, (int)newG, rgb.getBlue());
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		
		// G < B < R
		// G � O VALOR M�NIMO, B � O MEDIANO E R � O M�XIMO
		else if (avgB < avgR && avgB > avgG){
			
			// C�LCULO DA EQUA��O 4
			A = avgB / avgG;
			
			// C�LCULO DA EQUA��O 5
			Bi = avgB / avgR;
			
			// LOOP PARA ATUALIZA��O DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR M�NIMO MULTIPLICADO PELA EQUA��O 4
					newG = rgb.getGreen() * A;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;	
					
					// VALOR M�XIMO MULTIPLICADO PELA EQUA��O 5
					newR = rgb.getRed() * Bi;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					
					// ATUALIZA��O DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, (int)newG, rgb.getBlue());
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// B < R < G
		// B � O VALOR M�NIMO, R O MEDIANO E G O M�XIMO
		else if (avgR > avgB && avgR < avgG){
			
			// C�LCULO DA EQUA��O 4
			A = avgR / avgB;
			
			// C�LCULO DA EQUA��O 5
			Bi = avgR / avgG;
			
			// LOOP PARA ATUALIZA��O DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR M�XIMO MULTIPLICADO PELA EQUA��O 5
					newG = rgb.getGreen() * Bi;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;	
					
					// VALOR M�NIMO MULTIPLICADO PELA EQUA��O 4
					newB = rgb.getBlue() * A;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// ATUALIZA��O DO VALOR DE RGB DO PIXEL
					novo = new Color(rgb.getRed(), (int)newG, (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// G < R < B
		// G � O VALOR M�NIMO, R O MEDIANO E B O M�XIMO
		else if (avgR < avgB && avgR > avgG){
			
			// C�LCULO DA EQUA��O 4
			A = avgR / avgG;
			// C�LCULO DA EQUA��O 5
			Bi = avgR / avgB;
			
			// LOOP PARA ATUALIZA��O DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR M�NIMO MULTIPLICADO PELA EQUA��O 4
					newG = rgb.getGreen() * A;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;
					// VALOR M�XIMO MULTIPLICADO PELA EQUA��O 5
					newB = rgb.getBlue() * Bi;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// ATUALIZA��O DO VALOR DE RGB DO PIXEL
					novo = new Color(rgb.getRed(), (int)newG, (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// R < G < B
		// R � O VALOR M�NIMO, G O MEDIANO E B O M�XIMO
		else if (avgG > avgR && avgG < avgB){
			
			// C�LCULO DA EQUA��O 4
			A = avgG / avgR;
			
			// C�LCULO DA EQUA��O 5
			Bi = avgG / avgB;
			
			// LOOP PARA ATUALIZA��O DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR M�XIMO MULTIPLICADO PELA EQUA��O 5
					newB = rgb.getBlue() * Bi;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// VALOR M�NIMO MULTIPLICADO PELA EQUA��O 4
					newR = rgb.getRed() * A;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					
					// ATUALIZA��O DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, rgb.getGreen(), (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// B < G < R
		// B � O VALOR M�NIMO, G O MEDIANO E R O M�XIMO
		else if (avgG < avgR && avgG > avgB){

			// C�LCULO DA EQUA��O 4
			A = avgG / avgB;
			
			// C�LCULO DA EQUA��O 5
			Bi = avgG / avgR;
			
			// LOOP PARA ATUALIZA��O DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR M�NIMO MULTIPLICADO PELA EQUA��O 4
					newB = rgb.getBlue() * A;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// VALOR M�XIMO MULTIPLICADO PELA EQUA��O 5
					newR = rgb.getRed() * Bi;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;
					
					// ATUALIZA��O DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, rgb.getGreen(), (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		
		return imagemVon;
	}
}
