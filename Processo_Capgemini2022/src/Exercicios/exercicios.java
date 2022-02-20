package Exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class exercicios {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// O programa vai executar um comando Switch Case para o usuário decidir qual
		// questão quer resolver //

		System.out.println(
				"Escolha qual exercícios você quer resolver. \n Exercicio01 - Escada de caracter. \n Exercicio02 - Validar senha. \n Exercicio03 - Anagrama de palavras.");
		int num = sc.nextInt();

		switch (num) {

		// Exercicio 01
		case 1:
			System.out.println("Você escolheu 1");

			List<String> degraus = new ArrayList<>();

			System.out.print("Digite a quantidade de vezes: ");
			int qtdDegraus = sc.nextInt();

			for (int i = 0; i < qtdDegraus; i++) {
				degraus.add(" ".repeat(qtdDegraus - i) + "*".repeat(i + 1));
			}

			for (String d : degraus) {
				System.out.println(d);
			}
			break;

		// Exercicio 02
		case 2:
			System.out.println("Você escolheu 2");
			System.out.println(
					"Escreva a senha: \n A senha deve conter no mínimo 6 caracteres;\n A senha deve conter no mínimo 1 digito;\n A senha deve conter no mínimo 1 letra minuscula;\n A senha deve conter no mínimo uma letra maiuscula;\n A senha deve conter no mínimo um caracter especial (!@#$%^&*-+)");
			String senha = sc.next();
			int tamanho = senha.length();

			if (tamanho < 6) {
				System.out.println("insira mais " + (6 - tamanho) + " caracteres para ter uma senha segura");
			} else {
				System.out.println("a senha é segura");
			}
			break;

		// Exercicio 03
		case 3:
			String palavra = "";

			System.out.println("Você escolheu 2");
			System.out.println("Digite a palavra que deseja verificar: \n");
			palavra = sc.next();

			// chama um método para contar os anagramas que criaremos fora da main
			contagem_palavra(palavra);
			break;
		default:
			System.out.println("Número inválido");
		}
	}

	private static void contagem_palavra(String palavra) {

		// HashMap para guardar os elementos e manipular com mais facilidade
		HashMap<String, Integer> lista = new HashMap<>();

		// o valor y percorre sempre que valor x finalizar de percorrer e
		// o limite de ambos é o tamanho da palavra
		for (int y = 0; y <= palavra.length(); y++) {
			for (int x = y; x < palavra.length(); x++) {

				// char[] guarda as sub-arrays, contando +1 no tamanho até chegar ao limite da
				// palavra
				char[] palavraArray = palavra.substring(y, x + 1).toCharArray();
				Arrays.sort(palavraArray); // sort() para trocar as posições dos elementos
				String pseudoP = new String(palavraArray); // string pseudoP recebe valor de todo o conjunto do array
															// palavraArray
				if (lista.containsKey(pseudoP)) {
					lista.put(pseudoP, lista.get(pseudoP) + 1);
				} else {
					lista.put(pseudoP, 1);
				}
			}
		}

		// contador para mostrar a quantidade de anagramas
		int contagemP = 0;
		for (String cont : lista.keySet()) {
			int z = lista.get(cont);
			contagemP += ((z - 1) * z) / 2;
		}
		System.out.print("Quantidade de pares que são anagramas é de " + contagemP);
	}

}
