package accounts.controllers;

import accounts.controllers.dto.CreateAccountDTO;
import accounts.models.Account;
import accounts.services.AccountService;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class AccountsController extends Controller {

    private HttpExecutionContext executionContext;
    private AccountService accountService;

    @Inject
    public AccountsController(HttpExecutionContext pExecutionContext, AccountService pAccountService) {
        this.executionContext = pExecutionContext;
        this.accountService = pAccountService;
    }

    public CompletionStage<Result> create() {
        JsonNode json = request().body().asJson();
        final CreateAccountDTO dto = Json.fromJson(json, CreateAccountDTO.class);
        Account account = mapCreateAccountDTOtoAccount(dto);
        return accountService.addAccount(account).thenApplyAsync(accountId -> {
            return created(Json.toJson(accountId));
        }, executionContext.current());
    }

    public CompletionStage<Result> getAccouts() {
        return accountService.getAllAccounts().thenApplyAsync(accounts -> {
            return ok(Json.toJson(accounts));
        }, executionContext.current());
    }

    public CompletionStage<Result> delete(String id) {
        return accountService.deleteAccount(id).thenApplyAsync(optionalAccountId -> {
            return optionalAccountId.map(accountId ->
                    ok(Json.toJson(accountId))
            ).orElseGet(() ->
                    notFound()
            );
        }, executionContext.current());
    }

    private static Account mapCreateAccountDTOtoAccount(CreateAccountDTO accountDTO) {
        return Account.builder()
                .generateId()
                .owner(accountDTO.owner)
                .balacne(accountDTO.balance)
                .build();
    }

}
