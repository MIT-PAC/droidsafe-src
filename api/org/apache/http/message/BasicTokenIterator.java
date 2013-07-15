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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.688 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "EC9D0C260936A48CE3D00DF1B58760FD")

    protected HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.688 -0400", hash_original_field = "8A48FDE5E525D8E0723FE89C04899A8A", hash_generated_field = "7B4E018C3F013525C08A27A13DF71B71")

    protected String currentHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.689 -0400", hash_original_field = "D669CB175EE8F1FF968DF72793C16003", hash_generated_field = "74D8A76D642811495F7C9EB2CC2B1DBE")

    protected String currentToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.689 -0400", hash_original_field = "B2CCF8E31CDFA90F9873152A70561B3B", hash_generated_field = "41CA8C81CB60760B0D4A540CC5B31524")

    protected int searchPos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.689 -0400", hash_original_method = "728241B000D06E5A4B3FF4A1E835CDCC", hash_generated_method = "EECBB0328C0EF0C21C0C6976903AE5D2")
    public  BasicTokenIterator(final HeaderIterator headerIterator) {
    if(headerIterator == null)        
        {
            IllegalArgumentException var7DF460ACC625D606A2CEDF16D44D1646_2123654278 = new IllegalArgumentException
                ("Header iterator must not be null.");
            var7DF460ACC625D606A2CEDF16D44D1646_2123654278.addTaint(taint);
            throw var7DF460ACC625D606A2CEDF16D44D1646_2123654278;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.689 -0400", hash_original_method = "DAB37B2EA98FD1DE22306A8DB0E83A00", hash_generated_method = "00E525DFB13DB1726422483E3297801A")
    public boolean hasNext() {
        boolean varF9D1FD9B4069C0625E90F30612866EF5_519470397 = ((this.currentToken != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954622223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954622223;
        // ---------- Original Method ----------
        //return (this.currentToken != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.690 -0400", hash_original_method = "2D2EFD32F6C702BC7EE07BEBECC92489", hash_generated_method = "9C75D9B21CBCD64138406D4ABE23CC1D")
    public String nextToken() throws NoSuchElementException, ParseException {
    if(this.currentToken == null)        
        {
            NoSuchElementException var987AB9BC96C39424DAD4C83B35F26CD8_1479901082 = new NoSuchElementException("Iteration already finished.");
            var987AB9BC96C39424DAD4C83B35F26CD8_1479901082.addTaint(taint);
            throw var987AB9BC96C39424DAD4C83B35F26CD8_1479901082;
        } //End block
        final String result = this.currentToken;
        this.searchPos = findNext(this.searchPos);
String varDC838461EE2FA0CA4C9BBB70A15456B0_162000035 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_162000035.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_162000035;
        // ---------- Original Method ----------
        //if (this.currentToken == null) {
            //throw new NoSuchElementException("Iteration already finished.");
        //}
        //final String result = this.currentToken;
        //this.searchPos = findNext(this.searchPos);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.690 -0400", hash_original_method = "EF0593622B27F345C7E5884D7EB53A09", hash_generated_method = "99338AE53799DA6D983D0F27BADADB8E")
    public final Object next() throws NoSuchElementException, ParseException {
Object var1E85D5DD28517B6F091CC30DA1235BD1_767750184 =         nextToken();
        var1E85D5DD28517B6F091CC30DA1235BD1_767750184.addTaint(taint);
        return var1E85D5DD28517B6F091CC30DA1235BD1_767750184;
        // ---------- Original Method ----------
        //return nextToken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.690 -0400", hash_original_method = "3BA4D5C83A160BCB8FD8E05B9614066A", hash_generated_method = "4433241A1208F1DADFEB10FAE5F73A2A")
    public final void remove() throws UnsupportedOperationException {
        UnsupportedOperationException var7B570CABEE51442D3CCB7BB64D5EC4F8_597599413 = new UnsupportedOperationException
            ("Removing tokens is not supported.");
        var7B570CABEE51442D3CCB7BB64D5EC4F8_597599413.addTaint(taint);
        throw var7B570CABEE51442D3CCB7BB64D5EC4F8_597599413;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
            //("Removing tokens is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.691 -0400", hash_original_method = "32F5FD491C11EBCEB75A9EB408CEB9C9", hash_generated_method = "F66842077F5B7326ABA5FB8B49D3731E")
    protected int findNext(int from) throws ParseException {
        addTaint(from);
    if(from < 0)        
        {
    if(!this.headerIt.hasNext())            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2107567532 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037012153 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037012153;
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
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1484952286 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819776749 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819776749;
        } //End block
        int end = findTokenEnd(start);
        this.currentToken = createToken(this.currentHeader, start, end);
        int var7F021A1415B86F2D013B2618FB31AE53_1616365868 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957190574 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957190574;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.692 -0400", hash_original_method = "8A7AB715022476147F81646A7190B2B6", hash_generated_method = "E825169F83544E34C235A03D164AD35F")
    protected String createToken(String value, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(value.getTaint());
String var6D1AD31619F0A44155D98F0B7B4EEE63_818405000 =         value.substring(start, end);
        var6D1AD31619F0A44155D98F0B7B4EEE63_818405000.addTaint(taint);
        return var6D1AD31619F0A44155D98F0B7B4EEE63_818405000;
        // ---------- Original Method ----------
        //return value.substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.694 -0400", hash_original_method = "C3C9B07DEC7C1A6A9535E620A84F019D", hash_generated_method = "C757C9A463FA6E75E072C3866B0C8FB0")
    protected int findTokenStart(int from) {
        addTaint(from);
    if(from < 0)        
        {
            IllegalArgumentException varE67816026124B737FE00C0674250C1B6_1604507112 = new IllegalArgumentException
                ("Search position must not be negative: " + from);
            varE67816026124B737FE00C0674250C1B6_1604507112.addTaint(taint);
            throw varE67816026124B737FE00C0674250C1B6_1604507112;
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
                    ParseException varA8030CC569E7A8CB5F552D188C3E0720_1864553204 = new ParseException
                        ("Invalid character before token (pos " + from +
                         "): " + this.currentHeader);
                    varA8030CC569E7A8CB5F552D188C3E0720_1864553204.addTaint(taint);
                    throw varA8030CC569E7A8CB5F552D188C3E0720_1864553204;
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
        int var30BEC673AA85928644B576FD1EBDB4A9_2129150162 = (found ? from : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650004067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650004067;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.696 -0400", hash_original_method = "85E1DE95D8123E292DCFF62F7D93B47F", hash_generated_method = "CC19907B6EE73C72E2012C0A53C8EA85")
    protected int findTokenSeparator(int from) {
        addTaint(from);
    if(from < 0)        
        {
            IllegalArgumentException varE67816026124B737FE00C0674250C1B6_250908238 = new IllegalArgumentException
                ("Search position must not be negative: " + from);
            varE67816026124B737FE00C0674250C1B6_250908238.addTaint(taint);
            throw varE67816026124B737FE00C0674250C1B6_250908238;
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
                ParseException varEA490B7121C4EAA91DF759C9DBD7A5E2_1235875232 = new ParseException
                    ("Tokens without separator (pos " + from +
                     "): " + this.currentHeader);
                varEA490B7121C4EAA91DF759C9DBD7A5E2_1235875232.addTaint(taint);
                throw varEA490B7121C4EAA91DF759C9DBD7A5E2_1235875232;
            } //End block
            else
            {
                ParseException varE0E763A9CA040A12DD639AF228B6984D_2126017827 = new ParseException
                    ("Invalid character after token (pos " + from +
                     "): " + this.currentHeader);
                varE0E763A9CA040A12DD639AF228B6984D_2126017827.addTaint(taint);
                throw varE0E763A9CA040A12DD639AF228B6984D_2126017827;
            } //End block
        } //End block
        int varD98A07F84921B24EE30F86FD8CD85C3C_1944655861 = (from);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623784335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623784335;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.696 -0400", hash_original_method = "ED818B78DD519794D8AD6912C0355074", hash_generated_method = "5F8C0D3D84EDCF305DD58B91F6FE5352")
    protected int findTokenEnd(int from) {
        addTaint(from);
    if(from < 0)        
        {
            IllegalArgumentException varA6DC0764CC986C425F6C0F9B12A0AD34_1031935293 = new IllegalArgumentException
                ("Token start position must not be negative: " + from);
            varA6DC0764CC986C425F6C0F9B12A0AD34_1031935293.addTaint(taint);
            throw varA6DC0764CC986C425F6C0F9B12A0AD34_1031935293;
        } //End block
        final int to = this.currentHeader.length();
        int end = from+1;
        while
((end < to) && isTokenChar(this.currentHeader.charAt(end)))        
        {
            end++;
        } //End block
        int var7F021A1415B86F2D013B2618FB31AE53_1263728749 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627658992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627658992;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.697 -0400", hash_original_method = "82ADC719B633E23931D943624F51E118", hash_generated_method = "49A73D3A5BC28B0EB4A46CD38134308D")
    protected boolean isTokenSeparator(char ch) {
        addTaint(ch);
        boolean var618CE8E35889B64AFA0E42D547797C4D_1678750449 = ((ch == ','));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856550433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856550433;
        // ---------- Original Method ----------
        //return (ch == ',');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.697 -0400", hash_original_method = "C3B308F031251D57A69A78A18E46CB9C", hash_generated_method = "CC0BEA110DDE70E36B5906EBFB07910A")
    protected boolean isWhitespace(char ch) {
        addTaint(ch);
        boolean var19DF6487BAD8F89596CAC8516F2A5CC2_602301956 = (((ch == '\t') || Character.isSpaceChar(ch)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141050789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141050789;
        // ---------- Original Method ----------
        //return ((ch == '\t') || Character.isSpaceChar(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.697 -0400", hash_original_method = "776CFF97F037037124FC98CDEBC144D9", hash_generated_method = "7F217D938A1BAC3D1514A6E2B1013F76")
    protected boolean isTokenChar(char ch) {
        addTaint(ch);
    if(Character.isLetterOrDigit(ch))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_214108846 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496903268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496903268;
        }
    if(Character.isISOControl(ch))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1000976420 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509404658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509404658;
        }
    if(isHttpSeparator(ch))        
        {
        boolean var68934A3E9455FA72420237EB05902327_622519968 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_427378;
        }
        boolean varB326B5062B2F0E69046810717534CB09_1281964135 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623319239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_623319239;
        // ---------- Original Method ----------
        //if (Character.isLetterOrDigit(ch))
            //return true;
        //if (Character.isISOControl(ch))
            //return false;
        //if (isHttpSeparator(ch))
            //return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.698 -0400", hash_original_method = "8ABD66F1955A5164E5EB5D68E76EE993", hash_generated_method = "79BA4695B1C79F98CF48FA211DF90972")
    protected boolean isHttpSeparator(char ch) {
        addTaint(ch);
        boolean var05603C57C93F34A5B16428FA2E84075F_556393032 = ((HTTP_SEPARATORS.indexOf(ch) >= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_127211119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_127211119;
        // ---------- Original Method ----------
        //return (HTTP_SEPARATORS.indexOf(ch) >= 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.698 -0400", hash_original_field = "5FFFA8EDDAC6A93901241670E3BF8737", hash_generated_field = "802E3896B75225C251D59A8EE5A9E545")

    public final static String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
}

