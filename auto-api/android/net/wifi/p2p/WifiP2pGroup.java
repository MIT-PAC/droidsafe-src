package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class WifiP2pGroup implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.814 -0400", hash_original_field = "C993B689ED947861BE947503C28A4513", hash_generated_field = "2CC664DA8BE6E5F03767811BA72227AE")

    private String mNetworkName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.815 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "C79230C01ABFDB08C1FB6B4E9FE29F22")

    private WifiP2pDevice mOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.815 -0400", hash_original_field = "8424A546848958BC2DFBB7635B0F0F1B", hash_generated_field = "046456A515A3EA867E61CF2C37A5861B")

    private boolean mIsGroupOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.815 -0400", hash_original_field = "D464B2BB51B7E6860F626BF20EE6410A", hash_generated_field = "2084A80652A9E120D7E9DEC5FAD3BB40")

    private List<WifiP2pDevice> mClients = new ArrayList<WifiP2pDevice>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.815 -0400", hash_original_field = "F7D5D8B1B326105DFAF96EA5E2CC1F97", hash_generated_field = "86AD418EF42EB24608144FE3538B1AA2")

    private String mPassphrase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.815 -0400", hash_original_field = "22AC82794E997491870B6B9B34F28FA0", hash_generated_field = "5F89B7D413C8E14947C0E11B080C408D")

    private String mInterface;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.816 -0400", hash_original_method = "BC18BEC489FA7E8F37CA54A3CD540A78", hash_generated_method = "D3978A9837D03D7B11DDE06D4B93706F")
    public  WifiP2pGroup() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.903 -0400", hash_original_method = "67A4D14BE9A5BB5A5FDEDC963A5F293B", hash_generated_method = "850F64EB88D084F7854EFF6D211D83F6")
    public  WifiP2pGroup(String supplicantEvent) throws IllegalArgumentException {
        String[] tokens;
        tokens = supplicantEvent.split(" ");
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Malformed supplicant event");
        } //End block
        {
            boolean varE60AF3E6243EE6CE0619645F47C1B622_623632547 = (tokens[0].startsWith("P2P-GROUP"));
            {
                mInterface = tokens[1];
                mIsGroupOwner = tokens[2].equals("GO");
                {
                    Iterator<String> varD67D8F347A2D26FE6847991011252D61_485382176 = (tokens).iterator();
                    varD67D8F347A2D26FE6847991011252D61_485382176.hasNext();
                    String token = varD67D8F347A2D26FE6847991011252D61_485382176.next();
                    {
                        String[] nameValue;
                        nameValue = token.split("=");
                        {
                            boolean var180444484005155274AD425FA59B7A0F_1806003849 = (nameValue[0].equals("ssid"));
                            {
                                mNetworkName = nameValue[1];
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var6404793CD815A671D7CB477728F4C709_1971845477 = (nameValue[0].equals("passphrase"));
                            {
                                mPassphrase = nameValue[1];
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean varA68BF051D731A2CDC293397AEC0F7DD6_1554790721 = (nameValue[0].equals("go_dev_addr"));
                            {
                                mOwner = new WifiP2pDevice(nameValue[1]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varED019E61DDA09D9AB4B17841FE657010_160704137 = (tokens[0].equals("P2P-INVITATION-RECEIVED"));
                {
                    {
                        Iterator<String> varD67D8F347A2D26FE6847991011252D61_312112417 = (tokens).iterator();
                        varD67D8F347A2D26FE6847991011252D61_312112417.hasNext();
                        String token = varD67D8F347A2D26FE6847991011252D61_312112417.next();
                        {
                            String[] nameValue;
                            nameValue = token.split("=");
                            {
                                boolean varF3FB023D8BCA2AD24AB4361FF353987D_790503011 = (nameValue[0].equals("go_dev_addr"));
                                {
                                    mOwner = new WifiP2pDevice(nameValue[1]);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Malformed supplicant event");
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(supplicantEvent.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.932 -0400", hash_original_method = "5122EA1190FB8645A8F414458A4E6688", hash_generated_method = "EFAD35F50B62B2571BB869CD7BDB5943")
    public  WifiP2pGroup(WifiP2pGroup source) {
        {
            mNetworkName = source.getNetworkName();
            mOwner = new WifiP2pDevice(source.getOwner());
            mIsGroupOwner = source.mIsGroupOwner;
            {
                Iterator<WifiP2pDevice> varB2FBC232D1EF52489CB3D402479F0983_1611368398 = (source.getClientList()).iterator();
                varB2FBC232D1EF52489CB3D402479F0983_1611368398.hasNext();
                WifiP2pDevice d = varB2FBC232D1EF52489CB3D402479F0983_1611368398.next();
                mClients.add(d);
            } //End collapsed parenthetic
            mPassphrase = source.getPassphrase();
            mInterface = source.getInterface();
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mNetworkName = source.getNetworkName();
            //mOwner = new WifiP2pDevice(source.getOwner());
            //mIsGroupOwner = source.mIsGroupOwner;
            //for (WifiP2pDevice d : source.getClientList()) mClients.add(d);
            //mPassphrase = source.getPassphrase();
            //mInterface = source.getInterface();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.933 -0400", hash_original_method = "1F3206015C0D7A4CBD5E705EF1C23A0F", hash_generated_method = "C3736BDA5E3513723EA1A7ADFF8A9E4A")
    public void setNetworkName(String networkName) {
        mNetworkName = networkName;
        // ---------- Original Method ----------
        //mNetworkName = networkName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.933 -0400", hash_original_method = "32FF89F2A0087E1C62BF10B34EF6D932", hash_generated_method = "36DA1260CB21DA0410EA9563F29FF932")
    public String getNetworkName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1073261422 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1073261422 = mNetworkName;
        varB4EAC82CA7396A68D541C85D26508E83_1073261422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1073261422;
        // ---------- Original Method ----------
        //return mNetworkName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.934 -0400", hash_original_method = "389E55BA9756949E35517D77609F8AC0", hash_generated_method = "1F4E78E48BC1D398DE58B81C55D3C45B")
    public void setIsGroupOwner(boolean isGo) {
        mIsGroupOwner = isGo;
        // ---------- Original Method ----------
        //mIsGroupOwner = isGo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.934 -0400", hash_original_method = "9599D1040188F59722C5FA5110991675", hash_generated_method = "12F3BBF2F8F1C2123B75E0512514364A")
    public boolean isGroupOwner() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938467479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_938467479;
        // ---------- Original Method ----------
        //return mIsGroupOwner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.946 -0400", hash_original_method = "3B8BEB5DE992C10464B29BB370E6A4AC", hash_generated_method = "D589400B616270F7EEBE396EDAAC71B7")
    public void setOwner(WifiP2pDevice device) {
        mOwner = device;
        // ---------- Original Method ----------
        //mOwner = device;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.947 -0400", hash_original_method = "64A8053D0F0646F5E4AC8BED59B588ED", hash_generated_method = "02CA913504BB7E0891D19377A46D9EE8")
    public WifiP2pDevice getOwner() {
        WifiP2pDevice varB4EAC82CA7396A68D541C85D26508E83_785894033 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_785894033 = mOwner;
        varB4EAC82CA7396A68D541C85D26508E83_785894033.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_785894033;
        // ---------- Original Method ----------
        //return mOwner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.948 -0400", hash_original_method = "DBE7A809671EFF433B1C312D5019CC64", hash_generated_method = "F34CFC64DF2893C740E6CE9262E85940")
    public void addClient(String address) {
        addClient(new WifiP2pDevice(address));
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //addClient(new WifiP2pDevice(address));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.988 -0400", hash_original_method = "79E27749F3AC38AE959779DE4B42A054", hash_generated_method = "D3B9B0D9603BD591EC78D3050E54E281")
    public void addClient(WifiP2pDevice device) {
        {
            Iterator<WifiP2pDevice> var81EFF23692C4D5241A02FF6C3A30FD8F_1182803378 = (mClients).iterator();
            var81EFF23692C4D5241A02FF6C3A30FD8F_1182803378.hasNext();
            WifiP2pDevice client = var81EFF23692C4D5241A02FF6C3A30FD8F_1182803378.next();
            {
                {
                    boolean var76F66E3DA66BBFB2E7A6C0F0677B1C8C_455431724 = (client.equals(device));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mClients.add(device);
        addTaint(device.getTaint());
        // ---------- Original Method ----------
        //for (WifiP2pDevice client : mClients) {
            //if (client.equals(device)) return;
        //}
        //mClients.add(device);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.989 -0400", hash_original_method = "1526E375B4DF8BACD06805B33A5DCA8C", hash_generated_method = "D00001AB1A1B7F2D83436A757455DF8B")
    public boolean removeClient(String address) {
        boolean varFFA02D9212F1A0C8E4B9FE17ED759D3A_1159600683 = (mClients.remove(new WifiP2pDevice(address)));
        addTaint(address.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1088560370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1088560370;
        // ---------- Original Method ----------
        //return mClients.remove(new WifiP2pDevice(address));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.990 -0400", hash_original_method = "EDE2AC4ED1045F1449D193D9276A4C02", hash_generated_method = "5068A73609109F3382DE0A8768E26582")
    public boolean removeClient(WifiP2pDevice device) {
        boolean varB720DEFD70D015574367AFE10D93DD77_533402200 = (mClients.remove(device));
        addTaint(device.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439053309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439053309;
        // ---------- Original Method ----------
        //return mClients.remove(device);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.991 -0400", hash_original_method = "FBB5E028AB398AA4DEEB45B59F22DD8A", hash_generated_method = "8CEB259612BF887EF9F805F19AE4CD24")
    public boolean isClientListEmpty() {
        boolean var88B3992BCC908FE1B84965A767B98CC3_1290200539 = (mClients.size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039271827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039271827;
        // ---------- Original Method ----------
        //return mClients.size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.997 -0400", hash_original_method = "31A1E7A8626C889DB764B143F0123BF3", hash_generated_method = "FF34059CBD6A7CBB471E5820FE17DDB1")
    public Collection<WifiP2pDevice> getClientList() {
        Collection<WifiP2pDevice> varB4EAC82CA7396A68D541C85D26508E83_155803076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_155803076 = Collections.unmodifiableCollection(mClients);
        varB4EAC82CA7396A68D541C85D26508E83_155803076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_155803076;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mClients);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:25.998 -0400", hash_original_method = "073EE8049BAF41A715DB20DDA5E00101", hash_generated_method = "319504402F46E1BA7BFF5B169057CFCB")
    public void setPassphrase(String passphrase) {
        mPassphrase = passphrase;
        // ---------- Original Method ----------
        //mPassphrase = passphrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.011 -0400", hash_original_method = "5EB5F9BABC374AD0DE2453D35DFCC36C", hash_generated_method = "6E26CAAB3105F33FC37D9D700A9D571E")
    public String getPassphrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_1309653214 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1309653214 = mPassphrase;
        varB4EAC82CA7396A68D541C85D26508E83_1309653214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1309653214;
        // ---------- Original Method ----------
        //return mPassphrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.012 -0400", hash_original_method = "1BDFB331CB7F44520C6251E3C44B9A62", hash_generated_method = "29AC9DD1457A812822B9744217D2FCE6")
    public void setInterface(String intf) {
        mInterface = intf;
        // ---------- Original Method ----------
        //mInterface = intf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.013 -0400", hash_original_method = "3F43528BD183AE40A353AE75903024B0", hash_generated_method = "6355AFBD85625C9C03F0750C575CA2B7")
    public String getInterface() {
        String varB4EAC82CA7396A68D541C85D26508E83_1513191077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1513191077 = mInterface;
        varB4EAC82CA7396A68D541C85D26508E83_1513191077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513191077;
        // ---------- Original Method ----------
        //return mInterface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.080 -0400", hash_original_method = "D6A6710E4962EEBC5AEB834D1EC25D10", hash_generated_method = "79C61A4F32E4C46377F01B2596344296")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2140734240 = null; //Variable for return #1
        StringBuffer sbuf;
        sbuf = new StringBuffer();
        sbuf.append("network: ").append(mNetworkName);
        sbuf.append("\n isGO: ").append(mIsGroupOwner);
        sbuf.append("\n GO: ").append(mOwner);
        {
            Iterator<WifiP2pDevice> var81EFF23692C4D5241A02FF6C3A30FD8F_711515300 = (mClients).iterator();
            var81EFF23692C4D5241A02FF6C3A30FD8F_711515300.hasNext();
            WifiP2pDevice client = var81EFF23692C4D5241A02FF6C3A30FD8F_711515300.next();
            {
                sbuf.append("\n Client: ").append(client);
            } //End block
        } //End collapsed parenthetic
        sbuf.append("\n interface: ").append(mInterface);
        varB4EAC82CA7396A68D541C85D26508E83_2140734240 = sbuf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2140734240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2140734240;
        // ---------- Original Method ----------
        //StringBuffer sbuf = new StringBuffer();
        //sbuf.append("network: ").append(mNetworkName);
        //sbuf.append("\n isGO: ").append(mIsGroupOwner);
        //sbuf.append("\n GO: ").append(mOwner);
        //for (WifiP2pDevice client : mClients) {
            //sbuf.append("\n Client: ").append(client);
        //}
        //sbuf.append("\n interface: ").append(mInterface);
        //return sbuf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.082 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F18026A2CBA3C8EDA4245AE68FAF2D64")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063864846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2063864846;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.143 -0400", hash_original_method = "1E901056DDD7FF66FB9A75FE788910FD", hash_generated_method = "805AEFC20730A686F1F23664DEAB84B1")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mNetworkName);
        dest.writeParcelable(mOwner, flags);
        dest.writeByte(mIsGroupOwner ? (byte) 1: (byte) 0);
        dest.writeInt(mClients.size());
        {
            Iterator<WifiP2pDevice> var81EFF23692C4D5241A02FF6C3A30FD8F_493247180 = (mClients).iterator();
            var81EFF23692C4D5241A02FF6C3A30FD8F_493247180.hasNext();
            WifiP2pDevice client = var81EFF23692C4D5241A02FF6C3A30FD8F_493247180.next();
            {
                dest.writeParcelable(client, flags);
            } //End block
        } //End collapsed parenthetic
        dest.writeString(mPassphrase);
        dest.writeString(mInterface);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(mNetworkName);
        //dest.writeParcelable(mOwner, flags);
        //dest.writeByte(mIsGroupOwner ? (byte) 1: (byte) 0);
        //dest.writeInt(mClients.size());
        //for (WifiP2pDevice client : mClients) {
            //dest.writeParcelable(client, flags);
        //}
        //dest.writeString(mPassphrase);
        //dest.writeString(mInterface);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:26.143 -0400", hash_original_field = "2D4DFD124864C66F2F83797BE326D45F", hash_generated_field = "32E89BB9B9BA18A350DF4B63B27D02B5")

    public static final Creator<WifiP2pGroup> CREATOR =
        new Creator<WifiP2pGroup>() {
            public WifiP2pGroup createFromParcel(Parcel in) {
                WifiP2pGroup group = new WifiP2pGroup();
                group.setNetworkName(in.readString());
                group.setOwner((WifiP2pDevice)in.readParcelable(null));
                group.setIsGroupOwner(in.readByte() == (byte)1);
                int clientCount = in.readInt();
                for (int i=0; i<clientCount; i++) {
                    group.addClient((WifiP2pDevice) in.readParcelable(null));
                }
                group.setPassphrase(in.readString());
                group.setInterface(in.readString());
                return group;
            }

            public WifiP2pGroup[] newArray(int size) {
                return new WifiP2pGroup[size];
            }
        };
}

