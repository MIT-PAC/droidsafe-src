package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;
import org.apache.http.params.BasicHttpParams;

public abstract class AbstractHttpMessage implements HttpMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.218 -0500", hash_original_field = "529E3541026CF32B6C0C26478EFC5931", hash_generated_field = "34FF19CD0855E5D63A04F524D7452FF4")
    
    protected HeaderGroup headergroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.220 -0500", hash_original_field = "E1952F00A693661EA0D1C7B3D836F77E", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")
    
    protected HttpParams params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.224 -0500", hash_original_method = "926C531625268700794509BCC2F5F77F", hash_generated_method = "808992296B67DCFFB65C67FF661B52D8")
    
protected AbstractHttpMessage(final HttpParams params) {
        super();
        this.headergroup = new HeaderGroup();
        this.params = params;
    }
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
	public AbstractHttpMessage() {
		// TODO Auto-generated constructor stub
	}

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.228 -0500", hash_original_method = "9EF327933AC8CF093A78CA62674DD20F", hash_generated_method = "C9C252F4E2BA959207E337864FFA8ECB")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public boolean containsHeader(String name) {
        return this.headergroup.containsHeader(name);
    }
    
    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.231 -0500", hash_original_method = "FE431DBB9584369B7EDB43E7189B0AE3", hash_generated_method = "06D68BCC15992B8E7B9F087D108EAED5")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public Header[] getHeaders(final String name) {
        return this.headergroup.getHeaders(name);
    }

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.235 -0500", hash_original_method = "4F426424B706B56A99E07E40B5C52BFA", hash_generated_method = "E3A65663A110CE4AF73D8E3E4793572F")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public Header getFirstHeader(final String name) {
        return this.headergroup.getFirstHeader(name);
    }

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.237 -0500", hash_original_method = "2D4239F1E5F9F68D789A00645007924A", hash_generated_method = "1C7199F50B6599704221CF89E6C228B7")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public Header getLastHeader(final String name) {
        return this.headergroup.getLastHeader(name);
    }
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
	public Header[] getAllHeaders() {
        return this.headergroup.getAllHeaders();
	}
    
    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.242 -0500", hash_original_method = "1DE731CFF4ECF4DBA0EF3FE32BB726E4", hash_generated_method = "353991C9C556FF2420F3A5952CCD0B0F")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void addHeader(final Header header) {
        this.headergroup.addHeader(header);
    }

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.245 -0500", hash_original_method = "4C12242853C02960B9FD442E279D83C0", hash_generated_method = "D123C766B9C3F2FA03DB4CB537C58272")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void addHeader(final String name, final String value) {
        if (name == null) {
            throw new IllegalArgumentException("Header name may not be null");
        }
        this.headergroup.addHeader(new BasicHeader(name, value));
    }

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.247 -0500", hash_original_method = "65F67011ED88E162C7A3317CC96C8B85", hash_generated_method = "1F76962701E5F1AB61425BB160BF84BA")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setHeader(final Header header) {
        this.headergroup.updateHeader(header);
    }

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.249 -0500", hash_original_method = "59EEDD7DD894E22B8BE3BEB8962485C4", hash_generated_method = "0CE00872F5D992DB82A7206CAD5781A4")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setHeader(final String name, final String value) {
        if (name == null) {
            throw new IllegalArgumentException("Header name may not be null");
        }
        this.headergroup.updateHeader(new BasicHeader(name, value));
    }

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.251 -0500", hash_original_method = "F77171669C40FC4A8C250022B7C99495", hash_generated_method = "4C07754C02D8A9912C87AB8FC93DD2FB")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setHeaders(final Header[] headers) {
        this.headergroup.setHeaders(headers);
    }

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.253 -0500", hash_original_method = "167D8764CCE16F3185A846BF9C0F5516", hash_generated_method = "A9567058BC5B1E9E2D657E7A5C0412AF")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void removeHeader(final Header header) {
        this.headergroup.removeHeader(header);
    }
    
    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.256 -0500", hash_original_method = "D7D4084B603700D250D598944C009D40", hash_generated_method = "7CD91FFFC31C13695A0CE9968BC5F169")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void removeHeaders(final String name) {
        if (name == null) {
            return;
        }
        for (Iterator i = this.headergroup.iterator(); i.hasNext(); ) {
            Header header = (Header) i.next();
            if (name.equalsIgnoreCase(header.getName())) {
                i.remove();
            }
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
	public HeaderIterator headerIterator() {
		// TODO Auto-generated method stub
		return headerIterator("<http-msg-param>");
	}

    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.260 -0500", hash_original_method = "68644A261C0F1E0602A67E0AF6E4CB07", hash_generated_method = "EC8C94962809592752A33357816EBB3C")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public HeaderIterator headerIterator(String name) {
        return this.headergroup.iterator(name);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
	public HttpParams getParams() {
		// TODO Auto-generated method stub
		return params;
	}
    
    // non-javadoc, see interface HttpMessage
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.265 -0500", hash_original_method = "1CAC19773CE7693AFF1DBB697E1BBCDE", hash_generated_method = "060FBE3A2EB6CD95D5F4AA990A31A021")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setParams(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.params = params;
    }

}

