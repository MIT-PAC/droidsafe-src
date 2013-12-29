package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;

import javax.sip.address.URI;






public class RequestLine extends SIPObject implements SipRequestLine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.936 -0500", hash_original_field = "1D23EDFC276CA31BFE3F364D7A71C4E9", hash_generated_field = "ED5F8AB740667ACC3F117C961E7750C6")

    private static final long serialVersionUID = -3286426172326043129L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.937 -0500", hash_original_field = "301DE89A58C4FF637054844336681A92", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.939 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.940 -0500", hash_original_field = "CE1553CBFC9C6BF901CA3EFBFD71C841", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.941 -0500", hash_original_method = "E4B7F4B41910EC919E5F140217342F7C", hash_generated_method = "0C3AC04EB0C8B36380A7117E78C5276B")
    public RequestLine() {
        sipVersion = "SIP/2.0";
    }

    /** Constructor given the request URI and the method.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.945 -0500", hash_original_method = "FF0843F55ACEC2A8E2B69A1885A4A70E", hash_generated_method = "021C6E46A9441F0E8B72A9E3A3F22E70")
    public RequestLine(GenericURI requestURI, String method) {
        this.uri = requestURI;
        this.method = method;
        this.sipVersion = "SIP/2.0";
    }

   
    /** Encode the request line as a String.
    *
     * @return requestLine encoded as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.942 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.943 -0500", hash_original_method = "4F6DB28D47CD31A53DCF9FC226D5B630", hash_generated_method = "40AEC8575F20BE624923B0DF4AB0F2E8")
    public StringBuffer encode(StringBuffer buffer) {
        if (method != null) {
            buffer.append(method);
            buffer.append(SP);
        }
        if (uri != null) {
            uri.encode(buffer);
            buffer.append(SP);
        }
        buffer.append(sipVersion);
        buffer.append(NEWLINE);
        return buffer;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getUri()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.944 -0500", hash_original_method = "F87CE2D8FFE3E61DA8A4BD8B0BDA0697", hash_generated_method = "ED3D81A0DF2E489D77E3CFF96334234F")
    public GenericURI getUri() {
        return uri;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getMethod()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.946 -0500", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "BC38B478E0AED2517A3460750CABA307")
    public String getMethod() {
        return method;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getSipVersion()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.947 -0500", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "7635A3ADA2875913277DA776A6504B01")
    public String getSipVersion() {
        return sipVersion;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#setUri(gov.nist.javax.sip.address.GenericURI)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.948 -0500", hash_original_method = "E1410A4CC0BAAD1440D0D1F349F6B893", hash_generated_method = "8035294072322FC4F6F0BD50AF522DD9")
    public void setUri(URI uri) {
        this.uri = (GenericURI)uri;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#setMethod(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.949 -0500", hash_original_method = "190C52163DA3AE651D57D1F9409B666E", hash_generated_method = "E0D74BFAE23F23561EFCCA871D8C9B90")
    public void setMethod(String method) {
        this.method = method;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#setSipVersion(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.950 -0500", hash_original_method = "1D61DBA7A6626C97B8FBAF50D3DDD562", hash_generated_method = "5CBB1B0455D6A559F03A690FE53AA3E3")
    public void setSipVersion(String version) {
        this.sipVersion = version;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getVersionMajor()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.951 -0500", hash_original_method = "4D5FB483F06B9DEED18B900A5129C79B", hash_generated_method = "9BC8B56F13A145D6334560377EA214D5")
    public String getVersionMajor() {
        if (sipVersion == null)
            return null;
        String major = null;
        boolean slash = false;
        for (int i = 0; i < sipVersion.length(); i++) {
            if (sipVersion.charAt(i) == '.')
                break;
            if (slash) {
                if (major == null)
                    major = "" + sipVersion.charAt(i);
                else
                    major += sipVersion.charAt(i);
            }
            if (sipVersion.charAt(i) == '/')
                slash = true;
        }
        return major;
    }

    /* (non-Javadoc)
     * @see gov.nist.javax.sip.header.SipRequestLine#getVersionMinor()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.952 -0500", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "6EA6974F2F8CEB1964A391173266EFF2")
    public String getVersionMinor() {
        if (sipVersion == null)
            return null;
        String minor = null;
        boolean dot = false;
        for (int i = 0; i < sipVersion.length(); i++) {
            if (dot) {
                if (minor == null)
                    minor = "" + sipVersion.charAt(i);
                else
                    minor += sipVersion.charAt(i);
            }
            if (sipVersion.charAt(i) == '.')
                dot = true;
        }
        return minor;
    }

    /**
    * Compare for equality.
    *
    *@param other object to compare with. We assume that all fields
    * are set.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.953 -0500", hash_original_method = "1239840CE17889EA14CF87055D293638", hash_generated_method = "B6ABF3CF04C7903483B84BB8675BEEB1")
    public boolean equals(Object other) {
        boolean retval;
        if (!other.getClass().equals(this.getClass())) {
            return false;
        }
        RequestLine that = (RequestLine) other;
        try {
            retval =
                this.method.equals(that.method)
                    && this.uri.equals(that.uri)
                    && this.sipVersion.equals(that.sipVersion);
        } catch (NullPointerException ex) {
            retval = false;
        }
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.954 -0500", hash_original_method = "6B13CE61BDAF8DDF9CB0869D09E1BD0F", hash_generated_method = "ED54138F64CE7B2D61E53C7BA7B4C189")
    public Object clone() {
        RequestLine retval = (RequestLine) super.clone();
        if (this.uri != null)
            retval.uri = (GenericURI) this.uri.clone();
        return retval;
    }
}

