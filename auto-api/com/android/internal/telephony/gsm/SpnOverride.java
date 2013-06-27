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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.133 -0400", hash_original_field = "EC9E01A29836BA5CE6B183DD96F1B4B9", hash_generated_field = "F996EF25CC658B6424004352EBB9DD6A")

    private HashMap<String, String> CarrierSpnMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.134 -0400", hash_original_method = "DBF3481E765E19045BAECAE6F7649C1E", hash_generated_method = "C3C49BF09C235732F87B2EBF2D0A93AF")
      SpnOverride() {
        CarrierSpnMap = new HashMap<String, String>();
        loadSpnOverrides();
        // ---------- Original Method ----------
        //CarrierSpnMap = new HashMap<String, String>();
        //loadSpnOverrides();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.135 -0400", hash_original_method = "F9DB25D793978B2E288A45309BFBD20E", hash_generated_method = "53BDB09F0C69BF516F95F29A0116AE78")
     boolean containsCarrier(String carrier) {
        boolean var2F632E0C4A768A347CCDB28A8E681D79_394257593 = (CarrierSpnMap.containsKey(carrier));
        addTaint(carrier.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572275014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572275014;
        // ---------- Original Method ----------
        //return CarrierSpnMap.containsKey(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.135 -0400", hash_original_method = "DEBF8ECBE1690451B3CAF7E732385AF7", hash_generated_method = "B39E6C864FFAA8E8319A26A0BBB76037")
     String getSpn(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_731558303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_731558303 = CarrierSpnMap.get(carrier);
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_731558303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_731558303;
        // ---------- Original Method ----------
        //return CarrierSpnMap.get(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.152 -0400", hash_original_method = "E85B5B045E56A81356A43AE2CD2F25CE", hash_generated_method = "354E4CE41ADEEE001E1521D9DB24D93A")
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
                    boolean varA14E9DACD961E914DC53CB3D797ACBE7_1551919164 = (!"spnOverride".equals(name));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.152 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.152 -0400", hash_original_field = "7D1D57AD5214C5B06FBDB6AE50E36082", hash_generated_field = "09A3A73A4A54C0013AA50E70D0784516")

    static String PARTNER_SPN_OVERRIDE_PATH = "etc/spn-conf.xml";
}

