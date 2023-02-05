package entities;

import exceptions.BusinessException;

public class Account {
	
	private Integer number;
	private String holder;
	private double balance;
	private double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount); // se passar então ele realiza o saque. se nao passar sera lançada uma exceção e uma mensagem de erro aparecerá (quem lança essa exceção é a minha funçao customizada BusinessException 
		balance -= amount;
	}
	
	/*public void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new RuntimeException ("Erro de saque: A quantia excede o limite de saque"); // forma de lançar uma exceção é com throw (instanciar uma exceção)->new RuntimeException(exceção padrão) 
		}  //throw assim como o return corta o metodo
		if (amount > getBalance()) {  //posso até tirar o else pq o return ja corta a funçao
			throw new  RuntimeException ("Erro de saque: Saldo Insuficiente");
		}
	} */
	
	//Essa forma de cima é usando um recurso pronto com o RuntimeException. Porem podemos criar uma exceção customizada (BusinessException): 
	
	private void validateWithdraw(double amount) { //com private nao estara disponivel fora desta classe
		if (amount > getWithdrawLimit()) {
			throw new BusinessException ("Erro de saque: A quantia excede o limite de saque"); 
			}
		if (amount > getBalance()) {  
			throw new  BusinessException ("Erro de saque: Saldo Insuficiente");
		}
	}
	
	
	

}
