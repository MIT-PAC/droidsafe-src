package android.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.android.org.bouncycastle.openssl.PEMReader;
import com.android.org.bouncycastle.openssl.PEMWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charsets;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class Credentials {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.106 -0400", hash_original_method = "8C5D3C44A2BD1C8CB21A0D48D7048C00", hash_generated_method = "8C5D3C44A2BD1C8CB21A0D48D7048C00")
        public Credentials ()
    {
    }


        public static byte[] convertToPem(Object... objects) throws IOException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(bao, Charsets.US_ASCII);
        PEMWriter pw = new PEMWriter(writer);
        for (Object o : objects) {
            pw.writeObject(o);
        }
        pw.close();
        return bao.toByteArray();
    }

    
        public static List<Object> convertFromPem(byte[] bytes) throws IOException {
        ByteArrayInputStream bai = new ByteArrayInputStream(bytes);
        Reader reader = new InputStreamReader(bai, Charsets.US_ASCII);
        PEMReader pr = new PEMReader(reader);
        List<Object> result = new ArrayList<Object>();
        Object o;
        while ((o = pr.readObject()) != null) {
            result.add(o);
        }
        pr.close();
        return result;
    }

    
        public static Credentials getInstance() {
        if (singleton == null) {
            singleton = new Credentials();
        }
        return singleton;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.107 -0400", hash_original_method = "E5CB597E19A699BEE6BE3111711F0E73", hash_generated_method = "FC4A649C6CC512EF5A6A6FDA4A735CAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unlock(Context context) {
        dsTaint.addTaint(context.dsTaint);
        try 
        {
            Intent intent;
            intent = new Intent(UNLOCK_ACTION);
            context.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException e)
        { }
        // ---------- Original Method ----------
        //try {
            //Intent intent = new Intent(UNLOCK_ACTION);
            //context.startActivity(intent);
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOGTAG, e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.107 -0400", hash_original_method = "495C1AA770D3E4C1428A37EE08C3D570", hash_generated_method = "1A09BFAB3577FC552B8FBFC492A75B28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void install(Context context) {
        dsTaint.addTaint(context.dsTaint);
        try 
        {
            Intent intent;
            intent = KeyChain.createInstallIntent();
            context.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException e)
        { }
        // ---------- Original Method ----------
        //try {
            //Intent intent = KeyChain.createInstallIntent();
            //context.startActivity(intent);
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOGTAG, e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.118 -0400", hash_original_method = "37483F7105DB6C05B518E1F3D82A6DB5", hash_generated_method = "26188AAD0E3FFC727AE5A436D2E3816E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void install(Context context, KeyPair pair) {
        dsTaint.addTaint(pair.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        try 
        {
            Intent intent;
            intent = KeyChain.createInstallIntent();
            intent.putExtra(EXTRA_PRIVATE_KEY, pair.getPrivate().getEncoded());
            intent.putExtra(EXTRA_PUBLIC_KEY, pair.getPublic().getEncoded());
            context.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException e)
        { }
        // ---------- Original Method ----------
        //try {
            //Intent intent = KeyChain.createInstallIntent();
            //intent.putExtra(EXTRA_PRIVATE_KEY, pair.getPrivate().getEncoded());
            //intent.putExtra(EXTRA_PUBLIC_KEY, pair.getPublic().getEncoded());
            //context.startActivity(intent);
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOGTAG, e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.119 -0400", hash_original_method = "CC15ACCAB16387C45A58B01F639D7908", hash_generated_method = "191B9665A1A3C653B6E483E8D7264BCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void install(Context context, String type, byte[] value) {
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(type);
        try 
        {
            Intent intent;
            intent = KeyChain.createInstallIntent();
            intent.putExtra(type, value);
            context.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException e)
        { }
        // ---------- Original Method ----------
        //try {
            //Intent intent = KeyChain.createInstallIntent();
            //intent.putExtra(type, value);
            //context.startActivity(intent);
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOGTAG, e.toString());
        //}
    }

    
    private static final String LOGTAG = "Credentials";
    public static final String INSTALL_ACTION = "android.credentials.INSTALL";
    public static final String UNLOCK_ACTION = "com.android.credentials.UNLOCK";
    public static final String CA_CERTIFICATE = "CACERT_";
    public static final String USER_CERTIFICATE = "USRCERT_";
    public static final String USER_PRIVATE_KEY = "USRPKEY_";
    public static final String VPN = "VPN_";
    public static final String WIFI = "WIFI_";
    public static final String EXTRA_PUBLIC_KEY = "KEY";
    public static final String EXTRA_PRIVATE_KEY = "PKEY";
    public static final String EXTENSION_CRT = ".crt";
    public static final String EXTENSION_P12 = ".p12";
    public static final String EXTENSION_CER = ".cer";
    public static final String EXTENSION_PFX = ".pfx";
    private static Credentials singleton;
}

