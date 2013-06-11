package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;

public class EventObject implements Serializable {
    private static final long serialVersionUID = 5516075349620653480L;
    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    protected transient Object source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.135 -0400", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "987E082BCD07646E4ED04B159D9BE3BE")
    @DSModeled(DSC.SAFE)
    public EventObject(Object source) {
        dsTaint.addTaint(source.dsTaint);
        {
            throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (source == null) {
            //throw new IllegalArgumentException();
        //}
        //this.source = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.135 -0400", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "366AE93640E4BDD536BDD158C075D211")
    @DSModeled(DSC.SAFE)
    public Object getSource() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.135 -0400", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "C7BD203A147BCF77CE7E28C3E1386A35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var4E99393A8FD87533AC3DB6D22CE75C76_1888986933 = (getClass().getName() + "[source=" + source + ']');
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[source=" + source + ']';
    }

    
}


