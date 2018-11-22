import accounts.services.AccountsInMemoryRepository;
import accounts.services.AccountsRepository;
import com.google.inject.AbstractModule;

public class Module extends AbstractModule {

    @Override
    public void configure() {
        bind(AccountsRepository.class).to(AccountsInMemoryRepository.class).asEagerSingleton();
    }
}
