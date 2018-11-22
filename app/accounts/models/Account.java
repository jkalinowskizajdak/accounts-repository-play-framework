package accounts.models;

import java.util.UUID;

public class Account {

    private final UUID id;
    private final String owner;
    private final double balance;

    private Account(Builder builder) {
        id = builder.id;
        owner = builder.owner;
        balance = builder.balance;
    }

    public UUID getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID id;
        private String owner;
        private double balance;

        public Builder copy(Account account) {
            id = account.id;
            owner = account.owner;
            balance = account.balance;
            return this;
        }

        public Builder id(UUID pId) {
            id = pId;
            return this;
        }

        public Builder generateId() {
            id = UUID.randomUUID();
            return this;
        }

        public Builder owner(String pOwner) {
            owner = pOwner;
            return this;
        }

        public Builder balacne(double pBalance) {
            balance = pBalance;
            return this;
        }

        public Account build() {
            return new Account(this);
        }

    }

}
