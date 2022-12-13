package miniProject;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.System;

public class CreateUser extends MainMenuCls {
	Scanner sc = new Scanner(System.in);
	static long accNum;
	int pin;
	static String accHolder,accType,userID;
	static CreateUser usrObj = new CreateUser();
	HashMap<String, Integer> AtmHolders = new HashMap<String, Integer>();
	void CreateUserFun(char Y) {
		System.out.println("enter your account holder name");
		sc.skip("\\R?");
		accHolder = sc.nextLine();
		System.out.println("Choose a user ID");
		sc.skip("\\R?");
		userID = sc.nextLine().trim();
		//System.out.println(userID);
		System.out.println("Create your ATM Pin");
		sc.skip("\\R?");
		pin = sc.nextInt(); 
		System.out.println("select an account type: ");
		System.out.println("1: Savings"+'\n'+"2: Current");
		byte in = sc.nextByte();
		switch (in){
		case 1:
			accType = "Savings".toUpperCase();
			break;
		case 2:
			accType = "current".toUpperCase();
			break;
		default:
			System.out.println("Invalid type!!");
		}
		//sc.nextLine();
		System.out.println("Congratulations.. you have been registered!!");
		addUser();
		System.out.println("Press L to Login");
		char input = sc.next().charAt(0);
		LoginUser(input);
	}
	void addUser() {
		//AtmHolders.put (userID, pin);
		// insert qry + conn obj
		//System.out.println("Congratulations.. you have been added");
		accNum =  (long)Math.floor(Math.random()*10000000000L);
		System.out.println("your account number is: "+ accNum);

	}

	void LoginUser(char N) {
		System.out.println("enter your userID...");
		userID = sc.next();
		System.out.println("Enter your Pin...");
		pin = sc.nextInt();
		boolean verify = CheckUsrExist();
		if (verify== true) {
			System.out.println("Login Successful..");
			System.out.println("WELCOME " + userID.toUpperCase());
			System.out.println("Press 1 to enter main menu!!");
			short a = sc.nextShort();
			if(a == 1) {
				usrObj.mainMenu(a);
			}
		}
		else {
			System.out.println("User Not found!!");
			System.out.println("Press 1 to go to registration page or press Y to Login Again");
			Scanner sc = new Scanner(System.in);
			char y = sc.next().charAt(0);
			if(y == '1') {
				CreateUserFun(y);
			} else if(y == 'y') {
				LoginUser(y);
				System.exit(0);
			}
			else {
				System.out.println("Invalid Input");
			}
		}
	}

	boolean CheckUsrExist(){

		//select from tbl with where clause <---
		/*for (Map.Entry<String,Integer> mapElement : AtmHolders.entrySet()) {
		 * 
		 * 
		 * 
		 * if(AtmHolders.containsKey(userID) && AtmHolders.containsValue(pin)) {
				return true;
				}
			}
			return false;
		 * 
		 * 
		 * 
		 */
		return false;
	}
	@Override
	public void toDeposite() {
		System.out.println("enter amount to deposite");
		int depositeAmt = sc.nextInt();
		bankBalance += depositeAmt;
		System.out.println("your new acc balance is: "  + bankBalance);
		usrObj.toReturnMainMenu();
	}
	@Override
	public void toWithdraw() {
		// TODO Auto-generated method stub
		System.out.println("Enter amount in multiples of 100, 200, 500 or 2000");
		//System.out.println("enter amount to withdraw");
		sc.skip("\\R?");
		withdrawlAmt = sc.nextInt();
		if(withdrawlAmt > bankBalance ) {
			System.out.println("you have insufficient funds...");
			usrObj.toReturnMainMenu();
			System.exit(0);
		} else {
			if(withdrawlAmt%100 == 0 || withdrawlAmt%200 == 0 || withdrawlAmt%500 == 0 || withdrawlAmt%2000 == 0) {
				bankBalance -= withdrawlAmt;
				System.out.println(withdrawlAmt+" has been debited from your account "+"your new Account Balance is "+bankBalance);
				usrObj.toReturnMainMenu();	
			}
			else {
				System.out.println("Invalid Denominations...Enter amount in multiples of 100, 200, 500 or 2000");
				usrObj.toWithdraw();
			}
		}
	}
	@Override
	public void toViewAccBalance() {
		// TODO Auto-generated method stub
		System.out.println("Your account balance is: "+bankBalance);
		usrObj.toReturnMainMenu();
	}
	@Override
	public void toViewAccDtls() {
		// TODO Auto-generated method stub
		System.out.println("Your Account Number is: " + accNum);
		System.out.println("Account Holder is: " + accHolder);
		System.out.println("Your Account Balance is: " + bankBalance);
		System.out.println("Your Bank Name is: " + bankName);
		System.out.println("Your Account Type is: " + accType + " Account");
		usrObj.toReturnMainMenu();
	}
	@Override
	public void toTransferMoney() {
		// TODO Auto-generated method stub
		System.out.println("enter benificiary account number: ");
		long beneficiaryAccnt = sc.nextLong();
		System.out.println("enter amount to be tranferred: ");
		int amntToBeTransferred = sc.nextInt();
		if (amntToBeTransferred > bankBalance) {
			System.out.println("Process Failed.. Insufficient Funds");
			usrObj.toReturnMainMenu();
			System.exit(0);
		} else {
			bankBalance -= amntToBeTransferred;
			System.out.println("Amount "+amntToBeTransferred + "Transferred Successfully to "+beneficiaryAccnt);
			System.out.println("Your account balance is: " + bankBalance);
			usrObj.toReturnMainMenu();
			System.exit(0);
		}

	}
	@Override
	public void toChangePin() {
		// TODO Auto-generated method stub
		System.out.println("enter your new pin");
		int updatedPin = sc.nextInt();
		AtmHolders.put(userID, updatedPin);
		for (Map.Entry<String,Integer> mapElement : AtmHolders.entrySet()) {
			System.out.println("your updated pin for User ID "+mapElement.getKey()+" is: "+mapElement.getValue());
			usrObj.toReturnMainMenu();
			System.exit(0);
		}
	}
	public void toReturnMainMenu() {
		System.out.println("Press 1 to return to main menu");
		short a = sc.nextShort();
		if(a == 1) {
			usrObj.mainMenu(a);
		}
		System.out.println("Invalid Input!!");
		System.exit(0);
	}
}
