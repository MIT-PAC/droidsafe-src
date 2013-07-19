package javax.net.ssl;

// Droidsafe Imports
import java.util.EventObject;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SSLSessionBindingEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.784 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.785 -0400", hash_original_method = "794652F3E2A819204DF4691F4DF3911D", hash_generated_method = "91724F7B9C934561C2C44054F87ACCB2")
    public  SSLSessionBindingEvent(SSLSession session, String name) {
        super(session);
        addTaint(session.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.785 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "66072BB264B3CDD1332ED176E184D309")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1108486395 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1108486395.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1108486395;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.786 -0400", hash_original_method = "C5768F99D51ECCDFF4B75CB996C2544E", hash_generated_method = "C1C71217E4AC29EBCB3A4F46C77DF17F")
    public SSLSession getSession() {
SSLSession var79F41965EC88B5A8CE331591C2D80475_291747762 =         (SSLSession) this.source;
        var79F41965EC88B5A8CE331591C2D80475_291747762.addTaint(taint);
        return var79F41965EC88B5A8CE331591C2D80475_291747762;
        // ---------- Original Method ----------
        //return (SSLSession) this.source;
    }

    
}

