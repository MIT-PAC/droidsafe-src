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
import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.openssl.PEMWriter;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.929 -0400", hash_original_method = "1F7275C8DACF289F4D2AEA7102114D3A", hash_generated_method = "1F7275C8DACF289F4D2AEA7102114D3A")
    public Credentials ()
    {
        //Synthesized constructor
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.940 -0400", hash_original_method = "E5CB597E19A699BEE6BE3111711F0E73", hash_generated_method = "75BC94514DBD60E647DA5C82EFDAEDEC")
    public void unlock(Context context) {
        try 
        {
            Intent intent;
            intent = new Intent(UNLOCK_ACTION);
            context.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException e)
        { }
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //try {
            //Intent intent = new Intent(UNLOCK_ACTION);
            //context.startActivity(intent);
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOGTAG, e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.941 -0400", hash_original_method = "495C1AA770D3E4C1428A37EE08C3D570", hash_generated_method = "449375123D8E8EF7842CD82320032F64")
    public void install(Context context) {
        try 
        {
            Intent intent;
            intent = KeyChain.createInstallIntent();
            context.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException e)
        { }
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //try {
            //Intent intent = KeyChain.createInstallIntent();
            //context.startActivity(intent);
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOGTAG, e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.942 -0400", hash_original_method = "37483F7105DB6C05B518E1F3D82A6DB5", hash_generated_method = "D9618F0FB45DDA43129712ED1CFF44B3")
    public void install(Context context, KeyPair pair) {
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
        addTaint(context.getTaint());
        addTaint(pair.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_method = "CC15ACCAB16387C45A58B01F639D7908", hash_generated_method = "2140516A8D4C30951A007F5F325AD400")
    public void install(Context context, String type, byte[] value) {
        try 
        {
            Intent intent;
            intent = KeyChain.createInstallIntent();
            intent.putExtra(type, value);
            context.startActivity(intent);
        } //End block
        catch (ActivityNotFoundException e)
        { }
        addTaint(context.getTaint());
        addTaint(type.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //try {
            //Intent intent = KeyChain.createInstallIntent();
            //intent.putExtra(type, value);
            //context.startActivity(intent);
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOGTAG, e.toString());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "CE1ACF3E6C3947BF905CCB939D9792EA", hash_generated_field = "6B504BD4F1962D9027CCBFAD309E7FB8")

    private static String LOGTAG = "Credentials";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "3642562609862EFB6F09F70C7009C872", hash_generated_field = "1709FA3F0025860464A5F5DF644178F7")

    public static final String INSTALL_ACTION = "android.credentials.INSTALL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "AE68D790EC6B775F9028B8E3E6958410", hash_generated_field = "BDFDB7B0C73DAC00B7E889E660EF4662")

    public static final String UNLOCK_ACTION = "com.android.credentials.UNLOCK";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "6A4AB3099880BD571EC4659721AD6F21", hash_generated_field = "50F5C06806AB125569FB6AEF6E7A0321")

    public static final String CA_CERTIFICATE = "CACERT_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "EB1DA2BECFD5E6CAADB4B83A359F733C", hash_generated_field = "2F4F05867E2EA9F2E7A799A1E15C7024")

    public static final String USER_CERTIFICATE = "USRCERT_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "7C1493CDA44143889BE8116FEEF00BE9", hash_generated_field = "7ACBBAE3DFA2D19991143851C22B323E")

    public static final String USER_PRIVATE_KEY = "USRPKEY_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "1E4839409F67AA5962B427A256B402BA", hash_generated_field = "0AFE5770E2B2FC2283F10B25EAB69CDF")

    public static final String VPN = "VPN_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "3F79037A373AA548AA121246EA29A6DC", hash_generated_field = "69981F8FE86EA5FABCC0BCB3F03B9841")

    public static final String WIFI = "WIFI_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "3D9B6619D6EDBC5D17DF5EFC509DBFA3", hash_generated_field = "8FF9D494590BA62F44F238634250D08E")

    public static final String EXTRA_PUBLIC_KEY = "KEY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "F0F326D1EFEBAD6340D8E69131E09794", hash_generated_field = "174CAAD863D2733195B4B56F6BE94713")

    public static final String EXTRA_PRIVATE_KEY = "PKEY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "90179B0295B5947532778B862238151D", hash_generated_field = "5B02BBBD621F97791C48AE2B89BCAAC9")

    public static final String EXTENSION_CRT = ".crt";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "4D59A48833315E1E34B79CECB0242DE9", hash_generated_field = "E2A3A1B95CEBC5359470D01430015069")

    public static final String EXTENSION_P12 = ".p12";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "910B60D78BFBA2A88D03CF3B9E0DE0BD", hash_generated_field = "C0A51FDC40722D8A1275745833FBB534")

    public static final String EXTENSION_CER = ".cer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.943 -0400", hash_original_field = "0F2B00A5099BD307595E8049D7FC0D9E", hash_generated_field = "516AB5F934F457BB6F6A72A2C8C5F1FA")

    public static final String EXTENSION_PFX = ".pfx";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.944 -0400", hash_original_field = "2ED500A3529637175E675A8791B7C56E", hash_generated_field = "1E5765EE035DA8F60280ACCF0416ACD1")

    private static Credentials singleton;
}

