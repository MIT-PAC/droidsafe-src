package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.866 -0400", hash_original_field = "EC9E01A29836BA5CE6B183DD96F1B4B9", hash_generated_field = "F996EF25CC658B6424004352EBB9DD6A")

    private HashMap<String, String> CarrierSpnMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.867 -0400", hash_original_method = "DBF3481E765E19045BAECAE6F7649C1E", hash_generated_method = "C3C49BF09C235732F87B2EBF2D0A93AF")
      SpnOverride() {
        CarrierSpnMap = new HashMap<String, String>();
        loadSpnOverrides();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.867 -0400", hash_original_method = "F9DB25D793978B2E288A45309BFBD20E", hash_generated_method = "B2A3DEBEC72143BC6BB7EFE1C0DF7CC8")
     boolean containsCarrier(String carrier) {
        addTaint(carrier.getTaint());
        boolean var3E2E3D095BA2761DCABCAFC35B2AAA8A_1429863590 = (CarrierSpnMap.containsKey(carrier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305500923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305500923;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.868 -0400", hash_original_method = "DEBF8ECBE1690451B3CAF7E732385AF7", hash_generated_method = "AE1C02C69F772303829F58D69DA2AB03")
     String getSpn(String carrier) {
        addTaint(carrier.getTaint());
String varA4F692C7E4CB5AD08C930C1C2050AB6F_132413375 =         CarrierSpnMap.get(carrier);
        varA4F692C7E4CB5AD08C930C1C2050AB6F_132413375.addTaint(taint);
        return varA4F692C7E4CB5AD08C930C1C2050AB6F_132413375;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.869 -0400", hash_original_method = "E85B5B045E56A81356A43AE2CD2F25CE", hash_generated_method = "930E5D7DFDBB1312A74B7E4998026AA9")
    private void loadSpnOverrides() {
        FileReader spnReader;
        final File spnFile = new File(Environment.getRootDirectory(),
                PARTNER_SPN_OVERRIDE_PATH);
        try 
        {
            spnReader = new FileReader(spnFile);
        } 
        catch (FileNotFoundException e)
        {
            return;
        } 
        try 
        {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(spnReader);
            XmlUtils.beginDocument(parser, "spnOverrides");
            while
(true)            
            {
                XmlUtils.nextElement(parser);
                String name = parser.getName();
    if(!"spnOverride".equals(name))                
                {
                    break;
                } 
                String numeric = parser.getAttributeValue(null, "numeric");
                String data = parser.getAttributeValue(null, "spn");
                CarrierSpnMap.put(numeric, data);
            } 
        } 
        catch (XmlPullParserException e)
        {
        } 
        catch (IOException e)
        {
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.869 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.869 -0400", hash_original_field = "7D1D57AD5214C5B06FBDB6AE50E36082", hash_generated_field = "571B447F908349646546615F3EBC7F9A")

    static final String PARTNER_SPN_OVERRIDE_PATH = "etc/spn-conf.xml";
}

