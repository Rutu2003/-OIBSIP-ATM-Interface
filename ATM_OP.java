import java.util.*;
import java.util.Scanner;	

public class ATM_OP
{
	public static void main(String[] args) 
	{

		int ch;
		long amount=0,deposit=0,withdraw=0;
		Scanner r = new Scanner(System.in);
		String transactionHistory="";
		int ID=4418;
		int pin=2003;
		 do{
		 	System.out.println("Enter your Id : ");
			ID = r.nextInt();
	
			System.out.println("Enter your Pin : ");
			pin = r.nextInt();

			if(ID != 4418 || pin!=2003)
			{
				System.out.println("Id or Password is Incorrect!");
			}
		 }while(ID != 4418 || pin!=2003);

		do
		{
			System.out.println("----------ATM Service-----------");
			System.out.println("\n 1.Transaction History.\n 2.Withdraw.\n 3. Deposit.\n 4. Transfer. \n 5. Quit.");
			
			System.out.println("\nEnter your choice : ");
			 ch = r.nextInt();
			switch(ch)
			{
				case 1:
					System.out.println("--------Transaction History-------\n");
					System.out.println("Transaction History is: \n" + transactionHistory);
					break;

				case 2:
					System.out.println("\nEnter the amount to withdraw : ");
					int b = r.nextInt();

					if(b % 100 != 0)
					{
						System.out.println("\nPlease Enter the amount in multiple of 100.");
					}
					else if(b > (amount - 1000))
					{
						System.out.println("\nInsufficent balance!");
					}
					else
					{
						amount = amount - b;
						System.out.println("\n\nPlease receive Your Cash.");
						System.out.println("Your current balance is : " + amount);
					}
					break;

				case 3:
					System.out.println("\nEnter the amount to Deposit : ");
					int c = r.nextInt();
					amount = amount + c;
					System.out.println("Your balance is : "+amount);
					break;

				case 4:
					System.out.println("---------Transfer to the account----------");
					{
						Scanner sc = new Scanner(System.in);
						System.out.print("\nEnter Receipent's Name : ");
						String receipent = sc.nextLine();
						System.out.print("\nEnter amount you wish to transfer : ");
						float amount1 = sc.nextFloat();
		
						try {
								if ( amount >= amount1 ) {
									if ( amount1 <= 150000f ) {
										amount -= amount1;
										System.out.println("\nSuccessfully Transfered to : " + receipent);
										String str = amount1 + " : Rs transfered to : " + receipent + "\n";
										transactionHistory = transactionHistory.concat(str);
									}
								else {
										System.out.println("\nINVALID TRANSFER...Limit is 150000.00 only");
									}
								}
								else {
										System.out.println("\nInsufficient Balance!");
									}
							}
						catch (Exception e) {
							System.out.println(e);
						}
					}
				case 5:
					System.out.println("Thank you for using ATM service.");
					break;

				default:
					System.out.println("Invalid choice");

			}	
		}while(ch!=5);
	}
}