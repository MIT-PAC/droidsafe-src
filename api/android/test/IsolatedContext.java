package android.test;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.761 -0400", hash_original_field = "CF849E3C15214EFD093D4303B542BF44", hash_generated_field = "2ABF989C5B8F051BCBEE638ED1EA2586")

    private ContentResolver mResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.761 -0400", hash_original_field = "424449840F39E6FC762E7706148D57FA", hash_generated_field = "3DFFF263F722432AF9388693F146732E")

    private MockAccountManager mMockAccountManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.762 -0400", hash_original_field = "DE882347E0D917D87A9A76637D58E3E3", hash_generated_field = "B5CDB771BE958DF30918A2D1E28A95E3")

    private List<Intent> mBroadcastIntents = Lists.newArrayList();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.762 -0400", hash_original_method = "A71A97961214CA45DD285FABD52B40F7", hash_generated_method = "CBFCAC4D66DBF5E4BA7393602C6AFD01")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.762 -0400", hash_original_method = "8549CC856014937B713ABF96571E7E0A", hash_generated_method = "E206ECE92A6741ACEFACC405897DE8A9")
    public List<Intent> getAndClearBroadcastIntents() {
        List<Intent> intents = mBroadcastIntents;
        mBroadcastIntents = Lists.newArrayList();
List<Intent> varE605E6FF378E732B20AE622708ABD1E5_608022049 =         intents;
        varE605E6FF378E732B20AE622708ABD1E5_608022049.addTaint(taint);
        return varE605E6FF378E732B20AE622708ABD1E5_608022049;
        // ---------- Original Method ----------
        //List<Intent> intents = mBroadcastIntents;
        //mBroadcastIntents = Lists.newArrayList();
        //return intents;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.763 -0400", hash_original_method = "DB3EFD57F21462C44953D7817E2D1D0B", hash_generated_method = "DEC5AD25AF66D48FF9A6506BCB8EEB34")
    @Override
    public ContentResolver getContentResolver() {
ContentResolver varAB109E9A06CD2C0031B0F4CF098EA9E9_1272377150 =         mResolver;
        varAB109E9A06CD2C0031B0F4CF098EA9E9_1272377150.addTaint(taint);
        return varAB109E9A06CD2C0031B0F4CF098EA9E9_1272377150;
        // ---------- Original Method ----------
        //return mResolver;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.763 -0400", hash_original_method = "D151ADEF319006893C279FF639241601", hash_generated_method = "5B206CD66EB5E0DE88E03940E75B85DC")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_566728675 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796670879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796670879;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.764 -0400", hash_original_method = "D63A733B99C939E3B044BECFC3A4F3E0", hash_generated_method = "9B967991B4E65B7795FE8D7BE1703A27")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent var540C13E9E156B687226421B24F2DF178_1870985540 =         null;
        var540C13E9E156B687226421B24F2DF178_1870985540.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1870985540;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.764 -0400", hash_original_method = "5B78FE35E60043EEBC860B3845D6E056", hash_generated_method = "F3D4B94E17AF977F24D9B43015DBAC9F")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.765 -0400", hash_original_method = "8D436BAC12DD3DE12E9B49520E96DCDA", hash_generated_method = "5C8ED5CBBE2966ACA64812CDF5F94AD0")
    @Override
    public void sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBroadcastIntents.add(intent);
        // ---------- Original Method ----------
        //mBroadcastIntents.add(intent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.765 -0400", hash_original_method = "AE03E44313266CC18BE47C7921C18AFC", hash_generated_method = "5AFD2661FFA5F7D8AA1E3BDEF1B73C5E")
    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        mBroadcastIntents.add(intent);
        // ---------- Original Method ----------
        //mBroadcastIntents.add(intent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.766 -0400", hash_original_method = "D4A194640702A8287472737CF0B51049", hash_generated_method = "58A1CBB326421E0626DCC5ED326D9E05")
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
        int var55413C6AD5414521A701E18298A1C877_944876117 = (PackageManager.PERMISSION_GRANTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594214370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594214370;
        // ---------- Original Method ----------
        //return PackageManager.PERMISSION_GRANTED;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.767 -0400", hash_original_method = "D9147C12C0591AE2DF9A07380B6C581A", hash_generated_method = "E323F57736BB304C11EDF02278E823F6")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        int var55413C6AD5414521A701E18298A1C877_380655864 = (PackageManager.PERMISSION_GRANTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324884861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324884861;
        // ---------- Original Method ----------
        //return PackageManager.PERMISSION_GRANTED;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.768 -0400", hash_original_method = "97D70C3E7E76864AF838B3F545C2E8EF", hash_generated_method = "FB3C8B5F20B11FB3E1A2534BCC0BBCD8")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
        if(Context.ACCOUNT_SERVICE.equals(name))        
        {
Object varA5D00F4EC5971D65BFD6627A28D168C7_263104296 =             mMockAccountManager;
            varA5D00F4EC5971D65BFD6627A28D168C7_263104296.addTaint(taint);
            return varA5D00F4EC5971D65BFD6627A28D168C7_263104296;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1536496219 =         null;
        var540C13E9E156B687226421B24F2DF178_1536496219.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1536496219;
        // ---------- Original Method ----------
        //if (Context.ACCOUNT_SERVICE.equals(name)) {
            //return mMockAccountManager;
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.768 -0400", hash_original_method = "FE53204BB45F48ED45638BEC1B5AA1BA", hash_generated_method = "6CAE3062E357648C0400D2BE0F8D870C")
    @Override
    public File getFilesDir() {
File varCDB4F0E70BC9453804DFE6CD3611F6BF_1923668064 =         new File("/dev/null");
        varCDB4F0E70BC9453804DFE6CD3611F6BF_1923668064.addTaint(taint);
        return varCDB4F0E70BC9453804DFE6CD3611F6BF_1923668064;
        // ---------- Original Method ----------
        //return new File("/dev/null");
    }

    
    private class MockAccountManager extends AccountManager {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.769 -0400", hash_original_method = "F50A3FB8A5B88C0A2467EC0285F6EC49", hash_generated_method = "B682F1D4D506B92B6755DA9F25B8C9C2")
        public  MockAccountManager() {
            super(IsolatedContext.this, null , null );
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.770 -0400", hash_original_method = "CD3E43A96A9D76110323C3B9341CE036", hash_generated_method = "012C3EEEBEDE720FBB789686E20AD01E")
        public void addOnAccountsUpdatedListener(OnAccountsUpdateListener listener,
                Handler handler, boolean updateImmediately) {
            addTaint(updateImmediately);
            addTaint(handler.getTaint());
            addTaint(listener.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.771 -0400", hash_original_method = "C22581F9BCE56EDC1300FA008A2943C3", hash_generated_method = "EF438C40D57463ADE24E6FF45667F04B")
        public Account[] getAccounts() {
Account[] varF35A7B4D3EBC7623DF9EB3A949846B5B_2026429804 =             new Account[]{};
            varF35A7B4D3EBC7623DF9EB3A949846B5B_2026429804.addTaint(taint);
            return varF35A7B4D3EBC7623DF9EB3A949846B5B_2026429804;
            // ---------- Original Method ----------
            //return new Account[]{};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.772 -0400", hash_original_method = "5A38E85AB6C8568CBD9DDFB8A2598F70", hash_generated_method = "D2351E59045609D42BE93B05855D25B9")
        public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(
                final String type, final String[] features,
                AccountManagerCallback<Account[]> callback, Handler handler) {
            addTaint(handler.getTaint());
            addTaint(callback.getTaint());
            addTaint(features[0].getTaint());
            addTaint(type.getTaint());
AccountManagerFuture<Account[]> varA1C77EF2D49EC78A818761662FAD417E_478908207 =             new MockAccountManagerFuture<Account[]>(new Account[0]);
            varA1C77EF2D49EC78A818761662FAD417E_478908207.addTaint(taint);
            return varA1C77EF2D49EC78A818761662FAD417E_478908207;
            // ---------- Original Method ----------
            //return new MockAccountManagerFuture<Account[]>(new Account[0]);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.773 -0400", hash_original_method = "10417FE58833E3F01D4F5638C5F0722A", hash_generated_method = "A3832383F34F83D0D0D3BAB3BB11FB70")
        public String blockingGetAuthToken(Account account, String authTokenType,
                boolean notifyAuthFailure) throws OperationCanceledException, IOException, AuthenticatorException {
            addTaint(notifyAuthFailure);
            addTaint(authTokenType.getTaint());
            addTaint(account.getTaint());
String var540C13E9E156B687226421B24F2DF178_1484219517 =             null;
            var540C13E9E156B687226421B24F2DF178_1484219517.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1484219517;
            // ---------- Original Method ----------
            //return null;
        }

        
        private class MockAccountManagerFuture<T> implements AccountManagerFuture<T> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.773 -0400", hash_original_field = "313AEF43C06545BCEAC152A1C285EBE1", hash_generated_field = "B4972089E9D9C3CEB68A460B623049F0")

            T mResult;
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.773 -0400", hash_original_method = "AEBC033D1847CD0EB76C1CD9E1AF95BB", hash_generated_method = "6116808AFB1EBF7DF132977043A5389D")
            public  MockAccountManagerFuture(T result) {
                mResult = result;
                // ---------- Original Method ----------
                //mResult = result;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.774 -0400", hash_original_method = "E7E050BF43F9AAADC8EA5FB3113867CE", hash_generated_method = "8BEED217CE953FE3FF57C3B938F5F815")
            public boolean cancel(boolean mayInterruptIfRunning) {
                addTaint(mayInterruptIfRunning);
                boolean var68934A3E9455FA72420237EB05902327_2076713052 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_477615957 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_477615957;
                // ---------- Original Method ----------
                //return false;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.774 -0400", hash_original_method = "BCC8FFB68E7C7F6096B18A3AB81987E9", hash_generated_method = "DFE0E30697A9E7EBE3FDC3F617881B0E")
            public boolean isCancelled() {
                boolean var68934A3E9455FA72420237EB05902327_1217598714 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952626126 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952626126;
                // ---------- Original Method ----------
                //return false;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.774 -0400", hash_original_method = "2FACCCF2AE69DF9C18B4C967A20C9877", hash_generated_method = "686A88540A79F1327453E0BC48882523")
            public boolean isDone() {
                boolean varB326B5062B2F0E69046810717534CB09_570436916 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71509126 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_71509126;
                // ---------- Original Method ----------
                //return true;
            }

            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.775 -0400", hash_original_method = "8CB724F1A3943B1995566F000F10E5F3", hash_generated_method = "86205B90805FE7939EB0FC8A7065D467")
            public T getResult() throws OperationCanceledException, IOException, AuthenticatorException {
T var8EC17D26103D23643357521909BC2C9A_190176727 =                 mResult;
                var8EC17D26103D23643357521909BC2C9A_190176727.addTaint(taint);
                return var8EC17D26103D23643357521909BC2C9A_190176727;
                // ---------- Original Method ----------
                //return mResult;
            }

            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.775 -0400", hash_original_method = "810ADDF52164EBC63263CE769016F2A6", hash_generated_method = "91E9592F9336AC3128FFB9087D09F4C4")
            public T getResult(long timeout, TimeUnit unit) throws OperationCanceledException, IOException, AuthenticatorException {
                addTaint(unit.getTaint());
                addTaint(timeout);
T var44439E072D0705F6FD67F017CB15DB77_1753202360 =                 getResult();
                var44439E072D0705F6FD67F017CB15DB77_1753202360.addTaint(taint);
                return var44439E072D0705F6FD67F017CB15DB77_1753202360;
                // ---------- Original Method ----------
                //return getResult();
            }

            
        }


        
    }


    
}

