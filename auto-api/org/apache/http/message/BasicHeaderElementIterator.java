package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderElementIterator implements HeaderElementIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.891 -0400", hash_original_field = "17843B798641DCC33A90FE8CA70EEC07", hash_generated_field = "681B665373B1CBEA8829DF2690903333")

    private HeaderIterator headerIt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.891 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "FD033C82BEBC8E8A0B95CC65BD0BF608")

    private HeaderValueParser parser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.891 -0400", hash_original_field = "C78122D2807BC4DCAF6855B3CE30A527", hash_generated_field = "231DE4F2E10C59C340873284ECC7C9AF")

    private HeaderElement currentElement = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.891 -0400", hash_original_field = "0ED511E8C84BB7FDA5F61798CB01880D", hash_generated_field = "53E15FD8A31F799570449598E4AA1AA4")

    private CharArrayBuffer buffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.891 -0400", hash_original_field = "C32D2FC93A126CB666E8822C654D1555", hash_generated_field = "9D605F3FE696EE28F8BA84A7E0920C68")

    private ParserCursor cursor = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.902 -0400", hash_original_method = "65CFF0B218928C469B4491A10DEABC8E", hash_generated_method = "83BEB2B4EA36ECE19C68BF1B820AE59B")
    public  BasicHeaderElementIterator(
            final HeaderIterator headerIterator,
            final HeaderValueParser parser) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header iterator may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser may not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.903 -0400", hash_original_method = "301A478E2A86B8C402F0249D1AC3F9AF", hash_generated_method = "0BA798262BA1C6E9267FA954868A3FCA")
    public  BasicHeaderElementIterator(final HeaderIterator headerIterator) {
        this(headerIterator, BasicHeaderValueParser.DEFAULT);
        addTaint(headerIterator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.904 -0400", hash_original_method = "C8E28B138A9C5D591B033922ABD8E30E", hash_generated_method = "B608F06EB4CE6405F0FD0AA508022F92")
    private void bufferHeaderValue() {
        this.cursor = null;
        this.buffer = null;
        {
            boolean var4B49ECDFBB9AA35B6CED36FF20359A7D_1479009712 = (this.headerIt.hasNext());
            {
                Header h;
                h = this.headerIt.nextHeader();
                {
                    this.buffer = ((FormattedHeader) h).getBuffer();
                    this.cursor = new ParserCursor(0, this.buffer.length());
                    this.cursor.updatePos(((FormattedHeader) h).getValuePos());
                } //End block
                {
                    String value;
                    value = h.getValue();
                    {
                        this.buffer = new CharArrayBuffer(value.length());
                        this.buffer.append(value);
                        this.cursor = new ParserCursor(0, this.buffer.length());
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.905 -0400", hash_original_method = "AD9B9B018316D22B2D55EF0E8A1D3706", hash_generated_method = "79AE21B56B3BC4C4322279E578D96654")
    private void parseNextElement() {
        {
            boolean var09C563F417B20DBC09C799813B5B57F2_1295495182 = (this.headerIt.hasNext() || this.cursor != null);
            {
                {
                    boolean varA17C9442C72AD9D744B6A2CE535A4E5D_86830030 = (this.cursor == null || this.cursor.atEnd());
                    {
                        bufferHeaderValue();
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        boolean var37DDCB866335BA4CFFDA3E754AEC46CB_1550143535 = (!this.cursor.atEnd());
                        {
                            HeaderElement e;
                            e = this.parser.parseHeaderElement(this.buffer, this.cursor);
                            {
                                boolean varF638E443B5A1ABDA5428F9E7711C8D01_1378560035 = (!(e.getName().length() == 0 && e.getValue() == null));
                                {
                                    this.currentElement = e;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var175B52DC687943A501540A48B3FA9D67_721627745 = (this.cursor.atEnd());
                        {
                            this.cursor = null;
                            this.buffer = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.906 -0400", hash_original_method = "7B092A345DC93A80FE3D1D4087DB2A38", hash_generated_method = "AB23A9350F28AFE3899C0295C6D1A296")
    public boolean hasNext() {
        {
            parseNextElement();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317654757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317654757;
        // ---------- Original Method ----------
        //if (this.currentElement == null) {
            //parseNextElement();
        //}
        //return this.currentElement != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.906 -0400", hash_original_method = "242DF42D4654E6C59596DAD87DF1998D", hash_generated_method = "7AC13997B41B1239108532D092ECD392")
    public HeaderElement nextElement() throws NoSuchElementException {
        HeaderElement varB4EAC82CA7396A68D541C85D26508E83_515297229 = null; //Variable for return #1
        {
            parseNextElement();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException("No more header elements available");
        } //End block
        HeaderElement element;
        element = this.currentElement;
        this.currentElement = null;
        varB4EAC82CA7396A68D541C85D26508E83_515297229 = element;
        varB4EAC82CA7396A68D541C85D26508E83_515297229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_515297229;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.915 -0400", hash_original_method = "4D3D2FFF1A269DAEEFECD9D2B54EE606", hash_generated_method = "A76CD0B4AE4659FA5DADF47A41023726")
    public final Object next() throws NoSuchElementException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1572003195 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1572003195 = nextElement();
        varB4EAC82CA7396A68D541C85D26508E83_1572003195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1572003195;
        // ---------- Original Method ----------
        //return nextElement();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.915 -0400", hash_original_method = "4B70E222D9C00405F539E6D61C7F2493", hash_generated_method = "11E3365630BCDCA4B3D11BB4FF46A1B1")
    public void remove() throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Remove not supported");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Remove not supported");
    }

    
}

