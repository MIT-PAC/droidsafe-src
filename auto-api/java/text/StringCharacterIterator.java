package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StringCharacterIterator implements CharacterIterator {
    String string;
    int start, end, offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.661 -0400", hash_original_method = "DAE1DA2C567D7E8FDA6EBD1FE5405924", hash_generated_method = "A3C0CA245594DFBF6F63EB024E734B79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringCharacterIterator(String value) {
        dsTaint.addTaint(value);
        start = offset = 0;
        end = string.length();
        // ---------- Original Method ----------
        //string = value;
        //start = offset = 0;
        //end = string.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.661 -0400", hash_original_method = "5C2CF51DC0D0A9D0DCD2C7E4ADB28E8E", hash_generated_method = "40BC72824042D348769DB29FE809ACC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringCharacterIterator(String value, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(value);
        start = 0;
        end = string.length();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //string = value;
        //start = 0;
        //end = string.length();
        //if (location < 0 || location > end) {
            //throw new IllegalArgumentException();
        //}
        //offset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.662 -0400", hash_original_method = "704865465DB7061F34F598DD3605E202", hash_generated_method = "B952666F629DFBEEA5FCA72ADB32B797")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringCharacterIterator(String value, int start, int end, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(start);
        dsTaint.addTaint(value);
        dsTaint.addTaint(end);
        {
            boolean var7E6A1450C2AD9DE97936A8CA5751A69D_1841828819 = (start < 0 || end > string.length() || start > end
                || location < start || location > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //string = value;
        //if (start < 0 || end > string.length() || start > end
                //|| location < start || location > end) {
            //throw new IllegalArgumentException();
        //}
        //this.start = start;
        //this.end = end;
        //offset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.662 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "3E4D7E27139CA336A88D7ABBDC102820")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_243220721 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.662 -0400", hash_original_method = "0495E4BE554B279F8C8552A3E8BBAE9B", hash_generated_method = "054803F7D6DC15193809558461CB106B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char current() {
        char var21B7B547718317726EE4A22CD454BA01_1706375933 = (string.charAt(offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (offset == end) {
            //return DONE;
        //}
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.662 -0400", hash_original_method = "4A7E92C9AA8B158215F27F7CAB59071D", hash_generated_method = "DE28BC4E23F7E269C4E9340AD67471BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        StringCharacterIterator it;
        it = (StringCharacterIterator) object;
        boolean var81DC82203AB0F08D0DDD7ACB6D612DC1_166772748 = (string.equals(it.string) && start == it.start && end == it.end
                && offset == it.offset);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(object instanceof StringCharacterIterator)) {
            //return false;
        //}
        //StringCharacterIterator it = (StringCharacterIterator) object;
        //return string.equals(it.string) && start == it.start && end == it.end
                //&& offset == it.offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.663 -0400", hash_original_method = "B333B42236D9FFA1243D291D9F8E02D4", hash_generated_method = "6AC34DE5205906BEA801C0DB3669252F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char first() {
        offset = start;
        char var21B7B547718317726EE4A22CD454BA01_1852198664 = (string.charAt(offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = start;
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.663 -0400", hash_original_method = "C91A51EED2BDD0863CA60178FB31B7F7", hash_generated_method = "28824102F9CE19F2FB681C1FE86293C0")
    @DSModeled(DSC.SAFE)
    public int getBeginIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return start;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.663 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "C3BE0AA826B854D04281BFCB8B3D97C2")
    @DSModeled(DSC.SAFE)
    public int getEndIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.663 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "FCEC00E0892F67B68765D5C23E99AF88")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.664 -0400", hash_original_method = "261EF3CD78C94C444435F1728CE93178", hash_generated_method = "D8868F8B34D9859881F1FF84CC632F1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varC302329FBC202906BCCCE10F9522C378_1600704242 = (string.hashCode() + start + end + offset);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return string.hashCode() + start + end + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.664 -0400", hash_original_method = "920E2CC099037AFE91302301CF7E9F3E", hash_generated_method = "3AA5023925BB7D9508F09EDDF1D2CCA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char last() {
        offset = end - 1;
        char var21B7B547718317726EE4A22CD454BA01_1639890954 = (string.charAt(offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = end - 1;
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.664 -0400", hash_original_method = "8F260F0099582263F775831BBCA28C0F", hash_generated_method = "67633705D109BAA3871633A2608E80AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char next() {
        {
            offset = end;
        } //End block
        char var238AEF82B15A80F78B72DEC013544975_442962191 = (string.charAt(++offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (offset >= (end - 1)) {
            //offset = end;
            //return DONE;
        //}
        //return string.charAt(++offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.664 -0400", hash_original_method = "6641F70E0E9C6153122A4B9C58397241", hash_generated_method = "49C0F12525BB287BEC306D1FA29331CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char previous() {
        char var420CAAE2ECFCDE70CA387D7F943D6777_843829253 = (string.charAt(--offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (offset == start) {
            //return DONE;
        //}
        //return string.charAt(--offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.664 -0400", hash_original_method = "EE5D609C4869D1C6E36BED6C6655B503", hash_generated_method = "A4CED88D5D17257C762213A894C141D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char setIndex(int location) {
        dsTaint.addTaint(location);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        char var21B7B547718317726EE4A22CD454BA01_1890908426 = (string.charAt(offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (location < start || location > end) {
            //throw new IllegalArgumentException();
        //}
        //offset = location;
        //if (offset == end) {
            //return DONE;
        //}
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.665 -0400", hash_original_method = "C3050CECF999A44D7D35577309274942", hash_generated_method = "FB8CCABDCE7DF0C01E4635210B570ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(String value) {
        dsTaint.addTaint(value);
        start = offset = 0;
        end = value.length();
        // ---------- Original Method ----------
        //string = value;
        //start = offset = 0;
        //end = value.length();
    }

    
}

