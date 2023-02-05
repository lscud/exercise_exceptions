package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

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
		
		String error = acc.validateWithdraw(amount);
		if (error != null) {
			System.out.println(error);
		}
		else {	
			acc.withdraw(amount);
			System.out.printf("Novo salto: %.2f%n", acc.getBalance());
		}
		
		sc.close();
	}

}
