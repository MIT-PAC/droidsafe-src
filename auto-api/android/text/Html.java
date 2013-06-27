package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.ccil.cowan.tagsoup.HTMLSchema;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.util.HashMap;

public class Html {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.909 -0400", hash_original_method = "488A9EC3609F7D856C4CDBBB151F13E2", hash_generated_method = "03497373D06A453313C747AE9BCD9BA5")
    private  Html() {
        // ---------- Original Method ----------
    }

    
        public static Spanned fromHtml(String source) {
        return fromHtml(source, null, null);
    }

    
        public static Spanned fromHtml(String source, ImageGetter imageGetter,
                                   TagHandler tagHandler) {
        Parser parser = new Parser();
        try {
            parser.setProperty(Parser.schemaProperty, HtmlParser.schema);
        } catch (org.xml.sax.SAXNotRecognizedException e) {
            throw new RuntimeException(e);
        } catch (org.xml.sax.SAXNotSupportedException e) {
            throw new RuntimeException(e);
        }
        HtmlToSpannedConverter converter =
                new HtmlToSpannedConverter(source, imageGetter, tagHandler,
                        parser);
        return converter.convert();
    }

    
        public static String toHtml(Spanned text) {
        StringBuilder out = new StringBuilder();
        withinHtml(out, text);
        return out.toString();
    }

    
        private static void withinHtml(StringBuilder out, Spanned text) {
        int len = text.length();
        int next;
        for (int i = 0; i < text.length(); i = next) {
            next = text.nextSpanTransition(i, len, ParagraphStyle.class);
            ParagraphStyle[] style = text.getSpans(i, next, ParagraphStyle.class);
            String elements = " ";
            boolean needDiv = false;
            for(int j = 0; j < style.length; j++) {
                if (style[j] instanceof AlignmentSpan) {
                    Layout.Alignment align = 
                        ((AlignmentSpan) style[j]).getAlignment();
                    needDiv = true;
                    if (align == Layout.Alignment.ALIGN_CENTER) {
                        elements = "align=\"center\" " + elements;
                    } else if (align == Layout.Alignment.ALIGN_OPPOSITE) {
                        elements = "align=\"right\" " + elements;
                    } else {
                        elements = "align=\"left\" " + elements;
                    }
                }
            }
            if (needDiv) {
                out.append("<div " + elements + ">");
            }
            withinDiv(out, text, i, next);
            if (needDiv) {
                out.append("</div>");
            }
        }
    }

    
        private static void withinDiv(StringBuilder out, Spanned text,
            int start, int end) {
        int next;
        for (int i = start; i < end; i = next) {
            next = text.nextSpanTransition(i, end, QuoteSpan.class);
            QuoteSpan[] quotes = text.getSpans(i, next, QuoteSpan.class);
            for (QuoteSpan quote: quotes) {
                out.append("<blockquote>");
            }
            withinBlockquote(out, text, i, next);
            for (QuoteSpan quote: quotes) {
                out.append("</blockquote>\n");
            }
        }
    }

    
        private static void withinBlockquote(StringBuilder out, Spanned text,
                                         int start, int end) {
        out.append("<p>");
        int next;
        for (int i = start; i < end; i = next) {
            next = TextUtils.indexOf(text, '\n', i, end);
            if (next < 0) {
                next = end;
            }
            int nl = 0;
            while (next < end && text.charAt(next) == '\n') {
                nl++;
                next++;
            }
            withinParagraph(out, text, i, next - nl, nl, next == end);
        }
        out.append("</p>\n");
    }

    
        private static void withinParagraph(StringBuilder out, Spanned text,
                                        int start, int end, int nl,
                                        boolean last) {
        int next;
        for (int i = start; i < end; i = next) {
            next = text.nextSpanTransition(i, end, CharacterStyle.class);
            CharacterStyle[] style = text.getSpans(i, next,
                                                   CharacterStyle.class);
            for (int j = 0; j < style.length; j++) {
                if (style[j] instanceof StyleSpan) {
                    int s = ((StyleSpan) style[j]).getStyle();
                    if ((s & Typeface.BOLD) != 0) {
                        out.append("<b>");
                    }
                    if ((s & Typeface.ITALIC) != 0) {
                        out.append("<i>");
                    }
                }
                if (style[j] instanceof TypefaceSpan) {
                    String s = ((TypefaceSpan) style[j]).getFamily();
                    if (s.equals("monospace")) {
                        out.append("<tt>");
                    }
                }
                if (style[j] instanceof SuperscriptSpan) {
                    out.append("<sup>");
                }
                if (style[j] instanceof SubscriptSpan) {
                    out.append("<sub>");
                }
                if (style[j] instanceof UnderlineSpan) {
                    out.append("<u>");
                }
                if (style[j] instanceof StrikethroughSpan) {
                    out.append("<strike>");
                }
                if (style[j] instanceof URLSpan) {
                    out.append("<a href=\"");
                    out.append(((URLSpan) style[j]).getURL());
                    out.append("\">");
                }
                if (style[j] instanceof ImageSpan) {
                    out.append("<img src=\"");
                    out.append(((ImageSpan) style[j]).getSource());
                    out.append("\">");
                    i = next;
                }
                if (style[j] instanceof AbsoluteSizeSpan) {
                    out.append("<font size =\"");
                    out.append(((AbsoluteSizeSpan) style[j]).getSize() / 6);
                    out.append("\">");
                }
                if (style[j] instanceof ForegroundColorSpan) {
                    out.append("<font color =\"#");
                    String color = Integer.toHexString(((ForegroundColorSpan)
                            style[j]).getForegroundColor() + 0x01000000);
                    while (color.length() < 6) {
                        color = "0" + color;
                    }
                    out.append(color);
                    out.append("\">");
                }
            }
            withinStyle(out, text, i, next);
            for (int j = style.length - 1; j >= 0; j--) {
                if (style[j] instanceof ForegroundColorSpan) {
                    out.append("</font>");
                }
                if (style[j] instanceof AbsoluteSizeSpan) {
                    out.append("</font>");
                }
                if (style[j] instanceof URLSpan) {
                    out.append("</a>");
                }
                if (style[j] instanceof StrikethroughSpan) {
                    out.append("</strike>");
                }
                if (style[j] instanceof UnderlineSpan) {
                    out.append("</u>");
                }
                if (style[j] instanceof SubscriptSpan) {
                    out.append("</sub>");
                }
                if (style[j] instanceof SuperscriptSpan) {
                    out.append("</sup>");
                }
                if (style[j] instanceof TypefaceSpan) {
                    String s = ((TypefaceSpan) style[j]).getFamily();
                    if (s.equals("monospace")) {
                        out.append("</tt>");
                    }
                }
                if (style[j] instanceof StyleSpan) {
                    int s = ((StyleSpan) style[j]).getStyle();
                    if ((s & Typeface.BOLD) != 0) {
                        out.append("</b>");
                    }
                    if ((s & Typeface.ITALIC) != 0) {
                        out.append("</i>");
                    }
                }
            }
        }
        String p = last ? "" : "</p>\n<p>";
        if (nl == 1) {
            out.append("<br>\n");
        } else if (nl == 2) {
            out.append(p);
        } else {
            for (int i = 2; i < nl; i++) {
                out.append("<br>");
            }
            out.append(p);
        }
    }

    
        private static void withinStyle(StringBuilder out, Spanned text,
                                    int start, int end) {
        for (int i = start; i < end; i++) {
            char c = text.charAt(i);
            if (c == '<') {
                out.append("&lt;");
            } else if (c == '>') {
                out.append("&gt;");
            } else if (c == '&') {
                out.append("&amp;");
            } else if (c > 0x7E || c < ' ') {
                out.append("&#" + ((int) c) + ";");
            } else if (c == ' ') {
                while (i + 1 < end && text.charAt(i + 1) == ' ') {
                    out.append("&nbsp;");
                    i++;
                }
                out.append(' ');
            } else {
                out.append(c);
            }
        }
    }

    
    private static class HtmlParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.927 -0400", hash_original_method = "2BD8172A597CA1F4EC32CC40B5134462", hash_generated_method = "2BD8172A597CA1F4EC32CC40B5134462")
        public HtmlParser ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.927 -0400", hash_original_field = "6E4DDA0794A1CCE8D6F2FA6811420D43", hash_generated_field = "5838079820125DB01686ED5C81751BAB")

        private static HTMLSchema schema = new HTMLSchema();
    }


    
    public static interface ImageGetter {
        
        public Drawable getDrawable(String source);
    }
    
    public static interface TagHandler {
        
        public void handleTag(boolean opening, String tag,
                                 Editable output, XMLReader xmlReader);
    }
    
}

class HtmlToSpannedConverter implements ContentHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.953 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "5EB2E77F51594E2C1DE90F3545DAFA8A")

    private String mSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.953 -0400", hash_original_field = "5424551D2079C84D9F9DE456A622364D", hash_generated_field = "9F664E317A344F99238051D2F1903E54")

    private XMLReader mReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.953 -0400", hash_original_field = "4B465DB347FF24306351EC1CAD85D0E6", hash_generated_field = "F52BFE7C8AABC90420173998C2780B6F")

    private SpannableStringBuilder mSpannableStringBuilder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.953 -0400", hash_original_field = "D6904A1F7372BFB73B20A639D27CE5A5", hash_generated_field = "BEF214E2C597894208A5D89455A16592")

    private Html.ImageGetter mImageGetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.953 -0400", hash_original_field = "7349FBA43B42948D8A0510E7FC223B0E", hash_generated_field = "11FCD8A3816FE593E534934FCEA6171D")

    private Html.TagHandler mTagHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.967 -0400", hash_original_method = "BFBE9CD4145DCE3991FF308298481129", hash_generated_method = "23D4FCF052973F1BD05CE2C9C4218B3E")
    public  HtmlToSpannedConverter(
            String source, Html.ImageGetter imageGetter, Html.TagHandler tagHandler,
            Parser parser) {
        mSource = source;
        mSpannableStringBuilder = new SpannableStringBuilder();
        mImageGetter = imageGetter;
        mTagHandler = tagHandler;
        mReader = parser;
        // ---------- Original Method ----------
        //mSource = source;
        //mSpannableStringBuilder = new SpannableStringBuilder();
        //mImageGetter = imageGetter;
        //mTagHandler = tagHandler;
        //mReader = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.976 -0400", hash_original_method = "E9DCA093295E5055C16F068195A6DE9F", hash_generated_method = "931D4A23EE072855AF5310CD30B0B09A")
    public Spanned convert() {
        Spanned varB4EAC82CA7396A68D541C85D26508E83_363668655 = null; //Variable for return #1
        mReader.setContentHandler(this);
        try 
        {
            mReader.parse(new InputSource(new StringReader(mSource)));
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        catch (SAXException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        Object[] obj;
        obj = mSpannableStringBuilder.getSpans(0, mSpannableStringBuilder.length(), ParagraphStyle.class);
        {
            int i;
            i = 0;
            {
                int start;
                start = mSpannableStringBuilder.getSpanStart(obj[i]);
                int end;
                end = mSpannableStringBuilder.getSpanEnd(obj[i]);
                {
                    {
                        boolean var716F8958D699C3D544224ADAF48BFCBA_1095317252 = (mSpannableStringBuilder.charAt(end - 1) == '\n' &&
                    mSpannableStringBuilder.charAt(end - 2) == '\n');
                    } //End collapsed parenthetic
                } //End block
                {
                    mSpannableStringBuilder.removeSpan(obj[i]);
                } //End block
                {
                    mSpannableStringBuilder.setSpan(obj[i], start, end, Spannable.SPAN_PARAGRAPH);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_363668655 = mSpannableStringBuilder;
        varB4EAC82CA7396A68D541C85D26508E83_363668655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_363668655;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.978 -0400", hash_original_method = "D9F0F9B119583626825989DD5C2C535C", hash_generated_method = "9DECB2B0EA12599A5F6A5808B52B3781")
    private void handleStartTag(String tag, Attributes attributes) {
        {
            boolean var57A2353F0195A760F3120898165F6EA4_1075856245 = (tag.equalsIgnoreCase("br"));
            {
                boolean var1F0B931F68E02F4B2BF58F33EF2E156C_1808697147 = (tag.equalsIgnoreCase("p"));
                {
                    handleP(mSpannableStringBuilder);
                } //End block
                {
                    boolean var19C918E43201EC22B7B6DB02B72DE5B8_922349277 = (tag.equalsIgnoreCase("div"));
                    {
                        handleP(mSpannableStringBuilder);
                    } //End block
                    {
                        boolean var5151B7FECFE28D253B355C3B2974606B_1049041666 = (tag.equalsIgnoreCase("strong"));
                        {
                            start(mSpannableStringBuilder, new Bold());
                        } //End block
                        {
                            boolean varF1110B9C6F8D35B519CC4C091E12B52F_58650905 = (tag.equalsIgnoreCase("b"));
                            {
                                start(mSpannableStringBuilder, new Bold());
                            } //End block
                            {
                                boolean var3CC3277E9E14A6D42305C53ECC316837_845794815 = (tag.equalsIgnoreCase("em"));
                                {
                                    start(mSpannableStringBuilder, new Italic());
                                } //End block
                                {
                                    boolean var776EA7735AD2143B53E5A4E343741CF4_432985409 = (tag.equalsIgnoreCase("cite"));
                                    {
                                        start(mSpannableStringBuilder, new Italic());
                                    } //End block
                                    {
                                        boolean var6B2DBF912EBE3FB506C1B9BD8646C397_667505408 = (tag.equalsIgnoreCase("dfn"));
                                        {
                                            start(mSpannableStringBuilder, new Italic());
                                        } //End block
                                        {
                                            boolean var228054E982F6964C38947AD2E275B043_1804018131 = (tag.equalsIgnoreCase("i"));
                                            {
                                                start(mSpannableStringBuilder, new Italic());
                                            } //End block
                                            {
                                                boolean varA80484FAF7DA24FED004D22F0C75A187_1991054185 = (tag.equalsIgnoreCase("big"));
                                                {
                                                    start(mSpannableStringBuilder, new Big());
                                                } //End block
                                                {
                                                    boolean var98C02BB504930A45B94739781B848355_1619051402 = (tag.equalsIgnoreCase("small"));
                                                    {
                                                        start(mSpannableStringBuilder, new Small());
                                                    } //End block
                                                    {
                                                        boolean var2DDBEAB56702C208098AA7037A784BDC_1446290924 = (tag.equalsIgnoreCase("font"));
                                                        {
                                                            startFont(mSpannableStringBuilder, attributes);
                                                        } //End block
                                                        {
                                                            boolean var3B99ABCA36391C4F88F05090BA03A8C2_559311632 = (tag.equalsIgnoreCase("blockquote"));
                                                            {
                                                                handleP(mSpannableStringBuilder);
                                                                start(mSpannableStringBuilder, new Blockquote());
                                                            } //End block
                                                            {
                                                                boolean var93C70F85AC549217F8C5A3F6739D0C32_1467848100 = (tag.equalsIgnoreCase("tt"));
                                                                {
                                                                    start(mSpannableStringBuilder, new Monospace());
                                                                } //End block
                                                                {
                                                                    boolean var758F09D2541583CACC63FDA8A4AAFD62_739994488 = (tag.equalsIgnoreCase("a"));
                                                                    {
                                                                        startA(mSpannableStringBuilder, attributes);
                                                                    } //End block
                                                                    {
                                                                        boolean var96C3E44C7108BC6AD081BBF129F6A269_1860683073 = (tag.equalsIgnoreCase("u"));
                                                                        {
                                                                            start(mSpannableStringBuilder, new Underline());
                                                                        } //End block
                                                                        {
                                                                            boolean var8274A80A7CECB4C9BE83FFF7CA89B885_1691988406 = (tag.equalsIgnoreCase("sup"));
                                                                            {
                                                                                start(mSpannableStringBuilder, new Super());
                                                                            } //End block
                                                                            {
                                                                                boolean var30431EF8926D39F930CB68D182B5832A_1710779012 = (tag.equalsIgnoreCase("sub"));
                                                                                {
                                                                                    start(mSpannableStringBuilder, new Sub());
                                                                                } //End block
                                                                                {
                                                                                    boolean varC0AAE376FA82D90C4B32912FEBDC9403_1515059412 = (tag.length() == 2 &&
                   Character.toLowerCase(tag.charAt(0)) == 'h' &&
                   tag.charAt(1) >= '1' && tag.charAt(1) <= '6');
                                                                                    {
                                                                                        handleP(mSpannableStringBuilder);
                                                                                        start(mSpannableStringBuilder, new Header(tag.charAt(1) - '1'));
                                                                                    } //End block
                                                                                    {
                                                                                        boolean var614EE65A4F09D51A07720962715D70BC_1572128310 = (tag.equalsIgnoreCase("img"));
                                                                                        {
                                                                                            startImg(mSpannableStringBuilder, attributes, mImageGetter);
                                                                                        } //End block
                                                                                        {
                                                                                            mTagHandler.handleTag(true, tag, mSpannableStringBuilder, mReader);
                                                                                        } //End block
                                                                                    } //End collapsed parenthetic
                                                                                } //End collapsed parenthetic
                                                                            } //End collapsed parenthetic
                                                                        } //End collapsed parenthetic
                                                                    } //End collapsed parenthetic
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(tag.getTaint());
        addTaint(attributes.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:39.994 -0400", hash_original_method = "6B986DC33BF60A186B7109194B660A70", hash_generated_method = "4E5BFF93242E1CC4908E5860FA331D38")
    private void handleEndTag(String tag) {
        {
            boolean var57A2353F0195A760F3120898165F6EA4_193093906 = (tag.equalsIgnoreCase("br"));
            {
                handleBr(mSpannableStringBuilder);
            } //End block
            {
                boolean var1F0B931F68E02F4B2BF58F33EF2E156C_648134878 = (tag.equalsIgnoreCase("p"));
                {
                    handleP(mSpannableStringBuilder);
                } //End block
                {
                    boolean var19C918E43201EC22B7B6DB02B72DE5B8_1962746644 = (tag.equalsIgnoreCase("div"));
                    {
                        handleP(mSpannableStringBuilder);
                    } //End block
                    {
                        boolean var5151B7FECFE28D253B355C3B2974606B_952958007 = (tag.equalsIgnoreCase("strong"));
                        {
                            end(mSpannableStringBuilder, Bold.class, new StyleSpan(Typeface.BOLD));
                        } //End block
                        {
                            boolean varF1110B9C6F8D35B519CC4C091E12B52F_163339634 = (tag.equalsIgnoreCase("b"));
                            {
                                end(mSpannableStringBuilder, Bold.class, new StyleSpan(Typeface.BOLD));
                            } //End block
                            {
                                boolean var3CC3277E9E14A6D42305C53ECC316837_377034978 = (tag.equalsIgnoreCase("em"));
                                {
                                    end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
                                } //End block
                                {
                                    boolean var776EA7735AD2143B53E5A4E343741CF4_2130998397 = (tag.equalsIgnoreCase("cite"));
                                    {
                                        end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
                                    } //End block
                                    {
                                        boolean var6B2DBF912EBE3FB506C1B9BD8646C397_1316348968 = (tag.equalsIgnoreCase("dfn"));
                                        {
                                            end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
                                        } //End block
                                        {
                                            boolean var228054E982F6964C38947AD2E275B043_113188084 = (tag.equalsIgnoreCase("i"));
                                            {
                                                end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
                                            } //End block
                                            {
                                                boolean varA80484FAF7DA24FED004D22F0C75A187_1150730657 = (tag.equalsIgnoreCase("big"));
                                                {
                                                    end(mSpannableStringBuilder, Big.class, new RelativeSizeSpan(1.25f));
                                                } //End block
                                                {
                                                    boolean var98C02BB504930A45B94739781B848355_406711705 = (tag.equalsIgnoreCase("small"));
                                                    {
                                                        end(mSpannableStringBuilder, Small.class, new RelativeSizeSpan(0.8f));
                                                    } //End block
                                                    {
                                                        boolean var2DDBEAB56702C208098AA7037A784BDC_738148572 = (tag.equalsIgnoreCase("font"));
                                                        {
                                                            endFont(mSpannableStringBuilder);
                                                        } //End block
                                                        {
                                                            boolean var3B99ABCA36391C4F88F05090BA03A8C2_1468810816 = (tag.equalsIgnoreCase("blockquote"));
                                                            {
                                                                handleP(mSpannableStringBuilder);
                                                                end(mSpannableStringBuilder, Blockquote.class, new QuoteSpan());
                                                            } //End block
                                                            {
                                                                boolean var93C70F85AC549217F8C5A3F6739D0C32_1470548061 = (tag.equalsIgnoreCase("tt"));
                                                                {
                                                                    end(mSpannableStringBuilder, Monospace.class,
                    new TypefaceSpan("monospace"));
                                                                } //End block
                                                                {
                                                                    boolean var758F09D2541583CACC63FDA8A4AAFD62_769628342 = (tag.equalsIgnoreCase("a"));
                                                                    {
                                                                        endA(mSpannableStringBuilder);
                                                                    } //End block
                                                                    {
                                                                        boolean var96C3E44C7108BC6AD081BBF129F6A269_387971712 = (tag.equalsIgnoreCase("u"));
                                                                        {
                                                                            end(mSpannableStringBuilder, Underline.class, new UnderlineSpan());
                                                                        } //End block
                                                                        {
                                                                            boolean var8274A80A7CECB4C9BE83FFF7CA89B885_56394575 = (tag.equalsIgnoreCase("sup"));
                                                                            {
                                                                                end(mSpannableStringBuilder, Super.class, new SuperscriptSpan());
                                                                            } //End block
                                                                            {
                                                                                boolean var30431EF8926D39F930CB68D182B5832A_1260130291 = (tag.equalsIgnoreCase("sub"));
                                                                                {
                                                                                    end(mSpannableStringBuilder, Sub.class, new SubscriptSpan());
                                                                                } //End block
                                                                                {
                                                                                    boolean varA6B2680B8AC78E6BB5781BA2C37ADB27_1925240846 = (tag.length() == 2 &&
                Character.toLowerCase(tag.charAt(0)) == 'h' &&
                tag.charAt(1) >= '1' && tag.charAt(1) <= '6');
                                                                                    {
                                                                                        handleP(mSpannableStringBuilder);
                                                                                        endHeader(mSpannableStringBuilder);
                                                                                    } //End block
                                                                                    {
                                                                                        mTagHandler.handleTag(false, tag, mSpannableStringBuilder, mReader);
                                                                                    } //End block
                                                                                } //End collapsed parenthetic
                                                                            } //End collapsed parenthetic
                                                                        } //End collapsed parenthetic
                                                                    } //End collapsed parenthetic
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void handleP(SpannableStringBuilder text) {
        int len = text.length();
        if (len >= 1 && text.charAt(len - 1) == '\n') {
            if (len >= 2 && text.charAt(len - 2) == '\n') {
                return;
            }
            text.append("\n");
            return;
        }
        if (len != 0) {
            text.append("\n\n");
        }
    }

    
        private static void handleBr(SpannableStringBuilder text) {
        text.append("\n");
    }

    
        private static Object getLast(Spanned text, Class kind) {
        Object[] objs = text.getSpans(0, text.length(), kind);
        if (objs.length == 0) {
            return null;
        } else {
            return objs[objs.length - 1];
        }
    }

    
        private static void start(SpannableStringBuilder text, Object mark) {
        int len = text.length();
        text.setSpan(mark, len, len, Spannable.SPAN_MARK_MARK);
    }

    
        private static void end(SpannableStringBuilder text, Class kind,
                            Object repl) {
        int len = text.length();
        Object obj = getLast(text, kind);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        if (where != len) {
            text.setSpan(repl, where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return;
    }

    
        private static void startImg(SpannableStringBuilder text,
                                 Attributes attributes, Html.ImageGetter img) {
        String src = attributes.getValue("", "src");
        Drawable d = null;
        if (img != null) {
            d = img.getDrawable(src);
        }
        if (d == null) {
            d = Resources.getSystem().
                    getDrawable(com.android.internal.R.drawable.unknown_image);
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        }
        int len = text.length();
        text.append("\uFFFC");
        text.setSpan(new ImageSpan(d, src), len, text.length(),
                     Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    
        private static void startFont(SpannableStringBuilder text,
                                  Attributes attributes) {
        String color = attributes.getValue("", "color");
        String face = attributes.getValue("", "face");
        int len = text.length();
        text.setSpan(new Font(color, face), len, len, Spannable.SPAN_MARK_MARK);
    }

    
        private static void endFont(SpannableStringBuilder text) {
        int len = text.length();
        Object obj = getLast(text, Font.class);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        if (where != len) {
            Font f = (Font) obj;
            if (!TextUtils.isEmpty(f.mColor)) {
                if (f.mColor.startsWith("@")) {
                    Resources res = Resources.getSystem();
                    String name = f.mColor.substring(1);
                    int colorRes = res.getIdentifier(name, "color", "android");
                    if (colorRes != 0) {
                        ColorStateList colors = res.getColorStateList(colorRes);
                        text.setSpan(new TextAppearanceSpan(null, 0, 0, colors, null),
                                where, len,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                } else {
                    int c = getHtmlColor(f.mColor);
                    if (c != -1) {
                        text.setSpan(new ForegroundColorSpan(c | 0xFF000000),
                                where, len,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }
            if (f.mFace != null) {
                text.setSpan(new TypefaceSpan(f.mFace), where, len,
                             Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    
        private static void startA(SpannableStringBuilder text, Attributes attributes) {
        String href = attributes.getValue("", "href");
        int len = text.length();
        text.setSpan(new Href(href), len, len, Spannable.SPAN_MARK_MARK);
    }

    
        private static void endA(SpannableStringBuilder text) {
        int len = text.length();
        Object obj = getLast(text, Href.class);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        if (where != len) {
            Href h = (Href) obj;
            if (h.mHref != null) {
                text.setSpan(new URLSpan(h.mHref), where, len,
                             Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    
        private static void endHeader(SpannableStringBuilder text) {
        int len = text.length();
        Object obj = getLast(text, Header.class);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        while (len > where && text.charAt(len - 1) == '\n') {
            len--;
        }
        if (where != len) {
            Header h = (Header) obj;
            text.setSpan(new RelativeSizeSpan(HEADER_SIZES[h.mLevel]),
                         where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            text.setSpan(new StyleSpan(Typeface.BOLD),
                         where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.040 -0400", hash_original_method = "764EC710ED4FDFB68C9E6FE9ED249649", hash_generated_method = "8982242C86C53DDD9F8374B3C93C1CFB")
    public void setDocumentLocator(Locator locator) {
        addTaint(locator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.040 -0400", hash_original_method = "FAA725B72A2ADC391C781CAB49B849AD", hash_generated_method = "F5ABC17320CB17FAFC02F6F62510312E")
    public void startDocument() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.041 -0400", hash_original_method = "08AD4CBC251CA96B103DE58FB6AA2921", hash_generated_method = "3ACBE0E14DE791A4A89F8374A54B4D72")
    public void endDocument() throws SAXException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.047 -0400", hash_original_method = "9A8DBFCDD6673580DBBCEDB8AE69733A", hash_generated_method = "D2DEDFEF366F67889D9FA3A94A552C63")
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.047 -0400", hash_original_method = "0E90E85A66154559EA3C98CC7177C34F", hash_generated_method = "5B3A24B5853AE441BDBBB759C4F775AE")
    public void endPrefixMapping(String prefix) throws SAXException {
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.053 -0400", hash_original_method = "5AB19A89F0F12F22375CE28650E01E88", hash_generated_method = "FEFD93DA174F6C9FD404CF8AC54BE6BA")
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        handleStartTag(localName, attributes);
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        addTaint(attributes.getTaint());
        // ---------- Original Method ----------
        //handleStartTag(localName, attributes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.057 -0400", hash_original_method = "56FD9F5B493653CBD1D9C50AD3B3D114", hash_generated_method = "4F704DBA969CA892291ECF12614508C3")
    public void endElement(String uri, String localName, String qName) throws SAXException {
        handleEndTag(localName);
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        // ---------- Original Method ----------
        //handleEndTag(localName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.059 -0400", hash_original_method = "CA8066E430EFB34465AFA28815B509C0", hash_generated_method = "91FDA37ED9AAA5E5BB82ACB0E45CF58E")
    public void characters(char ch[], int start, int length) throws SAXException {
        StringBuilder sb;
        sb = new StringBuilder();
        {
            int i;
            i = 0;
            {
                char c;
                c = ch[i + start];
                {
                    char pred;
                    int len;
                    len = sb.length();
                    {
                        len = mSpannableStringBuilder.length();
                        {
                            pred = '\n';
                        } //End block
                        {
                            pred = mSpannableStringBuilder.charAt(len - 1);
                        } //End block
                    } //End block
                    {
                        pred = sb.charAt(len - 1);
                    } //End block
                    {
                        sb.append(' ');
                    } //End block
                } //End block
                {
                    sb.append(c);
                } //End block
            } //End block
        } //End collapsed parenthetic
        mSpannableStringBuilder.append(sb);
        addTaint(ch);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.080 -0400", hash_original_method = "9049C36C2683070F72629A8BA1D4C193", hash_generated_method = "AC4E906A96FAEDE3FB1F8423BA319DB8")
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
        addTaint(ch);
        addTaint(start);
        addTaint(length);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.080 -0400", hash_original_method = "D7C64873BD0FC0A0449628F53B089507", hash_generated_method = "F156EAF285B0C46B9FE32434ED0F4856")
    public void processingInstruction(String target, String data) throws SAXException {
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.081 -0400", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "78177C3306D49108B776A6C694C380AB")
    public void skippedEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        private static HashMap<String,Integer> buildColorMap() {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("aqua", 0x00FFFF);
        map.put("black", 0x000000);
        map.put("blue", 0x0000FF);
        map.put("fuchsia", 0xFF00FF);
        map.put("green", 0x008000);
        map.put("grey", 0x808080);
        map.put("lime", 0x00FF00);
        map.put("maroon", 0x800000);
        map.put("navy", 0x000080);
        map.put("olive", 0x808000);
        map.put("purple", 0x800080);
        map.put("red", 0xFF0000);
        map.put("silver", 0xC0C0C0);
        map.put("teal", 0x008080);
        map.put("white", 0xFFFFFF);
        map.put("yellow", 0xFFFF00);
        return map;
    }

    
        private static int getHtmlColor(String color) {
        Integer i = COLORS.get(color.toLowerCase());
        if (i != null) {
            return i;
        } else {
            try {
                return XmlUtils.convertValueToInt(color, -1);
            } catch (NumberFormatException nfe) {
                return -1;
            }
        }
    }

    
    private static class Bold {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.081 -0400", hash_original_method = "360EF21B8D8783EFA444B4BE5FDC6AD7", hash_generated_method = "360EF21B8D8783EFA444B4BE5FDC6AD7")
        public Bold ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Italic {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.082 -0400", hash_original_method = "49A8CF03F12E3553DCC23BB27643EAFC", hash_generated_method = "49A8CF03F12E3553DCC23BB27643EAFC")
        public Italic ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Underline {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.084 -0400", hash_original_method = "84D51255F87B8DD26833841AC6851E69", hash_generated_method = "84D51255F87B8DD26833841AC6851E69")
        public Underline ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Big {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_method = "273608B63D858A3552D83E6F68A870F3", hash_generated_method = "273608B63D858A3552D83E6F68A870F3")
        public Big ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Small {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_method = "30BB2E22576FED131404001997B90E83", hash_generated_method = "30BB2E22576FED131404001997B90E83")
        public Small ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Monospace {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_method = "9E34A0C6710AE2CB78083EA433BD9375", hash_generated_method = "9E34A0C6710AE2CB78083EA433BD9375")
        public Monospace ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Blockquote {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_method = "8510635EE940E5512FA9DD7C2C1B8599", hash_generated_method = "8510635EE940E5512FA9DD7C2C1B8599")
        public Blockquote ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Super {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_method = "7F9EC2B6EDB6C576D6E7F20FD0DA4CCE", hash_generated_method = "7F9EC2B6EDB6C576D6E7F20FD0DA4CCE")
        public Super ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Sub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_method = "35CBF4C3F1CE0FC70451AFA9D19DB301", hash_generated_method = "35CBF4C3F1CE0FC70451AFA9D19DB301")
        public Sub ()
        {
            //Synthesized constructor
        }


    }


    
    private static class Font {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "2C22DB162080CAE82C8D78A913DED9F7")

        public String mColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.085 -0400", hash_original_field = "001A605783B748C535B6127A31F8F3EE", hash_generated_field = "9EF83681A7C49CB0E73C741AE3D0F05C")

        public String mFace;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.089 -0400", hash_original_method = "C4B068F2F67D5AD4645AF1A9761F50CA", hash_generated_method = "0045DC1451596B8D8072989C438E2861")
        public  Font(String color, String face) {
            mColor = color;
            mFace = face;
            // ---------- Original Method ----------
            //mColor = color;
            //mFace = face;
        }

        
    }


    
    private static class Href {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.090 -0400", hash_original_field = "CE33A8F3A41D743FE3E46C5E1C560A65", hash_generated_field = "2F16E5D3AF055919B45CF87232A38369")

        public String mHref;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.093 -0400", hash_original_method = "1859394720661AA4B03D475EFD821F3A", hash_generated_method = "41EF2A9AC6A4FA312215BBCF14E58CAD")
        public  Href(String href) {
            mHref = href;
            // ---------- Original Method ----------
            //mHref = href;
        }

        
    }


    
    private static class Header {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.094 -0400", hash_original_field = "D3512852EA3D6B78A96B5192CDA7B029", hash_generated_field = "75109DE7AA3B41B03299C7AED8804A2F")

        private int mLevel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.094 -0400", hash_original_method = "9C6EFC5AFAADDC937EF8FD6D30D1EF2D", hash_generated_method = "19FC55A0458E0C1D397B9A48B86FB54E")
        public  Header(int level) {
            mLevel = level;
            // ---------- Original Method ----------
            //mLevel = level;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.094 -0400", hash_original_field = "D49A5EA828DDE4A015E6CB159896312A", hash_generated_field = "AD02A2D2325E0296DACFC0EB9F2E508A")

    private static float[] HEADER_SIZES = {
        1.5f, 1.4f, 1.3f, 1.2f, 1.1f, 1f,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:40.094 -0400", hash_original_field = "5289A74433A08D80C65F1716485A5C4F", hash_generated_field = "B4FEF6E9838FF422A3FE4BD8FF30796B")

    private static HashMap<String,Integer> COLORS = buildColorMap();
}

