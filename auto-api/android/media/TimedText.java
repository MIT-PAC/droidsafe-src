package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.util.Log;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class TimedText {
    private Parcel mParcel = Parcel.obtain();
    private HashMap<Integer, Object> mKeyObjectMap =
            new HashMap<Integer, Object>();
    private int mDisplayFlags = -1;
    private int mBackgroundColorRGBA = -1;
    private int mHighlightColorRGBA = -1;
    private int mScrollDelay = -1;
    private int mWrapText = -1;
    private List<CharPos> mBlinkingPosList = null;
    private List<CharPos> mHighlightPosList = null;
    private List<Karaoke> mKaraokeList = null;
    private List<Font> mFontList = null;
    private List<Style> mStyleList = null;
    private List<HyperText> mHyperTextList = null;
    private TextPos mTextPos;
    private Justification mJustification;
    private Text mTextStruct;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.406 -0400", hash_original_method = "20C0CCB7F458006F6F50D13C409F05F4", hash_generated_method = "0E9D2CAD59722CD05A7580D41FE807C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimedText(byte[] obj) {
        dsTaint.addTaint(obj[0]);
        mParcel.unmarshall(obj, 0, obj.length);
        {
            boolean varA7BE52CD023CCCA664C249CA00EDD19B_945769577 = (!parseParcel());
            {
                mKeyObjectMap.clear();
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("parseParcel() fails");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mParcel.unmarshall(obj, 0, obj.length);
        //if (!parseParcel()) {
            //mKeyObjectMap.clear();
            //throw new IllegalArgumentException("parseParcel() fails");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.408 -0400", hash_original_method = "791BBBBBE0FA40697270B44A4D66C782", hash_generated_method = "DCBFCE0014024AED261BF2B6DA29CCC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean parseParcel() {
        mParcel.setDataPosition(0);
        {
            boolean var3DA3E405D5AB1A7186A8C8316A9DA671_1068367508 = (mParcel.dataAvail() == 0);
        } //End collapsed parenthetic
        int type;
        type = mParcel.readInt();
        {
            type = mParcel.readInt();
            int mStartTimeMs;
            mStartTimeMs = mParcel.readInt();
            mKeyObjectMap.put(type, mStartTimeMs);
            type = mParcel.readInt();
            mTextStruct = new Text();
            mTextStruct.textLen = mParcel.readInt();
            mTextStruct.text = mParcel.createByteArray();
            mKeyObjectMap.put(type, mTextStruct);
        } //End block
        {
            boolean varBAF5D3EDA0A71A0A6CF689BD42BC19A0_870739944 = (mParcel.dataAvail() > 0);
            {
                int key;
                key = mParcel.readInt();
                {
                    boolean varFE2C56858DAAF48135B2C5860FE7BD76_1438742656 = (!isValidKey(key));
                } //End collapsed parenthetic
                Object object;
                object = null;
                //Begin case KEY_STRUCT_STYLE_LIST 
                {
                    readStyle();
                    object = mStyleList;
                } //End block
                //End case KEY_STRUCT_STYLE_LIST 
                //Begin case KEY_STRUCT_FONT_LIST 
                {
                    readFont();
                    object = mFontList;
                } //End block
                //End case KEY_STRUCT_FONT_LIST 
                //Begin case KEY_STRUCT_HIGHLIGHT_LIST 
                {
                    readHighlight();
                    object = mHighlightPosList;
                } //End block
                //End case KEY_STRUCT_HIGHLIGHT_LIST 
                //Begin case KEY_STRUCT_KARAOKE_LIST 
                {
                    readKaraoke();
                    object = mKaraokeList;
                } //End block
                //End case KEY_STRUCT_KARAOKE_LIST 
                //Begin case KEY_STRUCT_HYPER_TEXT_LIST 
                {
                    readHyperText();
                    object = mHyperTextList;
                } //End block
                //End case KEY_STRUCT_HYPER_TEXT_LIST 
                //Begin case KEY_STRUCT_BLINKING_TEXT_LIST 
                {
                    readBlinkingText();
                    object = mBlinkingPosList;
                } //End block
                //End case KEY_STRUCT_BLINKING_TEXT_LIST 
                //Begin case KEY_WRAP_TEXT 
                {
                    mWrapText = mParcel.readInt();
                    object = mWrapText;
                } //End block
                //End case KEY_WRAP_TEXT 
                //Begin case KEY_HIGHLIGHT_COLOR_RGBA 
                {
                    mHighlightColorRGBA = mParcel.readInt();
                    object = mHighlightColorRGBA;
                } //End block
                //End case KEY_HIGHLIGHT_COLOR_RGBA 
                //Begin case KEY_DISPLAY_FLAGS 
                {
                    mDisplayFlags = mParcel.readInt();
                    object = mDisplayFlags;
                } //End block
                //End case KEY_DISPLAY_FLAGS 
                //Begin case KEY_STRUCT_JUSTIFICATION 
                {
                    mJustification = new Justification();
                    mJustification.horizontalJustification = mParcel.readInt();
                    mJustification.verticalJustification = mParcel.readInt();
                    object = mJustification;
                } //End block
                //End case KEY_STRUCT_JUSTIFICATION 
                //Begin case KEY_BACKGROUND_COLOR_RGBA 
                {
                    mBackgroundColorRGBA = mParcel.readInt();
                    object = mBackgroundColorRGBA;
                } //End block
                //End case KEY_BACKGROUND_COLOR_RGBA 
                //Begin case KEY_STRUCT_TEXT_POS 
                {
                    mTextPos = new TextPos();
                    mTextPos.top = mParcel.readInt();
                    mTextPos.left = mParcel.readInt();
                    mTextPos.bottom = mParcel.readInt();
                    mTextPos.right = mParcel.readInt();
                    object = mTextPos;
                } //End block
                //End case KEY_STRUCT_TEXT_POS 
                //Begin case KEY_SCROLL_DELAY 
                {
                    mScrollDelay = mParcel.readInt();
                    object = mScrollDelay;
                } //End block
                //End case KEY_SCROLL_DELAY 
                {
                    {
                        boolean var4B9B346590725B1F141DA1F903C95C1C_1012081622 = (mKeyObjectMap.containsKey(key));
                        {
                            mKeyObjectMap.remove(key);
                        } //End block
                    } //End collapsed parenthetic
                    mKeyObjectMap.put(key, object);
                } //End block
            } //End block
        } //End collapsed parenthetic
        mParcel.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.419 -0400", hash_original_method = "0BA14F4ADFDDDB9356E71AC4A1ECA0E9", hash_generated_method = "B7B1400820B5B14132089DB28A897F8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readStyle() {
        Style style;
        style = new Style();
        boolean endOfStyle;
        endOfStyle = false;
        {
            boolean varC93A85BC0C8D1601F387B6A79E35D212_1343125099 = (!endOfStyle && (mParcel.dataAvail() > 0));
            {
                int key;
                key = mParcel.readInt();
                //Begin case KEY_START_CHAR 
                {
                    style.startChar = mParcel.readInt();
                } //End block
                //End case KEY_START_CHAR 
                //Begin case KEY_END_CHAR 
                {
                    style.endChar = mParcel.readInt();
                } //End block
                //End case KEY_END_CHAR 
                //Begin case KEY_FONT_ID 
                {
                    style.fontID = mParcel.readInt();
                } //End block
                //End case KEY_FONT_ID 
                //Begin case KEY_STYLE_FLAGS 
                {
                    int flags;
                    flags = mParcel.readInt();
                    style.isBold = ((flags % 2) == 1);
                    style.isItalic = ((flags % 4) >= 2);
                    style.isUnderlined = ((flags / 4) == 1);
                } //End block
                //End case KEY_STYLE_FLAGS 
                //Begin case KEY_FONT_SIZE 
                {
                    style.fontSize = mParcel.readInt();
                } //End block
                //End case KEY_FONT_SIZE 
                //Begin case KEY_TEXT_COLOR_RGBA 
                {
                    style.colorRGBA = mParcel.readInt();
                } //End block
                //End case KEY_TEXT_COLOR_RGBA 
                //Begin case default 
                {
                    mParcel.setDataPosition(mParcel.dataPosition() - 4);
                    endOfStyle = true;
                } //End block
                //End case default 
            } //End block
        } //End collapsed parenthetic
        {
            mStyleList = new ArrayList<Style>();
        } //End block
        mStyleList.add(style);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.422 -0400", hash_original_method = "00AE5F5A406478801ABD16E12F474E1A", hash_generated_method = "DEEE62A70A3A7400D068F344AF41615D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readFont() {
        int entryCount;
        entryCount = mParcel.readInt();
        {
            int i;
            i = 0;
            {
                Font font;
                font = new Font();
                font.ID = mParcel.readInt();
                int nameLen;
                nameLen = mParcel.readInt();
                byte[] text;
                text = mParcel.createByteArray();
                font.name = new String(text, 0, nameLen);
                {
                    mFontList = new ArrayList<Font>();
                } //End block
                mFontList.add(font);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int entryCount = mParcel.readInt();
        //for (int i = 0; i < entryCount; i++) {
            //Font font = new Font();
            //font.ID = mParcel.readInt();
            //int nameLen = mParcel.readInt();
            //byte[] text = mParcel.createByteArray();
            //font.name = new String(text, 0, nameLen);
            //if (mFontList == null) {
                //mFontList = new ArrayList<Font>();
            //}
            //mFontList.add(font);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.425 -0400", hash_original_method = "89A8EBF8FEFD90B855BF480125FCEA6A", hash_generated_method = "EC0B0AE9E69211080A175CA7867BC1B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readHighlight() {
        CharPos pos;
        pos = new CharPos();
        pos.startChar = mParcel.readInt();
        pos.endChar = mParcel.readInt();
        {
            mHighlightPosList = new ArrayList<CharPos>();
        } //End block
        mHighlightPosList.add(pos);
        // ---------- Original Method ----------
        //CharPos pos = new CharPos();
        //pos.startChar = mParcel.readInt();
        //pos.endChar = mParcel.readInt();
        //if (mHighlightPosList == null) {
            //mHighlightPosList = new ArrayList<CharPos>();
        //}
        //mHighlightPosList.add(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.426 -0400", hash_original_method = "9FC931A03E07E67B33BB5A4FA8F46AC4", hash_generated_method = "0BEA423FD3EEEC04B17B84F849C85B3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readKaraoke() {
        int entryCount;
        entryCount = mParcel.readInt();
        {
            int i;
            i = 0;
            {
                Karaoke kara;
                kara = new Karaoke();
                kara.startTimeMs = mParcel.readInt();
                kara.endTimeMs = mParcel.readInt();
                kara.startChar = mParcel.readInt();
                kara.endChar = mParcel.readInt();
                {
                    mKaraokeList = new ArrayList<Karaoke>();
                } //End block
                mKaraokeList.add(kara);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int entryCount = mParcel.readInt();
        //for (int i = 0; i < entryCount; i++) {
            //Karaoke kara = new Karaoke();
            //kara.startTimeMs = mParcel.readInt();
            //kara.endTimeMs = mParcel.readInt();
            //kara.startChar = mParcel.readInt();
            //kara.endChar = mParcel.readInt();
            //if (mKaraokeList == null) {
                //mKaraokeList = new ArrayList<Karaoke>();
            //}
            //mKaraokeList.add(kara);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.427 -0400", hash_original_method = "76399CA140680AA49BE7C693D75B5452", hash_generated_method = "758772AF677E6FC052CA6554B4ECD3FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readHyperText() {
        HyperText hyperText;
        hyperText = new HyperText();
        hyperText.startChar = mParcel.readInt();
        hyperText.endChar = mParcel.readInt();
        int len;
        len = mParcel.readInt();
        byte[] url;
        url = mParcel.createByteArray();
        hyperText.URL = new String(url, 0, len);
        len = mParcel.readInt();
        byte[] alt;
        alt = mParcel.createByteArray();
        hyperText.altString = new String(alt, 0, len);
        {
            mHyperTextList = new ArrayList<HyperText>();
        } //End block
        mHyperTextList.add(hyperText);
        // ---------- Original Method ----------
        //HyperText hyperText = new HyperText();
        //hyperText.startChar = mParcel.readInt();
        //hyperText.endChar = mParcel.readInt();
        //int len = mParcel.readInt();
        //byte[] url = mParcel.createByteArray();
        //hyperText.URL = new String(url, 0, len);
        //len = mParcel.readInt();
        //byte[] alt = mParcel.createByteArray();
        //hyperText.altString = new String(alt, 0, len);
        //if (mHyperTextList == null) {
            //mHyperTextList = new ArrayList<HyperText>();
        //}
        //mHyperTextList.add(hyperText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.428 -0400", hash_original_method = "9C2885E2BFC08F88B4AF57AA760616C2", hash_generated_method = "ECA373147BC51B14D71FF9542E0454F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readBlinkingText() {
        CharPos blinkingPos;
        blinkingPos = new CharPos();
        blinkingPos.startChar = mParcel.readInt();
        blinkingPos.endChar = mParcel.readInt();
        {
            mBlinkingPosList = new ArrayList<CharPos>();
        } //End block
        mBlinkingPosList.add(blinkingPos);
        // ---------- Original Method ----------
        //CharPos blinkingPos = new CharPos();
        //blinkingPos.startChar = mParcel.readInt();
        //blinkingPos.endChar = mParcel.readInt();
        //if (mBlinkingPosList == null) {
            //mBlinkingPosList = new ArrayList<CharPos>();
        //}
        //mBlinkingPosList.add(blinkingPos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.430 -0400", hash_original_method = "9BAFED3979BE76875AB5C6D705EB5845", hash_generated_method = "B039ABAA8776CB619449E245DCE484AC")
    @DSModeled(DSC.SAFE)
    public boolean isValidKey(final int key) {
        dsTaint.addTaint(key);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!((key >= FIRST_PUBLIC_KEY) && (key <= LAST_PUBLIC_KEY))
                //&& !((key >= FIRST_PRIVATE_KEY) && (key <= LAST_PRIVATE_KEY))) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.430 -0400", hash_original_method = "9397D6B2A6748EB9B0D75013A7674AB7", hash_generated_method = "567A75847D2D3369672D30F94FB1FCF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(final int key) {
        dsTaint.addTaint(key);
        {
            boolean varC1468D584CEEEB9E99188FFDA1F84F95_410326347 = (isValidKey(key) && mKeyObjectMap.containsKey(key));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isValidKey(key) && mKeyObjectMap.containsKey(key)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.431 -0400", hash_original_method = "D714619D6E49B86D75D24C1705999B69", hash_generated_method = "D08CBFC408D082F440CA7C53B9D4D7C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set keySet() {
        Set varC54E841039A45FC2E5A4520E8124B494_1375442638 = (mKeyObjectMap.keySet());
        return (Set)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mKeyObjectMap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.431 -0400", hash_original_method = "E013B89BFA963BB8F029FE138EDADA51", hash_generated_method = "FB6E4B28FF917DBDD706F27828F9C82E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getObject(final int key) {
        dsTaint.addTaint(key);
        {
            boolean var3B6E1BB933E0B37C47D3FDDB37B7AB5D_258014195 = (containsKey(key));
            {
                Object varE907A9B53A7BAAD21C2E40F393B9CC93_270280134 = (mKeyObjectMap.get(key));
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid key: " + key);
            } //End block
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (containsKey(key)) {
            //return mKeyObjectMap.get(key);
        //} else {
            //throw new IllegalArgumentException("Invalid key: " + key);
        //}
    }

    
    public class Text {
        public int textLen;
        public byte[] text;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.431 -0400", hash_original_method = "3E1AB979E39DEC5F091AD71588A6931C", hash_generated_method = "922FB99CB23AA4250B8765DF5A1FEC0F")
        @DSModeled(DSC.SAFE)
        public Text() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class CharPos {
        public int startChar = -1;
        public int endChar = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.432 -0400", hash_original_method = "B16942A4D6AA45C219307E42B3F01C5E", hash_generated_method = "F71D3E39F8F9FA0E1A28D452EF3FE562")
        @DSModeled(DSC.SAFE)
        public CharPos() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class TextPos {
        public int top = -1;
        public int left = -1;
        public int bottom = -1;
        public int right = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.432 -0400", hash_original_method = "533CD86BF5A1B326154330F052078462", hash_generated_method = "3152B4C699CD5F269C29FE4769308AF8")
        @DSModeled(DSC.SAFE)
        public TextPos() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Justification {
        public int horizontalJustification = -1;
        public int verticalJustification = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.432 -0400", hash_original_method = "9DE1082C41237E4CAACC983D55330CCE", hash_generated_method = "26C09D2F4C5000E014367858AB5DB8E2")
        @DSModeled(DSC.SAFE)
        public Justification() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Style {
        public int startChar = -1;
        public int endChar = -1;
        public int fontID = -1;
        public boolean isBold = false;
        public boolean isItalic = false;
        public boolean isUnderlined = false;
        public int fontSize = -1;
        public int colorRGBA = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.432 -0400", hash_original_method = "A73FFEA889FA48444DBD29C5B6A4F060", hash_generated_method = "0FF6A793A759E36F2F6633297C092FE3")
        @DSModeled(DSC.SAFE)
        public Style() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Font {
        public int ID = -1;
        public String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.433 -0400", hash_original_method = "9DB8E4889CA776938A054F1FA406F93D", hash_generated_method = "42C8369941244D1B2850DE898FCFF61F")
        @DSModeled(DSC.SAFE)
        public Font() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Karaoke {
        public int startTimeMs = -1;
        public int endTimeMs = -1;
        public int startChar = -1;
        public int endChar = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.433 -0400", hash_original_method = "20387F8DBBE28B02B4D4A333BCD1DC01", hash_generated_method = "ECDF11726A4CDE2B715F6BEE4C8BE9B0")
        @DSModeled(DSC.SAFE)
        public Karaoke() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class HyperText {
        public int startChar = -1;
        public int endChar = -1;
        public String URL;
        public String altString;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.433 -0400", hash_original_method = "B6B5545C3ABD1F1E6601A7A1C2669923", hash_generated_method = "E874923A6E6E7A9905BA6F463A66E5CE")
        @DSModeled(DSC.SAFE)
        public HyperText() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static final int FIRST_PUBLIC_KEY                 = 1;
    public static final int KEY_DISPLAY_FLAGS                 = 1;
    public static final int KEY_STYLE_FLAGS                   = 2;
    public static final int KEY_BACKGROUND_COLOR_RGBA         = 3;
    public static final int KEY_HIGHLIGHT_COLOR_RGBA          = 4;
    public static final int KEY_SCROLL_DELAY                  = 5;
    public static final int KEY_WRAP_TEXT                     = 6;
    public static final int KEY_START_TIME                    = 7;
    public static final int KEY_STRUCT_BLINKING_TEXT_LIST     = 8;
    public static final int KEY_STRUCT_FONT_LIST              = 9;
    public static final int KEY_STRUCT_HIGHLIGHT_LIST         = 10;
    public static final int KEY_STRUCT_HYPER_TEXT_LIST        = 11;
    public static final int KEY_STRUCT_KARAOKE_LIST           = 12;
    public static final int KEY_STRUCT_STYLE_LIST             = 13;
    public static final int KEY_STRUCT_TEXT_POS               = 14;
    public static final int KEY_STRUCT_JUSTIFICATION          = 15;
    public static final int KEY_STRUCT_TEXT                   = 16;
    private static final int LAST_PUBLIC_KEY                  = 16;
    private static final int FIRST_PRIVATE_KEY                = 101;
    private static final int KEY_GLOBAL_SETTING               = 101;
    private static final int KEY_LOCAL_SETTING                = 102;
    private static final int KEY_START_CHAR                   = 103;
    private static final int KEY_END_CHAR                     = 104;
    private static final int KEY_FONT_ID                      = 105;
    private static final int KEY_FONT_SIZE                    = 106;
    private static final int KEY_TEXT_COLOR_RGBA              = 107;
    private static final int LAST_PRIVATE_KEY                 = 107;
    private static final String TAG = "TimedText";
}

