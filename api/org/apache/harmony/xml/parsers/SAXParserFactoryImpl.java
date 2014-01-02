package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXNotRecognizedException;




public class SAXParserFactoryImpl extends SAXParserFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.741 -0500", hash_original_field = "23D5E90A009660027D8004B0865026CF", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")


    private static final String NAMESPACES
            = "http://xml.org/sax/features/namespaces";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.744 -0500", hash_original_field = "82AE1762CE90A109938E89B1ADAFE1BF", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")


    private static final String VALIDATION
            = "http://xml.org/sax/features/validation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.746 -0500", hash_original_field = "52DB9F5445142ACC1EFB3E9C4AA84BD1", hash_generated_field = "BBF36E0D89D30BFFC00EE4B538D5AA0E")


    private Map<String, Boolean> features = new HashMap<String, Boolean>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.792 -0400", hash_original_method = "BB7DD052856C5F48FEF96C6EA9CF9D9A", hash_generated_method = "BB7DD052856C5F48FEF96C6EA9CF9D9A")
    public SAXParserFactoryImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.793 -0400", hash_original_method = "7A2715D86ACB75E2F46F70864B886736", hash_generated_method = "3D8F90B43D8CCB46BB10FF9414B01FBF")
    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException {
        addTaint(name.getTaint());
        if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_293905393 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_293905393.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_293905393;
        } //End block
        if(!name.startsWith("http://xml.org/sax/features/"))        
        {
            SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_1395243829 = new SAXNotRecognizedException(name);
            var5FC954F6CCADD58BC8498AD6F3DB9EC4_1395243829.addTaint(taint);
            throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_1395243829;
        } //End block
        boolean var88BA011B209A52DCABE538CA75B2D11A_84159439 = (Boolean.TRUE.equals(features.get(name)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426724477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426724477;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (!name.startsWith("http://xml.org/sax/features/")) {
            //throw new SAXNotRecognizedException(name);
        //}
        //return Boolean.TRUE.equals(features.get(name));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.751 -0500", hash_original_method = "D0236E56EB7DBB7A9FD9FE0F0B030A07", hash_generated_method = "BFC42B31CA1C4C999EA17472B847965F")
    
@Override
    public boolean isNamespaceAware() {
        try {
            return getFeature(NAMESPACES);
        } catch (SAXNotRecognizedException ex) {
            throw new AssertionError(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.754 -0500", hash_original_method = "8429289DC0C07EE6D0C2B7B5BD1C7C0B", hash_generated_method = "3BBAB4825D5D80469A63DFB9A8C10023")
    
@Override
    public boolean isValidating() {
        try {
            return getFeature(VALIDATION);
        } catch (SAXNotRecognizedException ex) {
            throw new AssertionError(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.756 -0500", hash_original_method = "296E37D815DC1709C2AEF832AA03671B", hash_generated_method = "EFDD6A79C863EB4469F78CA98E03AF0A")
    
@Override
    public SAXParser newSAXParser() throws ParserConfigurationException {
        if (isValidating()) {
            throw new ParserConfigurationException(
                    "No validating SAXParser implementation available");
        }

        try {
            return new SAXParserImpl(features);
        } catch (Exception ex) {
            throw new ParserConfigurationException(ex.toString());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.796 -0400", hash_original_method = "F8C86ADBC38F5FA5C922066DFA926032", hash_generated_method = "1A427FE4D75D4A651B4E08CFE65A510C")
    @Override
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException {
        addTaint(value);
        addTaint(name.getTaint());
        if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_564546876 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_564546876.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_564546876;
        } //End block
        if(!name.startsWith("http://xml.org/sax/features/"))        
        {
            SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_1668489285 = new SAXNotRecognizedException(name);
            var5FC954F6CCADD58BC8498AD6F3DB9EC4_1668489285.addTaint(taint);
            throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_1668489285;
        } //End block
        if(value)        
        {
            features.put(name, Boolean.TRUE);
        } //End block
        else
        {
            features.put(name, Boolean.FALSE);
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (!name.startsWith("http://xml.org/sax/features/")) {
            //throw new SAXNotRecognizedException(name);
        //}
        //if (value) {
            //features.put(name, Boolean.TRUE);
        //} else {
            //features.put(name, Boolean.FALSE);
        //}
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.761 -0500", hash_original_method = "2AAB52F0B6288669A1F1A42BDA5388FA", hash_generated_method = "BFEA5614FD2CD0D47E80DBB6FACBFD99")
    
@Override
    public void setNamespaceAware(boolean value) {
        try {
            setFeature(NAMESPACES, value);
        } catch (SAXNotRecognizedException ex) {
            throw new AssertionError(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.763 -0500", hash_original_method = "FD755E093F221B14C5D40C6AB8BA5348", hash_generated_method = "43B468C824FE9A8BED391481C74D8CC4")
    
@Override
    public void setValidating(boolean value) {
        try {
            setFeature(VALIDATION, value);
        } catch (SAXNotRecognizedException ex) {
            throw new AssertionError(ex);
        }
    }
}

