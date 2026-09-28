package org.example;

public class DocumentoValidator {
    public boolean validarCpf(String cpf) {

        cpf = normalizar(cpf);

        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        // Impede CPFs como 111.111.111-11
        if (todosDigitosIguais(cpf)) {
            return false;
        }

        // Primeiro dígito verificador
        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int primeiroDigito = 11 - (soma % 11);

        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }

        // Segundo dígito verificador
        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        int segundoDigito = 11 - (soma % 11);

        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        return primeiroDigito ==
                Character.getNumericValue(cpf.charAt(9))
                &&
                segundoDigito ==
                        Character.getNumericValue(cpf.charAt(10));
    }


    public boolean validarCnpj(String cnpj) {

        cnpj = normalizar(cnpj);

        if (cnpj == null || cnpj.length() != 14) {
            return false;
        }

        // Impede CNPJs como 11111111111111
        if (todosDigitosIguais(cnpj)) {
            return false;
        }

        int[] pesosPrimeiroDigito =
                {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;

        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i))
                    * pesosPrimeiroDigito[i];
        }

        int primeiroDigito = 11 - (soma % 11);

        if (primeiroDigito >= 10) {
            primeiroDigito = 0;
        }


        int[] pesosSegundoDigito =
                {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        soma = 0;

        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i))
                    * pesosSegundoDigito[i];
        }

        int segundoDigito = 11 - (soma % 11);

        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }

        return primeiroDigito ==
                Character.getNumericValue(cnpj.charAt(12))
                &&
                segundoDigito ==
                        Character.getNumericValue(cnpj.charAt(13));
    }


    private boolean todosDigitosIguais(String documento) {

        char primeiro = documento.charAt(0);

        for (int i = 1; i < documento.length(); i++) {

            if (documento.charAt(i) != primeiro) {
                return false;
            }
        }

        return true;
    }


    private String normalizar(String documento) {

        if (documento == null) {
            return null;
        }

        // CPF: 529.982.247-25 e CNPJ: 11.222.333/0001-81
        if (!documento.matches("[0-9./\\s-]+")) {
            return null;
        }

        return documento.replaceAll("\\D", "");
    }
}
