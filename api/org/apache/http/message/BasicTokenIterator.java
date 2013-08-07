package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;

public class BasicTokenIterator implements TokenIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.275 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "EC9D0C260936A48CE3D00DF1B58760FD")

    protected HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.277 -0400", hash_original_field = "8A48FDE5E525D8E0723FE89C04899A8A", hash_generated_field = "7B4E018C3F013525C08A27A13DF71B71")

    protected String currentHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.278 -0400", hash_original_field = "D669CB175EE8F1FF968DF72793C16003", hash_generated_field = "74D8A76D642811495F7C9EB2CC2B1DBE")

    protected String currentToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.278 -0400", hash_original_field = "B2CCF8E31CDFA90F9873152A70561B3B", hash_generated_field = "41CA8C81CB60760B0D4A540CC5B31524")

    protected int searchPos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.283 -0400", hash_original_method = "728241B000D06E5A4B3FF4A1E835CDCC", hash_generated_method = "94820959A691C675E3B40D23581CEF19")
    public  BasicTokenIterator(final HeaderIterator headerIterator) {
        if(headerIterator == null)        
        {
            IllegalArgumentException var7DF460ACC625D606A2CEDF16D44D1646_798913793 = new IllegalArgumentException
                ("Header iterator must not be null.");
            var7DF460ACC625D606A2CEDF16D44D1646_798913793.addTaint(taint);
            throw var7DF460ACC625D606A2CEDF16D44D1646_798913793;
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

    
    @DSModeled(DSC.SAFE)
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @Override
	public String nextToken() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return new Object();
	}

    
    @Override
	public void remove() {
		// TODO Auto-generated method stub
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.304 -0400", hash_original_method = "32F5FD491C11EBCEB75A9EB408CEB9C9", hash_generated_method = "ACD3BBE7ACC7EFEC25ED082DEF9C0E74")
    protected int findNext(int from) throws ParseException {
        addTaint(from);
        if(from < 0)        
        {
            if(!this.headerIt.hasNext())            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2093295820 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482349534 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482349534;
            } //End block
            this.currentHeader = this.headerIt.nextHeader().getValue();
            from = 0;
        } //End block
        else
        {
            from = findTokenSeparator(from);
        } //End block
        int start = findTokenStart(from);
        if(start < 0)        
        {
            this.currentToken = null;
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1943178044 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269675205 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269675205;
        } //End block
        int end = findTokenEnd(start);
        this.currentToken = createToken(this.currentHeader, start, end);
        int var7F021A1415B86F2D013B2618FB31AE53_485249396 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541160244 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541160244;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.308 -0400", hash_original_method = "8A7AB715022476147F81646A7190B2B6", hash_generated_method = "AE5F87E74E38FB39504518776B34183C")
    protected String createToken(String value, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(value.getTaint());
String var6D1AD31619F0A44155D98F0B7B4EEE63_1194180939 =         value.substring(start, end);
        var6D1AD31619F0A44155D98F0B7B4EEE63_1194180939.addTaint(taint);
        return var6D1AD31619F0A44155D98F0B7B4EEE63_1194180939;
        // ---------- Original Method ----------
        //return value.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.316 -0400", hash_original_method = "C3C9B07DEC7C1A6A9535E620A84F019D", hash_generated_method = "2B0EB76265BBFADC27CCBA5AA3E70228")
    protected int findTokenStart(int from) {
        addTaint(from);
        if(from < 0)        
        {
            IllegalArgumentException varE67816026124B737FE00C0674250C1B6_67166393 = new IllegalArgumentException
                ("Search position must not be negative: " + from);
            varE67816026124B737FE00C0674250C1B6_67166393.addTaint(taint);
            throw varE67816026124B737FE00C0674250C1B6_67166393;
        } //End block
        boolean found = false;
        while
(!found && (this.currentHeader != null))        
        {
            final int to = this.currentHeader.length();
            while
(!found && (from < to))            
            {
                final char ch = this.currentHeader.charAt(from);
                if(isTokenSeparator(ch) || isWhitespace(ch))                
                {
                    from++;
                } //End block
                else
                if(isTokenChar(this.currentHeader.charAt(from)))                
                {
                    found = true;
                } //End block
                else
                {
                    ParseException varA8030CC569E7A8CB5F552D188C3E0720_791457672 = new ParseException
                        ("Invalid character before token (pos " + from +
                         "): " + this.currentHeader);
                    varA8030CC569E7A8CB5F552D188C3E0720_791457672.addTaint(taint);
                    throw varA8030CC569E7A8CB5F552D188C3E0720_791457672;
                } //End block
            } //End block
            if(!found)            
            {
                if(this.headerIt.hasNext())                
                {
                    this.currentHeader = this.headerIt.nextHeader().getValue();
                    from = 0;
                } //End block
                else
                {
                    this.currentHeader = null;
                } //End block
            } //End block
        } //End block
        int var30BEC673AA85928644B576FD1EBDB4A9_1349533818 = (found ? from : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651225657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651225657;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.323 -0400", hash_original_method = "85E1DE95D8123E292DCFF62F7D93B47F", hash_generated_method = "3E2B88A7DC52744EE11CD405168482C6")
    protected int findTokenSeparator(int from) {
        addTaint(from);
        if(from < 0)        
        {
            IllegalArgumentException varE67816026124B737FE00C0674250C1B6_1605867232 = new IllegalArgumentException
                ("Search position must not be negative: " + from);
            varE67816026124B737FE00C0674250C1B6_1605867232.addTaint(taint);
            throw varE67816026124B737FE00C0674250C1B6_1605867232;
        } //End block
        boolean found = false;
        final int to = this.currentHeader.length();
        while
(!found && (from < to))        
        {
            final char ch = this.currentHeader.charAt(from);
            if(isTokenSeparator(ch))            
            {
                found = true;
            } //End block
            else
            if(isWhitespace(ch))            
            {
                from++;
            } //End block
            else
            if(isTokenChar(ch))            
            {
                ParseException varEA490B7121C4EAA91DF759C9DBD7A5E2_35738325 = new ParseException
                    ("Tokens without separator (pos " + from +
                     "): " + this.currentHeader);
                varEA490B7121C4EAA91DF759C9DBD7A5E2_35738325.addTaint(taint);
                throw varEA490B7121C4EAA91DF759C9DBD7A5E2_35738325;
            } //End block
            else
            {
                ParseException varE0E763A9CA040A12DD639AF228B6984D_493162471 = new ParseException
                    ("Invalid character after token (pos " + from +
                     "): " + this.currentHeader);
                varE0E763A9CA040A12DD639AF228B6984D_493162471.addTaint(taint);
                throw varE0E763A9CA040A12DD639AF228B6984D_493162471;
            } //End block
        } //End block
        int varD98A07F84921B24EE30F86FD8CD85C3C_47713200 = (from);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037078406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2037078406;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.327 -0400", hash_original_method = "ED818B78DD519794D8AD6912C0355074", hash_generated_method = "E1773E5AD761E7F9E1DE869ED70A84A8")
    protected int findTokenEnd(int from) {
        addTaint(from);
        if(from < 0)        
        {
            IllegalArgumentException varA6DC0764CC986C425F6C0F9B12A0AD34_378528953 = new IllegalArgumentException
                ("Token start position must not be negative: " + from);
            varA6DC0764CC986C425F6C0F9B12A0AD34_378528953.addTaint(taint);
            throw varA6DC0764CC986C425F6C0F9B12A0AD34_378528953;
        } //End block
        final int to = this.currentHeader.length();
        int end = from+1;
        while
((end < to) && isTokenChar(this.currentHeader.charAt(end)))        
        {
            end++;
        } //End block
        int var7F021A1415B86F2D013B2618FB31AE53_1891675709 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325882086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325882086;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.329 -0400", hash_original_method = "82ADC719B633E23931D943624F51E118", hash_generated_method = "7A1889AF4D781C456CB0D8D8B999EA2C")
    protected boolean isTokenSeparator(char ch) {
        addTaint(ch);
        boolean var618CE8E35889B64AFA0E42D547797C4D_773462267 = ((ch == ','));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753766851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753766851;
        // ---------- Original Method ----------
        //return (ch == ',');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.345 -0400", hash_original_method = "C3B308F031251D57A69A78A18E46CB9C", hash_generated_method = "260688C908EC822742EC99D620A890DC")
    protected boolean isWhitespace(char ch) {
        addTaint(ch);
        boolean var19DF6487BAD8F89596CAC8516F2A5CC2_1492814622 = (((ch == '\t') || Character.isSpaceChar(ch)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016832266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016832266;
        // ---------- Original Method ----------
        //return ((ch == '\t') || Character.isSpaceChar(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.349 -0400", hash_original_method = "776CFF97F037037124FC98CDEBC144D9", hash_generated_method = "EF3B56DE16B96D936F2C2EEAD5364928")
    protected boolean isTokenChar(char ch) {
        addTaint(ch);
        if(Character.isLetterOrDigit(ch))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1691487173 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113171608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113171608;
        }
        if(Character.isISOControl(ch))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1381286253 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047142756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047142756;
        }
        if(isHttpSeparator(ch))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1215604239 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226132946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226132946;
        }
        boolean varB326B5062B2F0E69046810717534CB09_1940926952 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776727406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776727406;
        // ---------- Original Method ----------
        //if (Character.isLetterOrDigit(ch))
            //return true;
        //if (Character.isISOControl(ch))
            //return false;
        //if (isHttpSeparator(ch))
            //return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.351 -0400", hash_original_method = "8ABD66F1955A5164E5EB5D68E76EE993", hash_generated_method = "A2D366A41F07B813CEE697FC3C5D8F08")
    protected boolean isHttpSeparator(char ch) {
        addTaint(ch);
        boolean var05603C57C93F34A5B16428FA2E84075F_385974771 = ((HTTP_SEPARATORS.indexOf(ch) >= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130464650 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130464650;
        // ---------- Original Method ----------
        //return (HTTP_SEPARATORS.indexOf(ch) >= 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.352 -0400", hash_original_field = "5FFFA8EDDAC6A93901241670E3BF8737", hash_generated_field = "802E3896B75225C251D59A8EE5A9E545")

    public final static String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
}

