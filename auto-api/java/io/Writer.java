package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class Writer implements Appendable, Closeable, Flushable {
    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "673B7AADE5290DAEA83488F65491132B", hash_generated_method = "0DEB66B4640DD4342CA6E68BE765F107")
    @DSModeled(DSC.SAFE)
    protected Writer() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "D96C97132BD2547E52536C41B19A9E8C", hash_generated_method = "31E0835CE44C08677190B91EC8C2DBD7")
    @DSModeled(DSC.SAFE)
    protected Writer(Object lock) {
        dsTaint.addTaint(lock.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    public abstract void close() throws IOException;

    
    public abstract void flush() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "3613EF644BBA13BB917F4671227467C0", hash_generated_method = "8642F7C174C8975BB87F81728344B0D3")
    @DSModeled(DSC.SAFE)
    public void write(char[] buf) throws IOException {
        dsTaint.addTaint(buf);
        write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //write(buf, 0, buf.length);
    }

    
    public abstract void write(char[] buf, int offset, int count) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "8F6AF6BA5D86D88C527DBF804753FF5E", hash_generated_method = "2F413AA4CE89737B61D9BE20E9F3FD08")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "2CB0ACB6DB74A20D3FAA9874B0AAEB97", hash_generated_method = "E0E7162C5AA6C88870ED4B1546192C94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(String str) throws IOException {
        dsTaint.addTaint(str);
        write(str, 0, str.length());
        // ---------- Original Method ----------
        //write(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "2D3658401DD29E26DBD40724F9EE6A10", hash_generated_method = "4098D64B2D1C6A7A9666AFD9AF533A54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(String str, int offset, int count) throws IOException {
        dsTaint.addTaint(str);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            boolean var692490DEFA1D61E18F718478B787B00C_2136198034 = ((offset | count) < 0 || offset > str.length() - count);
            {
                throw new StringIndexOutOfBoundsException(str, offset, count);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "9D99658000F160BDAECAED91EC9BFB5D", hash_generated_method = "51768D62E32C034FD5DD0205C499DD18")
    @DSModeled(DSC.SAFE)
    public Writer append(char c) throws IOException {
        dsTaint.addTaint(c);
        write(c);
        return (Writer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "D993D81DE6953743EFA25FF281FB0E15", hash_generated_method = "C59823CF2141DBC888EACAC24C33FA6A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "44B7413EC481F793F1919C886AE2AD0E", hash_generated_method = "C6C3DF86647037F210F81F1854D4A8ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.714 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "72670A334E89D74D531B4ECE74FAA78A")
    @DSModeled(DSC.SAFE)
     boolean checkError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}


