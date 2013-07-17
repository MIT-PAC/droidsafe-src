package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class FilterReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.003 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "F15B9A182F31EEA4A8B216C74398FC35")

    protected Reader in;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.004 -0400", hash_original_method = "F3D1BE373A56A0B558A4F2E00F8B10E0", hash_generated_method = "739351D73AD74357F67B0EF04AC04675")
    protected  FilterReader(Reader in) {
        super(in);
        this.in = in;
        // ---------- Original Method ----------
        //this.in = in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.004 -0400", hash_original_method = "501891754658354231C7815C688E4921", hash_generated_method = "E4E394ABE6A8D2B8F05C0A68D0EB9539")
    @Override
    public void close() throws IOException {
        synchronized
(lock)        {
            in.close();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //in.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.005 -0400", hash_original_method = "CF9F5D7515858833C08423EA9B6FCE6A", hash_generated_method = "907E235D550618DFE572081872D7D847")
    @Override
    public synchronized void mark(int readlimit) throws IOException {
        addTaint(readlimit);
        synchronized
(lock)        {
            in.mark(readlimit);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //in.mark(readlimit);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.005 -0400", hash_original_method = "2ED4924508737903A79CF3129A066F71", hash_generated_method = "6D587E4EEDA6193BCE7BDAAB3C394D4D")
    @Override
    public boolean markSupported() {
        synchronized
(lock)        {
            boolean var92424DC7E92354A95936078BD657F7DC_1016390563 = (in.markSupported());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99838534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_99838534;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return in.markSupported();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.005 -0400", hash_original_method = "25E05A20196B2EF8776FA69AEA6A01AB", hash_generated_method = "853B90331A7907F964FDBC3A9FACA0A1")
    @Override
    public int read() throws IOException {
        synchronized
(lock)        {
            int varC746AA2461228F1337791E992A2C4661_1285567803 = (in.read());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592772590 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592772590;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return in.read();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.006 -0400", hash_original_method = "1EA26595B36EBCA6FE882CBA9CA8B025", hash_generated_method = "F852F7E43AC0BAAB92078D82E4356BD1")
    @Override
    public int read(char[] buffer, int offset, int count) throws IOException {
        addTaint(count);
        addTaint(offset);
        addTaint(buffer[0]);
        synchronized
(lock)        {
            int var16B8A5ED779D2972EF4A24F254214E3B_335271347 = (in.read(buffer, offset, count));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439379633 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439379633;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return in.read(buffer, offset, count);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.006 -0400", hash_original_method = "3B619AD38F7F67E79C5355301607CFA3", hash_generated_method = "6E4A26F1275F101EE37F6D651769542A")
    @Override
    public boolean ready() throws IOException {
        synchronized
(lock)        {
            boolean varB4741C0A842F523B135730D8B82EDE85_1835602319 = (in.ready());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866361590 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866361590;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return in.ready();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.006 -0400", hash_original_method = "14FB3B3EA5640BFE7D124E930BE279E7", hash_generated_method = "0A6CCFB96D671D21B6BB082A6A5A0FDD")
    @Override
    public void reset() throws IOException {
        synchronized
(lock)        {
            in.reset();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //in.reset();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.007 -0400", hash_original_method = "1B3BA6A4C9DAFF7D8DBE3635EB5F6FB9", hash_generated_method = "88E2AEA043CB5FB8076E141E68D6FD1E")
    @Override
    public long skip(long charCount) throws IOException {
        addTaint(charCount);
        synchronized
(lock)        {
            long var05DF4FCD0D81410756D3CF6CAF7FE43A_2041156632 = (in.skip(charCount));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_362812040 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_362812040;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return in.skip(charCount);
        //}
    }

    
}

