package android.bluetooth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;

final class BluetoothInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.262 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "F41529E7146F039F8982FD61509E896F")

    private BluetoothSocket mSocket;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.263 -0400", hash_original_method = "A759A55FDB7858A5B7FBD6EFC5F7FCA1", hash_generated_method = "51DD95F90510A057FC33A562FC393929")
      BluetoothInputStream(BluetoothSocket s) {
        mSocket = s;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.264 -0400", hash_original_method = "F8D5D10C5F2F8FB1DCC0A3044A3235C3", hash_generated_method = "6ACA49675A81ACD29D0F1D3E8E0FC286")
    public int available() throws IOException {
        int varEDE8435F226749B7C408708AD6C4DD12_1214087003 = (mSocket.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245373333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245373333;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.264 -0400", hash_original_method = "1323B57D07CB6385C2F8CE9373488A22", hash_generated_method = "FD4CC8D718C262BFF2A44C717A5A00BB")
    public void close() throws IOException {
        mSocket.close();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.265 -0400", hash_original_method = "2059D974D6DFEDC9A8B8553096188222", hash_generated_method = "48EF9BD7226151385114ABE8AC442212")
    public int read() throws IOException {
        byte b[] = new byte[1];
        int ret = mSocket.read(b, 0, 1);
    if(ret == 1)        
        {
            int var55D3865AACD24064F6ACF0F89CB68FB7_577273680 = ((int)b[0] & 0xff);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811674514 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811674514;
        } 
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_247214084 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050841504 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050841504;
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:07.266 -0400", hash_original_method = "20F62B1F3CA63F6FE3BCEE9660F3F09F", hash_generated_method = "FD0541313F3FE03B739E1015D5145F86")
    public int read(byte[] b, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(b[0]);
    if(b == null)        
        {
            NullPointerException varFDA6DA8786FB3EDEDA1C4BF2D933D93D_1064589878 = new NullPointerException("byte array is null");
            varFDA6DA8786FB3EDEDA1C4BF2D933D93D_1064589878.addTaint(taint);
            throw varFDA6DA8786FB3EDEDA1C4BF2D933D93D_1064589878;
        } 
    if((offset | length) < 0 || length > b.length - offset)        
        {
            ArrayIndexOutOfBoundsException varF956884CC32113133701D15839A01732_2044820716 = new ArrayIndexOutOfBoundsException("invalid offset or length");
            varF956884CC32113133701D15839A01732_2044820716.addTaint(taint);
            throw varF956884CC32113133701D15839A01732_2044820716;
        } 
        int varC95072A2E1DBA960320350DBD9DB4A02_100848113 = (mSocket.read(b, offset, length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522694974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522694974;
        
        
            
        
        
            
        
        
    }

    
}

