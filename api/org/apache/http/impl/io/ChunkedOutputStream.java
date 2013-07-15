package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

public class ChunkedOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.155 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "77BC14A656F9BA385AF4199F8E7C3C1D")

    private SessionOutputBuffer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.155 -0400", hash_original_field = "0FEA6A13C52B4D4725368F24B045CA84", hash_generated_field = "EBA08CF4C3E674FAE289C26AD80951B3")

    private byte[] cache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.155 -0400", hash_original_field = "46E3E8CFBDA7F68778B66F017C5C2FE1", hash_generated_field = "8AF6C10D15ADA8AC990219FA73C4C6FF")

    private int cachePosition = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.155 -0400", hash_original_field = "5AC2988E242259708AF30EE611285F47", hash_generated_field = "079555C6CADEB50B1BB49A96B89EAB4C")

    private boolean wroteLastChunk = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.155 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.156 -0400", hash_original_method = "56C47BEE54D84D2C2F06C5F3380F6FB5", hash_generated_method = "13922ECA8643BCE0F6F9E2C85B378856")
    public  ChunkedOutputStream(final SessionOutputBuffer out, int bufferSize) throws IOException {
        super();
        this.cache = new byte[bufferSize];
        this.out = out;
        // ---------- Original Method ----------
        //this.cache = new byte[bufferSize];
        //this.out = out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.156 -0400", hash_original_method = "0998BD1AC5B9537C7B2BFA3E832ED71A", hash_generated_method = "D4570D00A61C6FB90014617F162A887A")
    public  ChunkedOutputStream(final SessionOutputBuffer out) throws IOException {
        this(out, 2048);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.157 -0400", hash_original_method = "320F140F8D57B27D338CDA0750999A03", hash_generated_method = "24651ED8CD5565703872EAAEB1079B47")
    protected void flushCache() throws IOException {
    if(this.cachePosition > 0)        
        {
            this.out.writeLine(Integer.toHexString(this.cachePosition));
            this.out.write(this.cache, 0, this.cachePosition);
            this.out.writeLine("");
            this.cachePosition = 0;
        } //End block
        // ---------- Original Method ----------
        //if (this.cachePosition > 0) {
            //this.out.writeLine(Integer.toHexString(this.cachePosition));
            //this.out.write(this.cache, 0, this.cachePosition);
            //this.out.writeLine("");
            //this.cachePosition = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.157 -0400", hash_original_method = "B6A1CB3240895E2E2F127D1796BCAECF", hash_generated_method = "65D804933EB4153CC6FAC13E20289400")
    protected void flushCacheWithAppend(byte bufferToAppend[], int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(bufferToAppend[0]);
        this.out.writeLine(Integer.toHexString(this.cachePosition + len));
        this.out.write(this.cache, 0, this.cachePosition);
        this.out.write(bufferToAppend, off, len);
        this.out.writeLine("");
        this.cachePosition = 0;
        // ---------- Original Method ----------
        //this.out.writeLine(Integer.toHexString(this.cachePosition + len));
        //this.out.write(this.cache, 0, this.cachePosition);
        //this.out.write(bufferToAppend, off, len);
        //this.out.writeLine("");
        //this.cachePosition = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.158 -0400", hash_original_method = "967E1BC0792D48B7189E3B566BF7EE9B", hash_generated_method = "A8D8CA5274DD64B5F9C5A1D621BA437B")
    protected void writeClosingChunk() throws IOException {
        this.out.writeLine("0");
        this.out.writeLine("");
        // ---------- Original Method ----------
        //this.out.writeLine("0");
        //this.out.writeLine("");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.158 -0400", hash_original_method = "48C91C3E7A4F39D8E60BF0ABE327AC31", hash_generated_method = "3FDAC3B070CD42C7A1F64954F4D7BF84")
    public void finish() throws IOException {
    if(!this.wroteLastChunk)        
        {
            flushCache();
            writeClosingChunk();
            this.wroteLastChunk = true;
        } //End block
        // ---------- Original Method ----------
        //if (!this.wroteLastChunk) {
            //flushCache();
            //writeClosingChunk();
            //this.wroteLastChunk = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.158 -0400", hash_original_method = "97963AB3B21DB4797CA6C19C718B8A38", hash_generated_method = "10485433EF2AFBE6389B1ECD83F83636")
    public void write(int b) throws IOException {
    if(this.closed)        
        {
            IOException varB052DBEEB15E0A31B3EDC9E0CDC85E32_1325239503 = new IOException("Attempted write to closed stream.");
            varB052DBEEB15E0A31B3EDC9E0CDC85E32_1325239503.addTaint(taint);
            throw varB052DBEEB15E0A31B3EDC9E0CDC85E32_1325239503;
        } //End block
        this.cache[this.cachePosition] = (byte) b;
        this.cachePosition++;
    if(this.cachePosition == this.cache.length)        
        flushCache();
        // ---------- Original Method ----------
        //if (this.closed) {
            //throw new IOException("Attempted write to closed stream.");
        //}
        //this.cache[this.cachePosition] = (byte) b;
        //this.cachePosition++;
        //if (this.cachePosition == this.cache.length) flushCache();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.159 -0400", hash_original_method = "3A39FD94F4678FF92F02222292608085", hash_generated_method = "0D12FC600229B512F27E34195CC74680")
    public void write(byte b[]) throws IOException {
        addTaint(b[0]);
        write(b, 0, b.length);
        // ---------- Original Method ----------
        //write(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.160 -0400", hash_original_method = "CCAB33DDE1A6D08280EC0BE0610A6B79", hash_generated_method = "D38AF9DF4493AF421E22C36448394C03")
    public void write(byte src[], int off, int len) throws IOException {
        addTaint(off);
        addTaint(src[0]);
    if(this.closed)        
        {
            IOException varB052DBEEB15E0A31B3EDC9E0CDC85E32_1964634894 = new IOException("Attempted write to closed stream.");
            varB052DBEEB15E0A31B3EDC9E0CDC85E32_1964634894.addTaint(taint);
            throw varB052DBEEB15E0A31B3EDC9E0CDC85E32_1964634894;
        } //End block
    if(len >= this.cache.length - this.cachePosition)        
        {
            flushCacheWithAppend(src, off, len);
        } //End block
        else
        {
            System.arraycopy(src, off, cache, this.cachePosition, len);
            this.cachePosition += len;
        } //End block
        // ---------- Original Method ----------
        //if (this.closed) {
            //throw new IOException("Attempted write to closed stream.");
        //}
        //if (len >= this.cache.length - this.cachePosition) {
            //flushCacheWithAppend(src, off, len);
        //} else {
            //System.arraycopy(src, off, cache, this.cachePosition, len);
            //this.cachePosition += len;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.160 -0400", hash_original_method = "1D035E07BE479B8A909681E6BF90CFBD", hash_generated_method = "A492F731C1F84352887E9BB507A040A1")
    public void flush() throws IOException {
        flushCache();
        this.out.flush();
        // ---------- Original Method ----------
        //flushCache();
        //this.out.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.161 -0400", hash_original_method = "E495FD5BB343CF99481A29E811E92BD2", hash_generated_method = "B11B90BB85CBB573ACA2B305EEAF5E66")
    public void close() throws IOException {
    if(!this.closed)        
        {
            this.closed = true;
            finish();
            this.out.flush();
        } //End block
        // ---------- Original Method ----------
        //if (!this.closed) {
            //this.closed = true;
            //finish();
            //this.out.flush();
        //}
    }

    
}

