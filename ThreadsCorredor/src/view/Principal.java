package view;

import java.util.concurrent.Semaphore;
import controller.OperacoesThreads;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore s = new Semaphore(permissoes);
		
		for (int idPessoa = 0; idPessoa < 4; idPessoa++){
			Thread tCorredor = new OperacoesThreads(idPessoa, s);
			tCorredor.start();
		}
	}

}
