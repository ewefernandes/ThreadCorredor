package controller;

import java.util.concurrent.Semaphore;

public class OperacoesThreads extends Thread {
	
	private static int posChegada;
	private int idPessoa;
	private Semaphore s;
	
	public OperacoesThreads(int idPessoa, Semaphore s){
		this.idPessoa = idPessoa;
		this.s = s;
	}

	public void run() {
		AndaCorredor();
		try {
			s.acquire();
			CruzaPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			s.release();
		}
		LiberaPorta();
	}
	
	private void AndaCorredor() {
		int distCorredor = 200;
		int deslocamento = (int)((Math.random()*2.00002) + 4);
		int distPercorrida = 0;
		int tempo = 1000;
		
		while (distPercorrida < distCorredor) {
			distPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa #" +idPessoa+ " ja andou " +distPercorrida+ " metros.");
		}
		posChegada++;
		System.out.println("A pessoa #" +idPessoa+ " chegou em " +posChegada+ "o. lugar!");
	}
	
	private void CruzaPorta() {
		
		System.out.println("A pessoa #" +idPessoa+ " está cruzando a porta.");
		int tempo = (int)((Math.random() * 1.000001) + 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void LiberaPorta() {
		System.out.println("A pessoa #" +idPessoa+ " liberou a porta.");
	}
	
}
