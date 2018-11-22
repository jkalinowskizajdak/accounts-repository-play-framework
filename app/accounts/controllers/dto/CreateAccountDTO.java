package accounts.controllers.dto;

public class CreateAccountDTO {

    public String owner;
    public double balance;

    public CreateAccountDTO() {

    }

    public CreateAccountDTO(String pOwner, double pSingleWithdrawLimit, double pBalance) {
        owner = pOwner;
        balance = pBalance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

}
