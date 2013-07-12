package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;

public abstract class SSLInputStream extends InputStream {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.090 -0400", hash_original_method = "B3907DD288EBA16F858ADC5177372075", hash_generated_method = "B3907DD288EBA16F858ADC5177372075")
    public SSLInputStream ()
    {
        
    }


        @Override
public abstract int available() throws IOException;

    
        @Override
public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.092 -0400", hash_original_method = "4E61964AC41EB7FF0B969F3A0D2A867E", hash_generated_method = "0779BAB882DF353F4B26F8C2772E760B")
    public int readUint8() throws IOException {
        int varDE564EBA10F50982773C535F5DD0C71C_1971840102 = (read() & 0x00FF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66934454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_66934454;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.092 -0400", hash_original_method = "0E243896410AF2472245902D7F89ED82", hash_generated_method = "2CBA028558177910D6D7E71487633175")
    public int readUint16() throws IOException {
        int varE92D816B59C876C1E075FB7408EC5632_101509558 = ((read() << 8) | (read() & 0x00FF));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795762699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_795762699;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.093 -0400", hash_original_method = "B71B56A9E36B8A8CD4C9FE0969EFEC79", hash_generated_method = "70A234A6AF22777D35B837A497EC0E07")
    public int readUint24() throws IOException {
        int var3B1BC9CE46E8D9ABE7F7ADDE655F6975_2080938317 = ((read() << 16) | (read() << 8) | (read() & 0x00FF));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344881594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344881594;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.093 -0400", hash_original_method = "18D59391AE7948DA8080AA965DB6CE79", hash_generated_method = "9635D16983D96DCF7115BBCB8327BC73")
    public long readUint32() throws IOException {
        long var52385B0F5BA643C7B7E882733711900E_1257986465 = ((read() << 24) | (read() << 16)
              | (read() << 8) | (read() & 0x00FF));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_527708637 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_527708637;
        
        
              
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.093 -0400", hash_original_method = "85B7C4B5BFF5E58A56D479C7E3A9AABB", hash_generated_method = "4FADA51DF87AE3CB448E231336257D86")
    public long readUint64() throws IOException {
        long hi = readUint32();
        long lo = readUint32();
        long varD915340A788ED0901BEE0629617EE84E_1028250719 = ((hi << 32) | lo);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_314532608 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_314532608;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.094 -0400", hash_original_method = "22A07573F54A4BDDEECBBE8A8D080BB9", hash_generated_method = "5E7F5D532C293F576230385FDF9F78AC")
    public byte[] read(int length) throws IOException {
        addTaint(length);
        byte[] res = new byte[length];
for(int i=0;i<length;i++)
        {
            res[i] = (byte) read();
        } 
        byte[] var9B207167E5381C47682C6B4F58A623FB_1095016521 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1722510719 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1722510719;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.095 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "152770D15F9E9DAA16E7F58E45E1782B")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        int read_b;
        int i = 0;
        do {
            {
    if((read_b = read()) == -1)                
                {
                    int var9094914C036467CD32E9F7E210E518F4_2135413821 = ((i == 0) ? -1 : i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390696642 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390696642;
                } 
                b[off+i] = (byte) read_b;
                i++;
            } 
} while ((available() != 0) && (i<len));
        int var865C0C0B4AB0E063E5CAA3387C1A8741_1022558488 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452680499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452680499;
        
        
        
        
            
                
            
            
            
        
        
    }

    
}

