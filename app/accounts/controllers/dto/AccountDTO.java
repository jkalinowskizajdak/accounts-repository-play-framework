package accounts.controllers.dto;

public class AccountDTO {

    public String id;
    public String owner;
    public double balance;

    public AccountDTO() {

    }

    public AccountDTO(String pId, String pOwner, double pBalance) {
        owner = pOwner;
        balance = pBalance;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

}

