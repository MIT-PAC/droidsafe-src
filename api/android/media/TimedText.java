package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.util.Log;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class TimedText {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.325 -0400", hash_original_field = "EFA56283585F59792DE14EFDEC543EA6", hash_generated_field = "BB91EE8BB361270D3F9E96BDF275F77B")

    private Parcel mParcel = Parcel.obtain();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "91127D10B6A487857EC2F8B3C4A2AE31", hash_generated_field = "EC5144F1059594ED79C7BE9A57DB8642")

    private final HashMap<Integer, Object> mKeyObjectMap = new HashMap<Integer, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "847712F634A56039153E091BD6DBAA57", hash_generated_field = "80B2AE705A93483E0330D6F3D591DCEE")

    private int mDisplayFlags = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "64FA9D0B82223A8B2DE820BA77207A9A", hash_generated_field = "C453002A9E2C70445EB5199BE9B08059")

    private int mBackgroundColorRGBA = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "E0AA304F62D22150CE7AD9033BEA50CF", hash_generated_field = "31B8CD0D5AF7DFD87BA6E1CF70ABFB5F")

    private int mHighlightColorRGBA = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "611D19FD59318F3EBED8CC78E61A56A4", hash_generated_field = "6C96939CB5EB119D39955D86F77AB19B")

    private int mScrollDelay = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "6EE7B265D4790C4D83E14B22842F78B9", hash_generated_field = "036450566A3148835EE1A26286BC0ED1")

    private int mWrapText = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "E297F004D0467C4B5C9FE6EB85960265", hash_generated_field = "A15DDCA0E18A78ADEB869939295D7F43")

    private List<CharPos> mBlinkingPosList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "36D16BE4C3594F0C47638577621F9EB9", hash_generated_field = "DB74E93421E71106F88913A1AFB7B88A")

    private List<CharPos> mHighlightPosList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.326 -0400", hash_original_field = "96E8491BD3EFF28625800F20A5DC0D9D", hash_generated_field = "FB398A4A7BD2FF6E3F6566BBB16FE725")

    private List<Karaoke> mKaraokeList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.327 -0400", hash_original_field = "BC43D142703B15FDA071318A1B0E2DFC", hash_generated_field = "C1A505F457778FCB09CC9D54A415631E")

    private List<Font> mFontList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.327 -0400", hash_original_field = "0EB6184F5DAA62A2BA35D2D779DDDB75", hash_generated_field = "68E6863308C67DE90672639469C7B66A")

    private List<Style> mStyleList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.327 -0400", hash_original_field = "C2FFD8A568D14C913F52E923630CA7F8", hash_generated_field = "7D062F7EF76BD004C2E665883B094002")

    private List<HyperText> mHyperTextList = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.327 -0400", hash_original_field = "B4B254DE5E49EACB035A3B84E5ADBAAF", hash_generated_field = "1BF0EA15C173D16323FE9F74B1AD8364")

    private TextPos mTextPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.327 -0400", hash_original_field = "473F1C1E938D04968C439DCC201E9A05", hash_generated_field = "D18AAA756EFD16ACECFD20B5F9951651")

    private Justification mJustification;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.327 -0400", hash_original_field = "15EC26032C7DAE829A5B5B034AEDEF7A", hash_generated_field = "616503694D60DD8DA85A8F29EBD2A282")

    private Text mTextStruct;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.328 -0400", hash_original_method = "20C0CCB7F458006F6F50D13C409F05F4", hash_generated_method = "94150419739F59396CE5A8A52F4D9891")
    public  TimedText(byte[] obj) {
        addTaint(obj[0]);
        mParcel.unmarshall(obj, 0, obj.length);
        if(!parseParcel())        
        {
            mKeyObjectMap.clear();
            IllegalArgumentException varEDA0C29D002C2E6C68B5ACC851095771_1256103322 = new IllegalArgumentException("parseParcel() fails");
            varEDA0C29D002C2E6C68B5ACC851095771_1256103322.addTaint(taint);
            throw varEDA0C29D002C2E6C68B5ACC851095771_1256103322;
        } //End block
        // ---------- Original Method ----------
        //mParcel.unmarshall(obj, 0, obj.length);
        //if (!parseParcel()) {
            //mKeyObjectMap.clear();
            //throw new IllegalArgumentException("parseParcel() fails");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.332 -0400", hash_original_method = "791BBBBBE0FA40697270B44A4D66C782", hash_generated_method = "702AB57B428E3B5E666EE49FD17FAA3C")
    private boolean parseParcel() {
        mParcel.setDataPosition(0);
        if(mParcel.dataAvail() == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_19911986 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177744948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_177744948;
        } //End block
        int type = mParcel.readInt();
        if(type == KEY_LOCAL_SETTING)        
        {
            type = mParcel.readInt();
            if(type != KEY_START_TIME)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1784512130 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459497871 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459497871;
            } //End block
            int mStartTimeMs = mParcel.readInt();
            mKeyObjectMap.put(type, mStartTimeMs);
            type = mParcel.readInt();
            if(type != KEY_STRUCT_TEXT)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1079010822 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572370624 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_572370624;
            } //End block
            mTextStruct = new Text();
            mTextStruct.textLen = mParcel.readInt();
            mTextStruct.text = mParcel.createByteArray();
            mKeyObjectMap.put(type, mTextStruct);
        } //End block
        else
        if(type != KEY_GLOBAL_SETTING)        
        {
            boolean var68934A3E9455FA72420237EB05902327_43635970 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190663288 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190663288;
        } //End block
        while
(mParcel.dataAvail() > 0)        
        {
            int key = mParcel.readInt();
            if(!isValidKey(key))            
            {
                boolean var68934A3E9455FA72420237EB05902327_801066680 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806012229 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_806012229;
            } //End block
            Object object = null;
switch(key){
            case KEY_STRUCT_STYLE_LIST:
            {
                readStyle();
                object = mStyleList;
                break;
            } //End block
            case KEY_STRUCT_FONT_LIST:
            {
                readFont();
                object = mFontList;
                break;
            } //End block
            case KEY_STRUCT_HIGHLIGHT_LIST:
            {
                readHighlight();
                object = mHighlightPosList;
                break;
            } //End block
            case KEY_STRUCT_KARAOKE_LIST:
            {
                readKaraoke();
                object = mKaraokeList;
                break;
            } //End block
            case KEY_STRUCT_HYPER_TEXT_LIST:
            {
                readHyperText();
                object = mHyperTextList;
                break;
            } //End block
            case KEY_STRUCT_BLINKING_TEXT_LIST:
            {
                readBlinkingText();
                object = mBlinkingPosList;
                break;
            } //End block
            case KEY_WRAP_TEXT:
            {
                mWrapText = mParcel.readInt();
                object = mWrapText;
                break;
            } //End block
            case KEY_HIGHLIGHT_COLOR_RGBA:
            {
                mHighlightColorRGBA = mParcel.readInt();
                object = mHighlightColorRGBA;
                break;
            } //End block
            case KEY_DISPLAY_FLAGS:
            {
                mDisplayFlags = mParcel.readInt();
                object = mDisplayFlags;
                break;
            } //End block
            case KEY_STRUCT_JUSTIFICATION:
            {
                mJustification = new Justification();
                mJustification.horizontalJustification = mParcel.readInt();
                mJustification.verticalJustification = mParcel.readInt();
                object = mJustification;
                break;
            } //End block
            case KEY_BACKGROUND_COLOR_RGBA:
            {
                mBackgroundColorRGBA = mParcel.readInt();
                object = mBackgroundColorRGBA;
                break;
            } //End block
            case KEY_STRUCT_TEXT_POS:
            {
                mTextPos = new TextPos();
                mTextPos.top = mParcel.readInt();
                mTextPos.left = mParcel.readInt();
                mTextPos.bottom = mParcel.readInt();
                mTextPos.right = mParcel.readInt();
                object = mTextPos;
                break;
            } //End block
            case KEY_SCROLL_DELAY:
            {
                mScrollDelay = mParcel.readInt();
                object = mScrollDelay;
                break;
            } //End block
            default:
            {
                break;
            } //End block
}            if(object != null)            
            {
                if(mKeyObjectMap.containsKey(key))                
                {
                    mKeyObjectMap.remove(key);
                } //End block
                mKeyObjectMap.put(key, object);
            } //End block
        } //End block
        mParcel.recycle();
        boolean varB326B5062B2F0E69046810717534CB09_1618762500 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109871444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109871444;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.333 -0400", hash_original_method = "0BA14F4ADFDDDB9356E71AC4A1ECA0E9", hash_generated_method = "A91456EEC8ACCEF9DCB13CF6975F3CDA")
    private void readStyle() {
        Style style = new Style();
        boolean endOfStyle = false;
        while
(!endOfStyle && (mParcel.dataAvail() > 0))        
        {
            int key = mParcel.readInt();
switch(key){
            case KEY_START_CHAR:
            {
                style.startChar = mParcel.readInt();
                break;
            } //End block
            case KEY_END_CHAR:
            {
                style.endChar = mParcel.readInt();
                break;
            } //End block
            case KEY_FONT_ID:
            {
                style.fontID = mParcel.readInt();
                break;
            } //End block
            case KEY_STYLE_FLAGS:
            {
                int flags = mParcel.readInt();
                style.isBold = ((flags % 2) == 1);
                style.isItalic = ((flags % 4) >= 2);
                style.isUnderlined = ((flags / 4) == 1);
                break;
            } //End block
            case KEY_FONT_SIZE:
            {
                style.fontSize = mParcel.readInt();
                break;
            } //End block
            case KEY_TEXT_COLOR_RGBA:
            {
                style.colorRGBA = mParcel.readInt();
                break;
            } //End block
            default:
            {
                mParcel.setDataPosition(mParcel.dataPosition() - 4);
                endOfStyle = true;
                break;
            } //End block
}
        } //End block
        if(mStyleList == null)        
        {
            mStyleList = new ArrayList<Style>();
        } //End block
        mStyleList.add(style);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.334 -0400", hash_original_method = "00AE5F5A406478801ABD16E12F474E1A", hash_generated_method = "BF25CA6282179A61EA68F54E0A0FD519")
    private void readFont() {
        int entryCount = mParcel.readInt();
for(int i = 0;i < entryCount;i++)
        {
            Font font = new Font();
            font.ID = mParcel.readInt();
            int nameLen = mParcel.readInt();
            byte[] text = mParcel.createByteArray();
            font.name = new String(text, 0, nameLen);
            if(mFontList == null)            
            {
                mFontList = new ArrayList<Font>();
            } //End block
            mFontList.add(font);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.334 -0400", hash_original_method = "89A8EBF8FEFD90B855BF480125FCEA6A", hash_generated_method = "C31FC3E33FCE52C6F7898AC1605F5CE9")
    private void readHighlight() {
        CharPos pos = new CharPos();
        pos.startChar = mParcel.readInt();
        pos.endChar = mParcel.readInt();
        if(mHighlightPosList == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.335 -0400", hash_original_method = "9FC931A03E07E67B33BB5A4FA8F46AC4", hash_generated_method = "AB23D3EE9724A1192E0D1096FB25580E")
    private void readKaraoke() {
        int entryCount = mParcel.readInt();
for(int i = 0;i < entryCount;i++)
        {
            Karaoke kara = new Karaoke();
            kara.startTimeMs = mParcel.readInt();
            kara.endTimeMs = mParcel.readInt();
            kara.startChar = mParcel.readInt();
            kara.endChar = mParcel.readInt();
            if(mKaraokeList == null)            
            {
                mKaraokeList = new ArrayList<Karaoke>();
            } //End block
            mKaraokeList.add(kara);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.336 -0400", hash_original_method = "76399CA140680AA49BE7C693D75B5452", hash_generated_method = "6F0215116978816232DB154FE5DB67FA")
    private void readHyperText() {
        HyperText hyperText = new HyperText();
        hyperText.startChar = mParcel.readInt();
        hyperText.endChar = mParcel.readInt();
        int len = mParcel.readInt();
        byte[] url = mParcel.createByteArray();
        hyperText.URL = new String(url, 0, len);
        len = mParcel.readInt();
        byte[] alt = mParcel.createByteArray();
        hyperText.altString = new String(alt, 0, len);
        if(mHyperTextList == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.336 -0400", hash_original_method = "9C2885E2BFC08F88B4AF57AA760616C2", hash_generated_method = "F62C088DDC1EE11BF9577ED12F36FCDD")
    private void readBlinkingText() {
        CharPos blinkingPos = new CharPos();
        blinkingPos.startChar = mParcel.readInt();
        blinkingPos.endChar = mParcel.readInt();
        if(mBlinkingPosList == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.337 -0400", hash_original_method = "9BAFED3979BE76875AB5C6D705EB5845", hash_generated_method = "7FBC88907AA494A01D9B3E8F49BC9A82")
    public boolean isValidKey(final int key) {
        addTaint(key);
        if(!((key >= FIRST_PUBLIC_KEY) && (key <= LAST_PUBLIC_KEY))
                && !((key >= FIRST_PRIVATE_KEY) && (key <= LAST_PRIVATE_KEY)))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1982602735 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1441989327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1441989327;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_569171202 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062657402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062657402;
        // ---------- Original Method ----------
        //if (!((key >= FIRST_PUBLIC_KEY) && (key <= LAST_PUBLIC_KEY))
                //&& !((key >= FIRST_PRIVATE_KEY) && (key <= LAST_PRIVATE_KEY))) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.337 -0400", hash_original_method = "9397D6B2A6748EB9B0D75013A7674AB7", hash_generated_method = "0CE9E77813E4A851B5EEF73CE6931BFA")
    public boolean containsKey(final int key) {
        addTaint(key);
        if(isValidKey(key) && mKeyObjectMap.containsKey(key))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_531309825 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1756158855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1756158855;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_22835540 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913738079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913738079;
        // ---------- Original Method ----------
        //if (isValidKey(key) && mKeyObjectMap.containsKey(key)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.337 -0400", hash_original_method = "D714619D6E49B86D75D24C1705999B69", hash_generated_method = "4083F86FCC5677509C364C52BD4CF6EC")
    public Set keySet() {
Set varBBC4C0AAD9644B71B43DA8509843FD46_1233482818 =         mKeyObjectMap.keySet();
        varBBC4C0AAD9644B71B43DA8509843FD46_1233482818.addTaint(taint);
        return varBBC4C0AAD9644B71B43DA8509843FD46_1233482818;
        // ---------- Original Method ----------
        //return mKeyObjectMap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_method = "E013B89BFA963BB8F029FE138EDADA51", hash_generated_method = "6106DC3AA267491E5697A3993AB3CC9E")
    public Object getObject(final int key) {
        addTaint(key);
        if(containsKey(key))        
        {
Object var4F2B18D07722BAF49FA9B258E4A072EC_1525190307 =             mKeyObjectMap.get(key);
            var4F2B18D07722BAF49FA9B258E4A072EC_1525190307.addTaint(taint);
            return var4F2B18D07722BAF49FA9B258E4A072EC_1525190307;
        } //End block
        else
        {
            IllegalArgumentException var745A41FEF26C5745B86797818E5AD378_594606064 = new IllegalArgumentException("Invalid key: " + key);
            var745A41FEF26C5745B86797818E5AD378_594606064.addTaint(taint);
            throw var745A41FEF26C5745B86797818E5AD378_594606064;
        } //End block
        // ---------- Original Method ----------
        //if (containsKey(key)) {
            //return mKeyObjectMap.get(key);
        //} else {
            //throw new IllegalArgumentException("Invalid key: " + key);
        //}
    }

    
    public class Text {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "B64388B1F31130039E8B0E8BEF22D0BF", hash_generated_field = "0ECB483397C115F5BEBC3D12F8A4E7BA")

        public int textLen;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "9601616E43E4E097DEAC054F9AEDBD4F")

        public byte[] text;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_method = "3E1AB979E39DEC5F091AD71588A6931C", hash_generated_method = "922FB99CB23AA4250B8765DF5A1FEC0F")
        public  Text() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class CharPos {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "D2F7F619A7C88510A1B8A7C505C5E867", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "4B91C274C4FF5176F981FC75641BDD6A", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_method = "B16942A4D6AA45C219307E42B3F01C5E", hash_generated_method = "F71D3E39F8F9FA0E1A28D452EF3FE562")
        public  CharPos() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class TextPos {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "202B49903239C97060F2BFD90A1BB273", hash_generated_field = "C64E12BBD149C4BCB4C390DD3A4FF679")

        public int top = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "598133D176BB0642DF7FBFB040357CD7", hash_generated_field = "0F1BF7E12681395349F7DA55DB5AA159")

        public int left = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "1CDF0571EC7CBE9C09D2F8012A5CCFAB", hash_generated_field = "1067FFF30733E18F84211D17469C765B")

        public int bottom = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.338 -0400", hash_original_field = "99CE52C8A2BE7778385BF123896A795F", hash_generated_field = "DB264BE310D82168147D88131DA0FEBB")

        public int right = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_method = "533CD86BF5A1B326154330F052078462", hash_generated_method = "3152B4C699CD5F269C29FE4769308AF8")
        public  TextPos() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Justification {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "B6DE39E826DFB8EF13D0FE0C161D3803", hash_generated_field = "FEA5E3C4079F71C4123525CB7E2A737C")

        public int horizontalJustification = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "6947D55B898CD0D1B3F09DE0679F9AA6", hash_generated_field = "F401193FEE37D866191F6648D7A82D32")

        public int verticalJustification = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_method = "9DE1082C41237E4CAACC983D55330CCE", hash_generated_method = "26C09D2F4C5000E014367858AB5DB8E2")
        public  Justification() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Style {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "D2F7F619A7C88510A1B8A7C505C5E867", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "4B91C274C4FF5176F981FC75641BDD6A", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "7F78DBFFC3F884A0F7AEC3690CA05DE0", hash_generated_field = "D3DBED92BCC77A2766F38CBE573BA8FA")

        public int fontID = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "119D55CA0593FB3CBC790AC73E5A7B18", hash_generated_field = "DB5DB470B390D3AA5EC6FEED0BA82BC5")

        public boolean isBold = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "4F7AFA1D95E1BBB5DC50CEBC281FEF7B", hash_generated_field = "643A8D0A990D54B278905C83EA497448")

        public boolean isItalic = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "B8FC057A5EF1FAE55E8B8E29B7FCAC6B", hash_generated_field = "3D8C955C264DC3F085D41880E7F16D1D")

        public boolean isUnderlined = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "E355BBDEB89745362F5FC54472FDE493", hash_generated_field = "0041E0CA609906878711183AD327D4AD")

        public int fontSize = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "72F8FD02DD3A67E4452C03E56C0D8172", hash_generated_field = "ED3A4209C8320A0033FE8146EF308EE0")

        public int colorRGBA = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_method = "A73FFEA889FA48444DBD29C5B6A4F060", hash_generated_method = "0FF6A793A759E36F2F6633297C092FE3")
        public  Style() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Font {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "06FDB22A2A0C16BC99B5C96A2A921139", hash_generated_field = "BF5B80C071A192E34C9E8DFC1250E4D5")

        public int ID = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.339 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_method = "9DB8E4889CA776938A054F1FA406F93D", hash_generated_method = "42C8369941244D1B2850DE898FCFF61F")
        public  Font() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Karaoke {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "184B7606E3E7D92FCAA3EFB7950D814E", hash_generated_field = "A3ACF88B9728F52220895FE4A0056B40")

        public int startTimeMs = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "B355D4D7F16C9C62F4E2AE12B2941224", hash_generated_field = "87669B6E364BF92F363BC6940EA6244D")

        public int endTimeMs = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "D2F7F619A7C88510A1B8A7C505C5E867", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "4B91C274C4FF5176F981FC75641BDD6A", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_method = "20387F8DBBE28B02B4D4A333BCD1DC01", hash_generated_method = "ECDF11726A4CDE2B715F6BEE4C8BE9B0")
        public  Karaoke() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class HyperText {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "D2F7F619A7C88510A1B8A7C505C5E867", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "4B91C274C4FF5176F981FC75641BDD6A", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "E6B391A8D2C4D45902A23A8B6585703D", hash_generated_field = "31F0908C5724FBF0AFE05E1CB5F4B4DD")

        public String URL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "EF15C1D21462A1AB0FA40F5D4C577D5E", hash_generated_field = "D864AED02507FC933FD7E405F27F0330")

        public String altString;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_method = "B6B5545C3ABD1F1E6601A7A1C2669923", hash_generated_method = "E874923A6E6E7A9905BA6F463A66E5CE")
        public  HyperText() {
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "6362055D7C95A6FA7CD456C3F282749E", hash_generated_field = "E49CBDB7AE1F173AF5FB090FFC3C4FEB")

    private static final int FIRST_PUBLIC_KEY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "75ADA1ED2053BD4B9ADA5EA0C7D14392", hash_generated_field = "756BB9BF85C013682FF0E3FD9274AFE8")

    public static final int KEY_DISPLAY_FLAGS                 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "D08FE3935B26DF6615640DEE3908449A", hash_generated_field = "69B8F6A5FE4F2F2839EF6455F859A670")

    public static final int KEY_STYLE_FLAGS                   = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "37E64BF56417FA53DCA3E0C9F8189A3B", hash_generated_field = "FA331786EAA2BF7D9E250DD004CF64AE")

    public static final int KEY_BACKGROUND_COLOR_RGBA         = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.340 -0400", hash_original_field = "B7756372D446D769908CBB94DC9958BE", hash_generated_field = "909AC6DB5871265C59876AA1526B616E")

    public static final int KEY_HIGHLIGHT_COLOR_RGBA          = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "8EACD211C6B3D1F8742F1A97935839DE", hash_generated_field = "D76117D0D2E4C721C1D5C277CCE42E6C")

    public static final int KEY_SCROLL_DELAY                  = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "C2473E730E9B1808D389646F05D7443C", hash_generated_field = "459782586CD3A074DDF48E5ECA4E9DCA")

    public static final int KEY_WRAP_TEXT                     = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "EDA04ED6E315D1E678B239A667CA0F22", hash_generated_field = "AD8EBFAB35C49468949CD74B277805E1")

    public static final int KEY_START_TIME                    = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "4412377C70D9214F6D97E440F77B3A44", hash_generated_field = "757FC0BA5095E02F6EB5ADAD209562E8")

    public static final int KEY_STRUCT_BLINKING_TEXT_LIST     = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "D52F4572CD6C1F4C021C26565D78F9B6", hash_generated_field = "AE72EE439207D43E5B2F46673852ECD2")

    public static final int KEY_STRUCT_FONT_LIST              = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "D8BF73FCB8368218684B483C6CB420F2", hash_generated_field = "2B277711D2775F74051C742443DCE46B")

    public static final int KEY_STRUCT_HIGHLIGHT_LIST         = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "7B3DBF57F9BB1EE41E53F36AF2383DE5", hash_generated_field = "F1D15C21031656129FDB6A4824C5351E")

    public static final int KEY_STRUCT_HYPER_TEXT_LIST        = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "A4A42BFE0D38CDC4239690139F23344B", hash_generated_field = "7F78C6940BB6D4D1433A4A4A6DBB1BD6")

    public static final int KEY_STRUCT_KARAOKE_LIST           = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "A227068F7C5DE50377407B86EE1E7449", hash_generated_field = "46841B190A8AC2A913DD735B32102ACA")

    public static final int KEY_STRUCT_STYLE_LIST             = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "9D5BA478D37B75E901371F17F0B9A104", hash_generated_field = "A4C3426DBF4160840A50F43C5D8C1BB7")

    public static final int KEY_STRUCT_TEXT_POS               = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "E22C4B8723CDB0CEB839EACD640A515A", hash_generated_field = "02A63134903AB0332C4FB38E7F99C8A4")

    public static final int KEY_STRUCT_JUSTIFICATION          = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "B4AD4D2D8B51706426FDB39D223842B1", hash_generated_field = "A7D4F8A21510C2EF1D3DD4C9348F035F")

    public static final int KEY_STRUCT_TEXT                   = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "C79A6DF3ED7AD866FD468D34A525B1CD", hash_generated_field = "D6CDB3F416E9332C18F044FCED7C7805")

    private static final int LAST_PUBLIC_KEY = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "5CF721822DD2E8C27C2DD0B0B209190C", hash_generated_field = "2585FF6EA61E16643876449F9A8E9CF0")

    private static final int FIRST_PRIVATE_KEY = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "4C267415B0CA71283CE794DCABC9A84C", hash_generated_field = "3BEAA464DE02B03948AA76773D49F481")

    private static final int KEY_GLOBAL_SETTING = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "7E90A9377F48704533695A36F4B8B5C6", hash_generated_field = "AF786833E9592414AB3FACCD8D705017")

    private static final int KEY_LOCAL_SETTING = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "866A687E55D2FAAEDBD252FF526142F1", hash_generated_field = "4A3F4BC414F60AC34EF0A80D3741EBB0")

    private static final int KEY_START_CHAR = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "04E564511CD5A61CDDFAD93D07F8EEA7", hash_generated_field = "492BD1082B2F5D61A0061B00F3D402B9")

    private static final int KEY_END_CHAR = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "BCC2DF5438612BFA444CAA61DA798080", hash_generated_field = "876978FBD1B317FD3184FA7D8A52F286")

    private static final int KEY_FONT_ID = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "94AEBCDAA872B99EB8DCDF536F3B444E", hash_generated_field = "5D9D6ADAFA5F74ACEF0D43596D7D0699")

    private static final int KEY_FONT_SIZE = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "074E7E21DFAAD94FF13814AC483F7AB3", hash_generated_field = "E31A7E59F387C77F228551E51C68ADA8")

    private static final int KEY_TEXT_COLOR_RGBA = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "CBEF67078532E5D18B2F62E46F5FC603", hash_generated_field = "9E87440B093016A8A449C0F9FD5AC96B")

    private static final int LAST_PRIVATE_KEY = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.341 -0400", hash_original_field = "3495EE5D9E7777B35875E2B952E411B2", hash_generated_field = "EB79CC8B0353C1EBD30F062C0FE6F44E")

    private static final String TAG = "TimedText";
}

