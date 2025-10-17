// 在Account 類別中示範deposit 方法的多載(複載)案例
import java.util.Scanner;

public class Account {

    /*public void setAccountNumber(String accountNumber)
    {this.accountNumber = accountNumber;}*/
    // 帳戶號碼
    private String accountNumber;
    // 帳戶餘額
    private double balance;
    /**
     * 帳戶建構子，初始化帳戶號碼與初始餘額
     * @param accountNumber 帳戶號碼
     * @param initialBalance 初始餘額
     */

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public Account() {
        this(accountNumber:"000000",initialBalance:0.0);

    }
    public Account(String accountNumber) {
        this(accountNumber,initialBalance:0.0);
    }
    /**
     * 取得帳戶號碼
     * @return 帳戶號碼
     */

    public String getAccountNumber() {
        return accountNumber;
    }
    /**
     * 取得帳戶餘額
     * @return 帳戶餘額
     */

    public double getBalance() {
        return balance;
    }

    /**
     * 設定帳戶餘額
     * @param balance 設定帳戶餘額，必須為正數
     * @throws IllegalArgumentException 若餘額非正數則拋出例外
     */
    public void setBalance(double balance) {
        Scanner scanner = new Scanner(System.in);
        double validBalance = balance;
        if (!(balance>0)){
            validBalance = getValidAccount(scanner,prompt:"請輸入正確的初始餘額:",Double x ->x>0,errorMsg:"帳號餘額必須是正數");
        }
        this.balance = validBalance;
    }
    /**
     * 設定帳戶號碼
     * @param accountNumber 帳戶號碼
     */

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    /**
     * 存款方法，將指定金額存入帳戶
     * @param amount 存款金額
     */
    public void deposit(double amount) {
        Scanner scanner = new Scanner(System.in);
        double validAmount = amount;
        if (!(amount <= 0)) {
            validAmount = getValidAccount(scanner,prompt:"請輸入正確的存款金額:",Double x ->x>0,errorMsg:"存款金額必須大於0");
            //throw new IllegalArgumentException("存款金額必須大於0");
        }
        balance += validAmount;
    }


    /**
     * 多載的存款方法，支援不同貨幣類型的存款
     * @param amount 存款金額
     * @param currency 貨幣類型 (例如: "TWD", "USD", "EUR", "JPY")
     */
    public void deposit(double amount, String currency) {
        double exchangeRate = 1.0;
        switch (currency.toUpperCase()){
            case "USD":
                exchangeRate =30.0;//假設1 USD = 30 TWD
                break;
            case "EUR":
                exchangeRate = 35.0;//假設1 EUR = 35 TWD
                break;
            case "JPY" :
                exchangeRate = 0.25; // 假設1 JPY = 0.25 TWD
                break;
            default:
                System.out.println("不支援的貨幣類型，請使用TWD、USD、EUR、JPY");
                return;
        }
        double accountInTWD = amount * exchangeRate;
        this.deposit(accountInTWD);
    }
    /**
     * 多載的存款方法，支援一次存入多個金額
     * @param accounts 多個存款金額
     */
    public void deposit(double...accounts){
        double total =0;
        for (double account:accounts){
            if (account>0){
                total += account;
            }else {
                throw new IllegalArgumentException("存款金額必須大於0,必須為正數");
            }
        }
        this.deposit(total);
    }
    //    public void withdraw(double amount) {
//        if (amount > balance) {
//            throw new IllegalArgumentException("餘額不足");
//        }
//        if (amount <= 0) {
//            throw new IllegalArgumentException("提款金額必須大於0");
//        }
//        balance -= amount;
//    }
}
