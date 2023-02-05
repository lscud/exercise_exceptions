package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Infore os dados da conta: ");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine(); //massete para consumir o enter que foi dado no nextInt acima. Esse enter fica no buffer por isso precisamos consumi-lo com esse comando antes de dar nestLine();
		String name = sc.nextLine();
		System.out.print("Saldo Inicial: ");
		double balance = sc.nextDouble();
		System.out.print("Limite de Saque: ");
		double limit = sc.nextDouble();
		
		Account acc = new Account(number, name, balance, limit);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		
		try {	//tentar executar a função  acc.withdraw(amount) porém se ela lançar uma exceção eu osso capturar esta exceção com catch
			acc.withdraw(amount);
			System.out.printf("Novo salto: %.2f%n", acc.getBalance());
		}
		catch (BusinessException e) { //ou seja com catch estamos tratando essa exceção
			//quando eu capturar a exceção (lembrando que quando instanciei a BusinessException dentro da classe Account eu passei uma função de erro) nessa variavel e teremos a mensagem de erro.
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
