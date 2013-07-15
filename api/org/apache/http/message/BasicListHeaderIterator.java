package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

public class BasicListHeaderIterator implements HeaderIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.619 -0400", hash_original_field = "70C9DAFA949FAFF76AD7BDC73045BC73", hash_generated_field = "3B804EE90FB805BB2F9B41892E7AB9CC")

    protected List allHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.619 -0400", hash_original_field = "4BD5A8B788F2E9E58294F9371A3CF365", hash_generated_field = "888ED00F76573C33F42FD289758C6753")

    protected int currentIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.619 -0400", hash_original_field = "6F2EE54DDE3DC60F4A41E7DFB940851A", hash_generated_field = "7984FA65CEAD27AA9A0B68B55B2F3751")

    protected int lastIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.619 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.620 -0400", hash_original_method = "2D091C8CAFC19B749551E2F1187B6105", hash_generated_method = "E87968FD00EF726B9A48204F849C2390")
    public  BasicListHeaderIterator(List headers, String name) {
    if(headers == null)        
        {
            IllegalArgumentException var8177D2CEEC505E66B0DABCC7442B2697_824763586 = new IllegalArgumentException
                ("Header list must not be null.");
            var8177D2CEEC505E66B0DABCC7442B2697_824763586.addTaint(taint);
            throw var8177D2CEEC505E66B0DABCC7442B2697_824763586;
        } //End block
        this.allHeaders = headers;
        this.headerName = name;
        this.currentIndex = findNext(-1);
        this.lastIndex = -1;
        // ---------- Original Method ----------
        //if (headers == null) {
            //throw new IllegalArgumentException
                //("Header list must not be null.");
        //}
        //this.allHeaders = headers;
        //this.headerName = name;
        //this.currentIndex = findNext(-1);
        //this.lastIndex = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.621 -0400", hash_original_method = "AE89C08F08BB3F2E2361D882A86E08E6", hash_generated_method = "0AB624FF1E4C8D048C5CCBF32425D803")
    protected int findNext(int from) {
        addTaint(from);
    if(from < -1)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1115297791 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168913588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168913588;
        }
        final int to = this.allHeaders.size()-1;
        boolean found = false;
        while
(!found && (from < to))        
        {
            from++;
            found = filterHeader(from);
        } //End block
        int var30BEC673AA85928644B576FD1EBDB4A9_82202695 = (found ? from : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390871006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390871006;
        // ---------- Original Method ----------
        //if (from < -1)
            //return -1;
        //final int to = this.allHeaders.size()-1;
        //boolean found = false;
        //while (!found && (from < to)) {
            //from++;
            //found = filterHeader(from);
        //}
        //return found ? from : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.622 -0400", hash_original_method = "DC309B64F8D7236BD3D5DA9945B2E659", hash_generated_method = "1B8689F85ECAA31E35A2809BD2A985BB")
    protected boolean filterHeader(int index) {
        addTaint(index);
    if(this.headerName == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1682679302 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1376166549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1376166549;
        }
        final String name = ((Header)this.allHeaders.get(index)).getName();
        boolean varC3CEF156F878834D86C1A7D55EFC4992_1768957158 = (this.headerName.equalsIgnoreCase(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687046063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687046063;
        // ---------- Original Method ----------
        //if (this.headerName == null)
            //return true;
        //final String name = ((Header)this.allHeaders.get(index)).getName();
        //return this.headerName.equalsIgnoreCase(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.622 -0400", hash_original_method = "A999EE5BCD06DCC7730AAD5F8A866DB2", hash_generated_method = "E35466C495373485AC79026CB6991763")
    public boolean hasNext() {
        boolean varC26A12D4E7C3FDC78864370D6EEB75E9_778900379 = ((this.currentIndex >= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_238496663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_238496663;
        // ---------- Original Method ----------
        //return (this.currentIndex >= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.623 -0400", hash_original_method = "8B480335A0C8328D28D73B9B4CAA13A8", hash_generated_method = "E85768D98D9F6ED731BA99E149CF28C0")
    public Header nextHeader() throws NoSuchElementException {
        final int current = this.currentIndex;
    if(current < 0)        
        {
            NoSuchElementException var987AB9BC96C39424DAD4C83B35F26CD8_1958285965 = new NoSuchElementException("Iteration already finished.");
            var987AB9BC96C39424DAD4C83B35F26CD8_1958285965.addTaint(taint);
            throw var987AB9BC96C39424DAD4C83B35F26CD8_1958285965;
        } //End block
        this.lastIndex    = current;
        this.currentIndex = findNext(current);
Header varBA8BA1200FF1A61953A763AB5ECE3DC8_1656148613 =         (Header) this.allHeaders.get(current);
        varBA8BA1200FF1A61953A763AB5ECE3DC8_1656148613.addTaint(taint);
        return varBA8BA1200FF1A61953A763AB5ECE3DC8_1656148613;
        // ---------- Original Method ----------
        //final int current = this.currentIndex;
        //if (current < 0) {
            //throw new NoSuchElementException("Iteration already finished.");
        //}
        //this.lastIndex    = current;
        //this.currentIndex = findNext(current);
        //return (Header) this.allHeaders.get(current);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.623 -0400", hash_original_method = "52795801AD2FF0B406EF0189CBA87E8B", hash_generated_method = "E4983769C896232A0EA8BDA65D0E1000")
    public final Object next() throws NoSuchElementException {
Object var1A3FA08BBA40440D4CB2F4072E1F7431_851457953 =         nextHeader();
        var1A3FA08BBA40440D4CB2F4072E1F7431_851457953.addTaint(taint);
        return var1A3FA08BBA40440D4CB2F4072E1F7431_851457953;
        // ---------- Original Method ----------
        //return nextHeader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.624 -0400", hash_original_method = "38E9BF9964D831A9048EA81D99CFEC10", hash_generated_method = "2E444A8FDBF7FA8D824DD263D1E7626A")
    public void remove() throws UnsupportedOperationException {
    if(this.lastIndex < 0)        
        {
            IllegalStateException var9A02E18FF65F2C2C5BF52EDED7AAB687_213123845 = new IllegalStateException("No header to remove.");
            var9A02E18FF65F2C2C5BF52EDED7AAB687_213123845.addTaint(taint);
            throw var9A02E18FF65F2C2C5BF52EDED7AAB687_213123845;
        } //End block
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
        // ---------- Original Method ----------
        //if (this.lastIndex < 0) {
            //throw new IllegalStateException("No header to remove.");
        //}
        //this.allHeaders.remove(this.lastIndex);
        //this.lastIndex = -1;
        //this.currentIndex--;
    }

    
}

