package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.content.Context;
import android.util.Log;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.util.Slog;
public abstract class WindowOrientationListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.394 -0400", hash_original_field = "8CDFC97B128FB94D2A2F11FDAFFE50EA", hash_generated_field = "D8CC5B9F3DF5D78484C533BB7CDDA85C")

    private SensorManager mSensorManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.394 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "7A48C52BD142368ED44BC086FD9013A2")

    private boolean mEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.395 -0400", hash_original_field = "0FD08C74C4D82D468CDF1481B7D89AF9", hash_generated_field = "BE07B5837627C44B4A750B5B53456AEF")

    private int mRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.395 -0400", hash_original_field = "A02F29ACFE4449E0DE24BBE968EA7FD1", hash_generated_field = "CDAC787E68614CF3C3876914F547165F")

    private Sensor mSensor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.395 -0400", hash_original_field = "2EA4F09FB971E19728BD37B9F29E0383", hash_generated_field = "8FA9CEF83E32D696E50DA8AC92C3276C")

    private SensorEventListenerImpl mSensorEventListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.396 -0400", hash_original_field = "94DE540A98BFD3023C14AB26EEA60528", hash_generated_field = "97AFA1868C3B16FEE3C3BD75660D3095")

    boolean mLogEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.396 -0400", hash_original_field = "03D7EDB1100878DE9182BD05EC5807C9", hash_generated_field = "1CD2B2D4D62200C0F224AD78A4A17E12")

    int mCurrentRotation = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.397 -0400", hash_original_method = "A82A711A75082F1132E0302F45D19386", hash_generated_method = "049BDA23C83063E6655AFE2B2F42B2F2")
    public  WindowOrientationListener(Context context) {
        this(context, SensorManager.SENSOR_DELAY_UI);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.398 -0400", hash_original_method = "FA32512194D1044CA10829E498D54F58", hash_generated_method = "4A6BD2F7E047E34312233BED19EB5751")
    private  WindowOrientationListener(Context context, int rate) {
        addTaint(rate);
        addTaint(context.getTaint());
mSensorManager=(SensorManager) context.getSystemService(Context.SENSOR_SERVICE)mRate=ratemSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)        if(mSensor!=null)        
        {
mSensorEventListener=new SensorEventListenerImpl(this)
        } //End block
        // ---------- Original Method ----------
        //mSensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        //mRate = rate;
        //mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //if (mSensor != null) {
            //mSensorEventListener = new SensorEventListenerImpl(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.399 -0400", hash_original_method = "29A758F5A1A01F349D632A06364B75CB", hash_generated_method = "FC7711776D71364877E839CC8BA4A9F4")
    public void enable() {
        if(mSensor==null)        
        {
            return;
        } //End block
        if(mEnabled==false)        
        {
            if(localLOGV)            
Log.d(TAG, "WindowOrientationListener enabled")
mSensorManager.registerListener(mSensorEventListener, mSensor, mRate)mEnabled=true
        } //End block
        // ---------- Original Method ----------
        //if (mSensor == null) {
            //Log.w(TAG, "Cannot detect sensors. Not enabled");
            //return;
        //}
        //if (mEnabled == false) {
            //if (localLOGV) Log.d(TAG, "WindowOrientationListener enabled");
            //mSensorManager.registerListener(mSensorEventListener, mSensor, mRate);
            //mEnabled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.400 -0400", hash_original_method = "0F2BE7915022F1B9CA61A48D1BA329F2", hash_generated_method = "3C632D131BC56044D554D7AE430DEF84")
    public void disable() {
        if(mSensor==null)        
        {
            return;
        } //End block
        if(mEnabled==true)        
        {
            if(localLOGV)            
Log.d(TAG, "WindowOrientationListener disabled")
mSensorManager.unregisterListener(mSensorEventListener)mEnabled=false
        } //End block
        // ---------- Original Method ----------
        //if (mSensor == null) {
            //Log.w(TAG, "Cannot detect sensors. Invalid disable");
            //return;
        //}
        //if (mEnabled == true) {
            //if (localLOGV) Log.d(TAG, "WindowOrientationListener disabled");
            //mSensorManager.unregisterListener(mSensorEventListener);
            //mEnabled = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.401 -0400", hash_original_method = "64D97DEFBD47C980E3FA8DA999EC4EB6", hash_generated_method = "7D501D8DD2F48A0E2D9D2B6057880F0D")
    public void setCurrentRotation(int rotation) {
        addTaint(rotation);
mCurrentRotation=rotation
        // ---------- Original Method ----------
        //mCurrentRotation = rotation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.403 -0400", hash_original_method = "DC58F8A887830BD07E8A1DBF7E69B5D6", hash_generated_method = "158E5834E88DA832873066CDBD165ADD")
    public int getProposedRotation() {
        if(mEnabled)        
        {
            int varE14009A4F9B22692DA43CB341F1C62C8_1708696639 = (mSensorEventListener.getProposedRotation());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1382120149 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1382120149;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_281252173 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112604107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112604107;
        // ---------- Original Method ----------
        //if (mEnabled) {
            //return mSensorEventListener.getProposedRotation();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.405 -0400", hash_original_method = "1094A3B76B1DFEFFD525547DCAE398E5", hash_generated_method = "CAD1F4017843491D1CE930AD94617B92")
    public boolean canDetectOrientation() {
        boolean varAB21E133C2EBAFA58A96FF02589DCF3E_1118320011 = (mSensor!=null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900228251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900228251;
        // ---------- Original Method ----------
        //return mSensor != null;
    }

    
    public abstract void onProposedRotationChanged(int rotation);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.407 -0400", hash_original_method = "1D30F0C11E35442BA40BC09385F2CF44", hash_generated_method = "DD04EB74B7E51C4775098884084EB9D0")
    public void setLogEnabled(boolean enable) {
        addTaint(enable);
mLogEnabled=enable
        // ---------- Original Method ----------
        //mLogEnabled = enable;
    }

    
    static final class SensorEventListenerImpl implements SensorEventListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.408 -0400", hash_original_field = "50920FA74A0A918F73F6B58F3557DA9D", hash_generated_field = "83346557E7D23900DF28602C10033DB5")

        private WindowOrientationListener mOrientationListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.408 -0400", hash_original_field = "2499EF31312ECEC9DD457BA5425C8B46", hash_generated_field = "22FF225F00CA0D3D60D7259853F88626")

        private long mLastTimestamp = Long.MAX_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.409 -0400", hash_original_field = "90B1FC4E099485A717D6F52EC6FEE10A", hash_generated_field = "9A3D874A68918D68174D2619B9FB82A0")

        private float mLastFilteredX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.409 -0400", hash_original_field = "42F3624FE0B423C3A90729D5C4CCF9CC", hash_generated_field = "F59E70E37E8F1B4E9212361939FB74FC")

        private float mLastFilteredY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.409 -0400", hash_original_field = "B5E8170844E5E5D6A8ACBDA9E09C6DE7", hash_generated_field = "9DD284CAB96150768B1C5E962CE96CBA")

        private float mLastFilteredZ;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.410 -0400", hash_original_field = "8F55C46244AC984731C624834275D1CB", hash_generated_field = "7CBBFE3CEFCE0C2B591AE588256B4126")

        private int mProposalRotation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.410 -0400", hash_original_field = "0F7467518BB5FC86E3455CDFE9FB6428", hash_generated_field = "22B9B57AE2D24A5814F934EE25FBF4E8")

        private long mProposalAgeMS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.410 -0400", hash_original_field = "CC81EA898DE278FF2BF3FF22B569E809", hash_generated_field = "E1A24ED88541ACB68757B51ABC250894")

        private int mHistoryIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.410 -0400", hash_original_field = "7A09B8B9A3CCA5FB79F8FA50F597FEF2", hash_generated_field = "AC15AB78B88FBD2FC2B79C56E067012B")

        private int mHistoryLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.411 -0400", hash_original_field = "3589FD5D835E6067278531AC303F106A", hash_generated_field = "42CFA2F453996CB0B33AC9CA54D22F2D")

        private final long[] mHistoryTimestampMS = new long;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.411 -0400", hash_original_field = "A0B48C02BC858DAB49069ED62EA653D4", hash_generated_field = "C0F5B162BDD985221F05341AA1F043AC")

        private final float[] mHistoryMagnitudes = new float;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.411 -0400", hash_original_field = "FD5FC0B5C4E7BC85BD62B4FD11800108", hash_generated_field = "2EB04AA49AFD1A43CB8D9BF251E81734")

        private final int[] mHistoryTiltAngles = new int;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.412 -0400", hash_original_field = "ECCE24E81EA23BBC81D42CBC40085C52", hash_generated_field = "4860BA74BF4FBE66ABC2DA8A9F09137F")

        private final int[] mHistoryOrientationAngles = new int;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.412 -0400", hash_original_method = "56217EE38FC6311D8ABD1C486190CA3A", hash_generated_method = "4FD7F545A60878D00234E44EF7E4D6DD")
        public  SensorEventListenerImpl(WindowOrientationListener orientationListener) {
            addTaint(orientationListener.getTaint());
mOrientationListener=orientationListener
            // ---------- Original Method ----------
            //mOrientationListener = orientationListener;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.414 -0400", hash_original_method = "9688614F043505EDF096E3FD9D83BAFA", hash_generated_method = "BDB914984297DE120E2085D7370D46E5")
        public int getProposedRotation() {
            int var0DFE01F207B38FF6963EF1101385FAB2_507136786 = (mProposalAgeMS>=SETTLE_TIME_MS?mProposalRotation:mProposalRotation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861421034 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861421034;
            // ---------- Original Method ----------
            //return mProposalAgeMS >= SETTLE_TIME_MS ? mProposalRotation : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.415 -0400", hash_original_method = "203A2951410283BC62BAF2E5CECD84FA", hash_generated_method = "70960CB13F9799BF0972843E32C9F061")
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(accuracy);
            addTaint(sensor.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.419 -0400", hash_original_method = "A434D6835BDE74F53A4F8B36F69E0484", hash_generated_method = "417CB17C0F58ACA5C7E94D90775C6959")
        @Override
        public void onSensorChanged(SensorEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            final boolean log = mOrientationListener.mLogEnabled;
            float x = event.values[ACCELEROMETER_DATA_X];
            float y = event.values[ACCELEROMETER_DATA_Y];
            float z = event.values[ACCELEROMETER_DATA_Z];
            if(log)            
            {
            } //End block
            final long now = event.timestamp;
            final float timeDeltaMS = (now - mLastTimestamp) * 0.000001f;
            boolean skipSample;
            if(timeDeltaMS<=0||timeDeltaMS>MAX_FILTER_DELTA_TIME_MS||(x==0&&y==0&&z==0))            
            {
                if(log)                
                {
                } //End block
clearProposal()skipSample=true
            } //End block
            else
            {
                final float alpha = timeDeltaMS / (FILTER_TIME_CONSTANT_MS + timeDeltaMS);
x=alpha*(x-mLastFilteredX)+mLastFilteredXy=alpha*(y-mLastFilteredY)+mLastFilteredYz=alpha*(z-mLastFilteredZ)+mLastFilteredZ                if(log)                
                {
                } //End block
skipSample=false
            } //End block
mLastTimestamp=nowmLastFilteredX=xmLastFilteredY=ymLastFilteredZ=z            final int oldProposedRotation = getProposedRotation();
            if(!skipSample)            
            {
                final float magnitude = (float) Math.sqrt(x * x + y * y + z * z);
                if(magnitude<MIN_ACCELERATION_MAGNITUDE||magnitude>MAX_ACCELERATION_MAGNITUDE)                
                {
                    if(log)                    
                    {
                    } //End block
clearProposal()
                } //End block
                else
                {
                    final int tiltAngle = (int) Math.round(
                            Math.asin(z / magnitude) * RADIANS_TO_DEGREES);
                    if(Math.abs(tiltAngle)>MAX_TILT)                    
                    {
                        if(log)                        
                        {
                        } //End block
clearProposal()
                    } //End block
                    else
                    {
                        int orientationAngle = (int) Math.round(
                                -Math.atan2(-x, y) * RADIANS_TO_DEGREES);
                        if(orientationAngle<0)                        
                        {
orientationAngle+=360
                        } //End block
                        int nearestRotation = (orientationAngle + 45) / 90;
                        if(nearestRotation==4)                        
                        {
nearestRotation=0
                        } //End block
                        if(!isTiltAngleAcceptable(nearestRotation, tiltAngle)||!isOrientationAngleAcceptable(nearestRotation, orientationAngle))                        
                        {
                            if(log)                            
                            {
                            } //End block
clearProposal()
                        } //End block
                        else
                        {
                            if(log)                            
                            {
                            } //End block
updateProposal(nearestRotation, now/1000000L, magnitude, tiltAngle, orientationAngle)
                        } //End block
                    } //End block
                } //End block
            } //End block
            final int proposedRotation = getProposedRotation();
            if(log)            
            {
                final float proposalConfidence = Math.min(
                        mProposalAgeMS * 1.0f / SETTLE_TIME_MS, 1.0f);
            } //End block
            if(proposedRotation!=oldProposedRotation&&proposedRotation>=0)            
            {
                if(log)                
                {
                } //End block
mOrientationListener.onProposedRotationChanged(proposedRotation)
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.424 -0400", hash_original_method = "7D2375C59A0A7C805389CA08D500882E", hash_generated_method = "A7609F6F35C4869AEEF37952074FD936")
        private boolean isTiltAngleAcceptable(int proposedRotation,
                int tiltAngle) {
            addTaint(tiltAngle);
            addTaint(proposedRotation);
            boolean var12544289316279D70A6CF51D33575B21_1904594489 = (tiltAngle>=TILT_TOLERANCE[proposedRotation][0]&&tiltAngle<=TILT_TOLERANCE[proposedRotation][1]);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785157916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785157916;
            // ---------- Original Method ----------
            //return tiltAngle >= TILT_TOLERANCE[proposedRotation][0]
                    //&& tiltAngle <= TILT_TOLERANCE[proposedRotation][1];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.428 -0400", hash_original_method = "BA9208B8B5B6F372B19974951045C955", hash_generated_method = "AE7ACE17BA415347F7ED4BF93B3B19A8")
        private boolean isOrientationAngleAcceptable(int proposedRotation, int orientationAngle) {
            addTaint(orientationAngle);
            addTaint(proposedRotation);
            final int currentRotation = mOrientationListener.mCurrentRotation;
            if(currentRotation>=0)            
            {
                if(proposedRotation==currentRotation||proposedRotation==(currentRotation+1)%4)                
                {
                    int lowerBound = proposedRotation * 90 - 45
                            + ADJACENT_ORIENTATION_ANGLE_GAP / 2;
                    if(proposedRotation==0)                    
                    {
                        if(orientationAngle>=315&&orientationAngle<lowerBound+360)                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_1007869228 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93179436 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_93179436;
                        } //End block
                    } //End block
                    else
                    {
                        if(orientationAngle<lowerBound)                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_1162829782 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910780279 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_910780279;
                        } //End block
                    } //End block
                } //End block
                if(proposedRotation==currentRotation||proposedRotation==(currentRotation+3)%4)                
                {
                    int upperBound = proposedRotation * 90 + 45
                            - ADJACENT_ORIENTATION_ANGLE_GAP / 2;
                    if(proposedRotation==0)                    
                    {
                        if(orientationAngle<=45&&orientationAngle>upperBound)                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_166507256 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808154867 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_808154867;
                        } //End block
                    } //End block
                    else
                    {
                        if(orientationAngle>upperBound)                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_210497170 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909479958 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_909479958;
                        } //End block
                    } //End block
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_421531921 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008851135 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008851135;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.431 -0400", hash_original_method = "7F304752CA933353346CD20B5154B1BB", hash_generated_method = "3F6DB5B481C11F8BAFF3BE734C261040")
        private void clearProposal() {
mProposalRotation=-1mProposalAgeMS=0
            // ---------- Original Method ----------
            //mProposalRotation = -1;
            //mProposalAgeMS = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.434 -0400", hash_original_method = "05A3B96FF936141BD3DA3763101DE4CA", hash_generated_method = "852A148E7E9C0C9B1703D2BB88FBA286")
        private void updateProposal(int rotation, long timestampMS,
                float magnitude, int tiltAngle, int orientationAngle) {
            addTaint(orientationAngle);
            addTaint(tiltAngle);
            addTaint(magnitude);
            addTaint(timestampMS);
            addTaint(rotation);
            if(mProposalRotation!=rotation)            
            {
mProposalRotation=rotationmHistoryIndex=0mHistoryLength=0
            } //End block
            final int index = mHistoryIndex;
mHistoryTimestampMS[index]=timestampMSmHistoryMagnitudes[index]=magnitudemHistoryTiltAngles[index]=tiltAnglemHistoryOrientationAngles[index]=orientationAnglemHistoryIndex=(index+1)%HISTORY_SIZE            if(mHistoryLength<HISTORY_SIZE)            
            {
mHistoryLength+=1
            } //End block
            long age = 0;
for(int i = 1;i<mHistoryLength;i)
            {
                final int olderIndex = (index + HISTORY_SIZE - i) % HISTORY_SIZE;
                if(Math.abs(mHistoryMagnitudes[olderIndex]-magnitude)>SETTLE_MAGNITUDE_MAX_DELTA)                
                {
                    break;
                } //End block
                if(angleAbsoluteDelta(mHistoryTiltAngles[olderIndex], tiltAngle)>SETTLE_TILT_ANGLE_MAX_DELTA)                
                {
                    break;
                } //End block
                if(angleAbsoluteDelta(mHistoryOrientationAngles[olderIndex], orientationAngle)>SETTLE_ORIENTATION_ANGLE_MAX_DELTA)                
                {
                    break;
                } //End block
age=timestampMS-mHistoryTimestampMS[olderIndex]                if(age>=SETTLE_TIME_MS)                
                {
                    break;
                } //End block
            } //End block
mProposalAgeMS=age
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static int angleAbsoluteDelta(int a, int b) {
            int delta = Math.abs(a - b);
            if (delta > 180) {
                delta = 360 - delta;
            }
            return delta;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.436 -0400", hash_original_field = "67F76D2F4BE4622C131C49BAE1F2E0BB", hash_generated_field = "7A9DBFBF1116CD06FC153A52A65DA6B8")

        private static final float RADIANS_TO_DEGREES = (float) (180/Math.PI);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.437 -0400", hash_original_field = "587EB85D75B583AA54F68A48D172783E", hash_generated_field = "B3E6E1C4D5E584A6CBBB2514C5CEEA2D")

        private static final int ACCELEROMETER_DATA_X = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.438 -0400", hash_original_field = "E09AFB844DE1E7CAF890287AF16DD51F", hash_generated_field = "3E5FF903EFD5D22A0F0191176ABE6BFF")

        private static final int ACCELEROMETER_DATA_Y = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.438 -0400", hash_original_field = "34345AFBABF98E1C4173B6F510652320", hash_generated_field = "EFD167A2C6CF6039C28628BA2E26614D")

        private static final int ACCELEROMETER_DATA_Z = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.438 -0400", hash_original_field = "6DAAFD5B88F29676846E726D9B65052F", hash_generated_field = "58358C086E02AA6A7EE600505B5E651E")

        private static final int HISTORY_SIZE = 20;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.439 -0400", hash_original_field = "487500A373D947DD660FCC161D8FE7CA", hash_generated_field = "C2D33D512EA3FDF2E1073F845E7E3952")

        private static final float MAX_FILTER_DELTA_TIME_MS = 1000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.439 -0400", hash_original_field = "17645E42F5295FCE5A9228EA3D3959E0", hash_generated_field = "C8AD192FCBFC2DCEBE10239F84BCAC40")

        private static final float FILTER_TIME_CONSTANT_MS = 100.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.440 -0400", hash_original_field = "030DC81E649EDD16BFFA0B0985C235EB", hash_generated_field = "EBAADD66A02263CB9223BC986FA9EB14")

        private static final float MIN_ACCELERATION_MAGNITUDE = SensorManager.STANDARD_GRAVITY*0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.440 -0400", hash_original_field = "83844787E0E7A921B980C322CAF29638", hash_generated_field = "9B9E29CEB0349FB611AE82C649410772")

        private static final float MAX_ACCELERATION_MAGNITUDE = SensorManager.STANDARD_GRAVITY*1.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.440 -0400", hash_original_field = "A32E5393DA450A66F9D78C86ADD9EFE5", hash_generated_field = "43E944D08451D274C683CB6D15E9A7D4")

        private static final int MAX_TILT = 75;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.441 -0400", hash_original_field = "937A10F9FC1543768B01ACD057892A15", hash_generated_field = "C9F325225B398D19CBA7329B0EE3A755")

        private static final int[][] TILT_TOLERANCE = new int;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.441 -0400", hash_original_field = "B649B9B9C9C48B10FF3FD51DB90FBA63", hash_generated_field = "A388E6B5B54252A4D9E6BA40E5FF113D")

        private static final int ADJACENT_ORIENTATION_ANGLE_GAP = 45;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.441 -0400", hash_original_field = "E44A329F0CA3023EFC520C4B6DE94B4C", hash_generated_field = "394DE9F806B25CD1232D907CB1F068AC")

        private static final int SETTLE_TIME_MS = 200;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.441 -0400", hash_original_field = "D4D5B9E07AA4F058F9349648D06DBB57", hash_generated_field = "86C357F698456CE6BBB799C8E397B8ED")

        private static final float SETTLE_MAGNITUDE_MAX_DELTA = SensorManager.STANDARD_GRAVITY*0.2f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.442 -0400", hash_original_field = "597FD933A9358BB535B48D26177A430C", hash_generated_field = "A5530077B903BD4278DB48593E30648F")

        private static final int SETTLE_TILT_ANGLE_MAX_DELTA = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.442 -0400", hash_original_field = "87648B7877189130D2C6958747BCCA1A", hash_generated_field = "20C45C9A3BC32D7A4A277D072072118D")

        private static final int SETTLE_ORIENTATION_ANGLE_MAX_DELTA = 5;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.442 -0400", hash_original_field = "96D4ECDA4DCF9E27188018C876F12E03", hash_generated_field = "9F5E974D93F3FBA9D0D0C5F21C40B9FA")

    private static final String TAG = "WindowOrientationListener";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.443 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.443 -0400", hash_original_field = "DAC51AA8449559BB10428AADC6F0C4DE", hash_generated_field = "6A4DAF508D9B4E0F76C69A5FF2358AD7")

    private static final boolean localLOGV = DEBUG||false;
}

