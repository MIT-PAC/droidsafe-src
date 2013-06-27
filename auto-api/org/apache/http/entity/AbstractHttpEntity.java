package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

public abstract class AbstractHttpEntity implements HttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.835 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "7707552268699116A6B81DCAB1E039E0")

    protected Header contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.835 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "EE4016A6B9EC527F15082EA3FB92CF90")

    protected Header contentEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.835 -0400", hash_original_field = "DFAB03D14C0C8E9BD80B4D5DB07170D3", hash_generated_field = "AC5AAC899B99DDB88A53898F83C297BE")

    protected boolean chunked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.836 -0400", hash_original_method = "7092D401475F156326EB612012D50800", hash_generated_method = "8090890FE04071B33C38618871FDA9FD")
    protected  AbstractHttpEntity() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.836 -0400", hash_original_method = "DA5232C01B88DD776A78D6C1E0EF7DB4", hash_generated_method = "1535E0EB3931793AD9569FD34010680A")
    public Header getContentType() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1434701086 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1434701086 = this.contentType;
        varB4EAC82CA7396A68D541C85D26508E83_1434701086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434701086;
        // ---------- Original Method ----------
        //return this.contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.840 -0400", hash_original_method = "0300179EF34C28254565E1D29B0088D9", hash_generated_method = "81D94B826BBFD04574759A2A44ED4FE8")
    public Header getContentEncoding() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1473130820 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1473130820 = this.contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1473130820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1473130820;
        // ---------- Original Method ----------
        //return this.contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.840 -0400", hash_original_method = "A2E32B99DD6261F3B5CB31D5FA7FC0FC", hash_generated_method = "DC74434310643013825D6A26C5D05B6D")
    public boolean isChunked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689622981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689622981;
        // ---------- Original Method ----------
        //return this.chunked;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.841 -0400", hash_original_method = "2A50843ADF5A0160EFC9E5758FE12891", hash_generated_method = "513E2D2C622089B4C38694763A24458C")
    public void setContentType(final Header contentType) {
        this.contentType = contentType;
        // ---------- Original Method ----------
        //this.contentType = contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.846 -0400", hash_original_method = "E88DF46252A0D3C2D0E67C1F492FFB2C", hash_generated_method = "2F7AC1256B2000812DC9BA9882FD051F")
    public void setContentType(final String ctString) {
        Header h;
        h = null;
        {
            h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        } //End block
        setContentType(h);
        addTaint(ctString.getTaint());
        // ---------- Original Method ----------
        //Header h = null;
        //if (ctString != null) {
            //h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        //}
        //setContentType(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.847 -0400", hash_original_method = "DEBEEA900825B0657525159073BC33A3", hash_generated_method = "1A414CB42618A24BED38C8E50DD477A0")
    public void setContentEncoding(final Header contentEncoding) {
        this.contentEncoding = contentEncoding;
        // ---------- Original Method ----------
        //this.contentEncoding = contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.847 -0400", hash_original_method = "C8D25A66722ADB2A8BE857D43D852F52", hash_generated_method = "7B0340BC0DFD28F4EA36679DE4F4E30C")
    public void setContentEncoding(final String ceString) {
        Header h;
        h = null;
        {
            h = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        } //End block
        setContentEncoding(h);
        addTaint(ceString.getTaint());
        // ---------- Original Method ----------
        //Header h = null;
        //if (ceString != null) {
            //h = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        //}
        //setContentEncoding(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.847 -0400", hash_original_method = "1B88FA65FDF60169F373F298E33E777E", hash_generated_method = "31F89D88E68A040DC2DABC5362BEB7BE")
    public void setChunked(boolean b) {
        this.chunked = b;
        // ---------- Original Method ----------
        //this.chunked = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.866 -0400", hash_original_method = "3048E7043703056EA818491E1D9863FC", hash_generated_method = "02F78BA5F68042C7964BB76C5662C345")
    public void consumeContent() throws IOException, UnsupportedOperationException {
        {
            boolean var72EBA2DE13150A13520A1CB39AEB2004_1654001105 = (isStreaming());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException
                ("streaming entity does not implement consumeContent()");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isStreaming()) {
            //throw new UnsupportedOperationException
                //("streaming entity does not implement consumeContent()");
        //}
    }

    
}

