package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FieldPosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.966 -0400", hash_original_field = "4E5C9DDEA6C3DDCCF3C5EDA0B8239137", hash_generated_field = "23EE03EB10CD3D7DC8D790288DD8B044")

    private int myField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.966 -0400", hash_original_field = "28E05C3ABF05791ED24C5E5CAEA5AD15", hash_generated_field = "6F422E25A74B0B146E1ECC70B55EC74C")

    private int beginIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.966 -0400", hash_original_field = "6C7C6ECF23A364EB2EC70B77C92E7A4E", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

    private int endIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.966 -0400", hash_original_field = "D5ADA92999FCB0E4973F71AA3134065D", hash_generated_field = "8BA725474492CE8940933D456B128051")

    private Format.Field myAttribute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.969 -0400", hash_original_method = "E695F5151E58D69BC230540B458252AA", hash_generated_method = "3294FD3CC73A07FA36D86DFE9E3E23F0")
    public  FieldPosition(int field) {
        myField = field;
        // ---------- Original Method ----------
        //myField = field;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.970 -0400", hash_original_method = "67EE9DAFC04AACFB1E7BD135DD8AA2FB", hash_generated_method = "5772A6A110673D21B9080CEE635C49E6")
    public  FieldPosition(Format.Field attribute) {
        myAttribute = attribute;
        myField = -1;
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.970 -0400", hash_original_method = "D49B7D40F2EA042BB514EAEBCB178B5A", hash_generated_method = "B1B47276D81FA30C5CB96EE46A2D48DD")
    public  FieldPosition(Format.Field attribute, int field) {
        myAttribute = attribute;
        myField = field;
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = field;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.970 -0400", hash_original_method = "0917A34BEC387437E422442FF9D128A9", hash_generated_method = "7B55DCEF19A54303A6AEE5DCD2981156")
     void clear() {
        beginIndex = endIndex = 0;
        // ---------- Original Method ----------
        //beginIndex = endIndex = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.971 -0400", hash_original_method = "2EFD5CC62AE2C3EDB89CEF52D471F874", hash_generated_method = "0ED7C53143BF899A7D183A58F65287A0")
    @Override
    public boolean equals(Object object) {
        FieldPosition pos;
        pos = (FieldPosition) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_798385164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_798385164;
        // ---------- Original Method ----------
        //if (!(object instanceof FieldPosition)) {
            //return false;
        //}
        //FieldPosition pos = (FieldPosition) object;
        //return myField == pos.myField && myAttribute == pos.myAttribute
                //&& beginIndex == pos.beginIndex && endIndex == pos.endIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.971 -0400", hash_original_method = "D73EFD1B11663E2F20B33728384A7709", hash_generated_method = "D65B38D2A4AF6DC71BE4E3A48C09C1DF")
    public int getBeginIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238338847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238338847;
        // ---------- Original Method ----------
        //return beginIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.971 -0400", hash_original_method = "9236177A75F6147947B59829E100715E", hash_generated_method = "E972277C4B2CA9242952644528573C1A")
    public int getEndIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838298903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1838298903;
        // ---------- Original Method ----------
        //return endIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.971 -0400", hash_original_method = "FA0D18F7CDA71089ACF7D0CA54DB97A6", hash_generated_method = "F9E6AF359E844F1948A86562DE2249D0")
    public int getField() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593923024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593923024;
        // ---------- Original Method ----------
        //return myField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.972 -0400", hash_original_method = "7CAF144562B490BE3E2EB59461F9FF9F", hash_generated_method = "04C02DDB10329AFDD15C016C6D74B413")
    public Format.Field getFieldAttribute() {
        Format.Field varB4EAC82CA7396A68D541C85D26508E83_348318499 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_348318499 = myAttribute;
        varB4EAC82CA7396A68D541C85D26508E83_348318499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_348318499;
        // ---------- Original Method ----------
        //return myAttribute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.972 -0400", hash_original_method = "C545ABA0B6D3CBB4D119673C6F3DBEAC", hash_generated_method = "8849BC7F4DE746271CFE3B445D290BA5")
    @Override
    public int hashCode() {
        int attributeHash;
        attributeHash = 0;
        attributeHash = myAttribute.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639137584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639137584;
        // ---------- Original Method ----------
        //int attributeHash = (myAttribute == null) ? 0 : myAttribute.hashCode();
        //return attributeHash + myField * 10 + beginIndex * 100 + endIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.979 -0400", hash_original_method = "B6704CE8D3A3B86DBE7C4466AFBF63DE", hash_generated_method = "52375A7B9E133C46ADD8958312B215FD")
    public void setBeginIndex(int index) {
        beginIndex = index;
        // ---------- Original Method ----------
        //beginIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.979 -0400", hash_original_method = "D0945845F8EA8830C89E5D5682FA6C51", hash_generated_method = "D80F847F9AB2F854C130F487969DD63C")
    public void setEndIndex(int index) {
        endIndex = index;
        // ---------- Original Method ----------
        //endIndex = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.000 -0400", hash_original_method = "C87731FA15F0C601F30AE5E2B46DBDCA", hash_generated_method = "83CCFEF621B05B4A61E436834E93F857")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_148438280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_148438280 = getClass().getName() + "[attribute=" + myAttribute + ", field="
                + myField + ", beginIndex=" + beginIndex + ", endIndex="
                + endIndex + "]";
        varB4EAC82CA7396A68D541C85D26508E83_148438280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_148438280;
        // ---------- Original Method ----------
        //return getClass().getName() + "[attribute=" + myAttribute + ", field="
                //+ myField + ", beginIndex=" + beginIndex + ", endIndex="
                //+ endIndex + "]";
    }

    
}

