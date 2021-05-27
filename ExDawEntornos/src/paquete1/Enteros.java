package paquete1;

/**
 * Esta clase permite realizar distintas acciones y operaciones con números enteros y cadenas.
 */
public class Enteros {
	/**
	 * Permite calcular el factorial de un número entero haciendo <i>self reference</i> (llamándose a sí mismo).
	 * @param n Un número entero.
	 * @return El factorial de n.
	 * */
public static int r_factorial(int n) {
		int resultado;

		if (n == 0) {
			resultado = 1;
		} else {
			resultado = n * r_factorial(n - 1);
		}
		return resultado;
}
/**
 * Permite calcular el factorial de un número entero utilizando un blucle for.
 * @param n Un número entero.
 * @return El factorial de n.
 * */
public static int factorial(int n) {
		int resultado;

		resultado = 1;
		for (int i = 2; i <= n; i++) {
			resultado = resultado * i;
		}
		return resultado;
}
/**
 * Permite mostrar la entrada del usuario en orden inverso.
 * @param cadena Una cadena de caracteres.
 * @return La cadena de caracteres en orden inverso al introducido.
 * */
public static String alreves(String cadena) {
		String resultado = "";

		for (int i = cadena.length() - 1; i >= 0; i--) {
			resultado = resultado + cadena.charAt(i);
		}
		return resultado;
}
/**
 * Indica al usuario si el número introducido es capicua.
 * @param n Un número entero.
 * @return Verdadero si es capicua, Falso si no lo es.
 * */
public static boolean capicua(int n) {
		boolean resultado;
		String cadena;

		cadena = Integer.toString(n);
		if (cadena.equals(alreves(cadena))) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;
}
/**
 * Comprueba si un entero es divisible por otro entero, viendo si el resto de la división es cero.
 * @param multiplo El número a dividir.
 * @param divisor El número por el que se dividirá el múltiplo.
 * @return Verdadero si múltiplo es divisible por divisor, Falso de otro modo.
 * @throws ArithmeticException Si el divisor es 0.
 * */
public static boolean divisible(int multiplo, int divisor) {
		boolean resultado;

		if (multiplo % divisor == 0) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;
}
/**
 * Comprueba si un núero es múltiplo de otro.
 * @deprecated Este método ha sido reemplazado por el método <b>divisible(int, int)</b>
 * @param mult Número a comprobar si es múltiplo.
 * @param divisor Número del cual queremos saber múltiplo
 * @return Verdadero si múltiplo es divisible por divisor, Falso de otro modo.
 * */
public static boolean multiplo(int mult, int divisor) {
		boolean resultado;

		try {
			if (mult % divisor == 0) {
				resultado = true;
			} else {
				resultado = false;
			}
		} catch (ArithmeticException e) {
			resultado = false;
		}
		return resultado;
}

/**
 * Comprueba si un número entero es primo haciendo uso del método <b>divisible(int, int)</b>
 * @param n Un número entero.
 * @return True si es primo, Flase si no lo es.
 * */
public static boolean esPrimo(int n) {
		boolean primo;

		if (n <= 1) {
			primo = false;
		} else {
			primo = true;
			int i = 2;
			while (primo && i <= n / 2) {
				if (divisible(n, i)) {
					primo = false;
				} else {
					i++;
				}
			}
		}
		return primo;
}
	/**
	 * Suma todos los números primos hasta cierto valor indicado.
	 * @param n Un número entero.
	 * @return La suma de todos los primos hasta n.
	 * */
public static int n_primos(int n) {
		int resultado = 0;

		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado++;
			}
		}
		return resultado;
}
/**
 * Proporciona un array de números enteros primos que hay entre 0 y la suma de todos los primos que existen hasta el valor proporcionado por el usuario, haciendo uso de <b>n_primos(int)</b>
 * @param n Un número entero.
 * @return Un array con todos los enteros primos hasta la suma de los primos de 0 a n.
 * */
public static int[] primosHasta(int n) {
		int[] resultado;

		resultado = new int[n_primos(n)];
		int cont = 0;
		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
		}

		return resultado;
}
/**
 * Proporciona un array con todos los números primos entre 0 y el valor proporcionado, comprobando cada número si es primo con el método <b>esPrimo(int)</b>
 * @param n Un número entero.
 * @return Un array con todos los primos entre 0 y n.
 * */
public static int[] primerosPrimos(int n) {
		int[] resultado = new int[(n < 0) ? 0 : n];

		int cont = 0;
		int i = 2;
		while (cont < n) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
			i++;
		}

		return resultado;
	}
}
