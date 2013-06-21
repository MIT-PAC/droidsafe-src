package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private Locale locale;
    transient private String[] strings;
    private int[] argumentNumbers;
    private Format[] formats;
    private int maxOffset;
    transient private int maxArgumentIndex;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.402 -0400", hash_original_method = "DF99A7D88BE30484426F461C5ED2222D", hash_generated_method = "132EEA28D22A6D520456BCFEDC9301A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageFormat(String template, Locale locale) {
        dsTaint.addTaint(template);
        dsTaint.addTaint(locale.dsTaint);
        applyPattern(template);
        // ---------- Original Method ----------
        //this.locale = locale;
        //applyPattern(template);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.402 -0400", hash_original_method = "BAA918AD1B6BB7758E580E5A4864BDBA", hash_generated_method = "EE4D0BB5CA6A7DB86052CDA3AB117F4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MessageFormat(String template) {
        this(template, Locale.getDefault());
        dsTaint.addTaint(template);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.403 -0400", hash_original_method = "20F481C3B4FB7D239D889AD1AE3136D7", hash_generated_method = "40E177DFCD00F39FEE2739FD0323B289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyPattern(String template) {
        dsTaint.addTaint(template);
        int length;
        length = template.length();
        StringBuffer buffer;
        buffer = new StringBuffer();
        ParsePosition position;
        position = new ParsePosition(0);
        ArrayList<String> localStrings;
        localStrings = new ArrayList<String>();
        int argCount;
        argCount = 0;
        int[] args;
        args = new int[10];
        int maxArg;
        maxArg = -1;
        ArrayList<Format> localFormats;
        localFormats = new ArrayList<Format>();
        {
            boolean var1CBD9628FDA8F8DD1F5F44774868AEB1_1743460566 = (position.getIndex() < length);
            {
                {
                    boolean varFFC364F2C72A4285D1C314224E673045_592344984 = (Format.upTo(template, position, buffer, '{'));
                    {
                        int arg;
                        arg = 0;
                        int offset;
                        offset = position.getIndex();
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid argument number");
                        } //End block
                        char ch;
                        {
                            boolean var7453C4F8FA9947A221A910705511A3B8_1594720301 = ((ch = template.charAt(offset++)) != '}' && ch != ',');
                            {
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid argument number");
                                } //End block
                                arg = arg * 10 + (ch - '0');
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid argument number");
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        position.setIndex(offset);
                        localFormats.add(parseVariable(template, position));
                        {
                            int[] newArgs;
                            newArgs = new int[args.length * 2];
                            System.arraycopy(args, 0, newArgs, 0, args.length);
                            args = newArgs;
                        } //End block
                        args[argCount++] = arg;
                        {
                            maxArg = arg;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                localStrings.add(buffer.toString());
                buffer.setLength(0);
            } //End block
        } //End collapsed parenthetic
        this.strings = localStrings.toArray(new String[localStrings.size()]);
        argumentNumbers = args;
        this.formats = localFormats.toArray(new Format[argCount]);
        maxOffset = argCount - 1;
        maxArgumentIndex = maxArg;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.403 -0400", hash_original_method = "B53A9961D24B646CE17498A2E8FD8A6F", hash_generated_method = "BB18D4A6F0B691F6CB24C465626E8CA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        MessageFormat clone;
        clone = (MessageFormat) super.clone();
        Format[] array;
        array = new Format[formats.length];
        {
            int i;
            i = formats.length;
            {
                {
                    array[i] = (Format) formats[i].clone();
                } //End block
            } //End block
        } //End collapsed parenthetic
        clone.formats = array;
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.403 -0400", hash_original_method = "2E70B47400B10858E99F75E16A06D539", hash_generated_method = "E13F2427EBFE618560A62F55C5ED2867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        MessageFormat format;
        format = (MessageFormat) object;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        boolean varA649D10E111C585C8EA57029692B0506_1438531583 = (locale.equals(format.locale)
                && Arrays.equals(strings, format.strings)
                && Arrays.equals(formats, format.formats));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.407 -0400", hash_original_method = "2F36A5BCF5EDBC18FDC7136A6298BFC9", hash_generated_method = "1DADB81143476D7A4DB2EA682765FA1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        StringBuffer buffer;
        buffer = new StringBuffer();
        ArrayList<FieldContainer> fields;
        fields = new ArrayList<FieldContainer>();
        formatImpl((Object[]) object, buffer, new FieldPosition(0), fields);
        AttributedString as;
        as = new AttributedString(buffer.toString());
        {
            Iterator<FieldContainer> varD56559809A91B868170A31CFE0D36FBD_1851950935 = (fields).iterator();
            varD56559809A91B868170A31CFE0D36FBD_1851950935.hasNext();
            FieldContainer fc = varD56559809A91B868170A31CFE0D36FBD_1851950935.next();
            {
                as.addAttribute(fc.attribute, fc.value, fc.start, fc.end);
            } //End block
        } //End collapsed parenthetic
        AttributedCharacterIterator varC17B74234B5E841D682B5933E83FF653_1656621388 = (as.getIterator());
        return (AttributedCharacterIterator)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.407 -0400", hash_original_method = "A9B03AC07F14FDC18F9B212B66591284", hash_generated_method = "453792B50BC928D1980701F71FD8C4B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final StringBuffer format(Object[] objects, StringBuffer buffer,
            FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(objects[0].dsTaint);
        StringBuffer var3A684682D1E9A4F64359B4D4D5AF1913_558084188 = (formatImpl(objects, buffer, field, null));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return formatImpl(objects, buffer, field, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.408 -0400", hash_original_method = "CB09F1AB0972A7396E3B2DB81FB1793E", hash_generated_method = "0E1DB37362559398B871499EC0739CAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringBuffer formatImpl(Object[] objects, StringBuffer buffer,
            FieldPosition position, List<FieldContainer> fields) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(objects[0].dsTaint);
        dsTaint.addTaint(fields.dsTaint);
        FieldPosition passedField;
        passedField = new FieldPosition(0);
        {
            int i;
            i = 0;
            {
                buffer.append(strings[i]);
                int begin;
                begin = buffer.length();
                Object arg;
                {
                    arg = objects[argumentNumbers[i]];
                } //End block
                {
                    buffer.append('{');
                    buffer.append(argumentNumbers[i]);
                    buffer.append('}');
                    handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                } //End block
                Format format;
                format = formats[i];
                {
                    {
                        format = NumberFormat.getInstance();
                    } //End block
                    {
                        format = DateFormat.getInstance();
                    } //End block
                    {
                        buffer.append(arg);
                        handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                    } //End block
                } //End block
                {
                    String result;
                    result = format.format(arg);
                    MessageFormat mf;
                    mf = new MessageFormat(result);
                    mf.setLocale(locale);
                    mf.format(objects, buffer, passedField);
                    handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                    handleFormat(format, arg, begin, fields);
                } //End block
                {
                    format.format(arg, buffer, passedField);
                    handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                    handleFormat(format, arg, begin, fields);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            buffer.append(strings[maxOffset + 1]);
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.408 -0400", hash_original_method = "C43D87ABB966C2154325453E86772F9C", hash_generated_method = "7BBB7E46CF75F3B5FF7B44964227AFDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleArgumentField(int begin, int end, int argIndex,
            FieldPosition position, List<FieldContainer> fields) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(argIndex);
        dsTaint.addTaint(end);
        dsTaint.addTaint(fields.dsTaint);
        dsTaint.addTaint(begin);
        {
            fields.add(new FieldContainer(begin, end, Field.ARGUMENT, Integer.valueOf(argIndex)));
        } //End block
        {
            {
                boolean varBC49BD907E1C43C27CEFD8A151C51509_336261282 = (position != null
                    && position.getFieldAttribute() == Field.ARGUMENT
                    && position.getEndIndex() == 0);
                {
                    position.setBeginIndex(begin);
                    position.setEndIndex(end);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.409 -0400", hash_original_method = "DE679CD49EEE558B2CA2B7C9C9DE5810", hash_generated_method = "E02403A2F43095AA218D805238B29732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleFormat(Format format, Object arg, int begin, List<FieldContainer> fields) {
        dsTaint.addTaint(arg.dsTaint);
        dsTaint.addTaint(format.dsTaint);
        dsTaint.addTaint(fields.dsTaint);
        dsTaint.addTaint(begin);
        AttributedCharacterIterator iterator;
        iterator = format.formatToCharacterIterator(arg);
        {
            boolean varD77FF4806191D69BA2B31700FC241E51_1171581687 = (iterator.getIndex() != iterator.getEndIndex());
            {
                int start;
                start = iterator.getRunStart();
                int end;
                end = iterator.getRunLimit();
                Iterator<?> it;
                it = iterator.getAttributes().keySet().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_74024108 = (it.hasNext());
                    {
                        AttributedCharacterIterator.Attribute attribute;
                        attribute = (AttributedCharacterIterator.Attribute) it.next();
                        Object value;
                        value = iterator.getAttribute(attribute);
                        fields.add(new FieldContainer(begin + start, begin + end, attribute, value));
                    } //End block
                } //End collapsed parenthetic
                iterator.setIndex(end);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.409 -0400", hash_original_method = "86D79FEBC73D19AFFF1CE089D06D0A2E", hash_generated_method = "3B49A095358CC08F19D801C0BDE1D0EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        StringBuffer var73228AB7E55AFDD9B01E3F04ED703C15_1720837745 = (format((Object[]) object, buffer, field));
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.409 -0400", hash_original_method = "7EB79515AF02A4588C0D82DEFC2945FA", hash_generated_method = "80330D0BA615D16E7DBDF926DBC1A2E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Format[] getFormats() {
        Format[] varE3F7F761C2A0A33D70B5D613BC161E1A_576430042 = (formats.clone());
        return (Format[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return formats.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.410 -0400", hash_original_method = "6305A24530517BEB5A0FB94704F4E840", hash_generated_method = "73ED4A1F0AB615DD1275BEB029C7EA13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Format[] getFormatsByArgumentIndex() {
        Format[] answer;
        answer = new Format[maxArgumentIndex + 1];
        {
            int i;
            i = 0;
            {
                answer[argumentNumbers[i]] = formats[i];
            } //End block
        } //End collapsed parenthetic
        return (Format[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Format[] answer = new Format[maxArgumentIndex + 1];
        //for (int i = 0; i < maxOffset + 1; i++) {
            //answer[argumentNumbers[i]] = formats[i];
        //}
        //return answer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.410 -0400", hash_original_method = "A090F158D8C76258E8307612B54D8E7F", hash_generated_method = "6AD9F63840689BE12A2AF38A5DE4F708")
    @DSModeled(DSC.SAFE)
    public void setFormatByArgumentIndex(int argIndex, Format format) {
        dsTaint.addTaint(argIndex);
        dsTaint.addTaint(format.dsTaint);
        {
            int i;
            i = 0;
            {
                {
                    formats[i] = format;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < maxOffset + 1; i++) {
            //if (argumentNumbers[i] == argIndex) {
                //formats[i] = format;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.410 -0400", hash_original_method = "A9324DA1CAF88845D05BF77827620ABB", hash_generated_method = "C25349936957613A2654B56E380183B5")
    @DSModeled(DSC.SAFE)
    public void setFormatsByArgumentIndex(Format[] formats) {
        dsTaint.addTaint(formats[0].dsTaint);
        {
            int j;
            j = 0;
            {
                {
                    int i;
                    i = 0;
                    {
                        {
                            this.formats[i] = formats[j];
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int j = 0; j < formats.length; j++) {
            //for (int i = 0; i < maxOffset + 1; i++) {
                //if (argumentNumbers[i] == j) {
                    //this.formats[i] = formats[j];
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.410 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "9C9FBA894BADCE58B57303AC1C2C7371")
    @DSModeled(DSC.SAFE)
    public Locale getLocale() {
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.411 -0400", hash_original_method = "C3648461AA348ABE73C14E89998C9B55", hash_generated_method = "0AE685B7AA51C1EA67A923EE30BB3276")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        {
            int i;
            i = 0;
            {
                hashCode += argumentNumbers[i] + strings[i].hashCode();
                {
                    hashCode += formats[i].hashCode();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            hashCode += strings[maxOffset + 1].hashCode();
        } //End block
        {
            int var6D36F62AEE3C06A81D4EF3D0DF59FC8E_2070056447 = (hashCode + locale.hashCode());
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.411 -0400", hash_original_method = "EC21A725ACD65B59B44C587C03791CB0", hash_generated_method = "91C635FB4E67239CDAD52F9F12331295")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] parse(String string) throws ParseException {
        dsTaint.addTaint(string);
        ParsePosition position;
        position = new ParsePosition(0);
        Object[] result;
        result = parse(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_1558771581 = (position.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Parse failure", position.getErrorIndex());
            } //End block
        } //End collapsed parenthetic
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(0);
        //Object[] result = parse(string, position);
        //if (position.getIndex() == 0) {
            //throw new ParseException("Parse failure", position.getErrorIndex());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.412 -0400", hash_original_method = "D7228DDFC0E7ACF8FDCF2D792E0983E6", hash_generated_method = "537B65FEF9A568C781E2517C77CF5DA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] parse(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        ParsePosition internalPos;
        internalPos = new ParsePosition(0);
        int offset;
        offset = position.getIndex();
        Object[] result;
        result = new Object[maxArgumentIndex + 1];
        {
            int i;
            i = 0;
            {
                String sub;
                sub = strings[i];
                {
                    boolean var5EDB83E3A79DDC5A7BCBE1521980F15A_2034517875 = (!string.startsWith(sub, offset));
                    {
                        position.setErrorIndex(offset);
                    } //End block
                } //End collapsed parenthetic
                offset += sub.length();
                Object parse;
                Format format;
                format = formats[i];
                {
                    {
                        int next;
                        next = string.indexOf(strings[i + 1], offset);
                        {
                            position.setErrorIndex(offset);
                        } //End block
                        parse = string.substring(offset, next);
                        offset = next;
                    } //End block
                    {
                        parse = string.substring(offset);
                        offset = string.length();
                    } //End block
                } //End block
                {
                    internalPos.setIndex(offset);
                    parse = format.parseObject(string, internalPos);
                    {
                        boolean var6308E1130EB2D8DEA892A2D901A9133A_1958310512 = (internalPos.getErrorIndex() != -1);
                        {
                            position.setErrorIndex(offset);
                        } //End block
                    } //End collapsed parenthetic
                    offset = internalPos.getIndex();
                } //End block
                result[argumentNumbers[i]] = parse;
            } //End block
        } //End collapsed parenthetic
        {
            String sub;
            sub = strings[maxOffset + 1];
            {
                boolean var53E87A64A12D1F228CD5107F6DBE8253_545240853 = (!string.startsWith(sub, offset));
                {
                    position.setErrorIndex(offset);
                } //End block
            } //End collapsed parenthetic
            offset += sub.length();
        } //End block
        position.setIndex(offset);
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.414 -0400", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "07B7225E09EF7675F782AA34856467C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object parseObject(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        Object var04896F8F24C019F45C9BA249DADA68FE_1419250171 = (parse(string, position));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parse(string, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.414 -0400", hash_original_method = "F0EBB1D410262325E53A6EB4F51F6A54", hash_generated_method = "E105A481CE42CBAFC592924CD85A22D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int match(String string, ParsePosition position, boolean last,
            String[] tokens) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(last);
        dsTaint.addTaint(string);
        dsTaint.addTaint(tokens[0]);
        int length, offset, token;
        length = string.length();
        offset = position.getIndex();
        token = -1;
        {
            boolean var14D87D9C20C010057079C6E91BCB7C21_1475289527 = (offset < length && Character.isWhitespace(string.charAt(offset)));
        } //End collapsed parenthetic
        {
            int i;
            i = tokens.length;
            {
                {
                    boolean var11649D62D50616747009CD13B3D32DAF_1275963991 = (string.regionMatches(true, offset, tokens[i], 0, tokens[i]
                    .length()));
                    {
                        token = i;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        offset += tokens[token].length();
        {
            boolean var14D87D9C20C010057079C6E91BCB7C21_1529711481 = (offset < length && Character.isWhitespace(string.charAt(offset)));
        } //End collapsed parenthetic
        char ch;
        {
            boolean var43CB108BDDFC8FD2BA0FBF20522C5046_1958672864 = (offset < length
                && ((ch = string.charAt(offset)) == '}' || (!last && ch == ',')));
            {
                position.setIndex(offset + 1);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.420 -0400", hash_original_method = "C959BA9FF5D67B6099707C942E630082", hash_generated_method = "3E8ABFE03382D4DF9A3E4A27FEAB0717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Format parseVariable(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        int length, offset;
        length = string.length();
        offset = position.getIndex();
        char ch;
        {
            boolean var4DEA603935E11831D4046087BD6EF808_1226398143 = (offset >= length || ((ch = string.charAt(offset++)) != '}' && ch != ','));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Missing element format");
            } //End block
        } //End collapsed parenthetic
        position.setIndex(offset);
        int type;
        type = match(string, position, false,
                new String[] { "time", "date", "number", "choice" });
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown element format");
        } //End block
        StringBuffer buffer;
        buffer = new StringBuffer();
        ch = string.charAt(position.getIndex() - 1);
        //Begin case 0 1 
        {
            {
                Object var73B8CEEEF9B5E4A75B2DC825BE5A68A0_1123865172 = (DateFormat.getDateInstance(
                            DateFormat.DEFAULT, locale));
                Object var7C3F49AE1E3A865D92FFB48C3BC27000_1972731732 = (DateFormat
                            .getTimeInstance(DateFormat.DEFAULT, locale));
            } //End flattened ternary
        } //End block
        //End case 0 1 
        //Begin case 0 1 
        int dateStyle;
        dateStyle = match(string, position, true,
                        new String[] { "full", "long", "medium", "short" });
        //End case 0 1 
        //Begin case 0 1 
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
            Format varD76397900981C2F5800ACA3F62409573_758949357 = (new SimpleDateFormat(buffer.toString(), locale));
        } //End block
        //End case 0 1 
        //Begin case 0 1 
        //Begin case 0 
        dateStyle = DateFormat.FULL;
        //End case 0 
        //Begin case 1 
        dateStyle = DateFormat.LONG;
        //End case 1 
        //Begin case 2 
        dateStyle = DateFormat.MEDIUM;
        //End case 2 
        //Begin case 3 
        dateStyle = DateFormat.SHORT;
        //End case 3 
        //End case 0 1 
        //Begin case 0 1 
        {
            Object varACB009D87819E716A108C625FFCACF8D_172322247 = (DateFormat
                        .getDateInstance(dateStyle, locale));
            Object var44486A3DA939C5B9E6A1819B997419DC_2147124371 = (DateFormat
                        .getTimeInstance(dateStyle, locale));
        } //End flattened ternary
        //End case 0 1 
        //Begin case 2 
        {
            Format var50AB0B5FC637EE3F45DBAB6573A64518_1319356564 = (NumberFormat.getInstance(locale));
        } //End block
        //End case 2 
        //Begin case 2 
        int numberStyle;
        numberStyle = match(string, position, true,
                        new String[] { "currency", "percent", "integer" });
        //End case 2 
        //Begin case 2 
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
            Format var501FD3D03D8F16BED9DFB779E20AA234_1427517537 = (new DecimalFormat(buffer.toString(),
                            new DecimalFormatSymbols(locale)));
        } //End block
        //End case 2 
        //Begin case 2 
        //Begin case 0 
        Format var51DC6D3F4FD595E919AD081BFB9C8F0B_1747803397 = (NumberFormat.getCurrencyInstance(locale));
        //End case 0 
        //Begin case 1 
        Format varFA4BDF6AA338932FD1E7723136B78DCB_1793508457 = (NumberFormat.getPercentInstance(locale));
        //End case 1 
        //End case 2 
        //Begin case 2 
        Format varCE443FF70CC5844F4BBE7D628954D3A9_434853401 = (NumberFormat.getIntegerInstance(locale));
        //End case 2 
        try 
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
        } //End block
        catch (IllegalArgumentException e)
        { }
        Format varE7C0DE2954FCD6976EF50EBAB068453C_745258973 = (new ChoiceFormat(buffer.toString()));
        return (Format)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.421 -0400", hash_original_method = "40ED9258145F8A9FA53AE23CC8BC5498", hash_generated_method = "63F37D2B8364F2909EF398618ABA47BA")
    @DSModeled(DSC.SAFE)
    public void setFormat(int offset, Format format) {
        dsTaint.addTaint(format.dsTaint);
        dsTaint.addTaint(offset);
        formats[offset] = format;
        // ---------- Original Method ----------
        //formats[offset] = format;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.421 -0400", hash_original_method = "F9E7D69C4CD5EB0783A6761389D5E01C", hash_generated_method = "6411CBF6C63A7591C5FBA123702DBA72")
    @DSModeled(DSC.SAFE)
    public void setFormats(Format[] formats) {
        dsTaint.addTaint(formats[0].dsTaint);
        int min;
        min = this.formats.length;
        {
            min = formats.length;
        } //End block
        {
            int i;
            i = 0;
            {
                this.formats[i] = formats[i];
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int min = this.formats.length;
        //if (formats.length < min) {
            //min = formats.length;
        //}
        //for (int i = 0; i < min; i++) {
            //this.formats[i] = formats[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.422 -0400", hash_original_method = "2EE5DAE8254A09BA3EE14891BDB8B487", hash_generated_method = "3DCDDDB7BCBFAB4718885D234C431D08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLocale(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        {
            int i;
            i = 0;
            {
                Format format;
                format = formats[i];
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
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.422 -0400", hash_original_method = "BE681D9EC5F601D03AA4D2DED505610A", hash_generated_method = "DA511967B01A03F93F6FE4E37F24E1AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String decodeDecimalFormat(StringBuffer buffer, Format format) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(format.dsTaint);
        buffer.append(",number");
        {
            boolean var6CEBA82DF33D1470AA1A059D1696D0E3_935739962 = (format.equals(NumberFormat.getNumberInstance(locale)));
            {
                boolean var192F3AD5A013893638F297627FF58BEA_1815360761 = (format.equals(NumberFormat.getIntegerInstance(locale)));
                {
                    buffer.append(",integer");
                } //End block
                {
                    boolean varB450D48AC462C45AAA8E5DBE1D910862_1231857971 = (format.equals(NumberFormat.getCurrencyInstance(locale)));
                    {
                        buffer.append(",currency");
                    } //End block
                    {
                        boolean var927C1C1A47036598E7859EB402797E4D_154521408 = (format.equals(NumberFormat.getPercentInstance(locale)));
                        {
                            buffer.append(",percent");
                        } //End block
                        {
                            buffer.append(',');
                            String varB5848B294D41D42D19CD24A09CB9A895_2070425269 = (((DecimalFormat) format).toPattern());
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.423 -0400", hash_original_method = "4C7466ADB5C592A5046867709A03D0C4", hash_generated_method = "D1FDFD7392E5A420DFCEEF0C4C1ADA54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String decodeSimpleDateFormat(StringBuffer buffer, Format format) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(format.dsTaint);
        {
            boolean var5F4A480F42E5996FA52C1A9C5C3C999F_1647403222 = (format.equals(DateFormat.getTimeInstance(DateFormat.DEFAULT, locale)));
            {
                buffer.append(",time");
            } //End block
            {
                boolean var43744F2D0FC6579BA743788AA995A096_1744696893 = (format.equals(DateFormat.getDateInstance(DateFormat.DEFAULT,
                locale)));
                {
                    buffer.append(",date");
                } //End block
                {
                    boolean varB0EA48F2A2C11725E996E8BE46F7FF35_1809298812 = (format.equals(DateFormat.getTimeInstance(DateFormat.SHORT,
                locale)));
                    {
                        buffer.append(",time,short");
                    } //End block
                    {
                        boolean var8246C8EFEACE2E9D9B1C8338079D58D9_682551204 = (format.equals(DateFormat.getDateInstance(DateFormat.SHORT,
                locale)));
                        {
                            buffer.append(",date,short");
                        } //End block
                        {
                            boolean varE7C95AEFF1DE05A7E96B5D0F7DAC387F_1679614019 = (format.equals(DateFormat.getTimeInstance(DateFormat.LONG,
                locale)));
                            {
                                buffer.append(",time,long");
                            } //End block
                            {
                                boolean var317068F66FC22B2E0F3D063F7D154FF5_1296397118 = (format.equals(DateFormat.getDateInstance(DateFormat.LONG,
                locale)));
                                {
                                    buffer.append(",date,long");
                                } //End block
                                {
                                    boolean var3D572CFA72E81699C49F02EA1CE6BAF3_2034068752 = (format.equals(DateFormat.getTimeInstance(DateFormat.FULL,
                locale)));
                                    {
                                        buffer.append(",time,full");
                                    } //End block
                                    {
                                        boolean var78B2780CC51552A3F4971CA95E0BBF6A_1593212181 = (format.equals(DateFormat.getDateInstance(DateFormat.FULL,
                locale)));
                                        {
                                            buffer.append(",date,full");
                                        } //End block
                                        {
                                            buffer.append(",date,");
                                            String var5F018F7E3649C3C2DA9EB21FA5472354_584378034 = (((SimpleDateFormat) format).toPattern());
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.423 -0400", hash_original_method = "0A7E6003101ED48A94DA0D4F2E79183E", hash_generated_method = "BFEEE09A1F6BCB1E2A56CF6B43148E6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toPattern() {
        StringBuffer buffer;
        buffer = new StringBuffer();
        {
            int i;
            i = 0;
            {
                appendQuoted(buffer, strings[i]);
                buffer.append('{');
                buffer.append(argumentNumbers[i]);
                Format format;
                format = formats[i];
                String pattern;
                pattern = null;
                {
                    buffer.append(",choice,");
                    pattern = ((ChoiceFormat) format).toPattern();
                } //End block
                {
                    pattern = decodeDecimalFormat(buffer, format);
                } //End block
                {
                    pattern = decodeSimpleDateFormat(buffer, format);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown format");
                } //End block
                {
                    boolean quote;
                    quote = false;
                    int index, length, count;
                    index = 0;
                    length = pattern.length();
                    count = 0;
                    {
                        char ch;
                        ch = pattern.charAt(index++);
                        {
                            quote = !quote;
                        } //End block
                        {
                            {
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
        } //End collapsed parenthetic
        {
            appendQuoted(buffer, strings[maxOffset + 1]);
        } //End block
        String varAD28D02EB1C6982A5710D014292E1955_570986144 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.424 -0400", hash_original_method = "6D428A023D401981380713AD4CDA7F82", hash_generated_method = "33C9F1AC5054908B34CA73EDED8EA7BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendQuoted(StringBuffer buffer, String string) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(string);
        int length;
        length = string.length();
        {
            int i;
            i = 0;
            {
                char ch;
                ch = string.charAt(i);
                {
                    buffer.append('\'');
                    buffer.append(ch);
                    buffer.append('\'');
                } //End block
                {
                    buffer.append(ch);
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.424 -0400", hash_original_method = "9DFEE475D15759FEAAC0AFBD81E7E5BF", hash_generated_method = "A14199EFBF2D7AD318126A949C1FC328")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("argumentNumbers", argumentNumbers);
        Format[] compatibleFormats;
        compatibleFormats = formats;
        fields.put("formats", compatibleFormats);
        fields.put("locale", locale);
        fields.put("maxOffset", maxOffset);
        int offset;
        offset = 0;
        int offsetsLength;
        offsetsLength = maxOffset + 1;
        int[] offsets;
        offsets = new int[offsetsLength];
        StringBuilder pattern;
        pattern = new StringBuilder();
        {
            int i;
            i = 0;
            {
                offset += strings[i].length();
                offsets[i] = offset;
                pattern.append(strings[i]);
            } //End block
        } //End collapsed parenthetic
        {
            pattern.append(strings[maxOffset + 1]);
        } //End block
        fields.put("offsets", offsets);
        fields.put("pattern", pattern.toString());
        stream.writeFields();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.425 -0400", hash_original_method = "A9ED7844547D5D70718F3EA12242A430", hash_generated_method = "A0129141969C31FCDC15D7236AE12697")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        argumentNumbers = (int[]) fields.get("argumentNumbers", null);
        formats = (Format[]) fields.get("formats", null);
        locale = (Locale) fields.get("locale", null);
        maxOffset = fields.get("maxOffset", 0);
        int[] offsets;
        offsets = (int[]) fields.get("offsets", null);
        String pattern;
        pattern = (String) fields.get("pattern", null);
        int length;
        {
            length = pattern.length() > 0 ? 1 : 0;
        } //End block
        {
            length = maxOffset
                    + (offsets[maxOffset] == pattern.length() ? 1 : 2);
        } //End block
        strings = new String[length];
        int last;
        last = 0;
        {
            int i;
            i = 0;
            {
                strings[i] = pattern.substring(last, offsets[i]);
                last = offsets[i];
            } //End block
        } //End collapsed parenthetic
        {
            strings[strings.length - 1] = pattern.substring(last, pattern
                    .length());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class FieldContainer {
        int start, end;
        AttributedCharacterIterator.Attribute attribute;
        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.425 -0400", hash_original_method = "79F81C9DE3A6ED731ECF4F86681A281A", hash_generated_method = "E7DA222F7DD5697EDEC08F8659256E9F")
        @DSModeled(DSC.SAFE)
        public FieldContainer(int start, int end,
                AttributedCharacterIterator.Attribute attribute, Object value) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(attribute.dsTaint);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
            //this.start = start;
            //this.end = end;
            //this.attribute = attribute;
            //this.value = value;
        }

        
    }


    
    public static class Field extends Format.Field {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.425 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "C99CCBB0448DF6198290968345EBA180")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Field(String fieldName) {
            super(fieldName);
            dsTaint.addTaint(fieldName);
            // ---------- Original Method ----------
        }

        
        private static final long serialVersionUID = 7899943957617360810L;
        public static final Field ARGUMENT = new Field("message argument field");
    }


    
    private static final long serialVersionUID = 6479157306784022952L;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("argumentNumbers", int[].class),
        new ObjectStreamField("formats", Format[].class),
        new ObjectStreamField("locale", Locale.class),
        new ObjectStreamField("maxOffset", int.class),
        new ObjectStreamField("offsets", int[].class),
        new ObjectStreamField("pattern", String.class),
    };
}

