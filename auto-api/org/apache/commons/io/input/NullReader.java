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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.988 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.989 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.989 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.989 -0400", hash_original_field = "16CBF4482936223DDFC294A9E5A57F62", hash_generated_field = "46E59163904A8500BBCD8FB336955372")

    private long readlimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.989 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.989 -0400", hash_original_field = "9E5731673F64253AA7AF2BF0778624B0", hash_generated_field = "470C7A20C05392D09467E0B6AE3E34BA")

    private boolean throwEofException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.989 -0400", hash_original_field = "7B43F3FA2AB654B02F7D731CC4272002", hash_generated_field = "D1D7DACB2C9F2116ACC3AAD64C509D2F")

    private boolean markSupported;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.989 -0400", hash_original_method = "FC4346B115F208CCA0C91C96990142D1", hash_generated_method = "E1EF2C059D84A03818272D68B138F310")
    public  NullReader(long size) {
        this(size, true, false);
        addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.999 -0400", hash_original_method = "D4F800CDE3B717C1CE3877D05130C0A3", hash_generated_method = "13F8979FB695E0AE49B202796190AA9D")
    public  NullReader(long size, boolean markSupported, boolean throwEofException) {
        this.size = size;
        this.markSupported = markSupported;
        this.throwEofException = throwEofException;
        // ---------- Original Method ----------
        //this.size = size;
        //this.markSupported = markSupported;
        //this.throwEofException = throwEofException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.999 -0400", hash_original_method = "1760B71EAFD51B63FDFEE5AB7AC5FEE9", hash_generated_method = "47BB8E7F5AB5E4705BFA528B357A9E71")
    public long getPosition() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1072856540 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1072856540;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.999 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "5B8091B886908769EF57346BBE0DD866")
    public long getSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_799161116 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_799161116;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.000 -0400", hash_original_method = "EEFDACC2C301B42650B1064C3D4059CC", hash_generated_method = "5B6DBF346B0CD0A1CC0DCF5E7165EC4E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.000 -0400", hash_original_method = "7AEF2C3B62C677DC9FD1211BE4D4F4EB", hash_generated_method = "B2E766FDFDF2D4B287F2AD4768492E2B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.000 -0400", hash_original_method = "0829B6DA23F89F75CF76B7CF84C00C9F", hash_generated_method = "BC7E011FB03339379537E0BB2357634D")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097651357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097651357;
        // ---------- Original Method ----------
        //return markSupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.000 -0400", hash_original_method = "FBA121B80064AD99E30C613A90CFA3D6", hash_generated_method = "2156D6978E34FF368EF377918B3EDD2E")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } //End block
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_1563658985 = (doEndOfFile());
        } //End block
        int var6424F44E2FF1A4CA13605FB53080F2DD_1394139448 = (processChar());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170527005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170527005;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.008 -0400", hash_original_method = "4AD28164B3ED3B60A2412B4E7DEDB826", hash_generated_method = "0988126D1B0380FCCE73DD93FF9223C7")
    @Override
    public int read(char[] chars) throws IOException {
        int varCF21FDA3A25AF4CC14A7984F4AE2A442_1076170554 = (read(chars, 0, chars.length));
        addTaint(chars[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860544883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_860544883;
        // ---------- Original Method ----------
        //return read(chars, 0, chars.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.008 -0400", hash_original_method = "C70C3A95CC69C815CEA97A11A597B28A", hash_generated_method = "BBA0E02B240BAAC1E4C3862FADB3B5AF")
    @Override
    public int read(char[] chars, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } //End block
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_1146230198 = (doEndOfFile());
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127073150 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2127073150;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.009 -0400", hash_original_method = "DA70D8E8EFCF4CE896E4E17AB2D27792", hash_generated_method = "ADE91CA8E3BA9D12BD726C9F6A4B7B96")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.014 -0400", hash_original_method = "438CF302A21CA34274E9B0DDF0F4C413", hash_generated_method = "4BFCFCE892CD0B125118E1756E48C50B")
    @Override
    public long skip(long numberOfChars) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Skip after end of file");
        } //End block
        {
            long varECF9BCF45B9E6F55B0F3F60324CD3B94_1616717061 = (doEndOfFile());
        } //End block
        position += numberOfChars;
        long returnLength;
        returnLength = numberOfChars;
        {
            returnLength = numberOfChars - (position - size);
            position = size;
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1171749208 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1171749208;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.014 -0400", hash_original_method = "A737830B6A2B6F6C2620CA3298757069", hash_generated_method = "A34042E67E4423A4E239B9C8E43E16F0")
    protected int processChar() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798435597 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798435597;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.015 -0400", hash_original_method = "CECA15CD5926CD1CCF5DBC543CFC909D", hash_generated_method = "1028927649B8F13A27CC386B8B778485")
    protected void processChars(char[] chars, int offset, int length) {
        addTaint(chars[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.015 -0400", hash_original_method = "19CB45ABF7C0C1D656700921E322A527", hash_generated_method = "FA61E24613A9C7E6E8D2628AB7810281")
    private int doEndOfFile() throws EOFException {
        eof = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234678780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234678780;
        // ---------- Original Method ----------
        //eof = true;
        //if (throwEofException) {
            //throw new EOFException();
        //}
        //return -1;
    }

    
}

