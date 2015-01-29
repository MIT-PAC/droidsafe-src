package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.NoSuchElementException;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderElementIterator implements HeaderElementIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.337 -0500", hash_original_field = "8A85502E058E78CBD7CD2C77295C667A", hash_generated_field = "681B665373B1CBEA8829DF2690903333")
    
    private  HeaderIterator headerIt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.339 -0500", hash_original_field = "AE9E6BC118AE71CB538FB6EBA19891A8", hash_generated_field = "FD033C82BEBC8E8A0B95CC65BD0BF608")

    private  HeaderValueParser parser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.342 -0500", hash_original_field = "ADF89976800B1740565555F6A9531A33", hash_generated_field = "231DE4F2E10C59C340873284ECC7C9AF")
    
    private HeaderElement currentElement = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.344 -0500", hash_original_field = "169EEA34A539E7153A0DC09FA5984F0F", hash_generated_field = "53E15FD8A31F799570449598E4AA1AA4")

    private CharArrayBuffer buffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.346 -0500", hash_original_field = "74F022E1F1AF17317699F3E1D7A115CD", hash_generated_field = "9D605F3FE696EE28F8BA84A7E0920C68")

    private ParserCursor cursor = null;
    
    /**
     * Creates a new instance of BasicHeaderElementIterator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.349 -0500", hash_original_method = "65CFF0B218928C469B4491A10DEABC8E", hash_generated_method = "9C1308D1F4C5EFBDC70FFAD2FAA828F3")
    
public BasicHeaderElementIterator(
            final HeaderIterator headerIterator,
            final HeaderValueParser parser) {
        if (headerIterator == null) {
            throw new IllegalArgumentException("Header iterator may not be null");
        }
        if (parser == null) {
            throw new IllegalArgumentException("Parser may not be null");
        }
        this.headerIt = headerIterator;
        this.parser = parser;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.352 -0500", hash_original_method = "301A478E2A86B8C402F0249D1AC3F9AF", hash_generated_method = "0E3689E1E24ADF9EA9627E65DAB44B62")
    
public BasicHeaderElementIterator(final HeaderIterator headerIterator) {
        this(headerIterator, BasicHeaderValueParser.DEFAULT);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.356 -0500", hash_original_method = "C8E28B138A9C5D591B033922ABD8E30E", hash_generated_method = "6FFD397A68944DC958D03E859EB4B5C4")
    
private void bufferHeaderValue() {
        this.cursor = null;
        this.buffer = null;
        while (this.headerIt.hasNext()) {
            Header h = this.headerIt.nextHeader();
            if (h instanceof FormattedHeader) {
                this.buffer = ((FormattedHeader) h).getBuffer();
                this.cursor = new ParserCursor(0, this.buffer.length());
                this.cursor.updatePos(((FormattedHeader) h).getValuePos());
                break;
            } else {
                String value = h.getValue();
                if (value != null) {
                    this.buffer = new CharArrayBuffer(value.length());
                    this.buffer.append(value);
                    this.cursor = new ParserCursor(0, this.buffer.length());
                    break;
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.360 -0500", hash_original_method = "AD9B9B018316D22B2D55EF0E8A1D3706", hash_generated_method = "C19A7CF73FC1B18D33C38C384CEEAAD3")
    
private void parseNextElement() {
        // loop while there are headers left to parse
        while (this.headerIt.hasNext() || this.cursor != null) {
            if (this.cursor == null || this.cursor.atEnd()) {
                // get next header value
                bufferHeaderValue();
            }
            // Anything buffered?
            if (this.cursor != null) {
                // loop while there is data in the buffer 
                while (!this.cursor.atEnd()) {
                    HeaderElement e = this.parser.parseHeaderElement(this.buffer, this.cursor);
                    if (!(e.getName().length() == 0 && e.getValue() == null)) {
                        // Found something
                        this.currentElement = e;
                        return;
                    }
                }
                // if at the end of the buffer
                if (this.cursor.atEnd()) {
                    // discard it
                    this.cursor = null;
                    this.buffer = null;
                }
            }
        }
    }
    
	@DSSafe(DSCat.SAFE_LIST)
    @Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
    
    @Override
	public HeaderElement nextElement() {
		// TODO Auto-generated method stub
           return (HeaderElement)headerIt.next();
	}
    
	@DSSafe(DSCat.SAFE_LIST)
    @Override
	public Object next() {
		// TODO Auto-generated method stub
            return headerIt.next();
	}
    
    @DSSafe(DSCat.DATA_STRUCTURE)
    @Override
	public void remove() {
		// TODO Auto-generated method stub
	}
    
}

