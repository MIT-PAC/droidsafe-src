package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXNotRecognizedException;




public class SAXParserFactoryImpl extends SAXParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.791 -0400", hash_original_field = "987495AE8EA75D7FFAE9F17C211F4863", hash_generated_field = "BBF36E0D89D30BFFC00EE4B538D5AA0E")

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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.793 -0400", hash_original_method = "D0236E56EB7DBB7A9FD9FE0F0B030A07", hash_generated_method = "4793B14099C6AC50A75111C67B60E8D4")
    @Override
    public boolean isNamespaceAware() {
        try 
        {
            boolean varA85D5027A8BF86F9880028EE82799B8C_1166214095 = (getFeature(NAMESPACES));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355774060 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_355774060;
        } //End block
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_1250886003 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_1250886003.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_1250886003;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getFeature(NAMESPACES);
        //} catch (SAXNotRecognizedException ex) {
            //throw new AssertionError(ex);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.794 -0400", hash_original_method = "8429289DC0C07EE6D0C2B7B5BD1C7C0B", hash_generated_method = "0E74336AB365DE33E4AD4CBA6C3EEC77")
    @Override
    public boolean isValidating() {
        try 
        {
            boolean var8C62165CDF43988EF5B0DB9142FB8CE1_268505903 = (getFeature(VALIDATION));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807750672 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807750672;
        } //End block
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_210783407 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_210783407.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_210783407;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getFeature(VALIDATION);
        //} catch (SAXNotRecognizedException ex) {
            //throw new AssertionError(ex);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.795 -0400", hash_original_method = "296E37D815DC1709C2AEF832AA03671B", hash_generated_method = "77B60062746E0ED42949EB8B22DBE242")
    @Override
    public SAXParser newSAXParser() throws ParserConfigurationException {
        if(isValidating())        
        {
            ParserConfigurationException var3EE88861DE2349AF63FE4F2DF1665BA3_1486043171 = new ParserConfigurationException(
                    "No validating SAXParser implementation available");
            var3EE88861DE2349AF63FE4F2DF1665BA3_1486043171.addTaint(taint);
            throw var3EE88861DE2349AF63FE4F2DF1665BA3_1486043171;
        } //End block
        try 
        {
SAXParser var97136CDAC6E5068137219CC84BCFD745_372579539 =             new SAXParserImpl(features);
            var97136CDAC6E5068137219CC84BCFD745_372579539.addTaint(taint);
            return var97136CDAC6E5068137219CC84BCFD745_372579539;
        } //End block
        catch (Exception ex)
        {
            ParserConfigurationException var80352B97CDB95532FB2C18BFAB046C8B_13499543 = new ParserConfigurationException(ex.toString());
            var80352B97CDB95532FB2C18BFAB046C8B_13499543.addTaint(taint);
            throw var80352B97CDB95532FB2C18BFAB046C8B_13499543;
        } //End block
        // ---------- Original Method ----------
        //if (isValidating()) {
            //throw new ParserConfigurationException(
                    //"No validating SAXParser implementation available");
        //}
        //try {
            //return new SAXParserImpl(features);
        //} catch (Exception ex) {
            //throw new ParserConfigurationException(ex.toString());
        //}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.796 -0400", hash_original_method = "2AAB52F0B6288669A1F1A42BDA5388FA", hash_generated_method = "7C1B418C9E6BCDD054C73197A2130C2E")
    @Override
    public void setNamespaceAware(boolean value) {
        addTaint(value);
        try 
        {
            setFeature(NAMESPACES, value);
        } //End block
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_1143998732 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_1143998732.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_1143998732;
        } //End block
        // ---------- Original Method ----------
        //try {
            //setFeature(NAMESPACES, value);
        //} catch (SAXNotRecognizedException ex) {
            //throw new AssertionError(ex);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.797 -0400", hash_original_method = "FD755E093F221B14C5D40C6AB8BA5348", hash_generated_method = "0F19FD11F6B8C2EE843D2F7D095BC991")
    @Override
    public void setValidating(boolean value) {
        addTaint(value);
        try 
        {
            setFeature(VALIDATION, value);
        } //End block
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_1122307185 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_1122307185.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_1122307185;
        } //End block
        // ---------- Original Method ----------
        //try {
            //setFeature(VALIDATION, value);
        //} catch (SAXNotRecognizedException ex) {
            //throw new AssertionError(ex);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.797 -0400", hash_original_field = "57DAABD72ED77A96967246F7788B1447", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")

    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.797 -0400", hash_original_field = "1A6983F26F9A43F675933304E11A084C", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")

    private static final String VALIDATION = "http://xml.org/sax/features/validation";
}

