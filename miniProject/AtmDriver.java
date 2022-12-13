package miniProject;
import java.util.Scanner;
public class AtmDriver extends CreateUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Press Y to register yourself to use this ATM Machine...");
		Scanner sc = new Scanner(System.in);
		char resp = sc.next().charAt(0) ; 
		AtmDriver DriverObj = new AtmDriver();
		if(resp == 'Y' || resp == 'y' ) {
			DriverObj.CreateUserFun(resp);	
			DriverObj.addUser();
			System.out.println("Congratulations!! You may log in.. "+" Press Y to Continue..");
			char y = sc.next().charAt(0) ;
			if (y == 'y') {
				DriverObj.LoginUser(y);	
			}
			else {
				System.out.println(" Invalid Input");
				System.exit(0);
			}
		} 
		else{
			System.out.println(" Invalid Input");
			System.exit(0);
		}


	}

}
