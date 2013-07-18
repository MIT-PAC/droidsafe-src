package android.net.wifi.p2p;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WifiP2pGroup implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.693 -0400", hash_original_field = "C993B689ED947861BE947503C28A4513", hash_generated_field = "2CC664DA8BE6E5F03767811BA72227AE")

    private String mNetworkName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.693 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "C79230C01ABFDB08C1FB6B4E9FE29F22")

    private WifiP2pDevice mOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.693 -0400", hash_original_field = "8424A546848958BC2DFBB7635B0F0F1B", hash_generated_field = "046456A515A3EA867E61CF2C37A5861B")

    private boolean mIsGroupOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.693 -0400", hash_original_field = "D464B2BB51B7E6860F626BF20EE6410A", hash_generated_field = "2084A80652A9E120D7E9DEC5FAD3BB40")

    private List<WifiP2pDevice> mClients = new ArrayList<WifiP2pDevice>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.693 -0400", hash_original_field = "F7D5D8B1B326105DFAF96EA5E2CC1F97", hash_generated_field = "86AD418EF42EB24608144FE3538B1AA2")

    private String mPassphrase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.693 -0400", hash_original_field = "22AC82794E997491870B6B9B34F28FA0", hash_generated_field = "5F89B7D413C8E14947C0E11B080C408D")

    private String mInterface;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.693 -0400", hash_original_method = "BC18BEC489FA7E8F37CA54A3CD540A78", hash_generated_method = "D3978A9837D03D7B11DDE06D4B93706F")
    public  WifiP2pGroup() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.694 -0400", hash_original_method = "67A4D14BE9A5BB5A5FDEDC963A5F293B", hash_generated_method = "5128FC29BC6B940968AF44BD64956F0A")
    public  WifiP2pGroup(String supplicantEvent) throws IllegalArgumentException {
        addTaint(supplicantEvent.getTaint());
        String[] tokens = supplicantEvent.split(" ");
        if(tokens.length < 3)        
        {
            IllegalArgumentException varC6004F11587813439225B94CE376D336_1397421357 = new IllegalArgumentException("Malformed supplicant event");
            varC6004F11587813439225B94CE376D336_1397421357.addTaint(taint);
            throw varC6004F11587813439225B94CE376D336_1397421357;
        } //End block
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
                } //End block
                if(nameValue[0].equals("passphrase"))                
                {
                    mPassphrase = nameValue[1];
                    continue;
                } //End block
                if(nameValue[0].equals("go_dev_addr"))                
                {
                    mOwner = new WifiP2pDevice(nameValue[1]);
                } //End block
            } //End block
        } //End block
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
                } //End block
            } //End block
        } //End block
        else
        {
            IllegalArgumentException varC6004F11587813439225B94CE376D336_353744697 = new IllegalArgumentException("Malformed supplicant event");
            varC6004F11587813439225B94CE376D336_353744697.addTaint(taint);
            throw varC6004F11587813439225B94CE376D336_353744697;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.696 -0400", hash_original_method = "5122EA1190FB8645A8F414458A4E6688", hash_generated_method = "D50FF4FF7196E72725EC6D3C8B996F5B")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.696 -0400", hash_original_method = "1F3206015C0D7A4CBD5E705EF1C23A0F", hash_generated_method = "C3736BDA5E3513723EA1A7ADFF8A9E4A")
    public void setNetworkName(String networkName) {
        mNetworkName = networkName;
        // ---------- Original Method ----------
        //mNetworkName = networkName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.696 -0400", hash_original_method = "32FF89F2A0087E1C62BF10B34EF6D932", hash_generated_method = "A8129C561A254D333A3A8E67F3B8DB69")
    public String getNetworkName() {
String var2F764F1A91F74BAB946C9D90AE9ACD40_100611917 =         mNetworkName;
        var2F764F1A91F74BAB946C9D90AE9ACD40_100611917.addTaint(taint);
        return var2F764F1A91F74BAB946C9D90AE9ACD40_100611917;
        // ---------- Original Method ----------
        //return mNetworkName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.696 -0400", hash_original_method = "389E55BA9756949E35517D77609F8AC0", hash_generated_method = "1F4E78E48BC1D398DE58B81C55D3C45B")
    public void setIsGroupOwner(boolean isGo) {
        mIsGroupOwner = isGo;
        // ---------- Original Method ----------
        //mIsGroupOwner = isGo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.697 -0400", hash_original_method = "9599D1040188F59722C5FA5110991675", hash_generated_method = "FD29B639719A2E8CDA5233644CD84874")
    public boolean isGroupOwner() {
        boolean var8424A546848958BC2DFBB7635B0F0F1B_2135767053 = (mIsGroupOwner);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024231270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024231270;
        // ---------- Original Method ----------
        //return mIsGroupOwner;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.697 -0400", hash_original_method = "3B8BEB5DE992C10464B29BB370E6A4AC", hash_generated_method = "D589400B616270F7EEBE396EDAAC71B7")
    public void setOwner(WifiP2pDevice device) {
        mOwner = device;
        // ---------- Original Method ----------
        //mOwner = device;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.697 -0400", hash_original_method = "64A8053D0F0646F5E4AC8BED59B588ED", hash_generated_method = "F161105F9BA62855AD144B036AFDD322")
    public WifiP2pDevice getOwner() {
WifiP2pDevice var5F2C684ADE383867ABA7E337213B9967_1635008066 =         mOwner;
        var5F2C684ADE383867ABA7E337213B9967_1635008066.addTaint(taint);
        return var5F2C684ADE383867ABA7E337213B9967_1635008066;
        // ---------- Original Method ----------
        //return mOwner;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.697 -0400", hash_original_method = "DBE7A809671EFF433B1C312D5019CC64", hash_generated_method = "05C15EB6CB5B7D76D8FB922DCA764393")
    public void addClient(String address) {
        addTaint(address.getTaint());
        addClient(new WifiP2pDevice(address));
        // ---------- Original Method ----------
        //addClient(new WifiP2pDevice(address));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.697 -0400", hash_original_method = "79E27749F3AC38AE959779DE4B42A054", hash_generated_method = "A6E14D2E4AA901ABB15FC121BD431A5C")
    public void addClient(WifiP2pDevice device) {
        addTaint(device.getTaint());
for(WifiP2pDevice client : mClients)
        {
            if(client.equals(device))            
            return;
        } //End block
        mClients.add(device);
        // ---------- Original Method ----------
        //for (WifiP2pDevice client : mClients) {
            //if (client.equals(device)) return;
        //}
        //mClients.add(device);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.697 -0400", hash_original_method = "1526E375B4DF8BACD06805B33A5DCA8C", hash_generated_method = "C70C09572F6EBB51E5B99BC239DF9B83")
    public boolean removeClient(String address) {
        addTaint(address.getTaint());
        boolean var35B7908A8CEE536DD01D425552F433EF_803084588 = (mClients.remove(new WifiP2pDevice(address)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747472404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747472404;
        // ---------- Original Method ----------
        //return mClients.remove(new WifiP2pDevice(address));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.697 -0400", hash_original_method = "EDE2AC4ED1045F1449D193D9276A4C02", hash_generated_method = "08C4EBCFEE3CD3FD0DE84AB46C1D6EF7")
    public boolean removeClient(WifiP2pDevice device) {
        addTaint(device.getTaint());
        boolean var77877C36C9C4C18E9BE871F33F0372B8_1228884169 = (mClients.remove(device));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610707383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610707383;
        // ---------- Original Method ----------
        //return mClients.remove(device);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.698 -0400", hash_original_method = "FBB5E028AB398AA4DEEB45B59F22DD8A", hash_generated_method = "C85B126657F11EA244C0C2C26B1D1C41")
    public boolean isClientListEmpty() {
        boolean var37652FDED570C923755D3B11FF970CB3_1806588293 = (mClients.size() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376054594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_376054594;
        // ---------- Original Method ----------
        //return mClients.size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.698 -0400", hash_original_method = "31A1E7A8626C889DB764B143F0123BF3", hash_generated_method = "C1B8A5B37DA0EA72F37F58ACF9F95AE5")
    public Collection<WifiP2pDevice> getClientList() {
Collection<WifiP2pDevice> var56B5579FD7C84BFA68420B5AB0D4DCB4_1434655585 =         Collections.unmodifiableCollection(mClients);
        var56B5579FD7C84BFA68420B5AB0D4DCB4_1434655585.addTaint(taint);
        return var56B5579FD7C84BFA68420B5AB0D4DCB4_1434655585;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mClients);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.698 -0400", hash_original_method = "073EE8049BAF41A715DB20DDA5E00101", hash_generated_method = "319504402F46E1BA7BFF5B169057CFCB")
    public void setPassphrase(String passphrase) {
        mPassphrase = passphrase;
        // ---------- Original Method ----------
        //mPassphrase = passphrase;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.698 -0400", hash_original_method = "5EB5F9BABC374AD0DE2453D35DFCC36C", hash_generated_method = "B3A3E1E4DD2C3511A65CFCC0C67EB3BD")
    public String getPassphrase() {
String var3390FE1B04D641DF96A7A3765B8B4D50_1834191180 =         mPassphrase;
        var3390FE1B04D641DF96A7A3765B8B4D50_1834191180.addTaint(taint);
        return var3390FE1B04D641DF96A7A3765B8B4D50_1834191180;
        // ---------- Original Method ----------
        //return mPassphrase;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.698 -0400", hash_original_method = "1BDFB331CB7F44520C6251E3C44B9A62", hash_generated_method = "29AC9DD1457A812822B9744217D2FCE6")
    public void setInterface(String intf) {
        mInterface = intf;
        // ---------- Original Method ----------
        //mInterface = intf;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.699 -0400", hash_original_method = "3F43528BD183AE40A353AE75903024B0", hash_generated_method = "BFF72D4355EEB5084582D950AD656AB9")
    public String getInterface() {
String var690AAF4620A1A50EE3302D08CABA94B2_248265892 =         mInterface;
        var690AAF4620A1A50EE3302D08CABA94B2_248265892.addTaint(taint);
        return var690AAF4620A1A50EE3302D08CABA94B2_248265892;
        // ---------- Original Method ----------
        //return mInterface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.699 -0400", hash_original_method = "D6A6710E4962EEBC5AEB834D1EC25D10", hash_generated_method = "914C0200C13F0EB2B91D744F377817D7")
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("network: ").append(mNetworkName);
        sbuf.append("\n isGO: ").append(mIsGroupOwner);
        sbuf.append("\n GO: ").append(mOwner);
for(WifiP2pDevice client : mClients)
        {
            sbuf.append("\n Client: ").append(client);
        } //End block
        sbuf.append("\n interface: ").append(mInterface);
String var69222FFA45D1268AEE1923C5558B0BD5_902670146 =         sbuf.toString();
        var69222FFA45D1268AEE1923C5558B0BD5_902670146.addTaint(taint);
        return var69222FFA45D1268AEE1923C5558B0BD5_902670146;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.700 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "52AF00A116916127C368D56B7DA6D9E1")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_917078327 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918278619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918278619;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.700 -0400", hash_original_method = "1E901056DDD7FF66FB9A75FE788910FD", hash_generated_method = "31B5C3A28B81F70F77D19173D5A432CA")
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
        } //End block
        dest.writeString(mPassphrase);
        dest.writeString(mInterface);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.700 -0400", hash_original_field = "2D4DFD124864C66F2F83797BE326D45F", hash_generated_field = "32E89BB9B9BA18A350DF4B63B27D02B5")

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
    // orphaned legacy method
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
    
    // orphaned legacy method
    public WifiP2pGroup[] newArray(int size) {
                return new WifiP2pGroup[size];
            }
    
}

