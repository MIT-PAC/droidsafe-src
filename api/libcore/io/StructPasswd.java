package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class StructPasswd {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.047 -0400", hash_original_field = "C2415329D52E0A42F30D9BDABA0BBB01", hash_generated_field = "E07C1468FB550ED4AB19E2FD56BE95B9")

    public String pw_name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.048 -0400", hash_original_field = "ABB80B12932A4D037CF53794DABCB6F4", hash_generated_field = "E2C54B2FF765C8E127CD9C05E35E9973")

    public int pw_uid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.049 -0400", hash_original_field = "45568004BD59D2A728184D6493FF8176", hash_generated_field = "EE0B4D699F4E3D30AD7F1B4B74709978")

    public int pw_gid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.050 -0400", hash_original_field = "EA9279442A39E3365BA7BFDA06FAB2FE", hash_generated_field = "9D1C72CD8FA5E02BC421F4F0C5A5FEBB")

    public String pw_dir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.051 -0400", hash_original_field = "15C0F79A0DCD74D148D91F56153C1A97", hash_generated_field = "FAAAF6C5111C71231817F976E3E59543")

    public String pw_shell;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.059 -0400", hash_original_method = "EB3B16ED172FAF9B32CFE20692469A46", hash_generated_method = "78885F7991B56E2917F3023676D088BF")
    public  StructPasswd(String pw_name, int pw_uid, int pw_gid, String pw_dir, String pw_shell) {
        this.pw_name = pw_name;
        this.pw_uid = pw_uid;
        this.pw_gid = pw_gid;
        this.pw_dir = pw_dir;
        this.pw_shell = pw_shell;
        // ---------- Original Method ----------
        //this.pw_name = pw_name;
        //this.pw_uid = pw_uid;
        //this.pw_gid = pw_gid;
        //this.pw_dir = pw_dir;
        //this.pw_shell = pw_shell;
    }

    
}

