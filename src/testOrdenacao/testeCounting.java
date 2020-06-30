package testOrdenacao;

public class testeCounting {
	public static void main(String[] args) {
		int[] vetor = { 3, 1, 2, 2, 0 };
		// PRIMEIRO OLHA QUAL O MAIOR ELEMENTO DE 'VETOR'
		int maior = vetor[0];
		for (int i = 1; i < vetor.length; i++)
			if (vetor[i] > maior)
				maior = vetor[i];
		int[] vetorFinal = countSort(vetor, maior);

		for (int i : vetorFinal)
			System.out.println("me odeio - " + i);

	}

	public static int[] countSort(int[] vetor, int maior) {
		// CRIA UMA LISTA DE CONTADORES DO TAMANHO DO MAIOR + 1
		int[] contadores = new int[maior + 1];
		// A LISTA DE CONTADORES VAI RECEBER A QUANTIDADE DE OCORRENCIA DE CADA ELEMENTO
		// INCIALIZA ELE COM ZERO
		for (int i = 0; i < contadores.length; i++)
			contadores[i] = 0;

		// CONTA OS ELEMENTOS
		for (int i = 0; i < vetor.length; i++)
			contadores[vetor[i]] += 1;

		for (int i : contadores)
			System.out.println(i + " c");
		// AO FINAL DESTA REPETIÇÃO É PARA O VETOR CONTADOR TER A QUANTIDADE DE
		// ELEMENTOS NA LISTA
		// DEPOIS ADICIONA TUDO EM VETORFINAL DE TRAS PRA FRENTE
		for (int i = 1; i <= maior; i++)
			contadores[i] = contadores[i] + contadores[i - 1];

		for (int i : contadores)
			System.out.println(i + " c1");

		int[] vetorFinal = new int[vetor.length];
		for (int i = vetor.length - 1; i >= 0; i--) {
			vetorFinal[contadores[vetor[i]] - 1] = vetor[i];
			contadores[vetor[i]] = contadores[vetor[i]] - 1;
			System.out.println(i);
		}
		return vetorFinal;

	}
}
