package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public final class HttpHost implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.891 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.891 -0400", hash_original_field = "4B6994488E849D2EABC750D4A1DC0438", hash_generated_field = "21E874C75AB8261C3E938826C2C646D0")

    protected String lcHostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.892 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.892 -0400", hash_original_field = "018FE739B0B3B7545BA70D6D8A1BE0A6", hash_generated_field = "B9EB89391FD6A47F6CAEEA8A1467B77A")

    protected String schemeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.893 -0400", hash_original_method = "3BB513ACF90DB4E8549AF0CC3A6C9663", hash_generated_method = "1A449DF94A76DCEDBE5246168251E9D5")
    public  HttpHost(final String hostname, int port, final String scheme) {
        super();
    if(hostname == null)        
        {
            IllegalArgumentException varA4A44E13AE8A327B609868CAE518C1E0_66423103 = new IllegalArgumentException("Host name may not be null");
            varA4A44E13AE8A327B609868CAE518C1E0_66423103.addTaint(taint);
            throw varA4A44E13AE8A327B609868CAE518C1E0_66423103;
        } //End block
        this.hostname   = hostname;
        this.lcHostname = hostname.toLowerCase(Locale.ENGLISH);
    if(scheme != null)        
        {
            this.schemeName = scheme.toLowerCase(Locale.ENGLISH);
        } //End block
        else
        {
            this.schemeName = DEFAULT_SCHEME_NAME;
        } //End block
        this.port = port;
        // ---------- Original Method ----------
        //if (hostname == null) {
            //throw new IllegalArgumentException("Host name may not be null");
        //}
        //this.hostname   = hostname;
        //this.lcHostname = hostname.toLowerCase(Locale.ENGLISH);
        //if (scheme != null) {
            //this.schemeName = scheme.toLowerCase(Locale.ENGLISH);
        //} else {
            //this.schemeName = DEFAULT_SCHEME_NAME;
        //}
        //this.port = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.894 -0400", hash_original_method = "6AFEA0EBFC8A407A29450DC5B1D95F74", hash_generated_method = "67E5F1132B9AEC53F4513FF0855DCCC8")
    public  HttpHost(final String hostname, int port) {
        this(hostname, port, null);
        addTaint(port);
        addTaint(hostname.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.895 -0400", hash_original_method = "9E22BC6A820AFDDBFC5B86A2EC17A27A", hash_generated_method = "71E490F3361A1782307D755E40D7D695")
    public  HttpHost(final String hostname) {
        this(hostname, -1, null);
        addTaint(hostname.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.895 -0400", hash_original_method = "C44D4CD5D948E031A838C102F3C3F056", hash_generated_method = "2BC334727B51F49C4C42C8286E32572D")
    public  HttpHost(final HttpHost httphost) {
        this(httphost.hostname, httphost.port, httphost.schemeName);
        addTaint(httphost.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.895 -0400", hash_original_method = "FF0006634ABBE2C97788D559B23C884A", hash_generated_method = "AF9301A742341A04B15C0824D8E44ADC")
    public String getHostName() {
String varC616FC847D53CB735DD2A7C146C68762_1084382416 =         this.hostname;
        varC616FC847D53CB735DD2A7C146C68762_1084382416.addTaint(taint);
        return varC616FC847D53CB735DD2A7C146C68762_1084382416;
        // ---------- Original Method ----------
        //return this.hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.895 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "92F9DDBAFC6650DBAE3CED4AB3D9D34A")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_1001654610 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304265239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304265239;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.896 -0400", hash_original_method = "C6F0B2E3DB0F6FEAB7513E486FF6DA80", hash_generated_method = "C94BB49750BE2EFDB871FD4B4E682988")
    public String getSchemeName() {
String var8E0819DAE5908F45AA8F092100A40C0A_852489329 =         this.schemeName;
        var8E0819DAE5908F45AA8F092100A40C0A_852489329.addTaint(taint);
        return var8E0819DAE5908F45AA8F092100A40C0A_852489329;
        // ---------- Original Method ----------
        //return this.schemeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.896 -0400", hash_original_method = "FE8B35DF3D2B1A5F77A96BBF48284914", hash_generated_method = "3EB6117D3FD1527D59EB59AF444255D4")
    public String toURI() {
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        buffer.append(this.schemeName);
        buffer.append("://");
        buffer.append(this.hostname);
    if(this.port != -1)        
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_2077678530 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_2077678530.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_2077678530;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(32);
        //buffer.append(this.schemeName);
        //buffer.append("://");
        //buffer.append(this.hostname);
        //if (this.port != -1) {
            //buffer.append(':');
            //buffer.append(Integer.toString(this.port));
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.896 -0400", hash_original_method = "6DDBCACEAF7453CD975901EB7FA152DA", hash_generated_method = "1E2FF9651B4714174CBD2F930AC7CD8A")
    public String toHostString() {
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        buffer.append(this.hostname);
    if(this.port != -1)        
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_1629783776 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1629783776.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1629783776;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(32);
        //buffer.append(this.hostname);
        //if (this.port != -1) {
            //buffer.append(':');
            //buffer.append(Integer.toString(this.port));
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.896 -0400", hash_original_method = "C17018EEDA4C922BB5D288F6A26A7D04", hash_generated_method = "716DFD01AEEF0727FB8C54D5F046B3D0")
    public String toString() {
String var0A55F081974ADC5A13D4B31BB63BD3D0_1029765884 =         toURI();
        var0A55F081974ADC5A13D4B31BB63BD3D0_1029765884.addTaint(taint);
        return var0A55F081974ADC5A13D4B31BB63BD3D0_1029765884;
        // ---------- Original Method ----------
        //return toURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.897 -0400", hash_original_method = "C7D67D79CD52B2E28D96292DEF9F8BD7", hash_generated_method = "AB56D0896C1419D3D2AC6A544F060C4C")
    public boolean equals(final Object obj) {
        addTaint(obj.getTaint());
    if(obj == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1881449604 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416449387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416449387;
        }
    if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1248803325 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753736377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_753736377;
        }
    if(obj instanceof HttpHost)        
        {
            HttpHost that = (HttpHost) obj;
            boolean varF9A4D7BBBA4836465E9C93E55728A6F1_867380626 = (this.lcHostname.equals(that.lcHostname) 
                && this.port == that.port
                && this.schemeName.equals(that.schemeName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206694416 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206694416;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_539735113 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514199139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_514199139;
        } //End block
        // ---------- Original Method ----------
        //if (obj == null) return false;
        //if (this == obj) return true;
        //if (obj instanceof HttpHost) {
            //HttpHost that = (HttpHost) obj;
            //return this.lcHostname.equals(that.lcHostname) 
                //&& this.port == that.port
                //&& this.schemeName.equals(that.schemeName);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.898 -0400", hash_original_method = "148EB8E2858B696FB463985EE3E49929", hash_generated_method = "70EAC6FB11F46DE646C835535735E787")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.lcHostname);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.schemeName);
        int var0800FC577294C34E0B28AD2839435945_1543395323 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862012253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862012253;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.lcHostname);
        //hash = LangUtils.hashCode(hash, this.port);
        //hash = LangUtils.hashCode(hash, this.schemeName);
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.898 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "51CAA862E8FEDC2B753F176846CE10D5")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_675103916 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_675103916.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_675103916;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.898 -0400", hash_original_field = "FDEFA474EEB9B01BE6ECDD1CD4865451", hash_generated_field = "BC4AB09F492BB8FF3AF2DDEA94F3ED6C")

    public static final String DEFAULT_SCHEME_NAME = "http";
}

