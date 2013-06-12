package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

public final class NativeBreakIterator implements Cloneable {
    private static final int BI_CHAR_INSTANCE = 1;
    private static final int BI_WORD_INSTANCE = 2;
    private static final int BI_LINE_INSTANCE = 3;
    private static final int BI_SENT_INSTANCE = 4;
    private final int address;
    private final int type;
    private CharacterIterator charIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "9ED5AD4E2E4E4D0EFB32A4F0D669C323", hash_generated_method = "EEF9940CC6433F1FADD04DC1053F1764")
    @DSModeled(DSC.SAFE)
    private NativeBreakIterator(int address, int type) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(type);
        this.type = type;
        this.address = address;
        this.charIter = new StringCharacterIterator("");
        // ---------- Original Method ----------
        //this.address = address;
        //this.type = type;
        //this.charIter = new StringCharacterIterator("");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "E8D9FE5FD19A07CF96575F06CB3EDCC6", hash_generated_method = "C1AE78A0C372AFF8348421C29BC77F06")
    @DSModeled(DSC.SAFE)
    @Override
    public Object clone() {
        int cloneAddr;
        cloneAddr = cloneImpl(this.address);
        NativeBreakIterator clone;
        clone = new NativeBreakIterator(cloneAddr, this.type);
        clone.charIter = this.charIter;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int cloneAddr = cloneImpl(this.address);
        //NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        //clone.charIter = this.charIter;
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "C0D37969DD3FDF8DABA3E38E17F8673F", hash_generated_method = "40E905B750FE2883350E151D5DC7A345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        NativeBreakIterator rhs;
        rhs = (NativeBreakIterator) object;
        boolean var11AE9D85BACBD82FFFD804E90F7E9FC5_1683836155 = (type == rhs.type && charIter.equals(rhs.charIter));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (object == this) {
            //return true;
        //}
        //if (!(object instanceof NativeBreakIterator)) {
            //return false;
        //}
        //NativeBreakIterator rhs = (NativeBreakIterator) object;
        //return type == rhs.type && charIter.equals(rhs.charIter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "34D61A94E1D35565606B91BAEFC3E26A")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "208EB0EBF488A5AB652AF86235D70FBD", hash_generated_method = "06A2918EA08F339C714F2D9A96FB8ADB")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            closeBreakIteratorImpl(this.address);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //closeBreakIteratorImpl(this.address);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "2391C371CA23DB69D751D73221932202", hash_generated_method = "8E4ABDF0E7038B793313743C5F364F0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int current() {
        int varAE8CE53C0E425A9DE4B6B8685A7B4EC5_980582005 = (currentImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return currentImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "1A13813B2C0D0FA0A609E46FE8D7DFD7", hash_generated_method = "38918C916FB4BE7B102152471E8DC0DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int first() {
        int varFF8095A8131627AFC1D17DEB90DF743E_271663921 = (firstImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return firstImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "C67E0BB38B934A66B534DF84C290EF97", hash_generated_method = "1D138BA5306324AA3D52A39AC7CEFD62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int following(int offset) {
        dsTaint.addTaint(offset);
        int varD2C4385605086AFDC96151F2D2D9AD0A_962820391 = (followingImpl(this.address, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return followingImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "9A8EEEA70A76B239B3603BC6AAF004E0", hash_generated_method = "ABABF283751683E861FB0B0160C8E659")
    @DSModeled(DSC.SAFE)
    public CharacterIterator getText() {
        int newLoc;
        newLoc = currentImpl(this.address);
        this.charIter.setIndex(newLoc);
        return (CharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int newLoc = currentImpl(this.address);
        //this.charIter.setIndex(newLoc);
        //return this.charIter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.090 -0400", hash_original_method = "4EDF3F20F64FE6397882DD52BEA1A135", hash_generated_method = "F7625D55725CB565F799A35705EB2840")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int last() {
        int var86EADFE0A758E62B0D053B5253AFFAC7_911747607 = (lastImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "E523A5922365CD35E7F7E6CDEBFA4659", hash_generated_method = "78C55F0FC7E493CFC41ED7F06A87ED5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next(int n) {
        dsTaint.addTaint(n);
        int varEDD1AE483CE5B2B7DAA9A963EEC0581C_1871673673 = (nextImpl(this.address, n));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nextImpl(this.address, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "7AAEC5B08F789B8C43B6E5E5CF95D955", hash_generated_method = "7F2E83931CACB232B9C70758EA308F46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next() {
        int varCA823075C77E55F1D629CC474D5B1FB3_667243662 = (nextImpl(this.address, 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nextImpl(this.address, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "22FF5B0E4F3FECAD90665D7BA35C8F29", hash_generated_method = "EB436BCDC09E0B1742D85ECF5ABB7EDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int previous() {
        int var04ECAC957A62BD50BF2486A732DDED70_676565402 = (previousImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return previousImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "45B89ED28696EBB5A7E263628F907361", hash_generated_method = "AF9BDB511482F9AE8A873443EB18AA6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharacterIterator newText) {
        dsTaint.addTaint(newText.dsTaint);
        StringBuilder sb;
        sb = new StringBuilder();
        {
            char c;
            c = newText.first();
            c = newText.next();
            {
                sb.append(c);
            } //End block
        } //End collapsed parenthetic
        setText(sb.toString(), newText);
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //for (char c = newText.first(); c != CharacterIterator.DONE; c = newText.next()) {
            //sb.append(c);
        //}
        //setText(sb.toString(), newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "67F081416AECF904EEC9E927DC093231", hash_generated_method = "B3E1085569204D2EF416D5C1C967AA3C")
    @DSModeled(DSC.SAFE)
    public void setText(String newText) {
        dsTaint.addTaint(newText);
        setText(newText, new StringCharacterIterator(newText));
        // ---------- Original Method ----------
        //setText(newText, new StringCharacterIterator(newText));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "5F9AC84894F083D607B365AEC97D7D28", hash_generated_method = "8EC855E298B430DBA24A8EAD3E5F2954")
    @DSModeled(DSC.SAFE)
    private void setText(String s, CharacterIterator it) {
        dsTaint.addTaint(it.dsTaint);
        dsTaint.addTaint(s);
        setTextImpl(this.address, s);
        // ---------- Original Method ----------
        //this.charIter = it;
        //setTextImpl(this.address, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "CA983FC19E9238FC0FEBBD9EADAED98D", hash_generated_method = "B9D0129A9781F25BE600A8ECE8B95648")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBoundary(int offset) {
        dsTaint.addTaint(offset);
        boolean var78442A836AFAE97B9CDC0A97F3970018_1717016774 = (isBoundaryImpl(this.address, offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBoundaryImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "C0EEB96929CAD1AA71A6080EC44F9C10", hash_generated_method = "CFBE1C5DAAB610FA63F768B681918169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        int var35A4486875D2E90B8FAFD355C04FF2A7_1665827217 = (precedingImpl(this.address, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return precedingImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "2691A66B9F7121FF4E1F4C3AAB3B115E", hash_generated_method = "42DDEB519612D2FBBAFC815CFE4746A1")
    public static NativeBreakIterator getCharacterInstance(Locale where) {
        return new NativeBreakIterator(getCharacterInstanceImpl(where.toString()), BI_CHAR_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "A5068826AB61508C73B826D13F7802F6", hash_generated_method = "3142643C43E8C30F5636F1C02DB42E99")
    public static NativeBreakIterator getLineInstance(Locale where) {
        return new NativeBreakIterator(getLineInstanceImpl(where.toString()), BI_LINE_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "7BCD2471A17EE3261A84DEB3E7F32F40", hash_generated_method = "09110D6D10CDC69E97F8B5E85128125F")
    public static NativeBreakIterator getSentenceInstance(Locale where) {
        return new NativeBreakIterator(getSentenceInstanceImpl(where.toString()), BI_SENT_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "DDEBBF67963FA6D0A8324F874358024D", hash_generated_method = "7BCFC0C2A8877C4BE69A837A07D110A2")
    public static NativeBreakIterator getWordInstance(Locale where) {
        return new NativeBreakIterator(getWordInstanceImpl(where.toString()), BI_WORD_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "E766469118F90506F4C9971F2F3D4750", hash_generated_method = "B3CB0B65D60401EAF2B8D8905E40469E")
    private static int getCharacterInstanceImpl(String locale) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "35B9912B68AEF76CDC9E5DA290FBE19F", hash_generated_method = "B7880BF6341232F79A6367F8BD7CDE96")
    private static int getWordInstanceImpl(String locale) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "10BD6805657369CE3FE13179C9A4A9A0", hash_generated_method = "5292C72EB2CD49C2F7573EDB9514AB60")
    private static int getLineInstanceImpl(String locale) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "F5E3D605EB2ED0902B913AD7DDE3776C", hash_generated_method = "24EEE2F7734707FCD3182235B0843004")
    private static int getSentenceInstanceImpl(String locale) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "4A7DB1B9F3F48320253BFC66BEF09393", hash_generated_method = "9751E53BF3110E4192B1F736D833160D")
    private static void closeBreakIteratorImpl(int address) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "523AC9BA37BF4E05037C110BBD5C538B", hash_generated_method = "204E766663DE629EE0F417D8FB845AB6")
    private static void setTextImpl(int address, String text) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "C9B3B2F43D45BD33A36364AB99B01F0A", hash_generated_method = "88D19D4E85EF6AD226DC23C7DCB3106D")
    private static int cloneImpl(int address) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "409317681ACB84DC5FE75E73562B12EF", hash_generated_method = "EA907C1CE4F1C20C9FC7FC242E49EE42")
    private static int precedingImpl(int address, int offset) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "5F86A93EFF1868F91A88BDF127ABFD08", hash_generated_method = "61587A94B7E0B049CADA45BD7440460E")
    private static boolean isBoundaryImpl(int address, int offset) {
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "BAC69EC7980335B2A29F42F4F4C386CF", hash_generated_method = "080D85B312EE89277212BBBFE1046A9D")
    private static int nextImpl(int address, int n) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "D76F011F9F290901CF2468633CB0387C", hash_generated_method = "A1400EFD009316B5F1C41D3535C31485")
    private static int previousImpl(int address) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "7874B679284AF0368DA954A72841812B", hash_generated_method = "3542EE7C5EBE3FE5390D45C9AFB452D6")
    private static int currentImpl(int address) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "B49B6440E0A2979B13782B7B31F7DC9D", hash_generated_method = "235C1C0B8D349A23B4D3C97E96D8B450")
    private static int firstImpl(int address) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "942F150E9EA258E857D29D0B1227C19B", hash_generated_method = "8BF964D61CFBFAF8C95345CC4136636F")
    private static int followingImpl(int address, int offset) {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.091 -0400", hash_original_method = "4A10CEDE915BA75F7F2D7018A9C12E7F", hash_generated_method = "61F6268EE6ABF36B2D3AE0959684F2EC")
    private static int lastImpl(int address) {
    	return DSUtils.UNKNOWN_INT;
    }

    
}


