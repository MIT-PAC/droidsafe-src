package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;






public final class HttpHost implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.133 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.133 -0400", hash_original_field = "4B6994488E849D2EABC750D4A1DC0438", hash_generated_field = "21E874C75AB8261C3E938826C2C646D0")

    protected String lcHostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.133 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.133 -0400", hash_original_field = "018FE739B0B3B7545BA70D6D8A1BE0A6", hash_generated_field = "B9EB89391FD6A47F6CAEEA8A1467B77A")

    protected String schemeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.137 -0400", hash_original_method = "3BB513ACF90DB4E8549AF0CC3A6C9663", hash_generated_method = "9679D1A9D710BD3FA099F18632B28E91")
    public  HttpHost(final String hostname, int port, final String scheme) {
        super();
        if(hostname == null)        
        {
            IllegalArgumentException varA4A44E13AE8A327B609868CAE518C1E0_731471765 = new IllegalArgumentException("Host name may not be null");
            varA4A44E13AE8A327B609868CAE518C1E0_731471765.addTaint(taint);
            throw varA4A44E13AE8A327B609868CAE518C1E0_731471765;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.138 -0400", hash_original_method = "6AFEA0EBFC8A407A29450DC5B1D95F74", hash_generated_method = "67E5F1132B9AEC53F4513FF0855DCCC8")
    public  HttpHost(final String hostname, int port) {
        this(hostname, port, null);
        addTaint(port);
        addTaint(hostname.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.138 -0400", hash_original_method = "9E22BC6A820AFDDBFC5B86A2EC17A27A", hash_generated_method = "71E490F3361A1782307D755E40D7D695")
    public  HttpHost(final String hostname) {
        this(hostname, -1, null);
        addTaint(hostname.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.139 -0400", hash_original_method = "C44D4CD5D948E031A838C102F3C3F056", hash_generated_method = "2BC334727B51F49C4C42C8286E32572D")
    public  HttpHost(final HttpHost httphost) {
        this(httphost.hostname, httphost.port, httphost.schemeName);
        addTaint(httphost.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.140 -0400", hash_original_method = "FF0006634ABBE2C97788D559B23C884A", hash_generated_method = "11400882D5E7D3C6F7A4E219E594ECE2")
    public String getHostName() {
String varC616FC847D53CB735DD2A7C146C68762_184534669 =         this.hostname;
        varC616FC847D53CB735DD2A7C146C68762_184534669.addTaint(taint);
        return varC616FC847D53CB735DD2A7C146C68762_184534669;
        // ---------- Original Method ----------
        //return this.hostname;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.140 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "1700F49E7591C149327F8ECAE1D2A307")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_1782919514 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068692240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068692240;
        // ---------- Original Method ----------
        //return this.port;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.141 -0400", hash_original_method = "C6F0B2E3DB0F6FEAB7513E486FF6DA80", hash_generated_method = "D5E4F7CF000BA014CEEC35ADB15269D2")
    public String getSchemeName() {
String var8E0819DAE5908F45AA8F092100A40C0A_696592298 =         this.schemeName;
        var8E0819DAE5908F45AA8F092100A40C0A_696592298.addTaint(taint);
        return var8E0819DAE5908F45AA8F092100A40C0A_696592298;
        // ---------- Original Method ----------
        //return this.schemeName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.141 -0400", hash_original_method = "FE8B35DF3D2B1A5F77A96BBF48284914", hash_generated_method = "80451F027FD1B2D488F4621B1F988A16")
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
String varD03843288D33B9E1D3062E25339ECF6D_30388163 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_30388163.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_30388163;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.142 -0400", hash_original_method = "6DDBCACEAF7453CD975901EB7FA152DA", hash_generated_method = "64A4CF0FE6F330D2BD5ABC52051DB04D")
    public String toHostString() {
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        buffer.append(this.hostname);
        if(this.port != -1)        
        {
            buffer.append(':');
            buffer.append(Integer.toString(this.port));
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_752338645 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_752338645.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_752338645;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(32);
        //buffer.append(this.hostname);
        //if (this.port != -1) {
            //buffer.append(':');
            //buffer.append(Integer.toString(this.port));
        //}
        //return buffer.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.142 -0400", hash_original_method = "C17018EEDA4C922BB5D288F6A26A7D04", hash_generated_method = "97980D7048BC26C17EF291C11352FFA7")
    public String toString() {
String var0A55F081974ADC5A13D4B31BB63BD3D0_2111204369 =         toURI();
        var0A55F081974ADC5A13D4B31BB63BD3D0_2111204369.addTaint(taint);
        return var0A55F081974ADC5A13D4B31BB63BD3D0_2111204369;
        // ---------- Original Method ----------
        //return toURI();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.143 -0400", hash_original_method = "C7D67D79CD52B2E28D96292DEF9F8BD7", hash_generated_method = "8CF70F7653F086F7EBAB0EDFB65FA6F5")
    public boolean equals(final Object obj) {
        addTaint(obj.getTaint());
        if(obj == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1839802867 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231821845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231821845;
        }
        if(this == obj)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1250158287 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170558125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170558125;
        }
        if(obj instanceof HttpHost)        
        {
            HttpHost that = (HttpHost) obj;
            boolean varF9A4D7BBBA4836465E9C93E55728A6F1_1355881887 = (this.lcHostname.equals(that.lcHostname) 
                && this.port == that.port
                && this.schemeName.equals(that.schemeName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258823266 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258823266;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1359135689 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549555639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_549555639;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.144 -0400", hash_original_method = "148EB8E2858B696FB463985EE3E49929", hash_generated_method = "8425E327EFF8CBD9DDFBD09A61395981")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.lcHostname);
        hash = LangUtils.hashCode(hash, this.port);
        hash = LangUtils.hashCode(hash, this.schemeName);
        int var0800FC577294C34E0B28AD2839435945_773258612 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_976113742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_976113742;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.lcHostname);
        //hash = LangUtils.hashCode(hash, this.port);
        //hash = LangUtils.hashCode(hash, this.schemeName);
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.144 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "C1FC1DCC05F010CD78785EB587335C4D")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1276748610 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1276748610.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1276748610;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.144 -0400", hash_original_field = "FDEFA474EEB9B01BE6ECDD1CD4865451", hash_generated_field = "BC4AB09F492BB8FF3AF2DDEA94F3ED6C")

    public static final String DEFAULT_SCHEME_NAME = "http";
}

