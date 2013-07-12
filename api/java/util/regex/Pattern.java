package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class Pattern implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.332 -0400", hash_original_field = "240BF022E685B0EE30AD9FE9E1FB5D5B", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private String pattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.332 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.332 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "837A3237EDA74EDFA4F880469076F652")

    transient int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.333 -0400", hash_original_method = "F3225888DE48ADF8B6D1D654970A412C", hash_generated_method = "A8DABE650B74D081B38E6086E18BED65")
    private  Pattern(String pattern, int flags) throws PatternSyntaxException {
    if((flags & CANON_EQ) != 0)        
        {
            UnsupportedOperationException var0C1EE99045D2ED88D7B5983DECB376A6_1359009268 = new UnsupportedOperationException("CANON_EQ flag not supported");
            var0C1EE99045D2ED88D7B5983DECB376A6_1359009268.addTaint(taint);
            throw var0C1EE99045D2ED88D7B5983DECB376A6_1359009268;
        } //End block
        this.pattern = pattern;
        this.flags = flags;
        compile();
        // ---------- Original Method ----------
        //if ((flags & CANON_EQ) != 0) {
            //throw new UnsupportedOperationException("CANON_EQ flag not supported");
        //}
        //this.pattern = pattern;
        //this.flags = flags;
        //compile();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.334 -0400", hash_original_method = "82136F98856305B5433C94AE9E660844", hash_generated_method = "884716411772CB65E2A9A256CFB185F7")
    public Matcher matcher(CharSequence input) {
        addTaint(input.getTaint());
Matcher varD1372509FE38FF2A9B5E257205866CB3_629218918 =         new Matcher(this, input);
        varD1372509FE38FF2A9B5E257205866CB3_629218918.addTaint(taint);
        return varD1372509FE38FF2A9B5E257205866CB3_629218918;
        // ---------- Original Method ----------
        //return new Matcher(this, input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.334 -0400", hash_original_method = "F7B5873C63BE8AA500AA3CBEE5803928", hash_generated_method = "7C33F5602336960F305E7AC9A45B551D")
    public String[] split(CharSequence input, int limit) {
        addTaint(limit);
        addTaint(input.getTaint());
String[] var9C342D26374583C2D7F298CE387686FA_527697099 =         Splitter.split(this, pattern, input.toString(), limit);
        var9C342D26374583C2D7F298CE387686FA_527697099.addTaint(taint);
        return var9C342D26374583C2D7F298CE387686FA_527697099;
        // ---------- Original Method ----------
        //return Splitter.split(this, pattern, input.toString(), limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.335 -0400", hash_original_method = "B852F916561127A3CF7FAAC0D8165D0A", hash_generated_method = "F4E6DCBA22A5E43D88E44E3C15C28848")
    public String[] split(CharSequence input) {
        addTaint(input.getTaint());
String[] varF1D84C9BE10FAF82BDD8C524A41262B8_264546613 =         split(input, 0);
        varF1D84C9BE10FAF82BDD8C524A41262B8_264546613.addTaint(taint);
        return varF1D84C9BE10FAF82BDD8C524A41262B8_264546613;
        // ---------- Original Method ----------
        //return split(input, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.335 -0400", hash_original_method = "266BA96807DA041E9813A92F169CCF9C", hash_generated_method = "B08C92654B10B17D2429D349AF00A2D6")
    public String pattern() {
String var407D32260E541B695CF3FD3F7EFB76AB_1103796651 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_1103796651.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_1103796651;
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.335 -0400", hash_original_method = "78D8A2FB7B521C80E554EF489653C471", hash_generated_method = "CEDE60D5BF35D10BA805F074AB82539C")
    @Override
    public String toString() {
String var407D32260E541B695CF3FD3F7EFB76AB_48024340 =         pattern;
        var407D32260E541B695CF3FD3F7EFB76AB_48024340.addTaint(taint);
        return var407D32260E541B695CF3FD3F7EFB76AB_48024340;
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.336 -0400", hash_original_method = "2653DED91010C405DFA7C9A961BBF2C3", hash_generated_method = "2F00716E950BBEE7F33744D47DD1D57D")
    public int flags() {
        int var4E5868D676CB634AA75B125A0F741ABF_1902695880 = (flags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017908437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017908437;
        // ---------- Original Method ----------
        //return flags;
    }

    
        public static Pattern compile(String regularExpression, int flags) throws PatternSyntaxException {
        return new Pattern(regularExpression, flags);
    }

    
        public static Pattern compile(String pattern) {
        return new Pattern(pattern, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.337 -0400", hash_original_method = "7197179B856EBAB7792F85CCE5015D4A", hash_generated_method = "E3BFA4C6BC77776F918211B056CD3E02")
    private void compile() throws PatternSyntaxException {
    if(pattern == null)        
        {
            NullPointerException var91D96D5499E736B468B6817110062D6E_558732852 = new NullPointerException("pattern == null");
            var91D96D5499E736B468B6817110062D6E_558732852.addTaint(taint);
            throw var91D96D5499E736B468B6817110062D6E_558732852;
        } //End block
        String icuPattern = pattern;
    if((flags & LITERAL) != 0)        
        {
            icuPattern = quote(pattern);
        } //End block
        int icuFlags = flags & (CASE_INSENSITIVE | COMMENTS | MULTILINE | DOTALL | UNIX_LINES);
        address = compileImpl(icuPattern, icuFlags);
        // ---------- Original Method ----------
        //if (pattern == null) {
            //throw new NullPointerException("pattern == null");
        //}
        //String icuPattern = pattern;
        //if ((flags & LITERAL) != 0) {
            //icuPattern = quote(pattern);
        //}
        //int icuFlags = flags & (CASE_INSENSITIVE | COMMENTS | MULTILINE | DOTALL | UNIX_LINES);
        //address = compileImpl(icuPattern, icuFlags);
    }

    
        public static boolean matches(String regularExpression, CharSequence input) {
        return new Matcher(new Pattern(regularExpression, 0), input).matches();
    }

    
        public static String quote(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\Q");
        int apos = 0;
        int k;
        while ((k = string.indexOf("\\E", apos)) >= 0) {
            sb.append(string.substring(apos, k + 2)).append("\\\\E\\Q");
            apos = k + 2;
        }
        return sb.append(string.substring(apos)).append("\\E").toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.338 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "268F081DD9CF1446BB7E8CE24D74FE6E")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            closeImpl(address);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //closeImpl(address);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.338 -0400", hash_original_method = "53B6DF024185B8C2D6E69EA267F8FA46", hash_generated_method = "FC842B9FDB03AC6B69A2D0DF517F3C08")
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        addTaint(s.getTaint());
        s.defaultReadObject();
        compile();
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //compile();
    }

    
    @DSModeled(DSC.SAFE)
    private static void closeImpl(int addr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int compileImpl(String regex, int flags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "7EEB5D00B8A14C9233F0507FC43BA0C2", hash_generated_field = "89AAD938CC344AC32E4A8CD5D4DF86F6")

    private static final long serialVersionUID = 5073258162644648461L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "A3E7E02B07D3BBC90C1F95CE6EF9B040", hash_generated_field = "F6F493319E476C50F27832143F659D81")

    public static final int UNIX_LINES = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "FFDD3F8D8EB9981652E2D5A89812D29C", hash_generated_field = "60FD4E252AB372E1CF2E8086A13086A7")

    public static final int CASE_INSENSITIVE = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "2445F1FCDB71D3DD125517DB25D0AB58", hash_generated_field = "BC52C5452B22EB80FA6F1B6D6AB60466")

    public static final int COMMENTS = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "AF2B8E06D874BB8307805B4E48A12541", hash_generated_field = "C887CB44F5482B57F958812A8E704C6B")

    public static final int MULTILINE = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "EC5847FA222E21AA79F6FC749DF6B600", hash_generated_field = "0059CEB2E7FDFB976BF18743C74D0C30")

    public static final int LITERAL = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "0AA76A7A1AFB223069FD3224E63965ED", hash_generated_field = "C3C5A9C94AED77D6EDA7C1E3D3ABFFF8")

    public static final int DOTALL = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "351108F2A0CDD42AB8BA59ED3AFC518C", hash_generated_field = "268D1E6E79C1B435EF2D8E59BC94F66D")

    public static final int UNICODE_CASE = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.339 -0400", hash_original_field = "C22793FF1364E3056A176A3F13363B5C", hash_generated_field = "BF4401BCE687E6749EB42AF0574D67ED")

    public static final int CANON_EQ = 0x80;
}

