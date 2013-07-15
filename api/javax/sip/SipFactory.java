package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;

public class SipFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.283 -0400", hash_original_field = "F15291B53700565A1AF38AB3C8B76F75", hash_generated_field = "0A333A66907627CDEDE0F61BF2FFB75E")

    private Map<String, SipStack> mNameSipStackMap = new HashMap<String, SipStack>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.283 -0400", hash_original_method = "310FD6F79BE3873A4CC6341AA537481F", hash_generated_method = "8EE8B7CE3FF369FB663AE49D47AA71E3")
    private  SipFactory() {
        // ---------- Original Method ----------
    }

    
        public static synchronized SipFactory getInstance() {
        if (sSipFactory == null) sSipFactory = new SipFactory();
        return sSipFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.284 -0400", hash_original_method = "4674ABC43EF2CEE4F0AE8B5BE63244D8", hash_generated_method = "1563E944C31091A298AF7AA59469E4FE")
    public synchronized void resetFactory() {
        mNameSipStackMap.clear();
        // ---------- Original Method ----------
        //mNameSipStackMap.clear();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.285 -0400", hash_original_method = "46ABB390CF7D9D4CDAF3E704A7985B1B", hash_generated_method = "371DE14694E31FB9B3B13865AB150E98")
    public synchronized SipStack createSipStack(Properties properties) throws PeerUnavailableException {
        addTaint(properties.getTaint());
        String name = properties.getProperty(IP_ADDRESS_PROP);
    if(name == null)        
        {
            name = properties.getProperty(STACK_NAME_PROP);
    if(name == null)            
            {
                PeerUnavailableException var8E8896BE5BB95599FB6403E563010A92_893344380 = new PeerUnavailableException(
                        STACK_NAME_PROP + " property not found");
                var8E8896BE5BB95599FB6403E563010A92_893344380.addTaint(taint);
                throw var8E8896BE5BB95599FB6403E563010A92_893344380;
            } //End block
        } //End block
        SipStack sipStack = mNameSipStackMap.get(name);
    if(sipStack == null)        
        {
            String implClassName = "gov.nist."
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
                PeerUnavailableException varB4B1F8BF26990A35C3130FDDD6F84EA1_941180237 = new PeerUnavailableException(
                        "Failed to initiate " + implClassName, e);
                varB4B1F8BF26990A35C3130FDDD6F84EA1_941180237.addTaint(taint);
                throw varB4B1F8BF26990A35C3130FDDD6F84EA1_941180237;
            } //End block
            mNameSipStackMap.put(name, sipStack);
        } //End block
SipStack var0FC1F21ED47F4C0C48881B0DAF112A16_1347803189 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_1347803189.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_1347803189;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.285 -0400", hash_original_method = "131499B33C0579C2805DA9334AD4F6E4", hash_generated_method = "4419901CDD4D4EF342C4956D39806321")
    public AddressFactory createAddressFactory() throws PeerUnavailableException {
        try 
        {
AddressFactory var562E421D95FD4411AB15911AADE81CA6_882091724 =             new gov.nist.javax.sip.address.AddressFactoryImpl();
            var562E421D95FD4411AB15911AADE81CA6_882091724.addTaint(taint);
            return var562E421D95FD4411AB15911AADE81CA6_882091724;
        } //End block
        catch (Exception e)
        {
    if(e instanceof PeerUnavailableException)            
            {
                PeerUnavailableException var8AD0B7A7B75CEB7D544732B36B4BF06C_653177171 = (PeerUnavailableException) e;
                var8AD0B7A7B75CEB7D544732B36B4BF06C_653177171.addTaint(taint);
                throw var8AD0B7A7B75CEB7D544732B36B4BF06C_653177171;
            } //End block
            else
            {
                PeerUnavailableException var396F214AE68FED43EE07EE6DA855C7B8_930510712 = new PeerUnavailableException(
                        "Failed to create AddressFactory", e);
                var396F214AE68FED43EE07EE6DA855C7B8_930510712.addTaint(taint);
                throw var396F214AE68FED43EE07EE6DA855C7B8_930510712;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.286 -0400", hash_original_method = "0FA4F64CC80ADFAB389758154B5AE216", hash_generated_method = "8F7BED36140E528E31819AF5E9320C33")
    public HeaderFactory createHeaderFactory() throws PeerUnavailableException {
        try 
        {
HeaderFactory varAC192C4527CC0F586B5A80B1EFE715DE_1506505426 =             new gov.nist.javax.sip.header.HeaderFactoryImpl();
            varAC192C4527CC0F586B5A80B1EFE715DE_1506505426.addTaint(taint);
            return varAC192C4527CC0F586B5A80B1EFE715DE_1506505426;
        } //End block
        catch (Exception e)
        {
    if(e instanceof PeerUnavailableException)            
            {
                PeerUnavailableException var8AD0B7A7B75CEB7D544732B36B4BF06C_1482796589 = (PeerUnavailableException) e;
                var8AD0B7A7B75CEB7D544732B36B4BF06C_1482796589.addTaint(taint);
                throw var8AD0B7A7B75CEB7D544732B36B4BF06C_1482796589;
            } //End block
            else
            {
                PeerUnavailableException varDDD394FB2667ABC128691B7DAD32ECB0_1489620489 = new PeerUnavailableException(
                        "Failed to create HeaderFactory", e);
                varDDD394FB2667ABC128691B7DAD32ECB0_1489620489.addTaint(taint);
                throw varDDD394FB2667ABC128691B7DAD32ECB0_1489620489;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.286 -0400", hash_original_method = "633D2CDB57C82E2B47B87FEFEA967AF9", hash_generated_method = "BB67590955F02D22F1EC0006BF1A3029")
    public MessageFactory createMessageFactory() throws PeerUnavailableException {
        try 
        {
MessageFactory varACD0A6CE063FAEC9BCD99F0E9CE1CEC0_1523206167 =             new gov.nist.javax.sip.message.MessageFactoryImpl();
            varACD0A6CE063FAEC9BCD99F0E9CE1CEC0_1523206167.addTaint(taint);
            return varACD0A6CE063FAEC9BCD99F0E9CE1CEC0_1523206167;
        } //End block
        catch (Exception e)
        {
    if(e instanceof PeerUnavailableException)            
            {
                PeerUnavailableException var8AD0B7A7B75CEB7D544732B36B4BF06C_831360476 = (PeerUnavailableException) e;
                var8AD0B7A7B75CEB7D544732B36B4BF06C_831360476.addTaint(taint);
                throw var8AD0B7A7B75CEB7D544732B36B4BF06C_831360476;
            } //End block
            else
            {
                PeerUnavailableException var86BF01E245BEF996D4705E1061808349_252739786 = new PeerUnavailableException(
                        "Failed to create MessageFactory", e);
                var86BF01E245BEF996D4705E1061808349_252739786.addTaint(taint);
                throw var86BF01E245BEF996D4705E1061808349_252739786;
            } //End block
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.287 -0400", hash_original_field = "B52DAE80C3C897CBB987F034AC046F76", hash_generated_field = "34C141ED4403B005310012F8C335B3E5")

    private static final String IP_ADDRESS_PROP = "javax.sip.IP_ADDRESS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.287 -0400", hash_original_field = "23382FC72ADC4B0693230F251509D9FF", hash_generated_field = "2EFFA539BE9A2D5A1CF91EB3DFF2617A")

    private static final String STACK_NAME_PROP = "javax.sip.STACK_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.287 -0400", hash_original_field = "6F2288AC88E3EAF10AED7DA17F531E2F", hash_generated_field = "72CBBA349D76B2D2024E1DEDE9F885E4")

    private static SipFactory sSipFactory = null;
}

