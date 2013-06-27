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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.713 -0400", hash_original_field = "7DADAF6BEBDBEC9679B3936BAEE50B89", hash_generated_field = "47CDAADE6F8C5ECD8D87C1E79510A706")

    private LevelListState mLevelListState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.713 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.728 -0400", hash_original_method = "44C08D01AD86FB5FD2CB8E648FBEEBE6", hash_generated_method = "8DEE93644819C11B01FE6D8DDDC1A0A5")
    public  LevelListDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.738 -0400", hash_original_method = "FF29C84E557E14BBFF6CC67242AEE642", hash_generated_method = "40BBFFA6560F2BF3C2DF7D823228E2EC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.739 -0400", hash_original_method = "034C59859D302C36E8258EB9CAEDE0AF", hash_generated_method = "E8A7CEDE8DC8FCA2FB63DFBA65D0865B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.741 -0400", hash_original_method = "69975FEB6AC4D6000EB731D154CA4016", hash_generated_method = "BC3D15CD825DFB53FBCBB6BF2792156F")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int idx;
        idx = mLevelListState.indexOfLevel(level);
        {
            boolean var3E2B49468750734D46A6120849432D6B_1275666411 = (selectDrawable(idx));
        } //End collapsed parenthetic
        boolean varDB7AD9D2975F96CFC59CFC70C6A8F8CB_368320778 = (super.onLevelChange(level));
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131599030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131599030;
        // ---------- Original Method ----------
        //int idx = mLevelListState.indexOfLevel(level);
        //if (selectDrawable(idx)) {
            //return true;
        //}
        //return super.onLevelChange(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.759 -0400", hash_original_method = "D1DA3B3E6F995A3C0C835AA99D4132D2", hash_generated_method = "EBB28C023CED40CA4E26D54CC07A5038")
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
            boolean var5C2AD857B4870B6E82338097BA87AA78_237913076 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_92083287 = (depth > innerDepth || !parser.getName().equals("item"));
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
                        boolean var16E7483EB4C069010E58346DA2B7701B_1073628862 = ((type = parser.next()) == XmlPullParser.TEXT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.766 -0400", hash_original_method = "2F3DD5E6B39B84FDED94D3B2A7A7FBE8", hash_generated_method = "BF2875524DD87237D2E73F83AEE6FFA5")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_691493030 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_2107126708 = (!mMutated && super.mutate() == this);
            {
                mLevelListState.mLows = mLevelListState.mLows.clone();
                mLevelListState.mHighs = mLevelListState.mHighs.clone();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_691493030 = this;
        varB4EAC82CA7396A68D541C85D26508E83_691493030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_691493030;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mLevelListState.mLows = mLevelListState.mLows.clone();
            //mLevelListState.mHighs = mLevelListState.mHighs.clone();
            //mMutated = true;
        //}
        //return this;
    }

    
    private final static class LevelListState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.780 -0400", hash_original_field = "486E97E3A390A1CA09D64CA1515B6581", hash_generated_field = "37A326654DCDB6D550E9B55D69367F4E")

        private int[] mLows;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.780 -0400", hash_original_field = "3C7CECF15B500574F22FD19239AF02EE", hash_generated_field = "6415CF16E647D3E1A3CE81AF00D370F7")

        private int[] mHighs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.781 -0400", hash_original_method = "84CE1F1576ABE6B96A405641F0E77DA7", hash_generated_method = "26E8BE38ECE84B827A3491F845491423")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.783 -0400", hash_original_method = "532A81D3626CF6C141FB2F3AF4D4A1FD", hash_generated_method = "A431CDE28C48ED6EFED89917514889B2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.807 -0400", hash_original_method = "821B925FDD0461B6E2C8DAC2FBB67163", hash_generated_method = "D8FFD2A282CF6EADD513DAD0C23250D4")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51994524 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51994524;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.808 -0400", hash_original_method = "578EA11BFBDE2C74EEB0B28EA6FDC468", hash_generated_method = "2C0C1A0EAD0C2258D81498805924F4B6")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1091305245 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1091305245 = new LevelListDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_1091305245.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1091305245;
            // ---------- Original Method ----------
            //return new LevelListDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.809 -0400", hash_original_method = "940707433A1F7319278E4F2386D7D30E", hash_generated_method = "DC3B5341F4784172273503912704C887")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_40979088 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_40979088 = new LevelListDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_40979088.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_40979088;
            // ---------- Original Method ----------
            //return new LevelListDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.810 -0400", hash_original_method = "38D84B8130D493E02AF62015EFA0A6E9", hash_generated_method = "504CC4B277CFEF483C942D6D5AC6A8C5")
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

