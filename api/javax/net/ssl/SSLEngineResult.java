package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SSLEngineResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.702 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "3EDB9D951EE040B1BC6830CF666CCCCD")

    private SSLEngineResult.Status status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.703 -0400", hash_original_field = "412C59B2DCF10DB9CB06BD36CD184EF1", hash_generated_field = "F2C463FCEB0A45B07208B161F9FF9757")

    private SSLEngineResult.HandshakeStatus handshakeStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.703 -0400", hash_original_field = "98DE14CF6ED8BA2A08621F8989CBB73D", hash_generated_field = "B7E40EAAA68ABDE5DDF60571929046AC")

    private int bytesConsumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.703 -0400", hash_original_field = "E2C06B4E3C7D872CA40631F2B897CED4", hash_generated_field = "E53D2C5242B0192243BAF7EE50A5F6F7")

    private int bytesProduced;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.704 -0400", hash_original_method = "7E2A70A53EA60FD8E9743686AFF107DB", hash_generated_method = "3EE9E0CDF6E7F1FE40B33D1B1877FA9C")
    public  SSLEngineResult(SSLEngineResult.Status status,
            SSLEngineResult.HandshakeStatus handshakeStatus, int bytesConsumed, int bytesProduced) {
        if(status == null)        
        {
            IllegalArgumentException var0942C630AF72DE2BFAEF5B370BC34D38_787638028 = new IllegalArgumentException("status is null");
            var0942C630AF72DE2BFAEF5B370BC34D38_787638028.addTaint(taint);
            throw var0942C630AF72DE2BFAEF5B370BC34D38_787638028;
        } //End block
        if(handshakeStatus == null)        
        {
            IllegalArgumentException varB99CC69C46C6DB9382D7F79A0AFCB228_2035618997 = new IllegalArgumentException("handshakeStatus is null");
            varB99CC69C46C6DB9382D7F79A0AFCB228_2035618997.addTaint(taint);
            throw varB99CC69C46C6DB9382D7F79A0AFCB228_2035618997;
        } //End block
        if(bytesConsumed < 0)        
        {
            IllegalArgumentException varA0F469183671466F2BB471E20BA09B05_158521613 = new IllegalArgumentException("bytesConsumed is negative");
            varA0F469183671466F2BB471E20BA09B05_158521613.addTaint(taint);
            throw varA0F469183671466F2BB471E20BA09B05_158521613;
        } //End block
        if(bytesProduced < 0)        
        {
            IllegalArgumentException varB233E283F5476C881DBBB0A747935895_1742791873 = new IllegalArgumentException("bytesProduced is negative");
            varB233E283F5476C881DBBB0A747935895_1742791873.addTaint(taint);
            throw varB233E283F5476C881DBBB0A747935895_1742791873;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.704 -0400", hash_original_method = "50C43A89B1F71600509DCA8EECE4A168", hash_generated_method = "3E226B7B35726753B6869066381EDF7C")
    public final Status getStatus() {
Status var62D3D5D442782C1992154E821A40FA75_131929627 =         status;
        var62D3D5D442782C1992154E821A40FA75_131929627.addTaint(taint);
        return var62D3D5D442782C1992154E821A40FA75_131929627;
        // ---------- Original Method ----------
        //return status;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.704 -0400", hash_original_method = "C7CAF6278BE86BD417FEC0CDFDF808C8", hash_generated_method = "6C687D5B05AB90E0D7E044E763541A95")
    public final HandshakeStatus getHandshakeStatus() {
HandshakeStatus varA438FF77BFC821A5A761FEC3F6183918_1020062299 =         handshakeStatus;
        varA438FF77BFC821A5A761FEC3F6183918_1020062299.addTaint(taint);
        return varA438FF77BFC821A5A761FEC3F6183918_1020062299;
        // ---------- Original Method ----------
        //return handshakeStatus;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.705 -0400", hash_original_method = "4F217738DCB333D737660126178B49E9", hash_generated_method = "B313BE6F7177B54F80AA941BB38AAEE0")
    public final int bytesConsumed() {
        int var98DE14CF6ED8BA2A08621F8989CBB73D_29013235 = (bytesConsumed);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579742937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579742937;
        // ---------- Original Method ----------
        //return bytesConsumed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.705 -0400", hash_original_method = "881854C294C034F2A83844483FCF0823", hash_generated_method = "0368C4782D082850A3DAA8940C252E6D")
    public final int bytesProduced() {
        int varE2C06B4E3C7D872CA40631F2B897CED4_152941368 = (bytesProduced);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716035195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716035195;
        // ---------- Original Method ----------
        //return bytesProduced;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.705 -0400", hash_original_method = "FF10D49A46BF312B9918894EBDEF7098", hash_generated_method = "CB74B72A02D8455DC6839EAD1429650D")
    @Override
    public String toString() {
String varDE9DD2D87E9E529ADDDDF77023101E71_1962267759 =         "SSLEngineReport: Status = " + status + "  HandshakeStatus = " + handshakeStatus
                + "\n                 bytesConsumed = " + bytesConsumed + " bytesProduced = "
                + bytesProduced;
        varDE9DD2D87E9E529ADDDDF77023101E71_1962267759.addTaint(taint);
        return varDE9DD2D87E9E529ADDDDF77023101E71_1962267759;
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

