package android.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
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

public final class KeyChain {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.103 -0400", hash_original_method = "72F463E9A92E033797A9FA0AB2D9F5CF", hash_generated_method = "72F463E9A92E033797A9FA0AB2D9F5CF")
    public KeyChain ()
    {
        
    }


    @DSModeled(DSC.SPEC)
    public static Intent createInstallIntent() {
        Intent intent = new Intent(ACTION_INSTALL);
        intent.setClassName("com.android.certinstaller",
                            "com.android.certinstaller.CertInstallerMain");
        return intent;
    }

    
    @DSModeled(DSC.SAFE)
    public static void choosePrivateKeyAlias(Activity activity, KeyChainAliasCallback response,
                                             String[] keyTypes, Principal[] issuers,
                                             String host, int port,
                                             String alias) {
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
        intent.putExtra(EXTRA_SENDER, PendingIntent.getActivity(activity, 0, new Intent(), 0));
        activity.startActivity(intent);
    }

    
    @DSModeled(DSC.SAFE)
    public static PrivateKey getPrivateKey(Context context, String alias) throws KeyChainException, InterruptedException {
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
            throw new KeyChainException(e);
        } finally {
            keyChainConnection.close();
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static X509Certificate[] getCertificateChain(Context context, String alias) throws KeyChainException, InterruptedException {
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
            throw new KeyChainException(e);
        } finally {
            keyChainConnection.close();
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static KeyChainConnection bind(Context context) throws InterruptedException {
        if (context == null) {
            throw new NullPointerException("context == null");
        }
        ensureNotOnMainThread(context);
        final BlockingQueue<IKeyChainService> q = new LinkedBlockingQueue<IKeyChainService>(1);
        ServiceConnection keyChainServiceConnection = new ServiceConnection() {
            volatile boolean mConnectedAtLeastOnce = false;
            @Override public void onServiceConnected(ComponentName name, IBinder service) {
                if (!mConnectedAtLeastOnce) {
                    mConnectedAtLeastOnce = true;
                    try {
                        q.put(IKeyChainService.Stub.asInterface(service));
                    } catch (InterruptedException e) {
                    }
                }
            }
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

    
    @DSModeled(DSC.SAFE)
    private static void ensureNotOnMainThread(Context context) {
        Looper looper = Looper.myLooper();
        if (looper != null && looper == context.getMainLooper()) {
            throw new IllegalStateException(
                    "calling this from your main thread can lead to deadlock");
        }
    }

    
    private static class AliasResponse extends IKeyChainAliasCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.104 -0400", hash_original_field = "80DCD86245D888AD0689C6D8DB694C09", hash_generated_field = "3B8D8D094E0DD386140E6419313FE34D")

        private KeyChainAliasCallback keyChainAliasResponse;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.104 -0400", hash_original_method = "C9AAF5E97D9880605AC7CEDD0F5EF602", hash_generated_method = "734EA7C6CEA33BDAA3DD6D725B46AD40")
        private  AliasResponse(KeyChainAliasCallback keyChainAliasResponse) {
            this.keyChainAliasResponse = keyChainAliasResponse;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.105 -0400", hash_original_method = "253185D367E73ED341795E1D21B0472E", hash_generated_method = "4595967A2E3427C3A4895D2799F904F4")
        @Override
        public void alias(String alias) {
            keyChainAliasResponse.alias(alias);
            addTaint(alias.getTaint());
            
            
        }

        
    }


    
    public final static class KeyChainConnection implements Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.105 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "FFC623C2EA984831A33BAADC181E897E")

        private Context context;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.105 -0400", hash_original_field = "A36081F4E1A2CF21DE3F0D4609BEE1AA", hash_generated_field = "F03DA54B0850C99BBEDD6DC4593A8704")

        private ServiceConnection serviceConnection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.105 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "3B2474C4869160C7A0D7AF9B8ADD0D10")

        private IKeyChainService service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.105 -0400", hash_original_method = "0B75A6D253D58C29BB28E672713E5120", hash_generated_method = "6C4CDE9C615FDBE0665776FFBD223C20")
        private  KeyChainConnection(Context context,
                                   ServiceConnection serviceConnection,
                                   IKeyChainService service) {
            this.context = context;
            this.serviceConnection = serviceConnection;
            this.service = service;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.106 -0400", hash_original_method = "5F7D82BAE91D9994EB60B4EFC2ED07C1", hash_generated_method = "9F50B99A37D6B57C2CD3AB13B97D7FC3")
        @Override
        public void close() {
            context.unbindService(serviceConnection);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_method = "954EE7241574324971051CDC9EEAAD50", hash_generated_method = "19F589D85C11ECC52A97690BD716451C")
        public IKeyChainService getService() {
            IKeyChainService varB4EAC82CA7396A68D541C85D26508E83_1438892754 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1438892754 = service;
            varB4EAC82CA7396A68D541C85D26508E83_1438892754.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1438892754;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "3C28EBE3D6578ABD3A07D152CB00AEB1", hash_generated_field = "DB4CC18D22127F06448B97E6BAD252CD")

    private static final String TAG = "KeyChain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "18EB3D4AD514D4B4757DFA150D1F14A5", hash_generated_field = "2855009EDDCADE85D95C102D96763D94")

    public static final String ACCOUNT_TYPE = "com.android.keychain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "C90DB53BFFA4D3453A8E0D59D7B20D65", hash_generated_field = "76C121E893A74588E32B794333E72032")

    private static final String ACTION_CHOOSER = "com.android.keychain.CHOOSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "9428AE5DAC7950C2E02C1B85CC103C4D", hash_generated_field = "AEFAE834852EA3825F5C1663B5547EE6")

    public static final String EXTRA_RESPONSE = "response";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "5AF9704112BDF494F7BFB4320B94F3E3", hash_generated_field = "15045585F25BD1CF8632154440DC8620")

    public static final String EXTRA_HOST = "host";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "9483985477D2269BB495BCB7A1475B2D", hash_generated_field = "3A6CE87107AFF5BB3B6CC770B1BE705F")

    public static final String EXTRA_PORT = "port";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "BCC19A851C5E26A1B8C6EFA64B5364D8", hash_generated_field = "12136C3DD9974ECECB48BA0B3595CE16")

    public static final String EXTRA_ALIAS = "alias";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "A23EB0DA664D4F627F005AE7F7C023F9", hash_generated_field = "3EAE09CC2B58B4F52A9C75979C34CC85")

    public static final String EXTRA_SENDER = "sender";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.107 -0400", hash_original_field = "3126B272329197A1938D7B7C02365202", hash_generated_field = "86B1C12ACDF02E85FDAC47D49793B4FE")

    private static final String ACTION_INSTALL = "android.credentials.INSTALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.108 -0400", hash_original_field = "BBE1CDBB2C88E833C72820CFF9DEFF3C", hash_generated_field = "16F6C962E1DA8B0FD26A1ED292AABB3B")

    public static final String EXTRA_NAME = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.108 -0400", hash_original_field = "98F228FD103DAB1B474BEC37DD9F26D0", hash_generated_field = "D1C7397A513A096DC123BF01E4B5050A")

    public static final String EXTRA_CERTIFICATE = "CERT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.108 -0400", hash_original_field = "1CAC3E5996CF7E718CA4AB1CB04C3532", hash_generated_field = "DF406DBF531C82AFF9840E033879AB08")

    public static final String EXTRA_PKCS12 = "PKCS12";
    
}

