package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class ProxyProperties implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.924 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.924 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.924 -0400", hash_original_field = "F38606E98EB026EB9D970DA96CBDCC8D", hash_generated_field = "69C381CAD09CE31D3079B1694FAFB726")

    private String mExclusionList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.924 -0400", hash_original_field = "0ED6AC613F3B643FBC2DEFC7C073D553", hash_generated_field = "44474F4F446275AD736304F48293F55B")

    private String[] mParsedExclusionList;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.925 -0400", hash_original_method = "54A7DBB96A42C21C9A34864E71BDFD9B", hash_generated_method = "42DB5B71C710990590A7206B233BE09A")
    public  ProxyProperties(String host, int port, String exclList) {
        mHost = host;
        mPort = port;
        setExclusionList(exclList);
        addTaint(exclList.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.925 -0400", hash_original_method = "BC11E2D42BFC71E7CE241ADFD4F8685E", hash_generated_method = "63CFA9158D0179E62AF9851432940F54")
    private  ProxyProperties(String host, int port, String exclList, String[] parsedExclList) {
        mHost = host;
        mPort = port;
        mExclusionList = exclList;
        mParsedExclusionList = parsedExclList;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.925 -0400", hash_original_method = "A69C6CB2998D1D9E29343274F58FCABE", hash_generated_method = "7BD9393B82DEE13A153E5D6E3C6728BB")
    public  ProxyProperties(ProxyProperties source) {
        {
            mHost = source.getHost();
            mPort = source.getPort();
            mExclusionList = source.getExclusionList();
            mParsedExclusionList = source.mParsedExclusionList;
        } 
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.926 -0400", hash_original_method = "207ACF10C117D35BCDF8E06D043E3E5B", hash_generated_method = "95DC535E7FD47EFEB5983C6EF20A0875")
    public InetSocketAddress getSocketAddress() {
        InetSocketAddress varB4EAC82CA7396A68D541C85D26508E83_1255137452 = null; 
        InetSocketAddress inetSocketAddress = null;
        try 
        {
            inetSocketAddress = new InetSocketAddress(mHost, mPort);
        } 
        catch (IllegalArgumentException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1255137452 = inetSocketAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1255137452.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1255137452;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.927 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "521311605E13FE489C3E25C419F2AADD")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1932471961 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1932471961 = mHost;
        varB4EAC82CA7396A68D541C85D26508E83_1932471961.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1932471961;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.927 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "515D0BAD6FB00F17BE705B3252163518")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831063063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831063063;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.928 -0400", hash_original_method = "A9FE56F63855512203F6AE795614409C", hash_generated_method = "66D5C563C9BAC498820283EB1C1E67AE")
    public String getExclusionList() {
        String varB4EAC82CA7396A68D541C85D26508E83_728355363 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_728355363 = mExclusionList;
        varB4EAC82CA7396A68D541C85D26508E83_728355363.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_728355363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.929 -0400", hash_original_method = "BEF68745D535D943EDDB2DD96C1B6EA8", hash_generated_method = "B88A8CF3007C0FD68B81B8C37F70DCF2")
    private void setExclusionList(String exclusionList) {
        mExclusionList = exclusionList;
        {
            mParsedExclusionList = new String[0];
        } 
        {
            String splitExclusionList[] = exclusionList.toLowerCase().split(",");
            mParsedExclusionList = new String[splitExclusionList.length * 2];
            {
                int i = 0;
                {
                    String s = splitExclusionList[i].trim();
                    {
                        boolean varDD02578407E87DFB02749E3DE9227235_108283083 = (s.startsWith("."));
                        s = s.substring(1);
                    } 
                    mParsedExclusionList[i*2] = s;
                    mParsedExclusionList[(i*2)+1] = "." + s;
                } 
            } 
        } 
        
        
        
            
        
            
            
            
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.930 -0400", hash_original_method = "72D2F326AF1444346066F9053B4FD5C0", hash_generated_method = "7FF6C0CA1CECD9FABBB4F7F98F1869D3")
    public boolean isExcluded(String url) {
        {
            boolean var9C90EF043E3784234A49B219593EFBDA_157677275 = (TextUtils.isEmpty(url) || mParsedExclusionList == null ||
                mParsedExclusionList.length == 0);
        } 
        Uri u = Uri.parse(url);
        String urlDomain = u.getHost();
        {
            int i = 0;
            i+=2;
            {
                {
                    boolean varC03F0A18FFBF5EA342D3BF4D0C85A5FA_173679936 = (urlDomain.equals(mParsedExclusionList[i]) ||
                    urlDomain.endsWith(mParsedExclusionList[i+1]));
                } 
            } 
        } 
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309576849 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309576849;
        
        
                
        
        
        
        
            
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.930 -0400", hash_original_method = "FF3E8127D15D936B6F66AB217E4EB9BA", hash_generated_method = "148A6C76902DBD7123779371D2C3A8EB")
    public java.net.Proxy makeProxy() {
        java.net.Proxy varB4EAC82CA7396A68D541C85D26508E83_636135709 = null; 
        java.net.Proxy proxy = java.net.Proxy.NO_PROXY;
        {
            try 
            {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(mHost, mPort);
                proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, inetSocketAddress);
            } 
            catch (IllegalArgumentException e)
            { }
        } 
        varB4EAC82CA7396A68D541C85D26508E83_636135709 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_636135709.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_636135709;
        
        
        
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.931 -0400", hash_original_method = "FE9AE719D0C3E87A445C3CEFBF6B38D6", hash_generated_method = "49938E439F02207CFE9C3B4C4F82AD5B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1005621275 = null; 
        StringBuilder sb = new StringBuilder();
        {
            sb.append("[");
            sb.append(mHost);
            sb.append("] ");
            sb.append(Integer.toString(mPort));
            {
                sb.append(" xl=").append(mExclusionList);
            } 
        } 
        {
            sb.append("[ProxyProperties.mHost == null]");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1005621275 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1005621275.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1005621275;
        
        
        
            
            
            
            
            
                    
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.932 -0400", hash_original_method = "16EB0AD501F97CC03F0A85B7200F0E73", hash_generated_method = "61C5A3BF84AD60A05B762197311A44BD")
    @Override
    public boolean equals(Object o) {
        ProxyProperties p = (ProxyProperties)o;
        {
            boolean varE9ED1F5D95B4E0C60AD4D6B9786BB006_1980513242 = (mExclusionList != null && !mExclusionList.equals(p.getExclusionList()));
        } 
        {
            boolean var8E4D465625121C486267E0436ACD7002_2133967158 = (mHost != null && p.getHost() != null && mHost.equals(p.getHost()) == false);
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993984369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_993984369;
        
        
        
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.932 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6367BF64DC0EAF8EA931820EF4360D51")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914416163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914416163;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.933 -0400", hash_original_method = "AD2D5515FEDCF9B25A708B71445DFAB4", hash_generated_method = "366633A7D07A1176470672123CAADDF2")
    @Override
    public int hashCode() {
        int varC5C4A10D790BD48E2EA1C18AE7D59490_1776663484 = (((null == mHost) ? 0 : mHost.hashCode())
        + ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        + mPort); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139359829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2139359829;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.933 -0400", hash_original_method = "038CE78D7B15BBF2D949EA22EA3CF00F", hash_generated_method = "220715D67574944D239132F24BCEA1D8")
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeByte((byte)1);
            dest.writeString(mHost);
            dest.writeInt(mPort);
        } 
        {
            dest.writeByte((byte)0);
        } 
        dest.writeString(mExclusionList);
        dest.writeStringArray(mParsedExclusionList);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
            
            
            
        
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.933 -0400", hash_original_field = "8C1BCA5A763B1D293459FDC94947A9DA", hash_generated_field = "37B61C5F5B74C5B267912D84DAC98E0A")

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
    
}

