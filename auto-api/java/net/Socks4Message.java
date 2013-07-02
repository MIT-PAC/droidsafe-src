package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.ByteOrder;
import java.nio.charset.Charsets;
import libcore.io.Memory;

class Socks4Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.925 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.926 -0400", hash_original_method = "B36A7D8FEC73E76C782613C0576445D4", hash_generated_method = "E9318A5E21073D72E3A92D6D1199A0E3")
    public  Socks4Message() {
        buffer = new byte[BUFFER_LENGTH];
        setVersionNumber(SOCKS_VERSION);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.927 -0400", hash_original_method = "A4884809092D405A6CA5F6BEFDF8445C", hash_generated_method = "CD45F261D8D03CB1140DB975D68F21DF")
    public int getCommandOrResult() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481873461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481873461;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.927 -0400", hash_original_method = "338C1B26BFB9D7C284F2A4F94981D480", hash_generated_method = "AB61003D3B9ED48A84B27CC2A1E7703D")
    public void setCommandOrResult(int command) {
        buffer[INDEX_COMMAND] = (byte) command;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.928 -0400", hash_original_method = "469B36103954E60DA4EDBA1638A3DCA3", hash_generated_method = "911BB7DF2AA7DE91CDE1A8AED3E067BB")
    public int getPort() {
        int var2D60307C5C559F9592EBA8A328E67694_941468567 = (Memory.peekShort(buffer, INDEX_PORT, ByteOrder.BIG_ENDIAN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737207565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1737207565;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.928 -0400", hash_original_method = "5ADD361358F9B7D845CC4C6A0E6C787A", hash_generated_method = "9AD1FF693458559CFC800800756739BC")
    public void setPort(int port) {
        Memory.pokeShort(buffer, INDEX_PORT, (short) port, ByteOrder.BIG_ENDIAN);
        addTaint(port);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.928 -0400", hash_original_method = "2791CEFF5B7A34F564852C42E861A745", hash_generated_method = "FD2537747E4DAAB7E18AE85D8E8BDCBD")
    public int getIP() {
        int var7EFF0BFE855A0CE7874E2EB46E97D71E_1437645367 = (Memory.peekInt(buffer, INDEX_IP, ByteOrder.BIG_ENDIAN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168242410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168242410;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.929 -0400", hash_original_method = "CD63C26544B74E77AC58BA3597D39036", hash_generated_method = "5BCA823E0F4C72375C8EB1DA49BCFC44")
    public void setIP(byte[] ip) {
        buffer[INDEX_IP] = ip[0];
        buffer[INDEX_IP + 1] = ip[1];
        buffer[INDEX_IP + 2] = ip[2];
        buffer[INDEX_IP + 3] = ip[3];
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.929 -0400", hash_original_method = "6684A79AEF4191DE9F243F196998CD91", hash_generated_method = "B1621E090C80ACC629648625C977C468")
    public String getUserId() {
        String varB4EAC82CA7396A68D541C85D26508E83_361905324 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_361905324 = getString(INDEX_USER_ID, MAX_USER_ID_LENGTH);
        varB4EAC82CA7396A68D541C85D26508E83_361905324.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_361905324;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.930 -0400", hash_original_method = "D89FFAAC0CE83481287E79A931367547", hash_generated_method = "7D377ADCB054D16F4AB91FF39E167CB2")
    public void setUserId(String id) {
        setString(INDEX_USER_ID, MAX_USER_ID_LENGTH, id);
        addTaint(id.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.930 -0400", hash_original_method = "614A9A2B6D9145E41E65A77CC642278E", hash_generated_method = "33BCA9E62ADDC343B74AE790B5E12B4A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1887864149 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1887864149 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1887864149.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1887864149;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.931 -0400", hash_original_method = "C6D8DA97966902AB2F65AB6185B0BF06", hash_generated_method = "2A56FC75E16F28B093C6B83D0CA42B32")
    public int getLength() {
        int index = 0;
        {
            index = INDEX_USER_ID;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235128741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235128741;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.931 -0400", hash_original_method = "B4F98C9F9790743D28172709107A8C07", hash_generated_method = "351E912D8C6E2F3AC6A48800F75C97D6")
    public String getErrorString(int error) {
        String varB4EAC82CA7396A68D541C85D26508E83_429555057 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_726408867 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_903262171 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1135611890 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_429555057 = "Failure to connect to SOCKS server";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_726408867 = "Unable to connect to identd to verify user";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_903262171 = "Failure - user ids do not match";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1135611890 = "Success";
        
        addTaint(error);
        String varA7E53CE21691AB073D9660D615818899_1142884234; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1142884234 = varB4EAC82CA7396A68D541C85D26508E83_429555057;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1142884234 = varB4EAC82CA7396A68D541C85D26508E83_726408867;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1142884234 = varB4EAC82CA7396A68D541C85D26508E83_903262171;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1142884234 = varB4EAC82CA7396A68D541C85D26508E83_1135611890;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1142884234.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1142884234;
        
        
        
            
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.932 -0400", hash_original_method = "3E8202366775B7F03BFD8ECC0DED5E39", hash_generated_method = "6B318DB0F62AD8B05E536EABD410D2F7")
    public byte[] getBytes() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_395592320 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_395592320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.932 -0400", hash_original_method = "B2CC94DDACEA4538F2C9BF58B190DB1B", hash_generated_method = "ED0D5498F94B88C49E65679EADFFAAC1")
    private String getString(int offset, int maxLength) {
        String varB4EAC82CA7396A68D541C85D26508E83_1164889078 = null; 
        int index = offset;
        int lastIndex = index + maxLength;
        varB4EAC82CA7396A68D541C85D26508E83_1164889078 = new String(buffer, offset, index - offset, Charsets.ISO_8859_1);
        addTaint(offset);
        addTaint(maxLength);
        varB4EAC82CA7396A68D541C85D26508E83_1164889078.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1164889078;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_method = "7A63CD666B1834D5EA2D981ACB832F0E", hash_generated_method = "BAE850B88E415A2E9AF0B22A55580F02")
    private int getVersionNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044518030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044518030;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_method = "9E3EFE7D6597C76393DFD5F31266B92C", hash_generated_method = "8A8261862FBABC5B49693219D6B82E72")
    private void setString(int offset, int maxLength, String theString) {
        byte[] stringBytes = theString.getBytes(Charsets.ISO_8859_1);
        int length = Math.min(stringBytes.length, maxLength);
        System.arraycopy(stringBytes, 0, buffer, offset, length);
        buffer[offset + length] = 0;
        addTaint(maxLength);
        addTaint(theString.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_method = "551CE4AE0E4E79E50F85783B3E28117C", hash_generated_method = "057034333245897DECAF09231E016CBC")
    private void setVersionNumber(int number) {
        buffer[INDEX_VERSION] = (byte) number;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_field = "C5FF2770841EEFCE383E8EE6D75273FB", hash_generated_field = "BD6A3E366ABE51C7B3F08250983C2F91")

    static final int COMMAND_CONNECT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_field = "32DC8996110ACF18979D71096383FA9F", hash_generated_field = "F735423BCF52759E7B7A45F0E32AC8FD")

    static final int COMMAND_BIND = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_field = "8C7BC1007E9ED4B2A45191FE9478145A", hash_generated_field = "26BFE3379A1A1AE8BAEB428717D32786")

    static final int RETURN_SUCCESS = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_field = "976D83FFC7094BBBC0BAE39D5A724887", hash_generated_field = "5F609D15A27ECDAC5A62734391BA0F59")

    static final int RETURN_FAILURE = 91;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_field = "4BF7DEB35C53E0B7B8879D07FA14F9D2", hash_generated_field = "8F1AAE4D86AAC8AB92A2F0E1D6BA1104")

    static final int RETURN_CANNOT_CONNECT_TO_IDENTD = 92;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_field = "33B1F35A25E7E4E0499C35CC8CF2F190", hash_generated_field = "72BB404C9089606F3DE1ADF1E7C23EE6")

    static final int RETURN_DIFFERENT_USER_IDS = 93;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.933 -0400", hash_original_field = "C4FFC497CF61DD83262469DCBF203A42", hash_generated_field = "64BC989AFEFF38DC56D1E542C05D9CB5")

    static final int REPLY_LENGTH = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "7D799A1EE30E6BD5FB068A4052A15310", hash_generated_field = "961D1E6487A898D5A36F43E5BD69FEC6")

    static final int INDEX_VERSION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "9EA229E82ADA2E6B224072D7E0BEAB52", hash_generated_field = "B16117D7B56E6971EC3B5C27919F21AB")

    private static final int SOCKS_VERSION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "A7ADFC25BE50E59A3A956A77C504CA4E", hash_generated_field = "03D47C24378A3D5475059C87E820B634")

    private static final int INDEX_COMMAND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "91BD9959E9EC433EC243CF0BF3834242", hash_generated_field = "D9AEF46DB7567A3082AD47C4A819E6F9")

    private static final int INDEX_PORT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "6E678873BC6A2265656702D1BBCB1D29", hash_generated_field = "4BCA5D8E515996ECD4311F972DC3FF6F")

    private static final int INDEX_IP = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "31C4897737DEFEA6925C5A195156C7E8", hash_generated_field = "10C7D7F212FA8E6718A232CE1F343D59")

    private static final int INDEX_USER_ID = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "9C50A15DCC2EF4E92AEADB144DF121E0", hash_generated_field = "20DDA2E0F060AAFB5D2D76BE9092D1A1")

    private static final int BUFFER_LENGTH = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.934 -0400", hash_original_field = "9434C63DCE6845E57773F13F4D1BB469", hash_generated_field = "C1A9FB57B28C3ABA9BF2F497C036436F")

    private static final int MAX_USER_ID_LENGTH = BUFFER_LENGTH - INDEX_USER_ID;
}

