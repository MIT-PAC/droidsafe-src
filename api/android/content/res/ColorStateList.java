package android.content.res;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.StateSet;
import android.util.Xml;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ColorStateList implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.715 -0400", hash_original_field = "90D2BFFC9D360D1A65ACEAB45ADBE457", hash_generated_field = "7D52F505B14BC667C4ED1C5AB261B59A")

    private int[][] mStateSpecs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.715 -0400", hash_original_field = "F5B754067786840AA79148E1DA0BE95F", hash_generated_field = "53BCC056E3008A06A88375FEB8668D58")

    private int[] mColors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.715 -0400", hash_original_field = "19E481D0B803854FFC562966D69D049D", hash_generated_field = "57E8521AC9CBFD385A5C49D98FB81CDC")

    private int mDefaultColor = 0xffff0000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.716 -0400", hash_original_method = "A1B9AA8D55CC71F4C566F389AC3D8BBC", hash_generated_method = "B853D9FA4CC0F774905FDCA69D04F16F")
    private  ColorStateList() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.717 -0400", hash_original_method = "16DE5E515D4E313298C804E12AA820B9", hash_generated_method = "1A5568500CA502E67D3B8CE53B556B7F")
    public  ColorStateList(int[][] states, int[] colors) {
        mStateSpecs = states;
        mColors = colors;
    if(states.length > 0)        
        {
            mDefaultColor = colors[0];
for(int i = 0;i < states.length;i++)
            {
    if(states[i].length == 0)                
                {
                    mDefaultColor = colors[i];
                } 
            } 
        } 
        
        
        
        
            
            
                
                    
                
            
        
    }

    
        public static ColorStateList valueOf(int color) {
        synchronized (sCache) {
            WeakReference<ColorStateList> ref = sCache.get(color);
            ColorStateList csl = ref != null ? ref.get() : null;
            if (csl != null) {
                return csl;
            }
            csl = new ColorStateList(EMPTY, new int[] { color });
            sCache.put(color, new WeakReference<ColorStateList>(csl));
            return csl;
        }
    }

    
        public static ColorStateList createFromXml(Resources r, XmlPullParser parser) throws XmlPullParserException, IOException {
        AttributeSet attrs = Xml.asAttributeSet(parser);
        int type;
        while ((type=parser.next()) != XmlPullParser.START_TAG
                   && type != XmlPullParser.END_DOCUMENT) {
        }
        if (type != XmlPullParser.START_TAG) {
            throw new XmlPullParserException("No start tag found");
        }
        return createFromXmlInner(r, parser, attrs);
    }

    
        private static ColorStateList createFromXmlInner(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {
        ColorStateList colorStateList;
        final String name = parser.getName();
        if (name.equals("selector")) {
            colorStateList = new ColorStateList();
        } else {
            throw new XmlPullParserException(
                parser.getPositionDescription() + ": invalid drawable tag " + name);
        }
        colorStateList.inflate(r, parser, attrs);
        return colorStateList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.719 -0400", hash_original_method = "C02A6B069CD8C9360FEC8CA407C14B4A", hash_generated_method = "6865613E19B3815BDFE13A63CB1CBE47")
    public ColorStateList withAlpha(int alpha) {
        addTaint(alpha);
        int[] colors = new int[mColors.length];
        int len = colors.length;
for(int i = 0;i < len;i++)
        {
            colors[i] = (mColors[i] & 0xFFFFFF) | (alpha << 24);
        } 
ColorStateList var3DD0BBD465CAAA82779B9248F9A3D5BF_995728275 =         new ColorStateList(mStateSpecs, colors);
        var3DD0BBD465CAAA82779B9248F9A3D5BF_995728275.addTaint(taint);
        return var3DD0BBD465CAAA82779B9248F9A3D5BF_995728275;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.722 -0400", hash_original_method = "096D4D4F0EE82FD61B43B813E755281E", hash_generated_method = "AAD434BE8BFC7F954A4492214EFF1EF6")
    private void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        int type;
        final int innerDepth = parser.getDepth()+1;
        int depth;
        int listAllocated = 20;
        int listSize = 0;
        int[] colorList = new int[listAllocated];
        int[][] stateSpecList = new int[listAllocated][];
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
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
            int colorRes = 0;
            int color = 0xffff0000;
            boolean haveColor = false;
            int i;
            int j = 0;
            final int numAttrs = attrs.getAttributeCount();
            int[] stateSpec = new int[numAttrs];
for(i = 0;i < numAttrs;i++)
            {
                final int stateResId = attrs.getAttributeNameResource(i);
    if(stateResId == 0)                
                break;
    if(stateResId == com.android.internal.R.attr.color)                
                {
                    colorRes = attrs.getAttributeResourceValue(i, 0);
    if(colorRes == 0)                    
                    {
                        color = attrs.getAttributeIntValue(i, color);
                        haveColor = true;
                    } 
                } 
                else
                {
                    stateSpec[j++] = attrs.getAttributeBooleanValue(i, false)
                                  ? stateResId
                                  : -stateResId;
                } 
            } 
            stateSpec = StateSet.trimStateSet(stateSpec, j);
    if(colorRes != 0)            
            {
                color = r.getColor(colorRes);
            } 
            else
    if(!haveColor)            
            {
                XmlPullParserException var026DDF440CEE724E4E77FAC9736CB4D3_220204383 = new XmlPullParserException(
                        parser.getPositionDescription()
                        + ": <item> tag requires a 'android:color' attribute.");
                var026DDF440CEE724E4E77FAC9736CB4D3_220204383.addTaint(taint);
                throw var026DDF440CEE724E4E77FAC9736CB4D3_220204383;
            } 
    if(listSize == 0 || stateSpec.length == 0)            
            {
                mDefaultColor = color;
            } 
    if(listSize + 1 >= listAllocated)            
            {
                listAllocated = ArrayUtils.idealIntArraySize(listSize + 1);
                int[] ncolor = new int[listAllocated];
                System.arraycopy(colorList, 0, ncolor, 0, listSize);
                int[][] nstate = new int[listAllocated][];
                System.arraycopy(stateSpecList, 0, nstate, 0, listSize);
                colorList = ncolor;
                stateSpecList = nstate;
            } 
            colorList[listSize] = color;
            stateSpecList[listSize] = stateSpec;
            listSize++;
        } 
        mColors = new int[listSize];
        mStateSpecs = new int[listSize][];
        System.arraycopy(colorList, 0, mColors, 0, listSize);
        System.arraycopy(stateSpecList, 0, mStateSpecs, 0, listSize);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.723 -0400", hash_original_method = "1C923E0661B9E6FB6B4C6C1FDCEBD767", hash_generated_method = "F22548537C5AFC5398523BAF80CA6854")
    public boolean isStateful() {
        boolean varE10B369199E1AC74C448DAA7938908FC_1787841065 = (mStateSpecs.length > 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879583090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_879583090;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.723 -0400", hash_original_method = "4327A241B2C451B5F5DDB6DF79352F03", hash_generated_method = "56AAA8C9EC1D81928246A5F7181E2F04")
    public int getColorForState(int[] stateSet, int defaultColor) {
        addTaint(defaultColor);
        addTaint(stateSet[0]);
        final int setLength = mStateSpecs.length;
for(int i = 0;i < setLength;i++)
        {
            int[] stateSpec = mStateSpecs[i];
    if(StateSet.stateSetMatches(stateSpec, stateSet))            
            {
                int varEFD1363BD01A6BD85E174C4B82BC9D4F_1545378745 = (mColors[i]);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16564314 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16564314;
            } 
        } 
        int varC70EAEDB17963A6537F334D99DE972DE_1012919628 = (defaultColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600777206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600777206;
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.724 -0400", hash_original_method = "28A9CB761E85FC98D00C67A51FDC0266", hash_generated_method = "D5E65D32D6FBE278611E27603BFC5042")
    public int getDefaultColor() {
        int var27A2282CE852080081DD6A76ACF8DAC0_1252600221 = (mDefaultColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1793360266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1793360266;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.724 -0400", hash_original_method = "1483B624C0E3738F481F261D24FE0627", hash_generated_method = "202E764973F141B8C52F531A56AFC31B")
    public String toString() {
String var214C2B72655A76B1EFDC24D7C88B2748_234513353 =         "ColorStateList{" +
               "mStateSpecs=" + Arrays.deepToString(mStateSpecs) +
               "mColors=" + Arrays.toString(mColors) +
               "mDefaultColor=" + mDefaultColor + '}';
        var214C2B72655A76B1EFDC24D7C88B2748_234513353.addTaint(taint);
        return var214C2B72655A76B1EFDC24D7C88B2748_234513353;
        
        
               
               
               
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.724 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "40AFB68B4EFCB9E79903EC6AA92F1537")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_794853710 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153408660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153408660;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.725 -0400", hash_original_method = "E1B2D8F50F6285FEE430316C6FD92D49", hash_generated_method = "D6CC8C8FA6F92F7A45F6F8C229CE54D7")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        final int N = mStateSpecs.length;
        dest.writeInt(N);
for(int i=0;i<N;i++)
        {
            dest.writeIntArray(mStateSpecs[i]);
        } 
        dest.writeIntArray(mColors);
        
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.725 -0400", hash_original_field = "080ED7BBEFB1373EE8C4DA7AC0219B51", hash_generated_field = "41F1B900ACFD3D3CE9828C8FBA43A76D")

    private static final int[][] EMPTY = new int[][] { new int[0] };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.725 -0400", hash_original_field = "38EF06A4AFF04E20ADCD0BEE948F04D6", hash_generated_field = "63E4E9738983D663C4BF9E32C63A6A40")

    private static final SparseArray<WeakReference<ColorStateList>> sCache = new SparseArray<WeakReference<ColorStateList>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.725 -0400", hash_original_field = "1BBFF86921A48C3AD8A7B5472F436B50", hash_generated_field = "C7405A28A73CE53110DBA3CB822ABCA2")

    public static final Parcelable.Creator<ColorStateList> CREATOR =
            new Parcelable.Creator<ColorStateList>() {
        public ColorStateList[] newArray(int size) {
            return new ColorStateList[size];
        }

        public ColorStateList createFromParcel(Parcel source) {
            final int N = source.readInt();
            int[][] stateSpecs = new int[N][];
            for (int i=0; i<N; i++) {
                stateSpecs[i] = source.createIntArray();
            }
            int[] colors = source.createIntArray();
            return new ColorStateList(stateSpecs, colors);
        }
    };
    
    public ColorStateList createFromParcel(Parcel source) {
            final int N = source.readInt();
            int[][] stateSpecs = new int[N][];
            for (int i=0; i<N; i++) {
                stateSpecs[i] = source.createIntArray();
            }
            int[] colors = source.createIntArray();
            return new ColorStateList(stateSpecs, colors);
        }
    
    
    public ColorStateList[] newArray(int size) {
            return new ColorStateList[size];
        }
    
}

