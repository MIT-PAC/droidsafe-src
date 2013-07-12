package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteOrder;
import java.nio.charset.Charsets;
import libcore.io.Memory;

class Socks4Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.331 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.331 -0400", hash_original_method = "B36A7D8FEC73E76C782613C0576445D4", hash_generated_method = "E9318A5E21073D72E3A92D6D1199A0E3")
    public  Socks4Message() {
        buffer = new byte[BUFFER_LENGTH];
        setVersionNumber(SOCKS_VERSION);
        // ---------- Original Method ----------
        //buffer = new byte[BUFFER_LENGTH];
        //setVersionNumber(SOCKS_VERSION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.332 -0400", hash_original_method = "A4884809092D405A6CA5F6BEFDF8445C", hash_generated_method = "2BE6B35A23D6BD41692196B6C331F0C6")
    public int getCommandOrResult() {
        int varEEE63384C5EEC1D1F26BE7F607885436_1701381325 = (buffer[INDEX_COMMAND]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289254558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289254558;
        // ---------- Original Method ----------
        //return buffer[INDEX_COMMAND];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.332 -0400", hash_original_method = "338C1B26BFB9D7C284F2A4F94981D480", hash_generated_method = "AB61003D3B9ED48A84B27CC2A1E7703D")
    public void setCommandOrResult(int command) {
        buffer[INDEX_COMMAND] = (byte) command;
        // ---------- Original Method ----------
        //buffer[INDEX_COMMAND] = (byte) command;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.333 -0400", hash_original_method = "469B36103954E60DA4EDBA1638A3DCA3", hash_generated_method = "BCB582224BCA777124B85BD9DB133BE8")
    public int getPort() {
        int varB511F2DC5EB97FB588E4FF68674CB533_1210208411 = (Memory.peekShort(buffer, INDEX_PORT, ByteOrder.BIG_ENDIAN));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134277059 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134277059;
        // ---------- Original Method ----------
        //return Memory.peekShort(buffer, INDEX_PORT, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.333 -0400", hash_original_method = "5ADD361358F9B7D845CC4C6A0E6C787A", hash_generated_method = "FDB203FECF84024288521347C8C8FF5A")
    public void setPort(int port) {
        addTaint(port);
        Memory.pokeShort(buffer, INDEX_PORT, (short) port, ByteOrder.BIG_ENDIAN);
        // ---------- Original Method ----------
        //Memory.pokeShort(buffer, INDEX_PORT, (short) port, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.333 -0400", hash_original_method = "2791CEFF5B7A34F564852C42E861A745", hash_generated_method = "066E63CCC427558FB40CEA39B05A08AF")
    public int getIP() {
        int var43169D413FEAC3CEDA9A813B7443971C_647344312 = (Memory.peekInt(buffer, INDEX_IP, ByteOrder.BIG_ENDIAN));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249903134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249903134;
        // ---------- Original Method ----------
        //return Memory.peekInt(buffer, INDEX_IP, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.334 -0400", hash_original_method = "CD63C26544B74E77AC58BA3597D39036", hash_generated_method = "5BCA823E0F4C72375C8EB1DA49BCFC44")
    public void setIP(byte[] ip) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.335 -0400", hash_original_method = "6684A79AEF4191DE9F243F196998CD91", hash_generated_method = "9FFB82DE7CA4AA545F15CD756077937A")
    public String getUserId() {
String var3DD5599848628D833D4D71F889062CED_792779263 =         getString(INDEX_USER_ID, MAX_USER_ID_LENGTH);
        var3DD5599848628D833D4D71F889062CED_792779263.addTaint(taint);
        return var3DD5599848628D833D4D71F889062CED_792779263;
        // ---------- Original Method ----------
        //return getString(INDEX_USER_ID, MAX_USER_ID_LENGTH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.335 -0400", hash_original_method = "D89FFAAC0CE83481287E79A931367547", hash_generated_method = "A0E7EA3A91B7443981EE6682AFBEDAF6")
    public void setUserId(String id) {
        addTaint(id.getTaint());
        setString(INDEX_USER_ID, MAX_USER_ID_LENGTH, id);
        // ---------- Original Method ----------
        //setString(INDEX_USER_ID, MAX_USER_ID_LENGTH, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.335 -0400", hash_original_method = "614A9A2B6D9145E41E65A77CC642278E", hash_generated_method = "AA280F0E7A13A191CA58745CF704178D")
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
String var4FC680801218E6372BC708D6FA44AE60_634002430 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_634002430.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_634002430;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.336 -0400", hash_original_method = "C6D8DA97966902AB2F65AB6185B0BF06", hash_generated_method = "514521C2E3BA87074999C13790FA496D")
    public int getLength() {
        int index = 0;
for(index = INDEX_USER_ID;buffer[index] != 0;index++)
        {
        } //End block
        index++;
        int var6A992D5529F459A44FEE58C733255E86_962164706 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553241835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553241835;
        // ---------- Original Method ----------
        //int index = 0;
        //for (index = INDEX_USER_ID; buffer[index] != 0; index++) {
        //}
        //index++;
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.336 -0400", hash_original_method = "B4F98C9F9790743D28172709107A8C07", hash_generated_method = "075AEAEF4D2F041E93D4D1AF778DF90D")
    public String getErrorString(int error) {
        addTaint(error);
switch(error){
        case RETURN_FAILURE:
String var8C334539585AAEC2F3973DCA57D77696_1679618640 =         "Failure to connect to SOCKS server";
        var8C334539585AAEC2F3973DCA57D77696_1679618640.addTaint(taint);
        return var8C334539585AAEC2F3973DCA57D77696_1679618640;
        case RETURN_CANNOT_CONNECT_TO_IDENTD:
String varBA8CD2FC92C210E4F81424D65CFB5288_1871010608 =         "Unable to connect to identd to verify user";
        varBA8CD2FC92C210E4F81424D65CFB5288_1871010608.addTaint(taint);
        return varBA8CD2FC92C210E4F81424D65CFB5288_1871010608;
        case RETURN_DIFFERENT_USER_IDS:
String varBC3E5DCAE1F23D0BEC68224A1942D8BA_880483950 =         "Failure - user ids do not match";
        varBC3E5DCAE1F23D0BEC68224A1942D8BA_880483950.addTaint(taint);
        return varBC3E5DCAE1F23D0BEC68224A1942D8BA_880483950;
        default:
String var75B00C229FB73EC955B2048ABEF9CD64_1142432287 =         "Success";
        var75B00C229FB73EC955B2048ABEF9CD64_1142432287.addTaint(taint);
        return var75B00C229FB73EC955B2048ABEF9CD64_1142432287;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.337 -0400", hash_original_method = "3E8202366775B7F03BFD8ECC0DED5E39", hash_generated_method = "0DB72FCE47D7448D6157FD8B96F33C80")
    public byte[] getBytes() {
        byte[] var7F2DB423A49B305459147332FB01CF87_1837627739 = (buffer);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2112459578 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2112459578;
        // ---------- Original Method ----------
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.337 -0400", hash_original_method = "B2CC94DDACEA4538F2C9BF58B190DB1B", hash_generated_method = "B18B780F786420A0C6FB0C71BA7910C8")
    private String getString(int offset, int maxLength) {
        addTaint(maxLength);
        addTaint(offset);
        int index = offset;
        int lastIndex = index + maxLength;
        while
(index < lastIndex && (buffer[index] != 0))        
        {
            index++;
        } //End block
String varD6DBB704B6C19F3F537EF08C38038191_1919335089 =         new String(buffer, offset, index - offset, Charsets.ISO_8859_1);
        varD6DBB704B6C19F3F537EF08C38038191_1919335089.addTaint(taint);
        return varD6DBB704B6C19F3F537EF08C38038191_1919335089;
        // ---------- Original Method ----------
        //int index = offset;
        //int lastIndex = index + maxLength;
        //while (index < lastIndex && (buffer[index] != 0)) {
            //index++;
        //}
        //return new String(buffer, offset, index - offset, Charsets.ISO_8859_1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.338 -0400", hash_original_method = "7A63CD666B1834D5EA2D981ACB832F0E", hash_generated_method = "1900F7CBE172FAB5FC5591A40954B047")
    private int getVersionNumber() {
        int var3BDC3373F100A77A4D510F10D3356443_1847244460 = (buffer[INDEX_VERSION]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027721193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027721193;
        // ---------- Original Method ----------
        //return buffer[INDEX_VERSION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.338 -0400", hash_original_method = "9E3EFE7D6597C76393DFD5F31266B92C", hash_generated_method = "799EA2088F1838B1C3FD809E32372B92")
    private void setString(int offset, int maxLength, String theString) {
        addTaint(theString.getTaint());
        addTaint(maxLength);
        byte[] stringBytes = theString.getBytes(Charsets.ISO_8859_1);
        int length = Math.min(stringBytes.length, maxLength);
        System.arraycopy(stringBytes, 0, buffer, offset, length);
        buffer[offset + length] = 0;
        // ---------- Original Method ----------
        //byte[] stringBytes = theString.getBytes(Charsets.ISO_8859_1);
        //int length = Math.min(stringBytes.length, maxLength);
        //System.arraycopy(stringBytes, 0, buffer, offset, length);
        //buffer[offset + length] = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.339 -0400", hash_original_method = "551CE4AE0E4E79E50F85783B3E28117C", hash_generated_method = "057034333245897DECAF09231E016CBC")
    private void setVersionNumber(int number) {
        buffer[INDEX_VERSION] = (byte) number;
        // ---------- Original Method ----------
        //buffer[INDEX_VERSION] = (byte) number;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.339 -0400", hash_original_field = "C5FF2770841EEFCE383E8EE6D75273FB", hash_generated_field = "BD6A3E366ABE51C7B3F08250983C2F91")

    static final int COMMAND_CONNECT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.339 -0400", hash_original_field = "32DC8996110ACF18979D71096383FA9F", hash_generated_field = "F735423BCF52759E7B7A45F0E32AC8FD")

    static final int COMMAND_BIND = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.339 -0400", hash_original_field = "8C7BC1007E9ED4B2A45191FE9478145A", hash_generated_field = "26BFE3379A1A1AE8BAEB428717D32786")

    static final int RETURN_SUCCESS = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.339 -0400", hash_original_field = "976D83FFC7094BBBC0BAE39D5A724887", hash_generated_field = "5F609D15A27ECDAC5A62734391BA0F59")

    static final int RETURN_FAILURE = 91;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.339 -0400", hash_original_field = "4BF7DEB35C53E0B7B8879D07FA14F9D2", hash_generated_field = "8F1AAE4D86AAC8AB92A2F0E1D6BA1104")

    static final int RETURN_CANNOT_CONNECT_TO_IDENTD = 92;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "33B1F35A25E7E4E0499C35CC8CF2F190", hash_generated_field = "72BB404C9089606F3DE1ADF1E7C23EE6")

    static final int RETURN_DIFFERENT_USER_IDS = 93;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "C4FFC497CF61DD83262469DCBF203A42", hash_generated_field = "64BC989AFEFF38DC56D1E542C05D9CB5")

    static final int REPLY_LENGTH = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "7D799A1EE30E6BD5FB068A4052A15310", hash_generated_field = "961D1E6487A898D5A36F43E5BD69FEC6")

    static final int INDEX_VERSION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "9EA229E82ADA2E6B224072D7E0BEAB52", hash_generated_field = "B16117D7B56E6971EC3B5C27919F21AB")

    private static final int SOCKS_VERSION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "A7ADFC25BE50E59A3A956A77C504CA4E", hash_generated_field = "03D47C24378A3D5475059C87E820B634")

    private static final int INDEX_COMMAND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "91BD9959E9EC433EC243CF0BF3834242", hash_generated_field = "D9AEF46DB7567A3082AD47C4A819E6F9")

    private static final int INDEX_PORT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "6E678873BC6A2265656702D1BBCB1D29", hash_generated_field = "4BCA5D8E515996ECD4311F972DC3FF6F")

    private static final int INDEX_IP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "31C4897737DEFEA6925C5A195156C7E8", hash_generated_field = "10C7D7F212FA8E6718A232CE1F343D59")

    private static final int INDEX_USER_ID = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.340 -0400", hash_original_field = "9C50A15DCC2EF4E92AEADB144DF121E0", hash_generated_field = "20DDA2E0F060AAFB5D2D76BE9092D1A1")

    private static final int BUFFER_LENGTH = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.341 -0400", hash_original_field = "9434C63DCE6845E57773F13F4D1BB469", hash_generated_field = "C1A9FB57B28C3ABA9BF2F497C036436F")

    private static final int MAX_USER_ID_LENGTH = BUFFER_LENGTH - INDEX_USER_ID;
}

