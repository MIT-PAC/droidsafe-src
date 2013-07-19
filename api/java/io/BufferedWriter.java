package java.io;

// Droidsafe Imports
import java.util.Arrays;

import libcore.util.SneakyThrow;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BufferedWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.400 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "0251D9C19BD1379B95D6A9A5D4A8C80D")

    private Writer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.400 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "29466223C47F8B8BB1DFDB9869023C70")

    private char[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.401 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.401 -0400", hash_original_method = "D0AF799B17153797A8965CAE82858C8B", hash_generated_method = "4374D4B84A8E9BB7E975D27D1D8AB4A2")
    public  BufferedWriter(Writer out) {
        this(out, 8192);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.402 -0400", hash_original_method = "BD90CD6D32AE7EB9B6CCE31F3688E0F2", hash_generated_method = "D3848D9212D30220CDC9B62D4D4045E8")
    public  BufferedWriter(Writer out, int size) {
        super(out);
        if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_1908890313 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_1908890313.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_1908890313;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.404 -0400", hash_original_method = "1FFBADE50F933DAEBE6B8AB97A0787F1", hash_generated_method = "90322F3E471EEF794EA7FCC03D7AE5BA")
    @Override
    public void close() throws IOException {
        synchronized
(lock)        {
            if(isClosed())            
            {
                return;
            } //End block
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
                if(thrown == null)                
                {
                    thrown = e;
                } //End block
            } //End block
            out = null;
            if(thrown != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.405 -0400", hash_original_method = "CDBC99BDF3D706FE5CF6000E4273C9D9", hash_generated_method = "2B3DF9BABC6BACEA379ABCDCC553578E")
    @Override
    public void flush() throws IOException {
        synchronized
(lock)        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.406 -0400", hash_original_method = "023D06F961F755F2334356A83B61D7A7", hash_generated_method = "D5B6A3F8AB9EA2E05029A9C8B87126F9")
    private void checkNotClosed() throws IOException {
        if(isClosed())        
        {
            IOException var2274052E96CC2921AC28657447A07720_1954927262 = new IOException("BufferedWriter is closed");
            var2274052E96CC2921AC28657447A07720_1954927262.addTaint(taint);
            throw var2274052E96CC2921AC28657447A07720_1954927262;
        } //End block
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new IOException("BufferedWriter is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.406 -0400", hash_original_method = "56ED8A50252CAA4A163E554237CE5ACA", hash_generated_method = "E40EA2268EB097A4F1392CA223EF1383")
    private void flushInternal() throws IOException {
        if(pos > 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.407 -0400", hash_original_method = "65F785E5C7A072182DBDFA4385D9D27B", hash_generated_method = "7F9CA8F69650F2F5DA796329762CBF07")
    private boolean isClosed() {
        boolean varAE601444E7D588038E147A2CA548E6D7_1754750598 = (out == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129259496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129259496;
        // ---------- Original Method ----------
        //return out == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.408 -0400", hash_original_method = "2B3D7D602A7E63B6C09E849C2D681C65", hash_generated_method = "95268A8136CFE30ED36AA1BE72C081F8")
    public void newLine() throws IOException {
        write(System.lineSeparator());
        // ---------- Original Method ----------
        //write(System.lineSeparator());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.410 -0400", hash_original_method = "2ACD1A4D73C211D3299604BDD7AD25D9", hash_generated_method = "E76072C2E28CDF0AF593A3B635EA15B5")
    @Override
    public void write(char[] cbuf, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(cbuf[0]);
        synchronized
(lock)        {
            checkNotClosed();
            if(cbuf == null)            
            {
                NullPointerException varD1F0B530B211C354FD4DD40207900970_1224244544 = new NullPointerException("buffer == null");
                varD1F0B530B211C354FD4DD40207900970_1224244544.addTaint(taint);
                throw varD1F0B530B211C354FD4DD40207900970_1224244544;
            } //End block
            Arrays.checkOffsetAndCount(cbuf.length, offset, count);
            if(pos == 0 && count >= this.buf.length)            
            {
                out.write(cbuf, offset, count);
                return;
            } //End block
            int available = this.buf.length - pos;
            if(count < available)            
            {
                available = count;
            } //End block
            if(available > 0)            
            {
                System.arraycopy(cbuf, offset, this.buf, pos, available);
                pos += available;
            } //End block
            if(pos == this.buf.length)            
            {
                out.write(this.buf, 0, this.buf.length);
                pos = 0;
                if(count > available)                
                {
                    offset += available;
                    available = count - available;
                    if(available >= this.buf.length)                    
                    {
                        out.write(cbuf, offset, available);
                        return;
                    } //End block
                    System.arraycopy(cbuf, offset, this.buf, pos, available);
                    pos += available;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.412 -0400", hash_original_method = "C57AC7B5490B3E246FD3E407701AE232", hash_generated_method = "819489A921CCAB1BD8545F2FAEBA3480")
    @Override
    public void write(int oneChar) throws IOException {
        synchronized
(lock)        {
            checkNotClosed();
            if(pos >= buf.length)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.415 -0400", hash_original_method = "AE740E7607559E2B849C6855BC31C773", hash_generated_method = "F1C43EE76940DE3E454E83A3638FDBE9")
    @Override
    public void write(String str, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        synchronized
(lock)        {
            checkNotClosed();
            if(count <= 0)            
            {
                return;
            } //End block
            if(offset < 0 || offset > str.length() - count)            
            {
                StringIndexOutOfBoundsException varDD6466A465572C8C2EC4C6C733FC9AF8_1588343665 = new StringIndexOutOfBoundsException(str, offset, count);
                varDD6466A465572C8C2EC4C6C733FC9AF8_1588343665.addTaint(taint);
                throw varDD6466A465572C8C2EC4C6C733FC9AF8_1588343665;
            } //End block
            if(pos == 0 && count >= buf.length)            
            {
                char[] chars = new char[count];
                str.getChars(offset, offset + count, chars, 0);
                out.write(chars, 0, count);
                return;
            } //End block
            int available = buf.length - pos;
            if(count < available)            
            {
                available = count;
            } //End block
            if(available > 0)            
            {
                str.getChars(offset, offset + available, buf, pos);
                pos += available;
            } //End block
            if(pos == buf.length)            
            {
                out.write(this.buf, 0, this.buf.length);
                pos = 0;
                if(count > available)                
                {
                    offset += available;
                    available = count - available;
                    if(available >= buf.length)                    
                    {
                        char[] chars = new char[count];
                        str.getChars(offset, offset + available, chars, 0);
                        out.write(chars, 0, available);
                        return;
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

