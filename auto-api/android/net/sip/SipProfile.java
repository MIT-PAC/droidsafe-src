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
    private Address mAddress;
    private String mProxyAddress;
    private String mPassword;
    private String mDomain;
    private String mProtocol = UDP;
    private String mProfileName;
    private String mAuthUserName;
    private int mPort = DEFAULT_PORT;
    private boolean mSendKeepAlive = false;
    private boolean mAutoRegistration = true;
    private transient int mCallingUid = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.374 -0400", hash_original_method = "A9E3259F33F9DE91C391F7016F4793EF", hash_generated_method = "F93E0B2FF811F46C0359831D1336A6D7")
    @DSModeled(DSC.SAFE)
    private SipProfile() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.374 -0400", hash_original_method = "03F00CBB1D1D79A9110C9D3986D03161", hash_generated_method = "E7C3D528F6EAF1E67CA2404ED86ACC38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SipProfile(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.375 -0400", hash_original_method = "0F86B1263AA1167A9BA85D0781C26BDD", hash_generated_method = "1B170295B689A8B261C9E60D19AE23AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.375 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.375 -0400", hash_original_method = "95F156513507BA474AAADC0CAD04DB56", hash_generated_method = "E4858643EB4A371458210F0EEF1F1392")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipURI getUri() {
        SipURI varFEEB29E745068D67D3BC761FA921CD05_1752253688 = ((SipURI) mAddress.getURI());
        return (SipURI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (SipURI) mAddress.getURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.375 -0400", hash_original_method = "8967C0A1855BD4ECE9D4EFBDFCF47E43", hash_generated_method = "6B04A09DEF0154D6EF9A447AFFCF4A02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUriString() {
        {
            boolean var517335D4258242B1870AB0217C15F9B0_893721380 = (!TextUtils.isEmpty(mProxyAddress));
            {
                String var9AD7F532F256B1FF591476336DC0D39A_173207472 = ("sip:" + getUserName() + "@" + mDomain);
            } //End block
        } //End collapsed parenthetic
        String varFE7E616CEE015511762C357634DF41C9_882989614 = (getUri().toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!TextUtils.isEmpty(mProxyAddress)) {
            //return "sip:" + getUserName() + "@" + mDomain;
        //}
        //return getUri().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.376 -0400", hash_original_method = "15923319AE2A6D9E076B860EB8423C19", hash_generated_method = "13E45C6EF4BA2D96E729A181327068B8")
    @DSModeled(DSC.SAFE)
    public Address getSipAddress() {
        return (Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.376 -0400", hash_original_method = "986E0B7E655AC166DA3BC65E473D37F3", hash_generated_method = "16B3E985C852D7BE2D055C5802A9731D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName() {
        String var0917CC2DC1E420E3F55FD705B7BAF12D_520775725 = (mAddress.getDisplayName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAddress.getDisplayName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.376 -0400", hash_original_method = "5CC4F03701178BF5DF2B7731C175F0C0", hash_generated_method = "03F9931A2E3161C9556A322A21419518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserName() {
        String varE6FEA30CC0AB227E0894048B85ABDD31_355222069 = (getUri().getUser());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getUri().getUser();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.376 -0400", hash_original_method = "95E3B173DEC08F5D485CDBF035AFC6AC", hash_generated_method = "21138083AF8E3608C88AAD819F537555")
    @DSModeled(DSC.SAFE)
    public String getAuthUserName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAuthUserName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.377 -0400", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "092F0197408C571D7B3FB565A76F602F")
    @DSModeled(DSC.SAFE)
    public String getPassword() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.377 -0400", hash_original_method = "B8163CA1BE0927DF0B70D99008321B49", hash_generated_method = "41F239F564A782EF33034BE98D2934B3")
    @DSModeled(DSC.SAFE)
    public String getSipDomain() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.377 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "989B279AB861DC9FDC85B5020F096FDA")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.377 -0400", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "83BB3D205C9054750B0B417C7DC6C847")
    @DSModeled(DSC.SAFE)
    public String getProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.377 -0400", hash_original_method = "3AA5E492CF333F83039FEED9B349A3B0", hash_generated_method = "4A44EA2D41A9300E052FC37D7612657B")
    @DSModeled(DSC.SAFE)
    public String getProxyAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProxyAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.378 -0400", hash_original_method = "9B8D5C45DA02E326FD388B2D1055F434", hash_generated_method = "8B755A8382A3B0F17BD26A6E5F2AAC87")
    @DSModeled(DSC.SAFE)
    public String getProfileName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProfileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.378 -0400", hash_original_method = "0FCF61873B0EC3A9D19B7E99B4FC0FAA", hash_generated_method = "5687F41578534CC7E1CD6DBC303D8949")
    @DSModeled(DSC.SAFE)
    public boolean getSendKeepAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSendKeepAlive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.378 -0400", hash_original_method = "BE11F0672CD5463C56A90C5E0BC73CFE", hash_generated_method = "2E46600A1F34FD4CCAAAD69E024846C3")
    @DSModeled(DSC.SAFE)
    public boolean getAutoRegistration() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAutoRegistration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.378 -0400", hash_original_method = "24890DFC4ECCC257FBD9D683C57D0141", hash_generated_method = "AE71F3906FCCDAED1388772D0800E6C0")
    @DSModeled(DSC.SAFE)
    public void setCallingUid(int uid) {
        dsTaint.addTaint(uid);
        // ---------- Original Method ----------
        //mCallingUid = uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.378 -0400", hash_original_method = "1B2206C44B78A8BBFEDFDFC351FB4749", hash_generated_method = "247919F38ABAB1558E07B98530756603")
    @DSModeled(DSC.SAFE)
    public int getCallingUid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCallingUid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.379 -0400", hash_original_method = "0A3380549EECCCE1451002357806ED2B", hash_generated_method = "197335907A75D704D9353F2283EC698F")
    @DSModeled(DSC.SAFE)
    private Object readResolve() throws ObjectStreamException {
        mPort = DEFAULT_PORT;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPort == 0) mPort = DEFAULT_PORT;
        //return this;
    }

    
    public static class Builder {
        private AddressFactory mAddressFactory;
        private SipProfile mProfile = new SipProfile();
        private SipURI mUri;
        private String mDisplayName;
        private String mProxyAddress;
        {
            try {
                mAddressFactory =
                        SipFactory.getInstance().createAddressFactory();
            } catch (PeerUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.379 -0400", hash_original_method = "6381C04E2A4A8813FA59E1834CF9FF37", hash_generated_method = "6F69BAD1B8574D68A1DBAF54940D71B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder(SipProfile profile) {
            dsTaint.addTaint(profile.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.380 -0400", hash_original_method = "64C9112A2795748CF233F7AC81823050", hash_generated_method = "EC57C7CBDBD61B5ABA10BB1C00D50F09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder(String uriString) throws ParseException {
            dsTaint.addTaint(uriString);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.380 -0400", hash_original_method = "75E755B13696F99D7736C0DDC72A28FA", hash_generated_method = "C55E02D1CB5EB74B466A32DEC8BD2038")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder(String username, String serverDomain) throws ParseException {
            dsTaint.addTaint(username);
            dsTaint.addTaint(serverDomain);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.381 -0400", hash_original_method = "9B9A6C83AA85ED9069AF543EFC545200", hash_generated_method = "4CF88D173BA730369AD206E6D059226E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private String fix(String uriString) {
            dsTaint.addTaint(uriString);
            String var0F1F32F710114B4EBBA692A237987323_443932411 = ((uriString.trim().toLowerCase().startsWith("sip:")
                    ? uriString
                    : "sip:" + uriString)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return (uriString.trim().toLowerCase().startsWith("sip:")
                    //? uriString
                    //: "sip:" + uriString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.381 -0400", hash_original_method = "18250D1818A49995026FA15C7D9E3273", hash_generated_method = "C35EFA31D08C60B8D3A255F488CC82F6")
        @DSModeled(DSC.SAFE)
        public Builder setAuthUserName(String name) {
            dsTaint.addTaint(name);
            mProfile.mAuthUserName = name;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mProfile.mAuthUserName = name;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.381 -0400", hash_original_method = "296C55D6980E7D56ABE421835C15F41F", hash_generated_method = "D73FA4CB69AA933BF8F55EF2EF3D5BC8")
        @DSModeled(DSC.SAFE)
        public Builder setProfileName(String name) {
            dsTaint.addTaint(name);
            mProfile.mProfileName = name;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mProfile.mProfileName = name;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.381 -0400", hash_original_method = "BC6826AF1B9FCC986900D7A0D38FE546", hash_generated_method = "8A548A575B1749D4AA57B84678AE37A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setPassword(String password) {
            dsTaint.addTaint(password);
            mUri.setUserPassword(password);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mUri.setUserPassword(password);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.382 -0400", hash_original_method = "F3098A99A5C246234AF1DF8489EE5D8A", hash_generated_method = "026442070CF4ACABE4C7B272DC6045D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setPort(int port) throws IllegalArgumentException {
            dsTaint.addTaint(port);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("incorrect port arugment: " + port);
            } //End block
            mProfile.mPort = port;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if ((port > 65535) || (port < 1000)) {
                //throw new IllegalArgumentException("incorrect port arugment: " + port);
            //}
            //mProfile.mPort = port;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.382 -0400", hash_original_method = "3D9493D9C057190A447294828E62D209", hash_generated_method = "1525DC10C9407995B97A94E67C6F650D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setProtocol(String protocol) throws IllegalArgumentException {
            dsTaint.addTaint(protocol);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("protocol cannot be null");
            } //End block
            protocol = protocol.toUpperCase();
            {
                boolean var8ABDBE23B05570927D7C85EC139C7CA5_1868926257 = (!protocol.equals(UDP) && !protocol.equals(TCP));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "unsupported protocol: " + protocol);
                } //End block
            } //End collapsed parenthetic
            mProfile.mProtocol = protocol;
            return (Builder)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.382 -0400", hash_original_method = "3904E95A10FA919CA386CED8B9FE2A62", hash_generated_method = "C9EFB73134F988B3851945FC5F7A0901")
        @DSModeled(DSC.SAFE)
        public Builder setOutboundProxy(String outboundProxy) {
            dsTaint.addTaint(outboundProxy);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mProxyAddress = outboundProxy;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.382 -0400", hash_original_method = "6E9362DA0DBE9DD97645F0D0015D1E5C", hash_generated_method = "465CA9B7638D7540E3C5F54A3041F2A5")
        @DSModeled(DSC.SAFE)
        public Builder setDisplayName(String displayName) {
            dsTaint.addTaint(displayName);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mDisplayName = displayName;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.383 -0400", hash_original_method = "34498E182A6A75F890ADDB0BA3DE0052", hash_generated_method = "D2FE4AE108E96DB29603812A4768D046")
        @DSModeled(DSC.SAFE)
        public Builder setSendKeepAlive(boolean flag) {
            dsTaint.addTaint(flag);
            mProfile.mSendKeepAlive = flag;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mProfile.mSendKeepAlive = flag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.383 -0400", hash_original_method = "7257964704D967B57FF3B17ACA4002E0", hash_generated_method = "CB37B6DE01CF40F718B038F600060C9B")
        @DSModeled(DSC.SAFE)
        public Builder setAutoRegistration(boolean flag) {
            dsTaint.addTaint(flag);
            mProfile.mAutoRegistration = flag;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //mProfile.mAutoRegistration = flag;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.383 -0400", hash_original_method = "9D6052B0DC59ACBDB83E3EF9051B1CBF", hash_generated_method = "9351E198A85CE92BD6E3DA4E2901A847")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SipProfile build() {
            mProfile.mPassword = mUri.getUserPassword();
            mUri.setUserPassword(null);
            try 
            {
                {
                    boolean var77A86CE1E9040E28879A1D4FAC65956D_1108439406 = (!TextUtils.isEmpty(mProxyAddress));
                    {
                        SipURI uri;
                        uri = (SipURI)
                            mAddressFactory.createURI(fix(mProxyAddress));
                        mProfile.mProxyAddress = uri.getHost();
                    } //End block
                    {
                        {
                            boolean varEE92B79E70486E4A2D42217EE70AA432_208178011 = (!mProfile.mProtocol.equals(UDP));
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
            return (SipProfile)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PORT = 5060;
    private static final String TCP = "TCP";
    private static final String UDP = "UDP";
    public static final Parcelable.Creator<SipProfile> CREATOR = new Parcelable.Creator<SipProfile>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.384 -0400", hash_original_method = "346C5D5BBFC524BD8B0628E99AFE02A3", hash_generated_method = "437250ED98E5629F9A9AA8088BCC8FD3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SipProfile createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            SipProfile var4F27DAC6BA2857D7CC9DAD5640BAE424_1001106544 = (new SipProfile(in));
            return (SipProfile)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SipProfile(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.384 -0400", hash_original_method = "9F087A66F1C7235AFC6CAEE634042099", hash_generated_method = "87531090185608F3122730E8653C33F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SipProfile[] newArray(int size) {
            dsTaint.addTaint(size);
            SipProfile[] varC5D292C12CFA3ECA28253F9BCEB442C5_707699145 = (new SipProfile[size]);
            return (SipProfile[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SipProfile[size];
        }

        
}; //Transformed anonymous class
}

