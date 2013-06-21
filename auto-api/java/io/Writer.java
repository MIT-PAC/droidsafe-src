package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Writer implements Appendable, Closeable, Flushable {
    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.358 -0400", hash_original_method = "673B7AADE5290DAEA83488F65491132B", hash_generated_method = "A151A94197A0C9FE391BFFF503DB9D13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Writer() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.358 -0400", hash_original_method = "D96C97132BD2547E52536C41B19A9E8C", hash_generated_method = "D1749FE32FF23B016759BFE32BC264E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Writer(Object lock) {
        dsTaint.addTaint(lock.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    public abstract void close() throws IOException;

    
    public abstract void flush() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.359 -0400", hash_original_method = "3613EF644BBA13BB917F4671227467C0", hash_generated_method = "AC94E8EFD96218E04311A687E74B3C40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(char[] buf) throws IOException {
        dsTaint.addTaint(buf[0]);
        write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //write(buf, 0, buf.length);
    }

    
    public abstract void write(char[] buf, int offset, int count) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.359 -0400", hash_original_method = "8F6AF6BA5D86D88C527DBF804753FF5E", hash_generated_method = "11286F9F58AB95FF79C4D8713CA9E2DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(int oneChar) throws IOException {
        dsTaint.addTaint(oneChar);
        {
            char[] oneCharArray;
            oneCharArray = new char[1];
            oneCharArray[0] = (char) oneChar;
            write(oneCharArray);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] oneCharArray = new char[1];
            //oneCharArray[0] = (char) oneChar;
            //write(oneCharArray);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.359 -0400", hash_original_method = "2CB0ACB6DB74A20D3FAA9874B0AAEB97", hash_generated_method = "CD7C4AF4AE7689375AE7813E8238B72D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(String str) throws IOException {
        dsTaint.addTaint(str);
        write(str, 0, str.length());
        // ---------- Original Method ----------
        //write(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.360 -0400", hash_original_method = "2D3658401DD29E26DBD40724F9EE6A10", hash_generated_method = "54C16B6F3B240ED25CA98F6B452AECE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(String str, int offset, int count) throws IOException {
        dsTaint.addTaint(count);
        dsTaint.addTaint(str);
        dsTaint.addTaint(offset);
        {
            boolean var692490DEFA1D61E18F718478B787B00C_230834954 = ((offset | count) < 0 || offset > str.length() - count);
            {
                if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
            } //End block
        } //End collapsed parenthetic
        char[] buf;
        buf = new char[count];
        str.getChars(offset, offset + count, buf, 0);
        {
            write(buf, 0, buf.length);
        } //End block
        // ---------- Original Method ----------
        //if ((offset | count) < 0 || offset > str.length() - count) {
            //throw new StringIndexOutOfBoundsException(str, offset, count);
        //}
        //char[] buf = new char[count];
        //str.getChars(offset, offset + count, buf, 0);
        //synchronized (lock) {
            //write(buf, 0, buf.length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.360 -0400", hash_original_method = "9D99658000F160BDAECAED91EC9BFB5D", hash_generated_method = "C32A527B2E0F876ED5C0AF429553DA84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Writer append(char c) throws IOException {
        dsTaint.addTaint(c);
        write(c);
        return (Writer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.360 -0400", hash_original_method = "D993D81DE6953743EFA25FF281FB0E15", hash_generated_method = "CC24810DB57B13AFE6F8C296B08D6560")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Writer append(CharSequence csq) throws IOException {
        dsTaint.addTaint(csq);
        {
            csq = "null";
        } //End block
        write(csq.toString());
        return (Writer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.360 -0400", hash_original_method = "44B7413EC481F793F1919C886AE2AD0E", hash_generated_method = "552F6DEAB7D4D8378D5D90F372540C0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        dsTaint.addTaint(start);
        dsTaint.addTaint(csq);
        dsTaint.addTaint(end);
        {
            csq = "null";
        } //End block
        write(csq.subSequence(start, end).toString());
        return (Writer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.subSequence(start, end).toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.361 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "FDE27047AB1931599767795C9C8BC350")
    @DSModeled(DSC.SAFE)
     boolean checkError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}

