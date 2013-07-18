package libcore.icu;

// Droidsafe Imports
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public final class NativeBreakIterator implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.958 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.958 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.959 -0400", hash_original_field = "92442F743DC6BA830150769D757D3D4B", hash_generated_field = "24EE663A8B6FD47BBC471ECC500F93AB")

    private CharacterIterator charIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.960 -0400", hash_original_method = "9ED5AD4E2E4E4D0EFB32A4F0D669C323", hash_generated_method = "98E6F9885885A27CBEB93ABA0757BDC5")
    private  NativeBreakIterator(int address, int type) {
        this.address = address;
        this.type = type;
        this.charIter = new StringCharacterIterator("");
        // ---------- Original Method ----------
        //this.address = address;
        //this.type = type;
        //this.charIter = new StringCharacterIterator("");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.961 -0400", hash_original_method = "E8D9FE5FD19A07CF96575F06CB3EDCC6", hash_generated_method = "41F4221F4381A979E36022ACD0335D33")
    @Override
    public Object clone() {
        int cloneAddr = cloneImpl(this.address);
        NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        clone.charIter = this.charIter;
Object var3DE52045BFD3C1BF3742F994ED6139AD_2068761953 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_2068761953.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_2068761953;
        // ---------- Original Method ----------
        //int cloneAddr = cloneImpl(this.address);
        //NativeBreakIterator clone = new NativeBreakIterator(cloneAddr, this.type);
        //clone.charIter = this.charIter;
        //return clone;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.962 -0400", hash_original_method = "C0D37969DD3FDF8DABA3E38E17F8673F", hash_generated_method = "DC74D49008F80A26D2255F3445082828")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1554784603 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393095728 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_393095728;
        } //End block
        if(!(object instanceof NativeBreakIterator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1144964488 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479697631 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_479697631;
        } //End block
        NativeBreakIterator rhs = (NativeBreakIterator) object;
        boolean var37E8B39BA54D73CFF1F7A0DAE6792D6D_1265849737 = (type == rhs.type && charIter.equals(rhs.charIter));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466780231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_466780231;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.963 -0400", hash_original_method = "F98DCBD8FE8A6074B159B4049EE2DA7B", hash_generated_method = "C956E23DB6DFAE5CB0A1F93C8C38FD27")
    @Override
    public int hashCode() {
        int varA1D0C6E83F027327D8461063F4AC58A6_528614128 = (42);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336083728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336083728;
        // ---------- Original Method ----------
        //return 42;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.963 -0400", hash_original_method = "208EB0EBF488A5AB652AF86235D70FBD", hash_generated_method = "4840C7CD141C8487FE191FCFD53D4997")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.963 -0400", hash_original_method = "2391C371CA23DB69D751D73221932202", hash_generated_method = "57C6F1F7F4295D3788C68BE02F789D1B")
    public int current() {
        int var918887072051471D15DCE9865E176C01_1303163102 = (currentImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344009823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344009823;
        // ---------- Original Method ----------
        //return currentImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.964 -0400", hash_original_method = "1A13813B2C0D0FA0A609E46FE8D7DFD7", hash_generated_method = "AE5A440883069985E72139A868BD6A96")
    public int first() {
        int var2B7B35FE78989FE062EE33A3B222E26C_20507496 = (firstImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257839125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257839125;
        // ---------- Original Method ----------
        //return firstImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.964 -0400", hash_original_method = "C67E0BB38B934A66B534DF84C290EF97", hash_generated_method = "696B7F9A8DEB0CA0D3B98DB5F85FE14F")
    public int following(int offset) {
        addTaint(offset);
        int varCFC14FC5A7DCCE330CE97C10978BBD6B_1364159986 = (followingImpl(this.address, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562646256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1562646256;
        // ---------- Original Method ----------
        //return followingImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.964 -0400", hash_original_method = "9A8EEEA70A76B239B3603BC6AAF004E0", hash_generated_method = "BE7EF5ACC9329C84CA0BDCEFCAE6732C")
    public CharacterIterator getText() {
        int newLoc = currentImpl(this.address);
        this.charIter.setIndex(newLoc);
CharacterIterator var1C13B7121FF8DBF33774D26964F8457C_598191397 =         this.charIter;
        var1C13B7121FF8DBF33774D26964F8457C_598191397.addTaint(taint);
        return var1C13B7121FF8DBF33774D26964F8457C_598191397;
        // ---------- Original Method ----------
        //int newLoc = currentImpl(this.address);
        //this.charIter.setIndex(newLoc);
        //return this.charIter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.965 -0400", hash_original_method = "4EDF3F20F64FE6397882DD52BEA1A135", hash_generated_method = "107F0196AEE63BD91519732AB3FD0E74")
    public int last() {
        int varF61548759BDDE99A63FE59E0BE1519B9_2043753796 = (lastImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653982038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653982038;
        // ---------- Original Method ----------
        //return lastImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.965 -0400", hash_original_method = "E523A5922365CD35E7F7E6CDEBFA4659", hash_generated_method = "CD62214EDCDAC78577B2F8533F5FFB59")
    public int next(int n) {
        addTaint(n);
        int var17D3555F444C6B069FD374E00F7DC161_650090713 = (nextImpl(this.address, n));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367015771 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367015771;
        // ---------- Original Method ----------
        //return nextImpl(this.address, n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.965 -0400", hash_original_method = "7AAEC5B08F789B8C43B6E5E5CF95D955", hash_generated_method = "E80BA5CFADAC420EECA630431403295C")
    public int next() {
        int varC6EC4558C17C1F79E2A9D21289D5AE12_1223800669 = (nextImpl(this.address, 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091813934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2091813934;
        // ---------- Original Method ----------
        //return nextImpl(this.address, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.965 -0400", hash_original_method = "22FF5B0E4F3FECAD90665D7BA35C8F29", hash_generated_method = "36F76E07FF609F25DE1E91D8DD14BEB5")
    public int previous() {
        int var875938D14B97DC4FE8028C1873FCE670_991452829 = (previousImpl(this.address));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060411036 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060411036;
        // ---------- Original Method ----------
        //return previousImpl(this.address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.966 -0400", hash_original_method = "45B89ED28696EBB5A7E263628F907361", hash_generated_method = "351F0363933D30AD934472E4095390C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.966 -0400", hash_original_method = "67F081416AECF904EEC9E927DC093231", hash_generated_method = "632CAEA82ADC164E706623FA284F0A6A")
    public void setText(String newText) {
        addTaint(newText.getTaint());
        setText(newText, new StringCharacterIterator(newText));
        // ---------- Original Method ----------
        //setText(newText, new StringCharacterIterator(newText));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.967 -0400", hash_original_method = "5F9AC84894F083D607B365AEC97D7D28", hash_generated_method = "703E9C5AD734077DBB9A7B9A6C292C13")
    private void setText(String s, CharacterIterator it) {
        addTaint(s.getTaint());
        this.charIter = it;
        setTextImpl(this.address, s);
        // ---------- Original Method ----------
        //this.charIter = it;
        //setTextImpl(this.address, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.967 -0400", hash_original_method = "CA983FC19E9238FC0FEBBD9EADAED98D", hash_generated_method = "4D3F8696DAB80C2640B6363D670C6AA5")
    public boolean isBoundary(int offset) {
        addTaint(offset);
        boolean varEC21282E4FB03F5E2BA12A3CEF56C619_2065057970 = (isBoundaryImpl(this.address, offset));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399685630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_399685630;
        // ---------- Original Method ----------
        //return isBoundaryImpl(this.address, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.968 -0400", hash_original_method = "C0EEB96929CAD1AA71A6080EC44F9C10", hash_generated_method = "235B4AE0F9F1FEE29E2A9C1BD9C26B45")
    public int preceding(int offset) {
        addTaint(offset);
        int var46156B2A4D7AE5DC695E355219ABB0B9_542181641 = (precedingImpl(this.address, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073549986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073549986;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.970 -0400", hash_original_field = "6BD7E9E84499E5603B299C3A233B4C92", hash_generated_field = "8F5E3087826950D143F25CF896D3856E")

    private static final int BI_CHAR_INSTANCE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.970 -0400", hash_original_field = "057CFD03C44F6D28A94ABBF832CAD225", hash_generated_field = "5A4B618A89B222F27216AC1D3CFB505B")

    private static final int BI_WORD_INSTANCE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.970 -0400", hash_original_field = "C025976D9ACB5B6B5FD71B22001575FF", hash_generated_field = "C825CA97E025D552BDB49FDD5FC85C28")

    private static final int BI_LINE_INSTANCE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.970 -0400", hash_original_field = "1A8AFE673FA90549D5DBF03579CC782A", hash_generated_field = "0CFA201142952E1019C143FD2DDAA92B")

    private static final int BI_SENT_INSTANCE = 4;
}

