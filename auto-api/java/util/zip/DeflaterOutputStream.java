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
    protected byte[] buf;
    protected Deflater def;
    boolean done = false;
    private boolean syncFlush;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.723 -0400", hash_original_method = "139234A429000310B925F23DA1712488", hash_generated_method = "9D624FC5E5B82443CAF78E81C9992418")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeflaterOutputStream(OutputStream os, Deflater def) {
        this(os, def, BUF_SIZE, false);
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(def.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.723 -0400", hash_original_method = "D833AEB9A421148720E02F65A02537D6", hash_generated_method = "02F19FB47BFB7D49D6A1883869C45279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeflaterOutputStream(OutputStream os) {
        this(os, new Deflater(), BUF_SIZE, false);
        dsTaint.addTaint(os.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.724 -0400", hash_original_method = "4BB74E5E227C5A90579EB5A36914BC95", hash_generated_method = "382F5FC54CF0DD77DE407FC7A324CD88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeflaterOutputStream(OutputStream os, Deflater def, int bsize) {
        this(os, def, bsize, false);
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(bsize);
        dsTaint.addTaint(def.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.724 -0400", hash_original_method = "4AB400BD05A544E56EC5FA788A743E49", hash_generated_method = "7F4C94A32248C1534BC17E08DE5C9423")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeflaterOutputStream(OutputStream os, boolean syncFlush) {
        this(os, new Deflater(), BUF_SIZE, syncFlush);
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(syncFlush);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.724 -0400", hash_original_method = "030FC273048345BE6683513E5C823172", hash_generated_method = "568629293BFC5552E4B5A5D1EB42CE95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeflaterOutputStream(OutputStream os, Deflater def, boolean syncFlush) {
        this(os, def, BUF_SIZE, syncFlush);
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(def.dsTaint);
        dsTaint.addTaint(syncFlush);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.724 -0400", hash_original_method = "36641FCF7AB1B4FCCCA71F3379196A62", hash_generated_method = "527B5606426230DD8ABC7D5434C430D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeflaterOutputStream(OutputStream os, Deflater def, int bsize, boolean syncFlush) {
        super(os);
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(bsize);
        dsTaint.addTaint(def.dsTaint);
        dsTaint.addTaint(syncFlush);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        buf = new byte[bsize];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.724 -0400", hash_original_method = "5BA084DE43D12B9C920D3018364BFA70", hash_generated_method = "54E3B8C10C31AC10AFADDAA5F74BC6F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void deflate() throws IOException {
        int byteCount;
        {
            boolean var10D15E07E44197B12500ABC2F24406C5_1844323912 = ((byteCount = def.deflate(buf)) != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.725 -0400", hash_original_method = "9BCFE06D96770C193778FD581B5E01A8", hash_generated_method = "5CFB533E2D38ADC40DF48A68E404686E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            boolean var5EEBAAE4DB8BCC872AF863B44E5D6E21_1180318652 = (!def.finished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.725 -0400", hash_original_method = "1DDC7258E310FE2F6E87FB700766CEAD", hash_generated_method = "BEEC95A8FC81CA62125E4B145C22F4F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finish() throws IOException {
        def.finish();
        {
            boolean var5EEBAAE4DB8BCC872AF863B44E5D6E21_1953018852 = (!def.finished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.725 -0400", hash_original_method = "DD8DF91486AFD685531F1A8944310E80", hash_generated_method = "C156A28998641F851570125274DD6C89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(int i) throws IOException {
        dsTaint.addTaint(i);
        Streams.writeSingleByte(this, i);
        // ---------- Original Method ----------
        //Streams.writeSingleByte(this, i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.725 -0400", hash_original_method = "5BF353787DD4638B35D7C1FA14989FAE", hash_generated_method = "6EC75EE5E6A4F91A4CCA13F747B8FCF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] buffer, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("attempt to write after finish");
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        {
            boolean var763D854B5CEA8050FEC4551761112056_200826546 = (!def.needsInput());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } //End block
        } //End collapsed parenthetic
        def.setInput(buffer, offset, byteCount);
        deflate();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.726 -0400", hash_original_method = "FB4F039ED9744680CB15453045EEE574", hash_generated_method = "DCAF0B99C15BC61066DAF5458D464B56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void flush() throws IOException {
        {
            int byteCount;
            {
                boolean var1429AD011F1A43D28EAB20F39BEE93C0_1611417385 = ((byteCount = def.deflate(buf, 0, buf.length, Deflater.SYNC_FLUSH)) != 0);
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

    
    static final int BUF_SIZE = 512;
}

