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
    private Map<String, SipStack> mNameSipStackMap =
            new HashMap<String, SipStack>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.249 -0400", hash_original_method = "310FD6F79BE3873A4CC6341AA537481F", hash_generated_method = "8EE8B7CE3FF369FB663AE49D47AA71E3")
    @DSModeled(DSC.SAFE)
    private SipFactory() {
        // ---------- Original Method ----------
    }

    
        public static synchronized SipFactory getInstance() {
        if (sSipFactory == null) sSipFactory = new SipFactory();
        return sSipFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.250 -0400", hash_original_method = "4674ABC43EF2CEE4F0AE8B5BE63244D8", hash_generated_method = "1563E944C31091A298AF7AA59469E4FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void resetFactory() {
        mNameSipStackMap.clear();
        // ---------- Original Method ----------
        //mNameSipStackMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.250 -0400", hash_original_method = "46ABB390CF7D9D4CDAF3E704A7985B1B", hash_generated_method = "D8CBB37C3AA0DD3BB7B48FDEAB2EB80A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized SipStack createSipStack(Properties properties) throws PeerUnavailableException {
        dsTaint.addTaint(properties.dsTaint);
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
        return (SipStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.251 -0400", hash_original_method = "131499B33C0579C2805DA9334AD4F6E4", hash_generated_method = "5A6B4FDFF4BFBE0C3470401B0B5F65F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AddressFactory createAddressFactory() throws PeerUnavailableException {
        try 
        {
            AddressFactory var6AF694B5D419C268DA7C049D6175DDEF_121363094 = (new gov.nist.javax.sip.address.AddressFactoryImpl());
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
        return (AddressFactory)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.251 -0400", hash_original_method = "0FA4F64CC80ADFAB389758154B5AE216", hash_generated_method = "190F49470AD2AC2D3338D9DF77D64C87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HeaderFactory createHeaderFactory() throws PeerUnavailableException {
        try 
        {
            HeaderFactory var32F2A8979A3FF385429B1D006CCD0A83_649768400 = (new gov.nist.javax.sip.header.HeaderFactoryImpl());
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
        return (HeaderFactory)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.251 -0400", hash_original_method = "633D2CDB57C82E2B47B87FEFEA967AF9", hash_generated_method = "2B3B768B3FEF719CD237D65C1B373591")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageFactory createMessageFactory() throws PeerUnavailableException {
        try 
        {
            MessageFactory var33ADCF231699D2545F551C42DF9E0B1E_2086616653 = (new gov.nist.javax.sip.message.MessageFactoryImpl());
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
        return (MessageFactory)dsTaint.getTaint();
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

    
    private static final String IP_ADDRESS_PROP = "javax.sip.IP_ADDRESS";
    private static final String STACK_NAME_PROP = "javax.sip.STACK_NAME";
    private static SipFactory sSipFactory = null;
}

