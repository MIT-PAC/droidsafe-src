package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;
import javax.sip.ListeningPoint;
import javax.sip.PeerUnavailableException;
import javax.sip.SipFactory;
import javax.sip.address.Address;
import javax.sip.address.AddressFactory;
import javax.sip.address.SipURI;
import javax.sip.address.URI;

public class SipProfile implements Parcelable, Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.118 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "16324C43983326A3B46F3FCABA310E0B")

    private Address mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.118 -0400", hash_original_field = "B847FB87F2D765E8744246FA662A7189", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

    private String mProxyAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.118 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.118 -0400", hash_original_field = "04A167914207F011BE4077324C66A267", hash_generated_field = "C159D673C6FC052AF1A568408C4DA2F6")

    private String mDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.118 -0400", hash_original_field = "AEB4FB8FD662481E35470284EEE1AE26", hash_generated_field = "7961D341A30A6551A165752670ACA6FD")

    private String mProtocol = UDP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.119 -0400", hash_original_field = "3AEB99DBB3365C52C6692CF7388EF478", hash_generated_field = "5D267F5F18DF516348BB55C6412BAD8F")

    private String mProfileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.119 -0400", hash_original_field = "952FC91B10E7640FE4E3D89C68299E3A", hash_generated_field = "C2C52861D04ADF40D430DD5608696FA5")

    private String mAuthUserName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.119 -0400", hash_original_field = "C38FAA57BCE3E3E17A91F35F85C20EA7", hash_generated_field = "847F0DE2F4A62F6FE88C7934F99CC9EC")

    private int mPort = DEFAULT_PORT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.119 -0400", hash_original_field = "51058C8056C8BD658C8FBA0CC161B6E5", hash_generated_field = "C26F5CDD64291FBC6392240557469182")

    private boolean mSendKeepAlive = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.119 -0400", hash_original_field = "D0AFE5460DE3CC4616869E130622F0B6", hash_generated_field = "D6B09BB0511B0E0F2902F47EA8A42CF8")

    private boolean mAutoRegistration = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.119 -0400", hash_original_field = "0D99B946571E68215F1DADB92F2B42CF", hash_generated_field = "CB9163F150EE50C29DF1E6C445E05158")

    private transient int mCallingUid = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.119 -0400", hash_original_method = "A9E3259F33F9DE91C391F7016F4793EF", hash_generated_method = "F93E0B2FF811F46C0359831D1336A6D7")
    private  SipProfile() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.120 -0400", hash_original_method = "03F00CBB1D1D79A9110C9D3986D03161", hash_generated_method = "208365E4FFF39ADE6BA452905A4F5CFB")
    private  SipProfile(Parcel in) {
        mAddress = (Address) in.readSerializable();
        mProxyAddress = in.readString();
        mPassword = in.readString();
        mDomain = in.readString();
        mProtocol = in.readString();
        mProfileName = in.readString();
        mSendKeepAlive = (in.readInt() == 0) ? false : true;
        mAutoRegistration = (in.readInt() == 0) ? false : true;
        mCallingUid = in.readInt();
        mPort = in.readInt();
        mAuthUserName = in.readString();
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.120 -0400", hash_original_method = "0F86B1263AA1167A9BA85D0781C26BDD", hash_generated_method = "5D1D71606B6D603B5019FA278AF04028")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeSerializable(mAddress);
        out.writeString(mProxyAddress);
        out.writeString(mPassword);
        out.writeString(mDomain);
        out.writeString(mProtocol);
        out.writeString(mProfileName);
        out.writeInt(mSendKeepAlive ? 1 : 0);
        out.writeInt(mAutoRegistration ? 1 : 0);
        out.writeInt(mCallingUid);
        out.writeInt(mPort);
        out.writeString(mAuthUserName);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.120 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1F0D40463F58DC161E750DE4824E2D5C")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72081704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72081704;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.121 -0400", hash_original_method = "95F156513507BA474AAADC0CAD04DB56", hash_generated_method = "CE0F18B0265C572DD603CB552ECE0029")
    public SipURI getUri() {
        SipURI varB4EAC82CA7396A68D541C85D26508E83_985350576 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_985350576 = (SipURI) mAddress.getURI();
        varB4EAC82CA7396A68D541C85D26508E83_985350576.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_985350576;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.122 -0400", hash_original_method = "8967C0A1855BD4ECE9D4EFBDFCF47E43", hash_generated_method = "FADAA38FDA67768B1EFD7353ADE7C895")
    public String getUriString() {
        String varB4EAC82CA7396A68D541C85D26508E83_890732765 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2096047747 = null; 
        {
            boolean var517335D4258242B1870AB0217C15F9B0_1370047300 = (!TextUtils.isEmpty(mProxyAddress));
            {
                varB4EAC82CA7396A68D541C85D26508E83_890732765 = "sip:" + getUserName() + "@" + mDomain;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2096047747 = getUri().toString();
        String varA7E53CE21691AB073D9660D615818899_305352710; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_305352710 = varB4EAC82CA7396A68D541C85D26508E83_890732765;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_305352710 = varB4EAC82CA7396A68D541C85D26508E83_2096047747;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_305352710.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_305352710;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.123 -0400", hash_original_method = "15923319AE2A6D9E076B860EB8423C19", hash_generated_method = "224180F65674C6CF8BDBF23E028A59DC")
    public Address getSipAddress() {
        Address varB4EAC82CA7396A68D541C85D26508E83_1314682442 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1314682442 = mAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1314682442.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1314682442;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.123 -0400", hash_original_method = "986E0B7E655AC166DA3BC65E473D37F3", hash_generated_method = "9F852B419D504F3EA0EA43DA26A6C71C")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_171504735 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_171504735 = mAddress.getDisplayName();
        varB4EAC82CA7396A68D541C85D26508E83_171504735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_171504735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.124 -0400", hash_original_method = "5CC4F03701178BF5DF2B7731C175F0C0", hash_generated_method = "335D9A9CF10B5A32E91112E6AD2E4277")
    public String getUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2011134293 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2011134293 = getUri().getUser();
        varB4EAC82CA7396A68D541C85D26508E83_2011134293.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2011134293;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.125 -0400", hash_original_method = "95E3B173DEC08F5D485CDBF035AFC6AC", hash_generated_method = "B3A99E7023D9237C86B4776E8FDC9B2F")
    public String getAuthUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_622337314 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_622337314 = mAuthUserName;
        varB4EAC82CA7396A68D541C85D26508E83_622337314.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_622337314;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.125 -0400", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "3F726842851DE59137BD60C7D98D0D49")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_890576971 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_890576971 = mPassword;
        varB4EAC82CA7396A68D541C85D26508E83_890576971.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_890576971;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.126 -0400", hash_original_method = "B8163CA1BE0927DF0B70D99008321B49", hash_generated_method = "FD4F38F9ACE3C1F402C663CF59269D2E")
    public String getSipDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_958770494 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_958770494 = mDomain;
        varB4EAC82CA7396A68D541C85D26508E83_958770494.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_958770494;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.126 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "155B2EA03094341B03C70A7C6DFEFB86")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108389174 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108389174;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.127 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "C0E4224287A2783BCF3A7E4F37E40E0A")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1732300069 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1732300069 = mProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_1732300069.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1732300069;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.127 -0400", hash_original_method = "3AA5E492CF333F83039FEED9B349A3B0", hash_generated_method = "2795F163D9E63C2BA6DEA2413D988EA7")
    public String getProxyAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_648439619 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_648439619 = mProxyAddress;
        varB4EAC82CA7396A68D541C85D26508E83_648439619.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_648439619;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.127 -0400", hash_original_method = "9B8D5C45DA02E326FD388B2D1055F434", hash_generated_method = "67A76036AC45F4FE9D2063D790598A5C")
    public String getProfileName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1231878443 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1231878443 = mProfileName;
        varB4EAC82CA7396A68D541C85D26508E83_1231878443.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1231878443;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.128 -0400", hash_original_method = "0FCF61873B0EC3A9D19B7E99B4FC0FAA", hash_generated_method = "1012813C06AE5E6AC44884D117F18650")
    public boolean getSendKeepAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1696636592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1696636592;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.128 -0400", hash_original_method = "BE11F0672CD5463C56A90C5E0BC73CFE", hash_generated_method = "5700190DC480A536356DBAA4FBED96A6")
    public boolean getAutoRegistration() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723279837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723279837;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.128 -0400", hash_original_method = "24890DFC4ECCC257FBD9D683C57D0141", hash_generated_method = "0A7C123223C7B04C699C67D459550FF6")
    public void setCallingUid(int uid) {
        mCallingUid = uid;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.128 -0400", hash_original_method = "1B2206C44B78A8BBFEDFDFC351FB4749", hash_generated_method = "4F9C4F41B082744E66DC982CCC30D47A")
    public int getCallingUid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368288063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368288063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.129 -0400", hash_original_method = "0A3380549EECCCE1451002357806ED2B", hash_generated_method = "E0AACA21A4F78096225C87222E95798A")
    private Object readResolve() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1599043347 = null; 
        mPort = DEFAULT_PORT;
        varB4EAC82CA7396A68D541C85D26508E83_1599043347 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1599043347.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1599043347;
        
        
        
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.129 -0400", hash_original_field = "5B949EEB48FDAEA4C4F346D701A2FCAC", hash_generated_field = "D4548AF4DF078E10BA9DDCF8D88614E4")

        private AddressFactory mAddressFactory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.129 -0400", hash_original_field = "BECFB2157198958E2F874EC31716F10A", hash_generated_field = "E8146CB60F48DFE997F29F63657642A2")

        private SipProfile mProfile = new SipProfile();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.129 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "994050EB7C7C334D824C5DF2F52AE95A")

        private SipURI mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.129 -0400", hash_original_field = "978084D14AD2E624AC543B1AA3523D48", hash_generated_field = "E578F409A2A7146A63C54CC9E032AC14")

        private String mDisplayName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.129 -0400", hash_original_field = "B847FB87F2D765E8744246FA662A7189", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

        private String mProxyAddress;
        {
            try {
                mAddressFactory =
                        SipFactory.getInstance().createAddressFactory();
            } catch (PeerUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.130 -0400", hash_original_method = "6381C04E2A4A8813FA59E1834CF9FF37", hash_generated_method = "5E66AA652A3C580637523610AD6222C3")
        public  Builder(SipProfile profile) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            try 
            {
                mProfile = (SipProfile) profile.clone();
            } 
            catch (CloneNotSupportedException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("should not occur", e);
            } 
            mProfile.mAddress = null;
            mUri = profile.getUri();
            mUri.setUserPassword(profile.getPassword());
            mDisplayName = profile.getDisplayName();
            mProxyAddress = profile.getProxyAddress();
            mProfile.mPort = profile.getPort();
            
            
            
                
            
                
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.130 -0400", hash_original_method = "64C9112A2795748CF233F7AC81823050", hash_generated_method = "8BF16058B387CF0082DA64FA574EF313")
        public  Builder(String uriString) throws ParseException {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uriString cannot be null");
            } 
            URI uri = mAddressFactory.createURI(fix(uriString));
            {
                mUri = (SipURI) uri;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(uriString + " is not a SIP URI", 0);
            } 
            mProfile.mDomain = mUri.getHost();
            addTaint(uriString.getTaint());
            
            
                
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.130 -0400", hash_original_method = "75E755B13696F99D7736C0DDC72A28FA", hash_generated_method = "2E81BA08A325EB8CC6B80F375C41EFAC")
        public  Builder(String username, String serverDomain) throws ParseException {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                        "username and serverDomain cannot be null");
            } 
            mUri = mAddressFactory.createSipURI(username, serverDomain);
            mProfile.mDomain = serverDomain;
            
            
                
                        
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.131 -0400", hash_original_method = "9B9A6C83AA85ED9069AF543EFC545200", hash_generated_method = "694456D8EDB40CBBF049241B4EC928EF")
        private String fix(String uriString) {
            String varB4EAC82CA7396A68D541C85D26508E83_402877936 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_402877936 = (uriString.trim().toLowerCase().startsWith("sip:")
                    ? uriString
                    : "sip:" + uriString);
            addTaint(uriString.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_402877936.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_402877936;
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.132 -0400", hash_original_method = "18250D1818A49995026FA15C7D9E3273", hash_generated_method = "FAFDF988EE40168A65C7DEFF7A542BB0")
        public Builder setAuthUserName(String name) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_266806293 = null; 
            mProfile.mAuthUserName = name;
            varB4EAC82CA7396A68D541C85D26508E83_266806293 = this;
            varB4EAC82CA7396A68D541C85D26508E83_266806293.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_266806293;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.133 -0400", hash_original_method = "296C55D6980E7D56ABE421835C15F41F", hash_generated_method = "5DCE0116299C46CB97FED0AC241360C8")
        public Builder setProfileName(String name) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1248239675 = null; 
            mProfile.mProfileName = name;
            varB4EAC82CA7396A68D541C85D26508E83_1248239675 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1248239675.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1248239675;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.135 -0400", hash_original_method = "BC6826AF1B9FCC986900D7A0D38FE546", hash_generated_method = "1C6FE5512B2F0FCC65542C007EFA492D")
        public Builder setPassword(String password) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1740155729 = null; 
            mUri.setUserPassword(password);
            varB4EAC82CA7396A68D541C85D26508E83_1740155729 = this;
            addTaint(password.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1740155729.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1740155729;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.137 -0400", hash_original_method = "F3098A99A5C246234AF1DF8489EE5D8A", hash_generated_method = "3E9EBBDBDACEDBBA7A8A26A22A497254")
        public Builder setPort(int port) throws IllegalArgumentException {
            Builder varB4EAC82CA7396A68D541C85D26508E83_124370252 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("incorrect port arugment: " + port);
            } 
            mProfile.mPort = port;
            varB4EAC82CA7396A68D541C85D26508E83_124370252 = this;
            varB4EAC82CA7396A68D541C85D26508E83_124370252.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_124370252;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.138 -0400", hash_original_method = "3D9493D9C057190A447294828E62D209", hash_generated_method = "9F77AA87F37FD9C246C283A4E7155C09")
        public Builder setProtocol(String protocol) throws IllegalArgumentException {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1478333639 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("protocol cannot be null");
            } 
            protocol = protocol.toUpperCase();
            {
                boolean var8ABDBE23B05570927D7C85EC139C7CA5_576696006 = (!protocol.equals(UDP) && !protocol.equals(TCP));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "unsupported protocol: " + protocol);
                } 
            } 
            mProfile.mProtocol = protocol;
            varB4EAC82CA7396A68D541C85D26508E83_1478333639 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1478333639.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1478333639;
            
            
                
            
            
            
                
                        
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.139 -0400", hash_original_method = "3904E95A10FA919CA386CED8B9FE2A62", hash_generated_method = "9635B54CD40AB4C56B4C1281959B8400")
        public Builder setOutboundProxy(String outboundProxy) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1506155703 = null; 
            mProxyAddress = outboundProxy;
            varB4EAC82CA7396A68D541C85D26508E83_1506155703 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1506155703.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1506155703;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.140 -0400", hash_original_method = "6E9362DA0DBE9DD97645F0D0015D1E5C", hash_generated_method = "C608568AE04EA866E218C55FCC35AE9A")
        public Builder setDisplayName(String displayName) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_664780008 = null; 
            mDisplayName = displayName;
            varB4EAC82CA7396A68D541C85D26508E83_664780008 = this;
            varB4EAC82CA7396A68D541C85D26508E83_664780008.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_664780008;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.141 -0400", hash_original_method = "34498E182A6A75F890ADDB0BA3DE0052", hash_generated_method = "56C612B71C2F77BCAEFBC665EB85D38C")
        public Builder setSendKeepAlive(boolean flag) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1061809229 = null; 
            mProfile.mSendKeepAlive = flag;
            varB4EAC82CA7396A68D541C85D26508E83_1061809229 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1061809229.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1061809229;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.142 -0400", hash_original_method = "7257964704D967B57FF3B17ACA4002E0", hash_generated_method = "0FD0510A47D745275C23F60D92462CDF")
        public Builder setAutoRegistration(boolean flag) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1710155298 = null; 
            mProfile.mAutoRegistration = flag;
            varB4EAC82CA7396A68D541C85D26508E83_1710155298 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1710155298.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1710155298;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.143 -0400", hash_original_method = "9D6052B0DC59ACBDB83E3EF9051B1CBF", hash_generated_method = "6FFF31A84B75C740482D4CDE94BE3B7B")
        public SipProfile build() {
            SipProfile varB4EAC82CA7396A68D541C85D26508E83_695975726 = null; 
            mProfile.mPassword = mUri.getUserPassword();
            mUri.setUserPassword(null);
            try 
            {
                {
                    boolean var77A86CE1E9040E28879A1D4FAC65956D_2040734536 = (!TextUtils.isEmpty(mProxyAddress));
                    {
                        SipURI uri = (SipURI)
                            mAddressFactory.createURI(fix(mProxyAddress));
                        mProfile.mProxyAddress = uri.getHost();
                    } 
                    {
                        {
                            boolean varEE92B79E70486E4A2D42217EE70AA432_937151520 = (!mProfile.mProtocol.equals(UDP));
                            {
                                mUri.setTransportParam(mProfile.mProtocol);
                            } 
                        } 
                        {
                            mUri.setPort(mProfile.mPort);
                        } 
                    } 
                } 
                mProfile.mAddress = mAddressFactory.createAddress(
                        mDisplayName, mUri);
            } 
            catch (InvalidArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } 
            catch (ParseException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_695975726 = mProfile;
            varB4EAC82CA7396A68D541C85D26508E83_695975726.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_695975726;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.144 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.144 -0400", hash_original_field = "FC189807450A10EA66718E368206AECA", hash_generated_field = "7CF868A5B59EA9E2FBDEDE15F4AF54B1")

    private static final int DEFAULT_PORT = 5060;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.144 -0400", hash_original_field = "1C3F7B5F24DA057B3D27157300B18123", hash_generated_field = "98CDDA5BDB7392DC2196FB567DCA18FE")

    private static final String TCP = "TCP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.144 -0400", hash_original_field = "CEACCB78487D52E4BD97E4CBC4E2FF4E", hash_generated_field = "F3548A486935FA30E27EBDAFF56F549D")

    private static final String UDP = "UDP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:40.144 -0400", hash_original_field = "96AF49225A11A6C54E1496708E970B17", hash_generated_field = "63E93B45CDB4B9E1DB2BDCF0493FAF30")

    public static final Parcelable.Creator<SipProfile> CREATOR =
            new Parcelable.Creator<SipProfile>() {
                public SipProfile createFromParcel(Parcel in) {
                    return new SipProfile(in);
                }

                public SipProfile[] newArray(int size) {
                    return new SipProfile[size];
                }
            };
    
    public SipProfile createFromParcel(Parcel in) {
                    return new SipProfile(in);
                }
    
    
    public SipProfile[] newArray(int size) {
                    return new SipProfile[size];
                }
    
}

