package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;

public class SipFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.574 -0400", hash_original_field = "F15291B53700565A1AF38AB3C8B76F75", hash_generated_field = "0A333A66907627CDEDE0F61BF2FFB75E")

    private Map<String, SipStack> mNameSipStackMap = new HashMap<String, SipStack>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.578 -0400", hash_original_method = "310FD6F79BE3873A4CC6341AA537481F", hash_generated_method = "8EE8B7CE3FF369FB663AE49D47AA71E3")
    private  SipFactory() {
        // ---------- Original Method ----------
    }

    
        public static synchronized SipFactory getInstance() {
        if (sSipFactory == null) sSipFactory = new SipFactory();
        return sSipFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.581 -0400", hash_original_method = "4674ABC43EF2CEE4F0AE8B5BE63244D8", hash_generated_method = "1563E944C31091A298AF7AA59469E4FE")
    public synchronized void resetFactory() {
        mNameSipStackMap.clear();
        // ---------- Original Method ----------
        //mNameSipStackMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.590 -0400", hash_original_method = "46ABB390CF7D9D4CDAF3E704A7985B1B", hash_generated_method = "19ACD6D883BD4FE593AB3B16E22A741A")
    public synchronized SipStack createSipStack(Properties properties) throws PeerUnavailableException {
        SipStack varB4EAC82CA7396A68D541C85D26508E83_1913431021 = null; //Variable for return #1
        String name;
        name = properties.getProperty(IP_ADDRESS_PROP);
        {
            name = properties.getProperty(STACK_NAME_PROP);
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        STACK_NAME_PROP + " property not found");
            } //End block
        } //End block
        SipStack sipStack;
        sipStack = mNameSipStackMap.get(name);
        {
            String implClassName;
            implClassName = "gov.nist."
                    + SipStack.class.getCanonicalName() + "Impl";
            try 
            {
                sipStack = Class.forName(implClassName)
                        .asSubclass(SipStack.class)
                        .getConstructor(new Class[] {Properties.class})
                        .newInstance(new Object[] {properties});
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to initiate " + implClassName, e);
            } //End block
            mNameSipStackMap.put(name, sipStack);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1913431021 = sipStack;
        addTaint(properties.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1913431021.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1913431021;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.599 -0400", hash_original_method = "131499B33C0579C2805DA9334AD4F6E4", hash_generated_method = "3B849FF6E7081F2C68E828E55ABB2656")
    public AddressFactory createAddressFactory() throws PeerUnavailableException {
        AddressFactory varB4EAC82CA7396A68D541C85D26508E83_636736221 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_636736221 = new gov.nist.javax.sip.address.AddressFactoryImpl();
        } //End block
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (PeerUnavailableException) e;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to create AddressFactory", e);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_636736221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636736221;
        // ---------- Original Method ----------
        //try {
            //return new gov.nist.javax.sip.address.AddressFactoryImpl();
        //} catch (Exception e) {
            //if (e instanceof PeerUnavailableException) {
                //throw (PeerUnavailableException) e;
            //} else {
                //throw new PeerUnavailableException(
                        //"Failed to create AddressFactory", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.609 -0400", hash_original_method = "0FA4F64CC80ADFAB389758154B5AE216", hash_generated_method = "71C5A4DCD0DE5C577BFB15BCE13F1761")
    public HeaderFactory createHeaderFactory() throws PeerUnavailableException {
        HeaderFactory varB4EAC82CA7396A68D541C85D26508E83_654097055 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_654097055 = new gov.nist.javax.sip.header.HeaderFactoryImpl();
        } //End block
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (PeerUnavailableException) e;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to create HeaderFactory", e);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_654097055.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_654097055;
        // ---------- Original Method ----------
        //try {
            //return new gov.nist.javax.sip.header.HeaderFactoryImpl();
        //} catch (Exception e) {
            //if (e instanceof PeerUnavailableException) {
                //throw (PeerUnavailableException) e;
            //} else {
                //throw new PeerUnavailableException(
                        //"Failed to create HeaderFactory", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.613 -0400", hash_original_method = "633D2CDB57C82E2B47B87FEFEA967AF9", hash_generated_method = "44F03709F4849CC2710807CAB5BCC84E")
    public MessageFactory createMessageFactory() throws PeerUnavailableException {
        MessageFactory varB4EAC82CA7396A68D541C85D26508E83_1240715842 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1240715842 = new gov.nist.javax.sip.message.MessageFactoryImpl();
        } //End block
        catch (Exception e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (PeerUnavailableException) e;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
                        "Failed to create MessageFactory", e);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1240715842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1240715842;
        // ---------- Original Method ----------
        //try {
            //return new gov.nist.javax.sip.message.MessageFactoryImpl();
        //} catch (Exception e) {
            //if (e instanceof PeerUnavailableException) {
                //throw (PeerUnavailableException) e;
            //} else {
                //throw new PeerUnavailableException(
                        //"Failed to create MessageFactory", e);
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.614 -0400", hash_original_field = "B52DAE80C3C897CBB987F034AC046F76", hash_generated_field = "75C1CF51B9B33DF2A13C2B4492B115B3")

    private static String IP_ADDRESS_PROP = "javax.sip.IP_ADDRESS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.614 -0400", hash_original_field = "23382FC72ADC4B0693230F251509D9FF", hash_generated_field = "0CD395322606645C702E622B38AB94AA")

    private static String STACK_NAME_PROP = "javax.sip.STACK_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.614 -0400", hash_original_field = "6F2288AC88E3EAF10AED7DA17F531E2F", hash_generated_field = "72CBBA349D76B2D2024E1DEDE9F885E4")

    private static SipFactory sSipFactory = null;
}

