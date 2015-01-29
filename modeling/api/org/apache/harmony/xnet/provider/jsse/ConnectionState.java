package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.crypto.Cipher;

public abstract class ConnectionState {

    /**
     * Increments the sequence number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.891 -0500", hash_original_method = "CDB1021A2FBFF92D2A663F19F350FE72", hash_generated_method = "9E72F854679365A172B31C203F9C9101")
    
protected static void incSequenceNumber(byte[] seq_num) {
        int octet = 7;
        while (octet >= 0) {
            seq_num[octet] ++;
            if (seq_num[octet] == 0) {
                // characteristic overflow, so
                // carrying a number in adding
                octet --;
            } else {
                return;
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.857 -0500", hash_original_field = "6D8061D0A788980F21B439241045A062", hash_generated_field = "500F69F1C60CEE28C5C2ED8A78A310D1")

    protected Cipher encCipher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.859 -0500", hash_original_field = "719CD64012D69C8ADB6963C8D64D81EF", hash_generated_field = "8B33CC70399B336F104EFE9D5E043B16")

    protected Cipher decCipher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.861 -0500", hash_original_field = "4C94C8F60C0B83191718331720964626", hash_generated_field = "9C8F77FAB651025BE38856FBA3B311B5")

    protected int block_size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.863 -0500", hash_original_field = "E2E949CFC316BADAC5E2491D8F100F86", hash_generated_field = "E1CDB65CF7EE51A58855DD94D92E1EAE")

    protected int hash_size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.865 -0500", hash_original_field = "6246828921515969BEDB4EDF72772A3E", hash_generated_field = "2E793588BF371F357B2F4321A1C36EC3")

    protected final byte[] write_seq_num = {0, 0, 0, 0, 0, 0, 0, 0};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.868 -0500", hash_original_field = "F58178DB63D9A79F4D72E6BA0AEF6260", hash_generated_field = "B0D980ABBBB06862FD52BAC692678808")

    protected final byte[] read_seq_num = {0, 0, 0, 0, 0, 0, 0, 0};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.871 -0500", hash_original_field = "16399394529F4E1101CB1267B59A8CF1", hash_generated_field = "20CDF3CF116D1709E473D472063662F7")

    protected Logger.Stream logger = Logger.getStream("conn_state");
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.311 -0400", hash_original_method = "88641B04B82E21943FBE8D6E4F07DC57", hash_generated_method = "88641B04B82E21943FBE8D6E4F07DC57")
    public ConnectionState ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the minimal possible size of the
     * Generic[Stream|Generic]Cipher structure under this
     * connection state.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.873 -0500", hash_original_method = "A4712167FB5CF3F93D986A297FF936DF", hash_generated_method = "76A50EF9052D170FF6A2BDD0D851B148")
    
protected int getMinFragmentSize() {
        // block ciphers return value with padding included
        return encCipher.getOutputSize(1+hash_size); // 1 byte for data
    }

    /**
     * Returns the size of the Generic[Stream|Generic]Cipher structure
     * corresponding to the content data of specified size.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.875 -0500", hash_original_method = "DD3B7DF1039350512C674DDBBC384DAA", hash_generated_method = "E6BE36078D083E4DBD9620DEDD605C5B")
    
protected int getFragmentSize(int content_size) {
        return encCipher.getOutputSize(content_size+hash_size);
    }

    /**
     * Returns the minimal upper bound of the content size enclosed
     * into the Generic[Stream|Generic]Cipher structure of specified size.
     * For stream ciphers the returned value will be exact value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.877 -0500", hash_original_method = "1E3397EF0AF5BC858955A8504765F190", hash_generated_method = "6A05FF6314EB5C241917F5BB9744C0B7")
    
protected int getContentSize(int generic_cipher_size) {
        //it does not take the padding of block ciphered structures
        //into account (so returned value can be greater than actual)
        return decCipher.getOutputSize(generic_cipher_size)-hash_size;
    }

    /**
     * Returns the number of bytes of padding required to round the
     * content up to the required block size. Assumes power of two
     * block size.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.879 -0500", hash_original_method = "56D34079E1DEB6511460268571012285", hash_generated_method = "A0B1D361809AEB51D3FE355435E102CA")
    
protected int getPaddingSize(int content_size) {
        int mask = block_size - 1;
        return (block_size - (content_size & mask));
    }

    /**
     * Creates the GenericStreamCipher or GenericBlockCipher
     * data structure for specified data of specified type.
     * @param type - the ContentType of the provided data
     * @param fragment - the byte array containing the
     * data to be encrypted under the current connection state.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.881 -0500", hash_original_method = "0AD5A21CD5938B7890C178E88EF1C886", hash_generated_method = "F0983B657BF580079AFB1A227E779D06")
    
protected byte[] encrypt(byte type, byte[] fragment) {
        return encrypt(type, fragment, 0, fragment.length);
    }

    /**
     * Creates the GenericStreamCipher or GenericBlockCipher
     * data structure for specified data of specified type.
     * @param type - the ContentType of the provided data
     * @param fragment - the byte array containing the
     * data to be encrypted under the current connection state.
     * @param offset - the offset from which the data begins with.
     * @param len - the length of the data.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.883 -0500", hash_original_method = "3BA36083D14EF25C2A4B1EE235DAA602", hash_generated_method = "1DCEEA0F5183767845A022B6BACDF1AC")
    
protected abstract byte[] encrypt
        (byte type, byte[] fragment, int offset, int len);

    /**
     * Retrieves the fragment of the Plaintext structure of
     * the specified type from the provided data.
     * @param type - the ContentType of the data to be decrypted.
     * @param fragment - the byte array containing the
     * data to be encrypted under the current connection state.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.887 -0500", hash_original_method = "4CD2779F027BE7D5E16F48C0F5195279", hash_generated_method = "16F51084DF8803493075EFFA252F5F81")
    
protected byte[] decrypt(byte type, byte[] fragment) {
        return decrypt(type, fragment, 0, fragment.length);
    }

    /**
     * Retrieves the fragment of the Plaintext structure of
     * the specified type from the provided data.
     * @param type - the ContentType of the data to be decrypted.
     * @param fragment - the byte array containing the
     * data to be encrypted under the current connection state.
     * @param offset - the offset from which the data begins with.
     * @param len - the length of the data.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.889 -0500", hash_original_method = "C51A7F91262654A476F1D9D597BDBA8D", hash_generated_method = "0F946511B4CA284CFB4EF7F118155BEE")
    
protected abstract byte[] decrypt
        (byte type, byte[] fragment, int offset, int len);

    /**
     * Shutdownes the protocol. It will be impossiblke to use the instance
     * after the calling of this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.894 -0500", hash_original_method = "ECD0F58ABB6F3F91F5B43C452FA3783B", hash_generated_method = "D10F58C6AFB40433FF85AF293094EC6F")
    
protected void shutdown() {
        encCipher = null;
        decCipher = null;
        for (int i=0; i<write_seq_num.length; i++) {
            write_seq_num[i] = 0;
            read_seq_num[i] = 0;
        }
    }
    
}

