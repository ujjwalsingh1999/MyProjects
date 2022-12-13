package miniProject;

public interface AtmMechanism {
	//select from tbl 
	void toDeposite();
	void toWithdraw();
	void toViewAccBalance();
	void toViewAccDtls();
	void toTransferMoney();
	void toChangePin();
	void toReturnMainMenu();
}
