package accounts.services;

import accounts.models.Account;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletionStage;

/**
 * @author Jakub Kalinowski-Zajdak
 */
public interface AccountsRepository {

	CompletionStage<Collection<Account>> getAllAccounts();
	CompletionStage<String> addAccount(Account account);
	CompletionStage<Optional<String>> deleteAccount(String id);

}
