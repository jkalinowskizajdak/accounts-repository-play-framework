package accounts.services;

import accounts.models.Account;
import javax.inject.Singleton;
import java.util.*;
import java.util.concurrent.CompletionStage;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class AccountsInMemoryRepository implements AccountsRepository {

    private final Map<UUID, Account> accounts = new HashMap<>();

    @Override
    public CompletionStage<Collection<Account>> getAllAccounts() {
        return supplyAsync(() ->accounts.values());
    }

    @Override
    public CompletionStage<String> addAccount(Account account) {
        return supplyAsync(() -> insert(account));
    }

    @Override
    public CompletionStage<Optional<String>> deleteAccount(String id) {
        return supplyAsync(() -> delete(id));
    }

    private String insert(Account account) {
        accounts.put(account.getId(), account);
        return account.getId().toString();
    }

    private Optional<String> delete(String id) {
        UUID accountId = UUID.fromString(id);
        if (accounts.containsKey(accountId)) {
            accounts.remove(accountId);
            return Optional.of(id);
        }
        return Optional.empty();
    }
}
