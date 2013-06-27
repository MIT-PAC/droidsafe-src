package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.crypto.Cipher;

public abstract class ConnectionState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_field = "7E0281E8D0752C287C7E9EF3D786E7A3", hash_generated_field = "500F69F1C60CEE28C5C2ED8A78A310D1")

    protected Cipher encCipher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_field = "044C62AA5D8BF5BA0D564C7437A1CF13", hash_generated_field = "8B33CC70399B336F104EFE9D5E043B16")

    protected Cipher decCipher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_field = "471827D86551EB9B51F054D563C85636", hash_generated_field = "9C8F77FAB651025BE38856FBA3B311B5")

    protected int block_size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_field = "1B1B65EB7A79A67B26FC4EA2DDB83D99", hash_generated_field = "E1CDB65CF7EE51A58855DD94D92E1EAE")

    protected int hash_size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_field = "B9120A77E0C9360946200E8F9576819C", hash_generated_field = "E531AB0AF8406D0BDD94F4B231FCC6F9")

    protected byte[] write_seq_num = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_field = "60ADF91A095CBDF38C270EA47CF6BB5A", hash_generated_field = "1D5C880D25644D6B5D059D1D70516110")

    protected byte[] read_seq_num = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_field = "42B847A03416128B2166C9E5499953D7", hash_generated_field = "20CDF3CF116D1709E473D472063662F7")

    protected Logger.Stream logger = Logger.getStream("conn_state");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.818 -0400", hash_original_method = "88641B04B82E21943FBE8D6E4F07DC57", hash_generated_method = "88641B04B82E21943FBE8D6E4F07DC57")
    public ConnectionState ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.819 -0400", hash_original_method = "A4712167FB5CF3F93D986A297FF936DF", hash_generated_method = "4CBBF4145BB8D8610C6E9551ACBEF386")
    protected int getMinFragmentSize() {
        int var42E7BA7664A2DCCFE7BEE46BE6E36F80_980142202 = (encCipher.getOutputSize(1+hash_size));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426964579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_426964579;
        // ---------- Original Method ----------
        //return encCipher.getOutputSize(1+hash_size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.820 -0400", hash_original_method = "DD3B7DF1039350512C674DDBBC384DAA", hash_generated_method = "9A75169CD02CDA114D8FC6EFDA631031")
    protected int getFragmentSize(int content_size) {
        int var1B7F35805D7D31794B834252131E8654_1597776976 = (encCipher.getOutputSize(content_size+hash_size));
        addTaint(content_size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642280666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642280666;
        // ---------- Original Method ----------
        //return encCipher.getOutputSize(content_size+hash_size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.820 -0400", hash_original_method = "1E3397EF0AF5BC858955A8504765F190", hash_generated_method = "B810358B75E2A0E0A1158DAA27DE7CDD")
    protected int getContentSize(int generic_cipher_size) {
        int var454DC8BF516F46D089C3CCFEA3307C93_1299203192 = (decCipher.getOutputSize(generic_cipher_size)-hash_size);
        addTaint(generic_cipher_size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473754277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473754277;
        // ---------- Original Method ----------
        //return decCipher.getOutputSize(generic_cipher_size)-hash_size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.820 -0400", hash_original_method = "56D34079E1DEB6511460268571012285", hash_generated_method = "93495FF31362C5E598E5DCECC32B413C")
    protected int getPaddingSize(int content_size) {
        int mask;
        mask = block_size - 1;
        addTaint(content_size);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061635918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061635918;
        // ---------- Original Method ----------
        //int mask = block_size - 1;
        //return (block_size - (content_size & mask));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.821 -0400", hash_original_method = "0AD5A21CD5938B7890C178E88EF1C886", hash_generated_method = "8C21A3C9851CA2C32F9D1A526B512876")
    protected byte[] encrypt(byte type, byte[] fragment) {
        byte[] var89F0A6FB93D4E8AA94D0DFAF52E4CE3A_1649874399 = (encrypt(type, fragment, 0, fragment.length));
        addTaint(type);
        addTaint(fragment[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1953102139 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1953102139;
        // ---------- Original Method ----------
        //return encrypt(type, fragment, 0, fragment.length);
    }

    
    protected abstract byte[] encrypt
        (byte type, byte[] fragment, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.821 -0400", hash_original_method = "4CD2779F027BE7D5E16F48C0F5195279", hash_generated_method = "54B8B6D817645B7790104D532BB22E7D")
    protected byte[] decrypt(byte type, byte[] fragment) {
        byte[] var492AC30713F1AE92D5066440B1233849_1634876854 = (decrypt(type, fragment, 0, fragment.length));
        addTaint(type);
        addTaint(fragment[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_733826578 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_733826578;
        // ---------- Original Method ----------
        //return decrypt(type, fragment, 0, fragment.length);
    }

    
    protected abstract byte[] decrypt
        (byte type, byte[] fragment, int offset, int len);

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.831 -0400", hash_original_method = "ECD0F58ABB6F3F91F5B43C452FA3783B", hash_generated_method = "45374575F4C81D80B045B03D05886A37")
    protected void shutdown() {
        encCipher = null;
        decCipher = null;
        {
            int i;
            i = 0;
            {
                write_seq_num[i] = 0;
                read_seq_num[i] = 0;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //encCipher = null;
        //decCipher = null;
        //for (int i=0; i<write_seq_num.length; i++) {
            //write_seq_num[i] = 0;
            //read_seq_num[i] = 0;
        //}
    }

    
}

