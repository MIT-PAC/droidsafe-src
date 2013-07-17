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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.754 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "681B665373B1CBEA8829DF2690903333")

    private HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.754 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "FD033C82BEBC8E8A0B95CC65BD0BF608")

    private HeaderValueParser parser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.754 -0400", hash_original_field = "C78122D2807BC4DCAF6855B3CE30A527", hash_generated_field = "231DE4F2E10C59C340873284ECC7C9AF")

    private HeaderElement currentElement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.754 -0400", hash_original_field = "0ED511E8C84BB7FDA5F61798CB01880D", hash_generated_field = "53E15FD8A31F799570449598E4AA1AA4")

    private CharArrayBuffer buffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.754 -0400", hash_original_field = "C32D2FC93A126CB666E8822C654D1555", hash_generated_field = "9D605F3FE696EE28F8BA84A7E0920C68")

    private ParserCursor cursor = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.755 -0400", hash_original_method = "65CFF0B218928C469B4491A10DEABC8E", hash_generated_method = "206738AE33EBAE205BA19A4CE9F2D732")
    public  BasicHeaderElementIterator(
            final HeaderIterator headerIterator,
            final HeaderValueParser parser) {
        if(headerIterator == null)        
        {
            IllegalArgumentException varBEFA7A18EC202E1D1144D23F3DE83F4E_1982308633 = new IllegalArgumentException("Header iterator may not be null");
            varBEFA7A18EC202E1D1144D23F3DE83F4E_1982308633.addTaint(taint);
            throw varBEFA7A18EC202E1D1144D23F3DE83F4E_1982308633;
        } //End block
        if(parser == null)        
        {
            IllegalArgumentException var14D150EE6E3BCA2C18082D0609BEEAAF_332150587 = new IllegalArgumentException("Parser may not be null");
            var14D150EE6E3BCA2C18082D0609BEEAAF_332150587.addTaint(taint);
            throw var14D150EE6E3BCA2C18082D0609BEEAAF_332150587;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.756 -0400", hash_original_method = "301A478E2A86B8C402F0249D1AC3F9AF", hash_generated_method = "0BA798262BA1C6E9267FA954868A3FCA")
    public  BasicHeaderElementIterator(final HeaderIterator headerIterator) {
        this(headerIterator, BasicHeaderValueParser.DEFAULT);
        addTaint(headerIterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.758 -0400", hash_original_method = "C8E28B138A9C5D591B033922ABD8E30E", hash_generated_method = "8F2F876AF752B9ADC10C142F9ABFBDF1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.759 -0400", hash_original_method = "AD9B9B018316D22B2D55EF0E8A1D3706", hash_generated_method = "22D94DDDC1F4B1D6BB338DADEDCB106B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.759 -0400", hash_original_method = "7B092A345DC93A80FE3D1D4087DB2A38", hash_generated_method = "56E80AE158FF57FF4AB26B64104401DB")
    public boolean hasNext() {
        if(this.currentElement == null)        
        {
            parseNextElement();
        } //End block
        boolean var8FA0504B047C7AA9CA16481B72E9DEF7_120366350 = (this.currentElement != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504372358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504372358;
        // ---------- Original Method ----------
        //if (this.currentElement == null) {
            //parseNextElement();
        //}
        //return this.currentElement != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.760 -0400", hash_original_method = "242DF42D4654E6C59596DAD87DF1998D", hash_generated_method = "C77ADD583F5FB6C07B442F6B7D88E37D")
    public HeaderElement nextElement() throws NoSuchElementException {
        if(this.currentElement == null)        
        {
            parseNextElement();
        } //End block
        if(this.currentElement == null)        
        {
            NoSuchElementException varDE1843757D2EC12D80CCBE908797CE14_1410692165 = new NoSuchElementException("No more header elements available");
            varDE1843757D2EC12D80CCBE908797CE14_1410692165.addTaint(taint);
            throw varDE1843757D2EC12D80CCBE908797CE14_1410692165;
        } //End block
        HeaderElement element = this.currentElement;
        this.currentElement = null;
HeaderElement var24D05606CDD4BC4C89F2F5A15C16F343_1712162063 =         element;
        var24D05606CDD4BC4C89F2F5A15C16F343_1712162063.addTaint(taint);
        return var24D05606CDD4BC4C89F2F5A15C16F343_1712162063;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.760 -0400", hash_original_method = "4D3D2FFF1A269DAEEFECD9D2B54EE606", hash_generated_method = "26AE1095BDD3EA37034B330C325DFBC7")
    public final Object next() throws NoSuchElementException {
Object var459972DE48CB4C82E82E2DC06B4F9E84_2046267473 =         nextElement();
        var459972DE48CB4C82E82E2DC06B4F9E84_2046267473.addTaint(taint);
        return var459972DE48CB4C82E82E2DC06B4F9E84_2046267473;
        // ---------- Original Method ----------
        //return nextElement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.760 -0400", hash_original_method = "4B70E222D9C00405F539E6D61C7F2493", hash_generated_method = "E5D66EBD6349507DC3D78A306EA8CBC8")
    public void remove() throws UnsupportedOperationException {
        UnsupportedOperationException var0A4F5E88BC35FF75AA97A772F04412A3_1262629653 = new UnsupportedOperationException("Remove not supported");
        var0A4F5E88BC35FF75AA97A772F04412A3_1262629653.addTaint(taint);
        throw var0A4F5E88BC35FF75AA97A772F04412A3_1262629653;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Remove not supported");
    }

    
}

