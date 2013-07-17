package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import libcore.util.EmptyArray;

public class MessageFormat extends Format {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_field = "8BCF6629759BD278A5C6266BD9C054F8", hash_generated_field = "44BD3039B18FC631AF3469BBAABEF8A6")

    transient private String[] strings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_field = "014D9D5B07EC4A49CDA113BD9A52F736", hash_generated_field = "0CC8F912A4CE816F33718A9E926CC5E3")

    private int[] argumentNumbers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_field = "57E77C4C0B351CEA2ABB4E8B0042B074", hash_generated_field = "4840DFEFCC78103675C456B661F97552")

    private Format[] formats;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_field = "7CEE806716EA80C535651AF1C8AC2885", hash_generated_field = "8E5941FA03E4EAD10C76316C2B10EB9E")

    private int maxOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_field = "1D1C20ADB1AC0C122B3C1FA2123C4DA8", hash_generated_field = "D0A8CB4E81B16C7EDB6C78624EE723CF")

    transient private int maxArgumentIndex;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_method = "DF99A7D88BE30484426F461C5ED2222D", hash_generated_method = "E719E3A26C5068F11E196361CE198F4F")
    public  MessageFormat(String template, Locale locale) {
        addTaint(template.getTaint());
        this.locale = locale;
        applyPattern(template);
        // ---------- Original Method ----------
        //this.locale = locale;
        //applyPattern(template);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.727 -0400", hash_original_method = "BAA918AD1B6BB7758E580E5A4864BDBA", hash_generated_method = "81896B9388D8AB87ADBF31550E3A1963")
    public  MessageFormat(String template) {
        this(template, Locale.getDefault());
        addTaint(template.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.729 -0400", hash_original_method = "20F481C3B4FB7D239D889AD1AE3136D7", hash_generated_method = "4B318AB8A7469EB9BB030D2D6529C563")
    public void applyPattern(String template) {
        addTaint(template.getTaint());
        int length = template.length();
        StringBuffer buffer = new StringBuffer();
        ParsePosition position = new ParsePosition(0);
        ArrayList<String> localStrings = new ArrayList<String>();
        int argCount = 0;
        int[] args = new int[10];
        int maxArg = -1;
        ArrayList<Format> localFormats = new ArrayList<Format>();
        while
(position.getIndex() < length)        
        {
            if(Format.upTo(template, position, buffer, '{'))            
            {
                int arg = 0;
                int offset = position.getIndex();
                if(offset >= length)                
                {
                    IllegalArgumentException var5EE1EC2DB5E968AC4AD83F3273F4574E_1840105869 = new IllegalArgumentException("Invalid argument number");
                    var5EE1EC2DB5E968AC4AD83F3273F4574E_1840105869.addTaint(taint);
                    throw var5EE1EC2DB5E968AC4AD83F3273F4574E_1840105869;
                } //End block
                char ch;
                while
((ch = template.charAt(offset++)) != '}' && ch != ',')                
                {
                    if(ch < '0' && ch > '9')                    
                    {
                        IllegalArgumentException var5EE1EC2DB5E968AC4AD83F3273F4574E_1795809738 = new IllegalArgumentException("Invalid argument number");
                        var5EE1EC2DB5E968AC4AD83F3273F4574E_1795809738.addTaint(taint);
                        throw var5EE1EC2DB5E968AC4AD83F3273F4574E_1795809738;
                    } //End block
                    arg = arg * 10 + (ch - '0');
                    if(arg < 0 || offset >= length)                    
                    {
                        IllegalArgumentException var5EE1EC2DB5E968AC4AD83F3273F4574E_399432461 = new IllegalArgumentException("Invalid argument number");
                        var5EE1EC2DB5E968AC4AD83F3273F4574E_399432461.addTaint(taint);
                        throw var5EE1EC2DB5E968AC4AD83F3273F4574E_399432461;
                    } //End block
                } //End block
                offset--;
                position.setIndex(offset);
                localFormats.add(parseVariable(template, position));
                if(argCount >= args.length)                
                {
                    int[] newArgs = new int[args.length * 2];
                    System.arraycopy(args, 0, newArgs, 0, args.length);
                    args = newArgs;
                } //End block
                args[argCount++] = arg;
                if(arg > maxArg)                
                {
                    maxArg = arg;
                } //End block
            } //End block
            localStrings.add(buffer.toString());
            buffer.setLength(0);
        } //End block
        this.strings = localStrings.toArray(new String[localStrings.size()]);
        argumentNumbers = args;
        this.formats = localFormats.toArray(new Format[argCount]);
        maxOffset = argCount - 1;
        maxArgumentIndex = maxArg;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.731 -0400", hash_original_method = "B53A9961D24B646CE17498A2E8FD8A6F", hash_generated_method = "D844EFE5EC73BB2927D24BE9E1C3D1AC")
    @Override
    public Object clone() {
        MessageFormat clone = (MessageFormat) super.clone();
        Format[] array = new Format[formats.length];
for(int i = formats.length;--i >= 0;)
        {
            if(formats[i] != null)            
            {
                array[i] = (Format) formats[i].clone();
            } //End block
        } //End block
        clone.formats = array;
Object var3DE52045BFD3C1BF3742F994ED6139AD_725325188 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_725325188.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_725325188;
        // ---------- Original Method ----------
        //MessageFormat clone = (MessageFormat) super.clone();
        //Format[] array = new Format[formats.length];
        //for (int i = formats.length; --i >= 0;) {
            //if (formats[i] != null) {
                //array[i] = (Format) formats[i].clone();
            //}
        //}
        //clone.formats = array;
        //return clone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.732 -0400", hash_original_method = "2E70B47400B10858E99F75E16A06D539", hash_generated_method = "5BEDD4E526FBA434126B2C7C71CBFB43")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1122457032 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023387899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023387899;
        } //End block
        if(!(object instanceof MessageFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_546693878 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699877976 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_699877976;
        } //End block
        MessageFormat format = (MessageFormat) object;
        if(maxOffset != format.maxOffset)        
        {
            boolean var68934A3E9455FA72420237EB05902327_385803179 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622132711 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622132711;
        } //End block
for(int i = 0;i <= maxOffset;i++)
        {
            if(argumentNumbers[i] != format.argumentNumbers[i])            
            {
                boolean var68934A3E9455FA72420237EB05902327_26086572 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436768662 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436768662;
            } //End block
        } //End block
        boolean varA475EC639C74D8223DEBD993E08AD64D_1364570033 = (locale.equals(format.locale)
                && Arrays.equals(strings, format.strings)
                && Arrays.equals(formats, format.formats));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264751420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_264751420;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof MessageFormat)) {
            //return false;
        //}
        //MessageFormat format = (MessageFormat) object;
        //if (maxOffset != format.maxOffset) {
            //return false;
        //}
        //for (int i = 0; i <= maxOffset; i++) {
            //if (argumentNumbers[i] != format.argumentNumbers[i]) {
                //return false;
            //}
        //}
        //return locale.equals(format.locale)
                //&& Arrays.equals(strings, format.strings)
                //&& Arrays.equals(formats, format.formats);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.733 -0400", hash_original_method = "2F36A5BCF5EDBC18FDC7136A6298BFC9", hash_generated_method = "CA053DC050916D556956367DA0B49953")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        addTaint(object.getTaint());
        if(object == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1946857641 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1946857641.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1946857641;
        } //End block
        StringBuffer buffer = new StringBuffer();
        ArrayList<FieldContainer> fields = new ArrayList<FieldContainer>();
        formatImpl((Object[]) object, buffer, new FieldPosition(0), fields);
        AttributedString as = new AttributedString(buffer.toString());
for(FieldContainer fc : fields)
        {
            as.addAttribute(fc.attribute, fc.value, fc.start, fc.end);
        } //End block
AttributedCharacterIterator varE3ABF6B4C0DDC070CF0843A4557F5D73_1289279131 =         as.getIterator();
        varE3ABF6B4C0DDC070CF0843A4557F5D73_1289279131.addTaint(taint);
        return varE3ABF6B4C0DDC070CF0843A4557F5D73_1289279131;
        // ---------- Original Method ----------
        //if (object == null) {
            //throw new NullPointerException();
        //}
        //StringBuffer buffer = new StringBuffer();
        //ArrayList<FieldContainer> fields = new ArrayList<FieldContainer>();
        //formatImpl((Object[]) object, buffer, new FieldPosition(0), fields);
        //AttributedString as = new AttributedString(buffer.toString());
        //for (FieldContainer fc : fields) {
            //as.addAttribute(fc.attribute, fc.value, fc.start, fc.end);
        //}
        //return as.getIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.734 -0400", hash_original_method = "A9B03AC07F14FDC18F9B212B66591284", hash_generated_method = "39E881031A7F24261AA7D3251D02C61D")
    public final StringBuffer format(Object[] objects, StringBuffer buffer,
            FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(buffer.getTaint());
        addTaint(objects[0].getTaint());
StringBuffer var1F66D20762CFEE3B98D9E22CDAD14062_1066641912 =         formatImpl(objects, buffer, field, null);
        var1F66D20762CFEE3B98D9E22CDAD14062_1066641912.addTaint(taint);
        return var1F66D20762CFEE3B98D9E22CDAD14062_1066641912;
        // ---------- Original Method ----------
        //return formatImpl(objects, buffer, field, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.735 -0400", hash_original_method = "CB09F1AB0972A7396E3B2DB81FB1793E", hash_generated_method = "5E13A600C4506E81D0A548EB3D03B101")
    private StringBuffer formatImpl(Object[] objects, StringBuffer buffer,
            FieldPosition position, List<FieldContainer> fields) {
        addTaint(fields.getTaint());
        addTaint(position.getTaint());
        addTaint(buffer.getTaint());
        addTaint(objects[0].getTaint());
        FieldPosition passedField = new FieldPosition(0);
for(int i = 0;i <= maxOffset;i++)
        {
            buffer.append(strings[i]);
            int begin = buffer.length();
            Object arg;
            if(objects != null && argumentNumbers[i] < objects.length)            
            {
                arg = objects[argumentNumbers[i]];
            } //End block
            else
            {
                buffer.append('{');
                buffer.append(argumentNumbers[i]);
                buffer.append('}');
                handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                continue;
            } //End block
            Format format = formats[i];
            if(format == null || arg == null)            
            {
                if(arg instanceof Number)                
                {
                    format = NumberFormat.getInstance();
                } //End block
                else
                if(arg instanceof Date)                
                {
                    format = DateFormat.getInstance();
                } //End block
                else
                {
                    buffer.append(arg);
                    handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                    continue;
                } //End block
            } //End block
            if(format instanceof ChoiceFormat)            
            {
                String result = format.format(arg);
                MessageFormat mf = new MessageFormat(result);
                mf.setLocale(locale);
                mf.format(objects, buffer, passedField);
                handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                handleFormat(format, arg, begin, fields);
            } //End block
            else
            {
                format.format(arg, buffer, passedField);
                handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                handleFormat(format, arg, begin, fields);
            } //End block
        } //End block
        if(maxOffset + 1 < strings.length)        
        {
            buffer.append(strings[maxOffset + 1]);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_975541629 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_975541629.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_975541629;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.736 -0400", hash_original_method = "C43D87ABB966C2154325453E86772F9C", hash_generated_method = "7A4B320F81F8BFFBCFEB8B08AD9B35D6")
    private void handleArgumentField(int begin, int end, int argIndex,
            FieldPosition position, List<FieldContainer> fields) {
        addTaint(fields.getTaint());
        addTaint(position.getTaint());
        addTaint(argIndex);
        addTaint(end);
        addTaint(begin);
        if(fields != null)        
        {
            fields.add(new FieldContainer(begin, end, Field.ARGUMENT, Integer.valueOf(argIndex)));
        } //End block
        else
        {
            if(position != null
                    && position.getFieldAttribute() == Field.ARGUMENT
                    && position.getEndIndex() == 0)            
            {
                position.setBeginIndex(begin);
                position.setEndIndex(end);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (fields != null) {
            //fields.add(new FieldContainer(begin, end, Field.ARGUMENT, Integer.valueOf(argIndex)));
        //} else {
            //if (position != null
                    //&& position.getFieldAttribute() == Field.ARGUMENT
                    //&& position.getEndIndex() == 0) {
                //position.setBeginIndex(begin);
                //position.setEndIndex(end);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.737 -0400", hash_original_method = "DE679CD49EEE558B2CA2B7C9C9DE5810", hash_generated_method = "29B771FD742389F8993909A481D8A249")
    private void handleFormat(Format format, Object arg, int begin, List<FieldContainer> fields) {
        addTaint(fields.getTaint());
        addTaint(begin);
        addTaint(arg.getTaint());
        addTaint(format.getTaint());
        if(fields == null)        
        {
            return;
        } //End block
        AttributedCharacterIterator iterator = format.formatToCharacterIterator(arg);
        while
(iterator.getIndex() != iterator.getEndIndex())        
        {
            int start = iterator.getRunStart();
            int end = iterator.getRunLimit();
            Iterator<?> it = iterator.getAttributes().keySet().iterator();
            while
(it.hasNext())            
            {
                AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute) it.next();
                Object value = iterator.getAttribute(attribute);
                fields.add(new FieldContainer(begin + start, begin + end, attribute, value));
            } //End block
            iterator.setIndex(end);
        } //End block
        // ---------- Original Method ----------
        //if (fields == null) {
            //return;
        //}
        //AttributedCharacterIterator iterator = format.formatToCharacterIterator(arg);
        //while (iterator.getIndex() != iterator.getEndIndex()) {
            //int start = iterator.getRunStart();
            //int end = iterator.getRunLimit();
            //Iterator<?> it = iterator.getAttributes().keySet().iterator();
            //while (it.hasNext()) {
                //AttributedCharacterIterator.Attribute attribute =
                        //(AttributedCharacterIterator.Attribute) it.next();
                //Object value = iterator.getAttribute(attribute);
                //fields.add(new FieldContainer(begin + start, begin + end, attribute, value));
            //}
            //iterator.setIndex(end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.737 -0400", hash_original_method = "86D79FEBC73D19AFFF1CE089D06D0A2E", hash_generated_method = "E510EA554F68462BC47B9B4EE4325ACF")
    @Override
    public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(buffer.getTaint());
        addTaint(object.getTaint());
StringBuffer var14D385A8E7CB8E4D28D01B9DC3DB475C_1080020786 =         format((Object[]) object, buffer, field);
        var14D385A8E7CB8E4D28D01B9DC3DB475C_1080020786.addTaint(taint);
        return var14D385A8E7CB8E4D28D01B9DC3DB475C_1080020786;
        // ---------- Original Method ----------
        //return format((Object[]) object, buffer, field);
    }

    
    public static String format(String format, Object... args) {
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    args[i] = "null";
                }
            }
        }
        return new MessageFormat(format).format(args);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.738 -0400", hash_original_method = "7EB79515AF02A4588C0D82DEFC2945FA", hash_generated_method = "99D4098188E75014A5BE398879BF26C1")
    public Format[] getFormats() {
Format[] var3B05A551DC66BAA4CECF637E01483D61_1786466055 =         formats.clone();
        var3B05A551DC66BAA4CECF637E01483D61_1786466055.addTaint(taint);
        return var3B05A551DC66BAA4CECF637E01483D61_1786466055;
        // ---------- Original Method ----------
        //return formats.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.738 -0400", hash_original_method = "6305A24530517BEB5A0FB94704F4E840", hash_generated_method = "9FCCF62FBB908BD837E3DB3841008277")
    public Format[] getFormatsByArgumentIndex() {
        Format[] answer = new Format[maxArgumentIndex + 1];
for(int i = 0;i < maxOffset + 1;i++)
        {
            answer[argumentNumbers[i]] = formats[i];
        } //End block
Format[] var5F54B2A44CB8DC27B659B464640CF0FE_1782070784 =         answer;
        var5F54B2A44CB8DC27B659B464640CF0FE_1782070784.addTaint(taint);
        return var5F54B2A44CB8DC27B659B464640CF0FE_1782070784;
        // ---------- Original Method ----------
        //Format[] answer = new Format[maxArgumentIndex + 1];
        //for (int i = 0; i < maxOffset + 1; i++) {
            //answer[argumentNumbers[i]] = formats[i];
        //}
        //return answer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.739 -0400", hash_original_method = "A090F158D8C76258E8307612B54D8E7F", hash_generated_method = "42FA83817605FB7F4F4BC33CB9445F7D")
    public void setFormatByArgumentIndex(int argIndex, Format format) {
        addTaint(argIndex);
for(int i = 0;i < maxOffset + 1;i++)
        {
            if(argumentNumbers[i] == argIndex)            
            {
                formats[i] = format;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < maxOffset + 1; i++) {
            //if (argumentNumbers[i] == argIndex) {
                //formats[i] = format;
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.739 -0400", hash_original_method = "A9324DA1CAF88845D05BF77827620ABB", hash_generated_method = "31644C92854D98FE8E5E120AACD78F64")
    public void setFormatsByArgumentIndex(Format[] formats) {
for(int j = 0;j < formats.length;j++)
        {
for(int i = 0;i < maxOffset + 1;i++)
            {
                if(argumentNumbers[i] == j)                
                {
                    this.formats[i] = formats[j];
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int j = 0; j < formats.length; j++) {
            //for (int i = 0; i < maxOffset + 1; i++) {
                //if (argumentNumbers[i] == j) {
                    //this.formats[i] = formats[j];
                //}
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.740 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "1F74E507254282A4E061E7B482B19CDE")
    public Locale getLocale() {
Locale varB14E682FEAD06D8198D8ADBCBD62DEDB_1952390541 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_1952390541.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_1952390541;
        // ---------- Original Method ----------
        //return locale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.741 -0400", hash_original_method = "C3648461AA348ABE73C14E89998C9B55", hash_generated_method = "B5FDB0E1EB50253DA9ECFF84E5C755AC")
    @Override
    public int hashCode() {
        int hashCode = 0;
for(int i = 0;i <= maxOffset;i++)
        {
            hashCode += argumentNumbers[i] + strings[i].hashCode();
            if(formats[i] != null)            
            {
                hashCode += formats[i].hashCode();
            } //End block
        } //End block
        if(maxOffset + 1 < strings.length)        
        {
            hashCode += strings[maxOffset + 1].hashCode();
        } //End block
        if(locale != null)        
        {
            int var055CA475F8D8C62EB35811630A45799B_672558269 = (hashCode + locale.hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755113323 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755113323;
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_867892697 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288186839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288186839;
        // ---------- Original Method ----------
        //int hashCode = 0;
        //for (int i = 0; i <= maxOffset; i++) {
            //hashCode += argumentNumbers[i] + strings[i].hashCode();
            //if (formats[i] != null) {
                //hashCode += formats[i].hashCode();
            //}
        //}
        //if (maxOffset + 1 < strings.length) {
            //hashCode += strings[maxOffset + 1].hashCode();
        //}
        //if (locale != null) {
            //return hashCode + locale.hashCode();
        //}
        //return hashCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.741 -0400", hash_original_method = "EC21A725ACD65B59B44C587C03791CB0", hash_generated_method = "2C7E2A75E8571D5349CE7960B9C3CD73")
    public Object[] parse(String string) throws ParseException {
        addTaint(string.getTaint());
        ParsePosition position = new ParsePosition(0);
        Object[] result = parse(string, position);
        if(position.getIndex() == 0)        
        {
            ParseException varE37A2D5B4EBF9E36CFB19B811F94CB20_1786668851 = new ParseException("Parse failure", position.getErrorIndex());
            varE37A2D5B4EBF9E36CFB19B811F94CB20_1786668851.addTaint(taint);
            throw varE37A2D5B4EBF9E36CFB19B811F94CB20_1786668851;
        } //End block
Object[] varDC838461EE2FA0CA4C9BBB70A15456B0_1648685247 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1648685247.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1648685247;
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(0);
        //Object[] result = parse(string, position);
        //if (position.getIndex() == 0) {
            //throw new ParseException("Parse failure", position.getErrorIndex());
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.743 -0400", hash_original_method = "D7228DDFC0E7ACF8FDCF2D792E0983E6", hash_generated_method = "47A58CE8E63C3BDB3240F11F87C11CDD")
    public Object[] parse(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        if(string == null)        
        {
Object[] var3CDAC8E1894CA4B3B37667162540A097_743211993 =             EmptyArray.OBJECT;
            var3CDAC8E1894CA4B3B37667162540A097_743211993.addTaint(taint);
            return var3CDAC8E1894CA4B3B37667162540A097_743211993;
        } //End block
        ParsePosition internalPos = new ParsePosition(0);
        int offset = position.getIndex();
        Object[] result = new Object[maxArgumentIndex + 1];
for(int i = 0;i <= maxOffset;i++)
        {
            String sub = strings[i];
            if(!string.startsWith(sub, offset))            
            {
                position.setErrorIndex(offset);
Object[] var540C13E9E156B687226421B24F2DF178_255384275 =                 null;
                var540C13E9E156B687226421B24F2DF178_255384275.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_255384275;
            } //End block
            offset += sub.length();
            Object parse;
            Format format = formats[i];
            if(format == null)            
            {
                if(i + 1 < strings.length)                
                {
                    int next = string.indexOf(strings[i + 1], offset);
                    if(next == -1)                    
                    {
                        position.setErrorIndex(offset);
Object[] var540C13E9E156B687226421B24F2DF178_1065830070 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1065830070.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1065830070;
                    } //End block
                    parse = string.substring(offset, next);
                    offset = next;
                } //End block
                else
                {
                    parse = string.substring(offset);
                    offset = string.length();
                } //End block
            } //End block
            else
            {
                internalPos.setIndex(offset);
                parse = format.parseObject(string, internalPos);
                if(internalPos.getErrorIndex() != -1)                
                {
                    position.setErrorIndex(offset);
Object[] var540C13E9E156B687226421B24F2DF178_1296170980 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1296170980.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1296170980;
                } //End block
                offset = internalPos.getIndex();
            } //End block
            result[argumentNumbers[i]] = parse;
        } //End block
        if(maxOffset + 1 < strings.length)        
        {
            String sub = strings[maxOffset + 1];
            if(!string.startsWith(sub, offset))            
            {
                position.setErrorIndex(offset);
Object[] var540C13E9E156B687226421B24F2DF178_664352047 =                 null;
                var540C13E9E156B687226421B24F2DF178_664352047.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_664352047;
            } //End block
            offset += sub.length();
        } //End block
        position.setIndex(offset);
Object[] varDC838461EE2FA0CA4C9BBB70A15456B0_728118585 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_728118585.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_728118585;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.744 -0400", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "A90A30B6210A1B00F4F00A9696A71441")
    @Override
    public Object parseObject(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
Object var0D84F404ADD0A115F77E7D80294D92BC_392451055 =         parse(string, position);
        var0D84F404ADD0A115F77E7D80294D92BC_392451055.addTaint(taint);
        return var0D84F404ADD0A115F77E7D80294D92BC_392451055;
        // ---------- Original Method ----------
        //return parse(string, position);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.745 -0400", hash_original_method = "F0EBB1D410262325E53A6EB4F51F6A54", hash_generated_method = "E34ABB7DAE7046A0F28A91EEC1F36C0A")
    private int match(String string, ParsePosition position, boolean last,
            String[] tokens) {
        addTaint(tokens[0].getTaint());
        addTaint(last);
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        int length = string.length();
        int offset = position.getIndex();
        int token = -1;
        while
(offset < length && Character.isWhitespace(string.charAt(offset)))        
        {
            offset++;
        } //End block
for(int i = tokens.length;--i >= 0;)
        {
            if(string.regionMatches(true, offset, tokens[i], 0, tokens[i]
                    .length()))            
            {
                token = i;
                break;
            } //End block
        } //End block
        if(token == -1)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1844151264 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691691894 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691691894;
        } //End block
        offset += tokens[token].length();
        while
(offset < length && Character.isWhitespace(string.charAt(offset)))        
        {
            offset++;
        } //End block
        char ch;
        if(offset < length
                && ((ch = string.charAt(offset)) == '}' || (!last && ch == ',')))        
        {
            position.setIndex(offset + 1);
            int var94A08DA1FECBB6E8B46990538C7B50B2_462681114 = (token);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078478658 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078478658;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1009287091 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859710344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859710344;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.747 -0400", hash_original_method = "C959BA9FF5D67B6099707C942E630082", hash_generated_method = "EE0CB78E0606180E8A755487EF13D5AA")
    private Format parseVariable(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        int length = string.length();
        int offset = position.getIndex();
        char ch;
        if(offset >= length || ((ch = string.charAt(offset++)) != '}' && ch != ','))        
        {
            IllegalArgumentException varA5E7BD1FCB3868740C832FF64FE9F5AB_1943396192 = new IllegalArgumentException("Missing element format");
            varA5E7BD1FCB3868740C832FF64FE9F5AB_1943396192.addTaint(taint);
            throw varA5E7BD1FCB3868740C832FF64FE9F5AB_1943396192;
        } //End block
        position.setIndex(offset);
        if(ch == '}')        
        {
Format var540C13E9E156B687226421B24F2DF178_1007645908 =             null;
            var540C13E9E156B687226421B24F2DF178_1007645908.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1007645908;
        } //End block
        int type = match(string, position, false,
                new String[] { "time", "date", "number", "choice" });
        if(type == -1)        
        {
            IllegalArgumentException var09E469ADB27BDF219F1BEEA3440222E0_1744886388 = new IllegalArgumentException("Unknown element format");
            var09E469ADB27BDF219F1BEEA3440222E0_1744886388.addTaint(taint);
            throw var09E469ADB27BDF219F1BEEA3440222E0_1744886388;
        } //End block
        StringBuffer buffer = new StringBuffer();
        ch = string.charAt(position.getIndex() - 1);
switch(type){
        case 0:
        case 1:
        if(ch == '}')        
        {
Format var0C709448D0AB54751C0B08ACADFF8047_656036225 =             type == 1 ? DateFormat.getDateInstance(
                            DateFormat.DEFAULT, locale) : DateFormat
                            .getTimeInstance(DateFormat.DEFAULT, locale);
            var0C709448D0AB54751C0B08ACADFF8047_656036225.addTaint(taint);
            return var0C709448D0AB54751C0B08ACADFF8047_656036225;
        } //End block
        int dateStyle = match(string, position, true,
                        new String[] { "full", "long", "medium", "short" });
        if(dateStyle == -1)        
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
Format varB2162946718138C88520981897980D1E_1037798939 =             new SimpleDateFormat(buffer.toString(), locale);
            varB2162946718138C88520981897980D1E_1037798939.addTaint(taint);
            return varB2162946718138C88520981897980D1E_1037798939;
        } //End block
switch(dateStyle){
        case 0:
        dateStyle = DateFormat.FULL;
        break;
        case 1:
        dateStyle = DateFormat.LONG;
        break;
        case 2:
        dateStyle = DateFormat.MEDIUM;
        break;
        case 3:
        dateStyle = DateFormat.SHORT;
        break;
}Format var90CF270C7C4B8EB08FC9094DA689D26F_760964311 =         type == 1 ? DateFormat
                        .getDateInstance(dateStyle, locale) : DateFormat
                        .getTimeInstance(dateStyle, locale);
        var90CF270C7C4B8EB08FC9094DA689D26F_760964311.addTaint(taint);
        return var90CF270C7C4B8EB08FC9094DA689D26F_760964311;
        case 2:
        if(ch == '}')        
        {
Format varC876ECCE2FE467BF4F669D83F42C1CC4_609295509 =             NumberFormat.getInstance(locale);
            varC876ECCE2FE467BF4F669D83F42C1CC4_609295509.addTaint(taint);
            return varC876ECCE2FE467BF4F669D83F42C1CC4_609295509;
        } //End block
        int numberStyle = match(string, position, true,
                        new String[] { "currency", "percent", "integer" });
        if(numberStyle == -1)        
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
Format var1E51E74597221772FC02440C803ECB0B_1937184767 =             new DecimalFormat(buffer.toString(),
                            new DecimalFormatSymbols(locale));
            var1E51E74597221772FC02440C803ECB0B_1937184767.addTaint(taint);
            return var1E51E74597221772FC02440C803ECB0B_1937184767;
        } //End block
switch(numberStyle){
        case 0:
Format var6FF1AD4D31FD3125CD7111F9FBEC46FF_1221670056 =         NumberFormat.getCurrencyInstance(locale);
        var6FF1AD4D31FD3125CD7111F9FBEC46FF_1221670056.addTaint(taint);
        return var6FF1AD4D31FD3125CD7111F9FBEC46FF_1221670056;
        case 1:
Format varEA6C825C3E32D8F255175D38022E4D9C_1587405586 =         NumberFormat.getPercentInstance(locale);
        varEA6C825C3E32D8F255175D38022E4D9C_1587405586.addTaint(taint);
        return varEA6C825C3E32D8F255175D38022E4D9C_1587405586;
}Format var4F8D91476BF3374B1EB5714A42AC5671_644267138 =         NumberFormat.getIntegerInstance(locale);
        var4F8D91476BF3374B1EB5714A42AC5671_644267138.addTaint(taint);
        return var4F8D91476BF3374B1EB5714A42AC5671_644267138;
}        try 
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
        } //End block
        catch (IllegalArgumentException e)
        {
        } //End block
Format varF3AAE7A0C8A2D02E92D0F8827A6B82D9_1951322684 =         new ChoiceFormat(buffer.toString());
        varF3AAE7A0C8A2D02E92D0F8827A6B82D9_1951322684.addTaint(taint);
        return varF3AAE7A0C8A2D02E92D0F8827A6B82D9_1951322684;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.748 -0400", hash_original_method = "40ED9258145F8A9FA53AE23CC8BC5498", hash_generated_method = "F1F0700A79FE15C5103D16FF48D78E94")
    public void setFormat(int offset, Format format) {
        formats[offset] = format;
        // ---------- Original Method ----------
        //formats[offset] = format;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.749 -0400", hash_original_method = "F9E7D69C4CD5EB0783A6761389D5E01C", hash_generated_method = "01BCEC32624587A39DE068B6ECE04A91")
    public void setFormats(Format[] formats) {
        int min = this.formats.length;
        if(formats.length < min)        
        {
            min = formats.length;
        } //End block
for(int i = 0;i < min;i++)
        {
            this.formats[i] = formats[i];
        } //End block
        // ---------- Original Method ----------
        //int min = this.formats.length;
        //if (formats.length < min) {
            //min = formats.length;
        //}
        //for (int i = 0; i < min; i++) {
            //this.formats[i] = formats[i];
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.750 -0400", hash_original_method = "2EE5DAE8254A09BA3EE14891BDB8B487", hash_generated_method = "03E095937499E6AB0108A5656CC38A4C")
    public void setLocale(Locale locale) {
        this.locale = locale;
for(int i = 0;i <= maxOffset;i++)
        {
            Format format = formats[i];
            if(format instanceof DecimalFormat)            
            {
                try 
                {
                    formats[i] = new DecimalFormat(((DecimalFormat) format)
                            .toPattern(), new DecimalFormatSymbols(locale));
                } //End block
                catch (NullPointerException npe)
                {
                    formats[i] = null;
                } //End block
            } //End block
            else
            if(format instanceof SimpleDateFormat)            
            {
                try 
                {
                    formats[i] = new SimpleDateFormat(((SimpleDateFormat) format)
                            .toPattern(), locale);
                } //End block
                catch (NullPointerException npe)
                {
                    formats[i] = null;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.750 -0400", hash_original_method = "BE681D9EC5F601D03AA4D2DED505610A", hash_generated_method = "E2A8BC1C32917E6036A41F9D4CB8525B")
    private String decodeDecimalFormat(StringBuffer buffer, Format format) {
        addTaint(format.getTaint());
        addTaint(buffer.getTaint());
        buffer.append(",number");
        if(format.equals(NumberFormat.getNumberInstance(locale)))        
        {
        } //End block
        else
        if(format.equals(NumberFormat.getIntegerInstance(locale)))        
        {
            buffer.append(",integer");
        } //End block
        else
        if(format.equals(NumberFormat.getCurrencyInstance(locale)))        
        {
            buffer.append(",currency");
        } //End block
        else
        if(format.equals(NumberFormat.getPercentInstance(locale)))        
        {
            buffer.append(",percent");
        } //End block
        else
        {
            buffer.append(',');
String var51B8C705848C8D4C7673437789869999_1720997177 =             ((DecimalFormat) format).toPattern();
            var51B8C705848C8D4C7673437789869999_1720997177.addTaint(taint);
            return var51B8C705848C8D4C7673437789869999_1720997177;
        } //End block
String var540C13E9E156B687226421B24F2DF178_1380089862 =         null;
        var540C13E9E156B687226421B24F2DF178_1380089862.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1380089862;
        // ---------- Original Method ----------
        //buffer.append(",number");
        //if (format.equals(NumberFormat.getNumberInstance(locale))) {
        //} else if (format.equals(NumberFormat.getIntegerInstance(locale))) {
            //buffer.append(",integer");
        //} else if (format.equals(NumberFormat.getCurrencyInstance(locale))) {
            //buffer.append(",currency");
        //} else if (format.equals(NumberFormat.getPercentInstance(locale))) {
            //buffer.append(",percent");
        //} else {
            //buffer.append(',');
            //return ((DecimalFormat) format).toPattern();
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.750 -0400", hash_original_method = "4C7466ADB5C592A5046867709A03D0C4", hash_generated_method = "05F9B45DC3EF7D6D43C96208EB34535F")
    private String decodeSimpleDateFormat(StringBuffer buffer, Format format) {
        addTaint(format.getTaint());
        addTaint(buffer.getTaint());
        if(format.equals(DateFormat.getTimeInstance(DateFormat.DEFAULT, locale)))        
        {
            buffer.append(",time");
        } //End block
        else
        if(format.equals(DateFormat.getDateInstance(DateFormat.DEFAULT,
                locale)))        
        {
            buffer.append(",date");
        } //End block
        else
        if(format.equals(DateFormat.getTimeInstance(DateFormat.SHORT,
                locale)))        
        {
            buffer.append(",time,short");
        } //End block
        else
        if(format.equals(DateFormat.getDateInstance(DateFormat.SHORT,
                locale)))        
        {
            buffer.append(",date,short");
        } //End block
        else
        if(format.equals(DateFormat.getTimeInstance(DateFormat.LONG,
                locale)))        
        {
            buffer.append(",time,long");
        } //End block
        else
        if(format.equals(DateFormat.getDateInstance(DateFormat.LONG,
                locale)))        
        {
            buffer.append(",date,long");
        } //End block
        else
        if(format.equals(DateFormat.getTimeInstance(DateFormat.FULL,
                locale)))        
        {
            buffer.append(",time,full");
        } //End block
        else
        if(format.equals(DateFormat.getDateInstance(DateFormat.FULL,
                locale)))        
        {
            buffer.append(",date,full");
        } //End block
        else
        {
            buffer.append(",date,");
String varE4D840FE52EC3DDE1C4972E77CFD5992_2129405644 =             ((SimpleDateFormat) format).toPattern();
            varE4D840FE52EC3DDE1C4972E77CFD5992_2129405644.addTaint(taint);
            return varE4D840FE52EC3DDE1C4972E77CFD5992_2129405644;
        } //End block
String var540C13E9E156B687226421B24F2DF178_1772442474 =         null;
        var540C13E9E156B687226421B24F2DF178_1772442474.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1772442474;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.751 -0400", hash_original_method = "0A7E6003101ED48A94DA0D4F2E79183E", hash_generated_method = "414CE20609C84DC019F7BD689935614B")
    public String toPattern() {
        StringBuffer buffer = new StringBuffer();
for(int i = 0;i <= maxOffset;i++)
        {
            appendQuoted(buffer, strings[i]);
            buffer.append('{');
            buffer.append(argumentNumbers[i]);
            Format format = formats[i];
            String pattern = null;
            if(format instanceof ChoiceFormat)            
            {
                buffer.append(",choice,");
                pattern = ((ChoiceFormat) format).toPattern();
            } //End block
            else
            if(format instanceof DecimalFormat)            
            {
                pattern = decodeDecimalFormat(buffer, format);
            } //End block
            else
            if(format instanceof SimpleDateFormat)            
            {
                pattern = decodeSimpleDateFormat(buffer, format);
            } //End block
            else
            if(format != null)            
            {
                IllegalArgumentException var384628D36ACAADA29BD94F3FBB049AED_1609245054 = new IllegalArgumentException("Unknown format");
                var384628D36ACAADA29BD94F3FBB049AED_1609245054.addTaint(taint);
                throw var384628D36ACAADA29BD94F3FBB049AED_1609245054;
            } //End block
            if(pattern != null)            
            {
                boolean quote = false;
                int index = 0;
                int length = pattern.length();
                int count = 0;
                while
(index < length)                
                {
                    char ch = pattern.charAt(index++);
                    if(ch == '\'')                    
                    {
                        quote = !quote;
                    } //End block
                    if(!quote)                    
                    {
                        if(ch == '{')                        
                        {
                            count++;
                        } //End block
                        if(ch == '}')                        
                        {
                            if(count > 0)                            
                            {
                                count--;
                            } //End block
                            else
                            {
                                buffer.append("'}");
                                ch = '\'';
                            } //End block
                        } //End block
                    } //End block
                    buffer.append(ch);
                } //End block
            } //End block
            buffer.append('}');
        } //End block
        if(maxOffset + 1 < strings.length)        
        {
            appendQuoted(buffer, strings[maxOffset + 1]);
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_1105567738 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1105567738.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1105567738;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.751 -0400", hash_original_method = "6D428A023D401981380713AD4CDA7F82", hash_generated_method = "8B6BA6E09C3D489FCB91453B3F79F9D0")
    private void appendQuoted(StringBuffer buffer, String string) {
        addTaint(string.getTaint());
        addTaint(buffer.getTaint());
        int length = string.length();
for(int i = 0;i < length;i++)
        {
            char ch = string.charAt(i);
            if(ch == '{' || ch == '}')            
            {
                buffer.append('\'');
                buffer.append(ch);
                buffer.append('\'');
            } //End block
            else
            {
                buffer.append(ch);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int length = string.length();
        //for (int i = 0; i < length; i++) {
            //char ch = string.charAt(i);
            //if (ch == '{' || ch == '}') {
                //buffer.append('\'');
                //buffer.append(ch);
                //buffer.append('\'');
            //} else {
                //buffer.append(ch);
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.752 -0400", hash_original_method = "9DFEE475D15759FEAAC0AFBD81E7E5BF", hash_generated_method = "CBB6943F5B04099A235DE6515F4971D6")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("argumentNumbers", argumentNumbers);
        Format[] compatibleFormats = formats;
        fields.put("formats", compatibleFormats);
        fields.put("locale", locale);
        fields.put("maxOffset", maxOffset);
        int offset = 0;
        int offsetsLength = maxOffset + 1;
        int[] offsets = new int[offsetsLength];
        StringBuilder pattern = new StringBuilder();
for(int i = 0;i <= maxOffset;i++)
        {
            offset += strings[i].length();
            offsets[i] = offset;
            pattern.append(strings[i]);
        } //End block
        if(maxOffset + 1 < strings.length)        
        {
            pattern.append(strings[maxOffset + 1]);
        } //End block
        fields.put("offsets", offsets);
        fields.put("pattern", pattern.toString());
        stream.writeFields();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_method = "A9ED7844547D5D70718F3EA12242A430", hash_generated_method = "95C3259BE192611991F9A2CC87BE8043")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
        argumentNumbers = (int[]) fields.get("argumentNumbers", null);
        formats = (Format[]) fields.get("formats", null);
        locale = (Locale) fields.get("locale", null);
        maxOffset = fields.get("maxOffset", 0);
        int[] offsets = (int[]) fields.get("offsets", null);
        String pattern = (String) fields.get("pattern", null);
        int length;
        if(maxOffset < 0)        
        {
            length = pattern.length() > 0 ? 1 : 0;
        } //End block
        else
        {
            length = maxOffset
                    + (offsets[maxOffset] == pattern.length() ? 1 : 2);
        } //End block
        strings = new String[length];
        int last = 0;
for(int i = 0;i <= maxOffset;i++)
        {
            strings[i] = pattern.substring(last, offsets[i]);
            last = offsets[i];
        } //End block
        if(maxOffset + 1 < strings.length)        
        {
            strings[strings.length - 1] = pattern.substring(last, pattern
                    .length());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class FieldContainer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "D2EB444E35C0A71F0A85DF8194ACB5B6", hash_generated_field = "3C510FC4DA58A78E7F390C1B8DF1DA17")

        AttributedCharacterIterator.Attribute attribute;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_method = "79F81C9DE3A6ED731ECF4F86681A281A", hash_generated_method = "2168FA24EBD30878F8A9FAB65C5466CD")
        public  FieldContainer(int start, int end,
                AttributedCharacterIterator.Attribute attribute, Object value) {
            this.start = start;
            this.end = end;
            this.attribute = attribute;
            this.value = value;
            // ---------- Original Method ----------
            //this.start = start;
            //this.end = end;
            //this.attribute = attribute;
            //this.value = value;
        }

        
    }


    
    public static class Field extends Format.Field {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
        protected  Field(String fieldName) {
            super(fieldName);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "65742A0DA2D101A482A0847D5411F3C4", hash_generated_field = "82B93A1D640327089FF038CC1C876D1A")

        private static final long serialVersionUID = 7899943957617360810L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "D94CE10B685B435CA363911C15F03B9C", hash_generated_field = "BDDCF15FC3001123F8D4DF824E83B022")

        public static final Field ARGUMENT = new Field("message argument field");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.754 -0400", hash_original_field = "CF53E2BEFB2CA37DB3AE5D58546ECE7A", hash_generated_field = "DDAF9963C56DC8D3CC72243FA6D60F41")

    private static final long serialVersionUID = 6479157306784022952L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.754 -0400", hash_original_field = "48F92F66CE5FE41C558A38F296DF8082", hash_generated_field = "F3984ED43D46FE3C3FFDBA430A29142D")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("argumentNumbers", int[].class),
        new ObjectStreamField("formats", Format[].class),
        new ObjectStreamField("locale", Locale.class),
        new ObjectStreamField("maxOffset", int.class),
        new ObjectStreamField("offsets", int[].class),
        new ObjectStreamField("pattern", String.class),
    };
}

