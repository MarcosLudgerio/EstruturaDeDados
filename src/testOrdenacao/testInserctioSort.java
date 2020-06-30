package testOrdenacao;

public class testInserctioSort {
	public static void main(String[] args) {
		int[] vetor = { 2, 3, 0, 1 };
		int[] vetorFinal = insercao(vetor);

		for (int i : vetorFinal)
			System.out.println(i);

	}

	public static int[] insercao(int[] vetor) {
		int i, j, tmp;
		for (i = 1; i < vetor.length; i++) {
			tmp = vetor[i];
			j = i - 1;
			while (j >= 0 && tmp < vetor[j]) {
				vetor[j + 1] = vetor[j];
				j--;
			}
			vetor[j + 1] = tmp;
		}
		return vetor;
	}

}
