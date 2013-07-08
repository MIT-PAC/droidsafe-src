package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public class StringReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.130 -0400", hash_original_field = "341BE97D9AFF90C9978347F66F945B77", hash_generated_field = "787A2B4D426AC144FB23E0D0502FE70E")

    private String str;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.130 -0400", hash_original_field = "492E5D488B8C3F3A5B37BE9C27216BA1", hash_generated_field = "D9BE4F291B7CF1E403126100EC51CB87")

    private int markpos = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.130 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.130 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.131 -0400", hash_original_method = "FB44DCC8276A9B32CF15DCC88FC63BEE", hash_generated_method = "2BB533358CA78E399DDA1F3F66175075")
    public  StringReader(String str) {
        this.str = str;
        this.count = str.length();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.131 -0400", hash_original_method = "827A4A30AD2891E9194C78AEA719C92F", hash_generated_method = "56CB6D45E1B04874E8BB64A2135F32B4")
    @Override
    public void close() {
        str = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.131 -0400", hash_original_method = "E02036AA0C500209CBC33A804345F86B", hash_generated_method = "D510F8E8EB6D6E6D27354DA49ED5A0C3")
    private boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431017085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431017085;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.132 -0400", hash_original_method = "F8F979F8EBA759C2F6A839AF0D90FFA4", hash_generated_method = "9477A35EF17C11B1D62E277F2ABD71F9")
    @Override
    public void mark(int readLimit) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        {
            checkNotClosed();
            markpos = pos;
        } 
        addTaint(readLimit);
        
        
            
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.132 -0400", hash_original_method = "52097AD3D6FE0975840C468FF1E0F766", hash_generated_method = "B03221C5178A35BBB1B7C5E3FDFABAD9")
    private void checkNotClosed() throws IOException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_400762468 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("StringReader is closed");
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.132 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "F4998B56685CE1E4052DBEF2A184F44E")
    @Override
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21497415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_21497415;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.133 -0400", hash_original_method = "7FFE2BA54C7A195E9FE8B5D995EC9572", hash_generated_method = "AEEA13121AC35730AF98833138DE9982")
    @Override
    public int read() throws IOException {
        {
            checkNotClosed();
            {
                int var0F580E3D69302FA8221AA508D5192A84_720464772 = (str.charAt(pos++));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053654014 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053654014;
        
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.133 -0400", hash_original_method = "85EEB2DAA826BA4238F8F98E34D3FBD9", hash_generated_method = "D6EAA1E2D5D76DA05E4F969FAB3AA265")
    @Override
    public int read(char[] buf, int offset, int len) throws IOException {
        {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buf.length, offset, len);
            int end;
            end = this.count;
            end = pos + len;
            str.getChars(pos, end, buf, offset);
            int read = end - pos;
            pos = end;
        } 
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500000140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500000140;
        
        
            
            
            
                
            
            
                
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.134 -0400", hash_original_method = "3162F271739E7EAF4DA155264EC5FC94", hash_generated_method = "FFF6169A670DC9821D17C0D18517FEDC")
    @Override
    public boolean ready() throws IOException {
        {
            checkNotClosed();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023889537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023889537;
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.134 -0400", hash_original_method = "038BDF0065CA5B8ADE3B96C7C6A96C49", hash_generated_method = "83AB864F4946B1529535589675BD20F1")
    @Override
    public void reset() throws IOException {
        {
            checkNotClosed();
            pos = markpos != -1 ? markpos : 0;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.134 -0400", hash_original_method = "62CF7546C0F2369A3238D86713E4D3AD", hash_generated_method = "2D65208240C8860990639194B5F07D38")
    @Override
    public long skip(long charCount) throws IOException {
        {
            checkNotClosed();
            int minSkip = -pos;
            int maxSkip = count - pos;
            {
                charCount = maxSkip;
            } 
            {
                charCount = minSkip;
            } 
            pos += charCount;
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_368858065 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_368858065;
        
        
            
            
            
            
                
            
                
            
            
            
        
    }

    
}

