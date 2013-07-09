package org.apache.commons.io.input;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class NullInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.123 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.123 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.123 -0400", hash_original_field = "AEBE787CB6F497D2AAE0B3BE79923B47", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.123 -0400", hash_original_field = "16CBF4482936223DDFC294A9E5A57F62", hash_generated_field = "46E59163904A8500BBCD8FB336955372")

    private long readlimit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.123 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.123 -0400", hash_original_field = "9E5731673F64253AA7AF2BF0778624B0", hash_generated_field = "470C7A20C05392D09467E0B6AE3E34BA")

    private boolean throwEofException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.123 -0400", hash_original_field = "7B43F3FA2AB654B02F7D731CC4272002", hash_generated_field = "D1D7DACB2C9F2116ACC3AAD64C509D2F")

    private boolean markSupported;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.147 -0400", hash_original_method = "E86AC9DEB16682D41BCA3DC804FCEE8E", hash_generated_method = "6D6229044BF839825E277FA638709BFF")
    public  NullInputStream(long size) {
        this(size, true, false);
        addTaint(size);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.148 -0400", hash_original_method = "830F103A96EA74148B0B8535C89D1AF0", hash_generated_method = "7B6D246D371862C1A3A99EC50A6D92C1")
    public  NullInputStream(long size, boolean markSupported, boolean throwEofException) {
        this.size = size;
        this.markSupported = markSupported;
        this.throwEofException = throwEofException;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.149 -0400", hash_original_method = "1760B71EAFD51B63FDFEE5AB7AC5FEE9", hash_generated_method = "E05F21A9CC2DDA53CD7A7F9355AB1AC5")
    public long getPosition() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1251779550 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1251779550;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.150 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "49621AFB1D3CB39E11EDE610710C6087")
    public long getSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1764238727 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1764238727;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.150 -0400", hash_original_method = "7F3FA848D774B0E8E97D2C379EE0C684", hash_generated_method = "769E27E232A66C3129AFF8E64EF32A06")
    @Override
    public int available() {
        long avail = size - position;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345570323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345570323;
        
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.151 -0400", hash_original_method = "EEFDACC2C301B42650B1064C3D4059CC", hash_generated_method = "5B6DBF346B0CD0A1CC0DCF5E7165EC4E")
    @Override
    public void close() throws IOException {
        eof = false;
        position = 0;
        mark = -1;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.151 -0400", hash_original_method = "7AEF2C3B62C677DC9FD1211BE4D4F4EB", hash_generated_method = "B2E766FDFDF2D4B287F2AD4768492E2B")
    @Override
    public synchronized void mark(int readlimit) {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Mark not supported");
        } 
        mark = position;
        this.readlimit = readlimit;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.152 -0400", hash_original_method = "0829B6DA23F89F75CF76B7CF84C00C9F", hash_generated_method = "D47B4DA9A417EB3DF789454C9083A286")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731807085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731807085;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.152 -0400", hash_original_method = "58A7A50486EDC9346A5D459542A5BDB7", hash_generated_method = "35C19800DD5263720422DED903BE8373")
    @Override
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } 
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_1966014413 = (doEndOfFile());
        } 
        int varC45080C1A9D5F691112CA879E7686659_276647895 = (processByte());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659687995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659687995;
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.153 -0400", hash_original_method = "1E949846598722C79E2F0E8E4DF0AE25", hash_generated_method = "1F96D39DE1A248BE6D85B675AED1A86A")
    @Override
    public int read(byte[] bytes) throws IOException {
        int varABD71C100963A3F2718C8456D8E57C13_1472399055 = (read(bytes, 0, bytes.length));
        addTaint(bytes[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481794037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481794037;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.153 -0400", hash_original_method = "05A90D0FB660BAF10AD4D61031A72FD9", hash_generated_method = "BB7C41664E47996C65F8343DE625A5AD")
    @Override
    public int read(byte[] bytes, int offset, int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Read after end of file");
        } 
        {
            int varECF9BCF45B9E6F55B0F3F60324CD3B94_1130891783 = (doEndOfFile());
        } 
        position += length;
        int returnLength = length;
        {
            returnLength = length - (int)(position - size);
            position = size;
        } 
        processBytes(bytes, offset, returnLength);
        addTaint(bytes[0]);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736054703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736054703;
        
        
            
        
        
            
        
        
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.154 -0400", hash_original_method = "DA70D8E8EFCF4CE896E4E17AB2D27792", hash_generated_method = "ADE91CA8E3BA9D12BD726C9F6A4B7B96")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.156 -0400", hash_original_method = "9210FB6C78C901008C5A67E434CB9A0B", hash_generated_method = "539A99B8229D8889125B6986D6E011F1")
    @Override
    public long skip(long numberOfBytes) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Skip after end of file");
        } 
        {
            long varECF9BCF45B9E6F55B0F3F60324CD3B94_1908490101 = (doEndOfFile());
        } 
        position += numberOfBytes;
        long returnLength = numberOfBytes;
        {
            returnLength = numberOfBytes - (position - size);
            position = size;
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1724078627 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1724078627;
        
        
            
        
        
            
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.157 -0400", hash_original_method = "F722CD05EE5576BABE566E57360BDAA4", hash_generated_method = "25348B7D44B692E384DB6323D69D13A4")
    protected int processByte() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961364543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961364543;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.158 -0400", hash_original_method = "8351070DA7823031FCCA3BE9B1CDBB4D", hash_generated_method = "2D6069ECF00AD0F6C4F3D149F1F90EA8")
    protected void processBytes(byte[] bytes, int offset, int length) {
        addTaint(bytes[0]);
        addTaint(offset);
        addTaint(length);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.158 -0400", hash_original_method = "19CB45ABF7C0C1D656700921E322A527", hash_generated_method = "531DF8DA24F5B56DFCC23AE58076872E")
    private int doEndOfFile() throws EOFException {
        eof = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640735882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640735882;
        
        
        
            
        
        
    }

    
}

