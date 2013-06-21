package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import com.android.internal.util.XmlUtils;

public class SpnOverride {
    private HashMap<String, String> CarrierSpnMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.987 -0400", hash_original_method = "DBF3481E765E19045BAECAE6F7649C1E", hash_generated_method = "C3C49BF09C235732F87B2EBF2D0A93AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SpnOverride() {
        CarrierSpnMap = new HashMap<String, String>();
        loadSpnOverrides();
        // ---------- Original Method ----------
        //CarrierSpnMap = new HashMap<String, String>();
        //loadSpnOverrides();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.987 -0400", hash_original_method = "F9DB25D793978B2E288A45309BFBD20E", hash_generated_method = "E3F5B93B4A52ADE48E468FF9B3DC0EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean containsCarrier(String carrier) {
        dsTaint.addTaint(carrier);
        boolean var2F632E0C4A768A347CCDB28A8E681D79_789745844 = (CarrierSpnMap.containsKey(carrier));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return CarrierSpnMap.containsKey(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.987 -0400", hash_original_method = "DEBF8ECBE1690451B3CAF7E732385AF7", hash_generated_method = "C11CE4DF2FC614CB3BB30042805B4E7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getSpn(String carrier) {
        dsTaint.addTaint(carrier);
        String var3F12D63AA3C24B34F31D6968B78C7BA7_743887646 = (CarrierSpnMap.get(carrier));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return CarrierSpnMap.get(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.987 -0400", hash_original_method = "E85B5B045E56A81356A43AE2CD2F25CE", hash_generated_method = "6CEEF6F3B3C4CB30B0EEFE91D08F2210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void loadSpnOverrides() {
        FileReader spnReader;
        File spnFile;
        spnFile = new File(Environment.getRootDirectory(),
                PARTNER_SPN_OVERRIDE_PATH);
        try 
        {
            spnReader = new FileReader(spnFile);
        } //End block
        catch (FileNotFoundException e)
        { }
        try 
        {
            XmlPullParser parser;
            parser = Xml.newPullParser();
            parser.setInput(spnReader);
            XmlUtils.beginDocument(parser, "spnOverrides");
            {
                XmlUtils.nextElement(parser);
                String name;
                name = parser.getName();
                {
                    boolean varA14E9DACD961E914DC53CB3D797ACBE7_1729955063 = (!"spnOverride".equals(name));
                } //End collapsed parenthetic
                String numeric;
                numeric = parser.getAttributeValue(null, "numeric");
                String data;
                data = parser.getAttributeValue(null, "spn");
                CarrierSpnMap.put(numeric, data);
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
    static final String PARTNER_SPN_OVERRIDE_PATH ="etc/spn-conf.xml";
}

