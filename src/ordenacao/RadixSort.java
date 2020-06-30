package ordenacao;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

	private static final int MAX_CHARS = 28;

	private static void radixSort(String[] v) {
		Queue<String> queues[] = createQueues();
		for (int pos = maxSize(v) - 1; pos >= 0; pos--) {
			for (int i = 0; i < v.length; i++) {
				int q = queueNo(v[i], pos);
				queues[q].add(v[i]);
			}
			restore(queues, v);
		}
	}

	private static void restore(Queue<String>[] qs, String[] v) {
		int contv = 0;
		for (int q = 0; q < qs.length; q++)
			while (qs[q].size() > 0)
				v[contv++] = qs[q].remove();
	}

	private static Queue<String>[] createQueues() {
		LinkedList<String>[] result = new LinkedList[MAX_CHARS];
		for (int i = 0; i < MAX_CHARS; i++) {
			result[i] = new LinkedList<String>();
		}
		return result;
	}

	private static int queueNo(String string, int pos) {
		if (pos >= string.length()) {
			return 0;
		}
		char ch = string.charAt(pos);
		if ((ch >= 'A') && (ch <= 'Z')) {
			return (ch - 'A' + 1);
		} else if (ch >= 'a' && ch <= 'z') {
			return ch - 'a' + 1;
		} else {
			return 27;
		}
	}

	private static int maxSize(String[] v) {
		int maxValue = v[0].length();

		for (int i = 1; i < v.length; i++) {
			if (maxValue < v[i].length()) {
				maxValue = v[i].length();
			}
		}
		return maxValue;
	}

	public static void printStringArray(String[] arrToPrint) {
		for (int i = 0; i < arrToPrint.length; i++) {
			System.out.print(arrToPrint[i] + " ");
		}
		System.out.println();
	}

	/**
	 * @param args Array of strings (set of words) to be sorted (ordered) - Must be
	 *             passed as parameters
	 */
	public static void main(String[] args) {
		System.out.print("Input: ");
		printStringArray(args);
		radixSort(args);
		System.out.print("\nOutput: ");
		printStringArray(args);
	}
}
