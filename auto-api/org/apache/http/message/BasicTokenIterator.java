package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;

public class BasicTokenIterator implements TokenIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.301 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "EC9D0C260936A48CE3D00DF1B58760FD")

    protected HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.302 -0400", hash_original_field = "8A48FDE5E525D8E0723FE89C04899A8A", hash_generated_field = "7B4E018C3F013525C08A27A13DF71B71")

    protected String currentHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.302 -0400", hash_original_field = "D669CB175EE8F1FF968DF72793C16003", hash_generated_field = "74D8A76D642811495F7C9EB2CC2B1DBE")

    protected String currentToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.302 -0400", hash_original_field = "B2CCF8E31CDFA90F9873152A70561B3B", hash_generated_field = "41CA8C81CB60760B0D4A540CC5B31524")

    protected int searchPos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.302 -0400", hash_original_method = "728241B000D06E5A4B3FF4A1E835CDCC", hash_generated_method = "BD21B7C2E60C9DF6349C443D6D450F5E")
    public  BasicTokenIterator(final HeaderIterator headerIterator) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header iterator must not be null.");
        } 
        this.headerIt = headerIterator;
        this.searchPos = findNext(-1);
        
        
            
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.302 -0400", hash_original_method = "DAB37B2EA98FD1DE22306A8DB0E83A00", hash_generated_method = "D986B4A5DC34406D27D290137D499A66")
    public boolean hasNext() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790327831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790327831;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.303 -0400", hash_original_method = "2D2EFD32F6C702BC7EE07BEBECC92489", hash_generated_method = "080EE7A4CA6EA715159406F19C364331")
    public String nextToken() throws NoSuchElementException, ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_316390915 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException("Iteration already finished.");
        } 
        final String result = this.currentToken;
        this.searchPos = findNext(this.searchPos);
        varB4EAC82CA7396A68D541C85D26508E83_316390915 = result;
        varB4EAC82CA7396A68D541C85D26508E83_316390915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_316390915;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.304 -0400", hash_original_method = "EF0593622B27F345C7E5884D7EB53A09", hash_generated_method = "D36CCE108358A453E22F3B4D00856EE3")
    public final Object next() throws NoSuchElementException, ParseException {
        Object varB4EAC82CA7396A68D541C85D26508E83_739936234 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_739936234 = nextToken();
        varB4EAC82CA7396A68D541C85D26508E83_739936234.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_739936234;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.304 -0400", hash_original_method = "3BA4D5C83A160BCB8FD8E05B9614066A", hash_generated_method = "037448CF857D69C849CA62DE01E88BFD")
    public final void remove() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException
            ("Removing tokens is not supported.");
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.304 -0400", hash_original_method = "32F5FD491C11EBCEB75A9EB408CEB9C9", hash_generated_method = "669FAFAD541BB44F572862447048E1E1")
    protected int findNext(int from) throws ParseException {
        {
            {
                boolean var2ED5D41DAB80F18400A8BF4D761F589A_1757045399 = (!this.headerIt.hasNext());
            } 
            this.currentHeader = this.headerIt.nextHeader().getValue();
            from = 0;
        } 
        {
            from = findTokenSeparator(from);
        } 
        int start = findTokenStart(from);
        {
            this.currentToken = null;
        } 
        int end = findTokenEnd(start);
        this.currentToken = createToken(this.currentHeader, start, end);
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628081905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628081905;
        
        
            
                
            
            
            
        
            
        
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.306 -0400", hash_original_method = "8A7AB715022476147F81646A7190B2B6", hash_generated_method = "984C2F4A7B0EEE18F1BA91EBD84D1DC0")
    protected String createToken(String value, int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_1584074892 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1584074892 = value.substring(start, end);
        addTaint(value.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1584074892.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1584074892;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.307 -0400", hash_original_method = "C3C9B07DEC7C1A6A9535E620A84F019D", hash_generated_method = "648A8BC124D55425D29BF56436907C2E")
    protected int findTokenStart(int from) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Search position must not be negative: " + from);
        } 
        boolean found = false;
        {
            final int to = this.currentHeader.length();
            {
                final char ch = this.currentHeader.charAt(from);
                {
                    boolean var1CFFC2151A0DE523FB3ADD132871A9B5_693058862 = (isTokenSeparator(ch) || isWhitespace(ch));
                    {
                        boolean var6F63D153970F70A4B3084057F7262005_2082851915 = (isTokenChar(this.currentHeader.charAt(from)));
                        {
                            found = true;
                        } 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException
                        ("Invalid character before token (pos " + from +
                         "): " + this.currentHeader);
                        } 
                    } 
                } 
            } 
            {
                {
                    boolean var28CB0FA688573765FA387321488729EB_1235039813 = (this.headerIt.hasNext());
                    {
                        this.currentHeader = this.headerIt.nextHeader().getValue();
                        from = 0;
                    } 
                    {
                        this.currentHeader = null;
                    } 
                } 
            } 
        } 
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_743487266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_743487266;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.307 -0400", hash_original_method = "85E1DE95D8123E292DCFF62F7D93B47F", hash_generated_method = "1C3F28D5F3D33FB540ACE5ACF74B6AF7")
    protected int findTokenSeparator(int from) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Search position must not be negative: " + from);
        } 
        boolean found = false;
        final int to = this.currentHeader.length();
        {
            final char ch = this.currentHeader.charAt(from);
            {
                boolean var3446E97B69F01D5EE66A5892B24698C7_568577421 = (isTokenSeparator(ch));
                {
                    found = true;
                } 
                {
                    boolean var24E73B081FAA1F3638302F7B0430AE99_941989451 = (isWhitespace(ch));
                    {
                        boolean var071CCC5723544444075BA17AB0B5D484_137833571 = (isTokenChar(ch));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException
                    ("Tokens without separator (pos " + from +
                     "): " + this.currentHeader);
                        } 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ParseException
                    ("Invalid character after token (pos " + from +
                     "): " + this.currentHeader);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009004348 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009004348;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.308 -0400", hash_original_method = "ED818B78DD519794D8AD6912C0355074", hash_generated_method = "8DFCE8B8EDD9343C335B28130E5F7BA3")
    protected int findTokenEnd(int from) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Token start position must not be negative: " + from);
        } 
        final int to = this.currentHeader.length();
        int end = from+1;
        {
            boolean var7712AE26A406C9569CD551B48EA985FD_321669988 = ((end < to) && isTokenChar(this.currentHeader.charAt(end)));
        } 
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933582575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1933582575;
        
        
            
                
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.308 -0400", hash_original_method = "82ADC719B633E23931D943624F51E118", hash_generated_method = "11AD3A0DD9309668D38BA46762D14790")
    protected boolean isTokenSeparator(char ch) {
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251882041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_251882041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.308 -0400", hash_original_method = "C3B308F031251D57A69A78A18E46CB9C", hash_generated_method = "C0063BEF8D9A652C3476C79267E4FD1A")
    protected boolean isWhitespace(char ch) {
        boolean var8719D6B137540C1E7A3C19DC6567EB7D_1660527016 = (((ch == '\t') || Character.isSpaceChar(ch)));
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509801288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509801288;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.309 -0400", hash_original_method = "776CFF97F037037124FC98CDEBC144D9", hash_generated_method = "6B94A7333ADC9CB5539A02E4AAD5C423")
    protected boolean isTokenChar(char ch) {
        {
            boolean varBCA8C5ED5D4BB726319B13FC9A89C314_2103050740 = (Character.isLetterOrDigit(ch));
        } 
        {
            boolean varC940A6D7CCFAACAA9FBD978001FC2F57_1800408592 = (Character.isISOControl(ch));
        } 
        {
            boolean var966F8668D114AAF75212C7F4B98183C4_2147204409 = (isHttpSeparator(ch));
        } 
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785765167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785765167;
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.309 -0400", hash_original_method = "8ABD66F1955A5164E5EB5D68E76EE993", hash_generated_method = "EB13CF18B54D5E7071D36C90C8270276")
    protected boolean isHttpSeparator(char ch) {
        boolean varA864A68687971D97FD6C89CDBAC47E21_6468720 = ((HTTP_SEPARATORS.indexOf(ch) >= 0));
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80314247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_80314247;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.309 -0400", hash_original_field = "5FFFA8EDDAC6A93901241670E3BF8737", hash_generated_field = "802E3896B75225C251D59A8EE5A9E545")

    public final static String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
}

