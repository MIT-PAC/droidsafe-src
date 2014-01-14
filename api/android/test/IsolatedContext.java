package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OnAccountsUpdateListener;
import android.accounts.OperationCanceledException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;

import com.google.android.collect.Lists;

public class IsolatedContext extends ContextWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.912 -0500", hash_original_field = "D9EFC53032006A099035E3EBF749F453", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.914 -0500", hash_original_field = "639FEFC58440E914F62B80F18B61474A", hash_generated_field = "3DFFF263F722432AF9388693F146732E")

    private  MockAccountManager mMockAccountManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.917 -0500", hash_original_field = "3EB0E7D6038A5F0D982F7D563EC726AC", hash_generated_field = "B5CDB771BE958DF30918A2D1E28A95E3")

    private List<Intent> mBroadcastIntents = Lists.newArrayList();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.920 -0500", hash_original_method = "A71A97961214CA45DD285FABD52B40F7", hash_generated_method = "D543D14EC741E79375ABBF9094F9A632")
    
public IsolatedContext(
            ContentResolver resolver, Context targetContext) {
        super(targetContext);
        mResolver = resolver;
        mMockAccountManager = new MockAccountManager();
    }

    /** Returns the list of intents that were broadcast since the last call to this method. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.922 -0500", hash_original_method = "8549CC856014937B713ABF96571E7E0A", hash_generated_method = "2A73FC172E200058108D33F3AE070A5C")
    
public List<Intent> getAndClearBroadcastIntents() {
        List<Intent> intents = mBroadcastIntents;
        mBroadcastIntents = Lists.newArrayList();
        return intents;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.924 -0500", hash_original_method = "DB3EFD57F21462C44953D7817E2D1D0B", hash_generated_method = "B6347C1215DB4B2D838F5B1C3CDF3164")
    
@Override
    public ContentResolver getContentResolver() {
        // We need to return the real resolver so that MailEngine.makeRight can get to the
        // subscribed feeds provider. TODO: mock out subscribed feeds too.
        return mResolver;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.926 -0500", hash_original_method = "D151ADEF319006893C279FF639241601", hash_generated_method = "8A89D3272220F379D194F3F66CA073FA")
    
@Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.929 -0500", hash_original_method = "D63A733B99C939E3B044BECFC3A4F3E0", hash_generated_method = "E5AAD7D4F72E710BD5DC260624ED288D")
    
@Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.931 -0500", hash_original_method = "5B78FE35E60043EEBC860B3845D6E056", hash_generated_method = "A88662890337D37F90176F4205A80740")
    
@Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        // Ignore
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.933 -0500", hash_original_method = "8D436BAC12DD3DE12E9B49520E96DCDA", hash_generated_method = "FA0007733AD3841AD82594FBA54658F5")
    
@Override
    public void sendBroadcast(Intent intent) {
        mBroadcastIntents.add(intent);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.936 -0500", hash_original_method = "AE03E44313266CC18BE47C7921C18AFC", hash_generated_method = "0D6E3F74EAABEF09072148903B8F4E65")
    
@Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        mBroadcastIntents.add(intent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.938 -0500", hash_original_method = "D4A194640702A8287472737CF0B51049", hash_generated_method = "CED9C2C6DBA201CBCCD36A2252BC159B")
    
@Override
    public int checkUriPermission(
            Uri uri, String readPermission, String writePermission, int pid,
            int uid, int modeFlags) {
        return PackageManager.PERMISSION_GRANTED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.941 -0500", hash_original_method = "D9147C12C0591AE2DF9A07380B6C581A", hash_generated_method = "6E19244518677EF8B1A9D31CB18C12DF")
    
@Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return PackageManager.PERMISSION_GRANTED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.943 -0500", hash_original_method = "97D70C3E7E76864AF838B3F545C2E8EF", hash_generated_method = "2440E6E5B376D731C082D22B5AF4A5C1")
    
@Override
    public Object getSystemService(String name) {
        if (Context.ACCOUNT_SERVICE.equals(name)) {
            return mMockAccountManager;
        }
        // No other services exist in this context.
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.980 -0500", hash_original_method = "FE53204BB45F48ED45638BEC1B5AA1BA", hash_generated_method = "9CC56171776AE352EA27048C719E9A1D")
    
@Override
    public File getFilesDir() {
        return new File("/dev/null");
    }
    
    private class MockAccountManager extends AccountManager {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.946 -0500", hash_original_method = "F50A3FB8A5B88C0A2467EC0285F6EC49", hash_generated_method = "6D3EC41A283C290B54F7875864260BCB")
        
public MockAccountManager() {
            super(IsolatedContext.this, null /* IAccountManager */, null /* handler */);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.948 -0500", hash_original_method = "CD3E43A96A9D76110323C3B9341CE036", hash_generated_method = "65F1FA1ECF6ABCF9C3FBBCAD84F1A2F2")
        
public void addOnAccountsUpdatedListener(OnAccountsUpdateListener listener,
                Handler handler, boolean updateImmediately) {
            // do nothing
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.950 -0500", hash_original_method = "C22581F9BCE56EDC1300FA008A2943C3", hash_generated_method = "0ECA21841551971F4B68C27DD6CEE018")
        
public Account[] getAccounts() {
            return new Account[]{};
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.953 -0500", hash_original_method = "5A38E85AB6C8568CBD9DDFB8A2598F70", hash_generated_method = "3EE1E992A6598FC42F73F60BE91C355C")
        
public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
                final String type, final String[] features,
                AccountManagerCallback<Account[]> callback, Handler handler) {
            return new MockAccountManagerFuture<Account[]>(new Account[0]);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.956 -0500", hash_original_method = "10417FE58833E3F01D4F5638C5F0722A", hash_generated_method = "60C70AEBDF2DC8F5232E960CB63C26B8")
        
public String blockingGetAuthToken(Account account, String authTokenType,
                boolean notifyAuthFailure)
                throws OperationCanceledException, IOException, AuthenticatorException {
            return null;
        }
        
        private class MockAccountManagerFuture<T> implements AccountManagerFuture<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.958 -0500", hash_original_field = "B4972089E9D9C3CEB68A460B623049F0", hash_generated_field = "B4972089E9D9C3CEB68A460B623049F0")

            T mResult;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.961 -0500", hash_original_method = "AEBC033D1847CD0EB76C1CD9E1AF95BB", hash_generated_method = "ECAF01D01A640B0EA8021576C9CE0F98")
            
public MockAccountManagerFuture(T result) {
                mResult = result;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.964 -0500", hash_original_method = "E7E050BF43F9AAADC8EA5FB3113867CE", hash_generated_method = "A6E853E4358A52302024CC37F466222D")
            
public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.966 -0500", hash_original_method = "BCC8FFB68E7C7F6096B18A3AB81987E9", hash_generated_method = "8096AA7F07C93E0538DB9E15EBEDD6A0")
            
public boolean isCancelled() {
                return false;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.968 -0500", hash_original_method = "2FACCCF2AE69DF9C18B4C967A20C9877", hash_generated_method = "DCE4D93EB1933F27779169ACB21D3BEF")
            
public boolean isDone() {
                return true;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.971 -0500", hash_original_method = "8CB724F1A3943B1995566F000F10E5F3", hash_generated_method = "669DF37826357FA0574D9A752FC1A20A")
            
public T getResult()
                    throws OperationCanceledException, IOException, AuthenticatorException {
                return mResult;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.973 -0500", hash_original_method = "810ADDF52164EBC63263CE769016F2A6", hash_generated_method = "33B1608B6E41D6AC01A736F8B51EA5EE")
            
public T getResult(long timeout, TimeUnit unit)
                    throws OperationCanceledException, IOException, AuthenticatorException {
                return getResult();
            }
            
        }
        
    }
    
}

