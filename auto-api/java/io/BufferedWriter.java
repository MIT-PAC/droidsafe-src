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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.501 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "0251D9C19BD1379B95D6A9A5D4A8C80D")

    private Writer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.502 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "29466223C47F8B8BB1DFDB9869023C70")

    private char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.502 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.502 -0400", hash_original_method = "D0AF799B17153797A8965CAE82858C8B", hash_generated_method = "4374D4B84A8E9BB7E975D27D1D8AB4A2")
    public  BufferedWriter(Writer out) {
        this(out, 8192);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.502 -0400", hash_original_method = "BD90CD6D32AE7EB9B6CCE31F3688E0F2", hash_generated_method = "BDDEA63F320298F37E76C4A318270339")
    public  BufferedWriter(Writer out, int size) {
        super(out);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("size <= 0");
        } //End block
        this.out = out;
        this.buf = new char[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //this.out = out;
        //this.buf = new char[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.503 -0400", hash_original_method = "1FFBADE50F933DAEBE6B8AB97A0787F1", hash_generated_method = "671C5F5F2E4D78C44D3D67B9AD07A3C5")
    @Override
    public void close() throws IOException {
        {
            {
                boolean var073668DCF2DBBA30CA010AF5A40EF5D1_639730243 = (isClosed());
            } //End collapsed parenthetic
            Throwable thrown = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.503 -0400", hash_original_method = "CDBC99BDF3D706FE5CF6000E4273C9D9", hash_generated_method = "3CEF361F896CE5CCC011D59648FF8B61")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.504 -0400", hash_original_method = "023D06F961F755F2334356A83B61D7A7", hash_generated_method = "1A24BBA5945DBBD9782D5E348CF69D72")
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1233321340 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("BufferedWriter is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("BufferedWriter is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.504 -0400", hash_original_method = "56ED8A50252CAA4A163E554237CE5ACA", hash_generated_method = "A8C600A134459EA77656A476F11E549A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.504 -0400", hash_original_method = "65F785E5C7A072182DBDFA4385D9D27B", hash_generated_method = "579A1FAB058D4DD9CD96409F8E130300")
    private boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580478792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580478792;
        // ---------- Original Method ----------
        //return out == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.504 -0400", hash_original_method = "2B3D7D602A7E63B6C09E849C2D681C65", hash_generated_method = "95268A8136CFE30ED36AA1BE72C081F8")
    public void newLine() throws IOException {
        write(System.lineSeparator());
        // ---------- Original Method ----------
        //write(System.lineSeparator());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.505 -0400", hash_original_method = "2ACD1A4D73C211D3299604BDD7AD25D9", hash_generated_method = "EECE906AD2D7198C53308CEE0D877321")
    @Override
    public void write(char[] cbuf, int offset, int count) throws IOException {
        {
            checkNotClosed();
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
            } //End block
            Arrays.checkOffsetAndCount(cbuf.length, offset, count);
            {
                out.write(cbuf, offset, count);
            } //End block
            int available = this.buf.length - pos;
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
        addTaint(cbuf[0]);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.505 -0400", hash_original_method = "C57AC7B5490B3E246FD3E407701AE232", hash_generated_method = "DF38772FA3DF4ED58430A0C855CC1F67")
    @Override
    public void write(int oneChar) throws IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.506 -0400", hash_original_method = "AE740E7607559E2B849C6855BC31C773", hash_generated_method = "EA9D74B3F3EBF22C598D9619444B2C7B")
    @Override
    public void write(String str, int offset, int count) throws IOException {
        {
            checkNotClosed();
            {
                boolean var2D623A9FEC72D9FC3DAAD61AA5D26F0E_1476419017 = (offset < 0 || offset > str.length() - count);
                {
                    if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
                } //End block
            } //End collapsed parenthetic
            {
                char[] chars = new char[count];
                str.getChars(offset, offset + count, chars, 0);
                out.write(chars, 0, count);
            } //End block
            int available = buf.length - pos;
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
                        char[] chars = new char[count];
                        str.getChars(offset, offset + available, chars, 0);
                        out.write(chars, 0, available);
                    } //End block
                    str.getChars(offset, offset + available, buf, pos);
                    pos += available;
                } //End block
            } //End block
        } //End block
        addTaint(str.getTaint());
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

