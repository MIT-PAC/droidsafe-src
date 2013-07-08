package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.nio.charset.Charset;
import libcore.icu.LocaleData;
import libcore.icu.NativeDecimalFormat;
import libcore.io.IoUtils;

public final class Formatter implements Closeable, Flushable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.454 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "3DC9338DC786F95D1A95A8961D85A2A6")

    private Appendable out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.454 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.454 -0400", hash_original_field = "61DD86C2DC75C3F569EC619BD283A33F", hash_generated_field = "613B0CE96D5332BFAF1329D4F111938C")

    private Object arg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.454 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.454 -0400", hash_original_field = "B7B849C43DF0AE6D73905E0D7DFFBD21", hash_generated_field = "FB61E2282DE2F9A3C415CEE063007787")

    private FormatToken formatToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.454 -0400", hash_original_field = "460DFB1105EAD6E581494BC8EB7172AC", hash_generated_field = "94160D1F6EC5CF5867F2CCE7946E9FCB")

    private IOException lastIOException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.454 -0400", hash_original_field = "E3E7EE28E6489646D907CCB03E05DAAD", hash_generated_field = "C9E2992A298A3ADEBF6945150F771649")

    private LocaleData localeData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.455 -0400", hash_original_method = "776A8092D7EB6A8CE9FA3707C90FDC71", hash_generated_method = "84D520F5378D0961C20054F1B6C8CEC3")
    public  Formatter() {
        this(new StringBuilder(), Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.455 -0400", hash_original_method = "C10A7E7C6014F1D5457B2868B8DDD5FA", hash_generated_method = "31E6013FD29F4E00375F2E0819EFEC43")
    public  Formatter(Appendable a) {
        this(a, Locale.getDefault());
        addTaint(a.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.455 -0400", hash_original_method = "949ED46E62E9C1FD97345CAB1F572157", hash_generated_method = "1F77DEC42C276C4F532BB809AEBFC555")
    public  Formatter(Locale l) {
        this(new StringBuilder(), l);
        addTaint(l.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.456 -0400", hash_original_method = "731A0E308D6775F1250BD9086CA3748C", hash_generated_method = "76EB4A86010C765538F0CD5F267904FB")
    public  Formatter(Appendable a, Locale l) {
        {
            out = new StringBuilder();
        } 
        {
            out = a;
        } 
        locale = l;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.456 -0400", hash_original_method = "55110CB3A063CDDA9DDF2A6FEEDBC4D6", hash_generated_method = "70BDD2B3DD755EDDD96C2C4A66B6ADFD")
    public  Formatter(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        addTaint(fileName.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.456 -0400", hash_original_method = "D05AE6CA9B3694824C73C0B398D66198", hash_generated_method = "5E175B6E8111D40A645C215D023FFEEA")
    public  Formatter(String fileName, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new File(fileName), csn);
        addTaint(fileName.getTaint());
        addTaint(csn.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.456 -0400", hash_original_method = "106406A68116E4DC11358A25DB96C9D8", hash_generated_method = "5E89EAE84986EA97D043AD55A3E15F94")
    public  Formatter(String fileName, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn, l);
        addTaint(fileName.getTaint());
        addTaint(csn.getTaint());
        addTaint(l.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.456 -0400", hash_original_method = "56C5088BBC7ACEBB0E3B42C5FC534A61", hash_generated_method = "589E7B2AC2ADE54B3D54DCD41B50441F")
    public  Formatter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.457 -0400", hash_original_method = "15C3BB1BBEBB7DA2B256558B7A83F1D2", hash_generated_method = "F5E9451ABCBDE9893AA26A6A1D7AA59B")
    public  Formatter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(file, csn, Locale.getDefault());
        addTaint(file.getTaint());
        addTaint(csn.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.457 -0400", hash_original_method = "11FC304A866A57AD6707E0AE5ACD74C6", hash_generated_method = "C4EBCD6C3A22AE11D3913AABC4B03DDF")
    public  Formatter(File file, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fout = null;
        try 
        {
            fout = new FileOutputStream(file);
            out = new BufferedWriter(new OutputStreamWriter(fout, csn));
        } 
        catch (RuntimeException e)
        {
            IoUtils.closeQuietly(fout);
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (UnsupportedEncodingException e)
        {
            IoUtils.closeQuietly(fout);
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        locale = l;
        addTaint(file.getTaint());
        
        
        
            
            
        
            
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.458 -0400", hash_original_method = "18094D8509766CE6FC608D9540C5972B", hash_generated_method = "86DB88A0468A92B37477CC3A3583D801")
    public  Formatter(OutputStream os) {
        out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        locale = Locale.getDefault();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.458 -0400", hash_original_method = "F6295FD9F7AB3AB7F721531D402E7F81", hash_generated_method = "84790D15860A1225F92619D8FE2D1847")
    public  Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault());
        addTaint(os.getTaint());
        addTaint(csn.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.459 -0400", hash_original_method = "339D31BAB557832A3B8A75EB377C0635", hash_generated_method = "8BEF5CEA51D6B567DEC1210198AC5CE9")
    public  Formatter(OutputStream os, String csn, Locale l) throws UnsupportedEncodingException {
        out = new BufferedWriter(new OutputStreamWriter(os, csn));
        locale = l;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.459 -0400", hash_original_method = "6A92C9283CC7B01627E24F0E27824A3B", hash_generated_method = "EF9BC443EC2682F3121DB34BBAB1CB88")
    public  Formatter(PrintStream ps) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        out = ps;
        locale = Locale.getDefault();
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.460 -0400", hash_original_method = "9D62CCD9646FE324AC0FFA6EB7C17C6C", hash_generated_method = "36B9F51D2EB79F5C96EC884EF941C013")
    private NativeDecimalFormat getDecimalFormat(String pattern) {
        NativeDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_974334848 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_974334848 = cachedDecimalFormat.get().update(localeData, pattern);
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_974334848.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_974334848;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.460 -0400", hash_original_method = "E3DA6A4C963B6E9187963221C571CEC2", hash_generated_method = "CED13C9417F36F227519AB72CA97A589")
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new FormatterClosedException();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.460 -0400", hash_original_method = "B5A8A4A4A455286143E3BD4E75C6F0FE", hash_generated_method = "0B0C70F343D3C4B73343AF62C57C267C")
    public Locale locale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_979015499 = null; 
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_979015499 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_979015499.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_979015499;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.461 -0400", hash_original_method = "D73A5BF8E95D39CBD6819B9B1AA13C8D", hash_generated_method = "D9B767596FE535D6C36C639E57C51234")
    public Appendable out() {
        Appendable varB4EAC82CA7396A68D541C85D26508E83_1663787066 = null; 
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_1663787066 = out;
        varB4EAC82CA7396A68D541C85D26508E83_1663787066.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1663787066;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.461 -0400", hash_original_method = "39CF8FB3A631311648D12D228411CE26", hash_generated_method = "EF2CE10CDC3BEAB4A7A8039CEAC9EB77")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_206123418 = null; 
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_206123418 = out.toString();
        varB4EAC82CA7396A68D541C85D26508E83_206123418.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_206123418;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.462 -0400", hash_original_method = "E9CBCF5548B5D691C8801114F0C41C59", hash_generated_method = "013B35C8AAE53BF641F7E9D982E1D4C6")
    public void flush() {
        checkNotClosed();
        {
            try 
            {
                ((Flushable) out).flush();
            } 
            catch (IOException e)
            {
                lastIOException = e;
            } 
        } 
        
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.462 -0400", hash_original_method = "16C1939C51EF65BBD0A872F925CE78BF", hash_generated_method = "707CBA92274B8C8AF142983EEBDF49F5")
    public void close() {
        {
            closed = true;
            try 
            {
                {
                    ((Closeable) out).close();
                } 
            } 
            catch (IOException e)
            {
                lastIOException = e;
            } 
        } 
        
        
            
            
                
                    
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.463 -0400", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "FE9F7778773C4A80E9AB8F17A0816318")
    public IOException ioException() {
        IOException varB4EAC82CA7396A68D541C85D26508E83_415583280 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_415583280 = lastIOException;
        varB4EAC82CA7396A68D541C85D26508E83_415583280.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_415583280;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.463 -0400", hash_original_method = "EE9FCF62B0D200225753D8BA586AA3F5", hash_generated_method = "12A888692BBB3C26B359EF0D64261160")
    public Formatter format(String format, Object... args) {
        Formatter varB4EAC82CA7396A68D541C85D26508E83_433516699 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_433516699 = format(this.locale, format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_433516699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_433516699;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.464 -0400", hash_original_method = "F45273151F6DD69ACB6CCC03C59753A4", hash_generated_method = "327F2B535514EA0D3EA9D3FD8BCB97BB")
    public Formatter format(Locale l, String format, Object... args) {
        Formatter varB4EAC82CA7396A68D541C85D26508E83_561427012 = null; 
        Locale originalLocale = locale;
        try 
        {
            this.locale = (l == null ? Locale.US : l);
            this.localeData = LocaleData.get(locale);
            doFormat(format, args);
        } 
        finally 
        {
            this.locale = originalLocale;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_561427012 = this;
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_561427012.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_561427012;
        
        
        
            
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.464 -0400", hash_original_method = "960E24FB807777DEBBE8328729AF6A3F", hash_generated_method = "1DACEA3AC4026A9F2A3E638C7827CF94")
    private void doFormat(String format, Object... args) {
        checkNotClosed();
        FormatSpecifierParser fsp = new FormatSpecifierParser(format);
        int currentObjectIndex = 0;
        Object lastArgument = null;
        boolean hasLastArgumentSet = false;
        int length = format.length();
        int i = 0;
        {
            int plainTextStart = i;
            int nextPercent = format.indexOf('%', i);
            int plainTextEnd;
            plainTextEnd = length;
            plainTextEnd = nextPercent;
            {
                outputCharSequence(format, plainTextStart, plainTextEnd);
            } 
            i = plainTextEnd;
            {
                FormatToken token = fsp.parseFormatToken(i + 1);
                Object argument = null;
                {
                    boolean var15437F24151F4B9BB4CF0F9304E51BA9_1814085029 = (token.requireArgument());
                    {
                        int index;
                        boolean varE3D8046091E4D6BBC992AF3D15742E1E_965090736 = (token.getArgIndex() == FormatToken.UNSET);
                        index = currentObjectIndex++;
                        index = token.getArgIndex();
                        argument = getArgument(args, index, fsp, lastArgument, hasLastArgumentSet);
                        lastArgument = argument;
                        hasLastArgumentSet = true;
                    } 
                } 
                CharSequence substitution = transform(token, argument);
                {
                    outputCharSequence(substitution, 0, substitution.length());
                } 
                i = fsp.i;
            } 
        } 
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.465 -0400", hash_original_method = "4A93F3F0DF6F4E45CC93AF5660722832", hash_generated_method = "7B8F10843DEF23B6000374A8576830D5")
    private void outputCharSequence(CharSequence cs, int start, int end) {
        try 
        {
            out.append(cs, start, end);
        } 
        catch (IOException e)
        {
            lastIOException = e;
        } 
        addTaint(cs.getTaint());
        addTaint(start);
        addTaint(end);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.466 -0400", hash_original_method = "4EF20CF84298D39EE17983F53878C341", hash_generated_method = "1D6D0A24BEF81117EDE80E073FE7E74D")
    private Object getArgument(Object[] args, int index, FormatSpecifierParser fsp,
            Object lastArgument, boolean hasLastArgumentSet) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1442375819 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_273556493 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1031092368 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException("<");
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1442375819 = null;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException(fsp.getFormatSpecifierText());
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_273556493 = lastArgument;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1031092368 = args[index];
        addTaint(args[0].getTaint());
        addTaint(index);
        addTaint(fsp.getTaint());
        addTaint(lastArgument.getTaint());
        addTaint(hasLastArgumentSet);
        Object varA7E53CE21691AB073D9660D615818899_884761412; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_884761412 = varB4EAC82CA7396A68D541C85D26508E83_1442375819;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_884761412 = varB4EAC82CA7396A68D541C85D26508E83_273556493;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_884761412 = varB4EAC82CA7396A68D541C85D26508E83_1031092368;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_884761412.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_884761412;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.467 -0400", hash_original_method = "0237F1DF7BD7A386A4F4D1B44D43876F", hash_generated_method = "DD0B677158D8C0DADA6B82C008448D6D")
    private CharSequence transform(FormatToken token, Object argument) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1483750011 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_189821583 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_292579752 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1367596026 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1829302 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1861106991 = null; 
        this.formatToken = token;
        this.arg = argument;
        {
            boolean var774D16194421B6759CE7C28102870BC1_1828674862 = (token.isDefault());
            {
                {
                    Object var3AF4190693AD8752FD689B6D6C2F4FD0_853314315 = (token.getConversionType());
                    
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1483750011 = "null";
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_189821583 = arg.toString();
                    } 
                    
                    
                    boolean needLocalizedDigits = (localeData.zeroDigit != '0');
                    
                    
                    {
                        {
                            IntegralToString.appendInt((StringBuilder) out, ((Number) arg).intValue());
                            varB4EAC82CA7396A68D541C85D26508E83_292579752 = null;
                        } 
                        {
                            IntegralToString.appendLong((StringBuilder) out, ((Long) arg).longValue());
                            varB4EAC82CA7396A68D541C85D26508E83_1367596026 = null;
                        } 
                    } 
                    
                    
                    {
                        String result = arg.toString();
                        varB4EAC82CA7396A68D541C85D26508E83_1829302 = needLocalizedDigits ? localizeDigits(result) : result;
                    } 
                    
                } 
            } 
        } 
        formatToken.checkFlags(arg);
        CharSequence result;
        {
            Object var1A1A65DF413B75C3108F1920C1E23A5B_1252761735 = (token.getConversionType());
            
            result = transformFromBoolean();
            
            
            result = transformFromHashCode();
            
            
            result = transformFromString();
            
            
            result = transformFromCharacter();
            
            
            {
                result = transformFromBigInteger();
            } 
            {
                result = transformFromInteger();
            } 
            
            
            result = transformFromFloat();
            
            
            result = transformFromPercent();
            
            
            result = System.lineSeparator();
            
            
            result = transformFromDateTime();
            
            
            if (DroidSafeAndroidRuntime.control) throw token.unknownFormatConversionException();
            
        } 
        {
            boolean var1DB4C6B053C2BBEFBDA3D42D86D066E6_1043637044 = (Character.isUpperCase(token.getConversionType()));
            {
                {
                    result = result.toString().toUpperCase(locale);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1861106991 = result;
        CharSequence varA7E53CE21691AB073D9660D615818899_922858843; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_922858843 = varB4EAC82CA7396A68D541C85D26508E83_1483750011;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_922858843 = varB4EAC82CA7396A68D541C85D26508E83_189821583;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_922858843 = varB4EAC82CA7396A68D541C85D26508E83_292579752;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_922858843 = varB4EAC82CA7396A68D541C85D26508E83_1367596026;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_922858843 = varB4EAC82CA7396A68D541C85D26508E83_1829302;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_922858843 = varB4EAC82CA7396A68D541C85D26508E83_1861106991;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_922858843.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_922858843;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.468 -0400", hash_original_method = "D44F27ADB431306CEB9F9E1F25036901", hash_generated_method = "124E61E1871259646BE10006ACCFBD1F")
    private IllegalFormatConversionException badArgumentType() {
    	throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.470 -0400", hash_original_method = "8CD3AC57424B332A3611698407D98FD3", hash_generated_method = "B13F82BE70369C28DA6F4E0E2B8A3DC5")
    private CharSequence localizeDigits(CharSequence s) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1204103392 = null; 
        int length = s.length();
        int offsetToLocalizedDigits = localeData.zeroDigit - '0';
        StringBuilder result = new StringBuilder(length);
        {
            int i = 0;
            {
                char ch = s.charAt(i);
                {
                    ch += offsetToLocalizedDigits;
                } 
                result.append(ch);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1204103392 = result;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1204103392.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1204103392;
        
        
        
        
        
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.472 -0400", hash_original_method = "CC3FF2DA7072A05A8664F97319F6C752", hash_generated_method = "97DE205B34A4086A83430C3A8A98B2C9")
    private CharSequence insertGrouping(CharSequence s) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_115726254 = null; 
        StringBuilder result = new StringBuilder(s.length() + s.length()/3);
        int digitsLength = s.length();
        int i = 0;
        {
            boolean var9A0E6F317753A236C52C55D585498BB1_1062612663 = (s.charAt(0) == '-');
            {
                result.append('-');
            } 
        } 
        int headLength = digitsLength % 3;
        {
            headLength = 3;
        } 
        result.append(s, i, i + headLength);
        i += headLength;
        {
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_145754899 = (i < s.length());
            i += 3;
            {
                result.append(localeData.groupingSeparator);
                result.append(s, i, i + 3);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_115726254 = result;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_115726254.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_115726254;
        
        
        
        
        
            
            
            
        
        
        
            
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.473 -0400", hash_original_method = "54F34C95EDCEEE411BD250D07A12E500", hash_generated_method = "9494DACBEA31AC1B0A514C739032ECF3")
    private CharSequence transformFromBoolean() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1612041335 = null; 
        CharSequence result;
        {
            result = arg.toString();
        } 
        {
            result = "false";
        } 
        {
            result = "true";
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1612041335 = padding(result, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1612041335.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1612041335;
        
        
        
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.474 -0400", hash_original_method = "FEE63D21FF5AA7B8F21641D7D3CB6697", hash_generated_method = "54C726824C375585E1E1CC904DA3C8C2")
    private CharSequence transformFromHashCode() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2063614874 = null; 
        CharSequence result;
        {
            result = "null";
        } 
        {
            result = Integer.toHexString(arg.hashCode());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2063614874 = padding(result, 0);
        varB4EAC82CA7396A68D541C85D26508E83_2063614874.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2063614874;
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.474 -0400", hash_original_method = "41FDF272148D1D909A3CC241D4F2B404", hash_generated_method = "94F58C07E110088B203B7FE4F12632F2")
    private CharSequence transformFromString() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_621775533 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_655649533 = null; 
        {
            int flags = 0;
            {
                flags |= FormattableFlags.LEFT_JUSTIFY;
            } 
            {
                flags |= FormattableFlags.ALTERNATE;
            } 
            {
                boolean varE5047B2B0C3ABA50902192D0CF9C9641_1332336743 = (Character.isUpperCase(formatToken.getConversionType()));
                {
                    flags |= FormattableFlags.UPPERCASE;
                } 
            } 
            ((Formattable) arg).formatTo(this, flags, formatToken.getWidth(),
                    formatToken.getPrecision());
            varB4EAC82CA7396A68D541C85D26508E83_621775533 = null;
        } 
        CharSequence result;
        result = arg.toString();
        result = "null";
        varB4EAC82CA7396A68D541C85D26508E83_655649533 = padding(result, 0);
        CharSequence varA7E53CE21691AB073D9660D615818899_444894508; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_444894508 = varB4EAC82CA7396A68D541C85D26508E83_621775533;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_444894508 = varB4EAC82CA7396A68D541C85D26508E83_655649533;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_444894508.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_444894508;
        
        
            
            
                
            
            
                
            
            
                
            
            
                    
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.475 -0400", hash_original_method = "78103310C8550D540C751775D2E73F1B", hash_generated_method = "445544A9A1C0980CD98C89175FACAE31")
    private CharSequence transformFromCharacter() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1117666398 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1794919615 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_642593825 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1117666398 = padding("null", 0);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1794919615 = padding(String.valueOf(arg), 0);
        } 
        {
            int codePoint = ((Number) arg).intValue();
            {
                boolean var6F543C204E9C4F46177946447429AAE1_1064927077 = (!Character.isValidCodePoint(codePoint));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalFormatCodePointException(codePoint);
                } 
            } 
            CharSequence result;
            result = String.valueOf((char) codePoint);
            result = String.valueOf(Character.toChars(codePoint));
            varB4EAC82CA7396A68D541C85D26508E83_642593825 = padding(result, 0);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } 
        CharSequence varA7E53CE21691AB073D9660D615818899_2065180753; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2065180753 = varB4EAC82CA7396A68D541C85D26508E83_1117666398;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2065180753 = varB4EAC82CA7396A68D541C85D26508E83_1794919615;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2065180753 = varB4EAC82CA7396A68D541C85D26508E83_642593825;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2065180753.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2065180753;
        
        
            
        
        
            
        
            
            
                
            
            
                    
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.476 -0400", hash_original_method = "1802F533F155B8AA49557FA5A74B7DBE", hash_generated_method = "317700F183B83D05D8A2E0A9C82283C6")
    private CharSequence transformFromPercent() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1145758714 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1145758714 = padding("%", 0);
        varB4EAC82CA7396A68D541C85D26508E83_1145758714.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1145758714;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.477 -0400", hash_original_method = "EF7726D1BC858C4C5BDC40B9ACBD3ABF", hash_generated_method = "F5F5CE09EB67C73A998A3D029CF87D4E")
    private CharSequence padding(CharSequence source, int startIndex) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_976049528 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1809748041 = null; 
        int start = startIndex;
        int width = formatToken.getWidth();
        int precision = formatToken.getPrecision();
        int length = source.length();
        {
            length = Math.min(length, precision);
            {
                ((StringBuilder) source).setLength(length);
            } 
            {
                source = source.subSequence(0, length);
            } 
        } 
        {
            width = Math.max(source.length(), width);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_976049528 = source;
        } 
        char paddingChar = '\u0020';
        {
            {
                boolean var5580C15E55C4240F2395BB7B30D9E99A_759276796 = (formatToken.getConversionType() == 'd');
                {
                    paddingChar = localeData.zeroDigit;
                } 
                {
                    paddingChar = '0';
                } 
            } 
        } 
        {
            start = 0;
        } 
        char[] paddingChars = new char[width - length];
        Arrays.fill(paddingChars, paddingChar);
        boolean paddingRight = formatToken.flagMinus;
        StringBuilder result = toStringBuilder(source);
        {
            result.append(paddingChars);
        } 
        {
            result.insert(start, paddingChars);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1809748041 = result;
        addTaint(source.getTaint());
        addTaint(startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_14811747; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_14811747 = varB4EAC82CA7396A68D541C85D26508E83_976049528;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_14811747 = varB4EAC82CA7396A68D541C85D26508E83_1809748041;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_14811747.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_14811747;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.478 -0400", hash_original_method = "AA67EEFB247ACC7BDA1BABCD03B30A80", hash_generated_method = "CFA52E19A06913DC4BBFA2CDA8E32109")
    private StringBuilder toStringBuilder(CharSequence cs) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_496164450 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_496164450 = cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_496164450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_496164450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.479 -0400", hash_original_method = "CE1A2CC9741A13D14659E3953A660AC1", hash_generated_method = "2832CFA77236D528FA785011B3C3D5F8")
    private StringBuilder wrapParentheses(StringBuilder result) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_421979646 = null; 
        result.setCharAt(0, '(');
        {
            formatToken.setWidth(formatToken.getWidth() - 1);
            result = (StringBuilder) padding(result, 1);
            result.append(')');
        } 
        {
            result.append(')');
            result = (StringBuilder) padding(result, 0);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_421979646 = result;
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_421979646.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_421979646;
        
        
        
            
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.482 -0400", hash_original_method = "FADDE3D8C4FA639F028B03B661D10023", hash_generated_method = "3EE8A8EAB731DAB2E043E8F56D16047C")
    private CharSequence transformFromInteger() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2018010710 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1268206802 = null; 
        int startIndex = 0;
        StringBuilder result = new StringBuilder();
        char currentConversionType = formatToken.getConversionType();
        long value;
        {
            value = ((Long) arg).longValue();
        } 
        {
            value = ((Integer) arg).longValue();
        } 
        {
            value = ((Short) arg).longValue();
        } 
        {
            value = ((Byte) arg).longValue();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } 
        {
            {
                result.append("0");
                startIndex += 1;
            } 
            {
                result.append("0x");
                startIndex += 2;
            } 
        } 
        {
            CharSequence digits = Long.toString(value);
            {
                digits = insertGrouping(digits);
            } 
            {
                digits = localizeDigits(digits);
            } 
            result.append(digits);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2018010710 = wrapParentheses(result);
                } 
            } 
            {
                {
                    result.insert(0, '+');
                    startIndex += 1;
                } 
                {
                    result.insert(0, ' ');
                    startIndex += 1;
                } 
            } 
        } 
        {
            {
                value &= 0xffL;
            } 
            {
                value &= 0xffffL;
            } 
            {
                value &= 0xffffffffL;
            } 
            {
                result.append(Long.toOctalString(value));
            } 
            {
                result.append(Long.toHexString(value));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1268206802 = padding(result, startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_1221537025; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1221537025 = varB4EAC82CA7396A68D541C85D26508E83_2018010710;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1221537025 = varB4EAC82CA7396A68D541C85D26508E83_1268206802;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1221537025.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1221537025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.483 -0400", hash_original_method = "15D0DEB8422EE33E04C98AFC872D1D51", hash_generated_method = "F77C9B36DF489B6665AC54B17179ECA6")
    private CharSequence transformFromNull() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2040173731 = null; 
        formatToken.flagZero = false;
        varB4EAC82CA7396A68D541C85D26508E83_2040173731 = padding("null", 0);
        varB4EAC82CA7396A68D541C85D26508E83_2040173731.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2040173731;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.485 -0400", hash_original_method = "28740AE89E2FC451EFE3093F54121A6C", hash_generated_method = "3D5428FEAD22CE7C3684FCD6E16663E8")
    private CharSequence transformFromBigInteger() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_474107607 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_15805011 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1818055717 = null; 
        int startIndex = 0;
        StringBuilder result = new StringBuilder();
        BigInteger bigInt = (BigInteger) arg;
        char currentConversionType = formatToken.getConversionType();
        {
            varB4EAC82CA7396A68D541C85D26508E83_474107607 = transformFromNull();
        } 
        boolean isNegative = (bigInt.compareTo(BigInteger.ZERO) < 0);
        {
            CharSequence digits = bigInt.toString(10);
            {
                digits = insertGrouping(digits);
            } 
            result.append(digits);
        } 
        {
            result.append(bigInt.toString(8));
        } 
        {
            result.append(bigInt.toString(16));
        } 
        {
            startIndex = isNegative ? 1 : 0;
            {
                result.insert(startIndex, "0");
                startIndex += 1;
            } 
            {
                result.insert(startIndex, "0x");
                startIndex += 2;
            } 
        } 
        {
            {
                result.insert(0, '+');
                startIndex += 1;
            } 
            {
                result.insert(0, ' ');
                startIndex += 1;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_15805011 = wrapParentheses(result);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1818055717 = padding(result, startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_274572990; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_274572990 = varB4EAC82CA7396A68D541C85D26508E83_474107607;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_274572990 = varB4EAC82CA7396A68D541C85D26508E83_15805011;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_274572990 = varB4EAC82CA7396A68D541C85D26508E83_1818055717;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_274572990.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_274572990;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.486 -0400", hash_original_method = "3FA485DEFE055FA59E9A89B7029B3055", hash_generated_method = "D96E635275F30055693C73CDFC6BEF66")
    private CharSequence transformFromDateTime() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1939971395 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_938207137 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1939971395 = transformFromNull();
        } 
        Calendar calendar;
        {
            calendar = (Calendar) arg;
        } 
        {
            Date date = null;
            {
                date = new Date(((Long) arg).longValue());
            } 
            {
                date = (Date) arg;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw badArgumentType();
            } 
            calendar = Calendar.getInstance(locale);
            calendar.setTime(date);
        } 
        StringBuilder result = new StringBuilder();
        {
            boolean varCAB943A58957944F491BEB3F9C12AAC8_1685927825 = (!appendT(result, formatToken.getDateSuffix(), calendar));
            {
                if (DroidSafeAndroidRuntime.control) throw formatToken.unknownFormatConversionException();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_938207137 = padding(result, 0);
        CharSequence varA7E53CE21691AB073D9660D615818899_157606827; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_157606827 = varB4EAC82CA7396A68D541C85D26508E83_1939971395;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_157606827 = varB4EAC82CA7396A68D541C85D26508E83_938207137;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_157606827.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_157606827;
        
        
            
        
        
        
            
        
            
            
                
            
                
            
                
            
            
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.489 -0400", hash_original_method = "6A85D50A5F6F83B5DE3D767D1CCF3B76", hash_generated_method = "7E510CE184A5D54591A421BD48D93BA7")
    private boolean appendT(StringBuilder result, char conversion, Calendar calendar) {
        
        result.append(localeData.longWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
        
        
        result.append(localeData.shortWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
        
        
        result.append(localeData.longMonthNames[calendar.get(Calendar.MONTH)]);
        
        
        result.append(localeData.shortMonthNames[calendar.get(Calendar.MONTH)]);
        
        
        appendLocalized(result, calendar.get(Calendar.YEAR) / 100, 2);
        
        
        appendT(result, 'm', calendar);
        
        
        result.append('/');
        
        
        appendT(result, 'd', calendar);
        
        
        result.append('/');
        
        
        appendT(result, 'y', calendar);
        
        
        appendT(result, 'Y', calendar);
        
        
        result.append('-');
        
        
        appendT(result, 'm', calendar);
        
        
        result.append('-');
        
        
        appendT(result, 'd', calendar);
        
        
        appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 2);
        
        
        appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 2);
        
        
        appendLocalized(result, calendar.get(Calendar.MILLISECOND), 3);
        
        
        appendLocalized(result, calendar.get(Calendar.MINUTE), 2);
        
        
        appendLocalized(result, calendar.get(Calendar.MILLISECOND) * 1000000L, 9);
        
        
        appendLocalized(result, calendar.getTimeInMillis(), 0);
        
        
        appendT(result, 'H', calendar);
        
        
        result.append(':');
        
        
        appendT(result, 'M', calendar);
        
        
        appendLocalized(result, calendar.get(Calendar.SECOND), 2);
        
        
        appendT(result, 'H', calendar);
        
        
        result.append(':');
        
        
        appendT(result, 'M', calendar);
        
        
        result.append(':');
        
        
        appendT(result, 'S', calendar);
        
        
        appendLocalized(result, calendar.get(Calendar.YEAR), 4);
        
        
        TimeZone timeZone = calendar.getTimeZone();
        
        
        result.append(timeZone.getDisplayName(timeZone.inDaylightTime(calendar.getTime()),
                    TimeZone.SHORT, locale));
        
        
        appendT(result, 'a', calendar);
        
        
        result.append(' ');
        
        
        appendT(result, 'b', calendar);
        
        
        result.append(' ');
        
        
        appendT(result, 'd', calendar);
        
        
        result.append(' ');
        
        
        appendT(result, 'T', calendar);
        
        
        result.append(' ');
        
        
        appendT(result, 'Z', calendar);
        
        
        result.append(' ');
        
        
        appendT(result, 'Y', calendar);
        
        
        appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 2);
        
        
        appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 0);
        
        
        appendLocalized(result, calendar.get(Calendar.DAY_OF_YEAR), 3);
        
        
        appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 0);
        
        
        appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 0);
        
        
        appendLocalized(result, calendar.get(Calendar.MONTH) + 1, 2);
        
        
        result.append(localeData.amPm[calendar.get(Calendar.AM_PM)].toLowerCase(locale));
        
        
        appendT(result, 'I', calendar);
        
        
        result.append(':');
        
        
        appendT(result, 'M', calendar);
        
        
        result.append(':');
        
        
        appendT(result, 'S', calendar);
        
        
        result.append(' ');
        
        
        result.append(localeData.amPm[calendar.get(Calendar.AM_PM)]);
        
        
        appendLocalized(result, calendar.getTimeInMillis() / 1000, 0);
        
        
        appendLocalized(result, calendar.get(Calendar.YEAR) % 100, 2);
        
        
        long offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        
        
        char sign = '+';
        
        
        {
            sign = '-';
            offset = -offset;
        } 
        
        
        result.append(sign);
        
        
        appendLocalized(result, offset / 3600000, 2);
        
        
        appendLocalized(result, (offset % 3600000) / 60000, 2);
        
        addTaint(result.getTaint());
        addTaint(conversion);
        addTaint(calendar.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105090699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105090699;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.490 -0400", hash_original_method = "07C369462F22245026E1280008B34AEC", hash_generated_method = "D5F4D7D234DC76DA2D8ABB6AF0FAFF36")
    private int to12Hour(int hour) {
        addTaint(hour);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1351033965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1351033965;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.493 -0400", hash_original_method = "60B30B4DC0B127EF94D361BC9EB2AF90", hash_generated_method = "55491DA7574C4166F80F88424C099E67")
    private void appendLocalized(StringBuilder result, long value, int width) {
        int paddingIndex = result.length();
        char zeroDigit = localeData.zeroDigit;
        {
            result.append(value);
        } 
        {
            result.append(localizeDigits(Long.toString(value)));
        } 
        int zeroCount = width - (result.length() - paddingIndex);
        {
            result.insert(paddingIndex, ZEROS, 0, zeroCount);
        } 
        {
            {
                int i = 0;
                {
                    result.insert(paddingIndex, zeroDigit);
                } 
            } 
        } 
        addTaint(result.getTaint());
        addTaint(value);
        addTaint(width);
        
        
        
        
            
        
            
        
        
        
            
        
        
            
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.496 -0400", hash_original_method = "977B62B975352D4F075C1101DB18FB73", hash_generated_method = "60EB08D72697DE05B33547E6E9A1BE0D")
    private CharSequence transformFromSpecialNumber(double d) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1978202643 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_493448305 = null; 
        String source = null;
        {
            boolean varF573A637641E1AB21D698815AEB110FB_1430447614 = (Double.isNaN(d));
            {
                source = "NaN";
            } 
            {
                {
                    source = "+Infinity";
                } 
                {
                    source = " Infinity";
                } 
                {
                    source = "Infinity";
                } 
            } 
            {
                {
                    source = "(Infinity)";
                } 
                {
                    source = "-Infinity";
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1978202643 = null;
            } 
        } 
        formatToken.setPrecision(FormatToken.UNSET);
        formatToken.flagZero = false;
        varB4EAC82CA7396A68D541C85D26508E83_493448305 = padding(source, 0);
        addTaint(d);
        CharSequence varA7E53CE21691AB073D9660D615818899_1982867687; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1982867687 = varB4EAC82CA7396A68D541C85D26508E83_1978202643;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1982867687 = varB4EAC82CA7396A68D541C85D26508E83_493448305;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1982867687.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1982867687;
        
        
        
            
        
            
                
            
                
            
                
            
        
            
                
            
                
            
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.498 -0400", hash_original_method = "DECF7ECF8109F764E81E2CF8101BCB0C", hash_generated_method = "447051FBEE8ADC0A5A17B054CA402427")
    private CharSequence transformFromFloat() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_529957315 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_37697486 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_453080784 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1323634986 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_529957315 = transformFromNull();
        } 
        {
            Number number = (Number) arg;
            double d = number.doubleValue();
            {
                varB4EAC82CA7396A68D541C85D26508E83_37697486 = transformFromSpecialNumber(d);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } 
        char conversionType = formatToken.getConversionType();
        {
            boolean var4D48FD270E3C43B43C7CAFA231E3C2A7_377507006 = (conversionType != 'a' && conversionType != 'A' && !formatToken.isPrecisionSet());
            {
                formatToken.setPrecision(FormatToken.DEFAULT_PRECISION);
            } 
        } 
        StringBuilder result = new StringBuilder();
        
        transformA(result);
        
        
        transformE(result);
        
        
        transformF(result);
        
        
        transformG(result);
        
        
        if (DroidSafeAndroidRuntime.control) throw formatToken.unknownFormatConversionException();
        
        formatToken.setPrecision(FormatToken.UNSET);
        int startIndex = 0;
        {
            boolean varC4FD83BCDCE254D147FDF9D7B3AC13AA_1057430619 = (result.charAt(0) == localeData.minusSign);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_453080784 = wrapParentheses(result);
                } 
            } 
            {
                {
                    result.insert(0, ' ');
                } 
                {
                    result.insert(0, '+');
                } 
            } 
        } 
        char firstChar = result.charAt(0);
        {
            startIndex = 1;
        } 
        {
            startIndex += 2;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1323634986 = padding(result, startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_521355860; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_521355860 = varB4EAC82CA7396A68D541C85D26508E83_529957315;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_521355860 = varB4EAC82CA7396A68D541C85D26508E83_37697486;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_521355860 = varB4EAC82CA7396A68D541C85D26508E83_453080784;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_521355860 = varB4EAC82CA7396A68D541C85D26508E83_1323634986;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_521355860.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_521355860;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.500 -0400", hash_original_method = "43DA2A76094CCA7D42287B4466035D61", hash_generated_method = "0BA49695F3CCEA19861A3D7E2D26A5E6")
    private void transformE(StringBuilder result) {
        final int precision = formatToken.getPrecision();
        String pattern = "0E+00";
        {
            StringBuilder sb = new StringBuilder("0.");
            char[] zeros = new char[precision];
            Arrays.fill(zeros, '0');
            sb.append(zeros);
            sb.append("E+00");
            pattern = sb.toString();
        } 
        NativeDecimalFormat nf = getDecimalFormat(pattern);
        char[] chars;
        {
            chars = nf.formatBigDecimal((BigDecimal) arg, null);
        } 
        {
            chars = nf.formatDouble(((Number) arg).doubleValue(), null);
        } 
        {
            int i = 0;
            {
                {
                    chars[i] = 'e';
                } 
            } 
        } 
        result.append(chars);
        {
            int indexOfE = result.indexOf("e");
            result.insert(indexOfE, localeData.decimalSeparator);
        } 
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.502 -0400", hash_original_method = "1973123C0DFAE44325340FD650EA833E", hash_generated_method = "594D6037B7E9A8F3F68C064124121EEA")
    private void transformG(StringBuilder result) {
        int precision = formatToken.getPrecision();
        {
            precision = 1;
        } 
        formatToken.setPrecision(precision);
        double d = ((Number) arg).doubleValue();
        {
            formatToken.setPrecision(precision);
            transformF(result);
        } 
        boolean requireScientificRepresentation = true;
        d = Math.abs(d);
        {
            boolean var3ECD0EAFA593A6ADC1E4F46524942B82_370941867 = (Double.isInfinite(d));
            {
                precision = formatToken.getPrecision();
                formatToken.setPrecision(precision);
                transformE(result);
            } 
        } 
        BigDecimal b = new BigDecimal(d, new MathContext(precision));
        d = b.doubleValue();
        long l = b.longValue();
        {
            boolean var7952BAED570DF8211C40DB97D6C9494B_2034062751 = (d >= 1 && d < Math.pow(10, precision));
            {
                {
                    boolean var6DA2CA6307083AFD29BF7C8CBC3D16A4_1533047909 = (l < Math.pow(10, precision));
                    {
                        requireScientificRepresentation = false;
                        precision -= String.valueOf(l).length();
                        precision = precision < 0 ? 0 : precision;
                        l = Math.round(d * Math.pow(10, precision + 1));
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_1001671478 = (String.valueOf(l).length() <= formatToken.getPrecision());
                        } 
                        formatToken.setPrecision(precision);
                    } 
                } 
            } 
            {
                l = b.movePointRight(4).longValue();
                {
                    boolean varFC5D9BA1CE39DA4CE1D6C7B756E730FB_1587036554 = (d >= Math.pow(10, -4) && d < 1);
                    {
                        requireScientificRepresentation = false;
                        precision += 4 - String.valueOf(l).length();
                        l = b.movePointRight(precision + 1).longValue();
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_2077146178 = (String.valueOf(l).length() <= formatToken.getPrecision());
                        } 
                        l = b.movePointRight(precision).longValue();
                        {
                            boolean var48F2D010DC481B7F6EDFA70502BAD5C5_573663872 = (l >= Math.pow(10, precision - 4));
                            {
                                formatToken.setPrecision(precision);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            precision = formatToken.getPrecision();
            formatToken.setPrecision(precision);
            transformE(result);
        } 
        {
            transformF(result);
        } 
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.503 -0400", hash_original_method = "DF70A96812FA1EE536149F6B5D8F4C45", hash_generated_method = "10D73BD31B54BF0CAF63F411EA07B6E2")
    private void transformF(StringBuilder result) {
        String pattern = "0.000000";
        final int precision = formatToken.getPrecision();
        {
            StringBuilder patternBuilder = new StringBuilder();
            {
                patternBuilder.append(',');
                int groupingSize = 3;
                char[] sharps = new char[groupingSize - 1];
                Arrays.fill(sharps, '#');
                patternBuilder.append(sharps);
            } 
            patternBuilder.append('0');
            {
                patternBuilder.append('.');
                {
                    int i = 0;
                    {
                        patternBuilder.append('0');
                    } 
                } 
            } 
            pattern = patternBuilder.toString();
        } 
        NativeDecimalFormat nf = getDecimalFormat(pattern);
        {
            result.append(nf.formatBigDecimal((BigDecimal) arg, null));
        } 
        {
            result.append(nf.formatDouble(((Number) arg).doubleValue(), null));
        } 
        {
            result.append(localeData.decimalSeparator);
        } 
        addTaint(result.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.503 -0400", hash_original_method = "DCC3844221755C0C14FA659BF8647E6B", hash_generated_method = "C89880F32DBD9CF85118548C0FE10F10")
    private void transformA(StringBuilder result) {
        {
            result.append(Float.toHexString(((Float) arg).floatValue()));
        } 
        {
            result.append(Double.toHexString(((Double) arg).doubleValue()));
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } 
        {
            boolean var0BA49339344F3E46004E2C66FA171DC0_1806150284 = (!formatToken.isPrecisionSet());
        } 
        int precision = formatToken.getPrecision();
        {
            precision = 1;
        } 
        int indexOfFirstFractionalDigit = result.indexOf(".") + 1;
        int indexOfP = result.indexOf("p");
        int fractionalLength = indexOfP - indexOfFirstFractionalDigit;
        {
            char[] zeros = new char[precision - fractionalLength];
            Arrays.fill(zeros, '0');
            result.insert(indexOfP, zeros);
        } 
        result.delete(indexOfFirstFractionalDigit + precision, indexOfP);
        addTaint(result.getTaint());
        
        
    }

    
    public enum BigDecimalLayoutForm {
        SCIENTIFIC,
        DECIMAL_FLOAT
    }

    
    private static class CachedDecimalFormat {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.503 -0400", hash_original_field = "DBECB303151001B254CD458C962BFA06", hash_generated_field = "57B03D121D93C35DC4CD446F8684FFFD")

        public NativeDecimalFormat decimalFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.503 -0400", hash_original_field = "0DC9450ED9A8CE4C2B3A1D132A9E7261", hash_generated_field = "F1A921FEF7693E6D4DF1F57B4D8F992B")

        public LocaleData currentLocaleData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.504 -0400", hash_original_field = "0B0F76B47F491349A26FCE54BEF066C1", hash_generated_field = "79B878750A67D50688DF69A25D47682C")

        public String currentPattern;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.504 -0400", hash_original_method = "3AB4302EBBD3C6ECF16B79A91E887CC6", hash_generated_method = "C4149067CD2AF28823E946F111841C62")
        public  CachedDecimalFormat() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.504 -0400", hash_original_method = "784B3214258603820EA00D340F6FA563", hash_generated_method = "5810D5C6A84A5B6CCD8D8CB68EC94C88")
        public NativeDecimalFormat update(LocaleData localeData, String pattern) {
            NativeDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_1726938070 = null; 
            {
                currentPattern = pattern;
                currentLocaleData = localeData;
                decimalFormat = new NativeDecimalFormat(currentPattern, currentLocaleData);
            } 
            {
                boolean varC04205845392AD76FE20C5C34EA780FF_1728715992 = (!pattern.equals(currentPattern));
                {
                    decimalFormat.applyPattern(pattern);
                    currentPattern = pattern;
                } 
            } 
            {
                decimalFormat.setDecimalFormatSymbols(localeData);
                currentLocaleData = localeData;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1726938070 = decimalFormat;
            varB4EAC82CA7396A68D541C85D26508E83_1726938070.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1726938070;
            
            
                
                
                
            
            
                
                
            
            
                
                
            
            
        }

        
    }


    
    private static class FormatToken {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "CABEE536F594A7425CADCE9FE8AB1016", hash_generated_field = "772417271F7F0BDFEA0E64414172A084")

        private int argIndex = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "AF7A833327A8AE088613AF6547808B22", hash_generated_field = "98479ABC53D035AE015748B6501BED19")

        boolean flagComma;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "77D00CCF13983863513393B04DE90A5E", hash_generated_field = "84E0FE8767B1823F9BD483DE94C8D5B6")

        boolean flagMinus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "58EB12214972261349BEFF4AFEEBADE7", hash_generated_field = "6268F94D7EC6432771FAC9A81C06B277")

        boolean flagParenthesis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "2FC88FB85E37FA3049E7C4FB6131D130", hash_generated_field = "B18F735AA5B0F0DABBD7E427068CC4C3")

        boolean flagPlus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "CA9A273EC976964302B347E1A888F814", hash_generated_field = "C720CA7CDB619DB58116FBA407D9470B")

        boolean flagSharp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "0A9A68E8CA9C930B3BD25AC0267A50F6", hash_generated_field = "A2EE573CAED7292D13BAD741251059A4")

        boolean flagSpace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "23AC23B8E4A938ABDC183973ABADFBB2", hash_generated_field = "79C0F430E2F3E53D9DF49552E4733685")

        boolean flagZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "06BB72258511A33C8D897372F71D9BEB", hash_generated_field = "E9F667FE63992DF0A85E5D7A0685E01F")

        private char conversionType = (char) UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "CBA7C70F75D3196A71CEB9803FA45256", hash_generated_field = "6AC9B9E35F29643906A8717247B50CCB")

        private char dateSuffix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "448C0902A81C3D78DB12BA0C73991461", hash_generated_field = "1A5EEC185E39D6E54480D34E352CE283")

        private int precision = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "E3737662F9BF753CD6F77C63AE3B771F", hash_generated_field = "7F084C83D0F1982A47DE9354FC0CF9F1")

        private int width = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_field = "8A84BD7A36073EE32C37C1B79462B501", hash_generated_field = "0527ECB4D15D76D63A180FF8CBB184B2")

        private StringBuilder strFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_method = "98998A93ECCA1CEE378BE6F5FF82B45F", hash_generated_method = "98998A93ECCA1CEE378BE6F5FF82B45F")
        public FormatToken ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.505 -0400", hash_original_method = "A7B957B3122A1E0264F586D374F2E6B7", hash_generated_method = "2A22B05000C61347FEBCC6DF5E68A740")
         boolean isDefault() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644518210 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_644518210;
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.506 -0400", hash_original_method = "A13969ECEC9F8D1C94EA6A52CDFB6E17", hash_generated_method = "34A94901FEE29621D0595BC9DFE5509B")
         boolean isPrecisionSet() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161653675 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_161653675;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.506 -0400", hash_original_method = "3A74106121887CCA509F985D60DB5637", hash_generated_method = "C694281182EECB0EBFFB772248BD1290")
         int getArgIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525403651 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525403651;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.506 -0400", hash_original_method = "27CE41687BF54420F4C00D2CFB6A73FA", hash_generated_method = "F3E94D0F268DD41F463EE67139BE9385")
         void setArgIndex(int index) {
            argIndex = index;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.506 -0400", hash_original_method = "40140C97EC91863535630C305615FEC1", hash_generated_method = "66D8F6629A1309EB07077042511FF80B")
         int getWidth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556963231 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556963231;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.507 -0400", hash_original_method = "5C954D9C93DF99E2E990960A3CC1749D", hash_generated_method = "D40BD430ACB0EA3E0D63770A2976B08D")
         void setWidth(int width) {
            this.width = width;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.507 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "344A1F425669CD968A07635790B988C2")
         int getPrecision() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457551793 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457551793;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.507 -0400", hash_original_method = "7515FB19ACE3C47DEBBD3E8357F6915C", hash_generated_method = "5866B10F1157266750859E3B0502D979")
         void setPrecision(int precise) {
            this.precision = precise;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.508 -0400", hash_original_method = "837A02C50E03265F058B23775F6F6197", hash_generated_method = "052CA00A2B99A602F72EF0F1CF12F90D")
         String getStrFlags() {
            String varB4EAC82CA7396A68D541C85D26508E83_1690588044 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1690588044 = (strFlags != null) ? strFlags.toString() : "";
            varB4EAC82CA7396A68D541C85D26508E83_1690588044.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1690588044;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.509 -0400", hash_original_method = "E6ACD7E32E6ABC5AE16C357DB8116DB3", hash_generated_method = "AB08EE4C38ABB46A0CFF3031CEF68013")
         boolean setFlag(int ch) {
            boolean dupe = false;
            
            dupe = flagComma;
            
            
            flagComma = true;
            
            
            dupe = flagMinus;
            
            
            flagMinus = true;
            
            
            dupe = flagParenthesis;
            
            
            flagParenthesis = true;
            
            
            dupe = flagPlus;
            
            
            flagPlus = true;
            
            
            dupe = flagSharp;
            
            
            flagSharp = true;
            
            
            dupe = flagSpace;
            
            
            flagSpace = true;
            
            
            dupe = flagZero;
            
            
            flagZero = true;
            
            {
                if (DroidSafeAndroidRuntime.control) throw new DuplicateFormatFlagsException(String.valueOf(ch));
            } 
            {
                strFlags = new StringBuilder(7);
            } 
            strFlags.append((char) ch);
            addTaint(ch);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976401078 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976401078;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.510 -0400", hash_original_method = "563B5213711441DEFA9BB3355CD61032", hash_generated_method = "AA0ABD4AEBC9A7B4C3BF6967DCF8A747")
         char getConversionType() {
            char varA87DEB01C5F539E6BDA34829C8EF2368_1780909020 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1780909020;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.511 -0400", hash_original_method = "6C3279116A999B7A879305F448E4C7E6", hash_generated_method = "37AF4C580148FD1E99691D99021A9434")
         void setConversionType(char c) {
            conversionType = c;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.511 -0400", hash_original_method = "EE45DA1AFAF958B13872135C146745E9", hash_generated_method = "F03C25A5705D3B27040605D99313B861")
         char getDateSuffix() {
            char varA87DEB01C5F539E6BDA34829C8EF2368_1903014016 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1903014016;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.512 -0400", hash_original_method = "6F4F20E9A23952874C5B1A6A80E321B4", hash_generated_method = "B3184FE9D51C912BE0F6FB157BD6AF85")
         void setDateSuffix(char c) {
            dateSuffix = c;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.512 -0400", hash_original_method = "67F4DE623207C5AE23B919ACAD45AA0B", hash_generated_method = "C2C90F14A07E364098480392257B3704")
         boolean requireArgument() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698734086 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698734086;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.514 -0400", hash_original_method = "34D9D8688BA6BF211700F1E1A866C731", hash_generated_method = "196E3E839EE2CF0978DB2DCB75E7FE7D")
         void checkFlags(Object arg) {
            boolean allowComma = false;
            boolean allowMinus = true;
            boolean allowParenthesis = false;
            boolean allowPlus = false;
            boolean allowSharp = false;
            boolean allowSpace = false;
            boolean allowZero = false;
            boolean allowPrecision = true;
            boolean allowWidth = true;
            boolean allowArgument = true;
            
            allowPrecision = false;
            
            
            {
                allowSharp = true;
            } 
            
            
            allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
            
            
            allowComma = allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
            
            
            allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
            
            
            allowPlus = allowSharp = allowSpace = allowZero = true;
            
            
            allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
            
            
            allowPrecision = false;
            
            
            allowSharp = allowZero = true;
            
            
            {
                allowParenthesis = allowPlus = allowSpace = true;
            } 
            
            
            allowPrecision = false;
            
            
            allowMinus = false;
            
            
            allowArgument = allowPrecision = allowWidth = false;
            
            
            allowArgument = false;
            
            
            allowPrecision = false;
            
            
            if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
            
            String mismatch = null;
            {
                mismatch = ",";
            } 
            {
                mismatch = "-";
            } 
            {
                mismatch = "(";
            } 
            {
                mismatch = "+";
            } 
            {
                mismatch = "#";
            } 
            {
                mismatch = " ";
            } 
            {
                mismatch = "0";
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException(mismatch);
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new FormatFlagsConversionMismatchException(mismatch, conversionType);
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new MissingFormatWidthException("-" + conversionType);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException("%" + conversionType +
                        " doesn't take an argument");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatPrecisionException(precision);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatWidthException(width);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException("the '+' and ' ' flags are incompatible");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException("the '-' and '0' flags are incompatible");
            } 
            addTaint(arg.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_method = "ECFEC3AA46FEEC6BDD34290E5303C5C1", hash_generated_method = "1F40DF5C85005D492273A294DD80B82F")
        public UnknownFormatConversionException unknownFormatConversionException() {
            {
                if (DroidSafeAndroidRuntime.control) throw new UnknownFormatConversionException(String.format("%c%c",
                        conversionType, dateSuffix));
            } 
            throw new UnknownFormatConversionException(String.valueOf(conversionType));
            
            
                
                        
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "0D32D75D80197F9844932D7929DB5015", hash_generated_field = "1BAD064282D47A986023D9014C2CC686")

        static final int LAST_ARGUMENT_INDEX = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "682DBD04772A37CB99D92EB22481F8C6", hash_generated_field = "DE29D11B6980854EC22F3C15E7DA3A93")

        static final int UNSET = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "8FE6A229232BC2E57ECCA9364408A298", hash_generated_field = "6514D206AC3CB1872EE1D615A4517002")

        static final int FLAGS_UNSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "AEFDD97FD64534132DA681FF73D9FC6D", hash_generated_field = "5A822570BEDDD49CF98C09711A50F2C5")

        static final int DEFAULT_PRECISION = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "60A2F91F5F69F60923439B86F77F3E9E", hash_generated_field = "9C5453ECCDBB9489F68E15932C42DB5C")

        static final int FLAG_ZERO = 1 << 4;
    }


    
    private static class FormatSpecifierParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "3AFBEC2146BDEA5BFCBD2772D27C43DD")

        private String format;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private int length;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "04D77DDD9C9389CC56939726D3DA8089", hash_generated_field = "4DF8ED554EC7B2C7483518163DCC894C")

        private int startIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.515 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "DDFC4038967415E2F22993ABFD9A3B3F")

        private int i;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.516 -0400", hash_original_method = "2EAAE714EE0AE41BF39DBCA3F91B9104", hash_generated_method = "99616AB8C1E30FEFAAC91AD743EEE46F")
          FormatSpecifierParser(String format) {
            this.format = format;
            this.length = format.length();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.518 -0400", hash_original_method = "F77740880648C3886F14C74FD023BD3A", hash_generated_method = "C2097C18439B735376EFE7A3A9C9B82C")
         FormatToken parseFormatToken(int offset) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1302893153 = null; 
            this.startIndex = offset;
            this.i = offset;
            varB4EAC82CA7396A68D541C85D26508E83_1302893153 = parseArgumentIndexAndFlags(new FormatToken());
            varB4EAC82CA7396A68D541C85D26508E83_1302893153.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1302893153;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.520 -0400", hash_original_method = "7C388C74117CDF3E7844B526DC734D8C", hash_generated_method = "43BF942299B4829473E24F00103EA267")
         String getFormatSpecifierText() {
            String varB4EAC82CA7396A68D541C85D26508E83_208988470 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_208988470 = format.substring(startIndex, i);
            varB4EAC82CA7396A68D541C85D26508E83_208988470.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_208988470;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.523 -0400", hash_original_method = "6521B9C02DA744FF180556D39A74ED44", hash_generated_method = "A16D5C184AF013DD6A5E3A1CD978CDA6")
        private int peek() {
            {
                Object var765273F0E3B5EB95414F86EBEA317E40_712010868 = (format.charAt(i));
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853843765 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853843765;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.524 -0400", hash_original_method = "F520742ED92EBACDB47FBF0D0B1F08F4", hash_generated_method = "FACE0D9305AC8039F2C48FCCF1C92A68")
        private char advance() {
            {
                if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
            } 
            char var7701A7CCE85ED6AA9880F4BA6BB09ECE_543018036 = (format.charAt(i++));
            char varA87DEB01C5F539E6BDA34829C8EF2368_1827869130 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1827869130;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.525 -0400", hash_original_method = "DFAEBB829CC6A7AFE465DA1B9A0C1D5A", hash_generated_method = "30FA7929508460104EF53B75E4099319")
        private UnknownFormatConversionException unknownFormatConversionException() {
        	throw new UnknownFormatConversionException(getFormatSpecifierText());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.527 -0400", hash_original_method = "AD27190704DEC79DF3778A7C88589CDF", hash_generated_method = "65A4BCD9A2F72E57D028848884C09651")
        private FormatToken parseArgumentIndexAndFlags(FormatToken token) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_602493377 = null; 
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_232751945 = null; 
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1790332860 = null; 
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_871934587 = null; 
            int position = i;
            int ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_193608176 = (Character.isDigit(ch));
                {
                    int number = nextInt();
                    {
                        boolean varAF443300A994E05CBD4A93B1F0A6046B_202600747 = (peek() == '$');
                        {
                            advance();
                            {
                                if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException(getFormatSpecifierText());
                            } 
                            token.setArgIndex(Math.max(0, number - 1));
                        } 
                        {
                            {
                                i = position;
                            } 
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_602493377 = parseWidth(token, number);
                            } 
                        } 
                    } 
                } 
                {
                    token.setArgIndex(FormatToken.LAST_ARGUMENT_INDEX);
                    advance();
                } 
            } 
            {
                boolean varD959591D21FA1B51681982FB61D589FE_1970491550 = (token.setFlag(peek()));
                {
                    advance();
                } 
            } 
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_2032772819 = (Character.isDigit(ch));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_232751945 = parseWidth(token, nextInt());
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1790332860 = parsePrecision(token);
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_871934587 = parseConversionType(token);
                } 
            } 
            addTaint(token.getTaint());
            FormatToken varA7E53CE21691AB073D9660D615818899_1919205544; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1919205544 = varB4EAC82CA7396A68D541C85D26508E83_602493377;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1919205544 = varB4EAC82CA7396A68D541C85D26508E83_232751945;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_1919205544 = varB4EAC82CA7396A68D541C85D26508E83_1790332860;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1919205544 = varB4EAC82CA7396A68D541C85D26508E83_871934587;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1919205544.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1919205544;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.527 -0400", hash_original_method = "F4C6E47C7F58A93445972E2EDFDFCD5C", hash_generated_method = "E70A8ACCD5439E030EB11FE6D375B98F")
        private FormatToken parseWidth(FormatToken token, int width) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_470294632 = null; 
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1145206369 = null; 
            token.setWidth(width);
            int ch = peek();
            {
                varB4EAC82CA7396A68D541C85D26508E83_470294632 = parsePrecision(token);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1145206369 = parseConversionType(token);
            } 
            addTaint(token.getTaint());
            addTaint(width);
            FormatToken varA7E53CE21691AB073D9660D615818899_601794771; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_601794771 = varB4EAC82CA7396A68D541C85D26508E83_470294632;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_601794771 = varB4EAC82CA7396A68D541C85D26508E83_1145206369;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_601794771.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_601794771;
            
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.529 -0400", hash_original_method = "06DE93E908B11B43F41251F270A468F2", hash_generated_method = "A3910035DB71A87A8A4267343820CAA0")
        private FormatToken parsePrecision(FormatToken token) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1970296999 = null; 
            advance();
            int ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_1713648211 = (Character.isDigit(ch));
                {
                    token.setPrecision(nextInt());
                    varB4EAC82CA7396A68D541C85D26508E83_1970296999 = parseConversionType(token);
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
                } 
            } 
            addTaint(token.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1970296999.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1970296999;
            
            
            
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.529 -0400", hash_original_method = "779E7C7A9E24C2B8C7A984530163E241", hash_generated_method = "53BE908F49527112DDF281793FA857B3")
        private FormatToken parseConversionType(FormatToken token) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1329770109 = null; 
            char conversionType = advance();
            token.setConversionType(conversionType);
            {
                char dateSuffix = advance();
                token.setDateSuffix(dateSuffix);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1329770109 = token;
            addTaint(token.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1329770109.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1329770109;
            
            
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.530 -0400", hash_original_method = "ADF8322FF676CF5038257F50E4E4E6DC", hash_generated_method = "B7E83DB2DD2AECE9EAF4306611622E4B")
        private int nextInt() {
            long value = 0;
            {
                boolean var89C0C9F591E86A0985096DE42B7326D1_2051575733 = (i < length && Character.isDigit(format.charAt(i)));
                {
                    value = 10 * value + (format.charAt(i++) - '0');
                    {
                        int varBF2312BB009815DC54B749D4D210B6C9_439082637 = (failNextInt());
                    } 
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740310202 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740310202;
            
            
            
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.531 -0400", hash_original_method = "F2814F47D4EB7F1D4CA24D9FE1C3918D", hash_generated_method = "939D14B88A753FD925BDB713245BFDB9")
        private int failNextInt() {
            {
                boolean varDB282127B78D2B872AE9DB5E44D7F6B7_991105733 = (Character.isDigit(peek()));
                {
                    advance();
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665924705 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665924705;
            
            
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.532 -0400", hash_original_field = "A2B3A99FDB3C7974C9307D50BA09396A", hash_generated_field = "936B09C441C4FA32E24FFDE50779B4D5")

    private static final char[] ZEROS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.533 -0400", hash_original_field = "2E22D2BB824CAE76137397D7BB1A476C", hash_generated_field = "A22626209D6F7C1DAB7E829778351877")

    private static final ThreadLocal<CachedDecimalFormat> cachedDecimalFormat = new ThreadLocal<CachedDecimalFormat>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.533 -0400", hash_original_method = "3BF85501572F336E7CB9026A6524A649", hash_generated_method = "1EC7F54F0E895EC060EFCA96009F4258")
        @Override
        protected CachedDecimalFormat initialValue() {
            CachedDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_1389458477 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1389458477 = new CachedDecimalFormat();
            varB4EAC82CA7396A68D541C85D26508E83_1389458477.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1389458477;
            
            
        }

        
};
}

