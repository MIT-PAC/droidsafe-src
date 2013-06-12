package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;

public class SipFactory {
    private static final String IP_ADDRESS_PROP = "javax.sip.IP_ADDRESS";
    private static final String STACK_NAME_PROP = "javax.sip.STACK_NAME";
    private static SipFactory sSipFactory = null;
    private Map<String, SipStack> mNameSipStackMap =
            new HashMap<String, SipStack>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.522 -0400", hash_original_method = "310FD6F79BE3873A4CC6341AA537481F", hash_generated_method = "94189ED90ADB17B8E52444BE6F791A30")
    @DSModeled(DSC.SAFE)
    private SipFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.522 -0400", hash_original_method = "F7F2D55AC38114BCE4E789F1EDF2BA17", hash_generated_method = "EECE14B7DA555E1BBD62271ECC62ECE1")
    public static synchronized SipFactory getInstance() {
        if (sSipFactory == null) sSipFactory = new SipFactory();
        return sSipFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.522 -0400", hash_original_method = "4674ABC43EF2CEE4F0AE8B5BE63244D8", hash_generated_method = "1DA7CDC26D29769A759EA35C6A308EDF")
    @DSModeled(DSC.SAFE)
    public synchronized void resetFactory() {
        mNameSipStackMap.clear();
        // ---------- Original Method ----------
        //mNameSipStackMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.523 -0400", hash_original_method = "46ABB390CF7D9D4CDAF3E704A7985B1B", hash_generated_method = "7597D722F1B5080644F6BA949D570116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized SipStack createSipStack(Properties properties) throws PeerUnavailableException {
        dsTaint.addTaint(properties.dsTaint);
        String name;
        name = properties.getProperty(IP_ADDRESS_PROP);
        {
            name = properties.getProperty(STACK_NAME_PROP);
            {
                throw new PeerUnavailableException(
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
                throw new PeerUnavailableException(
                        "Failed to initiate " + implClassName, e);
            } //End block
            mNameSipStackMap.put(name, sipStack);
        } //End block
        return (SipStack)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.523 -0400", hash_original_method = "131499B33C0579C2805DA9334AD4F6E4", hash_generated_method = "6354BCCA65B72719B529E935DF54AA15")
    @DSModeled(DSC.SAFE)
    public AddressFactory createAddressFactory() throws PeerUnavailableException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.523 -0400", hash_original_method = "0FA4F64CC80ADFAB389758154B5AE216", hash_generated_method = "0365A8931CE3FB3D339EFC87DDA1D30B")
    @DSModeled(DSC.SAFE)
    public HeaderFactory createHeaderFactory() throws PeerUnavailableException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.523 -0400", hash_original_method = "633D2CDB57C82E2B47B87FEFEA967AF9", hash_generated_method = "510AAA5FE8BD55C19FF95F3475CCFC9C")
    @DSModeled(DSC.SAFE)
    public MessageFactory createMessageFactory() throws PeerUnavailableException {
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

    
}


