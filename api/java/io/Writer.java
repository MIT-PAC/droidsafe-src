package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Writer implements Appendable, Closeable, Flushable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.092 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.092 -0400", hash_original_method = "673B7AADE5290DAEA83488F65491132B", hash_generated_method = "A151A94197A0C9FE391BFFF503DB9D13")
    protected  Writer() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.093 -0400", hash_original_method = "D96C97132BD2547E52536C41B19A9E8C", hash_generated_method = "BB00E91CD43C611D320BF5A4EC1BF022")
    protected  Writer(Object lock) {
    if(lock == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1158691947 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1158691947.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1158691947;
        } //End block
        this.lock = lock;
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    public abstract void close() throws IOException;

    
    public abstract void flush() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.095 -0400", hash_original_method = "3613EF644BBA13BB917F4671227467C0", hash_generated_method = "EDB2281A1F92C2B5FD052E7F788E702C")
    public void write(char[] buf) throws IOException {
        addTaint(buf[0]);
        write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //write(buf, 0, buf.length);
    }

    
    public abstract void write(char[] buf, int offset, int count) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.096 -0400", hash_original_method = "8F6AF6BA5D86D88C527DBF804753FF5E", hash_generated_method = "17BF4B55221AAD4DFD06928C874C2969")
    public void write(int oneChar) throws IOException {
        addTaint(oneChar);
        synchronized
(lock)        {
            char[] oneCharArray = new char[1];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.097 -0400", hash_original_method = "2CB0ACB6DB74A20D3FAA9874B0AAEB97", hash_generated_method = "D679F0FD60DA7857A651B895A5562B8C")
    public void write(String str) throws IOException {
        addTaint(str.getTaint());
        write(str, 0, str.length());
        // ---------- Original Method ----------
        //write(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.097 -0400", hash_original_method = "2D3658401DD29E26DBD40724F9EE6A10", hash_generated_method = "817BE0CA244F0C5CFC3D132C737DD743")
    public void write(String str, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
    if((offset | count) < 0 || offset > str.length() - count)        
        {
            StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_184846063 = new StringIndexOutOfBoundsException(str, offset, count);
            varDD6466A465572C8C2EC4C6C733FC9AF8_184846063.addTaint(taint);
            throw varDD6466A465572C8C2EC4C6C733FC9AF8_184846063;
        } //End block
        char[] buf = new char[count];
        str.getChars(offset, offset + count, buf, 0);
        synchronized
(lock)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.098 -0400", hash_original_method = "9D99658000F160BDAECAED91EC9BFB5D", hash_generated_method = "14A41C84D31EDD37C818F4A6F244BACA")
    public Writer append(char c) throws IOException {
        addTaint(c);
        write(c);
Writer var72A74007B2BE62B849F475C7BDA4658B_1168950461 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1168950461.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1168950461;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.099 -0400", hash_original_method = "D993D81DE6953743EFA25FF281FB0E15", hash_generated_method = "4463EE13E958D016FFFD32C897305D27")
    public Writer append(CharSequence csq) throws IOException {
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } //End block
        write(csq.toString());
Writer var72A74007B2BE62B849F475C7BDA4658B_627038352 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_627038352.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_627038352;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.100 -0400", hash_original_method = "44B7413EC481F793F1919C886AE2AD0E", hash_generated_method = "845925BF7949977F382B5B624E37CF86")
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } //End block
        write(csq.subSequence(start, end).toString());
Writer var72A74007B2BE62B849F475C7BDA4658B_1928818764 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1928818764.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1928818764;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.subSequence(start, end).toString());
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.100 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "B1FDE7C63DEB2588834DDAE6E775F979")
     boolean checkError() {
        boolean var68934A3E9455FA72420237EB05902327_757902764 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448969809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448969809;
        // ---------- Original Method ----------
        //return false;
    }

    
}

