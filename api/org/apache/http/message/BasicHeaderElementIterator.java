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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.518 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "681B665373B1CBEA8829DF2690903333")

    private HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.518 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "FD033C82BEBC8E8A0B95CC65BD0BF608")

    private HeaderValueParser parser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.519 -0400", hash_original_field = "C78122D2807BC4DCAF6855B3CE30A527", hash_generated_field = "231DE4F2E10C59C340873284ECC7C9AF")

    private HeaderElement currentElement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.520 -0400", hash_original_field = "0ED511E8C84BB7FDA5F61798CB01880D", hash_generated_field = "53E15FD8A31F799570449598E4AA1AA4")

    private CharArrayBuffer buffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.520 -0400", hash_original_field = "C32D2FC93A126CB666E8822C654D1555", hash_generated_field = "9D605F3FE696EE28F8BA84A7E0920C68")

    private ParserCursor cursor = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.523 -0400", hash_original_method = "65CFF0B218928C469B4491A10DEABC8E", hash_generated_method = "401DE3540C86E65653B9664BEC975673")
    public  BasicHeaderElementIterator(
            final HeaderIterator headerIterator,
            final HeaderValueParser parser) {
        if(headerIterator == null)        
        {
            IllegalArgumentException varBEFA7A18EC202E1D1144D23F3DE83F4E_1031327406 = new IllegalArgumentException("Header iterator may not be null");
            varBEFA7A18EC202E1D1144D23F3DE83F4E_1031327406.addTaint(taint);
            throw varBEFA7A18EC202E1D1144D23F3DE83F4E_1031327406;
        } //End block
        if(parser == null)        
        {
            IllegalArgumentException var14D150EE6E3BCA2C18082D0609BEEAAF_1454407595 = new IllegalArgumentException("Parser may not be null");
            var14D150EE6E3BCA2C18082D0609BEEAAF_1454407595.addTaint(taint);
            throw var14D150EE6E3BCA2C18082D0609BEEAAF_1454407595;
        } //End block
        this.headerIt = headerIterator;
        this.parser = parser;
        // ---------- Original Method ----------
        //if (headerIterator == null) {
            //throw new IllegalArgumentException("Header iterator may not be null");
        //}
        //if (parser == null) {
            //throw new IllegalArgumentException("Parser may not be null");
        //}
        //this.headerIt = headerIterator;
        //this.parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.524 -0400", hash_original_method = "301A478E2A86B8C402F0249D1AC3F9AF", hash_generated_method = "0BA798262BA1C6E9267FA954868A3FCA")
    public  BasicHeaderElementIterator(final HeaderIterator headerIterator) {
        this(headerIterator, BasicHeaderValueParser.DEFAULT);
        addTaint(headerIterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.528 -0400", hash_original_method = "C8E28B138A9C5D591B033922ABD8E30E", hash_generated_method = "8F2F876AF752B9ADC10C142F9ABFBDF1")
    private void bufferHeaderValue() {
        this.cursor = null;
        this.buffer = null;
        while
(this.headerIt.hasNext())        
        {
            Header h = this.headerIt.nextHeader();
            if(h instanceof FormattedHeader)            
            {
                this.buffer = ((FormattedHeader) h).getBuffer();
                this.cursor = new ParserCursor(0, this.buffer.length());
                this.cursor.updatePos(((FormattedHeader) h).getValuePos());
                break;
            } //End block
            else
            {
                String value = h.getValue();
                if(value != null)                
                {
                    this.buffer = new CharArrayBuffer(value.length());
                    this.buffer.append(value);
                    this.cursor = new ParserCursor(0, this.buffer.length());
                    break;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //this.cursor = null;
        //this.buffer = null;
        //while (this.headerIt.hasNext()) {
            //Header h = this.headerIt.nextHeader();
            //if (h instanceof FormattedHeader) {
                //this.buffer = ((FormattedHeader) h).getBuffer();
                //this.cursor = new ParserCursor(0, this.buffer.length());
                //this.cursor.updatePos(((FormattedHeader) h).getValuePos());
                //break;
            //} else {
                //String value = h.getValue();
                //if (value != null) {
                    //this.buffer = new CharArrayBuffer(value.length());
                    //this.buffer.append(value);
                    //this.cursor = new ParserCursor(0, this.buffer.length());
                    //break;
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.530 -0400", hash_original_method = "AD9B9B018316D22B2D55EF0E8A1D3706", hash_generated_method = "22D94DDDC1F4B1D6BB338DADEDCB106B")
    private void parseNextElement() {
        while
(this.headerIt.hasNext() || this.cursor != null)        
        {
            if(this.cursor == null || this.cursor.atEnd())            
            {
                bufferHeaderValue();
            } //End block
            if(this.cursor != null)            
            {
                while
(!this.cursor.atEnd())                
                {
                    HeaderElement e = this.parser.parseHeaderElement(this.buffer, this.cursor);
                    if(!(e.getName().length() == 0 && e.getValue() == null))                    
                    {
                        this.currentElement = e;
                        return;
                    } //End block
                } //End block
                if(this.cursor.atEnd())                
                {
                    this.cursor = null;
                    this.buffer = null;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @Override
	public HeaderElement nextElement() {
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

