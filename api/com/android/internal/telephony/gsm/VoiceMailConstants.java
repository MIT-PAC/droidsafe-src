package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.784 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.787 -0500", hash_original_field = "0513B7789E51497CD0356920E7614BAC", hash_generated_field = "A7A20C99E1F7A8DBB390A0410D443AA6")

    static final String PARTNER_VOICEMAIL_PATH ="etc/voicemail-conf.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.789 -0500", hash_original_field = "2F7927E48A6353CDCE816CBD49EED4A9", hash_generated_field = "94F97F389D569D864E35EB506D54B128")

    static final int NAME = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.792 -0500", hash_original_field = "FDCF7DABCA0423FE97E346C00BD48BDF", hash_generated_field = "45400B6CCA1D90FC5844A6FD59A74995")

    static final int NUMBER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.794 -0500", hash_original_field = "CDAB39A11CA44163160BD0C9D448D341", hash_generated_field = "7DD4C1F30BE983580F1014A25C73E0E9")

    static final int TAG = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.797 -0500", hash_original_field = "0BF6B0DE24A8FAD41049869FF732919E", hash_generated_field = "53E3F62B6F3643688FCC874176FF61D6")

    static final int SIZE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.781 -0500", hash_original_field = "27BCEB131D17C5C6BC025816878A1612", hash_generated_field = "4822A23B6DAC900206318E4733509E52")

    private HashMap<String, String[]> CarrierVmMap;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.799 -0500", hash_original_method = "DDF8D53D84854590566E7F07FF4C6145", hash_generated_method = "DDF8D53D84854590566E7F07FF4C6145")
    
VoiceMailConstants () {
        CarrierVmMap = new HashMap<String, String[]>();
        loadVoiceMail();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.802 -0500", hash_original_method = "EA61BB6A69E663D3A55745A8DC567B93", hash_generated_method = "EA61BB6A69E663D3A55745A8DC567B93")
    
boolean containsCarrier(String carrier) {
        return CarrierVmMap.containsKey(carrier);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.805 -0500", hash_original_method = "50C2E249A143A488875B9940B1F1FDE1", hash_generated_method = "50C2E249A143A488875B9940B1F1FDE1")
    
String getCarrierName(String carrier) {
        String[] data = CarrierVmMap.get(carrier);
        return data[NAME];
    }

    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.807 -0500", hash_original_method = "0EE8F97DB48267A64D2C0726286D2A1F", hash_generated_method = "0EE8F97DB48267A64D2C0726286D2A1F")
    
String getVoiceMailNumber(String carrier) {
        String[] data = CarrierVmMap.get(carrier);
        return data[NUMBER];
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.809 -0500", hash_original_method = "DE969177752DBF24A725FEF909B2130D", hash_generated_method = "DE969177752DBF24A725FEF909B2130D")
    
String getVoiceMailTag(String carrier) {
        String[] data = CarrierVmMap.get(carrier);
        return data[TAG];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.812 -0500", hash_original_method = "F2B6258CF868D3537F2007BF45D05D11", hash_generated_method = "828345446691B9004F36E7F07571674E")
    
private void loadVoiceMail() {
        FileReader vmReader;

        final File vmFile = new File(Environment.getRootDirectory(),
                PARTNER_VOICEMAIL_PATH);

        try {
            vmReader = new FileReader(vmFile);
        } catch (FileNotFoundException e) {
            Log.w(LOG_TAG, "Can't open " +
                    Environment.getRootDirectory() + "/" + PARTNER_VOICEMAIL_PATH);
            return;
        }

        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(vmReader);

            XmlUtils.beginDocument(parser, "voicemail");

            while (true) {
                XmlUtils.nextElement(parser);

                String name = parser.getName();
                if (!"voicemail".equals(name)) {
                    break;
                }

                String[] data = new String[SIZE];
                String numeric = parser.getAttributeValue(null, "numeric");
                data[NAME]     = parser.getAttributeValue(null, "carrier");
                data[NUMBER]   = parser.getAttributeValue(null, "vmnumber");
                data[TAG]      = parser.getAttributeValue(null, "vmtag");

                CarrierVmMap.put(numeric, data);
            }
        } catch (XmlPullParserException e) {
            Log.w(LOG_TAG, "Exception in Voicemail parser " + e);
        } catch (IOException e) {
            Log.w(LOG_TAG, "Exception in Voicemail parser " + e);
        }
    }
}

