package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface OnAccountsUpdateListener {
    
    void onAccountsUpdated(Account[] accounts);
}
