package org.apache.harmony.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;

public class SAXParserFactoryImpl extends SAXParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.687 -0400", hash_original_field = "987495AE8EA75D7FFAE9F17C211F4863", hash_generated_field = "BBF36E0D89D30BFFC00EE4B538D5AA0E")

    private Map<String, Boolean> features = new HashMap<String, Boolean>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.687 -0400", hash_original_method = "BB7DD052856C5F48FEF96C6EA9CF9D9A", hash_generated_method = "BB7DD052856C5F48FEF96C6EA9CF9D9A")
    public SAXParserFactoryImpl ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.688 -0400", hash_original_method = "7A2715D86ACB75E2F46F70864B886736", hash_generated_method = "9724D22F81B21260A529AE4B2A918799")
    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1024040227 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1024040227.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1024040227;
        } 
    if(!name.startsWith("http://xml.org/sax/features/"))        
        {
            SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_450926000 = new SAXNotRecognizedException(name);
            var5FC954F6CCADD58BC8498AD6F3DB9EC4_450926000.addTaint(taint);
            throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_450926000;
        } 
        boolean var88BA011B209A52DCABE538CA75B2D11A_203097058 = (Boolean.TRUE.equals(features.get(name)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057682338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057682338;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.688 -0400", hash_original_method = "D0236E56EB7DBB7A9FD9FE0F0B030A07", hash_generated_method = "61833E4AF9894843C4A03D59D87800C5")
    @Override
    public boolean isNamespaceAware() {
        try 
        {
            boolean varA85D5027A8BF86F9880028EE82799B8C_668635403 = (getFeature(NAMESPACES));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875986083 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_875986083;
        } 
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_209011503 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_209011503.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_209011503;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.688 -0400", hash_original_method = "8429289DC0C07EE6D0C2B7B5BD1C7C0B", hash_generated_method = "E0F0A66BF7A38A135D771146BABBBC29")
    @Override
    public boolean isValidating() {
        try 
        {
            boolean var8C62165CDF43988EF5B0DB9142FB8CE1_2124854732 = (getFeature(VALIDATION));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136155682 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_136155682;
        } 
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_471994217 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_471994217.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_471994217;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.689 -0400", hash_original_method = "296E37D815DC1709C2AEF832AA03671B", hash_generated_method = "8FBD9B7D1F288AFBCEAA705BCCDBCCBE")
    @Override
    public SAXParser newSAXParser() throws ParserConfigurationException {
    if(isValidating())        
        {
            ParserConfigurationException var3EE88861DE2349AF63FE4F2DF1665BA3_391879814 = new ParserConfigurationException(
                    "No validating SAXParser implementation available");
            var3EE88861DE2349AF63FE4F2DF1665BA3_391879814.addTaint(taint);
            throw var3EE88861DE2349AF63FE4F2DF1665BA3_391879814;
        } 
        try 
        {
SAXParser var97136CDAC6E5068137219CC84BCFD745_1724644726 =             new SAXParserImpl(features);
            var97136CDAC6E5068137219CC84BCFD745_1724644726.addTaint(taint);
            return var97136CDAC6E5068137219CC84BCFD745_1724644726;
        } 
        catch (Exception ex)
        {
            ParserConfigurationException var80352B97CDB95532FB2C18BFAB046C8B_1838149224 = new ParserConfigurationException(ex.toString());
            var80352B97CDB95532FB2C18BFAB046C8B_1838149224.addTaint(taint);
            throw var80352B97CDB95532FB2C18BFAB046C8B_1838149224;
        } 
        
        
            
                    
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.690 -0400", hash_original_method = "F8C86ADBC38F5FA5C922066DFA926032", hash_generated_method = "6805EEC7699495B3A0B9D0EDD44B448D")
    @Override
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException {
        addTaint(value);
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_167065894 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_167065894.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_167065894;
        } 
    if(!name.startsWith("http://xml.org/sax/features/"))        
        {
            SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_602437636 = new SAXNotRecognizedException(name);
            var5FC954F6CCADD58BC8498AD6F3DB9EC4_602437636.addTaint(taint);
            throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_602437636;
        } 
    if(value)        
        {
            features.put(name, Boolean.TRUE);
        } 
        else
        {
            features.put(name, Boolean.FALSE);
        } 
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.691 -0400", hash_original_method = "2AAB52F0B6288669A1F1A42BDA5388FA", hash_generated_method = "F943FE6DDFD77CF4C102D282420F21E3")
    @Override
    public void setNamespaceAware(boolean value) {
        addTaint(value);
        try 
        {
            setFeature(NAMESPACES, value);
        } 
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_1954221752 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_1954221752.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_1954221752;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.691 -0400", hash_original_method = "FD755E093F221B14C5D40C6AB8BA5348", hash_generated_method = "C9D3C99DDE646D5FEA3B3FFFA7F0F271")
    @Override
    public void setValidating(boolean value) {
        addTaint(value);
        try 
        {
            setFeature(VALIDATION, value);
        } 
        catch (SAXNotRecognizedException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_1837602682 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_1837602682.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_1837602682;
        } 
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.692 -0400", hash_original_field = "57DAABD72ED77A96967246F7788B1447", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")

    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.692 -0400", hash_original_field = "1A6983F26F9A43F675933304E11A084C", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")

    private static final String VALIDATION = "http://xml.org/sax/features/validation";
}

