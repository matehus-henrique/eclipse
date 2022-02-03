package br.com.cord3r.cm1;

import br.com.cord3r.cm.modelo.Tabaleiro;
import br.com.cord3r.cm.visao.TabuleiroConsole;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabaleiro tabuleiro = new Tabaleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);
		
	
		
		
		
	}

}
