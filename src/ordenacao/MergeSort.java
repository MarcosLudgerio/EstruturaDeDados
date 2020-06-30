package ordenacao;

public class MergeSort {

	public static void main(String[] args) {

		int[] umVetor = {6, 3, 4, 1, 5, 2}; // Vetor que vai ser ordenado
		
		int[] vetorAuxiliar = new int[umVetor.length]; // Vetor auxiliar
		
		int inicio = 0, fim = vetorAuxiliar.length;
		
		// O merge sort recebe dois vetores, um deve ser auxiliar do mesmo tamanho do
		// vetor que irá ser ordenado, além do inicio e fim deles (os indices,
		// geralmente 0 e len(vetor)
		mergeSort(umVetor, vetorAuxiliar, inicio, fim);
		
	}

	public static void mergeSort(int[] vetorVitima, int[] vetorAjuda, int inicio, int fim) {

		// Equanto o inicio for menor que o final == if(inicio < fim)
		if (inicio < fim) {
			// Calcula o elemento que está no meio
			int meio = (inicio + fim) / 2;
			// Chama a bixiga do merge sort de novo, só que agora até o meio do vetor
			mergeSort(vetorVitima, vetorAjuda, inicio, meio); // Se liga no MEIO!
			// Chama a bixiga do método novamen só que agora pega do meio pro final
			mergeSort(vetorVitima, vetorAjuda, meio + 1, fim); // Se liga no MEIO!

			// Depois que for repartindo no meio, vai juntando as partes
			junta(vetorVitima, vetorAjuda, inicio, meio, fim);

		}

	}

	public static void junta(int[] vitima, int[] ajuda, int inicio, int meio, int fim) {

		// Cópia o vetor vitima pro vetor ajuda
		for (int i = inicio; i < fim; i++)
			ajuda[i] = vitima[i];

		// Depois cria outra variável que vai começar na posição inicio
		int j = inicio;

		// Cria outra variavel que vai começar da segunda metade do vetor
		int k = meio + 1;

		// Cria outro for pra fazer a junção entre dois subvetores
		for (int i = 0; i < fim; i++) {
			// TRATAR-SE DE CADA caso, se um vetor pequeno(subdividido) terminou antes do
			// outro eu cópio da vitima o restante do subvetor

			// Se o i, que ta andando na primeira parte do vetor, ultrapassou o elemento do
			// meio, então eu passo a copiar todos os elementos da segunda metade para o
			// vetor vitima
			if (i > meio)
				vitima[k] = ajuda[j++];
			// Isso, se a primeira metade do vetor já acabou
			// Se a segunda metade do vetor ultrapassou o final então copia todos os
			// elementos da primeira metade para a vitima
			else if (j > fim)
				vitima[k] = ajuda[i++]; /// A mulesta do i controla a primeira metade
			// Se ainda tem elementos na primeira metade e segunda metade então eu vou
			// comparar se o elemento que está na ajuda[i] é menor que o elemento que está
			// na posição ajuda[j]
			else if(ajuda[i] < ajuda[i])
				vitima[k] = ajuda[i++];
			else
				vitima[k] = ajuda[j++];

		}

	}
}
