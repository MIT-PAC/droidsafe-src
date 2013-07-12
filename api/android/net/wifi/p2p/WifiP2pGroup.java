package android.net.wifi.p2p;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class WifiP2pGroup implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.210 -0400", hash_original_field = "C993B689ED947861BE947503C28A4513", hash_generated_field = "2CC664DA8BE6E5F03767811BA72227AE")

    private String mNetworkName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.210 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "C79230C01ABFDB08C1FB6B4E9FE29F22")

    private WifiP2pDevice mOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.210 -0400", hash_original_field = "8424A546848958BC2DFBB7635B0F0F1B", hash_generated_field = "046456A515A3EA867E61CF2C37A5861B")

    private boolean mIsGroupOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.211 -0400", hash_original_field = "D464B2BB51B7E6860F626BF20EE6410A", hash_generated_field = "2084A80652A9E120D7E9DEC5FAD3BB40")

    private List<WifiP2pDevice> mClients = new ArrayList<WifiP2pDevice>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.211 -0400", hash_original_field = "F7D5D8B1B326105DFAF96EA5E2CC1F97", hash_generated_field = "86AD418EF42EB24608144FE3538B1AA2")

    private String mPassphrase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.211 -0400", hash_original_field = "22AC82794E997491870B6B9B34F28FA0", hash_generated_field = "5F89B7D413C8E14947C0E11B080C408D")

    private String mInterface;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.211 -0400", hash_original_method = "BC18BEC489FA7E8F37CA54A3CD540A78", hash_generated_method = "D3978A9837D03D7B11DDE06D4B93706F")
    public  WifiP2pGroup() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.212 -0400", hash_original_method = "67A4D14BE9A5BB5A5FDEDC963A5F293B", hash_generated_method = "44F48BF6CC1B614697FCC6D6830103C2")
    public  WifiP2pGroup(String supplicantEvent) throws IllegalArgumentException {
        addTaint(supplicantEvent.getTaint());
        String[] tokens = supplicantEvent.split(" ");
    if(tokens.length < 3)        
        {
            IllegalArgumentException varC6004F11587813439225B94CE376D336_2080057058 = new IllegalArgumentException("Malformed supplicant event");
            varC6004F11587813439225B94CE376D336_2080057058.addTaint(taint);
            throw varC6004F11587813439225B94CE376D336_2080057058;
        } 
    if(tokens[0].startsWith("P2P-GROUP"))        
        {
            mInterface = tokens[1];
            mIsGroupOwner = tokens[2].equals("GO");
for(String token : tokens)
            {
                String[] nameValue = token.split("=");
    if(nameValue.length != 2)                
                continue;
    if(nameValue[0].equals("ssid"))                
                {
                    mNetworkName = nameValue[1];
                    continue;
                } 
    if(nameValue[0].equals("passphrase"))                
                {
                    mPassphrase = nameValue[1];
                    continue;
                } 
    if(nameValue[0].equals("go_dev_addr"))                
                {
                    mOwner = new WifiP2pDevice(nameValue[1]);
                } 
            } 
        } 
        else
    if(tokens[0].equals("P2P-INVITATION-RECEIVED"))        
        {
for(String token : tokens)
            {
                String[] nameValue = token.split("=");
    if(nameValue.length != 2)                
                continue;
    if(nameValue[0].equals("go_dev_addr"))                
                {
                    mOwner = new WifiP2pDevice(nameValue[1]);
                    continue;
                } 
            } 
        } 
        else
        {
            IllegalArgumentException varC6004F11587813439225B94CE376D336_334699740 = new IllegalArgumentException("Malformed supplicant event");
            varC6004F11587813439225B94CE376D336_334699740.addTaint(taint);
            throw varC6004F11587813439225B94CE376D336_334699740;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.213 -0400", hash_original_method = "5122EA1190FB8645A8F414458A4E6688", hash_generated_method = "D50FF4FF7196E72725EC6D3C8B996F5B")
    public  WifiP2pGroup(WifiP2pGroup source) {
    if(source != null)        
        {
            mNetworkName = source.getNetworkName();
            mOwner = new WifiP2pDevice(source.getOwner());
            mIsGroupOwner = source.mIsGroupOwner;
for(WifiP2pDevice d : source.getClientList())
            mClients.add(d);
            mPassphrase = source.getPassphrase();
            mInterface = source.getInterface();
        } 
        
        
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.214 -0400", hash_original_method = "1F3206015C0D7A4CBD5E705EF1C23A0F", hash_generated_method = "C3736BDA5E3513723EA1A7ADFF8A9E4A")
    public void setNetworkName(String networkName) {
        mNetworkName = networkName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.214 -0400", hash_original_method = "32FF89F2A0087E1C62BF10B34EF6D932", hash_generated_method = "D8B43A74F64EA78DB4AEAAC8FFCF8BD5")
    public String getNetworkName() {
String var2F764F1A91F74BAB946C9D90AE9ACD40_727600789 =         mNetworkName;
        var2F764F1A91F74BAB946C9D90AE9ACD40_727600789.addTaint(taint);
        return var2F764F1A91F74BAB946C9D90AE9ACD40_727600789;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.215 -0400", hash_original_method = "389E55BA9756949E35517D77609F8AC0", hash_generated_method = "1F4E78E48BC1D398DE58B81C55D3C45B")
    public void setIsGroupOwner(boolean isGo) {
        mIsGroupOwner = isGo;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.215 -0400", hash_original_method = "9599D1040188F59722C5FA5110991675", hash_generated_method = "0A100F92C113B2A4BBC13DC92142B46D")
    public boolean isGroupOwner() {
        boolean var8424A546848958BC2DFBB7635B0F0F1B_1419640123 = (mIsGroupOwner);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418267857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418267857;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.215 -0400", hash_original_method = "3B8BEB5DE992C10464B29BB370E6A4AC", hash_generated_method = "D589400B616270F7EEBE396EDAAC71B7")
    public void setOwner(WifiP2pDevice device) {
        mOwner = device;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.216 -0400", hash_original_method = "64A8053D0F0646F5E4AC8BED59B588ED", hash_generated_method = "7C874F5E7C47F09624489EDD463D603C")
    public WifiP2pDevice getOwner() {
WifiP2pDevice var5F2C684ADE383867ABA7E337213B9967_1903258619 =         mOwner;
        var5F2C684ADE383867ABA7E337213B9967_1903258619.addTaint(taint);
        return var5F2C684ADE383867ABA7E337213B9967_1903258619;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.216 -0400", hash_original_method = "DBE7A809671EFF433B1C312D5019CC64", hash_generated_method = "05C15EB6CB5B7D76D8FB922DCA764393")
    public void addClient(String address) {
        addTaint(address.getTaint());
        addClient(new WifiP2pDevice(address));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.216 -0400", hash_original_method = "79E27749F3AC38AE959779DE4B42A054", hash_generated_method = "A6E14D2E4AA901ABB15FC121BD431A5C")
    public void addClient(WifiP2pDevice device) {
        addTaint(device.getTaint());
for(WifiP2pDevice client : mClients)
        {
    if(client.equals(device))            
            return;
        } 
        mClients.add(device);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.217 -0400", hash_original_method = "1526E375B4DF8BACD06805B33A5DCA8C", hash_generated_method = "D024E090839F14EF680D67C02D85622A")
    public boolean removeClient(String address) {
        addTaint(address.getTaint());
        boolean var35B7908A8CEE536DD01D425552F433EF_1165416862 = (mClients.remove(new WifiP2pDevice(address)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_917105439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_917105439;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.217 -0400", hash_original_method = "EDE2AC4ED1045F1449D193D9276A4C02", hash_generated_method = "F03385EAA01FE8380BFFF0F7E9F21D3D")
    public boolean removeClient(WifiP2pDevice device) {
        addTaint(device.getTaint());
        boolean var77877C36C9C4C18E9BE871F33F0372B8_152644900 = (mClients.remove(device));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128760631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128760631;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.217 -0400", hash_original_method = "FBB5E028AB398AA4DEEB45B59F22DD8A", hash_generated_method = "8B7FC9ECA45A3BB7726EF1C82BCF57C8")
    public boolean isClientListEmpty() {
        boolean var37652FDED570C923755D3B11FF970CB3_597619763 = (mClients.size() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2031304531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2031304531;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.217 -0400", hash_original_method = "31A1E7A8626C889DB764B143F0123BF3", hash_generated_method = "7ABBD9EAF8F3F36E217644CD40630D84")
    public Collection<WifiP2pDevice> getClientList() {
Collection<WifiP2pDevice> var56B5579FD7C84BFA68420B5AB0D4DCB4_107851619 =         Collections.unmodifiableCollection(mClients);
        var56B5579FD7C84BFA68420B5AB0D4DCB4_107851619.addTaint(taint);
        return var56B5579FD7C84BFA68420B5AB0D4DCB4_107851619;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.218 -0400", hash_original_method = "073EE8049BAF41A715DB20DDA5E00101", hash_generated_method = "319504402F46E1BA7BFF5B169057CFCB")
    public void setPassphrase(String passphrase) {
        mPassphrase = passphrase;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.218 -0400", hash_original_method = "5EB5F9BABC374AD0DE2453D35DFCC36C", hash_generated_method = "1D788204BEECC3B1305937598DA4F9C3")
    public String getPassphrase() {
String var3390FE1B04D641DF96A7A3765B8B4D50_55747085 =         mPassphrase;
        var3390FE1B04D641DF96A7A3765B8B4D50_55747085.addTaint(taint);
        return var3390FE1B04D641DF96A7A3765B8B4D50_55747085;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.218 -0400", hash_original_method = "1BDFB331CB7F44520C6251E3C44B9A62", hash_generated_method = "29AC9DD1457A812822B9744217D2FCE6")
    public void setInterface(String intf) {
        mInterface = intf;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.219 -0400", hash_original_method = "3F43528BD183AE40A353AE75903024B0", hash_generated_method = "19D6E8ABABAE1B70B242ED18EAFB6CE0")
    public String getInterface() {
String var690AAF4620A1A50EE3302D08CABA94B2_194907995 =         mInterface;
        var690AAF4620A1A50EE3302D08CABA94B2_194907995.addTaint(taint);
        return var690AAF4620A1A50EE3302D08CABA94B2_194907995;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.219 -0400", hash_original_method = "D6A6710E4962EEBC5AEB834D1EC25D10", hash_generated_method = "96E9ED0CF02639CA0A860068B6870A40")
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("network: ").append(mNetworkName);
        sbuf.append("\n isGO: ").append(mIsGroupOwner);
        sbuf.append("\n GO: ").append(mOwner);
for(WifiP2pDevice client : mClients)
        {
            sbuf.append("\n Client: ").append(client);
        } 
        sbuf.append("\n interface: ").append(mInterface);
String var69222FFA45D1268AEE1923C5558B0BD5_136615428 =         sbuf.toString();
        var69222FFA45D1268AEE1923C5558B0BD5_136615428.addTaint(taint);
        return var69222FFA45D1268AEE1923C5558B0BD5_136615428;
        
        
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.219 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BC6920D707AD1CC8B363AB05086CE07C")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_28371149 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051230939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051230939;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.220 -0400", hash_original_method = "1E901056DDD7FF66FB9A75FE788910FD", hash_generated_method = "31B5C3A28B81F70F77D19173D5A432CA")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mNetworkName);
        dest.writeParcelable(mOwner, flags);
        dest.writeByte(mIsGroupOwner ? (byte) 1: (byte) 0);
        dest.writeInt(mClients.size());
for(WifiP2pDevice client : mClients)
        {
            dest.writeParcelable(client, flags);
        } 
        dest.writeString(mPassphrase);
        dest.writeString(mInterface);
        
        
        
        
        
        
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.220 -0400", hash_original_field = "2D4DFD124864C66F2F83797BE326D45F", hash_generated_field = "32E89BB9B9BA18A350DF4B63B27D02B5")

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
    
}

