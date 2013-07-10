package org.apache.commons.io.input;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class NullReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.167 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.167 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.167 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.167 -0400", hash_original_field = "16CBF4482936223DDFC294A9E5A57F62", hash_generated_field = "46E59163904A8500BBCD8FB336955372")

    private long readlimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.167 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.167 -0400", hash_original_field = "9E5731673F64253AA7AF2BF0778624B0", hash_generated_field = "470C7A20C05392D09467E0B6AE3E34BA")

    private boolean throwEofException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.167 -0400", hash_original_field = "7B43F3FA2AB654B02F7D731CC4272002", hash_generated_field = "D1D7DACB2C9F2116ACC3AAD64C509D2F")

    private boolean markSupported;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.168 -0400", hash_original_method = "FC4346B115F208CCA0C91C96990142D1", hash_generated_method = "E1EF2C059D84A03818272D68B138F310")
    public  NullReader(long size) {
        this(size, true, false);
        addTaint(size);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.168 -0400", hash_original_method = "D4F800CDE3B717C1CE3877D05130C0A3", hash_generated_method = "13F8979FB695E0AE49B202796190AA9D")
    public  NullReader(long size, boolean markSupported, boolean throwEofException) {
        this.size = size;
        this.markSupported = markSupported;
        this.throwEofException = throwEofException;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.168 -0400", hash_original_method = "1760B71EAFD51B63FDFEE5AB7AC5FEE9", hash_generated_method = "0C69001502E3883231B8F2B0CD7A3844")
    public long getPosition() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1767993004 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1767993004;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.169 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "0FB8F440D52481BC681C44EFA2E2F59D")
    public long getSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_898120936 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_898120936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.169 -0400", hash_original_method = "EEFDACC2C301B42650B1064C3D4059CC", hash_generated_method = "5B6DBF346B0CD0A1CC0DCF5E7165EC4E")
    @Override
    public void close() throws IOException {
        eof = false;
        position = 0;
        mark = -1;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.169 -0400", hash_original_method = "7AEF2C3B62C677DC9FD1211BE4D4F4EB", hash_generated_method = "B2E766FDFDF2D4B287F2AD4768492E2B")
    @Override
    public synchronized void mark(int readlimit) {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Mark not supported");
        } 
        mark = position;
        this.readlimit = readlimit;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.170 -0400", hash_original_method = "0829B6DA23F89F75CF76B7CF84C00C9F", hash_generated_method = "DCF9B5F5CE50D24FAC24B137EE2B977B")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834549450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834549450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.170 -0400", hash_original_method = "FBA121B80064AD99E30C613A90CFA3D6", hash_generated_method = "C29003C5393B1E37344641F9EEB77AD6")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } 
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_412176966 = (doEndOfFile());
        } 
        int var6424F44E2FF1A4CA13605FB53080F2DD_964359966 = (processChar());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533335214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533335214;
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.170 -0400", hash_original_method = "4AD28164B3ED3B60A2412B4E7DEDB826", hash_generated_method = "38B2AAFC79FAD3627F2A0D26405ABBD7")
    @Override
    public int read(char[] chars) throws IOException {
        int varCF21FDA3A25AF4CC14A7984F4AE2A442_574284790 = (read(chars, 0, chars.length));
        addTaint(chars[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638355297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638355297;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.171 -0400", hash_original_method = "C70C3A95CC69C815CEA97A11A597B28A", hash_generated_method = "6CA58C08DE03564C80992364E257F038")
    @Override
    public int read(char[] chars, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } 
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_50048751 = (doEndOfFile());
        } 
        position += length;
        int returnLength = length;
        {
            returnLength = length - (int)(position - size);
            position = size;
        } 
        processChars(chars, offset, returnLength);
        addTaint(chars[0]);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169762941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169762941;
        
        
            
        
        
            
        
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.171 -0400", hash_original_method = "DA70D8E8EFCF4CE896E4E17AB2D27792", hash_generated_method = "ADE91CA8E3BA9D12BD726C9F6A4B7B96")
    @Override
    public synchronized void reset() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Mark not supported");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("No position has been marked");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Marked position [" + mark +
                    "] is no longer valid - passed the read limit [" +
                    readlimit + "]");
        } 
        position = mark;
        eof = false;
        
        
            
        
        
            
        
        
            
                    
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.171 -0400", hash_original_method = "438CF302A21CA34274E9B0DDF0F4C413", hash_generated_method = "CA84C599168DE6E39AA08E860848AB5C")
    @Override
    public long skip(long numberOfChars) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Skip after end of file");
        } 
        {
            long varECF9BCF45B9E6F55B0F3F60324CD3B94_1614714870 = (doEndOfFile());
        } 
        position += numberOfChars;
        long returnLength = numberOfChars;
        {
            returnLength = numberOfChars - (position - size);
            position = size;
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_568566446 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_568566446;
        
        
            
        
        
            
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.172 -0400", hash_original_method = "A737830B6A2B6F6C2620CA3298757069", hash_generated_method = "CBE9FDEC735036EF9B50103135E092B9")
    protected int processChar() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899196950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899196950;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.172 -0400", hash_original_method = "CECA15CD5926CD1CCF5DBC543CFC909D", hash_generated_method = "1028927649B8F13A27CC386B8B778485")
    protected void processChars(char[] chars, int offset, int length) {
        addTaint(chars[0]);
        addTaint(offset);
        addTaint(length);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.173 -0400", hash_original_method = "19CB45ABF7C0C1D656700921E322A527", hash_generated_method = "A25DD94790A9491ECE023EC491E7914F")
    private int doEndOfFile() throws EOFException {
        eof = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706190928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706190928;
        
        
        
            
        
        
    }

    
}

