package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static boolean defaultAllowUserInteraction;
    private static boolean defaultUseCaches = true;
    ContentHandler defaultHandler = new DefaultContentHandler();
    private long lastModified = -1;
    protected long ifModifiedSince;
    protected boolean useCaches = defaultUseCaches;
    protected boolean connected;
    protected boolean doOutput;
    protected boolean doInput = true;
    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    private static ContentHandlerFactory contentHandlerFactory;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    static Hashtable<String, Object> contentHandlers = new Hashtable<String, Object>();
    private static FileNameMap fileNameMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.430 -0400", hash_original_method = "C1B78B989F00EEFB1B34CFF3211D8415", hash_generated_method = "EC51CA403B1B9D25863E4EA9FA524467")
    @DSModeled(DSC.SAFE)
    protected URLConnection(URL url) {
        dsTaint.addTaint(url.dsTaint);
        // ---------- Original Method ----------
        //this.url = url;
    }

    
    public abstract void connect() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.430 -0400", hash_original_method = "C67DC5C525139049127B216E3212E5BD", hash_generated_method = "2A3ACB62EE8AD005FA97E79B52EB7229")
    @DSModeled(DSC.SAFE)
    public boolean getAllowUserInteraction() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return allowUserInteraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.430 -0400", hash_original_method = "2189DFB0457B899A3D415AD1ACECB1AB", hash_generated_method = "C5737AB7649E1FE4DCE199330FFCA065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getContent() throws java.io.IOException {
        {
            connect();
        } //End block
        {
            boolean varA85A22BDA5170C074999CE557CE528EC_45274600 = ((contentType = getContentType()) == null);
            {
                {
                    boolean var491682286539AF5FD0E713D813196B61_802765634 = ((contentType = guessContentTypeFromName(url.getFile())) == null);
                    {
                        contentType = guessContentTypeFromStream(getInputStream());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Object varFF01FA1183670EA9B3C87768CC76A8DA_1800429259 = (getContentHandler(contentType).getContent(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.430 -0400", hash_original_method = "4564C020E5F3A695F95559B726D59F50", hash_generated_method = "00494048457D420792E7537B066237BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Object getContent(Class[] types) throws IOException {
        dsTaint.addTaint(types.dsTaint);
        {
            connect();
        } //End block
        {
            boolean varA85A22BDA5170C074999CE557CE528EC_1038490641 = ((contentType = getContentType()) == null);
            {
                {
                    boolean var491682286539AF5FD0E713D813196B61_1195006602 = ((contentType = guessContentTypeFromName(url.getFile())) == null);
                    {
                        contentType = guessContentTypeFromStream(getInputStream());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Object var48D2E9ACDC159CEFECFE5F5F66554EBD_1479347127 = (getContentHandler(contentType).getContent(this, types));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.430 -0400", hash_original_method = "F034FCCBCF276A401A79AE9D47D45859", hash_generated_method = "6A1ABF0697944565531B3DDC106D9F1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentEncoding() {
        String var263829FD08996D899F0A0E64226CF288_93368456 = (getHeaderField("Content-Encoding"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getHeaderField("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "F46F19D62AAF6AA8CA742989F38D6600", hash_generated_method = "F2AD9DA53E602E40EE21A49E09AF6066")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ContentHandler getContentHandler(String type) throws IOException {
        dsTaint.addTaint(type);
        final String typeString;
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
                Iterator<String> seatecAstronomy42 = packageList.split("\\|").iterator();
                seatecAstronomy42.hasNext();
                String packageName = seatecAstronomy42.next();
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
                throw new UnknownServiceException();
            } //End block
            contentHandlers.put(type, cHandler);
        } //End block
        return (ContentHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "D3CB748394BDEDD2AA4B807728EDFBEF", hash_generated_method = "3C6B77E03F6D10B3BE81B596E335E1AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getContentLength() {
        int varA52287D24A01A3F982C408FA2D5E8EC8_1835873772 = (getHeaderFieldInt("Content-Length", -1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getHeaderFieldInt("Content-Length", -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "7440B54E7BE94AE7F9BB4349A25246D4", hash_generated_method = "241F35589CDD4C9B367CD4BF98B06AE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentType() {
        String var7E0691A8E003624580F7D3E153C22179_649206568 = (getHeaderField("Content-Type"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getHeaderField("Content-Type");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "4C9F7702471FFCF16C0BDF48E7BD6750", hash_generated_method = "28D2EF678CFE752FC4E1B68FB06953A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getDate() {
        long var46CDFFD7E5A5B6BB43365990F0F900F1_468287863 = (getHeaderFieldDate("Date", 0));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Date", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "67F858C73BD58BCF0CAF80EEB7D73D90", hash_generated_method = "3936BBC1DD5171A6137F084FBB8158D1")
    public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "B76126F7836136C8351610A389F2D654", hash_generated_method = "9C6117325CB6ACFF0010235F1E3C8499")
    @Deprecated
    public static String getDefaultRequestProperty(String field) {
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "08FC81CB612F586F4ABF44BAE872E3A8", hash_generated_method = "1C49AFD5C2061D118FB1542FE882782B")
    @DSModeled(DSC.SAFE)
    public boolean getDefaultUseCaches() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return defaultUseCaches;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "CCCD690FEDEDD1DE3F70C92A661DD993", hash_generated_method = "AA1AEEC192C3C2189816A7CE75292F09")
    @DSModeled(DSC.SAFE)
    public boolean getDoInput() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "15D6FCAAE0989BD58186FF458E57106D", hash_generated_method = "CC37268D95DF6172A9200CCE95E7E866")
    @DSModeled(DSC.SAFE)
    public boolean getDoOutput() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doOutput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "C717C195610527A15AE106EB78FD0F84", hash_generated_method = "6A9739AABD32B31936B822489DDA0A74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getExpiration() {
        long var1415B379E36DC2CC995ABF21A9A46751_1781707060 = (getHeaderFieldDate("Expires", 0));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Expires", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "29BA6BC9F5073139C26133751F95172D", hash_generated_method = "D75F508274D26B048BDA05E713F099FA")
    public static FileNameMap getFileNameMap() {
        synchronized (URLConnection.class) {
            if (fileNameMap == null) {
                fileNameMap = new DefaultFileNameMap();
            }
            return fileNameMap;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "4AACA905FA1278AAB35ED38439896081", hash_generated_method = "5B000FABE0EB40C2E93F5F26C2A15F8B")
    @DSModeled(DSC.SAFE)
    public String getHeaderField(int pos) {
        dsTaint.addTaint(pos);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "C458EE5373FC7B6169E37A6DC44512AF", hash_generated_method = "C6E8E7213CB13047C9DCB8857F6B637F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> var49AD3B79A6096AC21383C5A186205452_1003538687 = (Collections.emptyMap());
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "04A4D958E6B53818E212E56DBBF1EB38", hash_generated_method = "A886EE35F7B7411AA78F1FF058CE11B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Map<String, List<String>> getRequestProperties() {
        checkNotConnected();
        Map<String, List<String>> var49AD3B79A6096AC21383C5A186205452_891272572 = (Collections.emptyMap());
        return (Map<String, List<String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotConnected();
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.431 -0400", hash_original_method = "B91416BA99E534CF967424CBFE2F2ACE", hash_generated_method = "6A08B50689C9D7C0DD45B530F4C1B87D")
    @DSModeled(DSC.SAFE)
    private void checkNotConnected() {
        {
            throw new IllegalStateException("Already connected");
        } //End block
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Already connected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "AA90A2DB0C71826C83D2E27C5299DE6D", hash_generated_method = "EFDDBEF8AB4E127DCAAA5A76BE7B1240")
    @DSModeled(DSC.SAFE)
    public void addRequestProperty(String field, String newValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(newValue);
        checkNotConnected();
        {
            throw new NullPointerException("field == null");
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "565CBD8C4BDCB5C201FDE1F2CB76B55D", hash_generated_method = "8793D6EE272912F8FC395E8081B252AD")
    @DSModeled(DSC.SAFE)
    public String getHeaderField(String key) {
        dsTaint.addTaint(key);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "3BD57BE7E93B8CCFBCD5DB800D789765", hash_generated_method = "FFF97D33F740FFBE526A10D4520C9530")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    public long getHeaderFieldDate(String field, long defaultValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(defaultValue);
        String date;
        date = getHeaderField(field);
        try 
        {
            long var8BFDC426572870BCA644EAC70995F0E4_1118229737 = (Date.parse(date));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "13117EC346BE33DF62C37EDAC186E83F", hash_generated_method = "AC225BB62C0DF6612CCCFF57452C1777")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeaderFieldInt(String field, int defaultValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(defaultValue);
        try 
        {
            int var33497546D0AAA72A1193B3A095D3C22F_130371533 = (Integer.parseInt(getHeaderField(field)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "2E9FACF1BA93288E38DBB8CED1C2CF00", hash_generated_method = "07B3B925B84013CE2737A7FDA7002831")
    @DSModeled(DSC.SAFE)
    public String getHeaderFieldKey(int posn) {
        dsTaint.addTaint(posn);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "3D630E318477F0341CC679CD7D029C3F", hash_generated_method = "B19CD1703B2AE4AD653DDDE657C80B7A")
    @DSModeled(DSC.SAFE)
    public long getIfModifiedSince() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "AC7495DD6573AA12A9CB49C509EE6FD0", hash_generated_method = "F15BACF65DA66CADB01BC421570FDB9E")
    @DSModeled(DSC.SAFE)
    public InputStream getInputStream() throws IOException {
        throw new UnknownServiceException("Does not support writing to the input stream");
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the input stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "1B346D840CFCEDE13531D2A642CD424D", hash_generated_method = "A7C558EF09A88A503607F4D934F17855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLastModified() {
        long var78957E0DC07228E898FDC47AF0225433_268007382 = (lastModified = getHeaderFieldDate("Last-Modified", 0));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (lastModified != -1) {
            //return lastModified;
        //}
        //return lastModified = getHeaderFieldDate("Last-Modified", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "F613A2AA87619B352A0F7C7CAB39D3F5", hash_generated_method = "186AF8DFD73692F54250E1838E3C7911")
    @DSModeled(DSC.SAFE)
    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException("Does not support writing to the output stream");
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the output stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "0312DFF81C6978A2908F9B8EFDA3EFD4", hash_generated_method = "CD3F64C12F6A33106FD38CFA1D1BFE3A")
    @DSModeled(DSC.SAFE)
    public java.security.Permission getPermission() throws IOException {
        return (java.security.Permission)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new java.security.AllPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "9BF81D9E57E4C63EDA2E82E6CB1EEED2", hash_generated_method = "A5EFD7140357AD5DD7BF16539D40D42C")
    @DSModeled(DSC.SAFE)
    public String getRequestProperty(String field) {
        dsTaint.addTaint(field);
        checkNotConnected();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkNotConnected();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "2F8DA67F8DE7FED0345BBAE8C82F68E5", hash_generated_method = "5690C19FC97F478DB10BB5D5E665F59C")
    @DSModeled(DSC.SAFE)
    public URL getURL() {
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "2F69889B76EEFF99FBB9977BF19C64FC", hash_generated_method = "E2BF046F022C3DDE1EB5730905982091")
    @DSModeled(DSC.SAFE)
    public boolean getUseCaches() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return useCaches;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "CA2040B3E0B7CAC084654E1B2D2F55A4", hash_generated_method = "BCBA41FE6FDB3DB2762019574161AC70")
    public static String guessContentTypeFromName(String url) {
        return getFileNameMap().getContentTypeFor(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.432 -0400", hash_original_method = "788FE5A301E4424C703F6A133B8247C4", hash_generated_method = "EDF6BDFD87C8B7560F0DBD11AA64C6B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "8088F9069DED191ECB9FB0409A3793EB", hash_generated_method = "042A5B3358868DA5CD691924F97F7711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String parseTypeString(String typeString) {
        dsTaint.addTaint(typeString);
        StringBuilder result;
        result = new StringBuilder(typeString);
        {
            int i;
            i = 0;
            boolean varAE3E8ABB93CE5B757876CEF937C2290A_126235978 = (i < result.length());
            {
                char c;
                c = result.charAt(i);
                {
                    boolean var4FF1CE883340B394420C9CDB4FF9AF09_1558022528 = (!(Character.isLetter(c) || Character.isDigit(c) || c == '.'));
                    {
                        result.setCharAt(i, '_');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_403999884 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "701213F9DAF865C1E161CA61CF705A45", hash_generated_method = "74A66FF96BF04837CFD55ACCFC7D35CC")
    @DSModeled(DSC.SAFE)
    public void setAllowUserInteraction(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.allowUserInteraction = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "01C4B07DD183411E1616D228FCEA46F4", hash_generated_method = "70DFB3D550118FE8AEE561A0E357A32B")
    public static synchronized void setContentHandlerFactory(ContentHandlerFactory contentFactory) {
        if (contentHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        contentHandlerFactory = contentFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "0619B46EA06FDDA3BE0AC0FE1EF06FA2", hash_generated_method = "4F9CF50B0F9EE0B89033BBD11414C670")
    public static void setDefaultAllowUserInteraction(boolean allows) {
        defaultAllowUserInteraction = allows;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "C6165B081FA515B9B3060BC6E3911C85", hash_generated_method = "AD553A46666C9EA196877FE8233D039E")
    @Deprecated
    public static void setDefaultRequestProperty(String field, String value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "850171EE0F333E1246D13E7B06ED7B4A", hash_generated_method = "BA0C952AA1F717455300BAEFBBD1996F")
    @DSModeled(DSC.SAFE)
    public void setDefaultUseCaches(boolean newValue) {
        dsTaint.addTaint(newValue);
        // ---------- Original Method ----------
        //defaultUseCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "3A49AB6E406CA8641E1DA3C376F73D42", hash_generated_method = "05079E65DD4090E4C69C41242E3BE018")
    @DSModeled(DSC.SAFE)
    public void setDoInput(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doInput = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "F9A1D9CFB149787BC9250701CAC2EC3A", hash_generated_method = "40891FEA7166B109536787F891924401")
    @DSModeled(DSC.SAFE)
    public void setDoOutput(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doOutput = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "56CE34851CE4C12293D078BB294959F9", hash_generated_method = "B26DD18DA4BD0F1955EB9BE23F15CD93")
    public static void setFileNameMap(FileNameMap map) {
        synchronized (URLConnection.class) {
            fileNameMap = map;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "6F8DD71404577B87171F4310ACFD9CB3", hash_generated_method = "F7DCF35449D2168726516A953AF21A87")
    @DSModeled(DSC.SAFE)
    public void setIfModifiedSince(long newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.ifModifiedSince = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "EB8A856B35FAF51399B9B389D895E434", hash_generated_method = "CF56B2BB12A3D050E0AA90023293C2AB")
    @DSModeled(DSC.SAFE)
    public void setRequestProperty(String field, String newValue) {
        dsTaint.addTaint(field);
        dsTaint.addTaint(newValue);
        checkNotConnected();
        {
            throw new NullPointerException("field == null");
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "36A4E65C2F0D12499DC505123F0CC423", hash_generated_method = "177A7E43AC104401710CCD216D5EFE85")
    @DSModeled(DSC.SAFE)
    public void setUseCaches(boolean newValue) {
        dsTaint.addTaint(newValue);
        checkNotConnected();
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.useCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "6A558E4FD6643B6A2C9B278FD394A062", hash_generated_method = "9C22CEE7654A4A2D17B48AFB7A88124B")
    @DSModeled(DSC.SAFE)
    public void setConnectTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        {
            throw new IllegalArgumentException("timeout < 0");
        } //End block
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.connectTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "70B18BFD6BA7B76980125453BE48C7D1", hash_generated_method = "ED68677CDBAE2CFF925B6800F61558B9")
    @DSModeled(DSC.SAFE)
    public int getConnectTimeout() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return connectTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "AFADA452D3B07139A9E1C4690AAC11B3", hash_generated_method = "4C4BCF2DA47FC724228964015EC79EE2")
    @DSModeled(DSC.SAFE)
    public void setReadTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        {
            throw new IllegalArgumentException("timeout < 0");
        } //End block
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.readTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "D3F0467D6BAB1E0CB8F37756E837EDFD", hash_generated_method = "2949F028128FEF37CD6FCE249D39883D")
    @DSModeled(DSC.SAFE)
    public int getReadTimeout() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return readTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.433 -0400", hash_original_method = "C85D603FFD624A90EAB88172CE67727C", hash_generated_method = "B621E217AD2EC4E857E0240FADA2B307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var7CA6C688F396316F424EF7DE39212689_1573004554 = (getClass().getName() + ":" + url.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + ":" + url.toString();
    }

    
    static class DefaultContentHandler extends java.net.ContentHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.434 -0400", hash_original_method = "AE84E807F7FC8D1C4CC894407353562A", hash_generated_method = "C9C8343A46C80C2ED3FFC4C8615B1F27")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getContent(URLConnection u) throws IOException {
            dsTaint.addTaint(u.dsTaint);
            Object var0887AEC99D1618FAAAC5BA763F466E5C_1144850107 = (u.getInputStream());
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return u.getInputStream();
        }

        
    }


    
}


