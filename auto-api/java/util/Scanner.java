package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "E0D52F97F351E69EECDE3C383EA70269")

    private Readable input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "D260AE04E52CF23D72C8A3D8295E450B")

    private CharBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "B8E0CA1AFB60AD862E8369C4D5F39FEA", hash_generated_field = "7320765086863239DD8B2CE732355E5C")

    private Pattern delimiter = DEFAULT_DELIMITER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "FDB7D6BFCC3EFCF7BA578D70678C9F4B", hash_generated_field = "B6C086223608E4F54F76DF9A158EFEB4")

    private Matcher matcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "FA9861E386E410DF8EB9AD9D2561E649", hash_generated_field = "C3DABC3C885E91F4BEBE65D18A5D41DF")

    private int integerRadix = DEFAULT_RADIX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "C1406C33C5F41CED8E9C966043746C79", hash_generated_field = "E93B6DD8D2B917BF94B1E13ADC86BBF9")

    private Locale locale = Locale.getDefault();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "CA1A63C6156AD6EA04F7B3D6A296C793", hash_generated_field = "08240EC224E7D1F658B6C3E2B561656E")

    private int findStartIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "85E47497E5075EC4FAD041D1AC3E7907", hash_generated_field = "6421FE0EA4BD2B6775B9AA3004FC3126")

    private int preStartIndex = findStartIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "F4B7711D92CBAB86DA3D6B89D16B006B", hash_generated_field = "C005C413DDA0AFEE3D457FA4BFDF129F")

    private int bufferLength = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "460DFB1105EAD6E581494BC8EB7172AC", hash_generated_field = "94160D1F6EC5CF5867F2CCE7946E9FCB")

    private IOException lastIOException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "4B9929219B077CB687C4CDA9B01D2231", hash_generated_field = "FB51DEF3DC08BBEC5FA219733A95DF92")

    private boolean matchSuccessful = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.424 -0400", hash_original_field = "DBECB303151001B254CD458C962BFA06", hash_generated_field = "5CD50592C114680F0C3429A3015DD789")

    private DecimalFormat decimalFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.425 -0400", hash_original_field = "A0533E79DCA29CE143919C4A4025A07C", hash_generated_field = "835E9638D88C3871B5D667F83042A305")

    private boolean inputExhausted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.425 -0400", hash_original_field = "C1D78FE4623EB325FEA6F819E294DAD7", hash_generated_field = "16846571F2386772C11DF4DB11C6F290")

    private Object cacheHasNextValue = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.425 -0400", hash_original_field = "34E465836A10E49DF126E5F70F0785FC", hash_generated_field = "890CB8D9E7ACCC8E639BDCEBE76016CB")

    private int cachehasNextIndex = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.425 -0400", hash_original_method = "B810C33BB807151E40D15163250E5E02", hash_generated_method = "321539E3B9BA845EF9F76541A8DBF8C3")
    public  Scanner(File src) throws FileNotFoundException {
        this(src, Charset.defaultCharset().name());
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.425 -0400", hash_original_method = "CF25217F399E81A22DEECAEA7B649FFD", hash_generated_method = "27105B4B559A8A60028968D760CBB993")
    public  Scanner(File src, String charsetName) throws FileNotFoundException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("src == null");
        } //End block
        FileInputStream fis;
        fis = new FileInputStream(src);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("charsetName == null");
        } //End block
        try 
        {
            input = new InputStreamReader(fis, charsetName);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            IoUtils.closeQuietly(fis);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e.getMessage());
        } //End block
        initialization();
        addTaint(src.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.434 -0400", hash_original_method = "4332C70F225A92CAAA372FEA2EE20E90", hash_generated_method = "B648128C94F00F07C9AB0502C3851792")
    public  Scanner(String src) {
        input = new StringReader(src);
        initialization();
        // ---------- Original Method ----------
        //input = new StringReader(src);
        //initialization();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.435 -0400", hash_original_method = "C892D51D9056C33835D132934536F6A9", hash_generated_method = "29915AE179E011A2C0282BFECF6B6B0F")
    public  Scanner(InputStream src) {
        this(src, Charset.defaultCharset().name());
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.435 -0400", hash_original_method = "BF515108409EAD1D2D6060053F2B8EDA", hash_generated_method = "094DCDA8EDE8D905929B46799AB4E254")
    public  Scanner(InputStream src, String charsetName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("src == null");
        } //End block
        try 
        {
            input = new InputStreamReader(src, charsetName);
        } //End block
        catch (UnsupportedEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e.getMessage());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.435 -0400", hash_original_method = "E0E6972A58007CF9E26777BD359FD5D7", hash_generated_method = "593D7F71C644C674A01E1A80D5271FF2")
    public  Scanner(Readable src) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.436 -0400", hash_original_method = "246C896BCE9403BE34073893721DED9F", hash_generated_method = "24C2F70730EE9356054D047DBB43A0CE")
    public  Scanner(ReadableByteChannel src) {
        this(src, Charset.defaultCharset().name());
        addTaint(src.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.437 -0400", hash_original_method = "88C5EB3CF5CA9A4257014ADC8E6F132C", hash_generated_method = "5AA9885E1A21042636E8AE09D0AFC384")
    public  Scanner(ReadableByteChannel src, String charsetName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("src == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("charsetName == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.437 -0400", hash_original_method = "BE0E5A82355C52347C0C57A7BA02C4C5", hash_generated_method = "6FC330AB026C6D73857CA97BDC6C621B")
    public void close() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.442 -0400", hash_original_method = "E452C40637B7AD54EC03E79C646861D9", hash_generated_method = "60DF8F543D6AFB05ADC67B2CDF957F7E")
    public Pattern delimiter() {
        Pattern varB4EAC82CA7396A68D541C85D26508E83_1164210517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1164210517 = delimiter;
        varB4EAC82CA7396A68D541C85D26508E83_1164210517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1164210517;
        // ---------- Original Method ----------
        //return delimiter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.458 -0400", hash_original_method = "8312FC53E313435440A1A7306CBE2B24", hash_generated_method = "EA046917D8BE11FC82C745E89B79962E")
    public String findInLine(Pattern pattern) {
        String varB4EAC82CA7396A68D541C85D26508E83_856530687 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1628282915 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_815804966 = null; //Variable for return #3
        checkClosed();
        checkNull(pattern);
        int horizonLineSeparator;
        horizonLineSeparator = 0;
        matcher.usePattern(MULTI_LINE_TERMINATOR);
        matcher.region(findStartIndex, bufferLength);
        boolean findComplete;
        findComplete = false;
        int terminatorLength;
        terminatorLength = 0;
        {
            {
                boolean varC81C93FFC3EB18993C4322F990495240_744361995 = (matcher.find());
                {
                    horizonLineSeparator = matcher.start();
                    terminatorLength = matcher.end() - matcher.start();
                    findComplete = true;
                } //End block
                {
                    {
                        readMore();
                        resetMatcher();
                    } //End block
                    {
                        horizonLineSeparator = bufferLength;
                        findComplete = true;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        matcher.usePattern(pattern);
        int oldLimit;
        oldLimit = buffer.limit();
        buffer.limit(horizonLineSeparator + terminatorLength);
        matcher.region(findStartIndex, horizonLineSeparator + terminatorLength);
        {
            boolean var0CA07C7E05B5FB943A39E313382D5DA2_245131336 = (matcher.find());
            {
                findStartIndex = matcher.end();
                {
                    boolean varC973DC3C16D7E82501804822AF7C6A11_2113637053 = (horizonLineSeparator == matcher.end());
                    {
                        findStartIndex += terminatorLength;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var83C2BDFDE75409D63F2A50C71C5591B6_491600206 = (horizonLineSeparator != bufferLength
                    && (horizonLineSeparator + terminatorLength == matcher
                            .end()));
                    {
                        buffer.limit(oldLimit);
                        matchSuccessful = false;
                        varB4EAC82CA7396A68D541C85D26508E83_856530687 = null;
                    } //End block
                } //End collapsed parenthetic
                matchSuccessful = true;
                buffer.limit(oldLimit);
                varB4EAC82CA7396A68D541C85D26508E83_1628282915 = matcher.group();
            } //End block
        } //End collapsed parenthetic
        buffer.limit(oldLimit);
        matchSuccessful = false;
        varB4EAC82CA7396A68D541C85D26508E83_815804966 = null;
        addTaint(pattern.getTaint());
        String varA7E53CE21691AB073D9660D615818899_657023209; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_657023209 = varB4EAC82CA7396A68D541C85D26508E83_856530687;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_657023209 = varB4EAC82CA7396A68D541C85D26508E83_1628282915;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_657023209 = varB4EAC82CA7396A68D541C85D26508E83_815804966;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_657023209.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_657023209;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.459 -0400", hash_original_method = "D8B205142F30EEA5F1FA557732B63716", hash_generated_method = "F5370614251AA08B12FDAD3A2437131F")
    public String findInLine(String pattern) {
        String varB4EAC82CA7396A68D541C85D26508E83_1789266246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1789266246 = findInLine(Pattern.compile(pattern));
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1789266246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1789266246;
        // ---------- Original Method ----------
        //return findInLine(Pattern.compile(pattern));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.474 -0400", hash_original_method = "9C32C72D7AABC6AF4F26B68B84901E99", hash_generated_method = "6C9C9ADE148D617901B8B916C73898B8")
    public String findWithinHorizon(Pattern pattern, int horizon) {
        String varB4EAC82CA7396A68D541C85D26508E83_289973599 = null; //Variable for return #1
        checkClosed();
        checkNull(pattern);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("horizon < 0");
        } //End block
        matcher.usePattern(pattern);
        String result;
        result = null;
        int findEndIndex;
        findEndIndex = 0;
        int horizonEndIndex;
        horizonEndIndex = 0;
        {
            horizonEndIndex = Integer.MAX_VALUE;
        } //End block
        {
            horizonEndIndex = findStartIndex + horizon;
        } //End block
        {
            findEndIndex = bufferLength;
            findEndIndex = Math.min(horizonEndIndex, bufferLength);
            boolean isHorizonInBuffer;
            isHorizonInBuffer = (horizonEndIndex <= bufferLength);
            matcher.region(findStartIndex, findEndIndex);
            {
                boolean varC81C93FFC3EB18993C4322F990495240_1283845868 = (matcher.find());
                {
                    {
                        result = matcher.group();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
        {
            findStartIndex = matcher.end();
            matchSuccessful = true;
        } //End block
        {
            matchSuccessful = false;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_289973599 = result;
        addTaint(pattern.getTaint());
        addTaint(horizon);
        varB4EAC82CA7396A68D541C85D26508E83_289973599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289973599;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.475 -0400", hash_original_method = "A3C55B99475A85AD2BF4742E957D07D7", hash_generated_method = "8A5BB93739A9A1ED4F40E9C66FEFBDD5")
    public String findWithinHorizon(String pattern, int horizon) {
        String varB4EAC82CA7396A68D541C85D26508E83_1724643372 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1724643372 = findWithinHorizon(Pattern.compile(pattern), horizon);
        addTaint(pattern.getTaint());
        addTaint(horizon);
        varB4EAC82CA7396A68D541C85D26508E83_1724643372.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1724643372;
        // ---------- Original Method ----------
        //return findWithinHorizon(Pattern.compile(pattern), horizon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.476 -0400", hash_original_method = "A3E9F8A3E3BBCA86A059EA14ECB05A95", hash_generated_method = "AB5EA5D052B1F1D15F70A8E8E74FF8EB")
    public boolean hasNext() {
        boolean var6F321AE48FBCC2779DC0106D6CF87AA5_1673115496 = (hasNext(ANY_PATTERN));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837701101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837701101;
        // ---------- Original Method ----------
        //return hasNext(ANY_PATTERN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.477 -0400", hash_original_method = "31E7CF1F7239BC857AE7CC1A1F63EEFE", hash_generated_method = "3EA70A1A3709C13D0A03472CC45585CB")
    public boolean hasNext(Pattern pattern) {
        checkClosed();
        checkNull(pattern);
        matchSuccessful = false;
        saveCurrentStatus();
        {
            boolean var90E773CB6ED496A6025F7752708AFB24_1587801962 = (!setTokenRegion());
            {
                recoverPreviousStatus();
            } //End block
        } //End collapsed parenthetic
        matcher.usePattern(pattern);
        boolean hasNext;
        hasNext = false;
        {
            boolean varFADF96381EFE04681902A91CE218A31F_804789118 = (matcher.matches());
            {
                cachehasNextIndex = findStartIndex;
                matchSuccessful = true;
                hasNext = true;
            } //End block
        } //End collapsed parenthetic
        recoverPreviousStatus();
        addTaint(pattern.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153633355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_153633355;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.480 -0400", hash_original_method = "9958A7260053054A7CE88A67057D0BAF", hash_generated_method = "053F71C29F780BB4727E6DC4867F92EA")
    public boolean hasNext(String pattern) {
        boolean var3A8A72ECB858C1629A69224B0D16726F_1765042770 = (hasNext(Pattern.compile(pattern)));
        addTaint(pattern.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338522025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338522025;
        // ---------- Original Method ----------
        //return hasNext(Pattern.compile(pattern));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.487 -0400", hash_original_method = "725531718FDC15B509CB20755672217B", hash_generated_method = "C25375C106A732F6C7C755D1D9BF07D3")
    public boolean hasNextBigDecimal() {
        Pattern floatPattern;
        floatPattern = getFloatPattern();
        boolean isBigDecimalValue;
        isBigDecimalValue = false;
        {
            boolean varB4A1C6A64CCF48913AC10C0BB6AFBD2B_840313255 = (hasNext(floatPattern));
            {
                String floatString;
                floatString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225819838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_225819838;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.487 -0400", hash_original_method = "E4D3C235D8E1DAFC304BAA9FB6E2754B", hash_generated_method = "F6A7CF4EF44AE7C2936E788517B4E42D")
    public boolean hasNextBigInteger() {
        boolean var0196A9A5858CC1CE433F1F0BFAAB1D96_1084548122 = (hasNextBigInteger(integerRadix));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087240833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087240833;
        // ---------- Original Method ----------
        //return hasNextBigInteger(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.495 -0400", hash_original_method = "C25E77B6A38D1DC9BA3B0FA0BBEC50D5", hash_generated_method = "30CE438BBAEE5C31D15801E45FBFF713")
    public boolean hasNextBigInteger(int radix) {
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        boolean isBigIntegerValue;
        isBigIntegerValue = false;
        {
            boolean var11B967304DF8F28BEA485AA5ECE743AE_1289655551 = (hasNext(integerPattern));
            {
                String intString;
                intString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063582168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063582168;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.495 -0400", hash_original_method = "EB649DF4AB30251C023B5B81F2B2B0E4", hash_generated_method = "AF429001891A2ADAA10357C6CAD13F90")
    public boolean hasNextBoolean() {
        boolean varB53E3FE180289CBAFA6AE77C9732CA60_54094339 = (hasNext(BOOLEAN_PATTERN));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1086973783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1086973783;
        // ---------- Original Method ----------
        //return hasNext(BOOLEAN_PATTERN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.498 -0400", hash_original_method = "58199F8244631FBA465F06EC32762D29", hash_generated_method = "9797C217ED3ED5D6AF2B4777E2179718")
    public boolean hasNextByte() {
        boolean var02A3EA26BCF9E125D9C3FFC9CBE136F5_1412192088 = (hasNextByte(integerRadix));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131775323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131775323;
        // ---------- Original Method ----------
        //return hasNextByte(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.498 -0400", hash_original_method = "A5B80B22ED065BD547115A7BB2F2B96D", hash_generated_method = "9AA0A9C7A3417F351FA56105A66571E9")
    public boolean hasNextByte(int radix) {
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        boolean isByteValue;
        isByteValue = false;
        {
            boolean var11B967304DF8F28BEA485AA5ECE743AE_1680810005 = (hasNext(integerPattern));
            {
                String intString;
                intString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1429752003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1429752003;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.499 -0400", hash_original_method = "66A96A75B245956604135FA693CF46B1", hash_generated_method = "E4B237E21E514929210423D8085AA3CF")
    public boolean hasNextDouble() {
        Pattern floatPattern;
        floatPattern = getFloatPattern();
        boolean isDoubleValue;
        isDoubleValue = false;
        {
            boolean varB4A1C6A64CCF48913AC10C0BB6AFBD2B_803592974 = (hasNext(floatPattern));
            {
                String floatString;
                floatString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274623010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274623010;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.505 -0400", hash_original_method = "FBD2AAA8FD71EC1957BF71E495BA575B", hash_generated_method = "6C5874C33000BF3C55AFFBE0A5292873")
    public boolean hasNextFloat() {
        Pattern floatPattern;
        floatPattern = getFloatPattern();
        boolean isFloatValue;
        isFloatValue = false;
        {
            boolean varB4A1C6A64CCF48913AC10C0BB6AFBD2B_1661245370 = (hasNext(floatPattern));
            {
                String floatString;
                floatString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129939777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_129939777;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.505 -0400", hash_original_method = "5C4A5382507FD210B704AB0FDDE676B5", hash_generated_method = "A05E92D9C180D966CBF5B95862357828")
    public boolean hasNextInt() {
        boolean var6DE888DE12299605C3F9E57D3BBA6E8D_244954255 = (hasNextInt(integerRadix));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503456908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503456908;
        // ---------- Original Method ----------
        //return hasNextInt(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.519 -0400", hash_original_method = "98DA0996AE9A85FE2EB4C6BCBC334600", hash_generated_method = "EAB33EBBE865B6C1DD43122DDEA413F8")
    public boolean hasNextInt(int radix) {
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        boolean isIntValue;
        isIntValue = false;
        {
            boolean var11B967304DF8F28BEA485AA5ECE743AE_230638052 = (hasNext(integerPattern));
            {
                String intString;
                intString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163841051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_163841051;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.521 -0400", hash_original_method = "F85B53817DDA0DC627A3FD344338966A", hash_generated_method = "17FD9F3DE454A18EDEF46092C6B4CCF0")
    public boolean hasNextLine() {
        checkClosed();
        matcher.usePattern(LINE_PATTERN);
        matcher.region(findStartIndex, bufferLength);
        boolean hasNextLine;
        hasNextLine = false;
        {
            {
                boolean varC81C93FFC3EB18993C4322F990495240_1596871650 = (matcher.find());
                {
                    {
                        boolean var9DD87D5E90648769B98EF4880B492AA1_790131810 = (inputExhausted || matcher.end() != bufferLength);
                        {
                            matchSuccessful = true;
                            hasNextLine = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        matchSuccessful = false;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250923449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250923449;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.535 -0400", hash_original_method = "4E2EF7109AFFFF700ACDD8E154A60B95", hash_generated_method = "DB7B11C8DF0C0EA34C8038E6EBD56563")
    public boolean hasNextLong() {
        boolean varDF7B3B22533C646BC7D09B4EC88940C8_84583133 = (hasNextLong(integerRadix));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770342765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_770342765;
        // ---------- Original Method ----------
        //return hasNextLong(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.537 -0400", hash_original_method = "9F7A3D072C1FB851C44AA1EFB73ED70A", hash_generated_method = "6BA3C18466951F6168956960A87680F6")
    public boolean hasNextLong(int radix) {
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        boolean isLongValue;
        isLongValue = false;
        {
            boolean var11B967304DF8F28BEA485AA5ECE743AE_1545837419 = (hasNext(integerPattern));
            {
                String intString;
                intString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526294787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526294787;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.537 -0400", hash_original_method = "68819BFDCF6E57EBBFC27075215E0009", hash_generated_method = "A30DFBE1AA9570387683E0C1914094D6")
    public boolean hasNextShort() {
        boolean var693B553177EEA966D95235F42566BDEA_1869108443 = (hasNextShort(integerRadix));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074626724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074626724;
        // ---------- Original Method ----------
        //return hasNextShort(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.538 -0400", hash_original_method = "BC1837EAC21D315C1A66DDC5582DCF81", hash_generated_method = "E2A52EE25A0BA17FCD8C53D57A9C04FA")
    public boolean hasNextShort(int radix) {
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        boolean isShortValue;
        isShortValue = false;
        {
            boolean var11B967304DF8F28BEA485AA5ECE743AE_2012702557 = (hasNext(integerPattern));
            {
                String intString;
                intString = matcher.group();
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
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270927666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270927666;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.538 -0400", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "58C42013F2B263E60648909295ED76AF")
    public IOException ioException() {
        IOException varB4EAC82CA7396A68D541C85D26508E83_761628432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_761628432 = lastIOException;
        varB4EAC82CA7396A68D541C85D26508E83_761628432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761628432;
        // ---------- Original Method ----------
        //return lastIOException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.538 -0400", hash_original_method = "21C822C4BC15A6F74D874095878E5501", hash_generated_method = "A5A2A1AD8242E69A74B401FC7451F8AB")
    public Locale locale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_218590000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_218590000 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_218590000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_218590000;
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.543 -0400", hash_original_method = "2D94F093F10F1A8356EDEC86FADDCA70", hash_generated_method = "2B0F972B378C61860216134DBC02CC1B")
    public MatchResult match() {
        MatchResult varB4EAC82CA7396A68D541C85D26508E83_697451552 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_697451552 = matcher.toMatchResult();
        varB4EAC82CA7396A68D541C85D26508E83_697451552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697451552;
        // ---------- Original Method ----------
        //if (!matchSuccessful) {
            //throw new IllegalStateException();
        //}
        //return matcher.toMatchResult();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.543 -0400", hash_original_method = "A473F9C9E320CD6CEDCE3CE271E08C07", hash_generated_method = "C10BB60E678B01D62F9D58A6618A5C8F")
    public String next() {
        String varB4EAC82CA7396A68D541C85D26508E83_1328258288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1328258288 = next(ANY_PATTERN);
        varB4EAC82CA7396A68D541C85D26508E83_1328258288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1328258288;
        // ---------- Original Method ----------
        //return next(ANY_PATTERN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.559 -0400", hash_original_method = "064C5502A668BA6541E1986AFB8ECCE1", hash_generated_method = "CD354E83D84046B02823486E6A7ADC1A")
    public String next(Pattern pattern) {
        String varB4EAC82CA7396A68D541C85D26508E83_1650923372 = null; //Variable for return #1
        checkClosed();
        checkNull(pattern);
        matchSuccessful = false;
        saveCurrentStatus();
        {
            boolean var90E773CB6ED496A6025F7752708AFB24_1539124432 = (!setTokenRegion());
            {
                recoverPreviousStatus();
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
        } //End collapsed parenthetic
        matcher.usePattern(pattern);
        {
            boolean var29857123035FF7A64A8598EB68050605_1716838440 = (!matcher.matches());
            {
                recoverPreviousStatus();
                if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
            } //End block
        } //End collapsed parenthetic
        matchSuccessful = true;
        varB4EAC82CA7396A68D541C85D26508E83_1650923372 = matcher.group();
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1650923372.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1650923372;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.562 -0400", hash_original_method = "4894718ADE2D067062D34204C5088110", hash_generated_method = "57CC8318622AED87B47071600A65E418")
    public String next(String pattern) {
        String varB4EAC82CA7396A68D541C85D26508E83_1732796967 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1732796967 = next(Pattern.compile(pattern));
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1732796967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1732796967;
        // ---------- Original Method ----------
        //return next(Pattern.compile(pattern));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.571 -0400", hash_original_method = "E9A644C72A3309EE871164344474A07C", hash_generated_method = "FC4A3C76E8B3EC3FE02992016F9CAFE5")
    public BigDecimal nextBigDecimal() {
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_544276203 = null; //Variable for return #1
        BigDecimal varB4EAC82CA7396A68D541C85D26508E83_1140759217 = null; //Variable for return #2
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
            varB4EAC82CA7396A68D541C85D26508E83_544276203 = (BigDecimal) obj;
        } //End block
        Pattern floatPattern;
        floatPattern = getFloatPattern();
        String floatString;
        floatString = next(floatPattern);
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
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1140759217 = bigDecimalValue;
        BigDecimal varA7E53CE21691AB073D9660D615818899_1837083394; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1837083394 = varB4EAC82CA7396A68D541C85D26508E83_544276203;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1837083394 = varB4EAC82CA7396A68D541C85D26508E83_1140759217;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1837083394.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1837083394;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.572 -0400", hash_original_method = "144A2EEE9BFD199E176BF785D76B1260", hash_generated_method = "6967622B5004E71007E2BA2A27D45057")
    public BigInteger nextBigInteger() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1514224890 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1514224890 = nextBigInteger(integerRadix);
        varB4EAC82CA7396A68D541C85D26508E83_1514224890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514224890;
        // ---------- Original Method ----------
        //return nextBigInteger(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.590 -0400", hash_original_method = "A32F88E5530C257A4D62223BBE0A1F90", hash_generated_method = "64B4C36ECEB4329217321204C3909859")
    public BigInteger nextBigInteger(int radix) {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2109256145 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_820688447 = null; //Variable for return #2
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
            varB4EAC82CA7396A68D541C85D26508E83_2109256145 = (BigInteger) obj;
        } //End block
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        String intString;
        intString = next(integerPattern);
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
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_820688447 = bigIntegerValue;
        addTaint(radix);
        BigInteger varA7E53CE21691AB073D9660D615818899_1257145897; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1257145897 = varB4EAC82CA7396A68D541C85D26508E83_2109256145;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1257145897 = varB4EAC82CA7396A68D541C85D26508E83_820688447;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1257145897.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1257145897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.592 -0400", hash_original_method = "D0E4DE4C67E1DCF9B9C54027B3E1E21D", hash_generated_method = "DFEDCCEB56DE52091DE368C06EE79808")
    public boolean nextBoolean() {
        boolean var6FFC68F71983272DF7DEF6C4FCB03A47_127205581 = (Boolean.parseBoolean(next(BOOLEAN_PATTERN)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983314644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983314644;
        // ---------- Original Method ----------
        //return Boolean.parseBoolean(next(BOOLEAN_PATTERN));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.592 -0400", hash_original_method = "7CE1C60D76B7F2532B9BC1651A113CEF", hash_generated_method = "54E0F8015717CD661016CAE6B72D755B")
    public byte nextByte() {
        byte var7FD8022BC1F87A4308617EB2810AC102_621927845 = (nextByte(integerRadix));
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1442399685 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1442399685;
        // ---------- Original Method ----------
        //return nextByte(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.593 -0400", hash_original_method = "9181863BF854F96D8E1FF1A461B82F5F", hash_generated_method = "DF5B8FE3862E9B423DAE9B1FFCB18DEE")
    @SuppressWarnings("boxing")
    public byte nextByte(int radix) {
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
        } //End block
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        String intString;
        intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        byte byteValue;
        byteValue = 0;
        try 
        {
            byteValue = Byte.parseByte(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        addTaint(radix);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_874039416 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_874039416;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.602 -0400", hash_original_method = "59ED3F69878B10BC787D8DCCAB5B2B3E", hash_generated_method = "D3AC1BFE68F87307965DF742370DA491")
    @SuppressWarnings("boxing")
    public double nextDouble() {
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
        } //End block
        Pattern floatPattern;
        floatPattern = getFloatPattern();
        String floatString;
        floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        double doubleValue;
        doubleValue = 0;
        try 
        {
            doubleValue = Double.parseDouble(floatString);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        double varE8CD7DA078A86726031AD64F35F5A6C0_593663673 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_593663673;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.603 -0400", hash_original_method = "465894BBFB87D2894D77A1BB6EACCD0F", hash_generated_method = "2D994F63D5B7E22294B2169348B987D0")
    @SuppressWarnings("boxing")
    public float nextFloat() {
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
        } //End block
        Pattern floatPattern;
        floatPattern = getFloatPattern();
        String floatString;
        floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        float floatValue;
        floatValue = 0;
        try 
        {
            floatValue = Float.parseFloat(floatString);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_1869990781 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1869990781;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.606 -0400", hash_original_method = "5185135F499E2963894A73963B55B971", hash_generated_method = "6A3D8C579FBC3BEBBB87EBD47B91FBAE")
    public int nextInt() {
        int var1C5EA91DC98D35128AFBA198A5AD6FF1_443604361 = (nextInt(integerRadix));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986785437 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986785437;
        // ---------- Original Method ----------
        //return nextInt(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.614 -0400", hash_original_method = "B06EC911E3305341017BDCE4EADE227D", hash_generated_method = "C9483003B75F742EFAE844EB66650FA6")
    @SuppressWarnings("boxing")
    public int nextInt(int radix) {
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
        } //End block
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        String intString;
        intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        int intValue;
        intValue = 0;
        try 
        {
            intValue = Integer.parseInt(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        addTaint(radix);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625264894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625264894;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.623 -0400", hash_original_method = "3D66719B22D4824A272B09AB38D3D0FA", hash_generated_method = "5B59F1EAFAF1B4440F4E79B895AA3FE1")
    public String nextLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1439094054 = null; //Variable for return #1
        checkClosed();
        matcher.usePattern(LINE_PATTERN);
        matcher.region(findStartIndex, bufferLength);
        String result;
        result = null;
        {
            {
                boolean varC81C93FFC3EB18993C4322F990495240_1087775130 = (matcher.find());
                {
                    {
                        boolean var49D2780ED78A78184ADD9D70F9889E1C_1395916001 = (inputExhausted || matcher.end() != bufferLength
                        || bufferLength < buffer.capacity());
                        {
                            matchSuccessful = true;
                            findStartIndex = matcher.end();
                            result = matcher.group();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        matchSuccessful = false;
                        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
        {
            Matcher terminatorMatcher;
            terminatorMatcher = LINE_TERMINATOR.matcher(result);
            {
                boolean varA4CAC517FC5FC898470DC04D18C6CEF6_1094172334 = (terminatorMatcher.find());
                {
                    result = result.substring(0, terminatorMatcher.start());
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1439094054 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1439094054.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1439094054;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.624 -0400", hash_original_method = "6374462D33C9F89E6E50C3F6D20F5373", hash_generated_method = "98064FF5575B44A7080E548DDEB4D692")
    public long nextLong() {
        long var5538EBA5E58F7EFE2A994D53F5D75507_1612001573 = (nextLong(integerRadix));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_785244603 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_785244603;
        // ---------- Original Method ----------
        //return nextLong(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.625 -0400", hash_original_method = "36B6D1B74C7A404A698E79C7D45F2371", hash_generated_method = "67CB700B90B919F9AC61F837E76F08D5")
    @SuppressWarnings("boxing")
    public long nextLong(int radix) {
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
        } //End block
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        String intString;
        intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        long longValue;
        longValue = 0;
        try 
        {
            longValue = Long.parseLong(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        addTaint(radix);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1291329689 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1291329689;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.625 -0400", hash_original_method = "D33600E854DF5F367D7728611F6ACBC6", hash_generated_method = "6A34EB5890AE2546747F410BB16128C8")
    public short nextShort() {
        short var2418559F57A18A581ADCAC36A4B2F6CE_2086191197 = (nextShort(integerRadix));
        short var4F09DAA9D95BCB166A302407A0E0BABE_731528331 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_731528331;
        // ---------- Original Method ----------
        //return nextShort(integerRadix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.626 -0400", hash_original_method = "74041A63415BC5E03BF2BCCD0D0C92EB", hash_generated_method = "D489CDEE136E2A6769480817F8C138B9")
    @SuppressWarnings("boxing")
    public short nextShort(int radix) {
        checkClosed();
        Object obj;
        obj = cacheHasNextValue;
        cacheHasNextValue = null;
        {
            findStartIndex = cachehasNextIndex;
        } //End block
        Pattern integerPattern;
        integerPattern = getIntegerPattern(radix);
        String intString;
        intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        short shortValue;
        shortValue = 0;
        try 
        {
            shortValue = Short.parseShort(intString, radix);
        } //End block
        catch (NumberFormatException e)
        {
            matchSuccessful = false;
            recoverPreviousStatus();
            if (DroidSafeAndroidRuntime.control) throw new InputMismatchException();
        } //End block
        addTaint(radix);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1910004027 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1910004027;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.627 -0400", hash_original_method = "108FFB02BFAD84F212F542E44C9F6CE4", hash_generated_method = "BDDB03D491D7B22360796F46D832FF64")
    public int radix() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239751096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239751096;
        // ---------- Original Method ----------
        //return integerRadix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.650 -0400", hash_original_method = "EA8E10FC12D1B40BE210D235F143A214", hash_generated_method = "17AEF65AF0484F0516B27148BD5BEA9C")
    public Scanner skip(Pattern pattern) {
        Scanner varB4EAC82CA7396A68D541C85D26508E83_794815760 = null; //Variable for return #1
        checkClosed();
        checkNull(pattern);
        matcher.usePattern(pattern);
        matcher.region(findStartIndex, bufferLength);
        {
            {
                boolean var00DA13F1A4F224F81E84320C9A166B45_871298018 = (matcher.lookingAt());
                {
                    boolean matchInBuffer;
                    matchInBuffer = matcher.end() < bufferLength
                        || (matcher.end() == bufferLength && inputExhausted);
                    {
                        matchSuccessful = true;
                        findStartIndex = matcher.end();
                    } //End block
                } //End block
                {
                    {
                        matchSuccessful = false;
                        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                readMore();
                resetMatcher();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_794815760 = this;
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_794815760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794815760;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.654 -0400", hash_original_method = "B5629C8DC277AD4A72B913564449A4A1", hash_generated_method = "DBBA20E1D929AD0FFEB809AF0A37AD0F")
    public Scanner skip(String pattern) {
        Scanner varB4EAC82CA7396A68D541C85D26508E83_1284906707 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1284906707 = skip(Pattern.compile(pattern));
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1284906707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1284906707;
        // ---------- Original Method ----------
        //return skip(Pattern.compile(pattern));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.669 -0400", hash_original_method = "13B9E1963603D8F8D017FAED70E76372", hash_generated_method = "AF190B3850A446EEC690B749073A3012")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1307418852 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1307418852 = getClass().getName() +
                "[delimiter=" + delimiter +
                ",findStartIndex=" + findStartIndex +
                ",matchSuccessful=" + matchSuccessful +
                ",closed=" + closed +
                "]";
        varB4EAC82CA7396A68D541C85D26508E83_1307418852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307418852;
        // ---------- Original Method ----------
        //return getClass().getName() +
                //"[delimiter=" + delimiter +
                //",findStartIndex=" + findStartIndex +
                //",matchSuccessful=" + matchSuccessful +
                //",closed=" + closed +
                //"]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.682 -0400", hash_original_method = "E89CBE82FDB8B0CDDF4705672288D942", hash_generated_method = "2F17057A6723D2B3892B5D5EABF70C96")
    public Scanner useDelimiter(Pattern pattern) {
        Scanner varB4EAC82CA7396A68D541C85D26508E83_435885270 = null; //Variable for return #1
        delimiter = pattern;
        varB4EAC82CA7396A68D541C85D26508E83_435885270 = this;
        varB4EAC82CA7396A68D541C85D26508E83_435885270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_435885270;
        // ---------- Original Method ----------
        //delimiter = pattern;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.683 -0400", hash_original_method = "353C3ED30BA7FF969DF17D7F091BC9CC", hash_generated_method = "3877975C9237D0135FD4655F51FEA772")
    public Scanner useDelimiter(String pattern) {
        Scanner varB4EAC82CA7396A68D541C85D26508E83_1472174911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1472174911 = useDelimiter(Pattern.compile(pattern));
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1472174911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1472174911;
        // ---------- Original Method ----------
        //return useDelimiter(Pattern.compile(pattern));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.684 -0400", hash_original_method = "A3D9C7BB7710DA92E291534F4EEE6EBE", hash_generated_method = "2CA504B4D5849F64380C3E9865696AC9")
    public Scanner useLocale(Locale l) {
        Scanner varB4EAC82CA7396A68D541C85D26508E83_661024360 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.locale = l;
        varB4EAC82CA7396A68D541C85D26508E83_661024360 = this;
        varB4EAC82CA7396A68D541C85D26508E83_661024360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_661024360;
        // ---------- Original Method ----------
        //if (l == null) {
            //throw new NullPointerException();
        //}
        //this.locale = l;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.692 -0400", hash_original_method = "345B5E07834B16EBD69B375363EEC767", hash_generated_method = "FE92B0F753191CDF541F1C2A37933EA8")
    public Scanner useRadix(int radix) {
        Scanner varB4EAC82CA7396A68D541C85D26508E83_1532279458 = null; //Variable for return #1
        checkRadix(radix);
        this.integerRadix = radix;
        varB4EAC82CA7396A68D541C85D26508E83_1532279458 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1532279458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1532279458;
        // ---------- Original Method ----------
        //checkRadix(radix);
        //this.integerRadix = radix;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.693 -0400", hash_original_method = "A1030C8BAA30073CC5ACF726BB676E36", hash_generated_method = "11D05444247304B887F17D11E0C51293")
    private void checkRadix(int radix) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid radix: " + radix);
        } //End block
        addTaint(radix);
        // ---------- Original Method ----------
        //if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            //throw new IllegalArgumentException("Invalid radix: " + radix);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.693 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
    public void remove() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.693 -0400", hash_original_method = "406043B74DF8E969B61AA0BA511B152F", hash_generated_method = "C3800FC0AB14E78A4E511D811768D6B9")
    private void initialization() {
        buffer = CharBuffer.allocate(DEFAULT_TRUNK_SIZE);
        buffer.limit(0);
        matcher = delimiter.matcher(buffer);
        // ---------- Original Method ----------
        //buffer = CharBuffer.allocate(DEFAULT_TRUNK_SIZE);
        //buffer.limit(0);
        //matcher = delimiter.matcher(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.697 -0400", hash_original_method = "B30B600A81B32166D215C68FA4624658", hash_generated_method = "8ACDD5B1DFCA92CFCF5AA89C8B8FEB51")
    private void checkClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IllegalStateException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.697 -0400", hash_original_method = "36E7BDE51D05E7575D4F9253BA0F7A7F", hash_generated_method = "8E8141A7A6ADE06A3C649EE1D92EB10C")
    private void checkNull(Pattern pattern) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
        //if (pattern == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.697 -0400", hash_original_method = "EB8AF45030CFA93895E22043F16AA91D", hash_generated_method = "C8E294A6DF7F374A608BE9B64F7466BB")
    private void resetMatcher() {
        {
            matcher = delimiter.matcher(buffer);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.697 -0400", hash_original_method = "8767C8E3B92497CDD5E1C8E3E9AF12A5", hash_generated_method = "246DF741A54CA564E3597B59F5BC86C1")
    private void saveCurrentStatus() {
        preStartIndex = findStartIndex;
        // ---------- Original Method ----------
        //preStartIndex = findStartIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.698 -0400", hash_original_method = "C4EDF4CCA1B99C808834619656C45D45", hash_generated_method = "25DC76BF381C9B535A67870FCCE6C2E3")
    private void recoverPreviousStatus() {
        findStartIndex = preStartIndex;
        // ---------- Original Method ----------
        //findStartIndex = preStartIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.698 -0400", hash_original_method = "B97F3D0429BBD1DC99EF41C42DDF373F", hash_generated_method = "7C754399D93D60F0AFD55954521823D8")
    private Pattern getIntegerPattern(int radix) {
        Pattern varB4EAC82CA7396A68D541C85D26508E83_2021775802 = null; //Variable for return #1
        checkRadix(radix);
        decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
        String allAvailableDigits;
        allAvailableDigits = "0123456789abcdefghijklmnopqrstuvwxyz";
        String ASCIIDigit;
        ASCIIDigit = allAvailableDigits.substring(0, radix);
        String nonZeroASCIIDigit;
        nonZeroASCIIDigit = allAvailableDigits.substring(1, radix);
        StringBuilder digit;
        digit = new StringBuilder("((?i)[").append(ASCIIDigit)
                .append("]|\\p{javaDigit})");
        StringBuilder nonZeroDigit;
        nonZeroDigit = new StringBuilder("((?i)[").append(
                nonZeroASCIIDigit).append("]|([\\p{javaDigit}&&[^0]]))");
        StringBuilder numeral;
        numeral = getNumeral(digit, nonZeroDigit);
        StringBuilder integer;
        integer = new StringBuilder("(([-+]?(").append(numeral)
                .append(")))|(").append(addPositiveSign(numeral)).append(")|(")
                .append(addNegativeSign(numeral)).append(")");
        Pattern integerPattern;
        integerPattern = Pattern.compile(integer.toString());
        varB4EAC82CA7396A68D541C85D26508E83_2021775802 = integerPattern;
        addTaint(radix);
        varB4EAC82CA7396A68D541C85D26508E83_2021775802.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021775802;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.712 -0400", hash_original_method = "C0E115C785C5444E26611E86ADCD9532", hash_generated_method = "4C6A8E5807900EAA8A600714B39843DB")
    private Pattern getFloatPattern() {
        Pattern varB4EAC82CA7396A68D541C85D26508E83_983698081 = null; //Variable for return #1
        decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
        StringBuilder digit;
        digit = new StringBuilder("([0-9]|(\\p{javaDigit}))");
        StringBuilder nonZeroDigit;
        nonZeroDigit = new StringBuilder("[\\p{javaDigit}&&[^0]]");
        StringBuilder numeral;
        numeral = getNumeral(digit, nonZeroDigit);
        String decimalSeparator;
        decimalSeparator = "\\" + decimalFormat.getDecimalFormatSymbols()
                        .getDecimalSeparator();
        StringBuilder decimalNumeral;
        decimalNumeral = new StringBuilder("(").append(numeral)
                .append("|").append(numeral)
                .append(decimalSeparator).append(digit).append("*+|").append(
                        decimalSeparator).append(digit).append("++)");
        StringBuilder exponent;
        exponent = new StringBuilder("([eE][+-]?").append(digit)
                .append("+)?");
        StringBuilder decimal;
        decimal = new StringBuilder("(([-+]?").append(
                decimalNumeral).append("(").append(exponent).append("?)")
                .append(")|(").append(addPositiveSign(decimalNumeral)).append(
                        "(").append(exponent).append("?)").append(")|(")
                .append(addNegativeSign(decimalNumeral)).append("(").append(
                        exponent).append("?)").append("))");
        StringBuilder hexFloat;
        hexFloat = new StringBuilder("([-+]?0[xX][0-9a-fA-F]*")
                .append("\\.").append(
                        "[0-9a-fA-F]+([pP][-+]?[0-9]+)?)");
        String localNaN;
        localNaN = decimalFormat.getDecimalFormatSymbols().getNaN();
        String localeInfinity;
        localeInfinity = decimalFormat.getDecimalFormatSymbols()
                .getInfinity();
        StringBuilder nonNumber;
        nonNumber = new StringBuilder("(NaN|\\Q").append(localNaN)
                .append("\\E|Infinity|\\Q").append(localeInfinity).append("\\E)");
        StringBuilder singedNonNumber;
        singedNonNumber = new StringBuilder("((([-+]?(").append(
                nonNumber).append(")))|(").append(addPositiveSign(nonNumber))
                .append(")|(").append(addNegativeSign(nonNumber)).append("))");
        StringBuilder floatString;
        floatString = new StringBuilder().append(decimal).append(
                "|").append(hexFloat).append("|").append(singedNonNumber);
        Pattern floatPattern;
        floatPattern = Pattern.compile(floatString.toString());
        varB4EAC82CA7396A68D541C85D26508E83_983698081 = floatPattern;
        varB4EAC82CA7396A68D541C85D26508E83_983698081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_983698081;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.713 -0400", hash_original_method = "F633057156584A1CC211DF943CEE8B2E", hash_generated_method = "8BF73E599DF56DBB640F6AAC0F15009C")
    private StringBuilder getNumeral(StringBuilder digit,
            StringBuilder nonZeroDigit) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_152371086 = null; //Variable for return #1
        String groupSeparator;
        groupSeparator = "\\"
                + decimalFormat.getDecimalFormatSymbols()
                        .getGroupingSeparator();
        StringBuilder groupedNumeral;
        groupedNumeral = new StringBuilder("(").append(
                nonZeroDigit).append(digit).append("?").append(digit).append(
                "?(").append(groupSeparator).append(digit).append(digit)
                .append(digit).append(")+)");
        StringBuilder numeral;
        numeral = new StringBuilder("((").append(digit).append(
                "++)|").append(groupedNumeral).append(")");
        varB4EAC82CA7396A68D541C85D26508E83_152371086 = numeral;
        addTaint(digit.getTaint());
        addTaint(nonZeroDigit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_152371086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_152371086;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.713 -0400", hash_original_method = "F4802B299CEDF4B393BE453F4FA35C1C", hash_generated_method = "550D4214F9AD33529FAD0BB8BDC607F5")
    private StringBuilder addPositiveSign(StringBuilder unSignNumeral) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1783377140 = null; //Variable for return #1
        String positivePrefix;
        positivePrefix = "";
        String positiveSuffix;
        positiveSuffix = "";
        {
            boolean var4304F9C31E51F5B59DA62CC88BD98357_510393487 = (!decimalFormat.getPositivePrefix().isEmpty());
            {
                positivePrefix = "\\Q" + decimalFormat.getPositivePrefix() + "\\E";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1F31A2922CB5B3C62934063F51155AD0_90359080 = (!decimalFormat.getPositiveSuffix().isEmpty());
            {
                positiveSuffix = "\\Q" + decimalFormat.getPositiveSuffix() + "\\E";
            } //End block
        } //End collapsed parenthetic
        StringBuilder signedNumeral;
        signedNumeral = new StringBuilder()
                .append(positivePrefix).append(unSignNumeral).append(
                        positiveSuffix);
        varB4EAC82CA7396A68D541C85D26508E83_1783377140 = signedNumeral;
        addTaint(unSignNumeral.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1783377140.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783377140;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.728 -0400", hash_original_method = "52EA29890EB11047B6BC838B1D351A19", hash_generated_method = "6E369CDC6369F33A0CAFDA7474B16290")
    private StringBuilder addNegativeSign(StringBuilder unSignNumeral) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1605490459 = null; //Variable for return #1
        String negativePrefix;
        negativePrefix = "";
        String negativeSuffix;
        negativeSuffix = "";
        {
            boolean varC25B830A27B679D3982DD365B8188AE6_1777675178 = (!decimalFormat.getNegativePrefix().isEmpty());
            {
                negativePrefix = "\\Q" + decimalFormat.getNegativePrefix() + "\\E";
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBB6526D9DA02554F57D70167CDC32801_908812261 = (!decimalFormat.getNegativeSuffix().isEmpty());
            {
                negativeSuffix = "\\Q" + decimalFormat.getNegativeSuffix() + "\\E";
            } //End block
        } //End collapsed parenthetic
        StringBuilder signedNumeral;
        signedNumeral = new StringBuilder()
                .append(negativePrefix).append(unSignNumeral).append(
                        negativeSuffix);
        varB4EAC82CA7396A68D541C85D26508E83_1605490459 = signedNumeral;
        addTaint(unSignNumeral.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1605490459.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1605490459;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.729 -0400", hash_original_method = "E9627567024197FCA7EA352F1F4FD73F", hash_generated_method = "68713EE4C46EED7A6C6D345F519C9BA6")
    private String removeLocaleInfoFromFloat(String floatString) {
        String varB4EAC82CA7396A68D541C85D26508E83_12627008 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1901483337 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1473951404 = null; //Variable for return #3
        {
            boolean var10B2B3B995EAFF7C65FE3FD287EB6EF2_701118386 = (-1 != floatString.indexOf('x') || -1 != floatString.indexOf('X'));
            {
                varB4EAC82CA7396A68D541C85D26508E83_12627008 = floatString;
            } //End block
        } //End collapsed parenthetic
        int exponentIndex;
        String decimalNumeralString;
        String exponentString;
        {
            boolean var1A3B1B05B807F83ACB6CCDB2576A92C7_1423652496 = (-1 != (exponentIndex = floatString.indexOf('e'))
                || -1 != (exponentIndex = floatString.indexOf('E')));
            {
                decimalNumeralString = floatString.substring(0, exponentIndex);
                exponentString = floatString.substring(exponentIndex + 1,
                    floatString.length());
                decimalNumeralString = removeLocaleInfo(decimalNumeralString,
                    DataType.FLOAT);
                varB4EAC82CA7396A68D541C85D26508E83_1901483337 = decimalNumeralString + "e" + exponentString;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1473951404 = removeLocaleInfo(floatString, DataType.FLOAT);
        addTaint(floatString.getTaint());
        String varA7E53CE21691AB073D9660D615818899_694067187; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_694067187 = varB4EAC82CA7396A68D541C85D26508E83_12627008;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_694067187 = varB4EAC82CA7396A68D541C85D26508E83_1901483337;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_694067187 = varB4EAC82CA7396A68D541C85D26508E83_1473951404;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_694067187.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_694067187;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.738 -0400", hash_original_method = "E0679D6E03D5A7C0D246B9231F9BA005", hash_generated_method = "2C2B7089A428507121FFEDF2227D9704")
    private String removeLocaleInfo(String token, DataType type) {
        String varB4EAC82CA7396A68D541C85D26508E83_1955361480 = null; //Variable for return #1
        StringBuilder tokenBuilder;
        tokenBuilder = new StringBuilder(token);
        boolean negative;
        negative = removeLocaleSign(tokenBuilder);
        String groupSeparator;
        groupSeparator = String.valueOf(decimalFormat
                .getDecimalFormatSymbols().getGroupingSeparator());
        int separatorIndex;
        separatorIndex = -1;
        {
            boolean var9B27B3BDB9346CF6B421F4E796FDC089_631882423 = (-1 != (separatorIndex = tokenBuilder.indexOf(groupSeparator)));
            {
                tokenBuilder.delete(separatorIndex, separatorIndex + 1);
            } //End block
        } //End collapsed parenthetic
        String decimalSeparator;
        decimalSeparator = String.valueOf(decimalFormat
                .getDecimalFormatSymbols().getDecimalSeparator());
        separatorIndex = tokenBuilder.indexOf(decimalSeparator);
        StringBuilder result;
        result = new StringBuilder("");
        {
            {
                int i;
                i = 0;
                boolean varA59FCE7DE0ADC798AEC877C6BDF670FE_1360621019 = (i < tokenBuilder.length());
                {
                    {
                        boolean var08E6A5C2AB5D0570FADC944298681492_656041904 = (-1 != Character.digit(tokenBuilder.charAt(i),
                        Character.MAX_RADIX));
                        {
                            result.append(tokenBuilder.charAt(i));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varDD72E23368B7C6A0CCB73084198ED4EB_1743927895 = (tokenBuilder.toString().equals(
                    decimalFormat.getDecimalFormatSymbols().getNaN()));
                {
                    result.append("NaN");
                } //End block
                {
                    boolean var5468459D35597DADB7ADFD71EF1FBD65_1594796455 = (tokenBuilder.toString().equals(
                    decimalFormat.getDecimalFormatSymbols().getInfinity()));
                    {
                        result.append("Infinity");
                    } //End block
                    {
                        {
                            int i;
                            i = 0;
                            boolean var7E45BA1B7115BEACC403AB7F7D7EA7FD_1742143641 = (i < tokenBuilder.length());
                            {
                                {
                                    boolean var16E05919C92FE54AB8B927D033FE7DDF_1650592003 = (-1 != Character.digit(tokenBuilder.charAt(i), 10));
                                    {
                                        result.append(Character.digit(tokenBuilder.charAt(i),
                                10));
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            boolean varD75AC17579D20414FAFCF16B807A8833_916880365 = (result.length() == 0);
            {
                result = tokenBuilder;
            } //End block
        } //End collapsed parenthetic
        {
            result.insert(separatorIndex, ".");
        } //End block
        {
            result.insert(0, '-');
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1955361480 = result.toString();
        addTaint(token.getTaint());
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1955361480.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1955361480;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.827 -0400", hash_original_method = "78E2FFE43DDA019FB87A76C655422357", hash_generated_method = "717EC89C9E6B74EDFFDD5A92B6B5D235")
    private boolean removeLocaleSign(StringBuilder tokenBuilder) {
        String positivePrefix;
        positivePrefix = decimalFormat.getPositivePrefix();
        String positiveSuffix;
        positiveSuffix = decimalFormat.getPositiveSuffix();
        String negativePrefix;
        negativePrefix = decimalFormat.getNegativePrefix();
        String negativeSuffix;
        negativeSuffix = decimalFormat.getNegativeSuffix();
        {
            boolean var24B2F24D38297CA61632ABFD4CDC883A_512306188 = (tokenBuilder.indexOf("+") == 0);
            {
                tokenBuilder.delete(0, 1);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var57D97E4C45A6012BA5D7FFA5537C5753_494063882 = (!positivePrefix.isEmpty() && tokenBuilder.indexOf(positivePrefix) == 0);
            {
                tokenBuilder.delete(0, positivePrefix.length());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE5F786CDE5CE5A5C6B3CD62606AE0D1F_730853056 = (!positiveSuffix.isEmpty()
                && -1 != tokenBuilder.indexOf(positiveSuffix));
            {
                tokenBuilder.delete(
                    tokenBuilder.length() - positiveSuffix.length(),
                    tokenBuilder.length());
            } //End block
        } //End collapsed parenthetic
        boolean negative;
        negative = false;
        {
            boolean var00ADBAA5FB443A5A1A3FD672CA5AA29F_1105798127 = (tokenBuilder.indexOf("-") == 0);
            {
                tokenBuilder.delete(0, 1);
                negative = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var68E0CAAD324E2A2F3C0DD60982BEFEFA_1191312660 = (!negativePrefix.isEmpty() && tokenBuilder.indexOf(negativePrefix) == 0);
            {
                tokenBuilder.delete(0, negativePrefix.length());
                negative = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8A69CC51128D7719195057B3933E2DD3_546474722 = (!negativeSuffix.isEmpty()
                && -1 != tokenBuilder.indexOf(negativeSuffix));
            {
                tokenBuilder.delete(
                    tokenBuilder.length() - negativeSuffix.length(),
                    tokenBuilder.length());
                negative = true;
            } //End block
        } //End collapsed parenthetic
        addTaint(tokenBuilder.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235426250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235426250;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.828 -0400", hash_original_method = "F9C3F510E83B834D3EF4AA01E6CFE4F9", hash_generated_method = "B6E43C5F46EA60EF2F92EDF0826261FB")
    private boolean setTokenRegion() {
        int tokenStartIndex;
        tokenStartIndex = 0;
        int tokenEndIndex;
        tokenEndIndex = 0;
        matcher.usePattern(delimiter);
        matcher.region(findStartIndex, bufferLength);
        tokenStartIndex = findPreDelimiter();
        {
            boolean varF791467377247DF76FEA6FA79AD0E28C_1064892968 = (setHeadTokenRegion(tokenStartIndex));
        } //End collapsed parenthetic
        tokenEndIndex = findPostDelimiter();
        {
            tokenEndIndex = bufferLength;
            findStartIndex = bufferLength;
        } //End block
        matcher.region(tokenStartIndex, tokenEndIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412155522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412155522;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.828 -0400", hash_original_method = "C22FCAE783E3B780837C6EC57B7427D4", hash_generated_method = "E15A4A73EB00E49DF0EBC62CE21B9744")
    private int findPreDelimiter() {
        int tokenStartIndex;
        boolean findComplete;
        findComplete = false;
        {
            {
                boolean varC81C93FFC3EB18993C4322F990495240_102415453 = (matcher.find());
                {
                    findComplete = true;
                    {
                        boolean varF8076FAFFB22D0515BE308DC240465E1_1392700872 = (matcher.start() == findStartIndex
                        && matcher.end() == bufferLength);
                        {
                            {
                                readMore();
                                resetMatcher();
                                findComplete = false;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        readMore();
                        resetMatcher();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        tokenStartIndex = matcher.end();
        findStartIndex = matcher.end();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375604726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375604726;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.829 -0400", hash_original_method = "CDCEB3053237613D9179B8FF1482F233", hash_generated_method = "E5CC3A1F9B2914F231CCAB6075547B87")
    private boolean setHeadTokenRegion(int findIndex) {
        int tokenStartIndex;
        int tokenEndIndex;
        boolean setSuccess;
        setSuccess = false;
        {
            tokenStartIndex = preStartIndex;
            tokenEndIndex = bufferLength;
            findStartIndex = bufferLength;
            matcher.region(tokenStartIndex, tokenEndIndex);
            setSuccess = true;
        } //End block
        {
            boolean var20EC7C25DF9DDF9DF301AAF63A11870B_325365545 = (-1 != findIndex && preStartIndex != matcher.start());
            {
                tokenStartIndex = preStartIndex;
                tokenEndIndex = matcher.start();
                findStartIndex = matcher.start();
                matcher.region(tokenStartIndex, tokenEndIndex);
                setSuccess = true;
            } //End block
        } //End collapsed parenthetic
        addTaint(findIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776591573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776591573;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.830 -0400", hash_original_method = "2DA8EAAAB20ACFBF7221E1B39889C369", hash_generated_method = "E33D04838AE4E4B1A6D6CC44C6611009")
    private int findPostDelimiter() {
        int tokenEndIndex;
        tokenEndIndex = 0;
        boolean findComplete;
        findComplete = false;
        {
            {
                boolean varC81C93FFC3EB18993C4322F990495240_1534991883 = (matcher.find());
                {
                    findComplete = true;
                    {
                        boolean varB8737C108B8698B3F9F5020C98DCE407_2024094737 = (matcher.start() == findStartIndex
                        && matcher.start() == matcher.end());
                        {
                            findComplete = false;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        readMore();
                        resetMatcher();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        tokenEndIndex = matcher.start();
        findStartIndex = matcher.start();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619355753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619355753;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.830 -0400", hash_original_method = "71E256A499C0BF5FC1327A59408A7116", hash_generated_method = "C88BC4C07C4B434A6339F61E54B0CC53")
    private void readMore() {
        int oldPosition;
        oldPosition = buffer.position();
        int oldBufferLength;
        oldBufferLength = bufferLength;
        {
            boolean var5B6D85EEB96F956BC35EDF03EEA1F9F0_590152230 = (bufferLength >= buffer.capacity());
            {
                expandBuffer();
            } //End block
        } //End collapsed parenthetic
        int readCount;
        readCount = 0;
        try 
        {
            buffer.limit(buffer.capacity());
            buffer.position(oldBufferLength);
            {
                boolean var20BB5F5A9D4C646BCCB60979B8801366_1958156582 = ((readCount = input.read(buffer)) == 0);
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            bufferLength = buffer.position();
            readCount = -1;
            lastIOException = e;
        } //End block
        buffer.flip();
        buffer.position(oldPosition);
        {
            inputExhausted = true;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.832 -0400", hash_original_method = "333CE5605A5055092BA8AAF7729359CC", hash_generated_method = "AF6B7F6E5E5129298E8B1B5F1654CAC2")
    private void expandBuffer() {
        int oldPosition;
        oldPosition = buffer.position();
        int oldCapacity;
        oldCapacity = buffer.capacity();
        int oldLimit;
        oldLimit = buffer.limit();
        int newCapacity;
        newCapacity = oldCapacity * DIPLOID;
        char[] newBuffer;
        newBuffer = new char[newCapacity];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.832 -0400", hash_original_method = "6E6895DF0C38F7FD4A1856B0BE65A90D", hash_generated_method = "F1A65B34E0FE91A208B81E22440C5635")
    public Scanner reset() {
        Scanner varB4EAC82CA7396A68D541C85D26508E83_2047326446 = null; //Variable for return #1
        delimiter = DEFAULT_DELIMITER;
        locale = Locale.getDefault();
        integerRadix = 10;
        varB4EAC82CA7396A68D541C85D26508E83_2047326446 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2047326446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047326446;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.832 -0400", hash_original_field = "BC972EB0D22A6A007EA49964499CB869", hash_generated_field = "92095DDBD899D2B359B807EB41C39B06")

    private static Pattern DEFAULT_DELIMITER = Pattern
            .compile("\\p{javaWhitespace}+");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "51B36C22E2A7867914CF920A2F4D5E26", hash_generated_field = "B13D924D5BD4F6E72C61588510F2DAD2")

    private static Pattern BOOLEAN_PATTERN = Pattern.compile(
            "true|false", Pattern.CASE_INSENSITIVE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "54CA59FF6F5876977BA085227CBE9E03", hash_generated_field = "34D957310674ACDBDEF2BA84C8EFAF52")

    private static Pattern LINE_TERMINATOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "C5F111F5DE06ACB0CA2CF2B54D5B52E6", hash_generated_field = "6C40428A55C17D2895C0B094BEB1F611")

    private static Pattern MULTI_LINE_TERMINATOR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "AA77B9850811932532F09996BDC43803", hash_generated_field = "3C4C83BD4BB2A832CA90E27F9C78BAE2")

    private static Pattern LINE_PATTERN;
    static {
        String NL = "\n|\r\n|\r|\u0085|\u2028|\u2029";
        LINE_TERMINATOR = Pattern.compile(NL);
        MULTI_LINE_TERMINATOR = Pattern.compile("(" + NL + ")+");
        LINE_PATTERN = Pattern.compile(".*(" + NL + ")|.+(" + NL + ")?");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "AE2E9958C069FE6F38E5DC9ADAB45571", hash_generated_field = "C983EBB4EBAC7A1EBC581724E30E9E89")

    private static Pattern ANY_PATTERN = Pattern.compile("(?s).*");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "6DCC85CA6D691683EE954E4E0F50E8C6", hash_generated_field = "3B6E87C9ECEDEDBC2A465933A1B55AEB")

    private static int DIPLOID = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "F5158802C5AD653FFB1072819F8D7B16", hash_generated_field = "EF7D2A1E43E5ADCC3BC879E2CAC51DB9")

    private static int DEFAULT_RADIX = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.842 -0400", hash_original_field = "3D936557EB560A417CDF2BC916B4B530", hash_generated_field = "F19208961301E1E8B319283F2F9FC1DC")

    private static int DEFAULT_TRUNK_SIZE = 1024;
}

