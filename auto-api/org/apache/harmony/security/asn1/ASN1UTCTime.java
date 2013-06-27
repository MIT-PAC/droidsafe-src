package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ASN1UTCTime extends ASN1Time {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.484 -0400", hash_original_method = "26950815C4CFBBF28A3CFECAD840C50B", hash_generated_method = "EF7C489E04E77EFC692BF121C27E795F")
    public  ASN1UTCTime() {
        super(TAG_UTCTIME);
        // ---------- Original Method ----------
    }

    
        public static ASN1UTCTime getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.490 -0400", hash_original_method = "A91CD5C6AC359830199B04A7EA591A03", hash_generated_method = "C030FB12D1E84242325BF177BE81126B")
    @Override
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_899419206 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1391914379 = null; //Variable for return #2
        in.readUTCTime();
        {
            varB4EAC82CA7396A68D541C85D26508E83_899419206 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1391914379 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_482027038; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_482027038 = varB4EAC82CA7396A68D541C85D26508E83_899419206;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_482027038 = varB4EAC82CA7396A68D541C85D26508E83_1391914379;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_482027038.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_482027038;
        // ---------- Original Method ----------
        //in.readUTCTime();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.491 -0400", hash_original_method = "7E6261B78AC933A3E78C661A729AB3E3", hash_generated_method = "D4B2F8226DC3D8F41B8735BCEF5FE06A")
    @Override
    public void encodeContent(BerOutputStream out) {
        out.encodeUTCTime();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeUTCTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.494 -0400", hash_original_method = "DF1F65526ADDCB7D66CE158126525DF9", hash_generated_method = "CFC803BEE3AF76C401B6DECA8DF36E06")
    @Override
    public void setEncodingContent(BerOutputStream out) {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(UTC_PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        out.content = sdf.format(out.content).getBytes(Charsets.UTF_8);
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //SimpleDateFormat sdf = new SimpleDateFormat(UTC_PATTERN);
        //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        //out.content = sdf.format(out.content).getBytes(Charsets.UTF_8);
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.494 -0400", hash_original_field = "F1F2D4C39AFC8AE3E7F6253989C0ADB6", hash_generated_field = "C99E1AA1FD0B98FDECC7113FF17AD5A9")

    public static final int UTC_HM = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.494 -0400", hash_original_field = "CCBB64A379059E99A0D937177F7D4EF0", hash_generated_field = "43229A41614441B305939A18D625BBBF")

    public static final int UTC_HMS = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.494 -0400", hash_original_field = "27A9B83F51675132884C5B589ACCE162", hash_generated_field = "E277939BD96AECE8361F57CC38430D51")

    public static final int UTC_LOCAL_HM = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.494 -0400", hash_original_field = "0BCD2285E6C67B719C7A541E991D8CCC", hash_generated_field = "F6B17A8829ED2792E001CCEF650A209D")

    public static final int UTC_LOCAL_HMS = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.494 -0400", hash_original_field = "28A0E6F38A9728A9D6D7786A7C55593D", hash_generated_field = "1CA282BE56143F2983B8166B726F2012")

    private static ASN1UTCTime ASN1 = new ASN1UTCTime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.494 -0400", hash_original_field = "01918BC1C6E78250FDDC1427D79B58C3", hash_generated_field = "2A94E3128D2474310F2F8B93587DF869")

    private static String UTC_PATTERN = "yyMMddHHmmss'Z'";
}

