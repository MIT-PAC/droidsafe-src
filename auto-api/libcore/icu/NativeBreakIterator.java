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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.060 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.060 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.060 -0400", hash_original_field = "92442F743DC6BA830150769D757D3D4B", hash_generated_field = "24EE663A8B6FD47BBC471ECC500F93AB")

    private CharacterIterator charIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.065 -0400", hash_original_method = "9ED5AD4E2E4E4D0EFB32A4F0D669C323", hash_generated_method = "98E6F9885885A27CBEB93ABA0757BDC5")
    private  NativeBreakIterator(int address, int type) {
        this.address = address;
        this.type = type;
        this.charIter = new StringCharacterIterator("");
        // ---------- Original Method ----------
        //this.address = address;
        //this.type = type;
        //this.charIter = new StringCharacterIterator("");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.065 -0400", hash_original_method = "E8D9FE5FD19A07CF96575F06CB3EDCC6", hash_generated_method = "5A247EF5653DC51395C012317CA19AF6")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1895500203 = null; //Variable for return #1
        int cloneAddr;
        cloneAddr = cloneImpl(this.address);
        NativeBreakIterator clone;
        clone = new NativeBreakIterator(cloneAddr, this.type);
        clone.charIter = this.charIter;
        varB4EAC82CA7396A68D541C85D26508E83_1895500203 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1895500203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895500203;
        // ---------- Original Method ----------
        //int cloneAddr = cloneImpl(this.address);
        //NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        //clone.charIter = this.charIter;
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.069 -0400", hash_original_method = "C0D37969DD3FDF8DABA3E38E17F8673F", hash_generated_method = "742CAEFD6A85B97840216F29A9596C24")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_1436704083 = (object == this);
        } //End collapsed parenthetic
        NativeBreakIterator rhs;
        rhs = (NativeBreakIterator) object;
        boolean var11AE9D85BACBD82FFFD804E90F7E9FC5_1993488107 = (type == rhs.type && charIter.equals(rhs.charIter));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978616213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978616213;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.069 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "A181AB7711F2C62901AAC5B9D38EF809")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091098842 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091098842;
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.070 -0400", hash_original_method = "208EB0EBF488A5AB652AF86235D70FBD", hash_generated_method = "4840C7CD141C8487FE191FCFD53D4997")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.072 -0400", hash_original_method = "2391C371CA23DB69D751D73221932202", hash_generated_method = "4CF3069FB4DE76D179CA093BA696F3F2")
    public int current() {
        int varAE8CE53C0E425A9DE4B6B8685A7B4EC5_1697733653 = (currentImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201922850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201922850;
        // ---------- Original Method ----------
        //return currentImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.072 -0400", hash_original_method = "1A13813B2C0D0FA0A609E46FE8D7DFD7", hash_generated_method = "CD968C587450313AAA2DE47AA324F1CF")
    public int first() {
        int varFF8095A8131627AFC1D17DEB90DF743E_1580840134 = (firstImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939694036 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939694036;
        // ---------- Original Method ----------
        //return firstImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.081 -0400", hash_original_method = "C67E0BB38B934A66B534DF84C290EF97", hash_generated_method = "9A7659C23FFA521AD634C350016AF42B")
    public int following(int offset) {
        int varD2C4385605086AFDC96151F2D2D9AD0A_1066488782 = (followingImpl(this.address, offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521185219 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521185219;
        // ---------- Original Method ----------
        //return followingImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.082 -0400", hash_original_method = "9A8EEEA70A76B239B3603BC6AAF004E0", hash_generated_method = "9F748137730F47D5878D6AB12F1FD104")
    public CharacterIterator getText() {
        CharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1286845827 = null; //Variable for return #1
        int newLoc;
        newLoc = currentImpl(this.address);
        this.charIter.setIndex(newLoc);
        varB4EAC82CA7396A68D541C85D26508E83_1286845827 = this.charIter;
        varB4EAC82CA7396A68D541C85D26508E83_1286845827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1286845827;
        // ---------- Original Method ----------
        //int newLoc = currentImpl(this.address);
        //this.charIter.setIndex(newLoc);
        //return this.charIter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.083 -0400", hash_original_method = "4EDF3F20F64FE6397882DD52BEA1A135", hash_generated_method = "561D127496A299D9FDDC6981C98EA1BB")
    public int last() {
        int var86EADFE0A758E62B0D053B5253AFFAC7_357745414 = (lastImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663966902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663966902;
        // ---------- Original Method ----------
        //return lastImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.083 -0400", hash_original_method = "E523A5922365CD35E7F7E6CDEBFA4659", hash_generated_method = "9228630F027A23877F0DAF7F14D6971E")
    public int next(int n) {
        int varEDD1AE483CE5B2B7DAA9A963EEC0581C_2134343922 = (nextImpl(this.address, n));
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143984963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143984963;
        // ---------- Original Method ----------
        //return nextImpl(this.address, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.096 -0400", hash_original_method = "7AAEC5B08F789B8C43B6E5E5CF95D955", hash_generated_method = "8FA7AD82EF9D2017837ADEBDE733DFF2")
    public int next() {
        int varCA823075C77E55F1D629CC474D5B1FB3_1065209821 = (nextImpl(this.address, 1));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814911807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814911807;
        // ---------- Original Method ----------
        //return nextImpl(this.address, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.097 -0400", hash_original_method = "22FF5B0E4F3FECAD90665D7BA35C8F29", hash_generated_method = "ECF91E89240025BC702653B8E8855A21")
    public int previous() {
        int var04ECAC957A62BD50BF2486A732DDED70_1147237164 = (previousImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503011449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503011449;
        // ---------- Original Method ----------
        //return previousImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.098 -0400", hash_original_method = "45B89ED28696EBB5A7E263628F907361", hash_generated_method = "2E68ADD9FBF09F72631E706956688352")
    public void setText(CharacterIterator newText) {
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
        addTaint(newText.getTaint());
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //for (char c = newText.first(); c != CharacterIterator.DONE; c = newText.next()) {
            //sb.append(c);
        //}
        //setText(sb.toString(), newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.098 -0400", hash_original_method = "67F081416AECF904EEC9E927DC093231", hash_generated_method = "229A7BF4F4DA10AA5B8A5BD05847480B")
    public void setText(String newText) {
        setText(newText, new StringCharacterIterator(newText));
        addTaint(newText.getTaint());
        // ---------- Original Method ----------
        //setText(newText, new StringCharacterIterator(newText));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.098 -0400", hash_original_method = "5F9AC84894F083D607B365AEC97D7D28", hash_generated_method = "04316AB2DF6BB07D89221823C991AD7E")
    private void setText(String s, CharacterIterator it) {
        this.charIter = it;
        setTextImpl(this.address, s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //this.charIter = it;
        //setTextImpl(this.address, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.099 -0400", hash_original_method = "CA983FC19E9238FC0FEBBD9EADAED98D", hash_generated_method = "63DD75366C5BB10F4A132E95B88D42F4")
    public boolean isBoundary(int offset) {
        boolean var78442A836AFAE97B9CDC0A97F3970018_1523843301 = (isBoundaryImpl(this.address, offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600318409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600318409;
        // ---------- Original Method ----------
        //return isBoundaryImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.099 -0400", hash_original_method = "C0EEB96929CAD1AA71A6080EC44F9C10", hash_generated_method = "4FDD56C9E6A270A47556EB72C2BF6376")
    public int preceding(int offset) {
        int var35A4486875D2E90B8FAFD355C04FF2A7_1923933895 = (precedingImpl(this.address, offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040733910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040733910;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.136 -0400", hash_original_field = "6BD7E9E84499E5603B299C3A233B4C92", hash_generated_field = "993B29E7C4D14EBCEBC768718B0A6C21")

    private static int BI_CHAR_INSTANCE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.136 -0400", hash_original_field = "057CFD03C44F6D28A94ABBF832CAD225", hash_generated_field = "24A2C79DC40C39D7967B81C2DCE2CB2D")

    private static int BI_WORD_INSTANCE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.136 -0400", hash_original_field = "C025976D9ACB5B6B5FD71B22001575FF", hash_generated_field = "715F5452F68C864292FDA99F7F8EC33E")

    private static int BI_LINE_INSTANCE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.136 -0400", hash_original_field = "1A8AFE673FA90549D5DBF03579CC782A", hash_generated_field = "A4945CA05D69C8C0D9E99AF3FEE009D3")

    private static int BI_SENT_INSTANCE = 4;
}

