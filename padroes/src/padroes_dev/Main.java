package padroes_dev;

import java.util.Random;

public class Main {
	
	public static String s1="ABCDCBDCBDACBDABDCBADF";
	public static String s2="ADF";

	public static void main(String[] args) {
		
		Random gerador = new Random();
		
		for(int i =0; i<500000; i++) {
			s1 += (char)(Math.abs(gerador.nextInt() % 26));
		}
		
		System.out.println("Gerou palavra de tamanho 500.000");
		// TODO Auto-generated method stub
		Padroes_Checker pc = new Padroes_Checker();
		System.out.println("Padrão com String.IndexOf:\n");
		pc.calculaPadrao1(s1, s2);
		System.out.println("\n--------------------------------------\n\nPadrão Robin Karp:");
		pc.calculaRabinKarp(s2, s1);
		System.out.println("\nIteracoes/frequencia: " + pc.iteracao2 );
		System.out.println("\n--------------------------------------\n\nPadrão KMP:\n");
		pc.KMPSearch(s2, s1);
		System.out.println("\nComplexidade no pior caso: O(n)");
		System.out.println("\nIteracoes/frequencia:" + pc.iteracao3);
	}

}
