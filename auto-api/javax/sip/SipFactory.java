package javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;

public class SipFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.088 -0400", hash_original_field = "F15291B53700565A1AF38AB3C8B76F75", hash_generated_field = "0A333A66907627CDEDE0F61BF2FFB75E")

    private Map<String, SipStack> mNameSipStackMap = new HashMap<String, SipStack>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.089 -0400", hash_original_method = "310FD6F79BE3873A4CC6341AA537481F", hash_generated_method = "8EE8B7CE3FF369FB663AE49D47AA71E3")
    private  SipFactory() {
        
    }

    
    public static synchronized SipFactory getInstance() {
        if (sSipFactory == null) sSipFactory = new SipFactory();
        return sSipFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.090 -0400", hash_original_method = "4674ABC43EF2CEE4F0AE8B5BE63244D8", hash_generated_method = "1563E944C31091A298AF7AA59469E4FE")
    public synchronized void resetFactory() {
        mNameSipStackMap.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.091 -0400", hash_original_method = "46ABB390CF7D9D4CDAF3E704A7985B1B", hash_generated_method = "8026EE57CEEBBED3140ECB10BA0C37D7")
    public synchronized SipStack createSipStack(Properties properties) throws PeerUnavailableException {
        SipStack varB4EAC82CA7396A68D541C85D26508E83_732974557 = null; 
        String name = properties.getProperty(IP_ADDRESS_PROP);
        {
            name = properties.getProperty(STACK_NAME_PROP);
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        STACK_NAME_PROP + " property not found");
            } 
        } 
        SipStack sipStack = mNameSipStackMap.get(name);
        {
            String implClassName = "gov.nist."
                    + SipStack.class.getCanonicalName() + "Impl";
            try 
            {
                sipStack = Class.forName(implClassName)
                        .asSubclass(SipStack.class)
                        .getConstructor(new Class[] {Properties.class})
                        .newInstance(new Object[] {properties});
            } 
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to initiate " + implClassName, e);
            } 
            mNameSipStackMap.put(name, sipStack);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_732974557 = sipStack;
        addTaint(properties.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_732974557.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_732974557;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.092 -0400", hash_original_method = "131499B33C0579C2805DA9334AD4F6E4", hash_generated_method = "F722D449EF7A4C85E981BFB2EAC46FB9")
    public AddressFactory createAddressFactory() throws PeerUnavailableException {
        AddressFactory varB4EAC82CA7396A68D541C85D26508E83_1359382278 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1359382278 = new gov.nist.javax.sip.address.AddressFactoryImpl();
        } 
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (PeerUnavailableException) e;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to create AddressFactory", e);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1359382278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1359382278;
        
        
            
        
            
                
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.092 -0400", hash_original_method = "0FA4F64CC80ADFAB389758154B5AE216", hash_generated_method = "9B3D8A8E92F671181AFD5486AB3DF822")
    public HeaderFactory createHeaderFactory() throws PeerUnavailableException {
        HeaderFactory varB4EAC82CA7396A68D541C85D26508E83_1367458765 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1367458765 = new gov.nist.javax.sip.header.HeaderFactoryImpl();
        } 
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (PeerUnavailableException) e;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to create HeaderFactory", e);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1367458765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1367458765;
        
        
            
        
            
                
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.094 -0400", hash_original_method = "633D2CDB57C82E2B47B87FEFEA967AF9", hash_generated_method = "37DB8B4DC633F9F680450CA27ACA7F2A")
    public MessageFactory createMessageFactory() throws PeerUnavailableException {
        MessageFactory varB4EAC82CA7396A68D541C85D26508E83_138701568 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_138701568 = new gov.nist.javax.sip.message.MessageFactoryImpl();
        } 
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (PeerUnavailableException) e;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to create MessageFactory", e);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_138701568.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_138701568;
        
        
            
        
            
                
            
                
                        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.094 -0400", hash_original_field = "B52DAE80C3C897CBB987F034AC046F76", hash_generated_field = "34C141ED4403B005310012F8C335B3E5")

    private static final String IP_ADDRESS_PROP = "javax.sip.IP_ADDRESS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.094 -0400", hash_original_field = "23382FC72ADC4B0693230F251509D9FF", hash_generated_field = "2EFFA539BE9A2D5A1CF91EB3DFF2617A")

    private static final String STACK_NAME_PROP = "javax.sip.STACK_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.094 -0400", hash_original_field = "6F2288AC88E3EAF10AED7DA17F531E2F", hash_generated_field = "72CBBA349D76B2D2024E1DEDE9F885E4")

    private static SipFactory sSipFactory = null;
}

