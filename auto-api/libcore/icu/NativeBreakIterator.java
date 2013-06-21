package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

public final class NativeBreakIterator implements Cloneable {
    private int address;
    private int type;
    private CharacterIterator charIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.274 -0400", hash_original_method = "9ED5AD4E2E4E4D0EFB32A4F0D669C323", hash_generated_method = "51C382C69142E9C83FF1D9F29B0899F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NativeBreakIterator(int address, int type) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(type);
        this.charIter = new StringCharacterIterator("");
        // ---------- Original Method ----------
        //this.address = address;
        //this.type = type;
        //this.charIter = new StringCharacterIterator("");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.274 -0400", hash_original_method = "E8D9FE5FD19A07CF96575F06CB3EDCC6", hash_generated_method = "E5E6C8D4D7CC9D35B9C639548EC1A7FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.275 -0400", hash_original_method = "C0D37969DD3FDF8DABA3E38E17F8673F", hash_generated_method = "7110A9844796113836A3B8D83D2BF1DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var3F549205D4C262003697A031F89E5954_1463062905 = (object == this);
        } //End collapsed parenthetic
        NativeBreakIterator rhs;
        rhs = (NativeBreakIterator) object;
        boolean var11AE9D85BACBD82FFFD804E90F7E9FC5_439147766 = (type == rhs.type && charIter.equals(rhs.charIter));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.275 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "4AD6E921A7451B952F62B962966BB07C")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.275 -0400", hash_original_method = "208EB0EBF488A5AB652AF86235D70FBD", hash_generated_method = "4840C7CD141C8487FE191FCFD53D4997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.275 -0400", hash_original_method = "2391C371CA23DB69D751D73221932202", hash_generated_method = "A6FC5F0B1C4F86630D27E68D8BD5CAFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int current() {
        int varAE8CE53C0E425A9DE4B6B8685A7B4EC5_775188965 = (currentImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return currentImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.276 -0400", hash_original_method = "1A13813B2C0D0FA0A609E46FE8D7DFD7", hash_generated_method = "535A62DCADD7B85072BED39DBA5015D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int first() {
        int varFF8095A8131627AFC1D17DEB90DF743E_14989900 = (firstImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return firstImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.276 -0400", hash_original_method = "C67E0BB38B934A66B534DF84C290EF97", hash_generated_method = "7BE3A30CD247B7A6D3235F4F36625CF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int following(int offset) {
        dsTaint.addTaint(offset);
        int varD2C4385605086AFDC96151F2D2D9AD0A_468224936 = (followingImpl(this.address, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return followingImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.276 -0400", hash_original_method = "9A8EEEA70A76B239B3603BC6AAF004E0", hash_generated_method = "7F6F49913CE2DE7691BDF90137B437CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.276 -0400", hash_original_method = "4EDF3F20F64FE6397882DD52BEA1A135", hash_generated_method = "25FA34B3F16F5E2117E50C5B52B3F861")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int last() {
        int var86EADFE0A758E62B0D053B5253AFFAC7_743076143 = (lastImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.277 -0400", hash_original_method = "E523A5922365CD35E7F7E6CDEBFA4659", hash_generated_method = "0B396207E555FE645CB43318960B74B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next(int n) {
        dsTaint.addTaint(n);
        int varEDD1AE483CE5B2B7DAA9A963EEC0581C_986756149 = (nextImpl(this.address, n));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nextImpl(this.address, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.277 -0400", hash_original_method = "7AAEC5B08F789B8C43B6E5E5CF95D955", hash_generated_method = "DDE7155BD386166DD08FA54CBB1D4020")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next() {
        int varCA823075C77E55F1D629CC474D5B1FB3_1910366149 = (nextImpl(this.address, 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nextImpl(this.address, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.277 -0400", hash_original_method = "22FF5B0E4F3FECAD90665D7BA35C8F29", hash_generated_method = "C5250BD1DC5D83503192813565F47A0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int previous() {
        int var04ECAC957A62BD50BF2486A732DDED70_208946694 = (previousImpl(this.address));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return previousImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.277 -0400", hash_original_method = "45B89ED28696EBB5A7E263628F907361", hash_generated_method = "84E04F0350CE9F066B6DCDE8A9CB968D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.278 -0400", hash_original_method = "67F081416AECF904EEC9E927DC093231", hash_generated_method = "F28C511401030E7A4A97A8515B005A4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(String newText) {
        dsTaint.addTaint(newText);
        setText(newText, new StringCharacterIterator(newText));
        // ---------- Original Method ----------
        //setText(newText, new StringCharacterIterator(newText));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.278 -0400", hash_original_method = "5F9AC84894F083D607B365AEC97D7D28", hash_generated_method = "B93232A93F88E82F331553AB0941E53A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setText(String s, CharacterIterator it) {
        dsTaint.addTaint(it.dsTaint);
        dsTaint.addTaint(s);
        setTextImpl(this.address, s);
        // ---------- Original Method ----------
        //this.charIter = it;
        //setTextImpl(this.address, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.278 -0400", hash_original_method = "CA983FC19E9238FC0FEBBD9EADAED98D", hash_generated_method = "7F250DF7E541548C8B51CC7ED760D924")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBoundary(int offset) {
        dsTaint.addTaint(offset);
        boolean var78442A836AFAE97B9CDC0A97F3970018_2011765482 = (isBoundaryImpl(this.address, offset));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isBoundaryImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.278 -0400", hash_original_method = "C0EEB96929CAD1AA71A6080EC44F9C10", hash_generated_method = "1AF6CF09B4183FE0E84CD80A1B4DF209")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int preceding(int offset) {
        dsTaint.addTaint(offset);
        int var35A4486875D2E90B8FAFD355C04FF2A7_1103295864 = (precedingImpl(this.address, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return precedingImpl(this.address, offset);
    }

    
        public static NativeBreakIterator getCharacterInstance(Locale where) {
        return new NativeBreakIterator(getCharacterInstanceImpl(where.toString()), BI_CHAR_INSTANCE);
    }

    
        public static NativeBreakIterator getLineInstance(Locale where) {
        return new NativeBreakIterator(getLineInstanceImpl(where.toString()), BI_LINE_INSTANCE);
    }

    
        public static NativeBreakIterator getSentenceInstance(Locale where) {
        return new NativeBreakIterator(getSentenceInstanceImpl(where.toString()), BI_SENT_INSTANCE);
    }

    
        public static NativeBreakIterator getWordInstance(Locale where) {
        return new NativeBreakIterator(getWordInstanceImpl(where.toString()), BI_WORD_INSTANCE);
    }

    
        private static int getCharacterInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int getWordInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int getLineInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int getSentenceInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void closeBreakIteratorImpl(int address) {
    }

    
        private static void setTextImpl(int address, String text) {
    }

    
        private static int cloneImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int precedingImpl(int address, int offset) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static boolean isBoundaryImpl(int address, int offset) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int nextImpl(int address, int n) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int previousImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int currentImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int firstImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int followingImpl(int address, int offset) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int lastImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static final int BI_CHAR_INSTANCE = 1;
    private static final int BI_WORD_INSTANCE = 2;
    private static final int BI_LINE_INSTANCE = 3;
    private static final int BI_SENT_INSTANCE = 4;
}

