package br.com.cord3r.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cord3r.cm.excecao.EplosaoException;

public class CampoTeste {

	private Campo campo;  
	
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	
	
	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado	= campo.adcionarVizinho(vizinho);
	
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado	= campo.adcionarVizinho(vizinho);
	
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Emcima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado	= campo.adcionarVizinho(vizinho);
	
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Embaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado	= campo.adcionarVizinho(vizinho);
	
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado	= campo.adcionarVizinho(vizinho);
	
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinhoRealDistancia1Emcima() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado	= campo.adcionarVizinho(vizinho);
	
		assertFalse(resultado);
	}
	
	
	
	@Test
	void testeValorPadraoAtributoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();

		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {

		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
	
		campo.minar();
		
		assertThrows(EplosaoException.class, () ->{	campo.abrir();});
	
	}
	
	@Test
	void testeAbrirComVizinho1() {
		Campo campo11 = new Campo(1, 1);
		
		Campo campo22 = new Campo(2, 2);
		 campo22.adcionarVizinho(campo11);
		 campo.adcionarVizinho(campo22);
		 campo.abrir();
		assertTrue(campo22.isAberto()
				 && campo11.isAberto());
	}
	@Test
	void testeAbrirComVizinho2() {
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		 campo22.adcionarVizinho(campo11);
		 campo22.adcionarVizinho(campo12);
		 campo.adcionarVizinho(campo22);
		 campo.abrir();
		assertTrue(campo22.isAberto()
				 && campo11.isFechado());
	}
	
	@Test
	void alcancado() {
	
		Campo campo34 = new Campo(3, 4);
		campo.objetivoAlcancado();
		assertTrue(campo34.abrir());
	}
	
	



	private Campo Campo(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
