package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class ProxyProperties implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.852 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.852 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.852 -0400", hash_original_field = "F38606E98EB026EB9D970DA96CBDCC8D", hash_generated_field = "69C381CAD09CE31D3079B1694FAFB726")

    private String mExclusionList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.853 -0400", hash_original_field = "0ED6AC613F3B643FBC2DEFC7C073D553", hash_generated_field = "44474F4F446275AD736304F48293F55B")

    private String[] mParsedExclusionList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.875 -0400", hash_original_method = "54A7DBB96A42C21C9A34864E71BDFD9B", hash_generated_method = "42DB5B71C710990590A7206B233BE09A")
    public  ProxyProperties(String host, int port, String exclList) {
        mHost = host;
        mPort = port;
        setExclusionList(exclList);
        addTaint(exclList.getTaint());
        // ---------- Original Method ----------
        //mHost = host;
        //mPort = port;
        //setExclusionList(exclList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.877 -0400", hash_original_method = "BC11E2D42BFC71E7CE241ADFD4F8685E", hash_generated_method = "63CFA9158D0179E62AF9851432940F54")
    private  ProxyProperties(String host, int port, String exclList, String[] parsedExclList) {
        mHost = host;
        mPort = port;
        mExclusionList = exclList;
        mParsedExclusionList = parsedExclList;
        // ---------- Original Method ----------
        //mHost = host;
        //mPort = port;
        //mExclusionList = exclList;
        //mParsedExclusionList = parsedExclList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.879 -0400", hash_original_method = "A69C6CB2998D1D9E29343274F58FCABE", hash_generated_method = "7BD9393B82DEE13A153E5D6E3C6728BB")
    public  ProxyProperties(ProxyProperties source) {
        {
            mHost = source.getHost();
            mPort = source.getPort();
            mExclusionList = source.getExclusionList();
            mParsedExclusionList = source.mParsedExclusionList;
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mHost = source.getHost();
            //mPort = source.getPort();
            //mExclusionList = source.getExclusionList();
            //mParsedExclusionList = source.mParsedExclusionList;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.881 -0400", hash_original_method = "207ACF10C117D35BCDF8E06D043E3E5B", hash_generated_method = "DC821F7E7875061C15F28545C7850A53")
    public InetSocketAddress getSocketAddress() {
        InetSocketAddress varB4EAC82CA7396A68D541C85D26508E83_1204131603 = null; //Variable for return #1
        InetSocketAddress inetSocketAddress;
        inetSocketAddress = null;
        try 
        {
            inetSocketAddress = new InetSocketAddress(mHost, mPort);
        } //End block
        catch (IllegalArgumentException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1204131603 = inetSocketAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1204131603.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1204131603;
        // ---------- Original Method ----------
        //InetSocketAddress inetSocketAddress = null;
        //try {
            //inetSocketAddress = new InetSocketAddress(mHost, mPort);
        //} catch (IllegalArgumentException e) { }
        //return inetSocketAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.900 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "264EA4436BD2577BCA1C0C9EFB1C18E7")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1343932093 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1343932093 = mHost;
        varB4EAC82CA7396A68D541C85D26508E83_1343932093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1343932093;
        // ---------- Original Method ----------
        //return mHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.900 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "CA3C769D2CD935BD52BD34B5052CE253")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064025962 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064025962;
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.902 -0400", hash_original_method = "A9FE56F63855512203F6AE795614409C", hash_generated_method = "640D55FE76FE55D0A9B84E3D39740452")
    public String getExclusionList() {
        String varB4EAC82CA7396A68D541C85D26508E83_869284127 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_869284127 = mExclusionList;
        varB4EAC82CA7396A68D541C85D26508E83_869284127.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_869284127;
        // ---------- Original Method ----------
        //return mExclusionList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.907 -0400", hash_original_method = "BEF68745D535D943EDDB2DD96C1B6EA8", hash_generated_method = "CF9B8E46157C19C7DA4AC1407D61BEB9")
    private void setExclusionList(String exclusionList) {
        mExclusionList = exclusionList;
        {
            mParsedExclusionList = new String[0];
        } //End block
        {
            String splitExclusionList[];
            splitExclusionList = exclusionList.toLowerCase().split(",");
            mParsedExclusionList = new String[splitExclusionList.length * 2];
            {
                int i;
                i = 0;
                {
                    String s;
                    s = splitExclusionList[i].trim();
                    {
                        boolean varDD02578407E87DFB02749E3DE9227235_4590219 = (s.startsWith("."));
                        s = s.substring(1);
                    } //End collapsed parenthetic
                    mParsedExclusionList[i*2] = s;
                    mParsedExclusionList[(i*2)+1] = "." + s;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //mExclusionList = exclusionList;
        //if (mExclusionList == null) {
            //mParsedExclusionList = new String[0];
        //} else {
            //String splitExclusionList[] = exclusionList.toLowerCase().split(",");
            //mParsedExclusionList = new String[splitExclusionList.length * 2];
            //for (int i = 0; i < splitExclusionList.length; i++) {
                //String s = splitExclusionList[i].trim();
                //if (s.startsWith(".")) s = s.substring(1);
                //mParsedExclusionList[i*2] = s;
                //mParsedExclusionList[(i*2)+1] = "." + s;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.929 -0400", hash_original_method = "72D2F326AF1444346066F9053B4FD5C0", hash_generated_method = "E5AFFC79D3BAC52ECD35FD53A721ACBA")
    public boolean isExcluded(String url) {
        {
            boolean var9C90EF043E3784234A49B219593EFBDA_1198691337 = (TextUtils.isEmpty(url) || mParsedExclusionList == null ||
                mParsedExclusionList.length == 0);
        } //End collapsed parenthetic
        Uri u;
        u = Uri.parse(url);
        String urlDomain;
        urlDomain = u.getHost();
        {
            int i;
            i = 0;
            i+=2;
            {
                {
                    boolean varC03F0A18FFBF5EA342D3BF4D0C85A5FA_2037524826 = (urlDomain.equals(mParsedExclusionList[i]) ||
                    urlDomain.endsWith(mParsedExclusionList[i+1]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274673873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274673873;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(url) || mParsedExclusionList == null ||
                //mParsedExclusionList.length == 0) return false;
        //Uri u = Uri.parse(url);
        //String urlDomain = u.getHost();
        //if (urlDomain == null) return false;
        //for (int i = 0; i< mParsedExclusionList.length; i+=2) {
            //if (urlDomain.equals(mParsedExclusionList[i]) ||
                    //urlDomain.endsWith(mParsedExclusionList[i+1])) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.938 -0400", hash_original_method = "FF3E8127D15D936B6F66AB217E4EB9BA", hash_generated_method = "92C4DF79C8F79A7380D09AF124E2E9AA")
    public java.net.Proxy makeProxy() {
        java.net.Proxy varB4EAC82CA7396A68D541C85D26508E83_1982555717 = null; //Variable for return #1
        java.net.Proxy proxy;
        proxy = java.net.Proxy.NO_PROXY;
        {
            try 
            {
                InetSocketAddress inetSocketAddress;
                inetSocketAddress = new InetSocketAddress(mHost, mPort);
                proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, inetSocketAddress);
            } //End block
            catch (IllegalArgumentException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1982555717 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_1982555717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1982555717;
        // ---------- Original Method ----------
        //java.net.Proxy proxy = java.net.Proxy.NO_PROXY;
        //if (mHost != null) {
            //try {
                //InetSocketAddress inetSocketAddress = new InetSocketAddress(mHost, mPort);
                //proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, inetSocketAddress);
            //} catch (IllegalArgumentException e) {
            //}
        //}
        //return proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.944 -0400", hash_original_method = "FE9AE719D0C3E87A445C3CEFBF6B38D6", hash_generated_method = "B640CC8B7D1692EF42925212CA2828FE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1185389623 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        {
            sb.append("[");
            sb.append(mHost);
            sb.append("] ");
            sb.append(Integer.toString(mPort));
            {
                sb.append(" xl=").append(mExclusionList);
            } //End block
        } //End block
        {
            sb.append("[ProxyProperties.mHost == null]");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1185389623 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1185389623.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1185389623;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //if (mHost != null) {
            //sb.append("[");
            //sb.append(mHost);
            //sb.append("] ");
            //sb.append(Integer.toString(mPort));
            //if (mExclusionList != null) {
                    //sb.append(" xl=").append(mExclusionList);
            //}
        //} else {
            //sb.append("[ProxyProperties.mHost == null]");
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.954 -0400", hash_original_method = "16EB0AD501F97CC03F0A85B7200F0E73", hash_generated_method = "C6A8E6961EABFFD1893EC1836D45EA51")
    @Override
    public boolean equals(Object o) {
        ProxyProperties p;
        p = (ProxyProperties)o;
        {
            boolean varE9ED1F5D95B4E0C60AD4D6B9786BB006_470735402 = (mExclusionList != null && !mExclusionList.equals(p.getExclusionList()));
        } //End collapsed parenthetic
        {
            boolean var8E4D465625121C486267E0436ACD7002_379404179 = (mHost != null && p.getHost() != null && mHost.equals(p.getHost()) == false);
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155276796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155276796;
        // ---------- Original Method ----------
        //if (!(o instanceof ProxyProperties)) return false;
        //ProxyProperties p = (ProxyProperties)o;
        //if (mExclusionList != null && !mExclusionList.equals(p.getExclusionList())) return false;
        //if (mHost != null && p.getHost() != null && mHost.equals(p.getHost()) == false) {
            //return false;
        //}
        //if (mHost != null && p.mHost == null) return false;
        //if (mHost == null && p.mHost != null) return false;
        //if (mPort != p.mPort) return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.954 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DBBF245D42B4998F1D901A751CCF3B59")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228324163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228324163;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.966 -0400", hash_original_method = "AD2D5515FEDCF9B25A708B71445DFAB4", hash_generated_method = "C7CED8D6DF9CECA89EC2C32A76E9928F")
    @Override
    public int hashCode() {
        int varC5C4A10D790BD48E2EA1C18AE7D59490_1041134360 = (((null == mHost) ? 0 : mHost.hashCode())
        + ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        + mPort); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080248292 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1080248292;
        // ---------- Original Method ----------
        //return ((null == mHost) ? 0 : mHost.hashCode())
        //+ ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        //+ mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.968 -0400", hash_original_method = "038CE78D7B15BBF2D949EA22EA3CF00F", hash_generated_method = "220715D67574944D239132F24BCEA1D8")
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeByte((byte)1);
            dest.writeString(mHost);
            dest.writeInt(mPort);
        } //End block
        {
            dest.writeByte((byte)0);
        } //End block
        dest.writeString(mExclusionList);
        dest.writeStringArray(mParsedExclusionList);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //if (mHost != null) {
            //dest.writeByte((byte)1);
            //dest.writeString(mHost);
            //dest.writeInt(mPort);
        //} else {
            //dest.writeByte((byte)0);
        //}
        //dest.writeString(mExclusionList);
        //dest.writeStringArray(mParsedExclusionList);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.969 -0400", hash_original_field = "8C1BCA5A763B1D293459FDC94947A9DA", hash_generated_field = "37B61C5F5B74C5B267912D84DAC98E0A")

    public static final Creator<ProxyProperties> CREATOR =
        new Creator<ProxyProperties>() {
            public ProxyProperties createFromParcel(Parcel in) {
                String host = null;
                int port = 0;
                if (in.readByte() == 1) {
                    host = in.readString();
                    port = in.readInt();
                }
                String exclList = in.readString();
                String[] parsedExclList = in.readStringArray();
                ProxyProperties proxyProperties =
                        new ProxyProperties(host, port, exclList, parsedExclList);
                return proxyProperties;
            }

            public ProxyProperties[] newArray(int size) {
                return new ProxyProperties[size];
            }
        };
}

