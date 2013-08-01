package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

public abstract class AbstractHttpEntity implements HttpEntity {
    protected Header contentType;
    protected Header contentEncoding;
    protected boolean chunked;
    
    @DSModeled(DSC.SAFE)
	protected AbstractHttpEntity() {}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.751 -0400", hash_original_method = "DA5232C01B88DD776A78D6C1E0EF7DB4", hash_generated_method = "EF40BE92F22313642A74DF1065E07F14")
    public Header getContentType() {
Header varB33E79BD7783A8D6E8279F5398A07ECD_187706967 =         this.contentType;
        varB33E79BD7783A8D6E8279F5398A07ECD_187706967.addTaint(taint);
        return varB33E79BD7783A8D6E8279F5398A07ECD_187706967;
        // ---------- Original Method ----------
        //return this.contentType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.752 -0400", hash_original_method = "0300179EF34C28254565E1D29B0088D9", hash_generated_method = "06D2D50BE55D74BE2F0441205E61FF65")
    public Header getContentEncoding() {
Header var9FB76F0F7510CA91CDAC3C0B73E1BA5D_916294054 =         this.contentEncoding;
        var9FB76F0F7510CA91CDAC3C0B73E1BA5D_916294054.addTaint(taint);
        return var9FB76F0F7510CA91CDAC3C0B73E1BA5D_916294054;
        // ---------- Original Method ----------
        //return this.contentEncoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.753 -0400", hash_original_method = "A2E32B99DD6261F3B5CB31D5FA7FC0FC", hash_generated_method = "30C05184BB7AE12FD770F809B3E2BAC2")
    public boolean isChunked() {
        boolean varA9D5532A62E9998C758B235E369023D7_876992657 = (this.chunked);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1504308572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1504308572;
        // ---------- Original Method ----------
        //return this.chunked;
    }

    
    public void setContentType(final Header contentType) {
        this.contentType = contentType;
    }

    
    public void setContentType(final String ctString) {
        Header h = null;
        if (ctString != null) {
            h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        }
        setContentType(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.758 -0400", hash_original_method = "DEBEEA900825B0657525159073BC33A3", hash_generated_method = "1A414CB42618A24BED38C8E50DD477A0")
    public void setContentEncoding(final Header contentEncoding) {
        this.contentEncoding = contentEncoding;
        // ---------- Original Method ----------
        //this.contentEncoding = contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.759 -0400", hash_original_method = "C8D25A66722ADB2A8BE857D43D852F52", hash_generated_method = "BCEED26725CC5C466F41BFDBA7565B3E")
    public void setContentEncoding(final String ceString) {
        addTaint(ceString.getTaint());
        Header h = null;
        if(ceString != null)        
        {
            h = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        } //End block
        setContentEncoding(h);
        // ---------- Original Method ----------
        //Header h = null;
        //if (ceString != null) {
            //h = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        //}
        //setContentEncoding(h);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.760 -0400", hash_original_method = "1B88FA65FDF60169F373F298E33E777E", hash_generated_method = "31F89D88E68A040DC2DABC5362BEB7BE")
    public void setChunked(boolean b) {
        this.chunked = b;
        // ---------- Original Method ----------
        //this.chunked = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.761 -0400", hash_original_method = "3048E7043703056EA818491E1D9863FC", hash_generated_method = "B44CE0248CDEDF1EFB7806A7D7105F83")
    public void consumeContent() throws IOException, UnsupportedOperationException {
        if(isStreaming())        
        {
            UnsupportedOperationException var4BA6BB3E3C71762B9E04D03749812A8B_91810872 = new UnsupportedOperationException
                ("streaming entity does not implement consumeContent()");
            var4BA6BB3E3C71762B9E04D03749812A8B_91810872.addTaint(taint);
            throw var4BA6BB3E3C71762B9E04D03749812A8B_91810872;
        } //End block
        // ---------- Original Method ----------
        //if (isStreaming()) {
            //throw new UnsupportedOperationException
                //("streaming entity does not implement consumeContent()");
        //}
    }

    
}

