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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.829 -0400", hash_original_field = "EC9E01A29836BA5CE6B183DD96F1B4B9", hash_generated_field = "F996EF25CC658B6424004352EBB9DD6A")

    private HashMap<String, String> CarrierSpnMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.829 -0400", hash_original_method = "DBF3481E765E19045BAECAE6F7649C1E", hash_generated_method = "C3C49BF09C235732F87B2EBF2D0A93AF")
      SpnOverride() {
        CarrierSpnMap = new HashMap<String, String>();
        loadSpnOverrides();
        // ---------- Original Method ----------
        //CarrierSpnMap = new HashMap<String, String>();
        //loadSpnOverrides();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.830 -0400", hash_original_method = "F9DB25D793978B2E288A45309BFBD20E", hash_generated_method = "57B94B6D1FC0C69201D7DAAFE86D34E2")
     boolean containsCarrier(String carrier) {
        boolean var2F632E0C4A768A347CCDB28A8E681D79_1030250764 = (CarrierSpnMap.containsKey(carrier));
        addTaint(carrier.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920528651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920528651;
        // ---------- Original Method ----------
        //return CarrierSpnMap.containsKey(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.830 -0400", hash_original_method = "DEBF8ECBE1690451B3CAF7E732385AF7", hash_generated_method = "6E786F06E40A2833C498495321611ABF")
     String getSpn(String carrier) {
        String varB4EAC82CA7396A68D541C85D26508E83_255296767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_255296767 = CarrierSpnMap.get(carrier);
        addTaint(carrier.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_255296767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_255296767;
        // ---------- Original Method ----------
        //return CarrierSpnMap.get(carrier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.831 -0400", hash_original_method = "E85B5B045E56A81356A43AE2CD2F25CE", hash_generated_method = "20D9651B817EE9DC11508CDDCDB0C37A")
    private void loadSpnOverrides() {
        FileReader spnReader;
        final File spnFile = new File(Environment.getRootDirectory(),
                PARTNER_SPN_OVERRIDE_PATH);
        try 
        {
            spnReader = new FileReader(spnFile);
        } //End block
        catch (FileNotFoundException e)
        { }
        try 
        {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(spnReader);
            XmlUtils.beginDocument(parser, "spnOverrides");
            {
                XmlUtils.nextElement(parser);
                String name = parser.getName();
                {
                    boolean varA14E9DACD961E914DC53CB3D797ACBE7_1925037687 = (!"spnOverride".equals(name));
                } //End collapsed parenthetic
                String numeric = parser.getAttributeValue(null, "numeric");
                String data = parser.getAttributeValue(null, "spn");
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.831 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.831 -0400", hash_original_field = "7D1D57AD5214C5B06FBDB6AE50E36082", hash_generated_field = "571B447F908349646546615F3EBC7F9A")

    static final String PARTNER_SPN_OVERRIDE_PATH = "etc/spn-conf.xml";
}

