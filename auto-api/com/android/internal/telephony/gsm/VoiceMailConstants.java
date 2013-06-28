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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.961 -0400", hash_original_field = "A7DDC0939D7CC2DCDAAB30900E979453", hash_generated_field = "4822A23B6DAC900206318E4733509E52")

    private HashMap<String, String[]> CarrierVmMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.962 -0400", hash_original_method = "DDF8D53D84854590566E7F07FF4C6145", hash_generated_method = "C3E263BD40B13CFFA32C025D4E16B624")
      VoiceMailConstants() {
        CarrierVmMap = new HashMap<String, String[]>();
        loadVoiceMail();
        // ---------- Original Method ----------
        //CarrierVmMap = new HashMap<String, String[]>();
        //loadVoiceMail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.962 -0400", hash_original_method = "EA61BB6A69E663D3A55745A8DC567B93", hash_generated_method = "F88EA8CF73F5BD56F6C3208C654D61FD")
     boolean containsCarrier(String carrier) {
        boolean varFF25C7C2ECBD496582D005691839F35D_111328833 = (CarrierVmMap.containsKey(carrier));
        addTaint(carrier.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460444904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460444904;
        // ---------- Original Method ----------
        //return CarrierVmMap.containsKey(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.963 -0400", hash_original_method = "50C2E249A143A488875B9940B1F1FDE1", hash_generated_method = "F70158249EFE4073A318292B9298E284")
     String getCarrierName(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_1689531155 = null; //Variable for return #1
        String[] data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_1689531155 = data[NAME];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1689531155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689531155;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NAME];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.965 -0400", hash_original_method = "0EE8F97DB48267A64D2C0726286D2A1F", hash_generated_method = "BA1DEAB72AAFC4F4B333A57ADEB7E040")
     String getVoiceMailNumber(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_855155866 = null; //Variable for return #1
        String[] data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_855155866 = data[NUMBER];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_855155866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_855155866;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NUMBER];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.966 -0400", hash_original_method = "DE969177752DBF24A725FEF909B2130D", hash_generated_method = "E1D3846C2F3AB2F00B26D9E2CE13F5A1")
     String getVoiceMailTag(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_327776704 = null; //Variable for return #1
        String[] data = CarrierVmMap.get(carrier);
        varB4EAC82CA7396A68D541C85D26508E83_327776704 = data[TAG];
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_327776704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327776704;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[TAG];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.967 -0400", hash_original_method = "F2B6258CF868D3537F2007BF45D05D11", hash_generated_method = "2077AC4D9D6134AD9F7FBD4352E6F364")
    private void loadVoiceMail() {
        FileReader vmReader = null;
        final File vmFile = new File(Environment.getRootDirectory(),
                PARTNER_VOICEMAIL_PATH);
        try 
        {
            vmReader = new FileReader(vmFile);
        } //End block
        catch (FileNotFoundException e)
        { }
        try 
        {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(vmReader);
            XmlUtils.beginDocument(parser, "voicemail");
            {
                XmlUtils.nextElement(parser);
                String name = parser.getName();
                {
                    boolean var4F6ABE7219F4967175C42B33C47943A5_2071971888 = (!"voicemail".equals(name));
                } //End collapsed parenthetic
                String[] data = new String[SIZE];
                String numeric = parser.getAttributeValue(null, "numeric");
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.968 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.968 -0400", hash_original_field = "C0953AB1CDD06F3FFEBFE6D56B581A8A", hash_generated_field = "A7A20C99E1F7A8DBB390A0410D443AA6")

    static final String PARTNER_VOICEMAIL_PATH = "etc/voicemail-conf.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.968 -0400", hash_original_field = "A0BFEB2FAC9E81C939FBF858B44B03F5", hash_generated_field = "94F97F389D569D864E35EB506D54B128")

    static final int NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.968 -0400", hash_original_field = "8EBF1B465BEA05EAA3866C94BE48BA46", hash_generated_field = "45400B6CCA1D90FC5844A6FD59A74995")

    static final int NUMBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.968 -0400", hash_original_field = "7F69F6778CDCB6154D611A443CDC52B5", hash_generated_field = "7DD4C1F30BE983580F1014A25C73E0E9")

    static final int TAG = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.968 -0400", hash_original_field = "FF1C101DE95D0ADEE2D5B5FFC3630CC1", hash_generated_field = "53E3F62B6F3643688FCC874176FF61D6")

    static final int SIZE = 3;
}

