package mvc.view;

import java.util.Scanner;
import mvc.controller.ProfileController;

public class MenuView {

    private Scanner sc = new Scanner(System.in);
    private ProfileController controller = new ProfileController();

    public void printMenu() {

        while(true) {
        	System.out.println("============================================");
            System.out.println("1. 프로필 저장   2. 프로필 불러오기   3. 종료");
            System.out.println("============================================");
            System.out.print("메뉴선택 > ");

            String input = sc.nextLine();
            int menu = Integer.parseInt(input);

            switch(menu) {

                case 1:
                    save();
                    break;

                case 2:
                    load();
                    break;

                case 3:
                    System.out.println("프로그램 종료");
                    return;
            }
        }
    }

    private void save() {

        System.out.print("이름> ");
        String name = sc.nextLine();

        System.out.print("몸무게> ");
        String weight = sc.nextLine();

        System.out.print("비밀번호> ");
        String pw = sc.nextLine();

        controller.save(name, weight, pw);
    }

    private void load() {

        System.out.print("이름> ");
        String name = sc.nextLine();

        controller.load(name);
    }
}
