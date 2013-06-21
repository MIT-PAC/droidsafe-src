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
    private LevelListState mLevelListState;
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.490 -0400", hash_original_method = "44C08D01AD86FB5FD2CB8E648FBEEBE6", hash_generated_method = "8DEE93644819C11B01FE6D8DDDC1A0A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LevelListDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.490 -0400", hash_original_method = "FF29C84E557E14BBFF6CC67242AEE642", hash_generated_method = "B1EBA6784F5265988EE5055963253F6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LevelListDrawable(LevelListState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        LevelListState as;
        as = new LevelListState(state, this, res);
        mLevelListState = as;
        setConstantState(as);
        onLevelChange(getLevel());
        // ---------- Original Method ----------
        //LevelListState as = new LevelListState(state, this, res);
        //mLevelListState = as;
        //setConstantState(as);
        //onLevelChange(getLevel());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.490 -0400", hash_original_method = "034C59859D302C36E8258EB9CAEDE0AF", hash_generated_method = "D6D9978F6D4B7493592D7EED77CF5EB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addLevel(int low, int high, Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
        dsTaint.addTaint(high);
        dsTaint.addTaint(low);
        {
            mLevelListState.addLevel(low, high, drawable);
            onLevelChange(getLevel());
        } //End block
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mLevelListState.addLevel(low, high, drawable);
            //onLevelChange(getLevel());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.491 -0400", hash_original_method = "69975FEB6AC4D6000EB731D154CA4016", hash_generated_method = "03DB3ACFF6178B1B8D31DC9F7127ADD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        int idx;
        idx = mLevelListState.indexOfLevel(level);
        {
            boolean var3E2B49468750734D46A6120849432D6B_905943801 = (selectDrawable(idx));
        } //End collapsed parenthetic
        boolean varDB7AD9D2975F96CFC59CFC70C6A8F8CB_300653868 = (super.onLevelChange(level));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int idx = mLevelListState.indexOfLevel(level);
        //if (selectDrawable(idx)) {
            //return true;
        //}
        //return super.onLevelChange(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.492 -0400", hash_original_method = "D1DA3B3E6F995A3C0C835AA99D4132D2", hash_generated_method = "9A0EEE0AC66B65774F7DC16124406BAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        int type;
        int low;
        low = 0;
        int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth;
        {
            boolean var5C2AD857B4870B6E82338097BA87AA78_1599584733 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_467253237 = (depth > innerDepth || !parser.getName().equals("item"));
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
                        boolean var16E7483EB4C069010E58346DA2B7701B_2037987409 = ((type = parser.next()) == XmlPullParser.TEXT);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.492 -0400", hash_original_method = "2F3DD5E6B39B84FDED94D3B2A7A7FBE8", hash_generated_method = "DDA936A222BBC3317C152C6B6B685B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_501383218 = (!mMutated && super.mutate() == this);
            {
                mLevelListState.mLows = mLevelListState.mLows.clone();
                mLevelListState.mHighs = mLevelListState.mHighs.clone();
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mLevelListState.mLows = mLevelListState.mLows.clone();
            //mLevelListState.mHighs = mLevelListState.mHighs.clone();
            //mMutated = true;
        //}
        //return this;
    }

    
    private final static class LevelListState extends DrawableContainerState {
        private int[] mLows;
        private int[] mHighs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.493 -0400", hash_original_method = "84CE1F1576ABE6B96A405641F0E77DA7", hash_generated_method = "98AEF253627A108A28EA4E790BD6E073")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LevelListState(LevelListState orig, LevelListDrawable owner, Resources res) {
            super(orig, owner, res);
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            {
                mLows = orig.mLows;
                mHighs = orig.mHighs;
            } //End block
            {
                mLows = new int[getChildren().length];
                mHighs = new int[getChildren().length];
            } //End block
            // ---------- Original Method ----------
            //if (orig != null) {
                //mLows = orig.mLows;
                //mHighs = orig.mHighs;
            //} else {
                //mLows = new int[getChildren().length];
                //mHighs = new int[getChildren().length];
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.494 -0400", hash_original_method = "532A81D3626CF6C141FB2F3AF4D4A1FD", hash_generated_method = "841A55AA6996EFB75FB65E97B05F31F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void addLevel(int low, int high, Drawable drawable) {
            dsTaint.addTaint(drawable.dsTaint);
            dsTaint.addTaint(high);
            dsTaint.addTaint(low);
            int pos;
            pos = addChild(drawable);
            mLows[pos] = low;
            mHighs[pos] = high;
            // ---------- Original Method ----------
            //int pos = addChild(drawable);
            //mLows[pos] = low;
            //mHighs[pos] = high;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.495 -0400", hash_original_method = "821B925FDD0461B6E2C8DAC2FBB67163", hash_generated_method = "BDAED4894FA5D444CBBB2EF178259866")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int indexOfLevel(int level) {
            dsTaint.addTaint(level);
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
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.496 -0400", hash_original_method = "578EA11BFBDE2C74EEB0B28EA6FDC468", hash_generated_method = "52AFBB1965D3EB294FF7A299BCA197E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var6A32118B89C60FE1CBB4852C89C28781_713081243 = (new LevelListDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LevelListDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.497 -0400", hash_original_method = "940707433A1F7319278E4F2386D7D30E", hash_generated_method = "3555D9F35FA9887D268BC41DAF83CC2D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable varE08317973D2282FEE3595C8BF170DEF6_1306650969 = (new LevelListDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LevelListDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.497 -0400", hash_original_method = "38D84B8130D493E02AF62015EFA0A6E9", hash_generated_method = "D159A710EB032C92052A68C983C16ABD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void growArray(int oldSize, int newSize) {
            dsTaint.addTaint(oldSize);
            dsTaint.addTaint(newSize);
            super.growArray(oldSize, newSize);
            int[] newInts;
            newInts = new int[newSize];
            System.arraycopy(mLows, 0, newInts, 0, oldSize);
            mLows = newInts;
            newInts = new int[newSize];
            System.arraycopy(mHighs, 0, newInts, 0, oldSize);
            mHighs = newInts;
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

