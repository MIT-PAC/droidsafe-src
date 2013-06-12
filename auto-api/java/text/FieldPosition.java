package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class FieldPosition {
    private int myField, beginIndex, endIndex;
    private Format.Field myAttribute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "E695F5151E58D69BC230540B458252AA", hash_generated_method = "DB6C8026F47F52B522A9993E6DE8A5C8")
    @DSModeled(DSC.SAFE)
    public FieldPosition(int field) {
        dsTaint.addTaint(field);
        // ---------- Original Method ----------
        //myField = field;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "67EE9DAFC04AACFB1E7BD135DD8AA2FB", hash_generated_method = "795F5A19486DAE566CB9B6B15E91B4C1")
    @DSModeled(DSC.SAFE)
    public FieldPosition(Format.Field attribute) {
        dsTaint.addTaint(attribute.dsTaint);
        myField = -1;
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "D49B7D40F2EA042BB514EAEBCB178B5A", hash_generated_method = "A99F0D4355FD65754BDAEC75261CD29B")
    @DSModeled(DSC.SAFE)
    public FieldPosition(Format.Field attribute, int field) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(attribute.dsTaint);
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = field;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "0917A34BEC387437E422442FF9D128A9", hash_generated_method = "B3A4323D4A039FA5AF465BB8B7EB95FF")
    @DSModeled(DSC.SAFE)
     void clear() {
        beginIndex = endIndex = 0;
        // ---------- Original Method ----------
        //beginIndex = endIndex = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "2EFD5CC62AE2C3EDB89CEF52D471F874", hash_generated_method = "81ED41C92D449BE26EC59EB160529ED5")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        FieldPosition pos;
        pos = (FieldPosition) object;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(object instanceof FieldPosition)) {
            //return false;
        //}
        //FieldPosition pos = (FieldPosition) object;
        //return myField == pos.myField && myAttribute == pos.myAttribute
                //&& beginIndex == pos.beginIndex && endIndex == pos.endIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "D73EFD1B11663E2F20B33728384A7709", hash_generated_method = "CD4C8C13E512D94C6E8B30F5447A1EE8")
    @DSModeled(DSC.SAFE)
    public int getBeginIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return beginIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "9236177A75F6147947B59829E100715E", hash_generated_method = "9C8138656D08AC48E476438D3A7848EC")
    @DSModeled(DSC.SAFE)
    public int getEndIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return endIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "FA0D18F7CDA71089ACF7D0CA54DB97A6", hash_generated_method = "0C368B5FC364BB7DE9F25217ADC13ACF")
    @DSModeled(DSC.SAFE)
    public int getField() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return myField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "7CAF144562B490BE3E2EB59461F9FF9F", hash_generated_method = "8B1E6CC15DF0BE6728D359B233F38783")
    @DSModeled(DSC.SAFE)
    public Format.Field getFieldAttribute() {
        return (Format.Field)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return myAttribute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "C545ABA0B6D3CBB4D119673C6F3DBEAC", hash_generated_method = "6B3FFE554419CD2A78056149138E4F42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int attributeHash;
        attributeHash = 0;
        attributeHash = myAttribute.hashCode();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int attributeHash = (myAttribute == null) ? 0 : myAttribute.hashCode();
        //return attributeHash + myField * 10 + beginIndex * 100 + endIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "B6704CE8D3A3B86DBE7C4466AFBF63DE", hash_generated_method = "3BC8C6131C7C8619786FD88989353EC9")
    @DSModeled(DSC.SAFE)
    public void setBeginIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //beginIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.105 -0400", hash_original_method = "D0945845F8EA8830C89E5D5682FA6C51", hash_generated_method = "CDEF5D13448C6B118F6643802BDE31C7")
    @DSModeled(DSC.SAFE)
    public void setEndIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //endIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.106 -0400", hash_original_method = "C87731FA15F0C601F30AE5E2B46DBDCA", hash_generated_method = "E92E926B3FC09E70F612C91ED753F167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varF4747AE3225DE36EA37AB251C37648AF_127238477 = (getClass().getName() + "[attribute=" + myAttribute + ", field="
                + myField + ", beginIndex=" + beginIndex + ", endIndex="
                + endIndex + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[attribute=" + myAttribute + ", field="
                //+ myField + ", beginIndex=" + beginIndex + ", endIndex="
                //+ endIndex + "]";
    }

    
}


