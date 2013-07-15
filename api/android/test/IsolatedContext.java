package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.google.android.collect.Lists;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OnAccountsUpdateListener;
import android.accounts.OperationCanceledException;
import android.accounts.Account;
import android.content.ContextWrapper;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.List;

public class IsolatedContext extends ContextWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.112 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.112 -0400", hash_original_field = "424449840F39E6FC762E7706148D57FA", hash_generated_field = "3DFFF263F722432AF9388693F146732E")

    private MockAccountManager mMockAccountManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.112 -0400", hash_original_field = "DE882347E0D917D87A9A76637D58E3E3", hash_generated_field = "B5CDB771BE958DF30918A2D1E28A95E3")

    private List<Intent> mBroadcastIntents = Lists.newArrayList();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.112 -0400", hash_original_method = "A71A97961214CA45DD285FABD52B40F7", hash_generated_method = "CBFCAC4D66DBF5E4BA7393602C6AFD01")
    public  IsolatedContext(
            ContentResolver resolver, Context targetContext) {
        super(targetContext);
        addTaint(targetContext.getTaint());
        mResolver = resolver;
        mMockAccountManager = new MockAccountManager();
        // ---------- Original Method ----------
        //mResolver = resolver;
        //mMockAccountManager = new MockAccountManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.113 -0400", hash_original_method = "8549CC856014937B713ABF96571E7E0A", hash_generated_method = "A9E704E774A9549B5B792C832EC275B7")
    public List<Intent> getAndClearBroadcastIntents() {
        List<Intent> intents = mBroadcastIntents;
        mBroadcastIntents = Lists.newArrayList();
List<Intent> varE605E6FF378E732B20AE622708ABD1E5_1756568544 =         intents;
        varE605E6FF378E732B20AE622708ABD1E5_1756568544.addTaint(taint);
        return varE605E6FF378E732B20AE622708ABD1E5_1756568544;
        // ---------- Original Method ----------
        //List<Intent> intents = mBroadcastIntents;
        //mBroadcastIntents = Lists.newArrayList();
        //return intents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.113 -0400", hash_original_method = "DB3EFD57F21462C44953D7817E2D1D0B", hash_generated_method = "3AAF8260B2BF14316CCD5FA8AD16D4E3")
    @Override
    public ContentResolver getContentResolver() {
ContentResolver varAB109E9A06CD2C0031B0F4CF098EA9E9_961678017 =         mResolver;
        varAB109E9A06CD2C0031B0F4CF098EA9E9_961678017.addTaint(taint);
        return varAB109E9A06CD2C0031B0F4CF098EA9E9_961678017;
        // ---------- Original Method ----------
        //return mResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.113 -0400", hash_original_method = "D151ADEF319006893C279FF639241601", hash_generated_method = "D5236996010CDE7957E1203B76F0C27B")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_882733956 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763856476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763856476;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.113 -0400", hash_original_method = "D63A733B99C939E3B044BECFC3A4F3E0", hash_generated_method = "3EAC4B92C3510F9EDB7B3BD91A74B6AB")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent var540C13E9E156B687226421B24F2DF178_1458089441 =         null;
        var540C13E9E156B687226421B24F2DF178_1458089441.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1458089441;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.114 -0400", hash_original_method = "5B78FE35E60043EEBC860B3845D6E056", hash_generated_method = "F3D4B94E17AF977F24D9B43015DBAC9F")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.114 -0400", hash_original_method = "8D436BAC12DD3DE12E9B49520E96DCDA", hash_generated_method = "5C8ED5CBBE2966ACA64812CDF5F94AD0")
    @Override
    public void sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBroadcastIntents.add(intent);
        // ---------- Original Method ----------
        //mBroadcastIntents.add(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.114 -0400", hash_original_method = "AE03E44313266CC18BE47C7921C18AFC", hash_generated_method = "5AFD2661FFA5F7D8AA1E3BDEF1B73C5E")
    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        mBroadcastIntents.add(intent);
        // ---------- Original Method ----------
        //mBroadcastIntents.add(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.115 -0400", hash_original_method = "D4A194640702A8287472737CF0B51049", hash_generated_method = "21AEB8895021F99B810A6A0F6B1880B1")
    @Override
    public int checkUriPermission(
            Uri uri, String readPermission, String writePermission, int pid,
            int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
        int var55413C6AD5414521A701E18298A1C877_1776976459 = (PackageManager.PERMISSION_GRANTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012677599 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012677599;
        // ---------- Original Method ----------
        //return PackageManager.PERMISSION_GRANTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.115 -0400", hash_original_method = "D9147C12C0591AE2DF9A07380B6C581A", hash_generated_method = "C08FC206452BFAD68CD23B2153879AC3")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        int var55413C6AD5414521A701E18298A1C877_1348629057 = (PackageManager.PERMISSION_GRANTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194656416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194656416;
        // ---------- Original Method ----------
        //return PackageManager.PERMISSION_GRANTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.116 -0400", hash_original_method = "97D70C3E7E76864AF838B3F545C2E8EF", hash_generated_method = "0448DD92A8FD9E4AD2B5A86654B983BF")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
    if(Context.ACCOUNT_SERVICE.equals(name))        
        {
Object varA5D00F4EC5971D65BFD6627A28D168C7_350350066 =             mMockAccountManager;
            varA5D00F4EC5971D65BFD6627A28D168C7_350350066.addTaint(taint);
            return varA5D00F4EC5971D65BFD6627A28D168C7_350350066;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_2077497878 =         null;
        var540C13E9E156B687226421B24F2DF178_2077497878.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2077497878;
        // ---------- Original Method ----------
        //if (Context.ACCOUNT_SERVICE.equals(name)) {
            //return mMockAccountManager;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.116 -0400", hash_original_method = "FE53204BB45F48ED45638BEC1B5AA1BA", hash_generated_method = "A1C8B2DB505461BF2B2A48ADCA611325")
    @Override
    public File getFilesDir() {
File varCDB4F0E70BC9453804DFE6CD3611F6BF_1236998301 =         new File("/dev/null");
        varCDB4F0E70BC9453804DFE6CD3611F6BF_1236998301.addTaint(taint);
        return varCDB4F0E70BC9453804DFE6CD3611F6BF_1236998301;
        // ---------- Original Method ----------
        //return new File("/dev/null");
    }

    
    private class MockAccountManager extends AccountManager {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.116 -0400", hash_original_method = "F50A3FB8A5B88C0A2467EC0285F6EC49", hash_generated_method = "B682F1D4D506B92B6755DA9F25B8C9C2")
        public  MockAccountManager() {
            super(IsolatedContext.this, null , null );
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.117 -0400", hash_original_method = "CD3E43A96A9D76110323C3B9341CE036", hash_generated_method = "012C3EEEBEDE720FBB789686E20AD01E")
        public void addOnAccountsUpdatedListener(OnAccountsUpdateListener listener,
                Handler handler, boolean updateImmediately) {
            addTaint(updateImmediately);
            addTaint(handler.getTaint());
            addTaint(listener.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.117 -0400", hash_original_method = "C22581F9BCE56EDC1300FA008A2943C3", hash_generated_method = "0B28FE5C70881498C4DB8E3E39535478")
        public Account[] getAccounts() {
Account[] varF35A7B4D3EBC7623DF9EB3A949846B5B_1103712996 =             new Account[]{};
            varF35A7B4D3EBC7623DF9EB3A949846B5B_1103712996.addTaint(taint);
            return varF35A7B4D3EBC7623DF9EB3A949846B5B_1103712996;
            // ---------- Original Method ----------
            //return new Account[]{};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.117 -0400", hash_original_method = "5A38E85AB6C8568CBD9DDFB8A2598F70", hash_generated_method = "D2C372FC70A847F7580757D510A53DE8")
        public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
                final String type, final String[] features,
                AccountManagerCallback<Account[]> callback, Handler handler) {
            addTaint(handler.getTaint());
            addTaint(callback.getTaint());
            addTaint(features[0].getTaint());
            addTaint(type.getTaint());
AccountManagerFuture<Account[]> varA1C77EF2D49EC78A818761662FAD417E_1097970719 =             new MockAccountManagerFuture<Account[]>(new Account[0]);
            varA1C77EF2D49EC78A818761662FAD417E_1097970719.addTaint(taint);
            return varA1C77EF2D49EC78A818761662FAD417E_1097970719;
            // ---------- Original Method ----------
            //return new MockAccountManagerFuture<Account[]>(new Account[0]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.118 -0400", hash_original_method = "10417FE58833E3F01D4F5638C5F0722A", hash_generated_method = "AD1824DB575D1E9AD8C39118C69A8F5D")
        public String blockingGetAuthToken(Account account, String authTokenType,
                boolean notifyAuthFailure) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(notifyAuthFailure);
            addTaint(authTokenType.getTaint());
            addTaint(account.getTaint());
String var540C13E9E156B687226421B24F2DF178_2034189897 =             null;
            var540C13E9E156B687226421B24F2DF178_2034189897.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2034189897;
            // ---------- Original Method ----------
            //return null;
        }

        
        private class MockAccountManagerFuture<T> implements AccountManagerFuture<T> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.118 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "B4972089E9D9C3CEB68A460B623049F0")

            T mResult;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.118 -0400", hash_original_method = "AEBC033D1847CD0EB76C1CD9E1AF95BB", hash_generated_method = "6116808AFB1EBF7DF132977043A5389D")
            public  MockAccountManagerFuture(T result) {
                mResult = result;
                // ---------- Original Method ----------
                //mResult = result;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.119 -0400", hash_original_method = "E7E050BF43F9AAADC8EA5FB3113867CE", hash_generated_method = "A1B31A7096DB108DC5F107B871DF9C25")
            public boolean cancel(boolean mayInterruptIfRunning) {
                addTaint(mayInterruptIfRunning);
                boolean var68934A3E9455FA72420237EB05902327_1565081133 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968280325 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968280325;
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.119 -0400", hash_original_method = "BCC8FFB68E7C7F6096B18A3AB81987E9", hash_generated_method = "FF8A35E84E889B6F4DDDEA3651E896D5")
            public boolean isCancelled() {
                boolean var68934A3E9455FA72420237EB05902327_1387216205 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679153752 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679153752;
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.119 -0400", hash_original_method = "2FACCCF2AE69DF9C18B4C967A20C9877", hash_generated_method = "4107BCA17685BC328D66D41955C2564E")
            public boolean isDone() {
                boolean varB326B5062B2F0E69046810717534CB09_1646093526 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496418651 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496418651;
                // ---------- Original Method ----------
                //return true;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.119 -0400", hash_original_method = "8CB724F1A3943B1995566F000F10E5F3", hash_generated_method = "068054FFB90FC295AE6D307E90355912")
            public T getResult() throws OperationCanceledException, IOException, AuthenticatorException {
T var8EC17D26103D23643357521909BC2C9A_226689116 =                 mResult;
                var8EC17D26103D23643357521909BC2C9A_226689116.addTaint(taint);
                return var8EC17D26103D23643357521909BC2C9A_226689116;
                // ---------- Original Method ----------
                //return mResult;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.120 -0400", hash_original_method = "810ADDF52164EBC63263CE769016F2A6", hash_generated_method = "7FE4B02FD898CD77EE18F6415457C15B")
            public T getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
                addTaint(unit.getTaint());
                addTaint(timeout);
T var44439E072D0705F6FD67F017CB15DB77_320269073 =                 getResult();
                var44439E072D0705F6FD67F017CB15DB77_320269073.addTaint(taint);
                return var44439E072D0705F6FD67F017CB15DB77_320269073;
                // ---------- Original Method ----------
                //return getResult();
            }

            
        }


        
    }


    
}

