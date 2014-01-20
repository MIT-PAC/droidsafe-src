package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class FieldPosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.507 -0400", hash_original_field = "4E5C9DDEA6C3DDCCF3C5EDA0B8239137", hash_generated_field = "23EE03EB10CD3D7DC8D790288DD8B044")

    private int myField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.507 -0400", hash_original_field = "28E05C3ABF05791ED24C5E5CAEA5AD15", hash_generated_field = "6F422E25A74B0B146E1ECC70B55EC74C")

    private int beginIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.507 -0400", hash_original_field = "6C7C6ECF23A364EB2EC70B77C92E7A4E", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

    private int endIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.945 -0500", hash_original_field = "E9A28BA7E1938925A10371FD5B4FC16C", hash_generated_field = "8BA725474492CE8940933D456B128051")

    private Format.Field myAttribute;

    /**
     * Constructs a new {@code FieldPosition} for the specified field.
     *
     * @param field
     *            the field to identify.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.948 -0500", hash_original_method = "E695F5151E58D69BC230540B458252AA", hash_generated_method = "6840825CBF924B6A390940786E90DDDB")
    
public FieldPosition(int field) {
        myField = field;
    }

    /**
     * Constructs a new {@code FieldPosition} for the specified {@code Field}
     * attribute.
     *
     * @param attribute
     *            the field attribute to identify.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.951 -0500", hash_original_method = "67EE9DAFC04AACFB1E7BD135DD8AA2FB", hash_generated_method = "9A050537255DA4F6F145AA7957D28BD8")
    
public FieldPosition(Format.Field attribute) {
        myAttribute = attribute;
        myField = -1;
    }

    /**
     * Constructs a new {@code FieldPosition} for the specified {@code Field}
     * attribute and field id.
     *
     * @param attribute
     *            the field attribute to identify.
     * @param field
     *            the field to identify.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.953 -0500", hash_original_method = "D49B7D40F2EA042BB514EAEBCB178B5A", hash_generated_method = "CB3FF0744A300DB297F27DD0F3036B3D")
    
public FieldPosition(Format.Field attribute, int field) {
        myAttribute = attribute;
        myField = field;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.956 -0500", hash_original_method = "0917A34BEC387437E422442FF9D128A9", hash_generated_method = "0917A34BEC387437E422442FF9D128A9")
    
void clear() {
        beginIndex = endIndex = 0;
    }

    /**
     * Compares the specified object to this field position and indicates if
     * they are equal. In order to be equal, {@code object} must be an instance
     * of {@code FieldPosition} with the same field, begin index and end index.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this field
     *         position; {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.959 -0500", hash_original_method = "2EFD5CC62AE2C3EDB89CEF52D471F874", hash_generated_method = "65E7AC1AD7D9F4BB8D4ED6C9A5B5D1A7")
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof FieldPosition)) {
            return false;
        }
        FieldPosition pos = (FieldPosition) object;
        return myField == pos.myField && myAttribute == pos.myAttribute
                && beginIndex == pos.beginIndex && endIndex == pos.endIndex;
    }

    /**
     * Returns the index of the beginning of the field.
     *
     * @return the first index of the field.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.961 -0500", hash_original_method = "D73EFD1B11663E2F20B33728384A7709", hash_generated_method = "2F90CE977F6454CCD742CC39E5800B3F")
    
public int getBeginIndex() {
        return beginIndex;
    }

    /**
     * Returns the index one past the end of the field.
     *
     * @return one past the index of the last character in the field.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.964 -0500", hash_original_method = "9236177A75F6147947B59829E100715E", hash_generated_method = "E2DB6089C9C1CB197EEB6F119595567F")
    
public int getEndIndex() {
        return endIndex;
    }

    /**
     * Returns the field which is being identified.
     *
     * @return the field constant.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.967 -0500", hash_original_method = "FA0D18F7CDA71089ACF7D0CA54DB97A6", hash_generated_method = "312D8615450594C16427A36E55E25569")
    
public int getField() {
        return myField;
    }

    /**
     * Returns the attribute which is being identified.
     *
     * @return the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.969 -0500", hash_original_method = "7CAF144562B490BE3E2EB59461F9FF9F", hash_generated_method = "4CE8A12939DD5C32FF3C6DFBD7D56773")
    
public Format.Field getFieldAttribute() {
        return myAttribute;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.972 -0500", hash_original_method = "C545ABA0B6D3CBB4D119673C6F3DBEAC", hash_generated_method = "B23008877C896A74DC57F148652920FA")
    
@Override
    public int hashCode() {
        int attributeHash = (myAttribute == null) ? 0 : myAttribute.hashCode();
        return attributeHash + myField * 10 + beginIndex * 100 + endIndex;
    }

    /**
     * Sets the index of the beginning of the field.
     *
     * @param index
     *            the index of the first character in the field.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.975 -0500", hash_original_method = "B6704CE8D3A3B86DBE7C4466AFBF63DE", hash_generated_method = "6AC0962FD64156C5BD7027682479A8E3")
    
public void setBeginIndex(int index) {
        beginIndex = index;
    }

    /**
     * Sets the index of the end of the field.
     *
     * @param index
     *            one past the index of the last character in the field.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.977 -0500", hash_original_method = "D0945845F8EA8830C89E5D5682FA6C51", hash_generated_method = "23964A13F3E495C466DA582765852E9B")
    
public void setEndIndex(int index) {
        endIndex = index;
    }

    /**
     * Returns the string representation of this field position.
     *
     * @return the string representation of this field position.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.980 -0500", hash_original_method = "C87731FA15F0C601F30AE5E2B46DBDCA", hash_generated_method = "BF88C3E53333B37FCC8C650181AD6C8B")
    
@Override
    public String toString() {
        return getClass().getName() + "[attribute=" + myAttribute + ", field="
                + myField + ", beginIndex=" + beginIndex + ", endIndex="
                + endIndex + "]";
    }
    
}

