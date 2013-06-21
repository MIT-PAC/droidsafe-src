package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public class EventObject implements Serializable {
    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED") protected transient Object source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.998 -0400", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "539F58D648529C52316036638ABF98BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EventObject(Object source) {
        dsTaint.addTaint(source.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new IllegalArgumentException();
        //}
        //this.source = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.999 -0400", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "33A4463FD0061A35ECAAA2BF2874DC3D")
    @DSModeled(DSC.SAFE)
    public Object getSource() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.999 -0400", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "73B3B246BEBFDA1412839BC67272488D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var4E99393A8FD87533AC3DB6D22CE75C76_1662568470 = (getClass().getName() + "[source=" + source + ']');
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[source=" + source + ']';
    }

    
    private static final long serialVersionUID = 5516075349620653480L;
}

