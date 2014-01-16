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

public class SpnOverride {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:27.014 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:27.017 -0500", hash_original_field = "97CFD8EB4FAB8256217AB19827F26F14", hash_generated_field = "571B447F908349646546615F3EBC7F9A")

    static final String PARTNER_SPN_OVERRIDE_PATH ="etc/spn-conf.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:27.012 -0500", hash_original_field = "EC94D0246CDDF1BCD1FD8BAF3ED56B03", hash_generated_field = "F996EF25CC658B6424004352EBB9DD6A")

    private HashMap<String, String> CarrierSpnMap;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:27.019 -0500", hash_original_method = "DBF3481E765E19045BAECAE6F7649C1E", hash_generated_method = "DBF3481E765E19045BAECAE6F7649C1E")
    
SpnOverride () {
        CarrierSpnMap = new HashMap<String, String>();
        loadSpnOverrides();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:27.021 -0500", hash_original_method = "F9DB25D793978B2E288A45309BFBD20E", hash_generated_method = "F9DB25D793978B2E288A45309BFBD20E")
    
boolean containsCarrier(String carrier) {
        return CarrierSpnMap.containsKey(carrier);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:27.023 -0500", hash_original_method = "DEBF8ECBE1690451B3CAF7E732385AF7", hash_generated_method = "DEBF8ECBE1690451B3CAF7E732385AF7")
    
String getSpn(String carrier) {
        return CarrierSpnMap.get(carrier);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:27.026 -0500", hash_original_method = "E85B5B045E56A81356A43AE2CD2F25CE", hash_generated_method = "A0A0A66152D1527EEC801CBFC57BB3F0")
    
private void loadSpnOverrides() {
        FileReader spnReader;

        final File spnFile = new File(Environment.getRootDirectory(),
                PARTNER_SPN_OVERRIDE_PATH);

        try {
            spnReader = new FileReader(spnFile);
        } catch (FileNotFoundException e) {
            Log.w(LOG_TAG, "Can't open " +
                    Environment.getRootDirectory() + "/" + PARTNER_SPN_OVERRIDE_PATH);
            return;
        }

        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(spnReader);

            XmlUtils.beginDocument(parser, "spnOverrides");

            while (true) {
                XmlUtils.nextElement(parser);

                String name = parser.getName();
                if (!"spnOverride".equals(name)) {
                    break;
                }

                String numeric = parser.getAttributeValue(null, "numeric");
                String data    = parser.getAttributeValue(null, "spn");

                CarrierSpnMap.put(numeric, data);
            }
        } catch (XmlPullParserException e) {
            Log.w(LOG_TAG, "Exception in spn-conf parser " + e);
        } catch (IOException e) {
            Log.w(LOG_TAG, "Exception in spn-conf parser " + e);
        }
    }
}

