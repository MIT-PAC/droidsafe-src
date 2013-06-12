package android.accounts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Binder;
import android.os.IBinder;
import android.content.pm.PackageManager;
import android.content.Context;
import android.content.Intent;
import android.Manifest;
import android.util.Log;
import java.util.Arrays;

public abstract class AbstractAccountAuthenticator {
    private static String TAG = "AccountAuthenticator";
    private Context mContext;
    private Transport mTransport = new Transport();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:36.823 -0400", hash_original_method = "9F3D7C5E34F274AF92FE1930A0A4DDDF", hash_generated_method = "E918530C65CBB4B88C25017B066B3EEF")
    @DSModeled(DSC.SAFE)
    public AbstractAccountAuthenticator(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:36.870 -0400", hash_original_method = "95E526E96C0C7C30932DEDFB43544813", hash_generated_method = "981A36A47BE704F4AC26102F54A60E12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleException(IAccountAuthenticatorResponse response, String method,
            String data, Exception e) throws RemoteException {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(data);
        dsTaint.addTaint(method);
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_489411449 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            response.onError(AccountManager.ERROR_CODE_NETWORK_ERROR, e.getMessage());
        } //End block
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1241019629 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            response.onError(AccountManager.ERROR_CODE_UNSUPPORTED_OPERATION,
                    method + " not supported");
        } //End block
        {
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_289341194 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            response.onError(AccountManager.ERROR_CODE_BAD_ARGUMENTS,
                    method + " not supported");
        } //End block
        {
            response.onError(AccountManager.ERROR_CODE_REMOTE_EXCEPTION,
                    method + " failed");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:36.894 -0400", hash_original_method = "3939F878E9AB1367A4D6F0AA3E405BEB", hash_generated_method = "D0D1C4FBEB8D5B030801FB8958918137")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkBinderPermission() {
        int uid;
        uid = Binder.getCallingUid();
        String perm;
        perm = Manifest.permission.ACCOUNT_MANAGER;
        {
            boolean var11B444147FE59A2C58CC5B66374D5DC6_1249006380 = (mContext.checkCallingOrSelfPermission(perm) != PackageManager.PERMISSION_GRANTED);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException("caller uid " + uid + " lacks " + perm);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int uid = Binder.getCallingUid();
        //final String perm = Manifest.permission.ACCOUNT_MANAGER;
        //if (mContext.checkCallingOrSelfPermission(perm) != PackageManager.PERMISSION_GRANTED) {
            //throw new SecurityException("caller uid " + uid + " lacks " + perm);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:36.906 -0400", hash_original_method = "6DC54D8912A95F1FD9D0B49763BAD989", hash_generated_method = "E3985B550C174A209E61E63AE2DC42CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IBinder getIBinder() {
        IBinder var99ABB018A258C930B3BC83C24E3B130E_1336989491 = (mTransport.asBinder());
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTransport.asBinder();
    }

    
    public abstract Bundle editProperties(AccountAuthenticatorResponse response,
            String accountType);

    
    public abstract Bundle addAccount(AccountAuthenticatorResponse response, String accountType,
            String authTokenType, String[] requiredFeatures, Bundle options)
            throws NetworkErrorException;

    
    public abstract Bundle confirmCredentials(AccountAuthenticatorResponse response,
            Account account, Bundle options)
            throws NetworkErrorException;

    
    public abstract Bundle getAuthToken(AccountAuthenticatorResponse response,
            Account account, String authTokenType, Bundle options)
            throws NetworkErrorException;

    
    public abstract String getAuthTokenLabel(String authTokenType);

    
    public abstract Bundle updateCredentials(AccountAuthenticatorResponse response,
            Account account, String authTokenType, Bundle options) throws NetworkErrorException;

    
    public abstract Bundle hasFeatures(AccountAuthenticatorResponse response,
            Account account, String[] features) throws NetworkErrorException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:36.967 -0400", hash_original_method = "6F844A6749C692C7821327095809795F", hash_generated_method = "B65BFAC738F07A5E6E557FB70794FD89")
    @DSModeled(DSC.SAFE)
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse response,
            Account account) throws NetworkErrorException {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(account.dsTaint);
        Bundle result;
        result = new Bundle();
        result.putBoolean(AccountManager.KEY_BOOLEAN_RESULT, true);
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Bundle result = new Bundle();
        //result.putBoolean(AccountManager.KEY_BOOLEAN_RESULT, true);
        //return result;
    }

    
    private class Transport extends IAccountAuthenticator.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.015 -0400", hash_original_method = "407AD6E8DF513E5FCA508D8E605549E0", hash_generated_method = "9F8624C037FF245FD6933494784B5A28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void addAccount(IAccountAuthenticatorResponse response, String accountType,
                String authTokenType, String[] features, Bundle options) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(accountType);
            dsTaint.addTaint(features[0]);
            dsTaint.addTaint(authTokenType);
            dsTaint.addTaint(options.dsTaint);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_172071137 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = AbstractAccountAuthenticator.this.addAccount(
                    new AccountAuthenticatorResponse(response),
                        accountType, authTokenType, features, options);
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1112598653 = (Log.isLoggable(TAG, Log.VERBOSE));
                    {
                        result.keySet();
                    } //End block
                } //End collapsed parenthetic
                {
                    response.onResult(result);
                } //End block
            } //End block
            catch (Exception e)
            {
                handleException(response, "addAccount", accountType, e);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.058 -0400", hash_original_method = "655C56EFA9B46DA2E6362CB661909222", hash_generated_method = "E1AE190DC64D0FB8D9E946EB07F488A9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void confirmCredentials(IAccountAuthenticatorResponse response,
                Account account, Bundle options) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(options.dsTaint);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1842463361 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = AbstractAccountAuthenticator.this.confirmCredentials(
                    new AccountAuthenticatorResponse(response), account, options);
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_53190453 = (Log.isLoggable(TAG, Log.VERBOSE));
                    {
                        result.keySet();
                    } //End block
                } //End collapsed parenthetic
                {
                    response.onResult(result);
                } //End block
            } //End block
            catch (Exception e)
            {
                handleException(response, "confirmCredentials", account.toString(), e);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.095 -0400", hash_original_method = "0B8E04381CE4543FA42B184881ECD368", hash_generated_method = "B8C6C26FC4B553C47B4963DA68685794")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getAuthTokenLabel(IAccountAuthenticatorResponse response,
                String authTokenType) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(authTokenType);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1831611029 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = new Bundle();
                result.putString(AccountManager.KEY_AUTH_TOKEN_LABEL,
                        AbstractAccountAuthenticator.this.getAuthTokenLabel(authTokenType));
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_2075697006 = (Log.isLoggable(TAG, Log.VERBOSE));
                    {
                        result.keySet();
                    } //End block
                } //End collapsed parenthetic
                response.onResult(result);
            } //End block
            catch (Exception e)
            {
                handleException(response, "getAuthTokenLabel", authTokenType, e);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.119 -0400", hash_original_method = "4C21311CEF34DFAF64EF2CBE1D7F71D4", hash_generated_method = "18EF44C001722ACCA663AD439434EC8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getAuthToken(IAccountAuthenticatorResponse response,
                Account account, String authTokenType, Bundle loginOptions) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(loginOptions.dsTaint);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(authTokenType);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_898135198 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = AbstractAccountAuthenticator.this.getAuthToken(
                        new AccountAuthenticatorResponse(response), account,
                        authTokenType, loginOptions);
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_1031992263 = (Log.isLoggable(TAG, Log.VERBOSE));
                    {
                        result.keySet();
                    } //End block
                } //End collapsed parenthetic
                {
                    response.onResult(result);
                } //End block
            } //End block
            catch (Exception e)
            {
                handleException(response, "getAuthToken",
                        account.toString() + "," + authTokenType, e);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.160 -0400", hash_original_method = "1AEEB273836952F76F107380EE41EC51", hash_generated_method = "AB1508098AB1A17B016055DEE8155D8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updateCredentials(IAccountAuthenticatorResponse response, Account account,
                String authTokenType, Bundle loginOptions) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(loginOptions.dsTaint);
            dsTaint.addTaint(account.dsTaint);
            dsTaint.addTaint(authTokenType);
            {
                boolean var9C0394913D1D3E76433CD87690A4731B_1411838634 = (Log.isLoggable(TAG, Log.VERBOSE));
            } //End collapsed parenthetic
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = AbstractAccountAuthenticator.this.updateCredentials(
                    new AccountAuthenticatorResponse(response), account,
                        authTokenType, loginOptions);
                {
                    boolean var5FC87F7ECAA44100B96543687E8D1157_592396717 = (Log.isLoggable(TAG, Log.VERBOSE));
                    {
                        result.keySet();
                    } //End block
                } //End collapsed parenthetic
                {
                    response.onResult(result);
                } //End block
            } //End block
            catch (Exception e)
            {
                handleException(response, "updateCredentials",
                        account.toString() + "," + authTokenType, e);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.189 -0400", hash_original_method = "0E386DBDFED388C2F6E9D818F72B2DFA", hash_generated_method = "6B558B3F255A57D0A24AF9A845352A9A")
        @DSModeled(DSC.SAFE)
        public void editProperties(IAccountAuthenticatorResponse response,
                String accountType) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(accountType);
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = AbstractAccountAuthenticator.this.editProperties(
                    new AccountAuthenticatorResponse(response), accountType);
                {
                    response.onResult(result);
                } //End block
            } //End block
            catch (Exception e)
            {
                handleException(response, "editProperties", accountType, e);
            } //End block
            // ---------- Original Method ----------
            //checkBinderPermission();
            //try {
                //final Bundle result = AbstractAccountAuthenticator.this.editProperties(
                    //new AccountAuthenticatorResponse(response), accountType);
                //if (result != null) {
                    //response.onResult(result);
                //}
            //} catch (Exception e) {
                //handleException(response, "editProperties", accountType, e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.211 -0400", hash_original_method = "ED7B623313911EFB27297E4C59F3BA80", hash_generated_method = "03C23A41C3CDE78F4AE7921DDDDF1FF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void hasFeatures(IAccountAuthenticatorResponse response,
                Account account, String[] features) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(features[0]);
            dsTaint.addTaint(account.dsTaint);
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = AbstractAccountAuthenticator.this.hasFeatures(
                    new AccountAuthenticatorResponse(response), account, features);
                {
                    response.onResult(result);
                } //End block
            } //End block
            catch (Exception e)
            {
                handleException(response, "hasFeatures", account.toString(), e);
            } //End block
            // ---------- Original Method ----------
            //checkBinderPermission();
            //try {
                //final Bundle result = AbstractAccountAuthenticator.this.hasFeatures(
                    //new AccountAuthenticatorResponse(response), account, features);
                //if (result != null) {
                    //response.onResult(result);
                //}
            //} catch (Exception e) {
                //handleException(response, "hasFeatures", account.toString(), e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:04:37.224 -0400", hash_original_method = "09B1DE63B1D9788B32F2239098E3EBA0", hash_generated_method = "36DA92C87043265E6A7F5B37EFD9BB18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getAccountRemovalAllowed(IAccountAuthenticatorResponse response,
                Account account) throws RemoteException {
            dsTaint.addTaint(response.dsTaint);
            dsTaint.addTaint(account.dsTaint);
            checkBinderPermission();
            try 
            {
                Bundle result;
                result = AbstractAccountAuthenticator.this.getAccountRemovalAllowed(
                    new AccountAuthenticatorResponse(response), account);
                {
                    response.onResult(result);
                } //End block
            } //End block
            catch (Exception e)
            {
                handleException(response, "getAccountRemovalAllowed", account.toString(), e);
            } //End block
            // ---------- Original Method ----------
            //checkBinderPermission();
            //try {
                //final Bundle result = AbstractAccountAuthenticator.this.getAccountRemovalAllowed(
                    //new AccountAuthenticatorResponse(response), account);
                //if (result != null) {
                    //response.onResult(result);
                //}
            //} catch (Exception e) {
                //handleException(response, "getAccountRemovalAllowed", account.toString(), e);
            //}
        }

        
    }


    
}


