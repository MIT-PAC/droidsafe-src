package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class StringCharacterIterator implements CharacterIterator {
    String string;
    int start, end, offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "DAE1DA2C567D7E8FDA6EBD1FE5405924", hash_generated_method = "2258F58E0510D2B5D007A7E2C31638AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "5C2CF51DC0D0A9D0DCD2C7E4ADB28E8E", hash_generated_method = "854707F572E1178B6176B5A4A2B0BF1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringCharacterIterator(String value, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(value);
        start = 0;
        end = string.length();
        {
            throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "704865465DB7061F34F598DD3605E202", hash_generated_method = "79BE95B25304F5DBD61A519EBD5C4A8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringCharacterIterator(String value, int start, int end, int location) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(location);
        dsTaint.addTaint(value);
        dsTaint.addTaint(end);
        {
            boolean var7E6A1450C2AD9DE97936A8CA5751A69D_1552266984 = (start < 0 || end > string.length() || start > end
                || location < start || location > end);
            {
                throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "72B172FDBEAF2F1721F72FD6E06FBB81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_824357659 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "0495E4BE554B279F8C8552A3E8BBAE9B", hash_generated_method = "CACEFAA0A5FA231E008ED17E377FBB8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char current() {
        char var21B7B547718317726EE4A22CD454BA01_1468860269 = (string.charAt(offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (offset == end) {
            //return DONE;
        //}
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "4A7E92C9AA8B158215F27F7CAB59071D", hash_generated_method = "FA0B877F2701959EC494E544E7C080B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        StringCharacterIterator it;
        it = (StringCharacterIterator) object;
        boolean var81DC82203AB0F08D0DDD7ACB6D612DC1_1317587412 = (string.equals(it.string) && start == it.start && end == it.end
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "B333B42236D9FFA1243D291D9F8E02D4", hash_generated_method = "95BE9B6874CCE7BE93F9DFB8694CAB7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char first() {
        offset = start;
        char var21B7B547718317726EE4A22CD454BA01_1688881413 = (string.charAt(offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = start;
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "C91A51EED2BDD0863CA60178FB31B7F7", hash_generated_method = "4B165C894BFFEEE9802EB290337DE968")
    @DSModeled(DSC.SAFE)
    public int getBeginIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return start;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "3C27A85C1F70E764283E3AE3637F8072")
    @DSModeled(DSC.SAFE)
    public int getEndIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "1F3C5CF325FB8ED42E9146662B125A6E")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "261EF3CD78C94C444435F1728CE93178", hash_generated_method = "C705B2D57059AA73345D3BA36DA391A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varC302329FBC202906BCCCE10F9522C378_1684172572 = (string.hashCode() + start + end + offset);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return string.hashCode() + start + end + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "920E2CC099037AFE91302301CF7E9F3E", hash_generated_method = "0A83013988DB5B01AC02818C67954DA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char last() {
        offset = end - 1;
        char var21B7B547718317726EE4A22CD454BA01_639638250 = (string.charAt(offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = end - 1;
        //return string.charAt(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.233 -0400", hash_original_method = "8F260F0099582263F775831BBCA28C0F", hash_generated_method = "C96B7B35FA866DB73F458508C465CFB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char next() {
        {
            offset = end;
        } //End block
        char var238AEF82B15A80F78B72DEC013544975_41452621 = (string.charAt(++offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (offset >= (end - 1)) {
            //offset = end;
            //return DONE;
        //}
        //return string.charAt(++offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.234 -0400", hash_original_method = "6641F70E0E9C6153122A4B9C58397241", hash_generated_method = "47D2BCF0AE11C63AB1A0BB77D42D4B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char previous() {
        char var420CAAE2ECFCDE70CA387D7F943D6777_26242580 = (string.charAt(--offset));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (offset == start) {
            //return DONE;
        //}
        //return string.charAt(--offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.234 -0400", hash_original_method = "EE5D609C4869D1C6E36BED6C6655B503", hash_generated_method = "3A0C86C5B21B0B2D22590D2EC869B6DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char setIndex(int location) {
        dsTaint.addTaint(location);
        {
            throw new IllegalArgumentException();
        } //End block
        char var21B7B547718317726EE4A22CD454BA01_1757406657 = (string.charAt(offset));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.234 -0400", hash_original_method = "C3050CECF999A44D7D35577309274942", hash_generated_method = "5BFC1F4A31F2F36D577598079C481A52")
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


