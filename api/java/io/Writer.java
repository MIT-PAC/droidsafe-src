package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;





public abstract class Writer implements Appendable, Closeable, Flushable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.824 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.824 -0400", hash_original_method = "673B7AADE5290DAEA83488F65491132B", hash_generated_method = "A151A94197A0C9FE391BFFF503DB9D13")
    protected  Writer() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.825 -0400", hash_original_method = "D96C97132BD2547E52536C41B19A9E8C", hash_generated_method = "D90C7BB8E7BC0A8FEA367EC572EDF19C")
    protected  Writer(Object lock) {
        if(lock == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_163044673 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_163044673.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_163044673;
        } //End block
        this.lock = lock;
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void close() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract void flush() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.826 -0400", hash_original_method = "3613EF644BBA13BB917F4671227467C0", hash_generated_method = "EDB2281A1F92C2B5FD052E7F788E702C")
    public void write(char[] buf) throws IOException {
        addTaint(buf[0]);
        write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //write(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void write(char[] buf, int offset, int count) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.827 -0400", hash_original_method = "8F6AF6BA5D86D88C527DBF804753FF5E", hash_generated_method = "17BF4B55221AAD4DFD06928C874C2969")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.827 -0400", hash_original_method = "2CB0ACB6DB74A20D3FAA9874B0AAEB97", hash_generated_method = "D679F0FD60DA7857A651B895A5562B8C")
    public void write(String str) throws IOException {
        addTaint(str.getTaint());
        write(str, 0, str.length());
        // ---------- Original Method ----------
        //write(str, 0, str.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.827 -0400", hash_original_method = "2D3658401DD29E26DBD40724F9EE6A10", hash_generated_method = "28BFF56728E1C7FBE68733E163FC3824")
    public void write(String str, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        if((offset | count) < 0 || offset > str.length() - count)        
        {
            StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_1688935081 = new StringIndexOutOfBoundsException(str, offset, count);
            varDD6466A465572C8C2EC4C6C733FC9AF8_1688935081.addTaint(taint);
            throw varDD6466A465572C8C2EC4C6C733FC9AF8_1688935081;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.828 -0400", hash_original_method = "9D99658000F160BDAECAED91EC9BFB5D", hash_generated_method = "0A509602C5476E9936C69FAB94D8D80D")
    public Writer append(char c) throws IOException {
        addTaint(c);
        write(c);
Writer var72A74007B2BE62B849F475C7BDA4658B_208249911 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_208249911.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_208249911;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.828 -0400", hash_original_method = "D993D81DE6953743EFA25FF281FB0E15", hash_generated_method = "AE1E49D61EBB6B581D2A33E9A9E196FC")
    public Writer append(CharSequence csq) throws IOException {
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            csq = "null";
        } //End block
        write(csq.toString());
Writer var72A74007B2BE62B849F475C7BDA4658B_1119451712 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1119451712.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1119451712;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.toString());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.829 -0400", hash_original_method = "44B7413EC481F793F1919C886AE2AD0E", hash_generated_method = "172ED5244E526B3A0F8E0FC3EC3D20A4")
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
        if(csq == null)        
        {
            csq = "null";
        } //End block
        write(csq.subSequence(start, end).toString());
Writer var72A74007B2BE62B849F475C7BDA4658B_543795264 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_543795264.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_543795264;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //write(csq.subSequence(start, end).toString());
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.829 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "83E9E99BA1B38F562EC9AB1C29B2FEBD")
     boolean checkError() {
        boolean var68934A3E9455FA72420237EB05902327_140828011 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443684915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_443684915;
        // ---------- Original Method ----------
        //return false;
    }

    
}

