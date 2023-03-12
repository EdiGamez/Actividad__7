import java.math.BigInteger;
import java.util.Scanner;
public class Main {
            private static Scanner scanner = new Scanner(System.in);
            private static int cantidadNumeros = 0;

            public static void main(String[] args) {
                while (true) {
                    System.out.println("Seleccione la sucesión a calcular:");
                    System.out.println("1. Números primos");
                    System.out.println("2. Sucesión de Fibonacci");
                    System.out.println("3. Salir");
                    int opcion = scanner.nextInt();
                    if (opcion == 1) {
                        System.out.println("Ingrese la cantidad de números primos a calcular:");
                        cantidadNumeros = scanner.nextInt();
                        int[] primos = calcularNumerosPrimos(cantidadNumeros);
                        imprimirNumeros("Números primos", primos);
                    } else if (opcion == 2) {
                        System.out.println("Ingrese la cantidad de números de la sucesión de Fibonacci a calcular:");
                        cantidadNumeros = scanner.nextInt();
                        BigInteger[] fibonacci = calcularFibonacci(cantidadNumeros);
                        imprimirNumeros("Sucesión de Fibonacci", fibonacci);
                    } else if (opcion == 3) {
                        break;
                    } else {
                        System.out.println("Opción no válida, intente de nuevo.");
                    }
                }
                scanner.close();
            }

            public static int[] calcularNumerosPrimos(int cantidad) {
                int[] primos = new int[cantidad];
                int i = 2;
                int j = 0;
                while (j < cantidad) {
                    if (esPrimo(i)) {
                        primos[j] = i;
                        j++;
                    }
                    i++;
                }
                return primos;
            }

            public static boolean esPrimo(int n) {
                if (n <= 1) {
                    return false;
                }
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }

    public static BigInteger[] calcularFibonacci(int cantidad) {
        BigInteger[] fibonacci = new BigInteger[cantidad];
        fibonacci[0] = BigInteger.ZERO;
        if (cantidad > 1) {
            fibonacci[1] = BigInteger.ONE;
        }
        for (int i = 2; i < cantidad; i++) {
            fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
        }
        return fibonacci;
    }

    public static void imprimirNumeros(String nombre, BigInteger[] numeros) {
        System.out.println(nombre + ":");
        int tamano = (int)Math.ceil(Math.sqrt(cantidadNumeros));
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                int indice = i*tamano + j;
                if (indice < cantidadNumeros) {
                    System.out.printf(" %5d", numeros[indice]);
                }
            }
            System.out.println();

        }
        System.out.println("---------------------------------------------------------");
    }
    public static void imprimirNumeros(String nombre, int[] numeros) {
        System.out.println(nombre + ":");
        int tamano = (int)Math.ceil(Math.sqrt(cantidadNumeros));
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                int indice = i*tamano + j;
                if (indice < cantidadNumeros) {
                    System.out.printf("%5d", numeros[indice]);
                }
            }
            System.out.println();

        }
        System.out.println("---------------------------------------------------------");
    }
}
