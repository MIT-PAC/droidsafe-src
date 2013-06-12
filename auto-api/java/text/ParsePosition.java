package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ParsePosition {
    private int currentPosition, errorIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.141 -0400", hash_original_method = "DC50BCA5F95CF2B530ABA250C6125033", hash_generated_method = "09B05EE4C4E3382CD6BF98957BF12520")
    @DSModeled(DSC.SAFE)
    public ParsePosition(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.142 -0400", hash_original_method = "7A2CC483DDAB3EA409EA20ED7AF6932E", hash_generated_method = "0473B3827026BD50EC1378294E1C1A97")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        ParsePosition pos;
        pos = (ParsePosition) object;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(object instanceof ParsePosition)) {
            //return false;
        //}
        //ParsePosition pos = (ParsePosition) object;
        //return currentPosition == pos.currentPosition
                //&& errorIndex == pos.errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.142 -0400", hash_original_method = "251F29749A0D498AD09891D5409959A9", hash_generated_method = "66CEC0346C3EA2C9E13FC713BD51E1F2")
    @DSModeled(DSC.SAFE)
    public int getErrorIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.142 -0400", hash_original_method = "1CFE76DD95166F56A240763AD86BFFF6", hash_generated_method = "CB7B623CB5F3588CFA15603D614C39EC")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return currentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.142 -0400", hash_original_method = "78BEA0F92DBA8060A51AB3A3D8273064", hash_generated_method = "0DDE50FDB546B9EBD116E3CC698E0AA2")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return currentPosition + errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.142 -0400", hash_original_method = "F3EA9276CC48A5113CA1E4D2C48DC7D4", hash_generated_method = "A899D8C2AED4872B6A02A4EA2BDF63E2")
    @DSModeled(DSC.SAFE)
    public void setErrorIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //errorIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.142 -0400", hash_original_method = "1C6C7B20133CCF9092C9B321C0CF7A81", hash_generated_method = "B43F45C23692CEC135397AA338E4875E")
    @DSModeled(DSC.SAFE)
    public void setIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.142 -0400", hash_original_method = "EA803D38773CA0193E1AA7C91AAA6A50", hash_generated_method = "C3345D57230E24132D0BEA65818C44E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var454C1C1E56F7CF7C6D7F068B75A45571_1380103607 = (getClass().getName() + "[index=" + currentPosition
                + ", errorIndex=" + errorIndex + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[index=" + currentPosition
                //+ ", errorIndex=" + errorIndex + "]";
    }

    
}


