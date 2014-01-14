package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

import droidsafe.helpers.DSUtils;

public final class NativeBreakIterator implements Cloneable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.798 -0500", hash_original_method = "2691A66B9F7121FF4E1F4C3AAB3B115E", hash_generated_method = "42DDEB519612D2FBBAFC815CFE4746A1")
    
public static NativeBreakIterator getCharacterInstance(Locale where) {
        return new NativeBreakIterator(getCharacterInstanceImpl(where.toString()), BI_CHAR_INSTANCE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.801 -0500", hash_original_method = "A5068826AB61508C73B826D13F7802F6", hash_generated_method = "3142643C43E8C30F5636F1C02DB42E99")
    
public static NativeBreakIterator getLineInstance(Locale where) {
        return new NativeBreakIterator(getLineInstanceImpl(where.toString()), BI_LINE_INSTANCE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.803 -0500", hash_original_method = "7BCD2471A17EE3261A84DEB3E7F32F40", hash_generated_method = "09110D6D10CDC69E97F8B5E85128125F")
    
public static NativeBreakIterator getSentenceInstance(Locale where) {
        return new NativeBreakIterator(getSentenceInstanceImpl(where.toString()), BI_SENT_INSTANCE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.806 -0500", hash_original_method = "DDEBBF67963FA6D0A8324F874358024D", hash_generated_method = "7BCFC0C2A8877C4BE69A837A07D110A2")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.736 -0500", hash_original_field = "ADC5815F60DECE39E3EFD55FDE9D76C1", hash_generated_field = "8F5E3087826950D143F25CF896D3856E")

    private static final int BI_CHAR_INSTANCE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.738 -0500", hash_original_field = "491B557A5699B281495F18277A3F3815", hash_generated_field = "5A4B618A89B222F27216AC1D3CFB505B")

    private static final int BI_WORD_INSTANCE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.741 -0500", hash_original_field = "98F1F24582F0C394B3DFB96380A01D76", hash_generated_field = "C825CA97E025D552BDB49FDD5FC85C28")

    private static final int BI_LINE_INSTANCE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.743 -0500", hash_original_field = "FFF6DC2F0DB0F70C01B42D02E1A9FAC1", hash_generated_field = "0CFA201142952E1019C143FD2DDAA92B")

    private static final int BI_SENT_INSTANCE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.746 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private  int address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.748 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private  int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.750 -0500", hash_original_field = "4D13D35348917AF2C7A3686E058DF6D2", hash_generated_field = "24EE663A8B6FD47BBC471ECC500F93AB")

    private CharacterIterator charIter;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.752 -0500", hash_original_method = "9ED5AD4E2E4E4D0EFB32A4F0D669C323", hash_generated_method = "B39470009066E1562E6CE37B98210DDF")
    
private NativeBreakIterator(int address, int type) {
        this.address = address;
        this.type = type;
        this.charIter = new StringCharacterIterator("");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.755 -0500", hash_original_method = "E8D9FE5FD19A07CF96575F06CB3EDCC6", hash_generated_method = "C2FB168A1240136A54A391F6EDC2FB38")
    
@Override
    public Object clone() {
        int cloneAddr = cloneImpl(this.address);
        NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        // The RI doesn't clone the CharacterIterator.
        clone.charIter = this.charIter;
        return clone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.757 -0500", hash_original_method = "C0D37969DD3FDF8DABA3E38E17F8673F", hash_generated_method = "F2AB5C458A26A5EA715085C40C05781E")
    
@Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NativeBreakIterator)) {
            return false;
        }
        // TODO: is this sufficient? shouldn't we be checking the underlying rules?
        NativeBreakIterator rhs = (NativeBreakIterator) object;
        return type == rhs.type && charIter.equals(rhs.charIter);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.759 -0500", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "6FE10F00B45C1B3A5C1E5FE9B1177C9E")
    
@Override
    public int hashCode() {
        return 42; // No-one uses BreakIterator as a hash key.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.762 -0500", hash_original_method = "208EB0EBF488A5AB652AF86235D70FBD", hash_generated_method = "0C61F8DA3E19DDA8A8E21A8EFA0CF440")
    
@Override protected void finalize() throws Throwable {
        try {
            closeBreakIteratorImpl(this.address);
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.764 -0500", hash_original_method = "2391C371CA23DB69D751D73221932202", hash_generated_method = "83D6F7CDA8ABB4860A56E9C8FEFC2906")
    
public int current() {
        return currentImpl(this.address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.766 -0500", hash_original_method = "1A13813B2C0D0FA0A609E46FE8D7DFD7", hash_generated_method = "7D9E7625A36580C88E55CA60C5CC37C9")
    
public int first() {
        return firstImpl(this.address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.769 -0500", hash_original_method = "C67E0BB38B934A66B534DF84C290EF97", hash_generated_method = "756AD35267EDFDD789AE078C24306BEA")
    
public int following(int offset) {
        return followingImpl(this.address, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.771 -0500", hash_original_method = "9A8EEEA70A76B239B3603BC6AAF004E0", hash_generated_method = "2A1698EBD92E4433C10E5F9A7EBAB96B")
    
public CharacterIterator getText() {
        int newLoc = currentImpl(this.address);
        this.charIter.setIndex(newLoc);
        return this.charIter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.773 -0500", hash_original_method = "4EDF3F20F64FE6397882DD52BEA1A135", hash_generated_method = "DA2DBBFF8E71C055F9B6AD92003DED37")
    
public int last() {
        return lastImpl(this.address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.775 -0500", hash_original_method = "E523A5922365CD35E7F7E6CDEBFA4659", hash_generated_method = "DE8730CF2242862AE3C962AAE878BD70")
    
public int next(int n) {
        return nextImpl(this.address, n);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.777 -0500", hash_original_method = "7AAEC5B08F789B8C43B6E5E5CF95D955", hash_generated_method = "1E2D1C7AAB607F2BCBC38D8B207729F2")
    
public int next() {
        return nextImpl(this.address, 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.779 -0500", hash_original_method = "22FF5B0E4F3FECAD90665D7BA35C8F29", hash_generated_method = "0C63903B62DBB05DA133D4C6894557DF")
    
public int previous() {
        return previousImpl(this.address);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.782 -0500", hash_original_method = "45B89ED28696EBB5A7E263628F907361", hash_generated_method = "6E2702A6B45E230A447975D2EBD63E63")
    
public void setText(CharacterIterator newText) {
        StringBuilder sb = new StringBuilder();
        for (char c = newText.first(); c != CharacterIterator.DONE; c = newText.next()) {
            sb.append(c);
        }
        setText(sb.toString(), newText);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.785 -0500", hash_original_method = "67F081416AECF904EEC9E927DC093231", hash_generated_method = "BE99923ADC4BB691C54634CED28CF931")
    
public void setText(String newText) {
        setText(newText, new StringCharacterIterator(newText));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.787 -0500", hash_original_method = "5F9AC84894F083D607B365AEC97D7D28", hash_generated_method = "B9BCF9DF688E9273A7AE591D5670945C")
    
private void setText(String s, CharacterIterator it) {
        this.charIter = it;
        setTextImpl(this.address, s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.794 -0500", hash_original_method = "CA983FC19E9238FC0FEBBD9EADAED98D", hash_generated_method = "C55F4C690B5DBE07FDE69EEDD189D9A4")
    
public boolean isBoundary(int offset) {
        return isBoundaryImpl(this.address, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.796 -0500", hash_original_method = "C0EEB96929CAD1AA71A6080EC44F9C10", hash_generated_method = "4E39CF026A16D5139750DC83A408E2F3")
    
public int preceding(int offset) {
        return precedingImpl(this.address, offset);
    }
}

