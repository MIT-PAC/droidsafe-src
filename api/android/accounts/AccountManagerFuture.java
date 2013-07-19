package android.accounts;

// Droidsafe Imports
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public interface AccountManagerFuture<V> {
    
    boolean cancel(boolean mayInterruptIfRunning);

    
    boolean isCancelled();

    
    boolean isDone();

    
    V getResult() throws OperationCanceledException, IOException, AuthenticatorException;

    
    V getResult(long timeout, TimeUnit unit)
            throws OperationCanceledException, IOException, AuthenticatorException;
}
