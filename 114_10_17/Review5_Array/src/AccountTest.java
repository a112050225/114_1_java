public class AccountTest {
    private int customerCount;
    public static void main(String[] args) {
        Account[] customers = new Account[10];//儲存客戶帳戶的陣列
        Account acc1 = new Account("A001", ownerName:"Alice",initialBalance:1000.0);
        addCustomer(customers, acc1);
        Account acc2 = new Account("A002", 3000);
        addCustomer(customers, acc2);
        Account acc3 = new Account("A003", -100.0);
        addCustomer(customers, acc3);
        //java中全部都是call by value沒有call by reference，value一般變數傳送的就是一般值/參考變數就是參考值
        //印出客戶資訊
        System.out.println("\n所有客戶帳戶資訊:");
        printCustomersAccount(customers);

    }
    public static void addCustomer(Account[] customers, Account newAccount) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = newAccount;
                System.out.printf("已新增客戶帳戶：%s，餘額：%.2f%n", newAccount.getAccountNumber(), newAccount.getBalance());
                return;
            }
        }
        System.out.println("無法新增客戶，客戶數量已達上限");
    }
    public static void printCustomersInfo(Account[] customers,account newAccount) {

    }

}
