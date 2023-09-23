package Bibliotecas;

import java.util.Scanner;

/**
 * A classe Coletar fornece métodos para coletar entradas do usuário a partir do console,
 * incluindo números inteiros, números de ponto flutuante e strings.
 * Ela oferece validação de entrada para garantir que os valores informados estejam dentro de
 * intervalos específicos (quando aplicável) e trata exceções de entrada inválida.
 */
public abstract class Coletar {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Coleta um número inteiro do usuário com um valor mínimo e máximo permitido.
     *
     * @param mensagem_de_exibicao A mensagem exibida ao usuário para solicitar a entrada.
     * @param valorMin O valor mínimo permitido.
     * @param valorMax O valor máximo permitido.
     * @return O número inteiro coletado.
     */
    public static int coletarInt(String mensagem_de_exibicao, int valorMin, int valorMax) {
        Scanner sc = new Scanner(System.in);
        int numInteiro;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            if (sc.hasNextInt()) {
                numInteiro = sc.nextInt(); sc.nextLine();
                if (numInteiro >= valorMin && numInteiro <= valorMax) {
                    return numInteiro;
                } else {
                    System.out.println("Erro! O valor deve estar entre " + valorMin + " e " + valorMax + ". Tente novamente.");
                }
            } else {
                System.out.printf("Erro! Entrada inválida. Digite um número inteiro entre %d e %d.", valorMin, valorMax);
                sc.nextLine();
            }
        }
    }

    /**
     * Coleta um número inteiro do usuário com um valor mínimo permitido.
     *
     * @param mensagem_de_exibicao A mensagem exibida ao usuário para solicitar a entrada.
     * @param valorMin O valor mínimo permitido.
     * @return O número inteiro coletado.
     */
    public static int coletarInt(String mensagem_de_exibicao, int valorMin) {
        Scanner sc = new Scanner(System.in);
        int numInteiro;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            if (sc.hasNextInt()) {
                numInteiro = sc.nextInt(); sc.nextLine();
                if (numInteiro >= valorMin) {
                    return numInteiro;
                } else {
                    System.out.printf("Erro! O valor deve ser maior ou igual a %d. Tente novamente.\n", valorMin);
                }
            } else {
                System.out.printf("Erro! Entrada inválida. Digite um número maior ou igual a %d.\n", valorMin);
                sc.nextLine();
            }
        }
    }

    /**
     * Coleta um número inteiro do usuário.
     *
     * @param mensagem_de_exibicao A mensagem exibida ao usuário para solicitar a entrada.
     * @return O número inteiro coletado.
     */
    public static int coletarInt(String mensagem_de_exibicao) {
        Scanner sc = new Scanner(System.in);
        int numInteiro;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            if (sc.hasNextInt()) {
                numInteiro = sc.nextInt(); sc.nextLine();
                return numInteiro;
            } else {
                System.out.println("Erro! Entrada inválida. Digite um número inteiro.");
                sc.nextLine();
            }
        }
    }

    /**
     * Coleta um número de ponto flutuante do usuário com um valor mínimo e máximo permitido.
     *
     * @param mensagem_de_exibicao A mensagem exibida ao usuário para solicitar a entrada.
     * @param valorMin O valor mínimo permitido.
     * @param valorMax O valor máximo permitido.
     * @return O número de ponto flutuante coletado.
     */
    public static double coletarDouble(String mensagem_de_exibicao, double valorMin, double valorMax) {
        Scanner sc = new Scanner(System.in);
        double valor;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            String input = sc.nextLine().replace(",", ".");

            try {
                valor = Double.parseDouble(input);
                if (valor >= valorMin && valor <= valorMax) {
                    return valor;
                } else {
                    System.out.printf("Erro! O valor deve estar entre %f e %f. Tente novamente.\n", valorMin, valorMax);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Erro! Entrada inválida. Digite um número entre %f e %f.", valorMin, valorMax);
            }
        }
    }

    /**
     * Coleta um número de ponto flutuante do usuário com um valor mínimo permitido.
     *
     * @param mensagem_de_exibicao A mensagem exibida ao usuário para solicitar a entrada.
     * @param valorMin O valor mínimo permitido.
     * @return O número de ponto flutuante coletado.
     */
    public static double coletarDouble(String mensagem_de_exibicao, double valorMin) {
        Scanner sc = new Scanner(System.in);
        double valor;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            String input = sc.nextLine().replace(",", ".");

            try {
                valor = Double.parseDouble(input);
                if (valor >= valorMin) {
                    return valor;
                } else {
                    System.out.printf("Erro! O valor deve ser maior ou igual a %f. Tente novamente.\n", valorMin);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Erro! Entrada inválida. Digite um número maior ou igual a %f.\n", valorMin);
            }
        }
    }

    /**
     * Coleta um número de ponto flutuante do usuário.
     *
     * @param mensagem_de_exibicao A mensagem exibida ao usuário para solicitar a entrada.
     * @return O número de ponto flutuante coletado.
     */
    public static double coletarDouble(String mensagem_de_exibicao) {
        Scanner sc = new Scanner(System.in);
        double valor;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            String input = sc.nextLine().replace(",", ".");

            try {
                valor = Double.parseDouble(input);
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Erro! Entrada inválida. Digite um número.\n");
            }
        }
    }

    /**
     * Coleta uma string do usuário.
     *
     * @param mensagem_de_exibicao A mensagem exibida ao usuário para solicitar a entrada.
     * @return A string coletada.
     */
    public static String coletarString(String mensagem_de_exibicao){
        Scanner sc = new Scanner(System.in);
        String string;

        while (true) {
            System.out.println(mensagem_de_exibicao);
            string = sc.nextLine().trim();
            if (string.isEmpty()){
                System.out.println("Tente novamente. A entrada não pode ser vazia.");
            } else {
                return string;
            }
        }
    }

    public static void fecharScanner(){
        sc.close();
    }
}
