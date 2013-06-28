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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.822 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.822 -0400", hash_original_field = "8BCF6629759BD278A5C6266BD9C054F8", hash_generated_field = "44BD3039B18FC631AF3469BBAABEF8A6")

    transient private String[] strings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.822 -0400", hash_original_field = "014D9D5B07EC4A49CDA113BD9A52F736", hash_generated_field = "0CC8F912A4CE816F33718A9E926CC5E3")

    private int[] argumentNumbers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.822 -0400", hash_original_field = "57E77C4C0B351CEA2ABB4E8B0042B074", hash_generated_field = "4840DFEFCC78103675C456B661F97552")

    private Format[] formats;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.822 -0400", hash_original_field = "7CEE806716EA80C535651AF1C8AC2885", hash_generated_field = "8E5941FA03E4EAD10C76316C2B10EB9E")

    private int maxOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.822 -0400", hash_original_field = "1D1C20ADB1AC0C122B3C1FA2123C4DA8", hash_generated_field = "D0A8CB4E81B16C7EDB6C78624EE723CF")

    transient private int maxArgumentIndex;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.822 -0400", hash_original_method = "DF99A7D88BE30484426F461C5ED2222D", hash_generated_method = "B7FCD83538A640F8B254E5B4C5B3343E")
    public  MessageFormat(String template, Locale locale) {
        this.locale = locale;
        applyPattern(template);
        addTaint(template.getTaint());
        // ---------- Original Method ----------
        //this.locale = locale;
        //applyPattern(template);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.823 -0400", hash_original_method = "BAA918AD1B6BB7758E580E5A4864BDBA", hash_generated_method = "81896B9388D8AB87ADBF31550E3A1963")
    public  MessageFormat(String template) {
        this(template, Locale.getDefault());
        addTaint(template.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.823 -0400", hash_original_method = "20F481C3B4FB7D239D889AD1AE3136D7", hash_generated_method = "DF91C5DF24055ECDDC7F1135CF8329DA")
    public void applyPattern(String template) {
        int length = template.length();
        StringBuffer buffer = new StringBuffer();
        ParsePosition position = new ParsePosition(0);
        ArrayList<String> localStrings = new ArrayList<String>();
        int argCount = 0;
        int[] args = new int[10];
        int maxArg = -1;
        ArrayList<Format> localFormats = new ArrayList<Format>();
        {
            boolean var1CBD9628FDA8F8DD1F5F44774868AEB1_77056901 = (position.getIndex() < length);
            {
                {
                    boolean varFFC364F2C72A4285D1C314224E673045_1865832113 = (Format.upTo(template, position, buffer, '{'));
                    {
                        int arg = 0;
                        int offset = position.getIndex();
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid argument number");
                        } //End block
                        char ch;
                        {
                            boolean var7453C4F8FA9947A221A910705511A3B8_816920533 = ((ch = template.charAt(offset++)) != '}' && ch != ',');
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
                            int[] newArgs = new int[args.length * 2];
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
        addTaint(template.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.824 -0400", hash_original_method = "B53A9961D24B646CE17498A2E8FD8A6F", hash_generated_method = "EFDF58F9260C76D2C52AC9FBDC8F8405")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_762051373 = null; //Variable for return #1
        MessageFormat clone = (MessageFormat) super.clone();
        Format[] array = new Format[formats.length];
        {
            int i = formats.length;
            {
                {
                    array[i] = (Format) formats[i].clone();
                } //End block
            } //End block
        } //End collapsed parenthetic
        clone.formats = array;
        varB4EAC82CA7396A68D541C85D26508E83_762051373 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_762051373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_762051373;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.825 -0400", hash_original_method = "2E70B47400B10858E99F75E16A06D539", hash_generated_method = "D820DCC8C91D3DDE8091267817D78800")
    @Override
    public boolean equals(Object object) {
        MessageFormat format = (MessageFormat) object;
        {
            int i = 0;
        } //End collapsed parenthetic
        boolean varA649D10E111C585C8EA57029692B0506_1085304543 = (locale.equals(format.locale)
                && Arrays.equals(strings, format.strings)
                && Arrays.equals(formats, format.formats));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841155164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_841155164;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.831 -0400", hash_original_method = "2F36A5BCF5EDBC18FDC7136A6298BFC9", hash_generated_method = "B41F4E3647D98074CF09C1A4D7DDEA82")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1971665116 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        StringBuffer buffer = new StringBuffer();
        ArrayList<FieldContainer> fields = new ArrayList<FieldContainer>();
        formatImpl((Object[]) object, buffer, new FieldPosition(0), fields);
        AttributedString as = new AttributedString(buffer.toString());
        {
            Iterator<FieldContainer> varD56559809A91B868170A31CFE0D36FBD_657768966 = (fields).iterator();
            varD56559809A91B868170A31CFE0D36FBD_657768966.hasNext();
            FieldContainer fc = varD56559809A91B868170A31CFE0D36FBD_657768966.next();
            {
                as.addAttribute(fc.attribute, fc.value, fc.start, fc.end);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1971665116 = as.getIterator();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1971665116.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1971665116;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.831 -0400", hash_original_method = "A9B03AC07F14FDC18F9B212B66591284", hash_generated_method = "5E4595864F53F4B3FF5AC895136809EF")
    public final StringBuffer format(Object[] objects, StringBuffer buffer,
            FieldPosition field) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_553445028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_553445028 = formatImpl(objects, buffer, field, null);
        addTaint(objects[0].getTaint());
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_553445028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_553445028;
        // ---------- Original Method ----------
        //return formatImpl(objects, buffer, field, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.832 -0400", hash_original_method = "CB09F1AB0972A7396E3B2DB81FB1793E", hash_generated_method = "90D73073D1994CE35E632694F9D478EF")
    private StringBuffer formatImpl(Object[] objects, StringBuffer buffer,
            FieldPosition position, List<FieldContainer> fields) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_958957542 = null; //Variable for return #1
        FieldPosition passedField = new FieldPosition(0);
        {
            int i = 0;
            {
                buffer.append(strings[i]);
                int begin = buffer.length();
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
                Format format = formats[i];
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
                    String result = format.format(arg);
                    MessageFormat mf = new MessageFormat(result);
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
        varB4EAC82CA7396A68D541C85D26508E83_958957542 = buffer;
        addTaint(objects[0].getTaint());
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        addTaint(fields.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_958957542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_958957542;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.833 -0400", hash_original_method = "C43D87ABB966C2154325453E86772F9C", hash_generated_method = "D32060405BEAF24AFF00E3E6DF6DE089")
    private void handleArgumentField(int begin, int end, int argIndex,
            FieldPosition position, List<FieldContainer> fields) {
        {
            fields.add(new FieldContainer(begin, end, Field.ARGUMENT, Integer.valueOf(argIndex)));
        } //End block
        {
            {
                boolean varBC49BD907E1C43C27CEFD8A151C51509_1613143125 = (position != null
                    && position.getFieldAttribute() == Field.ARGUMENT
                    && position.getEndIndex() == 0);
                {
                    position.setBeginIndex(begin);
                    position.setEndIndex(end);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(begin);
        addTaint(end);
        addTaint(argIndex);
        addTaint(position.getTaint());
        addTaint(fields.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.833 -0400", hash_original_method = "DE679CD49EEE558B2CA2B7C9C9DE5810", hash_generated_method = "1FE803F8DA666267E7E15439A2282A19")
    private void handleFormat(Format format, Object arg, int begin, List<FieldContainer> fields) {
        AttributedCharacterIterator iterator = format.formatToCharacterIterator(arg);
        {
            boolean varD77FF4806191D69BA2B31700FC241E51_261182281 = (iterator.getIndex() != iterator.getEndIndex());
            {
                int start = iterator.getRunStart();
                int end = iterator.getRunLimit();
                Iterator<?> it = iterator.getAttributes().keySet().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_808415902 = (it.hasNext());
                    {
                        AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute) it.next();
                        Object value = iterator.getAttribute(attribute);
                        fields.add(new FieldContainer(begin + start, begin + end, attribute, value));
                    } //End block
                } //End collapsed parenthetic
                iterator.setIndex(end);
            } //End block
        } //End collapsed parenthetic
        addTaint(format.getTaint());
        addTaint(arg.getTaint());
        addTaint(begin);
        addTaint(fields.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.834 -0400", hash_original_method = "86D79FEBC73D19AFFF1CE089D06D0A2E", hash_generated_method = "DD7F6C1AEACD5A7F6251EDDA56185D45")
    @Override
    public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_185322237 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_185322237 = format((Object[]) object, buffer, field);
        addTaint(object.getTaint());
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_185322237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185322237;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.834 -0400", hash_original_method = "7EB79515AF02A4588C0D82DEFC2945FA", hash_generated_method = "64130A62B1B273909EDF3ABE800A489C")
    public Format[] getFormats() {
        Format[] varB4EAC82CA7396A68D541C85D26508E83_373127566 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_373127566 = formats.clone();
        varB4EAC82CA7396A68D541C85D26508E83_373127566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_373127566;
        // ---------- Original Method ----------
        //return formats.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.835 -0400", hash_original_method = "6305A24530517BEB5A0FB94704F4E840", hash_generated_method = "883D4F268FD292403B3106B0672BAE68")
    public Format[] getFormatsByArgumentIndex() {
        Format[] varB4EAC82CA7396A68D541C85D26508E83_864498221 = null; //Variable for return #1
        Format[] answer = new Format[maxArgumentIndex + 1];
        {
            int i = 0;
            {
                answer[argumentNumbers[i]] = formats[i];
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_864498221 = answer;
        varB4EAC82CA7396A68D541C85D26508E83_864498221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_864498221;
        // ---------- Original Method ----------
        //Format[] answer = new Format[maxArgumentIndex + 1];
        //for (int i = 0; i < maxOffset + 1; i++) {
            //answer[argumentNumbers[i]] = formats[i];
        //}
        //return answer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.836 -0400", hash_original_method = "A090F158D8C76258E8307612B54D8E7F", hash_generated_method = "E1BCB6FA3665DA88B4548C6777FE1693")
    public void setFormatByArgumentIndex(int argIndex, Format format) {
        {
            int i = 0;
            {
                {
                    formats[i] = format;
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(argIndex);
        // ---------- Original Method ----------
        //for (int i = 0; i < maxOffset + 1; i++) {
            //if (argumentNumbers[i] == argIndex) {
                //formats[i] = format;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.836 -0400", hash_original_method = "A9324DA1CAF88845D05BF77827620ABB", hash_generated_method = "C09BE2CB24674B40BF88B6EFB676DC75")
    public void setFormatsByArgumentIndex(Format[] formats) {
        {
            int j = 0;
            {
                {
                    int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.837 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "9CC1CAC547F44274695808C9B9C1A15A")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_641987852 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_641987852 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_641987852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_641987852;
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.839 -0400", hash_original_method = "C3648461AA348ABE73C14E89998C9B55", hash_generated_method = "292B87DF8A3E92AAC464D7B113B8B063")
    @Override
    public int hashCode() {
        int hashCode = 0;
        {
            int i = 0;
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
            int var6D36F62AEE3C06A81D4EF3D0DF59FC8E_1681068896 = (hashCode + locale.hashCode());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202264053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1202264053;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.840 -0400", hash_original_method = "EC21A725ACD65B59B44C587C03791CB0", hash_generated_method = "4AD6266A7A5385A968699B9926992D85")
    public Object[] parse(String string) throws ParseException {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_88424268 = null; //Variable for return #1
        ParsePosition position = new ParsePosition(0);
        Object[] result = parse(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_697978992 = (position.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Parse failure", position.getErrorIndex());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_88424268 = result;
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_88424268.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_88424268;
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(0);
        //Object[] result = parse(string, position);
        //if (position.getIndex() == 0) {
            //throw new ParseException("Parse failure", position.getErrorIndex());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.843 -0400", hash_original_method = "D7228DDFC0E7ACF8FDCF2D792E0983E6", hash_generated_method = "88D5530E3F17686DCE2BD481D909389B")
    public Object[] parse(String string, ParsePosition position) {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1808242384 = null; //Variable for return #1
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1343875294 = null; //Variable for return #2
        Object[] varB4EAC82CA7396A68D541C85D26508E83_654362362 = null; //Variable for return #3
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1987228110 = null; //Variable for return #4
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1467440137 = null; //Variable for return #5
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1616193149 = null; //Variable for return #6
        {
            varB4EAC82CA7396A68D541C85D26508E83_1808242384 = EmptyArray.OBJECT;
        } //End block
        ParsePosition internalPos = new ParsePosition(0);
        int offset = position.getIndex();
        Object[] result = new Object[maxArgumentIndex + 1];
        {
            int i = 0;
            {
                String sub = strings[i];
                {
                    boolean var5EDB83E3A79DDC5A7BCBE1521980F15A_2033418481 = (!string.startsWith(sub, offset));
                    {
                        position.setErrorIndex(offset);
                        varB4EAC82CA7396A68D541C85D26508E83_1343875294 = null;
                    } //End block
                } //End collapsed parenthetic
                offset += sub.length();
                Object parse;
                Format format = formats[i];
                {
                    {
                        int next = string.indexOf(strings[i + 1], offset);
                        {
                            position.setErrorIndex(offset);
                            varB4EAC82CA7396A68D541C85D26508E83_654362362 = null;
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
                        boolean var6308E1130EB2D8DEA892A2D901A9133A_1222365940 = (internalPos.getErrorIndex() != -1);
                        {
                            position.setErrorIndex(offset);
                            varB4EAC82CA7396A68D541C85D26508E83_1987228110 = null;
                        } //End block
                    } //End collapsed parenthetic
                    offset = internalPos.getIndex();
                } //End block
                result[argumentNumbers[i]] = parse;
            } //End block
        } //End collapsed parenthetic
        {
            String sub = strings[maxOffset + 1];
            {
                boolean var53E87A64A12D1F228CD5107F6DBE8253_992150092 = (!string.startsWith(sub, offset));
                {
                    position.setErrorIndex(offset);
                    varB4EAC82CA7396A68D541C85D26508E83_1467440137 = null;
                } //End block
            } //End collapsed parenthetic
            offset += sub.length();
        } //End block
        position.setIndex(offset);
        varB4EAC82CA7396A68D541C85D26508E83_1616193149 = result;
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Object[] varA7E53CE21691AB073D9660D615818899_2026946228; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2026946228 = varB4EAC82CA7396A68D541C85D26508E83_1808242384;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2026946228 = varB4EAC82CA7396A68D541C85D26508E83_1343875294;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2026946228 = varB4EAC82CA7396A68D541C85D26508E83_654362362;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2026946228 = varB4EAC82CA7396A68D541C85D26508E83_1987228110;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2026946228 = varB4EAC82CA7396A68D541C85D26508E83_1467440137;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2026946228 = varB4EAC82CA7396A68D541C85D26508E83_1616193149;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2026946228.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2026946228;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.844 -0400", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "832170758C443CD7ACD0EDAFD70160D3")
    @Override
    public Object parseObject(String string, ParsePosition position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1165288639 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1165288639 = parse(string, position);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1165288639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1165288639;
        // ---------- Original Method ----------
        //return parse(string, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.845 -0400", hash_original_method = "F0EBB1D410262325E53A6EB4F51F6A54", hash_generated_method = "65946CA781FC54024586CBC67F64D98E")
    private int match(String string, ParsePosition position, boolean last,
            String[] tokens) {
        int length = string.length();
        int offset = position.getIndex();
        int token = -1;
        {
            boolean var14D87D9C20C010057079C6E91BCB7C21_484670643 = (offset < length && Character.isWhitespace(string.charAt(offset)));
        } //End collapsed parenthetic
        {
            int i = tokens.length;
            {
                {
                    boolean var11649D62D50616747009CD13B3D32DAF_671231420 = (string.regionMatches(true, offset, tokens[i], 0, tokens[i]
                    .length()));
                    {
                        token = i;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        offset += tokens[token].length();
        {
            boolean var14D87D9C20C010057079C6E91BCB7C21_1148907601 = (offset < length && Character.isWhitespace(string.charAt(offset)));
        } //End collapsed parenthetic
        char ch;
        {
            boolean var43CB108BDDFC8FD2BA0FBF20522C5046_1498546309 = (offset < length
                && ((ch = string.charAt(offset)) == '}' || (!last && ch == ',')));
            {
                position.setIndex(offset + 1);
            } //End block
        } //End collapsed parenthetic
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        addTaint(last);
        addTaint(tokens[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375831714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375831714;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.847 -0400", hash_original_method = "C959BA9FF5D67B6099707C942E630082", hash_generated_method = "93CD594825F7953D7B130FBC3960158E")
    private Format parseVariable(String string, ParsePosition position) {
        Format varB4EAC82CA7396A68D541C85D26508E83_1347232617 = null; //Variable for return #1
        Format varB4EAC82CA7396A68D541C85D26508E83_1799234076 = null; //Variable for return #2
        Format varB4EAC82CA7396A68D541C85D26508E83_2044841303 = null; //Variable for return #3
        Format varB4EAC82CA7396A68D541C85D26508E83_1482723014 = null; //Variable for return #4
        Format varB4EAC82CA7396A68D541C85D26508E83_1780856069 = null; //Variable for return #5
        Format varB4EAC82CA7396A68D541C85D26508E83_1348950195 = null; //Variable for return #6
        Format varB4EAC82CA7396A68D541C85D26508E83_104650491 = null; //Variable for return #7
        Format varB4EAC82CA7396A68D541C85D26508E83_188245679 = null; //Variable for return #8
        Format varB4EAC82CA7396A68D541C85D26508E83_953200383 = null; //Variable for return #9
        Format varB4EAC82CA7396A68D541C85D26508E83_57056300 = null; //Variable for return #10
        int length = string.length();
        int offset = position.getIndex();
        char ch;
        {
            boolean var4DEA603935E11831D4046087BD6EF808_1629877636 = (offset >= length || ((ch = string.charAt(offset++)) != '}' && ch != ','));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Missing element format");
            } //End block
        } //End collapsed parenthetic
        position.setIndex(offset);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1347232617 = null;
        } //End block
        int type = match(string, position, false,
                new String[] { "time", "date", "number", "choice" });
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown element format");
        } //End block
        StringBuffer buffer = new StringBuffer();
        ch = string.charAt(position.getIndex() - 1);
        //Begin case 0 1 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1799234076 = type == 1 ? DateFormat.getDateInstance(
                            DateFormat.DEFAULT, locale) : DateFormat
                            .getTimeInstance(DateFormat.DEFAULT, locale);
        } //End block
        //End case 0 1 
        //Begin case 0 1 
        int dateStyle = match(string, position, true,
                        new String[] { "full", "long", "medium", "short" });
        //End case 0 1 
        //Begin case 0 1 
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
            varB4EAC82CA7396A68D541C85D26508E83_2044841303 = new SimpleDateFormat(buffer.toString(), locale);
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
        varB4EAC82CA7396A68D541C85D26508E83_1482723014 = type == 1 ? DateFormat
                        .getDateInstance(dateStyle, locale) : DateFormat
                        .getTimeInstance(dateStyle, locale);
        //End case 0 1 
        //Begin case 2 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1780856069 = NumberFormat.getInstance(locale);
        } //End block
        //End case 2 
        //Begin case 2 
        int numberStyle = match(string, position, true,
                        new String[] { "currency", "percent", "integer" });
        //End case 2 
        //Begin case 2 
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
            varB4EAC82CA7396A68D541C85D26508E83_1348950195 = new DecimalFormat(buffer.toString(),
                            new DecimalFormatSymbols(locale));
        } //End block
        //End case 2 
        //Begin case 2 
        //Begin case 0 
        varB4EAC82CA7396A68D541C85D26508E83_104650491 = NumberFormat.getCurrencyInstance(locale);
        //End case 0 
        //Begin case 1 
        varB4EAC82CA7396A68D541C85D26508E83_188245679 = NumberFormat.getPercentInstance(locale);
        //End case 1 
        //End case 2 
        //Begin case 2 
        varB4EAC82CA7396A68D541C85D26508E83_953200383 = NumberFormat.getIntegerInstance(locale);
        //End case 2 
        try 
        {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
        } //End block
        catch (IllegalArgumentException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_57056300 = new ChoiceFormat(buffer.toString());
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Format varA7E53CE21691AB073D9660D615818899_1469551168; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_1347232617;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_1799234076;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_2044841303;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_1482723014;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_1780856069;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_1348950195;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_104650491;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_188245679;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_953200383;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1469551168 = varB4EAC82CA7396A68D541C85D26508E83_57056300;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1469551168.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1469551168;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.848 -0400", hash_original_method = "40ED9258145F8A9FA53AE23CC8BC5498", hash_generated_method = "F1F0700A79FE15C5103D16FF48D78E94")
    public void setFormat(int offset, Format format) {
        formats[offset] = format;
        // ---------- Original Method ----------
        //formats[offset] = format;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.848 -0400", hash_original_method = "F9E7D69C4CD5EB0783A6761389D5E01C", hash_generated_method = "E34E8DA745609AD0E7C98107DA6CDDA3")
    public void setFormats(Format[] formats) {
        int min = this.formats.length;
        {
            min = formats.length;
        } //End block
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.850 -0400", hash_original_method = "2EE5DAE8254A09BA3EE14891BDB8B487", hash_generated_method = "D7258DD4321DC22131F6C72F466A95D4")
    public void setLocale(Locale locale) {
        this.locale = locale;
        {
            int i = 0;
            {
                Format format = formats[i];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.852 -0400", hash_original_method = "BE681D9EC5F601D03AA4D2DED505610A", hash_generated_method = "33A58CF78FF6A5C3ED811C7BE2A50561")
    private String decodeDecimalFormat(StringBuffer buffer, Format format) {
        String varB4EAC82CA7396A68D541C85D26508E83_298790824 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_295430014 = null; //Variable for return #2
        buffer.append(",number");
        {
            boolean var6CEBA82DF33D1470AA1A059D1696D0E3_798493348 = (format.equals(NumberFormat.getNumberInstance(locale)));
            {
                boolean var192F3AD5A013893638F297627FF58BEA_787556787 = (format.equals(NumberFormat.getIntegerInstance(locale)));
                {
                    buffer.append(",integer");
                } //End block
                {
                    boolean varB450D48AC462C45AAA8E5DBE1D910862_948256635 = (format.equals(NumberFormat.getCurrencyInstance(locale)));
                    {
                        buffer.append(",currency");
                    } //End block
                    {
                        boolean var927C1C1A47036598E7859EB402797E4D_221086528 = (format.equals(NumberFormat.getPercentInstance(locale)));
                        {
                            buffer.append(",percent");
                        } //End block
                        {
                            buffer.append(',');
                            varB4EAC82CA7396A68D541C85D26508E83_298790824 = ((DecimalFormat) format).toPattern();
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_295430014 = null;
        addTaint(buffer.getTaint());
        addTaint(format.getTaint());
        String varA7E53CE21691AB073D9660D615818899_479195269; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_479195269 = varB4EAC82CA7396A68D541C85D26508E83_298790824;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_479195269 = varB4EAC82CA7396A68D541C85D26508E83_295430014;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_479195269.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_479195269;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.855 -0400", hash_original_method = "4C7466ADB5C592A5046867709A03D0C4", hash_generated_method = "9E584DAE8A6061081CA7FD77AF7438BF")
    private String decodeSimpleDateFormat(StringBuffer buffer, Format format) {
        String varB4EAC82CA7396A68D541C85D26508E83_452549233 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1575449640 = null; //Variable for return #2
        {
            boolean var5F4A480F42E5996FA52C1A9C5C3C999F_355898468 = (format.equals(DateFormat.getTimeInstance(DateFormat.DEFAULT, locale)));
            {
                buffer.append(",time");
            } //End block
            {
                boolean var43744F2D0FC6579BA743788AA995A096_742109879 = (format.equals(DateFormat.getDateInstance(DateFormat.DEFAULT,
                locale)));
                {
                    buffer.append(",date");
                } //End block
                {
                    boolean varB0EA48F2A2C11725E996E8BE46F7FF35_796195114 = (format.equals(DateFormat.getTimeInstance(DateFormat.SHORT,
                locale)));
                    {
                        buffer.append(",time,short");
                    } //End block
                    {
                        boolean var8246C8EFEACE2E9D9B1C8338079D58D9_286935885 = (format.equals(DateFormat.getDateInstance(DateFormat.SHORT,
                locale)));
                        {
                            buffer.append(",date,short");
                        } //End block
                        {
                            boolean varE7C95AEFF1DE05A7E96B5D0F7DAC387F_299758958 = (format.equals(DateFormat.getTimeInstance(DateFormat.LONG,
                locale)));
                            {
                                buffer.append(",time,long");
                            } //End block
                            {
                                boolean var317068F66FC22B2E0F3D063F7D154FF5_1872755210 = (format.equals(DateFormat.getDateInstance(DateFormat.LONG,
                locale)));
                                {
                                    buffer.append(",date,long");
                                } //End block
                                {
                                    boolean var3D572CFA72E81699C49F02EA1CE6BAF3_1231920193 = (format.equals(DateFormat.getTimeInstance(DateFormat.FULL,
                locale)));
                                    {
                                        buffer.append(",time,full");
                                    } //End block
                                    {
                                        boolean var78B2780CC51552A3F4971CA95E0BBF6A_1250314552 = (format.equals(DateFormat.getDateInstance(DateFormat.FULL,
                locale)));
                                        {
                                            buffer.append(",date,full");
                                        } //End block
                                        {
                                            buffer.append(",date,");
                                            varB4EAC82CA7396A68D541C85D26508E83_452549233 = ((SimpleDateFormat) format).toPattern();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1575449640 = null;
        addTaint(buffer.getTaint());
        addTaint(format.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1744502881; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1744502881 = varB4EAC82CA7396A68D541C85D26508E83_452549233;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1744502881 = varB4EAC82CA7396A68D541C85D26508E83_1575449640;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1744502881.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1744502881;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.857 -0400", hash_original_method = "0A7E6003101ED48A94DA0D4F2E79183E", hash_generated_method = "5746ABCA9ED098B1673982031103542B")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_1263668466 = null; //Variable for return #1
        StringBuffer buffer = new StringBuffer();
        {
            int i = 0;
            {
                appendQuoted(buffer, strings[i]);
                buffer.append('{');
                buffer.append(argumentNumbers[i]);
                Format format = formats[i];
                String pattern = null;
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
                    boolean quote = false;
                    int index = 0;
                    int length = pattern.length();
                    int count = 0;
                    {
                        char ch = pattern.charAt(index++);
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
        varB4EAC82CA7396A68D541C85D26508E83_1263668466 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1263668466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1263668466;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.858 -0400", hash_original_method = "6D428A023D401981380713AD4CDA7F82", hash_generated_method = "A092807C1D01D269E5FEE1B7295CFA5C")
    private void appendQuoted(StringBuffer buffer, String string) {
        int length = string.length();
        {
            int i = 0;
            {
                char ch = string.charAt(i);
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
        addTaint(buffer.getTaint());
        addTaint(string.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.859 -0400", hash_original_method = "9DFEE475D15759FEAAC0AFBD81E7E5BF", hash_generated_method = "5537AD38F40BA3C26D4B42EC45F24D35")
    private void writeObject(ObjectOutputStream stream) throws IOException {
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
        {
            int i = 0;
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
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.861 -0400", hash_original_method = "A9ED7844547D5D70718F3EA12242A430", hash_generated_method = "760427DD9FF1F2F46D56294DA337D29A")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        argumentNumbers = (int[]) fields.get("argumentNumbers", null);
        formats = (Format[]) fields.get("formats", null);
        locale = (Locale) fields.get("locale", null);
        maxOffset = fields.get("maxOffset", 0);
        int[] offsets = (int[]) fields.get("offsets", null);
        String pattern = (String) fields.get("pattern", null);
        int length;
        {
            length = pattern.length() > 0 ? 1 : 0;
        } //End block
        {
            length = maxOffset
                    + (offsets[maxOffset] == pattern.length() ? 1 : 2);
        } //End block
        strings = new String[length];
        int last = 0;
        {
            int i = 0;
            {
                strings[i] = pattern.substring(last, offsets[i]);
                last = offsets[i];
            } //End block
        } //End collapsed parenthetic
        {
            strings[strings.length - 1] = pattern.substring(last, pattern
                    .length());
        } //End block
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class FieldContainer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.862 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.862 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.862 -0400", hash_original_field = "D2EB444E35C0A71F0A85DF8194ACB5B6", hash_generated_field = "3C510FC4DA58A78E7F390C1B8DF1DA17")

        AttributedCharacterIterator.Attribute attribute;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.862 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.862 -0400", hash_original_method = "79F81C9DE3A6ED731ECF4F86681A281A", hash_generated_method = "2168FA24EBD30878F8A9FAB65C5466CD")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.863 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
        protected  Field(String fieldName) {
            super(fieldName);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.863 -0400", hash_original_field = "65742A0DA2D101A482A0847D5411F3C4", hash_generated_field = "82B93A1D640327089FF038CC1C876D1A")

        private static final long serialVersionUID = 7899943957617360810L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.863 -0400", hash_original_field = "D94CE10B685B435CA363911C15F03B9C", hash_generated_field = "BDDCF15FC3001123F8D4DF824E83B022")

        public static final Field ARGUMENT = new Field("message argument field");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.863 -0400", hash_original_field = "CF53E2BEFB2CA37DB3AE5D58546ECE7A", hash_generated_field = "DDAF9963C56DC8D3CC72243FA6D60F41")

    private static final long serialVersionUID = 6479157306784022952L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.863 -0400", hash_original_field = "48F92F66CE5FE41C558A38F296DF8082", hash_generated_field = "F3984ED43D46FE3C3FFDBA430A29142D")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("argumentNumbers", int[].class),
        new ObjectStreamField("formats", Format[].class),
        new ObjectStreamField("locale", Locale.class),
        new ObjectStreamField("maxOffset", int.class),
        new ObjectStreamField("offsets", int[].class),
        new ObjectStreamField("pattern", String.class),
    };
}

