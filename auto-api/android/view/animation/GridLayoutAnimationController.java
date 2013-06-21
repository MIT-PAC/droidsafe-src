package android.view.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.Random;

public class GridLayoutAnimationController extends LayoutAnimationController {
    private float mColumnDelay;
    private float mRowDelay;
    private int mDirection;
    private int mDirectionPriority;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.134 -0400", hash_original_method = "44CE70ED19752223312271876AB6E98A", hash_generated_method = "D810DB7D16F8AEAC56B8422EAE50B955")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GridLayoutAnimationController(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.GridLayoutAnimation);
        Animation.Description d;
        d = Animation.Description.parseValue(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.134 -0400", hash_original_method = "635B8E92CCDF8F873CC8B4D59C2B03E9", hash_generated_method = "146F1BB6A6DE34AE74BE719DEDDA0D8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GridLayoutAnimationController(Animation animation) {
        this(animation, 0.5f, 0.5f);
        dsTaint.addTaint(animation.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.134 -0400", hash_original_method = "48DE05A423E3644ACD346758FE8F6FE2", hash_generated_method = "96B1FF2373D895227F17843CEE7DCAB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GridLayoutAnimationController(Animation animation, float columnDelay, float rowDelay) {
        super(animation);
        dsTaint.addTaint(rowDelay);
        dsTaint.addTaint(animation.dsTaint);
        dsTaint.addTaint(columnDelay);
        // ---------- Original Method ----------
        //mColumnDelay = columnDelay;
        //mRowDelay = rowDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.134 -0400", hash_original_method = "3717FF744AD9B352598BB020F584214F", hash_generated_method = "450689E71C6CC041EFEED366823B565E")
    @DSModeled(DSC.SAFE)
    public float getColumnDelay() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mColumnDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.135 -0400", hash_original_method = "9501A5CA0F153641CDBB87B4A0FF2D10", hash_generated_method = "C2427D4F87BF66D0C9B50B5C56DCCF7C")
    @DSModeled(DSC.SAFE)
    public void setColumnDelay(float columnDelay) {
        dsTaint.addTaint(columnDelay);
        // ---------- Original Method ----------
        //mColumnDelay = columnDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.135 -0400", hash_original_method = "4A1DF1219341ECD3C219976F02BC50A3", hash_generated_method = "50E018DB454CAA858B012CAF7E4EC1AB")
    @DSModeled(DSC.SAFE)
    public float getRowDelay() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mRowDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.135 -0400", hash_original_method = "64D555696CC7461EC1F71D4A3CF182E8", hash_generated_method = "37E6446DE1D1CC4047D3E7510FC8DFAF")
    @DSModeled(DSC.SAFE)
    public void setRowDelay(float rowDelay) {
        dsTaint.addTaint(rowDelay);
        // ---------- Original Method ----------
        //mRowDelay = rowDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.135 -0400", hash_original_method = "41E7A7956AF2C8AD22DB281BF2D1824C", hash_generated_method = "1D4019396BE07EB87AE66B9F13776172")
    @DSModeled(DSC.SAFE)
    public int getDirection() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDirection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.135 -0400", hash_original_method = "1018F9EE846F5F3D270E1DDB698C3F6E", hash_generated_method = "474E95B69F95B694C94A64C0D680BA51")
    @DSModeled(DSC.SAFE)
    public void setDirection(int direction) {
        dsTaint.addTaint(direction);
        // ---------- Original Method ----------
        //mDirection = direction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.135 -0400", hash_original_method = "B1015DE18826455B040F95A300414206", hash_generated_method = "C0118CC0AD3C6772D1F523983F578BE2")
    @DSModeled(DSC.SAFE)
    public int getDirectionPriority() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDirectionPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.136 -0400", hash_original_method = "709631E231E1B8C214255AB5EF74A588", hash_generated_method = "308A898BF1A9F9C255B4D3442D0C9B5C")
    @DSModeled(DSC.SAFE)
    public void setDirectionPriority(int directionPriority) {
        dsTaint.addTaint(directionPriority);
        // ---------- Original Method ----------
        //mDirectionPriority = directionPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.136 -0400", hash_original_method = "A375B490E9D5A30E7BEB9896805D2CB7", hash_generated_method = "4A589BE6C0CA23B43F92371ED401305C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean willOverlap() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mColumnDelay < 1.0f || mRowDelay < 1.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.136 -0400", hash_original_method = "13A2BFBB43D7D8280701088FA02E8C51", hash_generated_method = "F7C3D422B856BC9AA954B2FAB31DA529")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected long getDelayForView(View view) {
        dsTaint.addTaint(view.dsTaint);
        ViewGroup.LayoutParams lp;
        lp = view.getLayoutParams();
        AnimationParameters params;
        params = (AnimationParameters) lp.layoutAnimationParameters;
        int column;
        column = getTransformedColumnIndex(params);
        int row;
        row = getTransformedRowIndex(params);
        int rowsCount;
        rowsCount = params.rowsCount;
        int columnsCount;
        columnsCount = params.columnsCount;
        long duration;
        duration = mAnimation.getDuration();
        float columnDelay;
        columnDelay = mColumnDelay * duration;
        float rowDelay;
        rowDelay = mRowDelay * duration;
        float totalDelay;
        long viewDelay;
        {
            mInterpolator = new LinearInterpolator();
        } //End block
        //Begin case PRIORITY_COLUMN 
        viewDelay = (long) (row * rowDelay + column * rowsCount * rowDelay);
        //End case PRIORITY_COLUMN 
        //Begin case PRIORITY_COLUMN 
        totalDelay = rowsCount * rowDelay + columnsCount * rowsCount * rowDelay;
        //End case PRIORITY_COLUMN 
        //Begin case PRIORITY_ROW 
        viewDelay = (long) (column * columnDelay + row * columnsCount * columnDelay);
        //End case PRIORITY_ROW 
        //Begin case PRIORITY_ROW 
        totalDelay = columnsCount * columnDelay + rowsCount * columnsCount * columnDelay;
        //End case PRIORITY_ROW 
        //Begin case PRIORITY_NONE default 
        viewDelay = (long) (column * columnDelay + row * rowDelay);
        //End case PRIORITY_NONE default 
        //Begin case PRIORITY_NONE default 
        totalDelay = columnsCount * columnDelay + rowsCount * rowDelay;
        //End case PRIORITY_NONE default 
        float normalizedDelay;
        normalizedDelay = viewDelay / totalDelay;
        normalizedDelay = mInterpolator.getInterpolation(normalizedDelay);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.137 -0400", hash_original_method = "C50C7512E3339F2A41AD9697D8F57632", hash_generated_method = "161E2C7660726FD6650E41CA7BE9A424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getTransformedColumnIndex(AnimationParameters params) {
        dsTaint.addTaint(params.dsTaint);
        int index;
        {
            Object var998A9FCD617ED3F225652B49EC9B64C8_1660481633 = (getOrder());
            //Begin case ORDER_REVERSE 
            index = params.columnsCount - 1 - params.column;
            //End case ORDER_REVERSE 
            //Begin case ORDER_RANDOM 
            {
                mRandomizer = new Random();
            } //End block
            //End case ORDER_RANDOM 
            //Begin case ORDER_RANDOM 
            index = (int) (params.columnsCount * mRandomizer.nextFloat());
            //End case ORDER_RANDOM 
            //Begin case ORDER_NORMAL default 
            index = params.column;
            //End case ORDER_NORMAL default 
        } //End collapsed parenthetic
        int direction;
        direction = mDirection & DIRECTION_HORIZONTAL_MASK;
        {
            index = params.columnsCount - 1 - index;
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.137 -0400", hash_original_method = "B94231C9BBDDC40F852ECD0311BD9DAC", hash_generated_method = "8E781F92038ED7832A6574DEC9F23D9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getTransformedRowIndex(AnimationParameters params) {
        dsTaint.addTaint(params.dsTaint);
        int index;
        {
            Object var998A9FCD617ED3F225652B49EC9B64C8_965698168 = (getOrder());
            //Begin case ORDER_REVERSE 
            index = params.rowsCount - 1 - params.row;
            //End case ORDER_REVERSE 
            //Begin case ORDER_RANDOM 
            {
                mRandomizer = new Random();
            } //End block
            //End case ORDER_RANDOM 
            //Begin case ORDER_RANDOM 
            index = (int) (params.rowsCount * mRandomizer.nextFloat());
            //End case ORDER_RANDOM 
            //Begin case ORDER_NORMAL default 
            index = params.row;
            //End case ORDER_NORMAL default 
        } //End collapsed parenthetic
        int direction;
        direction = mDirection & DIRECTION_VERTICAL_MASK;
        {
            index = params.rowsCount - 1 - index;
        } //End block
        return dsTaint.getTaintInt();
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
        public int column;
        public int row;
        public int columnsCount;
        public int rowsCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.137 -0400", hash_original_method = "306FDDA070662CC16985D7D7D54EA29B", hash_generated_method = "306FDDA070662CC16985D7D7D54EA29B")
                public AnimationParameters ()
        {
        }


    }


    
    public static final int DIRECTION_LEFT_TO_RIGHT = 0x0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 0x1;
    public static final int DIRECTION_TOP_TO_BOTTOM = 0x0;
    public static final int DIRECTION_BOTTOM_TO_TOP = 0x2;
    public static final int DIRECTION_HORIZONTAL_MASK = 0x1;
    public static final int DIRECTION_VERTICAL_MASK   = 0x2;
    public static final int PRIORITY_NONE   = 0;
    public static final int PRIORITY_COLUMN = 1;
    public static final int PRIORITY_ROW    = 2;
}

