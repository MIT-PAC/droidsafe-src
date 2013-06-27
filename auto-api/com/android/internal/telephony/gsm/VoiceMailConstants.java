package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Environment;
import android.util.Xml;
import android.util.Log;
import java.util.HashMap;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import com.android.internal.util.XmlUtils;

class VoiceMailConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.512 -0400", hash_original_field = "A7DDC0939D7CC2DCDAAB30900E979453", hash_generated_field = "4822A23B6DAC900206318E4733509E52")

    private HashMap<String, String[]> CarrierVmMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.512 -0400", hash_original_method = "DDF8D53D84854590566E7F07FF4C6145", hash_generated_method = "C3E263BD40B13CFFA32C025D4E16B624")
      VoiceMailConstants() {
        CarrierVmMap = new HashMap<String, String[]>();
        loadVoiceMail();
        // ---------- Original Method ----------
        //CarrierVmMap = new HashMap<String, String[]>();
        //loadVoiceMail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.522 -0400", hash_original_method = "EA61BB6A69E663D3A55745A8DC567B93", hash_generated_method = "D0B5A050A133284FE22AD415855C0E8B")
     boolean containsCarrier(String carrier) {
        boolean varFF25C7C2ECBD496582D005691839F35D_1359198979 = (CarrierVmMap.containsKey(carrier));
        addTaint(carrier.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375037221 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375037221;
        // ---------- Original Method ----------
        //return CarrierVmMap.containsKey(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.537 -0400", hash_original_method = "50C2E249A143A488875B9940B1F1FDE1", hash_generated_method = "A4ECB992C15E3701C95EF99ABB999633")
     String getCarrierName(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_1205201728 = null; //Variable for return #1
        String[] data;
        data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_1205201728 = data[NAME];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1205201728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1205201728;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NAME];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.544 -0400", hash_original_method = "0EE8F97DB48267A64D2C0726286D2A1F", hash_generated_method = "257B20003A02AE32AAE0B74875BF6E84")
     String getVoiceMailNumber(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_737580738 = null; //Variable for return #1
        String[] data;
        data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_737580738 = data[NUMBER];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_737580738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_737580738;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NUMBER];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.545 -0400", hash_original_method = "DE969177752DBF24A725FEF909B2130D", hash_generated_method = "23AD5C69002BE0594F5BF94968BE51D8")
     String getVoiceMailTag(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_582676163 = null; //Variable for return #1
        String[] data;
        data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_582676163 = data[TAG];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_582676163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582676163;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[TAG];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.545 -0400", hash_original_method = "F2B6258CF868D3537F2007BF45D05D11", hash_generated_method = "805A938FE932FD9E91C9F395E384D820")
    private void loadVoiceMail() {
        FileReader vmReader;
        File vmFile;
        vmFile = new File(Environment.getRootDirectory(),
                PARTNER_VOICEMAIL_PATH);
        try 
        {
            vmReader = new FileReader(vmFile);
        } //End block
        catch (FileNotFoundException e)
        { }
        try 
        {
            XmlPullParser parser;
            parser = Xml.newPullParser();
            parser.setInput(vmReader);
            XmlUtils.beginDocument(parser, "voicemail");
            {
                XmlUtils.nextElement(parser);
                String name;
                name = parser.getName();
                {
                    boolean var4F6ABE7219F4967175C42B33C47943A5_851051124 = (!"voicemail".equals(name));
                } //End collapsed parenthetic
                String[] data;
                data = new String[SIZE];
                String numeric;
                numeric = parser.getAttributeValue(null, "numeric");
                data[NAME]     = parser.getAttributeValue(null, "carrier");
                data[NUMBER]   = parser.getAttributeValue(null, "vmnumber");
                data[TAG]      = parser.getAttributeValue(null, "vmtag");
                CarrierVmMap.put(numeric, data);
            } //End block
        } //End block
        catch (XmlPullParserException e)
        { }
        catch (IOException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.545 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.546 -0400", hash_original_field = "C0953AB1CDD06F3FFEBFE6D56B581A8A", hash_generated_field = "B381D0472FC71D4FA29D8FFC981C1B76")

    static String PARTNER_VOICEMAIL_PATH = "etc/voicemail-conf.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.546 -0400", hash_original_field = "A0BFEB2FAC9E81C939FBF858B44B03F5", hash_generated_field = "8C7C69BBC0376B4BEE0AE98784EFDA3A")

    static int NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.546 -0400", hash_original_field = "8EBF1B465BEA05EAA3866C94BE48BA46", hash_generated_field = "F3DD5DC3990D267F7ABAA1191E511092")

    static int NUMBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.546 -0400", hash_original_field = "7F69F6778CDCB6154D611A443CDC52B5", hash_generated_field = "D5B9A8949D9E8B71183C6B59CFC0EBAD")

    static int TAG = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.546 -0400", hash_original_field = "FF1C101DE95D0ADEE2D5B5FFC3630CC1", hash_generated_field = "AD79AD7214E755E6517475FB21EF624D")

    static int SIZE = 3;
}

