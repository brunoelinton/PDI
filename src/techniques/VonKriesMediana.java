package techniques;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class VonKriesMediana {
public BufferedImage mediana(BufferedImage imagemOriginal) {
		
		int linha, coluna, R = 0, G = 0, B = 0;
		double newR, newG, newB, avgR = 0, avgG = 0, avgB = 0, A, Bi, pixelTotal = 0;
		Color rgb, novo;
		BufferedImage imagemVon = new BufferedImage(imagemOriginal.getWidth(), imagemOriginal.getHeight(), imagemOriginal.getType());
		
		// LOOP PARA OTER O TOTAL DE COR RGB PARA O CÁLCULO DA MÉDIA DE CADA CANAL
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
		
		// CÁLCULO DA MÉDIA
		avgR = avgR / pixelTotal;
		avgG = avgG / pixelTotal;
		avgB = avgB / pixelTotal;
		
		//	R < B < G
		// R É O VALOR MÍNIMO, B O MEDIANO E G O MÁXIMO
		if (avgB > avgR && avgB < avgG){
			
			// CÁLCULO DA EQUAÇÃO 4
			A = avgB / avgR;
			
			// CÁLCULO DA EQUAÇÃO 5
			Bi = avgB / avgG;
			
			// LOOP PARA OBTER A ATUALIZAÇÃO DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR MÁXIMO MULTIPLICADO PELA EQUAÇÃO 5
					newG = rgb.getGreen() * Bi;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;	
					
					// VALOR MÍNIMO MULTIPLICADO PELA EQUAÇÃO 4
					newR = rgb.getRed() * A;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					
					// ATUALIZAÇÃO DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, (int)newG, rgb.getBlue());
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		
		// G < B < R
		// G É O VALOR MÍNIMO, B É O MEDIANO E R É O MÁXIMO
		else if (avgB < avgR && avgB > avgG){
			
			// CÁLCULO DA EQUAÇÃO 4
			A = avgB / avgG;
			
			// CÁLCULO DA EQUAÇÃO 5
			Bi = avgB / avgR;
			
			// LOOP PARA ATUALIZAÇÃO DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR MÍNIMO MULTIPLICADO PELA EQUAÇÃO 4
					newG = rgb.getGreen() * A;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;	
					
					// VALOR MÁXIMO MULTIPLICADO PELA EQUAÇÃO 5
					newR = rgb.getRed() * Bi;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					
					// ATUALIZAÇÃO DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, (int)newG, rgb.getBlue());
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// B < R < G
		// B É O VALOR MÍNIMO, R O MEDIANO E G O MÁXIMO
		else if (avgR > avgB && avgR < avgG){
			
			// CÁLCULO DA EQUAÇÃO 4
			A = avgR / avgB;
			
			// CÁLCULO DA EQUAÇÃO 5
			Bi = avgR / avgG;
			
			// LOOP PARA ATUALIZAÇÃO DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR MÁXIMO MULTIPLICADO PELA EQUAÇÃO 5
					newG = rgb.getGreen() * Bi;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;	
					
					// VALOR MÍNIMO MULTIPLICADO PELA EQUAÇÃO 4
					newB = rgb.getBlue() * A;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// ATUALIZAÇÃO DO VALOR DE RGB DO PIXEL
					novo = new Color(rgb.getRed(), (int)newG, (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// G < R < B
		// G É O VALOR MÍNIMO, R O MEDIANO E B O MÁXIMO
		else if (avgR < avgB && avgR > avgG){
			
			// CÁLCULO DA EQUAÇÃO 4
			A = avgR / avgG;
			// CÁLCULO DA EQUAÇÃO 5
			Bi = avgR / avgB;
			
			// LOOP PARA ATUALIZAÇÃO DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR MÍNIMO MULTIPLICADO PELA EQUAÇÃO 4
					newG = rgb.getGreen() * A;
					if (newG > 255)
						newG = 255;
					else if(newG < 0)
						newG = 0;
					// VALOR MÁXIMO MULTIPLICADO PELA EQUAÇÃO 5
					newB = rgb.getBlue() * Bi;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// ATUALIZAÇÃO DO VALOR DE RGB DO PIXEL
					novo = new Color(rgb.getRed(), (int)newG, (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// R < G < B
		// R É O VALOR MÍNIMO, G O MEDIANO E B O MÁXIMO
		else if (avgG > avgR && avgG < avgB){
			
			// CÁLCULO DA EQUAÇÃO 4
			A = avgG / avgR;
			
			// CÁLCULO DA EQUAÇÃO 5
			Bi = avgG / avgB;
			
			// LOOP PARA ATUALIZAÇÃO DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR MÁXIMO MULTIPLICADO PELA EQUAÇÃO 5
					newB = rgb.getBlue() * Bi;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// VALOR MÍNIMO MULTIPLICADO PELA EQUAÇÃO 4
					newR = rgb.getRed() * A;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;	
					
					// ATUALIZAÇÃO DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, rgb.getGreen(), (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		// B < G < R
		// B É O VALOR MÍNIMO, G O MEDIANO E R O MÁXIMO
		else if (avgG < avgR && avgG > avgB){

			// CÁLCULO DA EQUAÇÃO 4
			A = avgG / avgB;
			
			// CÁLCULO DA EQUAÇÃO 5
			Bi = avgG / avgR;
			
			// LOOP PARA ATUALIZAÇÃO DOS VALORES DOS CANAIS RGB
			for (linha = 0; linha < imagemOriginal.getWidth(); linha++) {
				for (coluna = 0; coluna < imagemOriginal.getHeight(); coluna++) {
					rgb = new Color(imagemOriginal.getRGB(linha, coluna));
					
					// VALOR MÍNIMO MULTIPLICADO PELA EQUAÇÃO 4
					newB = rgb.getBlue() * A;
					if (newB > 255)
						newB = 255;
					else if(newB < 0)
						newB = 0;	
					
					// VALOR MÁXIMO MULTIPLICADO PELA EQUAÇÃO 5
					newR = rgb.getRed() * Bi;
					if (newR > 255)
						newR = 255;
					else if(newR < 0)
						newR = 0;
					
					// ATUALIZAÇÃO DO VALOR DE RGB DO PIXEL
					novo = new Color((int)newR, rgb.getGreen(), (int)newB);
					imagemVon.setRGB(linha, coluna, novo.getRGB());				
				}	
			}
		}
		
		return imagemVon;
	}
}
