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
    private String mNetworkName;
    private WifiP2pDevice mOwner;
    private boolean mIsGroupOwner;
    private List<WifiP2pDevice> mClients = new ArrayList<WifiP2pDevice>();
    private String mPassphrase;
    private String mInterface;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.740 -0400", hash_original_method = "BC18BEC489FA7E8F37CA54A3CD540A78", hash_generated_method = "D3978A9837D03D7B11DDE06D4B93706F")
    @DSModeled(DSC.SAFE)
    public WifiP2pGroup() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.743 -0400", hash_original_method = "67A4D14BE9A5BB5A5FDEDC963A5F293B", hash_generated_method = "AD2B4F5FD23C607B50E1FAFC2C52C3E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiP2pGroup(String supplicantEvent) throws IllegalArgumentException {
        dsTaint.addTaint(supplicantEvent);
        String[] tokens;
        tokens = supplicantEvent.split(" ");
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Malformed supplicant event");
        } //End block
        {
            boolean varE60AF3E6243EE6CE0619645F47C1B622_1493461339 = (tokens[0].startsWith("P2P-GROUP"));
            {
                mInterface = tokens[1];
                mIsGroupOwner = tokens[2].equals("GO");
                {
                    Iterator<String> varD67D8F347A2D26FE6847991011252D61_1899812674 = (tokens).iterator();
                    varD67D8F347A2D26FE6847991011252D61_1899812674.hasNext();
                    String token = varD67D8F347A2D26FE6847991011252D61_1899812674.next();
                    {
                        String[] nameValue;
                        nameValue = token.split("=");
                        {
                            boolean var180444484005155274AD425FA59B7A0F_1842267579 = (nameValue[0].equals("ssid"));
                            {
                                mNetworkName = nameValue[1];
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var6404793CD815A671D7CB477728F4C709_1638614204 = (nameValue[0].equals("passphrase"));
                            {
                                mPassphrase = nameValue[1];
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean varA68BF051D731A2CDC293397AEC0F7DD6_1330580719 = (nameValue[0].equals("go_dev_addr"));
                            {
                                mOwner = new WifiP2pDevice(nameValue[1]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varED019E61DDA09D9AB4B17841FE657010_916778047 = (tokens[0].equals("P2P-INVITATION-RECEIVED"));
                {
                    {
                        Iterator<String> varD67D8F347A2D26FE6847991011252D61_798997718 = (tokens).iterator();
                        varD67D8F347A2D26FE6847991011252D61_798997718.hasNext();
                        String token = varD67D8F347A2D26FE6847991011252D61_798997718.next();
                        {
                            String[] nameValue;
                            nameValue = token.split("=");
                            {
                                boolean varF3FB023D8BCA2AD24AB4361FF353987D_53867688 = (nameValue[0].equals("go_dev_addr"));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.745 -0400", hash_original_method = "5122EA1190FB8645A8F414458A4E6688", hash_generated_method = "1E1E18AFAB799F3667747F20797813D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiP2pGroup(WifiP2pGroup source) {
        dsTaint.addTaint(source.dsTaint);
        {
            mNetworkName = source.getNetworkName();
            mOwner = new WifiP2pDevice(source.getOwner());
            mIsGroupOwner = source.mIsGroupOwner;
            {
                Iterator<WifiP2pDevice> varB2FBC232D1EF52489CB3D402479F0983_519943736 = (source.getClientList()).iterator();
                varB2FBC232D1EF52489CB3D402479F0983_519943736.hasNext();
                WifiP2pDevice d = varB2FBC232D1EF52489CB3D402479F0983_519943736.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.745 -0400", hash_original_method = "1F3206015C0D7A4CBD5E705EF1C23A0F", hash_generated_method = "558BC55E5675075A42F9560BC890116F")
    @DSModeled(DSC.SAFE)
    public void setNetworkName(String networkName) {
        dsTaint.addTaint(networkName);
        // ---------- Original Method ----------
        //mNetworkName = networkName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.745 -0400", hash_original_method = "32FF89F2A0087E1C62BF10B34EF6D932", hash_generated_method = "555B21F83CF1F31999A3D33708D40C03")
    @DSModeled(DSC.SAFE)
    public String getNetworkName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mNetworkName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.746 -0400", hash_original_method = "389E55BA9756949E35517D77609F8AC0", hash_generated_method = "BE2F7F8D2A72298B1F79CF0EE05EFB8C")
    @DSModeled(DSC.SAFE)
    public void setIsGroupOwner(boolean isGo) {
        dsTaint.addTaint(isGo);
        // ---------- Original Method ----------
        //mIsGroupOwner = isGo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.746 -0400", hash_original_method = "9599D1040188F59722C5FA5110991675", hash_generated_method = "BFBA21EF00F4CC69728687876EBE1778")
    @DSModeled(DSC.SAFE)
    public boolean isGroupOwner() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsGroupOwner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.746 -0400", hash_original_method = "3B8BEB5DE992C10464B29BB370E6A4AC", hash_generated_method = "72DC3F5697C6444C57EE7C749AA28EB1")
    @DSModeled(DSC.SAFE)
    public void setOwner(WifiP2pDevice device) {
        dsTaint.addTaint(device.dsTaint);
        // ---------- Original Method ----------
        //mOwner = device;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.746 -0400", hash_original_method = "64A8053D0F0646F5E4AC8BED59B588ED", hash_generated_method = "94649BFDA40F4D5DE8479757568DEC19")
    @DSModeled(DSC.SAFE)
    public WifiP2pDevice getOwner() {
        return (WifiP2pDevice)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOwner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.747 -0400", hash_original_method = "DBE7A809671EFF433B1C312D5019CC64", hash_generated_method = "469C0DF9D89F3C10EC2177C6490AFD28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addClient(String address) {
        dsTaint.addTaint(address);
        addClient(new WifiP2pDevice(address));
        // ---------- Original Method ----------
        //addClient(new WifiP2pDevice(address));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.750 -0400", hash_original_method = "79E27749F3AC38AE959779DE4B42A054", hash_generated_method = "41A4359D2FE0C95F390B5AE56ADC1F25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addClient(WifiP2pDevice device) {
        dsTaint.addTaint(device.dsTaint);
        {
            Iterator<WifiP2pDevice> var81EFF23692C4D5241A02FF6C3A30FD8F_698823863 = (mClients).iterator();
            var81EFF23692C4D5241A02FF6C3A30FD8F_698823863.hasNext();
            WifiP2pDevice client = var81EFF23692C4D5241A02FF6C3A30FD8F_698823863.next();
            {
                {
                    boolean var76F66E3DA66BBFB2E7A6C0F0677B1C8C_1882259786 = (client.equals(device));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mClients.add(device);
        // ---------- Original Method ----------
        //for (WifiP2pDevice client : mClients) {
            //if (client.equals(device)) return;
        //}
        //mClients.add(device);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.750 -0400", hash_original_method = "1526E375B4DF8BACD06805B33A5DCA8C", hash_generated_method = "B72854B4BF58108A0D10AD9A0EC16470")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeClient(String address) {
        dsTaint.addTaint(address);
        boolean varFFA02D9212F1A0C8E4B9FE17ED759D3A_813362823 = (mClients.remove(new WifiP2pDevice(address)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClients.remove(new WifiP2pDevice(address));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.751 -0400", hash_original_method = "EDE2AC4ED1045F1449D193D9276A4C02", hash_generated_method = "0C1CC79FEE6B9FB3A6BA4C9F2373C665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeClient(WifiP2pDevice device) {
        dsTaint.addTaint(device.dsTaint);
        boolean varB720DEFD70D015574367AFE10D93DD77_1558253618 = (mClients.remove(device));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClients.remove(device);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.751 -0400", hash_original_method = "FBB5E028AB398AA4DEEB45B59F22DD8A", hash_generated_method = "90CE00948F775C4AC4F6EB8C47B22FE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isClientListEmpty() {
        boolean var88B3992BCC908FE1B84965A767B98CC3_1839932808 = (mClients.size() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mClients.size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.751 -0400", hash_original_method = "31A1E7A8626C889DB764B143F0123BF3", hash_generated_method = "68F6BD4A5710993C589856D444EEAE58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<WifiP2pDevice> getClientList() {
        Collection<WifiP2pDevice> var864FFBF036930988ED29ACBED0E10912_1683557534 = (Collections.unmodifiableCollection(mClients));
        return (Collection<WifiP2pDevice>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(mClients);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.752 -0400", hash_original_method = "073EE8049BAF41A715DB20DDA5E00101", hash_generated_method = "94A2E0AF80332EE7D67EC61DEE726E4E")
    @DSModeled(DSC.SAFE)
    public void setPassphrase(String passphrase) {
        dsTaint.addTaint(passphrase);
        // ---------- Original Method ----------
        //mPassphrase = passphrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.752 -0400", hash_original_method = "5EB5F9BABC374AD0DE2453D35DFCC36C", hash_generated_method = "CD7FC71652E1542E127BF6A14A61D7B2")
    @DSModeled(DSC.SAFE)
    public String getPassphrase() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPassphrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.753 -0400", hash_original_method = "1BDFB331CB7F44520C6251E3C44B9A62", hash_generated_method = "15D8C95255064E350F779D7A1A48B80E")
    @DSModeled(DSC.SAFE)
    public void setInterface(String intf) {
        dsTaint.addTaint(intf);
        // ---------- Original Method ----------
        //mInterface = intf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.753 -0400", hash_original_method = "3F43528BD183AE40A353AE75903024B0", hash_generated_method = "FC8696739E85396EE4DCCCBD1F4C580A")
    @DSModeled(DSC.SAFE)
    public String getInterface() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mInterface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.758 -0400", hash_original_method = "D6A6710E4962EEBC5AEB834D1EC25D10", hash_generated_method = "231007693963A84277EDE78F6983C203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuffer sbuf;
        sbuf = new StringBuffer();
        sbuf.append("network: ").append(mNetworkName);
        sbuf.append("\n isGO: ").append(mIsGroupOwner);
        sbuf.append("\n GO: ").append(mOwner);
        {
            Iterator<WifiP2pDevice> var81EFF23692C4D5241A02FF6C3A30FD8F_639280929 = (mClients).iterator();
            var81EFF23692C4D5241A02FF6C3A30FD8F_639280929.hasNext();
            WifiP2pDevice client = var81EFF23692C4D5241A02FF6C3A30FD8F_639280929.next();
            {
                sbuf.append("\n Client: ").append(client);
            } //End block
        } //End collapsed parenthetic
        sbuf.append("\n interface: ").append(mInterface);
        String var0826C75FB1499484A6621049C9E9DB4E_1868282539 = (sbuf.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.758 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.771 -0400", hash_original_method = "1E901056DDD7FF66FB9A75FE788910FD", hash_generated_method = "B2F901029B99F232802879D12C1B5A5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mNetworkName);
        dest.writeParcelable(mOwner, flags);
        dest.writeByte(mIsGroupOwner ? (byte) 1: (byte) 0);
        dest.writeInt(mClients.size());
        {
            Iterator<WifiP2pDevice> var81EFF23692C4D5241A02FF6C3A30FD8F_2036667800 = (mClients).iterator();
            var81EFF23692C4D5241A02FF6C3A30FD8F_2036667800.hasNext();
            WifiP2pDevice client = var81EFF23692C4D5241A02FF6C3A30FD8F_2036667800.next();
            {
                dest.writeParcelable(client, flags);
            } //End block
        } //End collapsed parenthetic
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

    
    public static final Creator<WifiP2pGroup> CREATOR = new Creator<WifiP2pGroup>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.778 -0400", hash_original_method = "6F43542D9464653EF7252A408A904124", hash_generated_method = "7BD42072663FB58CCAAAD070831A7406")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pGroup createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            WifiP2pGroup group;
            group = new WifiP2pGroup();
            group.setNetworkName(in.readString());
            group.setOwner((WifiP2pDevice)in.readParcelable(null));
            group.setIsGroupOwner(in.readByte() == (byte)1);
            int clientCount;
            clientCount = in.readInt();
            {
                int i;
                i = 0;
                {
                    group.addClient((WifiP2pDevice) in.readParcelable(null));
                } //End block
            } //End collapsed parenthetic
            group.setPassphrase(in.readString());
            group.setInterface(in.readString());
            return (WifiP2pGroup)dsTaint.getTaint();
            // ---------- Original Method ----------
            //WifiP2pGroup group = new WifiP2pGroup();
            //group.setNetworkName(in.readString());
            //group.setOwner((WifiP2pDevice)in.readParcelable(null));
            //group.setIsGroupOwner(in.readByte() == (byte)1);
            //int clientCount = in.readInt();
            //for (int i=0; i<clientCount; i++) {
                    //group.addClient((WifiP2pDevice) in.readParcelable(null));
                //}
            //group.setPassphrase(in.readString());
            //group.setInterface(in.readString());
            //return group;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.778 -0400", hash_original_method = "839A08DA63AA08BCC51725CBC0D012F5", hash_generated_method = "A3F4342190A2A1783B0A7D1C75F7B4A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pGroup[] newArray(int size) {
            dsTaint.addTaint(size);
            WifiP2pGroup[] varC7B4E9B4E4662A15813FA48B77B28859_133808944 = (new WifiP2pGroup[size]);
            return (WifiP2pGroup[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WifiP2pGroup[size];
        }

        
}; //Transformed anonymous class
}

