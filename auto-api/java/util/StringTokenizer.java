package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StringTokenizer implements Enumeration<Object> {
    private String string;
    private String delimiters;
    private boolean returnDelimiters;
    private int position;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.687 -0400", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "56BF60C7625FE4689766A003CB63F397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.688 -0400", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "E9C211480225C522A34EC9478508A740")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
        dsTaint.addTaint(delimiters);
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.688 -0400", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "A1D128D45BF698050583F09064AB1538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringTokenizer(String string, String delimiters,
            boolean returnDelimiters) {
        dsTaint.addTaint(returnDelimiters);
        dsTaint.addTaint(delimiters);
        dsTaint.addTaint(string);
        {
            this.position = 0;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        // ---------- Original Method ----------
        //if (string != null) {
            //this.string = string;
            //this.delimiters = delimiters;
            //this.returnDelimiters = returnDelimiters;
            //this.position = 0;
        //} else
            //throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.689 -0400", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "44EF754E3E15E0D9EE80ABB1F855A9AD")
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
                    boolean varF959624410E37AE8E04F3D6629840E93_1352111701 = (delimiters.indexOf(string.charAt(i), 0) >= 0);
                    {
                        {
                            inToken = false;
                        } //End block
                    } //End block
                    {
                        inToken = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.690 -0400", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "37D9B2750AC1B3C2E325DF8CDCCB782B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMoreElements() {
        boolean varD6DD5EDA7437B9905500CFBE29944506_2109958813 = (hasMoreTokens());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasMoreTokens();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.690 -0400", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "CD9105EC090D5DABD3C8977C5F2577D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMoreTokens() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int length;
        length = string.length();
        {
            {
                int i;
                i = position;
                {
                    boolean var51C04FE3BD64EB66A94B1ADE79981D5D_955125672 = (delimiters.indexOf(string.charAt(i), 0) == -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.691 -0400", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "4A8FC6AD9081EC0850F9D3575307DDC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object nextElement() {
        Object varABD8305D610545BAEB0C5AE26333E4D0_863111969 = (nextToken());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nextToken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.693 -0400", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "293F37F5BB28BE1D579CEACBD6D579A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextToken() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int i;
        i = position;
        int length;
        length = string.length();
        {
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1576174824 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    String var8137DD5727BF0B9A6C79792B477F29E3_458367342 = (String.valueOf(string.charAt(position++)));
                } //End collapsed parenthetic
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1186796005 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    String var1D99947455954578AD0DF1BE5ABCBBB9_1262429131 = (string.substring(i, position));
                } //End collapsed parenthetic
                String var03FD55E535DFE72AF51AF1F459B1C0A7_124633688 = (string.substring(i));
            } //End block
            {
                boolean var64D6C26CDC470C826C7D5C1E99C29036_2039095030 = (i < length && delimiters.indexOf(string.charAt(i), 0) >= 0);
            } //End collapsed parenthetic
            position = i;
            {
                {
                    boolean var3D48EA53132D147C01AFDEE9DDB55A41_1455915867 = (delimiters.indexOf(string.charAt(position), 0) >= 0);
                    String var1D99947455954578AD0DF1BE5ABCBBB9_2073651455 = (string.substring(i, position));
                } //End collapsed parenthetic
                String var03FD55E535DFE72AF51AF1F459B1C0A7_197178256 = (string.substring(i));
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.693 -0400", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "31A9300830A4EEA930DB94C50F03CA59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextToken(String delims) {
        dsTaint.addTaint(delims);
        String varABD8305D610545BAEB0C5AE26333E4D0_1943549928 = (nextToken());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //this.delimiters = delims;
        //return nextToken();
    }

    
}

