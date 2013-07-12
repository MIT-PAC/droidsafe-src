package java.util.zip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import libcore.io.Streams;

public class DeflaterOutputStream extends FilterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.600 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.600 -0400", hash_original_field = "4ED9407630EB1000C0F6B63842DEFA7D", hash_generated_field = "BB50A00575DEBF8BAC8ED22DB8D1D289")

    protected Deflater def;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.600 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "B3F4B9FB7F6E266775B1E500C6C15A46")

    boolean done = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.600 -0400", hash_original_field = "B3CB03682DEC49A2A9E73B0589312F2F", hash_generated_field = "2E2C89D90D8FD13D5246794A60DDA967")

    private boolean syncFlush;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.601 -0400", hash_original_method = "139234A429000310B925F23DA1712488", hash_generated_method = "F8F8EA1C6A2C8CC5841D7C65FC620FED")
    public  DeflaterOutputStream(OutputStream os, Deflater def) {
        this(os, def, BUF_SIZE, false);
        addTaint(def.getTaint());
        addTaint(os.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.601 -0400", hash_original_method = "D833AEB9A421148720E02F65A02537D6", hash_generated_method = "EC508EC72F547AF9C14FAACCB17F551B")
    public  DeflaterOutputStream(OutputStream os) {
        this(os, new Deflater(), BUF_SIZE, false);
        addTaint(os.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.601 -0400", hash_original_method = "4BB74E5E227C5A90579EB5A36914BC95", hash_generated_method = "19669059882C7D68E35A3DF822C21142")
    public  DeflaterOutputStream(OutputStream os, Deflater def, int bsize) {
        this(os, def, bsize, false);
        addTaint(bsize);
        addTaint(def.getTaint());
        addTaint(os.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.601 -0400", hash_original_method = "4AB400BD05A544E56EC5FA788A743E49", hash_generated_method = "FB66FD477913D2AD65F93BAB6FD83F97")
    public  DeflaterOutputStream(OutputStream os, boolean syncFlush) {
        this(os, new Deflater(), BUF_SIZE, syncFlush);
        addTaint(syncFlush);
        addTaint(os.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.601 -0400", hash_original_method = "030FC273048345BE6683513E5C823172", hash_generated_method = "E26A235F655019C7C5A57E31F5C59720")
    public  DeflaterOutputStream(OutputStream os, Deflater def, boolean syncFlush) {
        this(os, def, BUF_SIZE, syncFlush);
        addTaint(syncFlush);
        addTaint(def.getTaint());
        addTaint(os.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.601 -0400", hash_original_method = "36641FCF7AB1B4FCCCA71F3379196A62", hash_generated_method = "3C40DAA4CD8B0396ED401DC5BFBF8C50")
    public  DeflaterOutputStream(OutputStream os, Deflater def, int bsize, boolean syncFlush) {
        super(os);
        addTaint(os.getTaint());
    if(os == null || def == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2117023211 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2117023211.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2117023211;
        } 
    if(bsize <= 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_942487962 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_942487962.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_942487962;
        } 
        this.def = def;
        this.syncFlush = syncFlush;
        buf = new byte[bsize];
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.602 -0400", hash_original_method = "5BA084DE43D12B9C920D3018364BFA70", hash_generated_method = "CDAF36726627B7EF9181B20BF883146D")
    protected void deflate() throws IOException {
        int byteCount;
        while
((byteCount = def.deflate(buf)) != 0)        
        {
            out.write(buf, 0, byteCount);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.602 -0400", hash_original_method = "9BCFE06D96770C193778FD581B5E01A8", hash_generated_method = "C7C0BAB9767EA3E619F87532FF8B1D11")
    @Override
    public void close() throws IOException {
    if(!def.finished())        
        {
            finish();
        } 
        def.end();
        out.close();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.602 -0400", hash_original_method = "1DDC7258E310FE2F6E87FB700766CEAD", hash_generated_method = "8E768FDE0B9120A7C030A75B5B792406")
    public void finish() throws IOException {
    if(done)        
        {
            return;
        } 
        def.finish();
        while
(!def.finished())        
        {
            int byteCount = def.deflate(buf);
            out.write(buf, 0, byteCount);
        } 
        done = true;
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.602 -0400", hash_original_method = "DD8DF91486AFD685531F1A8944310E80", hash_generated_method = "AB841CB7DA3E92DD3EDA031DF935C98A")
    @Override
    public void write(int i) throws IOException {
        addTaint(i);
        Streams.writeSingleByte(this, i);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.602 -0400", hash_original_method = "5BF353787DD4638B35D7C1FA14989FAE", hash_generated_method = "C6E7C02D0C2862192C5F58D549CA147C")
    @Override
    public void write(byte[] buffer, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buffer[0]);
    if(done)        
        {
            IOException varF29E1D4708786ED420EF7756108AEC17_1123202876 = new IOException("attempt to write after finish");
            varF29E1D4708786ED420EF7756108AEC17_1123202876.addTaint(taint);
            throw varF29E1D4708786ED420EF7756108AEC17_1123202876;
        } 
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
    if(!def.needsInput())        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_978032350 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_978032350.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_978032350;
        } 
        def.setInput(buffer, offset, byteCount);
        deflate();
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.602 -0400", hash_original_method = "FB4F039ED9744680CB15453045EEE574", hash_generated_method = "05380BB10916E6ED4246D94CA8350379")
    @Override
    public void flush() throws IOException {
    if(syncFlush)        
        {
            int byteCount;
            while
((byteCount = def.deflate(buf, 0, buf.length, Deflater.SYNC_FLUSH)) != 0)            
            {
                out.write(buf, 0, byteCount);
            } 
        } 
        out.flush();
        
        
            
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.602 -0400", hash_original_field = "D1C827DB9A3BDE870AF89553E76D4553", hash_generated_field = "A60956B00A99CF9DF92AF09280C120E9")

    static final int BUF_SIZE = 512;
}

