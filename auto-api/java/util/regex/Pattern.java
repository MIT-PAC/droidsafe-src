package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class Pattern implements Serializable {
    private static long serialVersionUID = 5073258162644648461L;
    public static int UNIX_LINES = 0x01;
    public static int CASE_INSENSITIVE = 0x02;
    public static int COMMENTS = 0x04;
    public static int MULTILINE = 0x08;
    public static int LITERAL = 0x10;
    public static int DOTALL = 0x20;
    public static int UNICODE_CASE = 0x40;
    public static int CANON_EQ = 0x80;
    private String pattern;
    private int flags;
    transient int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.735 -0400", hash_original_method = "F3225888DE48ADF8B6D1D654970A412C", hash_generated_method = "0BF42E92C48CC4161C3E526019EC1A7D")
    @DSModeled(DSC.SAFE)
    private Pattern(String pattern, int flags) throws PatternSyntaxException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(pattern);
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("CANON_EQ flag not supported");
        } //End block
        compile();
        // ---------- Original Method ----------
        //if ((flags & CANON_EQ) != 0) {
            //throw new UnsupportedOperationException("CANON_EQ flag not supported");
        //}
        //this.pattern = pattern;
        //this.flags = flags;
        //compile();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.738 -0400", hash_original_method = "82136F98856305B5433C94AE9E660844", hash_generated_method = "CED5FB025AA1BD9BD356F88EF55BE5AC")
    @DSModeled(DSC.SAFE)
    public Matcher matcher(CharSequence input) {
        dsTaint.addTaint(input);
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Matcher(this, input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.742 -0400", hash_original_method = "F7B5873C63BE8AA500AA3CBEE5803928", hash_generated_method = "8FD15C8E530AF5A5852A6B404050B6B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(CharSequence input, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(input);
        String[] var7AA7A539EC7678A4BFBE8BCB900D0B07_1240445148 = (Splitter.split(this, pattern, input.toString(), limit));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return Splitter.split(this, pattern, input.toString(), limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.745 -0400", hash_original_method = "B852F916561127A3CF7FAAC0D8165D0A", hash_generated_method = "F8916C412DCD6CD5A45EBBFF2A875EEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(CharSequence input) {
        dsTaint.addTaint(input);
        String[] var809184E771E915B5C867FEBE4CDD7F45_330224911 = (split(input, 0));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return split(input, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.747 -0400", hash_original_method = "266BA96807DA041E9813A92F169CCF9C", hash_generated_method = "BF43ABF92777615EDD76D4F9A464B910")
    @DSModeled(DSC.SAFE)
    public String pattern() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.748 -0400", hash_original_method = "78D8A2FB7B521C80E554EF489653C471", hash_generated_method = "83E043808D1DB03D439FE216652B691D")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.750 -0400", hash_original_method = "2653DED91010C405DFA7C9A961BBF2C3", hash_generated_method = "9E1DA8B81A04AD378465650AB275E7F6")
    @DSModeled(DSC.SAFE)
    public int flags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.752 -0400", hash_original_method = "029800E42310A5C751B07B4109A52530", hash_generated_method = "480AB8A4C0BB731089E7125A8D3EDCD6")
    public static Pattern compile(String regularExpression, int flags) throws PatternSyntaxException {
        return new Pattern(regularExpression, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.769 -0400", hash_original_method = "F247F5CF281C5F9996F6C94B5EA92FED", hash_generated_method = "314F6EA271F181E366513165FAC3D0EC")
    public static Pattern compile(String pattern) {
        return new Pattern(pattern, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.773 -0400", hash_original_method = "7197179B856EBAB7792F85CCE5015D4A", hash_generated_method = "6459F55636956EECA12DD9045E6D9716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void compile() throws PatternSyntaxException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("pattern == null");
        } //End block
        String icuPattern;
        icuPattern = pattern;
        {
            icuPattern = quote(pattern);
        } //End block
        int icuFlags;
        icuFlags = flags & (CASE_INSENSITIVE | COMMENTS | MULTILINE | DOTALL | UNIX_LINES);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.776 -0400", hash_original_method = "3E791313A82E18EC1ADA7594E9746E1F", hash_generated_method = "A62C31C049A9EDD862B1DBC9F26CF5B2")
    public static boolean matches(String regularExpression, CharSequence input) {
        return new Matcher(new Pattern(regularExpression, 0), input).matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.778 -0400", hash_original_method = "B294BEEA973D4CB6A8EA737C4F56E6F2", hash_generated_method = "91B1AE274685940131731B45422E6FFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.786 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "2423E3A5A529212650FA426A2F677B91")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.792 -0400", hash_original_method = "53B6DF024185B8C2D6E69EA267F8FA46", hash_generated_method = "1BD666E2B6EDF13FE0A5E674873CA64C")
    @DSModeled(DSC.SAFE)
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        compile();
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //compile();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.794 -0400", hash_original_method = "8263343A665FA522ECFED6CB0D912EAE", hash_generated_method = "B13E0255C323949B5BBE9E38B2F35561")
    private static void closeImpl(int addr) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:35:50.800 -0400", hash_original_method = "A1A14EF44BC9EE14629BD2A8EC1D3CE0", hash_generated_method = "3F087119EC49970C907FDB1A08050533")
    private static int compileImpl(String regex, int flags) {
        return DSUtils.UNKNOWN_INT;
    }

    
}


