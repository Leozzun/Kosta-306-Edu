package mvc.view;

public class StartView {

    public static void main(String[] args) {

        System.out.println("===== 프로그램 시작 =====");

        MenuView menu = new MenuView();
        menu.printMenu();
    }
}
