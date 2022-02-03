package br.com.cord3r.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.cord3r.cm.excecao.EplosaoException;
import br.com.cord3r.cm.excecao.SairException;
import br.com.cord3r.cm.modelo.Tabaleiro;

public class TabuleiroConsole {
	
	private Tabaleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);
	
	public TabuleiroConsole( Tabaleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		excutarJogo();
	}

	private void excutarJogo() {
		try {
			boolean continuar = true;
			
			while( continuar) {
				cicloDoJogo();
				System.out.println("outra partida? ( s/n)");
				String resposta = entrada.nextLine();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
				
			}
		} catch(SairException e) {
			System.out.println("Adeus!!!s");
		} finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		 try {
			 
			 while(!tabuleiro.objetivoAlcancado()) {
				 System.out.print(tabuleiro);
				 String digita = capturaValorDigitado("digite (x,y): ");
			Iterator<Integer> xy = Arrays.stream(digita.split(","))
					.map( e -> Integer.parseInt(e.trim())).iterator();
			
			digita = capturaValorDigitado("1 - Abrir ou 2 (Des)Marca");
			if("1".equals(digita)) {
				tabuleiro.abrir(xy.next(), xy.next());
				
			} else if("2".equals(digita)) {
				tabuleiro.alternarMarcacao(xy.next(), xy.next());
			}
				
			 }
			 
			 
			 System.out.println(tabuleiro);
			 System.out.println("voce ganho!!!");
		 } catch(EplosaoException e ) {
			 System.out.println(tabuleiro);
			 System.out.println("voce perdeu!!! ");
		 }
		
	} 

	private String capturaValorDigitado(String texto) {
		System.out.println(texto);
		String digitado = entrada.nextLine();
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
			
		}
		
		return digitado; 
	}
}
