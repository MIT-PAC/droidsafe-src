package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class Pattern implements Serializable {
    private static final long serialVersionUID = 5073258162644648461L;
    public static final int UNIX_LINES = 0x01;
    public static final int CASE_INSENSITIVE = 0x02;
    public static final int COMMENTS = 0x04;
    public static final int MULTILINE = 0x08;
    public static final int LITERAL = 0x10;
    public static final int DOTALL = 0x20;
    public static final int UNICODE_CASE = 0x40;
    public static final int CANON_EQ = 0x80;
    private final String pattern;
    private final int flags;
    transient int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "F3225888DE48ADF8B6D1D654970A412C", hash_generated_method = "8B69F7577DAE1E9F0F720B81B23D0215")
    @DSModeled(DSC.SAFE)
    private Pattern(String pattern, int flags) throws PatternSyntaxException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(pattern);
        {
            throw new UnsupportedOperationException("CANON_EQ flag not supported");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "82136F98856305B5433C94AE9E660844", hash_generated_method = "CED5FB025AA1BD9BD356F88EF55BE5AC")
    @DSModeled(DSC.SAFE)
    public Matcher matcher(CharSequence input) {
        dsTaint.addTaint(input);
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Matcher(this, input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "F7B5873C63BE8AA500AA3CBEE5803928", hash_generated_method = "2560EA1453148F4A4AE69ED2D632A371")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(CharSequence input, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(input);
        String[] var7AA7A539EC7678A4BFBE8BCB900D0B07_1240740162 = (Splitter.split(this, pattern, input.toString(), limit));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return Splitter.split(this, pattern, input.toString(), limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "B852F916561127A3CF7FAAC0D8165D0A", hash_generated_method = "FC4104B8E3A8A0B55DCF5E144147666F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(CharSequence input) {
        dsTaint.addTaint(input);
        String[] var809184E771E915B5C867FEBE4CDD7F45_2034623747 = (split(input, 0));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return split(input, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "266BA96807DA041E9813A92F169CCF9C", hash_generated_method = "BF43ABF92777615EDD76D4F9A464B910")
    @DSModeled(DSC.SAFE)
    public String pattern() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "78D8A2FB7B521C80E554EF489653C471", hash_generated_method = "83E043808D1DB03D439FE216652B691D")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "2653DED91010C405DFA7C9A961BBF2C3", hash_generated_method = "9E1DA8B81A04AD378465650AB275E7F6")
    @DSModeled(DSC.SAFE)
    public int flags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "029800E42310A5C751B07B4109A52530", hash_generated_method = "480AB8A4C0BB731089E7125A8D3EDCD6")
    public static Pattern compile(String regularExpression, int flags) throws PatternSyntaxException {
        return new Pattern(regularExpression, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "F247F5CF281C5F9996F6C94B5EA92FED", hash_generated_method = "314F6EA271F181E366513165FAC3D0EC")
    public static Pattern compile(String pattern) {
        return new Pattern(pattern, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "7197179B856EBAB7792F85CCE5015D4A", hash_generated_method = "8F36B1BD9E7E9A4C99FA3D2427903E8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void compile() throws PatternSyntaxException {
        {
            throw new NullPointerException("pattern == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.834 -0400", hash_original_method = "3E791313A82E18EC1ADA7594E9746E1F", hash_generated_method = "A62C31C049A9EDD862B1DBC9F26CF5B2")
    public static boolean matches(String regularExpression, CharSequence input) {
        return new Matcher(new Pattern(regularExpression, 0), input).matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.835 -0400", hash_original_method = "B294BEEA973D4CB6A8EA737C4F56E6F2", hash_generated_method = "91B1AE274685940131731B45422E6FFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.835 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "2423E3A5A529212650FA426A2F677B91")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.835 -0400", hash_original_method = "53B6DF024185B8C2D6E69EA267F8FA46", hash_generated_method = "1BD666E2B6EDF13FE0A5E674873CA64C")
    @DSModeled(DSC.SAFE)
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        compile();
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //compile();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.835 -0400", hash_original_method = "8263343A665FA522ECFED6CB0D912EAE", hash_generated_method = "480897A941524788AA53F14F2C01EA79")
    private static void closeImpl(int addr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.835 -0400", hash_original_method = "A1A14EF44BC9EE14629BD2A8EC1D3CE0", hash_generated_method = "C4AC0D943969198B784E75EE9C72368E")
    private static int compileImpl(String regex, int flags) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


