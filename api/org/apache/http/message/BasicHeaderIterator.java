package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

public class BasicHeaderIterator implements HeaderIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.556 -0500", hash_original_field = "7561685C14CD5CD7F041FA1870ADDE5B", hash_generated_field = "9D20A5B33FC154C445108A690F776855")

    protected  Header[] allHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.559 -0500", hash_original_field = "6F81E025B1753B7DB14DC2504C9B53B1", hash_generated_field = "888ED00F76573C33F42FD289758C6753")

    protected int currentIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.561 -0500", hash_original_field = "BD66DD28721A718F4DADB56502A74024", hash_generated_field = "A59FED2AE4AD2264FB1F7BF89553485D")

    protected String headerName;



    /**
     * Creates a new header iterator.
     *
     * @param headers   an array of headers over which to iterate
     * @param name      the name of the headers over which to iterate, or
     *                  <code>null</code> for any
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.564 -0500", hash_original_method = "55914EF56C76B8DDF5A0F659085C899A", hash_generated_method = "B0A067E01290EFC07BA78E64742D3EE9")
    
public BasicHeaderIterator(Header[] headers, String name) {
        if (headers == null) {
            throw new IllegalArgumentException
                ("Header array must not be null.");
        }

        this.allHeaders = headers;
        this.headerName = name;
        this.currentIndex = findNext(-1);
    }


    /**
     * Determines the index of the next header.
     *
     * @param from      one less than the index to consider first,
     *                  -1 to search for the first header
     *
     * @return  the index of the next header that matches the filter name,
     *          or negative if there are no more headers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.566 -0500", hash_original_method = "FA5378A644617D9F29788BE3811B38CD", hash_generated_method = "4DB9B209B4DD0C72B03CA03D0C5421AC")
    
protected int findNext(int from) {
        if (from < -1)
            return -1;

        final int to = this.allHeaders.length-1;
        boolean found = false;
        while (!found && (from < to)) {
            from++;
            found = filterHeader(from);
        }
        return found ? from : -1;
    }


    /**
     * Checks whether a header is part of the iteration.
     *
     * @param index     the index of the header to check
     *
     * @return  <code>true</code> if the header should be part of the
     *          iteration, <code>false</code> to skip
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.569 -0500", hash_original_method = "9D88E0551A3FF4A21A3E39810268F7E4", hash_generated_method = "A165D91B4AEB54800A42FB79DF93E3BE")
    
protected boolean filterHeader(int index) {
        return (this.headerName == null) ||
            this.headerName.equalsIgnoreCase(this.allHeaders[index].getName());
    }

    
    @DSModeled(DSC.SAFE)
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @DSModeled(DSC.SAFE)
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

