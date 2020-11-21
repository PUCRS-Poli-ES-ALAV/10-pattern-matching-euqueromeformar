package padroes_dev;

public class Padroes_Checker {
	
	public int iteracao1 = 0;
	public int iteracao2 = 0;
	public int iteracao3 = 0;


	
	public Padroes_Checker() {};
	
	public void calculaPadrao1(String s1, String s2) {
		System.out.println( "Posição da primeira Ocorrência de s2: "+s1.indexOf(s2));
		iteracao1++;
		System.out.println( "\nComplexidade no pior caso:O(m*n) onde m = s1.length() e n = s2.length()");
		System.out.println( "\nIteracoes/frequencia:"+iteracao1);
	}
	
	public void calculaRabinKarp(String pat, String txt) {
			int inc = search(pat,txt);
			iteracao2+=3;
		
		   if(inc == txt.length()) {
			   System.out.println("Nenhuma Ocorrencia");
			   iteracao2+=2;
		   }
		   else {
			   System.out.println("\nOcorrência em:"+inc);
			   iteracao2+=3;
		   }
		   
	}
	
	private int search(String pat, String txt) {
		   int M = pat.length();
		   int N = txt.length();
		   long patHash = hash(pat, M);
		   iteracao2+=8;

		   for (int i = 0; i <= N - M; i++) {
			  iteracao2+=5;
		      long txtHash = hash(txt.substring(i, i+M), M);
		      iteracao2+=3;
		      if (patHash == txtHash) {
		    	  iteracao2+=i;
		         return i; // ocorrência? colisão?
		      }
		   }
		   iteracao2+=N-M;
		   return N; // nenhuma ocorrência
		}

	
	private long hash(String s, int M) {
		   long h = 0;
		   iteracao2+=2;
		   for (int j = 0; j < M; j++)
		      h = (h * 25 + s.charAt(j)) % 2147483647;
		   
		   iteracao2+=M + 5;
		   
		   return h;
		}
	
	void KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 
		
		iteracao3 += 6;

		// cria lps[] que vai guardar o maior 
		// valor prefixo sufixo para o padrão 
		int lps[] = new int[M]; 
		int j = 0; // index for pat[] 
		
		iteracao3 += 5;

		// Calcula lps[] 
		computeLPSArray(pat, M, lps); 
		iteracao3 ++;

		int i = 0; // index for txt[] 
		iteracao3 += 2;
		
		while (i < N) { 
			iteracao3 ++;
			
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; 
				i++; 
				
				iteracao3 += 3;
			} 
			if (j == M) { 
				System.out.println("Found pattern "
								+ "at index " + (i - j)); 
				j = lps[j - 1]; 
				
				iteracao3 += 4;
			} 

			// mismatch após j matches 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
				// Não faz match dos caracteres lps[0..lps[j-1]], 
				// não é necesssário, eles combinarão 
				iteracao3 += 5;
				
				if (j != 0) 
					j = lps[j - 1]; 
				else
					i = i + 1; 
				
				iteracao3 += 3;
			} 
		} 
		
	} 

	void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		// tamanho do maior prefixo sufixo anterior 
		int len = 0; 
		int i = 1; 
		lps[0] = 0; // lps[0] is always 0 

		iteracao3 += 5;
		
		// loop calcula lps[i] for i = 1 to M-1 
		while (i < M) { 
			iteracao3 ++;
			if (pat.charAt(i) == pat.charAt(len)) { 
				len++; 
				lps[i] = len; 
				i++; 
				iteracao3 += 9;
			} 
			else // (pat[i] != pat[len]) 
			{ 
				if (len != 0) { 
					len = lps[len - 1]; 
					iteracao3 += 3;
				} 
				
				else // if (len == 0) 
				{ 
					lps[i] = len; 
					i++; 
					iteracao3 += 4;
				} 
			} 
		} 
	} 
	
}
