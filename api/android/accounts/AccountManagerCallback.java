package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface AccountManagerCallback<V> {
    void run(AccountManagerFuture<V> future);
}
