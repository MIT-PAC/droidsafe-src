package android.net.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.PeerUnavailableException;
import javax.sip.SipFactory;
import javax.sip.address.Address;
import javax.sip.address.AddressFactory;
import javax.sip.address.SipURI;
import javax.sip.address.URI;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class SipProfile implements Parcelable, Serializable, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.260 -0500", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.263 -0500", hash_original_field = "6ECEAD1F110245340F598FE159B9D6F3", hash_generated_field = "7CF868A5B59EA9E2FBDEDE15F4AF54B1")

    private static final int DEFAULT_PORT = 5060;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.266 -0500", hash_original_field = "063D89290F70014D3E36058AF8C27D65", hash_generated_field = "98CDDA5BDB7392DC2196FB567DCA18FE")

    private static final String TCP = "TCP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.268 -0500", hash_original_field = "AE215C9E2CFD4AA13D6519F6A77B18FB", hash_generated_field = "F3548A486935FA30E27EBDAFF56F549D")

    private static final String UDP = "UDP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:21.651 -0400", hash_original_field = "96AF49225A11A6C54E1496708E970B17", hash_generated_field = "63E93B45CDB4B9E1DB2BDCF0493FAF30")

    public static final Parcelable.Creator<SipProfile> CREATOR =
            new Parcelable.Creator<SipProfile>() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.296 -0500", hash_original_method = "346C5D5BBFC524BD8B0628E99AFE02A3", hash_generated_method = "D5A88E9F58A6ADA2DD90A2D6DBFA06D7")
        
public SipProfile createFromParcel(Parcel in) {
                    return new SipProfile(in);
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.298 -0500", hash_original_method = "9F087A66F1C7235AFC6CAEE634042099", hash_generated_method = "47A83D8A74B2156FE7B837B26AB3385C")
        
public SipProfile[] newArray(int size) {
                    return new SipProfile[size];
                }
            };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.270 -0500", hash_original_field = "BA523996B765265291D5ADCDFABE79B3", hash_generated_field = "16324C43983326A3B46F3FCABA310E0B")

    private Address mAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.272 -0500", hash_original_field = "1E876FD9377BC2388423C0B7D745A482", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

    private String mProxyAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.275 -0500", hash_original_field = "6E680D0312272F1C50F2E99ACBEA882B", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.277 -0500", hash_original_field = "428E2A9565FBB9A9F848DBD3B018A836", hash_generated_field = "C159D673C6FC052AF1A568408C4DA2F6")

    private String mDomain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.280 -0500", hash_original_field = "16E66C66E1DCD7C258871BCE5376724E", hash_generated_field = "7961D341A30A6551A165752670ACA6FD")

    private String mProtocol = UDP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.282 -0500", hash_original_field = "0423B63A4253856B868C084D606F0F75", hash_generated_field = "5D267F5F18DF516348BB55C6412BAD8F")

    private String mProfileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.284 -0500", hash_original_field = "4F8C4F41C607E4707092B0D616B9161D", hash_generated_field = "C2C52861D04ADF40D430DD5608696FA5")

    private String mAuthUserName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.286 -0500", hash_original_field = "C089F69FD07E1436057FA06D898201A8", hash_generated_field = "847F0DE2F4A62F6FE88C7934F99CC9EC")

    private int mPort = DEFAULT_PORT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.288 -0500", hash_original_field = "38E490F78359E99F55DC83C626A63C26", hash_generated_field = "C26F5CDD64291FBC6392240557469182")

    private boolean mSendKeepAlive = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.290 -0500", hash_original_field = "91BE166C9BD4C410069CE0D959AF719D", hash_generated_field = "D6B09BB0511B0E0F2902F47EA8A42CF8")

    private boolean mAutoRegistration = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.292 -0500", hash_original_field = "C7C3D4420C593C4B5045ACCA3E1452CD", hash_generated_field = "CB9163F150EE50C29DF1E6C445E05158")

    private transient int mCallingUid = 0;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.356 -0500", hash_original_method = "A9E3259F33F9DE91C391F7016F4793EF", hash_generated_method = "FED8766999C79E5FC9EADF65B6B01435")
    
private SipProfile() {
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.359 -0500", hash_original_method = "03F00CBB1D1D79A9110C9D3986D03161", hash_generated_method = "8CC7170A8DD58D50011A8DB87CAD4F69")
    
private SipProfile(Parcel in) {
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

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public SipProfile(DSOnlyType ds) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.361 -0500", hash_original_method = "0F86B1263AA1167A9BA85D0781C26BDD", hash_generated_method = "C4D0286935FE551D873CEDBE3C350714")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.363 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    /**
     * Gets the SIP URI of this profile.
     *
     * @return the SIP URI of this profile
     * @hide
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.366 -0500", hash_original_method = "95F156513507BA474AAADC0CAD04DB56", hash_generated_method = "C6732423BBA293A6F9CBB9D5E2CBC1C0")
    
public SipURI getUri() {
        return (SipURI) mAddress.getURI();
    }

    /**
     * Gets the SIP URI string of this profile.
     *
     * @return the SIP URI string of this profile
     */
    @DSComment("Data structure only, except writeToParcel")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.368 -0500", hash_original_method = "8967C0A1855BD4ECE9D4EFBDFCF47E43", hash_generated_method = "BF50A503FFF8E58300C49312CA915F38")
    
public String getUriString() {
        // We need to return the sip uri domain instead of
        // the SIP URI with transport, port information if
        // the outbound proxy address exists.
        if (!TextUtils.isEmpty(mProxyAddress)) {
            return "sip:" + getUserName() + "@" + mDomain;
        }
        return getUri().toString();
    }

    /**
     * Gets the SIP address of this profile.
     *
     * @return the SIP address of this profile
     * @hide
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.370 -0500", hash_original_method = "15923319AE2A6D9E076B860EB8423C19", hash_generated_method = "AA07A4C14990AFB91DEDEEF0866474DE")
    
public Address getSipAddress() {
        return mAddress;
    }

    /**
     * Gets the display name of the user.
     *
     * @return the display name of the user
     */
    @DSComment("Data structure only, except writeToParcel")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.372 -0500", hash_original_method = "986E0B7E655AC166DA3BC65E473D37F3", hash_generated_method = "E1D73EE245674BB839176FD2E2F3E033")
    
public String getDisplayName() {
        return mAddress.getDisplayName();
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    @DSComment("Data structure only, except writeToParcel")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.374 -0500", hash_original_method = "5CC4F03701178BF5DF2B7731C175F0C0", hash_generated_method = "19441879268764ACC8D0F353D88AF234")
    
public String getUserName() {
        return getUri().getUser();
    }

    /**
     * Gets the username for authentication. If it is null, then the username
     * is used in authentication instead.
     *
     * @return the authentication username
     * @see #getUserName
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.376 -0500", hash_original_method = "95E3B173DEC08F5D485CDBF035AFC6AC", hash_generated_method = "078780B80C0E2AF331BAB1D8763A6405")
    
public String getAuthUserName() {
        return mAuthUserName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.379 -0500", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "9B2AF8FA5A4898123492BF46BD6C9002")
    
public String getPassword() {
        return mPassword;
    }

    /**
     * Gets the SIP domain.
     *
     * @return the SIP domain
     */
    @DSComment("Data structure only, except writeToParcel")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.381 -0500", hash_original_method = "B8163CA1BE0927DF0B70D99008321B49", hash_generated_method = "1DB85475B114B6FF212FD8A1D167E541")
    
public String getSipDomain() {
        return mDomain;
    }

    /**
     * Gets the port number of the SIP server.
     *
     * @return the port number of the SIP server
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.383 -0500", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "33B8E8C1C43AC396F100852932189626")
    
public int getPort() {
        return mPort;
    }

    /**
     * Gets the protocol used to connect to the server.
     *
     * @return the protocol
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.386 -0500", hash_original_method = "259570BEE3678204ECD026726561CF7F", hash_generated_method = "8F1EAEC8EB0D8F93DE7E24D552C33424")
    
public String getProtocol() {
        return mProtocol;
    }

    /**
     * Gets the network address of the server outbound proxy.
     *
     * @return the network address of the server outbound proxy
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.388 -0500", hash_original_method = "3AA5E492CF333F83039FEED9B349A3B0", hash_generated_method = "C6862B17D4584DACD1601D3BC8C9CAF8")
    
public String getProxyAddress() {
        return mProxyAddress;
    }

    /**
     * Gets the (user-defined) name of the profile.
     *
     * @return name of the profile
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.389 -0500", hash_original_method = "9B8D5C45DA02E326FD388B2D1055F434", hash_generated_method = "6314F94D62800DF6C757400E73F0CAEE")
    
public String getProfileName() {
        return mProfileName;
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.303 -0500", hash_original_field = "6C705E47EB29E7031537DF33B4BD20CD", hash_generated_field = "D4548AF4DF078E10BA9DDCF8D88614E4")

        private AddressFactory mAddressFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.305 -0500", hash_original_field = "9F7C8FD1996BBF6BB5E9CE8F6732A0B3", hash_generated_field = "E8146CB60F48DFE997F29F63657642A2")

        private SipProfile mProfile = new SipProfile();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.308 -0500", hash_original_field = "3CE78ED1D75109013376860FA39F36C5", hash_generated_field = "994050EB7C7C334D824C5DF2F52AE95A")

        private SipURI mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.310 -0500", hash_original_field = "909EB572D0FA4337FFD0D9EC24BB74FF", hash_generated_field = "E578F409A2A7146A63C54CC9E032AC14")

        private String mDisplayName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.313 -0500", hash_original_field = "1E876FD9377BC2388423C0B7D745A482", hash_generated_field = "90C2D7808B6597C0EE6C5CDAAC93FED6")

        private String mProxyAddress;
        {
            try {
                mAddressFactory =
                        SipFactory.getInstance().createAddressFactory();
            } catch (PeerUnavailableException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Creates a builder based on the given profile.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.316 -0500", hash_original_method = "6381C04E2A4A8813FA59E1834CF9FF37", hash_generated_method = "6B324AC588614E8743A9A4197A1A32C3")
        
public Builder(SipProfile profile) {
            if (profile == null) throw new NullPointerException();
            try {
                mProfile = (SipProfile) profile.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("should not occur", e);
            }
            mProfile.mAddress = null;
            mUri = profile.getUri();
            mUri.setUserPassword(profile.getPassword());
            mDisplayName = profile.getDisplayName();
            mProxyAddress = profile.getProxyAddress();
            mProfile.mPort = profile.getPort();
        }

        /**
         * Constructor.
         *
         * @param uriString the URI string as "sip:<user_name>@<domain>"
         * @throws ParseException if the string is not a valid URI
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.320 -0500", hash_original_method = "64C9112A2795748CF233F7AC81823050", hash_generated_method = "86B29B60258F05012D4BE1F2CFD7120B")
        
public Builder(String uriString) throws ParseException {
            if (uriString == null) {
                throw new NullPointerException("uriString cannot be null");
            }
            URI uri = mAddressFactory.createURI(fix(uriString));
            if (uri instanceof SipURI) {
                mUri = (SipURI) uri;
            } else {
                throw new ParseException(uriString + " is not a SIP URI", 0);
            }
            mProfile.mDomain = mUri.getHost();
        }

        /**
         * Constructor.
         *
         * @param username username of the SIP account
         * @param serverDomain the SIP server domain; if the network address
         *      is different from the domain, use {@link #setOutboundProxy} to
         *      set server address
         * @throws ParseException if the parameters are not valid
         */
        @DSComment("Utility to build profile")
        @DSSafe(DSCat.UTIL_FUNCTION)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.323 -0500", hash_original_method = "75E755B13696F99D7736C0DDC72A28FA", hash_generated_method = "D89607C23A0798A84030B4276C561676")
        
public Builder(String username, String serverDomain)
                throws ParseException {
            if ((username == null) || (serverDomain == null)) {
                throw new NullPointerException(
                        "username and serverDomain cannot be null");
            }
            mUri = mAddressFactory.createSipURI(username, serverDomain);
            mProfile.mDomain = serverDomain;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.325 -0500", hash_original_method = "9B9A6C83AA85ED9069AF543EFC545200", hash_generated_method = "5B1240AC73121B3CC3E352C7A704B117")
        
private String fix(String uriString) {
            return (uriString.trim().toLowerCase().startsWith("sip:")
                    ? uriString
                    : "sip:" + uriString);
        }

        /**
         * Sets the username used for authentication.
         *
         * @param name authentication username of the profile
         * @return this builder object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.327 -0500", hash_original_method = "18250D1818A49995026FA15C7D9E3273", hash_generated_method = "58C96ED3FD356531672DF60EF19C0C4C")
        
public Builder setAuthUserName(String name) {
            mProfile.mAuthUserName = name;
            return this;
        }

        /**
         * Sets the name of the profile. This name is given by user.
         *
         * @param name name of the profile
         * @return this builder object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.330 -0500", hash_original_method = "296C55D6980E7D56ABE421835C15F41F", hash_generated_method = "FAD56340E40E3A3110061CF9D8205BBC")
        
public Builder setProfileName(String name) {
            mProfile.mProfileName = name;
            return this;
        }

        /**
         * Sets the password of the SIP account
         *
         * @param password password of the SIP account
         * @return this builder object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.332 -0500", hash_original_method = "BC6826AF1B9FCC986900D7A0D38FE546", hash_generated_method = "EB1FE3C7E5CBF7DA7B547AF1D26D4165")
        
public Builder setPassword(String password) {
            mUri.setUserPassword(password);
            return this;
        }

        /**
         * Sets the port number of the server. By default, it is 5060.
         *
         * @param port port number of the server
         * @return this builder object
         * @throws IllegalArgumentException if the port number is out of range
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.335 -0500", hash_original_method = "F3098A99A5C246234AF1DF8489EE5D8A", hash_generated_method = "7A832EF07ABCFBCDAC4CE159C761DAEA")
        
public Builder setPort(int port) throws IllegalArgumentException {
            if ((port > 65535) || (port < 1000)) {
                throw new IllegalArgumentException("incorrect port arugment: " + port);
            }
            mProfile.mPort = port;
            return this;
        }

        /**
         * Sets the protocol used to connect to the SIP server. Currently,
         * only "UDP" and "TCP" are supported.
         *
         * @param protocol the protocol string
         * @return this builder object
         * @throws IllegalArgumentException if the protocol is not recognized
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.337 -0500", hash_original_method = "3D9493D9C057190A447294828E62D209", hash_generated_method = "C22507514704073509D5D4DBD36F078F")
        
public Builder setProtocol(String protocol)
                throws IllegalArgumentException {
            if (protocol == null) {
                throw new NullPointerException("protocol cannot be null");
            }
            protocol = protocol.toUpperCase();
            if (!protocol.equals(UDP) && !protocol.equals(TCP)) {
                throw new IllegalArgumentException(
                        "unsupported protocol: " + protocol);
            }
            mProfile.mProtocol = protocol;
            return this;
        }

        /**
         * Sets the outbound proxy of the SIP server.
         *
         * @param outboundProxy the network address of the outbound proxy
         * @return this builder object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.339 -0500", hash_original_method = "3904E95A10FA919CA386CED8B9FE2A62", hash_generated_method = "9B98FB1ABCAC1117FBBABEAFFDD0EE02")
        
public Builder setOutboundProxy(String outboundProxy) {
            mProxyAddress = outboundProxy;
            return this;
        }

        /**
         * Sets the display name of the user.
         *
         * @param displayName display name of the user
         * @return this builder object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.342 -0500", hash_original_method = "6E9362DA0DBE9DD97645F0D0015D1E5C", hash_generated_method = "1581471222ED48424A91F40D1B678D10")
        
public Builder setDisplayName(String displayName) {
            mDisplayName = displayName;
            return this;
        }

        /**
         * Sets the send keep-alive flag.
         *
         * @param flag true if sending keep-alive message is required,
         *      false otherwise
         * @return this builder object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.344 -0500", hash_original_method = "34498E182A6A75F890ADDB0BA3DE0052", hash_generated_method = "7CA9FD657034A50A7C43F32C3D90BA1A")
        
public Builder setSendKeepAlive(boolean flag) {
            mProfile.mSendKeepAlive = flag;
            return this;
        }

        /**
         * Sets the auto. registration flag.
         *
         * @param flag true if the profile will be registered automatically,
         *      false otherwise
         * @return this builder object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.346 -0500", hash_original_method = "7257964704D967B57FF3B17ACA4002E0", hash_generated_method = "934FB3F423AE57FE4E6B5EE429188F0C")
        
public Builder setAutoRegistration(boolean flag) {
            mProfile.mAutoRegistration = flag;
            return this;
        }

        /**
         * Builds and returns the SIP profile object.
         *
         * @return the profile object created
         */
        @DSComment("Utility to build profile")
        @DSSafe(DSCat.UTIL_FUNCTION)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.349 -0500", hash_original_method = "9D6052B0DC59ACBDB83E3EF9051B1CBF", hash_generated_method = "EE3144543673BCA538013AE8E29AD939")
        
public SipProfile build() {
            // remove password from URI
            mProfile.mPassword = mUri.getUserPassword();
            mUri.setUserPassword(null);
            try {
                if (!TextUtils.isEmpty(mProxyAddress)) {
                    SipURI uri = (SipURI)
                            mAddressFactory.createURI(fix(mProxyAddress));
                    mProfile.mProxyAddress = uri.getHost();
                } else {
                    if (!mProfile.mProtocol.equals(UDP)) {
                        mUri.setTransportParam(mProfile.mProtocol);
                    }
                    if (mProfile.mPort != DEFAULT_PORT) {
                        mUri.setPort(mProfile.mPort);
                    }
                }
                mProfile.mAddress = mAddressFactory.createAddress(
                        mDisplayName, mUri);
            } catch (InvalidArgumentException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                // must not occur
                throw new RuntimeException(e);
            }
            return mProfile;
        }
        
    }

    /**
     * Gets the flag of 'Sending keep-alive'.
     *
     * @return the flag of sending SIP keep-alive messages.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.391 -0500", hash_original_method = "0FCF61873B0EC3A9D19B7E99B4FC0FAA", hash_generated_method = "22121916FA3DEAFAF1C056B74068BD16")
    
public boolean getSendKeepAlive() {
        return mSendKeepAlive;
    }

    /**
     * Gets the flag of 'Auto Registration'.
     *
     * @return the flag of registering the profile automatically.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.394 -0500", hash_original_method = "BE11F0672CD5463C56A90C5E0BC73CFE", hash_generated_method = "17567A49A3FEC3341D7374C88F33661B")
    
public boolean getAutoRegistration() {
        return mAutoRegistration;
    }

    /**
     * Sets the calling process's Uid in the sip service.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.396 -0500", hash_original_method = "24890DFC4ECCC257FBD9D683C57D0141", hash_generated_method = "E7993CB0E54E2B2A188C4503190C496C")
    
public void setCallingUid(int uid) {
        mCallingUid = uid;
    }

    /**
     * Gets the calling process's Uid in the sip settings.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.398 -0500", hash_original_method = "1B2206C44B78A8BBFEDFDFC351FB4749", hash_generated_method = "90676EFC2EE8437376F39B7CFD517EEA")
    
public int getCallingUid() {
        return mCallingUid;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:25.401 -0500", hash_original_method = "0A3380549EECCCE1451002357806ED2B", hash_generated_method = "5AD4DC34E87665A45E67778E2D54F695")
    
private Object readResolve() throws ObjectStreamException {
        // For compatibility.
        if (mPort == 0) mPort = DEFAULT_PORT;
        return this;
    }
    // orphaned legacy method
    public SipProfile createFromParcel(Parcel in) {
                    return new SipProfile(in);
                }
    
    // orphaned legacy method
    public SipProfile[] newArray(int size) {
                    return new SipProfile[size];
                }
    
}

