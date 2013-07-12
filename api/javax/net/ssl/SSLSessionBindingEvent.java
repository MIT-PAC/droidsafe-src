package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;

public class SSLSessionBindingEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.931 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.932 -0400", hash_original_method = "794652F3E2A819204DF4691F4DF3911D", hash_generated_method = "91724F7B9C934561C2C44054F87ACCB2")
    public  SSLSessionBindingEvent(SSLSession session, String name) {
        super(session);
        addTaint(session.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.932 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F1BB6F02A84ABF027920FEAA9D75EF44")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_168219376 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_168219376.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_168219376;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.933 -0400", hash_original_method = "C5768F99D51ECCDFF4B75CB996C2544E", hash_generated_method = "DFD0773FB9C695621192874B71704C4E")
    public SSLSession getSession() {
SSLSession var79F41965EC88B5A8CE331591C2D80475_1156591383 =         (SSLSession) this.source;
        var79F41965EC88B5A8CE331591C2D80475_1156591383.addTaint(taint);
        return var79F41965EC88B5A8CE331591C2D80475_1156591383;
        // ---------- Original Method ----------
        //return (SSLSession) this.source;
    }

    
}

