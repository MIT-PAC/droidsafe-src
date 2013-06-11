package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class ProxyProperties implements Parcelable {
    private String mHost;
    private int mPort;
    private String mExclusionList;
    private String[] mParsedExclusionList;
    public static final Creator<ProxyProperties> CREATOR = new Creator<ProxyProperties>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.274 -0400", hash_original_method = "A76B576B418A59DA79A74A0B4EFE2DF1", hash_generated_method = "36E7189ABFC7617AB7FA21EB6F9F9693")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ProxyProperties createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            String host;
            host = null;
            int port;
            port = 0;
            {
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_50940600 = (in.readByte() == 1);
                {
                    host = in.readString();
                    port = in.readInt();
                } //End block
            } //End collapsed parenthetic
            String exclList;
            exclList = in.readString();
            String[] parsedExclList;
            parsedExclList = in.readStringArray();
            ProxyProperties proxyProperties;
            proxyProperties = new ProxyProperties(host, port, exclList, parsedExclList);
            return (ProxyProperties)dsTaint.getTaint();
            // ---------- Original Method ----------
            //String host = null;
            //int port = 0;
            //if (in.readByte() == 1) {
                    //host = in.readString();
                    //port = in.readInt();
                //}
            //String exclList = in.readString();
            //String[] parsedExclList = in.readStringArray();
            //ProxyProperties proxyProperties =
                        //new ProxyProperties(host, port, exclList, parsedExclList);
            //return proxyProperties;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.274 -0400", hash_original_method = "059EE23B2C7F4EFFECDBB1A455F1E783", hash_generated_method = "FA7B42A9BD57B7FCD2A906D019550FF0")
        @DSModeled(DSC.SAFE)
        public ProxyProperties[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ProxyProperties[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ProxyProperties[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.275 -0400", hash_original_method = "54A7DBB96A42C21C9A34864E71BDFD9B", hash_generated_method = "9E4903F5FDADD04B7575917BC5764EB7")
    @DSModeled(DSC.SAFE)
    public ProxyProperties(String host, int port, String exclList) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(exclList);
        setExclusionList(exclList);
        // ---------- Original Method ----------
        //mHost = host;
        //mPort = port;
        //setExclusionList(exclList);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.275 -0400", hash_original_method = "BC11E2D42BFC71E7CE241ADFD4F8685E", hash_generated_method = "9783465525E9C2FA85F302A446C027DF")
    @DSModeled(DSC.SAFE)
    private ProxyProperties(String host, int port, String exclList, String[] parsedExclList) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(parsedExclList);
        dsTaint.addTaint(host);
        dsTaint.addTaint(exclList);
        // ---------- Original Method ----------
        //mHost = host;
        //mPort = port;
        //mExclusionList = exclList;
        //mParsedExclusionList = parsedExclList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.275 -0400", hash_original_method = "A69C6CB2998D1D9E29343274F58FCABE", hash_generated_method = "142FAC7FA76A49FA0E4E2CD35A188067")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyProperties(ProxyProperties source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.275 -0400", hash_original_method = "207ACF10C117D35BCDF8E06D043E3E5B", hash_generated_method = "0D73EE0A473B373D8C7A5F6AA3A1EEC5")
    @DSModeled(DSC.SAFE)
    public InetSocketAddress getSocketAddress() {
        InetSocketAddress inetSocketAddress;
        inetSocketAddress = null;
        try 
        {
            inetSocketAddress = new InetSocketAddress(mHost, mPort);
        } //End block
        catch (IllegalArgumentException e)
        { }
        return (InetSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //InetSocketAddress inetSocketAddress = null;
        //try {
            //inetSocketAddress = new InetSocketAddress(mHost, mPort);
        //} catch (IllegalArgumentException e) { }
        //return inetSocketAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.275 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "5D7FB7EF798C1D1B66E805B4E08F784B")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.275 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "15B913872630FEC82C8C724DE4684D9A")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.275 -0400", hash_original_method = "A9FE56F63855512203F6AE795614409C", hash_generated_method = "F20A5B4A1B18FAE07369B854C33D9B81")
    @DSModeled(DSC.SAFE)
    public String getExclusionList() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mExclusionList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.276 -0400", hash_original_method = "BEF68745D535D943EDDB2DD96C1B6EA8", hash_generated_method = "306C48653BF96299D492A1E9E3B831AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setExclusionList(String exclusionList) {
        dsTaint.addTaint(exclusionList);
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
                        boolean varDD02578407E87DFB02749E3DE9227235_838606789 = (s.startsWith("."));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.276 -0400", hash_original_method = "72D2F326AF1444346066F9053B4FD5C0", hash_generated_method = "3EDF4EC6AAE12F36F4D0EC5794862191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isExcluded(String url) {
        dsTaint.addTaint(url);
        {
            boolean var9C90EF043E3784234A49B219593EFBDA_1429457943 = (TextUtils.isEmpty(url) || mParsedExclusionList == null ||
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
                    boolean varC03F0A18FFBF5EA342D3BF4D0C85A5FA_620189426 = (urlDomain.equals(mParsedExclusionList[i]) ||
                    urlDomain.endsWith(mParsedExclusionList[i+1]));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.276 -0400", hash_original_method = "FF3E8127D15D936B6F66AB217E4EB9BA", hash_generated_method = "C2B681DBA5EBA8C98473F0E4F05D7D62")
    @DSModeled(DSC.SAFE)
    public java.net.Proxy makeProxy() {
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
        return (java.net.Proxy)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.276 -0400", hash_original_method = "FE9AE719D0C3E87A445C3CEFBF6B38D6", hash_generated_method = "54EAD5B36B252D4C1CB9D71C800B0990")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var806458D832AB974D230FEE4CBBDBD390_1744141774 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.277 -0400", hash_original_method = "16EB0AD501F97CC03F0A85B7200F0E73", hash_generated_method = "75A05BCA811CAE9FAAF9D30360EBA9B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        ProxyProperties p;
        p = (ProxyProperties)o;
        {
            boolean varE9ED1F5D95B4E0C60AD4D6B9786BB006_40424720 = (mExclusionList != null && !mExclusionList.equals(p.getExclusionList()));
        } //End collapsed parenthetic
        {
            boolean var8E4D465625121C486267E0436ACD7002_1577452912 = (mHost != null && p.getHost() != null && mHost.equals(p.getHost()) == false);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.277 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.277 -0400", hash_original_method = "AD2D5515FEDCF9B25A708B71445DFAB4", hash_generated_method = "813BCB6F24C89874BCCBBCEFFCCF08DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varC5C4A10D790BD48E2EA1C18AE7D59490_769602221 = (((null == mHost) ? 0 : mHost.hashCode())
        + ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        + mPort); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((null == mHost) ? 0 : mHost.hashCode())
        //+ ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        //+ mPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.277 -0400", hash_original_method = "038CE78D7B15BBF2D949EA22EA3CF00F", hash_generated_method = "91684199A38793B24B24400074F544D1")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
}


