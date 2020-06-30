package ordenacao;

public class InserctionSort {

	public static void main(String[] args) {

		int quantidade = 8;
		int[] vetor = new int[quantidade];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * quantidade);
		}

		insertionSort(vetor);

	}

	public static void insertionSort(int[] vetor) {
		int j;
		int key;
		int i;

		for (j = 1; j < vetor.length; j++) {
			
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;

		}
	}

}
