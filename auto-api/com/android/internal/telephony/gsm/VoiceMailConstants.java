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
    private HashMap<String, String[]> CarrierVmMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.079 -0400", hash_original_method = "DDF8D53D84854590566E7F07FF4C6145", hash_generated_method = "C3E263BD40B13CFFA32C025D4E16B624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     VoiceMailConstants() {
        CarrierVmMap = new HashMap<String, String[]>();
        loadVoiceMail();
        // ---------- Original Method ----------
        //CarrierVmMap = new HashMap<String, String[]>();
        //loadVoiceMail();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.079 -0400", hash_original_method = "EA61BB6A69E663D3A55745A8DC567B93", hash_generated_method = "0B01128C6E7D885425AD5CD196EE49A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean containsCarrier(String carrier) {
        dsTaint.addTaint(carrier);
        boolean varFF25C7C2ECBD496582D005691839F35D_1309899332 = (CarrierVmMap.containsKey(carrier));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return CarrierVmMap.containsKey(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.080 -0400", hash_original_method = "50C2E249A143A488875B9940B1F1FDE1", hash_generated_method = "FD2D0A2AD806041A5DB1E8A387DFC41D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getCarrierName(String carrier) {
        dsTaint.addTaint(carrier);
        String[] data;
        data = CarrierVmMap.get(carrier);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NAME];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.080 -0400", hash_original_method = "0EE8F97DB48267A64D2C0726286D2A1F", hash_generated_method = "E38423B9FC4D08CEAADE137D1569EDA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getVoiceMailNumber(String carrier) {
        dsTaint.addTaint(carrier);
        String[] data;
        data = CarrierVmMap.get(carrier);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[NUMBER];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.080 -0400", hash_original_method = "DE969177752DBF24A725FEF909B2130D", hash_generated_method = "37DD50BBC29ACECD82ECB4C8449885F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getVoiceMailTag(String carrier) {
        dsTaint.addTaint(carrier);
        String[] data;
        data = CarrierVmMap.get(carrier);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String[] data = CarrierVmMap.get(carrier);
        //return data[TAG];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.081 -0400", hash_original_method = "F2B6258CF868D3537F2007BF45D05D11", hash_generated_method = "3994E3D1B401C752505D53841CE589DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var4F6ABE7219F4967175C42B33C47943A5_2111723285 = (!"voicemail".equals(name));
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

    
    static final String LOG_TAG = "GSM";
    static final String PARTNER_VOICEMAIL_PATH ="etc/voicemail-conf.xml";
    static final int NAME = 0;
    static final int NUMBER = 1;
    static final int TAG = 2;
    static final int SIZE = 3;
}

