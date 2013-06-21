package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParsePosition {
    private int currentPosition, errorIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.483 -0400", hash_original_method = "DC50BCA5F95CF2B530ABA250C6125033", hash_generated_method = "EFAAC2A23238F3355E0E5E10F565D71C")
    @DSModeled(DSC.SAFE)
    public ParsePosition(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.484 -0400", hash_original_method = "7A2CC483DDAB3EA409EA20ED7AF6932E", hash_generated_method = "9B990A03EAE92D1E7AF8966092A001D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.484 -0400", hash_original_method = "251F29749A0D498AD09891D5409959A9", hash_generated_method = "83A59264AC53F9A201F9279B9740C300")
    @DSModeled(DSC.SAFE)
    public int getErrorIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.484 -0400", hash_original_method = "1CFE76DD95166F56A240763AD86BFFF6", hash_generated_method = "71818AC9D9D60DE952D8E6052F280E70")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return currentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.484 -0400", hash_original_method = "78BEA0F92DBA8060A51AB3A3D8273064", hash_generated_method = "A7986766CA6EFE4CC7ED9B2BD8FC9AB1")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return currentPosition + errorIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.485 -0400", hash_original_method = "F3EA9276CC48A5113CA1E4D2C48DC7D4", hash_generated_method = "DB1BF2A2D1F4D0679BD78C5E9A98D845")
    @DSModeled(DSC.SAFE)
    public void setErrorIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //errorIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.485 -0400", hash_original_method = "1C6C7B20133CCF9092C9B321C0CF7A81", hash_generated_method = "7E7A4CA4D7944CB37F3F3A19B970C18A")
    @DSModeled(DSC.SAFE)
    public void setIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //currentPosition = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.485 -0400", hash_original_method = "EA803D38773CA0193E1AA7C91AAA6A50", hash_generated_method = "FFE63D0B4635FE6BEACA2AB8D1925840")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var454C1C1E56F7CF7C6D7F068B75A45571_2071187719 = (getClass().getName() + "[index=" + currentPosition
                + ", errorIndex=" + errorIndex + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[index=" + currentPosition
                //+ ", errorIndex=" + errorIndex + "]";
    }

    
}

