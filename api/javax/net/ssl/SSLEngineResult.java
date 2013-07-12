package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SSLEngineResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.689 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "3EDB9D951EE040B1BC6830CF666CCCCD")

    private SSLEngineResult.Status status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.690 -0400", hash_original_field = "412C59B2DCF10DB9CB06BD36CD184EF1", hash_generated_field = "F2C463FCEB0A45B07208B161F9FF9757")

    private SSLEngineResult.HandshakeStatus handshakeStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.690 -0400", hash_original_field = "98DE14CF6ED8BA2A08621F8989CBB73D", hash_generated_field = "B7E40EAAA68ABDE5DDF60571929046AC")

    private int bytesConsumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.690 -0400", hash_original_field = "E2C06B4E3C7D872CA40631F2B897CED4", hash_generated_field = "E53D2C5242B0192243BAF7EE50A5F6F7")

    private int bytesProduced;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.693 -0400", hash_original_method = "7E2A70A53EA60FD8E9743686AFF107DB", hash_generated_method = "7171093140A64FB73C6C491B15E76619")
    public  SSLEngineResult(SSLEngineResult.Status status,
            SSLEngineResult.HandshakeStatus handshakeStatus, int bytesConsumed, int bytesProduced) {
    if(status == null)        
        {
            IllegalArgumentException var0942C630AF72DE2BFAEF5B370BC34D38_1906141155 = new IllegalArgumentException("status is null");
            var0942C630AF72DE2BFAEF5B370BC34D38_1906141155.addTaint(taint);
            throw var0942C630AF72DE2BFAEF5B370BC34D38_1906141155;
        } //End block
    if(handshakeStatus == null)        
        {
            IllegalArgumentException varB99CC69C46C6DB9382D7F79A0AFCB228_559690479 = new IllegalArgumentException("handshakeStatus is null");
            varB99CC69C46C6DB9382D7F79A0AFCB228_559690479.addTaint(taint);
            throw varB99CC69C46C6DB9382D7F79A0AFCB228_559690479;
        } //End block
    if(bytesConsumed < 0)        
        {
            IllegalArgumentException varA0F469183671466F2BB471E20BA09B05_2091979765 = new IllegalArgumentException("bytesConsumed is negative");
            varA0F469183671466F2BB471E20BA09B05_2091979765.addTaint(taint);
            throw varA0F469183671466F2BB471E20BA09B05_2091979765;
        } //End block
    if(bytesProduced < 0)        
        {
            IllegalArgumentException varB233E283F5476C881DBBB0A747935895_1496216175 = new IllegalArgumentException("bytesProduced is negative");
            varB233E283F5476C881DBBB0A747935895_1496216175.addTaint(taint);
            throw varB233E283F5476C881DBBB0A747935895_1496216175;
        } //End block
        this.status = status;
        this.handshakeStatus = handshakeStatus;
        this.bytesConsumed = bytesConsumed;
        this.bytesProduced = bytesProduced;
        // ---------- Original Method ----------
        //if (status == null) {
            //throw new IllegalArgumentException("status is null");
        //}
        //if (handshakeStatus == null) {
            //throw new IllegalArgumentException("handshakeStatus is null");
        //}
        //if (bytesConsumed < 0) {
            //throw new IllegalArgumentException("bytesConsumed is negative");
        //}
        //if (bytesProduced < 0) {
            //throw new IllegalArgumentException("bytesProduced is negative");
        //}
        //this.status = status;
        //this.handshakeStatus = handshakeStatus;
        //this.bytesConsumed = bytesConsumed;
        //this.bytesProduced = bytesProduced;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.693 -0400", hash_original_method = "50C43A89B1F71600509DCA8EECE4A168", hash_generated_method = "D2EE9AE1C2DBC763EC0B217FF363FFCE")
    public final Status getStatus() {
Status var62D3D5D442782C1992154E821A40FA75_158016852 =         status;
        var62D3D5D442782C1992154E821A40FA75_158016852.addTaint(taint);
        return var62D3D5D442782C1992154E821A40FA75_158016852;
        // ---------- Original Method ----------
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.694 -0400", hash_original_method = "C7CAF6278BE86BD417FEC0CDFDF808C8", hash_generated_method = "26735830AF24ABC34DB2192CBBAA7C0D")
    public final HandshakeStatus getHandshakeStatus() {
HandshakeStatus varA438FF77BFC821A5A761FEC3F6183918_1532005227 =         handshakeStatus;
        varA438FF77BFC821A5A761FEC3F6183918_1532005227.addTaint(taint);
        return varA438FF77BFC821A5A761FEC3F6183918_1532005227;
        // ---------- Original Method ----------
        //return handshakeStatus;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.694 -0400", hash_original_method = "4F217738DCB333D737660126178B49E9", hash_generated_method = "93F2632F0EA528905000D919508711C2")
    public final int bytesConsumed() {
        int var98DE14CF6ED8BA2A08621F8989CBB73D_984247078 = (bytesConsumed);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663672878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663672878;
        // ---------- Original Method ----------
        //return bytesConsumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.694 -0400", hash_original_method = "881854C294C034F2A83844483FCF0823", hash_generated_method = "94A15FE9444D69887C80084425F3B041")
    public final int bytesProduced() {
        int varE2C06B4E3C7D872CA40631F2B897CED4_1901228958 = (bytesProduced);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724223734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724223734;
        // ---------- Original Method ----------
        //return bytesProduced;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.695 -0400", hash_original_method = "FF10D49A46BF312B9918894EBDEF7098", hash_generated_method = "34641AB51CFCC59221F67DFFC6E4177A")
    @Override
    public String toString() {
String varDE9DD2D87E9E529ADDDDF77023101E71_1963059640 =         "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                + "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                + bytesProduced;
        varDE9DD2D87E9E529ADDDDF77023101E71_1963059640.addTaint(taint);
        return varDE9DD2D87E9E529ADDDDF77023101E71_1963059640;
        // ---------- Original Method ----------
        //return "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                //+ "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                //+ bytesProduced;
    }

    
    public enum HandshakeStatus {
        NOT_HANDSHAKING,
        FINISHED,
        NEED_TASK,
        NEED_WRAP,
        NEED_UNWRAP
    }

    
    public static enum Status {
        BUFFER_OVERFLOW,
        BUFFER_UNDERFLOW,
        CLOSED,
        OK
    }

    
}

