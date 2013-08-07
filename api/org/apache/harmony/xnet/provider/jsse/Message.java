package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;






public abstract class Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.675 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.676 -0400", hash_original_method = "1320821CB7E319AA2006FCB6CC079C6F", hash_generated_method = "1320821CB7E319AA2006FCB6CC079C6F")
    public Message ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    abstract int getType();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.677 -0400", hash_original_method = "A95929A9D1E422E13DF7B6BE29D62093", hash_generated_method = "3B26F06E75D42D67F565829230B39A7D")
    public int length() {
        int var2FA47F7C65FEC19CC163B195725E3844_1745266887 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237470392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237470392;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSModeled(DSC.SAFE)
    abstract void send(HandshakeIODataStream out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.678 -0400", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "31B29FD5145EB81D388DC83F9B3C1D6C")
    protected void fatalAlert(byte description, String reason) {
        addTaint(reason.getTaint());
        addTaint(description);
        AlertException var799552F05CBB23D97AC6FE1EE17DC122_1373895217 = new AlertException(description, new SSLHandshakeException(reason));
        var799552F05CBB23D97AC6FE1EE17DC122_1373895217.addTaint(taint);
        throw var799552F05CBB23D97AC6FE1EE17DC122_1373895217;
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLHandshakeException(reason));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.679 -0400", hash_original_method = "8FFC926D3CD0D9B230B909F759D2E972", hash_generated_method = "5BE4DFCE6A1E564CF417001C8BF819D8")
    protected void fatalAlert(byte description, String reason, Throwable cause) {
        addTaint(cause.getTaint());
        addTaint(reason.getTaint());
        addTaint(description);
        AlertException varAB600E5C2470883884CE64C72AED6B37_1781209232 = new AlertException(description, new SSLException(reason, cause));
        varAB600E5C2470883884CE64C72AED6B37_1781209232.addTaint(taint);
        throw varAB600E5C2470883884CE64C72AED6B37_1781209232;
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLException(reason, cause));
    }

    
}

