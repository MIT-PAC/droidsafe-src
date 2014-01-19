package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.icu.NativeBreakIterator;

class RuleBasedBreakIterator extends BreakIterator {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.384 -0500", hash_original_method = "1D7663481F9CF836249C543E9EA9D4B8", hash_generated_method = "1D7663481F9CF836249C543E9EA9D4B8")
    
RuleBasedBreakIterator(NativeBreakIterator iterator) {
        super(iterator);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.386 -0500", hash_original_method = "297748753389E9E3E039DEEA5BA99884", hash_generated_method = "895947AFB07B7A1F3EBE247D7C84EE33")
    
@Override public int current() {
        return wrapped.current();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.389 -0500", hash_original_method = "28B1915E0F3A1A21D89118527E0B2336", hash_generated_method = "9ED09CF89932E15C2FBC4E2F7028A0C1")
    
@Override public int first() {
        return wrapped.first();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.391 -0500", hash_original_method = "F8C933789C0B1B391D1242A497D0FB61", hash_generated_method = "437D917F9203FEB4619A7B4ECE26EA6C")
    
@Override public int following(int offset) {
        validateOffset(offset);
        return wrapped.following(offset);
    }

    /*
     * check the offset, throw exception if it is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.394 -0500", hash_original_method = "49EE36B5C8835D510AEEA1B2E4051F58", hash_generated_method = "FCFF8187C01FD0135EEFA96FEDEF2E0F")
    
private void validateOffset(int offset) {
        CharacterIterator it = wrapped.getText();
        if (offset < it.getBeginIndex() || offset > it.getEndIndex()) {
            String message = "Valid range is [" + it.getBeginIndex() + " " + it.getEndIndex() + "]";
            throw new IllegalArgumentException(message);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.397 -0500", hash_original_method = "0709975D2E361F60AA4A842C629D2B9B", hash_generated_method = "AB6E4341DBCE2FE5ABA23D7BC63F2263")
    
@Override public CharacterIterator getText() {
        return wrapped.getText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.400 -0500", hash_original_method = "A974AD33040EAFAD57444C0F88520784", hash_generated_method = "7FFA21285433509FE20AB84D0C369CD0")
    
@Override public int last() {
        return wrapped.last();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.403 -0500", hash_original_method = "FB9F2F9B43CCA9FD1C53DF1222484F9A", hash_generated_method = "1A54D3B001AD8AE4C92E621123DABA61")
    
@Override public int next() {
        return wrapped.next();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.405 -0500", hash_original_method = "60DA8E0BA6782B5D414226D40CCAEA03", hash_generated_method = "BEE4A104AC16FD9A7720DFE842E64F5C")
    
@Override public int next(int n) {
        return wrapped.next(n);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.408 -0500", hash_original_method = "5367A90D16F732A542804E8845F40BEA", hash_generated_method = "CFF8AE0070657DE52A74A2E9FF23E468")
    
@Override public int previous() {
        return wrapped.previous();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.410 -0500", hash_original_method = "E75CFE1E66B7B743956F14CBE08A2F07", hash_generated_method = "D4C972EA16D357AF2BCE675368B46C21")
    
@Override public void setText(CharacterIterator newText) {
        // call a method to check if null pointer
        newText.current();
        wrapped.setText(newText);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.413 -0500", hash_original_method = "EB484024A2CABB19E3D3208A3B638094", hash_generated_method = "B67B7A60940ACAF50458E3A2574F9AA7")
    
@Override public boolean isBoundary(int offset) {
        validateOffset(offset);
        return wrapped.isBoundary(offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.415 -0500", hash_original_method = "2B3191872A351BFE28946C264BFDE54F", hash_generated_method = "7870DAA170A62B3B595FCA6B9600633B")
    
@Override public int preceding(int offset) {
        validateOffset(offset);
        return wrapped.preceding(offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.418 -0500", hash_original_method = "1C0A7071B8D0A3C31C41CE6D2D9C1AD9", hash_generated_method = "3A0A252B640346A818536EC9CDEC1E0C")
    
@Override public boolean equals(Object o) {
        if (!(o instanceof RuleBasedBreakIterator)) {
            return false;
        }
        return wrapped.equals(((RuleBasedBreakIterator) o).wrapped);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.421 -0500", hash_original_method = "06F92F6D5094F2398873E74C963FD03D", hash_generated_method = "335E1F915D1C60B1566AC8FE334BBCC5")
    
@Override public String toString() {
        return wrapped.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.423 -0500", hash_original_method = "E6CC31FF7D266DCE2DDA4A7B187D9033", hash_generated_method = "570F0C93134E62B7F7275DF32C549250")
    
@Override public int hashCode() {
        return wrapped.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:02.426 -0500", hash_original_method = "CB8345057924EAB3D86F5E280E0AFDC7", hash_generated_method = "D0515A3F5F1D631F9CA0EBA93066D9BF")
    
@Override public Object clone() {
        RuleBasedBreakIterator cloned = (RuleBasedBreakIterator) super.clone();
        cloned.wrapped = (NativeBreakIterator) wrapped.clone();
        return cloned;
    }
    
}

