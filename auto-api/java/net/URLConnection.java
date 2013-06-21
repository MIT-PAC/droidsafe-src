package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class URLConnection {
    protected URL url;
    private String contentType;
    ContentHandler defaultHandler = new DefaultContentHandler();
    private long lastModified = -1;
    protected long ifModifiedSince;
    protected boolean useCaches = defaultUseCaches;
    protected boolean connected;
    protected boolean doOutput;
    protected boolean doInput = true;
    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.359 -0400", hash_original_method = "C1B78B989F00EEFB1B34CFF3211D8415", hash_generated_method = "0DF3F7B5D888667333EEE2712FA47CDD")
    @DSModeled(DSC.SAFE)
    protected URLConnection(URL url) {
        dsTaint.addTaint(url.dsTaint);
        // ---------- Original Method ----------
        //this.url = url;
    }

    
    public abstract void connect() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.360 -0400", hash_original_method = "C67DC5C525139049127B216E3212E5BD", hash_generated_method = "3B01797ABA8DB5DD158DFE811D9BD493")
    @DSModeled(DSC.SAFE)
    public boolean getAllowUserInteraction() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return allowUserInteraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.360 -0400", hash_original_method = "2189DFB0457B899A3D415AD1ACECB1AB", hash_generated_method = "8F7D20AB99CF17967191BB1155A67AB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getContent() throws java.io.IOException {
        {
            connect();
        } //End block
        {
            boolean varA85A22BDA5170C074999CE557CE528EC_1251132763 = ((contentType = getContentType()) == null);
            {
                {
                    boolean var491682286539AF5FD0E713D813196B61_1674630276 = ((contentType = guessContentTypeFromName(url.getFile())) == null);
                    {
                        contentType = guessContentTypeFromStream(getInputStream());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Object varFF01FA1183670EA9B3C87768CC76A8DA_463703407 = (getContentHandler(contentType).getContent(this));
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if ((contentType = getContentType()) == null) {
            //if ((contentType = guessContentTypeFromName(url.getFile())) == null) {
                //contentType = guessContentTypeFromStream(getInputStream());
            //}
        //}
        //if (contentType != null) {
            //return getContentHandler(contentType).getContent(this);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.360 -0400", hash_original_method = "4564C020E5F3A695F95559B726D59F50", hash_generated_method = "B19AB9745072C197CD3794DDD60ED140")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Object getContent(Class[] types) throws IOException {
        dsTaint.addTaint(types[0].dsTaint);
        {
            connect();
        } //End block
        {
            boolean varA85A22BDA5170C074999CE557CE528EC_1290359624 = ((contentType = getContentType()) == null);
            {
                {
                    boolean var491682286539AF5FD0E713D813196B61_1702011316 = ((contentType = guessContentTypeFromName(url.getFile())) == null);
                    {
                        contentType = guessContentTypeFromStream(getInputStream());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Object var48D2E9ACDC159CEFECFE5F5F66554EBD_1729008090 = (getContentHandler(contentType).getContent(this, types));
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if ((contentType = getContentType()) == null) {
            //if ((contentType = guessContentTypeFromName(url.getFile())) == null) {
                //contentType = guessContentTypeFromStream(getInputStream());
            //}
        //}
        //if (contentType != null) {
            //return getContentHandler(contentType).getContent(this, types);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.360 -0400", hash_original_method = "F034FCCBCF276A401A79AE9D47D45859", hash_generated_method = "45294976FCD2B22A9527A7C5763ED3C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentEncoding() {
        String var263829FD08996D899F0A0E64226CF288_1379604640 = (getHeaderField("Content-Encoding"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getHeaderField("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.380 -0400", hash_original_method = "F46F19D62AAF6AA8CA742989F38D6600", hash_generated_method = "DEDB2DA88271C5F2B6B33517A341844A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ContentHandler getContentHandler(String type) throws IOException {
        dsTaint.addTaint(type);
        String typeString;
        typeString = parseTypeString(type.replace('/', '.'));
        Object cHandler;
        cHandler = contentHandlers.get(type);
        {
            cHandler = contentHandlerFactory.createContentHandler(type);
            contentHandlers.put(type, cHandler);
        } //End block
        String packageList;
        packageList = System.getProperty("java.content.handler.pkgs");
        {
            {
                String packageName = packageList.split("\\|")[0];
                {
                    String className;
                    className = packageName + "." + typeString;
                    try 
                    {
                        Class<?> klass;
                        klass = Class.forName(className, true, ClassLoader.getSystemClassLoader());
                        cHandler = klass.newInstance();
                    } //End block
                    catch (ClassNotFoundException e)
                    { }
                    catch (IllegalAccessException e)
                    { }
                    catch (InstantiationException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            try 
            {
                String className;
                className = "org.apache.harmony.awt.www.content." + typeString;
                cHandler = Class.forName(className).newInstance();
            } //End block
            catch (ClassNotFoundException e)
            { }
            catch (IllegalAccessException e)
            { }
            catch (InstantiationException e)
            { }
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new UnknownServiceException();
            } //End block
            contentHandlers.put(type, cHandler);
        } //End block
        return (ContentHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.380 -0400", hash_original_method = "D3CB748394BDEDD2AA4B807728EDFBEF", hash_generated_method = "68C7CB942590C18515580EE2BFCD439A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getContentLength() {
        int varA52287D24A01A3F982C408FA2D5E8EC8_1575040524 = (getHeaderFieldInt("Content-Length", -1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getHeaderFieldInt("Content-Length", -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.380 -0400", hash_original_method = "7440B54E7BE94AE7F9BB4349A25246D4", hash_generated_method = "EF4B8431CD31C5A000A3B67BAAF22E2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentType() {
        String var7E0691A8E003624580F7D3E153C22179_1668419049 = (getHeaderField("Content-Type"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getHeaderField("Content-Type");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.381 -0400", hash_original_method = "4C9F7702471FFCF16C0BDF48E7BD6750", hash_generated_method = "06F53ED991D11D57CBEABF9FD45974C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getDate() {
        long var46CDFFD7E5A5B6BB43365990F0F900F1_1061515735 = (getHeaderFieldDate("Date", 0));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Date", 0);
    }

    
        public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    
        @Deprecated
    public static String getDefaultRequestProperty(String field) {
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.381 -0400", hash_original_method = "08FC81CB612F586F4ABF44BAE872E3A8", hash_generated_method = "61ECE09F73FF0A0E2ED8FCE7D1EABD92")
    @DSModeled(DSC.SAFE)
    public boolean getDefaultUseCaches() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return defaultUseCaches;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.381 -0400", hash_original_method = "CCCD690FEDEDD1DE3F70C92A661DD993", hash_generated_method = "DED77C3E5BE5CB68ED8EFE7DBAC5283D")
    @DSModeled(DSC.SAFE)
    public boolean getDoInput() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.381 -0400", hash_original_method = "15D6FCAAE0989BD58186FF458E57106D", hash_generated_method = "B2E3B25D7A43DC2C560CDC1E65BB1598")
    @DSModeled(DSC.SAFE)
    public boolean getDoOutput() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doOutput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.382 -0400", hash_original_method = "C717C195610527A15AE106EB78FD0F84", hash_generated_method = "A4A1CB1C1416738ACFFF6F7F2385DC1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getExpiration() {
        long var1415B379E36DC2CC995ABF21A9A46751_1131559346 = (getHeaderFieldDate("Expires", 0));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Expires", 0);
    }

    
        public static FileNameMap getFileNameMap() {
        synchronized (URLConnection.class) {
            if (fileNameMap == null) {
                fileNameMap = new DefaultFileNameMap();
            }
            return fileNameMap;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.382 -0400", hash_original_method = "4AACA905FA1278AAB35ED38439896081", hash_generated_method = "8148E41857788E799885F35012E13EAC")
    @DSModeled(DSC.SAFE)
    public String getHeaderField(int pos) {
        dsTaint.addTaint(pos);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.382 -0400", hash_original_method = "C458EE5373FC7B6169E37A6DC44512AF", hash_generated_method = "30B490A2F94BC3402EB141B9DD91B735")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> var49AD3B79A6096AC21383C5A186205452_1276569380 = (Collections.emptyMap());
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.382 -0400", hash_original_method = "04A4D958E6B53818E212E56DBBF1EB38", hash_generated_method = "654031365D593E9BD377FCEB9E4B69D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, List<String>> getRequestProperties() {
        checkNotConnected();
        Map<String, List<String>> var49AD3B79A6096AC21383C5A186205452_213041115 = (Collections.emptyMap());
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotConnected();
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.383 -0400", hash_original_method = "B91416BA99E534CF967424CBFE2F2ACE", hash_generated_method = "4F5A9EDC3D5F7D6029632FEB7F4612A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotConnected() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected");
        } //End block
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Already connected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.383 -0400", hash_original_method = "AA90A2DB0C71826C83D2E27C5299DE6D", hash_generated_method = "D1B4D5740A2B01CB04C7A8FAF139FA9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addRequestProperty(String field, String newValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(newValue);
        checkNotConnected();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.383 -0400", hash_original_method = "565CBD8C4BDCB5C201FDE1F2CB76B55D", hash_generated_method = "12D6235058FCC9B6C96D7B3BE445F936")
    @DSModeled(DSC.SAFE)
    public String getHeaderField(String key) {
        dsTaint.addTaint(key);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.386 -0400", hash_original_method = "3BD57BE7E93B8CCFBCD5DB800D789765", hash_generated_method = "121CB4720A6DBA3D1DD9D8961C75F5AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    public long getHeaderFieldDate(String field, long defaultValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(defaultValue);
        String date;
        date = getHeaderField(field);
        try 
        {
            long var8BFDC426572870BCA644EAC70995F0E4_833817233 = (Date.parse(date));
        } //End block
        catch (Exception e)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //String date = getHeaderField(field);
        //if (date == null) {
            //return defaultValue;
        //}
        //try {
            //return Date.parse(date); 
        //} catch (Exception e) {
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.387 -0400", hash_original_method = "13117EC346BE33DF62C37EDAC186E83F", hash_generated_method = "1E44AE14A1FDB2EF218BE17DD24D7D45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeaderFieldInt(String field, int defaultValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(defaultValue);
        try 
        {
            int var33497546D0AAA72A1193B3A095D3C22F_1962148379 = (Integer.parseInt(getHeaderField(field)));
        } //End block
        catch (NumberFormatException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(getHeaderField(field));
        //} catch (NumberFormatException e) {
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.388 -0400", hash_original_method = "2E9FACF1BA93288E38DBB8CED1C2CF00", hash_generated_method = "0DFD04CAF0C182B8CBF0F2CC2FA88A96")
    @DSModeled(DSC.SAFE)
    public String getHeaderFieldKey(int posn) {
        dsTaint.addTaint(posn);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.389 -0400", hash_original_method = "3D630E318477F0341CC679CD7D029C3F", hash_generated_method = "7BF1260E6DD09EFFD31FBE590C1CB5D4")
    @DSModeled(DSC.SAFE)
    public long getIfModifiedSince() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.390 -0400", hash_original_method = "AC7495DD6573AA12A9CB49C509EE6FD0", hash_generated_method = "89BA92232C9428AEDCE2A74C36055E3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnknownServiceException("Does not support writing to the input stream");
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the input stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.390 -0400", hash_original_method = "1B346D840CFCEDE13531D2A642CD424D", hash_generated_method = "7FFD8F8E4D311C1BB48D7FABC2A72524")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLastModified() {
        long var78957E0DC07228E898FDC47AF0225433_1439913048 = (lastModified = getHeaderFieldDate("Last-Modified", 0));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (lastModified != -1) {
            //return lastModified;
        //}
        //return lastModified = getHeaderFieldDate("Last-Modified", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.390 -0400", hash_original_method = "F613A2AA87619B352A0F7C7CAB39D3F5", hash_generated_method = "D00EBE33BB69437133BE16D39141A97D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStream getOutputStream() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnknownServiceException("Does not support writing to the output stream");
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the output stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.390 -0400", hash_original_method = "0312DFF81C6978A2908F9B8EFDA3EFD4", hash_generated_method = "CD261953710EC5FDF2F3C6A4E6BD3DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.security.Permission getPermission() throws IOException {
        java.security.Permission var4606CC88CDDDF68AF65F38323BF4DFF4_1283286683 = (new java.security.AllPermission());
        return (java.security.Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new java.security.AllPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.390 -0400", hash_original_method = "9BF81D9E57E4C63EDA2E82E6CB1EEED2", hash_generated_method = "2B18772D780C6D18D91DB9C23C38C2B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRequestProperty(String field) {
        dsTaint.addTaint(field);
        checkNotConnected();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkNotConnected();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.391 -0400", hash_original_method = "2F8DA67F8DE7FED0345BBAE8C82F68E5", hash_generated_method = "37134C95510D18849440B25B0533D7DB")
    @DSModeled(DSC.SAFE)
    public URL getURL() {
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.391 -0400", hash_original_method = "2F69889B76EEFF99FBB9977BF19C64FC", hash_generated_method = "06A3C4D8CDA32E9069DE96C8DC0F033F")
    @DSModeled(DSC.SAFE)
    public boolean getUseCaches() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return useCaches;
    }

    
        public static String guessContentTypeFromName(String url) {
        return getFileNameMap().getContentTypeFor(url);
    }

    
        public static String guessContentTypeFromStream(InputStream is) throws IOException {
        if (!is.markSupported()) {
            return null;
        }
        is.mark(64);
        byte[] bytes = new byte[64];
        int length = is.read(bytes);
        is.reset();
        if (length == -1) {
            return null;
        }
        String encoding = "US-ASCII";
        int start = 0;
        if (length > 1) {
            if ((bytes[0] == (byte) 0xFF) && (bytes[1] == (byte) 0xFE)) {
                encoding = "UTF-16LE";
                start = 2;
                length -= length & 1;
            }
            if ((bytes[0] == (byte) 0xFE) && (bytes[1] == (byte) 0xFF)) {
                encoding = "UTF-16BE";
                start = 2;
                length -= length & 1;
            }
            if (length > 2) {
                if ((bytes[0] == (byte) 0xEF) && (bytes[1] == (byte) 0xBB)
                        && (bytes[2] == (byte) 0xBF)) {
                    encoding = "UTF-8";
                    start = 3;
                }
                if (length > 3) {
                    if ((bytes[0] == (byte) 0x00) && (bytes[1] == (byte) 0x00)
                            && (bytes[2] == (byte) 0xFE)
                            && (bytes[3] == (byte) 0xFF)) {
                        encoding = "UTF-32BE";
                        start = 4;
                        length -= length & 3;
                    }
                    if ((bytes[0] == (byte) 0xFF) && (bytes[1] == (byte) 0xFE)
                            && (bytes[2] == (byte) 0x00)
                            && (bytes[3] == (byte) 0x00)) {
                        encoding = "UTF-32LE";
                        start = 4;
                        length -= length & 3;
                    }
                }
            }
        }
        String header = new String(bytes, start, length - start, encoding);
        if (header.startsWith("PK")) {
            return "application/zip";
        }
        if (header.startsWith("GI")) {
            return "image/gif";
        }
        String textHeader = header.trim().toUpperCase(Locale.US);
        if (textHeader.startsWith("<!DOCTYPE HTML") ||
                textHeader.startsWith("<HTML") ||
                textHeader.startsWith("<HEAD") ||
                textHeader.startsWith("<BODY") ||
                textHeader.startsWith("<HEAD")) {
            return "text/html";
        }
        if (textHeader.startsWith("<?XML")) {
            return "application/xml";
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.392 -0400", hash_original_method = "8088F9069DED191ECB9FB0409A3793EB", hash_generated_method = "819C8C7981D4528998DD5A8FD276AA46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String parseTypeString(String typeString) {
        dsTaint.addTaint(typeString);
        StringBuilder result;
        result = new StringBuilder(typeString);
        {
            int i;
            i = 0;
            boolean varAE3E8ABB93CE5B757876CEF937C2290A_1133528765 = (i < result.length());
            {
                char c;
                c = result.charAt(i);
                {
                    boolean var4FF1CE883340B394420C9CDB4FF9AF09_652223767 = (!(Character.isLetter(c) || Character.isDigit(c) || c == '.'));
                    {
                        result.setCharAt(i, '_');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_1311022162 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(typeString);
        //for (int i = 0; i < result.length(); i++) {
            //char c = result.charAt(i);
            //if (!(Character.isLetter(c) || Character.isDigit(c) || c == '.')) {
                //result.setCharAt(i, '_');
            //}
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.392 -0400", hash_original_method = "701213F9DAF865C1E161CA61CF705A45", hash_generated_method = "8B37056CF025ADDB86A23627F5BD86D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAllowUserInteraction(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.allowUserInteraction = newValue;
    }

    
        public static synchronized void setContentHandlerFactory(ContentHandlerFactory contentFactory) {
        if (contentHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        contentHandlerFactory = contentFactory;
    }

    
        public static void setDefaultAllowUserInteraction(boolean allows) {
        defaultAllowUserInteraction = allows;
    }

    
        @Deprecated
    public static void setDefaultRequestProperty(String field, String value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.392 -0400", hash_original_method = "850171EE0F333E1246D13E7B06ED7B4A", hash_generated_method = "6F2E8B19448115215D172CFD0E019068")
    @DSModeled(DSC.SAFE)
    public void setDefaultUseCaches(boolean newValue) {
        dsTaint.addTaint(newValue);
        defaultUseCaches = newValue;
        // ---------- Original Method ----------
        //defaultUseCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.393 -0400", hash_original_method = "3A49AB6E406CA8641E1DA3C376F73D42", hash_generated_method = "1FA1143AE1A3058C04B27E035C6D4A81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDoInput(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doInput = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.393 -0400", hash_original_method = "F9A1D9CFB149787BC9250701CAC2EC3A", hash_generated_method = "83F687279200181A8AB81EB2E04BB79A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDoOutput(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doOutput = newValue;
    }

    
        public static void setFileNameMap(FileNameMap map) {
        synchronized (URLConnection.class) {
            fileNameMap = map;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.393 -0400", hash_original_method = "6F8DD71404577B87171F4310ACFD9CB3", hash_generated_method = "2274F5002F56CAD50B386A7772C7F747")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIfModifiedSince(long newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.ifModifiedSince = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.393 -0400", hash_original_method = "EB8A856B35FAF51399B9B389D895E434", hash_generated_method = "CA4AE8CD06DBAE46FF50F37A76147449")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRequestProperty(String field, String newValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(newValue);
        checkNotConnected();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.394 -0400", hash_original_method = "36A4E65C2F0D12499DC505123F0CC423", hash_generated_method = "EAADBDEB434915FF07205808F3FC1765")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUseCaches(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.useCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.394 -0400", hash_original_method = "6A558E4FD6643B6A2C9B278FD394A062", hash_generated_method = "A7769FDF518BF7D88EC42EB12255974C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setConnectTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.connectTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.394 -0400", hash_original_method = "70B18BFD6BA7B76980125453BE48C7D1", hash_generated_method = "100BB589A2EBB32B57BBD15DEF311DB4")
    @DSModeled(DSC.SAFE)
    public int getConnectTimeout() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return connectTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.394 -0400", hash_original_method = "AFADA452D3B07139A9E1C4690AAC11B3", hash_generated_method = "57F461F6D88920D48B546B15DE1A8B63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReadTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.readTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.394 -0400", hash_original_method = "D3F0467D6BAB1E0CB8F37756E837EDFD", hash_generated_method = "74BB4D5700B78D79D51BA47F29DCB2BC")
    @DSModeled(DSC.SAFE)
    public int getReadTimeout() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return readTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.395 -0400", hash_original_method = "C85D603FFD624A90EAB88172CE67727C", hash_generated_method = "3AE659C99F5E2E34F8A24C55655D8413")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var7CA6C688F396316F424EF7DE39212689_545543889 = (getClass().getName() + ":" + url.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + ":" + url.toString();
    }

    
    static class DefaultContentHandler extends java.net.ContentHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.395 -0400", hash_original_method = "0C9FC2ED8B71A23DE8CD16742EA90CAE", hash_generated_method = "0C9FC2ED8B71A23DE8CD16742EA90CAE")
                public DefaultContentHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.395 -0400", hash_original_method = "AE84E807F7FC8D1C4CC894407353562A", hash_generated_method = "8986C3C5A7758E971073EADAB77D9CE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getContent(URLConnection u) throws IOException {
            dsTaint.addTaint(u.dsTaint);
            Object var0887AEC99D1618FAAAC5BA763F466E5C_1199122296 = (u.getInputStream());
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return u.getInputStream();
        }

        
    }


    
    private static boolean defaultAllowUserInteraction;
    private static boolean defaultUseCaches = true;
    private static ContentHandlerFactory contentHandlerFactory;
    static Hashtable<String, Object> contentHandlers = new Hashtable<String, Object>();
    private static FileNameMap fileNameMap;
}

