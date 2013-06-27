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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.168 -0400", hash_original_field = "A7DDC0939D7CC2DCDAAB30900E979453", hash_generated_field = "4822A23B6DAC900206318E4733509E52")

    private HashMap<String, String[]> CarrierVmMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.168 -0400", hash_original_method = "DDF8D53D84854590566E7F07FF4C6145", hash_generated_method = "C3E263BD40B13CFFA32C025D4E16B624")
      VoiceMailConstants() {
        CarrierVmMap = new HashMap<String, String[]>();
        loadVoiceMail();
        // ---------- Original Method ----------
        //CarrierVmMap = new HashMap<String, String[]>();
        //loadVoiceMail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.175 -0400", hash_original_method = "EA61BB6A69E663D3A55745A8DC567B93", hash_generated_method = "E1587B1032ACCBC7F9D5B05FD65089E3")
     boolean containsCarrier(String carrier) {
        boolean varFF25C7C2ECBD496582D005691839F35D_402525277 = (CarrierVmMap.containsKey(carrier));
        addTaint(carrier.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943109213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943109213;
        // ---------- Original Method ----------
        //return CarrierVmMap.containsKey(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.175 -0400", hash_original_method = "50C2E249A143A488875B9940B1F1FDE1", hash_generated_method = "0B39622708AC81730E76ED2B20F5CCC7")
     String getCarrierName(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_252840947 = null; //Variable for return #1
        String[] data;
        data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_252840947 = data[NAME];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_252840947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_252840947;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NAME];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.176 -0400", hash_original_method = "0EE8F97DB48267A64D2C0726286D2A1F", hash_generated_method = "330868CFB025226F7325A34F911F412B")
     String getVoiceMailNumber(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_1678554811 = null; //Variable for return #1
        String[] data;
        data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_1678554811 = data[NUMBER];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1678554811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678554811;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NUMBER];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.176 -0400", hash_original_method = "DE969177752DBF24A725FEF909B2130D", hash_generated_method = "FD95CE6DD1AE190DC797E8E20BF9839E")
     String getVoiceMailTag(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_937499233 = null; //Variable for return #1
        String[] data;
        data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_937499233 = data[TAG];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_937499233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_937499233;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[TAG];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.186 -0400", hash_original_method = "F2B6258CF868D3537F2007BF45D05D11", hash_generated_method = "423ABDE40F558E7E09F34EBFFB900428")
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
                    boolean var4F6ABE7219F4967175C42B33C47943A5_491864089 = (!"voicemail".equals(name));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.186 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.186 -0400", hash_original_field = "C0953AB1CDD06F3FFEBFE6D56B581A8A", hash_generated_field = "B381D0472FC71D4FA29D8FFC981C1B76")

    static String PARTNER_VOICEMAIL_PATH = "etc/voicemail-conf.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.186 -0400", hash_original_field = "A0BFEB2FAC9E81C939FBF858B44B03F5", hash_generated_field = "8C7C69BBC0376B4BEE0AE98784EFDA3A")

    static int NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.186 -0400", hash_original_field = "8EBF1B465BEA05EAA3866C94BE48BA46", hash_generated_field = "F3DD5DC3990D267F7ABAA1191E511092")

    static int NUMBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.186 -0400", hash_original_field = "7F69F6778CDCB6154D611A443CDC52B5", hash_generated_field = "D5B9A8949D9E8B71183C6B59CFC0EBAD")

    static int TAG = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.186 -0400", hash_original_field = "FF1C101DE95D0ADEE2D5B5FFC3630CC1", hash_generated_field = "AD79AD7214E755E6517475FB21EF624D")

    static int SIZE = 3;
}

