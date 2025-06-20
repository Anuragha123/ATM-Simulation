// import java.util.HashMap;
// import java.util.Map;
// import java.util.*;
// class Solution {
//     public String palindrome(String s) {
//         int st = 0;
//         int ed = s.length()-1;
//         while(st <= ed) {
//             if(s.charAt(st) != s.charAt(ed)) {
//                 return "Not a palindrome";
//             }
//             else{
//                 st++;
//                 ed--;
//             }
//         }
//         return "palindrome";
//     }
// }

// public class pattern{
//     public static void main(String[] args) {
//         Solution s = new Solution();
//         String str = "abba";
//        String res = s.palindrome(str);
//        System.out.println(res);
//     }
    
// }
import java.util.*;

public class ATM {
    static Scanner sc = new Scanner(System.in);
    static double balance = 10000.00;
    static List<String> miniStatement = new ArrayList<>();

    public static void main(String[] args) {
        int atmNumber = 12345;
        int pin = 123;

        System.out.print("Enter ATM Number: ");
        int enteredAtm = sc.nextInt();
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredAtm == atmNumber && enteredPin == pin) {
            menu();
        } else {
            System.out.println("Invalid ATM Number or PIN");
        }
    }

    public static void menu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Available Balance");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. View Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    viewMiniStatement();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    public static void checkBalance() {
        System.out.printf("Your current balance is: %.2f\n", balance);
        miniStatement.add("balances:"+balance);
    }

    public static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("%.2f withdrawn successfully.\n", amount);
            miniStatement.add("Withdraw: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("%.2f deposited successfully.\n", amount);
            miniStatement.add("Deposit: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public static void viewMiniStatement() {
        System.out.println("----- Mini Statement -----");
        if (miniStatement.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String entry : miniStatement) {
                System.out.println(entry);
            }
        }
    }
}
