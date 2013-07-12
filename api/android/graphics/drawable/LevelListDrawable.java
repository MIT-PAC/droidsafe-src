package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class LevelListDrawable extends DrawableContainer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.470 -0400", hash_original_field = "7DADAF6BEBDBEC9679B3936BAEE50B89", hash_generated_field = "47CDAADE6F8C5ECD8D87C1E79510A706")

    private LevelListState mLevelListState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.470 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.470 -0400", hash_original_method = "44C08D01AD86FB5FD2CB8E648FBEEBE6", hash_generated_method = "8DEE93644819C11B01FE6D8DDDC1A0A5")
    public  LevelListDrawable() {
        this(null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.471 -0400", hash_original_method = "FF29C84E557E14BBFF6CC67242AEE642", hash_generated_method = "2DF4817439F49DD91F462701D8ABAACD")
    private  LevelListDrawable(LevelListState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
        LevelListState as = new LevelListState(state, this, res);
        mLevelListState = as;
        setConstantState(as);
        onLevelChange(getLevel());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.471 -0400", hash_original_method = "034C59859D302C36E8258EB9CAEDE0AF", hash_generated_method = "F3CE64CF0E5519D168420D6A03918457")
    public void addLevel(int low, int high, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(high);
        addTaint(low);
    if(drawable != null)        
        {
            mLevelListState.addLevel(low, high, drawable);
            onLevelChange(getLevel());
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.472 -0400", hash_original_method = "69975FEB6AC4D6000EB731D154CA4016", hash_generated_method = "781938E2D95915DB9508329CF92F658C")
    @Override
    protected boolean onLevelChange(int level) {
        
        addTaint(level);
        int idx = mLevelListState.indexOfLevel(level);
    if(selectDrawable(idx))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1535236738 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084187121 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084187121;
        } 
        boolean var55D85368FEC8B8968114D2ED6BABC9BE_895687589 = (super.onLevelChange(level));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129407375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129407375;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.473 -0400", hash_original_method = "D1DA3B3E6F995A3C0C835AA99D4132D2", hash_generated_method = "AD40F1D40ED170E3F0CAAC9F4CABD676")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        super.inflate(r, parser, attrs);
        int type;
        int low = 0;
        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG))        
        {
    if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } 
    if(depth > innerDepth || !parser.getName().equals("item"))            
            {
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
    if(high < 0)            
            {
                XmlPullParserException varDA0FC977C726BC6EAB19AAC38D594373_1690241075 = new XmlPullParserException(parser.getPositionDescription()
                        + ": <item> tag requires a 'maxLevel' attribute");
                varDA0FC977C726BC6EAB19AAC38D594373_1690241075.addTaint(taint);
                throw varDA0FC977C726BC6EAB19AAC38D594373_1690241075;
            } 
            Drawable dr;
    if(drawableRes != 0)            
            {
                dr = r.getDrawable(drawableRes);
            } 
            else
            {
                while
((type = parser.next()) == XmlPullParser.TEXT)                
                {
                } 
    if(type != XmlPullParser.START_TAG)                
                {
                    XmlPullParserException var323689A2E36B2E80C03C4E544ECA8A7C_59098115 = new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                    var323689A2E36B2E80C03C4E544ECA8A7C_59098115.addTaint(taint);
                    throw var323689A2E36B2E80C03C4E544ECA8A7C_59098115;
                } 
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } 
            mLevelListState.addLevel(low, high, dr);
        } 
        onLevelChange(getLevel());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.474 -0400", hash_original_method = "2F3DD5E6B39B84FDED94D3B2A7A7FBE8", hash_generated_method = "112B38DDE58639F908281CD991A780DE")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mLevelListState.mLows = mLevelListState.mLows.clone();
            mLevelListState.mHighs = mLevelListState.mHighs.clone();
            mMutated = true;
        } 
Drawable var72A74007B2BE62B849F475C7BDA4658B_560512338 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_560512338.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_560512338;
        
        
            
            
            
        
        
    }

    
    private final static class LevelListState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.474 -0400", hash_original_field = "486E97E3A390A1CA09D64CA1515B6581", hash_generated_field = "37A326654DCDB6D550E9B55D69367F4E")

        private int[] mLows;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.474 -0400", hash_original_field = "3C7CECF15B500574F22FD19239AF02EE", hash_generated_field = "6415CF16E647D3E1A3CE81AF00D370F7")

        private int[] mHighs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.475 -0400", hash_original_method = "84CE1F1576ABE6B96A405641F0E77DA7", hash_generated_method = "646BDD69228B71701C8E396CA1B6FCF4")
          LevelListState(LevelListState orig, LevelListDrawable owner, Resources res) {
            super(orig, owner, res);
            addTaint(res.getTaint());
            addTaint(owner.getTaint());
    if(orig != null)            
            {
                mLows = orig.mLows;
                mHighs = orig.mHighs;
            } 
            else
            {
                mLows = new int[getChildren().length];
                mHighs = new int[getChildren().length];
            } 
            
            
                
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.476 -0400", hash_original_method = "532A81D3626CF6C141FB2F3AF4D4A1FD", hash_generated_method = "AF93F4161EFC444807225586266255EA")
        public void addLevel(int low, int high, Drawable drawable) {
            addTaint(drawable.getTaint());
            int pos = addChild(drawable);
            mLows[pos] = low;
            mHighs[pos] = high;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.477 -0400", hash_original_method = "821B925FDD0461B6E2C8DAC2FBB67163", hash_generated_method = "95EE3A824801E1C95E40FD458097E7F3")
        public int indexOfLevel(int level) {
            addTaint(level);
            final int[] lows = mLows;
            final int[] highs = mHighs;
            final int N = getChildCount();
for(int i = 0;i < N;i++)
            {
    if(level >= lows[i] && level <= highs[i])                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1559749330 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132399587 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132399587;
                } 
            } 
            int var6BB61E3B7BCE0931DA574D19D1D82C88_831523344 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069517943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069517943;
            
            
            
            
            
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.477 -0400", hash_original_method = "578EA11BFBDE2C74EEB0B28EA6FDC468", hash_generated_method = "B72EFF305D0E9F708620859A6CEA8EEF")
        @Override
        public Drawable newDrawable() {
Drawable var6167E9193441AB5E7B9D360C480317F7_968004962 =             new LevelListDrawable(this, null);
            var6167E9193441AB5E7B9D360C480317F7_968004962.addTaint(taint);
            return var6167E9193441AB5E7B9D360C480317F7_968004962;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.478 -0400", hash_original_method = "940707433A1F7319278E4F2386D7D30E", hash_generated_method = "70BEDF259A56F3AAA38B447C35FB4E2B")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var658F4AFFCC25F59D3034E6F8A11F2A98_533535099 =             new LevelListDrawable(this, res);
            var658F4AFFCC25F59D3034E6F8A11F2A98_533535099.addTaint(taint);
            return var658F4AFFCC25F59D3034E6F8A11F2A98_533535099;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.479 -0400", hash_original_method = "38D84B8130D493E02AF62015EFA0A6E9", hash_generated_method = "1B3915C78FC10DE5F79D444F9BEB7FEB")
        @Override
        public void growArray(int oldSize, int newSize) {
            addTaint(newSize);
            addTaint(oldSize);
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

