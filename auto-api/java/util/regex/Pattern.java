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
    private String pattern;
    private int flags;
    transient int address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.663 -0400", hash_original_method = "F3225888DE48ADF8B6D1D654970A412C", hash_generated_method = "810170D1087E58E360C10B223BF95877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.664 -0400", hash_original_method = "82136F98856305B5433C94AE9E660844", hash_generated_method = "929256CEF876D0F3F7E3C39BB51FD05D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Matcher matcher(CharSequence input) {
        dsTaint.addTaint(input);
        Matcher varB5FB27FD896513206D6F8BFD480FBF46_478139707 = (new Matcher(this, input));
        return (Matcher)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Matcher(this, input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.664 -0400", hash_original_method = "F7B5873C63BE8AA500AA3CBEE5803928", hash_generated_method = "BF93E31A527CBF145A48C4C3F0BE83EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(CharSequence input, int limit) {
        dsTaint.addTaint(limit);
        dsTaint.addTaint(input);
        String[] var7AA7A539EC7678A4BFBE8BCB900D0B07_183631559 = (Splitter.split(this, pattern, input.toString(), limit));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return Splitter.split(this, pattern, input.toString(), limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.664 -0400", hash_original_method = "B852F916561127A3CF7FAAC0D8165D0A", hash_generated_method = "BB2EAE068760E710BBD80253D2559799")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] split(CharSequence input) {
        dsTaint.addTaint(input);
        String[] var809184E771E915B5C867FEBE4CDD7F45_1562670009 = (split(input, 0));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return split(input, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.664 -0400", hash_original_method = "266BA96807DA041E9813A92F169CCF9C", hash_generated_method = "0CBF99D1EFF4F3179E8CCCA4E5B3B429")
    @DSModeled(DSC.SAFE)
    public String pattern() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.664 -0400", hash_original_method = "78D8A2FB7B521C80E554EF489653C471", hash_generated_method = "9A5E696C5262FD6569880517DFC57ED7")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return pattern;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.664 -0400", hash_original_method = "2653DED91010C405DFA7C9A961BBF2C3", hash_generated_method = "D5D7246AE1D42F0969E088A8AC401E7F")
    @DSModeled(DSC.SAFE)
    public int flags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return flags;
    }

    
        public static Pattern compile(String regularExpression, int flags) throws PatternSyntaxException {
        return new Pattern(regularExpression, flags);
    }

    
        public static Pattern compile(String pattern) {
        return new Pattern(pattern, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.665 -0400", hash_original_method = "7197179B856EBAB7792F85CCE5015D4A", hash_generated_method = "E0A8831009232F0F9F24AEE4856A5F76")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.665 -0400", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "268F081DD9CF1446BB7E8CE24D74FE6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.666 -0400", hash_original_method = "53B6DF024185B8C2D6E69EA267F8FA46", hash_generated_method = "26B0ED4AA1FBAF4B9119921B2D0B3D6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        compile();
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //compile();
    }

    
        private static void closeImpl(int addr) {
    }

    
        private static int compileImpl(String regex, int flags) {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static final long serialVersionUID = 5073258162644648461L;
    public static final int UNIX_LINES = 0x01;
    public static final int CASE_INSENSITIVE = 0x02;
    public static final int COMMENTS = 0x04;
    public static final int MULTILINE = 0x08;
    public static final int LITERAL = 0x10;
    public static final int DOTALL = 0x20;
    public static final int UNICODE_CASE = 0x40;
    public static final int CANON_EQ = 0x80;
}

