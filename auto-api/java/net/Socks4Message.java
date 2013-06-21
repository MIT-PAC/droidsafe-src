package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteOrder;
import java.nio.charset.Charsets;
import libcore.io.Memory;

class Socks4Message {
    protected byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.143 -0400", hash_original_method = "B36A7D8FEC73E76C782613C0576445D4", hash_generated_method = "E9318A5E21073D72E3A92D6D1199A0E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Socks4Message() {
        buffer = new byte[BUFFER_LENGTH];
        setVersionNumber(SOCKS_VERSION);
        // ---------- Original Method ----------
        //buffer = new byte[BUFFER_LENGTH];
        //setVersionNumber(SOCKS_VERSION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.144 -0400", hash_original_method = "A4884809092D405A6CA5F6BEFDF8445C", hash_generated_method = "6DAEA4EAE5138F61FD03C3DF9A34EFF1")
    @DSModeled(DSC.SAFE)
    public int getCommandOrResult() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return buffer[INDEX_COMMAND];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.144 -0400", hash_original_method = "338C1B26BFB9D7C284F2A4F94981D480", hash_generated_method = "CD1277E04B47AFBF879F73712033A345")
    @DSModeled(DSC.SAFE)
    public void setCommandOrResult(int command) {
        dsTaint.addTaint(command);
        buffer[INDEX_COMMAND] = (byte) command;
        // ---------- Original Method ----------
        //buffer[INDEX_COMMAND] = (byte) command;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.144 -0400", hash_original_method = "469B36103954E60DA4EDBA1638A3DCA3", hash_generated_method = "B01DD2F664409947B3943FA78E4334EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        int var2D60307C5C559F9592EBA8A328E67694_1565970830 = (Memory.peekShort(buffer, INDEX_PORT, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Memory.peekShort(buffer, INDEX_PORT, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.144 -0400", hash_original_method = "5ADD361358F9B7D845CC4C6A0E6C787A", hash_generated_method = "268536D2641C9A03623A61590A1F26E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPort(int port) {
        dsTaint.addTaint(port);
        Memory.pokeShort(buffer, INDEX_PORT, (short) port, ByteOrder.BIG_ENDIAN);
        // ---------- Original Method ----------
        //Memory.pokeShort(buffer, INDEX_PORT, (short) port, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.144 -0400", hash_original_method = "2791CEFF5B7A34F564852C42E861A745", hash_generated_method = "900EE11C118FDA72B41A5D19E705F33B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIP() {
        int var7EFF0BFE855A0CE7874E2EB46E97D71E_129477443 = (Memory.peekInt(buffer, INDEX_IP, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Memory.peekInt(buffer, INDEX_IP, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.145 -0400", hash_original_method = "CD63C26544B74E77AC58BA3597D39036", hash_generated_method = "BDEBE1749D8A930C24CE51F2954A4CB8")
    @DSModeled(DSC.SAFE)
    public void setIP(byte[] ip) {
        dsTaint.addTaint(ip[0]);
        buffer[INDEX_IP] = ip[0];
        buffer[INDEX_IP + 1] = ip[1];
        buffer[INDEX_IP + 2] = ip[2];
        buffer[INDEX_IP + 3] = ip[3];
        // ---------- Original Method ----------
        //buffer[INDEX_IP] = ip[0];
        //buffer[INDEX_IP + 1] = ip[1];
        //buffer[INDEX_IP + 2] = ip[2];
        //buffer[INDEX_IP + 3] = ip[3];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.145 -0400", hash_original_method = "6684A79AEF4191DE9F243F196998CD91", hash_generated_method = "CD925A86CDB02AB7A2C5FDF2F98D04E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserId() {
        String var04884D878DF88A1EC1F6C6E7D1F51E79_2011419937 = (getString(INDEX_USER_ID, MAX_USER_ID_LENGTH));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getString(INDEX_USER_ID, MAX_USER_ID_LENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.145 -0400", hash_original_method = "D89FFAAC0CE83481287E79A931367547", hash_generated_method = "DAD9114A2EF34D1A4CAA2DB082BCD85B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUserId(String id) {
        dsTaint.addTaint(id);
        setString(INDEX_USER_ID, MAX_USER_ID_LENGTH, id);
        // ---------- Original Method ----------
        //setString(INDEX_USER_ID, MAX_USER_ID_LENGTH, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.145 -0400", hash_original_method = "614A9A2B6D9145E41E65A77CC642278E", hash_generated_method = "DB1ADA891542AB5CE0E38E344D443616")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder buf;
        buf = new StringBuilder(50);
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
        String var0C174602EFE4BFBCB80A7056CFA680FB_1777665542 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(50);
        //buf.append("Version: ");
        //buf.append(Integer.toHexString(getVersionNumber()));
        //buf.append(" Command: ");
        //buf.append(Integer.toHexString(getCommandOrResult()));
        //buf.append(" Port: ");
        //buf.append(getPort());
        //buf.append(" IP: ");
        //buf.append(Integer.toHexString(getIP()));
        //buf.append(" User ID: ");
        //buf.append(getUserId());
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.145 -0400", hash_original_method = "C6D8DA97966902AB2F65AB6185B0BF06", hash_generated_method = "B40623E892C142B0BEB76773A7ABB6C1")
    @DSModeled(DSC.SAFE)
    public int getLength() {
        int index;
        index = 0;
        {
            index = INDEX_USER_ID;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int index = 0;
        //for (index = INDEX_USER_ID; buffer[index] != 0; index++) {
        //}
        //index++;
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.146 -0400", hash_original_method = "B4F98C9F9790743D28172709107A8C07", hash_generated_method = "1726F3E18B51F973C0D7B93D3FA03F64")
    @DSModeled(DSC.SAFE)
    public String getErrorString(int error) {
        dsTaint.addTaint(error);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch (error) {
        //case RETURN_FAILURE:
            //return "Failure to connect to SOCKS server";
        //case RETURN_CANNOT_CONNECT_TO_IDENTD:
            //return "Unable to connect to identd to verify user";
        //case RETURN_DIFFERENT_USER_IDS:
            //return "Failure - user ids do not match";
        //default:
            //return "Success";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.146 -0400", hash_original_method = "3E8202366775B7F03BFD8ECC0DED5E39", hash_generated_method = "3D05D541EF22A6B9A5680ED21212F7B4")
    @DSModeled(DSC.SAFE)
    public byte[] getBytes() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.146 -0400", hash_original_method = "B2CC94DDACEA4538F2C9BF58B190DB1B", hash_generated_method = "E548247B3182FA98A6D6EC6F2E745D92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getString(int offset, int maxLength) {
        dsTaint.addTaint(maxLength);
        dsTaint.addTaint(offset);
        int index;
        index = offset;
        int lastIndex;
        lastIndex = index + maxLength;
        String varEEA0F769047BD74E3D55E00D57926DB9_1068849099 = (new String(buffer, offset, index - offset, Charsets.ISO_8859_1));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int index = offset;
        //int lastIndex = index + maxLength;
        //while (index < lastIndex && (buffer[index] != 0)) {
            //index++;
        //}
        //return new String(buffer, offset, index - offset, Charsets.ISO_8859_1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.146 -0400", hash_original_method = "7A63CD666B1834D5EA2D981ACB832F0E", hash_generated_method = "09A931DA7C63091EC081BB0BDB842C2A")
    @DSModeled(DSC.SAFE)
    private int getVersionNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return buffer[INDEX_VERSION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.146 -0400", hash_original_method = "9E3EFE7D6597C76393DFD5F31266B92C", hash_generated_method = "762AE53D8962817B58333ECC76F2A56D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setString(int offset, int maxLength, String theString) {
        dsTaint.addTaint(theString);
        dsTaint.addTaint(maxLength);
        dsTaint.addTaint(offset);
        byte[] stringBytes;
        stringBytes = theString.getBytes(Charsets.ISO_8859_1);
        int length;
        length = Math.min(stringBytes.length, maxLength);
        System.arraycopy(stringBytes, 0, buffer, offset, length);
        buffer[offset + length] = 0;
        // ---------- Original Method ----------
        //byte[] stringBytes = theString.getBytes(Charsets.ISO_8859_1);
        //int length = Math.min(stringBytes.length, maxLength);
        //System.arraycopy(stringBytes, 0, buffer, offset, length);
        //buffer[offset + length] = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.146 -0400", hash_original_method = "551CE4AE0E4E79E50F85783B3E28117C", hash_generated_method = "B397BCDE97777830D5171EEAEDF02C74")
    @DSModeled(DSC.SAFE)
    private void setVersionNumber(int number) {
        dsTaint.addTaint(number);
        buffer[INDEX_VERSION] = (byte) number;
        // ---------- Original Method ----------
        //buffer[INDEX_VERSION] = (byte) number;
    }

    
    static final int COMMAND_CONNECT = 1;
    static final int COMMAND_BIND = 2;
    static final int RETURN_SUCCESS = 90;
    static final int RETURN_FAILURE = 91;
    static final int RETURN_CANNOT_CONNECT_TO_IDENTD = 92;
    static final int RETURN_DIFFERENT_USER_IDS = 93;
    static final int REPLY_LENGTH = 8;
    static final int INDEX_VERSION = 0;
    private static final int SOCKS_VERSION = 4;
    private static final int INDEX_COMMAND = 1;
    private static final int INDEX_PORT = 2;
    private static final int INDEX_IP = 4;
    private static final int INDEX_USER_ID = 8;
    private static final int BUFFER_LENGTH = 256;
    private static final int MAX_USER_ID_LENGTH = BUFFER_LENGTH - INDEX_USER_ID;
}

