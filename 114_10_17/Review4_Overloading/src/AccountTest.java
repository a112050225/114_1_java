public class AccountTest {
    public static void main(String[] args){

        System.out.printf("帳號號碼：%s%n初始餘額:%.2f%n" , account1.getAccountNumber(),account1.getBalance());
        System.out.printf("帳號號碼：%s%n初始餘額:%.2f%n" , account2.getAccountNumber(),account1.getBalance());

        account1.deposit(account:500.0);
        System.out.printf("帳號號碼：%s%n存款後餘額:%.2f%n" , account1.getAccountNumber(),account1.getBalance());
        System.out.printf("帳號號碼：%s%n初始餘額:%.2f%n" , account2.getAccountNumber(),account1.getBalance());

        account1.withdraw(account:1000.0);
        System.out.printf("帳號號碼：%s%n提款後餘額:%.2f%n" , account1.getAccountNumber(),account1.getBalance());
        System.out.printf("帳號號碼：%s%n初始餘額:%.2f%n" , account2.getAccountNumber(),account1.getBalance());

        //測試非法提款
        try {
            account1.deposit(-100.0);
            system.out.printf("帳號號碼：%s%n提款後餘額:%.2f%n" , account1.getAccountNumber(),account1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account1.withdraw(2000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account1.deposit(100.0,currency:"USD");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }


}

