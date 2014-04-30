package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

public abstract class Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.641 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.676 -0400", hash_original_method = "1320821CB7E319AA2006FCB6CC079C6F", hash_generated_method = "1320821CB7E319AA2006FCB6CC079C6F")
    public Message ()
    {
        //Synthesized constructor
    }

    /**
     * Returns message type
     * @return
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.644 -0500", hash_original_method = "2661BA1F0AB44A1458B9DF009873A1E7", hash_generated_method = "36213AEFF6693FFB3A13105AE24E6A1E")
    
abstract int getType();

    /**
     * Returns message length
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.646 -0500", hash_original_method = "A95929A9D1E422E13DF7B6BE29D62093", hash_generated_method = "0744BCA0A089D0C6D748DF23D36A5A63")
    
public int length() {
        return length;
    }

    /**
     * Sends message
     * @param out
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.648 -0500", hash_original_method = "B58948AFEF1A0E057CD3CFAE54CA0552", hash_generated_method = "2E9F9AA3787127B95DA1E436E11287FE")
    
abstract void send(HandshakeIODataStream out);

    /**
     * Sends fatal alert
     * @param description
     * @param reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.651 -0500", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "9867DC8FBFE9F1B9BC6DB5E6A4B30F51")
    
protected void fatalAlert(byte description, String reason) {
        throw new AlertException(description, new SSLHandshakeException(reason));
    }

    /**
     * Sends fatal alert
     * @param description
     * @param reason
     * @param cause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.653 -0500", hash_original_method = "8FFC926D3CD0D9B230B909F759D2E972", hash_generated_method = "83D22385F41B2709BC1B4274EA441A3E")
    
protected void fatalAlert(byte description, String reason, Throwable cause) {
        throw new AlertException(description, new SSLException(reason, cause));
    }
    
}

