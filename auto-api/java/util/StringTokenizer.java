package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class StringTokenizer implements Enumeration<Object> {
    private String string;
    private String delimiters;
    private boolean returnDelimiters;
    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.177 -0400", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "9CD7DA3A3C146DE7C9B296B71D7575BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.177 -0400", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "5A899D0C27BFC0C102A52E0196D1E23B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
        dsTaint.addTaint(delimiters);
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.177 -0400", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "CFC3CF1E3D996F9985D9EA3FD7FBECB8")
    @DSModeled(DSC.SAFE)
    public StringTokenizer(String string, String delimiters,
            boolean returnDelimiters) {
        dsTaint.addTaint(returnDelimiters);
        dsTaint.addTaint(delimiters);
        dsTaint.addTaint(string);
        {
            this.position = 0;
        } //End block
        throw new NullPointerException();
        // ---------- Original Method ----------
        //if (string != null) {
            //this.string = string;
            //this.delimiters = delimiters;
            //this.returnDelimiters = returnDelimiters;
            //this.position = 0;
        //} else
            //throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.177 -0400", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "1E988C11D9719799E38F753E9A81AAA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int countTokens() {
        int count;
        count = 0;
        boolean inToken;
        inToken = false;
        {
            int i, length;
            i = position;
            length = string.length();
            {
                {
                    boolean varF959624410E37AE8E04F3D6629840E93_373789435 = (delimiters.indexOf(string.charAt(i), 0) >= 0);
                    {
                        count++;
                        {
                            count++;
                            inToken = false;
                        } //End block
                    } //End block
                    {
                        inToken = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        count++;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = 0;
        //boolean inToken = false;
        //for (int i = position, length = string.length(); i < length; i++) {
            //if (delimiters.indexOf(string.charAt(i), 0) >= 0) {
                //if (returnDelimiters)
                    //count++;
                //if (inToken) {
                    //count++;
                    //inToken = false;
                //}
            //} else {
                //inToken = true;
            //}
        //}
        //if (inToken)
            //count++;
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.177 -0400", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "E935FE36D20AC3ADB79A009F93BF8844")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMoreElements() {
        boolean varD6DD5EDA7437B9905500CFBE29944506_1877447658 = (hasMoreTokens());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasMoreTokens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.177 -0400", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "D84EF6AFB4C69BE7371E4ACF0D92187A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMoreTokens() {
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        int length;
        length = string.length();
        {
            {
                int i;
                i = position;
                {
                    boolean var51C04FE3BD64EB66A94B1ADE79981D5D_1970802205 = (delimiters.indexOf(string.charAt(i), 0) == -1);
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (delimiters == null) {
            //throw new NullPointerException();
        //}
        //int length = string.length();
        //if (position < length) {
            //if (returnDelimiters)
                //return true; 
            //for (int i = position; i < length; i++)
                //if (delimiters.indexOf(string.charAt(i), 0) == -1)
                    //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.177 -0400", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "5641AE172B4CEB61E985C5BD47948DA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object nextElement() {
        Object varABD8305D610545BAEB0C5AE26333E4D0_355810512 = (nextToken());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nextToken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.178 -0400", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "00A97865477ED21F549E184AE6C55547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextToken() {
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        int i;
        i = position;
        int length;
        length = string.length();
        {
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1896586005 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    String var8137DD5727BF0B9A6C79792B477F29E3_384607838 = (String.valueOf(string.charAt(position++)));
                } //End collapsed parenthetic
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_858864884 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    String var1D99947455954578AD0DF1BE5ABCBBB9_1800794935 = (string.substring(i, position));
                } //End collapsed parenthetic
                String var03FD55E535DFE72AF51AF1F459B1C0A7_613958142 = (string.substring(i));
            } //End block
            {
                boolean var64D6C26CDC470C826C7D5C1E99C29036_388896976 = (i < length && delimiters.indexOf(string.charAt(i), 0) >= 0);
                i++;
            } //End collapsed parenthetic
            position = i;
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1605744664 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    String var1D99947455954578AD0DF1BE5ABCBBB9_248960191 = (string.substring(i, position));
                } //End collapsed parenthetic
                String var03FD55E535DFE72AF51AF1F459B1C0A7_801191075 = (string.substring(i));
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) {
        	throw new NoSuchElementException();
        }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.178 -0400", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "44C91CE7DA69A3C24D35611BB8DE6D54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextToken(String delims) {
        dsTaint.addTaint(delims);
        String varABD8305D610545BAEB0C5AE26333E4D0_1252726192 = (nextToken());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //this.delimiters = delims;
        //return nextToken();
    }

    
}


