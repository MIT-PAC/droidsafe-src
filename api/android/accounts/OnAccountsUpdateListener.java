package android.accounts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface OnAccountsUpdateListener {
    
    void onAccountsUpdated(Account[] accounts);
}
