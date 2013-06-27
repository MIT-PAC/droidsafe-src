package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;

public class BasicTokenIterator implements TokenIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.115 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "EC9D0C260936A48CE3D00DF1B58760FD")

    protected HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.116 -0400", hash_original_field = "8A48FDE5E525D8E0723FE89C04899A8A", hash_generated_field = "7B4E018C3F013525C08A27A13DF71B71")

    protected String currentHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.116 -0400", hash_original_field = "D669CB175EE8F1FF968DF72793C16003", hash_generated_field = "74D8A76D642811495F7C9EB2CC2B1DBE")

    protected String currentToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.116 -0400", hash_original_field = "B2CCF8E31CDFA90F9873152A70561B3B", hash_generated_field = "41CA8C81CB60760B0D4A540CC5B31524")

    protected int searchPos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.117 -0400", hash_original_method = "728241B000D06E5A4B3FF4A1E835CDCC", hash_generated_method = "BD21B7C2E60C9DF6349C443D6D450F5E")
    public  BasicTokenIterator(final HeaderIterator headerIterator) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header iterator must not be null.");
        } //End block
        this.headerIt = headerIterator;
        this.searchPos = findNext(-1);
        // ---------- Original Method ----------
        //if (headerIterator == null) {
            //throw new IllegalArgumentException
                //("Header iterator must not be null.");
        //}
        //this.headerIt = headerIterator;
        //this.searchPos = findNext(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.117 -0400", hash_original_method = "DAB37B2EA98FD1DE22306A8DB0E83A00", hash_generated_method = "FDA3A8E8EE166CF77EEC0A7681CD8EBA")
    public boolean hasNext() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120613581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120613581;
        // ---------- Original Method ----------
        //return (this.currentToken != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.118 -0400", hash_original_method = "2D2EFD32F6C702BC7EE07BEBECC92489", hash_generated_method = "A18FA4D6234425DA09C85EB632137564")
    public String nextToken() throws NoSuchElementException, ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1358320049 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException("Iteration already finished.");
        } //End block
        String result;
        result = this.currentToken;
        this.searchPos = findNext(this.searchPos);
        varB4EAC82CA7396A68D541C85D26508E83_1358320049 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1358320049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1358320049;
        // ---------- Original Method ----------
        //if (this.currentToken == null) {
            //throw new NoSuchElementException("Iteration already finished.");
        //}
        //final String result = this.currentToken;
        //this.searchPos = findNext(this.searchPos);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.126 -0400", hash_original_method = "EF0593622B27F345C7E5884D7EB53A09", hash_generated_method = "2E85A54D74A0F1BABE8FDE32F0DAEF89")
    public final Object next() throws NoSuchElementException, ParseException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1983622182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1983622182 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_1983622182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1983622182;
        // ---------- Original Method ----------
        //return nextToken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.126 -0400", hash_original_method = "3BA4D5C83A160BCB8FD8E05B9614066A", hash_generated_method = "037448CF857D69C849CA62DE01E88BFD")
    public final void remove() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException
            ("Removing tokens is not supported.");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
            //("Removing tokens is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.127 -0400", hash_original_method = "32F5FD491C11EBCEB75A9EB408CEB9C9", hash_generated_method = "FD08979E0EAFCE397056B60FFACD3E32")
    protected int findNext(int from) throws ParseException {
        {
            {
                boolean var2ED5D41DAB80F18400A8BF4D761F589A_54971176 = (!this.headerIt.hasNext());
            } //End collapsed parenthetic
            this.currentHeader = this.headerIt.nextHeader().getValue();
            from = 0;
        } //End block
        {
            from = findTokenSeparator(from);
        } //End block
        int start;
        start = findTokenStart(from);
        {
            this.currentToken = null;
        } //End block
        int end;
        end = findTokenEnd(start);
        this.currentToken = createToken(this.currentHeader, start, end);
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103260366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103260366;
        // ---------- Original Method ----------
        //if (from < 0) {
            //if (!this.headerIt.hasNext()) {
                //return -1;
            //}
            //this.currentHeader = this.headerIt.nextHeader().getValue();
            //from = 0;
        //} else {
            //from = findTokenSeparator(from);
        //}
        //int start = findTokenStart(from);
        //if (start < 0) {
            //this.currentToken = null;
            //return -1; 
        //}
        //int end = findTokenEnd(start);
        //this.currentToken = createToken(this.currentHeader, start, end);
        //return end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.127 -0400", hash_original_method = "8A7AB715022476147F81646A7190B2B6", hash_generated_method = "25E1A2B4EE25DB4900040796EA895541")
    protected String createToken(String value, int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_1993189546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993189546 = value.substring(start, end);
        addTaint(value.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1993189546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993189546;
        // ---------- Original Method ----------
        //return value.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.137 -0400", hash_original_method = "C3C9B07DEC7C1A6A9535E620A84F019D", hash_generated_method = "E18C6F42624E1DCD5DEFD2B62692A7A0")
    protected int findTokenStart(int from) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Search position must not be negative: " + from);
        } //End block
        boolean found;
        found = false;
        {
            int to;
            to = this.currentHeader.length();
            {
                char ch;
                ch = this.currentHeader.charAt(from);
                {
                    boolean var1CFFC2151A0DE523FB3ADD132871A9B5_760002116 = (isTokenSeparator(ch) || isWhitespace(ch));
                    {
                        boolean var6F63D153970F70A4B3084057F7262005_537433071 = (isTokenChar(this.currentHeader.charAt(from)));
                        {
                            found = true;
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException
                        ("Invalid character before token (pos " + from +
                         "): " + this.currentHeader);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var28CB0FA688573765FA387321488729EB_1175425711 = (this.headerIt.hasNext());
                    {
                        this.currentHeader = this.headerIt.nextHeader().getValue();
                        from = 0;
                    } //End block
                    {
                        this.currentHeader = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577782160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_577782160;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.138 -0400", hash_original_method = "85E1DE95D8123E292DCFF62F7D93B47F", hash_generated_method = "6AD64A797CD787251766D6EBFE8E33EE")
    protected int findTokenSeparator(int from) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Search position must not be negative: " + from);
        } //End block
        boolean found;
        found = false;
        int to;
        to = this.currentHeader.length();
        {
            char ch;
            ch = this.currentHeader.charAt(from);
            {
                boolean var3446E97B69F01D5EE66A5892B24698C7_2063298910 = (isTokenSeparator(ch));
                {
                    found = true;
                } //End block
                {
                    boolean var24E73B081FAA1F3638302F7B0430AE99_388736022 = (isWhitespace(ch));
                    {
                        boolean var071CCC5723544444075BA17AB0B5D484_978883186 = (isTokenChar(ch));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException
                    ("Tokens without separator (pos " + from +
                     "): " + this.currentHeader);
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException
                    ("Invalid character after token (pos " + from +
                     "): " + this.currentHeader);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020236196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2020236196;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.149 -0400", hash_original_method = "ED818B78DD519794D8AD6912C0355074", hash_generated_method = "00F6C32EF73BA1F1C7998F1B83284D3E")
    protected int findTokenEnd(int from) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Token start position must not be negative: " + from);
        } //End block
        int to;
        to = this.currentHeader.length();
        int end;
        end = from+1;
        {
            boolean var7712AE26A406C9569CD551B48EA985FD_1989640354 = ((end < to) && isTokenChar(this.currentHeader.charAt(end)));
        } //End collapsed parenthetic
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4191208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4191208;
        // ---------- Original Method ----------
        //if (from < 0) {
            //throw new IllegalArgumentException
                //("Token start position must not be negative: " + from);
        //}
        //final int to = this.currentHeader.length();
        //int end = from+1;
        //while ((end < to) && isTokenChar(this.currentHeader.charAt(end))) {
            //end++;
        //}
        //return end;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.149 -0400", hash_original_method = "82ADC719B633E23931D943624F51E118", hash_generated_method = "AD51925AD72F8BA96AB7A53D08A52DAA")
    protected boolean isTokenSeparator(char ch) {
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1458023780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1458023780;
        // ---------- Original Method ----------
        //return (ch == ',');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.150 -0400", hash_original_method = "C3B308F031251D57A69A78A18E46CB9C", hash_generated_method = "0E991ED8CB6ADB1FCAE337B685B70D88")
    protected boolean isWhitespace(char ch) {
        boolean var8719D6B137540C1E7A3C19DC6567EB7D_1045651574 = (((ch == '\t') || Character.isSpaceChar(ch)));
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189242388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189242388;
        // ---------- Original Method ----------
        //return ((ch == '\t') || Character.isSpaceChar(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.151 -0400", hash_original_method = "776CFF97F037037124FC98CDEBC144D9", hash_generated_method = "E0A4153B96848C3011BD5A5A0AFA2349")
    protected boolean isTokenChar(char ch) {
        {
            boolean varBCA8C5ED5D4BB726319B13FC9A89C314_984770720 = (Character.isLetterOrDigit(ch));
        } //End collapsed parenthetic
        {
            boolean varC940A6D7CCFAACAA9FBD978001FC2F57_2033244838 = (Character.isISOControl(ch));
        } //End collapsed parenthetic
        {
            boolean var966F8668D114AAF75212C7F4B98183C4_888624271 = (isHttpSeparator(ch));
        } //End collapsed parenthetic
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108623149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108623149;
        // ---------- Original Method ----------
        //if (Character.isLetterOrDigit(ch))
            //return true;
        //if (Character.isISOControl(ch))
            //return false;
        //if (isHttpSeparator(ch))
            //return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.151 -0400", hash_original_method = "8ABD66F1955A5164E5EB5D68E76EE993", hash_generated_method = "F7930CE55D894896DECDEBBFB3322578")
    protected boolean isHttpSeparator(char ch) {
        boolean varA864A68687971D97FD6C89CDBAC47E21_1407929361 = ((HTTP_SEPARATORS.indexOf(ch) >= 0));
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499018567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499018567;
        // ---------- Original Method ----------
        //return (HTTP_SEPARATORS.indexOf(ch) >= 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.151 -0400", hash_original_field = "5FFFA8EDDAC6A93901241670E3BF8737", hash_generated_field = "802E3896B75225C251D59A8EE5A9E545")

    public final static String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
}

