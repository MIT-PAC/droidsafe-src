package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class FieldPosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.604 -0400", hash_original_field = "4E5C9DDEA6C3DDCCF3C5EDA0B8239137", hash_generated_field = "23EE03EB10CD3D7DC8D790288DD8B044")

    private int myField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.604 -0400", hash_original_field = "28E05C3ABF05791ED24C5E5CAEA5AD15", hash_generated_field = "6F422E25A74B0B146E1ECC70B55EC74C")

    private int beginIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.604 -0400", hash_original_field = "6C7C6ECF23A364EB2EC70B77C92E7A4E", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

    private int endIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.604 -0400", hash_original_field = "D5ADA92999FCB0E4973F71AA3134065D", hash_generated_field = "8BA725474492CE8940933D456B128051")

    private Format.Field myAttribute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.604 -0400", hash_original_method = "E695F5151E58D69BC230540B458252AA", hash_generated_method = "3294FD3CC73A07FA36D86DFE9E3E23F0")
    public  FieldPosition(int field) {
        myField = field;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.604 -0400", hash_original_method = "67EE9DAFC04AACFB1E7BD135DD8AA2FB", hash_generated_method = "5772A6A110673D21B9080CEE635C49E6")
    public  FieldPosition(Format.Field attribute) {
        myAttribute = attribute;
        myField = -1;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.604 -0400", hash_original_method = "D49B7D40F2EA042BB514EAEBCB178B5A", hash_generated_method = "B1B47276D81FA30C5CB96EE46A2D48DD")
    public  FieldPosition(Format.Field attribute, int field) {
        myAttribute = attribute;
        myField = field;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.605 -0400", hash_original_method = "0917A34BEC387437E422442FF9D128A9", hash_generated_method = "7B55DCEF19A54303A6AEE5DCD2981156")
     void clear() {
        beginIndex = endIndex = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.605 -0400", hash_original_method = "2EFD5CC62AE2C3EDB89CEF52D471F874", hash_generated_method = "42E066A836E5384C025EFBD0B3F44204")
    @Override
    public boolean equals(Object object) {
        FieldPosition pos = (FieldPosition) object;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93874030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93874030;
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.605 -0400", hash_original_method = "D73EFD1B11663E2F20B33728384A7709", hash_generated_method = "D02726F48B30E1F456872C7ECED7C4D2")
    public int getBeginIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_576725718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_576725718;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.605 -0400", hash_original_method = "9236177A75F6147947B59829E100715E", hash_generated_method = "A9A4725B01209D5DB38EE2C1DF9976BA")
    public int getEndIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992407506 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992407506;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.605 -0400", hash_original_method = "FA0D18F7CDA71089ACF7D0CA54DB97A6", hash_generated_method = "A18CF35E0E0E1DCB7172E8FD60B06DA8")
    public int getField() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665010208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665010208;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.606 -0400", hash_original_method = "7CAF144562B490BE3E2EB59461F9FF9F", hash_generated_method = "62E15F604A97EE5E599A6E8CEE93B4C3")
    public Format.Field getFieldAttribute() {
        Format.Field varB4EAC82CA7396A68D541C85D26508E83_1190980436 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1190980436 = myAttribute;
        varB4EAC82CA7396A68D541C85D26508E83_1190980436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1190980436;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.606 -0400", hash_original_method = "C545ABA0B6D3CBB4D119673C6F3DBEAC", hash_generated_method = "E27BB4FB92CEE4600D0EF49B3D6BFA41")
    @Override
    public int hashCode() {
        int attributeHash;
        attributeHash = 0;
        attributeHash = myAttribute.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971607328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971607328;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.606 -0400", hash_original_method = "B6704CE8D3A3B86DBE7C4466AFBF63DE", hash_generated_method = "52375A7B9E133C46ADD8958312B215FD")
    public void setBeginIndex(int index) {
        beginIndex = index;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.607 -0400", hash_original_method = "D0945845F8EA8830C89E5D5682FA6C51", hash_generated_method = "D80F847F9AB2F854C130F487969DD63C")
    public void setEndIndex(int index) {
        endIndex = index;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.608 -0400", hash_original_method = "C87731FA15F0C601F30AE5E2B46DBDCA", hash_generated_method = "3FB4C64443DEBCAF3792B96B975CDBB4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1438949294 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1438949294 = getClass().getName() + "[attribute=" + myAttribute + ", field="
                + myField + ", beginIndex=" + beginIndex + ", endIndex="
                + endIndex + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1438949294.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1438949294;
        
        
                
                
    }

    
}

