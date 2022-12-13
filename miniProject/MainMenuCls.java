package miniProject;
import java.util.Scanner;
public abstract class MainMenuCls implements AtmMechanism {
		int bankBalance=0;
		int withdrawlAmt=0;
		int depositeAmt=0;
		String bankName="Bank Of India";
	void mainMenu(short a) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a Banking Option");
		System.out.println("Press 1 for depositing:");
		System.out.println("Press 2 for withdrawl:");
		System.out.println("Press 3 to check account balance:");
		System.out.println("Press 4 to view account details:");
		System.out.println("Press 5 to transfer money:");
		System.out.println("Press 6 to change ATM pin:");
		byte option = sc.nextByte();
		switch (option) {
		case 1: 
			toDeposite();
			break;
		case 2:
			toWithdraw();
			break;
		case 3:
			toViewAccBalance();
			break;
		case 4:
			toViewAccDtls();
			break;
		case 5:
			toTransferMoney();
			break;
		case 6:
			toChangePin();
			break;
		default:
			System.out.println("Invalid Input!!");
			System.out.println("Press 1 to enter main menu");
			short b = sc.nextShort();
			if(b == 1 ) {
				mainMenu(b);
			}
			else {
				System.out.println("Invalid Input!!.. Program Terminated");
				System.exit(0);
			}
		}
	}
}
