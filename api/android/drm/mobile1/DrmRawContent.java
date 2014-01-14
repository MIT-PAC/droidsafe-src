package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DrmRawContent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.292 -0500", hash_original_field = "FAE08528D4AE89FDF2D83D608F2B7B1C", hash_generated_field = "29181C4D953A39C351B8C01664607777")

    public static final String DRM_MIMETYPE_MESSAGE_STRING = "application/vnd.oma.drm.message";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.294 -0500", hash_original_field = "BEDC821F04954040E7FB7B9D3C82DA7A", hash_generated_field = "BD795434A76D303A889FDEE440B9A38D")

    public static final String DRM_MIMETYPE_CONTENT_STRING = "application/vnd.oma.drm.content";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.297 -0500", hash_original_field = "F4CA0F2CA21D70C790FFB41B8681C21B", hash_generated_field = "BE75013ACBBFB578DD0D79AA8B030FDD")

    public static final int DRM_FORWARD_LOCK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.299 -0500", hash_original_field = "01EA4D34472D4E38278AD0177CA768D1", hash_generated_field = "4BF6251F8F423A87A7453D2F3EE60637")

    public static final int DRM_COMBINED_DELIVERY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.302 -0500", hash_original_field = "0019905A961DFDCDD9F76E3699EA026A", hash_generated_field = "FCF82C97F26D5D315B6F34A5C28873E0")

    public static final int DRM_SEPARATE_DELIVERY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.304 -0500", hash_original_field = "10D395FC26C1382A2BE8192184185EEE", hash_generated_field = "A770CEF0324BA4B3D13C058366063385")

    public static final int DRM_SEPARATE_DELIVERY_DM = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.307 -0500", hash_original_field = "536377E134667DDFE9DC8C8A38734612", hash_generated_field = "71B094D9F60A448ABA482B2A442A14B2")

    public static final int DRM_UNKNOWN_DATA_LEN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.310 -0500", hash_original_field = "D345246C87E6D4404981829D98CE75C3", hash_generated_field = "98083C2F2BCD6A089C4D9DF2D1E75981")

    private static final int DRM_MIMETYPE_MESSAGE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.313 -0500", hash_original_field = "72BE048B13C8083EF5FD305950BB229D", hash_generated_field = "E725C855FB7FE62F795595C2E189FF67")

    private static final int DRM_MIMETYPE_CONTENT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.315 -0500", hash_original_field = "FF738810C6AC45A69932287AFA098725", hash_generated_field = "25E0D3E71BAEFA88E14AB25E5D0E168C")

    private static final int JNI_DRM_SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.317 -0500", hash_original_field = "37BEA82E28CB1C34F8EBE2B3C4DE18F8", hash_generated_field = "E53DB537690563C59F99436A7DB3F114")

    private static final int JNI_DRM_FAILURE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.320 -0500", hash_original_field = "BEE154435135E8E0EF8A37BC6E78D5E2", hash_generated_field = "67E46112BDC89D140887F40C5BD4DE7D")

    private static final int JNI_DRM_EOF = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.322 -0500", hash_original_field = "BC76FEFF24007071618BC4E58C6DBADA", hash_generated_field = "B332F11E3A55D2D327F1A2362D31A7AA")

    private static final int JNI_DRM_UNKNOWN_DATA_LEN = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.324 -0500", hash_original_field = "BBF099965A5EEE25CFCF5224EFAF978C", hash_generated_field = "A35457D5EC6175629B73FEE1B6FC7118")

    private BufferedInputStream inData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.327 -0500", hash_original_field = "BD974066A8F92FBA13712AE7253E2DF4", hash_generated_field = "7857E9BFAB78C608EC1696A66F8974D8")

    private int inDataLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.329 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "D0FAB3735D60E909B66356CA0D9609D4")

    private int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.332 -0500", hash_original_field = "89C4B20A91B662E5812D34AF6AB9161C", hash_generated_field = "4877FDB686907EE9662E107E49F39E17")

    private String rightsIssuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.334 -0500", hash_original_field = "A0E69A6EE5F0E365A04496F51D58E52D", hash_generated_field = "C674ADD25B97CF9C03558A1EC7937BAD")

    private String mediaType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.336 -0500", hash_original_field = "796FD106AB1D7F5DCE9144A88FC7E265", hash_generated_field = "ED45BCA90194A65359E902CD54F1901B")

    private int rawType;
    
    class DrmInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.354 -0500", hash_original_field = "FF1318BD7B381B7887A6EEC627EFEF6C", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

        private boolean isClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.357 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.359 -0500", hash_original_field = "C66D25F656201C017C902BF4484CCECC", hash_generated_field = "A9C85E0E8E361BA26D5E816C01AD5FF6")

        private byte[] b;

        /**
         * Construct a DrmInputStream instance.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.362 -0500", hash_original_method = "757FC08885175457E85C9AB1294F9204", hash_generated_method = "60EC476456FAA597E0E3D6EF5D2BCBF4")
        
public DrmInputStream(DrmRights rights) {
            /**
             * Because currently the media object associate with rights object
             * has been handled in native logic, so here it is not need to deal
             * the rights. But for the apps, it is mandatory for user to get
             * the rights object before get the media content data.
             */

            isClosed = false;
            offset = 0;
            b = new byte[1];
        }

        /* Non-javadoc
         * @see java.io.InputStream#available()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.364 -0500", hash_original_method = "DD7664962C7714C7E289B90A25098018", hash_generated_method = "5E8745AA7EC50347CF05BF3586E3857F")
        
public int available() throws IOException {
            /* call native method to get this DRM decrypted media content length */
            int len = nativeGetContentLength();

            if (JNI_DRM_FAILURE == len)
                throw new IOException();

            /* if the length is unknown, just return 0 for available value */
            if (JNI_DRM_UNKNOWN_DATA_LEN == len)
                return 0;

            int availableLen = len - offset;
            if (availableLen < 0)
                throw new IOException();

            return availableLen;
        }

        /* Non-javadoc
         * @see java.io.InputStream#read()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.367 -0500", hash_original_method = "287241C29465CA302A7D4AC4EAA3FF8F", hash_generated_method = "0E29C605E7DB5EFCB46408A5A48F143A")
        
public int read() throws IOException {
            int res;

            res = read(b, 0, 1);

            if (-1 == res)
                return -1;

            return b[0] & 0xff;
        }

        /* Non-javadoc
         * @see java.io.InputStream#read(byte)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.370 -0500", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "E0F9C5B343EA0376178403393DBFABB2")
        
public int read(byte[] b) throws IOException {
            return read(b, 0, b.length);
        }

        /* Non-javadoc
         * @see java.io.InputStream#read(byte, int, int)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.373 -0500", hash_original_method = "E3473D498149E2AB489389364DA9079E", hash_generated_method = "B7C55B3E70C5FC955FFDD66F7CBECC55")
        
public int read(byte[] b, int off, int len) throws IOException {
            if (null == b)
                throw new NullPointerException();
            if (off < 0 || len < 0 || off + len > b.length)
                throw new IndexOutOfBoundsException();
            if (true == isClosed)
                throw new IOException();

            if (0 == len)
                return 0;

            len = nativeReadContent(b, off, len, offset);

            if (JNI_DRM_FAILURE == len)
                throw new IOException();
            else if (JNI_DRM_EOF == len)
                return -1;

            offset += len;

            return len;
        }

        /* Non-javadoc
         * @see java.io.InputStream#markSupported()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.375 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "68CB0655189E46325916378CAE21EACC")
        
public boolean markSupported() {
            return false;
        }

        /* Non-javadoc
         * @see java.io.InputStream#mark(int)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.378 -0500", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "561B12231EF8492BA6CD36D053E70C35")
        
public void mark(int readlimit) {
        }

        /* Non-javadoc
         * @see java.io.InputStream#reset()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.380 -0500", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "905AD4216897ED858D0A370D64D237D3")
        
public void reset() throws IOException {
            throw new IOException();
        }

        /* Non-javadoc
         * @see java.io.InputStream#skip()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.382 -0500", hash_original_method = "373BCB0654FCF6410EF04A71B1FD669C", hash_generated_method = "6819F67050416C03BFAA1CF65FCAE7C9")
        
public long skip(long n) throws IOException {
            return 0;
        }

        /* Non-javadoc
         * @see java.io.InputStream#close()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.385 -0500", hash_original_method = "10D4C3BAF156E237AD0273689BD4B9BB", hash_generated_method = "FE341F2CD57CC8E7714B3A32EBC33782")
        
public void close() {
            isClosed = true;
        }
        
    }

    /**
     * Construct a DrmRawContent object.
     *
     * @param inRawdata     object of DRM raw data stream.
     * @param len           the length of raw data can be read.
     * @param mimeTypeStr   the mime type of the DRM content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.339 -0500", hash_original_method = "48C7554EE3F27E9D89A6C35F1696C3B9", hash_generated_method = "7AABE886225F9C3DFAC6A2DE91418981")
    
public DrmRawContent(InputStream inRawdata, int len, String mimeTypeStr) throws DrmException, IOException {
        int mimeType;

        id = -1;
        inData = new BufferedInputStream(inRawdata, 1024);
        inDataLen = len;

        if (DRM_MIMETYPE_MESSAGE_STRING.equals(mimeTypeStr))
            mimeType = DRM_MIMETYPE_MESSAGE;
        else if (DRM_MIMETYPE_CONTENT_STRING.equals(mimeTypeStr))
            mimeType = DRM_MIMETYPE_CONTENT;
        else
            throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT");

        if (len <= 0)
            throw new IllegalArgumentException("len must be > 0");

        /* call native method to initialize this DRM content */
        id = nativeConstructDrmContent(inData, inDataLen, mimeType);

        if (JNI_DRM_FAILURE == id)
            throw new DrmException("nativeConstructDrmContent() returned JNI_DRM_FAILURE");

        /* init the rights issuer field. */
        rightsIssuer = nativeGetRightsAddress();

        /* init the raw content type. */
        rawType = nativeGetDeliveryMethod();
        if (JNI_DRM_FAILURE == rawType)
            throw new DrmException("nativeGetDeliveryMethod() returned JNI_DRM_FAILURE");

        /* init the media content type. */
        mediaType = nativeGetContentType();
        if (null == mediaType)
            throw new DrmException("nativeGetContentType() returned null");
    }

    /**
     * Get rights address from raw Seperate Delivery content.
     *
     * @return the string of the rights issuer address,
     *         or null if no rights issuer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.342 -0500", hash_original_method = "DA61D867171B37EBE3ABF3A7818C6279", hash_generated_method = "BAF945A948D601852002C1C4EF920F52")
    
public String getRightsAddress() {
        return rightsIssuer;
    }

    /**
     * Get the type of the raw DRM content.
     *
     * @return one of the following delivery type of this DRM content:
     *              #DRM_FORWARD_LOCK
     *              #DRM_COMBINED_DELIVERY
     *              #DRM_SEPARATE_DELIVERY
     *              #DRM_SEPARATE_DELIVERY_DM
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.344 -0500", hash_original_method = "D6292E91B10AADE74CDCC0EA78647873", hash_generated_method = "8C1C518EC52B312FC5111DD9711CC9DC")
    
public int getRawType() {
        return rawType;
    }

    /**
     * Get one InputStream object to read decrypted content.
     *
     * @param rights        the rights object contain decrypted key.
     *
     * @return the InputStream object of decrypted media content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.346 -0500", hash_original_method = "3A81FD63CF04F4BFFAA8D4F0C3F30C0B", hash_generated_method = "2AE9C4F5192B4DE92A8493140C655329")
    
public InputStream getContentInputStream(DrmRights rights) {
        if (null == rights)
            throw new NullPointerException();

        return new DrmInputStream(rights);
    }

    /**
     * Get the type of the decrypted media content.
     *
     * @return the decrypted media content type of this DRM content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.349 -0500", hash_original_method = "B3F2608C469A4E7BAEFC0D100E327F2C", hash_generated_method = "778F2F03CD46113737D50AE1303EA88F")
    
public String getContentType() {
        return mediaType;
    }

    /**
     * Get the length of the decrypted media content.
     *
     * @param rights        the rights object contain decrypted key.
     *
     * @return the length of the decrypted media content.
     *         #DRM_UNKNOWN_DATA_LEN if the length is unknown currently.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.351 -0500", hash_original_method = "1DD68310D2E0F74333AF2EE851C2CA4C", hash_generated_method = "C0DD457BF7036AEBC4EBBBFC588E6954")
    
public int getContentLength(DrmRights rights) throws DrmException {
        /**
         * Because currently the media object associate with rights object
         * has been handled in native logic, so here it is not need to deal
         * the rights. But for the apps, it is mandatory for user to get
         * the rights object before get the media content length.
         */
        if (null == rights)
            throw new NullPointerException();

        int mediaLen = nativeGetContentLength();

        if (JNI_DRM_FAILURE == mediaLen)
            throw new DrmException("nativeGetContentLength() returned JNI_DRM_FAILURE");

        if (JNI_DRM_UNKNOWN_DATA_LEN == mediaLen)
            return DRM_UNKNOWN_DATA_LEN;

        return mediaLen;
    }

    /**
     * native method: construct a DRM content according the mime type.
     *
     * @param data      input DRM content data to be parsed.
     * @param len       the length of the data.
     * @param mimeType  the mime type of this DRM content. the value of this field includes:
     *                      #DRM_MIMETYPE_MESSAGE
     *                      #DRM_MIMETYPE_CONTENT
     *
     * @return #the id of the DRM content if succeed.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.391 -0500", hash_original_method = "C7FDCF3FD928AB15F38956E64BA9E194", hash_generated_method = "B8BEF93FFA5A3F5F62EC0487663A16A3")
    
    private int nativeConstructDrmContent(InputStream data, int len, int mimeType){
    	//Formerly a native method
    	addTaint(data.getTaint());
    	addTaint(len);
    	addTaint(mimeType);
    	return getTaintInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.546 -0400", hash_original_method = "F8C7C9754DABA7F76C3A7CE0927D169C", hash_generated_method = "FB49DAE02267FB01D7F8074178E3812C")
    private String nativeGetRightsAddress() {
    	String s = new String();
    	s.addTaint(this.taint);
    	return s;
    }

    /**
     * native method: get this DRM content delivery type.
     *
     * @return the delivery method, the value may be one of the following:
     *              #DRM_FORWARD_LOCK
     *              #DRM_COMBINED_DELIVERY
     *              #DRM_SEPARATE_DELIVERY
     *              #DRM_SEPARATE_DELIVERY_DM
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.399 -0500", hash_original_method = "DEB2FF4C98D7FB31135AB87CA522046D", hash_generated_method = "96E38A71C3F4C56BF71911413EC2F281")
    
    private int nativeGetDeliveryMethod(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * native method: get a piece of media content data.
     *
     * @param buf       the buffer to save DRM media content data.
     * @param bufOff    the offset of the buffer to start to save data.
     * @param len       the number of byte to read.
     * @param mediaOff  the offset of the media content data to start to read.
     *
     * @return the length of the media content data has been read.
     *         #JNI_DRM_EOF if reach to end of the media content.
     *         #JNI_DRM_FAILURE if fail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.403 -0500", hash_original_method = "EB4FD7737CAA6B47FAF861D2CF75741C", hash_generated_method = "6946942B3991A05F1F01A9DFA85486EB")
    
    private int nativeReadContent(byte[] buf, int bufOff, int len, int mediaOff){
    	//Formerly a native method
    	addTaint(buf[0]);
    	addTaint(bufOff);
    	addTaint(len);
    	addTaint(mediaOff);
    	return getTaintInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.547 -0400", hash_original_method = "9C49D7586D5C53FF58306596D0BFC464", hash_generated_method = "3114617F023481A1F61CCC44387FD7A5")
    private String nativeGetContentType() {
    	String s = new String();
    	s.addTaint(this.taint);
    	return s;
    }

    /**
     * native method: get this DRM decrypted media content length.
     *
     * @return the length of decrypted media content.
     *         #JNI_DRM_FAILURE if fail.
     *         #JNI_DRM_UNKNOWN_DATA_LEN if the length is unknown currently.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.411 -0500", hash_original_method = "B76F89F97A3E0D25504A6F7E11289FEA", hash_generated_method = "92193E589D668832E187B7EE4320092C")
    
    private int nativeGetContentLength(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * The finalizer of the DRMRawContent. Do some cleanup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:01.414 -0500", hash_original_method = "45E7CB171B397E7ACAF01FE08BEFF46E", hash_generated_method = "4ABBE9BFD747132A545B2A21176E1B5C")
    
    protected void finalize(){
    	//Formerly a native method
    }

    static {
        try {
            System.loadLibrary("drm1_jni");
        }
        catch (UnsatisfiedLinkError ule) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
    
}

