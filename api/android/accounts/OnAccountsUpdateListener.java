package android.accounts;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface OnAccountsUpdateListener {
    
    void onAccountsUpdated(Account[] accounts);
}
