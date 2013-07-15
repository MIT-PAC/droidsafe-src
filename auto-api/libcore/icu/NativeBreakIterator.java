package libcore.icu;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

public final class NativeBreakIterator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.941 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.941 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.941 -0400", hash_original_field = "92442F743DC6BA830150769D757D3D4B", hash_generated_field = "24EE663A8B6FD47BBC471ECC500F93AB")

    private CharacterIterator charIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.941 -0400", hash_original_method = "9ED5AD4E2E4E4D0EFB32A4F0D669C323", hash_generated_method = "98E6F9885885A27CBEB93ABA0757BDC5")
    private  NativeBreakIterator(int address, int type) {
        this.address = address;
        this.type = type;
        this.charIter = new StringCharacterIterator("");
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.942 -0400", hash_original_method = "E8D9FE5FD19A07CF96575F06CB3EDCC6", hash_generated_method = "6153EEEDA0D26A4EC0F0B2F6C7F50EBB")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_420710464 = null; 
        int cloneAddr = cloneImpl(this.address);
        NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        clone.charIter = this.charIter;
        varB4EAC82CA7396A68D541C85D26508E83_420710464 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_420710464.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_420710464;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.942 -0400", hash_original_method = "C0D37969DD3FDF8DABA3E38E17F8673F", hash_generated_method = "C33FBE4F1B07124835F0B9832E413011")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_350707278 = (object == this);
        } 
        NativeBreakIterator rhs = (NativeBreakIterator) object;
        boolean var11AE9D85BACBD82FFFD804E90F7E9FC5_1029250574 = (type == rhs.type && charIter.equals(rhs.charIter));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149984556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149984556;
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.942 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "DDDAF2EB102405E253947E412E93579A")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653227993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653227993;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.943 -0400", hash_original_method = "208EB0EBF488A5AB652AF86235D70FBD", hash_generated_method = "4840C7CD141C8487FE191FCFD53D4997")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            closeBreakIteratorImpl(this.address);
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.943 -0400", hash_original_method = "2391C371CA23DB69D751D73221932202", hash_generated_method = "415E844E0221EC441915580AC66A9DEE")
    public int current() {
        int varAE8CE53C0E425A9DE4B6B8685A7B4EC5_168475040 = (currentImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475514787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475514787;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.943 -0400", hash_original_method = "1A13813B2C0D0FA0A609E46FE8D7DFD7", hash_generated_method = "59DB291818647A676ACDD8EC30409922")
    public int first() {
        int varFF8095A8131627AFC1D17DEB90DF743E_1458776323 = (firstImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339770525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339770525;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.943 -0400", hash_original_method = "C67E0BB38B934A66B534DF84C290EF97", hash_generated_method = "DF4BB428E638874C9032EE02237AB2B9")
    public int following(int offset) {
        int varD2C4385605086AFDC96151F2D2D9AD0A_1387229457 = (followingImpl(this.address, offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210955657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210955657;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.944 -0400", hash_original_method = "9A8EEEA70A76B239B3603BC6AAF004E0", hash_generated_method = "EADC09B690E8225B5E14421A4607415C")
    public CharacterIterator getText() {
        CharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1356415759 = null; 
        int newLoc = currentImpl(this.address);
        this.charIter.setIndex(newLoc);
        varB4EAC82CA7396A68D541C85D26508E83_1356415759 = this.charIter;
        varB4EAC82CA7396A68D541C85D26508E83_1356415759.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1356415759;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.944 -0400", hash_original_method = "4EDF3F20F64FE6397882DD52BEA1A135", hash_generated_method = "F91D90C5CF1DBC5F0A896521BB8BFB3D")
    public int last() {
        int var86EADFE0A758E62B0D053B5253AFFAC7_571485342 = (lastImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142991886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142991886;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.944 -0400", hash_original_method = "E523A5922365CD35E7F7E6CDEBFA4659", hash_generated_method = "4FFA72379D96374FFA8D386F841DCE08")
    public int next(int n) {
        int varEDD1AE483CE5B2B7DAA9A963EEC0581C_1121981528 = (nextImpl(this.address, n));
        addTaint(n);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317210338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317210338;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.944 -0400", hash_original_method = "7AAEC5B08F789B8C43B6E5E5CF95D955", hash_generated_method = "EC88C9457FEF1C94A5F1EB969CC3B2CB")
    public int next() {
        int varCA823075C77E55F1D629CC474D5B1FB3_1805550839 = (nextImpl(this.address, 1));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767434129 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767434129;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.945 -0400", hash_original_method = "22FF5B0E4F3FECAD90665D7BA35C8F29", hash_generated_method = "71C3A20FC81A467FFF8AF4A40900AD34")
    public int previous() {
        int var04ECAC957A62BD50BF2486A732DDED70_1991347459 = (previousImpl(this.address));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074403180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074403180;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.945 -0400", hash_original_method = "45B89ED28696EBB5A7E263628F907361", hash_generated_method = "61996B66770DB6C1276C80155C4AC7CD")
    public void setText(CharacterIterator newText) {
        StringBuilder sb = new StringBuilder();
        {
            char c = newText.first();
            c = newText.next();
            {
                sb.append(c);
            } 
        } 
        setText(sb.toString(), newText);
        addTaint(newText.getTaint());
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.946 -0400", hash_original_method = "67F081416AECF904EEC9E927DC093231", hash_generated_method = "229A7BF4F4DA10AA5B8A5BD05847480B")
    public void setText(String newText) {
        setText(newText, new StringCharacterIterator(newText));
        addTaint(newText.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.946 -0400", hash_original_method = "5F9AC84894F083D607B365AEC97D7D28", hash_generated_method = "04316AB2DF6BB07D89221823C991AD7E")
    private void setText(String s, CharacterIterator it) {
        this.charIter = it;
        setTextImpl(this.address, s);
        addTaint(s.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.947 -0400", hash_original_method = "CA983FC19E9238FC0FEBBD9EADAED98D", hash_generated_method = "4AB82110EFDE83245F4420F6AE25C139")
    public boolean isBoundary(int offset) {
        boolean var78442A836AFAE97B9CDC0A97F3970018_425155287 = (isBoundaryImpl(this.address, offset));
        addTaint(offset);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568299998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568299998;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.947 -0400", hash_original_method = "C0EEB96929CAD1AA71A6080EC44F9C10", hash_generated_method = "1808DF82769673CA56BA9DF6D1C5968A")
    public int preceding(int offset) {
        int var35A4486875D2E90B8FAFD355C04FF2A7_1111824421 = (precedingImpl(this.address, offset));
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145860431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145860431;
        
        
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

    
    @DSModeled(DSC.SAFE)
    private static int getCharacterInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int getWordInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int getLineInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int getSentenceInstanceImpl(String locale) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void closeBreakIteratorImpl(int address) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void setTextImpl(int address, String text) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int cloneImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int precedingImpl(int address, int offset) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isBoundaryImpl(int address, int offset) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nextImpl(int address, int n) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int previousImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int currentImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int firstImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int followingImpl(int address, int offset) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int lastImpl(int address) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.951 -0400", hash_original_field = "6BD7E9E84499E5603B299C3A233B4C92", hash_generated_field = "8F5E3087826950D143F25CF896D3856E")

    private static final int BI_CHAR_INSTANCE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.952 -0400", hash_original_field = "057CFD03C44F6D28A94ABBF832CAD225", hash_generated_field = "5A4B618A89B222F27216AC1D3CFB505B")

    private static final int BI_WORD_INSTANCE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.952 -0400", hash_original_field = "C025976D9ACB5B6B5FD71B22001575FF", hash_generated_field = "C825CA97E025D552BDB49FDD5FC85C28")

    private static final int BI_LINE_INSTANCE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:26.952 -0400", hash_original_field = "1A8AFE673FA90549D5DBF03579CC782A", hash_generated_field = "0CFA201142952E1019C143FD2DDAA92B")

    private static final int BI_SENT_INSTANCE = 4;
}

