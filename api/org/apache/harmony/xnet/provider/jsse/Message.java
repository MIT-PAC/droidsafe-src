package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

public abstract class Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.504 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.504 -0400", hash_original_method = "1320821CB7E319AA2006FCB6CC079C6F", hash_generated_method = "1320821CB7E319AA2006FCB6CC079C6F")
    public Message ()
    {
        
    }


    abstract int getType();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.505 -0400", hash_original_method = "A95929A9D1E422E13DF7B6BE29D62093", hash_generated_method = "10C8C93898B328E36AEAD1AE97E3208C")
    public int length() {
        int var2FA47F7C65FEC19CC163B195725E3844_1945838412 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439895760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439895760;
        
        
    }

    
    abstract void send(HandshakeIODataStream out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.506 -0400", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "747E17B64578AEDE3984DA1ACA6E5F6F")
    protected void fatalAlert(byte description, String reason) {
        addTaint(reason.getTaint());
        addTaint(description);
        AlertException var799552F05CBB23D97AC6FE1EE17DC122_64980677 = new AlertException(description, new SSLHandshakeException(reason));
        var799552F05CBB23D97AC6FE1EE17DC122_64980677.addTaint(taint);
        throw var799552F05CBB23D97AC6FE1EE17DC122_64980677;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.506 -0400", hash_original_method = "8FFC926D3CD0D9B230B909F759D2E972", hash_generated_method = "99652ED7F00FB675F4FA26124BAEF0CA")
    protected void fatalAlert(byte description, String reason, Throwable cause) {
        addTaint(cause.getTaint());
        addTaint(reason.getTaint());
        addTaint(description);
        AlertException varAB600E5C2470883884CE64C72AED6B37_1621126044 = new AlertException(description, new SSLException(reason, cause));
        varAB600E5C2470883884CE64C72AED6B37_1621126044.addTaint(taint);
        throw varAB600E5C2470883884CE64C72AED6B37_1621126044;
        
        
    }

    
}

