
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Ваше Имя и ПинКод для доступа к банковскому аккаунту");
        String name = sc.nextLine();
        String customerId = sc.nextLine();

        BankAccount obj1 = new BankAccount(name, customerId);
        obj1.menu();

    }

}

class BankAccount {
    double balance;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if(amount !=0){
            balance+=amount;
            prevTrans = amount;
        }
    }

    void withdraw(double amt) {
        if(amt!=0 && balance>=amt) {
            balance -= amt;
            prevTrans = -amt;
        } else if (balance < amt) {
            System.out.println("Недостаточно средств");
        }
    }

    void getPreviousTrans(){
        if (prevTrans > 0){
            System.out.println("Внесено: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Снято: " + prevTrans);
        } else {
            System.out.println("Нет совершенных транзакций");
        }
    }

    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать " + customerName);
        System.out.println("ID");
        System.out.println("\n");
        System.out.println("1 - Проверить баланс");
        System.out.println("2 - Внести депозит");
        System.out.println("3 - Снять средства");
        System.out.println("4 - Предыдущая транзакция");
        System.out.println("5 - Выход");

        do{
            System.out.println("**********************");
            System.out.println("Выберите пункт");
            option = sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case '1':
                    System.out.println(".........");
                    System.out.println("Ваш баланс = " + balance);
                    System.out.println("\n");
                    break;
                case '2':
                    System.out.println(".........");
                    System.out.println("Введите сумму для внесения депозита: ");
                    double amt = sc.nextDouble();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                case '3':
                    System.out.println(".........");
                    System.out.println("Введите сумму для снятия средств: ");
                    System.out.println(".........");
                    double amtW = sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("\n");
                    break;
                case '4':
                    System.out.println(".........");
                    System.out.println("Предыдущая транзакция");
                    getPreviousTrans();
                    System.out.println(".........");
                    System.out.println("\n");
                    break;
        }

        } while (option!='5');
        System.out.println("Спасибо что воспользовались нашим банковским серивсом");
    }
}
