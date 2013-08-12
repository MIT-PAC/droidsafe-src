package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sip.address.AddressFactory;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;






public class SipFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.328 -0400", hash_original_field = "F15291B53700565A1AF38AB3C8B76F75", hash_generated_field = "0A333A66907627CDEDE0F61BF2FFB75E")

    private Map<String, SipStack> mNameSipStackMap = new HashMap<String, SipStack>();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.328 -0400", hash_original_method = "310FD6F79BE3873A4CC6341AA537481F", hash_generated_method = "8EE8B7CE3FF369FB663AE49D47AA71E3")
    private  SipFactory() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized SipFactory getInstance() {
        if (sSipFactory == null) sSipFactory = new SipFactory();
        return sSipFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.329 -0400", hash_original_method = "4674ABC43EF2CEE4F0AE8B5BE63244D8", hash_generated_method = "1563E944C31091A298AF7AA59469E4FE")
    public synchronized void resetFactory() {
        mNameSipStackMap.clear();
        // ---------- Original Method ----------
        //mNameSipStackMap.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.330 -0400", hash_original_method = "46ABB390CF7D9D4CDAF3E704A7985B1B", hash_generated_method = "B667111BBE519A55F44B9A13E23ECC26")
    public synchronized SipStack createSipStack(Properties properties) throws PeerUnavailableException {
        addTaint(properties.getTaint());
        String name = properties.getProperty(IP_ADDRESS_PROP);
        if(name == null)        
        {
            name = properties.getProperty(STACK_NAME_PROP);
            if(name == null)            
            {
                PeerUnavailableException var8E8896BE5BB95599FB6403E563010A92_2074036568 = new PeerUnavailableException(
                        STACK_NAME_PROP + " property not found");
                var8E8896BE5BB95599FB6403E563010A92_2074036568.addTaint(taint);
                throw var8E8896BE5BB95599FB6403E563010A92_2074036568;
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
                PeerUnavailableException varB4B1F8BF26990A35C3130FDDD6F84EA1_1020520436 = new PeerUnavailableException(
                        "Failed to initiate " + implClassName, e);
                varB4B1F8BF26990A35C3130FDDD6F84EA1_1020520436.addTaint(taint);
                throw varB4B1F8BF26990A35C3130FDDD6F84EA1_1020520436;
            } //End block
            mNameSipStackMap.put(name, sipStack);
        } //End block
SipStack var0FC1F21ED47F4C0C48881B0DAF112A16_1191162552 =         sipStack;
        var0FC1F21ED47F4C0C48881B0DAF112A16_1191162552.addTaint(taint);
        return var0FC1F21ED47F4C0C48881B0DAF112A16_1191162552;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.330 -0400", hash_original_method = "131499B33C0579C2805DA9334AD4F6E4", hash_generated_method = "A7CF642DC07F557CAF29EDB590758C67")
    public AddressFactory createAddressFactory() throws PeerUnavailableException {
        try 
        {
AddressFactory var562E421D95FD4411AB15911AADE81CA6_152485755 =             new gov.nist.javax.sip.address.AddressFactoryImpl();
            var562E421D95FD4411AB15911AADE81CA6_152485755.addTaint(taint);
            return var562E421D95FD4411AB15911AADE81CA6_152485755;
        } //End block
        catch (Exception e)
        {
            if(e instanceof PeerUnavailableException)            
            {
                PeerUnavailableException var8AD0B7A7B75CEB7D544732B36B4BF06C_652840489 = (PeerUnavailableException) e;
                var8AD0B7A7B75CEB7D544732B36B4BF06C_652840489.addTaint(taint);
                throw var8AD0B7A7B75CEB7D544732B36B4BF06C_652840489;
            } //End block
            else
            {
                PeerUnavailableException var396F214AE68FED43EE07EE6DA855C7B8_2064941039 = new PeerUnavailableException(
                        "Failed to create AddressFactory", e);
                var396F214AE68FED43EE07EE6DA855C7B8_2064941039.addTaint(taint);
                throw var396F214AE68FED43EE07EE6DA855C7B8_2064941039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.331 -0400", hash_original_method = "0FA4F64CC80ADFAB389758154B5AE216", hash_generated_method = "F192697BB1ACA931C22679C1ABEDEE22")
    public HeaderFactory createHeaderFactory() throws PeerUnavailableException {
        try 
        {
HeaderFactory varAC192C4527CC0F586B5A80B1EFE715DE_12685641 =             new gov.nist.javax.sip.header.HeaderFactoryImpl();
            varAC192C4527CC0F586B5A80B1EFE715DE_12685641.addTaint(taint);
            return varAC192C4527CC0F586B5A80B1EFE715DE_12685641;
        } //End block
        catch (Exception e)
        {
            if(e instanceof PeerUnavailableException)            
            {
                PeerUnavailableException var8AD0B7A7B75CEB7D544732B36B4BF06C_2096247206 = (PeerUnavailableException) e;
                var8AD0B7A7B75CEB7D544732B36B4BF06C_2096247206.addTaint(taint);
                throw var8AD0B7A7B75CEB7D544732B36B4BF06C_2096247206;
            } //End block
            else
            {
                PeerUnavailableException varDDD394FB2667ABC128691B7DAD32ECB0_1136134714 = new PeerUnavailableException(
                        "Failed to create HeaderFactory", e);
                varDDD394FB2667ABC128691B7DAD32ECB0_1136134714.addTaint(taint);
                throw varDDD394FB2667ABC128691B7DAD32ECB0_1136134714;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.331 -0400", hash_original_method = "633D2CDB57C82E2B47B87FEFEA967AF9", hash_generated_method = "0231C9B96783324293FE380461B7703A")
    public MessageFactory createMessageFactory() throws PeerUnavailableException {
        try 
        {
MessageFactory varACD0A6CE063FAEC9BCD99F0E9CE1CEC0_559768927 =             new gov.nist.javax.sip.message.MessageFactoryImpl();
            varACD0A6CE063FAEC9BCD99F0E9CE1CEC0_559768927.addTaint(taint);
            return varACD0A6CE063FAEC9BCD99F0E9CE1CEC0_559768927;
        } //End block
        catch (Exception e)
        {
            if(e instanceof PeerUnavailableException)            
            {
                PeerUnavailableException var8AD0B7A7B75CEB7D544732B36B4BF06C_17898439 = (PeerUnavailableException) e;
                var8AD0B7A7B75CEB7D544732B36B4BF06C_17898439.addTaint(taint);
                throw var8AD0B7A7B75CEB7D544732B36B4BF06C_17898439;
            } //End block
            else
            {
                PeerUnavailableException var86BF01E245BEF996D4705E1061808349_2071216438 = new PeerUnavailableException(
                        "Failed to create MessageFactory", e);
                var86BF01E245BEF996D4705E1061808349_2071216438.addTaint(taint);
                throw var86BF01E245BEF996D4705E1061808349_2071216438;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.332 -0400", hash_original_field = "B52DAE80C3C897CBB987F034AC046F76", hash_generated_field = "34C141ED4403B005310012F8C335B3E5")

    private static final String IP_ADDRESS_PROP = "javax.sip.IP_ADDRESS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.332 -0400", hash_original_field = "23382FC72ADC4B0693230F251509D9FF", hash_generated_field = "2EFFA539BE9A2D5A1CF91EB3DFF2617A")

    private static final String STACK_NAME_PROP = "javax.sip.STACK_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.332 -0400", hash_original_field = "6F2288AC88E3EAF10AED7DA17F531E2F", hash_generated_field = "72CBBA349D76B2D2024E1DEDE9F885E4")

    private static SipFactory sSipFactory = null;
}

