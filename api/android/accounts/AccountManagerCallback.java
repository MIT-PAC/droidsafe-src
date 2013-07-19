package android.accounts;

// Droidsafe Imports

public interface AccountManagerCallback<V> {
    void run(AccountManagerFuture<V> future);
}
