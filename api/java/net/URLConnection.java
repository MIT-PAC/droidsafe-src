package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.772 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "65BA9482E03BACCDBB5A2D08239D2205")

    protected URL url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.773 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.773 -0400", hash_original_field = "29F88E17E91EE912EF8A08645AE85733", hash_generated_field = "AA6C99420A3EDFB143DFB7EA7C0B7623")

    ContentHandler defaultHandler = new DefaultContentHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.773 -0400", hash_original_field = "1E65905B55C5FDFCEDE87E2147EF83D4", hash_generated_field = "80AE10D08247476B02E38D0EE6A074A6")

    private long lastModified = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.773 -0400", hash_original_field = "61C0F054FFE1E91934EAEB56EE7AF160", hash_generated_field = "CCFF3B6B851FE8AAC8BF953CAC3C257F")

    protected long ifModifiedSince;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.774 -0400", hash_original_field = "EEBF1201F029083BACC250A113006105", hash_generated_field = "75210328E42DAA7308C7C0DA02D4ECC5")

    protected boolean useCaches = defaultUseCaches;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.774 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "34C8ABCCB96118D0E63480374F97C450")

    protected boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.774 -0400", hash_original_field = "0E81D488D2F909D6A2A616B72D4618C2", hash_generated_field = "0588DDF6632243F20DFFAECC5F0C174F")

    protected boolean doOutput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.774 -0400", hash_original_field = "B1043A2A09F39C536DD3E2FFE22765F1", hash_generated_field = "9295E463A85C6D53795FA77F5F4990C8")

    protected boolean doInput = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.774 -0400", hash_original_field = "F928530DB23E56922DC9E86CDD254774", hash_generated_field = "4EB96F0015DD5E6A1B47A0B69C90DCD0")

    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.774 -0400", hash_original_field = "EBA57E117BB383A9D85770809926064C", hash_generated_field = "2D29EC4E724B4A9910DF5E47FBCFBD74")

    private int readTimeout = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.774 -0400", hash_original_field = "FAD2CED9F68F37418BC6C3633BE26D8B", hash_generated_field = "7C5462E35603097818B70A73FEBCE187")

    private int connectTimeout = 0;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.775 -0400", hash_original_method = "C1B78B989F00EEFB1B34CFF3211D8415", hash_generated_method = "26FB837EE505F718F5C8BD67B14C0626")
    protected  URLConnection(URL url) {
        this.url = url;
        // ---------- Original Method ----------
        //this.url = url;
    }

    
    public abstract void connect() throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.775 -0400", hash_original_method = "C67DC5C525139049127B216E3212E5BD", hash_generated_method = "B2CD2EF30AC39A0944C8F2526B9F1293")
    public boolean getAllowUserInteraction() {
        boolean var165E1313420F8FCA27A780CD6890FD9D_1608810252 = (allowUserInteraction);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993198423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_993198423;
        // ---------- Original Method ----------
        //return allowUserInteraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.776 -0400", hash_original_method = "2189DFB0457B899A3D415AD1ACECB1AB", hash_generated_method = "E61568F5561690A801CB045B971452E0")
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
Object var418179EDE47C0498EFBE729262988C61_1365677841 =             getContentHandler(contentType).getContent(this);
            var418179EDE47C0498EFBE729262988C61_1365677841.addTaint(taint);
            return var418179EDE47C0498EFBE729262988C61_1365677841;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1841400959 =         null;
        var540C13E9E156B687226421B24F2DF178_1841400959.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1841400959;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.777 -0400", hash_original_method = "4564C020E5F3A695F95559B726D59F50", hash_generated_method = "E45B28B4598595DEBB549D0E26DD82D1")
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
Object var3119B9ED0627436C092DED6C7791C839_131827021 =             getContentHandler(contentType).getContent(this, types);
            var3119B9ED0627436C092DED6C7791C839_131827021.addTaint(taint);
            return var3119B9ED0627436C092DED6C7791C839_131827021;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1675692494 =         null;
        var540C13E9E156B687226421B24F2DF178_1675692494.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1675692494;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.777 -0400", hash_original_method = "F034FCCBCF276A401A79AE9D47D45859", hash_generated_method = "416564C49EF8FCC5DEF460B837CE95E4")
    public String getContentEncoding() {
String var510A0BC22C0D704C1004D5A998438214_153051118 =         getHeaderField("Content-Encoding");
        var510A0BC22C0D704C1004D5A998438214_153051118.addTaint(taint);
        return var510A0BC22C0D704C1004D5A998438214_153051118;
        // ---------- Original Method ----------
        //return getHeaderField("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.779 -0400", hash_original_method = "F46F19D62AAF6AA8CA742989F38D6600", hash_generated_method = "CCB9493DCE1CA6E6473ECE582B704A34")
    private ContentHandler getContentHandler(String type) throws IOException {
        addTaint(type.getTaint());
        final String typeString = parseTypeString(type.replace('/', '.'));
        Object cHandler = contentHandlers.get(type);
    if(cHandler != null)        
        {
ContentHandler varDCD7EACEED88651730DC005C1B50C3DC_675990506 =             (ContentHandler) cHandler;
            varDCD7EACEED88651730DC005C1B50C3DC_675990506.addTaint(taint);
            return varDCD7EACEED88651730DC005C1B50C3DC_675990506;
        } //End block
    if(contentHandlerFactory != null)        
        {
            cHandler = contentHandlerFactory.createContentHandler(type);
            contentHandlers.put(type, cHandler);
ContentHandler varDCD7EACEED88651730DC005C1B50C3DC_1139494012 =             (ContentHandler) cHandler;
            varDCD7EACEED88651730DC005C1B50C3DC_1139494012.addTaint(taint);
            return varDCD7EACEED88651730DC005C1B50C3DC_1139494012;
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
                UnknownServiceException varE581FBFBB14C6B63856726BBA8C657E1_1657051683 = new UnknownServiceException();
                varE581FBFBB14C6B63856726BBA8C657E1_1657051683.addTaint(taint);
                throw varE581FBFBB14C6B63856726BBA8C657E1_1657051683;
            } //End block
            contentHandlers.put(type, cHandler);
ContentHandler varDCD7EACEED88651730DC005C1B50C3DC_727703920 =             (ContentHandler) cHandler;
            varDCD7EACEED88651730DC005C1B50C3DC_727703920.addTaint(taint);
            return varDCD7EACEED88651730DC005C1B50C3DC_727703920;
        } //End block
ContentHandler varDDDFBDCC1DC485BBAE08766814FFA7F9_522231824 =         defaultHandler;
        varDDDFBDCC1DC485BBAE08766814FFA7F9_522231824.addTaint(taint);
        return varDDDFBDCC1DC485BBAE08766814FFA7F9_522231824;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.780 -0400", hash_original_method = "D3CB748394BDEDD2AA4B807728EDFBEF", hash_generated_method = "631777F9A56945F7CB55A8E89EE78EB5")
    public int getContentLength() {
        int var36E747513101639E71FF28934335E8B1_821137752 = (getHeaderFieldInt("Content-Length", -1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520448217 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520448217;
        // ---------- Original Method ----------
        //return getHeaderFieldInt("Content-Length", -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.780 -0400", hash_original_method = "7440B54E7BE94AE7F9BB4349A25246D4", hash_generated_method = "CAABB57DACFB781E757CC89AD896AFE9")
    public String getContentType() {
String var0EAB4E793F4B3855B9901F8B99D4EE3C_172921205 =         getHeaderField("Content-Type");
        var0EAB4E793F4B3855B9901F8B99D4EE3C_172921205.addTaint(taint);
        return var0EAB4E793F4B3855B9901F8B99D4EE3C_172921205;
        // ---------- Original Method ----------
        //return getHeaderField("Content-Type");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.780 -0400", hash_original_method = "4C9F7702471FFCF16C0BDF48E7BD6750", hash_generated_method = "FBA48D78F58BD5D23869F5F34E192AE8")
    public long getDate() {
        long var6C7D70BD6F687EC931CC210CAA86A7DA_1064724323 = (getHeaderFieldDate("Date", 0));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1389952899 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1389952899;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.781 -0400", hash_original_method = "08FC81CB612F586F4ABF44BAE872E3A8", hash_generated_method = "1D66F509B5B9867F4F0468C4C9BEEC9B")
    public boolean getDefaultUseCaches() {
        boolean varE5044AEA2CD45AB11C684629D133B064_1711630928 = (defaultUseCaches);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989111482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989111482;
        // ---------- Original Method ----------
        //return defaultUseCaches;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.781 -0400", hash_original_method = "CCCD690FEDEDD1DE3F70C92A661DD993", hash_generated_method = "72B3AEB19661A864AE15F43731DF5A5C")
    public boolean getDoInput() {
        boolean var4471923C0500D7406947716E8AF1DB0C_902551781 = (doInput);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804945688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804945688;
        // ---------- Original Method ----------
        //return doInput;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.782 -0400", hash_original_method = "15D6FCAAE0989BD58186FF458E57106D", hash_generated_method = "2E40CD8CB8C9A4786506893FDE8CD6E5")
    public boolean getDoOutput() {
        boolean var0E81D488D2F909D6A2A616B72D4618C2_1076543901 = (doOutput);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689925600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689925600;
        // ---------- Original Method ----------
        //return doOutput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.782 -0400", hash_original_method = "C717C195610527A15AE106EB78FD0F84", hash_generated_method = "1784FE6F16C9AACBBFF251EC2882A620")
    public long getExpiration() {
        long varB302556983FC0193F72FBF497F8AFB8C_149255991 = (getHeaderFieldDate("Expires", 0));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1600818773 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1600818773;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.783 -0400", hash_original_method = "4AACA905FA1278AAB35ED38439896081", hash_generated_method = "47C1993D82D3200A3596ABAB2DE38470")
    public String getHeaderField(int pos) {
        addTaint(pos);
String var540C13E9E156B687226421B24F2DF178_706030172 =         null;
        var540C13E9E156B687226421B24F2DF178_706030172.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_706030172;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.783 -0400", hash_original_method = "C458EE5373FC7B6169E37A6DC44512AF", hash_generated_method = "E97B9CD875ABC6C06D218D70E6296DB0")
    public Map<String, List<String>> getHeaderFields() {
Map<String, List<String>> varA32ED10B45EA6ACB8D1ECFEFE1C18540_1178601612 =         Collections.emptyMap();
        varA32ED10B45EA6ACB8D1ECFEFE1C18540_1178601612.addTaint(taint);
        return varA32ED10B45EA6ACB8D1ECFEFE1C18540_1178601612;
        // ---------- Original Method ----------
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.783 -0400", hash_original_method = "04A4D958E6B53818E212E56DBBF1EB38", hash_generated_method = "16BF64180240DB09779B2FB3E19383F0")
    public Map<String, List<String>> getRequestProperties() {
        checkNotConnected();
Map<String, List<String>> varA32ED10B45EA6ACB8D1ECFEFE1C18540_1700839873 =         Collections.emptyMap();
        varA32ED10B45EA6ACB8D1ECFEFE1C18540_1700839873.addTaint(taint);
        return varA32ED10B45EA6ACB8D1ECFEFE1C18540_1700839873;
        // ---------- Original Method ----------
        //checkNotConnected();
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.784 -0400", hash_original_method = "B91416BA99E534CF967424CBFE2F2ACE", hash_generated_method = "1944256712448BEB61684B5E9C2A0F60")
    private void checkNotConnected() {
    if(connected)        
        {
            IllegalStateException varA63B9CEF256810621025D7CDF0DCD664_1921625255 = new IllegalStateException("Already connected");
            varA63B9CEF256810621025D7CDF0DCD664_1921625255.addTaint(taint);
            throw varA63B9CEF256810621025D7CDF0DCD664_1921625255;
        } //End block
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Already connected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.784 -0400", hash_original_method = "AA90A2DB0C71826C83D2E27C5299DE6D", hash_generated_method = "1918EFBB120D0DEB8AA0D2A135AFFEAB")
    public void addRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        checkNotConnected();
    if(field == null)        
        {
            NullPointerException varCE93C640A96638F050352C840C379BEB_1304448368 = new NullPointerException("field == null");
            varCE93C640A96638F050352C840C379BEB_1304448368.addTaint(taint);
            throw varCE93C640A96638F050352C840C379BEB_1304448368;
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.785 -0400", hash_original_method = "565CBD8C4BDCB5C201FDE1F2CB76B55D", hash_generated_method = "115E2CD3FAA309224873730A56BC47FE")
    public String getHeaderField(String key) {
        addTaint(key.getTaint());
String var540C13E9E156B687226421B24F2DF178_2050153086 =         null;
        var540C13E9E156B687226421B24F2DF178_2050153086.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2050153086;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.785 -0400", hash_original_method = "3BD57BE7E93B8CCFBCD5DB800D789765", hash_generated_method = "C84AE20FA115F7E12404EA5F14F81AB2")
    @SuppressWarnings("deprecation")
    public long getHeaderFieldDate(String field, long defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        String date = getHeaderField(field);
    if(date == null)        
        {
            long var16830A58E1E33A4163524366BA7B701B_1165617957 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1567277374 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1567277374;
        } //End block
        try 
        {
            long varE0A934EFBBF0BE06C3B9F34E81515BE2_860476733 = (Date.parse(date));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_972451690 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_972451690;
        } //End block
        catch (Exception e)
        {
            long var16830A58E1E33A4163524366BA7B701B_258494312 = (defaultValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_695017566 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_695017566;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.786 -0400", hash_original_method = "13117EC346BE33DF62C37EDAC186E83F", hash_generated_method = "E9C0204E2ADD4CDDE0011A1BD816FA7C")
    public int getHeaderFieldInt(String field, int defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        try 
        {
            int varE46A0E0145ED86A06EDA928950129A8A_588688181 = (Integer.parseInt(getHeaderField(field)));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554568187 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554568187;
        } //End block
        catch (NumberFormatException e)
        {
            int var16830A58E1E33A4163524366BA7B701B_1099935984 = (defaultValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674830386 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674830386;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(getHeaderField(field));
        //} catch (NumberFormatException e) {
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.786 -0400", hash_original_method = "2E9FACF1BA93288E38DBB8CED1C2CF00", hash_generated_method = "AD96414435EE04DB599CC57B8DE3CBA8")
    public String getHeaderFieldKey(int posn) {
        addTaint(posn);
String var540C13E9E156B687226421B24F2DF178_1985163768 =         null;
        var540C13E9E156B687226421B24F2DF178_1985163768.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1985163768;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.787 -0400", hash_original_method = "3D630E318477F0341CC679CD7D029C3F", hash_generated_method = "876FD548228968F2FBE53C666CC57025")
    public long getIfModifiedSince() {
        long var61C0F054FFE1E91934EAEB56EE7AF160_1348181274 = (ifModifiedSince);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_437668311 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_437668311;
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.787 -0400", hash_original_method = "AC7495DD6573AA12A9CB49C509EE6FD0", hash_generated_method = "B7AFAB8D603445F76C6AFAD143D06B54")
    public InputStream getInputStream() throws IOException {
        UnknownServiceException var041CA6C0CEC20D69C1192EA6A23D16F1_1998800855 = new UnknownServiceException("Does not support writing to the input stream");
        var041CA6C0CEC20D69C1192EA6A23D16F1_1998800855.addTaint(taint);
        throw var041CA6C0CEC20D69C1192EA6A23D16F1_1998800855;
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the input stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.788 -0400", hash_original_method = "1B346D840CFCEDE13531D2A642CD424D", hash_generated_method = "A1024AA562219B91BFB7E46CD2D030CA")
    public long getLastModified() {
    if(lastModified != -1)        
        {
            long var56D4CE3ADDD9E0185B21EB938EA5BC79_66226179 = (lastModified);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_208917649 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_208917649;
        } //End block
        long varBB8F45C45FEE0F82210CC2ED4CBF79F1_277149852 = (lastModified = getHeaderFieldDate("Last-Modified", 0));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1083821705 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1083821705;
        // ---------- Original Method ----------
        //if (lastModified != -1) {
            //return lastModified;
        //}
        //return lastModified = getHeaderFieldDate("Last-Modified", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.788 -0400", hash_original_method = "F613A2AA87619B352A0F7C7CAB39D3F5", hash_generated_method = "D9B46FF91BA99123D66DB1EAD6470C3B")
    public OutputStream getOutputStream() throws IOException {
        UnknownServiceException var1691875A0B15152BF366E3EE936B3627_1247955125 = new UnknownServiceException("Does not support writing to the output stream");
        var1691875A0B15152BF366E3EE936B3627_1247955125.addTaint(taint);
        throw var1691875A0B15152BF366E3EE936B3627_1247955125;
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the output stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.788 -0400", hash_original_method = "0312DFF81C6978A2908F9B8EFDA3EFD4", hash_generated_method = "A20F32DD721D985D7FFB736E8E1BA440")
    public java.security.Permission getPermission() throws IOException {
java.security.Permission varAA4D4D55ABB29408F9384F4494AEC9E5_460069671 =         new java.security.AllPermission();
        varAA4D4D55ABB29408F9384F4494AEC9E5_460069671.addTaint(taint);
        return varAA4D4D55ABB29408F9384F4494AEC9E5_460069671;
        // ---------- Original Method ----------
        //return new java.security.AllPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.789 -0400", hash_original_method = "9BF81D9E57E4C63EDA2E82E6CB1EEED2", hash_generated_method = "2678039D2DB175BAE8A949B0F51FA8BC")
    public String getRequestProperty(String field) {
        addTaint(field.getTaint());
        checkNotConnected();
String var540C13E9E156B687226421B24F2DF178_1668407663 =         null;
        var540C13E9E156B687226421B24F2DF178_1668407663.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1668407663;
        // ---------- Original Method ----------
        //checkNotConnected();
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.789 -0400", hash_original_method = "2F8DA67F8DE7FED0345BBAE8C82F68E5", hash_generated_method = "81129F759FF9F99E25094FE561EA627D")
    public URL getURL() {
URL var4F9C62D322C7F68D5668056D4B193F9B_1250407080 =         url;
        var4F9C62D322C7F68D5668056D4B193F9B_1250407080.addTaint(taint);
        return var4F9C62D322C7F68D5668056D4B193F9B_1250407080;
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.790 -0400", hash_original_method = "2F69889B76EEFF99FBB9977BF19C64FC", hash_generated_method = "AB386732DF1C4FB0DCBF94911908037C")
    public boolean getUseCaches() {
        boolean var691C57F8E736BC3B73874BB05455D1C7_2140125094 = (useCaches);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_172392952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_172392952;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.791 -0400", hash_original_method = "8088F9069DED191ECB9FB0409A3793EB", hash_generated_method = "8356189A46AB835C44FF332D0AAC4822")
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
String varE65B3A02759122992CB82C0E651AD408_1635712945 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1635712945.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1635712945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.791 -0400", hash_original_method = "701213F9DAF865C1E161CA61CF705A45", hash_generated_method = "408F9F458C8E55460089B8BE6916EAA4")
    public void setAllowUserInteraction(boolean newValue) {
        checkNotConnected();
        this.allowUserInteraction = newValue;
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

    
        @DSModeled(DSC.SAFE)
    public static void setDefaultAllowUserInteraction(boolean allows) {
        defaultAllowUserInteraction = allows;
    }

    
        @DSModeled(DSC.SAFE)
    @Deprecated
    public static void setDefaultRequestProperty(String field, String value) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.793 -0400", hash_original_method = "850171EE0F333E1246D13E7B06ED7B4A", hash_generated_method = "436C41CBA1FB80C3D7958C86AC6952C6")
    public void setDefaultUseCaches(boolean newValue) {
        addTaint(newValue);
        defaultUseCaches = newValue;
        // ---------- Original Method ----------
        //defaultUseCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.793 -0400", hash_original_method = "3A49AB6E406CA8641E1DA3C376F73D42", hash_generated_method = "5479128F7387075B4F54BB3064B9DD25")
    public void setDoInput(boolean newValue) {
        checkNotConnected();
        this.doInput = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doInput = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.794 -0400", hash_original_method = "F9A1D9CFB149787BC9250701CAC2EC3A", hash_generated_method = "C87FEF41C96B6A34E93E22638F84D18D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.794 -0400", hash_original_method = "6F8DD71404577B87171F4310ACFD9CB3", hash_generated_method = "3C3BFEEA68FC926E1FD28F2EDF6381A6")
    public void setIfModifiedSince(long newValue) {
        checkNotConnected();
        this.ifModifiedSince = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.ifModifiedSince = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.795 -0400", hash_original_method = "EB8A856B35FAF51399B9B389D895E434", hash_generated_method = "EBAC14E00762DF1B8DBDECD2EC07DA3C")
    public void setRequestProperty(String field, String newValue) {
        addTaint(newValue.getTaint());
        addTaint(field.getTaint());
        checkNotConnected();
    if(field == null)        
        {
            NullPointerException varCE93C640A96638F050352C840C379BEB_238113286 = new NullPointerException("field == null");
            varCE93C640A96638F050352C840C379BEB_238113286.addTaint(taint);
            throw varCE93C640A96638F050352C840C379BEB_238113286;
        } //End block
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.796 -0400", hash_original_method = "36A4E65C2F0D12499DC505123F0CC423", hash_generated_method = "2C4942B39DE1BD013B5FC65E487DC4CE")
    public void setUseCaches(boolean newValue) {
        checkNotConnected();
        this.useCaches = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.useCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.796 -0400", hash_original_method = "6A558E4FD6643B6A2C9B278FD394A062", hash_generated_method = "BB034ADAAFAA2A8B78C5CEB778497F88")
    public void setConnectTimeout(int timeout) {
    if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_1835101925 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_1835101925.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_1835101925;
        } //End block
        this.connectTimeout = timeout;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.connectTimeout = timeout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.797 -0400", hash_original_method = "70B18BFD6BA7B76980125453BE48C7D1", hash_generated_method = "B2BD91F311DAC7F21565B23AED6DBFAB")
    public int getConnectTimeout() {
        int var23877A0B37BD98D5993CA98BD9204BD5_1877037726 = (connectTimeout);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719267932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719267932;
        // ---------- Original Method ----------
        //return connectTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.797 -0400", hash_original_method = "AFADA452D3B07139A9E1C4690AAC11B3", hash_generated_method = "42268CB6E624EBA7871EFB920FF924BD")
    public void setReadTimeout(int timeout) {
    if(timeout < 0)        
        {
            IllegalArgumentException varBA4E54C08633B7FB6474427FE4B69BA6_599242978 = new IllegalArgumentException("timeout < 0");
            varBA4E54C08633B7FB6474427FE4B69BA6_599242978.addTaint(taint);
            throw varBA4E54C08633B7FB6474427FE4B69BA6_599242978;
        } //End block
        this.readTimeout = timeout;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.readTimeout = timeout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.798 -0400", hash_original_method = "D3F0467D6BAB1E0CB8F37756E837EDFD", hash_generated_method = "823412B54EEDC6E8BE1DEB56E6EFD263")
    public int getReadTimeout() {
        int var8FC05721DCBB3B49F66A6D283A300B5B_1589096480 = (readTimeout);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950127306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950127306;
        // ---------- Original Method ----------
        //return readTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.798 -0400", hash_original_method = "C85D603FFD624A90EAB88172CE67727C", hash_generated_method = "0296E336699BD73FCD1BFBD569D860F7")
    @Override
    public String toString() {
String var6A8B79AC21D46F64E8FA95BADFC3BF6A_1256069019 =         getClass().getName() + ":" + url.toString();
        var6A8B79AC21D46F64E8FA95BADFC3BF6A_1256069019.addTaint(taint);
        return var6A8B79AC21D46F64E8FA95BADFC3BF6A_1256069019;
        // ---------- Original Method ----------
        //return getClass().getName() + ":" + url.toString();
    }

    
    static class DefaultContentHandler extends java.net.ContentHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.798 -0400", hash_original_method = "D9C7FF4AC457B32D0DB70E56925850DE", hash_generated_method = "D9C7FF4AC457B32D0DB70E56925850DE")
        public DefaultContentHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.798 -0400", hash_original_method = "AE84E807F7FC8D1C4CC894407353562A", hash_generated_method = "71C88D13EC6A32116635E05B5357EFD5")
        @Override
        public Object getContent(URLConnection u) throws IOException {
            addTaint(u.getTaint());
Object varEA60E7D94351E5F8174FE87AC3C07B53_350014757 =             u.getInputStream();
            varEA60E7D94351E5F8174FE87AC3C07B53_350014757.addTaint(taint);
            return varEA60E7D94351E5F8174FE87AC3C07B53_350014757;
            // ---------- Original Method ----------
            //return u.getInputStream();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.799 -0400", hash_original_field = "2EF9D74EDA056159EF28D8BEDB8E2029", hash_generated_field = "1A52F999A308188068C76D38BA5615EF")

    private static boolean defaultAllowUserInteraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.799 -0400", hash_original_field = "BDA43DE9887FC5B4AE2773879B6DC47D", hash_generated_field = "0745D91F58FAC663266DAFADF4C39A8B")

    private static boolean defaultUseCaches = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.799 -0400", hash_original_field = "5374745A15E146F670B4E156900FC280", hash_generated_field = "D42218022B7E3DD64D7C74B810FC8B3D")

    private static ContentHandlerFactory contentHandlerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.799 -0400", hash_original_field = "0DED07A99DDC83F010D0232F904AB185", hash_generated_field = "B35CCA371471EC5184868CE09D94475C")

    static Hashtable<String, Object> contentHandlers = new Hashtable<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.799 -0400", hash_original_field = "1F40A211288BCB20F811E6D3918ADD04", hash_generated_field = "E3E7D988476B274A9DF2166D8A8B4DFA")

    private static FileNameMap fileNameMap;
}

