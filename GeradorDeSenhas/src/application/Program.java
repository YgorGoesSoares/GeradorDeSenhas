package application;

import model.entities.Gerador;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contemMaiusculas = 0;
        int contemEspeciais = 0;
        int contemNumeros = 0;
        int comprimento = 0;
        String indice;

        System.out.println("Seja bem-vindo ao gerador de senhas!");

        do {
            try {
                System.out.print("Digite, em número inteiro, a quantidade de caracteres que deseja em sua senha (mínimo 4) == ");
                comprimento = sc.nextInt();
                sc.nextLine();

                if (comprimento < 4) {
                    System.out.println("Quantidade menor que a permitida. Digite a quantidade de caracteres, sabendo que o mínimo é 4.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                sc.nextLine();
            }
        } while (comprimento < 4);

        do {
            System.out.print("Deseja caracteres especiais em sua senha? (S/N) == ");
            indice = sc.nextLine();
        } while (!indice.equalsIgnoreCase("s") && !indice.equalsIgnoreCase("n"));

        if (indice.equalsIgnoreCase("s")) {
            contemEspeciais++;
        }

        do {
            System.out.print("Deseja letras maiúsculas em sua senha? (S/N) == ");
            indice = sc.nextLine();
        } while (!indice.equalsIgnoreCase("s") && !indice.equalsIgnoreCase("n"));

        if (indice.equalsIgnoreCase("s")) {
            contemMaiusculas++;
        }

        do {
            System.out.print("Deseja números em sua senha? (S/N) == ");
            indice = sc.nextLine();
        } while (!indice.equalsIgnoreCase("s") && !indice.equalsIgnoreCase("n"));

        if (indice.equalsIgnoreCase("s")) {
            contemNumeros++;
        }

        /**
         * Questiona o usuário sobre a inclusão de letras maiúsculas, caracteres especiais e números na senha.
         * Se a resposta for sim, as variáveis "contemMaiusculas", "contemEspeciais" e "contemNumeros" recebem o valor 1.
         * Essas variáveis são passadas como parâmetros para o método de geração de senha, onde valores 1 indicam a inclusão
         * dos respectivos tipos de caracteres na lista de possibilidades para a formatação da senha.
         */


        Gerador senha = new Gerador();
        System.out.println("SENHA GERADA: " + senha.gerarSenha(comprimento, contemMaiusculas, contemEspeciais, contemNumeros));

        sc.close();
    }
}
