package org.apache.harmony.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;

public class SAXParserFactoryImpl extends SAXParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.518 -0400", hash_original_field = "987495AE8EA75D7FFAE9F17C211F4863", hash_generated_field = "BBF36E0D89D30BFFC00EE4B538D5AA0E")

    private Map<String, Boolean> features = new HashMap<String, Boolean>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.518 -0400", hash_original_method = "BB7DD052856C5F48FEF96C6EA9CF9D9A", hash_generated_method = "BB7DD052856C5F48FEF96C6EA9CF9D9A")
    public SAXParserFactoryImpl ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.518 -0400", hash_original_method = "7A2715D86ACB75E2F46F70864B886736", hash_generated_method = "9B9BE6FC29DEBE3475765F30228C9330")
    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var0DD90ED7C4F94A2541AADCD92B315247_711339234 = (!name.startsWith("http://xml.org/sax/features/"));
            {
                if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
            } 
        } 
        boolean varD7EF5C05A876DA5F362CC7F45E3B2539_2075957124 = (Boolean.TRUE.equals(features.get(name)));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413733489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413733489;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.519 -0400", hash_original_method = "D0236E56EB7DBB7A9FD9FE0F0B030A07", hash_generated_method = "F1F5C512E8A86CC5D75B789293B2F7A0")
    @Override
    public boolean isNamespaceAware() {
        try 
        {
            boolean var25A733CB16E2C08AEAA35CEBC6C1F171_1758953239 = (getFeature(NAMESPACES));
        } 
        catch (SAXNotRecognizedException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(ex);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325108417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325108417;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.519 -0400", hash_original_method = "8429289DC0C07EE6D0C2B7B5BD1C7C0B", hash_generated_method = "25991BA47CC9086D3871E6812E0986E3")
    @Override
    public boolean isValidating() {
        try 
        {
            boolean var546AC4507E23F527F77ACB41D0E0B2EA_936457081 = (getFeature(VALIDATION));
        } 
        catch (SAXNotRecognizedException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(ex);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380844276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_380844276;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.520 -0400", hash_original_method = "296E37D815DC1709C2AEF832AA03671B", hash_generated_method = "096AD64FD61498C47B1B814D5DE4CAE2")
    @Override
    public SAXParser newSAXParser() throws ParserConfigurationException {
        SAXParser varB4EAC82CA7396A68D541C85D26508E83_1575585519 = null; 
        {
            boolean var4E297FF2ACA5FE750738C034402DA121_895895140 = (isValidating());
            {
                if (DroidSafeAndroidRuntime.control) throw new ParserConfigurationException(
                    "No validating SAXParser implementation available");
            } 
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1575585519 = new SAXParserImpl(features);
        } 
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParserConfigurationException(ex.toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1575585519.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1575585519;
        
        
            
                    
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.521 -0400", hash_original_method = "F8C86ADBC38F5FA5C922066DFA926032", hash_generated_method = "BEA66B658F68CA7E5C79829916DB81FB")
    @Override
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var0DD90ED7C4F94A2541AADCD92B315247_1968561225 = (!name.startsWith("http://xml.org/sax/features/"));
            {
                if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
            } 
        } 
        {
            features.put(name, Boolean.TRUE);
        } 
        {
            features.put(name, Boolean.FALSE);
        } 
        addTaint(name.getTaint());
        addTaint(value);
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.521 -0400", hash_original_method = "2AAB52F0B6288669A1F1A42BDA5388FA", hash_generated_method = "933E0F2800F06846B852563B7B015D0E")
    @Override
    public void setNamespaceAware(boolean value) {
        try 
        {
            setFeature(NAMESPACES, value);
        } 
        catch (SAXNotRecognizedException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(ex);
        } 
        addTaint(value);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.522 -0400", hash_original_method = "FD755E093F221B14C5D40C6AB8BA5348", hash_generated_method = "564D70865B9E88C5AB718774D3F0F001")
    @Override
    public void setValidating(boolean value) {
        try 
        {
            setFeature(VALIDATION, value);
        } 
        catch (SAXNotRecognizedException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(ex);
        } 
        addTaint(value);
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.522 -0400", hash_original_field = "57DAABD72ED77A96967246F7788B1447", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")

    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.522 -0400", hash_original_field = "1A6983F26F9A43F675933304E11A084C", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")

    private static final String VALIDATION = "http://xml.org/sax/features/validation";
}

