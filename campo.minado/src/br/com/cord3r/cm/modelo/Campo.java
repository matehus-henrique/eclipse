package br.com.cord3r.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.cord3r.cm.excecao.EplosaoException;

public class Campo {
	
	private  final int linha;
	private final int coluna;
	
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<Campo>();
	
	
	
	
	Campo(int linha, int coluna){
		this.linha = linha ;
		this.coluna = coluna;
	
	}
	
	boolean adcionarVizinho(Campo vizinho) {
		boolean linhaDiFerente = linha != vizinho.linha; // candidato de vizinho
		boolean colunaDiFerente = coluna != vizinho.coluna;
		boolean diagnal = linhaDiFerente && colunaDiFerente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int DetalGeral = deltaColuna + deltaLinha;
		
		if(DetalGeral == 1 && !diagnal) {
			vizinhos.add(vizinho);
			return true;
		}else if(DetalGeral == 2 && diagnal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	
		
	}
	
	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir() {
		
		
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new EplosaoException();
			}
			
			
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			
			return true;
		} else {
			return false;
		}
		
	}
	
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	void minar() {
		minado = true;
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	
	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isFechado() {
		return !isAberto();
	}

}
