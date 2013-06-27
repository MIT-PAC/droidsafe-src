package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.940 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "16324C43983326A3B46F3FCABA310E0B")

    private Address mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "B847FB87F2D765E8744246FA662A7189", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

    private String mProxyAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "04A167914207F011BE4077324C66A267", hash_generated_field = "C159D673C6FC052AF1A568408C4DA2F6")

    private String mDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "AEB4FB8FD662481E35470284EEE1AE26", hash_generated_field = "7961D341A30A6551A165752670ACA6FD")

    private String mProtocol = UDP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "3AEB99DBB3365C52C6692CF7388EF478", hash_generated_field = "5D267F5F18DF516348BB55C6412BAD8F")

    private String mProfileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "952FC91B10E7640FE4E3D89C68299E3A", hash_generated_field = "C2C52861D04ADF40D430DD5608696FA5")

    private String mAuthUserName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "C38FAA57BCE3E3E17A91F35F85C20EA7", hash_generated_field = "847F0DE2F4A62F6FE88C7934F99CC9EC")

    private int mPort = DEFAULT_PORT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "51058C8056C8BD658C8FBA0CC161B6E5", hash_generated_field = "C26F5CDD64291FBC6392240557469182")

    private boolean mSendKeepAlive = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "D0AFE5460DE3CC4616869E130622F0B6", hash_generated_field = "D6B09BB0511B0E0F2902F47EA8A42CF8")

    private boolean mAutoRegistration = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.941 -0400", hash_original_field = "0D99B946571E68215F1DADB92F2B42CF", hash_generated_field = "CB9163F150EE50C29DF1E6C445E05158")

    private transient int mCallingUid = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.942 -0400", hash_original_method = "A9E3259F33F9DE91C391F7016F4793EF", hash_generated_method = "F93E0B2FF811F46C0359831D1336A6D7")
    private  SipProfile() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.963 -0400", hash_original_method = "03F00CBB1D1D79A9110C9D3986D03161", hash_generated_method = "208365E4FFF39ADE6BA452905A4F5CFB")
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
        // ---------- Original Method ----------
        //mAddress = (Address) in.readSerializable();
        //mProxyAddress = in.readString();
        //mPassword = in.readString();
        //mDomain = in.readString();
        //mProtocol = in.readString();
        //mProfileName = in.readString();
        //mSendKeepAlive = (in.readInt() == 0) ? false : true;
        //mAutoRegistration = (in.readInt() == 0) ? false : true;
        //mCallingUid = in.readInt();
        //mPort = in.readInt();
        //mAuthUserName = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.965 -0400", hash_original_method = "0F86B1263AA1167A9BA85D0781C26BDD", hash_generated_method = "5D1D71606B6D603B5019FA278AF04028")
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
        // ---------- Original Method ----------
        //out.writeSerializable(mAddress);
        //out.writeString(mProxyAddress);
        //out.writeString(mPassword);
        //out.writeString(mDomain);
        //out.writeString(mProtocol);
        //out.writeString(mProfileName);
        //out.writeInt(mSendKeepAlive ? 1 : 0);
        //out.writeInt(mAutoRegistration ? 1 : 0);
        //out.writeInt(mCallingUid);
        //out.writeInt(mPort);
        //out.writeString(mAuthUserName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.974 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "CF9FD8377E201D01CBFB56045B90C87E")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851833377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851833377;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.975 -0400", hash_original_method = "95F156513507BA474AAADC0CAD04DB56", hash_generated_method = "F77837A0627AC6E9392120659A211188")
    public SipURI getUri() {
        SipURI varB4EAC82CA7396A68D541C85D26508E83_747793070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_747793070 = (SipURI) mAddress.getURI();
        varB4EAC82CA7396A68D541C85D26508E83_747793070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_747793070;
        // ---------- Original Method ----------
        //return (SipURI) mAddress.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.983 -0400", hash_original_method = "8967C0A1855BD4ECE9D4EFBDFCF47E43", hash_generated_method = "50485622E7B4C2F4FD5E0BB549148C0B")
    public String getUriString() {
        String varB4EAC82CA7396A68D541C85D26508E83_743450147 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_480856839 = null; //Variable for return #2
        {
            boolean var517335D4258242B1870AB0217C15F9B0_1356647106 = (!TextUtils.isEmpty(mProxyAddress));
            {
                varB4EAC82CA7396A68D541C85D26508E83_743450147 = "sip:" + getUserName() + "@" + mDomain;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_480856839 = getUri().toString();
        String varA7E53CE21691AB073D9660D615818899_1500758366; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1500758366 = varB4EAC82CA7396A68D541C85D26508E83_743450147;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1500758366 = varB4EAC82CA7396A68D541C85D26508E83_480856839;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1500758366.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1500758366;
        // ---------- Original Method ----------
        //if (!TextUtils.isEmpty(mProxyAddress)) {
            //return "sip:" + getUserName() + "@" + mDomain;
        //}
        //return getUri().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.992 -0400", hash_original_method = "15923319AE2A6D9E076B860EB8423C19", hash_generated_method = "C02B3C8E0E76D4508DD8119451F6CA4E")
    public Address getSipAddress() {
        Address varB4EAC82CA7396A68D541C85D26508E83_311060142 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_311060142 = mAddress;
        varB4EAC82CA7396A68D541C85D26508E83_311060142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_311060142;
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.993 -0400", hash_original_method = "986E0B7E655AC166DA3BC65E473D37F3", hash_generated_method = "4031847C9A2DCA3ABA19883841E33402")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1607815873 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1607815873 = mAddress.getDisplayName();
        varB4EAC82CA7396A68D541C85D26508E83_1607815873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1607815873;
        // ---------- Original Method ----------
        //return mAddress.getDisplayName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.994 -0400", hash_original_method = "5CC4F03701178BF5DF2B7731C175F0C0", hash_generated_method = "83F534CA3A89A4DFE89A7E1B7561377E")
    public String getUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_484116404 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_484116404 = getUri().getUser();
        varB4EAC82CA7396A68D541C85D26508E83_484116404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_484116404;
        // ---------- Original Method ----------
        //return getUri().getUser();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.995 -0400", hash_original_method = "95E3B173DEC08F5D485CDBF035AFC6AC", hash_generated_method = "93608D3C0C18F9125D4A452D2BCD1D84")
    public String getAuthUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_384282357 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_384282357 = mAuthUserName;
        varB4EAC82CA7396A68D541C85D26508E83_384282357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_384282357;
        // ---------- Original Method ----------
        //return mAuthUserName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.996 -0400", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "FE5D7AB85A47002343D54895E3A0FC20")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_940175308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_940175308 = mPassword;
        varB4EAC82CA7396A68D541C85D26508E83_940175308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_940175308;
        // ---------- Original Method ----------
        //return mPassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.013 -0400", hash_original_method = "B8163CA1BE0927DF0B70D99008321B49", hash_generated_method = "50C8BF53870090DCBF5977E323FCE1A4")
    public String getSipDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_14564285 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_14564285 = mDomain;
        varB4EAC82CA7396A68D541C85D26508E83_14564285.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_14564285;
        // ---------- Original Method ----------
        //return mDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.027 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "F836D277CF9F6FE4426A3254909287D0")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900036158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900036158;
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.028 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "C130796873FCA0942C918FF667983494")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_338907010 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_338907010 = mProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_338907010.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_338907010;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.028 -0400", hash_original_method = "3AA5E492CF333F83039FEED9B349A3B0", hash_generated_method = "63E1A37999EA22874C7E9D89DADB1290")
    public String getProxyAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_963350436 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_963350436 = mProxyAddress;
        varB4EAC82CA7396A68D541C85D26508E83_963350436.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_963350436;
        // ---------- Original Method ----------
        //return mProxyAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.035 -0400", hash_original_method = "9B8D5C45DA02E326FD388B2D1055F434", hash_generated_method = "4AE9CC6C52C56DA7F1AD0208A03C9410")
    public String getProfileName() {
        String varB4EAC82CA7396A68D541C85D26508E83_815151809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_815151809 = mProfileName;
        varB4EAC82CA7396A68D541C85D26508E83_815151809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_815151809;
        // ---------- Original Method ----------
        //return mProfileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.036 -0400", hash_original_method = "0FCF61873B0EC3A9D19B7E99B4FC0FAA", hash_generated_method = "8F27B4B1A2F5FB2F940ECE61D400801C")
    public boolean getSendKeepAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411813915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411813915;
        // ---------- Original Method ----------
        //return mSendKeepAlive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.036 -0400", hash_original_method = "BE11F0672CD5463C56A90C5E0BC73CFE", hash_generated_method = "16F7B850FBCB371C4B240A1DD2494BB2")
    public boolean getAutoRegistration() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657539166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657539166;
        // ---------- Original Method ----------
        //return mAutoRegistration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.037 -0400", hash_original_method = "24890DFC4ECCC257FBD9D683C57D0141", hash_generated_method = "0A7C123223C7B04C699C67D459550FF6")
    public void setCallingUid(int uid) {
        mCallingUid = uid;
        // ---------- Original Method ----------
        //mCallingUid = uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.037 -0400", hash_original_method = "1B2206C44B78A8BBFEDFDFC351FB4749", hash_generated_method = "9347AFF61D35EF9EEDD46EDC214CFB0E")
    public int getCallingUid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55699242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_55699242;
        // ---------- Original Method ----------
        //return mCallingUid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.059 -0400", hash_original_method = "0A3380549EECCCE1451002357806ED2B", hash_generated_method = "C1E87E6538CB725DA0DE997EFBA3D508")
    private Object readResolve() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1754395302 = null; //Variable for return #1
        mPort = DEFAULT_PORT;
        varB4EAC82CA7396A68D541C85D26508E83_1754395302 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1754395302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1754395302;
        // ---------- Original Method ----------
        //if (mPort == 0) mPort = DEFAULT_PORT;
        //return this;
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.068 -0400", hash_original_field = "5B949EEB48FDAEA4C4F346D701A2FCAC", hash_generated_field = "D4548AF4DF078E10BA9DDCF8D88614E4")

        private AddressFactory mAddressFactory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.068 -0400", hash_original_field = "BECFB2157198958E2F874EC31716F10A", hash_generated_field = "E8146CB60F48DFE997F29F63657642A2")

        private SipProfile mProfile = new SipProfile();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.068 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "994050EB7C7C334D824C5DF2F52AE95A")

        private SipURI mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.068 -0400", hash_original_field = "978084D14AD2E624AC543B1AA3523D48", hash_generated_field = "E578F409A2A7146A63C54CC9E032AC14")

        private String mDisplayName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.068 -0400", hash_original_field = "B847FB87F2D765E8744246FA662A7189", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

        private String mProxyAddress;
        {
            try {
                mAddressFactory =
                        SipFactory.getInstance().createAddressFactory();
            } catch (PeerUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.088 -0400", hash_original_method = "6381C04E2A4A8813FA59E1834CF9FF37", hash_generated_method = "5E66AA652A3C580637523610AD6222C3")
        public  Builder(SipProfile profile) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            try 
            {
                mProfile = (SipProfile) profile.clone();
            } //End block
            catch (CloneNotSupportedException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("should not occur", e);
            } //End block
            mProfile.mAddress = null;
            mUri = profile.getUri();
            mUri.setUserPassword(profile.getPassword());
            mDisplayName = profile.getDisplayName();
            mProxyAddress = profile.getProxyAddress();
            mProfile.mPort = profile.getPort();
            // ---------- Original Method ----------
            //if (profile == null) throw new NullPointerException();
            //try {
                //mProfile = (SipProfile) profile.clone();
            //} catch (CloneNotSupportedException e) {
                //throw new RuntimeException("should not occur", e);
            //}
            //mProfile.mAddress = null;
            //mUri = profile.getUri();
            //mUri.setUserPassword(profile.getPassword());
            //mDisplayName = profile.getDisplayName();
            //mProxyAddress = profile.getProxyAddress();
            //mProfile.mPort = profile.getPort();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.104 -0400", hash_original_method = "64C9112A2795748CF233F7AC81823050", hash_generated_method = "E7BBD9147662E144EF74764574DC07FB")
        public  Builder(String uriString) throws ParseException {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uriString cannot be null");
            } //End block
            URI uri;
            uri = mAddressFactory.createURI(fix(uriString));
            {
                mUri = (SipURI) uri;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(uriString + " is not a SIP URI", 0);
            } //End block
            mProfile.mDomain = mUri.getHost();
            addTaint(uriString.getTaint());
            // ---------- Original Method ----------
            //if (uriString == null) {
                //throw new NullPointerException("uriString cannot be null");
            //}
            //URI uri = mAddressFactory.createURI(fix(uriString));
            //if (uri instanceof SipURI) {
                //mUri = (SipURI) uri;
            //} else {
                //throw new ParseException(uriString + " is not a SIP URI", 0);
            //}
            //mProfile.mDomain = mUri.getHost();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.106 -0400", hash_original_method = "75E755B13696F99D7736C0DDC72A28FA", hash_generated_method = "2E81BA08A325EB8CC6B80F375C41EFAC")
        public  Builder(String username, String serverDomain) throws ParseException {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                        "username and serverDomain cannot be null");
            } //End block
            mUri = mAddressFactory.createSipURI(username, serverDomain);
            mProfile.mDomain = serverDomain;
            // ---------- Original Method ----------
            //if ((username == null) || (serverDomain == null)) {
                //throw new NullPointerException(
                        //"username and serverDomain cannot be null");
            //}
            //mUri = mAddressFactory.createSipURI(username, serverDomain);
            //mProfile.mDomain = serverDomain;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.106 -0400", hash_original_method = "9B9A6C83AA85ED9069AF543EFC545200", hash_generated_method = "26B4EB7BD8117513F28A4393013F64AF")
        private String fix(String uriString) {
            String varB4EAC82CA7396A68D541C85D26508E83_211205845 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_211205845 = (uriString.trim().toLowerCase().startsWith("sip:")
                    ? uriString
                    : "sip:" + uriString);
            addTaint(uriString.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_211205845.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_211205845;
            // ---------- Original Method ----------
            //return (uriString.trim().toLowerCase().startsWith("sip:")
                    //? uriString
                    //: "sip:" + uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.117 -0400", hash_original_method = "18250D1818A49995026FA15C7D9E3273", hash_generated_method = "CC02CF1B0E16E0DBD7AABAD21EB61A67")
        public Builder setAuthUserName(String name) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_296471636 = null; //Variable for return #1
            mProfile.mAuthUserName = name;
            varB4EAC82CA7396A68D541C85D26508E83_296471636 = this;
            varB4EAC82CA7396A68D541C85D26508E83_296471636.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_296471636;
            // ---------- Original Method ----------
            //mProfile.mAuthUserName = name;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.119 -0400", hash_original_method = "296C55D6980E7D56ABE421835C15F41F", hash_generated_method = "CA6ACE2F24CEDCFC95643EF1DBC604B3")
        public Builder setProfileName(String name) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1683668628 = null; //Variable for return #1
            mProfile.mProfileName = name;
            varB4EAC82CA7396A68D541C85D26508E83_1683668628 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1683668628.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1683668628;
            // ---------- Original Method ----------
            //mProfile.mProfileName = name;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.135 -0400", hash_original_method = "BC6826AF1B9FCC986900D7A0D38FE546", hash_generated_method = "35CB2A58B96080AFFDF084AC9E0411D9")
        public Builder setPassword(String password) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_43217713 = null; //Variable for return #1
            mUri.setUserPassword(password);
            varB4EAC82CA7396A68D541C85D26508E83_43217713 = this;
            addTaint(password.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_43217713.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_43217713;
            // ---------- Original Method ----------
            //mUri.setUserPassword(password);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.136 -0400", hash_original_method = "F3098A99A5C246234AF1DF8489EE5D8A", hash_generated_method = "CFF5D6957557B4ACA1FD2A303842B261")
        public Builder setPort(int port) throws IllegalArgumentException {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1201938217 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("incorrect port arugment: " + port);
            } //End block
            mProfile.mPort = port;
            varB4EAC82CA7396A68D541C85D26508E83_1201938217 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1201938217.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1201938217;
            // ---------- Original Method ----------
            //if ((port > 65535) || (port < 1000)) {
                //throw new IllegalArgumentException("incorrect port arugment: " + port);
            //}
            //mProfile.mPort = port;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.153 -0400", hash_original_method = "3D9493D9C057190A447294828E62D209", hash_generated_method = "AF588B5DE0536AA5EE32BC2D07DDD486")
        public Builder setProtocol(String protocol) throws IllegalArgumentException {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1489866081 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("protocol cannot be null");
            } //End block
            protocol = protocol.toUpperCase();
            {
                boolean var8ABDBE23B05570927D7C85EC139C7CA5_282980469 = (!protocol.equals(UDP) && !protocol.equals(TCP));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "unsupported protocol: " + protocol);
                } //End block
            } //End collapsed parenthetic
            mProfile.mProtocol = protocol;
            varB4EAC82CA7396A68D541C85D26508E83_1489866081 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1489866081.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1489866081;
            // ---------- Original Method ----------
            //if (protocol == null) {
                //throw new NullPointerException("protocol cannot be null");
            //}
            //protocol = protocol.toUpperCase();
            //if (!protocol.equals(UDP) && !protocol.equals(TCP)) {
                //throw new IllegalArgumentException(
                        //"unsupported protocol: " + protocol);
            //}
            //mProfile.mProtocol = protocol;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.163 -0400", hash_original_method = "3904E95A10FA919CA386CED8B9FE2A62", hash_generated_method = "1534FD981038FBE2024E6859A835744A")
        public Builder setOutboundProxy(String outboundProxy) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2008982259 = null; //Variable for return #1
            mProxyAddress = outboundProxy;
            varB4EAC82CA7396A68D541C85D26508E83_2008982259 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2008982259.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2008982259;
            // ---------- Original Method ----------
            //mProxyAddress = outboundProxy;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.165 -0400", hash_original_method = "6E9362DA0DBE9DD97645F0D0015D1E5C", hash_generated_method = "096737EF5ECE819603273277FB16C674")
        public Builder setDisplayName(String displayName) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_227013987 = null; //Variable for return #1
            mDisplayName = displayName;
            varB4EAC82CA7396A68D541C85D26508E83_227013987 = this;
            varB4EAC82CA7396A68D541C85D26508E83_227013987.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_227013987;
            // ---------- Original Method ----------
            //mDisplayName = displayName;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.192 -0400", hash_original_method = "34498E182A6A75F890ADDB0BA3DE0052", hash_generated_method = "4CD9CAFC021C7C978C30F2E0B6DD8D71")
        public Builder setSendKeepAlive(boolean flag) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_456885070 = null; //Variable for return #1
            mProfile.mSendKeepAlive = flag;
            varB4EAC82CA7396A68D541C85D26508E83_456885070 = this;
            varB4EAC82CA7396A68D541C85D26508E83_456885070.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_456885070;
            // ---------- Original Method ----------
            //mProfile.mSendKeepAlive = flag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.194 -0400", hash_original_method = "7257964704D967B57FF3B17ACA4002E0", hash_generated_method = "C42DBDCA304390DCB5C2F06E3AED0D13")
        public Builder setAutoRegistration(boolean flag) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1751009521 = null; //Variable for return #1
            mProfile.mAutoRegistration = flag;
            varB4EAC82CA7396A68D541C85D26508E83_1751009521 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1751009521.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1751009521;
            // ---------- Original Method ----------
            //mProfile.mAutoRegistration = flag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.205 -0400", hash_original_method = "9D6052B0DC59ACBDB83E3EF9051B1CBF", hash_generated_method = "A6EB9AB6A597B817B56712CAB3F8E6D7")
        public SipProfile build() {
            SipProfile varB4EAC82CA7396A68D541C85D26508E83_278207851 = null; //Variable for return #1
            mProfile.mPassword = mUri.getUserPassword();
            mUri.setUserPassword(null);
            try 
            {
                {
                    boolean var77A86CE1E9040E28879A1D4FAC65956D_1965920935 = (!TextUtils.isEmpty(mProxyAddress));
                    {
                        SipURI uri;
                        uri = (SipURI)
                            mAddressFactory.createURI(fix(mProxyAddress));
                        mProfile.mProxyAddress = uri.getHost();
                    } //End block
                    {
                        {
                            boolean varEE92B79E70486E4A2D42217EE70AA432_1088411699 = (!mProfile.mProtocol.equals(UDP));
                            {
                                mUri.setTransportParam(mProfile.mProtocol);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            mUri.setPort(mProfile.mPort);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                mProfile.mAddress = mAddressFactory.createAddress(
                        mDisplayName, mUri);
            } //End block
            catch (InvalidArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
            catch (ParseException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_278207851 = mProfile;
            varB4EAC82CA7396A68D541C85D26508E83_278207851.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_278207851;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.206 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.206 -0400", hash_original_field = "FC189807450A10EA66718E368206AECA", hash_generated_field = "7E7E76F62D517E7FECDE9600045CBD7F")

    private static int DEFAULT_PORT = 5060;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.206 -0400", hash_original_field = "1C3F7B5F24DA057B3D27157300B18123", hash_generated_field = "320F58931B67FF2FF6EF6B49304881E9")

    private static String TCP = "TCP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.206 -0400", hash_original_field = "CEACCB78487D52E4BD97E4CBC4E2FF4E", hash_generated_field = "151DC90C050B32F42BDDB3C85069DDD3")

    private static String UDP = "UDP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:23.206 -0400", hash_original_field = "96AF49225A11A6C54E1496708E970B17", hash_generated_field = "63E93B45CDB4B9E1DB2BDCF0493FAF30")

    public static final Parcelable.Creator<SipProfile> CREATOR =
            new Parcelable.Creator<SipProfile>() {
                public SipProfile createFromParcel(Parcel in) {
                    return new SipProfile(in);
                }

                public SipProfile[] newArray(int size) {
                    return new SipProfile[size];
                }
            };
}

