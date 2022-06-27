package fr.ben.oth.kata;

import fr.ben.oth.kata.entite.BankAccount;
import fr.ben.oth.kata.entite.BankClient;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws Exception {
        BankAccount account = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankClient client1 = new BankClient(1,"Othmane","Bentaleb", account);
        BankClient client2 = new BankClient(2,"TOTO","TATA", account2);

        try {
            client1 = client1.save(1, 500,1);
            client1.retrieve(1,500,1);
            client2 = client2.save(2,5555,1);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println(client1.showHistory(1));
            System.out.println("\n" + client2.showHistory(2));

        }

    }
}
