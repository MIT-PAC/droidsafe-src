package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.io.IOException;

public interface AccountManagerFuture<V> {
    
    boolean cancel(boolean mayInterruptIfRunning);

    
    boolean isCancelled();

    
    boolean isDone();

    
    V getResult() throws OperationCanceledException, IOException, AuthenticatorException;

    
    V getResult(long timeout, TimeUnit unit)
            throws OperationCanceledException, IOException, AuthenticatorException;
}
