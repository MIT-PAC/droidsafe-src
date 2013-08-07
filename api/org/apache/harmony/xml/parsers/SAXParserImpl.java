package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;

import org.apache.harmony.xml.ExpatReader;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderAdapter;






final class SAXParserImpl extends SAXParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.809 -0400", hash_original_field = "54500990E8C2CA416B97834F0A2A41E6", hash_generated_field = "5A288FC03A9EC3CBF67B84D7411659BA")

    private Map<String, Boolean> initialFeatures;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.809 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "2331E55663EE08977E2E12264071B561")

    private XMLReader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.809 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "D434606E37B1227241E7860D969B4643")

    private Parser parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.810 -0400", hash_original_method = "9779EC9D1D1B404AB344DB3CA0720707", hash_generated_method = "94E9BC8CEC2C7941E41B2FA6EF9CDC3E")
      SAXParserImpl(Map<String, Boolean> initialFeatures) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.initialFeatures = initialFeatures.isEmpty()
                ? Collections.<String, Boolean>emptyMap()
                : new HashMap<String, Boolean>(initialFeatures);
        resetInternal();
        // ---------- Original Method ----------
        //this.initialFeatures = initialFeatures.isEmpty()
                //? Collections.<String, Boolean>emptyMap()
                //: new HashMap<String, Boolean>(initialFeatures);
        //resetInternal();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.811 -0400", hash_original_method = "92E2D289AE561178AC5F307252F0C6F0", hash_generated_method = "5F6B3218F65DD6DB72DFB507C763FD74")
    private void resetInternal() throws SAXNotSupportedException, SAXNotRecognizedException {
        reader = new ExpatReader();
for(Map.Entry<String,Boolean> entry : initialFeatures.entrySet())
        {
            reader.setFeature(entry.getKey(), entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //reader = new ExpatReader();
        //for (Map.Entry<String,Boolean> entry : initialFeatures.entrySet()) {
            //reader.setFeature(entry.getKey(), entry.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.811 -0400", hash_original_method = "26E1B1518091EE44E3A8C3E01B27E1B4", hash_generated_method = "2A72BC3AB5BA91FFAF1639DADEF79B10")
    @Override
    public void reset() {
        try 
        {
            resetInternal();
        } //End block
        catch (SAXNotRecognizedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1400058927 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1400058927.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1400058927;
        } //End block
        catch (SAXNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1964520578 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1964520578.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1964520578;
        } //End block
        // ---------- Original Method ----------
        //try {
            //resetInternal();
        //} catch (SAXNotRecognizedException e) {
            //throw new AssertionError();
        //} catch (SAXNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.812 -0400", hash_original_method = "18862164328B5438252F399ABE567B5E", hash_generated_method = "690918B10F282A1C7BA0BE6437DBD438")
    @Override
    public Parser getParser() {
        if(parser == null)        
        {
            parser = new XMLReaderAdapter(reader);
        } //End block
Parser var6C454504E3B46BB170EB6C8961D23597_213240371 =         parser;
        var6C454504E3B46BB170EB6C8961D23597_213240371.addTaint(taint);
        return var6C454504E3B46BB170EB6C8961D23597_213240371;
        // ---------- Original Method ----------
        //if (parser == null) {
            //parser = new XMLReaderAdapter(reader);
        //}
        //return parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.813 -0400", hash_original_method = "9F43AD8AE86873C6002272EA37B61BFA", hash_generated_method = "71749E37368132FD03FC78D2165B797E")
    @Override
    public Object getProperty(String name) throws SAXNotRecognizedException,
            SAXNotSupportedException {
        addTaint(name.getTaint());
Object var5BBB273B259F736B50FEB008BF3FDB91_1190593654 =         reader.getProperty(name);
        var5BBB273B259F736B50FEB008BF3FDB91_1190593654.addTaint(taint);
        return var5BBB273B259F736B50FEB008BF3FDB91_1190593654;
        // ---------- Original Method ----------
        //return reader.getProperty(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.813 -0400", hash_original_method = "2EF684CE098290C07222DD88BA41AEFB", hash_generated_method = "8A892A03FA91142342688B8CD9B1885F")
    @Override
    public XMLReader getXMLReader() {
XMLReader var681AFDDDB48FD166DFCBFA04C65E6269_1842155731 =         reader;
        var681AFDDDB48FD166DFCBFA04C65E6269_1842155731.addTaint(taint);
        return var681AFDDDB48FD166DFCBFA04C65E6269_1842155731;
        // ---------- Original Method ----------
        //return reader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.814 -0400", hash_original_method = "4C988836598C02053146886655E4EB88", hash_generated_method = "5614AF223E7F379B9355021058B06156")
    @Override
    public boolean isNamespaceAware() {
        try 
        {
            boolean varAAF6B023277518C6238E2264EF86C519_2089365130 = (reader.getFeature("http://xml.org/sax/features/namespaces"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352929187 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352929187;
        } //End block
        catch (SAXException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1973632088 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763879763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763879763;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return reader.getFeature("http://xml.org/sax/features/namespaces");
        //} catch (SAXException ex) {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.815 -0400", hash_original_method = "BC62268279A4D4DB4B44A495D4290EBF", hash_generated_method = "C007351DD34EDC68CE5B4FA0CEEA2353")
    @Override
    public boolean isValidating() {
        boolean var68934A3E9455FA72420237EB05902327_1363907340 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058115380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058115380;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.815 -0400", hash_original_method = "3CB351E70AA30B9105B52B17172319A2", hash_generated_method = "44C7104F7BA628A70FD112EA51A7B663")
    @Override
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        reader.setProperty(name, value);
        // ---------- Original Method ----------
        //reader.setProperty(name, value);
    }

    
}

