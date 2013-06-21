package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import libcore.util.SneakyThrow;

public class BufferedWriter extends Writer {
    private Writer out;
    private char[] buf;
    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.425 -0400", hash_original_method = "D0AF799B17153797A8965CAE82858C8B", hash_generated_method = "71A180186F040996B33B21C7911395E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedWriter(Writer out) {
        this(out, 8192);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.425 -0400", hash_original_method = "BD90CD6D32AE7EB9B6CCE31F3688E0F2", hash_generated_method = "378E1ABC0F5252C78383E8018FC52E57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BufferedWriter(Writer out, int size) {
        super(out);
        dsTaint.addTaint(size);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } //End block
        this.buf = new char[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //this.out = out;
        //this.buf = new char[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.426 -0400", hash_original_method = "1FFBADE50F933DAEBE6B8AB97A0787F1", hash_generated_method = "A705606A0993AB0F4F2CF1EF964CC84D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            {
                boolean var073668DCF2DBBA30CA010AF5A40EF5D1_313744168 = (isClosed());
            } //End collapsed parenthetic
            Throwable thrown;
            thrown = null;
            try 
            {
                flushInternal();
            } //End block
            catch (Throwable e)
            {
                thrown = e;
            } //End block
            buf = null;
            try 
            {
                out.close();
            } //End block
            catch (Throwable e)
            {
                {
                    thrown = e;
                } //End block
            } //End block
            out = null;
            {
                SneakyThrow.sneakyThrow(thrown);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (isClosed()) {
                //return;
            //}
            //Throwable thrown = null;
            //try {
                //flushInternal();
            //} catch (Throwable e) {
                //thrown = e;
            //}
            //buf = null;
            //try {
                //out.close();
            //} catch (Throwable e) {
                //if (thrown == null) {
                    //thrown = e;
                //}
            //}
            //out = null;
            //if (thrown != null) {
                //SneakyThrow.sneakyThrow(thrown);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.426 -0400", hash_original_method = "CDBC99BDF3D706FE5CF6000E4273C9D9", hash_generated_method = "3CEF361F896CE5CCC011D59648FF8B61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void flush() throws IOException {
        {
            checkNotClosed();
            flushInternal();
            out.flush();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //flushInternal();
            //out.flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.426 -0400", hash_original_method = "023D06F961F755F2334356A83B61D7A7", hash_generated_method = "DEB13054089A24AA67E3786DC7042EFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_2006913214 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("BufferedWriter is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("BufferedWriter is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.426 -0400", hash_original_method = "56ED8A50252CAA4A163E554237CE5ACA", hash_generated_method = "A8C600A134459EA77656A476F11E549A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flushInternal() throws IOException {
        {
            out.write(buf, 0, pos);
        } //End block
        pos = 0;
        // ---------- Original Method ----------
        //if (pos > 0) {
            //out.write(buf, 0, pos);
        //}
        //pos = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.426 -0400", hash_original_method = "65F785E5C7A072182DBDFA4385D9D27B", hash_generated_method = "22B90F664085D6824B9017421A267F06")
    @DSModeled(DSC.SAFE)
    private boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return out == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.427 -0400", hash_original_method = "2B3D7D602A7E63B6C09E849C2D681C65", hash_generated_method = "95268A8136CFE30ED36AA1BE72C081F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void newLine() throws IOException {
        write(System.lineSeparator());
        // ---------- Original Method ----------
        //write(System.lineSeparator());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.427 -0400", hash_original_method = "2ACD1A4D73C211D3299604BDD7AD25D9", hash_generated_method = "06C42B169BB5A574C4E3BDE5E118FDBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(char[] cbuf, int offset, int count) throws IOException {
        dsTaint.addTaint(cbuf[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            checkNotClosed();
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
            } //End block
            Arrays.checkOffsetAndCount(cbuf.length, offset, count);
            {
                out.write(cbuf, offset, count);
            } //End block
            int available;
            available = this.buf.length - pos;
            {
                available = count;
            } //End block
            {
                System.arraycopy(cbuf, offset, this.buf, pos, available);
                pos += available;
            } //End block
            {
                out.write(this.buf, 0, this.buf.length);
                pos = 0;
                {
                    offset += available;
                    available = count - available;
                    {
                        out.write(cbuf, offset, available);
                    } //End block
                    System.arraycopy(cbuf, offset, this.buf, pos, available);
                    pos += available;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.427 -0400", hash_original_method = "C57AC7B5490B3E246FD3E407701AE232", hash_generated_method = "83F803456A6A4258301C2FD22DAE261E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(int oneChar) throws IOException {
        dsTaint.addTaint(oneChar);
        {
            checkNotClosed();
            {
                out.write(buf, 0, buf.length);
                pos = 0;
            } //End block
            buf[pos++] = (char) oneChar;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkNotClosed();
            //if (pos >= buf.length) {
                //out.write(buf, 0, buf.length);
                //pos = 0;
            //}
            //buf[pos++] = (char) oneChar;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.428 -0400", hash_original_method = "AE740E7607559E2B849C6855BC31C773", hash_generated_method = "ED4ADE4D2966C02223F8000F38ED96BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str, int offset, int count) throws IOException {
        dsTaint.addTaint(count);
        dsTaint.addTaint(str);
        dsTaint.addTaint(offset);
        {
            checkNotClosed();
            {
                boolean var2D623A9FEC72D9FC3DAAD61AA5D26F0E_124151862 = (offset < 0 || offset > str.length() - count);
                {
                    if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
                } //End block
            } //End collapsed parenthetic
            {
                char[] chars;
                chars = new char[count];
                str.getChars(offset, offset + count, chars, 0);
                out.write(chars, 0, count);
            } //End block
            int available;
            available = buf.length - pos;
            {
                available = count;
            } //End block
            {
                str.getChars(offset, offset + available, buf, pos);
                pos += available;
            } //End block
            {
                out.write(this.buf, 0, this.buf.length);
                pos = 0;
                {
                    offset += available;
                    available = count - available;
                    {
                        char[] chars;
                        chars = new char[count];
                        str.getChars(offset, offset + available, chars, 0);
                        out.write(chars, 0, available);
                    } //End block
                    str.getChars(offset, offset + available, buf, pos);
                    pos += available;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

