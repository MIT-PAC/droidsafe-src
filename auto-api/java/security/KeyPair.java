package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class KeyPair implements Serializable {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.332 -0400", hash_original_method = "283304EE488E7CC511471A1BB564958E", hash_generated_method = "46DAD6FEFB6218B84BC9FEFCF1870977")
    @DSModeled(DSC.SAFE)
    public KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        dsTaint.addTaint(publicKey.dsTaint);
        dsTaint.addTaint(privateKey.dsTaint);
        // ---------- Original Method ----------
        //this.privateKey = privateKey;
        //this.publicKey = publicKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.332 -0400", hash_original_method = "3FFC913C725561B27B9684931E08C69F", hash_generated_method = "77124EDD63DEF956356B26745D698897")
    @DSModeled(DSC.SAFE)
    public PrivateKey getPrivate() {
        return (PrivateKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return privateKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.332 -0400", hash_original_method = "6C6DB8409915627C7F2AEC2B5C46974F", hash_generated_method = "77C6FD6F7C9AE379D0559936056C3BEC")
    @DSModeled(DSC.SAFE)
    public PublicKey getPublic() {
        return (PublicKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return publicKey;
    }

    
    private static final long serialVersionUID = -7565189502268009837L;
}

