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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.894 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "7707552268699116A6B81DCAB1E039E0")

    protected Header contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.894 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "EE4016A6B9EC527F15082EA3FB92CF90")

    protected Header contentEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.894 -0400", hash_original_field = "DFAB03D14C0C8E9BD80B4D5DB07170D3", hash_generated_field = "AC5AAC899B99DDB88A53898F83C297BE")

    protected boolean chunked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.895 -0400", hash_original_method = "7092D401475F156326EB612012D50800", hash_generated_method = "8090890FE04071B33C38618871FDA9FD")
    protected  AbstractHttpEntity() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.895 -0400", hash_original_method = "DA5232C01B88DD776A78D6C1E0EF7DB4", hash_generated_method = "BB289FC44C370B8868065E8C9F59C6A3")
    public Header getContentType() {
Header varB33E79BD7783A8D6E8279F5398A07ECD_1651965423 =         this.contentType;
        varB33E79BD7783A8D6E8279F5398A07ECD_1651965423.addTaint(taint);
        return varB33E79BD7783A8D6E8279F5398A07ECD_1651965423;
        // ---------- Original Method ----------
        //return this.contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.896 -0400", hash_original_method = "0300179EF34C28254565E1D29B0088D9", hash_generated_method = "BFCDE4DD976D5F64F69FB8E3DCD18F20")
    public Header getContentEncoding() {
Header var9FB76F0F7510CA91CDAC3C0B73E1BA5D_785934099 =         this.contentEncoding;
        var9FB76F0F7510CA91CDAC3C0B73E1BA5D_785934099.addTaint(taint);
        return var9FB76F0F7510CA91CDAC3C0B73E1BA5D_785934099;
        // ---------- Original Method ----------
        //return this.contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.896 -0400", hash_original_method = "A2E32B99DD6261F3B5CB31D5FA7FC0FC", hash_generated_method = "67660BE7AC7D2A5F5D142E095DD13E3D")
    public boolean isChunked() {
        boolean varA9D5532A62E9998C758B235E369023D7_777957248 = (this.chunked);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221938071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221938071;
        // ---------- Original Method ----------
        //return this.chunked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.897 -0400", hash_original_method = "2A50843ADF5A0160EFC9E5758FE12891", hash_generated_method = "513E2D2C622089B4C38694763A24458C")
    public void setContentType(final Header contentType) {
        this.contentType = contentType;
        // ---------- Original Method ----------
        //this.contentType = contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.897 -0400", hash_original_method = "E88DF46252A0D3C2D0E67C1F492FFB2C", hash_generated_method = "55C2748AF2194704F0493D38A1BC7AD1")
    public void setContentType(final String ctString) {
        addTaint(ctString.getTaint());
        Header h = null;
    if(ctString != null)        
        {
            h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        } //End block
        setContentType(h);
        // ---------- Original Method ----------
        //Header h = null;
        //if (ctString != null) {
            //h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        //}
        //setContentType(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.898 -0400", hash_original_method = "DEBEEA900825B0657525159073BC33A3", hash_generated_method = "1A414CB42618A24BED38C8E50DD477A0")
    public void setContentEncoding(final Header contentEncoding) {
        this.contentEncoding = contentEncoding;
        // ---------- Original Method ----------
        //this.contentEncoding = contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.898 -0400", hash_original_method = "C8D25A66722ADB2A8BE857D43D852F52", hash_generated_method = "BCEED26725CC5C466F41BFDBA7565B3E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.898 -0400", hash_original_method = "1B88FA65FDF60169F373F298E33E777E", hash_generated_method = "31F89D88E68A040DC2DABC5362BEB7BE")
    public void setChunked(boolean b) {
        this.chunked = b;
        // ---------- Original Method ----------
        //this.chunked = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.899 -0400", hash_original_method = "3048E7043703056EA818491E1D9863FC", hash_generated_method = "2744BF8E9E865DE2DE469F6A2B408B19")
    public void consumeContent() throws IOException, UnsupportedOperationException {
    if(isStreaming())        
        {
            UnsupportedOperationException var4BA6BB3E3C71762B9E04D03749812A8B_1528422182 = new UnsupportedOperationException
                ("streaming entity does not implement consumeContent()");
            var4BA6BB3E3C71762B9E04D03749812A8B_1528422182.addTaint(taint);
            throw var4BA6BB3E3C71762B9E04D03749812A8B_1528422182;
        } //End block
        // ---------- Original Method ----------
        //if (isStreaming()) {
            //throw new UnsupportedOperationException
                //("streaming entity does not implement consumeContent()");
        //}
    }

    
}

