/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.accounts;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

/**
 * Abstract base class for creating AccountAuthenticators.
 * In order to be an authenticator one must extend this class, provider implementations for the
 * abstract methods and write a service that returns the result of {@link #getIBinder()}
 * in the service's {@link android.app.Service#onBind(android.content.Intent)} when invoked
 * with an intent with action {@link AccountManager#ACTION_AUTHENTICATOR_INTENT}. This service
 * must specify the following intent filter and metadata tags in its AndroidManifest.xml file
 * <pre>
 *   &lt;intent-filter&gt;
 *     &lt;action android:name="android.accounts.AccountAuthenticator" /&gt;
 *   &lt;/intent-filter&gt;
 *   &lt;meta-data android:name="android.accounts.AccountAuthenticator"
 *             android:resource="@xml/authenticator" /&gt;
 * </pre>
 * The <code>android:resource</code> attribute must point to a resource that looks like:
 * <pre>
 * &lt;account-authenticator xmlns:android="http://schemas.android.com/apk/res/android"
 *    android:accountType="typeOfAuthenticator"
 *    android:icon="@drawable/icon"
 *    android:smallIcon="@drawable/miniIcon"
 *    android:label="@string/label"
 *    android:accountPreferences="@xml/account_preferences"
 * /&gt;
 * </pre>
 * Replace the icons and labels with your own resources. The <code>android:accountType</code>
 * attribute must be a string that uniquely identifies your authenticator and will be the same
 * string that user will use when making calls on the {@link AccountManager} and it also
 * corresponds to {@link Account#type} for your accounts. One user of the android:icon is the
 * "Account & Sync" settings page and one user of the android:smallIcon is the Contact Application's
 * tab panels.
 * <p>
 * The preferences attribute points to an PreferenceScreen xml hierarchy that contains
 * a list of PreferenceScreens that can be invoked to manage the authenticator. An example is:
 * <pre>
 * &lt;PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android"&gt;
 *    &lt;PreferenceCategory android:title="@string/title_fmt" /&gt;
 *    &lt;PreferenceScreen
 *         android:key="key1"
 *         android:title="@string/key1_action"
 *         android:summary="@string/key1_summary"&gt;
 *         &lt;intent
 *             android:action="key1.ACTION"
 *             android:targetPackage="key1.package"
 *             android:targetClass="key1.class" /&gt;
 *     &lt;/PreferenceScreen&gt;
 * &lt;/PreferenceScreen&gt;
 * </pre>
 *
 * <p>
 * The standard pattern for implementing any of the abstract methods is the following:
 * <ul>
 * <li> If the supplied arguments are enough for the authenticator to fully satisfy the request
 * then it will do so and return a {@link Bundle} that contains the results.
 * <li> If the authenticator needs information from the user to satisfy the request then it
 * will create an {@link Intent} to an activity that will prompt the user for the information
 * and then carry out the request. This intent must be returned in a Bundle as key
 * {@link AccountManager#KEY_INTENT}.
 * <p>
 * The activity needs to return the final result when it is complete so the Intent should contain
 * the {@link AccountAuthenticatorResponse} as {@link AccountManager#KEY_ACCOUNT_MANAGER_RESPONSE}.
 * The activity must then call {@link AccountAuthenticatorResponse#onResult} or
 * {@link AccountAuthenticatorResponse#onError} when it is complete.
 * <li> If the authenticator cannot synchronously process the request and return a result then it
 * may choose to return null and then use the AccountManagerResponse to send the result
 * when it has completed the request.
 * </ul>
 * <p>
 * The following descriptions of each of the abstract authenticator methods will not describe the
 * possible asynchronous nature of the request handling and will instead just describe the input
 * parameters and the expected result.
 * <p>
 * When writing an activity to satisfy these requests one must pass in the AccountManagerResponse
 * and return the result via that response when the activity finishes (or whenever else  the
 * activity author deems it is the correct time to respond).
 * The {@link AccountAuthenticatorActivity} handles this, so one may wish to extend that when
 * writing activities to handle these requests.
 */
public abstract class AbstractAccountAuthenticator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.026 -0500", hash_original_field = "E439044E2C88077D7419CAC5292C15CF", hash_generated_field = "BF3374BAD0101417026E99889985E21E")

    private static final String TAG = "AccountAuthenticator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.037 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.202 -0500", hash_original_field = "2D5E29FC7BC3EDC39507E0A8AD5A6CDE", hash_generated_field = "B996B8C49C2307FDF0CA3803832CA9DC")

    private Transport mTransport = new Transport();

    private class Transport extends IAccountAuthenticator.Stub {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.061 -0500", hash_original_method = "407AD6E8DF513E5FCA508D8E605549E0", hash_generated_method = "342F08F99FF2CDD09FF6C00F4921DCC4")
        
public void addAccount(IAccountAuthenticatorResponse response, String accountType,
                String authTokenType, String[] features, Bundle options)
                throws RemoteException {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "addAccount: accountType " + accountType
                        + ", authTokenType " + authTokenType
                        + ", features " + (features == null ? "[]" : Arrays.toString(features)));
            }
            checkBinderPermission();
            try {
                final Bundle result = AbstractAccountAuthenticator.this.addAccount(
                    new AccountAuthenticatorResponse(response),
                        accountType, authTokenType, features, options);
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    result.keySet(); // force it to be unparcelled
                    Log.v(TAG, "addAccount: result " + AccountManager.sanitizeResult(result));
                }
                if (result != null) {
                    response.onResult(result);
                }
            } catch (Exception e) {
                handleException(response, "addAccount", accountType, e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.076 -0500", hash_original_method = "655C56EFA9B46DA2E6362CB661909222", hash_generated_method = "C20BFB11EDCA13D22C1E283722BE0576")
        
public void confirmCredentials(IAccountAuthenticatorResponse response,
                Account account, Bundle options) throws RemoteException {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "confirmCredentials: " + account);
            }
            checkBinderPermission();
            try {
                final Bundle result = AbstractAccountAuthenticator.this.confirmCredentials(
                    new AccountAuthenticatorResponse(response), account, options);
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    result.keySet(); // force it to be unparcelled
                    Log.v(TAG, "confirmCredentials: result "
                            + AccountManager.sanitizeResult(result));
                }
                if (result != null) {
                    response.onResult(result);
                }
            } catch (Exception e) {
                handleException(response, "confirmCredentials", account.toString(), e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.087 -0500", hash_original_method = "0B8E04381CE4543FA42B184881ECD368", hash_generated_method = "5F56A3C38BCD0F48299A67B7A736ACC9")
        
public void getAuthTokenLabel(IAccountAuthenticatorResponse response,
                String authTokenType)
                throws RemoteException {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "getAuthTokenLabel: authTokenType " + authTokenType);
            }
            checkBinderPermission();
            try {
                Bundle result = new Bundle();
                result.putString(AccountManager.KEY_AUTH_TOKEN_LABEL,
                        AbstractAccountAuthenticator.this.getAuthTokenLabel(authTokenType));
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    result.keySet(); // force it to be unparcelled
                    Log.v(TAG, "getAuthTokenLabel: result "
                            + AccountManager.sanitizeResult(result));
                }
                response.onResult(result);
            } catch (Exception e) {
                handleException(response, "getAuthTokenLabel", authTokenType, e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.117 -0500", hash_original_method = "4C21311CEF34DFAF64EF2CBE1D7F71D4", hash_generated_method = "FC7F957FD38744312ED4CD01A97D51B8")
        
public void getAuthToken(IAccountAuthenticatorResponse response,
                Account account, String authTokenType, Bundle loginOptions)
                throws RemoteException {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "getAuthToken: " + account
                        + ", authTokenType " + authTokenType);
            }
            checkBinderPermission();
            try {
                final Bundle result = AbstractAccountAuthenticator.this.getAuthToken(
                        new AccountAuthenticatorResponse(response), account,
                        authTokenType, loginOptions);
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    result.keySet(); // force it to be unparcelled
                    Log.v(TAG, "getAuthToken: result " + AccountManager.sanitizeResult(result));
                }
                if (result != null) {
                    response.onResult(result);
                }
            } catch (Exception e) {
                handleException(response, "getAuthToken",
                        account.toString() + "," + authTokenType, e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.129 -0500", hash_original_method = "1AEEB273836952F76F107380EE41EC51", hash_generated_method = "D7683B8A7BEFF549D02DFB63DE230292")
        
public void updateCredentials(IAccountAuthenticatorResponse response, Account account,
                String authTokenType, Bundle loginOptions) throws RemoteException {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "updateCredentials: " + account
                        + ", authTokenType " + authTokenType);
            }
            checkBinderPermission();
            try {
                final Bundle result = AbstractAccountAuthenticator.this.updateCredentials(
                    new AccountAuthenticatorResponse(response), account,
                        authTokenType, loginOptions);
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    result.keySet(); // force it to be unparcelled
                    Log.v(TAG, "updateCredentials: result "
                            + AccountManager.sanitizeResult(result));
                }
                if (result != null) {
                    response.onResult(result);
                }
            } catch (Exception e) {
                handleException(response, "updateCredentials",
                        account.toString() + "," + authTokenType, e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.137 -0500", hash_original_method = "0E386DBDFED388C2F6E9D818F72B2DFA", hash_generated_method = "E7658B03951F0BD802E884F2362396C7")
        
public void editProperties(IAccountAuthenticatorResponse response,
                String accountType) throws RemoteException {
            checkBinderPermission();
            try {
                final Bundle result = AbstractAccountAuthenticator.this.editProperties(
                    new AccountAuthenticatorResponse(response), accountType);
                if (result != null) {
                    response.onResult(result);
                }
            } catch (Exception e) {
                handleException(response, "editProperties", accountType, e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.145 -0500", hash_original_method = "ED7B623313911EFB27297E4C59F3BA80", hash_generated_method = "5B98ACE416E9A8BCB2C4EF06D68C85F2")
        
public void hasFeatures(IAccountAuthenticatorResponse response,
                Account account, String[] features) throws RemoteException {
            checkBinderPermission();
            try {
                final Bundle result = AbstractAccountAuthenticator.this.hasFeatures(
                    new AccountAuthenticatorResponse(response), account, features);
                if (result != null) {
                    response.onResult(result);
                }
            } catch (Exception e) {
                handleException(response, "hasFeatures", account.toString(), e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.152 -0500", hash_original_method = "09B1DE63B1D9788B32F2239098E3EBA0", hash_generated_method = "1EBB264D7618C49C54EDB4BC8AF60D93")
        
public void getAccountRemovalAllowed(IAccountAuthenticatorResponse response,
                Account account) throws RemoteException {
            checkBinderPermission();
            try {
                final Bundle result = AbstractAccountAuthenticator.this.getAccountRemovalAllowed(
                    new AccountAuthenticatorResponse(response), account);
                if (result != null) {
                    response.onResult(result);
                }
            } catch (Exception e) {
                handleException(response, "getAccountRemovalAllowed", account.toString(), e);
            }
        }
    }

    @DSComment("constructor")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.043 -0500", hash_original_method = "9F3D7C5E34F274AF92FE1930A0A4DDDF", hash_generated_method = "273418773D979EAC578A93251DBF332A")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public AbstractAccountAuthenticator(Context context) {
        mContext = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.191 -0500", hash_original_method = "95E526E96C0C7C30932DEDFB43544813", hash_generated_method = "A0D6215A6F4913E32BE30E9DC640FFEE")
    
private void handleException(IAccountAuthenticatorResponse response, String method,
            String data, Exception e) throws RemoteException {
        if (e instanceof NetworkErrorException) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, method + "(" + data + ")", e);
            }
            response.onError(AccountManager.ERROR_CODE_NETWORK_ERROR, e.getMessage());
        } else if (e instanceof UnsupportedOperationException) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, method + "(" + data + ")", e);
            }
            response.onError(AccountManager.ERROR_CODE_UNSUPPORTED_OPERATION,
                    method + " not supported");
        } else if (e instanceof IllegalArgumentException) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, method + "(" + data + ")", e);
            }
            response.onError(AccountManager.ERROR_CODE_BAD_ARGUMENTS,
                    method + " not supported");
        } else {
            Log.w(TAG, method + "(" + data + ")", e);
            response.onError(AccountManager.ERROR_CODE_REMOTE_EXCEPTION,
                    method + " failed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.197 -0500", hash_original_method = "3939F878E9AB1367A4D6F0AA3E405BEB", hash_generated_method = "525E51D9760B3BB804EF9219F3110B07")
    
private void checkBinderPermission() {
        final int uid = Binder.getCallingUid();
        final String perm = Manifest.permission.ACCOUNT_MANAGER;
        if (mContext.checkCallingOrSelfPermission(perm) != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException("caller uid " + uid + " lacks " + perm);
        }
    }

    /**
     * @return the IBinder for the AccountAuthenticator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.208 -0500", hash_original_method = "6DC54D8912A95F1FD9D0B49763BAD989", hash_generated_method = "E85CCD2CD8210FBCA5AD7E9CA4E95103")
    
public final IBinder getIBinder() {
        return mTransport.asBinder();
    }

    /**
     * Returns a Bundle that contains the Intent of the activity that can be used to edit the
     * properties. In order to indicate success the activity should call response.setResult()
     * with a non-null Bundle.
     * @param response used to set the result for the request. If the Constants.INTENT_KEY
     *   is set in the bundle then this response field is to be used for sending future
     *   results if and when the Intent is started.
     * @param accountType the AccountType whose properties are to be edited.
     * @return a Bundle containing the result or the Intent to start to continue the request.
     *   If this is null then the request is considered to still be active and the result should
     *   sent later using response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.214 -0500", hash_original_method = "31039A7331CC8B6B53593CE65AC0222F", hash_generated_method = "952D5676681A5E6B061BE7CC4D5F403D")
    
public abstract Bundle editProperties(AccountAuthenticatorResponse response,
            String accountType);

    /**
     * Adds an account of the specified accountType.
     * @param response to send the result back to the AccountManager, will never be null
     * @param accountType the type of account to add, will never be null
     * @param authTokenType the type of auth token to retrieve after adding the account, may be null
     * @param requiredFeatures a String array of authenticator-specific features that the added
     * account must support, may be null
     * @param options a Bundle of authenticator-specific options, may be null
     * @return a Bundle result or null if the result is to be returned via the response. The result
     * will contain either:
     * <ul>
     * <li> {@link AccountManager#KEY_INTENT}, or
     * <li> {@link AccountManager#KEY_ACCOUNT_NAME} and {@link AccountManager#KEY_ACCOUNT_TYPE} of
     * the account that was added, or
     * <li> {@link AccountManager#KEY_ERROR_CODE} and {@link AccountManager#KEY_ERROR_MESSAGE} to
     * indicate an error
     * </ul>
     * @throws NetworkErrorException if the authenticator could not honor the request due to a
     * network error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.219 -0500", hash_original_method = "B3194B71D1A4051E445D9C0426258147", hash_generated_method = "8FD7408C3510BA75FB0D46C4E0073484")
    
public abstract Bundle addAccount(AccountAuthenticatorResponse response, String accountType,
            String authTokenType, String[] requiredFeatures, Bundle options)
            throws NetworkErrorException;

    /**
     * Checks that the user knows the credentials of an account.
     * @param response to send the result back to the AccountManager, will never be null
     * @param account the account whose credentials are to be checked, will never be null
     * @param options a Bundle of authenticator-specific options, may be null
     * @return a Bundle result or null if the result is to be returned via the response. The result
     * will contain either:
     * <ul>
     * <li> {@link AccountManager#KEY_INTENT}, or
     * <li> {@link AccountManager#KEY_BOOLEAN_RESULT}, true if the check succeeded, false otherwise
     * <li> {@link AccountManager#KEY_ERROR_CODE} and {@link AccountManager#KEY_ERROR_MESSAGE} to
     * indicate an error
     * </ul>
     * @throws NetworkErrorException if the authenticator could not honor the request due to a
     * network error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.224 -0500", hash_original_method = "113062179074BC4E456696E4267AFB92", hash_generated_method = "117B1E3C3F01AFF77C67E6E0FE54E1B7")
    
public abstract Bundle confirmCredentials(AccountAuthenticatorResponse response,
            Account account, Bundle options)
            throws NetworkErrorException;
    /**
     * Gets the authtoken for an account.
     * @param response to send the result back to the AccountManager, will never be null
     * @param account the account whose credentials are to be retrieved, will never be null
     * @param authTokenType the type of auth token to retrieve, will never be null
     * @param options a Bundle of authenticator-specific options, may be null
     * @return a Bundle result or null if the result is to be returned via the response. The result
     * will contain either:
     * <ul>
     * <li> {@link AccountManager#KEY_INTENT}, or
     * <li> {@link AccountManager#KEY_ACCOUNT_NAME}, {@link AccountManager#KEY_ACCOUNT_TYPE},
     * and {@link AccountManager#KEY_AUTHTOKEN}, or
     * <li> {@link AccountManager#KEY_ERROR_CODE} and {@link AccountManager#KEY_ERROR_MESSAGE} to
     * indicate an error
     * </ul>
     * @throws NetworkErrorException if the authenticator could not honor the request due to a
     * network error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.229 -0500", hash_original_method = "EBE567DB4B9F6AC9F4BD78B9E2C4BB30", hash_generated_method = "548C7E630A039DC69E47A1F9D0138549")
    
public abstract Bundle getAuthToken(AccountAuthenticatorResponse response,
            Account account, String authTokenType, Bundle options)
            throws NetworkErrorException;

    /**
     * Ask the authenticator for a localized label for the given authTokenType.
     * @param authTokenType the authTokenType whose label is to be returned, will never be null
     * @return the localized label of the auth token type, may be null if the type isn't known
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.234 -0500", hash_original_method = "6807373873E6806B933E17EB67E28ECA", hash_generated_method = "FD1A09CBCE9BC752396FCFB40E6235C1")
    
public abstract String getAuthTokenLabel(String authTokenType);

    /**
     * Update the locally stored credentials for an account.
     * @param response to send the result back to the AccountManager, will never be null
     * @param account the account whose credentials are to be updated, will never be null
     * @param authTokenType the type of auth token to retrieve after updating the credentials,
     * may be null
     * @param options a Bundle of authenticator-specific options, may be null
     * @return a Bundle result or null if the result is to be returned via the response. The result
     * will contain either:
     * <ul>
     * <li> {@link AccountManager#KEY_INTENT}, or
     * <li> {@link AccountManager#KEY_ACCOUNT_NAME} and {@link AccountManager#KEY_ACCOUNT_TYPE} of
     * the account that was added, or
     * <li> {@link AccountManager#KEY_ERROR_CODE} and {@link AccountManager#KEY_ERROR_MESSAGE} to
     * indicate an error
     * </ul>
     * @throws NetworkErrorException if the authenticator could not honor the request due to a
     * network error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.239 -0500", hash_original_method = "02C8DFCA44DDE65799EEDEDD187D7A73", hash_generated_method = "0B2BAF6302BB25423091E5062AD84111")
    
public abstract Bundle updateCredentials(AccountAuthenticatorResponse response,
            Account account, String authTokenType, Bundle options) throws NetworkErrorException;

    /**
     * Checks if the account supports all the specified authenticator specific features.
     * @param response to send the result back to the AccountManager, will never be null
     * @param account the account to check, will never be null
     * @param features an array of features to check, will never be null
     * @return a Bundle result or null if the result is to be returned via the response. The result
     * will contain either:
     * <ul>
     * <li> {@link AccountManager#KEY_INTENT}, or
     * <li> {@link AccountManager#KEY_BOOLEAN_RESULT}, true if the account has all the features,
     * false otherwise
     * <li> {@link AccountManager#KEY_ERROR_CODE} and {@link AccountManager#KEY_ERROR_MESSAGE} to
     * indicate an error
     * </ul>
     * @throws NetworkErrorException if the authenticator could not honor the request due to a
     * network error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.243 -0500", hash_original_method = "A0384D242FEB07714149BB3529B3995E", hash_generated_method = "387FCB531A48C5159F34A9219B158E91")
    
public abstract Bundle hasFeatures(AccountAuthenticatorResponse response,
            Account account, String[] features) throws NetworkErrorException;

    /**
     * Checks if the removal of this account is allowed.
     * @param response to send the result back to the AccountManager, will never be null
     * @param account the account to check, will never be null
     * @return a Bundle result or null if the result is to be returned via the response. The result
     * will contain either:
     * <ul>
     * <li> {@link AccountManager#KEY_INTENT}, or
     * <li> {@link AccountManager#KEY_BOOLEAN_RESULT}, true if the removal of the account is
     * allowed, false otherwise
     * <li> {@link AccountManager#KEY_ERROR_CODE} and {@link AccountManager#KEY_ERROR_MESSAGE} to
     * indicate an error
     * </ul>
     * @throws NetworkErrorException if the authenticator could not honor the request due to a
     * network error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-18 14:17:07.249 -0500", hash_original_method = "6F844A6749C692C7821327095809795F", hash_generated_method = "7E44D248202B98DE8E662032A3E0332B")
    
public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse response,
            Account account) throws NetworkErrorException {
        final Bundle result = new Bundle();
        result.putBoolean(AccountManager.KEY_BOOLEAN_RESULT, true);
        return result;
    }
}
