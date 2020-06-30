
package ordenacao;

public class CountingSort {

	public static void main(String[] args) {
		int[] lista = new int[] { 3, 1, 2, 2, 3, 3, 3, 1, 2, 1 };
		int[] lista2 = ordenacaoPorContagem(lista);
		for (int i : lista2) {
			System.out.printf(i + " ");
		}

	}

	
	public static int[] ordenacaoPorContagem(int[] vetor) {
		int k = vetor.length;
		int[] balde = new int[k];

		// VERIFICA QUAL É O MAIOR DA LISTA
		int maior = vetor[0];
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] > maior) {
				maior = vetor[i];
			}
		}

		// INICIALIZA O VETOR BALDE COM TODAS AS POSIÇÕES ZERO PARA PODER ADICIONAR A
		// QUANTIDADE DE ELEMENTOS QUE CADA VALOR APARECE NA LISTA
		for (int i = 0; i < k; i++) {
			balde[i] = 0;
		}

		// CONTA QUANTAS VEZES CADA ELEMENTO APARECE QUANDO O VETOR ACABAR EU VOU TER A
		// QUANTIDADE DE CADA ELEMENTO QUE APARECE NA LISTA
		for (int i = 0; i < k; i++) {
			balde[vetor[i]]++;
		}

		// ADICIONA A LISTA CADA VALOR DE ACORDO COM A QUANTIDADE QUE ELES APARECEM
		for (int i = 0, j = 0; j < maior; j++) {
			for(int l = balde[j]; l > 0; l--) {
				vetor[i++] = j;
			}
		}

		return vetor;
	}
	
	
	
	
	
	public static void ordena(int[] a, int m) {
		int n = a.length;

		int vetorAuxiliar[] = new int[m];

		// 1ª - (Inicializar com zero)
		for (int i = 0; i < m; i++) {
			vetorAuxiliar[i] = 0;
		}

		// 2ª - Contagem das ocorrencias
		for (int i = 0; i < n; i++) {
			vetorAuxiliar[a[i]]++; 
		}

		// 3ª - Ordenando os indices do vetor auxiliar
		int sum = 0;
		for (int i = 1; i < m; i++) {
			int dum = vetorAuxiliar[i];
			vetorAuxiliar[i] = sum;
			sum += dum;
		}
		int vetorOrdenado[] = new int[n];
		for (int i = 0; i < n; i++) {
			vetorOrdenado[vetorAuxiliar[a[i]]] = a[i];
			vetorAuxiliar[a[i]]++;
		}

		// 4ª Retornando os valores ordenados para o vetor de entrada
		for (int i = 0; i < n; i++) {
			a[i] = vetorOrdenado[i];
		}
	}

}
