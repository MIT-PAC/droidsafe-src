package android.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.openssl.PEMWriter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

public class Credentials {

    /**
     * Convert objects to a PEM format, which is used for
     * CA_CERTIFICATE, USER_CERTIFICATE, and USER_PRIVATE_KEY
     * entries.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.380 -0500", hash_original_method = "8B20078D970D567CC41CA64CA9C8F771", hash_generated_method = "CE4455212C3B8EAB38281BA81F86F88E")
    
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
    /**
     * Convert objects from PEM format, which is used for
     * CA_CERTIFICATE, USER_CERTIFICATE, and USER_PRIVATE_KEY
     * entries.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.384 -0500", hash_original_method = "F0ABBF5B9651EE5121610CD48916D5A8", hash_generated_method = "085EFC9B30C254937B2F82B25DA23398")
    
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

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.389 -0500", hash_original_method = "9C858811BB4060B16ECD93FD3573ADC2", hash_generated_method = "516E05BB5789732D83B572D07C814C5C")
    
public static Credentials getInstance() {
        if (singleton == null) {
            singleton = new Credentials();
        }
        return singleton;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.336 -0500", hash_original_field = "26FCF7673A4B02F039FA2A278434875A", hash_generated_field = "6F3651127EA440B3E6DC55A1DDB183B2")

    private static final String LOGTAG = "Credentials";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.339 -0500", hash_original_field = "9DB20F28D7CAD388159300B983B19C79", hash_generated_field = "1709FA3F0025860464A5F5DF644178F7")

    public static final String INSTALL_ACTION = "android.credentials.INSTALL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.342 -0500", hash_original_field = "1ACB4F4FF682688F8CE6789F1C6B162B", hash_generated_field = "BDFDB7B0C73DAC00B7E889E660EF4662")

    public static final String UNLOCK_ACTION = "com.android.credentials.UNLOCK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.345 -0500", hash_original_field = "36832B061A6CC16993E3E13026EC81F8", hash_generated_field = "50F5C06806AB125569FB6AEF6E7A0321")

    public static final String CA_CERTIFICATE = "CACERT_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.348 -0500", hash_original_field = "A898DD9C19E7949C7F2BB1DBCBD6A2AE", hash_generated_field = "2F4F05867E2EA9F2E7A799A1E15C7024")

    public static final String USER_CERTIFICATE = "USRCERT_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.352 -0500", hash_original_field = "74F249359DD8E6561D78D134FEEFDA3C", hash_generated_field = "7ACBBAE3DFA2D19991143851C22B323E")

    public static final String USER_PRIVATE_KEY = "USRPKEY_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.355 -0500", hash_original_field = "8F635A3B7A7EA8ADD46EB4BBCAF8FB86", hash_generated_field = "0AFE5770E2B2FC2283F10B25EAB69CDF")

    public static final String VPN = "VPN_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.358 -0500", hash_original_field = "E65E268FEE3F50FB536B0D81723131D9", hash_generated_field = "69981F8FE86EA5FABCC0BCB3F03B9841")

    public static final String WIFI = "WIFI_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.361 -0500", hash_original_field = "6366971A78801208DC81D10782368B04", hash_generated_field = "8FF9D494590BA62F44F238634250D08E")

    public static final String EXTRA_PUBLIC_KEY = "KEY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.364 -0500", hash_original_field = "7B271B571111CDD363A6B629455988E7", hash_generated_field = "174CAAD863D2733195B4B56F6BE94713")

    public static final String EXTRA_PRIVATE_KEY = "PKEY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.367 -0500", hash_original_field = "1405DC1AED1E159295779D01CA6CFB37", hash_generated_field = "5B02BBBD621F97791C48AE2B89BCAAC9")

    public static final String EXTENSION_CRT = ".crt";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.370 -0500", hash_original_field = "309258B7CB14167894157355269A8CC1", hash_generated_field = "E2A3A1B95CEBC5359470D01430015069")

    public static final String EXTENSION_P12 = ".p12";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.373 -0500", hash_original_field = "068FFD4EB4146A6AE615BAD361B45064", hash_generated_field = "C0A51FDC40722D8A1275745833FBB534")

    public static final String EXTENSION_CER = ".cer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.377 -0500", hash_original_field = "2EDE9354571BB7B314F20F4002656C82", hash_generated_field = "516AB5F934F457BB6F6A72A2C8C5F1FA")

    public static final String EXTENSION_PFX = ".pfx";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.386 -0500", hash_original_field = "64F7F9694387CFA20D388BACB931FFAC", hash_generated_field = "1E5765EE035DA8F60280ACCF0416ACD1")

    private static Credentials singleton;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.930 -0400", hash_original_method = "1F7275C8DACF289F4D2AEA7102114D3A", hash_generated_method = "1F7275C8DACF289F4D2AEA7102114D3A")
    public Credentials ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.392 -0500", hash_original_method = "E5CB597E19A699BEE6BE3111711F0E73", hash_generated_method = "D7178BD33127286974F17C9F256B7D8F")
    
public void unlock(Context context) {
        try {
            Intent intent = new Intent(UNLOCK_ACTION);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.395 -0500", hash_original_method = "495C1AA770D3E4C1428A37EE08C3D570", hash_generated_method = "725724970BCF5F0A1B2925DC172BB643")
    
public void install(Context context) {
        try {
            Intent intent = KeyChain.createInstallIntent();
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.398 -0500", hash_original_method = "37483F7105DB6C05B518E1F3D82A6DB5", hash_generated_method = "5CDE2431698DF60FACB0144E4C7BC591")
    
public void install(Context context, KeyPair pair) {
        try {
            Intent intent = KeyChain.createInstallIntent();
            intent.putExtra(EXTRA_PRIVATE_KEY, pair.getPrivate().getEncoded());
            intent.putExtra(EXTRA_PUBLIC_KEY, pair.getPublic().getEncoded());
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:57.401 -0500", hash_original_method = "CC15ACCAB16387C45A58B01F639D7908", hash_generated_method = "6DFE9697E4DAE2437A3BF86C64F8DA4E")
    
public void install(Context context, String type, byte[] value) {
        try {
            Intent intent = KeyChain.createInstallIntent();
            intent.putExtra(type, value);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOGTAG, e.toString());
        }
    }
}

