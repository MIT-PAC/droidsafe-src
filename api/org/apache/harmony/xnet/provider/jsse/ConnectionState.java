package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.crypto.Cipher;

public abstract class ConnectionState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.191 -0400", hash_original_field = "7E0281E8D0752C287C7E9EF3D786E7A3", hash_generated_field = "500F69F1C60CEE28C5C2ED8A78A310D1")

    protected Cipher encCipher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.191 -0400", hash_original_field = "044C62AA5D8BF5BA0D564C7437A1CF13", hash_generated_field = "8B33CC70399B336F104EFE9D5E043B16")

    protected Cipher decCipher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.191 -0400", hash_original_field = "471827D86551EB9B51F054D563C85636", hash_generated_field = "9C8F77FAB651025BE38856FBA3B311B5")

    protected int block_size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.191 -0400", hash_original_field = "1B1B65EB7A79A67B26FC4EA2DDB83D99", hash_generated_field = "E1CDB65CF7EE51A58855DD94D92E1EAE")

    protected int hash_size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.191 -0400", hash_original_field = "B9120A77E0C9360946200E8F9576819C", hash_generated_field = "2E793588BF371F357B2F4321A1C36EC3")

    protected final byte[] write_seq_num = {0, 0, 0, 0, 0, 0, 0, 0};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.191 -0400", hash_original_field = "60ADF91A095CBDF38C270EA47CF6BB5A", hash_generated_field = "B0D980ABBBB06862FD52BAC692678808")

    protected final byte[] read_seq_num = {0, 0, 0, 0, 0, 0, 0, 0};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.191 -0400", hash_original_field = "42B847A03416128B2166C9E5499953D7", hash_generated_field = "20CDF3CF116D1709E473D472063662F7")

    protected Logger.Stream logger = Logger.getStream("conn_state");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.192 -0400", hash_original_method = "88641B04B82E21943FBE8D6E4F07DC57", hash_generated_method = "88641B04B82E21943FBE8D6E4F07DC57")
    public ConnectionState ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.192 -0400", hash_original_method = "A4712167FB5CF3F93D986A297FF936DF", hash_generated_method = "125DB0DE7985944D1E2A382C686C85F4")
    protected int getMinFragmentSize() {
        int var8E16396006E30E999C59C6F584041DF5_376117040 = (encCipher.getOutputSize(1+hash_size));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603289913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603289913;
        // ---------- Original Method ----------
        //return encCipher.getOutputSize(1+hash_size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.192 -0400", hash_original_method = "DD3B7DF1039350512C674DDBBC384DAA", hash_generated_method = "31D3A593137538ADAADDFD8785AB3DC6")
    protected int getFragmentSize(int content_size) {
        addTaint(content_size);
        int varAA4996F53AF9DCC5E946114F9E41255A_758416918 = (encCipher.getOutputSize(content_size+hash_size));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983335220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983335220;
        // ---------- Original Method ----------
        //return encCipher.getOutputSize(content_size+hash_size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.193 -0400", hash_original_method = "1E3397EF0AF5BC858955A8504765F190", hash_generated_method = "9FE23C48F077A46C4F4AECBA6497E9A7")
    protected int getContentSize(int generic_cipher_size) {
        addTaint(generic_cipher_size);
        int var1B035F6BABB1AD009B3E3D1683321FFB_957858526 = (decCipher.getOutputSize(generic_cipher_size)-hash_size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712849555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712849555;
        // ---------- Original Method ----------
        //return decCipher.getOutputSize(generic_cipher_size)-hash_size;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.194 -0400", hash_original_method = "56D34079E1DEB6511460268571012285", hash_generated_method = "4C790A5E7751BD899B614470A41AA14E")
    protected int getPaddingSize(int content_size) {
        addTaint(content_size);
        int mask = block_size - 1;
        int var9D67DBE9810ECE44947F61E99F5D022D_709024968 = ((block_size - (content_size & mask)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1035599743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1035599743;
        // ---------- Original Method ----------
        //int mask = block_size - 1;
        //return (block_size - (content_size & mask));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.194 -0400", hash_original_method = "0AD5A21CD5938B7890C178E88EF1C886", hash_generated_method = "707AB8CF0D438E1910D66D0EE7DC6FB0")
    protected byte[] encrypt(byte type, byte[] fragment) {
        addTaint(fragment[0]);
        addTaint(type);
        byte[] varC1921F752758030F419267382FC3E287_425489867 = (encrypt(type, fragment, 0, fragment.length));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1788799919 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1788799919;
        // ---------- Original Method ----------
        //return encrypt(type, fragment, 0, fragment.length);
    }

    
    protected abstract byte[] encrypt
        (byte type, byte[] fragment, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.195 -0400", hash_original_method = "4CD2779F027BE7D5E16F48C0F5195279", hash_generated_method = "6D06FA25684D24F6CE67C7309B777010")
    protected byte[] decrypt(byte type, byte[] fragment) {
        addTaint(fragment[0]);
        addTaint(type);
        byte[] varC1A583ED60A88F1A85B0D7E58F88469D_2179349 = (decrypt(type, fragment, 0, fragment.length));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_394278903 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_394278903;
        // ---------- Original Method ----------
        //return decrypt(type, fragment, 0, fragment.length);
    }

    
    protected abstract byte[] decrypt
        (byte type, byte[] fragment, int offset, int len);

    
        @DSModeled(DSC.SAFE)
    protected static void incSequenceNumber(byte[] seq_num) {
        int octet = 7;
        while (octet >= 0) {
            seq_num[octet] ++;
            if (seq_num[octet] == 0) {
                octet --;
            } else {
                return;
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.196 -0400", hash_original_method = "ECD0F58ABB6F3F91F5B43C452FA3783B", hash_generated_method = "11F44FD967A343893B8B094CF1CF1E92")
    protected void shutdown() {
        encCipher = null;
        decCipher = null;
for(int i=0;i<write_seq_num.length;i++)
        {
            write_seq_num[i] = 0;
            read_seq_num[i] = 0;
        } //End block
        // ---------- Original Method ----------
        //encCipher = null;
        //decCipher = null;
        //for (int i=0; i<write_seq_num.length; i++) {
            //write_seq_num[i] = 0;
            //read_seq_num[i] = 0;
        //}
    }

    
}

