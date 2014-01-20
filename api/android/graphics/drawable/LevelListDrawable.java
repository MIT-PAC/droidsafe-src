package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class LevelListDrawable extends DrawableContainer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.725 -0500", hash_original_field = "2F3B839357AC4C9240B27FC00557844D", hash_generated_field = "47CDAADE6F8C5ECD8D87C1E79510A706")

    private  LevelListState mLevelListState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.727 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.729 -0500", hash_original_method = "44C08D01AD86FB5FD2CB8E648FBEEBE6", hash_generated_method = "E085D1E02370305C3BA4C9C948FEC593")
    
public LevelListDrawable() {
        this(null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.765 -0500", hash_original_method = "FF29C84E557E14BBFF6CC67242AEE642", hash_generated_method = "8733E31FD345288A2D5EAF44753D672B")
    
private LevelListDrawable(LevelListState state, Resources res) {
        LevelListState as = new LevelListState(state, this, res);
        mLevelListState = as;
        setConstantState(as);
        onLevelChange(getLevel());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.731 -0500", hash_original_method = "034C59859D302C36E8258EB9CAEDE0AF", hash_generated_method = "4D7ACAE7F8BE29D0BD3ADD3C090B512D")
    
public void addLevel(int low, int high, Drawable drawable) {
        if (drawable != null) {
            mLevelListState.addLevel(low, high, drawable);
            // in case the new state matches our current state...
            onLevelChange(getLevel());
        }
    }

    // overrides from Drawable

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.733 -0500", hash_original_method = "69975FEB6AC4D6000EB731D154CA4016", hash_generated_method = "E888621E60E59C9D397505B76EF521FD")
    
@Override
    protected boolean onLevelChange(int level) {
        int idx = mLevelListState.indexOfLevel(level);
        if (selectDrawable(idx)) {
            return true;
        }
        return super.onLevelChange(level);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.737 -0500", hash_original_method = "D1DA3B3E6F995A3C0C835AA99D4132D2", hash_generated_method = "F84A0D1EBB58DA0FB1E23A608A14889D")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {

        super.inflate(r, parser, attrs);

        int type;

        int low = 0;

        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            if (depth > innerDepth || !parser.getName().equals("item")) {
                continue;
            }

            TypedArray a = r.obtainAttributes(attrs,
                    com.android.internal.R.styleable.LevelListDrawableItem);

            low = a.getInt(
                    com.android.internal.R.styleable.LevelListDrawableItem_minLevel, 0);
            int high = a.getInt(
                    com.android.internal.R.styleable.LevelListDrawableItem_maxLevel, 0);
            int drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.LevelListDrawableItem_drawable, 0);

            a.recycle();

            if (high < 0) {
                throw new XmlPullParserException(parser.getPositionDescription()
                        + ": <item> tag requires a 'maxLevel' attribute");
            }

            Drawable dr;
            if (drawableRes != 0) {
                dr = r.getDrawable(drawableRes);
            } else {
                while ((type = parser.next()) == XmlPullParser.TEXT) {
                }
                if (type != XmlPullParser.START_TAG) {
                    throw new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                }
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            }

            mLevelListState.addLevel(low, high, dr);
        }

        onLevelChange(getLevel());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.740 -0500", hash_original_method = "2F3DD5E6B39B84FDED94D3B2A7A7FBE8", hash_generated_method = "3614019FFAAF3C4AA61E4F75819A2C5D")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mLevelListState.mLows = mLevelListState.mLows.clone();
            mLevelListState.mHighs = mLevelListState.mHighs.clone();
            mMutated = true;
        }
        return this;
    }
    
    private final static class LevelListState extends DrawableContainerState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.743 -0500", hash_original_field = "6FE36D59F9E611A4BB43B905FDDA462B", hash_generated_field = "37A326654DCDB6D550E9B55D69367F4E")

        private int[] mLows;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.745 -0500", hash_original_field = "893E6C3DA08A7D53D421EDD1DCAEF7BB", hash_generated_field = "6415CF16E647D3E1A3CE81AF00D370F7")

        private int[] mHighs;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.748 -0500", hash_original_method = "84CE1F1576ABE6B96A405641F0E77DA7", hash_generated_method = "84CE1F1576ABE6B96A405641F0E77DA7")
        
LevelListState(LevelListState orig, LevelListDrawable owner, Resources res) {
            super(orig, owner, res);

            if (orig != null) {
                mLows = orig.mLows;
                mHighs = orig.mHighs;
            } else {
                mLows = new int[getChildren().length];
                mHighs = new int[getChildren().length];
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.750 -0500", hash_original_method = "532A81D3626CF6C141FB2F3AF4D4A1FD", hash_generated_method = "8C565060031500B708E12D05AD9A52EF")
        
public void addLevel(int low, int high, Drawable drawable) {
            int pos = addChild(drawable);
            mLows[pos] = low;
            mHighs[pos] = high;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.753 -0500", hash_original_method = "821B925FDD0461B6E2C8DAC2FBB67163", hash_generated_method = "D2FB97DC2C74F89B1CEBC2658CB2E577")
        
public int indexOfLevel(int level) {
            final int[] lows = mLows;
            final int[] highs = mHighs;
            final int N = getChildCount();
            for (int i = 0; i < N; i++) {
                if (level >= lows[i] && level <= highs[i]) {
                    return i;
                }
            }
            return -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.755 -0500", hash_original_method = "578EA11BFBDE2C74EEB0B28EA6FDC468", hash_generated_method = "4D63526913BD1C0D7C22B3363501C756")
        
@Override
        public Drawable newDrawable() {
            return new LevelListDrawable(this, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.758 -0500", hash_original_method = "940707433A1F7319278E4F2386D7D30E", hash_generated_method = "721B4B0C126370469D75E324DE636FF9")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new LevelListDrawable(this, res);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:14.760 -0500", hash_original_method = "38D84B8130D493E02AF62015EFA0A6E9", hash_generated_method = "6EAA09858AC9A08FF1FDC2DB41AD3D1C")
        
@Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            int[] newInts = new int[newSize];
            System.arraycopy(mLows, 0, newInts, 0, oldSize);
            mLows = newInts;
            newInts = new int[newSize];
            System.arraycopy(mHighs, 0, newInts, 0, oldSize);
            mHighs = newInts;
        }
        
    }
    
}

