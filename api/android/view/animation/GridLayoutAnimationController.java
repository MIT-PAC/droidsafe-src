package android.view.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Random;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class GridLayoutAnimationController extends LayoutAnimationController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.499 -0500", hash_original_field = "DEC2532CC0C05FCC16238C9C4AB1C58A", hash_generated_field = "81A390036EC25AAFFB1697DEC594D207")

    public static final int DIRECTION_LEFT_TO_RIGHT = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.501 -0500", hash_original_field = "29808D87535F532710EAA939E1C6FB1F", hash_generated_field = "FA49DB6FCE6E16CA1A330F3620DF35DD")

    public static final int DIRECTION_RIGHT_TO_LEFT = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.504 -0500", hash_original_field = "620E5C590C1C6AC8E22BAF071823711D", hash_generated_field = "B69F2B6D4B5690B5C115F42907FFA853")

    public static final int DIRECTION_TOP_TO_BOTTOM = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.506 -0500", hash_original_field = "4715F53CA40556EEB936838634C61AAC", hash_generated_field = "8CA21B3BB876C60365F7F1662F06B536")

    public static final int DIRECTION_BOTTOM_TO_TOP = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.509 -0500", hash_original_field = "3DCAF54F3FC6B6F2D42039341D8AD86E", hash_generated_field = "8534AAD7B6330E6886D0D81307085A61")

    public static final int DIRECTION_HORIZONTAL_MASK = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.513 -0500", hash_original_field = "4F3290EA10B16025A32212B076E4561C", hash_generated_field = "034B6CBCF1E61E536B07C913C9A127B1")

    public static final int DIRECTION_VERTICAL_MASK   = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.516 -0500", hash_original_field = "F41E799DA0AABACB1345443223369EA1", hash_generated_field = "0BF3AF3D13F5507B1F74B75A449FF30D")

    public static final int PRIORITY_NONE   = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.518 -0500", hash_original_field = "7D13E816AC15238B470EFD545571998D", hash_generated_field = "025715DBCBF419245A96116E815BDEA3")

    public static final int PRIORITY_COLUMN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.520 -0500", hash_original_field = "F2D67560EAC404DAD879C7E96C28C045", hash_generated_field = "99052FE202D8E8A5DEA7B9EBA7BD55C1")

    public static final int PRIORITY_ROW    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.523 -0500", hash_original_field = "37D207F3CAE882D11B8F6E7BCE823045", hash_generated_field = "629BDB9D286507ADB5AC44CEFC58428A")

    private float mColumnDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.526 -0500", hash_original_field = "861D8E5D822B3420AA42D6CDB68677F8", hash_generated_field = "4721784781D2BCA01C8500DB42882C15")

    private float mRowDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.528 -0500", hash_original_field = "CCADC966D479FDECD819C1B63381D3A8", hash_generated_field = "1745FCE9A11C63A8CCC7883651828226")

    private int mDirection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.531 -0500", hash_original_field = "A22F98545368697E7BFA796CDFF9A17B", hash_generated_field = "8864A96EB28D62DC4D579E581BD7D010")

    private int mDirectionPriority;

    /**
     * Creates a new grid layout animation controller from external resources.
     *
     * @param context the Context the view  group is running in, through which
     *        it can access the resources
     * @param attrs the attributes of the XML tag that is inflating the
     *        layout animation controller
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.534 -0500", hash_original_method = "44CE70ED19752223312271876AB6E98A", hash_generated_method = "60098B8EA8C1658DCED988BF485B1C85")
    
public GridLayoutAnimationController(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.GridLayoutAnimation);

        Animation.Description d = Animation.Description.parseValue(
                a.peekValue(com.android.internal.R.styleable.GridLayoutAnimation_columnDelay));
        mColumnDelay = d.value;
        d = Animation.Description.parseValue(
                a.peekValue(com.android.internal.R.styleable.GridLayoutAnimation_rowDelay));
        mRowDelay = d.value;
        //noinspection PointlessBitwiseExpression
        mDirection = a.getInt(com.android.internal.R.styleable.GridLayoutAnimation_direction,
                DIRECTION_LEFT_TO_RIGHT | DIRECTION_TOP_TO_BOTTOM);
        mDirectionPriority = a.getInt(com.android.internal.R.styleable.GridLayoutAnimation_directionPriority,
                PRIORITY_NONE);

        a.recycle();
    }

    /**
     * Creates a new layout animation controller with a delay of 50%
     * for both rows and columns and the specified animation.
     *
     * @param animation the animation to use on each child of the view group
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.536 -0500", hash_original_method = "635B8E92CCDF8F873CC8B4D59C2B03E9", hash_generated_method = "070B6C6F29C5E439FA17334A1ABD91F5")
    
public GridLayoutAnimationController(Animation animation) {
        this(animation, 0.5f, 0.5f);
    }

    /**
     * Creates a new layout animation controller with the specified delays
     * and the specified animation.
     *
     * @param animation the animation to use on each child of the view group
     * @param columnDelay the delay by which each column animation must be offset
     * @param rowDelay the delay by which each row animation must be offset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.539 -0500", hash_original_method = "48DE05A423E3644ACD346758FE8F6FE2", hash_generated_method = "B82215A310D13713A871365BB526A891")
    
public GridLayoutAnimationController(Animation animation, float columnDelay, float rowDelay) {
        super(animation);
        mColumnDelay = columnDelay;
        mRowDelay = rowDelay;
    }

    /**
     * Returns the delay by which the children's animation are offset from one
     * column to the other. The delay is expressed as a fraction of the
     * animation duration.
     *
     * @return a fraction of the animation duration
     *
     * @see #setColumnDelay(float)
     * @see #getRowDelay()
     * @see #setRowDelay(float)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.541 -0500", hash_original_method = "3717FF744AD9B352598BB020F584214F", hash_generated_method = "686C96EB1CFC717BF80C2B8C831FA563")
    
public float getColumnDelay() {
        return mColumnDelay;
    }

    /**
     * Sets the delay, as a fraction of the animation duration, by which the
     * children's animations are offset from one column to the other.
     *
     * @param columnDelay a fraction of the animation duration
     *
     * @see #getColumnDelay()
     * @see #getRowDelay()
     * @see #setRowDelay(float)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.544 -0500", hash_original_method = "9501A5CA0F153641CDBB87B4A0FF2D10", hash_generated_method = "4A92AA56499D5B636DB37E39FB542DF7")
    
public void setColumnDelay(float columnDelay) {
        mColumnDelay = columnDelay;
    }

    /**
     * Returns the delay by which the children's animation are offset from one
     * row to the other. The delay is expressed as a fraction of the
     * animation duration.
     *
     * @return a fraction of the animation duration
     *
     * @see #setRowDelay(float)
     * @see #getColumnDelay()
     * @see #setColumnDelay(float)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.547 -0500", hash_original_method = "4A1DF1219341ECD3C219976F02BC50A3", hash_generated_method = "A878D630753AEC0F4DFB501460B6714D")
    
public float getRowDelay() {
        return mRowDelay;
    }
    
    public static class AnimationParameters extends LayoutAnimationController.AnimationParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.572 -0500", hash_original_field = "90576625319AB666908247B08CE7D656", hash_generated_field = "1A00D99B7D583B1BE415D4D1EFC674C4")

        public int column;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.576 -0500", hash_original_field = "3295C82375A7A7DEB6BCB6BCD0CDC92A", hash_generated_field = "FC7E95DA00208F4A4FA29F4E2C950348")

        public int row;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.578 -0500", hash_original_field = "9C7D085D4302AECD758FD0BA4CAF4EBD", hash_generated_field = "DE2C9B64DBA02FB732565AFC9B72C933")

        public int columnsCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.580 -0500", hash_original_field = "9F84C66496857D2C92F351B7382E5EF5", hash_generated_field = "4632F6BDA45FF38F13A6136805C6CC61")

        public int rowsCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.987 -0400", hash_original_method = "838D907A76D7295751639A8A84C023C1", hash_generated_method = "838D907A76D7295751639A8A84C023C1")
        public AnimationParameters ()
        {
            //Synthesized constructor
        }

    }

    /**
     * Sets the delay, as a fraction of the animation duration, by which the
     * children's animations are offset from one row to the other.
     *
     * @param rowDelay a fraction of the animation duration
     *
     * @see #getRowDelay()
     * @see #getColumnDelay()
     * @see #setColumnDelay(float) 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.549 -0500", hash_original_method = "64D555696CC7461EC1F71D4A3CF182E8", hash_generated_method = "06669E81126140DF9490697FABAB98C5")
    
public void setRowDelay(float rowDelay) {
        mRowDelay = rowDelay;
    }

    /**
     * Returns the direction of the animation. {@link #DIRECTION_HORIZONTAL_MASK}
     * and {@link #DIRECTION_VERTICAL_MASK} can be used to retrieve the
     * horizontal and vertical components of the direction.
     *
     * @return the direction of the animation
     *
     * @see #setDirection(int)
     * @see #DIRECTION_BOTTOM_TO_TOP
     * @see #DIRECTION_TOP_TO_BOTTOM
     * @see #DIRECTION_LEFT_TO_RIGHT
     * @see #DIRECTION_RIGHT_TO_LEFT
     * @see #DIRECTION_HORIZONTAL_MASK
     * @see #DIRECTION_VERTICAL_MASK
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.551 -0500", hash_original_method = "41E7A7956AF2C8AD22DB281BF2D1824C", hash_generated_method = "5763099F5F441B75270C6CF5B82F5F4E")
    
public int getDirection() {
        return mDirection;
    }

    /**
     * Sets the direction of the animation. The direction is expressed as an
     * integer containing a horizontal and vertical component. For instance,
     * <code>DIRECTION_BOTTOM_TO_TOP | DIRECTION_RIGHT_TO_LEFT</code>.
     *
     * @param direction the direction of the animation
     *
     * @see #getDirection()
     * @see #DIRECTION_BOTTOM_TO_TOP
     * @see #DIRECTION_TOP_TO_BOTTOM
     * @see #DIRECTION_LEFT_TO_RIGHT
     * @see #DIRECTION_RIGHT_TO_LEFT
     * @see #DIRECTION_HORIZONTAL_MASK
     * @see #DIRECTION_VERTICAL_MASK
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.553 -0500", hash_original_method = "1018F9EE846F5F3D270E1DDB698C3F6E", hash_generated_method = "28F3DBFD504A09FBE40A2EDFB4BEB326")
    
public void setDirection(int direction) {
        mDirection = direction;
    }

    /**
     * Returns the direction priority for the animation. The priority can
     * be either {@link #PRIORITY_NONE}, {@link #PRIORITY_COLUMN} or
     * {@link #PRIORITY_ROW}.
     *
     * @return the priority of the animation direction
     *
     * @see #setDirectionPriority(int)
     * @see #PRIORITY_COLUMN
     * @see #PRIORITY_NONE
     * @see #PRIORITY_ROW
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.556 -0500", hash_original_method = "B1015DE18826455B040F95A300414206", hash_generated_method = "B1BE19AC72E8376C827DD493B3403771")
    
public int getDirectionPriority() {
        return mDirectionPriority;
    }

    /**
     * Specifies the direction priority of the animation. For instance,
     * {@link #PRIORITY_COLUMN} will give priority to columns: the animation
     * will first play on the column, then on the rows.Z
     *
     * @param directionPriority the direction priority of the animation
     *
     * @see #getDirectionPriority()
     * @see #PRIORITY_COLUMN
     * @see #PRIORITY_NONE
     * @see #PRIORITY_ROW
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.558 -0500", hash_original_method = "709631E231E1B8C214255AB5EF74A588", hash_generated_method = "E7F7BA9DF479A24E9FA28FFAD41FF329")
    
public void setDirectionPriority(int directionPriority) {
        mDirectionPriority = directionPriority;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.561 -0500", hash_original_method = "A375B490E9D5A30E7BEB9896805D2CB7", hash_generated_method = "E428D6E189E5525B87EE8BAA6A5670D6")
    
@Override
    public boolean willOverlap() {
        return mColumnDelay < 1.0f || mRowDelay < 1.0f;
    }

    /**
     * {@inheritDoc}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.564 -0500", hash_original_method = "13A2BFBB43D7D8280701088FA02E8C51", hash_generated_method = "11ECC44E3060B8F2953E7D5362E3CAF2")
    
@Override
    protected long getDelayForView(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        AnimationParameters params = (AnimationParameters) lp.layoutAnimationParameters;

        if (params == null) {
            return 0;
        }

        final int column = getTransformedColumnIndex(params);
        final int row = getTransformedRowIndex(params);

        final int rowsCount = params.rowsCount;
        final int columnsCount = params.columnsCount;

        final long duration = mAnimation.getDuration();
        final float columnDelay = mColumnDelay * duration;
        final float rowDelay = mRowDelay * duration;

        float totalDelay;
        long viewDelay;

        if (mInterpolator == null) {
            mInterpolator = new LinearInterpolator();
        }

        switch (mDirectionPriority) {
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
        }

        float normalizedDelay = viewDelay / totalDelay;
        normalizedDelay = mInterpolator.getInterpolation(normalizedDelay);

        return (long) (normalizedDelay * totalDelay);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.566 -0500", hash_original_method = "C50C7512E3339F2A41AD9697D8F57632", hash_generated_method = "1B97D3A51E2FD0D15D1332657A28A3B8")
    
private int getTransformedColumnIndex(AnimationParameters params) {
        int index;
        switch (getOrder()) {
            case ORDER_REVERSE:
                index = params.columnsCount - 1 - params.column;
                break;
            case ORDER_RANDOM:
                if (mRandomizer == null) {
                    mRandomizer = new Random();
                }
                index = (int) (params.columnsCount * mRandomizer.nextFloat());
                break;
            case ORDER_NORMAL:
            default:
                index = params.column;
                break;
        }

        int direction = mDirection & DIRECTION_HORIZONTAL_MASK;
        if (direction == DIRECTION_RIGHT_TO_LEFT) {
            index = params.columnsCount - 1 - index;
        }

        return index;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:56.569 -0500", hash_original_method = "B94231C9BBDDC40F852ECD0311BD9DAC", hash_generated_method = "8C0EF026A540C076CA6BF78F6EC0AD69")
    
private int getTransformedRowIndex(AnimationParameters params) {
        int index;
        switch (getOrder()) {
            case ORDER_REVERSE:
                index = params.rowsCount - 1 - params.row;
                break;
            case ORDER_RANDOM:
                if (mRandomizer == null) {
                    mRandomizer = new Random();
                }
                index = (int) (params.rowsCount * mRandomizer.nextFloat());
                break;
            case ORDER_NORMAL:
            default:
                index = params.row;
                break;
        }

        int direction = mDirection & DIRECTION_VERTICAL_MASK;
        if (direction == DIRECTION_BOTTOM_TO_TOP) {
            index = params.rowsCount - 1 - index;
        }

        return index;
    }
}

