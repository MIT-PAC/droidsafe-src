package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ParsePosition {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.878 -0400", hash_original_field = "F92DCDD86E6BEEEA3E199F5D44A97241", hash_generated_field = "8A55CE2AEC9EB9B4FFBC5BD7C0750E33")

    private int currentPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.878 -0400", hash_original_field = "02A1F59FCDD6F1515C17B6F84ABA0756", hash_generated_field = "4249A53A741FB202C50A53B01C7CB1E3")

    private int errorIndex = -1;

    /**
     * Constructs a new {@code ParsePosition} with the specified index.
     *
     * @param index
     *            the index to begin parsing.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.826 -0500", hash_original_method = "DC50BCA5F95CF2B530ABA250C6125033", hash_generated_method = "D2C67F25DF78C8DD8CC7C58EB94A8913")
    
public ParsePosition(int index) {
        currentPosition = index;
    }

    /**
     * Compares the specified object to this {@code ParsePosition} and indicates
     * if they are equal. In order to be equal, {@code object} must be an
     * instance of {@code ParsePosition} and it must have the same index and
     * error index.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this
     *         {@code ParsePosition}; {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.829 -0500", hash_original_method = "7A2CC483DDAB3EA409EA20ED7AF6932E", hash_generated_method = "CAB7203C3A085DE7F4B65C2136C19B16")
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof ParsePosition)) {
            return false;
        }
        ParsePosition pos = (ParsePosition) object;
        return currentPosition == pos.currentPosition
                && errorIndex == pos.errorIndex;
    }

    /**
     * Returns the index at which the parse could not continue.
     *
     * @return the index of the parse error or -1 if there is no error.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.831 -0500", hash_original_method = "251F29749A0D498AD09891D5409959A9", hash_generated_method = "8513B758071D7BF28FC97A139C41AD8C")
    
public int getErrorIndex() {
        return errorIndex;
    }

    /**
     * Returns the current parse position.
     *
     * @return the current position.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.834 -0500", hash_original_method = "1CFE76DD95166F56A240763AD86BFFF6", hash_generated_method = "65114281D83995728CC54A5781A616A4")
    
public int getIndex() {
        return currentPosition;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.836 -0500", hash_original_method = "78BEA0F92DBA8060A51AB3A3D8273064", hash_generated_method = "34759ADCBA6D0B2C6986E711CEEDEC4B")
    
@Override
    public int hashCode() {
        return currentPosition + errorIndex;
    }

    /**
     * Sets the index at which the parse could not continue.
     *
     * @param index
     *            the index of the parse error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.839 -0500", hash_original_method = "F3EA9276CC48A5113CA1E4D2C48DC7D4", hash_generated_method = "DA015261131ACB466C6FBA56A13F6CF9")
    
public void setErrorIndex(int index) {
        errorIndex = index;
    }

    /**
     * Sets the current parse position.
     *
     * @param index
     *            the current parse position.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.841 -0500", hash_original_method = "1C6C7B20133CCF9092C9B321C0CF7A81", hash_generated_method = "2460B67C707C219B342228AEF66DA5EF")
    
public void setIndex(int index) {
        currentPosition = index;
    }

    /**
     * Returns the string representation of this parse position.
     *
     * @return the string representation of this parse position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.844 -0500", hash_original_method = "EA803D38773CA0193E1AA7C91AAA6A50", hash_generated_method = "AEB38833E430D517AABC28F6D901BEA1")
    
@Override
    public String toString() {
        return getClass().getName() + "[index=" + currentPosition
                + ", errorIndex=" + errorIndex + "]";
    }
    
}

