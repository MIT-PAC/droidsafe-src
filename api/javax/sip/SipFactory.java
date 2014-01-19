package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;

public class SipFactory {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.006 -0500", hash_original_method = "F7F2D55AC38114BCE4E789F1EDF2BA17", hash_generated_method = "EECE14B7DA555E1BBD62271ECC62ECE1")
    
public static synchronized SipFactory getInstance() {
        if (sSipFactory == null) sSipFactory = new SipFactory();
        return sSipFactory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.998 -0500", hash_original_field = "BA885C31BAB6B1319B4B4F1C800842A2", hash_generated_field = "34C141ED4403B005310012F8C335B3E5")

    private static final String IP_ADDRESS_PROP = "javax.sip.IP_ADDRESS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.001 -0500", hash_original_field = "EFB8E4C0E3EED3FD0007CA8729E6BB1E", hash_generated_field = "2EFFA539BE9A2D5A1CF91EB3DFF2617A")

    private static final String STACK_NAME_PROP = "javax.sip.STACK_NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.003 -0500", hash_original_field = "C1D3320A3B9CD7CCA3CA3B3E0A0995AB", hash_generated_field = "72CBBA349D76B2D2024E1DEDE9F885E4")

    private static SipFactory sSipFactory = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.009 -0500", hash_original_field = "A0AB8B39EB9CE7959A4CAB9B6C1D8CB4", hash_generated_field = "0A333A66907627CDEDE0F61BF2FFB75E")

    private Map<String, SipStack> mNameSipStackMap =
            new HashMap<String, SipStack>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.012 -0500", hash_original_method = "310FD6F79BE3873A4CC6341AA537481F", hash_generated_method = "FBF172BABDB9A2D2604F43FA77916B34")
    
private SipFactory() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.014 -0500", hash_original_method = "4674ABC43EF2CEE4F0AE8B5BE63244D8", hash_generated_method = "819059286BD308683AB7A77A79902887")
    
public synchronized void resetFactory() {
        mNameSipStackMap.clear();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.017 -0500", hash_original_method = "46ABB390CF7D9D4CDAF3E704A7985B1B", hash_generated_method = "CE3ADE3EE0A4168935FB54A7B5D7BFD8")
    
public synchronized SipStack createSipStack(Properties properties)
            throws PeerUnavailableException {
        // for backward compatibility, if IP_ADDRESS_PROP exists, use it and
        // ignore STACK_NAME_PROP.
        String name = properties.getProperty(IP_ADDRESS_PROP);
        if (name == null) {
            name = properties.getProperty(STACK_NAME_PROP);
            if (name == null ) {
                throw new PeerUnavailableException(
                        STACK_NAME_PROP + " property not found");
            }
        }

        SipStack sipStack = mNameSipStackMap.get(name);
        if (sipStack == null) {
            String implClassName = "gov.nist."
                    + SipStack.class.getCanonicalName() + "Impl";
            try {
                sipStack = Class.forName(implClassName)
                        .asSubclass(SipStack.class)
                        .getConstructor(new Class[] {Properties.class})
                        .newInstance(new Object[] {properties});
            } catch (Exception e) {
                throw new PeerUnavailableException(
                        "Failed to initiate " + implClassName, e);
            }
            mNameSipStackMap.put(name, sipStack);
        }
        return sipStack;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.019 -0500", hash_original_method = "131499B33C0579C2805DA9334AD4F6E4", hash_generated_method = "32F7B9A706E81D5B21EE9C9802763108")
    
public AddressFactory createAddressFactory()
            throws PeerUnavailableException {
        try {
            return new gov.nist.javax.sip.address.AddressFactoryImpl();
        } catch (Exception e) {
            if (e instanceof PeerUnavailableException) {
                throw (PeerUnavailableException) e;
            } else {
                throw new PeerUnavailableException(
                        "Failed to create AddressFactory", e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.021 -0500", hash_original_method = "0FA4F64CC80ADFAB389758154B5AE216", hash_generated_method = "D300E6B850F7D4C0FFB462A91ED5E2E7")
    
public HeaderFactory createHeaderFactory() throws PeerUnavailableException {
        try {
            return new gov.nist.javax.sip.header.HeaderFactoryImpl();
        } catch (Exception e) {
            if (e instanceof PeerUnavailableException) {
                throw (PeerUnavailableException) e;
            } else {
                throw new PeerUnavailableException(
                        "Failed to create HeaderFactory", e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.023 -0500", hash_original_method = "633D2CDB57C82E2B47B87FEFEA967AF9", hash_generated_method = "4D299FA26D992B9C519F0E327E0E1D86")
    
public MessageFactory createMessageFactory()
            throws PeerUnavailableException {
        try {
            return new gov.nist.javax.sip.message.MessageFactoryImpl();
        } catch (Exception e) {
            if (e instanceof PeerUnavailableException) {
                throw (PeerUnavailableException) e;
            } else {
                throw new PeerUnavailableException(
                        "Failed to create MessageFactory", e);
            }
        }
    }
}

