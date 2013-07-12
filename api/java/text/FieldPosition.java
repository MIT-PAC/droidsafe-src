package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class FieldPosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.666 -0400", hash_original_field = "4E5C9DDEA6C3DDCCF3C5EDA0B8239137", hash_generated_field = "23EE03EB10CD3D7DC8D790288DD8B044")

    private int myField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.666 -0400", hash_original_field = "28E05C3ABF05791ED24C5E5CAEA5AD15", hash_generated_field = "6F422E25A74B0B146E1ECC70B55EC74C")

    private int beginIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.666 -0400", hash_original_field = "6C7C6ECF23A364EB2EC70B77C92E7A4E", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

    private int endIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.666 -0400", hash_original_field = "D5ADA92999FCB0E4973F71AA3134065D", hash_generated_field = "8BA725474492CE8940933D456B128051")

    private Format.Field myAttribute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.667 -0400", hash_original_method = "E695F5151E58D69BC230540B458252AA", hash_generated_method = "3294FD3CC73A07FA36D86DFE9E3E23F0")
    public  FieldPosition(int field) {
        myField = field;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.667 -0400", hash_original_method = "67EE9DAFC04AACFB1E7BD135DD8AA2FB", hash_generated_method = "5772A6A110673D21B9080CEE635C49E6")
    public  FieldPosition(Format.Field attribute) {
        myAttribute = attribute;
        myField = -1;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.668 -0400", hash_original_method = "D49B7D40F2EA042BB514EAEBCB178B5A", hash_generated_method = "B1B47276D81FA30C5CB96EE46A2D48DD")
    public  FieldPosition(Format.Field attribute, int field) {
        myAttribute = attribute;
        myField = field;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.668 -0400", hash_original_method = "0917A34BEC387437E422442FF9D128A9", hash_generated_method = "7B55DCEF19A54303A6AEE5DCD2981156")
     void clear() {
        beginIndex = endIndex = 0;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.669 -0400", hash_original_method = "2EFD5CC62AE2C3EDB89CEF52D471F874", hash_generated_method = "023955D49B68A9A5CCA4695F44CEF6E0")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(!(object instanceof FieldPosition))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1582909880 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1760989852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1760989852;
        } 
        FieldPosition pos = (FieldPosition) object;
        boolean varB329B14BF376013966B7864B31331406_531981610 = (myField == pos.myField && myAttribute == pos.myAttribute
                && beginIndex == pos.beginIndex && endIndex == pos.endIndex);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152638540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152638540;
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.669 -0400", hash_original_method = "D73EFD1B11663E2F20B33728384A7709", hash_generated_method = "9D3E60F73172CA51429ECDCEE1D7E8D1")
    public int getBeginIndex() {
        int var28E05C3ABF05791ED24C5E5CAEA5AD15_617440699 = (beginIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572189769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572189769;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.669 -0400", hash_original_method = "9236177A75F6147947B59829E100715E", hash_generated_method = "5E406C0D3833B15120FEF8FF54F7BFFE")
    public int getEndIndex() {
        int var6C7C6ECF23A364EB2EC70B77C92E7A4E_23560864 = (endIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965234497 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_965234497;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.670 -0400", hash_original_method = "FA0D18F7CDA71089ACF7D0CA54DB97A6", hash_generated_method = "9F172738FDF476CB78D63089482621BF")
    public int getField() {
        int var4E5C9DDEA6C3DDCCF3C5EDA0B8239137_348605577 = (myField);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088273767 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088273767;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.670 -0400", hash_original_method = "7CAF144562B490BE3E2EB59461F9FF9F", hash_generated_method = "70C4D5E38382193527D4C2455BC1EDDD")
    public Format.Field getFieldAttribute() {
Format.Field varC989273768E79F118062181F4D7B1A1F_1629524481 =         myAttribute;
        varC989273768E79F118062181F4D7B1A1F_1629524481.addTaint(taint);
        return varC989273768E79F118062181F4D7B1A1F_1629524481;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.670 -0400", hash_original_method = "C545ABA0B6D3CBB4D119673C6F3DBEAC", hash_generated_method = "07A4340B3F2F11C04F15A849DBB707D1")
    @Override
    public int hashCode() {
        int attributeHash = (myAttribute == null) ? 0 : myAttribute.hashCode();
        int var1E2C656F547B32050EFD4D5BDD319E7D_562608963 = (attributeHash + myField * 10 + beginIndex * 100 + endIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946237434 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1946237434;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.671 -0400", hash_original_method = "B6704CE8D3A3B86DBE7C4466AFBF63DE", hash_generated_method = "52375A7B9E133C46ADD8958312B215FD")
    public void setBeginIndex(int index) {
        beginIndex = index;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.671 -0400", hash_original_method = "D0945845F8EA8830C89E5D5682FA6C51", hash_generated_method = "D80F847F9AB2F854C130F487969DD63C")
    public void setEndIndex(int index) {
        endIndex = index;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.672 -0400", hash_original_method = "C87731FA15F0C601F30AE5E2B46DBDCA", hash_generated_method = "A0FF9641042A8ED2FF6E586511337115")
    @Override
    public String toString() {
String varC4DFBFDD2DEE990D7C4D51C7B64C7D88_1487916117 =         getClass().getName() + "[attribute=" + myAttribute + ", field="
                + myField + ", beginIndex=" + beginIndex + ", endIndex="
                + endIndex + "]";
        varC4DFBFDD2DEE990D7C4D51C7B64C7D88_1487916117.addTaint(taint);
        return varC4DFBFDD2DEE990D7C4D51C7B64C7D88_1487916117;
        
        
                
                
    }

    
}

