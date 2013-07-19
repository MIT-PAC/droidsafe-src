package java.text;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class FieldPosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.507 -0400", hash_original_field = "4E5C9DDEA6C3DDCCF3C5EDA0B8239137", hash_generated_field = "23EE03EB10CD3D7DC8D790288DD8B044")

    private int myField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.507 -0400", hash_original_field = "28E05C3ABF05791ED24C5E5CAEA5AD15", hash_generated_field = "6F422E25A74B0B146E1ECC70B55EC74C")

    private int beginIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.507 -0400", hash_original_field = "6C7C6ECF23A364EB2EC70B77C92E7A4E", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

    private int endIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.507 -0400", hash_original_field = "D5ADA92999FCB0E4973F71AA3134065D", hash_generated_field = "8BA725474492CE8940933D456B128051")

    private Format.Field myAttribute;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.508 -0400", hash_original_method = "E695F5151E58D69BC230540B458252AA", hash_generated_method = "3294FD3CC73A07FA36D86DFE9E3E23F0")
    public  FieldPosition(int field) {
        myField = field;
        // ---------- Original Method ----------
        //myField = field;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.508 -0400", hash_original_method = "67EE9DAFC04AACFB1E7BD135DD8AA2FB", hash_generated_method = "5772A6A110673D21B9080CEE635C49E6")
    public  FieldPosition(Format.Field attribute) {
        myAttribute = attribute;
        myField = -1;
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.508 -0400", hash_original_method = "D49B7D40F2EA042BB514EAEBCB178B5A", hash_generated_method = "B1B47276D81FA30C5CB96EE46A2D48DD")
    public  FieldPosition(Format.Field attribute, int field) {
        myAttribute = attribute;
        myField = field;
        // ---------- Original Method ----------
        //myAttribute = attribute;
        //myField = field;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.508 -0400", hash_original_method = "0917A34BEC387437E422442FF9D128A9", hash_generated_method = "7B55DCEF19A54303A6AEE5DCD2981156")
     void clear() {
        beginIndex = endIndex = 0;
        // ---------- Original Method ----------
        //beginIndex = endIndex = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.509 -0400", hash_original_method = "2EFD5CC62AE2C3EDB89CEF52D471F874", hash_generated_method = "36551F1B6F047115EA16BFAC26E9C92D")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(!(object instanceof FieldPosition))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1653724825 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984812563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984812563;
        } //End block
        FieldPosition pos = (FieldPosition) object;
        boolean varB329B14BF376013966B7864B31331406_1057077692 = (myField == pos.myField && myAttribute == pos.myAttribute
                && beginIndex == pos.beginIndex && endIndex == pos.endIndex);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823853235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823853235;
        // ---------- Original Method ----------
        //if (!(object instanceof FieldPosition)) {
            //return false;
        //}
        //FieldPosition pos = (FieldPosition) object;
        //return myField == pos.myField && myAttribute == pos.myAttribute
                //&& beginIndex == pos.beginIndex && endIndex == pos.endIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.509 -0400", hash_original_method = "D73EFD1B11663E2F20B33728384A7709", hash_generated_method = "7A96E09FB9E45F51A1C716FEF49CBF97")
    public int getBeginIndex() {
        int var28E05C3ABF05791ED24C5E5CAEA5AD15_330945411 = (beginIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819431711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819431711;
        // ---------- Original Method ----------
        //return beginIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.509 -0400", hash_original_method = "9236177A75F6147947B59829E100715E", hash_generated_method = "C7050008C43BE996FA713312558C5B36")
    public int getEndIndex() {
        int var6C7C6ECF23A364EB2EC70B77C92E7A4E_1627454072 = (endIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890535647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890535647;
        // ---------- Original Method ----------
        //return endIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.509 -0400", hash_original_method = "FA0D18F7CDA71089ACF7D0CA54DB97A6", hash_generated_method = "5590F8DDBDB7946060C4755417BAE387")
    public int getField() {
        int var4E5C9DDEA6C3DDCCF3C5EDA0B8239137_1429269249 = (myField);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573233621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573233621;
        // ---------- Original Method ----------
        //return myField;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.509 -0400", hash_original_method = "7CAF144562B490BE3E2EB59461F9FF9F", hash_generated_method = "59B72EF2824928225B69F9FE47C03473")
    public Format.Field getFieldAttribute() {
Format.Field varC989273768E79F118062181F4D7B1A1F_1059547884 =         myAttribute;
        varC989273768E79F118062181F4D7B1A1F_1059547884.addTaint(taint);
        return varC989273768E79F118062181F4D7B1A1F_1059547884;
        // ---------- Original Method ----------
        //return myAttribute;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.510 -0400", hash_original_method = "C545ABA0B6D3CBB4D119673C6F3DBEAC", hash_generated_method = "7D5DB980A64784607072F504BA694C5E")
    @Override
    public int hashCode() {
        int attributeHash = (myAttribute == null) ? 0 : myAttribute.hashCode();
        int var1E2C656F547B32050EFD4D5BDD319E7D_1636164171 = (attributeHash + myField * 10 + beginIndex * 100 + endIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792026670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792026670;
        // ---------- Original Method ----------
        //int attributeHash = (myAttribute == null) ? 0 : myAttribute.hashCode();
        //return attributeHash + myField * 10 + beginIndex * 100 + endIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.510 -0400", hash_original_method = "B6704CE8D3A3B86DBE7C4466AFBF63DE", hash_generated_method = "52375A7B9E133C46ADD8958312B215FD")
    public void setBeginIndex(int index) {
        beginIndex = index;
        // ---------- Original Method ----------
        //beginIndex = index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.510 -0400", hash_original_method = "D0945845F8EA8830C89E5D5682FA6C51", hash_generated_method = "D80F847F9AB2F854C130F487969DD63C")
    public void setEndIndex(int index) {
        endIndex = index;
        // ---------- Original Method ----------
        //endIndex = index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.511 -0400", hash_original_method = "C87731FA15F0C601F30AE5E2B46DBDCA", hash_generated_method = "1684AFDE2741ABC2A8CF11147919B727")
    @Override
    public String toString() {
String varC4DFBFDD2DEE990D7C4D51C7B64C7D88_2034828954 =         getClass().getName() + "[attribute=" + myAttribute + ", field="
                + myField + ", beginIndex=" + beginIndex + ", endIndex="
                + endIndex + "]";
        varC4DFBFDD2DEE990D7C4D51C7B64C7D88_2034828954.addTaint(taint);
        return varC4DFBFDD2DEE990D7C4D51C7B64C7D88_2034828954;
        // ---------- Original Method ----------
        //return getClass().getName() + "[attribute=" + myAttribute + ", field="
                //+ myField + ", beginIndex=" + beginIndex + ", endIndex="
                //+ endIndex + "]";
    }

    
}

