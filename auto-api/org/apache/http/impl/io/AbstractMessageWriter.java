package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractMessageWriter implements HttpMessageWriter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.597 -0400", hash_original_field = "C5C1A1B9CB00AE65F16C20243BC76E0D", hash_generated_field = "7546C8F84D7739D4A1BA10808E25B0AE")

    protected SessionOutputBuffer sessionBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.598 -0400", hash_original_field = "DD77BBE950DCBAAE75A78BE6835B370C", hash_generated_field = "3CE530BC037559228F5322CB75C414E0")

    protected CharArrayBuffer lineBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.598 -0400", hash_original_field = "F9CE68A7F7D0CBA6428185FFD4DE4D25", hash_generated_field = "9B2BF02A5898CE488D537E86AD344847")

    protected LineFormatter lineFormatter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.598 -0400", hash_original_method = "81470EB0FA2062B136A4D8177B3454ED", hash_generated_method = "461E4520B327CC37BA23EC57A5590617")
    public  AbstractMessageWriter(final SessionOutputBuffer buffer,
                                 final LineFormatter formatter,
                                 final HttpParams params) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session input buffer may not be null");
        } //End block
        this.sessionBuffer = buffer;
        this.lineBuf = new CharArrayBuffer(128);
        this.lineFormatter = (formatter != null) ?
            formatter : BasicLineFormatter.DEFAULT;
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IllegalArgumentException("Session input buffer may not be null");
        //}
        //this.sessionBuffer = buffer;
        //this.lineBuf = new CharArrayBuffer(128);
        //this.lineFormatter = (formatter != null) ?
            //formatter : BasicLineFormatter.DEFAULT;
    }

    
    protected abstract void writeHeadLine(HttpMessage message)
        throws IOException
        ;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.599 -0400", hash_original_method = "33F4F2FFED23975C76AB7BEDB0A8854B", hash_generated_method = "976A5D0E008188ECD169729D2CB72B02")
    public void write(
            final HttpMessage message) throws IOException, HttpException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP message may not be null");
        } //End block
        writeHeadLine(message);
        {
            Iterator it;
            it = message.headerIterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_650275615 = (it.hasNext());
            {
                Header header;
                header = (Header) it.next();
                this.sessionBuffer.writeLine
                (lineFormatter.formatHeader(this.lineBuf, header));
            } //End block
        } //End collapsed parenthetic
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //if (message == null) {
            //throw new IllegalArgumentException("HTTP message may not be null");
        //}
        //writeHeadLine(message);
        //for (Iterator it = message.headerIterator(); it.hasNext(); ) {
            //Header header = (Header) it.next();
            //this.sessionBuffer.writeLine
                //(lineFormatter.formatHeader(this.lineBuf, header));
        //}
        //this.lineBuf.clear();
        //this.sessionBuffer.writeLine(this.lineBuf);
    }

    
}

