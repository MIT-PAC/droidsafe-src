package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.os.Environment;
import android.util.Xml;

import com.android.internal.util.XmlUtils;




class VoiceMailConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.018 -0400", hash_original_field = "A7DDC0939D7CC2DCDAAB30900E979453", hash_generated_field = "4822A23B6DAC900206318E4733509E52")

    private HashMap<String, String[]> CarrierVmMap;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.018 -0400", hash_original_method = "DDF8D53D84854590566E7F07FF4C6145", hash_generated_method = "C3E263BD40B13CFFA32C025D4E16B624")
      VoiceMailConstants() {
        CarrierVmMap = new HashMap<String, String[]>();
        loadVoiceMail();
        // ---------- Original Method ----------
        //CarrierVmMap = new HashMap<String, String[]>();
        //loadVoiceMail();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.018 -0400", hash_original_method = "EA61BB6A69E663D3A55745A8DC567B93", hash_generated_method = "CE6D09CA1F2742BB42119B812362B9AC")
     boolean containsCarrier(String carrier) {
        addTaint(carrier.getTaint());
        boolean var7BC711206EF82846D7AC6E14A8BE1874_971047439 = (CarrierVmMap.containsKey(carrier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930352750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930352750;
        // ---------- Original Method ----------
        //return CarrierVmMap.containsKey(carrier);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.019 -0400", hash_original_method = "50C2E249A143A488875B9940B1F1FDE1", hash_generated_method = "70DE23FCB8078A7358AF6836D7F2009A")
     String getCarrierName(String carrier) {
        addTaint(carrier.getTaint());
        String[] data = CarrierVmMap.get(carrier);
String varD24591417917DD3D4237E62016A99D8A_714757338 =         data[NAME];
        varD24591417917DD3D4237E62016A99D8A_714757338.addTaint(taint);
        return varD24591417917DD3D4237E62016A99D8A_714757338;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NAME];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.019 -0400", hash_original_method = "0EE8F97DB48267A64D2C0726286D2A1F", hash_generated_method = "36E903A9224CDC7DF01DDDD90C079EF3")
     String getVoiceMailNumber(String carrier) {
        addTaint(carrier.getTaint());
        String[] data = CarrierVmMap.get(carrier);
String var72FF74B6CD4ABE1D2FC635821C089974_809255586 =         data[NUMBER];
        var72FF74B6CD4ABE1D2FC635821C089974_809255586.addTaint(taint);
        return var72FF74B6CD4ABE1D2FC635821C089974_809255586;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NUMBER];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.019 -0400", hash_original_method = "DE969177752DBF24A725FEF909B2130D", hash_generated_method = "BE793A601220C49F6C077ACCCEBA60F8")
     String getVoiceMailTag(String carrier) {
        addTaint(carrier.getTaint());
        String[] data = CarrierVmMap.get(carrier);
String var999169416C4489763CC073FF64F0FE09_1965099081 =         data[TAG];
        var999169416C4489763CC073FF64F0FE09_1965099081.addTaint(taint);
        return var999169416C4489763CC073FF64F0FE09_1965099081;
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[TAG];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.021 -0400", hash_original_method = "F2B6258CF868D3537F2007BF45D05D11", hash_generated_method = "9767775BA188DFEEA4F2FB661E60073C")
    private void loadVoiceMail() {
        FileReader vmReader;
        final File vmFile = new File(Environment.getRootDirectory(),
                PARTNER_VOICEMAIL_PATH);
        try 
        {
            vmReader = new FileReader(vmFile);
        } //End block
        catch (FileNotFoundException e)
        {
            return;
        } //End block
        try 
        {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(vmReader);
            XmlUtils.beginDocument(parser, "voicemail");
            while
(true)            
            {
                XmlUtils.nextElement(parser);
                String name = parser.getName();
                if(!"voicemail".equals(name))                
                {
                    break;
                } //End block
                String[] data = new String[SIZE];
                String numeric = parser.getAttributeValue(null, "numeric");
                data[NAME]     = parser.getAttributeValue(null, "carrier");
                data[NUMBER]   = parser.getAttributeValue(null, "vmnumber");
                data[TAG]      = parser.getAttributeValue(null, "vmtag");
                CarrierVmMap.put(numeric, data);
            } //End block
        } //End block
        catch (XmlPullParserException e)
        {
        } //End block
        catch (IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.022 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.022 -0400", hash_original_field = "C0953AB1CDD06F3FFEBFE6D56B581A8A", hash_generated_field = "A7A20C99E1F7A8DBB390A0410D443AA6")

    static final String PARTNER_VOICEMAIL_PATH = "etc/voicemail-conf.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.022 -0400", hash_original_field = "A0BFEB2FAC9E81C939FBF858B44B03F5", hash_generated_field = "94F97F389D569D864E35EB506D54B128")

    static final int NAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.022 -0400", hash_original_field = "8EBF1B465BEA05EAA3866C94BE48BA46", hash_generated_field = "45400B6CCA1D90FC5844A6FD59A74995")

    static final int NUMBER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.022 -0400", hash_original_field = "7F69F6778CDCB6154D611A443CDC52B5", hash_generated_field = "7DD4C1F30BE983580F1014A25C73E0E9")

    static final int TAG = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.022 -0400", hash_original_field = "FF1C101DE95D0ADEE2D5B5FFC3630CC1", hash_generated_field = "53E3F62B6F3643688FCC874176FF61D6")

    static final int SIZE = 3;
}

