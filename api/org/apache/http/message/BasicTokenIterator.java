package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;

public class BasicTokenIterator implements TokenIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.072 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "EC9D0C260936A48CE3D00DF1B58760FD")

    protected HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.072 -0400", hash_original_field = "8A48FDE5E525D8E0723FE89C04899A8A", hash_generated_field = "7B4E018C3F013525C08A27A13DF71B71")

    protected String currentHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.073 -0400", hash_original_field = "D669CB175EE8F1FF968DF72793C16003", hash_generated_field = "74D8A76D642811495F7C9EB2CC2B1DBE")

    protected String currentToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.073 -0400", hash_original_field = "B2CCF8E31CDFA90F9873152A70561B3B", hash_generated_field = "41CA8C81CB60760B0D4A540CC5B31524")

    protected int searchPos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.073 -0400", hash_original_method = "728241B000D06E5A4B3FF4A1E835CDCC", hash_generated_method = "DA49B71E77954772FAB1BCCA1E75F861")
    public  BasicTokenIterator(final HeaderIterator headerIterator) {
        if(headerIterator == null)        
        {
            IllegalArgumentException var7DF460ACC625D606A2CEDF16D44D1646_796627117 = new IllegalArgumentException
                ("Header iterator must not be null.");
            var7DF460ACC625D606A2CEDF16D44D1646_796627117.addTaint(taint);
            throw var7DF460ACC625D606A2CEDF16D44D1646_796627117;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.073 -0400", hash_original_method = "DAB37B2EA98FD1DE22306A8DB0E83A00", hash_generated_method = "08BB5940E29F2F3B0D2F869976D2666A")
    public boolean hasNext() {
        boolean varF9D1FD9B4069C0625E90F30612866EF5_238606784 = ((this.currentToken != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1142847799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1142847799;
        // ---------- Original Method ----------
        //return (this.currentToken != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.074 -0400", hash_original_method = "2D2EFD32F6C702BC7EE07BEBECC92489", hash_generated_method = "2988ADCF178849232A2AA6D63C98E608")
    public String nextToken() throws NoSuchElementException, ParseException {
        if(this.currentToken == null)        
        {
            NoSuchElementException var987AB9BC96C39424DAD4C83B35F26CD8_1465249332 = new NoSuchElementException("Iteration already finished.");
            var987AB9BC96C39424DAD4C83B35F26CD8_1465249332.addTaint(taint);
            throw var987AB9BC96C39424DAD4C83B35F26CD8_1465249332;
        } //End block
        final String result = this.currentToken;
        this.searchPos = findNext(this.searchPos);
String varDC838461EE2FA0CA4C9BBB70A15456B0_869660410 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_869660410.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_869660410;
        // ---------- Original Method ----------
        //if (this.currentToken == null) {
            //throw new NoSuchElementException("Iteration already finished.");
        //}
        //final String result = this.currentToken;
        //this.searchPos = findNext(this.searchPos);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.074 -0400", hash_original_method = "EF0593622B27F345C7E5884D7EB53A09", hash_generated_method = "F0B03B4FFB089BA687946FA1247A4610")
    public final Object next() throws NoSuchElementException, ParseException {
Object var1E85D5DD28517B6F091CC30DA1235BD1_1127962497 =         nextToken();
        var1E85D5DD28517B6F091CC30DA1235BD1_1127962497.addTaint(taint);
        return var1E85D5DD28517B6F091CC30DA1235BD1_1127962497;
        // ---------- Original Method ----------
        //return nextToken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.075 -0400", hash_original_method = "3BA4D5C83A160BCB8FD8E05B9614066A", hash_generated_method = "0BDCFCADF1CAEF37D9A0B327030B7FF7")
    public final void remove() throws UnsupportedOperationException {
        UnsupportedOperationException var7B570CABEE51442D3CCB7BB64D5EC4F8_952116488 = new UnsupportedOperationException
            ("Removing tokens is not supported.");
        var7B570CABEE51442D3CCB7BB64D5EC4F8_952116488.addTaint(taint);
        throw var7B570CABEE51442D3CCB7BB64D5EC4F8_952116488;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
            //("Removing tokens is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.076 -0400", hash_original_method = "32F5FD491C11EBCEB75A9EB408CEB9C9", hash_generated_method = "F2CF0D0FED563B8EBF3C6CE1D9D33ED9")
    protected int findNext(int from) throws ParseException {
        addTaint(from);
        if(from < 0)        
        {
            if(!this.headerIt.hasNext())            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_473044736 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494645648 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494645648;
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
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1592603303 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396183290 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396183290;
        } //End block
        int end = findTokenEnd(start);
        this.currentToken = createToken(this.currentHeader, start, end);
        int var7F021A1415B86F2D013B2618FB31AE53_687343489 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739901613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739901613;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.077 -0400", hash_original_method = "8A7AB715022476147F81646A7190B2B6", hash_generated_method = "297D483DDB2B378123CBCE451C0106C0")
    protected String createToken(String value, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(value.getTaint());
String var6D1AD31619F0A44155D98F0B7B4EEE63_363197820 =         value.substring(start, end);
        var6D1AD31619F0A44155D98F0B7B4EEE63_363197820.addTaint(taint);
        return var6D1AD31619F0A44155D98F0B7B4EEE63_363197820;
        // ---------- Original Method ----------
        //return value.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.078 -0400", hash_original_method = "C3C9B07DEC7C1A6A9535E620A84F019D", hash_generated_method = "41773EF677C2A1E917D750ACDD22891E")
    protected int findTokenStart(int from) {
        addTaint(from);
        if(from < 0)        
        {
            IllegalArgumentException varE67816026124B737FE00C0674250C1B6_166900989 = new IllegalArgumentException
                ("Search position must not be negative: " + from);
            varE67816026124B737FE00C0674250C1B6_166900989.addTaint(taint);
            throw varE67816026124B737FE00C0674250C1B6_166900989;
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
                    ParseException varA8030CC569E7A8CB5F552D188C3E0720_1095162379 = new ParseException
                        ("Invalid character before token (pos " + from +
                         "): " + this.currentHeader);
                    varA8030CC569E7A8CB5F552D188C3E0720_1095162379.addTaint(taint);
                    throw varA8030CC569E7A8CB5F552D188C3E0720_1095162379;
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
        int var30BEC673AA85928644B576FD1EBDB4A9_1589126455 = (found ? from : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473808646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473808646;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.080 -0400", hash_original_method = "85E1DE95D8123E292DCFF62F7D93B47F", hash_generated_method = "AAC09983D3E5CBBA869CD06153F87788")
    protected int findTokenSeparator(int from) {
        addTaint(from);
        if(from < 0)        
        {
            IllegalArgumentException varE67816026124B737FE00C0674250C1B6_1383001242 = new IllegalArgumentException
                ("Search position must not be negative: " + from);
            varE67816026124B737FE00C0674250C1B6_1383001242.addTaint(taint);
            throw varE67816026124B737FE00C0674250C1B6_1383001242;
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
                ParseException varEA490B7121C4EAA91DF759C9DBD7A5E2_1731190767 = new ParseException
                    ("Tokens without separator (pos " + from +
                     "): " + this.currentHeader);
                varEA490B7121C4EAA91DF759C9DBD7A5E2_1731190767.addTaint(taint);
                throw varEA490B7121C4EAA91DF759C9DBD7A5E2_1731190767;
            } //End block
            else
            {
                ParseException varE0E763A9CA040A12DD639AF228B6984D_934662051 = new ParseException
                    ("Invalid character after token (pos " + from +
                     "): " + this.currentHeader);
                varE0E763A9CA040A12DD639AF228B6984D_934662051.addTaint(taint);
                throw varE0E763A9CA040A12DD639AF228B6984D_934662051;
            } //End block
        } //End block
        int varD98A07F84921B24EE30F86FD8CD85C3C_2102519316 = (from);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746853494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1746853494;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.081 -0400", hash_original_method = "ED818B78DD519794D8AD6912C0355074", hash_generated_method = "AD004E3431B429836A65CF643FEFAA0A")
    protected int findTokenEnd(int from) {
        addTaint(from);
        if(from < 0)        
        {
            IllegalArgumentException varA6DC0764CC986C425F6C0F9B12A0AD34_758329569 = new IllegalArgumentException
                ("Token start position must not be negative: " + from);
            varA6DC0764CC986C425F6C0F9B12A0AD34_758329569.addTaint(taint);
            throw varA6DC0764CC986C425F6C0F9B12A0AD34_758329569;
        } //End block
        final int to = this.currentHeader.length();
        int end = from+1;
        while
((end < to) && isTokenChar(this.currentHeader.charAt(end)))        
        {
            end++;
        } //End block
        int var7F021A1415B86F2D013B2618FB31AE53_1304260199 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899034524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899034524;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.082 -0400", hash_original_method = "82ADC719B633E23931D943624F51E118", hash_generated_method = "EB773F1EA41458379F9DEB928748D5DB")
    protected boolean isTokenSeparator(char ch) {
        addTaint(ch);
        boolean var618CE8E35889B64AFA0E42D547797C4D_1765594580 = ((ch == ','));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664671501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664671501;
        // ---------- Original Method ----------
        //return (ch == ',');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.082 -0400", hash_original_method = "C3B308F031251D57A69A78A18E46CB9C", hash_generated_method = "942DA8AA100EF80C1717AD65C7F620F4")
    protected boolean isWhitespace(char ch) {
        addTaint(ch);
        boolean var19DF6487BAD8F89596CAC8516F2A5CC2_690303269 = (((ch == '\t') || Character.isSpaceChar(ch)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_838093548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_838093548;
        // ---------- Original Method ----------
        //return ((ch == '\t') || Character.isSpaceChar(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.083 -0400", hash_original_method = "776CFF97F037037124FC98CDEBC144D9", hash_generated_method = "80D8740D6AF7826AA0C89F19A8234982")
    protected boolean isTokenChar(char ch) {
        addTaint(ch);
        if(Character.isLetterOrDigit(ch))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2043765316 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199477617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_199477617;
        }
        if(Character.isISOControl(ch))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1843865528 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1469904063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1469904063;
        }
        if(isHttpSeparator(ch))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1990389762 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151257685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151257685;
        }
        boolean varB326B5062B2F0E69046810717534CB09_154823547 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033100387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033100387;
        // ---------- Original Method ----------
        //if (Character.isLetterOrDigit(ch))
            //return true;
        //if (Character.isISOControl(ch))
            //return false;
        //if (isHttpSeparator(ch))
            //return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.084 -0400", hash_original_method = "8ABD66F1955A5164E5EB5D68E76EE993", hash_generated_method = "8118547698C5C6F1343A673845B2AB1A")
    protected boolean isHttpSeparator(char ch) {
        addTaint(ch);
        boolean var05603C57C93F34A5B16428FA2E84075F_1047929327 = ((HTTP_SEPARATORS.indexOf(ch) >= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454718935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454718935;
        // ---------- Original Method ----------
        //return (HTTP_SEPARATORS.indexOf(ch) >= 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.084 -0400", hash_original_field = "5FFFA8EDDAC6A93901241670E3BF8737", hash_generated_field = "802E3896B75225C251D59A8EE5A9E545")

    public final static String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
}

