package model.entities;

import java.security.SecureRandom;

public class Gerador {

    /**
     * Gera uma senha aleatória baseada nos parâmetros fornecidos.
     *
     * @param comprimento O comprimento da senha desejada.
     * @param contemMaiusculas Indica se a senha deve conter letras maiúsculas (1 para sim, 0 para não).
     * @param contemEspeciais Indica se a senha deve conter caracteres especiais (1 para sim, 0 para não).
     * @param contemNumeros Indica se a senha deve conter números (1 para sim, 0 para não).
     * @return A senha gerada.
     */

    public String gerarSenha(int comprimento, int contemMaiusculas, int contemEspeciais, int contemNumeros) {
        String letrasMaiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresEspeciais = "!@#$%^&*()-_=+";
        String numeros = "123456789";
        int qtdadeInicial = 0;

        StringBuilder formatoGeral = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        StringBuilder senha = new StringBuilder(comprimento);
        SecureRandom random = new SecureRandom();

        if (contemMaiusculas > 0) {
            qtdadeInicial++;
            senha.append(letrasMaiusculas.charAt(random.nextInt(letrasMaiusculas.length())));
            formatoGeral.append(letrasMaiusculas);
        }

        if (contemEspeciais > 0) {
            qtdadeInicial++;
            senha.append(caracteresEspeciais.charAt(random.nextInt(caracteresEspeciais.length())));
            formatoGeral.append(caracteresEspeciais);
        }

        if (contemNumeros > 0) {
            qtdadeInicial++;
            senha.append(numeros.charAt(random.nextInt(numeros.length())));
            formatoGeral.append(numeros);
        }

        for (int i = qtdadeInicial; i < comprimento; i++) {
            senha.append(formatoGeral.charAt(random.nextInt(formatoGeral.length())));
        }

        String senhaFinal = senha.toString();

        return senhaFinal;

    }
}
