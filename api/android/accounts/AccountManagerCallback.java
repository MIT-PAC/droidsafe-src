package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface AccountManagerCallback<V> {
    void run(AccountManagerFuture<V> future);
}
