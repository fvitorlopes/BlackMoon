package siop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorAleatorio {

	// gerador de cpf
	private static Long generate(Random random) {
		int[] digits = generateArray(random, 11, 9);
		// First digit
		int total = 0;
		for (int i = 1, j = 10; i <= 9; i++, j--)
			total += digits[i - 1] * j;
		int rest = total % 11;
		if (rest < 2)
			digits[9] = 0;
		else
			digits[9] = 11 - rest;
		total = 0;
		for (int i = 1, j = 11; i <= 10; i++, j--)
			total += digits[i - 1] * j;
		rest = total % 11;
		if (rest < 2)
			digits[10] = 0;
		else
			digits[10] = 11 - rest;
		return arrayToLong(digits);
	}

	private static Long generateRandom() {
		return generate(new Random());
	}

	@SuppressWarnings("unused")
	private static Long generate(long seed) {
		return generate(new Random(seed));
	}

	private static String format(Long cpf) {
		String str = cpf.toString();
		if (str.length() < 11)
			for (int i = str.length(); i < 11; i++)
				str = "0" + str;
		return str.substring(0, 3) + "." + str.substring(3, 6) + "."
				+ str.substring(6, 9) + "-" + str.substring(9);
	}

	public static String gerarCpf() {
		return format(generateRandom());
	}

	private static int[] generateArray(Random random, int length,
			int quantityOfZeros) {
		if (quantityOfZeros > length)
			throw new IllegalArgumentException(
					"quantityOfZeros must be less or equal than length.");
		if (length <= 0)
			throw new IllegalArgumentException(
					"length must be bigger than zero.");
		int[] digits = new int[length];
		int i;
		for (i = 0; i < quantityOfZeros; i++)
			digits[i] = random.nextInt(10);
		if (i < length)
			digits[i++] = 1 + random.nextInt(9); // != 0
		for (; i < length; i++)
			digits[i] = random.nextInt(10);
		return digits;
	}

	@SuppressWarnings("unused")
	private static int[] generateArray(long seed, int length,
			int quantityOfZeros) {
		return generateArray(new Random(seed), length, quantityOfZeros);
	}

	private static int[] generateRandomArray(int length, int quantityOfZeros) {
		return generateArray(new Random(), length, quantityOfZeros);
	}

	private static int generateRandom(int maxLength) {
		long l = arrayToLong(generateRandomArray(maxLength, maxLength));
		if (l > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) l;
	}

	@SuppressWarnings("unused")
	private static int generateRandomForce(int length) {
		long l = arrayToLong(generateRandomArray(length, 0));
		if (l > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) l;
	}

	@SuppressWarnings("unused")
	private static int[] longToArray(final long number) {
		long n = number;
		List<Long> list = new ArrayList<Long>(10);
		do {
			list.add(n % 10);
			n /= 10;
		} while (n != 0);
		int length = list.size();
		int[] digits = new int[length];
		for (int i = length - 1, j = 0; i >= 0; i--, j++)
			digits[j] = list.get(i).intValue();
		return digits;
	}

	private static long arrayToLong(final int[] digits) {
		long result = 0;
		long pot = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			long partial = digits[i] * pot;
			if (Long.MAX_VALUE - result - partial > 0) {
				result += partial;
			} else
				return Long.MAX_VALUE;
			pot *= 10;
		}
		return result;
	}

	public static String gerarTelefone() {
		String telefoneFormatado = "";
		String telefone = "" + generateRandom(10);
		for (int i = 0; i < telefone.length(); i++) {
			if (i == 0) {
				telefoneFormatado += "(" + telefone.charAt(i);
			} else if (i == 2) {
				telefoneFormatado += ")" + telefone.charAt(i);
			} else if (i == 6) {
				telefoneFormatado += "-" + telefone.charAt(i);
			} else {
				telefoneFormatado += "" + telefone.charAt(i);
			}
		}
		return telefoneFormatado;
	}
}
