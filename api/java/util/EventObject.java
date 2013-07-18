package java.util;

// Droidsafe Imports
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class EventObject implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.908 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "B89FD14140C3D96FD5EE1AB3347DDB03")

    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED") protected transient Object source;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.909 -0400", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "9FDB8B0F6700A6AF6E6D6EA32866534C")
    public  EventObject(Object source) {
        if(source == null)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1587398585 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1587398585.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1587398585;
        } //End block
        this.source = source;
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new IllegalArgumentException();
        //}
        //this.source = source;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.909 -0400", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "37F609D4B23513D66A9C81C847CA1EB5")
    public Object getSource() {
Object var87D92E4D22D3928BDE6A72969186AF86_1091750433 =         source;
        var87D92E4D22D3928BDE6A72969186AF86_1091750433.addTaint(taint);
        return var87D92E4D22D3928BDE6A72969186AF86_1091750433;
        // ---------- Original Method ----------
        //return source;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.909 -0400", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "B3477B2D634FF06BCA2007258FD66022")
    @Override
    public String toString() {
String var178B53FC42AF410704CA95F6BC97B99F_2059559042 =         getClass().getName() + "[source=" + source + ']';
        var178B53FC42AF410704CA95F6BC97B99F_2059559042.addTaint(taint);
        return var178B53FC42AF410704CA95F6BC97B99F_2059559042;
        // ---------- Original Method ----------
        //return getClass().getName() + "[source=" + source + ']';
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.909 -0400", hash_original_field = "D96D8741991E0FF309E98E4D0FF23C6A", hash_generated_field = "7EDA1B54A84BB88DBCC9E4ADB18207F4")

    private static final long serialVersionUID = 5516075349620653480L;
}

