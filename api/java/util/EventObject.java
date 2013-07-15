package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public class EventObject implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.261 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "B89FD14140C3D96FD5EE1AB3347DDB03")

    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED") protected transient Object source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.262 -0400", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "0D4E9D99F8FF87F195F3CF7007BE476E")
    public  EventObject(Object source) {
    if(source == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_390001333 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_390001333.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_390001333;
        } //End block
        this.source = source;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new IllegalArgumentException();
        //}
        //this.source = source;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.263 -0400", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "8F9ECC52A0A2F272E8505CC0EE74154E")
    public Object getSource() {
Object var87D92E4D22D3928BDE6A72969186AF86_870932577 =         source;
        var87D92E4D22D3928BDE6A72969186AF86_870932577.addTaint(taint);
        return var87D92E4D22D3928BDE6A72969186AF86_870932577;
        // ---------- Original Method ----------
        //return source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.264 -0400", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "E58B17D548D56C81D6AFCF1EB70AF23B")
    @Override
    public String toString() {
String var178B53FC42AF410704CA95F6BC97B99F_1712402776 =         getClass().getName() + "[source=" + source + ']';
        var178B53FC42AF410704CA95F6BC97B99F_1712402776.addTaint(taint);
        return var178B53FC42AF410704CA95F6BC97B99F_1712402776;
        // ---------- Original Method ----------
        //return getClass().getName() + "[source=" + source + ']';
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.264 -0400", hash_original_field = "D96D8741991E0FF309E98E4D0FF23C6A", hash_generated_field = "7EDA1B54A84BB88DBCC9E4ADB18207F4")

    private static final long serialVersionUID = 5516075349620653480L;
}

