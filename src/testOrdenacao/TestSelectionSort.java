package testOrdenacao;

public class TestSelectionSort {
	public static void main(String [] args) {
		int [] vetor = {3,5,1,2};
		int [] vetor2 = selecao(vetor);
		for(int i : vetor2) System.out.println(i);
	}
	
	public static int [] selecao(int [] vetor) {
		int tamanho = vetor.length; 
		for(int i = 0; i < tamanho; i++) {
			int min = i;
			for(int j = i+1; j < tamanho; j++)
				if(vetor[j] < vetor[min]) 
					min = j;	
			int temp = vetor[min];
			vetor[min] = vetor[i];
			vetor[i] = temp;
		}
		
		return vetor;
	}
}
