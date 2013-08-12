package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;



public class DigestException extends GeneralSecurityException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.827 -0400", hash_original_method = "5DAAB61061CBFECD5A1E1A61BC7BAA88", hash_generated_method = "2992D047403F360329B182C14D4D443A")
    public  DigestException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.828 -0400", hash_original_method = "4BFD0A9812571E805B2B692917954A18", hash_generated_method = "32516E3A03E7277423B9AFF8010A7A86")
    public  DigestException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.828 -0400", hash_original_method = "BCC7846DF9BFB7C5F5EA1087695CCF8F", hash_generated_method = "EB3FC4A1FBB30CB17281A60A70B7E236")
    public  DigestException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.828 -0400", hash_original_method = "57079B2A067E95F6018E75F3448CD9E3", hash_generated_method = "9483021684AF42E332153F4EA1890266")
    public  DigestException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.829 -0400", hash_original_field = "979ECC2C2D22EE0B0A61C9FBCBC3C9A8", hash_generated_field = "853F3DF1FAC804A2D310C3B47CFD7996")

    private static final long serialVersionUID = 5821450303093652515L;
}

