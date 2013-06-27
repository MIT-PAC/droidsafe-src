package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import libcore.io.Streams;

public class DeflaterOutputStream extends FilterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.732 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.732 -0400", hash_original_field = "4ED9407630EB1000C0F6B63842DEFA7D", hash_generated_field = "BB50A00575DEBF8BAC8ED22DB8D1D289")

    protected Deflater def;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.732 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "B3F4B9FB7F6E266775B1E500C6C15A46")

    boolean done = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.732 -0400", hash_original_field = "B3CB03682DEC49A2A9E73B0589312F2F", hash_generated_field = "2E2C89D90D8FD13D5246794A60DDA967")

    private boolean syncFlush;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.732 -0400", hash_original_method = "139234A429000310B925F23DA1712488", hash_generated_method = "8C2BD5B067A082107AABA5005F1433F5")
    public  DeflaterOutputStream(OutputStream os, Deflater def) {
        this(os, def, BUF_SIZE, false);
        addTaint(os.getTaint());
        addTaint(def.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.732 -0400", hash_original_method = "D833AEB9A421148720E02F65A02537D6", hash_generated_method = "EC508EC72F547AF9C14FAACCB17F551B")
    public  DeflaterOutputStream(OutputStream os) {
        this(os, new Deflater(), BUF_SIZE, false);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.733 -0400", hash_original_method = "4BB74E5E227C5A90579EB5A36914BC95", hash_generated_method = "A34650E425F29FF66AAA06F1AE263AB3")
    public  DeflaterOutputStream(OutputStream os, Deflater def, int bsize) {
        this(os, def, bsize, false);
        addTaint(os.getTaint());
        addTaint(def.getTaint());
        addTaint(bsize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.733 -0400", hash_original_method = "4AB400BD05A544E56EC5FA788A743E49", hash_generated_method = "36403AC904CBCB23B6FA830AF353B48E")
    public  DeflaterOutputStream(OutputStream os, boolean syncFlush) {
        this(os, new Deflater(), BUF_SIZE, syncFlush);
        addTaint(os.getTaint());
        addTaint(syncFlush);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.733 -0400", hash_original_method = "030FC273048345BE6683513E5C823172", hash_generated_method = "643907DAF595783EE576C67CBD8C1C5D")
    public  DeflaterOutputStream(OutputStream os, Deflater def, boolean syncFlush) {
        this(os, def, BUF_SIZE, syncFlush);
        addTaint(os.getTaint());
        addTaint(def.getTaint());
        addTaint(syncFlush);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.734 -0400", hash_original_method = "36641FCF7AB1B4FCCCA71F3379196A62", hash_generated_method = "9855B52CFB166AAEB80E96E54FC71B2C")
    public  DeflaterOutputStream(OutputStream os, Deflater def, int bsize, boolean syncFlush) {
        super(os);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        this.def = def;
        this.syncFlush = syncFlush;
        buf = new byte[bsize];
        addTaint(os.getTaint());
        // ---------- Original Method ----------
        //if (os == null || def == null) {
            //throw new NullPointerException();
        //}
        //if (bsize <= 0) {
            //throw new IllegalArgumentException();
        //}
        //this.def = def;
        //this.syncFlush = syncFlush;
        //buf = new byte[bsize];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.748 -0400", hash_original_method = "5BA084DE43D12B9C920D3018364BFA70", hash_generated_method = "6CD86EAAEE291262606ED4DDA4033606")
    protected void deflate() throws IOException {
        int byteCount;
        {
            boolean var10D15E07E44197B12500ABC2F24406C5_1449201990 = ((byteCount = def.deflate(buf)) != 0);
            {
                out.write(buf, 0, byteCount);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int byteCount;
        //while ((byteCount = def.deflate(buf)) != 0) {
            //out.write(buf, 0, byteCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.749 -0400", hash_original_method = "9BCFE06D96770C193778FD581B5E01A8", hash_generated_method = "078B23064A440E0FEEF5EAADA52EB4B0")
    @Override
    public void close() throws IOException {
        {
            boolean var5EEBAAE4DB8BCC872AF863B44E5D6E21_37792446 = (!def.finished());
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        def.end();
        out.close();
        // ---------- Original Method ----------
        //if (!def.finished()) {
            //finish();
        //}
        //def.end();
        //out.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.750 -0400", hash_original_method = "1DDC7258E310FE2F6E87FB700766CEAD", hash_generated_method = "364B47496483E185F38034B263178C6A")
    public void finish() throws IOException {
        def.finish();
        {
            boolean var5EEBAAE4DB8BCC872AF863B44E5D6E21_1574912428 = (!def.finished());
            {
                int byteCount;
                byteCount = def.deflate(buf);
                out.write(buf, 0, byteCount);
            } //End block
        } //End collapsed parenthetic
        done = true;
        // ---------- Original Method ----------
        //if (done) {
            //return;
        //}
        //def.finish();
        //while (!def.finished()) {
            //int byteCount = def.deflate(buf);
            //out.write(buf, 0, byteCount);
        //}
        //done = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.750 -0400", hash_original_method = "DD8DF91486AFD685531F1A8944310E80", hash_generated_method = "2205273C4F9905F6B7DC49EF87BB045E")
    @Override
    public void write(int i) throws IOException {
        Streams.writeSingleByte(this, i);
        addTaint(i);
        // ---------- Original Method ----------
        //Streams.writeSingleByte(this, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.754 -0400", hash_original_method = "5BF353787DD4638B35D7C1FA14989FAE", hash_generated_method = "A622D735F256FC72F6C997F1D336ACFA")
    @Override
    public void write(byte[] buffer, int offset, int byteCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("attempt to write after finish");
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        {
            boolean var763D854B5CEA8050FEC4551761112056_1116879434 = (!def.needsInput());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } //End block
        } //End collapsed parenthetic
        def.setInput(buffer, offset, byteCount);
        deflate();
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //if (done) {
            //throw new IOException("attempt to write after finish");
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        //if (!def.needsInput()) {
            //throw new IOException();
        //}
        //def.setInput(buffer, offset, byteCount);
        //deflate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.775 -0400", hash_original_method = "FB4F039ED9744680CB15453045EEE574", hash_generated_method = "4CFBF24FE2D877F6322DB797DE451C2B")
    @Override
    public void flush() throws IOException {
        {
            int byteCount;
            {
                boolean var1429AD011F1A43D28EAB20F39BEE93C0_1673533691 = ((byteCount = def.deflate(buf, 0, buf.length, Deflater.SYNC_FLUSH)) != 0);
                {
                    out.write(buf, 0, byteCount);
                } //End block
            } //End collapsed parenthetic
        } //End block
        out.flush();
        // ---------- Original Method ----------
        //if (syncFlush) {
            //int byteCount;
            //while ((byteCount = def.deflate(buf, 0, buf.length, Deflater.SYNC_FLUSH)) != 0) {
                //out.write(buf, 0, byteCount);
            //}
        //}
        //out.flush();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.775 -0400", hash_original_field = "D1C827DB9A3BDE870AF89553E76D4553", hash_generated_field = "9880536815CC2F93011C070CDDEA4810")

    static int BUF_SIZE = 512;
}

