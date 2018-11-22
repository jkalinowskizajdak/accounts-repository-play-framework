package accounts.services;

import accounts.models.Account;
import play.libs.concurrent.HttpExecutionContext;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

public class AccountService {

    private final HttpExecutionContext executionContext;
    private final AccountsRepository accountsRepository;

    @Inject
    public AccountService(HttpExecutionContext pExecutionContext, AccountsRepository pAccountsRepository) {
        this.executionContext = pExecutionContext;
        this.accountsRepository = pAccountsRepository;
    }

    public CompletionStage<String> addAccount(Account account) {
        return accountsRepository.addAccount(account);
    }

    public CompletionStage<Collection<Account>> getAllAccounts() {
        return accountsRepository.getAllAccounts();
    }

    public CompletionStage<Optional<String>> deleteAccount(String id) {
        return accountsRepository.deleteAccount(id);
    }

}
