/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.security.KeyPair;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import libcore.util.Objects;

import org.apache.harmony.xnet.provider.jsse.TrustedCertificateStore;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;

public final class KeyChain {

    /**
     * Returns an {@code Intent} that can be used for credential
     * installation. The intent may be used without any extras, in
     * which case the user will be able to install credentials from
     * their own source.
     *
     * <p>Alternatively, {@link #EXTRA_CERTIFICATE} or {@link
     * #EXTRA_PKCS12} maybe used to specify the bytes of an X.509
     * certificate or a PKCS#12 key store for installation. These
     * extras may be combined with {@link #EXTRA_NAME} to provide a
     * default alias name for credentials being installed.
     *
     * <p>When used with {@link Activity#startActivityForResult},
     * {@link Activity#RESULT_OK} will be returned if a credential was
     * successfully installed, otherwise {@link
     * Activity#RESULT_CANCELED} will be returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.649 -0500", hash_original_method = "06FC50D13B83BB8887D669EBF0AB4A29", hash_generated_method = "EAEAFD3BE5465D1E05B8906A1C11D40F")
    
public static Intent createInstallIntent() {
        Intent intent = new Intent(ACTION_INSTALL);
        intent.setClassName("com.android.certinstaller",
                            "com.android.certinstaller.CertInstallerMain");
        return intent;
    }

    /**
     * Launches an {@code Activity} for the user to select the alias
     * for a private key and certificate pair for authentication. The
     * selected alias or null will be returned via the
     * KeyChainAliasCallback callback.
     *
     * <p>{@code keyTypes} and {@code issuers} may be used to
     * highlight suggested choices to the user, although to cope with
     * sometimes erroneous values provided by servers, the user may be
     * able to override these suggestions.
     *
     * <p>{@code host} and {@code port} may be used to give the user
     * more context about the server requesting the credentials.
     *
     * <p>{@code alias} allows the chooser to preselect an existing
     * alias which will still be subject to user confirmation.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#USE_CREDENTIALS}.
     *
     * @param activity The {@link Activity} context to use for
     *     launching the new sub-Activity to prompt the user to select
     *     a private key; used only to call startActivity(); must not
     *     be null.
     * @param response Callback to invoke when the request completes;
     *     must not be null
     * @param keyTypes The acceptable types of asymmetric keys such as
     *     "RSA" or "DSA", or a null array.
     * @param issuers The acceptable certificate issuers for the
     *     certificate matching the private key, or null.
     * @param host The host name of the server requesting the
     *     certificate, or null if unavailable.
     * @param port The port number of the server requesting the
     *     certificate, or -1 if unavailable.
     * @param alias The alias to preselect if available, or null if
     *     unavailable.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.653 -0500", hash_original_method = "E907821151711095569DC644B61BB753", hash_generated_method = "7C98775AC542C6D186951CA07D4D010A")
    
public static void choosePrivateKeyAlias(Activity activity, KeyChainAliasCallback response,
                                             String[] keyTypes, Principal[] issuers,
                                             String host, int port,
                                             String alias) {
        /*
         * TODO currently keyTypes, issuers are unused. They are meant
         * to follow the semantics and purpose of X509KeyManager
         * method arguments.
         *
         * keyTypes would allow the list to be filtered and typically
         * will be set correctly by the server. In practice today,
         * most all users will want only RSA, rarely DSA, and usually
         * only a small number of certs will be available.
         *
         * issuers is typically not useful. Some servers historically
         * will send the entire list of public CAs known to the
         * server. Others will send none. If this is used, if there
         * are no matches after applying the constraint, it should be
         * ignored.
         */
        if (activity == null) {
            throw new NullPointerException("activity == null");
        }
        if (response == null) {
            throw new NullPointerException("response == null");
        }
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.putExtra(EXTRA_RESPONSE, new AliasResponse(response));
        intent.putExtra(EXTRA_HOST, host);
        intent.putExtra(EXTRA_PORT, port);
        intent.putExtra(EXTRA_ALIAS, alias);
        // the PendingIntent is used to get calling package name
        intent.putExtra(EXTRA_SENDER, PendingIntent.getActivity(activity, 0, new Intent(), 0));
        activity.startActivity(intent);
    }

    /**
     * Returns the {@code PrivateKey} for the requested alias, or null
     * if no there is no result.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#USE_CREDENTIALS}.
     *
     * @param alias The alias of the desired private key, typically
     * returned via {@link KeyChainAliasCallback#alias}.
     * @throws KeyChainException if the alias was valid but there was some problem accessing it.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.669 -0500", hash_original_method = "DF062E6FA636775439DA598053BC2C74", hash_generated_method = "2D9A8B83BCA9D73C008133748AF8F217")
    
public static PrivateKey getPrivateKey(Context context, String alias)
            throws KeyChainException, InterruptedException {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        KeyChainConnection keyChainConnection = bind(context);
        try {
            IKeyChainService keyChainService = keyChainConnection.getService();
            byte[] privateKeyBytes = keyChainService.getPrivateKey(alias);
            return toPrivateKey(privateKeyBytes);
        } catch (RemoteException e) {
            throw new KeyChainException(e);
        } catch (RuntimeException e) {
            // only certain RuntimeExceptions can be propagated across the IKeyChainService call
            throw new KeyChainException(e);
        } finally {
            keyChainConnection.close();
        }
    }

    /**
     * Returns the {@code X509Certificate} chain for the requested
     * alias, or null if no there is no result.
     *
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#USE_CREDENTIALS}.
     *
     * @param alias The alias of the desired certificate chain, typically
     * returned via {@link KeyChainAliasCallback#alias}.
     * @throws KeyChainException if the alias was valid but there was some problem accessing it.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.672 -0500", hash_original_method = "E3D944E68CC612365472BFA8499DA506", hash_generated_method = "84ACC2912769A26659673923B13D8A9A")
    
public static X509Certificate[] getCertificateChain(Context context, String alias)
            throws KeyChainException, InterruptedException {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        KeyChainConnection keyChainConnection = bind(context);
        try {
            IKeyChainService keyChainService = keyChainConnection.getService();
            byte[] certificateBytes = keyChainService.getCertificate(alias);
            List<X509Certificate> chain = new ArrayList<X509Certificate>();
            chain.add(toCertificate(certificateBytes));
            TrustedCertificateStore store = new TrustedCertificateStore();
            for (int i = 0; true; i++) {
                X509Certificate cert = chain.get(i);
                if (Objects.equal(cert.getSubjectX500Principal(), cert.getIssuerX500Principal())) {
                    break;
                }
                X509Certificate issuer = store.findIssuer(cert);
                if (issuer == null) {
                    break;
                }
                chain.add(issuer);
            }
            return chain.toArray(new X509Certificate[chain.size()]);
        } catch (RemoteException e) {
            throw new KeyChainException(e);
        } catch (RuntimeException e) {
            // only certain RuntimeExceptions can be propagated across the IKeyChainService call
            throw new KeyChainException(e);
        } finally {
            keyChainConnection.close();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.676 -0500", hash_original_method = "2D88B737F06C5681279A96FA6505C78B", hash_generated_method = "D3198FDCE6803459112E503840DEBC1F")
    
private static PrivateKey toPrivateKey(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("bytes == null");
        }
        try {
            KeyPair keyPair = (KeyPair) Credentials.convertFromPem(bytes).get(0);
            return keyPair.getPrivate();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.679 -0500", hash_original_method = "FBC33F30F54EF78C28A947D81B2D2FD8", hash_generated_method = "3B765872A0AE9B68E04B09B1EAFE0EF9")
    
private static X509Certificate toCertificate(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("bytes == null");
        }
        try {
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            Certificate cert = certFactory.generateCertificate(new ByteArrayInputStream(bytes));
            return (X509Certificate) cert;
        } catch (CertificateException e) {
            throw new AssertionError(e);
        }
    }
    
    public static KeyChainConnection bind(Context context) throws InterruptedException {
        if (context == null) {
            throw new NullPointerException("context == null");
        }
        ensureNotOnMainThread(context);
        final BlockingQueue<IKeyChainService> q = new LinkedBlockingQueue<IKeyChainService>(1);
        ServiceConnection keyChainServiceConnection = new ServiceConnection() {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.704 -0500", hash_original_field = "21255A01152DD24A86DE12F87E27FF3B", hash_generated_field = "C431883BBF8215516E9EEAF80D2813D2")

            volatile boolean mConnectedAtLeastOnce = false;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.708 -0500", hash_original_method = "93DC1C4521E69AF1011605C4E54C3650", hash_generated_method = "1BF2EFF5D5F0D6EA0FCD92B8049B3630")
            
@Override public void onServiceConnected(ComponentName name, IBinder service) {
                if (!mConnectedAtLeastOnce) {
                    mConnectedAtLeastOnce = true;
                    try {
                        q.put(IKeyChainService.Stub.asInterface(service));
                    } catch (InterruptedException e) {
                        // will never happen, since the queue starts with one available slot
                    }
                }
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.711 -0500", hash_original_method = "A6DD54D24097AC8AE24CBCD0FEC205D9", hash_generated_method = "60A9F3D2B364A7DC9DECB7C12D4F3ECC")
            
@Override public void onServiceDisconnected(ComponentName name) {}
        };
        boolean isBound = context.bindService(new Intent(IKeyChainService.class.getName()),
                                              keyChainServiceConnection,
                                              Context.BIND_AUTO_CREATE);
        if (!isBound) {
            throw new AssertionError("could not bind to KeyChainService");
        }
        return new KeyChainConnection(context, keyChainServiceConnection, q.take());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.718 -0500", hash_original_method = "7DAE0D3A2CCC6CA9F77C8F9024139D9A", hash_generated_method = "ED43C8B84829F8F34047312F8EF0394F")
    
private static void ensureNotOnMainThread(Context context) {
        Looper looper = Looper.myLooper();
        if (looper != null && looper == context.getMainLooper()) {
            throw new IllegalStateException(
                    "calling this from your main thread can lead to deadlock");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.611 -0500", hash_original_field = "5ECC530E410AC78FFBA3C9F8F2A0C707", hash_generated_field = "DB4CC18D22127F06448B97E6BAD252CD")

    private static final String TAG = "KeyChain";
    
    private static class AliasResponse extends IKeyChainAliasCallback.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.657 -0500", hash_original_field = "9CC5013B5B2A8FBBD02E50EB12848B32", hash_generated_field = "3B8D8D094E0DD386140E6419313FE34D")

        private  KeyChainAliasCallback keyChainAliasResponse;
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.660 -0500", hash_original_method = "C9AAF5E97D9880605AC7CEDD0F5EF602", hash_generated_method = "6257DABFC786F50A3D2423B7CF684988")
        
private AliasResponse(KeyChainAliasCallback keyChainAliasResponse) {
            this.keyChainAliasResponse = keyChainAliasResponse;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.663 -0500", hash_original_method = "253185D367E73ED341795E1D21B0472E", hash_generated_method = "3E99995A0E4493EFE66528DD2D34C978")
        
@Override public void alias(String alias) {
            keyChainAliasResponse.alias(alias);
        }
        
    }
    
    public final static class KeyChainConnection implements Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.682 -0500", hash_original_field = "571FE4403DDA9BF54693EBF4F0D6639D", hash_generated_field = "FFC623C2EA984831A33BAADC181E897E")

        private  Context context;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.685 -0500", hash_original_field = "36BF213323933A944FF87A89C7972A14", hash_generated_field = "F03DA54B0850C99BBEDD6DC4593A8704")

        private  ServiceConnection serviceConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.688 -0500", hash_original_field = "3FAA0CAB83CBC9D427861B15897609E2", hash_generated_field = "3B2474C4869160C7A0D7AF9B8ADD0D10")

        private  IKeyChainService service;
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.692 -0500", hash_original_method = "0B75A6D253D58C29BB28E672713E5120", hash_generated_method = "EC2DDFDB85129E98429D837C2B7DF946")
        
private KeyChainConnection(Context context,
                                   ServiceConnection serviceConnection,
                                   IKeyChainService service) {
            this.context = context;
            this.serviceConnection = serviceConnection;
            this.service = service;
        }
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.695 -0500", hash_original_method = "5F7D82BAE91D9994EB60B4EFC2ED07C1", hash_generated_method = "AF4DCBDBDB2A9D97E7BF3B0343EB4EBB")
        
@Override public void close() {
            context.unbindService(serviceConnection);
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.698 -0500", hash_original_method = "954EE7241574324971051CDC9EEAAD50", hash_generated_method = "53CF2DA78B8B234F9251222D09CDC4A6")
        
public IKeyChainService getService() {
            return service;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.614 -0500", hash_original_field = "99DAEC3D78ED5C74CEB7FF0ADC0BD30F", hash_generated_field = "2855009EDDCADE85D95C102D96763D94")

    public static final String ACCOUNT_TYPE = "com.android.keychain";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.617 -0500", hash_original_field = "C98CFEC57BE028FDBA5896D2DD49E613", hash_generated_field = "76C121E893A74588E32B794333E72032")

    private static final String ACTION_CHOOSER = "com.android.keychain.CHOOSER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.621 -0500", hash_original_field = "D6FA4FE2FEC6B263BB35A849D02802C4", hash_generated_field = "AEFAE834852EA3825F5C1663B5547EE6")

    public static final String EXTRA_RESPONSE = "response";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.624 -0500", hash_original_field = "D304E0BCAD809DC7674F77FD6E75D911", hash_generated_field = "15045585F25BD1CF8632154440DC8620")

    public static final String EXTRA_HOST = "host";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.628 -0500", hash_original_field = "2745ACF6C66C3AC3D3DC95CFDE717190", hash_generated_field = "3A6CE87107AFF5BB3B6CC770B1BE705F")

    public static final String EXTRA_PORT = "port";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.631 -0500", hash_original_field = "3D452D17B8D855EDD8BE44E1F12661F2", hash_generated_field = "12136C3DD9974ECECB48BA0B3595CE16")

    public static final String EXTRA_ALIAS = "alias";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.634 -0500", hash_original_field = "57E9E68D561A2210EDD54CE533C4253E", hash_generated_field = "3EAE09CC2B58B4F52A9C75979C34CC85")

    public static final String EXTRA_SENDER = "sender";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.637 -0500", hash_original_field = "EE0178B06BF186CA30CB2890BC4C2A0F", hash_generated_field = "86B1C12ACDF02E85FDAC47D49793B4FE")

    private static final String ACTION_INSTALL = "android.credentials.INSTALL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.640 -0500", hash_original_field = "75C1CBE32C120C778EF3C7E0D15E07C7", hash_generated_field = "461D6B9226D8DE0EB156CD91946FB988")

    // Compatible with old com.android.certinstaller.CredentialHelper.CERT_NAME_KEY
    public static final String EXTRA_NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.643 -0500", hash_original_field = "C496E11F5B4A7FE37365621FF595B1D0", hash_generated_field = "74ADABCFBA07274599FBB0C8C2B16BC8")

    // Compatible with old android.security.Credentials.CERTIFICATE
    public static final String EXTRA_CERTIFICATE = "CERT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.646 -0500", hash_original_field = "ECAACCED609F8D7EFA47410A859F7628", hash_generated_field = "18A16B95B2C79D3EDBB084BB4B84782D")

    // Compatible with old android.security.Credentials.PKCS12
    public static final String EXTRA_PKCS12 = "PKCS12";
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.021 -0400", hash_original_method = "72F463E9A92E033797A9FA0AB2D9F5CF", hash_generated_method = "72F463E9A92E033797A9FA0AB2D9F5CF")
    public KeyChain ()
    {
        //Synthesized constructor
    }
}

