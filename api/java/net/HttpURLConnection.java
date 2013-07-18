package java.net;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import libcore.net.http.HttpEngine;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class HttpURLConnection extends URLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.484 -0400", hash_original_field = "CA56706558142FC704CE89912339A740", hash_generated_field = "F06DE6E42C33023D5D9ACD62B7708D03")

    protected String method = HttpEngine.GET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.484 -0400", hash_original_field = "343D8113EC60F49B94DCB68676490D2B", hash_generated_field = "8B29EFDEBE881DE9494B414F5C05E649")

    protected int responseCode = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.484 -0400", hash_original_field = "C1E66B2C48B6FCDFA45BCBEAB51F2D59", hash_generated_field = "E5DB9E5C9FDAF202B17CFDE924A921F1")

    protected String responseMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.484 -0400", hash_original_field = "58160E63C579EF50E6AF730A51AB73C2", hash_generated_field = "809E761C93200C2583C6922826941A9E")

    protected boolean instanceFollowRedirects = followRedirects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.484 -0400", hash_original_field = "00E152074333A68E69921D909E0517F4", hash_generated_field = "77687C2C09882EC53E9F2E7D596A60DB")

    protected int chunkLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.485 -0400", hash_original_field = "5D27D54960AECEBB1F1A9D21386117A3", hash_generated_field = "BAF5159A87CC6A5E2AEF6B3E3AEA785A")

    protected int fixedContentLength = -1;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.485 -0400", hash_original_method = "58372EDCAE538607FC34A4F4F0582407", hash_generated_method = "EF30486123EAFC89CBD27123BFE65934")
    protected  HttpURLConnection(URL url) {
        super(url);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void disconnect();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.485 -0400", hash_original_method = "6640096D2D877ED3E740627246DA5AF9", hash_generated_method = "E2F41242360C6D80317E58CD46513355")
    public InputStream getErrorStream() {
InputStream var540C13E9E156B687226421B24F2DF178_953261749 =         null;
        var540C13E9E156B687226421B24F2DF178_953261749.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_953261749;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.487 -0400", hash_original_method = "ED24FB1ED5E1E919D525362B14A80DB6", hash_generated_method = "528529399447A69E30FAACEF49F15076")
    @Override
    public java.security.Permission getPermission() throws IOException {
        int port = url.getPort();
        if(port < 0)        
        {
            port = 80;
        } //End block
java.security.Permission varB773738882167D3068FEA8E0693C1D1A_1556748440 =         new SocketPermission(url.getHost() + ":" + port,
                "connect, resolve");
        varB773738882167D3068FEA8E0693C1D1A_1556748440.addTaint(taint);
        return varB773738882167D3068FEA8E0693C1D1A_1556748440;
        // ---------- Original Method ----------
        //int port = url.getPort();
        //if (port < 0) {
            //port = 80;
        //}
        //return new SocketPermission(url.getHost() + ":" + port,
                //"connect, resolve");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.487 -0400", hash_original_method = "0D9C6E3C645DAD49E763E30DD315D3EF", hash_generated_method = "49313A82D70B753F2DEB30C6805ED388")
    public String getRequestMethod() {
String var27E3C5B2D4A798771E5F53D6527EECD0_1061818332 =         method;
        var27E3C5B2D4A798771E5F53D6527EECD0_1061818332.addTaint(taint);
        return var27E3C5B2D4A798771E5F53D6527EECD0_1061818332;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.488 -0400", hash_original_method = "7D3B203196D55AEFB0033919830A54D2", hash_generated_method = "A2705FB7B663EA17A2B4F53985270981")
    public int getResponseCode() throws IOException {
        getInputStream();
        String response = getHeaderField(0);
        if(response == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_125736620 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_415300364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_415300364;
        } //End block
        response = response.trim();
        int mark = response.indexOf(" ") + 1;
        if(mark == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_905197564 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698007198 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698007198;
        } //End block
        int last = mark + 3;
        if(last > response.length())        
        {
            last = response.length();
        } //End block
        responseCode = Integer.parseInt(response.substring(mark, last));
        if(last + 1 <= response.length())        
        {
            responseMessage = response.substring(last + 1);
        } //End block
        int var30F8CC0A3AD81545F79B55CD4A8D8C8E_1210700707 = (responseCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121217320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121217320;
        // ---------- Original Method ----------
        //getInputStream();
        //String response = getHeaderField(0);
        //if (response == null) {
            //return -1;
        //}
        //response = response.trim();
        //int mark = response.indexOf(" ") + 1;
        //if (mark == 0) {
            //return -1;
        //}
        //int last = mark + 3;
        //if (last > response.length()) {
            //last = response.length();
        //}
        //responseCode = Integer.parseInt(response.substring(mark, last));
        //if (last + 1 <= response.length()) {
            //responseMessage = response.substring(last + 1);
        //}
        //return responseCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.489 -0400", hash_original_method = "2B517AE93F70715BB09FC42E79EE9551", hash_generated_method = "CBAEBB4B9F79DDF6B6B1C28EA1197E75")
    public String getResponseMessage() throws IOException {
        if(responseMessage != null)        
        {
String var0EA3F56E6B543F51FDF09BD18CE60D5C_1239228370 =             responseMessage;
            var0EA3F56E6B543F51FDF09BD18CE60D5C_1239228370.addTaint(taint);
            return var0EA3F56E6B543F51FDF09BD18CE60D5C_1239228370;
        } //End block
        getResponseCode();
String var0EA3F56E6B543F51FDF09BD18CE60D5C_1931824519 =         responseMessage;
        var0EA3F56E6B543F51FDF09BD18CE60D5C_1931824519.addTaint(taint);
        return var0EA3F56E6B543F51FDF09BD18CE60D5C_1931824519;
        // ---------- Original Method ----------
        //if (responseMessage != null) {
            //return responseMessage;
        //}
        //getResponseCode();
        //return responseMessage;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setFollowRedirects(boolean auto) {
        followRedirects = auto;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.490 -0400", hash_original_method = "3B5EB6833E70FFDCB063E860A5177AF6", hash_generated_method = "D6FFA66AEC133516A6CFE9AFDFDAC420")
    public void setRequestMethod(String method) throws ProtocolException {
        if(connected)        
        {
            ProtocolException varB6423A717568BBA89D85070594A5973A_1959072785 = new ProtocolException("Connection already established");
            varB6423A717568BBA89D85070594A5973A_1959072785.addTaint(taint);
            throw varB6423A717568BBA89D85070594A5973A_1959072785;
        } //End block
for(String permittedUserMethod : PERMITTED_USER_METHODS)
        {
            if(permittedUserMethod.equals(method))            
            {
                this.method = permittedUserMethod;
                return;
            } //End block
        } //End block
        ProtocolException var745FCF10B233548D766C61B42140A77C_1476320452 = new ProtocolException("Unknown method '" + method + "'; must be one of " +
                Arrays.toString(PERMITTED_USER_METHODS));
        var745FCF10B233548D766C61B42140A77C_1476320452.addTaint(taint);
        throw var745FCF10B233548D766C61B42140A77C_1476320452;
        // ---------- Original Method ----------
        //if (connected) {
            //throw new ProtocolException("Connection already established");
        //}
        //for (String permittedUserMethod : PERMITTED_USER_METHODS) {
            //if (permittedUserMethod.equals(method)) {
                //this.method = permittedUserMethod;
                //return;
            //}
        //}
        //throw new ProtocolException("Unknown method '" + method + "'; must be one of " +
                //Arrays.toString(PERMITTED_USER_METHODS));
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean usingProxy();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.490 -0400", hash_original_method = "17A4A6C99056147BEFFA252CAD4737D6", hash_generated_method = "B9A32E6612D838A4EE193987F3BD06BE")
    @Override
    public String getContentEncoding() {
String var636F640217A2586C23C7303E786B88FE_366726606 =         super.getContentEncoding();
        var636F640217A2586C23C7303E786B88FE_366726606.addTaint(taint);
        return var636F640217A2586C23C7303E786B88FE_366726606;
        // ---------- Original Method ----------
        //return super.getContentEncoding();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.491 -0400", hash_original_method = "881D26516B84F6D6EEADB518A168ADE5", hash_generated_method = "8F59B48BA79120BA6D64A4DFB82B94E2")
    public boolean getInstanceFollowRedirects() {
        boolean var2023E717DDE450AF2AE0C63A1BCD60DA_1364359109 = (instanceFollowRedirects);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689026685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689026685;
        // ---------- Original Method ----------
        //return instanceFollowRedirects;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.491 -0400", hash_original_method = "BB71B8E9C2D3F0EF20C7720F9E44016D", hash_generated_method = "A4E72D6C11951C7D0B323DF1D1093EEE")
    public void setInstanceFollowRedirects(boolean followRedirects) {
        instanceFollowRedirects = followRedirects;
        // ---------- Original Method ----------
        //instanceFollowRedirects = followRedirects;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.491 -0400", hash_original_method = "6E2F3B7733832056F416A461A3655623", hash_generated_method = "35442E7DE8E5A1AABDCAFFFAED21C779")
    @Override
    public long getHeaderFieldDate(String field, long defaultValue) {
        addTaint(defaultValue);
        addTaint(field.getTaint());
        long var76493ED3C4DE1E696F995CF6A64B9FC1_1695986943 = (super.getHeaderFieldDate(field, defaultValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_204485227 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_204485227;
        // ---------- Original Method ----------
        //return super.getHeaderFieldDate(field, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.491 -0400", hash_original_method = "746797ABBB47B5E996C092A3E4D56421", hash_generated_method = "A39A95A57F9C530B43BF4736FD7B2FE8")
    public void setFixedLengthStreamingMode(int contentLength) {
        if(super.connected)        
        {
            IllegalStateException varA63B9CEF256810621025D7CDF0DCD664_309585092 = new IllegalStateException("Already connected");
            varA63B9CEF256810621025D7CDF0DCD664_309585092.addTaint(taint);
            throw varA63B9CEF256810621025D7CDF0DCD664_309585092;
        } //End block
        if(chunkLength > 0)        
        {
            IllegalStateException varADDC73322BFBFE9BB5C51AE89B398106_1993376940 = new IllegalStateException("Already in chunked mode");
            varADDC73322BFBFE9BB5C51AE89B398106_1993376940.addTaint(taint);
            throw varADDC73322BFBFE9BB5C51AE89B398106_1993376940;
        } //End block
        if(contentLength < 0)        
        {
            IllegalArgumentException var93585202CEC78E81C5BF1DA1E2D2B2AE_1856643629 = new IllegalArgumentException("contentLength < 0");
            var93585202CEC78E81C5BF1DA1E2D2B2AE_1856643629.addTaint(taint);
            throw var93585202CEC78E81C5BF1DA1E2D2B2AE_1856643629;
        } //End block
        this.fixedContentLength = contentLength;
        // ---------- Original Method ----------
        //if (super.connected) {
            //throw new IllegalStateException("Already connected");
        //}
        //if (chunkLength > 0) {
            //throw new IllegalStateException("Already in chunked mode");
        //}
        //if (contentLength < 0) {
            //throw new IllegalArgumentException("contentLength < 0");
        //}
        //this.fixedContentLength = contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.492 -0400", hash_original_method = "21470E1D7A697F6C3367E1B80C1F2447", hash_generated_method = "DEBE80E8F58FD54C250D07E5CE095553")
    public void setChunkedStreamingMode(int chunkLength) {
        if(super.connected)        
        {
            IllegalStateException varA63B9CEF256810621025D7CDF0DCD664_771090320 = new IllegalStateException("Already connected");
            varA63B9CEF256810621025D7CDF0DCD664_771090320.addTaint(taint);
            throw varA63B9CEF256810621025D7CDF0DCD664_771090320;
        } //End block
        if(fixedContentLength >= 0)        
        {
            IllegalStateException varE4FBACB36A7737DB40BE38159E39D020_954007129 = new IllegalStateException("Already in fixed-length mode");
            varE4FBACB36A7737DB40BE38159E39D020_954007129.addTaint(taint);
            throw varE4FBACB36A7737DB40BE38159E39D020_954007129;
        } //End block
        if(chunkLength <= 0)        
        {
            this.chunkLength = HttpEngine.DEFAULT_CHUNK_LENGTH;
        } //End block
        else
        {
            this.chunkLength = chunkLength;
        } //End block
        // ---------- Original Method ----------
        //if (super.connected) {
            //throw new IllegalStateException("Already connected");
        //}
        //if (fixedContentLength >= 0) {
            //throw new IllegalStateException("Already in fixed-length mode");
        //}
        //if (chunkLength <= 0) {
            //this.chunkLength = HttpEngine.DEFAULT_CHUNK_LENGTH;
        //} else {
            //this.chunkLength = chunkLength;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.493 -0400", hash_original_field = "4D151438718964384DC3D27D739C4EC0", hash_generated_field = "F1D43D7AF10CD2CFD98F375B3A27D9E2")

    private static final String[] PERMITTED_USER_METHODS = {
            HttpEngine.OPTIONS,
            HttpEngine.GET,
            HttpEngine.HEAD,
            HttpEngine.POST,
            HttpEngine.PUT,
            HttpEngine.DELETE,
            HttpEngine.TRACE
            
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.493 -0400", hash_original_field = "674085B4216012519B2FBC98E7656E8B", hash_generated_field = "B6B148D800DA01B94858FBCF1FB7DA47")

    private static boolean followRedirects = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.493 -0400", hash_original_field = "9C5CC481D1252265CE7ED3813B129C30", hash_generated_field = "C21AC049C6E3CBCF4611D4B8204D3406")

    public static final int HTTP_ACCEPTED = 202;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.493 -0400", hash_original_field = "192D567D4855BA96CE8C003B1DFA871F", hash_generated_field = "9864CA3F5FB31C39804E7466BA3CD139")

    public static final int HTTP_BAD_GATEWAY = 502;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.493 -0400", hash_original_field = "450F6FC27548447DBCB0665B982A29CA", hash_generated_field = "696A2E951293D6CD9261D6B05486691E")

    public static final int HTTP_BAD_METHOD = 405;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.493 -0400", hash_original_field = "05B8E7BF6611008DB451FB026B3FD51E", hash_generated_field = "5577B38F7E0C48DFB42FE39AEF31D544")

    public static final int HTTP_BAD_REQUEST = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.493 -0400", hash_original_field = "36BBFBF28ADA4D209DE952DEA52EB353", hash_generated_field = "63A04887E330E4F535339E1E5BCF5FDD")

    public static final int HTTP_CLIENT_TIMEOUT = 408;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.494 -0400", hash_original_field = "352C73982169A1FADA8AC72440586E03", hash_generated_field = "0767719730997B49271B736544301776")

    public static final int HTTP_CONFLICT = 409;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.494 -0400", hash_original_field = "7EB7CF6DCAF61D895597522663369413", hash_generated_field = "E0DF1F490D7179E22226073461AD67B5")

    public static final int HTTP_CREATED = 201;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.494 -0400", hash_original_field = "1A56A33A0BA53CFA58298753586D3CDB", hash_generated_field = "FD6C34742CF4690CA78A254B5256C694")

    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.494 -0400", hash_original_field = "91A4691F3BE0838D636C2283E02051EC", hash_generated_field = "BAAF308A424CA9ACE2FAAE31C54AFC7F")

    public static final int HTTP_FORBIDDEN = 403;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.494 -0400", hash_original_field = "DA5C3DDB96C498849F9E8BF83C9186C5", hash_generated_field = "8CDD0FC1C367EA9D2C8D75383F450447")

    public static final int HTTP_GATEWAY_TIMEOUT = 504;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.494 -0400", hash_original_field = "59C6423382FE7C51C817DDCA1150B02F", hash_generated_field = "7BBF798C1FD94676CE47A165F97359C4")

    public static final int HTTP_GONE = 410;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.498 -0400", hash_original_field = "FD526F03AD048274984454EAEE960005", hash_generated_field = "F01C8443DA02D3A267D3E058CCB1F504")

    public static final int HTTP_INTERNAL_ERROR = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.498 -0400", hash_original_field = "563B201185A97D41FFEC9E813D679F7E", hash_generated_field = "0DCDC89059EE26376A2549D30E897CBB")

    public static final int HTTP_LENGTH_REQUIRED = 411;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.498 -0400", hash_original_field = "3645A5257A6E8C682D1A8486DBBB2E25", hash_generated_field = "850977F848B556A14BE3FA0DA2ADAD18")

    public static final int HTTP_MOVED_PERM = 301;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "B9B8C11A1E1252613F8FED80FD299913", hash_generated_field = "F6577310447CF3C587C37765B2784E79")

    public static final int HTTP_MOVED_TEMP = 302;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "CCCCBB76AB725FB9C411D970D60F1935", hash_generated_field = "469D3D9BE99C408D2FA7961787A207EF")

    public static final int HTTP_MULT_CHOICE = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "42046FD12366B409BA12B272C5A3E107", hash_generated_field = "B2FC3A8B3E42A9E9D38E54A3702BEB16")

    public static final int HTTP_NO_CONTENT = 204;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "2EECA4AE200A0FA5C1666F378F23ED77", hash_generated_field = "B40E3B5B40334E6092B9B6D34B7C538E")

    public static final int HTTP_NOT_ACCEPTABLE = 406;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "DF4169D18E229824E4CC44B39BBD65D0", hash_generated_field = "D27B485062E6EC655CD2B4E91A01411F")

    public static final int HTTP_NOT_AUTHORITATIVE = 203;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "B970EF697AC248BDAD36A5826B50E965", hash_generated_field = "DA61F60B79920B39A724C61DCBD4C785")

    public static final int HTTP_NOT_FOUND = 404;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "2AF43E6F914ABB9F1B5E6546244DC598", hash_generated_field = "5AF86F1E70BBDB2DDA175ACE4BE74EB2")

    public static final int HTTP_NOT_IMPLEMENTED = 501;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "0FF390CB90ACDFA99B5AA910382219DE", hash_generated_field = "09621F5A75F08E6A479373F764583267")

    public static final int HTTP_NOT_MODIFIED = 304;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "4800DC2FC1B39792E563783C8F6B5A15", hash_generated_field = "B28A869494D6F2BB4C3309364352E925")

    public static final int HTTP_OK = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "451B30E8211B6CAA98DDA4E72C383C72", hash_generated_field = "9470102D6735C74C850CC62FFAC35505")

    public static final int HTTP_PARTIAL = 206;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "4CFC477F0BB3E7A6D65AEA16CA28CCBA", hash_generated_field = "623DAA6CF22D74D5117D76A4E14DBB31")

    public static final int HTTP_PAYMENT_REQUIRED = 402;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "5727DCE8EF1A13374E624AD58B826EEE", hash_generated_field = "03F7F1E288750056447A9AEE3777CB82")

    public static final int HTTP_PRECON_FAILED = 412;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "63AD218BFAC63DB6FD5C0ED2F32ADDA7", hash_generated_field = "1D204D4BD4AB01CF4D5CCF382B338CA2")

    public static final int HTTP_PROXY_AUTH = 407;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "6DE52919F00B8C8CA8391D17183A5F4A", hash_generated_field = "1C15FD99A982DB822D82F55EC13E7655")

    public static final int HTTP_REQ_TOO_LONG = 414;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "7B2E0210C45F2F541B492BDA3215511B", hash_generated_field = "654DDA09165022891332C495EEA0BCAA")

    public static final int HTTP_RESET = 205;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "181D1EAE3C8C62D9A4E824819B863C2E", hash_generated_field = "DCCCB9D9FAB840DC0E6E2A8B18DF7B1B")

    public static final int HTTP_SEE_OTHER = 303;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.499 -0400", hash_original_field = "B4ABAA58A600A368013FF2E96E6C8D47", hash_generated_field = "3420A19DE136753A76C8A86911BDE6EA")

    @Deprecated
    public static final int HTTP_SERVER_ERROR = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.500 -0400", hash_original_field = "D36BE5673499645F4A409A50013B3623", hash_generated_field = "30A12FC36C0F6722154FAAA6F4948E03")

    public static final int HTTP_USE_PROXY = 305;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.500 -0400", hash_original_field = "3332777CEA4D91403AC6EEF5491EFEEF", hash_generated_field = "D598D4ED4CC6F37F7F263CD950F7880A")

    public static final int HTTP_UNAUTHORIZED = 401;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.500 -0400", hash_original_field = "5269B1B5A9030488B5B1381063B220B4", hash_generated_field = "F9830A7FB26A343C08DADEA53699DDD4")

    public static final int HTTP_UNSUPPORTED_TYPE = 415;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.500 -0400", hash_original_field = "15B2CF1EE60572D44750F2AD9F0A0B82", hash_generated_field = "3465A3FC0C00178A095C5D45D5849D57")

    public static final int HTTP_UNAVAILABLE = 503;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.500 -0400", hash_original_field = "88283FC04068A4A5EF99F434E7F3A588", hash_generated_field = "9D040EB72BD3FB6AFC1CBAC843DD69E3")

    public static final int HTTP_VERSION = 505;
}

