package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FieldPosition {
    private int myField, beginIndex, endIndex;
    private Format.Field myAttribute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.288 -0400", hash_original_method = "E695F5151E58D69BC230540B458252AA", hash_generated_method = "414C370ED5F861D62603796A9C3740AF")
    @DSModeled(DSC.SAFE)
    public FieldPosition(int field) {
        dsTaint.addTaint(field);
        // ---------- Original Method ----------
        //myField = field;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.288 -0400", hash_original_method = "67EE9DAFC04AACFB1E7BD135DD8AA2FB", hash_generated_method = "2598780227B97AABB19CBDA7B088BFED")
    @DSModeled(DSC.SAFE)
    public FieldPosition(Format.Field attribute) {
        dsTaint.addTaint(attribute.dsTaint);
        myField = -1;
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.289 -0400", hash_original_method = "D49B7D40F2EA042BB514EAEBCB178B5A", hash_generated_method = "F8E12D54432FD82D4629A39D5B767BB3")
    @DSModeled(DSC.SAFE)
    public FieldPosition(Format.Field attribute, int field) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(attribute.dsTaint);
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = field;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.289 -0400", hash_original_method = "0917A34BEC387437E422442FF9D128A9", hash_generated_method = "7B55DCEF19A54303A6AEE5DCD2981156")
    @DSModeled(DSC.SAFE)
     void clear() {
        beginIndex = endIndex = 0;
        // ---------- Original Method ----------
        //beginIndex = endIndex = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.289 -0400", hash_original_method = "2EFD5CC62AE2C3EDB89CEF52D471F874", hash_generated_method = "4CD75467E461BB1ABC60C0F68E8D03BB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.289 -0400", hash_original_method = "D73EFD1B11663E2F20B33728384A7709", hash_generated_method = "0D59CBB564C3AA7249E6A2E0DC303D16")
    @DSModeled(DSC.SAFE)
    public int getBeginIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return beginIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.289 -0400", hash_original_method = "9236177A75F6147947B59829E100715E", hash_generated_method = "2B0F1AD88EFD4BD74044E3E154370D10")
    @DSModeled(DSC.SAFE)
    public int getEndIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return endIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.290 -0400", hash_original_method = "FA0D18F7CDA71089ACF7D0CA54DB97A6", hash_generated_method = "163A8FD6A81073C866C27F04E273E43D")
    @DSModeled(DSC.SAFE)
    public int getField() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return myField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.290 -0400", hash_original_method = "7CAF144562B490BE3E2EB59461F9FF9F", hash_generated_method = "FEFE009C93FAD788BF46D415D4D721D6")
    @DSModeled(DSC.SAFE)
    public Format.Field getFieldAttribute() {
        return (Format.Field)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return myAttribute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.290 -0400", hash_original_method = "C545ABA0B6D3CBB4D119673C6F3DBEAC", hash_generated_method = "AF710574461241432D1CDEC1BD297296")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.290 -0400", hash_original_method = "B6704CE8D3A3B86DBE7C4466AFBF63DE", hash_generated_method = "B02629589226D51D0D8FC0BB062FC1E6")
    @DSModeled(DSC.SAFE)
    public void setBeginIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //beginIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.290 -0400", hash_original_method = "D0945845F8EA8830C89E5D5682FA6C51", hash_generated_method = "10DB7B99F9D00ECEA50497492D3CF093")
    @DSModeled(DSC.SAFE)
    public void setEndIndex(int index) {
        dsTaint.addTaint(index);
        // ---------- Original Method ----------
        //endIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.291 -0400", hash_original_method = "C87731FA15F0C601F30AE5E2B46DBDCA", hash_generated_method = "49628A085D29BCCD01CD50925C6DCF9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varF4747AE3225DE36EA37AB251C37648AF_728899775 = (getClass().getName() + "[attribute=" + myAttribute + ", field="
                + myField + ", beginIndex=" + beginIndex + ", endIndex="
                + endIndex + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[attribute=" + myAttribute + ", field="
                //+ myField + ", beginIndex=" + beginIndex + ", endIndex="
                //+ endIndex + "]";
    }

    
}

