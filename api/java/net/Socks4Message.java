package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteOrder;
import java.nio.charset.Charsets;

import libcore.io.Memory;

class Socks4Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.093 -0500", hash_original_field = "F942E69E6A8BA58B931D09F44410DEF4", hash_generated_field = "BD6A3E366ABE51C7B3F08250983C2F91")

    static final int COMMAND_CONNECT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.095 -0500", hash_original_field = "32F34E85DB27926C1E4275B1F765DB8B", hash_generated_field = "F735423BCF52759E7B7A45F0E32AC8FD")

    static final int COMMAND_BIND = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.098 -0500", hash_original_field = "34039F1F39B46B54F75114D7B6D9B729", hash_generated_field = "26BFE3379A1A1AE8BAEB428717D32786")

    static final int RETURN_SUCCESS = 90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.100 -0500", hash_original_field = "3B34F0EC6027FBF06B3E478D1AD5BB6A", hash_generated_field = "5F609D15A27ECDAC5A62734391BA0F59")

    static final int RETURN_FAILURE = 91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.103 -0500", hash_original_field = "B14E1EF1E5F85072CF1FB6BE0CF1B111", hash_generated_field = "8F1AAE4D86AAC8AB92A2F0E1D6BA1104")

    static final int RETURN_CANNOT_CONNECT_TO_IDENTD = 92;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.106 -0500", hash_original_field = "525BB2D5FB0C1DCB48E29ADD5096200A", hash_generated_field = "72BB404C9089606F3DE1ADF1E7C23EE6")

    static final int RETURN_DIFFERENT_USER_IDS = 93;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.108 -0500", hash_original_field = "8B3AE064F3661FED413E16F9D0C5A9E0", hash_generated_field = "64BC989AFEFF38DC56D1E542C05D9CB5")

    static final int REPLY_LENGTH = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.111 -0500", hash_original_field = "ED87EFBB6A569C322D6AB42C7F907C68", hash_generated_field = "961D1E6487A898D5A36F43E5BD69FEC6")

    static final int INDEX_VERSION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.114 -0500", hash_original_field = "ABD6AADD7FF0CEB229D742B5138A0831", hash_generated_field = "B16117D7B56E6971EC3B5C27919F21AB")

    private static final int SOCKS_VERSION = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.116 -0500", hash_original_field = "4BB4489821CBA3E2CFA08569340AC135", hash_generated_field = "03D47C24378A3D5475059C87E820B634")

    private static final int INDEX_COMMAND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.118 -0500", hash_original_field = "456C561D14749B63219BE92F50143BE5", hash_generated_field = "D9AEF46DB7567A3082AD47C4A819E6F9")

    private static final int INDEX_PORT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.121 -0500", hash_original_field = "3E51893C0BFEA93A28B2481B20D5DE15", hash_generated_field = "4BCA5D8E515996ECD4311F972DC3FF6F")

    private static final int INDEX_IP = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.123 -0500", hash_original_field = "2298604F41A9EFCB82D26029C90E2044", hash_generated_field = "10C7D7F212FA8E6718A232CE1F343D59")

    private static final int INDEX_USER_ID = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.126 -0500", hash_original_field = "ECB6902F20BF16ABF2629AE5CF6D52D9", hash_generated_field = "20DDA2E0F060AAFB5D2D76BE9092D1A1")

    private static final int BUFFER_LENGTH = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.129 -0500", hash_original_field = "280E7D156975C27DEA7C4CD9FBA53FC1", hash_generated_field = "C1A9FB57B28C3ABA9BF2F497C036436F")

    private static final int MAX_USER_ID_LENGTH = BUFFER_LENGTH - INDEX_USER_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.131 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.134 -0500", hash_original_method = "B36A7D8FEC73E76C782613C0576445D4", hash_generated_method = "631B85F303C413E68FF6BF74A769BF42")
    
public Socks4Message() {
        buffer = new byte[BUFFER_LENGTH];
        setVersionNumber(SOCKS_VERSION);
    }

    /**
     * Get the request's command or result.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.136 -0500", hash_original_method = "A4884809092D405A6CA5F6BEFDF8445C", hash_generated_method = "4E8203CF55E7FB63242C7B8C74633D90")
    
public int getCommandOrResult() {
        return buffer[INDEX_COMMAND];
    }

    /**
     * Set the request's command or result.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.138 -0500", hash_original_method = "338C1B26BFB9D7C284F2A4F94981D480", hash_generated_method = "D80606DA24E639FE7952CC5B9CA3011D")
    
public void setCommandOrResult(int command) {
        buffer[INDEX_COMMAND] = (byte) command;
    }

    /**
     * Returns the request's port number.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.141 -0500", hash_original_method = "469B36103954E60DA4EDBA1638A3DCA3", hash_generated_method = "76C424240E08A46CC1EE6A45AE9C085A")
    
public int getPort() {
        return Memory.peekShort(buffer, INDEX_PORT, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Set the request's port number.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.143 -0500", hash_original_method = "5ADD361358F9B7D845CC4C6A0E6C787A", hash_generated_method = "07543520C712DD8A6BC7E728EC01D32C")
    
public void setPort(int port) {
        Memory.pokeShort(buffer, INDEX_PORT, (short) port, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Returns the IP address of the request as an integer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.145 -0500", hash_original_method = "2791CEFF5B7A34F564852C42E861A745", hash_generated_method = "AC75FE22CBD6C1F8C5CCE73ECD7F5A27")
    
public int getIP() {
        return Memory.peekInt(buffer, INDEX_IP, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Set the IP address. This expects an array of four bytes in host order.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.148 -0500", hash_original_method = "CD63C26544B74E77AC58BA3597D39036", hash_generated_method = "2F69A5313A94A6570E4DB5DF218D11EC")
    
public void setIP(byte[] ip) {
        buffer[INDEX_IP] = ip[0];
        buffer[INDEX_IP + 1] = ip[1];
        buffer[INDEX_IP + 2] = ip[2];
        buffer[INDEX_IP + 3] = ip[3];
    }

    /**
     * Returns the user id for authentication.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.151 -0500", hash_original_method = "6684A79AEF4191DE9F243F196998CD91", hash_generated_method = "6E223FEB5AC83C17D6E8366011750445")
    
public String getUserId() {
        return getString(INDEX_USER_ID, MAX_USER_ID_LENGTH);
    }

    /**
     * Set the user id for authentication.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.153 -0500", hash_original_method = "D89FFAAC0CE83481287E79A931367547", hash_generated_method = "78E3906F8963A66447ABED40A0D4BF91")
    
public void setUserId(String id) {
        setString(INDEX_USER_ID, MAX_USER_ID_LENGTH, id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.156 -0500", hash_original_method = "614A9A2B6D9145E41E65A77CC642278E", hash_generated_method = "4373509DD759957F5328AB53B3836621")
    
@Override
    public String toString() {
        StringBuilder buf = new StringBuilder(50);
        buf.append("Version: ");
        buf.append(Integer.toHexString(getVersionNumber()));
        buf.append(" Command: ");
        buf.append(Integer.toHexString(getCommandOrResult()));
        buf.append(" Port: ");
        buf.append(getPort());
        buf.append(" IP: ");
        buf.append(Integer.toHexString(getIP()));
        buf.append(" User ID: ");
        buf.append(getUserId());
        return buf.toString();
    }

    /**
     * Returns the total number of bytes used for the request. This method
     * searches for the end of the user id, then searches for the end of the
     * password and returns the final index as the requests length.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.159 -0500", hash_original_method = "C6D8DA97966902AB2F65AB6185B0BF06", hash_generated_method = "4B4B63163B597BA31E6E88BEDB40EF21")
    
public int getLength() {
        int index = 0;

        // Look for the end of the user id.
        for (index = INDEX_USER_ID; buffer[index] != 0; index++) {
            /*
             * Finds the end of the user id by searching for the null
             * termination of the user id string.
             */
        }

        // Increment the index to include the NULL character in the length;
        index++;
        return index;
    }

    /**
     * Returns an error string corresponding to the given error value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.161 -0500", hash_original_method = "B4F98C9F9790743D28172709107A8C07", hash_generated_method = "464E7A654B675E12FF8C2C67A3B8CA2C")
    
public String getErrorString(int error) {
        switch (error) {
        case RETURN_FAILURE:
            return "Failure to connect to SOCKS server";
        case RETURN_CANNOT_CONNECT_TO_IDENTD:
            return "Unable to connect to identd to verify user";
        case RETURN_DIFFERENT_USER_IDS:
            return "Failure - user ids do not match";
        default:
            return "Success";
        }
    }

    /**
     * Returns the message's byte buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.163 -0500", hash_original_method = "3E8202366775B7F03BFD8ECC0DED5E39", hash_generated_method = "8CEA774D71F4BAB32DE7A1AD137FE077")
    
public byte[] getBytes() {
        return buffer;
    }

    /**
     * Get a String from the buffer at the offset given. The method reads until
     * it encounters a null value or reaches the maxLength given.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.165 -0500", hash_original_method = "B2CC94DDACEA4538F2C9BF58B190DB1B", hash_generated_method = "9B486A427284312235492044EB995A7C")
    
private String getString(int offset, int maxLength) {
        int index = offset;
        int lastIndex = index + maxLength;
        while (index < lastIndex && (buffer[index] != 0)) {
            index++;
        }
        return new String(buffer, offset, index - offset, Charsets.ISO_8859_1);
    }

    /**
     * Returns the SOCKS version number. Should always be 4.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.168 -0500", hash_original_method = "7A63CD666B1834D5EA2D981ACB832F0E", hash_generated_method = "FE36F30EF9569F408788D91358A9126C")
    
private int getVersionNumber() {
        return buffer[INDEX_VERSION];
    }

    /**
     * Put a string into the buffer at the offset given.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.170 -0500", hash_original_method = "9E3EFE7D6597C76393DFD5F31266B92C", hash_generated_method = "83DDB8F06251D9CBEE8BAF956BD30CC1")
    
private void setString(int offset, int maxLength, String theString) {
        byte[] stringBytes = theString.getBytes(Charsets.ISO_8859_1);
        int length = Math.min(stringBytes.length, maxLength);
        System.arraycopy(stringBytes, 0, buffer, offset, length);
        buffer[offset + length] = 0;
    }

    /**
     * Set the SOCKS version number. This should always be 4.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.173 -0500", hash_original_method = "551CE4AE0E4E79E50F85783B3E28117C", hash_generated_method = "DAC57D327B3EB24398B8830CB412330E")
    
private void setVersionNumber(int number) {
        buffer[INDEX_VERSION] = (byte) number;
    }
}

