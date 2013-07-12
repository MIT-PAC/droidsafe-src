package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.NoSuchElementException;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderElementIterator implements HeaderElementIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.366 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "681B665373B1CBEA8829DF2690903333")

    private HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.366 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "FD033C82BEBC8E8A0B95CC65BD0BF608")

    private HeaderValueParser parser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.366 -0400", hash_original_field = "C78122D2807BC4DCAF6855B3CE30A527", hash_generated_field = "231DE4F2E10C59C340873284ECC7C9AF")

    private HeaderElement currentElement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.366 -0400", hash_original_field = "0ED511E8C84BB7FDA5F61798CB01880D", hash_generated_field = "53E15FD8A31F799570449598E4AA1AA4")

    private CharArrayBuffer buffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.366 -0400", hash_original_field = "C32D2FC93A126CB666E8822C654D1555", hash_generated_field = "9D605F3FE696EE28F8BA84A7E0920C68")

    private ParserCursor cursor = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.367 -0400", hash_original_method = "65CFF0B218928C469B4491A10DEABC8E", hash_generated_method = "CA0EB9FE0B246287A648FAFEEB35A370")
    public  BasicHeaderElementIterator(
            final HeaderIterator headerIterator,
            final HeaderValueParser parser) {
    if(headerIterator == null)        
        {
            IllegalArgumentException varBEFA7A18EC202E1D1144D23F3DE83F4E_2047066772 = new IllegalArgumentException("Header iterator may not be null");
            varBEFA7A18EC202E1D1144D23F3DE83F4E_2047066772.addTaint(taint);
            throw varBEFA7A18EC202E1D1144D23F3DE83F4E_2047066772;
        } //End block
    if(parser == null)        
        {
            IllegalArgumentException var14D150EE6E3BCA2C18082D0609BEEAAF_2031666432 = new IllegalArgumentException("Parser may not be null");
            var14D150EE6E3BCA2C18082D0609BEEAAF_2031666432.addTaint(taint);
            throw var14D150EE6E3BCA2C18082D0609BEEAAF_2031666432;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.368 -0400", hash_original_method = "301A478E2A86B8C402F0249D1AC3F9AF", hash_generated_method = "0BA798262BA1C6E9267FA954868A3FCA")
    public  BasicHeaderElementIterator(final HeaderIterator headerIterator) {
        this(headerIterator, BasicHeaderValueParser.DEFAULT);
        addTaint(headerIterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.370 -0400", hash_original_method = "C8E28B138A9C5D591B033922ABD8E30E", hash_generated_method = "8F2F876AF752B9ADC10C142F9ABFBDF1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.372 -0400", hash_original_method = "AD9B9B018316D22B2D55EF0E8A1D3706", hash_generated_method = "22D94DDDC1F4B1D6BB338DADEDCB106B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.372 -0400", hash_original_method = "7B092A345DC93A80FE3D1D4087DB2A38", hash_generated_method = "B64607FA232483D8D14D8AF585B55189")
    public boolean hasNext() {
    if(this.currentElement == null)        
        {
            parseNextElement();
        } //End block
        boolean var8FA0504B047C7AA9CA16481B72E9DEF7_788278663 = (this.currentElement != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_778760716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_778760716;
        // ---------- Original Method ----------
        //if (this.currentElement == null) {
            //parseNextElement();
        //}
        //return this.currentElement != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.373 -0400", hash_original_method = "242DF42D4654E6C59596DAD87DF1998D", hash_generated_method = "3B21B8E90F915992BBDC0F9185F36C3D")
    public HeaderElement nextElement() throws NoSuchElementException {
    if(this.currentElement == null)        
        {
            parseNextElement();
        } //End block
    if(this.currentElement == null)        
        {
            NoSuchElementException varDE1843757D2EC12D80CCBE908797CE14_555231623 = new NoSuchElementException("No more header elements available");
            varDE1843757D2EC12D80CCBE908797CE14_555231623.addTaint(taint);
            throw varDE1843757D2EC12D80CCBE908797CE14_555231623;
        } //End block
        HeaderElement element = this.currentElement;
        this.currentElement = null;
HeaderElement var24D05606CDD4BC4C89F2F5A15C16F343_728648506 =         element;
        var24D05606CDD4BC4C89F2F5A15C16F343_728648506.addTaint(taint);
        return var24D05606CDD4BC4C89F2F5A15C16F343_728648506;
        // ---------- Original Method ----------
        //if (this.currentElement == null) {
            //parseNextElement();
        //}
        //if (this.currentElement == null) {
            //throw new NoSuchElementException("No more header elements available");
        //}
        //HeaderElement element = this.currentElement;
        //this.currentElement = null;
        //return element;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.373 -0400", hash_original_method = "4D3D2FFF1A269DAEEFECD9D2B54EE606", hash_generated_method = "17BB21D6EF755351A6D416F54C1B1102")
    public final Object next() throws NoSuchElementException {
Object var459972DE48CB4C82E82E2DC06B4F9E84_1597016524 =         nextElement();
        var459972DE48CB4C82E82E2DC06B4F9E84_1597016524.addTaint(taint);
        return var459972DE48CB4C82E82E2DC06B4F9E84_1597016524;
        // ---------- Original Method ----------
        //return nextElement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.373 -0400", hash_original_method = "4B70E222D9C00405F539E6D61C7F2493", hash_generated_method = "EE693E664988DCA761519822D2822A20")
    public void remove() throws UnsupportedOperationException {
        UnsupportedOperationException var0A4F5E88BC35FF75AA97A772F04412A3_658237494 = new UnsupportedOperationException("Remove not supported");
        var0A4F5E88BC35FF75AA97A772F04412A3_658237494.addTaint(taint);
        throw var0A4F5E88BC35FF75AA97A772F04412A3_658237494;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Remove not supported");
    }

    
}

