package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface OnAccountsUpdateListener {
    
    void onAccountsUpdated(Account[] accounts);
}
