package android.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.util.ArrayList;
import android.net.LocalSocket;
import java.nio.charset.Charsets;
import android.net.LocalSocketAddress;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
public class KeyStore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.820 -0400", hash_original_field = "CD8FAF7D660C7EC82002A0CE6D311A68", hash_generated_field = "9E9CD322B0C625288DCE22FC1B42DF42")

    private int mError = NO_ERROR;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.821 -0400", hash_original_method = "A98AD5AABB81ED93EC08C3EDBDE1D1EA", hash_generated_method = "EB3DBA9370F2FF070F5A58F5F515AAB5")
    private  KeyStore() {
        // ---------- Original Method ----------
    }

    
    public static KeyStore getInstance() {
        return new KeyStore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.824 -0400", hash_original_method = "4DB839F9A62A146E90DB327277824F66", hash_generated_method = "BD90549DB25E418747C16DEC270A6C77")
    public State state() {
execute('t')        switch(mError){
        case NO_ERROR:
State var44379469C11FA6583F346DC70F7F8C22_1189759662 = State.UNLOCKED        var44379469C11FA6583F346DC70F7F8C22_1189759662.addTaint(taint);
        return var44379469C11FA6583F346DC70F7F8C22_1189759662;
        case LOCKED:
State var11FF73C33E436E2ECBF594F9EA2693F8_1949644375 = State.LOCKED        var11FF73C33E436E2ECBF594F9EA2693F8_1949644375.addTaint(taint);
        return var11FF73C33E436E2ECBF594F9EA2693F8_1949644375;
        case UNINITIALIZED:
State var6796A732B1A5E0053E4F1C0E42CE7D16_1184825079 = State.UNINITIALIZED        var6796A732B1A5E0053E4F1C0E42CE7D16_1184825079.addTaint(taint);
        return var6796A732B1A5E0053E4F1C0E42CE7D16_1184825079;
        default:
        AssertionError varAC310590022B6D3478CA82218930413A_461646823 = new AssertionError(mError);
        varAC310590022B6D3478CA82218930413A_461646823.addTaint(taint);
        throw varAC310590022B6D3478CA82218930413A_461646823;
}
        // ---------- Original Method ----------
        //execute('t');
        //switch (mError) {
            //case NO_ERROR: return State.UNLOCKED;
            //case LOCKED: return State.LOCKED;
            //case UNINITIALIZED: return State.UNINITIALIZED;
            //default: throw new AssertionError(mError);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.825 -0400", hash_original_method = "BE5930442BAE920993839309BCA136A6", hash_generated_method = "24E8AA5AC01523FA2AB5D364E6A608FC")
    private byte[] get(byte[] key) {
        addTaint(key[0]);
        ArrayList<byte[]> values = execute('g', key);
        byte[] varCC93DF89DF936F4239A165A9FE48A240_353469817 = ((values==null||values.isEmpty())?null:null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1714289181 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1714289181;
        // ---------- Original Method ----------
        //ArrayList<byte[]> values = execute('g', key);
        //return (values == null || values.isEmpty()) ? null : values.get(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.826 -0400", hash_original_method = "A71F19FF8CC890A9AE637DA54EBF419B", hash_generated_method = "2D2E42E6D5D3B52239289208F55E6374")
    public byte[] get(String key) {
        addTaint(key.getTaint());
        byte[] var6A23CC83F4A7732BF2B81CB4C7AD77E8_1594275019 = (get(getBytes(key)));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1064255628 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1064255628;
        // ---------- Original Method ----------
        //return get(getBytes(key));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.828 -0400", hash_original_method = "9F1D454675EFE0BF8565EE1F8185D4BF", hash_generated_method = "C74CB7F1C4C01C5917610AF1F88ABF9C")
    private boolean put(byte[] key, byte[] value) {
        addTaint(value[0]);
        addTaint(key[0]);
execute('i', key, value)        boolean var030D82016B34284439DD68917C635D6D_1539170855 = (mError==NO_ERROR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1787618474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1787618474;
        // ---------- Original Method ----------
        //execute('i', key, value);
        //return mError == NO_ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.829 -0400", hash_original_method = "7D2E4BF80FEF791FB7652A1CD1DACC01", hash_generated_method = "4EED1A24B7D8A92CC7089E5AF2ACAC9A")
    public boolean put(String key, byte[] value) {
        addTaint(value[0]);
        addTaint(key.getTaint());
        boolean varCF90F1163F2BE90BC8E2849E060C9095_644922287 = (put(getBytes(key), value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483018665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483018665;
        // ---------- Original Method ----------
        //return put(getBytes(key), value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.830 -0400", hash_original_method = "982459A16EECBD95F8F3843E4BE3D0A9", hash_generated_method = "E2A71DA73B675949C54C74B9E7ADE4C8")
    private boolean delete(byte[] key) {
        addTaint(key[0]);
execute('d', key)        boolean var030D82016B34284439DD68917C635D6D_296032076 = (mError==NO_ERROR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939765682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_939765682;
        // ---------- Original Method ----------
        //execute('d', key);
        //return mError == NO_ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.832 -0400", hash_original_method = "340373C67CA26F6333DCEE6305485E62", hash_generated_method = "80A4B25D61AA78B05DA483D3F1EC1FA9")
    public boolean delete(String key) {
        addTaint(key.getTaint());
        boolean var5EAFD2A80B4948663909EFDF4FDC9600_370074138 = (delete(getBytes(key)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1640588719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1640588719;
        // ---------- Original Method ----------
        //return delete(getBytes(key));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.834 -0400", hash_original_method = "38B7B4EAAEEC63F8F37CD676F03CFC59", hash_generated_method = "0E2D6CD51F3ED0902F0473131666588F")
    private boolean contains(byte[] key) {
        addTaint(key[0]);
execute('e', key)        boolean var030D82016B34284439DD68917C635D6D_1374468386 = (mError==NO_ERROR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453204812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453204812;
        // ---------- Original Method ----------
        //execute('e', key);
        //return mError == NO_ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.836 -0400", hash_original_method = "9A851EB87E047F793CE977742A64F221", hash_generated_method = "60030FF793A429E3E38D25AA49248F59")
    public boolean contains(String key) {
        addTaint(key.getTaint());
        boolean varECD54522756C6F2F77250C68E4201D6B_1197813550 = (contains(getBytes(key)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832857535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832857535;
        // ---------- Original Method ----------
        //return contains(getBytes(key));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.837 -0400", hash_original_method = "6736913AC59DB3FD12D3A9AEDF4E116E", hash_generated_method = "19C17975281A6491572DF11DEE32462F")
    public byte[][] saw(byte[] prefix) {
        addTaint(prefix[0]);
        ArrayList<byte[]> values = execute('s', prefix);
        byte[][] var87B3B571FAD58FA7D9F7BDFC9EAA05AF_1899248537 = ((values==null)?null:null);
                byte[][] var09EEFE93BC05FD972F5A60957AA3195B_668958551 = {{getTaintByte()}};
        return var09EEFE93BC05FD972F5A60957AA3195B_668958551;
        // ---------- Original Method ----------
        //ArrayList<byte[]> values = execute('s', prefix);
        //return (values == null) ? null : values.toArray(new byte[values.size()][]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.838 -0400", hash_original_method = "517293415288DFC3CA653399440B56EA", hash_generated_method = "6D9A5CE7448195484957CCB680E0B8E9")
    public String[] saw(String prefix) {
        addTaint(prefix.getTaint());
        byte[][] values = saw(getBytes(prefix));
        if(values==null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_998477435 = null            var540C13E9E156B687226421B24F2DF178_998477435.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_998477435;
        } //End block
        String[] strings = new String[values.length];
for(int i = 0;i<values.length;++i)
        {
strings[i]=toString(values[i])
        } //End block
String[] var2E6885ACC179B2D302813BAD2D696933_55068193 = strings        var2E6885ACC179B2D302813BAD2D696933_55068193.addTaint(taint);
        return var2E6885ACC179B2D302813BAD2D696933_55068193;
        // ---------- Original Method ----------
        //byte[][] values = saw(getBytes(prefix));
        //if (values == null) {
            //return null;
        //}
        //String[] strings = new String[values.length];
        //for (int i = 0; i < values.length; ++i) {
            //strings[i] = toString(values[i]);
        //}
        //return strings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.840 -0400", hash_original_method = "CDF8CE8430C8C648291D8666D8B0FA18", hash_generated_method = "444592C052E09F95B48C44DF43A052A7")
    public boolean reset() {
execute('r')        boolean var030D82016B34284439DD68917C635D6D_937866119 = (mError==NO_ERROR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143058710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143058710;
        // ---------- Original Method ----------
        //execute('r');
        //return mError == NO_ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.841 -0400", hash_original_method = "8B400DE9BA23C213D4D7FA62FE33A793", hash_generated_method = "2E2FA078C0AFC7D36AF6F5263454FAF9")
    private boolean password(byte[] password) {
        addTaint(password[0]);
execute('p', password)        boolean var030D82016B34284439DD68917C635D6D_349916328 = (mError==NO_ERROR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588484201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588484201;
        // ---------- Original Method ----------
        //execute('p', password);
        //return mError == NO_ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.843 -0400", hash_original_method = "AFF582796835333334DBBFF8C78C5134", hash_generated_method = "CCD29E259044FDEDAE62095E58E9695E")
    public boolean password(String password) {
        addTaint(password.getTaint());
        boolean varC56F217DF05521F34F763651BD14F2E5_903487586 = (password(getBytes(password)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829426659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829426659;
        // ---------- Original Method ----------
        //return password(getBytes(password));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.844 -0400", hash_original_method = "1BC3965E73A0B9126E92DE7BDCF2FC00", hash_generated_method = "A11276DACEF3F7A578C4BD9944EE190E")
    public boolean lock() {
execute('l')        boolean var030D82016B34284439DD68917C635D6D_771301224 = (mError==NO_ERROR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400773988 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400773988;
        // ---------- Original Method ----------
        //execute('l');
        //return mError == NO_ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.845 -0400", hash_original_method = "679A2A33FF985DFE4E73B8B95EDB3AA3", hash_generated_method = "A9DA84DA7993F561CF9BE5DD52DB65AB")
    private boolean unlock(byte[] password) {
        addTaint(password[0]);
execute('u', password)        boolean var030D82016B34284439DD68917C635D6D_242848740 = (mError==NO_ERROR);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249043775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249043775;
        // ---------- Original Method ----------
        //execute('u', password);
        //return mError == NO_ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.846 -0400", hash_original_method = "F27C20925BFEDA252D1126B70358B799", hash_generated_method = "6332A97F4B6433C7A154D506780199CE")
    public boolean unlock(String password) {
        addTaint(password.getTaint());
        boolean var1CD1D788945AB504CBDCF8CA39B81286_1403876079 = (unlock(getBytes(password)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388635146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388635146;
        // ---------- Original Method ----------
        //return unlock(getBytes(password));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.873 -0400", hash_original_method = "14AB822DFFDBF81BCBA02A96E529FE4D", hash_generated_method = "1AC9CD0B1BC19F22B4535B42E49060EB")
    public boolean isEmpty() {
execute('z')        boolean var387609FC863EA53C5D955667ED7F6472_1432648429 = (mError==KEY_NOT_FOUND);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555387150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555387150;
        // ---------- Original Method ----------
        //execute('z');
        //return mError == KEY_NOT_FOUND;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.876 -0400", hash_original_method = "0A5C8BB13955BF40FA4E4F287FE07689", hash_generated_method = "E1559E37C93E012713FFAEC42F8C354E")
    public int getLastError() {
        int var6F8A455C94CBB7A00E920835C0C8964C_1049622971 = (mError);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671029016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671029016;
        // ---------- Original Method ----------
        //return mError;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:39.881 -0400", hash_original_method = "DC897701A539E436DD820E86EFB508CC", hash_generated_method = "63A164FEBE3743818277A10AE0A056E8")
    private ArrayList<byte[]> execute(int code, byte[]... parameters) {
        addTaint(parameters[0][0]);
        addTaint(code);
mError=PROTOCOL_ERRORfor(byte[] parameter : parameters)
        {
            if(parameter==null||parameter.length>65535)            
            {
ArrayList<byte[]> var540C13E9E156B687226421B24F2DF178_914351839 = null                var540C13E9E156B687226421B24F2DF178_914351839.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_914351839;
            } //End block
        } //End block
        LocalSocket socket = new LocalSocket();
        try 
        {
socket.connect(sAddress)            OutputStream out = socket.getOutputStream();
out.write(code)for(byte[] parameter : parameters)
            {
out.write(parameter.length>>8)out.write(parameter.length)out.write(parameter)
            } //End block
out.flush()socket.shutdownOutput()            InputStream in = socket.getInputStream();
            if((code=in.read())!=NO_ERROR)            
            {
                if(code!=-1)                
                {
mError=code
                } //End block
ArrayList<byte[]> var540C13E9E156B687226421B24F2DF178_162624742 = null                var540C13E9E156B687226421B24F2DF178_162624742.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_162624742;
            } //End block
            ArrayList<byte[]> values = new ArrayList<byte[]>();
            while
(true)            
            {
                int i;
                int j;
                if((i=in.read())==-1)                
                {
                    break;
                } //End block
                if((j=in.read())==-1)                
                {
ArrayList<byte[]> var540C13E9E156B687226421B24F2DF178_1851554859 = null                    var540C13E9E156B687226421B24F2DF178_1851554859.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1851554859;
                } //End block
                byte[] value = new byte[i << 8 | j];
for(i=0;i<value.length;i+=j)
                {
                    if((j=in.read(value, i, value.length-i))==-1)                    
                    {
ArrayList<byte[]> var540C13E9E156B687226421B24F2DF178_1106657756 = null                        var540C13E9E156B687226421B24F2DF178_1106657756.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1106657756;
                    } //End block
                } //End block
values.add(value)
            } //End block
mError=NO_ERRORArrayList<byte[]> var674B10C763DBAAF9696AD9A3DDAE07B3_1980359158 = values            var674B10C763DBAAF9696AD9A3DDAE07B3_1980359158.addTaint(taint);
            return var674B10C763DBAAF9696AD9A3DDAE07B3_1980359158;
        } //End block
        catch (IOException e)
        {
        } //End block
        finally 
        {
            try 
            {
socket.close()
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
ArrayList<byte[]> var540C13E9E156B687226421B24F2DF178_837533929 = null        var540C13E9E156B687226421B24F2DF178_837533929.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_837533929;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static byte[] getBytes(String string) {
        return string.getBytes(Charsets.UTF_8);
    }

    
    private static String toString(byte[] bytes) {
        return new String(bytes, Charsets.UTF_8);
    }

    
    public enum State { UNLOCKED, LOCKED, UNINITIALIZED }

    

