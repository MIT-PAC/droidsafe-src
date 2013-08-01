package android.view.animation;

// Droidsafe Imports
import java.util.Random;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class GridLayoutAnimationController extends LayoutAnimationController {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.979 -0400", hash_original_field = "29CD4D8FF8E5FB724D956AFF9C7C34F0", hash_generated_field = "629BDB9D286507ADB5AC44CEFC58428A")

    private float mColumnDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.979 -0400", hash_original_field = "97A9DC435CAC51E025B6456BF8EAD00A", hash_generated_field = "4721784781D2BCA01C8500DB42882C15")

    private float mRowDelay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.979 -0400", hash_original_field = "58DD5558F1951929038C67E89573E9B3", hash_generated_field = "1745FCE9A11C63A8CCC7883651828226")

    private int mDirection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.979 -0400", hash_original_field = "AD0B39F63BA0052B2AAD900697170EF9", hash_generated_field = "8864A96EB28D62DC4D579E581BD7D010")

    private int mDirectionPriority;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.980 -0400", hash_original_method = "44CE70ED19752223312271876AB6E98A", hash_generated_method = "3D0526DCD4CCE309D9369A98186D4CBD")
    public  GridLayoutAnimationController(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.GridLayoutAnimation);
        Animation.Description d = Animation.Description.parseValue(
                a.peekValue(com.android.internal.R.styleable.GridLayoutAnimation_columnDelay));
        mColumnDelay = d.value;
        d = Animation.Description.parseValue(
                a.peekValue(com.android.internal.R.styleable.GridLayoutAnimation_rowDelay));
        mRowDelay = d.value;
        mDirection = a.getInt(com.android.internal.R.styleable.GridLayoutAnimation_direction,
                DIRECTION_LEFT_TO_RIGHT | DIRECTION_TOP_TO_BOTTOM);
        mDirectionPriority = a.getInt(com.android.internal.R.styleable.GridLayoutAnimation_directionPriority,
                PRIORITY_NONE);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.GridLayoutAnimation);
        //Animation.Description d = Animation.Description.parseValue(
                //a.peekValue(com.android.internal.R.styleable.GridLayoutAnimation_columnDelay));
        //mColumnDelay = d.value;
        //d = Animation.Description.parseValue(
                //a.peekValue(com.android.internal.R.styleable.GridLayoutAnimation_rowDelay));
        //mRowDelay = d.value;
        //mDirection = a.getInt(com.android.internal.R.styleable.GridLayoutAnimation_direction,
                //DIRECTION_LEFT_TO_RIGHT | DIRECTION_TOP_TO_BOTTOM);
        //mDirectionPriority = a.getInt(com.android.internal.R.styleable.GridLayoutAnimation_directionPriority,
                //PRIORITY_NONE);
        //a.recycle();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.980 -0400", hash_original_method = "635B8E92CCDF8F873CC8B4D59C2B03E9", hash_generated_method = "688D07ADC846A0CD46DFC5154F883307")
    public  GridLayoutAnimationController(Animation animation) {
        this(animation, 0.5f, 0.5f);
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.981 -0400", hash_original_method = "48DE05A423E3644ACD346758FE8F6FE2", hash_generated_method = "0474A2F50ECB73AC27C56865DB796200")
    public  GridLayoutAnimationController(Animation animation, float columnDelay, float rowDelay) {
        super(animation);
        addTaint(animation.getTaint());
        mColumnDelay = columnDelay;
        mRowDelay = rowDelay;
        // ---------- Original Method ----------
        //mColumnDelay = columnDelay;
        //mRowDelay = rowDelay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.981 -0400", hash_original_method = "3717FF744AD9B352598BB020F584214F", hash_generated_method = "9426F6E423CB8B38EE902A893F44194D")
    public float getColumnDelay() {
        float var29CD4D8FF8E5FB724D956AFF9C7C34F0_1232362103 = (mColumnDelay);
                float var546ADE640B6EDFBC8A086EF31347E768_1142278152 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1142278152;
        // ---------- Original Method ----------
        //return mColumnDelay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.981 -0400", hash_original_method = "9501A5CA0F153641CDBB87B4A0FF2D10", hash_generated_method = "C7AA2AD84759C6B2FECFC5080692540A")
    public void setColumnDelay(float columnDelay) {
        mColumnDelay = columnDelay;
        // ---------- Original Method ----------
        //mColumnDelay = columnDelay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.982 -0400", hash_original_method = "4A1DF1219341ECD3C219976F02BC50A3", hash_generated_method = "35682D573E7D3CA0569774582F73094C")
    public float getRowDelay() {
        float var97A9DC435CAC51E025B6456BF8EAD00A_1873328465 = (mRowDelay);
                float var546ADE640B6EDFBC8A086EF31347E768_283571217 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_283571217;
        // ---------- Original Method ----------
        //return mRowDelay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.982 -0400", hash_original_method = "64D555696CC7461EC1F71D4A3CF182E8", hash_generated_method = "44CD6692632F04CC8033AC326535A160")
    public void setRowDelay(float rowDelay) {
        mRowDelay = rowDelay;
        // ---------- Original Method ----------
        //mRowDelay = rowDelay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.982 -0400", hash_original_method = "41E7A7956AF2C8AD22DB281BF2D1824C", hash_generated_method = "BE9E96F2BFC986F62B6F137B6FC0A065")
    public int getDirection() {
        int var58DD5558F1951929038C67E89573E9B3_1438857508 = (mDirection);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303604568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303604568;
        // ---------- Original Method ----------
        //return mDirection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.982 -0400", hash_original_method = "1018F9EE846F5F3D270E1DDB698C3F6E", hash_generated_method = "308442DCD74853153DE9BB2BF46521FD")
    public void setDirection(int direction) {
        mDirection = direction;
        // ---------- Original Method ----------
        //mDirection = direction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.983 -0400", hash_original_method = "B1015DE18826455B040F95A300414206", hash_generated_method = "F3E13BF4AF3A7DEE2CDE76C170F2BF44")
    public int getDirectionPriority() {
        int varAD0B39F63BA0052B2AAD900697170EF9_618665814 = (mDirectionPriority);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119005538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119005538;
        // ---------- Original Method ----------
        //return mDirectionPriority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.983 -0400", hash_original_method = "709631E231E1B8C214255AB5EF74A588", hash_generated_method = "ECC5BD2FC1392EAC72A0F198845CE262")
    public void setDirectionPriority(int directionPriority) {
        mDirectionPriority = directionPriority;
        // ---------- Original Method ----------
        //mDirectionPriority = directionPriority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.983 -0400", hash_original_method = "A375B490E9D5A30E7BEB9896805D2CB7", hash_generated_method = "99E0C6226029BF7FAB32AECAA2F5CB42")
    @Override
    public boolean willOverlap() {
        boolean varF55BE30F979F0CAF3C3A5707C7428ADF_102474486 = (mColumnDelay < 1.0f || mRowDelay < 1.0f);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772461079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_772461079;
        // ---------- Original Method ----------
        //return mColumnDelay < 1.0f || mRowDelay < 1.0f;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.985 -0400", hash_original_method = "13A2BFBB43D7D8280701088FA02E8C51", hash_generated_method = "C8EE9558E1965FB7770F061A4D434252")
    @Override
    protected long getDelayForView(View view) {
        addTaint(view.getTaint());
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        AnimationParameters params = (AnimationParameters) lp.layoutAnimationParameters;
        if(params == null)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1344431245 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_643356540 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_643356540;
        } //End block
        final int column = getTransformedColumnIndex(params);
        final int row = getTransformedRowIndex(params);
        final int rowsCount = params.rowsCount;
        final int columnsCount = params.columnsCount;
        final long duration = mAnimation.getDuration();
        final float columnDelay = mColumnDelay * duration;
        final float rowDelay = mRowDelay * duration;
        float totalDelay;
        long viewDelay;
        if(mInterpolator == null)        
        {
            mInterpolator = new LinearInterpolator();
        } //End block
switch(mDirectionPriority){
        case PRIORITY_COLUMN:
        viewDelay = (long) (row * rowDelay + column * rowsCount * rowDelay);
        totalDelay = rowsCount * rowDelay + columnsCount * rowsCount * rowDelay;
        break;
        case PRIORITY_ROW:
        viewDelay = (long) (column * columnDelay + row * columnsCount * columnDelay);
        totalDelay = columnsCount * columnDelay + rowsCount * columnsCount * columnDelay;
        break;
        case PRIORITY_NONE:
        default:
        viewDelay = (long) (column * columnDelay + row * rowDelay);
        totalDelay = columnsCount * columnDelay + rowsCount * rowDelay;
        break;
}        float normalizedDelay = viewDelay / totalDelay;
        normalizedDelay = mInterpolator.getInterpolation(normalizedDelay);
        long varE65571F221469C7C9AAECA50B46EA242_56683977 = ((long) (normalizedDelay * totalDelay));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_240929555 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_240929555;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.986 -0400", hash_original_method = "C50C7512E3339F2A41AD9697D8F57632", hash_generated_method = "1A7FDF04EDEAD4BE994FA425ED034705")
    private int getTransformedColumnIndex(AnimationParameters params) {
        addTaint(params.getTaint());
        int index;
switch(getOrder()){
        case ORDER_REVERSE:
        index = params.columnsCount - 1 - params.column;
        break;
        case ORDER_RANDOM:
        if(mRandomizer == null)        
        {
            mRandomizer = new Random();
        } //End block
        index = (int) (params.columnsCount * mRandomizer.nextFloat());
        break;
        case ORDER_NORMAL:
        default:
        index = params.column;
        break;
}        int direction = mDirection & DIRECTION_HORIZONTAL_MASK;
        if(direction == DIRECTION_RIGHT_TO_LEFT)        
        {
            index = params.columnsCount - 1 - index;
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_1180881453 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305330431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305330431;
        // ---------- Original Method ----------
        //int index;
        //switch (getOrder()) {
            //case ORDER_REVERSE:
                //index = params.columnsCount - 1 - params.column;
                //break;
            //case ORDER_RANDOM:
                //if (mRandomizer == null) {
                    //mRandomizer = new Random();
                //}
                //index = (int) (params.columnsCount * mRandomizer.nextFloat());
                //break;
            //case ORDER_NORMAL:
            //default:
                //index = params.column;
                //break;
        //}
        //int direction = mDirection & DIRECTION_HORIZONTAL_MASK;
        //if (direction == DIRECTION_RIGHT_TO_LEFT) {
            //index = params.columnsCount - 1 - index;
        //}
        //return index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_method = "B94231C9BBDDC40F852ECD0311BD9DAC", hash_generated_method = "F0B46A70D1739178918832BF7AC50BD4")
    private int getTransformedRowIndex(AnimationParameters params) {
        addTaint(params.getTaint());
        int index;
switch(getOrder()){
        case ORDER_REVERSE:
        index = params.rowsCount - 1 - params.row;
        break;
        case ORDER_RANDOM:
        if(mRandomizer == null)        
        {
            mRandomizer = new Random();
        } //End block
        index = (int) (params.rowsCount * mRandomizer.nextFloat());
        break;
        case ORDER_NORMAL:
        default:
        index = params.row;
        break;
}        int direction = mDirection & DIRECTION_VERTICAL_MASK;
        if(direction == DIRECTION_BOTTOM_TO_TOP)        
        {
            index = params.rowsCount - 1 - index;
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_814795464 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995332119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995332119;
        // ---------- Original Method ----------
        //int index;
        //switch (getOrder()) {
            //case ORDER_REVERSE:
                //index = params.rowsCount - 1 - params.row;
                //break;
            //case ORDER_RANDOM:
                //if (mRandomizer == null) {
                    //mRandomizer = new Random();
                //}
                //index = (int) (params.rowsCount * mRandomizer.nextFloat());
                //break;
            //case ORDER_NORMAL:
            //default:
                //index = params.row;
                //break;
        //}
        //int direction = mDirection & DIRECTION_VERTICAL_MASK;
        //if (direction == DIRECTION_BOTTOM_TO_TOP) {
            //index = params.rowsCount - 1 - index;
        //}
        //return index;
    }

    
    public static class AnimationParameters extends LayoutAnimationController.AnimationParameters {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "1AFD32818D1C9525F82AFF4C09EFD254", hash_generated_field = "1A00D99B7D583B1BE415D4D1EFC674C4")

        public int column;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "F1965A857BC285D26FE22023AA5AB50D", hash_generated_field = "FC7E95DA00208F4A4FA29F4E2C950348")

        public int row;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "F7682AA26C1D87923249C9728983B1F3", hash_generated_field = "DE2C9B64DBA02FB732565AFC9B72C933")

        public int columnsCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "F2828631D1A4BBAB89EDC73F7D2E9817", hash_generated_field = "4632F6BDA45FF38F13A6136805C6CC61")

        public int rowsCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_method = "838D907A76D7295751639A8A84C023C1", hash_generated_method = "838D907A76D7295751639A8A84C023C1")
        public AnimationParameters ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "AE5143B0667C59379EDF7E9AED609970", hash_generated_field = "81A390036EC25AAFFB1697DEC594D207")

    public static final int DIRECTION_LEFT_TO_RIGHT = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "F7B62377266859B0699DEE2C3D666509", hash_generated_field = "FA49DB6FCE6E16CA1A330F3620DF35DD")

    public static final int DIRECTION_RIGHT_TO_LEFT = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "2A1A5647491568F95DA82DF7680DF118", hash_generated_field = "B69F2B6D4B5690B5C115F42907FFA853")

    public static final int DIRECTION_TOP_TO_BOTTOM = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_field = "DEAC318983057E2DB0C3D0FE832790D9", hash_generated_field = "8CA21B3BB876C60365F7F1662F06B536")

    public static final int DIRECTION_BOTTOM_TO_TOP = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.988 -0400", hash_original_field = "BC2F42B167C5526F26FBDD3ED91647EE", hash_generated_field = "8534AAD7B6330E6886D0D81307085A61")

    public static final int DIRECTION_HORIZONTAL_MASK = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.988 -0400", hash_original_field = "77455B5179FD9C202633F3177F788A62", hash_generated_field = "034B6CBCF1E61E536B07C913C9A127B1")

    public static final int DIRECTION_VERTICAL_MASK   = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.988 -0400", hash_original_field = "E7ECFEE548A714A04846054D5D979E05", hash_generated_field = "0BF3AF3D13F5507B1F74B75A449FF30D")

    public static final int PRIORITY_NONE   = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.988 -0400", hash_original_field = "B11D7C9D93590F6403AC4E73BAF710EA", hash_generated_field = "025715DBCBF419245A96116E815BDEA3")

    public static final int PRIORITY_COLUMN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.988 -0400", hash_original_field = "8906278510BDD02D69B47F29250284D3", hash_generated_field = "99052FE202D8E8A5DEA7B9EBA7BD55C1")

    public static final int PRIORITY_ROW    = 2;
}

