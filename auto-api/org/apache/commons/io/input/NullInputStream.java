package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class NullInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.957 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.957 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.958 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.958 -0400", hash_original_field = "16CBF4482936223DDFC294A9E5A57F62", hash_generated_field = "46E59163904A8500BBCD8FB336955372")

    private long readlimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.958 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.958 -0400", hash_original_field = "9E5731673F64253AA7AF2BF0778624B0", hash_generated_field = "470C7A20C05392D09467E0B6AE3E34BA")

    private boolean throwEofException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.958 -0400", hash_original_field = "7B43F3FA2AB654B02F7D731CC4272002", hash_generated_field = "D1D7DACB2C9F2116ACC3AAD64C509D2F")

    private boolean markSupported;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.958 -0400", hash_original_method = "E86AC9DEB16682D41BCA3DC804FCEE8E", hash_generated_method = "6D6229044BF839825E277FA638709BFF")
    public  NullInputStream(long size) {
        this(size, true, false);
        addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.959 -0400", hash_original_method = "830F103A96EA74148B0B8535C89D1AF0", hash_generated_method = "7B6D246D371862C1A3A99EC50A6D92C1")
    public  NullInputStream(long size, boolean markSupported, boolean throwEofException) {
        this.size = size;
        this.markSupported = markSupported;
        this.throwEofException = throwEofException;
        // ---------- Original Method ----------
        //this.size = size;
        //this.markSupported = markSupported;
        //this.throwEofException = throwEofException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.959 -0400", hash_original_method = "1760B71EAFD51B63FDFEE5AB7AC5FEE9", hash_generated_method = "4BD7B56933E224D3DC6830301B66340D")
    public long getPosition() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1348241839 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1348241839;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.959 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "7FCE8D11B72DEC71F6DA5A9765B21E6F")
    public long getSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1023727340 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1023727340;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.967 -0400", hash_original_method = "7F3FA848D774B0E8E97D2C379EE0C684", hash_generated_method = "406781F386F75C3AEF8E1AAADD528C40")
    @Override
    public int available() {
        long avail;
        avail = size - position;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242913206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242913206;
        // ---------- Original Method ----------
        //long avail = size - position;
        //if (avail <= 0) {
            //return 0;
        //} else if (avail > Integer.MAX_VALUE) {
            //return Integer.MAX_VALUE;
        //} else {
            //return (int)avail;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.967 -0400", hash_original_method = "EEFDACC2C301B42650B1064C3D4059CC", hash_generated_method = "5B6DBF346B0CD0A1CC0DCF5E7165EC4E")
    @Override
    public void close() throws IOException {
        eof = false;
        position = 0;
        mark = -1;
        // ---------- Original Method ----------
        //eof = false;
        //position = 0;
        //mark = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.968 -0400", hash_original_method = "7AEF2C3B62C677DC9FD1211BE4D4F4EB", hash_generated_method = "B2E766FDFDF2D4B287F2AD4768492E2B")
    @Override
    public synchronized void mark(int readlimit) {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Mark not supported");
        } //End block
        mark = position;
        this.readlimit = readlimit;
        // ---------- Original Method ----------
        //if (!markSupported) {
            //throw new UnsupportedOperationException("Mark not supported");
        //}
        //mark = position;
        //this.readlimit = readlimit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.968 -0400", hash_original_method = "0829B6DA23F89F75CF76B7CF84C00C9F", hash_generated_method = "EFD0C202271F68238324FCD2A756773C")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094566899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094566899;
        // ---------- Original Method ----------
        //return markSupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.968 -0400", hash_original_method = "58A7A50486EDC9346A5D459542A5BDB7", hash_generated_method = "1CBA8C88B1038CAACC0C24CE79DBD83D")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } //End block
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_911573079 = (doEndOfFile());
        } //End block
        int varC45080C1A9D5F691112CA879E7686659_1741528909 = (processByte());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183443448 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183443448;
        // ---------- Original Method ----------
        //if (eof) {
            //throw new IOException("Read after end of file");
        //}
        //if (position == size) {
            //return doEndOfFile();
        //}
        //position++;
        //return processByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.973 -0400", hash_original_method = "1E949846598722C79E2F0E8E4DF0AE25", hash_generated_method = "BEC0746D78DF3D731C198DB5CD23487F")
    @Override
    public int read(byte[] bytes) throws IOException {
        int varABD71C100963A3F2718C8456D8E57C13_31247643 = (read(bytes, 0, bytes.length));
        addTaint(bytes[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331067896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331067896;
        // ---------- Original Method ----------
        //return read(bytes, 0, bytes.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.984 -0400", hash_original_method = "05A90D0FB660BAF10AD4D61031A72FD9", hash_generated_method = "054FEB93054B0F0001216BCF51F2FE9A")
    @Override
    public int read(byte[] bytes, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } //End block
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_478659341 = (doEndOfFile());
        } //End block
        position += length;
        int returnLength;
        returnLength = length;
        {
            returnLength = length - (int)(position - size);
            position = size;
        } //End block
        processBytes(bytes, offset, returnLength);
        addTaint(bytes[0]);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808638357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808638357;
        // ---------- Original Method ----------
        //if (eof) {
            //throw new IOException("Read after end of file");
        //}
        //if (position == size) {
            //return doEndOfFile();
        //}
        //position += length;
        //int returnLength = length;
        //if (position > size) {
            //returnLength = length - (int)(position - size);
            //position = size;
        //}
        //processBytes(bytes, offset, returnLength);
        //return returnLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.984 -0400", hash_original_method = "DA70D8E8EFCF4CE896E4E17AB2D27792", hash_generated_method = "ADE91CA8E3BA9D12BD726C9F6A4B7B96")
    @Override
    public synchronized void reset() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Mark not supported");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("No position has been marked");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Marked position [" + mark +
                    "] is no longer valid - passed the read limit [" +
                    readlimit + "]");
        } //End block
        position = mark;
        eof = false;
        // ---------- Original Method ----------
        //if (!markSupported) {
            //throw new UnsupportedOperationException("Mark not supported");
        //}
        //if (mark < 0) {
            //throw new IOException("No position has been marked");
        //}
        //if (position > mark + readlimit) {
            //throw new IOException("Marked position [" + mark +
                    //"] is no longer valid - passed the read limit [" +
                    //readlimit + "]");
        //}
        //position = mark;
        //eof = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.985 -0400", hash_original_method = "9210FB6C78C901008C5A67E434CB9A0B", hash_generated_method = "51F0505CF5BD201FFCF31E64CEB827D5")
    @Override
    public long skip(long numberOfBytes) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Skip after end of file");
        } //End block
        {
            long varECF9BCF45B9E6F55B0F3F60324CD3B94_142139448 = (doEndOfFile());
        } //End block
        position += numberOfBytes;
        long returnLength;
        returnLength = numberOfBytes;
        {
            returnLength = numberOfBytes - (position - size);
            position = size;
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_971004958 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_971004958;
        // ---------- Original Method ----------
        //if (eof) {
            //throw new IOException("Skip after end of file");
        //}
        //if (position == size) {
            //return doEndOfFile();
        //}
        //position += numberOfBytes;
        //long returnLength = numberOfBytes;
        //if (position > size) {
            //returnLength = numberOfBytes - (position - size);
            //position = size;
        //}
        //return returnLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.985 -0400", hash_original_method = "F722CD05EE5576BABE566E57360BDAA4", hash_generated_method = "5C89D5304420511F7B7278E43C203E6F")
    protected int processByte() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474286684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474286684;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.985 -0400", hash_original_method = "8351070DA7823031FCCA3BE9B1CDBB4D", hash_generated_method = "2D6069ECF00AD0F6C4F3D149F1F90EA8")
    protected void processBytes(byte[] bytes, int offset, int length) {
        addTaint(bytes[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.985 -0400", hash_original_method = "19CB45ABF7C0C1D656700921E322A527", hash_generated_method = "A26DF3F231959196165E319D56DCFB85")
    private int doEndOfFile() throws EOFException {
        eof = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044319142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044319142;
        // ---------- Original Method ----------
        //eof = true;
        //if (throwEofException) {
            //throw new EOFException();
        //}
        //return -1;
    }

    
}

