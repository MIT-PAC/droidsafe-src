package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.InetSocketAddress;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public class ProxyProperties implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.163 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "C8F07C3E0F6788C43A05E20D5536D66C")

    private String mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.163 -0400", hash_original_field = "5EFA61C4FCA92CA992BE37C2BAF4D350", hash_generated_field = "A2873EA11C139FA2F790281AB4EEDB4E")

    private int mPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.163 -0400", hash_original_field = "F38606E98EB026EB9D970DA96CBDCC8D", hash_generated_field = "69C381CAD09CE31D3079B1694FAFB726")

    private String mExclusionList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.163 -0400", hash_original_field = "0ED6AC613F3B643FBC2DEFC7C073D553", hash_generated_field = "44474F4F446275AD736304F48293F55B")

    private String[] mParsedExclusionList;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.164 -0400", hash_original_method = "54A7DBB96A42C21C9A34864E71BDFD9B", hash_generated_method = "3016880FA037606211CE706EEDE03259")
    public  ProxyProperties(String host, int port, String exclList) {
        addTaint(exclList.getTaint());
        mHost = host;
        mPort = port;
        setExclusionList(exclList);
        // ---------- Original Method ----------
        //mHost = host;
        //mPort = port;
        //setExclusionList(exclList);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.164 -0400", hash_original_method = "BC11E2D42BFC71E7CE241ADFD4F8685E", hash_generated_method = "63CFA9158D0179E62AF9851432940F54")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.164 -0400", hash_original_method = "A69C6CB2998D1D9E29343274F58FCABE", hash_generated_method = "17C8ABC252A039088A166C16EF3830DC")
    public  ProxyProperties(ProxyProperties source) {
        if(source != null)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.164 -0400", hash_original_method = "207ACF10C117D35BCDF8E06D043E3E5B", hash_generated_method = "355BE28370DEED195EAC4B6AC96E6397")
    public InetSocketAddress getSocketAddress() {
        InetSocketAddress inetSocketAddress = null;
        try 
        {
            inetSocketAddress = new InetSocketAddress(mHost, mPort);
        } //End block
        catch (IllegalArgumentException e)
        {
        } //End block
InetSocketAddress var571036BB61B9E7FDBB9F3BBC66371C29_1957345502 =         inetSocketAddress;
        var571036BB61B9E7FDBB9F3BBC66371C29_1957345502.addTaint(taint);
        return var571036BB61B9E7FDBB9F3BBC66371C29_1957345502;
        // ---------- Original Method ----------
        //InetSocketAddress inetSocketAddress = null;
        //try {
            //inetSocketAddress = new InetSocketAddress(mHost, mPort);
        //} catch (IllegalArgumentException e) { }
        //return inetSocketAddress;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.164 -0400", hash_original_method = "B21C2297C1E60D4D2D92DDE75D931874", hash_generated_method = "BFAB79A73F991F6DD97F41836AAEAFCC")
    public String getHost() {
String varE57614B151242FB69B92E61EEA287D33_10611194 =         mHost;
        varE57614B151242FB69B92E61EEA287D33_10611194.addTaint(taint);
        return varE57614B151242FB69B92E61EEA287D33_10611194;
        // ---------- Original Method ----------
        //return mHost;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.164 -0400", hash_original_method = "D8DAED2CD8A0984A9202198C71DA9D83", hash_generated_method = "8B90C85E27CEFF8E5C512E0E90BF2FBE")
    public int getPort() {
        int var5EFA61C4FCA92CA992BE37C2BAF4D350_1435477479 = (mPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640017085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640017085;
        // ---------- Original Method ----------
        //return mPort;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.164 -0400", hash_original_method = "A9FE56F63855512203F6AE795614409C", hash_generated_method = "4E5634495BECD399515DE8ADAAB04C30")
    public String getExclusionList() {
String varC0B04173BEBA2500AEBF48903299C3F4_1773792936 =         mExclusionList;
        varC0B04173BEBA2500AEBF48903299C3F4_1773792936.addTaint(taint);
        return varC0B04173BEBA2500AEBF48903299C3F4_1773792936;
        // ---------- Original Method ----------
        //return mExclusionList;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.165 -0400", hash_original_method = "BEF68745D535D943EDDB2DD96C1B6EA8", hash_generated_method = "A400141A9BAD1D5E50FFC8CB00FA76AC")
    private void setExclusionList(String exclusionList) {
        mExclusionList = exclusionList;
        if(mExclusionList == null)        
        {
            mParsedExclusionList = new String[0];
        } //End block
        else
        {
            String splitExclusionList[] = exclusionList.toLowerCase().split(",");
            mParsedExclusionList = new String[splitExclusionList.length * 2];
for(int i = 0;i < splitExclusionList.length;i++)
            {
                String s = splitExclusionList[i].trim();
                if(s.startsWith("."))                
                s = s.substring(1);
                mParsedExclusionList[i*2] = s;
                mParsedExclusionList[(i*2)+1] = "." + s;
            } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.165 -0400", hash_original_method = "72D2F326AF1444346066F9053B4FD5C0", hash_generated_method = "6B7833E8BE5837739DFCE21118DC0866")
    public boolean isExcluded(String url) {
        addTaint(url.getTaint());
        if(TextUtils.isEmpty(url) || mParsedExclusionList == null ||
                mParsedExclusionList.length == 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_859544152 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728061208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728061208;
        }
        Uri u = Uri.parse(url);
        String urlDomain = u.getHost();
        if(urlDomain == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_883667496 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892434635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_892434635;
        }
for(int i = 0;i< mParsedExclusionList.length;i+=2)
        {
            if(urlDomain.equals(mParsedExclusionList[i]) ||
                    urlDomain.endsWith(mParsedExclusionList[i+1]))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1205928016 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877697551 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877697551;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_374251486 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_293326450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_293326450;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.165 -0400", hash_original_method = "FF3E8127D15D936B6F66AB217E4EB9BA", hash_generated_method = "7BCBE7F11D16BAC8831D5BC02D558E76")
    public java.net.Proxy makeProxy() {
        java.net.Proxy proxy = java.net.Proxy.NO_PROXY;
        if(mHost != null)        
        {
            try 
            {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(mHost, mPort);
                proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, inetSocketAddress);
            } //End block
            catch (IllegalArgumentException e)
            {
            } //End block
        } //End block
java.net.Proxy var60FC9F22F7E863EBFD33B2ADB8462743_1586426084 =         proxy;
        var60FC9F22F7E863EBFD33B2ADB8462743_1586426084.addTaint(taint);
        return var60FC9F22F7E863EBFD33B2ADB8462743_1586426084;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.166 -0400", hash_original_method = "FE9AE719D0C3E87A445C3CEFBF6B38D6", hash_generated_method = "0B1E3CEA28013B15723FD1A04F2DDC78")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(mHost != null)        
        {
            sb.append("[");
            sb.append(mHost);
            sb.append("] ");
            sb.append(Integer.toString(mPort));
            if(mExclusionList != null)            
            {
                sb.append(" xl=").append(mExclusionList);
            } //End block
        } //End block
        else
        {
            sb.append("[ProxyProperties.mHost == null]");
        } //End block
String var2460B846747F8B22185AD8BE722266A5_986218408 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_986218408.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_986218408;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.166 -0400", hash_original_method = "16EB0AD501F97CC03F0A85B7200F0E73", hash_generated_method = "EC3A205C10E101180D3EAD090A62CD59")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof ProxyProperties))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1581270101 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219766209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_219766209;
        }
        ProxyProperties p = (ProxyProperties)o;
        if(mExclusionList != null && !mExclusionList.equals(p.getExclusionList()))        
        {
        boolean var68934A3E9455FA72420237EB05902327_951732334 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560104;
        }
        if(mHost != null && p.getHost() != null && mHost.equals(p.getHost()) == false)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1179913872 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534324609 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_534324609;
        } //End block
        if(mHost != null && p.mHost == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_708358128 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387154034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387154034;
        }
        if(mHost == null && p.mHost != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_349440270 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591256929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591256929;
        }
        if(mPort != p.mPort)        
        {
        boolean var68934A3E9455FA72420237EB05902327_846973596 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135388167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135388167;
        }
        boolean varB326B5062B2F0E69046810717534CB09_978382844 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253589981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253589981;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.166 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DD9252ED1831B5A44D1E8466C893F46F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2116146747 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363605850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363605850;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.166 -0400", hash_original_method = "AD2D5515FEDCF9B25A708B71445DFAB4", hash_generated_method = "CA87245FD03E13532EF5D73D8B2A831F")
    @Override
    public int hashCode() {
        int var6E4FB25E7D189C7F05CCFA475B81E741_1185118330 = (((null == mHost) ? 0 : mHost.hashCode())
        + ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        + mPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349948738 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349948738;
        // ---------- Original Method ----------
        //return ((null == mHost) ? 0 : mHost.hashCode())
        //+ ((null == mExclusionList) ? 0 : mExclusionList.hashCode())
        //+ mPort;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.166 -0400", hash_original_method = "038CE78D7B15BBF2D949EA22EA3CF00F", hash_generated_method = "0E5101B4C4C4BA18D5AB6C9E5FB78F2C")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        if(mHost != null)        
        {
            dest.writeByte((byte)1);
            dest.writeString(mHost);
            dest.writeInt(mPort);
        } //End block
        else
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.167 -0400", hash_original_field = "8C1BCA5A763B1D293459FDC94947A9DA", hash_generated_field = "37B61C5F5B74C5B267912D84DAC98E0A")

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
    // orphaned legacy method
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
    
    // orphaned legacy method
    public ProxyProperties[] newArray(int size) {
                return new ProxyProperties[size];
            }
    
}

