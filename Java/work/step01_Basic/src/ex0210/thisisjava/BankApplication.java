package ex0210.thisisjava;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accountArray = new Account[100];
    private static int accountCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while(run) {
            System.out.println("-------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택> ");

            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    accountList();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    withdraw();
                    break;
                case "5":
                    System.out.println("프로그램 종료");
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private static void createAccount() {
        System.out.println("계좌생성");
        System.out.println("---------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("계좌주: ");
        String owner = scanner.nextLine();

        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(scanner.nextLine());

        Account newAccount = new Account(ano, owner, balance);
        accountArray[accountCount++] = newAccount;

        System.out.println("결과: 계좌가 생성되었습니다.");
    }

    private static void accountList() {
        System.out.println("계좌목록");
        System.out.println("---------");

        for (int i = 0; i < accountCount; i++) {
            Account acc = accountArray[i];
            System.out.printf("%s\t%s\t%d\n", acc.getAno(), acc.getOwner(), acc.getBalance());
        }
    }

    private static Account findAccount(String ano) {
        for (int i = 0; i < accountCount; i++) {
            if(accountArray[i].getAno().equals(ano)) {
                return accountArray[i];
            }
        }
        return null;
    }

    private static void deposit() {
        System.out.println("예금");
        System.out.println("---------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        Account account = findAccount(ano);

        if (account == null) {
            System.out.println("결과: 계좌가 없습니다.");
            return;
        }

        System.out.print("예금액: ");
        int amount = Integer.parseInt(scanner.nextLine());

        account.deposit(amount);

        System.out.printf("결과: 예금이 성공되었습니다. (예금액: %d)\n", amount);
    }

    private static void withdraw() {
        System.out.println("출금");
        System.out.println("---------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        Account account = findAccount(ano);

        if (account == null) {
            System.out.println("결과: 계좌가 없습니다.");
            return;
        }

        System.out.print("출금액: ");
        int amount = Integer.parseInt(scanner.nextLine());

        if(account.withdraw(amount)) {
            System.out.println("결과: 출금이 성공되었습니다.");
        } else {
            System.out.println("결과: 잔액이 부족합니다.");
        }
    }
}
