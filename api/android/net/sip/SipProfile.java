package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.404 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "16324C43983326A3B46F3FCABA310E0B")

    private Address mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.404 -0400", hash_original_field = "B847FB87F2D765E8744246FA662A7189", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

    private String mProxyAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.404 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "04A167914207F011BE4077324C66A267", hash_generated_field = "C159D673C6FC052AF1A568408C4DA2F6")

    private String mDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "AEB4FB8FD662481E35470284EEE1AE26", hash_generated_field = "7961D341A30A6551A165752670ACA6FD")

    private String mProtocol = UDP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "3AEB99DBB3365C52C6692CF7388EF478", hash_generated_field = "5D267F5F18DF516348BB55C6412BAD8F")

    private String mProfileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "952FC91B10E7640FE4E3D89C68299E3A", hash_generated_field = "C2C52861D04ADF40D430DD5608696FA5")

    private String mAuthUserName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "C38FAA57BCE3E3E17A91F35F85C20EA7", hash_generated_field = "847F0DE2F4A62F6FE88C7934F99CC9EC")

    private int mPort = DEFAULT_PORT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "51058C8056C8BD658C8FBA0CC161B6E5", hash_generated_field = "C26F5CDD64291FBC6392240557469182")

    private boolean mSendKeepAlive = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "D0AFE5460DE3CC4616869E130622F0B6", hash_generated_field = "D6B09BB0511B0E0F2902F47EA8A42CF8")

    private boolean mAutoRegistration = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.405 -0400", hash_original_field = "0D99B946571E68215F1DADB92F2B42CF", hash_generated_field = "CB9163F150EE50C29DF1E6C445E05158")

    private transient int mCallingUid = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.406 -0400", hash_original_method = "A9E3259F33F9DE91C391F7016F4793EF", hash_generated_method = "F93E0B2FF811F46C0359831D1336A6D7")
    private  SipProfile() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.408 -0400", hash_original_method = "03F00CBB1D1D79A9110C9D3986D03161", hash_generated_method = "208365E4FFF39ADE6BA452905A4F5CFB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.408 -0400", hash_original_method = "0F86B1263AA1167A9BA85D0781C26BDD", hash_generated_method = "891BEF1CDED0A49E8CAAE48C372D1BDC")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.409 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1BF15453C900548612D4FAF0060E2964")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1157105558 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451267725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451267725;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.409 -0400", hash_original_method = "95F156513507BA474AAADC0CAD04DB56", hash_generated_method = "2D9D72CAFF74772C49EB4B7344AB89A7")
    public SipURI getUri() {
SipURI var95FDA4C63539A7F6A3372CE48866EE18_1289940195 =         (SipURI) mAddress.getURI();
        var95FDA4C63539A7F6A3372CE48866EE18_1289940195.addTaint(taint);
        return var95FDA4C63539A7F6A3372CE48866EE18_1289940195;
        // ---------- Original Method ----------
        //return (SipURI) mAddress.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.409 -0400", hash_original_method = "8967C0A1855BD4ECE9D4EFBDFCF47E43", hash_generated_method = "888E7FBBDAF221B2FFA7C42AAAD746FE")
    public String getUriString() {
    if(!TextUtils.isEmpty(mProxyAddress))        
        {
String var9DE07222769F3A8DC62E51FF3F88310D_1476248210 =             "sip:" + getUserName() + "@" + mDomain;
            var9DE07222769F3A8DC62E51FF3F88310D_1476248210.addTaint(taint);
            return var9DE07222769F3A8DC62E51FF3F88310D_1476248210;
        } //End block
String varCD3A2D1DE5E8E77723178044A3636A53_1229253270 =         getUri().toString();
        varCD3A2D1DE5E8E77723178044A3636A53_1229253270.addTaint(taint);
        return varCD3A2D1DE5E8E77723178044A3636A53_1229253270;
        // ---------- Original Method ----------
        //if (!TextUtils.isEmpty(mProxyAddress)) {
            //return "sip:" + getUserName() + "@" + mDomain;
        //}
        //return getUri().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.410 -0400", hash_original_method = "15923319AE2A6D9E076B860EB8423C19", hash_generated_method = "0234C3F6B86512DABB80D9722BCAFDA2")
    public Address getSipAddress() {
Address var86CD3BA5FA0F42F72E695A9A747D1E23_61340737 =         mAddress;
        var86CD3BA5FA0F42F72E695A9A747D1E23_61340737.addTaint(taint);
        return var86CD3BA5FA0F42F72E695A9A747D1E23_61340737;
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.410 -0400", hash_original_method = "986E0B7E655AC166DA3BC65E473D37F3", hash_generated_method = "763F9294F15FC591E86372FA07EF86E1")
    public String getDisplayName() {
String varCA247D4070EBA69E293EDE228C7016A5_1492643892 =         mAddress.getDisplayName();
        varCA247D4070EBA69E293EDE228C7016A5_1492643892.addTaint(taint);
        return varCA247D4070EBA69E293EDE228C7016A5_1492643892;
        // ---------- Original Method ----------
        //return mAddress.getDisplayName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.410 -0400", hash_original_method = "5CC4F03701178BF5DF2B7731C175F0C0", hash_generated_method = "5A6524D515EE742853323E48958564CB")
    public String getUserName() {
String var2DC509A5BDF6D016393D388560037066_1756712119 =         getUri().getUser();
        var2DC509A5BDF6D016393D388560037066_1756712119.addTaint(taint);
        return var2DC509A5BDF6D016393D388560037066_1756712119;
        // ---------- Original Method ----------
        //return getUri().getUser();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.411 -0400", hash_original_method = "95E3B173DEC08F5D485CDBF035AFC6AC", hash_generated_method = "1AA0A21EBFF5E20991064E298F8372D5")
    public String getAuthUserName() {
String varE4D0D348EAEBE6154DBD036FF44ECDF8_1512934922 =         mAuthUserName;
        varE4D0D348EAEBE6154DBD036FF44ECDF8_1512934922.addTaint(taint);
        return varE4D0D348EAEBE6154DBD036FF44ECDF8_1512934922;
        // ---------- Original Method ----------
        //return mAuthUserName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.411 -0400", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "7A97C78D6A516C24C8020BD9E4B0B014")
    public String getPassword() {
String var8A1D2454BCA4BED59D7FC1FA34A5817A_1231238332 =         mPassword;
        var8A1D2454BCA4BED59D7FC1FA34A5817A_1231238332.addTaint(taint);
        return var8A1D2454BCA4BED59D7FC1FA34A5817A_1231238332;
        // ---------- Original Method ----------
        //return mPassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.411 -0400", hash_original_method = "B8163CA1BE0927DF0B70D99008321B49", hash_generated_method = "F0C7EA46578B14401D52903BC54FFAD0")
    public String getSipDomain() {
String var6BADB33CC960D9973D9AC5B303641B09_1028983933 =         mDomain;
        var6BADB33CC960D9973D9AC5B303641B09_1028983933.addTaint(taint);
        return var6BADB33CC960D9973D9AC5B303641B09_1028983933;
        // ---------- Original Method ----------
        //return mDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.411 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "132978EEE2FA7FD3235A6D472F45796C")
    public int getPort() {
        int var5EFA61C4FCA92CA992BE37C2BAF4D350_324694231 = (mPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2423208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2423208;
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.412 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "983BA7826B469A60E4C46B4DDB619CF4")
    public String getProtocol() {
String var08FE45DCAD8E150FAC65A2ED6B7AD1DC_942574035 =         mProtocol;
        var08FE45DCAD8E150FAC65A2ED6B7AD1DC_942574035.addTaint(taint);
        return var08FE45DCAD8E150FAC65A2ED6B7AD1DC_942574035;
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.412 -0400", hash_original_method = "3AA5E492CF333F83039FEED9B349A3B0", hash_generated_method = "2FF85D2819638B65C888D7E1BFC04CC6")
    public String getProxyAddress() {
String var71994BF38EBA4B6E5855187997F89D61_1624624889 =         mProxyAddress;
        var71994BF38EBA4B6E5855187997F89D61_1624624889.addTaint(taint);
        return var71994BF38EBA4B6E5855187997F89D61_1624624889;
        // ---------- Original Method ----------
        //return mProxyAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.412 -0400", hash_original_method = "9B8D5C45DA02E326FD388B2D1055F434", hash_generated_method = "90B2CCBA283B58D6789E29D96FD7FE1E")
    public String getProfileName() {
String varB7B5AF13F9E5284422C310D543CA143D_353148045 =         mProfileName;
        varB7B5AF13F9E5284422C310D543CA143D_353148045.addTaint(taint);
        return varB7B5AF13F9E5284422C310D543CA143D_353148045;
        // ---------- Original Method ----------
        //return mProfileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.413 -0400", hash_original_method = "0FCF61873B0EC3A9D19B7E99B4FC0FAA", hash_generated_method = "5BCD60C5F5B2A6277DF52060430D39E3")
    public boolean getSendKeepAlive() {
        boolean varF0160431F22C3FFD41B239425D8EEF93_990088013 = (mSendKeepAlive);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581883026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_581883026;
        // ---------- Original Method ----------
        //return mSendKeepAlive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.413 -0400", hash_original_method = "BE11F0672CD5463C56A90C5E0BC73CFE", hash_generated_method = "00C2A4A997D22827DD043440C1882C5A")
    public boolean getAutoRegistration() {
        boolean varECAF50927DD72AA36A90869018F857B2_1532907693 = (mAutoRegistration);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68032841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_68032841;
        // ---------- Original Method ----------
        //return mAutoRegistration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.413 -0400", hash_original_method = "24890DFC4ECCC257FBD9D683C57D0141", hash_generated_method = "0A7C123223C7B04C699C67D459550FF6")
    public void setCallingUid(int uid) {
        mCallingUid = uid;
        // ---------- Original Method ----------
        //mCallingUid = uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.414 -0400", hash_original_method = "1B2206C44B78A8BBFEDFDFC351FB4749", hash_generated_method = "EDAAE05D44596E769E7409C93C85E2B1")
    public int getCallingUid() {
        int varADFDCD8DB22A6CFEC4CB8ABED6EFC7FA_1305742879 = (mCallingUid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1841437469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1841437469;
        // ---------- Original Method ----------
        //return mCallingUid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.414 -0400", hash_original_method = "0A3380549EECCCE1451002357806ED2B", hash_generated_method = "05B26E25EBEC7407A4CA35CDF2F74A18")
    private Object readResolve() throws ObjectStreamException {
    if(mPort == 0)        
        mPort = DEFAULT_PORT;
Object var72A74007B2BE62B849F475C7BDA4658B_210256695 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_210256695.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_210256695;
        // ---------- Original Method ----------
        //if (mPort == 0) mPort = DEFAULT_PORT;
        //return this;
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.415 -0400", hash_original_field = "5B949EEB48FDAEA4C4F346D701A2FCAC", hash_generated_field = "D4548AF4DF078E10BA9DDCF8D88614E4")

        private AddressFactory mAddressFactory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.415 -0400", hash_original_field = "BECFB2157198958E2F874EC31716F10A", hash_generated_field = "E8146CB60F48DFE997F29F63657642A2")

        private SipProfile mProfile = new SipProfile();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.415 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "994050EB7C7C334D824C5DF2F52AE95A")

        private SipURI mUri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.415 -0400", hash_original_field = "978084D14AD2E624AC543B1AA3523D48", hash_generated_field = "E578F409A2A7146A63C54CC9E032AC14")

        private String mDisplayName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.415 -0400", hash_original_field = "B847FB87F2D765E8744246FA662A7189", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

        private String mProxyAddress;
        {
            try {
                mAddressFactory =
                        SipFactory.getInstance().createAddressFactory();
            } catch (PeerUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.416 -0400", hash_original_method = "6381C04E2A4A8813FA59E1834CF9FF37", hash_generated_method = "B2DA61753B49AFA683EE2D95A689EC9E")
        public  Builder(SipProfile profile) {
    if(profile == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1909671628 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1909671628.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1909671628;
            }
            try 
            {
                mProfile = (SipProfile) profile.clone();
            } //End block
            catch (CloneNotSupportedException e)
            {
                RuntimeException var28D7841C78CBA67A91C4E61E357B834B_840899866 = new RuntimeException("should not occur", e);
                var28D7841C78CBA67A91C4E61E357B834B_840899866.addTaint(taint);
                throw var28D7841C78CBA67A91C4E61E357B834B_840899866;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.417 -0400", hash_original_method = "64C9112A2795748CF233F7AC81823050", hash_generated_method = "963599661BA34FE53DA259C2AF8AF294")
        public  Builder(String uriString) throws ParseException {
            addTaint(uriString.getTaint());
    if(uriString == null)            
            {
                NullPointerException var72FFAECF6BFC9C09ED038B51411C6AD2_1001316777 = new NullPointerException("uriString cannot be null");
                var72FFAECF6BFC9C09ED038B51411C6AD2_1001316777.addTaint(taint);
                throw var72FFAECF6BFC9C09ED038B51411C6AD2_1001316777;
            } //End block
            URI uri = mAddressFactory.createURI(fix(uriString));
    if(uri instanceof SipURI)            
            {
                mUri = (SipURI) uri;
            } //End block
            else
            {
                ParseException varFE21AC86CC944E69A011BEFCB01269E9_369006609 = new ParseException(uriString + " is not a SIP URI", 0);
                varFE21AC86CC944E69A011BEFCB01269E9_369006609.addTaint(taint);
                throw varFE21AC86CC944E69A011BEFCB01269E9_369006609;
            } //End block
            mProfile.mDomain = mUri.getHost();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.418 -0400", hash_original_method = "75E755B13696F99D7736C0DDC72A28FA", hash_generated_method = "4C43223FCC5CEC896F71F6A8B52CAE4D")
        public  Builder(String username, String serverDomain) throws ParseException {
    if((username == null) || (serverDomain == null))            
            {
                NullPointerException var6AD8FE3BE96395DA1FBA5FF7E623D19C_1797684582 = new NullPointerException(
                        "username and serverDomain cannot be null");
                var6AD8FE3BE96395DA1FBA5FF7E623D19C_1797684582.addTaint(taint);
                throw var6AD8FE3BE96395DA1FBA5FF7E623D19C_1797684582;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.419 -0400", hash_original_method = "9B9A6C83AA85ED9069AF543EFC545200", hash_generated_method = "A35CC06720EBBCB22959E35936439037")
        private String fix(String uriString) {
            addTaint(uriString.getTaint());
String varEE08D80023883C80E1930E2668767591_1417597388 =             (uriString.trim().toLowerCase().startsWith("sip:")
                    ? uriString
                    : "sip:" + uriString);
            varEE08D80023883C80E1930E2668767591_1417597388.addTaint(taint);
            return varEE08D80023883C80E1930E2668767591_1417597388;
            // ---------- Original Method ----------
            //return (uriString.trim().toLowerCase().startsWith("sip:")
                    //? uriString
                    //: "sip:" + uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.419 -0400", hash_original_method = "18250D1818A49995026FA15C7D9E3273", hash_generated_method = "636C05642FE8E996A2792942D545EA05")
        public Builder setAuthUserName(String name) {
            mProfile.mAuthUserName = name;
Builder var72A74007B2BE62B849F475C7BDA4658B_1074235376 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1074235376.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1074235376;
            // ---------- Original Method ----------
            //mProfile.mAuthUserName = name;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.420 -0400", hash_original_method = "296C55D6980E7D56ABE421835C15F41F", hash_generated_method = "CC2BBFAF1FA78DEFF25C050688F1F2DF")
        public Builder setProfileName(String name) {
            mProfile.mProfileName = name;
Builder var72A74007B2BE62B849F475C7BDA4658B_342660946 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_342660946.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_342660946;
            // ---------- Original Method ----------
            //mProfile.mProfileName = name;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.420 -0400", hash_original_method = "BC6826AF1B9FCC986900D7A0D38FE546", hash_generated_method = "F9115BF37E536DD300B6AFBDF4720971")
        public Builder setPassword(String password) {
            addTaint(password.getTaint());
            mUri.setUserPassword(password);
Builder var72A74007B2BE62B849F475C7BDA4658B_110733667 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_110733667.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_110733667;
            // ---------- Original Method ----------
            //mUri.setUserPassword(password);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.420 -0400", hash_original_method = "F3098A99A5C246234AF1DF8489EE5D8A", hash_generated_method = "CCEADF72F5B2B333F59E90A4CE3B81BD")
        public Builder setPort(int port) throws IllegalArgumentException {
    if((port > 65535) || (port < 1000))            
            {
                IllegalArgumentException varB7FBC44021B1F7610A12B2691CAB4C0E_1156795292 = new IllegalArgumentException("incorrect port arugment: " + port);
                varB7FBC44021B1F7610A12B2691CAB4C0E_1156795292.addTaint(taint);
                throw varB7FBC44021B1F7610A12B2691CAB4C0E_1156795292;
            } //End block
            mProfile.mPort = port;
Builder var72A74007B2BE62B849F475C7BDA4658B_150409543 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_150409543.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_150409543;
            // ---------- Original Method ----------
            //if ((port > 65535) || (port < 1000)) {
                //throw new IllegalArgumentException("incorrect port arugment: " + port);
            //}
            //mProfile.mPort = port;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.421 -0400", hash_original_method = "3D9493D9C057190A447294828E62D209", hash_generated_method = "B333F59A8E71C022498C77E504261C4F")
        public Builder setProtocol(String protocol) throws IllegalArgumentException {
    if(protocol == null)            
            {
                NullPointerException var1F61BD93F0A39C2344B563FA6556FE6D_988690842 = new NullPointerException("protocol cannot be null");
                var1F61BD93F0A39C2344B563FA6556FE6D_988690842.addTaint(taint);
                throw var1F61BD93F0A39C2344B563FA6556FE6D_988690842;
            } //End block
            protocol = protocol.toUpperCase();
    if(!protocol.equals(UDP) && !protocol.equals(TCP))            
            {
                IllegalArgumentException var5F828D235DB5FC3E9F645EE54715BC69_58501434 = new IllegalArgumentException(
                        "unsupported protocol: " + protocol);
                var5F828D235DB5FC3E9F645EE54715BC69_58501434.addTaint(taint);
                throw var5F828D235DB5FC3E9F645EE54715BC69_58501434;
            } //End block
            mProfile.mProtocol = protocol;
Builder var72A74007B2BE62B849F475C7BDA4658B_196426733 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_196426733.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_196426733;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.422 -0400", hash_original_method = "3904E95A10FA919CA386CED8B9FE2A62", hash_generated_method = "E26B8BE76D13BD2540E21F92DEF56512")
        public Builder setOutboundProxy(String outboundProxy) {
            mProxyAddress = outboundProxy;
Builder var72A74007B2BE62B849F475C7BDA4658B_1566682197 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1566682197.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1566682197;
            // ---------- Original Method ----------
            //mProxyAddress = outboundProxy;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.422 -0400", hash_original_method = "6E9362DA0DBE9DD97645F0D0015D1E5C", hash_generated_method = "1566DAF3B51E5694C03B208644EC4E20")
        public Builder setDisplayName(String displayName) {
            mDisplayName = displayName;
Builder var72A74007B2BE62B849F475C7BDA4658B_1172938951 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1172938951.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1172938951;
            // ---------- Original Method ----------
            //mDisplayName = displayName;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.422 -0400", hash_original_method = "34498E182A6A75F890ADDB0BA3DE0052", hash_generated_method = "58550F86D7F021AF118A655B6D0945D7")
        public Builder setSendKeepAlive(boolean flag) {
            mProfile.mSendKeepAlive = flag;
Builder var72A74007B2BE62B849F475C7BDA4658B_779349850 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_779349850.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_779349850;
            // ---------- Original Method ----------
            //mProfile.mSendKeepAlive = flag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.423 -0400", hash_original_method = "7257964704D967B57FF3B17ACA4002E0", hash_generated_method = "5A9B3E3197362F47E7E6110F9574EC0E")
        public Builder setAutoRegistration(boolean flag) {
            mProfile.mAutoRegistration = flag;
Builder var72A74007B2BE62B849F475C7BDA4658B_378558422 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_378558422.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_378558422;
            // ---------- Original Method ----------
            //mProfile.mAutoRegistration = flag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.424 -0400", hash_original_method = "9D6052B0DC59ACBDB83E3EF9051B1CBF", hash_generated_method = "30CEEE080D2C33FA8D680A8B98DC5707")
        public SipProfile build() {
            mProfile.mPassword = mUri.getUserPassword();
            mUri.setUserPassword(null);
            try 
            {
    if(!TextUtils.isEmpty(mProxyAddress))                
                {
                    SipURI uri = (SipURI)
                            mAddressFactory.createURI(fix(mProxyAddress));
                    mProfile.mProxyAddress = uri.getHost();
                } //End block
                else
                {
    if(!mProfile.mProtocol.equals(UDP))                    
                    {
                        mUri.setTransportParam(mProfile.mProtocol);
                    } //End block
    if(mProfile.mPort != DEFAULT_PORT)                    
                    {
                        mUri.setPort(mProfile.mPort);
                    } //End block
                } //End block
                mProfile.mAddress = mAddressFactory.createAddress(
                        mDisplayName, mUri);
            } //End block
            catch (InvalidArgumentException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_607314864 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_607314864.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_607314864;
            } //End block
            catch (ParseException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1832831400 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_1832831400.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_1832831400;
            } //End block
SipProfile var2628D2F9765045D198E63F41D85B8E30_527975942 =             mProfile;
            var2628D2F9765045D198E63F41D85B8E30_527975942.addTaint(taint);
            return var2628D2F9765045D198E63F41D85B8E30_527975942;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.424 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.424 -0400", hash_original_field = "FC189807450A10EA66718E368206AECA", hash_generated_field = "7CF868A5B59EA9E2FBDEDE15F4AF54B1")

    private static final int DEFAULT_PORT = 5060;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.424 -0400", hash_original_field = "1C3F7B5F24DA057B3D27157300B18123", hash_generated_field = "98CDDA5BDB7392DC2196FB567DCA18FE")

    private static final String TCP = "TCP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.424 -0400", hash_original_field = "CEACCB78487D52E4BD97E4CBC4E2FF4E", hash_generated_field = "F3548A486935FA30E27EBDAFF56F549D")

    private static final String UDP = "UDP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.424 -0400", hash_original_field = "96AF49225A11A6C54E1496708E970B17", hash_generated_field = "63E93B45CDB4B9E1DB2BDCF0493FAF30")

    public static final Parcelable.Creator<SipProfile> CREATOR =
            new Parcelable.Creator<SipProfile>() {
                public SipProfile createFromParcel(Parcel in) {
                    return new SipProfile(in);
                }

                public SipProfile[] newArray(int size) {
                    return new SipProfile[size];
                }
            };
    // orphaned legacy method
    public SipProfile createFromParcel(Parcel in) {
                    return new SipProfile(in);
                }
    
    // orphaned legacy method
    public SipProfile[] newArray(int size) {
                    return new SipProfile[size];
                }
    
}

