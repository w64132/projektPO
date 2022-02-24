/** Autor Erwin Kulig w64132 */

package pl.erwin;
import java.sql.SQLOutput;
import java.util.Scanner;

public class AplikacjaBankowa {

    public static void main(String[] args) {

    BankAccount obj1 = new BankAccount("XYZ","CA0001");
    obj1.showMenu();


    }
}
//* Klasa BankAccount*/
class BankAccount
{
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) //cname -imie klietna cid - ID klienta
    {
customerName = cname;
customerId = cid;
    }

    void deposit(int amount) //* Metoda deposit */
    {
        if(amount !=0)
        {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }
    void withdraw(int amount) //* metoda wyplac */
    {
        if(amount != 0)
        {
            balance = balance - amount;
            prevTransaction = -amount;
        }
    }

    void getPrevioustTransaction() //* metoda wybierająca poprzednią transakcję */
    {
        if(prevTransaction > 0)
        {
            System.out.println("Zdeponowane: "+ prevTransaction);
        }
        else if(prevTransaction < 0)
        {
            System.out.println("Wyplacone: "+Math.abs(prevTransaction));
        }
        else
        {
            System.out.println("Brak transakcji");
        }
    }
    //* metoda showMenu */
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj " + customerName);
        System.out.println("Twoje ID to: " + customerId);
        System.out.println("\n");
        System.out.println("A.Sprawdz saldo");
        System.out.println("B.Depozyt");
        System.out.println("C.Wyplac");
        System.out.println("D.Poprzednia transakcja");
        System.out.println("E.Wyjdz");
//* pętla do-While */
        do {
            System.out.println("==========================================");
            System.out.println("Wybierz opcje");
            System.out.println("==========================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");
//* instrukcja switch case */
            switch (option) {
                case 'A':
                    System.out.println("-------------------------------------");
                    System.out.println("Saldo = " + balance);
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("-------------------------------------");
                    System.out.println("Wpisz kwote do depozytu:");
                    System.out.println("-------------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("-------------------------------------");
                    System.out.println("Wpisz kwote ktora chcesz wyplacic");
                    System.out.println("-------------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("-------------------------------------");
                    getPrevioustTransaction();
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("**************************************");
                    break;

                default:
                    System.out.println("Zla opcja! Sprobuj ponownie");
            }
        } while (option != 'E');


    }
}
