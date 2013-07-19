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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.714 -0400", hash_original_field = "70C9DAFA949FAFF76AD7BDC73045BC73", hash_generated_field = "3B804EE90FB805BB2F9B41892E7AB9CC")

    protected List allHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.717 -0400", hash_original_field = "4BD5A8B788F2E9E58294F9371A3CF365", hash_generated_field = "888ED00F76573C33F42FD289758C6753")

    protected int currentIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.718 -0400", hash_original_field = "6F2EE54DDE3DC60F4A41E7DFB940851A", hash_generated_field = "7984FA65CEAD27AA9A0B68B55B2F3751")

    protected int lastIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.718 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.720 -0400", hash_original_method = "2D091C8CAFC19B749551E2F1187B6105", hash_generated_method = "C9F419A38BDA9FA70D45ADC4C2C0C577")
    public  BasicListHeaderIterator(List headers, String name) {
        if(headers == null)        
        {
            IllegalArgumentException var8177D2CEEC505E66B0DABCC7442B2697_731671496 = new IllegalArgumentException
                ("Header list must not be null.");
            var8177D2CEEC505E66B0DABCC7442B2697_731671496.addTaint(taint);
            throw var8177D2CEEC505E66B0DABCC7442B2697_731671496;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.723 -0400", hash_original_method = "AE89C08F08BB3F2E2361D882A86E08E6", hash_generated_method = "87C172DDF899E8E91FA23176366D8D37")
    protected int findNext(int from) {
        addTaint(from);
        if(from < -1)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1031377682 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832206674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832206674;
        }
        final int to = this.allHeaders.size()-1;
        boolean found = false;
        while
(!found && (from < to))        
        {
            from++;
            found = filterHeader(from);
        } //End block
        int var30BEC673AA85928644B576FD1EBDB4A9_1438142848 = (found ? from : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965783890 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965783890;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.725 -0400", hash_original_method = "DC309B64F8D7236BD3D5DA9945B2E659", hash_generated_method = "DE88FFFE34721CFA6DD2010975A1D9AC")
    protected boolean filterHeader(int index) {
        addTaint(index);
        if(this.headerName == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_550262843 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1703401573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1703401573;
        }
        final String name = ((Header)this.allHeaders.get(index)).getName();
        boolean varC3CEF156F878834D86C1A7D55EFC4992_74080640 = (this.headerName.equalsIgnoreCase(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781873928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_781873928;
        // ---------- Original Method ----------
        //if (this.headerName == null)
            //return true;
        //final String name = ((Header)this.allHeaders.get(index)).getName();
        //return this.headerName.equalsIgnoreCase(name);
    }

    
    @DSModeled(DSC.SAFE)
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @Override
	public Header nextHeader() {
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

    
}

