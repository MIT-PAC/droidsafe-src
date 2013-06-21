package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.crypto.Cipher;

public abstract class ConnectionState {
    protected Cipher encCipher;
    protected Cipher decCipher;
    protected int block_size;
    protected int hash_size;
    protected byte[] write_seq_num = {0, 0, 0, 0, 0, 0, 0, 0};
    protected byte[] read_seq_num = {0, 0, 0, 0, 0, 0, 0, 0};
    protected Logger.Stream logger = Logger.getStream("conn_state");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.669 -0400", hash_original_method = "BD00B9051C2325C8AB6BFA4BEDEFE8A8", hash_generated_method = "BD00B9051C2325C8AB6BFA4BEDEFE8A8")
        public ConnectionState ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.670 -0400", hash_original_method = "A4712167FB5CF3F93D986A297FF936DF", hash_generated_method = "6EA91D94F713C9C43A61B1056471FA6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getMinFragmentSize() {
        int var42E7BA7664A2DCCFE7BEE46BE6E36F80_718823826 = (encCipher.getOutputSize(1+hash_size));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return encCipher.getOutputSize(1+hash_size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.670 -0400", hash_original_method = "DD3B7DF1039350512C674DDBBC384DAA", hash_generated_method = "A0D97D2CFC086C624715BCDA41A4689A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getFragmentSize(int content_size) {
        dsTaint.addTaint(content_size);
        int var1B7F35805D7D31794B834252131E8654_1007847335 = (encCipher.getOutputSize(content_size+hash_size));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return encCipher.getOutputSize(content_size+hash_size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.671 -0400", hash_original_method = "1E3397EF0AF5BC858955A8504765F190", hash_generated_method = "EF6E86C1EE2A207775FD1516071E8BDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getContentSize(int generic_cipher_size) {
        dsTaint.addTaint(generic_cipher_size);
        int var454DC8BF516F46D089C3CCFEA3307C93_1559159441 = (decCipher.getOutputSize(generic_cipher_size)-hash_size);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return decCipher.getOutputSize(generic_cipher_size)-hash_size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.671 -0400", hash_original_method = "56D34079E1DEB6511460268571012285", hash_generated_method = "3960725363083D63A486377DB11711D5")
    @DSModeled(DSC.SAFE)
    protected int getPaddingSize(int content_size) {
        dsTaint.addTaint(content_size);
        int mask;
        mask = block_size - 1;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int mask = block_size - 1;
        //return (block_size - (content_size & mask));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.672 -0400", hash_original_method = "0AD5A21CD5938B7890C178E88EF1C886", hash_generated_method = "88D5B88D1D5F0E3FA50D7C508FB0A109")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] encrypt(byte type, byte[] fragment) {
        dsTaint.addTaint(type);
        dsTaint.addTaint(fragment[0]);
        byte[] var89F0A6FB93D4E8AA94D0DFAF52E4CE3A_363774678 = (encrypt(type, fragment, 0, fragment.length));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return encrypt(type, fragment, 0, fragment.length);
    }

    
    protected abstract byte[] encrypt
        (byte type, byte[] fragment, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.672 -0400", hash_original_method = "4CD2779F027BE7D5E16F48C0F5195279", hash_generated_method = "A413B1706774B6DCA97BB311E5AC96DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] decrypt(byte type, byte[] fragment) {
        dsTaint.addTaint(type);
        dsTaint.addTaint(fragment[0]);
        byte[] var492AC30713F1AE92D5066440B1233849_1139032006 = (decrypt(type, fragment, 0, fragment.length));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.673 -0400", hash_original_method = "ECD0F58ABB6F3F91F5B43C452FA3783B", hash_generated_method = "45374575F4C81D80B045B03D05886A37")
    @DSModeled(DSC.SAFE)
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

