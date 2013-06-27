package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class LevelListDrawable extends DrawableContainer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.133 -0400", hash_original_field = "7DADAF6BEBDBEC9679B3936BAEE50B89", hash_generated_field = "47CDAADE6F8C5ECD8D87C1E79510A706")

    private LevelListState mLevelListState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.133 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.134 -0400", hash_original_method = "44C08D01AD86FB5FD2CB8E648FBEEBE6", hash_generated_method = "8DEE93644819C11B01FE6D8DDDC1A0A5")
    public  LevelListDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.147 -0400", hash_original_method = "FF29C84E557E14BBFF6CC67242AEE642", hash_generated_method = "40BBFFA6560F2BF3C2DF7D823228E2EC")
    private  LevelListDrawable(LevelListState state, Resources res) {
        LevelListState as;
        as = new LevelListState(state, this, res);
        mLevelListState = as;
        setConstantState(as);
        onLevelChange(getLevel());
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        // ---------- Original Method ----------
        //LevelListState as = new LevelListState(state, this, res);
        //mLevelListState = as;
        //setConstantState(as);
        //onLevelChange(getLevel());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.152 -0400", hash_original_method = "034C59859D302C36E8258EB9CAEDE0AF", hash_generated_method = "E8A7CEDE8DC8FCA2FB63DFBA65D0865B")
    public void addLevel(int low, int high, Drawable drawable) {
        {
            mLevelListState.addLevel(low, high, drawable);
            onLevelChange(getLevel());
        } //End block
        addTaint(low);
        addTaint(high);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mLevelListState.addLevel(low, high, drawable);
            //onLevelChange(getLevel());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.155 -0400", hash_original_method = "69975FEB6AC4D6000EB731D154CA4016", hash_generated_method = "2B8CC0F9D368AF121FD4C0E03F9F058E")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int idx;
        idx = mLevelListState.indexOfLevel(level);
        {
            boolean var3E2B49468750734D46A6120849432D6B_1151480517 = (selectDrawable(idx));
        } //End collapsed parenthetic
        boolean varDB7AD9D2975F96CFC59CFC70C6A8F8CB_860825941 = (super.onLevelChange(level));
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39554520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_39554520;
        // ---------- Original Method ----------
        //int idx = mLevelListState.indexOfLevel(level);
        //if (selectDrawable(idx)) {
            //return true;
        //}
        //return super.onLevelChange(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.166 -0400", hash_original_method = "D1DA3B3E6F995A3C0C835AA99D4132D2", hash_generated_method = "F51DA29BDBEBEAFB7D04B407A3A0C019")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);
        int type;
        int low;
        low = 0;
        int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth;
        {
            boolean var5C2AD857B4870B6E82338097BA87AA78_1469460785 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_551786776 = (depth > innerDepth || !parser.getName().equals("item"));
                } //End collapsed parenthetic
                TypedArray a;
                a = r.obtainAttributes(attrs,
                    com.android.internal.R.styleable.LevelListDrawableItem);
                low = a.getInt(
                    com.android.internal.R.styleable.LevelListDrawableItem_minLevel, 0);
                int high;
                high = a.getInt(
                    com.android.internal.R.styleable.LevelListDrawableItem_maxLevel, 0);
                int drawableRes;
                drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.LevelListDrawableItem_drawable, 0);
                a.recycle();
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription()
                        + ": <item> tag requires a 'maxLevel' attribute");
                } //End block
                Drawable dr;
                {
                    dr = r.getDrawable(drawableRes);
                } //End block
                {
                    {
                        boolean var16E7483EB4C069010E58346DA2B7701B_1140509081 = ((type = parser.next()) == XmlPullParser.TEXT);
                    } //End collapsed parenthetic
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                    } //End block
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } //End block
                mLevelListState.addLevel(low, high, dr);
            } //End block
        } //End collapsed parenthetic
        onLevelChange(getLevel());
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.189 -0400", hash_original_method = "2F3DD5E6B39B84FDED94D3B2A7A7FBE8", hash_generated_method = "1F6B1DC3C5C7441D9C3F4D02472B77D1")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_420490544 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_1006527354 = (!mMutated && super.mutate() == this);
            {
                mLevelListState.mLows = mLevelListState.mLows.clone();
                mLevelListState.mHighs = mLevelListState.mHighs.clone();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_420490544 = this;
        varB4EAC82CA7396A68D541C85D26508E83_420490544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_420490544;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mLevelListState.mLows = mLevelListState.mLows.clone();
            //mLevelListState.mHighs = mLevelListState.mHighs.clone();
            //mMutated = true;
        //}
        //return this;
    }

    
    private final static class LevelListState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.189 -0400", hash_original_field = "486E97E3A390A1CA09D64CA1515B6581", hash_generated_field = "37A326654DCDB6D550E9B55D69367F4E")

        private int[] mLows;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.189 -0400", hash_original_field = "3C7CECF15B500574F22FD19239AF02EE", hash_generated_field = "6415CF16E647D3E1A3CE81AF00D370F7")

        private int[] mHighs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.198 -0400", hash_original_method = "84CE1F1576ABE6B96A405641F0E77DA7", hash_generated_method = "26E8BE38ECE84B827A3491F845491423")
          LevelListState(LevelListState orig, LevelListDrawable owner, Resources res) {
            super(orig, owner, res);
            {
                mLows = orig.mLows;
                mHighs = orig.mHighs;
            } //End block
            {
                mLows = new int[getChildren().length];
                mHighs = new int[getChildren().length];
            } //End block
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            // ---------- Original Method ----------
            //if (orig != null) {
                //mLows = orig.mLows;
                //mHighs = orig.mHighs;
            //} else {
                //mLows = new int[getChildren().length];
                //mHighs = new int[getChildren().length];
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.219 -0400", hash_original_method = "532A81D3626CF6C141FB2F3AF4D4A1FD", hash_generated_method = "A431CDE28C48ED6EFED89917514889B2")
        public void addLevel(int low, int high, Drawable drawable) {
            int pos;
            pos = addChild(drawable);
            mLows[pos] = low;
            mHighs[pos] = high;
            addTaint(drawable.getTaint());
            // ---------- Original Method ----------
            //int pos = addChild(drawable);
            //mLows[pos] = low;
            //mHighs[pos] = high;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.220 -0400", hash_original_method = "821B925FDD0461B6E2C8DAC2FBB67163", hash_generated_method = "564C42D5E64E09824FD78D33EE5961ED")
        public int indexOfLevel(int level) {
            int[] lows;
            lows = mLows;
            int[] highs;
            highs = mHighs;
            int N;
            N = getChildCount();
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
            addTaint(level);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763244146 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763244146;
            // ---------- Original Method ----------
            //final int[] lows = mLows;
            //final int[] highs = mHighs;
            //final int N = getChildCount();
            //for (int i = 0; i < N; i++) {
                //if (level >= lows[i] && level <= highs[i]) {
                    //return i;
                //}
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.220 -0400", hash_original_method = "578EA11BFBDE2C74EEB0B28EA6FDC468", hash_generated_method = "147B9281544F370D11402040B7AB20E6")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_917155599 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_917155599 = new LevelListDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_917155599.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_917155599;
            // ---------- Original Method ----------
            //return new LevelListDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.221 -0400", hash_original_method = "940707433A1F7319278E4F2386D7D30E", hash_generated_method = "46302D45008E79BECC930FAB4B3DED7C")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1998742007 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1998742007 = new LevelListDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1998742007.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1998742007;
            // ---------- Original Method ----------
            //return new LevelListDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.232 -0400", hash_original_method = "38D84B8130D493E02AF62015EFA0A6E9", hash_generated_method = "504CC4B277CFEF483C942D6D5AC6A8C5")
        @Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            int[] newInts;
            newInts = new int[newSize];
            System.arraycopy(mLows, 0, newInts, 0, oldSize);
            mLows = newInts;
            newInts = new int[newSize];
            System.arraycopy(mHighs, 0, newInts, 0, oldSize);
            mHighs = newInts;
            addTaint(oldSize);
            addTaint(newSize);
            // ---------- Original Method ----------
            //super.growArray(oldSize, newSize);
            //int[] newInts = new int[newSize];
            //System.arraycopy(mLows, 0, newInts, 0, oldSize);
            //mLows = newInts;
            //newInts = new int[newSize];
            //System.arraycopy(mHighs, 0, newInts, 0, oldSize);
            //mHighs = newInts;
        }

        
    }


    
}

