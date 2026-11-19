package funcoes;

import java.util.Scanner;

public class Leitura {

    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem, int minimo) {
        while (true) {
            System.out.print(mensagem);

            try {
                int numero = Integer.parseInt(scanner.nextLine());

                if (numero >= minimo) {
                    return numero;
                }

                System.out.println("\nNúmero abaixo do mínimo permitido!");

            } catch (NumberFormatException e) {
                System.out.println("\nDigite um número inteiro válido!");
            }
        }
    }

    public static void fechar() {
        scanner.close();
    }
}