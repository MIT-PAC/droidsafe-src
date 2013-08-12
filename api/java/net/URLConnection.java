package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "65BA9482E03BACCDBB5A2D08239D2205")

    protected URL url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "29F88E17E91EE912EF8A08645AE85733", hash_generated_field = "AA6C99420A3EDFB143DFB7EA7C0B7623")

    ContentHandler defaultHandler = new DefaultContentHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "1E65905B55C5FDFCEDE87E2147EF83D4", hash_generated_field = "80AE10D08247476B02E38D0EE6A074A6")

    private long lastModified = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "61C0F054FFE1E91934EAEB56EE7AF160", hash_generated_field = "CCFF3B6B851FE8AAC8BF953CAC3C257F")

    protected long ifModifiedSince;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "EEBF1201F029083BACC250A113006105", hash_generated_field = "75210328E42DAA7308C7C0DA02D4ECC5")

    protected boolean useCaches = defaultUseCaches;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "34C8ABCCB96118D0E63480374F97C450")

    protected boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.052 -0400", hash_original_field = "0E81D488D2F909D6A2A616B72D4618C2", hash_generated_field = "0588DDF6632243F20DFFAECC5F0C174F")

    protected boolean doOutput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.053 -0400", hash_original_field = "B1043A2A09F39C536DD3E2FFE22765F1", hash_generated_field = "9295E463A85C6D53795FA77F5F4990C8")

    protected boolean doInput = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.053 -0400", hash_original_field = "F928530DB23E56922DC9E86CDD254774", hash_generated_field = "4EB96F0015DD5E6A1B47A0B69C90DCD0")

    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.053 -0400", hash_original_field = "EBA57E117BB383A9D85770809926064C", hash_generated_field = "2D29EC4E724B4A9910DF5E47FBCFBD74")

    private int readTimeout = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.053 -0400", hash_original_field = "FAD2CED9F68F37418BC6C3633BE26D8B", hash_generated_field = "7C5462E35603097818B70A73FEBCE187")

    private int connectTimeout = 0;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.054 -0400", hash_original_method = "C1B78B989F00EEFB1B34CFF3211D8415", hash_generated_method = "26FB837EE505F718F5C8BD67B14C0626")
    protected  URLConnection(URL url) {
        this.url = url;
        // ---------- Original Method ----------
        //this.url = url;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void connect() throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.055 -0400", hash_original_method = "C67DC5C525139049127B216E3212E5BD", hash_generated_method = "B204497FBD6780CCB55F7E35A07EA584")
    public boolean getAllowUserInteraction() {
        boolean var165E1313420F8FCA27A780CD6890FD9D_911718957 = (allowUserInteraction);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185377939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_185377939;
        // ---------- Original Method ----------
        //return allowUserInteraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.057 -0400", hash_original_method = "2189DFB0457B899A3D415AD1ACECB1AB", hash_generated_method = "1E2ED415835E728FFB9CBC43176355D8")
    public Object getContent() throws java.io.IOException {
        if(!connected)        
        {
            connect();
        } //End block
        if((contentType = getContentType()) == null)        
        {
            if((contentType = guessContentTypeFromName(url.getFile())) == null)            
            {
                contentType = guessContentTypeFromStream(getInputStream());
            } //End block
        } //End block
        if(contentType != null)        
        {
Object var418179EDE47C0498EFBE729262988C61_112498649 =             getContentHandler(contentType).getContent(this);
            var418179EDE47C0498EFBE729262988C61_112498649.addTaint(taint);
            return var418179EDE47C0498EFBE729262988C61_112498649;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1491019690 =         null;
        var540C13E9E156B687226421B24F2DF178_1491019690.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1491019690;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.058 -0400", hash_original_method = "4564C020E5F3A695F95559B726D59F50", hash_generated_method = "C52EE2D49F8E974F095F12AED1A9FA3D")
    @SuppressWarnings("unchecked")
    public Object getContent(Class[] types) throws IOException {
        addTaint(types[0].getTaint());
        if(!connected)        
        {
            connect();
        } //End block
        if((contentType = getContentType()) == null)        
        {
            if((contentType = guessContentTypeFromName(url.getFile())) == null)            
            {
                contentType = guessContentTypeFromStream(getInputStream());
            } //End block
        } //End block
        if(contentType != null)        
        {
Object var3119B9ED0627436C092DED6C7791C839_1899823484 =             getContentHandler(contentType).getContent(this, types);
            var3119B9ED0627436C092DED6C7791C839_1899823484.addTaint(taint);
            return var3119B9ED0627436C092DED6C7791C839_1899823484;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1804063500 =         null;
        var540C13E9E156B687226421B24F2DF178_1804063500.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1804063500;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.059 -0400", hash_original_method = "F034FCCBCF276A401A79AE9D47D45859", hash_generated_method = "A49BB65459E94F5E55A2E24811C1F85E")
    public String getContentEncoding() {
String var510A0BC22C0D704C1004D5A998438214_1964403696 =         getHeaderField("Content-Encoding");
        var510A0BC22C0D704C1004D5A998438214_1964403696.addTaint(taint);
        return var510A0BC22C0D704C1004D5A998438214_1964403696;
        // ---------- Original Method ----------
        //return getHeaderField("Content-Encoding");
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.060 -0400", hash_original_method = "F46F19D62AAF6AA8CA742989F38D6600", hash_generated_method = "E7C08385662F1B0E109B770409F3A592")
    private ContentHandler getContentHandler(String type) throws IOException {
        addTaint(type.getTaint());
        final String typeString = parseTypeString(type.replace('/', '.'));
        Object cHandler = contentHandlers.get(type);
        if(cHandler != null)        
        {
ContentHandler varDCD7EACEED88651730DC005C1B50C3DC_2000214958 =             (ContentHandler) cHandler;
            varDCD7EACEED88651730DC005C1B50C3DC_2000214958.addTaint(taint);
            return varDCD7EACEED88651730DC005C1B50C3DC_2000214958;
        } //End block
        if(contentHandlerFactory != null)        
        {
            cHandler = contentHandlerFactory.createContentHandler(type);
            contentHandlers.put(type, cHandler);
ContentHandler varDCD7EACEED88651730DC005C1B50C3DC_1523736069 =             (ContentHandler) cHandler;
            varDCD7EACEED88651730DC005C1B50C3DC_1523736069.addTaint(taint);
            return varDCD7EACEED88651730DC005C1B50C3DC_1523736069;
        } //End block
        String packageList = System.getProperty("java.content.handler.pkgs");
        if(packageList != null)        
        {
for(String packageName : packageList.split("\\|"))
            {
                String className = packageName + "." + typeString;
                try 
                {
                    Class<?> klass = Class.forName(className, true, ClassLoader.getSystemClassLoader());
                    cHandler = klass.newInstance();
                } //End block
                catch (ClassNotFoundException e)
                {
                } //End block
                catch (IllegalAccessException e)
                {
                } //End block
                catch (InstantiationException e)
                {
                } //End block
            } //End block
        } //End block
        if(cHandler == null)        
        {
            try 
            {
                String className = "org.apache.harmony.awt.www.content." + typeString;
                cHandler = Class.forName(className).newInstance();
            } //End block
            catch (ClassNotFoundException e)
            {
            } //End block
            catch (IllegalAccessException e)
            {
            } //End block
            catch (InstantiationException e)
            {
            } //End block
        } //End block
        if(cHandler != null)        
        {
            if(!(cHandler instanceof ContentHandler))            
            {
                UnknownServiceException varE581FBFBB14C6B63856726BBA8C657E1_1510779556 = new UnknownServiceException();
                varE581FBFBB14C6B63856726BBA8C657E1_1510779556.addTaint(taint);
                throw varE581FBFBB14C6B63856726BBA8C657E1_1510779556;
            } //End block
            contentHandlers.put(type, cHandler);
ContentHandler varDCD7EACEED88651730DC005C1B50C3DC_1241565712 =             (ContentHandler) cHandler;
            varDCD7EACEED88651730DC005C1B50C3DC_1241565712.addTaint(taint);
            return varDCD7EACEED88651730DC005C1B50C3DC_1241565712;
        } //End block
ContentHandler varDDDFBDCC1DC485BBAE08766814FFA7F9_502461751 =         defaultHandler;
        varDDDFBDCC1DC485BBAE08766814FFA7F9_502461751.addTaint(taint);
        return varDDDFBDCC1DC485BBAE08766814FFA7F9_502461751;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.062 -0400", hash_original_method = "D3CB748394BDEDD2AA4B807728EDFBEF", hash_generated_method = "BEA2C0584E04C8068784136E54821BCF")
    public int getContentLength() {
        int var36E747513101639E71FF28934335E8B1_1039960482 = (getHeaderFieldInt("Content-Length", -1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067231763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067231763;
        // ---------- Original Method ----------
        //return getHeaderFieldInt("Content-Length", -1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.062 -0400", hash_original_method = "7440B54E7BE94AE7F9BB4349A25246D4", hash_generated_method = "7D5FEB4A2FD1AF38D96A2949CE73C07E")
    public String getContentType() {
String var0EAB4E793F4B3855B9901F8B99D4EE3C_10822782 =         getHeaderField("Content-Type");
        var0EAB4E793F4B3855B9901F8B99D4EE3C_10822782.addTaint(taint);
        return var0EAB4E793F4B3855B9901F8B99D4EE3C_10822782;
        // ---------- Original Method ----------
        //return getHeaderField("Content-Type");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.063 -0400", hash_original_method = "4C9F7702471FFCF16C0BDF48E7BD6750", hash_generated_method = "3501E8BAC3414D6E40AE282F0DC8DE84")
    public long getDate() {
        long var6C7D70BD6F687EC931CC210CAA86A7DA_1793163874 = (getHeaderFieldDate("Date", 0));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_471825375 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_471825375;
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Date", 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static String getDefaultRequestProperty(String field) {
        return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.064 -0400", hash_original_method = "08FC81CB612F586F4ABF44BAE872E3A8", hash_generated_method = "8181054D81DD58F1996A35934C8F28B9")
    public boolean getDefaultUseCaches() {
        boolean varE5044AEA2CD45AB11C684629D133B064_1143343857 = (defaultUseCaches);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406175211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_406175211;
        // ---------- Original Method ----------
        //return defaultUseCaches;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.064 -0400", hash_original_method = "CCCD690FEDEDD1DE3F70C92A661DD993", hash_generated_method = "687B3499B3EB5F1D16466F9ABBBC3084")
    public boolean getDoInput() {
        boolean var4471923C0500D7406947716E8AF1DB0C_1582051674 = (doInput);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048090852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048090852;
        // ---------- Original Method ----------
        //return doInput;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.064 -0400", hash_original_method = "15D6FCAAE0989BD58186FF458E57106D", hash_generated_method = "298688E1A92E8C96539CE59C9E77E0DC")
    public boolean getDoOutput() {
        boolean var0E81D488D2F909D6A2A616B72D4618C2_1827005059 = (doOutput);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493160888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493160888;
        // ---------- Original Method ----------
        //return doOutput;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.065 -0400", hash_original_method = "C717C195610527A15AE106EB78FD0F84", hash_generated_method = "CEAC4A86E14883C5D9935BC0FEEE99F3")
    public long getExpiration() {
        long varB302556983FC0193F72FBF497F8AFB8C_1939338647 = (getHeaderFieldDate("Expires", 0));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_885712690 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_885712690;
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Expires", 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static FileNameMap getFileNameMap() {
        synchronized (URLConnection.class) {
            if (fileNameMap == null) {
                fileNameMap = new DefaultFileNameMap();
            }
            return fileNameMap;
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.066 -0400", hash_original_method = "4AACA905FA1278AAB35ED38439896081", hash_generated_method = "B906C8DC37A57E6F835EE93715D32767")
    public String getHeaderField(int pos) {
        addTaint(pos);
String var540C13E9E156B687226421B24F2DF178_77330459 =         null;
        var540C13E9E156B687226421B24F2DF178_77330459.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_77330459;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.067 -0400", hash_original_method = "C458EE5373FC7B6169E37A6DC44512AF", hash_generated_method = "3D54408700AEBF3ED8C2665EBD23DDAD")
    public Map<String, List<String>> getHeaderFields() {
Map<String, List<String>> varA32ED10B45EA6ACB8D1ECFEFE1C18540_99643496 =         Collections.emptyMap();
        varA32ED10B45EA6ACB8D1ECFEFE1C18540_99643496.addTaint(taint);
        return varA32ED10B45EA6ACB8D1ECFEFE1C18540_99643496;
        // ---------- Original Method ----------
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.067 -0400", hash_original_method = "04A4D958E6B53818E212E56DBBF1EB38", hash_generated_method = "C9FC54AF1B13258FB1277BE55FE43192")
    public Map<String, List<String>> getRequestProperties() {
        checkNotConnected();
Map<String, List<String>> varA32ED10B45EA6ACB8D1ECFEFE1C18540_553406560 =         Collections.emptyMap();
        varA32ED10B45EA6ACB8D1ECFEFE1C18540_553406560.addTaint(taint);
        return varA32ED10B45EA6ACB8D1ECFEFE1C18540_553406560;
        // ---------- Original Method ----------
        //checkNotConnected();
        //return Collections.emptyMap();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.068 -0400", hash_original_method = "B91416BA99E534CF967424CBFE2F2ACE", hash_generated_method = "B908EC3B515FB9BC821B49A2EF5DEAB0")
    private void checkNotConnected() {
        if(connected)        
        {
            IllegalStateException varA63B9CEF256810621025D7CDF0DCD664_1361458580 = new IllegalStateException("Already connected");
            varA63B9CEF256810621025D7CDF0DCD664_1361458580.addTaint(taint);
            throw varA63B9CEF256810621025D7CDF0DCD664_1361458580;
        } //End block
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Already connected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.068 -0400", hash_original_method = "AA90A2DB0C71826C83D2E27C5299DE6D", hash_generated_method = "F99CDE5B543A829CC910BAB68E53DA30")
    public void addRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        checkNotConnected();
        if(field == null)        
        {
            NullPointerException varCE93C640A96638F050352C840C379BEB_1550169669 = new NullPointerException("field == null");
            varCE93C640A96638F050352C840C379BEB_1550169669.addTaint(taint);
            throw varCE93C640A96638F050352C840C379BEB_1550169669;
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.069 -0400", hash_original_method = "565CBD8C4BDCB5C201FDE1F2CB76B55D", hash_generated_method = "D5CFB6D9944DC818223871C09587AF3E")
    public String getHeaderField(String key) {
        addTaint(key.getTaint());
String var540C13E9E156B687226421B24F2DF178_984524825 =         null;
        var540C13E9E156B687226421B24F2DF178_984524825.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_984524825;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.069 -0400", hash_original_method = "3BD57BE7E93B8CCFBCD5DB800D789765", hash_generated_method = "9F52614E9CDA421E4D07A501C8876891")
    @SuppressWarnings("deprecation")
    public long getHeaderFieldDate(String field, long defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        String date = getHeaderField(field);
        if(date == null)        
        {
            long var16830A58E1E33A4163524366BA7B701B_486726489 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_869633989 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_869633989;
        } //End block
        try 
        {
            long varE0A934EFBBF0BE06C3B9F34E81515BE2_880984177 = (Date.parse(date));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1835791994 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1835791994;
        } //End block
        catch (Exception e)
        {
            long var16830A58E1E33A4163524366BA7B701B_469191076 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2042436779 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2042436779;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.069 -0400", hash_original_method = "13117EC346BE33DF62C37EDAC186E83F", hash_generated_method = "6609FE780318B5A5DC1BBBC89D2E04FE")
    public int getHeaderFieldInt(String field, int defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        try 
        {
            int varE46A0E0145ED86A06EDA928950129A8A_191656558 = (Integer.parseInt(getHeaderField(field)));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001582151 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001582151;
        } //End block
        catch (NumberFormatException e)
        {
            int var16830A58E1E33A4163524366BA7B701B_1294694757 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143277651 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143277651;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(getHeaderField(field));
        //} catch (NumberFormatException e) {
            //return defaultValue;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.070 -0400", hash_original_method = "2E9FACF1BA93288E38DBB8CED1C2CF00", hash_generated_method = "971EEA463C3702CF90A38DE303A1059A")
    public String getHeaderFieldKey(int posn) {
        addTaint(posn);
String var540C13E9E156B687226421B24F2DF178_415062842 =         null;
        var540C13E9E156B687226421B24F2DF178_415062842.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_415062842;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.070 -0400", hash_original_method = "3D630E318477F0341CC679CD7D029C3F", hash_generated_method = "7CA69A80D2A692E16301B3BC9433848F")
    public long getIfModifiedSince() {
        long var61C0F054FFE1E91934EAEB56EE7AF160_593950631 = (ifModifiedSince);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1920418799 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1920418799;
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.070 -0400", hash_original_method = "AC7495DD6573AA12A9CB49C509EE6FD0", hash_generated_method = "76EDB5C5D45C90A51DF4D8B7B0E2B37F")
    public InputStream getInputStream() throws IOException {
        UnknownServiceException var041CA6C0CEC20D69C1192EA6A23D16F1_751798312 = new UnknownServiceException("Does not support writing to the input stream");
        var041CA6C0CEC20D69C1192EA6A23D16F1_751798312.addTaint(taint);
        throw var041CA6C0CEC20D69C1192EA6A23D16F1_751798312;
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the input stream");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.071 -0400", hash_original_method = "1B346D840CFCEDE13531D2A642CD424D", hash_generated_method = "963CFBBA03AF775A2B3F1C2D621FBB57")
    public long getLastModified() {
        if(lastModified != -1)        
        {
            long var56D4CE3ADDD9E0185B21EB938EA5BC79_229720700 = (lastModified);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1999121225 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1999121225;
        } //End block
        long varBB8F45C45FEE0F82210CC2ED4CBF79F1_1947311646 = (lastModified = getHeaderFieldDate("Last-Modified", 0));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2068219429 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2068219429;
        // ---------- Original Method ----------
        //if (lastModified != -1) {
            //return lastModified;
        //}
        //return lastModified = getHeaderFieldDate("Last-Modified", 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.071 -0400", hash_original_method = "F613A2AA87619B352A0F7C7CAB39D3F5", hash_generated_method = "707AFC17B8F2447D35D122E57FE44934")
    public OutputStream getOutputStream() throws IOException {
        UnknownServiceException var1691875A0B15152BF366E3EE936B3627_1503405204 = new UnknownServiceException("Does not support writing to the output stream");
        var1691875A0B15152BF366E3EE936B3627_1503405204.addTaint(taint);
        throw var1691875A0B15152BF366E3EE936B3627_1503405204;
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the output stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.071 -0400", hash_original_method = "0312DFF81C6978A2908F9B8EFDA3EFD4", hash_generated_method = "DD8704B51A9EE53F2DF31FC66BD25AAE")
    public java.security.Permission getPermission() throws IOException {
java.security.Permission varAA4D4D55ABB29408F9384F4494AEC9E5_560687210 =         new java.security.AllPermission();
        varAA4D4D55ABB29408F9384F4494AEC9E5_560687210.addTaint(taint);
        return varAA4D4D55ABB29408F9384F4494AEC9E5_560687210;
        // ---------- Original Method ----------
        //return new java.security.AllPermission();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.071 -0400", hash_original_method = "9BF81D9E57E4C63EDA2E82E6CB1EEED2", hash_generated_method = "5FF1CD59B10A8165F60080607859207E")
    public String getRequestProperty(String field) {
        addTaint(field.getTaint());
        checkNotConnected();
String var540C13E9E156B687226421B24F2DF178_1274590431 =         null;
        var540C13E9E156B687226421B24F2DF178_1274590431.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1274590431;
        // ---------- Original Method ----------
        //checkNotConnected();
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.072 -0400", hash_original_method = "2F8DA67F8DE7FED0345BBAE8C82F68E5", hash_generated_method = "6C40004904769725A70BAB264D82D80E")
    public URL getURL() {
URL var4F9C62D322C7F68D5668056D4B193F9B_1582075202 =         url;
        var4F9C62D322C7F68D5668056D4B193F9B_1582075202.addTaint(taint);
        return var4F9C62D322C7F68D5668056D4B193F9B_1582075202;
        // ---------- Original Method ----------
        //return url;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.072 -0400", hash_original_method = "2F69889B76EEFF99FBB9977BF19C64FC", hash_generated_method = "68DA03D729D5C63596F1F803B90ECA7D")
    public boolean getUseCaches() {
        boolean var691C57F8E736BC3B73874BB05455D1C7_1880381108 = (useCaches);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306301886 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306301886;
        // ---------- Original Method ----------
        //return useCaches;
    }

    
    @DSModeled(DSC.SAFE)
    public static String guessContentTypeFromName(String url) {
        return getFileNameMap().getContentTypeFor(url);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.073 -0400", hash_original_method = "8088F9069DED191ECB9FB0409A3793EB", hash_generated_method = "A4DC76E60A77AAB184DFB37B353A1874")
    private String parseTypeString(String typeString) {
        addTaint(typeString.getTaint());
        StringBuilder result = new StringBuilder(typeString);
for(int i = 0;i < result.length();i++)
        {
            char c = result.charAt(i);
            if(!(Character.isLetter(c) || Character.isDigit(c) || c == '.'))            
            {
                result.setCharAt(i, '_');
            } //End block
        } //End block
String varE65B3A02759122992CB82C0E651AD408_415779763 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_415779763.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_415779763;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.073 -0400", hash_original_method = "701213F9DAF865C1E161CA61CF705A45", hash_generated_method = "408F9F458C8E55460089B8BE6916EAA4")
    public void setAllowUserInteraction(boolean newValue) {
        checkNotConnected();
        this.allowUserInteraction = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.allowUserInteraction = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized void setContentHandlerFactory(ContentHandlerFactory contentFactory) {
        if (contentHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        contentHandlerFactory = contentFactory;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setDefaultAllowUserInteraction(boolean allows) {
        defaultAllowUserInteraction = allows;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static void setDefaultRequestProperty(String field, String value) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.074 -0400", hash_original_method = "850171EE0F333E1246D13E7B06ED7B4A", hash_generated_method = "436C41CBA1FB80C3D7958C86AC6952C6")
    public void setDefaultUseCaches(boolean newValue) {
        addTaint(newValue);
        defaultUseCaches = newValue;
        // ---------- Original Method ----------
        //defaultUseCaches = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.074 -0400", hash_original_method = "3A49AB6E406CA8641E1DA3C376F73D42", hash_generated_method = "5479128F7387075B4F54BB3064B9DD25")
    public void setDoInput(boolean newValue) {
        checkNotConnected();
        this.doInput = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doInput = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.075 -0400", hash_original_method = "F9A1D9CFB149787BC9250701CAC2EC3A", hash_generated_method = "C87FEF41C96B6A34E93E22638F84D18D")
    public void setDoOutput(boolean newValue) {
        checkNotConnected();
        this.doOutput = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doOutput = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setFileNameMap(FileNameMap map) {
        synchronized (URLConnection.class) {
            fileNameMap = map;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.075 -0400", hash_original_method = "6F8DD71404577B87171F4310ACFD9CB3", hash_generated_method = "3C3BFEEA68FC926E1FD28F2EDF6381A6")
    public void setIfModifiedSince(long newValue) {
        checkNotConnected();
        this.ifModifiedSince = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.ifModifiedSince = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.076 -0400", hash_original_method = "EB8A856B35FAF51399B9B389D895E434", hash_generated_method = "ECDA14C4CEBD696C919706BB2E04449F")
    public void setRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        checkNotConnected();
        if(field == null)        
        {
            NullPointerException varCE93C640A96638F050352C840C379BEB_652736942 = new NullPointerException("field == null");
            varCE93C640A96638F050352C840C379BEB_652736942.addTaint(taint);
            throw varCE93C640A96638F050352C840C379BEB_652736942;
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.076 -0400", hash_original_method = "36A4E65C2F0D12499DC505123F0CC423", hash_generated_method = "2C4942B39DE1BD013B5FC65E487DC4CE")
    public void setUseCaches(boolean newValue) {
        checkNotConnected();
        this.useCaches = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.useCaches = newValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.077 -0400", hash_original_method = "6A558E4FD6643B6A2C9B278FD394A062", hash_generated_method = "982FF05D8031E0450262D106A2FA9443")
    public void setConnectTimeout(int timeout) {
        if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_1621515642 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_1621515642.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_1621515642;
        } //End block
        this.connectTimeout = timeout;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.connectTimeout = timeout;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.077 -0400", hash_original_method = "70B18BFD6BA7B76980125453BE48C7D1", hash_generated_method = "AC7F5BA3F59888B3AAB447FBCC7AD029")
    public int getConnectTimeout() {
        int var23877A0B37BD98D5993CA98BD9204BD5_1579073343 = (connectTimeout);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159455830 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159455830;
        // ---------- Original Method ----------
        //return connectTimeout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.077 -0400", hash_original_method = "AFADA452D3B07139A9E1C4690AAC11B3", hash_generated_method = "FBCAE12275BE3EE0A82583A02964BBF7")
    public void setReadTimeout(int timeout) {
        if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_457603554 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_457603554.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_457603554;
        } //End block
        this.readTimeout = timeout;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.readTimeout = timeout;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.078 -0400", hash_original_method = "D3F0467D6BAB1E0CB8F37756E837EDFD", hash_generated_method = "B12CF40FDF139E41FFE8DE5C82A6909C")
    public int getReadTimeout() {
        int var8FC05721DCBB3B49F66A6D283A300B5B_1006028643 = (readTimeout);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052188795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052188795;
        // ---------- Original Method ----------
        //return readTimeout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.078 -0400", hash_original_method = "C85D603FFD624A90EAB88172CE67727C", hash_generated_method = "A23E86DBE6740E14FB9A0C328C7D5D00")
    @Override
    public String toString() {
String var6A8B79AC21D46F64E8FA95BADFC3BF6A_1737255838 =         getClass().getName() + ":" + url.toString();
        var6A8B79AC21D46F64E8FA95BADFC3BF6A_1737255838.addTaint(taint);
        return var6A8B79AC21D46F64E8FA95BADFC3BF6A_1737255838;
        // ---------- Original Method ----------
        //return getClass().getName() + ":" + url.toString();
    }

    
    static class DefaultContentHandler extends java.net.ContentHandler {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.078 -0400", hash_original_method = "D9C7FF4AC457B32D0DB70E56925850DE", hash_generated_method = "D9C7FF4AC457B32D0DB70E56925850DE")
        public DefaultContentHandler ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.078 -0400", hash_original_method = "AE84E807F7FC8D1C4CC894407353562A", hash_generated_method = "74C742CA875BA0BB8DEF98FF9E46BC71")
        @Override
        public Object getContent(URLConnection u) throws IOException {
            addTaint(u.getTaint());
Object varEA60E7D94351E5F8174FE87AC3C07B53_1938347202 =             u.getInputStream();
            varEA60E7D94351E5F8174FE87AC3C07B53_1938347202.addTaint(taint);
            return varEA60E7D94351E5F8174FE87AC3C07B53_1938347202;
            // ---------- Original Method ----------
            //return u.getInputStream();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.079 -0400", hash_original_field = "2EF9D74EDA056159EF28D8BEDB8E2029", hash_generated_field = "1A52F999A308188068C76D38BA5615EF")

    private static boolean defaultAllowUserInteraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.079 -0400", hash_original_field = "BDA43DE9887FC5B4AE2773879B6DC47D", hash_generated_field = "0745D91F58FAC663266DAFADF4C39A8B")

    private static boolean defaultUseCaches = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.079 -0400", hash_original_field = "5374745A15E146F670B4E156900FC280", hash_generated_field = "D42218022B7E3DD64D7C74B810FC8B3D")

    private static ContentHandlerFactory contentHandlerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.079 -0400", hash_original_field = "0DED07A99DDC83F010D0232F904AB185", hash_generated_field = "B35CCA371471EC5184868CE09D94475C")

    static Hashtable<String, Object> contentHandlers = new Hashtable<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.079 -0400", hash_original_field = "1F40A211288BCB20F811E6D3918ADD04", hash_generated_field = "E3E7D988476B274A9DF2166D8A8B4DFA")

    private static FileNameMap fileNameMap;
}

