package ordenacao;

public class CountingSortMaluco {
	public int[] ordenacaoPorContagem(int[] vetor) {
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

}
