package libcore.icu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

public final class NativeBreakIterator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.685 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.685 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.685 -0400", hash_original_field = "92442F743DC6BA830150769D757D3D4B", hash_generated_field = "24EE663A8B6FD47BBC471ECC500F93AB")

    private CharacterIterator charIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.686 -0400", hash_original_method = "9ED5AD4E2E4E4D0EFB32A4F0D669C323", hash_generated_method = "98E6F9885885A27CBEB93ABA0757BDC5")
    private  NativeBreakIterator(int address, int type) {
        this.address = address;
        this.type = type;
        this.charIter = new StringCharacterIterator("");
        // ---------- Original Method ----------
        //this.address = address;
        //this.type = type;
        //this.charIter = new StringCharacterIterator("");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.687 -0400", hash_original_method = "E8D9FE5FD19A07CF96575F06CB3EDCC6", hash_generated_method = "9333ABF593E5E2F2B77E1E9CD5513CD8")
    @Override
    public Object clone() {
        int cloneAddr = cloneImpl(this.address);
        NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        clone.charIter = this.charIter;
Object var3DE52045BFD3C1BF3742F994ED6139AD_1402636367 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1402636367.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1402636367;
        // ---------- Original Method ----------
        //int cloneAddr = cloneImpl(this.address);
        //NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        //clone.charIter = this.charIter;
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.688 -0400", hash_original_method = "C0D37969DD3FDF8DABA3E38E17F8673F", hash_generated_method = "9E5BC56A343973D7145B36D8FB265E2F")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1307894472 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9162011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_9162011;
        } //End block
    if(!(object instanceof NativeBreakIterator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1783353768 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81005644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_81005644;
        } //End block
        NativeBreakIterator rhs = (NativeBreakIterator) object;
        boolean var37E8B39BA54D73CFF1F7A0DAE6792D6D_476112683 = (type == rhs.type && charIter.equals(rhs.charIter));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659586039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659586039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.688 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "5532DC669F1A2C4108622672F374E05D")
    @Override
    public int hashCode() {
        int varA1D0C6E83F027327D8461063F4AC58A6_1683419581 = (42);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749123749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749123749;
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.689 -0400", hash_original_method = "208EB0EBF488A5AB652AF86235D70FBD", hash_generated_method = "4840C7CD141C8487FE191FCFD53D4997")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.689 -0400", hash_original_method = "2391C371CA23DB69D751D73221932202", hash_generated_method = "105FFEA1EB57F799F3099E8AA79643C6")
    public int current() {
        int var918887072051471D15DCE9865E176C01_593997244 = (currentImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912547511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912547511;
        // ---------- Original Method ----------
        //return currentImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.689 -0400", hash_original_method = "1A13813B2C0D0FA0A609E46FE8D7DFD7", hash_generated_method = "A93A0A3C6E0CE1FB1F352667F62904BE")
    public int first() {
        int var2B7B35FE78989FE062EE33A3B222E26C_1698411972 = (firstImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246411016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246411016;
        // ---------- Original Method ----------
        //return firstImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.690 -0400", hash_original_method = "C67E0BB38B934A66B534DF84C290EF97", hash_generated_method = "33816284DFD3D89F86BACE0D73ACE462")
    public int following(int offset) {
        addTaint(offset);
        int varCFC14FC5A7DCCE330CE97C10978BBD6B_1135589422 = (followingImpl(this.address, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482790434 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_482790434;
        // ---------- Original Method ----------
        //return followingImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.690 -0400", hash_original_method = "9A8EEEA70A76B239B3603BC6AAF004E0", hash_generated_method = "437A9C34EBCF0D2D1FE133BD5728E37A")
    public CharacterIterator getText() {
        int newLoc = currentImpl(this.address);
        this.charIter.setIndex(newLoc);
CharacterIterator var1C13B7121FF8DBF33774D26964F8457C_1616152278 =         this.charIter;
        var1C13B7121FF8DBF33774D26964F8457C_1616152278.addTaint(taint);
        return var1C13B7121FF8DBF33774D26964F8457C_1616152278;
        // ---------- Original Method ----------
        //int newLoc = currentImpl(this.address);
        //this.charIter.setIndex(newLoc);
        //return this.charIter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.691 -0400", hash_original_method = "4EDF3F20F64FE6397882DD52BEA1A135", hash_generated_method = "EC355A8B814807D1421947CB6286B0FE")
    public int last() {
        int varF61548759BDDE99A63FE59E0BE1519B9_374113000 = (lastImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2946383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2946383;
        // ---------- Original Method ----------
        //return lastImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.691 -0400", hash_original_method = "E523A5922365CD35E7F7E6CDEBFA4659", hash_generated_method = "38B607612CC28069D17A6652416915C8")
    public int next(int n) {
        addTaint(n);
        int var17D3555F444C6B069FD374E00F7DC161_1274980287 = (nextImpl(this.address, n));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047186549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047186549;
        // ---------- Original Method ----------
        //return nextImpl(this.address, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.692 -0400", hash_original_method = "7AAEC5B08F789B8C43B6E5E5CF95D955", hash_generated_method = "43CC8D705671F2574E10E0B9DC1A82F9")
    public int next() {
        int varC6EC4558C17C1F79E2A9D21289D5AE12_1591418425 = (nextImpl(this.address, 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129955816 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129955816;
        // ---------- Original Method ----------
        //return nextImpl(this.address, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.692 -0400", hash_original_method = "22FF5B0E4F3FECAD90665D7BA35C8F29", hash_generated_method = "8E8C5673435B012E8AD1590D502F10A8")
    public int previous() {
        int var875938D14B97DC4FE8028C1873FCE670_2114293977 = (previousImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258062192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258062192;
        // ---------- Original Method ----------
        //return previousImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.693 -0400", hash_original_method = "45B89ED28696EBB5A7E263628F907361", hash_generated_method = "351F0363933D30AD934472E4095390C6")
    public void setText(CharacterIterator newText) {
        addTaint(newText.getTaint());
        StringBuilder sb = new StringBuilder();
for(char c = newText.first();c != CharacterIterator.DONE;c = newText.next())
        {
            sb.append(c);
        } //End block
        setText(sb.toString(), newText);
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //for (char c = newText.first(); c != CharacterIterator.DONE; c = newText.next()) {
            //sb.append(c);
        //}
        //setText(sb.toString(), newText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.693 -0400", hash_original_method = "67F081416AECF904EEC9E927DC093231", hash_generated_method = "632CAEA82ADC164E706623FA284F0A6A")
    public void setText(String newText) {
        addTaint(newText.getTaint());
        setText(newText, new StringCharacterIterator(newText));
        // ---------- Original Method ----------
        //setText(newText, new StringCharacterIterator(newText));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.694 -0400", hash_original_method = "5F9AC84894F083D607B365AEC97D7D28", hash_generated_method = "703E9C5AD734077DBB9A7B9A6C292C13")
    private void setText(String s, CharacterIterator it) {
        addTaint(s.getTaint());
        this.charIter = it;
        setTextImpl(this.address, s);
        // ---------- Original Method ----------
        //this.charIter = it;
        //setTextImpl(this.address, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.694 -0400", hash_original_method = "CA983FC19E9238FC0FEBBD9EADAED98D", hash_generated_method = "0B1B0F92E449D017C5159C3A2A709245")
    public boolean isBoundary(int offset) {
        addTaint(offset);
        boolean varEC21282E4FB03F5E2BA12A3CEF56C619_1615543701 = (isBoundaryImpl(this.address, offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146822282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146822282;
        // ---------- Original Method ----------
        //return isBoundaryImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.694 -0400", hash_original_method = "C0EEB96929CAD1AA71A6080EC44F9C10", hash_generated_method = "0D52093DBF0009EB5FE014B0A89DE120")
    public int preceding(int offset) {
        addTaint(offset);
        int var46156B2A4D7AE5DC695E355219ABB0B9_1601521087 = (precedingImpl(this.address, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004645627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004645627;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.698 -0400", hash_original_field = "6BD7E9E84499E5603B299C3A233B4C92", hash_generated_field = "8F5E3087826950D143F25CF896D3856E")

    private static final int BI_CHAR_INSTANCE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.698 -0400", hash_original_field = "057CFD03C44F6D28A94ABBF832CAD225", hash_generated_field = "5A4B618A89B222F27216AC1D3CFB505B")

    private static final int BI_WORD_INSTANCE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.698 -0400", hash_original_field = "C025976D9ACB5B6B5FD71B22001575FF", hash_generated_field = "C825CA97E025D552BDB49FDD5FC85C28")

    private static final int BI_LINE_INSTANCE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:24.698 -0400", hash_original_field = "1A8AFE673FA90549D5DBF03579CC782A", hash_generated_field = "0CFA201142952E1019C143FD2DDAA92B")

    private static final int BI_SENT_INSTANCE = 4;
}

