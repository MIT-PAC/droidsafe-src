package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class NullReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "16CBF4482936223DDFC294A9E5A57F62", hash_generated_field = "46E59163904A8500BBCD8FB336955372")

    private long readlimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "9E5731673F64253AA7AF2BF0778624B0", hash_generated_field = "470C7A20C05392D09467E0B6AE3E34BA")

    private boolean throwEofException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.988 -0400", hash_original_field = "7B43F3FA2AB654B02F7D731CC4272002", hash_generated_field = "D1D7DACB2C9F2116ACC3AAD64C509D2F")

    private boolean markSupported;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.989 -0400", hash_original_method = "FC4346B115F208CCA0C91C96990142D1", hash_generated_method = "E1EF2C059D84A03818272D68B138F310")
    public  NullReader(long size) {
        this(size, true, false);
        addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.990 -0400", hash_original_method = "D4F800CDE3B717C1CE3877D05130C0A3", hash_generated_method = "13F8979FB695E0AE49B202796190AA9D")
    public  NullReader(long size, boolean markSupported, boolean throwEofException) {
        this.size = size;
        this.markSupported = markSupported;
        this.throwEofException = throwEofException;
        // ---------- Original Method ----------
        //this.size = size;
        //this.markSupported = markSupported;
        //this.throwEofException = throwEofException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.990 -0400", hash_original_method = "1760B71EAFD51B63FDFEE5AB7AC5FEE9", hash_generated_method = "16A8D1D79DFD5E091003779A75812031")
    public long getPosition() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_480319362 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_480319362;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.990 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "5CA921F5CA6C5DD9E91D126F1C38348E")
    public long getSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1677358442 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1677358442;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.991 -0400", hash_original_method = "EEFDACC2C301B42650B1064C3D4059CC", hash_generated_method = "5B6DBF346B0CD0A1CC0DCF5E7165EC4E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.991 -0400", hash_original_method = "7AEF2C3B62C677DC9FD1211BE4D4F4EB", hash_generated_method = "B2E766FDFDF2D4B287F2AD4768492E2B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.991 -0400", hash_original_method = "0829B6DA23F89F75CF76B7CF84C00C9F", hash_generated_method = "9CA7417454EEA1E06BE12D29AFC5EC22")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498126336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_498126336;
        // ---------- Original Method ----------
        //return markSupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.002 -0400", hash_original_method = "FBA121B80064AD99E30C613A90CFA3D6", hash_generated_method = "D776DF33F99B2216DC215D1F799CF361")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } //End block
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_1056206325 = (doEndOfFile());
        } //End block
        int var6424F44E2FF1A4CA13605FB53080F2DD_177385508 = (processChar());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391021249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391021249;
        // ---------- Original Method ----------
        //if (eof) {
            //throw new IOException("Read after end of file");
        //}
        //if (position == size) {
            //return doEndOfFile();
        //}
        //position++;
        //return processChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.009 -0400", hash_original_method = "4AD28164B3ED3B60A2412B4E7DEDB826", hash_generated_method = "7F3ED3EFDC54F6813BC5CE0BF9D89310")
    @Override
    public int read(char[] chars) throws IOException {
        int varCF21FDA3A25AF4CC14A7984F4AE2A442_985047946 = (read(chars, 0, chars.length));
        addTaint(chars[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192044254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192044254;
        // ---------- Original Method ----------
        //return read(chars, 0, chars.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.014 -0400", hash_original_method = "C70C3A95CC69C815CEA97A11A597B28A", hash_generated_method = "844C70D812A3C027346A0074641E3A73")
    @Override
    public int read(char[] chars, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } //End block
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_121536445 = (doEndOfFile());
        } //End block
        position += length;
        int returnLength;
        returnLength = length;
        {
            returnLength = length - (int)(position - size);
            position = size;
        } //End block
        processChars(chars, offset, returnLength);
        addTaint(chars[0]);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865798127 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865798127;
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
        //processChars(chars, offset, returnLength);
        //return returnLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.017 -0400", hash_original_method = "DA70D8E8EFCF4CE896E4E17AB2D27792", hash_generated_method = "ADE91CA8E3BA9D12BD726C9F6A4B7B96")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.030 -0400", hash_original_method = "438CF302A21CA34274E9B0DDF0F4C413", hash_generated_method = "9D041D121F0C475EBCF1A47BE82FBCAB")
    @Override
    public long skip(long numberOfChars) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Skip after end of file");
        } //End block
        {
            long varECF9BCF45B9E6F55B0F3F60324CD3B94_1999293741 = (doEndOfFile());
        } //End block
        position += numberOfChars;
        long returnLength;
        returnLength = numberOfChars;
        {
            returnLength = numberOfChars - (position - size);
            position = size;
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2039937321 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2039937321;
        // ---------- Original Method ----------
        //if (eof) {
            //throw new IOException("Skip after end of file");
        //}
        //if (position == size) {
            //return doEndOfFile();
        //}
        //position += numberOfChars;
        //long returnLength = numberOfChars;
        //if (position > size) {
            //returnLength = numberOfChars - (position - size);
            //position = size;
        //}
        //return returnLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.031 -0400", hash_original_method = "A737830B6A2B6F6C2620CA3298757069", hash_generated_method = "D0A59F23F00FD84A4BEA3F319BB255E5")
    protected int processChar() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434543333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434543333;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.031 -0400", hash_original_method = "CECA15CD5926CD1CCF5DBC543CFC909D", hash_generated_method = "1028927649B8F13A27CC386B8B778485")
    protected void processChars(char[] chars, int offset, int length) {
        addTaint(chars[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.031 -0400", hash_original_method = "19CB45ABF7C0C1D656700921E322A527", hash_generated_method = "3CBBC9E1B2FF0E133E4B45E8ECFDE369")
    private int doEndOfFile() throws EOFException {
        eof = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642019674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642019674;
        // ---------- Original Method ----------
        //eof = true;
        //if (throwEofException) {
            //throw new EOFException();
        //}
        //return -1;
    }

    
}

