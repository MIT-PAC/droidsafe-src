package android.bluetooth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;

final class BluetoothInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.542 -0400", hash_original_field = "ADAA094F2E9199B78AA3ADA013DBD64F", hash_generated_field = "F41529E7146F039F8982FD61509E896F")

    private BluetoothSocket mSocket;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.543 -0400", hash_original_method = "A759A55FDB7858A5B7FBD6EFC5F7FCA1", hash_generated_method = "51DD95F90510A057FC33A562FC393929")
      BluetoothInputStream(BluetoothSocket s) {
        mSocket = s;
        // ---------- Original Method ----------
        //mSocket = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.544 -0400", hash_original_method = "F8D5D10C5F2F8FB1DCC0A3044A3235C3", hash_generated_method = "3BA9A6A09AECF38338432FAD247DC680")
    public int available() throws IOException {
        int varEDE8435F226749B7C408708AD6C4DD12_381519550 = (mSocket.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727541932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727541932;
        // ---------- Original Method ----------
        //return mSocket.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.545 -0400", hash_original_method = "1323B57D07CB6385C2F8CE9373488A22", hash_generated_method = "FD4CC8D718C262BFF2A44C717A5A00BB")
    public void close() throws IOException {
        mSocket.close();
        // ---------- Original Method ----------
        //mSocket.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.546 -0400", hash_original_method = "2059D974D6DFEDC9A8B8553096188222", hash_generated_method = "D0A545C552BF89965D6F9E4C791B8681")
    public int read() throws IOException {
        byte b[] = new byte[1];
        int ret = mSocket.read(b, 0, 1);
        if(ret == 1)        
        {
            int var55D3865AACD24064F6ACF0F89CB68FB7_345046828 = ((int)b[0] & 0xff);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100013060 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100013060;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1165957812 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602807698 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602807698;
        } //End block
        // ---------- Original Method ----------
        //byte b[] = new byte[1];
        //int ret = mSocket.read(b, 0, 1);
        //if (ret == 1) {
            //return (int)b[0] & 0xff;
        //} else {
            //return -1;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:58.549 -0400", hash_original_method = "20F62B1F3CA63F6FE3BCEE9660F3F09F", hash_generated_method = "46E7C3EA611BB7EC9176F845509BABF3")
    public int read(byte[] b, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(b[0]);
        if(b == null)        
        {
            NullPointerException varFDA6DA8786FB3EDEDA1C4BF2D933D93D_330398779 = new NullPointerException("byte array is null");
            varFDA6DA8786FB3EDEDA1C4BF2D933D93D_330398779.addTaint(taint);
            throw varFDA6DA8786FB3EDEDA1C4BF2D933D93D_330398779;
        } //End block
        if((offset | length) < 0 || length > b.length - offset)        
        {
            ArrayIndexOutOfBoundsException varF956884CC32113133701D15839A01732_2115292299 = new ArrayIndexOutOfBoundsException("invalid offset or length");
            varF956884CC32113133701D15839A01732_2115292299.addTaint(taint);
            throw varF956884CC32113133701D15839A01732_2115292299;
        } //End block
        int varC95072A2E1DBA960320350DBD9DB4A02_293157138 = (mSocket.read(b, offset, length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337099936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337099936;
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new NullPointerException("byte array is null");
        //}
        //if ((offset | length) < 0 || length > b.length - offset) {
            //throw new ArrayIndexOutOfBoundsException("invalid offset or length");
        //}
        //return mSocket.read(b, offset, length);
    }

    
}

