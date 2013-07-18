package org.apache.http.message;

// Droidsafe Imports
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BasicHeaderIterator implements HeaderIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.578 -0400", hash_original_field = "70C9DAFA949FAFF76AD7BDC73045BC73", hash_generated_field = "9D20A5B33FC154C445108A690F776855")

    protected Header[] allHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.578 -0400", hash_original_field = "4BD5A8B788F2E9E58294F9371A3CF365", hash_generated_field = "888ED00F76573C33F42FD289758C6753")

    protected int currentIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.579 -0400", hash_original_field = "5B56D13EFD69E1602F78DED5D4B9CB80", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.581 -0400", hash_original_method = "55914EF56C76B8DDF5A0F659085C899A", hash_generated_method = "8B89439E21D10B0360D98E988C5EEFED")
    public  BasicHeaderIterator(Header[] headers, String name) {
        if(headers == null)        
        {
            IllegalArgumentException varF2EDCEA803CFC639953C3D405096CECF_2049089918 = new IllegalArgumentException
                ("Header array must not be null.");
            varF2EDCEA803CFC639953C3D405096CECF_2049089918.addTaint(taint);
            throw varF2EDCEA803CFC639953C3D405096CECF_2049089918;
        } //End block
        this.allHeaders = headers;
        this.headerName = name;
        this.currentIndex = findNext(-1);
        // ---------- Original Method ----------
        //if (headers == null) {
            //throw new IllegalArgumentException
                //("Header array must not be null.");
        //}
        //this.allHeaders = headers;
        //this.headerName = name;
        //this.currentIndex = findNext(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.583 -0400", hash_original_method = "FA5378A644617D9F29788BE3811B38CD", hash_generated_method = "8E3AC563479A56ECAF9278513AF1A94A")
    protected int findNext(int from) {
        addTaint(from);
        if(from < -1)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_39145816 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227711838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227711838;
        }
        final int to = this.allHeaders.length-1;
        boolean found = false;
        while
(!found && (from < to))        
        {
            from++;
            found = filterHeader(from);
        } //End block
        int var30BEC673AA85928644B576FD1EBDB4A9_1351575723 = (found ? from : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829101325 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_829101325;
        // ---------- Original Method ----------
        //if (from < -1)
            //return -1;
        //final int to = this.allHeaders.length-1;
        //boolean found = false;
        //while (!found && (from < to)) {
            //from++;
            //found = filterHeader(from);
        //}
        //return found ? from : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.584 -0400", hash_original_method = "9D88E0551A3FF4A21A3E39810268F7E4", hash_generated_method = "877E17D4DF69D4A31FAA88999B89688C")
    protected boolean filterHeader(int index) {
        addTaint(index);
        boolean var20CD6195CD6576D5C0C8A71101676A49_1483089768 = ((this.headerName == null) ||
            this.headerName.equalsIgnoreCase(this.allHeaders[index].getName()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972176638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972176638;
        // ---------- Original Method ----------
        //return (this.headerName == null) ||
            //this.headerName.equalsIgnoreCase(this.allHeaders[index].getName());
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

