package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class LevelListDrawable extends DrawableContainer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.326 -0400", hash_original_field = "7DADAF6BEBDBEC9679B3936BAEE50B89", hash_generated_field = "47CDAADE6F8C5ECD8D87C1E79510A706")

    private LevelListState mLevelListState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.326 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.327 -0400", hash_original_method = "44C08D01AD86FB5FD2CB8E648FBEEBE6", hash_generated_method = "8DEE93644819C11B01FE6D8DDDC1A0A5")
    public  LevelListDrawable() {
        this(null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.327 -0400", hash_original_method = "FF29C84E557E14BBFF6CC67242AEE642", hash_generated_method = "761ABE84D06409C0841478A98C1BE965")
    private  LevelListDrawable(LevelListState state, Resources res) {
        LevelListState as = new LevelListState(state, this, res);
        mLevelListState = as;
        setConstantState(as);
        onLevelChange(getLevel());
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.327 -0400", hash_original_method = "034C59859D302C36E8258EB9CAEDE0AF", hash_generated_method = "E8A7CEDE8DC8FCA2FB63DFBA65D0865B")
    public void addLevel(int low, int high, Drawable drawable) {
        {
            mLevelListState.addLevel(low, high, drawable);
            onLevelChange(getLevel());
        } 
        addTaint(low);
        addTaint(high);
        addTaint(drawable.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.328 -0400", hash_original_method = "69975FEB6AC4D6000EB731D154CA4016", hash_generated_method = "C38CD075615ACE3512A95A7222DD9C74")
    @Override
    protected boolean onLevelChange(int level) {
        
        int idx = mLevelListState.indexOfLevel(level);
        {
            boolean var3E2B49468750734D46A6120849432D6B_1822525909 = (selectDrawable(idx));
        } 
        boolean varDB7AD9D2975F96CFC59CFC70C6A8F8CB_599913238 = (super.onLevelChange(level));
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511815478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_511815478;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.759 -0400", hash_original_method = "D1DA3B3E6F995A3C0C835AA99D4132D2", hash_generated_method = "EBB28C023CED40CA4E26D54CC07A5038")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);
        int type;
        int low;
        low = 0;
        int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth = 0;
        {
            boolean var5C2AD857B4870B6E82338097BA87AA78_237913076 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_92083287 = (depth > innerDepth || !parser.getName().equals("item"));
                } 
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
                } 
                Drawable dr;
                {
                    dr = r.getDrawable(drawableRes);
                } 
                {
                    {
                        boolean var16E7483EB4C069010E58346DA2B7701B_1073628862 = ((type = parser.next()) == XmlPullParser.TEXT);
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                    } 
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } 
                mLevelListState.addLevel(low, high, dr);
            } 
        } 
        onLevelChange(getLevel());
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.329 -0400", hash_original_method = "2F3DD5E6B39B84FDED94D3B2A7A7FBE8", hash_generated_method = "2033F1FD4301620A62DA100A0F8F6AFE")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1063161566 = null; 
        {
            boolean varC94B19053599294E7944C8C841976773_15157486 = (!mMutated && super.mutate() == this);
            {
                mLevelListState.mLows = mLevelListState.mLows.clone();
                mLevelListState.mHighs = mLevelListState.mHighs.clone();
                mMutated = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1063161566 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1063161566.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1063161566;
        
        
            
            
            
        
        
    }

    
    private final static class LevelListState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.330 -0400", hash_original_field = "486E97E3A390A1CA09D64CA1515B6581", hash_generated_field = "37A326654DCDB6D550E9B55D69367F4E")

        private int[] mLows;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.330 -0400", hash_original_field = "3C7CECF15B500574F22FD19239AF02EE", hash_generated_field = "6415CF16E647D3E1A3CE81AF00D370F7")

        private int[] mHighs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.330 -0400", hash_original_method = "84CE1F1576ABE6B96A405641F0E77DA7", hash_generated_method = "26E8BE38ECE84B827A3491F845491423")
          LevelListState(LevelListState orig, LevelListDrawable owner, Resources res) {
            super(orig, owner, res);
            {
                mLows = orig.mLows;
                mHighs = orig.mHighs;
            } 
            {
                mLows = new int[getChildren().length];
                mHighs = new int[getChildren().length];
            } 
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            
            
                
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.331 -0400", hash_original_method = "532A81D3626CF6C141FB2F3AF4D4A1FD", hash_generated_method = "3EC3F5AB4071AA2A4AF8CAFA2BD9E98B")
        public void addLevel(int low, int high, Drawable drawable) {
            int pos = addChild(drawable);
            mLows[pos] = low;
            mHighs[pos] = high;
            addTaint(drawable.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.331 -0400", hash_original_method = "821B925FDD0461B6E2C8DAC2FBB67163", hash_generated_method = "401B1CE9D9D8C0690B35F67146B4CE51")
        public int indexOfLevel(int level) {
            final int[] lows = mLows;
            final int[] highs = mHighs;
            final int N = getChildCount();
            {
                int i = 0;
            } 
            addTaint(level);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350840637 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350840637;
            
            
            
            
            
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.332 -0400", hash_original_method = "578EA11BFBDE2C74EEB0B28EA6FDC468", hash_generated_method = "3C91D73D7C2B810271EC13A0C745E6C8")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_575904095 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_575904095 = new LevelListDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_575904095.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_575904095;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.332 -0400", hash_original_method = "940707433A1F7319278E4F2386D7D30E", hash_generated_method = "483A6499F39DD59325778D332ED177B9")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1913197365 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1913197365 = new LevelListDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1913197365.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1913197365;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.333 -0400", hash_original_method = "38D84B8130D493E02AF62015EFA0A6E9", hash_generated_method = "085323203CB02BA7DB2C13E6C7017E06")
        @Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            int[] newInts = new int[newSize];
            System.arraycopy(mLows, 0, newInts, 0, oldSize);
            mLows = newInts;
            newInts = new int[newSize];
            System.arraycopy(mHighs, 0, newInts, 0, oldSize);
            mHighs = newInts;
            addTaint(oldSize);
            addTaint(newSize);
            
            
            
            
            
            
            
            
        }

        
    }


    
}

