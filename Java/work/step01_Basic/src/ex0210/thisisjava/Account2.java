package ex0210.thisisjava;

public class Account2 {
	
	private int balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(0 <= balance && 1000000 >= balance) {
			this.balance = balance;
		}
	}

	public static void main(String[] args) {
		Account2 account = new Account2();
		
		account.setBalance(10000);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(-100);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(2000000);
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(300000);
		System.out.println("현재 잔고: " + account.getBalance());
	}
}
