package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.io.IoUtils;

public final class Scanner implements Iterator<String> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.850 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "E0D52F97F351E69EECDE3C383EA70269")

    private Readable input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.850 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "D260AE04E52CF23D72C8A3D8295E450B")

    private CharBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.850 -0400", hash_original_field = "B8E0CA1AFB60AD862E8369C4D5F39FEA", hash_generated_field = "7320765086863239DD8B2CE732355E5C")

    private Pattern delimiter = DEFAULT_DELIMITER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.850 -0400", hash_original_field = "FDB7D6BFCC3EFCF7BA578D70678C9F4B", hash_generated_field = "B6C086223608E4F54F76DF9A158EFEB4")

    private Matcher matcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.850 -0400", hash_original_field = "FA9861E386E410DF8EB9AD9D2561E649", hash_generated_field = "C3DABC3C885E91F4BEBE65D18A5D41DF")

    private int integerRadix = DEFAULT_RADIX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.850 -0400", hash_original_field = "C1406C33C5F41CED8E9C966043746C79", hash_generated_field = "E93B6DD8D2B917BF94B1E13ADC86BBF9")

    private Locale locale = Locale.getDefault();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.850 -0400", hash_original_field = "CA1A63C6156AD6EA04F7B3D6A296C793", hash_generated_field = "08240EC224E7D1F658B6C3E2B561656E")

    private int findStartIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "85E47497E5075EC4FAD041D1AC3E7907", hash_generated_field = "6421FE0EA4BD2B6775B9AA3004FC3126")

    private int preStartIndex = findStartIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "F4B7711D92CBAB86DA3D6B89D16B006B", hash_generated_field = "C005C413DDA0AFEE3D457FA4BFDF129F")

    private int bufferLength = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "460DFB1105EAD6E581494BC8EB7172AC", hash_generated_field = "94160D1F6EC5CF5867F2CCE7946E9FCB")

    private IOException lastIOException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "4B9929219B077CB687C4CDA9B01D2231", hash_generated_field = "FB51DEF3DC08BBEC5FA219733A95DF92")

    private boolean matchSuccessful = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "DBECB303151001B254CD458C962BFA06", hash_generated_field = "5CD50592C114680F0C3429A3015DD789")

    private DecimalFormat decimalFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "A0533E79DCA29CE143919C4A4025A07C", hash_generated_field = "835E9638D88C3871B5D667F83042A305")

    private boolean inputExhausted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "C1D78FE4623EB325FEA6F819E294DAD7", hash_generated_field = "16846571F2386772C11DF4DB11C6F290")

    private Object cacheHasNextValue = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_field = "34E465836A10E49DF126E5F70F0785FC", hash_generated_field = "890CB8D9E7ACCC8E639BDCEBE76016CB")

    private int cachehasNextIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.851 -0400", hash_original_method = "B810C33BB807151E40D15163250E5E02", hash_generated_method = "321539E3B9BA845EF9F76541A8DBF8C3")
    public  Scanner(File src) throws FileNotFoundException {
        this(src, Charset.defaultCharset().name());
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.852 -0400", hash_original_method = "CF25217F399E81A22DEECAEA7B649FFD", hash_generated_method = "0D4664DE1AE731D3F42D9F7A9F678CEC")
    public  Scanner(File src, String charsetName) throws FileNotFoundException {
        addTaint(src.getTaint());
    if(src == null)        
        {
            NullPointerException var2D07B1D654A343534339A4B66E26F519_1203784697 = new NullPointerException("src == null");
            var2D07B1D654A343534339A4B66E26F519_1203784697.addTaint(taint);
            throw var2D07B1D654A343534339A4B66E26F519_1203784697;
        } //End block
        FileInputStream fis = new FileInputStream(src);
    if(charsetName == null)        
        {
            IllegalArgumentException varFF9DC8EEABA015CA50BA498EA11F36E9_657392501 = new IllegalArgumentException("charsetName == null");
            varFF9DC8EEABA015CA50BA498EA11F36E9_657392501.addTaint(taint);
            throw varFF9DC8EEABA015CA50BA498EA11F36E9_657392501;
        } //End block
        try 
        {
            input = new InputStreamReader(fis, charsetName);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            IoUtils.closeQuietly(fis);
            IllegalArgumentException var50C16F62C7E45E44DBD26FE32DDFD217_2004699451 = new IllegalArgumentException(e.getMessage());
            var50C16F62C7E45E44DBD26FE32DDFD217_2004699451.addTaint(taint);
            throw var50C16F62C7E45E44DBD26FE32DDFD217_2004699451;
        } //End block
        initialization();
        // ---------- Original Method ----------
        //if (src == null) {
            //throw new NullPointerException("src == null");
        //}
        //FileInputStream fis = new FileInputStream(src);
        //if (charsetName == null) {
            //throw new IllegalArgumentException("charsetName == null");
        //}
        //try {
            //input = new InputStreamReader(fis, charsetName);
        //} catch (UnsupportedEncodingException e) {
            //IoUtils.closeQuietly(fis);
            //throw new IllegalArgumentException(e.getMessage());
        //}
        //initialization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.853 -0400", hash_original_method = "4332C70F225A92CAAA372FEA2EE20E90", hash_generated_method = "B648128C94F00F07C9AB0502C3851792")
    public  Scanner(String src) {
        input = new StringReader(src);
        initialization();
        // ---------- Original Method ----------
        //input = new StringReader(src);
        //initialization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.853 -0400", hash_original_method = "C892D51D9056C33835D132934536F6A9", hash_generated_method = "29915AE179E011A2C0282BFECF6B6B0F")
    public  Scanner(InputStream src) {
        this(src, Charset.defaultCharset().name());
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.853 -0400", hash_original_method = "BF515108409EAD1D2D6060053F2B8EDA", hash_generated_method = "4E314E8984E6863A91D87717E8AD3ED2")
    public  Scanner(InputStream src, String charsetName) {
    if(src == null)        
        {
            NullPointerException var2D07B1D654A343534339A4B66E26F519_1608641056 = new NullPointerException("src == null");
            var2D07B1D654A343534339A4B66E26F519_1608641056.addTaint(taint);
            throw var2D07B1D654A343534339A4B66E26F519_1608641056;
        } //End block
        try 
        {
            input = new InputStreamReader(src, charsetName);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            IllegalArgumentException var50C16F62C7E45E44DBD26FE32DDFD217_1494244297 = new IllegalArgumentException(e.getMessage());
            var50C16F62C7E45E44DBD26FE32DDFD217_1494244297.addTaint(taint);
            throw var50C16F62C7E45E44DBD26FE32DDFD217_1494244297;
        } //End block
        initialization();
        // ---------- Original Method ----------
        //if (src == null) {
            //throw new NullPointerException("src == null");
        //}
        //try {
            //input = new InputStreamReader(src, charsetName);
        //} catch (UnsupportedEncodingException e) {
            //throw new IllegalArgumentException(e.getMessage());
        //}
        //initialization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.854 -0400", hash_original_method = "E0E6972A58007CF9E26777BD359FD5D7", hash_generated_method = "857EC357668DDF9717864E3F590BD06B")
    public  Scanner(Readable src) {
    if(src == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1886548681 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1886548681.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1886548681;
        } //End block
        input = src;
        initialization();
        // ---------- Original Method ----------
        //if (src == null) {
            //throw new NullPointerException();
        //}
        //input = src;
        //initialization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.854 -0400", hash_original_method = "246C896BCE9403BE34073893721DED9F", hash_generated_method = "24C2F70730EE9356054D047DBB43A0CE")
    public  Scanner(ReadableByteChannel src) {
        this(src, Charset.defaultCharset().name());
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.855 -0400", hash_original_method = "88C5EB3CF5CA9A4257014ADC8E6F132C", hash_generated_method = "8EDA7AE49E259FAF2F1B701923AE3C21")
    public  Scanner(ReadableByteChannel src, String charsetName) {
    if(src == null)        
        {
            NullPointerException var2D07B1D654A343534339A4B66E26F519_865196764 = new NullPointerException("src == null");
            var2D07B1D654A343534339A4B66E26F519_865196764.addTaint(taint);
            throw var2D07B1D654A343534339A4B66E26F519_865196764;
        } //End block
    if(charsetName == null)        
        {
            IllegalArgumentException varFF9DC8EEABA015CA50BA498EA11F36E9_1038235600 = new IllegalArgumentException("charsetName == null");
            varFF9DC8EEABA015CA50BA498EA11F36E9_1038235600.addTaint(taint);
            throw varFF9DC8EEABA015CA50BA498EA11F36E9_1038235600;
        } //End block
        input = Channels.newReader(src, charsetName);
        initialization();
        // ---------- Original Method ----------
        //if (src == null) {
            //throw new NullPointerException("src == null");
        //}
        //if (charsetName == null) {
            //throw new IllegalArgumentException("charsetName == null");
        //}
        //input = Channels.newReader(src, charsetName);
        //initialization();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.855 -0400", hash_original_method = "BE0E5A82355C52347C0C57A7BA02C4C5", hash_generated_method = "FD966E343C742ADB54E79FDF754C3866")
    public void close() {
    if(closed)        
        {
            return;
        } //End block
    if(input instanceof Closeable)        
        {
            try 
            {
                ((Closeable) input).close();
            } //End block
            catch (IOException e)
            {
                lastIOException = e;
            } //End block
        } //End block
        closed = true;
        // ---------- Original Method ----------
        //if (closed) {
            //return;
        //}
        //if (input instanceof Closeable) {
            //try {
                //((Closeable) input).close();
            //} catch (IOException e) {
                //lastIOException = e;
            //}
        //}
        //closed = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.855 -0400", hash_original_method = "E452C40637B7AD54EC03E79C646861D9", hash_generated_method = "927B79D574A18E8AAD6E5E0BC25C74E4")
    public Pattern delimiter() {
Pattern var77605B888C3EF78D6C12E459BDBBB2B6_1700308507 =         delimiter;
        var77605B888C3EF78D6C12E459BDBBB2B6_1700308507.addTaint(taint);
        return var77605B888C3EF78D6C12E459BDBBB2B6_1700308507;
        // ---------- Original Method ----------
        //return delimiter;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.857 -0400", hash_original_method = "8312FC53E313435440A1A7306CBE2B24", hash_generated_method = "F6F46B5F8536C9803C647A673F9BE6C7")
    public String findInLine(Pattern pattern) {
        addTaint(pattern.getTaint());
        checkClosed();
        checkNull(pattern);
        int horizonLineSeparator = 0;
        matcher.usePattern(MULTI_LINE_TERMINATOR);
        matcher.region(findStartIndex, bufferLength);
        boolean findComplete = false;
        int terminatorLength = 0;
        while
(!findComplete)        
        {
    if(matcher.find())            
            {
                horizonLineSeparator = matcher.start();
                terminatorLength = matcher.end() - matcher.start();
                findComplete = true;
            } //End block
            else
            {
    if(!inputExhausted)                
                {
                    readMore();
                    resetMatcher();
                } //End block
                else
                {
                    horizonLineSeparator = bufferLength;
                    findComplete = true;
                } //End block
            } //End block
        } //End block
        matcher.usePattern(pattern);
        int oldLimit = buffer.limit();
        buffer.limit(horizonLineSeparator + terminatorLength);
        matcher.region(findStartIndex, horizonLineSeparator + terminatorLength);
    if(matcher.find())        
        {
            findStartIndex = matcher.end();
    if(horizonLineSeparator == matcher.end())            
            {
                findStartIndex += terminatorLength;
            } //End block
    if(horizonLineSeparator != bufferLength
                    && (horizonLineSeparator + terminatorLength == matcher
                            .end()))            
            {
                buffer.limit(oldLimit);
                matchSuccessful = false;
String var540C13E9E156B687226421B24F2DF178_412921984 =                 null;
                var540C13E9E156B687226421B24F2DF178_412921984.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_412921984;
            } //End block
            matchSuccessful = true;
            buffer.limit(oldLimit);
String varB5AAE48376C24FBB3ED941DE034F616C_1921366849 =             matcher.group();
            varB5AAE48376C24FBB3ED941DE034F616C_1921366849.addTaint(taint);
            return varB5AAE48376C24FBB3ED941DE034F616C_1921366849;
        } //End block
        buffer.limit(oldLimit);
        matchSuccessful = false;
String var540C13E9E156B687226421B24F2DF178_1217014441 =         null;
        var540C13E9E156B687226421B24F2DF178_1217014441.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1217014441;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.857 -0400", hash_original_method = "D8B205142F30EEA5F1FA557732B63716", hash_generated_method = "E36B527B88E3152D1C5465106BA3650C")
    public String findInLine(String pattern) {
        addTaint(pattern.getTaint());
String var20EEC46E915BD4AF22F9D0C811864F43_10271203 =         findInLine(Pattern.compile(pattern));
        var20EEC46E915BD4AF22F9D0C811864F43_10271203.addTaint(taint);
        return var20EEC46E915BD4AF22F9D0C811864F43_10271203;
        // ---------- Original Method ----------
        //return findInLine(Pattern.compile(pattern));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.858 -0400", hash_original_method = "9C32C72D7AABC6AF4F26B68B84901E99", hash_generated_method = "9735AA951489797D8291DD4773AB6B5D")
    public String findWithinHorizon(Pattern pattern, int horizon) {
        addTaint(horizon);
        addTaint(pattern.getTaint());
        checkClosed();
        checkNull(pattern);
    if(horizon < 0)        
        {
            IllegalArgumentException var6B71F6AB3C11E05471F7D7A2ADAE7B0E_1329014014 = new IllegalArgumentException("horizon < 0");
            var6B71F6AB3C11E05471F7D7A2ADAE7B0E_1329014014.addTaint(taint);
            throw var6B71F6AB3C11E05471F7D7A2ADAE7B0E_1329014014;
        } //End block
        matcher.usePattern(pattern);
        String result = null;
        int findEndIndex = 0;
        int horizonEndIndex = 0;
    if(horizon == 0)        
        {
            horizonEndIndex = Integer.MAX_VALUE;
        } //End block
        else
        {
            horizonEndIndex = findStartIndex + horizon;
        } //End block
        while
(true)        
        {
            findEndIndex = bufferLength;
            findEndIndex = Math.min(horizonEndIndex, bufferLength);
            boolean isHorizonInBuffer = (horizonEndIndex <= bufferLength);
            matcher.region(findStartIndex, findEndIndex);
    if(matcher.find())            
            {
    if(isHorizonInBuffer || inputExhausted)                
                {
                    result = matcher.group();
                    break;
                } //End block
            } //End block
            else
            {
    if(isHorizonInBuffer || inputExhausted)                
                {
                    break;
                } //End block
            } //End block
    if(!inputExhausted)            
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
    if(result != null)        
        {
            findStartIndex = matcher.end();
            matchSuccessful = true;
        } //End block
        else
        {
            matchSuccessful = false;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_185597557 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_185597557.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_185597557;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.859 -0400", hash_original_method = "A3C55B99475A85AD2BF4742E957D07D7", hash_generated_method = "A74D5D4EF518969B4B34D68C7B30E0F5")
    public String findWithinHorizon(String pattern, int horizon) {
        addTaint(horizon);
        addTaint(pattern.getTaint());
String var625811C6FEA063078499B45918DC71F9_532365711 =         findWithinHorizon(Pattern.compile(pattern), horizon);
        var625811C6FEA063078499B45918DC71F9_532365711.addTaint(taint);
        return var625811C6FEA063078499B45918DC71F9_532365711;
        // ---------- Original Method ----------
        //return findWithinHorizon(Pattern.compile(pattern), horizon);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.859 -0400", hash_original_method = "A3E9F8A3E3BBCA86A059EA14ECB05A95", hash_generated_method = "32312A3806CBB067AFFF0102646D57A1")
    public boolean hasNext() {
        boolean var4BD81B08EA815004EBDAA22E0DD0D90F_1178181670 = (hasNext(ANY_PATTERN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682859476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682859476;
        // ---------- Original Method ----------
        //return hasNext(ANY_PATTERN);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.860 -0400", hash_original_method = "31E7CF1F7239BC857AE7CC1A1F63EEFE", hash_generated_method = "8544590487D20438590AEFF4F6E9C12F")
    public boolean hasNext(Pattern pattern) {
        addTaint(pattern.getTaint());
        checkClosed();
        checkNull(pattern);
        matchSuccessful = false;
        saveCurrentStatus();
    if(!setTokenRegion())        
        {
            recoverPreviousStatus();
            boolean var68934A3E9455FA72420237EB05902327_1627602538 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302016860 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_302016860;
        } //End block
        matcher.usePattern(pattern);
        boolean hasNext = false;
    if(matcher.matches())        
        {
            cachehasNextIndex = findStartIndex;
            matchSuccessful = true;
            hasNext = true;
        } //End block
        recoverPreviousStatus();
        boolean varD9CA95405A2301707BEA3F2942FAB48B_1042258248 = (hasNext);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922283685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922283685;
        // ---------- Original Method ----------
        //checkClosed();
        //checkNull(pattern);
        //matchSuccessful = false;
        //saveCurrentStatus();
        //if (!setTokenRegion()) {
            //recoverPreviousStatus();
            //return false;
        //}
        //matcher.usePattern(pattern);
        //boolean hasNext = false;
        //if (matcher.matches()) {
            //cachehasNextIndex = findStartIndex;
            //matchSuccessful = true;
            //hasNext = true;
        //}
        //recoverPreviousStatus();
        //return hasNext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.860 -0400", hash_original_method = "9958A7260053054A7CE88A67057D0BAF", hash_generated_method = "F2DA6387158C3EF70D8DE3ACABD672E2")
    public boolean hasNext(String pattern) {
        addTaint(pattern.getTaint());
        boolean var89EF6F604CD6F3E6CBD980D731FFE7BE_1465493429 = (hasNext(Pattern.compile(pattern)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976796332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976796332;
        // ---------- Original Method ----------
        //return hasNext(Pattern.compile(pattern));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.861 -0400", hash_original_method = "725531718FDC15B509CB20755672217B", hash_generated_method = "B6302AB9CE76BB4E73F2A2CE9B7A3038")
    public boolean hasNextBigDecimal() {
        Pattern floatPattern = getFloatPattern();
        boolean isBigDecimalValue = false;
    if(hasNext(floatPattern))        
        {
            String floatString = matcher.group();
            floatString = removeLocaleInfoFromFloat(floatString);
            try 
            {
                cacheHasNextValue = new BigDecimal(floatString);
                isBigDecimalValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean var1FD60F90C8EF781F71C419DDA1546C50_1275238413 = (isBigDecimalValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684725151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_684725151;
        // ---------- Original Method ----------
        //Pattern floatPattern = getFloatPattern();
        //boolean isBigDecimalValue = false;
        //if (hasNext(floatPattern)) {
            //String floatString = matcher.group();
            //floatString = removeLocaleInfoFromFloat(floatString);
            //try {
                //cacheHasNextValue = new BigDecimal(floatString);
                //isBigDecimalValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isBigDecimalValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.861 -0400", hash_original_method = "E4D3C235D8E1DAFC304BAA9FB6E2754B", hash_generated_method = "2BA58025D781F5D0A9A437DA5B4B7B7B")
    public boolean hasNextBigInteger() {
        boolean var64635BE6E974D8063B7B707E1DCB64A7_622150907 = (hasNextBigInteger(integerRadix));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448131547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448131547;
        // ---------- Original Method ----------
        //return hasNextBigInteger(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.862 -0400", hash_original_method = "C25E77B6A38D1DC9BA3B0FA0BBEC50D5", hash_generated_method = "5CC1009BA8A16F4284F7EF5FFB73E99F")
    public boolean hasNextBigInteger(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isBigIntegerValue = false;
    if(hasNext(integerPattern))        
        {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try 
            {
                cacheHasNextValue = new BigInteger(intString, radix);
                isBigIntegerValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean varD3BFD38C6AF5CCDF65C670000ACADAFD_1701965803 = (isBigIntegerValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432057608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432057608;
        // ---------- Original Method ----------
        //Pattern integerPattern = getIntegerPattern(radix);
        //boolean isBigIntegerValue = false;
        //if (hasNext(integerPattern)) {
            //String intString = matcher.group();
            //intString = removeLocaleInfo(intString, DataType.INT);
            //try {
                //cacheHasNextValue = new BigInteger(intString, radix);
                //isBigIntegerValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isBigIntegerValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.862 -0400", hash_original_method = "EB649DF4AB30251C023B5B81F2B2B0E4", hash_generated_method = "D1F9D02E790F85339C05BFBEB8561964")
    public boolean hasNextBoolean() {
        boolean var88D8FF71BAD823DCB5880318F817F6FE_1504483896 = (hasNext(BOOLEAN_PATTERN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629707671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629707671;
        // ---------- Original Method ----------
        //return hasNext(BOOLEAN_PATTERN);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.863 -0400", hash_original_method = "58199F8244631FBA465F06EC32762D29", hash_generated_method = "F6282B7F3D33A9094F430B565AA44553")
    public boolean hasNextByte() {
        boolean varA0C7366AA38E52F442867E2AD3C6DDA9_1211650348 = (hasNextByte(integerRadix));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236238935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236238935;
        // ---------- Original Method ----------
        //return hasNextByte(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.863 -0400", hash_original_method = "A5B80B22ED065BD547115A7BB2F2B96D", hash_generated_method = "8A889E24D65851D628EFF2C01E743349")
    public boolean hasNextByte(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isByteValue = false;
    if(hasNext(integerPattern))        
        {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try 
            {
                cacheHasNextValue = Byte.valueOf(intString, radix);
                isByteValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean var4213881AAAE63C68013F8DF22809449C_327488389 = (isByteValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470950643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_470950643;
        // ---------- Original Method ----------
        //Pattern integerPattern = getIntegerPattern(radix);
        //boolean isByteValue = false;
        //if (hasNext(integerPattern)) {
            //String intString = matcher.group();
            //intString = removeLocaleInfo(intString, DataType.INT);
            //try {
                //cacheHasNextValue = Byte.valueOf(intString, radix);
                //isByteValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isByteValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.864 -0400", hash_original_method = "66A96A75B245956604135FA693CF46B1", hash_generated_method = "6C1037BF6853F02A0A2FA8AF6F0A84DE")
    public boolean hasNextDouble() {
        Pattern floatPattern = getFloatPattern();
        boolean isDoubleValue = false;
    if(hasNext(floatPattern))        
        {
            String floatString = matcher.group();
            floatString = removeLocaleInfoFromFloat(floatString);
            try 
            {
                cacheHasNextValue = Double.valueOf(floatString);
                isDoubleValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean varD731A081554B83E47296D9D098114250_1088950437 = (isDoubleValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245968877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245968877;
        // ---------- Original Method ----------
        //Pattern floatPattern = getFloatPattern();
        //boolean isDoubleValue = false;
        //if (hasNext(floatPattern)) {
            //String floatString = matcher.group();
            //floatString = removeLocaleInfoFromFloat(floatString);
            //try {
                //cacheHasNextValue = Double.valueOf(floatString);
                //isDoubleValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isDoubleValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.865 -0400", hash_original_method = "FBD2AAA8FD71EC1957BF71E495BA575B", hash_generated_method = "088B94BFFAFB146A6B0A17AFD03AA264")
    public boolean hasNextFloat() {
        Pattern floatPattern = getFloatPattern();
        boolean isFloatValue = false;
    if(hasNext(floatPattern))        
        {
            String floatString = matcher.group();
            floatString = removeLocaleInfoFromFloat(floatString);
            try 
            {
                cacheHasNextValue = Float.valueOf(floatString);
                isFloatValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean var19965B41D93D790584DCB9157A13FB48_975101634 = (isFloatValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670538089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_670538089;
        // ---------- Original Method ----------
        //Pattern floatPattern = getFloatPattern();
        //boolean isFloatValue = false;
        //if (hasNext(floatPattern)) {
            //String floatString = matcher.group();
            //floatString = removeLocaleInfoFromFloat(floatString);
            //try {
                //cacheHasNextValue = Float.valueOf(floatString);
                //isFloatValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isFloatValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.865 -0400", hash_original_method = "5C4A5382507FD210B704AB0FDDE676B5", hash_generated_method = "DF14620AF4AFAE54605AEA7FD645683C")
    public boolean hasNextInt() {
        boolean var1910A7ED0656EF08A1FAE0A07C6CCBF0_1900258078 = (hasNextInt(integerRadix));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302331728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_302331728;
        // ---------- Original Method ----------
        //return hasNextInt(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.866 -0400", hash_original_method = "98DA0996AE9A85FE2EB4C6BCBC334600", hash_generated_method = "51AE26121668983816CDF508DB254788")
    public boolean hasNextInt(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isIntValue = false;
    if(hasNext(integerPattern))        
        {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try 
            {
                cacheHasNextValue = Integer.valueOf(intString, radix);
                isIntValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean varA9FDA0B07783271A921FD1E8AB9EBF67_956028139 = (isIntValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_704582045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_704582045;
        // ---------- Original Method ----------
        //Pattern integerPattern = getIntegerPattern(radix);
        //boolean isIntValue = false;
        //if (hasNext(integerPattern)) {
            //String intString = matcher.group();
            //intString = removeLocaleInfo(intString, DataType.INT);
            //try {
                //cacheHasNextValue = Integer.valueOf(intString, radix);
                //isIntValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isIntValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.867 -0400", hash_original_method = "F85B53817DDA0DC627A3FD344338966A", hash_generated_method = "9C764D24890187975750D7C35F530840")
    public boolean hasNextLine() {
        checkClosed();
        matcher.usePattern(LINE_PATTERN);
        matcher.region(findStartIndex, bufferLength);
        boolean hasNextLine = false;
        while
(true)        
        {
    if(matcher.find())            
            {
    if(inputExhausted || matcher.end() != bufferLength)                
                {
                    matchSuccessful = true;
                    hasNextLine = true;
                    break;
                } //End block
            } //End block
            else
            {
    if(inputExhausted)                
                {
                    matchSuccessful = false;
                    break;
                } //End block
            } //End block
    if(!inputExhausted)            
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
        boolean var03BBB060FB832609545C9DBCC7D85A3E_1127105665 = (hasNextLine);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480155626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480155626;
        // ---------- Original Method ----------
        //checkClosed();
        //matcher.usePattern(LINE_PATTERN);
        //matcher.region(findStartIndex, bufferLength);
        //boolean hasNextLine = false;
        //while (true) {
            //if (matcher.find()) {
                //if (inputExhausted || matcher.end() != bufferLength) {
                    //matchSuccessful = true;
                    //hasNextLine = true;
                    //break;
                //}
            //} else {
                //if (inputExhausted) {
                    //matchSuccessful = false;
                    //break;
                //}
            //}
            //if (!inputExhausted) {
                //readMore();
                //resetMatcher();
            //}
        //}
        //return hasNextLine;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.868 -0400", hash_original_method = "4E2EF7109AFFFF700ACDD8E154A60B95", hash_generated_method = "70E5D1BAE02B571CF3C670B8BF8B3229")
    public boolean hasNextLong() {
        boolean varF9D0037E413797F6A095CCA459619085_1712734504 = (hasNextLong(integerRadix));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713107042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713107042;
        // ---------- Original Method ----------
        //return hasNextLong(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.869 -0400", hash_original_method = "9F7A3D072C1FB851C44AA1EFB73ED70A", hash_generated_method = "AF10A956FB0A0B8ED67097843D7AEC50")
    public boolean hasNextLong(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isLongValue = false;
    if(hasNext(integerPattern))        
        {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try 
            {
                cacheHasNextValue = Long.valueOf(intString, radix);
                isLongValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean var08C85966FB366E8026585C4A85619558_1252565026 = (isLongValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910004170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910004170;
        // ---------- Original Method ----------
        //Pattern integerPattern = getIntegerPattern(radix);
        //boolean isLongValue = false;
        //if (hasNext(integerPattern)) {
            //String intString = matcher.group();
            //intString = removeLocaleInfo(intString, DataType.INT);
            //try {
                //cacheHasNextValue = Long.valueOf(intString, radix);
                //isLongValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isLongValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.869 -0400", hash_original_method = "68819BFDCF6E57EBBFC27075215E0009", hash_generated_method = "6DE6E6CE727B97CC66A1278C4706A4C8")
    public boolean hasNextShort() {
        boolean var0AF113868AE522EC65C1F85AB7F0CDD0_600731420 = (hasNextShort(integerRadix));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366353532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366353532;
        // ---------- Original Method ----------
        //return hasNextShort(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.869 -0400", hash_original_method = "BC1837EAC21D315C1A66DDC5582DCF81", hash_generated_method = "FD2B20418E12DA748A6A901ED891E3EC")
    public boolean hasNextShort(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isShortValue = false;
    if(hasNext(integerPattern))        
        {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try 
            {
                cacheHasNextValue = Short.valueOf(intString, radix);
                isShortValue = true;
            } //End block
            catch (NumberFormatException e)
            {
                matchSuccessful = false;
            } //End block
        } //End block
        boolean var5BE8894813CD19E2AE260B1FDBC8003C_1620516336 = (isShortValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314224098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314224098;
        // ---------- Original Method ----------
        //Pattern integerPattern = getIntegerPattern(radix);
        //boolean isShortValue = false;
        //if (hasNext(integerPattern)) {
            //String intString = matcher.group();
            //intString = removeLocaleInfo(intString, DataType.INT);
            //try {
                //cacheHasNextValue = Short.valueOf(intString, radix);
                //isShortValue = true;
            //} catch (NumberFormatException e) {
                //matchSuccessful = false;
            //}
        //}
        //return isShortValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.869 -0400", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "7CF0FAA64469F14F097DB4266A7436F2")
    public IOException ioException() {
IOException var1C9C3579611AFFB9BDE735EED6EBCBD7_1640733337 =         lastIOException;
        var1C9C3579611AFFB9BDE735EED6EBCBD7_1640733337.addTaint(taint);
        return var1C9C3579611AFFB9BDE735EED6EBCBD7_1640733337;
        // ---------- Original Method ----------
        //return lastIOException;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.870 -0400", hash_original_method = "21C822C4BC15A6F74D874095878E5501", hash_generated_method = "CC92B167450F18C26E1E375A8A819348")
    public Locale locale() {
Locale varB14E682FEAD06D8198D8ADBCBD62DEDB_1340303681 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_1340303681.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_1340303681;
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.870 -0400", hash_original_method = "2D94F093F10F1A8356EDEC86FADDCA70", hash_generated_method = "002348EE2A227F6295E1A2CC1E7A4E1E")
    public MatchResult match() {
    if(!matchSuccessful)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1731312359 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1731312359.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1731312359;
        } //End block
MatchResult var21E7CF64DE21F9FE27E7A15788408EBF_1118431597 =         matcher.toMatchResult();
        var21E7CF64DE21F9FE27E7A15788408EBF_1118431597.addTaint(taint);
        return var21E7CF64DE21F9FE27E7A15788408EBF_1118431597;
        // ---------- Original Method ----------
        //if (!matchSuccessful) {
            //throw new IllegalStateException();
        //}
        //return matcher.toMatchResult();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.870 -0400", hash_original_method = "A473F9C9E320CD6CEDCE3CE271E08C07", hash_generated_method = "7D0CF6D45064406AE75FA3B133585A50")
    public String next() {
String var5793CCCF246E3B39A8BF32047CAA536F_1852542339 =         next(ANY_PATTERN);
        var5793CCCF246E3B39A8BF32047CAA536F_1852542339.addTaint(taint);
        return var5793CCCF246E3B39A8BF32047CAA536F_1852542339;
        // ---------- Original Method ----------
        //return next(ANY_PATTERN);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.871 -0400", hash_original_method = "064C5502A668BA6541E1986AFB8ECCE1", hash_generated_method = "5CCBA68FB1001EB4EE660D4A6A6F1D6F")
    public String next(Pattern pattern) {
        addTaint(pattern.getTaint());
        checkClosed();
        checkNull(pattern);
        matchSuccessful = false;
        saveCurrentStatus();
    if(!setTokenRegion())        
        {
            recoverPreviousStatus();
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1199619237 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1199619237.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1199619237;
        } //End block
        matcher.usePattern(pattern);
    if(!matcher.matches())        
        {
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_716044968 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_716044968.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_716044968;
        } //End block
        matchSuccessful = true;
String varB5AAE48376C24FBB3ED941DE034F616C_649184332 =         matcher.group();
        varB5AAE48376C24FBB3ED941DE034F616C_649184332.addTaint(taint);
        return varB5AAE48376C24FBB3ED941DE034F616C_649184332;
        // ---------- Original Method ----------
        //checkClosed();
        //checkNull(pattern);
        //matchSuccessful = false;
        //saveCurrentStatus();
        //if (!setTokenRegion()) {
            //recoverPreviousStatus();
            //throw new NoSuchElementException();
        //}
        //matcher.usePattern(pattern);
        //if (!matcher.matches()) {
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //matchSuccessful = true;
        //return matcher.group();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.871 -0400", hash_original_method = "4894718ADE2D067062D34204C5088110", hash_generated_method = "04487A59F2CF774A37BF15864C27DEE4")
    public String next(String pattern) {
        addTaint(pattern.getTaint());
String var421A1E4D0FC47575EF77486A7FB08DAB_2010095449 =         next(Pattern.compile(pattern));
        var421A1E4D0FC47575EF77486A7FB08DAB_2010095449.addTaint(taint);
        return var421A1E4D0FC47575EF77486A7FB08DAB_2010095449;
        // ---------- Original Method ----------
        //return next(Pattern.compile(pattern));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.872 -0400", hash_original_method = "E9A644C72A3309EE871164344474A07C", hash_generated_method = "E484F5366B9BAE098B1614DE666587EA")
    public BigDecimal nextBigDecimal() {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof BigDecimal)        
        {
            findStartIndex = cachehasNextIndex;
BigDecimal var37C70D4B47C4AEFD43AD4A6492977AAF_428475444 =             (BigDecimal) obj;
            var37C70D4B47C4AEFD43AD4A6492977AAF_428475444.addTaint(taint);
            return var37C70D4B47C4AEFD43AD4A6492977AAF_428475444;
        } //End block
        Pattern floatPattern = getFloatPattern();
        String floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        BigDecimal bigDecimalValue;
        try 
        {
            bigDecimalValue = new BigDecimal(floatString);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_1676795838 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_1676795838.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_1676795838;
        } //End block
BigDecimal var44A3084B13A7A676F46780F49B2AB84F_852180146 =         bigDecimalValue;
        var44A3084B13A7A676F46780F49B2AB84F_852180146.addTaint(taint);
        return var44A3084B13A7A676F46780F49B2AB84F_852180146;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof BigDecimal) {
            //findStartIndex = cachehasNextIndex;
            //return (BigDecimal) obj;
        //}
        //Pattern floatPattern = getFloatPattern();
        //String floatString = next(floatPattern);
        //floatString = removeLocaleInfoFromFloat(floatString);
        //BigDecimal bigDecimalValue;
        //try {
            //bigDecimalValue = new BigDecimal(floatString);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return bigDecimalValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.872 -0400", hash_original_method = "144A2EEE9BFD199E176BF785D76B1260", hash_generated_method = "9B6D16848A4975AC1A944DA98BF9744C")
    public BigInteger nextBigInteger() {
BigInteger varCA4C1AB9C133629FF9E9A3A74F789A07_1495424660 =         nextBigInteger(integerRadix);
        varCA4C1AB9C133629FF9E9A3A74F789A07_1495424660.addTaint(taint);
        return varCA4C1AB9C133629FF9E9A3A74F789A07_1495424660;
        // ---------- Original Method ----------
        //return nextBigInteger(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.873 -0400", hash_original_method = "A32F88E5530C257A4D62223BBE0A1F90", hash_generated_method = "5FBF3E58A519B02D238B9CD42FD57F8A")
    public BigInteger nextBigInteger(int radix) {
        addTaint(radix);
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof BigInteger)        
        {
            findStartIndex = cachehasNextIndex;
BigInteger var8BC401377AE0097F920B30F4FA719BB6_933061426 =             (BigInteger) obj;
            var8BC401377AE0097F920B30F4FA719BB6_933061426.addTaint(taint);
            return var8BC401377AE0097F920B30F4FA719BB6_933061426;
        } //End block
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        BigInteger bigIntegerValue;
        try 
        {
            bigIntegerValue = new BigInteger(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_547796399 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_547796399.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_547796399;
        } //End block
BigInteger var8AF16930E5451512123E8827D73E0424_690170874 =         bigIntegerValue;
        var8AF16930E5451512123E8827D73E0424_690170874.addTaint(taint);
        return var8AF16930E5451512123E8827D73E0424_690170874;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof BigInteger) {
            //findStartIndex = cachehasNextIndex;
            //return (BigInteger) obj;
        //}
        //Pattern integerPattern = getIntegerPattern(radix);
        //String intString = next(integerPattern);
        //intString = removeLocaleInfo(intString, DataType.INT);
        //BigInteger bigIntegerValue;
        //try {
            //bigIntegerValue = new BigInteger(intString, radix);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return bigIntegerValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.873 -0400", hash_original_method = "D0E4DE4C67E1DCF9B9C54027B3E1E21D", hash_generated_method = "426A82ACC73C815DC4C449F5BDBD48C9")
    public boolean nextBoolean() {
        boolean var41FAC9845DB48FC67D8312E1605941EC_1857208378 = (Boolean.parseBoolean(next(BOOLEAN_PATTERN)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409124684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409124684;
        // ---------- Original Method ----------
        //return Boolean.parseBoolean(next(BOOLEAN_PATTERN));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.873 -0400", hash_original_method = "7CE1C60D76B7F2532B9BC1651A113CEF", hash_generated_method = "4D6A8E31330DD81116E8E5A9BE031F39")
    public byte nextByte() {
        byte varA0694E0B3F92169FA57116F2A3C1B51E_209522747 = (nextByte(integerRadix));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_371365336 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_371365336;
        // ---------- Original Method ----------
        //return nextByte(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.874 -0400", hash_original_method = "9181863BF854F96D8E1FF1A461B82F5F", hash_generated_method = "217E4728D92EE3EA4D772935B9A7C51C")
    @SuppressWarnings("boxing")
    public byte nextByte(int radix) {
        addTaint(radix);
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof Byte)        
        {
            findStartIndex = cachehasNextIndex;
            byte var08C4D4744DCBDCE86395B60EF1209ED9_596714914 = ((Byte) obj);
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_17044668 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_17044668;
        } //End block
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        byte byteValue = 0;
        try 
        {
            byteValue = Byte.parseByte(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_1309693799 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_1309693799.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_1309693799;
        } //End block
        byte varB06DCFA642C28EAD8A57F682A6525BCB_1715551415 = (byteValue);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_624149982 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_624149982;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof Byte) {
            //findStartIndex = cachehasNextIndex;
            //return (Byte) obj;
        //}
        //Pattern integerPattern = getIntegerPattern(radix);
        //String intString = next(integerPattern);
        //intString = removeLocaleInfo(intString, DataType.INT);
        //byte byteValue = 0;
        //try {
            //byteValue = Byte.parseByte(intString, radix);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return byteValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.875 -0400", hash_original_method = "59ED3F69878B10BC787D8DCCAB5B2B3E", hash_generated_method = "DBD8D50CE3A9BA7B3F10A562ED27013E")
    @SuppressWarnings("boxing")
    public double nextDouble() {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof Double)        
        {
            findStartIndex = cachehasNextIndex;
            double varB4480C628311720259FACA195A47CE89_1382926606 = ((Double) obj);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1986727524 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1986727524;
        } //End block
        Pattern floatPattern = getFloatPattern();
        String floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        double doubleValue = 0;
        try 
        {
            doubleValue = Double.parseDouble(floatString);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_1767748801 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_1767748801.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_1767748801;
        } //End block
        double varD3673895FFF90A031E58F7DF70D852B3_401653279 = (doubleValue);
                double varE8CD7DA078A86726031AD64F35F5A6C0_188620552 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_188620552;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof Double) {
            //findStartIndex = cachehasNextIndex;
            //return (Double) obj;
        //}
        //Pattern floatPattern = getFloatPattern();
        //String floatString = next(floatPattern);
        //floatString = removeLocaleInfoFromFloat(floatString);
        //double doubleValue = 0;
        //try {
            //doubleValue = Double.parseDouble(floatString);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return doubleValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.876 -0400", hash_original_method = "465894BBFB87D2894D77A1BB6EACCD0F", hash_generated_method = "860C14E293A736C2DFC46FFB3983B5B2")
    @SuppressWarnings("boxing")
    public float nextFloat() {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof Float)        
        {
            findStartIndex = cachehasNextIndex;
            float var2AB21CCE0789952BAACEFA4F243C7D75_1079101445 = ((Float) obj);
                        float var546ADE640B6EDFBC8A086EF31347E768_903572020 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_903572020;
        } //End block
        Pattern floatPattern = getFloatPattern();
        String floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        float floatValue = 0;
        try 
        {
            floatValue = Float.parseFloat(floatString);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_205406015 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_205406015.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_205406015;
        } //End block
        float var9EC90E82509332A2D6E51DE04DBBE788_1579048675 = (floatValue);
                float var546ADE640B6EDFBC8A086EF31347E768_1053695697 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1053695697;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof Float) {
            //findStartIndex = cachehasNextIndex;
            //return (Float) obj;
        //}
        //Pattern floatPattern = getFloatPattern();
        //String floatString = next(floatPattern);
        //floatString = removeLocaleInfoFromFloat(floatString);
        //float floatValue = 0;
        //try {
            //floatValue = Float.parseFloat(floatString);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return floatValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.876 -0400", hash_original_method = "5185135F499E2963894A73963B55B971", hash_generated_method = "37390681D58962DCDB723E74B13EDF4F")
    public int nextInt() {
        int varBFC2D72ECA7B1E55D02D8081F60A5869_1453221748 = (nextInt(integerRadix));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461236101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1461236101;
        // ---------- Original Method ----------
        //return nextInt(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.877 -0400", hash_original_method = "B06EC911E3305341017BDCE4EADE227D", hash_generated_method = "E043BCE99BFB10481460A35363975719")
    @SuppressWarnings("boxing")
    public int nextInt(int radix) {
        addTaint(radix);
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof Integer)        
        {
            findStartIndex = cachehasNextIndex;
            int var1BA191DDA4CB90317D2A3D8CEAF830EE_1032619434 = ((Integer) obj);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907590882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907590882;
        } //End block
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        int intValue = 0;
        try 
        {
            intValue = Integer.parseInt(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_1315810180 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_1315810180.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_1315810180;
        } //End block
        int var481F44389B52D587646C4A792551B4DC_753885434 = (intValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878379936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878379936;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof Integer) {
            //findStartIndex = cachehasNextIndex;
            //return (Integer) obj;
        //}
        //Pattern integerPattern = getIntegerPattern(radix);
        //String intString = next(integerPattern);
        //intString = removeLocaleInfo(intString, DataType.INT);
        //int intValue = 0;
        //try {
            //intValue = Integer.parseInt(intString, radix);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return intValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.878 -0400", hash_original_method = "3D66719B22D4824A272B09AB38D3D0FA", hash_generated_method = "8D4B003128CAAFE7188D4728B0134375")
    public String nextLine() {
        checkClosed();
        matcher.usePattern(LINE_PATTERN);
        matcher.region(findStartIndex, bufferLength);
        String result = null;
        while
(true)        
        {
    if(matcher.find())            
            {
    if(inputExhausted || matcher.end() != bufferLength
                        || bufferLength < buffer.capacity())                
                {
                    matchSuccessful = true;
                    findStartIndex = matcher.end();
                    result = matcher.group();
                    break;
                } //End block
            } //End block
            else
            {
    if(inputExhausted)                
                {
                    matchSuccessful = false;
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_717320590 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_717320590.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_717320590;
                } //End block
            } //End block
    if(!inputExhausted)            
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
    if(result != null)        
        {
            Matcher terminatorMatcher = LINE_TERMINATOR.matcher(result);
    if(terminatorMatcher.find())            
            {
                result = result.substring(0, terminatorMatcher.start());
            } //End block
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_537351527 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_537351527.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_537351527;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.879 -0400", hash_original_method = "6374462D33C9F89E6E50C3F6D20F5373", hash_generated_method = "D97FCE887964C082D2AE5CFC11225ECE")
    public long nextLong() {
        long varD6D6B71A50E59822E14D1E2C3F1455A0_185593177 = (nextLong(integerRadix));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_608089641 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_608089641;
        // ---------- Original Method ----------
        //return nextLong(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.882 -0400", hash_original_method = "36B6D1B74C7A404A698E79C7D45F2371", hash_generated_method = "8F094F980D096689A5BA6920F7CCFDD7")
    @SuppressWarnings("boxing")
    public long nextLong(int radix) {
        addTaint(radix);
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof Long)        
        {
            findStartIndex = cachehasNextIndex;
            long var5D04E6DA14E86CE2BB630E29180F7F42_1577490204 = ((Long) obj);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1666246409 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1666246409;
        } //End block
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        long longValue = 0;
        try 
        {
            longValue = Long.parseLong(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_461421053 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_461421053.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_461421053;
        } //End block
        long var4173301EF4A1E942CF554B17124A6E9A_1573557151 = (longValue);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_358064616 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_358064616;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof Long) {
            //findStartIndex = cachehasNextIndex;
            //return (Long) obj;
        //}
        //Pattern integerPattern = getIntegerPattern(radix);
        //String intString = next(integerPattern);
        //intString = removeLocaleInfo(intString, DataType.INT);
        //long longValue = 0;
        //try {
            //longValue = Long.parseLong(intString, radix);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return longValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.882 -0400", hash_original_method = "D33600E854DF5F367D7728611F6ACBC6", hash_generated_method = "541B28C2B2C135AAFCCDD3E91B5354A0")
    public short nextShort() {
        short var6CCB068CB6539DBE60A2A715F690B762_496739840 = (nextShort(integerRadix));
                short var4F09DAA9D95BCB166A302407A0E0BABE_716020223 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_716020223;
        // ---------- Original Method ----------
        //return nextShort(integerRadix);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.883 -0400", hash_original_method = "74041A63415BC5E03BF2BCCD0D0C92EB", hash_generated_method = "6142CC842D979B915C9F6BEB475E79DC")
    @SuppressWarnings("boxing")
    public short nextShort(int radix) {
        addTaint(radix);
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
    if(obj instanceof Short)        
        {
            findStartIndex = cachehasNextIndex;
            short var55B7E8BB82CE85C01506802A0BB34BF9_2070635085 = ((Short) obj);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_330651454 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_330651454;
        } //End block
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        short shortValue = 0;
        try 
        {
            shortValue = Short.parseShort(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            InputMismatchException varCFB23610718B4049192DFAAC13B0BE66_1474109716 = new InputMismatchException();
            varCFB23610718B4049192DFAAC13B0BE66_1474109716.addTaint(taint);
            throw varCFB23610718B4049192DFAAC13B0BE66_1474109716;
        } //End block
        short var543D44E474334B1F6826F78585803C78_2138131537 = (shortValue);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1317826877 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1317826877;
        // ---------- Original Method ----------
        //checkClosed();
        //Object obj = cacheHasNextValue;
        //cacheHasNextValue = null;
        //if (obj instanceof Short) {
            //findStartIndex = cachehasNextIndex;
            //return (Short) obj;
        //}
        //Pattern integerPattern = getIntegerPattern(radix);
        //String intString = next(integerPattern);
        //intString = removeLocaleInfo(intString, DataType.INT);
        //short shortValue = 0;
        //try {
            //shortValue = Short.parseShort(intString, radix);
        //} catch (NumberFormatException e) {
            //matchSuccessful = false;
            //recoverPreviousStatus();
            //throw new InputMismatchException();
        //}
        //return shortValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.884 -0400", hash_original_method = "108FFB02BFAD84F212F542E44C9F6CE4", hash_generated_method = "D5355B5552F488FBDE549F07DB865300")
    public int radix() {
        int var46F37B0D5E779097F7E5B659DF66B491_1262134136 = (integerRadix);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778093798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778093798;
        // ---------- Original Method ----------
        //return integerRadix;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.885 -0400", hash_original_method = "EA8E10FC12D1B40BE210D235F143A214", hash_generated_method = "B9D4459286B5B4A53033735FD15C95B9")
    public Scanner skip(Pattern pattern) {
        addTaint(pattern.getTaint());
        checkClosed();
        checkNull(pattern);
        matcher.usePattern(pattern);
        matcher.region(findStartIndex, bufferLength);
        while
(true)        
        {
    if(matcher.lookingAt())            
            {
                boolean matchInBuffer = matcher.end() < bufferLength
                        || (matcher.end() == bufferLength && inputExhausted);
    if(matchInBuffer)                
                {
                    matchSuccessful = true;
                    findStartIndex = matcher.end();
                    break;
                } //End block
            } //End block
            else
            {
    if(inputExhausted)                
                {
                    matchSuccessful = false;
                    NoSuchElementException var28D00AB599969908D71F102AF992D49A_1049505591 = new NoSuchElementException();
                    var28D00AB599969908D71F102AF992D49A_1049505591.addTaint(taint);
                    throw var28D00AB599969908D71F102AF992D49A_1049505591;
                } //End block
            } //End block
    if(!inputExhausted)            
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
Scanner var72A74007B2BE62B849F475C7BDA4658B_167929369 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_167929369.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_167929369;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.885 -0400", hash_original_method = "B5629C8DC277AD4A72B913564449A4A1", hash_generated_method = "8A1B94170F8469987CFEBD28EAD50205")
    public Scanner skip(String pattern) {
        addTaint(pattern.getTaint());
Scanner var0F453C43516595ADDE753671394A49C8_1413200417 =         skip(Pattern.compile(pattern));
        var0F453C43516595ADDE753671394A49C8_1413200417.addTaint(taint);
        return var0F453C43516595ADDE753671394A49C8_1413200417;
        // ---------- Original Method ----------
        //return skip(Pattern.compile(pattern));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.885 -0400", hash_original_method = "13B9E1963603D8F8D017FAED70E76372", hash_generated_method = "E9A48231728087D7F548EF3747BB0225")
    @Override
    public String toString() {
String var7B6A43F99D6C02EB18851785F3FE3C71_1996693409 =         getClass().getName() +
                "[delimiter=" + delimiter +
                ",findStartIndex=" + findStartIndex +
                ",matchSuccessful=" + matchSuccessful +
                ",closed=" + closed +
                "]";
        var7B6A43F99D6C02EB18851785F3FE3C71_1996693409.addTaint(taint);
        return var7B6A43F99D6C02EB18851785F3FE3C71_1996693409;
        // ---------- Original Method ----------
        //return getClass().getName() +
                //"[delimiter=" + delimiter +
                //",findStartIndex=" + findStartIndex +
                //",matchSuccessful=" + matchSuccessful +
                //",closed=" + closed +
                //"]";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.886 -0400", hash_original_method = "E89CBE82FDB8B0CDDF4705672288D942", hash_generated_method = "0B42B189039A095474AFC22AD3F8EB5A")
    public Scanner useDelimiter(Pattern pattern) {
        delimiter = pattern;
Scanner var72A74007B2BE62B849F475C7BDA4658B_710104100 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_710104100.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_710104100;
        // ---------- Original Method ----------
        //delimiter = pattern;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.886 -0400", hash_original_method = "353C3ED30BA7FF969DF17D7F091BC9CC", hash_generated_method = "7B8C1CFBAF0C91FE6A8773129B1EEA7C")
    public Scanner useDelimiter(String pattern) {
        addTaint(pattern.getTaint());
Scanner var6F17C59D1EEAE47DFF057C9063BC6022_1961246374 =         useDelimiter(Pattern.compile(pattern));
        var6F17C59D1EEAE47DFF057C9063BC6022_1961246374.addTaint(taint);
        return var6F17C59D1EEAE47DFF057C9063BC6022_1961246374;
        // ---------- Original Method ----------
        //return useDelimiter(Pattern.compile(pattern));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.886 -0400", hash_original_method = "A3D9C7BB7710DA92E291534F4EEE6EBE", hash_generated_method = "6B1F1019D2B6DDCFF4F9438A7F1FCC05")
    public Scanner useLocale(Locale l) {
    if(l == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1268121693 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1268121693.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1268121693;
        } //End block
        this.locale = l;
Scanner var72A74007B2BE62B849F475C7BDA4658B_719707006 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_719707006.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_719707006;
        // ---------- Original Method ----------
        //if (l == null) {
            //throw new NullPointerException();
        //}
        //this.locale = l;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.887 -0400", hash_original_method = "345B5E07834B16EBD69B375363EEC767", hash_generated_method = "22E29806188B990CAF9FB51C62A8BC33")
    public Scanner useRadix(int radix) {
        checkRadix(radix);
        this.integerRadix = radix;
Scanner var72A74007B2BE62B849F475C7BDA4658B_558047907 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_558047907.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_558047907;
        // ---------- Original Method ----------
        //checkRadix(radix);
        //this.integerRadix = radix;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.887 -0400", hash_original_method = "A1030C8BAA30073CC5ACF726BB676E36", hash_generated_method = "5515EF22FCA23AF8A14B9EA0F2DD0E2D")
    private void checkRadix(int radix) {
        addTaint(radix);
    if(radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)        
        {
            IllegalArgumentException var68431E8A8F645EA6C390811716BE4783_1529687282 = new IllegalArgumentException("Invalid radix: " + radix);
            var68431E8A8F645EA6C390811716BE4783_1529687282.addTaint(taint);
            throw var68431E8A8F645EA6C390811716BE4783_1529687282;
        } //End block
        // ---------- Original Method ----------
        //if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            //throw new IllegalArgumentException("Invalid radix: " + radix);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.887 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "FB3775B057E1B827D7DB01602691CE30")
    public void remove() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1250644784 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1250644784.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1250644784;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.888 -0400", hash_original_method = "406043B74DF8E969B61AA0BA511B152F", hash_generated_method = "C3800FC0AB14E78A4E511D811768D6B9")
    private void initialization() {
        buffer = CharBuffer.allocate(DEFAULT_TRUNK_SIZE);
        buffer.limit(0);
        matcher = delimiter.matcher(buffer);
        // ---------- Original Method ----------
        //buffer = CharBuffer.allocate(DEFAULT_TRUNK_SIZE);
        //buffer.limit(0);
        //matcher = delimiter.matcher(buffer);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.888 -0400", hash_original_method = "B30B600A81B32166D215C68FA4624658", hash_generated_method = "A5E26F446E771FA9FA4A7DC319ADB532")
    private void checkClosed() {
    if(closed)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1927775232 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1927775232.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1927775232;
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IllegalStateException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.888 -0400", hash_original_method = "36E7BDE51D05E7575D4F9253BA0F7A7F", hash_generated_method = "BF65E768DDC8DCAF476F5442466B7171")
    private void checkNull(Pattern pattern) {
        addTaint(pattern.getTaint());
    if(pattern == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_177260481 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_177260481.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_177260481;
        } //End block
        // ---------- Original Method ----------
        //if (pattern == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.889 -0400", hash_original_method = "EB8AF45030CFA93895E22043F16AA91D", hash_generated_method = "4FFF894F621D168A9267F3900484EF7F")
    private void resetMatcher() {
    if(matcher == null)        
        {
            matcher = delimiter.matcher(buffer);
        } //End block
        else
        {
            matcher.reset(buffer);
        } //End block
        matcher.region(findStartIndex, bufferLength);
        // ---------- Original Method ----------
        //if (matcher == null) {
            //matcher = delimiter.matcher(buffer);
        //} else {
            //matcher.reset(buffer);
        //}
        //matcher.region(findStartIndex, bufferLength);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.889 -0400", hash_original_method = "8767C8E3B92497CDD5E1C8E3E9AF12A5", hash_generated_method = "246DF741A54CA564E3597B59F5BC86C1")
    private void saveCurrentStatus() {
        preStartIndex = findStartIndex;
        // ---------- Original Method ----------
        //preStartIndex = findStartIndex;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.889 -0400", hash_original_method = "C4EDF4CCA1B99C808834619656C45D45", hash_generated_method = "25DC76BF381C9B535A67870FCCE6C2E3")
    private void recoverPreviousStatus() {
        findStartIndex = preStartIndex;
        // ---------- Original Method ----------
        //findStartIndex = preStartIndex;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.890 -0400", hash_original_method = "B97F3D0429BBD1DC99EF41C42DDF373F", hash_generated_method = "CB0733DE4907E98648C5FC33408B6135")
    private Pattern getIntegerPattern(int radix) {
        addTaint(radix);
        checkRadix(radix);
        decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
        String allAvailableDigits = "0123456789abcdefghijklmnopqrstuvwxyz";
        String ASCIIDigit = allAvailableDigits.substring(0, radix);
        String nonZeroASCIIDigit = allAvailableDigits.substring(1, radix);
        StringBuilder digit = new StringBuilder("((?i)[").append(ASCIIDigit)
                .append("]|\\p{javaDigit})");
        StringBuilder nonZeroDigit = new StringBuilder("((?i)[").append(
                nonZeroASCIIDigit).append("]|([\\p{javaDigit}&&[^0]]))");
        StringBuilder numeral = getNumeral(digit, nonZeroDigit);
        StringBuilder integer = new StringBuilder("(([-+]?(").append(numeral)
                .append(")))|(").append(addPositiveSign(numeral)).append(")|(")
                .append(addNegativeSign(numeral)).append(")");
        Pattern integerPattern = Pattern.compile(integer.toString());
Pattern var2A2E87AC25F15D6F5D194B4ED9121FE2_1939752996 =         integerPattern;
        var2A2E87AC25F15D6F5D194B4ED9121FE2_1939752996.addTaint(taint);
        return var2A2E87AC25F15D6F5D194B4ED9121FE2_1939752996;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.890 -0400", hash_original_method = "C0E115C785C5444E26611E86ADCD9532", hash_generated_method = "A1EB60EF9BA19FD1D6D4F1E20733C023")
    private Pattern getFloatPattern() {
        decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
        StringBuilder digit = new StringBuilder("([0-9]|(\\p{javaDigit}))");
        StringBuilder nonZeroDigit = new StringBuilder("[\\p{javaDigit}&&[^0]]");
        StringBuilder numeral = getNumeral(digit, nonZeroDigit);
        String decimalSeparator = "\\" + decimalFormat.getDecimalFormatSymbols()
                        .getDecimalSeparator();
        StringBuilder decimalNumeral = new StringBuilder("(").append(numeral)
                .append("|").append(numeral)
                .append(decimalSeparator).append(digit).append("*+|").append(
                        decimalSeparator).append(digit).append("++)");
        StringBuilder exponent = new StringBuilder("([eE][+-]?").append(digit)
                .append("+)?");
        StringBuilder decimal = new StringBuilder("(([-+]?").append(
                decimalNumeral).append("(").append(exponent).append("?)")
                .append(")|(").append(addPositiveSign(decimalNumeral)).append(
                        "(").append(exponent).append("?)").append(")|(")
                .append(addNegativeSign(decimalNumeral)).append("(").append(
                        exponent).append("?)").append("))");
        StringBuilder hexFloat = new StringBuilder("([-+]?0[xX][0-9a-fA-F]*")
                .append("\\.").append(
                        "[0-9a-fA-F]+([pP][-+]?[0-9]+)?)");
        String localNaN = decimalFormat.getDecimalFormatSymbols().getNaN();
        String localeInfinity = decimalFormat.getDecimalFormatSymbols()
                .getInfinity();
        StringBuilder nonNumber = new StringBuilder("(NaN|\\Q").append(localNaN)
                .append("\\E|Infinity|\\Q").append(localeInfinity).append("\\E)");
        StringBuilder singedNonNumber = new StringBuilder("((([-+]?(").append(
                nonNumber).append(")))|(").append(addPositiveSign(nonNumber))
                .append(")|(").append(addNegativeSign(nonNumber)).append("))");
        StringBuilder floatString = new StringBuilder().append(decimal).append(
                "|").append(hexFloat).append("|").append(singedNonNumber);
        Pattern floatPattern = Pattern.compile(floatString.toString());
Pattern var4CE604A5A135179962E148B45FDEEC34_1049410788 =         floatPattern;
        var4CE604A5A135179962E148B45FDEEC34_1049410788.addTaint(taint);
        return var4CE604A5A135179962E148B45FDEEC34_1049410788;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.891 -0400", hash_original_method = "F633057156584A1CC211DF943CEE8B2E", hash_generated_method = "3DBED6B6561C5B89A25F1FE1277E1A97")
    private StringBuilder getNumeral(StringBuilder digit,
            StringBuilder nonZeroDigit) {
        addTaint(nonZeroDigit.getTaint());
        addTaint(digit.getTaint());
        String groupSeparator = "\\"
                + decimalFormat.getDecimalFormatSymbols()
                        .getGroupingSeparator();
        StringBuilder groupedNumeral = new StringBuilder("(").append(
                nonZeroDigit).append(digit).append("?").append(digit).append(
                "?(").append(groupSeparator).append(digit).append(digit)
                .append(digit).append(")+)");
        StringBuilder numeral = new StringBuilder("((").append(digit).append(
                "++)|").append(groupedNumeral).append(")");
StringBuilder var8C779BAD5A11BFE86DA55B97DBDE41A1_597153126 =         numeral;
        var8C779BAD5A11BFE86DA55B97DBDE41A1_597153126.addTaint(taint);
        return var8C779BAD5A11BFE86DA55B97DBDE41A1_597153126;
        // ---------- Original Method ----------
        //String groupSeparator = "\\"
                //+ decimalFormat.getDecimalFormatSymbols()
                        //.getGroupingSeparator();
        //StringBuilder groupedNumeral = new StringBuilder("(").append(
                //nonZeroDigit).append(digit).append("?").append(digit).append(
                //"?(").append(groupSeparator).append(digit).append(digit)
                //.append(digit).append(")+)");
        //StringBuilder numeral = new StringBuilder("((").append(digit).append(
                //"++)|").append(groupedNumeral).append(")");
        //return numeral;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.892 -0400", hash_original_method = "F4802B299CEDF4B393BE453F4FA35C1C", hash_generated_method = "AD1C25F9A423BEAD6DCD6093BEFF6560")
    private StringBuilder addPositiveSign(StringBuilder unSignNumeral) {
        addTaint(unSignNumeral.getTaint());
        String positivePrefix = "";
        String positiveSuffix = "";
    if(!decimalFormat.getPositivePrefix().isEmpty())        
        {
            positivePrefix = "\\Q" + decimalFormat.getPositivePrefix() + "\\E";
        } //End block
    if(!decimalFormat.getPositiveSuffix().isEmpty())        
        {
            positiveSuffix = "\\Q" + decimalFormat.getPositiveSuffix() + "\\E";
        } //End block
        StringBuilder signedNumeral = new StringBuilder()
                .append(positivePrefix).append(unSignNumeral).append(
                        positiveSuffix);
StringBuilder var8B886972C0E558CFE8922B5938E4BC99_27388221 =         signedNumeral;
        var8B886972C0E558CFE8922B5938E4BC99_27388221.addTaint(taint);
        return var8B886972C0E558CFE8922B5938E4BC99_27388221;
        // ---------- Original Method ----------
        //String positivePrefix = "";
        //String positiveSuffix = "";
        //if (!decimalFormat.getPositivePrefix().isEmpty()) {
            //positivePrefix = "\\Q" + decimalFormat.getPositivePrefix() + "\\E";
        //}
        //if (!decimalFormat.getPositiveSuffix().isEmpty()) {
            //positiveSuffix = "\\Q" + decimalFormat.getPositiveSuffix() + "\\E";
        //}
        //StringBuilder signedNumeral = new StringBuilder()
                //.append(positivePrefix).append(unSignNumeral).append(
                        //positiveSuffix);
        //return signedNumeral;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.892 -0400", hash_original_method = "52EA29890EB11047B6BC838B1D351A19", hash_generated_method = "155189AB57E9FA5B574D1C4CE7247691")
    private StringBuilder addNegativeSign(StringBuilder unSignNumeral) {
        addTaint(unSignNumeral.getTaint());
        String negativePrefix = "";
        String negativeSuffix = "";
    if(!decimalFormat.getNegativePrefix().isEmpty())        
        {
            negativePrefix = "\\Q" + decimalFormat.getNegativePrefix() + "\\E";
        } //End block
    if(!decimalFormat.getNegativeSuffix().isEmpty())        
        {
            negativeSuffix = "\\Q" + decimalFormat.getNegativeSuffix() + "\\E";
        } //End block
        StringBuilder signedNumeral = new StringBuilder()
                .append(negativePrefix).append(unSignNumeral).append(
                        negativeSuffix);
StringBuilder var8B886972C0E558CFE8922B5938E4BC99_448617915 =         signedNumeral;
        var8B886972C0E558CFE8922B5938E4BC99_448617915.addTaint(taint);
        return var8B886972C0E558CFE8922B5938E4BC99_448617915;
        // ---------- Original Method ----------
        //String negativePrefix = "";
        //String negativeSuffix = "";
        //if (!decimalFormat.getNegativePrefix().isEmpty()) {
            //negativePrefix = "\\Q" + decimalFormat.getNegativePrefix() + "\\E";
        //}
        //if (!decimalFormat.getNegativeSuffix().isEmpty()) {
            //negativeSuffix = "\\Q" + decimalFormat.getNegativeSuffix() + "\\E";
        //}
        //StringBuilder signedNumeral = new StringBuilder()
                //.append(negativePrefix).append(unSignNumeral).append(
                        //negativeSuffix);
        //return signedNumeral;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.893 -0400", hash_original_method = "E9627567024197FCA7EA352F1F4FD73F", hash_generated_method = "A55DBB5DC285A0332E400BC2C91DE7D7")
    private String removeLocaleInfoFromFloat(String floatString) {
        addTaint(floatString.getTaint());
    if(-1 != floatString.indexOf('x') || -1 != floatString.indexOf('X'))        
        {
String varF28E6248FB79B5DCF6FBDCEC99C9362E_871069702 =             floatString;
            varF28E6248FB79B5DCF6FBDCEC99C9362E_871069702.addTaint(taint);
            return varF28E6248FB79B5DCF6FBDCEC99C9362E_871069702;
        } //End block
        int exponentIndex;
        String decimalNumeralString;
        String exponentString;
    if(-1 != (exponentIndex = floatString.indexOf('e'))
                || -1 != (exponentIndex = floatString.indexOf('E')))        
        {
            decimalNumeralString = floatString.substring(0, exponentIndex);
            exponentString = floatString.substring(exponentIndex + 1,
                    floatString.length());
            decimalNumeralString = removeLocaleInfo(decimalNumeralString,
                    DataType.FLOAT);
String var0C1ED84DE87A49C83C852B7F3E8C7DA2_764026310 =             decimalNumeralString + "e" + exponentString;
            var0C1ED84DE87A49C83C852B7F3E8C7DA2_764026310.addTaint(taint);
            return var0C1ED84DE87A49C83C852B7F3E8C7DA2_764026310;
        } //End block
String varD4B2483B666E8926B66EBAD49483F4A9_907741822 =         removeLocaleInfo(floatString, DataType.FLOAT);
        varD4B2483B666E8926B66EBAD49483F4A9_907741822.addTaint(taint);
        return varD4B2483B666E8926B66EBAD49483F4A9_907741822;
        // ---------- Original Method ----------
        //if (-1 != floatString.indexOf('x') || -1 != floatString.indexOf('X')) {
            //return floatString;
        //}
        //int exponentIndex;
        //String decimalNumeralString;
        //String exponentString;
        //if (-1 != (exponentIndex = floatString.indexOf('e'))
                //|| -1 != (exponentIndex = floatString.indexOf('E'))) {
            //decimalNumeralString = floatString.substring(0, exponentIndex);
            //exponentString = floatString.substring(exponentIndex + 1,
                    //floatString.length());
            //decimalNumeralString = removeLocaleInfo(decimalNumeralString,
                    //DataType.FLOAT);
            //return decimalNumeralString + "e" + exponentString;
        //}
        //return removeLocaleInfo(floatString, DataType.FLOAT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.894 -0400", hash_original_method = "E0679D6E03D5A7C0D246B9231F9BA005", hash_generated_method = "098E3ED9CEC2757C6A6355C85AE9C214")
    private String removeLocaleInfo(String token, DataType type) {
        addTaint(type.getTaint());
        addTaint(token.getTaint());
        StringBuilder tokenBuilder = new StringBuilder(token);
        boolean negative = removeLocaleSign(tokenBuilder);
        String groupSeparator = String.valueOf(decimalFormat
                .getDecimalFormatSymbols().getGroupingSeparator());
        int separatorIndex = -1;
        while
(-1 != (separatorIndex = tokenBuilder.indexOf(groupSeparator)))        
        {
            tokenBuilder.delete(separatorIndex, separatorIndex + 1);
        } //End block
        String decimalSeparator = String.valueOf(decimalFormat
                .getDecimalFormatSymbols().getDecimalSeparator());
        separatorIndex = tokenBuilder.indexOf(decimalSeparator);
        StringBuilder result = new StringBuilder("");
    if(DataType.INT == type)        
        {
for(int i = 0;i < tokenBuilder.length();i++)
            {
    if(-1 != Character.digit(tokenBuilder.charAt(i),
                        Character.MAX_RADIX))                
                {
                    result.append(tokenBuilder.charAt(i));
                } //End block
            } //End block
        } //End block
    if(DataType.FLOAT == type)        
        {
    if(tokenBuilder.toString().equals(
                    decimalFormat.getDecimalFormatSymbols().getNaN()))            
            {
                result.append("NaN");
            } //End block
            else
    if(tokenBuilder.toString().equals(
                    decimalFormat.getDecimalFormatSymbols().getInfinity()))            
            {
                result.append("Infinity");
            } //End block
            else
            {
for(int i = 0;i < tokenBuilder.length();i++)
                {
    if(-1 != Character.digit(tokenBuilder.charAt(i), 10))                    
                    {
                        result.append(Character.digit(tokenBuilder.charAt(i),
                                10));
                    } //End block
                } //End block
            } //End block
        } //End block
    if(result.length() == 0)        
        {
            result = tokenBuilder;
        } //End block
    if(-1 != separatorIndex)        
        {
            result.insert(separatorIndex, ".");
        } //End block
    if(negative)        
        {
            result.insert(0, '-');
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1232270380 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1232270380.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1232270380;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.896 -0400", hash_original_method = "78E2FFE43DDA019FB87A76C655422357", hash_generated_method = "73F9B52755C7865B1093F1A81D5F999D")
    private boolean removeLocaleSign(StringBuilder tokenBuilder) {
        addTaint(tokenBuilder.getTaint());
        String positivePrefix = decimalFormat.getPositivePrefix();
        String positiveSuffix = decimalFormat.getPositiveSuffix();
        String negativePrefix = decimalFormat.getNegativePrefix();
        String negativeSuffix = decimalFormat.getNegativeSuffix();
    if(tokenBuilder.indexOf("+") == 0)        
        {
            tokenBuilder.delete(0, 1);
        } //End block
    if(!positivePrefix.isEmpty() && tokenBuilder.indexOf(positivePrefix) == 0)        
        {
            tokenBuilder.delete(0, positivePrefix.length());
        } //End block
    if(!positiveSuffix.isEmpty()
                && -1 != tokenBuilder.indexOf(positiveSuffix))        
        {
            tokenBuilder.delete(
                    tokenBuilder.length() - positiveSuffix.length(),
                    tokenBuilder.length());
        } //End block
        boolean negative = false;
    if(tokenBuilder.indexOf("-") == 0)        
        {
            tokenBuilder.delete(0, 1);
            negative = true;
        } //End block
    if(!negativePrefix.isEmpty() && tokenBuilder.indexOf(negativePrefix) == 0)        
        {
            tokenBuilder.delete(0, negativePrefix.length());
            negative = true;
        } //End block
    if(!negativeSuffix.isEmpty()
                && -1 != tokenBuilder.indexOf(negativeSuffix))        
        {
            tokenBuilder.delete(
                    tokenBuilder.length() - negativeSuffix.length(),
                    tokenBuilder.length());
            negative = true;
        } //End block
        boolean var228D6A97A9838DC800E58B3C74BA7B11_1597676383 = (negative);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423615535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_423615535;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.897 -0400", hash_original_method = "F9C3F510E83B834D3EF4AA01E6CFE4F9", hash_generated_method = "30DB2F23A70D61ADD04A3D2A4DB05FFB")
    private boolean setTokenRegion() {
        int tokenStartIndex = 0;
        int tokenEndIndex = 0;
        matcher.usePattern(delimiter);
        matcher.region(findStartIndex, bufferLength);
        tokenStartIndex = findPreDelimiter();
    if(setHeadTokenRegion(tokenStartIndex))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_532715972 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147399319 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147399319;
        } //End block
        tokenEndIndex = findPostDelimiter();
    if(-1 == tokenEndIndex)        
        {
    if(findStartIndex == bufferLength)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1864834222 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1761324562 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1761324562;
            } //End block
            tokenEndIndex = bufferLength;
            findStartIndex = bufferLength;
        } //End block
        matcher.region(tokenStartIndex, tokenEndIndex);
        boolean varB326B5062B2F0E69046810717534CB09_542728782 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88337847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_88337847;
        // ---------- Original Method ----------
        //int tokenStartIndex = 0;
        //int tokenEndIndex = 0;
        //matcher.usePattern(delimiter);
        //matcher.region(findStartIndex, bufferLength);
        //tokenStartIndex = findPreDelimiter();
        //if (setHeadTokenRegion(tokenStartIndex)) {
            //return true;
        //}
        //tokenEndIndex = findPostDelimiter();
        //if (-1 == tokenEndIndex) {
            //if (findStartIndex == bufferLength) {
                //return false;
            //}
            //tokenEndIndex = bufferLength;
            //findStartIndex = bufferLength;
        //}
        //matcher.region(tokenStartIndex, tokenEndIndex);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.898 -0400", hash_original_method = "C22FCAE783E3B780837C6EC57B7427D4", hash_generated_method = "2E0D27684B0D6796DCCCA1EC1044F1DD")
    private int findPreDelimiter() {
        int tokenStartIndex;
        boolean findComplete = false;
        while
(!findComplete)        
        {
    if(matcher.find())            
            {
                findComplete = true;
    if(matcher.start() == findStartIndex
                        && matcher.end() == bufferLength)                
                {
    if(!inputExhausted)                    
                    {
                        readMore();
                        resetMatcher();
                        findComplete = false;
                    } //End block
                } //End block
            } //End block
            else
            {
    if(!inputExhausted)                
                {
                    readMore();
                    resetMatcher();
                } //End block
                else
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_1093248054 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492439331 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492439331;
                } //End block
            } //End block
        } //End block
        tokenStartIndex = matcher.end();
        findStartIndex = matcher.end();
        int var47FDAFC64F7DDB0A9381135F88CE37B1_1054174974 = (tokenStartIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267179301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267179301;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.912 -0400", hash_original_method = "CDCEB3053237613D9179B8FF1482F233", hash_generated_method = "177DE6172237D9704ACB20C0DC3B67F2")
    private boolean setHeadTokenRegion(int findIndex) {
        addTaint(findIndex);
        int tokenStartIndex;
        int tokenEndIndex;
        boolean setSuccess = false;
    if(-1 == findIndex && preStartIndex != bufferLength)        
        {
            tokenStartIndex = preStartIndex;
            tokenEndIndex = bufferLength;
            findStartIndex = bufferLength;
            matcher.region(tokenStartIndex, tokenEndIndex);
            setSuccess = true;
        } //End block
    if(-1 != findIndex && preStartIndex != matcher.start())        
        {
            tokenStartIndex = preStartIndex;
            tokenEndIndex = matcher.start();
            findStartIndex = matcher.start();
            matcher.region(tokenStartIndex, tokenEndIndex);
            setSuccess = true;
        } //End block
        boolean varE25887E46B0D29950156F350013B7359_1596894761 = (setSuccess);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859956200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859956200;
        // ---------- Original Method ----------
        //int tokenStartIndex;
        //int tokenEndIndex;
        //boolean setSuccess = false;
        //if (-1 == findIndex && preStartIndex != bufferLength) {
            //tokenStartIndex = preStartIndex;
            //tokenEndIndex = bufferLength;
            //findStartIndex = bufferLength;
            //matcher.region(tokenStartIndex, tokenEndIndex);
            //setSuccess = true;
        //}
        //if (-1 != findIndex && preStartIndex != matcher.start()) {
            //tokenStartIndex = preStartIndex;
            //tokenEndIndex = matcher.start();
            //findStartIndex = matcher.start();
            //matcher.region(tokenStartIndex, tokenEndIndex);
            //setSuccess = true;
        //}
        //return setSuccess;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.913 -0400", hash_original_method = "2DA8EAAAB20ACFBF7221E1B39889C369", hash_generated_method = "0786B8103C56BE78FB92F7F3B3EF3BEA")
    private int findPostDelimiter() {
        int tokenEndIndex = 0;
        boolean findComplete = false;
        while
(!findComplete)        
        {
    if(matcher.find())            
            {
                findComplete = true;
    if(matcher.start() == findStartIndex
                        && matcher.start() == matcher.end())                
                {
                    findComplete = false;
                } //End block
            } //End block
            else
            {
    if(!inputExhausted)                
                {
                    readMore();
                    resetMatcher();
                } //End block
                else
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_37422288 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137813102 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137813102;
                } //End block
            } //End block
        } //End block
        tokenEndIndex = matcher.start();
        findStartIndex = matcher.start();
        int var115976B362F1C9A69857E6A84ED3F715_1235589834 = (tokenEndIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428151956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428151956;
        // ---------- Original Method ----------
        //int tokenEndIndex = 0;
        //boolean findComplete = false;
        //while (!findComplete) {
            //if (matcher.find()) {
                //findComplete = true;
                //if (matcher.start() == findStartIndex
                        //&& matcher.start() == matcher.end()) {
                    //findComplete = false;
                //}
            //} else {
                //if (!inputExhausted) {
                    //readMore();
                    //resetMatcher();
                //} else {
                    //return -1;
                //}
            //}
        //}
        //tokenEndIndex = matcher.start();
        //findStartIndex = matcher.start();
        //return tokenEndIndex;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.913 -0400", hash_original_method = "71E256A499C0BF5FC1327A59408A7116", hash_generated_method = "1DF49024B4CB53215818AAA178CE5F89")
    private void readMore() {
        int oldPosition = buffer.position();
        int oldBufferLength = bufferLength;
    if(bufferLength >= buffer.capacity())        
        {
            expandBuffer();
        } //End block
        int readCount = 0;
        try 
        {
            buffer.limit(buffer.capacity());
            buffer.position(oldBufferLength);
            while
((readCount = input.read(buffer)) == 0)            
            {
            } //End block
        } //End block
        catch (IOException e)
        {
            bufferLength = buffer.position();
            readCount = -1;
            lastIOException = e;
        } //End block
        buffer.flip();
        buffer.position(oldPosition);
    if(-1 == readCount)        
        {
            inputExhausted = true;
        } //End block
        else
        {
            bufferLength = readCount + bufferLength;
        } //End block
        // ---------- Original Method ----------
        //int oldPosition = buffer.position();
        //int oldBufferLength = bufferLength;
        //if (bufferLength >= buffer.capacity()) {
            //expandBuffer();
        //}
        //int readCount = 0;
        //try {
            //buffer.limit(buffer.capacity());
            //buffer.position(oldBufferLength);
            //while ((readCount = input.read(buffer)) == 0) {
            //}
        //} catch (IOException e) {
            //bufferLength = buffer.position();
            //readCount = -1;
            //lastIOException = e;
        //}
        //buffer.flip();
        //buffer.position(oldPosition);
        //if (-1 == readCount) {
            //inputExhausted = true;
        //} else {
            //bufferLength = readCount + bufferLength;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.913 -0400", hash_original_method = "333CE5605A5055092BA8AAF7729359CC", hash_generated_method = "1561AD8539375CEBEE6C435C8A290497")
    private void expandBuffer() {
        int oldPosition = buffer.position();
        int oldCapacity = buffer.capacity();
        int oldLimit = buffer.limit();
        int newCapacity = oldCapacity * DIPLOID;
        char[] newBuffer = new char[newCapacity];
        System.arraycopy(buffer.array(), 0, newBuffer, 0, oldLimit);
        buffer = CharBuffer.wrap(newBuffer, 0, newCapacity);
        buffer.position(oldPosition);
        buffer.limit(oldLimit);
        // ---------- Original Method ----------
        //int oldPosition = buffer.position();
        //int oldCapacity = buffer.capacity();
        //int oldLimit = buffer.limit();
        //int newCapacity = oldCapacity * DIPLOID;
        //char[] newBuffer = new char[newCapacity];
        //System.arraycopy(buffer.array(), 0, newBuffer, 0, oldLimit);
        //buffer = CharBuffer.wrap(newBuffer, 0, newCapacity);
        //buffer.position(oldPosition);
        //buffer.limit(oldLimit);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_method = "6E6895DF0C38F7FD4A1856B0BE65A90D", hash_generated_method = "2A425DC015A8E574973EA2ED45B68DF1")
    public Scanner reset() {
        delimiter = DEFAULT_DELIMITER;
        locale = Locale.getDefault();
        integerRadix = 10;
Scanner var72A74007B2BE62B849F475C7BDA4658B_1323726731 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1323726731.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1323726731;
        // ---------- Original Method ----------
        //delimiter = DEFAULT_DELIMITER;
        //locale = Locale.getDefault();
        //integerRadix = 10;
        //return this;
    }

    
    private enum DataType {
        INT,
        FLOAT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "BC972EB0D22A6A007EA49964499CB869", hash_generated_field = "198E8DC61E6EE6260DD0FD67EC1BE70A")

    private static final Pattern DEFAULT_DELIMITER = Pattern
            .compile("\\p{javaWhitespace}+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "51B36C22E2A7867914CF920A2F4D5E26", hash_generated_field = "A53C7CC23A0CC495ADEF2FAB7B5DCB77")

    private static final Pattern BOOLEAN_PATTERN = Pattern.compile(
            "true|false", Pattern.CASE_INSENSITIVE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "54CA59FF6F5876977BA085227CBE9E03", hash_generated_field = "34D957310674ACDBDEF2BA84C8EFAF52")

    private static Pattern LINE_TERMINATOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "C5F111F5DE06ACB0CA2CF2B54D5B52E6", hash_generated_field = "6C40428A55C17D2895C0B094BEB1F611")

    private static Pattern MULTI_LINE_TERMINATOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "AA77B9850811932532F09996BDC43803", hash_generated_field = "3C4C83BD4BB2A832CA90E27F9C78BAE2")

    private static Pattern LINE_PATTERN;
    static {
        String NL = "\n|\r\n|\r|\u0085|\u2028|\u2029";
        LINE_TERMINATOR = Pattern.compile(NL);
        MULTI_LINE_TERMINATOR = Pattern.compile("(" + NL + ")+");
        LINE_PATTERN = Pattern.compile(".*(" + NL + ")|.+(" + NL + ")?");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "AE2E9958C069FE6F38E5DC9ADAB45571", hash_generated_field = "D845CBECA21831ED0A78D9A752686AC5")

    private static final Pattern ANY_PATTERN = Pattern.compile("(?s).*");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "6DCC85CA6D691683EE954E4E0F50E8C6", hash_generated_field = "3BA97B4331D762E18310C69487A4537F")

    private static final int DIPLOID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "F5158802C5AD653FFB1072819F8D7B16", hash_generated_field = "6AD996F6F0E1D10B17B6B57671BFAA93")

    private static final int DEFAULT_RADIX = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.914 -0400", hash_original_field = "3D936557EB560A417CDF2BC916B4B530", hash_generated_field = "943912C72E8350CCD8E69B9D60A0C886")

    private static final int DEFAULT_TRUNK_SIZE = 1024;
}

