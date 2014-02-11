package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;
import android.text.TextUtils;
import android.content.Context;
import java.util.StringTokenizer;
import android.util.DisplayMetrics;
import android.content.res.Resources;
import android.content.res.TypedArray;
public class Keyboard {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.209 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "35633BB7C9814BC2D57023D255065F26")

    private CharSequence mLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.210 -0400", hash_original_field = "C79D914900B3B6C61E5B360316CBA655", hash_generated_field = "5F4568A58D1E737D49746258688C1277")

    private int mDefaultHorizontalGap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.211 -0400", hash_original_field = "9F08E280D393D29F1CE1738D374DF945", hash_generated_field = "0870018EDF677D6343D4FAE3013D66CE")

    private int mDefaultWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.211 -0400", hash_original_field = "22A67E3B3D6F0C9D7F9CD85B78FCFD44", hash_generated_field = "3A61A555C05959D5D544DD18DBB7AD91")

    private int mDefaultHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.212 -0400", hash_original_field = "B90FCDDDE2B86F29C97A0A7D6A048733", hash_generated_field = "9C75615E36B248B31E2235084930D292")

    private int mDefaultVerticalGap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.216 -0400", hash_original_field = "8DD8BEF23C0B8C3B9264170C3AFE31E9", hash_generated_field = "ACBAF5D57607D656F9F647E4C35F69D9")

    private boolean mShifted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.217 -0400", hash_original_field = "1C10118944B85656CB6EA6807AF0F90E", hash_generated_field = "C85051C2C649D2F10F8E5691E0309897")

    private Key[] mShiftKeys = { null, null };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.218 -0400", hash_original_field = "BD5A5D9E486947BBC25BC2A27FA631F4", hash_generated_field = "8B53282977C674C80FAD40588AEFF788")

    private int[] mShiftKeyIndices = {-1, -1};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.218 -0400", hash_original_field = "A13C856DCF32E2DE8F8E28B43AEB8960", hash_generated_field = "50BE6AAE57532225B66631FDA07985B5")

    private int mKeyWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.219 -0400", hash_original_field = "5000093B703160E2B10399A649332620", hash_generated_field = "44D3637F32B768739C8E9B4609442E31")

    private int mKeyHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.219 -0400", hash_original_field = "8EF93AC90BB3417A4396010B3DF77EE9", hash_generated_field = "654E079B92E7410373504A7D3E2BCC8F")

    private int mTotalHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.220 -0400", hash_original_field = "9F615BB0FE3FE6CA5A459E9D388E8B15", hash_generated_field = "32AE931A04D85B3213606197A4E2BBD8")

    private int mTotalWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.220 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "26D67A00441EC3B025C2F111D0D83814")

    private List<Key> mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.221 -0400", hash_original_field = "EB992C27804728468955563475761618", hash_generated_field = "69ABAD8B2F373600D63E721106C79CE0")

    private List<Key> mModifierKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.221 -0400", hash_original_field = "544AEA79BB7B86F0CF2FB6DCE924CB76", hash_generated_field = "BF17CC98BE93BC48683121AAF3DC5E27")

    private int mDisplayWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.222 -0400", hash_original_field = "1C27B6DEF90015DC72D898616678AD85", hash_generated_field = "43C9EB41B54262FA581EF75713878DBE")

    private int mDisplayHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.222 -0400", hash_original_field = "23CF9C1CFA09FFE799D01E2919DC2CD1", hash_generated_field = "E9E8472CB906155C8F0CFC0D1EE9FF1D")

    private int mKeyboardMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.223 -0400", hash_original_field = "70DD66D07CF3B2896E68146E1CFB6D3B", hash_generated_field = "32F34551EB04BFF0177FB5C56295C8AF")

    private int mCellWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.224 -0400", hash_original_field = "70BA3FC74F803D7C02692DC05A99B85F", hash_generated_field = "E45B5AF8E83FE0EAEEDA2C7D26778933")

    private int mCellHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.224 -0400", hash_original_field = "DA5E15AAA6EAB030DECA18AA6AD79468", hash_generated_field = "77548ADBE35E708C9AF26A0BF8BA259F")

    private int[][] mGridNeighbors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.225 -0400", hash_original_field = "31BCF1AFB6C03815E5B2B18F5591EF09", hash_generated_field = "F939B6CC64FA51F8C34ABDCE9B9025CF")

    private int mProximityThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.225 -0400", hash_original_field = "0BE65860942E1AA096D4F6DDF317318D", hash_generated_field = "1A52F5EE0BF41D795B3415D02CCA2F26")

    private ArrayList<Row> rows = new ArrayList<Row>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.228 -0400", hash_original_method = "094A05122A351A181D6EFB292417974C", hash_generated_method = "F00A4A0F1D461896103C68447C71490B")
    public  Keyboard(Context context, int xmlLayoutResId) {
        this(context, xmlLayoutResId, 0);
        addTaint(xmlLayoutResId);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.237 -0400", hash_original_method = "FC11E9ED9DE485D5CB801CC8BD3E666A", hash_generated_method = "9889912C7E2959D4E63032A25674BD41")
    public  Keyboard(Context context, int xmlLayoutResId, int modeId, int width, int height) {
        addTaint(xmlLayoutResId);
        addTaint(context.getTaint());
        mDisplayWidth = width;
        mDisplayHeight = height;
        mDefaultHorizontalGap = 0;
        mDefaultWidth = mDisplayWidth / 10;
        mDefaultVerticalGap = 0;
        mDefaultHeight = mDefaultWidth;
        mKeys = new ArrayList<Key>();
        mModifierKeys = new ArrayList<Key>();
        mKeyboardMode = modeId;
        loadKeyboard(context, context.getResources().getXml(xmlLayoutResId));
        // ---------- Original Method ----------
        //mDisplayWidth = width;
        //mDisplayHeight = height;
        //mDefaultHorizontalGap = 0;
        //mDefaultWidth = mDisplayWidth / 10;
        //mDefaultVerticalGap = 0;
        //mDefaultHeight = mDefaultWidth;
        //mKeys = new ArrayList<Key>();
        //mModifierKeys = new ArrayList<Key>();
        //mKeyboardMode = modeId;
        //loadKeyboard(context, context.getResources().getXml(xmlLayoutResId));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.247 -0400", hash_original_method = "BBB05B12455B659AA4CB792848FE2BA1", hash_generated_method = "B75E4EF58CC6CBACD4AAB0037B8ED094")
    public  Keyboard(Context context, int xmlLayoutResId, int modeId) {
        addTaint(xmlLayoutResId);
        addTaint(context.getTaint());
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        mDisplayWidth = dm.widthPixels;
        mDisplayHeight = dm.heightPixels;
        mDefaultHorizontalGap = 0;
        mDefaultWidth = mDisplayWidth / 10;
        mDefaultVerticalGap = 0;
        mDefaultHeight = mDefaultWidth;
        mKeys = new ArrayList<Key>();
        mModifierKeys = new ArrayList<Key>();
        mKeyboardMode = modeId;
        loadKeyboard(context, context.getResources().getXml(xmlLayoutResId));
        // ---------- Original Method ----------
        //DisplayMetrics dm = context.getResources().getDisplayMetrics();
        //mDisplayWidth = dm.widthPixels;
        //mDisplayHeight = dm.heightPixels;
        //mDefaultHorizontalGap = 0;
        //mDefaultWidth = mDisplayWidth / 10;
        //mDefaultVerticalGap = 0;
        //mDefaultHeight = mDefaultWidth;
        //mKeys = new ArrayList<Key>();
        //mModifierKeys = new ArrayList<Key>();
        //mKeyboardMode = modeId;
        //loadKeyboard(context, context.getResources().getXml(xmlLayoutResId));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.264 -0400", hash_original_method = "397F7AF852698A44CD282AED80891D0E", hash_generated_method = "0DE680FB9B16F7C7AC7EF4C2039009D8")
    public  Keyboard(Context context, int layoutTemplateResId, 
            CharSequence characters, int columns, int horizontalPadding) {
        this(context, layoutTemplateResId);
        addTaint(horizontalPadding);
        addTaint(columns);
        addTaint(characters.getTaint());
        addTaint(layoutTemplateResId);
        addTaint(context.getTaint());
        int x = 0;
        int y = 0;
        int column = 0;
        mTotalWidth = 0;
        Row row = new Row(this);
        row.defaultHeight = mDefaultHeight;
        row.defaultWidth = mDefaultWidth;
        row.defaultHorizontalGap = mDefaultHorizontalGap;
        row.verticalGap = mDefaultVerticalGap;
        row.rowEdgeFlags = EDGE_TOP | EDGE_BOTTOM;
        final int maxColumns = columns == -1 ? Integer.MAX_VALUE : columns;
for(int i = 0;i < characters.length();i++)
        {
            char c = characters.charAt(i);
            if(column >= maxColumns 
                    || x + mDefaultWidth + horizontalPadding > mDisplayWidth)            
            {
                x = 0;
                y += mDefaultVerticalGap + mDefaultHeight;
                column = 0;
            } //End block
            final Key key = new Key(row);
            key.x = x;
            key.y = y;
            key.label = String.valueOf(c);
            key.codes = new int[] { c };
            column++;
            x += key.width + key.gap;
            mKeys.add(key);
            row.mKeys.add(key);
            if(x > mTotalWidth)            
            {
                mTotalWidth = x;
            } //End block
        } //End block
        mTotalHeight = y + mDefaultHeight;
        rows.add(row);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.273 -0400", hash_original_method = "4FB4FF088ED0C4D1CB4E59C58676D824", hash_generated_method = "8E9D337D5386C919F5772CEC1D08908C")
    final void resize(int newWidth, int newHeight) {
        addTaint(newHeight);
        int numRows = rows.size();
for(int rowIndex = 0;rowIndex < numRows;++rowIndex)
        {
            Row row = rows.get(rowIndex);
            int numKeys = row.mKeys.size();
            int totalGap = 0;
            int totalWidth = 0;
for(int keyIndex = 0;keyIndex < numKeys;++keyIndex)
            {
                Key key = row.mKeys.get(keyIndex);
                if(keyIndex > 0)                
                {
                    totalGap += key.gap;
                } //End block
                totalWidth += key.width;
            } //End block
            if(totalGap + totalWidth > newWidth)            
            {
                int x = 0;
                float scaleFactor = (float)(newWidth - totalGap) / totalWidth;
for(int keyIndex = 0;keyIndex < numKeys;++keyIndex)
                {
                    Key key = row.mKeys.get(keyIndex);
                    key.width *= scaleFactor;
                    key.x = x;
                    x += key.width + key.gap;
                } //End block
            } //End block
        } //End block
        mTotalWidth = newWidth;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.276 -0400", hash_original_method = "9C5EC889910FC63E2BE3F348DAE4AAAD", hash_generated_method = "6A1C99C56D0E6437E54B114688BD2F7B")
    public List<Key> getKeys() {
List<Key> var5AEE71826958DB6E612956708AF0BFCD_1356398994 =         mKeys;
        var5AEE71826958DB6E612956708AF0BFCD_1356398994.addTaint(taint);
        return var5AEE71826958DB6E612956708AF0BFCD_1356398994;
        // ---------- Original Method ----------
        //return mKeys;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.278 -0400", hash_original_method = "E40925805CEC2A064551415A821E0FB9", hash_generated_method = "4EAEA954F4A3DA048442B2088B01A4FA")
    public List<Key> getModifierKeys() {
List<Key> var8E2232677A0F8985EDE331E3DBDCDCE0_365756968 =         mModifierKeys;
        var8E2232677A0F8985EDE331E3DBDCDCE0_365756968.addTaint(taint);
        return var8E2232677A0F8985EDE331E3DBDCDCE0_365756968;
        // ---------- Original Method ----------
        //return mModifierKeys;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.279 -0400", hash_original_method = "55D65ED4C1F27D39714A25D8EDD1319F", hash_generated_method = "4C8C68526B6BC25E8E3A8A235A7C8E92")
    protected int getHorizontalGap() {
        int varC79D914900B3B6C61E5B360316CBA655_1518276091 = (mDefaultHorizontalGap);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67031310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_67031310;
        // ---------- Original Method ----------
        //return mDefaultHorizontalGap;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.281 -0400", hash_original_method = "4192371F5213E482193A428CA71C34EA", hash_generated_method = "452FA50DD6F5DC0602C2E1EC1C2FFD09")
    protected void setHorizontalGap(int gap) {
        mDefaultHorizontalGap = gap;
        // ---------- Original Method ----------
        //mDefaultHorizontalGap = gap;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.283 -0400", hash_original_method = "232957D9F7E6BFBC8E2B05B34F9668F2", hash_generated_method = "183A2F3999BC9AF05C99A33B35BEB238")
    protected int getVerticalGap() {
        int varB90FCDDDE2B86F29C97A0A7D6A048733_359082145 = (mDefaultVerticalGap);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952747180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952747180;
        // ---------- Original Method ----------
        //return mDefaultVerticalGap;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.285 -0400", hash_original_method = "598BAA2C92908786CB17AA934B082365", hash_generated_method = "BB777769CA689EA87D616F2789664971")
    protected void setVerticalGap(int gap) {
        mDefaultVerticalGap = gap;
        // ---------- Original Method ----------
        //mDefaultVerticalGap = gap;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.287 -0400", hash_original_method = "8CEE4CDE272B313204033BF04DE43200", hash_generated_method = "B8546B56780D6CDF2C569229B852DCAE")
    protected int getKeyHeight() {
        int var22A67E3B3D6F0C9D7F9CD85B78FCFD44_1819774508 = (mDefaultHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381482030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381482030;
        // ---------- Original Method ----------
        //return mDefaultHeight;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.289 -0400", hash_original_method = "E8399B39ECFD9C5BC5903E5145B67E65", hash_generated_method = "15727C77D45671C833AED60A4B45CC9A")
    protected void setKeyHeight(int height) {
        mDefaultHeight = height;
        // ---------- Original Method ----------
        //mDefaultHeight = height;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.295 -0400", hash_original_method = "68A61D79825E54979EFE7EA876A84FC9", hash_generated_method = "07F5C6C5B066899BBF1C90B31C61EA09")
    protected int getKeyWidth() {
        int var9F08E280D393D29F1CE1738D374DF945_1013774024 = (mDefaultWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101659811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101659811;
        // ---------- Original Method ----------
        //return mDefaultWidth;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.297 -0400", hash_original_method = "F6D0490D947FC5165E76986F052B51DE", hash_generated_method = "FEA2B57F93421C7445B7B9A839F3B3F1")
    protected void setKeyWidth(int width) {
        mDefaultWidth = width;
        // ---------- Original Method ----------
        //mDefaultWidth = width;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.298 -0400", hash_original_method = "D150DA54A75C2BA86B65582A3A41C5A6", hash_generated_method = "CA1DF79121F29C143D5A0F624251960C")
    public int getHeight() {
        int var8EF93AC90BB3417A4396010B3DF77EE9_1946702634 = (mTotalHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606736993 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606736993;
        // ---------- Original Method ----------
        //return mTotalHeight;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.300 -0400", hash_original_method = "113BBBBB846096B3AB050F232D720DB4", hash_generated_method = "99D0D64B620DE32CF993871A6278691F")
    public int getMinWidth() {
        int var9F615BB0FE3FE6CA5A459E9D388E8B15_910006225 = (mTotalWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013917798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013917798;
        // ---------- Original Method ----------
        //return mTotalWidth;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.304 -0400", hash_original_method = "16BA6B5E2038A1F5E624AA7B21CEE0CD", hash_generated_method = "2B947C7A811B823AB9B4073B6672987C")
    public boolean setShifted(boolean shiftState) {
for(Key shiftKey : mShiftKeys)
        {
            if(shiftKey != null)            
            {
                shiftKey.on = shiftState;
            } //End block
        } //End block
        if(mShifted != shiftState)        
        {
            mShifted = shiftState;
            boolean varB326B5062B2F0E69046810717534CB09_1412032703 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806455602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_806455602;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_612109561 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755467304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755467304;
        // ---------- Original Method ----------
        //for (Key shiftKey : mShiftKeys) {
            //if (shiftKey != null) {
                //shiftKey.on = shiftState;
            //}
        //}
        //if (mShifted != shiftState) {
            //mShifted = shiftState;
            //return true;
        //}
        //return false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.306 -0400", hash_original_method = "EACA0ECEFEB42C937A9D56634AD800E3", hash_generated_method = "CA066D08DCEED6E28DD125605FA1C382")
    public boolean isShifted() {
        boolean var8DD8BEF23C0B8C3B9264170C3AFE31E9_1086607596 = (mShifted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_148203100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_148203100;
        // ---------- Original Method ----------
        //return mShifted;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.308 -0400", hash_original_method = "91DF01E3B8C10F94CBF3B151E0DB8E32", hash_generated_method = "475718D9ADAC90FDEFDB8DE868F2D45D")
    public int[] getShiftKeyIndices() {
        int[] var16CC8CC8AD90E69615E18685CCE3D353_32761915 = (mShiftKeyIndices);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2049079110 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2049079110;
        // ---------- Original Method ----------
        //return mShiftKeyIndices;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.310 -0400", hash_original_method = "82B171C39309CF9EDE40413656430B43", hash_generated_method = "A2E685F250BC6E1E70B6308C7389D603")
    public int getShiftKeyIndex() {
        int var0902804C1B4968253FC8F47DBCBBE2B2_1576048204 = (mShiftKeyIndices[0]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603166888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603166888;
        // ---------- Original Method ----------
        //return mShiftKeyIndices[0];
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.320 -0400", hash_original_method = "B148C84FA2E3F9F5A1A02C8218F6C9F6", hash_generated_method = "25D85FE0AFD5DF95B315D8C3F8F56B28")
    private void computeNearestNeighbors() {
        mCellWidth = (getMinWidth() + GRID_WIDTH - 1) / GRID_WIDTH;
        mCellHeight = (getHeight() + GRID_HEIGHT - 1) / GRID_HEIGHT;
        mGridNeighbors = new int[GRID_SIZE][];
        int[] indices = new int[mKeys.size()];
        final int gridWidth = GRID_WIDTH * mCellWidth;
        final int gridHeight = GRID_HEIGHT * mCellHeight;
for(int x = 0;x < gridWidth;x += mCellWidth)
        {
for(int y = 0;y < gridHeight;y += mCellHeight)
            {
                int count = 0;
for(int i = 0;i < mKeys.size();i++)
                {
                    final Key key = mKeys.get(i);
                    if(key.squaredDistanceFrom(x, y) < mProximityThreshold ||
                            key.squaredDistanceFrom(x + mCellWidth - 1, y) < mProximityThreshold ||
                            key.squaredDistanceFrom(x + mCellWidth - 1, y + mCellHeight - 1) 
                                < mProximityThreshold ||
                            key.squaredDistanceFrom(x, y + mCellHeight - 1) < mProximityThreshold)                    
                    {
                        indices[count++] = i;
                    } //End block
                } //End block
                int [] cell = new int[count];
                System.arraycopy(indices, 0, cell, 0, count);
                mGridNeighbors[(y / mCellHeight) * GRID_WIDTH + (x / mCellWidth)] = cell;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.324 -0400", hash_original_method = "9099142BCFA8D4BBDACC6C89C180FADC", hash_generated_method = "AB115BD961CFFEA0C7C063CDBE8DE68B")
    public int[] getNearestKeys(int x, int y) {
        addTaint(y);
        addTaint(x);
        if(mGridNeighbors == null)        
        computeNearestNeighbors();
        if(x >= 0 && x < getMinWidth() && y >= 0 && y < getHeight())        
        {
            int index = (y / mCellHeight) * GRID_WIDTH + (x / mCellWidth);
            if(index < GRID_SIZE)            
            {
                int[] var113D4B10EAFB777944D74CA8420C5B84_1276333161 = (mGridNeighbors[index]);
                                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_90267714 = {getTaintInt()};
                return varB4CCCA26F9DB9189C32F33E82D425CFB_90267714;
            } //End block
        } //End block
        int[] varF2DAAF45A90510C85B6C1E6A026C33E3_1470495249 = (new int[0]);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_357981129 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_357981129;
        // ---------- Original Method ----------
        //if (mGridNeighbors == null) computeNearestNeighbors();
        //if (x >= 0 && x < getMinWidth() && y >= 0 && y < getHeight()) {
            //int index = (y / mCellHeight) * GRID_WIDTH + (x / mCellWidth);
            //if (index < GRID_SIZE) {
                //return mGridNeighbors[index];
            //}
        //}
        //return new int[0];
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.326 -0400", hash_original_method = "ADC7EEE1D5CC40EB06869D36925A8A51", hash_generated_method = "81D9E5A24B88775869E296BDCFC66B08")
    protected Row createRowFromXml(Resources res, XmlResourceParser parser) {
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
Row var7FB2305D944DF0E13CD0B9F32571CD82_217922640 =         new Row(res, this, parser);
        var7FB2305D944DF0E13CD0B9F32571CD82_217922640.addTaint(taint);
        return var7FB2305D944DF0E13CD0B9F32571CD82_217922640;
        // ---------- Original Method ----------
        //return new Row(res, this, parser);
    }
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.328 -0400", hash_original_method = "7C30A8D931433BEC83D450C4892EA38E", hash_generated_method = "065CFC740585DAAA22F517B11248C727")
    protected Key createKeyFromXml(Resources res, Row parent, int x, int y, 
            XmlResourceParser parser) {
        addTaint(parser.getTaint());
        addTaint(y);
        addTaint(x);
        addTaint(parent.getTaint());
        addTaint(res.getTaint());
Key varE985980EDE73F0AE27A28D587669E369_495507450 =         new Key(res, parent, x, y, parser);
        varE985980EDE73F0AE27A28D587669E369_495507450.addTaint(taint);
        return varE985980EDE73F0AE27A28D587669E369_495507450;
        // ---------- Original Method ----------
        //return new Key(res, parent, x, y, parser);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.341 -0400", hash_original_method = "0682C3FA4A49194161BF3A995754C5A7", hash_generated_method = "97A1C9A2834A8DBC5450342245B710F5")
    private void loadKeyboard(Context context, XmlResourceParser parser) {
        addTaint(parser.getTaint());
        addTaint(context.getTaint());
        boolean inKey = false;
        boolean inRow = false;
        boolean leftMostKey = false;
        int row = 0;
        int x = 0;
        int y = 0;
        Key key = null;
        Row currentRow = null;
        Resources res = context.getResources();
        boolean skipRow = false;
        try 
        {
            int event;
            while
((event = parser.next()) != XmlResourceParser.END_DOCUMENT)            
            {
                if(event == XmlResourceParser.START_TAG)                
                {
                    String tag = parser.getName();
                    if(TAG_ROW.equals(tag))                    
                    {
                        inRow = true;
                        x = 0;
                        currentRow = createRowFromXml(res, parser);
                        rows.add(currentRow);
                        skipRow = currentRow.mode != 0 && currentRow.mode != mKeyboardMode;
                        if(skipRow)                        
                        {
                            skipToEndOfRow(parser);
                            inRow = false;
                        } //End block
                    } //End block
                    else
                    if(TAG_KEY.equals(tag))                    
                    {
                        inKey = true;
                        key = createKeyFromXml(res, currentRow, x, y, parser);
                        mKeys.add(key);
                        if(key.codes[0] == KEYCODE_SHIFT)                        
                        {
for(int i = 0;i < mShiftKeys.length;i++)
                            {
                                if(mShiftKeys[i] == null)                                
                                {
                                    mShiftKeys[i] = key;
                                    mShiftKeyIndices[i] = mKeys.size()-1;
                                    break;
                                } //End block
                            } //End block
                            mModifierKeys.add(key);
                        } //End block
                        else
                        if(key.codes[0] == KEYCODE_ALT)                        
                        {
                            mModifierKeys.add(key);
                        } //End block
                        currentRow.mKeys.add(key);
                    } //End block
                    else
                    if(TAG_KEYBOARD.equals(tag))                    
                    {
                        parseKeyboardAttributes(res, parser);
                    } //End block
                } //End block
                else
                if(event == XmlResourceParser.END_TAG)                
                {
                    if(inKey)                    
                    {
                        inKey = false;
                        x += key.gap + key.width;
                        if(x > mTotalWidth)                        
                        {
                            mTotalWidth = x;
                        } //End block
                    } //End block
                    else
                    if(inRow)                    
                    {
                        inRow = false;
                        y += currentRow.verticalGap;
                        y += currentRow.defaultHeight;
                        row++;
                    } //End block
                    else
                    {
                    } //End block
                } //End block
            } //End block
        } //End block
        catch (Exception e)
        {
            e.printStackTrace();
        } //End block
        mTotalHeight = y - mDefaultVerticalGap;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.347 -0400", hash_original_method = "0E562BFCE15C1E3AC6B0A8EF6F890819", hash_generated_method = "DE299EB0C5B44C47D0ABD180617C2264")
    private void skipToEndOfRow(XmlResourceParser parser) throws XmlPullParserException, IOException {
        addTaint(parser.getTaint());
        int event;
        while
((event = parser.next()) != XmlResourceParser.END_DOCUMENT)        
        {
            if(event == XmlResourceParser.END_TAG 
                    && parser.getName().equals(TAG_ROW))            
            {
                break;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int event;
        //while ((event = parser.next()) != XmlResourceParser.END_DOCUMENT) {
            //if (event == XmlResourceParser.END_TAG 
                    //&& parser.getName().equals(TAG_ROW)) {
                //break;
            //}
        //}
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.353 -0400", hash_original_method = "215B5FFF32E25431B5AACD69551E6B9E", hash_generated_method = "512CB2503541FE767D96F3AF79B154B2")
    private void parseKeyboardAttributes(Resources res, XmlResourceParser parser) {
        addTaint(parser.getTaint());
        addTaint(res.getTaint());
        TypedArray a = res.obtainAttributes(Xml.asAttributeSet(parser), 
                com.android.internal.R.styleable.Keyboard);
        mDefaultWidth = getDimensionOrFraction(a,
                com.android.internal.R.styleable.Keyboard_keyWidth,
                mDisplayWidth, mDisplayWidth / 10);
        mDefaultHeight = getDimensionOrFraction(a,
                com.android.internal.R.styleable.Keyboard_keyHeight,
                mDisplayHeight, 50);
        mDefaultHorizontalGap = getDimensionOrFraction(a,
                com.android.internal.R.styleable.Keyboard_horizontalGap,
                mDisplayWidth, 0);
        mDefaultVerticalGap = getDimensionOrFraction(a,
                com.android.internal.R.styleable.Keyboard_verticalGap,
                mDisplayHeight, 0);
        mProximityThreshold = (int) (mDefaultWidth * SEARCH_DISTANCE);
        mProximityThreshold = mProximityThreshold * mProximityThreshold;
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
        @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    static int getDimensionOrFraction(TypedArray a, int index, int base, int defValue) {
        TypedValue value = a.peekValue(index);
        if (value == null) return defValue;
        if (value.type == TypedValue.TYPE_DIMENSION) {
            return a.getDimensionPixelOffset(index, defValue);
        } else if (value.type == TypedValue.TYPE_FRACTION) {
            return Math.round(a.getFraction(index, base, base, defValue));
        }
        return defValue;
    }
    
    public static class Row {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.355 -0400", hash_original_field = "B1A0839A70AFA61664B9A94F7B7C0F75", hash_generated_field = "A96204A8425B32C1F84986D87F5052CF")

        public int defaultWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.355 -0400", hash_original_field = "BF43DE06F94997B919153CC8773694DB", hash_generated_field = "DC52DD2090474CE225C7F04A65169B4D")

        public int defaultHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.356 -0400", hash_original_field = "0D2DE09E5F27455E05F7FF1B67886C82", hash_generated_field = "DF71D318B5EB1BF5987F356CB0279275")

        public int defaultHorizontalGap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.356 -0400", hash_original_field = "D570E9F85848AB1FA1B5CF09216D5735", hash_generated_field = "8FBFE89E7473D92A42F12D2754464DF1")

        public int verticalGap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.357 -0400", hash_original_field = "BB41E4F69BAD3DF9E224CF8B509D5902", hash_generated_field = "9D3D892C3131B2197CD0D2C746D97B95")

        ArrayList<Key> mKeys = new ArrayList<Key>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.357 -0400", hash_original_field = "0E1101664B8DB57E18332B336B9B1E2F", hash_generated_field = "91FC11B42D977D3B02FD50BC1189971A")

        public int rowEdgeFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.358 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "1713E3B7BE81112E8E3FFA899CB92941")

        public int mode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.358 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "A92AD498BEEAF9C2708EE10DACA716CF")

        private Keyboard parent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.360 -0400", hash_original_method = "DC05BCBDB8A9070EDAF2437F34B8D080", hash_generated_method = "A14915E0A0194E04900739C509BA6B30")
        public  Row(Keyboard parent) {
            this.parent = parent;
            // ---------- Original Method ----------
            //this.parent = parent;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.367 -0400", hash_original_method = "328FC2DFF8AD8E9D0620885E13D17104", hash_generated_method = "79D1FD1F032B4B6CBFFE67668D27AE10")
        public  Row(Resources res, Keyboard parent, XmlResourceParser parser) {
            addTaint(parser.getTaint());
            addTaint(res.getTaint());
            this.parent = parent;
            TypedArray a = res.obtainAttributes(Xml.asAttributeSet(parser), 
                    com.android.internal.R.styleable.Keyboard);
            defaultWidth = getDimensionOrFraction(a, 
                    com.android.internal.R.styleable.Keyboard_keyWidth, 
                    parent.mDisplayWidth, parent.mDefaultWidth);
            defaultHeight = getDimensionOrFraction(a, 
                    com.android.internal.R.styleable.Keyboard_keyHeight, 
                    parent.mDisplayHeight, parent.mDefaultHeight);
            defaultHorizontalGap = getDimensionOrFraction(a,
                    com.android.internal.R.styleable.Keyboard_horizontalGap, 
                    parent.mDisplayWidth, parent.mDefaultHorizontalGap);
            verticalGap = getDimensionOrFraction(a, 
                    com.android.internal.R.styleable.Keyboard_verticalGap, 
                    parent.mDisplayHeight, parent.mDefaultVerticalGap);
            a.recycle();
            a = res.obtainAttributes(Xml.asAttributeSet(parser),
                    com.android.internal.R.styleable.Keyboard_Row);
            rowEdgeFlags = a.getInt(com.android.internal.R.styleable.Keyboard_Row_rowEdgeFlags, 0);
            mode = a.getResourceId(com.android.internal.R.styleable.Keyboard_Row_keyboardMode,
                    0);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        
    }
    
    public static class Key {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.370 -0400", hash_original_field = "76034A9F5BEF30B9DEE701711D30BED6", hash_generated_field = "816E16893109F7A2D1F430C780DBBA02")

        public int[] codes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.370 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "D6BF9CF13073D3E7F28EBF190C9E996E")

        public CharSequence label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.371 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "7DA0BD4911ECB4A1387B13FD86D9CFB1")

        public Drawable icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.371 -0400", hash_original_field = "C805BF68B5F2429D3342E7A2D1F569DF", hash_generated_field = "67E46CC13E0A6AC1A32D5AE6094F3D15")

        public Drawable iconPreview;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.372 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "6FAF64E7577371F06EC12EBE94C8466B")

        public int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.372 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "7F76BED9760D410D06D1D8D13D91425A")

        public int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.373 -0400", hash_original_field = "DF9BCBD6578A1E49C06B7EC2874F9E23", hash_generated_field = "2A555D4A9C680660571497FD56C6B203")

        public int gap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.373 -0400", hash_original_field = "609A8F6F218FDFE6F955E19F818EC050", hash_generated_field = "2AF82E2132A2681BE44B5FD438CFADF5")

        public boolean sticky;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.374 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "DC9CDA960147F3D22D20E612AF25CB17")

        public int x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.374 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "2B3105BD07A59FEFE1F1918C5EDA2B54")

        public int y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.375 -0400", hash_original_field = "6375592A2D987630E9BF9AFD9E7DE973", hash_generated_field = "574D068D12BF592FB07E646F581E4F8C")

        public boolean pressed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.375 -0400", hash_original_field = "ED2B5C0139CEC8AD2873829DC1117D50", hash_generated_field = "665648E66B8A55C64D630EFB1287DC19")

        public boolean on;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.376 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "1FDF02F5FA00FB650C53E54E20AF7723")

        public CharSequence text;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.376 -0400", hash_original_field = "BEAB3F446100B0109969700E4ACBD0FD", hash_generated_field = "D4717D2B62BFE6A0EAF0250B3EC7FDE5")

        public CharSequence popupCharacters;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.377 -0400", hash_original_field = "26757146C945DD8955EEBF74EA104390", hash_generated_field = "B7670209317A99A0F9FD6EA8AC95F471")

        public int edgeFlags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.377 -0400", hash_original_field = "3AD7320FA61B1CFAD6B5A97FCB565315", hash_generated_field = "8D9293B00B5809BD9CEDFC0ADB474CD4")

        public boolean modifier;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.378 -0400", hash_original_field = "388A56DBB62A010DC26A378981346247", hash_generated_field = "DDEC53B260A0B0C62C968A94B6C87569")

        private Keyboard keyboard;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.378 -0400", hash_original_field = "1BF18B00918F0446E0568A22A44F1EAD", hash_generated_field = "E9FE8D0F40D5A1A1C9A458D86D2FAE8E")

        public int popupResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.379 -0400", hash_original_field = "118FE1E8CA47F6C9B92B88E21CB0AC0D", hash_generated_field = "92853C2BBEB69E894CDDBFEE68216A36")

        public boolean repeatable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.383 -0400", hash_original_method = "EAB500CB07B3BAAF78C0991235E90656", hash_generated_method = "339C3CA20CD32E7BDABE9AE5C91A01A0")
        public  Key(Row parent) {
            keyboard = parent.parent;
            height = parent.defaultHeight;
            width = parent.defaultWidth;
            gap = parent.defaultHorizontalGap;
            edgeFlags = parent.rowEdgeFlags;
            // ---------- Original Method ----------
            //keyboard = parent.parent;
            //height = parent.defaultHeight;
            //width = parent.defaultWidth;
            //gap = parent.defaultHorizontalGap;
            //edgeFlags = parent.rowEdgeFlags;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.398 -0400", hash_original_method = "830941FBCB4391B83C4612526668A64E", hash_generated_method = "03544F08109C281026311ABE2223E3C8")
        public  Key(Resources res, Row parent, int x, int y, XmlResourceParser parser) {
            this(parent);
            addTaint(parser.getTaint());
            addTaint(res.getTaint());
            this.x = x;
            this.y = y;
            TypedArray a = res.obtainAttributes(Xml.asAttributeSet(parser), 
                    com.android.internal.R.styleable.Keyboard);
            width = getDimensionOrFraction(a, 
                    com.android.internal.R.styleable.Keyboard_keyWidth,
                    keyboard.mDisplayWidth, parent.defaultWidth);
            height = getDimensionOrFraction(a, 
                    com.android.internal.R.styleable.Keyboard_keyHeight,
                    keyboard.mDisplayHeight, parent.defaultHeight);
            gap = getDimensionOrFraction(a, 
                    com.android.internal.R.styleable.Keyboard_horizontalGap,
                    keyboard.mDisplayWidth, parent.defaultHorizontalGap);
            a.recycle();
            a = res.obtainAttributes(Xml.asAttributeSet(parser),
                    com.android.internal.R.styleable.Keyboard_Key);
            this.x += gap;
            TypedValue codesValue = new TypedValue();
            a.getValue(com.android.internal.R.styleable.Keyboard_Key_codes, 
                    codesValue);
            if(codesValue.type == TypedValue.TYPE_INT_DEC 
                    || codesValue.type == TypedValue.TYPE_INT_HEX)            
            {
                codes = new int[] { codesValue.data };
            } //End block
            else
            if(codesValue.type == TypedValue.TYPE_STRING)            
            {
                codes = parseCSV(codesValue.string.toString());
            } //End block
            iconPreview = a.getDrawable(com.android.internal.R.styleable.Keyboard_Key_iconPreview);
            if(iconPreview != null)            
            {
                iconPreview.setBounds(0, 0, iconPreview.getIntrinsicWidth(), 
                        iconPreview.getIntrinsicHeight());
            } //End block
            popupCharacters = a.getText(
                    com.android.internal.R.styleable.Keyboard_Key_popupCharacters);
            popupResId = a.getResourceId(
                    com.android.internal.R.styleable.Keyboard_Key_popupKeyboard, 0);
            repeatable = a.getBoolean(
                    com.android.internal.R.styleable.Keyboard_Key_isRepeatable, false);
            modifier = a.getBoolean(
                    com.android.internal.R.styleable.Keyboard_Key_isModifier, false);
            sticky = a.getBoolean(
                    com.android.internal.R.styleable.Keyboard_Key_isSticky, false);
            edgeFlags = a.getInt(com.android.internal.R.styleable.Keyboard_Key_keyEdgeFlags, 0);
            edgeFlags |= parent.rowEdgeFlags;
            icon = a.getDrawable(
                    com.android.internal.R.styleable.Keyboard_Key_keyIcon);
            if(icon != null)            
            {
                icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            } //End block
            label = a.getText(com.android.internal.R.styleable.Keyboard_Key_keyLabel);
            text = a.getText(com.android.internal.R.styleable.Keyboard_Key_keyOutputText);
            if(codes == null && !TextUtils.isEmpty(label))            
            {
                codes = new int[] { label.charAt(0) };
            } //End block
            a.recycle();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.401 -0400", hash_original_method = "EFEB5D5E48E6D7DF231600A54B22CA47", hash_generated_method = "44FF42A871C6238C7170E65DD82E4031")
        public void onPressed() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            pressed = !pressed;
            // ---------- Original Method ----------
            //pressed = !pressed;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.403 -0400", hash_original_method = "8C534B266C13BA38876EAA9999644CF9", hash_generated_method = "01321ADAFEEEAF22E081016D56D3B254")
        public void onReleased(boolean inside) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(inside);
            pressed = !pressed;
            if(sticky)            
            {
                on = !on;
            } //End block
            // ---------- Original Method ----------
            //pressed = !pressed;
            //if (sticky) {
                //on = !on;
            //}
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.406 -0400", hash_original_method = "7B51E12ECAEC0CF836B26BA3AD3CC811", hash_generated_method = "9FE3FFC47FB4B80C123C478633E2D702")
         int[] parseCSV(String value) {
            addTaint(value.getTaint());
            int count = 0;
            int lastIndex = 0;
            if(value.length() > 0)            
            {
                count++;
                while
((lastIndex = value.indexOf(",", lastIndex + 1)) > 0)                
                {
                    count++;
                } //End block
            } //End block
            int[] values = new int[count];
            count = 0;
            StringTokenizer st = new StringTokenizer(value, ",");
            while
(st.hasMoreTokens())            
            {
                try 
                {
                    values[count++] = Integer.parseInt(st.nextToken());
                } //End block
                catch (NumberFormatException nfe)
                {
                } //End block
            } //End block
            int[] varF09CC7EE3A9A93273F4B80601CAFB00C_336172155 = (values);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_721156687 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_721156687;
            // ---------- Original Method ----------
            //int count = 0;
            //int lastIndex = 0;
            //if (value.length() > 0) {
                //count++;
                //while ((lastIndex = value.indexOf(",", lastIndex + 1)) > 0) {
                    //count++;
                //}
            //}
            //int[] values = new int[count];
            //count = 0;
            //StringTokenizer st = new StringTokenizer(value, ",");
            //while (st.hasMoreTokens()) {
                //try {
                    //values[count++] = Integer.parseInt(st.nextToken());
                //} catch (NumberFormatException nfe) {
                    //Log.e(TAG, "Error parsing keycodes " + value);
                //}
            //}
            //return values;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.410 -0400", hash_original_method = "9971CE43B16389831BA636E5AD76DCEB", hash_generated_method = "DC1FEDF6D4321006BE666AC693CC8E83")
        public boolean isInside(int x, int y) {
            addTaint(y);
            addTaint(x);
            boolean leftEdge = (edgeFlags & EDGE_LEFT) > 0;
            boolean rightEdge = (edgeFlags & EDGE_RIGHT) > 0;
            boolean topEdge = (edgeFlags & EDGE_TOP) > 0;
            boolean bottomEdge = (edgeFlags & EDGE_BOTTOM) > 0;
            if((x >= this.x || (leftEdge && x <= this.x + this.width)) 
                    && (x < this.x + this.width || (rightEdge && x >= this.x)) 
                    && (y >= this.y || (topEdge && y <= this.y + this.height))
                    && (y < this.y + this.height || (bottomEdge && y >= this.y)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_718057174 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105215183 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105215183;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_509623238 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_447144323 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_447144323;
            } //End block
            // ---------- Original Method ----------
            //boolean leftEdge = (edgeFlags & EDGE_LEFT) > 0;
            //boolean rightEdge = (edgeFlags & EDGE_RIGHT) > 0;
            //boolean topEdge = (edgeFlags & EDGE_TOP) > 0;
            //boolean bottomEdge = (edgeFlags & EDGE_BOTTOM) > 0;
            //if ((x >= this.x || (leftEdge && x <= this.x + this.width)) 
                    //&& (x < this.x + this.width || (rightEdge && x >= this.x)) 
                    //&& (y >= this.y || (topEdge && y <= this.y + this.height))
                    //&& (y < this.y + this.height || (bottomEdge && y >= this.y))) {
                //return true;
            //} else {
                //return false;
            //}
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.413 -0400", hash_original_method = "C0CF70FF2C5619B3CD017BF04C6EEC63", hash_generated_method = "6A74ED2AD3DFC0E5A5DA3A92349279D0")
        public int squaredDistanceFrom(int x, int y) {
            addTaint(y);
            addTaint(x);
            int xDist = this.x + width / 2 - x;
            int yDist = this.y + height / 2 - y;
            int var51E4855BB39D3E04481C7A120C193C9A_75257535 = (xDist * xDist + yDist * yDist);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1421496278 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1421496278;
            // ---------- Original Method ----------
            //int xDist = this.x + width / 2 - x;
            //int yDist = this.y + height / 2 - y;
            //return xDist * xDist + yDist * yDist;
        }
        
        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.417 -0400", hash_original_method = "A312018CFE68CC41CED7C34A2BAC04C3", hash_generated_method = "815782FCC891DA1DF269592299EFAEB9")
        public int[] getCurrentDrawableState() {
            int[] states = KEY_STATE_NORMAL;
            if(on)            
            {
                if(pressed)                
                {
                    states = KEY_STATE_PRESSED_ON;
                } //End block
                else
                {
                    states = KEY_STATE_NORMAL_ON;
                } //End block
            } //End block
            else
            {
                if(sticky)                
                {
                    if(pressed)                    
                    {
                        states = KEY_STATE_PRESSED_OFF;
                    } //End block
                    else
                    {
                        states = KEY_STATE_NORMAL_OFF;
                    } //End block
                } //End block
                else
                {
                    if(pressed)                    
                    {
                        states = KEY_STATE_PRESSED;
                    } //End block
                } //End block
            } //End block
            int[] var34D955A0DF5F7AF9C9B4E4DCCB3C3564_295804779 = (states);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_141310494 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_141310494;
            // ---------- Original Method ----------
            //int[] states = KEY_STATE_NORMAL;
            //if (on) {
                //if (pressed) {
                    //states = KEY_STATE_PRESSED_ON;
                //} else {
                    //states = KEY_STATE_NORMAL_ON;
                //}
            //} else {
                //if (sticky) {
                    //if (pressed) {
                        //states = KEY_STATE_PRESSED_OFF;
                    //} else {
                        //states = KEY_STATE_NORMAL_OFF;
                    //}
                //} else {
                    //if (pressed) {
                        //states = KEY_STATE_PRESSED;
                    //}
                //}
            //}
            //return states;
        }
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.420 -0400", hash_original_field = "1F0F754F606663C991356B37BABF0DB5", hash_generated_field = "0FBA4127AF3BD7D5AE1B160EB1508675")

        private final static int[] KEY_STATE_NORMAL_ON = { 
            android.R.attr.state_checkable, 
            android.R.attr.state_checked
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.420 -0400", hash_original_field = "625AE80A8EF0F9E3B331789577915003", hash_generated_field = "BAC8E1314778A3F2D9FB1BD233879E65")

        private final static int[] KEY_STATE_PRESSED_ON = { 
            android.R.attr.state_pressed, 
            android.R.attr.state_checkable, 
            android.R.attr.state_checked 
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.421 -0400", hash_original_field = "60A2E4BFEC20C3BDB04F22EB990E1EE7", hash_generated_field = "BB19E4F4B1362AB83F9D17354DA90E38")

        private final static int[] KEY_STATE_NORMAL_OFF = { 
            android.R.attr.state_checkable 
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.421 -0400", hash_original_field = "84A9325F94D79A746C7C7210F1FC2CEB", hash_generated_field = "C7ACFEAD0E4F02668859F5EDA10E6900")

        private final static int[] KEY_STATE_PRESSED_OFF = { 
            android.R.attr.state_pressed, 
            android.R.attr.state_checkable 
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.422 -0400", hash_original_field = "A0A45B844B942DDCC77E22904525F4C7", hash_generated_field = "0F8AFC49B4A9717ACC9BAA31B5941039")

        private final static int[] KEY_STATE_NORMAL = {
        };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.422 -0400", hash_original_field = "2C1E8FD0546CB0AD27ADA671AB2DA850", hash_generated_field = "B019C19DC2F282337325922DF06A550C")

        private final static int[] KEY_STATE_PRESSED = {
            android.R.attr.state_pressed
        };
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.423 -0400", hash_original_field = "20A7B5BEEC4CEEC197C774F3CF7FEDBE", hash_generated_field = "5DB368AB1F0561AD5D71B248E817F10A")

    static final String TAG = "Keyboard";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.424 -0400", hash_original_field = "BA90E0ACC3082CDADCF6A2FABF763099", hash_generated_field = "9BE61274FEBD92987B61D6173BED81C9")

    private static final String TAG_KEYBOARD = "Keyboard";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.424 -0400", hash_original_field = "00F0A3C583E6A35713C3E21A70D86F69", hash_generated_field = "097092C3058E80866FF0766E073101AB")

    private static final String TAG_ROW = "Row";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.425 -0400", hash_original_field = "454618211AEB46A92B59615EC95FE51E", hash_generated_field = "41CCDDE8FC21C767A700064BAB15F349")

    private static final String TAG_KEY = "Key";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.425 -0400", hash_original_field = "9A1C14EF7D96C05816CE65A406BD09E6", hash_generated_field = "460EBDA83E1BE0D671E863E2201A5E83")

    public static final int EDGE_LEFT = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.426 -0400", hash_original_field = "AC5199D68C5406D1C57FC61CA9FB336F", hash_generated_field = "06F18604D6450DBD9F2983D8A6DB5413")

    public static final int EDGE_RIGHT = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.426 -0400", hash_original_field = "D55DBBCD43D0631B82B47EB31A362489", hash_generated_field = "1B74BD977C032F617276750ACCA4B850")

    public static final int EDGE_TOP = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.427 -0400", hash_original_field = "FA00DCF31FF0A4201EA85C701CE61BBD", hash_generated_field = "4A0450E9CC63E79C8396DB8AFAEAD09D")

    public static final int EDGE_BOTTOM = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.427 -0400", hash_original_field = "190472BA6D918903592E121C9DE9D1C8", hash_generated_field = "6DB1BCA7922FA0000036393DF32D2F58")

    public static final int KEYCODE_SHIFT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.428 -0400", hash_original_field = "F92E38895F591042F88A035DD548EFDF", hash_generated_field = "281242799C6F24DF3DBFBE4088726548")

    public static final int KEYCODE_MODE_CHANGE = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.428 -0400", hash_original_field = "23BE11E0877DEC2F45FCDBB3B55A4C04", hash_generated_field = "ABAEC54268E67573EA51F8157F7D4580")

    public static final int KEYCODE_CANCEL = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.428 -0400", hash_original_field = "8D23604F7BDC2EF340B008C4EA42FD48", hash_generated_field = "101FB779BD9E4671BD07B9A1C11D2F97")

    public static final int KEYCODE_DONE = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.429 -0400", hash_original_field = "B7C2875C7DCAE7AED68374C46C2D0400", hash_generated_field = "B2ACA86B7EC99D6D8B89BAC103FE2E17")

    public static final int KEYCODE_DELETE = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.429 -0400", hash_original_field = "1A43616316AC96B3A77239B6031B7F8C", hash_generated_field = "374BC754F19E2D821318D82922A39D6D")

    public static final int KEYCODE_ALT = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.430 -0400", hash_original_field = "A7ABA5EBC467179C9184731DC6D7108F", hash_generated_field = "0A95B7AC89F1A426D8C3975E2B0E2BCB")

    private static final int GRID_WIDTH = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.430 -0400", hash_original_field = "6BF878C5240ACE52DB5AABE32DA7F5B4", hash_generated_field = "7D1917F7E472B899E18EABA6682D42C1")

    private static final int GRID_HEIGHT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.431 -0400", hash_original_field = "90B4E53628E3D88D3E4D6FACFEE70045", hash_generated_field = "BA44C2952851A1285DD5C685143370CB")

    private static final int GRID_SIZE = GRID_WIDTH * GRID_HEIGHT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.431 -0400", hash_original_field = "05A4BDD881F25999B8B9B34662B0B907", hash_generated_field = "2220E714671E9DD23ECF163111019543")

    private static float SEARCH_DISTANCE = 1.8f;
}

