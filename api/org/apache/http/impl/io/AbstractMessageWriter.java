package org.apache.http.impl.io;

// Droidsafe Imports
import java.io.IOException;
import java.util.Iterator;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AbstractMessageWriter implements HttpMessageWriter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.384 -0400", hash_original_field = "C5C1A1B9CB00AE65F16C20243BC76E0D", hash_generated_field = "7546C8F84D7739D4A1BA10808E25B0AE")

    protected SessionOutputBuffer sessionBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.384 -0400", hash_original_field = "DD77BBE950DCBAAE75A78BE6835B370C", hash_generated_field = "3CE530BC037559228F5322CB75C414E0")

    protected CharArrayBuffer lineBuf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.384 -0400", hash_original_field = "F9CE68A7F7D0CBA6428185FFD4DE4D25", hash_generated_field = "9B2BF02A5898CE488D537E86AD344847")

    protected LineFormatter lineFormatter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.385 -0400", hash_original_method = "81470EB0FA2062B136A4D8177B3454ED", hash_generated_method = "E8D22AC1D377D9998615507FFD34F612")
    public  AbstractMessageWriter(final SessionOutputBuffer buffer,
                                 final LineFormatter formatter,
                                 final HttpParams params) {
        super();
        addTaint(params.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException varB3677395451B18A3F9262E9D7FE254B3_258676033 = new IllegalArgumentException("Session input buffer may not be null");
            varB3677395451B18A3F9262E9D7FE254B3_258676033.addTaint(taint);
            throw varB3677395451B18A3F9262E9D7FE254B3_258676033;
        } //End block
        this.sessionBuffer = buffer;
        this.lineBuf = new CharArrayBuffer(128);
        this.lineFormatter = (formatter != null) ?
            formatter : BasicLineFormatter.DEFAULT;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IllegalArgumentException("Session input buffer may not be null");
        //}
        //this.sessionBuffer = buffer;
        //this.lineBuf = new CharArrayBuffer(128);
        //this.lineFormatter = (formatter != null) ?
            //formatter : BasicLineFormatter.DEFAULT;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void writeHeadLine(HttpMessage message)
        throws IOException
        ;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.385 -0400", hash_original_method = "33F4F2FFED23975C76AB7BEDB0A8854B", hash_generated_method = "AC7B21EA6D46637C22D239D4E28BFE18")
    public void write(
            final HttpMessage message) throws IOException, HttpException {
        addTaint(message.getTaint());
        if(message == null)        
        {
            IllegalArgumentException var1AA7713A32BCFE0974EC5B02C04D6E20_1447833022 = new IllegalArgumentException("HTTP message may not be null");
            var1AA7713A32BCFE0974EC5B02C04D6E20_1447833022.addTaint(taint);
            throw var1AA7713A32BCFE0974EC5B02C04D6E20_1447833022;
        } //End block
        writeHeadLine(message);
for(Iterator it = message.headerIterator();it.hasNext();)
        {
            Header header = (Header) it.next();
            this.sessionBuffer.writeLine
                (lineFormatter.formatHeader(this.lineBuf, header));
        } //End block
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
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

