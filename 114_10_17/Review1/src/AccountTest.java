public class AccountTest {
    public static void main(String[] args){

        Account account1 = new Account(accountNumber: "A123" , initialbalance:1000.0);//一定要透過get讀取，如果get是私有的話就不能讀取
        Account account2 = new Account(accountNumber: "A123" , initialbalance:-2000.0);//一定要透過get讀取，如果get是私有的話就不能讀取

//        system.out.println(account1.getAccountNumber());
//        system.out.println(account1.getBalance());
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
            account1.withdraw(2000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account1.deposit(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            account1.deposit(100.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }


}
