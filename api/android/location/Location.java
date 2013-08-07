package android.location;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;





public class Location implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.581 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "644895AD43D171E05003EF08DEE63C8C")

    private String mProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.581 -0400", hash_original_field = "0FF4023E293539BB0CBB2281B1FBFE9D", hash_generated_field = "39CDFD59B94279CE728BDCF20E03E08D")

    private long mTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.581 -0400", hash_original_field = "1857A1FB07A896723EA711F0AFB93340", hash_generated_field = "269B3D2493D0F96EF61A46FF198ABE0D")

    private double mLatitude = 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.581 -0400", hash_original_field = "E6CF59E79C700CD79A21BF27BBC13455", hash_generated_field = "2C9B2A9CE4E7FB2DE0150E4CBE0B8843")

    private double mLongitude = 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.582 -0400", hash_original_field = "C162B2370B6E9C9396E90B6C83C206DB", hash_generated_field = "AB014DDDC67804474525003E8CCA6813")

    private boolean mHasAltitude = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.582 -0400", hash_original_field = "55C374BD8AF5348A1621EBEF8CD68357", hash_generated_field = "65AF56B9C1C08B51B31BCAF89C7F3B4F")

    private double mAltitude = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.582 -0400", hash_original_field = "4CB9D0B6D768A54407CB02FA19A6EC4C", hash_generated_field = "8CE70E9CD9C32590583FE0B532925C61")

    private boolean mHasSpeed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "650660EA0420A29D90ED9A00E6FC34B9", hash_generated_field = "ABFC05BB8A240BFECCDF9D843EC57200")

    private float mSpeed = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "48CEC0520CC8FD41CF12A50DC73750BA", hash_generated_field = "F1AC4D74AE98BF26D0BA40D4270DBA80")

    private boolean mHasBearing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "338EE98C0A32E90D986E30FC9798FA5B", hash_generated_field = "6BB038E41DD655D9B95C50E3DA08A87F")

    private float mBearing = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "B486DB6648372F35D8207306E1A41C9B", hash_generated_field = "40E3E568925ACF4851792D33B86F0123")

    private boolean mHasAccuracy = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "7815EA36A3E24DCFF7B1F55452C671F8", hash_generated_field = "ED55BE9EA8B3BEA284F24131E9FD0A9A")

    private float mAccuracy = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "7AC7A3C81EDFAF4AE16351926EDACBA4", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "90E9D640B14E41D6C4E69C84771B8965", hash_generated_field = "97C53B5EAC108D3EC1F84D706895F9BD")

    private double mLat1 = 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "9EDC69B2AC3C9DF7E35BC8A81CAB4C27", hash_generated_field = "052169D4CDC5007A7869324FC8CEAEFD")

    private double mLon1 = 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "3DBBDA00AA2D5C2900663409DEC23314", hash_generated_field = "AA6D86402CD4A25FF1E0F4C41D36A40D")

    private double mLat2 = 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "F772A55B9A8C8B28B1412D22DFE80457", hash_generated_field = "8A9E97E6541A3C771F68B1C68C60D06D")

    private double mLon2 = 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "24190082D29C9BABD667CAFF7D867E33", hash_generated_field = "CA9178B97D08F71ACD73BBBB766149DA")

    private float mDistance = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "167BE1A5B6472CB0839D4A309BB792F6", hash_generated_field = "95983693C31B9D94B7F8DF00068BDD2A")

    private float mInitialBearing = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.583 -0400", hash_original_field = "77314E0C583ED59B7DE814672B1053A1", hash_generated_field = "FC7CDADAD690A1BE9FE4854D8EF42339")

    private float[] mResults = new float[2];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.584 -0400", hash_original_method = "70E7035C56BDBF9C3F6572F798B0D4BF", hash_generated_method = "8AB106958B355CB4AC17F4AC5B22BFE5")
    public  Location(String provider) {
        mProvider = provider;
        // ---------- Original Method ----------
        //mProvider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.584 -0400", hash_original_method = "4853EB704C822ED076EB467B9C8220F5", hash_generated_method = "D528599C2E7600E8D84BE753FBDAB844")
    public  Location(Location l) {
        addTaint(l.getTaint());
        set(l);
        // ---------- Original Method ----------
        //set(l);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.584 -0400", hash_original_method = "E894B78E8DAE7217EB8A906829737D1E", hash_generated_method = "9F87EAEF0B688A50D01B5BDBBF0C42A3")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        pw.println(prefix + "mProvider=" + mProvider + " mTime=" + mTime);
        pw.println(prefix + "mLatitude=" + mLatitude + " mLongitude=" + mLongitude);
        pw.println(prefix + "mHasAltitude=" + mHasAltitude + " mAltitude=" + mAltitude);
        pw.println(prefix + "mHasSpeed=" + mHasSpeed + " mSpeed=" + mSpeed);
        pw.println(prefix + "mHasBearing=" + mHasBearing + " mBearing=" + mBearing);
        pw.println(prefix + "mHasAccuracy=" + mHasAccuracy + " mAccuracy=" + mAccuracy);
        pw.println(prefix + "mExtras=" + mExtras);
        // ---------- Original Method ----------
        //pw.println(prefix + "mProvider=" + mProvider + " mTime=" + mTime);
        //pw.println(prefix + "mLatitude=" + mLatitude + " mLongitude=" + mLongitude);
        //pw.println(prefix + "mHasAltitude=" + mHasAltitude + " mAltitude=" + mAltitude);
        //pw.println(prefix + "mHasSpeed=" + mHasSpeed + " mSpeed=" + mSpeed);
        //pw.println(prefix + "mHasBearing=" + mHasBearing + " mBearing=" + mBearing);
        //pw.println(prefix + "mHasAccuracy=" + mHasAccuracy + " mAccuracy=" + mAccuracy);
        //pw.println(prefix + "mExtras=" + mExtras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.586 -0400", hash_original_method = "8A60F1EB9D48909B7AC1F2F058E6CA7B", hash_generated_method = "A5FD920F0D9C1B46242725755E8D0203")
    public void set(Location l) {
        mProvider = l.mProvider;
        mTime = l.mTime;
        mLatitude = l.mLatitude;
        mLongitude = l.mLongitude;
        mHasAltitude = l.mHasAltitude;
        mAltitude = l.mAltitude;
        mHasSpeed = l.mHasSpeed;
        mSpeed = l.mSpeed;
        mHasBearing = l.mHasBearing;
        mBearing = l.mBearing;
        mHasAccuracy = l.mHasAccuracy;
        mAccuracy = l.mAccuracy;
        mExtras = (l.mExtras == null) ? null : new Bundle(l.mExtras);
        // ---------- Original Method ----------
        //mProvider = l.mProvider;
        //mTime = l.mTime;
        //mLatitude = l.mLatitude;
        //mLongitude = l.mLongitude;
        //mHasAltitude = l.mHasAltitude;
        //mAltitude = l.mAltitude;
        //mHasSpeed = l.mHasSpeed;
        //mSpeed = l.mSpeed;
        //mHasBearing = l.mHasBearing;
        //mBearing = l.mBearing;
        //mHasAccuracy = l.mHasAccuracy;
        //mAccuracy = l.mAccuracy;
        //mExtras = (l.mExtras == null) ? null : new Bundle(l.mExtras);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.588 -0400", hash_original_method = "616C057876C322A61AA799FA470B1CEA", hash_generated_method = "9802993BD0F72AB4AC58EEAAA252C63C")
    public void reset() {
        mProvider = null;
        mTime = 0;
        mLatitude = 0;
        mLongitude = 0;
        mHasAltitude = false;
        mAltitude = 0;
        mHasSpeed = false;
        mSpeed = 0;
        mHasBearing = false;
        mBearing = 0;
        mHasAccuracy = false;
        mAccuracy = 0;
        mExtras = null;
        // ---------- Original Method ----------
        //mProvider = null;
        //mTime = 0;
        //mLatitude = 0;
        //mLongitude = 0;
        //mHasAltitude = false;
        //mAltitude = 0;
        //mHasSpeed = false;
        //mSpeed = 0;
        //mHasBearing = false;
        //mBearing = 0;
        //mHasAccuracy = false;
        //mAccuracy = 0;
        //mExtras = null;
    }

    
    @DSModeled(DSC.SAFE)
    public static String convert(double coordinate, int outputType) {
        if (coordinate < -180.0 || coordinate > 180.0 ||
            Double.isNaN(coordinate)) {
            throw new IllegalArgumentException("coordinate=" + coordinate);
        }
        if ((outputType != FORMAT_DEGREES) &&
            (outputType != FORMAT_MINUTES) &&
            (outputType != FORMAT_SECONDS)) {
            throw new IllegalArgumentException("outputType=" + outputType);
        }
        StringBuilder sb = new StringBuilder();
        if (coordinate < 0) {
            sb.append('-');
            coordinate = -coordinate;
        }
        DecimalFormat df = new DecimalFormat("###.#####");
        if (outputType == FORMAT_MINUTES || outputType == FORMAT_SECONDS) {
            int degrees = (int) Math.floor(coordinate);
            sb.append(degrees);
            sb.append(':');
            coordinate -= degrees;
            coordinate *= 60.0;
            if (outputType == FORMAT_SECONDS) {
                int minutes = (int) Math.floor(coordinate);
                sb.append(minutes);
                sb.append(':');
                coordinate -= minutes;
                coordinate *= 60.0;
            }
        }
        sb.append(df.format(coordinate));
        return sb.toString();
    }

    
    public static double convert(String coordinate) {
        if (coordinate == null) {
            throw new NullPointerException("coordinate");
        }
        boolean negative = false;
        if (coordinate.charAt(0) == '-') {
            coordinate = coordinate.substring(1);
            negative = true;
        }
        StringTokenizer st = new StringTokenizer(coordinate, ":");
        int tokens = st.countTokens();
        if (tokens < 1) {
            throw new IllegalArgumentException("coordinate=" + coordinate);
        }
        try {
            String degrees = st.nextToken();
            double val;
            if (tokens == 1) {
                val = Double.parseDouble(degrees);
                return negative ? -val : val;
            }
            String minutes = st.nextToken();
            int deg = Integer.parseInt(degrees);
            double min;
            double sec = 0.0;
            if (st.hasMoreTokens()) {
                min = Integer.parseInt(minutes);
                String seconds = st.nextToken();
                sec = Double.parseDouble(seconds);
            } else {
                min = Double.parseDouble(minutes);
            }
            boolean isNegative180 = negative && (deg == 180) &&
                (min == 0) && (sec == 0);
            if ((deg < 0.0) || (deg > 179 && !isNegative180)) {
                throw new IllegalArgumentException("coordinate=" + coordinate);
            }
            if (min < 0 || min > 59) {
                throw new IllegalArgumentException("coordinate=" +
                        coordinate);
            }
            if (sec < 0 || sec > 59) {
                throw new IllegalArgumentException("coordinate=" +
                        coordinate);
            }
            val = deg*3600.0 + min*60.0 + sec;
            val /= 3600.0;
            return negative ? -val : val;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("coordinate=" + coordinate);
        }
    }

    
    @DSModeled(DSC.BAN)
    private static void computeDistanceAndBearing(double lat1, double lon1,
        double lat2, double lon2, float[] results) {
        int MAXITERS = 20;
        lat1 *= Math.PI / 180.0;
        lat2 *= Math.PI / 180.0;
        lon1 *= Math.PI / 180.0;
        lon2 *= Math.PI / 180.0;
        double a = 6378137.0;
        double b = 6356752.3142;
        double f = (a - b) / a;
        double aSqMinusBSqOverBSq = (a * a - b * b) / (b * b);
        double L = lon2 - lon1;
        double A = 0.0;
        double U1 = Math.atan((1.0 - f) * Math.tan(lat1));
        double U2 = Math.atan((1.0 - f) * Math.tan(lat2));
        double cosU1 = Math.cos(U1);
        double cosU2 = Math.cos(U2);
        double sinU1 = Math.sin(U1);
        double sinU2 = Math.sin(U2);
        double cosU1cosU2 = cosU1 * cosU2;
        double sinU1sinU2 = sinU1 * sinU2;
        double sigma = 0.0;
        double deltaSigma = 0.0;
        double cosSqAlpha = 0.0;
        double cos2SM = 0.0;
        double cosSigma = 0.0;
        double sinSigma = 0.0;
        double cosLambda = 0.0;
        double sinLambda = 0.0;
        double lambda = L;
        for (int iter = 0; iter < MAXITERS; iter++) {
            double lambdaOrig = lambda;
            cosLambda = Math.cos(lambda);
            sinLambda = Math.sin(lambda);
            double t1 = cosU2 * sinLambda;
            double t2 = cosU1 * sinU2 - sinU1 * cosU2 * cosLambda;
            double sinSqSigma = t1 * t1 + t2 * t2; 
            sinSigma = Math.sqrt(sinSqSigma);
            cosSigma = sinU1sinU2 + cosU1cosU2 * cosLambda; 
            sigma = Math.atan2(sinSigma, cosSigma); 
            double sinAlpha = (sinSigma == 0) ? 0.0 :
                cosU1cosU2 * sinLambda / sinSigma; 
            cosSqAlpha = 1.0 - sinAlpha * sinAlpha;
            cos2SM = (cosSqAlpha == 0) ? 0.0 :
                cosSigma - 2.0 * sinU1sinU2 / cosSqAlpha; 
            double uSquared = cosSqAlpha * aSqMinusBSqOverBSq; 
            A = 1 + (uSquared / 16384.0) * 
                (4096.0 + uSquared *
                 (-768 + uSquared * (320.0 - 175.0 * uSquared)));
            double B = (uSquared / 1024.0) * 
                (256.0 + uSquared *
                 (-128.0 + uSquared * (74.0 - 47.0 * uSquared)));
            double C = (f / 16.0) *
                cosSqAlpha *
                (4.0 + f * (4.0 - 3.0 * cosSqAlpha)); 
            double cos2SMSq = cos2SM * cos2SM;
            deltaSigma = B * sinSigma * 
                (cos2SM + (B / 4.0) *
                 (cosSigma * (-1.0 + 2.0 * cos2SMSq) -
                  (B / 6.0) * cos2SM *
                  (-3.0 + 4.0 * sinSigma * sinSigma) *
                  (-3.0 + 4.0 * cos2SMSq)));
            lambda = L +
                (1.0 - C) * f * sinAlpha *
                (sigma + C * sinSigma *
                 (cos2SM + C * cosSigma *
                  (-1.0 + 2.0 * cos2SM * cos2SM))); 
            double delta = (lambda - lambdaOrig) / lambda;
            if (Math.abs(delta) < 1.0e-12) {
                break;
            }
        }
        float distance = (float) (b * A * (sigma - deltaSigma));
        results[0] = distance;
        if (results.length > 1) {
            float initialBearing = (float) Math.atan2(cosU2 * sinLambda,
                cosU1 * sinU2 - sinU1 * cosU2 * cosLambda);
            initialBearing *= 180.0 / Math.PI;
            results[1] = initialBearing;
            if (results.length > 2) {
                float finalBearing = (float) Math.atan2(cosU1 * sinLambda,
                    -sinU1 * cosU2 + cosU1 * sinU2 * cosLambda);
                finalBearing *= 180.0 / Math.PI;
                results[2] = finalBearing;
            }
        }
    }

    
    public static void distanceBetween(double startLatitude, double startLongitude,
        double endLatitude, double endLongitude, float[] results) {
        if (results == null || results.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        computeDistanceAndBearing(startLatitude, startLongitude,
            endLatitude, endLongitude, results);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.591 -0400", hash_original_method = "F7D4263990E83377B0F1337DC2A9789F", hash_generated_method = "F5FBFC3E4D61E52A9A5A0E53219B0846")
    public float distanceTo(Location dest) {
        synchronized
(mResults)        {
            if(mLatitude != mLat1 || mLongitude != mLon1 ||
                dest.mLatitude != mLat2 || dest.mLongitude != mLon2)            
            {
                computeDistanceAndBearing(mLatitude, mLongitude,
                    dest.mLatitude, dest.mLongitude, mResults);
                mLat1 = mLatitude;
                mLon1 = mLongitude;
                mLat2 = dest.mLatitude;
                mLon2 = dest.mLongitude;
                mDistance = mResults[0];
                mInitialBearing = mResults[1];
            } //End block
            float varBF32B1A424992DE40B0D821EE846F814_1617011067 = (mDistance);
                        float var546ADE640B6EDFBC8A086EF31347E768_1163216464 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1163216464;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mResults) {
            //if (mLatitude != mLat1 || mLongitude != mLon1 ||
                //dest.mLatitude != mLat2 || dest.mLongitude != mLon2) {
                //computeDistanceAndBearing(mLatitude, mLongitude,
                    //dest.mLatitude, dest.mLongitude, mResults);
                //mLat1 = mLatitude;
                //mLon1 = mLongitude;
                //mLat2 = dest.mLatitude;
                //mLon2 = dest.mLongitude;
                //mDistance = mResults[0];
                //mInitialBearing = mResults[1];
            //}
            //return mDistance;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.592 -0400", hash_original_method = "EC026D992E5F4947C061D86521AAB3B6", hash_generated_method = "B6BF2DBEAD2BD203A6ADBB2F80ACA6D7")
    public float bearingTo(Location dest) {
        synchronized
(mResults)        {
            if(mLatitude != mLat1 || mLongitude != mLon1 ||
                            dest.mLatitude != mLat2 || dest.mLongitude != mLon2)            
            {
                computeDistanceAndBearing(mLatitude, mLongitude,
                    dest.mLatitude, dest.mLongitude, mResults);
                mLat1 = mLatitude;
                mLon1 = mLongitude;
                mLat2 = dest.mLatitude;
                mLon2 = dest.mLongitude;
                mDistance = mResults[0];
                mInitialBearing = mResults[1];
            } //End block
            float var0A03E24BC3B33DBD95D01480E1E6B381_322907838 = (mInitialBearing);
                        float var546ADE640B6EDFBC8A086EF31347E768_1861471710 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1861471710;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mResults) {
            //if (mLatitude != mLat1 || mLongitude != mLon1 ||
                            //dest.mLatitude != mLat2 || dest.mLongitude != mLon2) {
                //computeDistanceAndBearing(mLatitude, mLongitude,
                    //dest.mLatitude, dest.mLongitude, mResults);
                //mLat1 = mLatitude;
                //mLon1 = mLongitude;
                //mLat2 = dest.mLatitude;
                //mLon2 = dest.mLongitude;
                //mDistance = mResults[0];
                //mInitialBearing = mResults[1];
            //}
            //return mInitialBearing;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.592 -0400", hash_original_method = "BFECE3BB8B622B00AFB7A331FE5F6AF2", hash_generated_method = "3CA1F0AB243F4B6424917ECAB951C519")
    public String getProvider() {
String var0FBB50B5F14310A28A298A4AC9FE2015_1512997039 =         mProvider;
        var0FBB50B5F14310A28A298A4AC9FE2015_1512997039.addTaint(taint);
        return var0FBB50B5F14310A28A298A4AC9FE2015_1512997039;
        // ---------- Original Method ----------
        //return mProvider;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.592 -0400", hash_original_method = "25D5387E6BE9F4E7F6250416A2346065", hash_generated_method = "D4DDA5FD376A8D7A0AB64AD1E0FBF0B0")
    public void setProvider(String provider) {
        mProvider = provider;
        // ---------- Original Method ----------
        //mProvider = provider;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.592 -0400", hash_original_method = "997C67A326545139029C9D8F308B45E1", hash_generated_method = "C56A980FF80A7F944623629C4498B779")
    public long getTime() {
        long varAC4CA5198859A8F40FE4EE1026D3CEC1_1023684514 = (mTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1042684903 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1042684903;
        // ---------- Original Method ----------
        //return mTime;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.592 -0400", hash_original_method = "1825242101B57AC7053134E109B277AF", hash_generated_method = "58DABEC95C53E00275149175E1A0B6A4")
    public void setTime(long time) {
        mTime = time;
        // ---------- Original Method ----------
        //mTime = time;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.593 -0400", hash_original_method = "F25A3F38BD2475F276CF0768419142B9", hash_generated_method = "B355CF4B8D1B773F56A423AAAA04A256")
    public double getLatitude() {
        double varF9F903C408E7A13A84941FB6656F8EFD_842135109 = (mLatitude);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1855769760 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1855769760;
        // ---------- Original Method ----------
        //return mLatitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.593 -0400", hash_original_method = "1F7F9B57342DE3FD3D5D55490B64EE27", hash_generated_method = "FC6A7DC458B61FEDE4D25D69F95BD772")
    public void setLatitude(double latitude) {
        mLatitude = latitude;
        // ---------- Original Method ----------
        //mLatitude = latitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.594 -0400", hash_original_method = "7E07C4F8B2560C863B560B81405E4EA8", hash_generated_method = "CC18AF2437C390B62DA7BC55B70CEEB8")
    public double getLongitude() {
        double var7C3CBAEC265653C71D6DB9C159F9C831_204618787 = (mLongitude);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1428795578 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1428795578;
        // ---------- Original Method ----------
        //return mLongitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.594 -0400", hash_original_method = "D382B7FFFC1832B1199A432F05F295AF", hash_generated_method = "950F51F7A7B87639F3E5F8D3B8F6A89B")
    public void setLongitude(double longitude) {
        mLongitude = longitude;
        // ---------- Original Method ----------
        //mLongitude = longitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.594 -0400", hash_original_method = "8588CDCF553966E03782186D08715F65", hash_generated_method = "A46180E16C4F830469925CB1DB34223A")
    public boolean hasAltitude() {
        boolean varE9B01A07C982BC8168E144ABA5030891_1583162418 = (mHasAltitude);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962523748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962523748;
        // ---------- Original Method ----------
        //return mHasAltitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.594 -0400", hash_original_method = "38598EF38BAA57E5BBA23C5814512D64", hash_generated_method = "D2F78ECABBC9C4F22039814511EC5B16")
    public double getAltitude() {
        double var93BF7340ADB9DF392E329E7CE114E05A_545100970 = (mAltitude);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1012280042 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1012280042;
        // ---------- Original Method ----------
        //return mAltitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.595 -0400", hash_original_method = "8207B2258C8D7E964A376C6D8FB9BDB2", hash_generated_method = "96E91323AADC3BDBE674936065F8BD0C")
    public void setAltitude(double altitude) {
        mAltitude = altitude;
        mHasAltitude = true;
        // ---------- Original Method ----------
        //mAltitude = altitude;
        //mHasAltitude = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.595 -0400", hash_original_method = "5A565618B4FD768311EE533344239248", hash_generated_method = "3C6C4C32C0A06792221D8F9CA2011B2A")
    public void removeAltitude() {
        mAltitude = 0.0f;
        mHasAltitude = false;
        // ---------- Original Method ----------
        //mAltitude = 0.0f;
        //mHasAltitude = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.596 -0400", hash_original_method = "053704FA5AD46F36CEE00CE492DC93E4", hash_generated_method = "65907425F9BEB7AB0A8D6674B04BFCD9")
    public boolean hasSpeed() {
        boolean varBA2273AEA87E9BFB48A7C841DD57F8BC_128380268 = (mHasSpeed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404206945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_404206945;
        // ---------- Original Method ----------
        //return mHasSpeed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.596 -0400", hash_original_method = "CA7E551E55E608E59EEFDA2D55C22485", hash_generated_method = "C48805C243595E1BE16293F1FB4F909C")
    public float getSpeed() {
        float varF80FE44BFAA4753A2445463AD52519E8_404904482 = (mSpeed);
                float var546ADE640B6EDFBC8A086EF31347E768_542340985 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_542340985;
        // ---------- Original Method ----------
        //return mSpeed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.596 -0400", hash_original_method = "34F00EE21F4532CBE8BBCA1E84CB5B7E", hash_generated_method = "FB8501B9FE99D7121D1B6E86551C9B62")
    public void setSpeed(float speed) {
        mSpeed = speed;
        mHasSpeed = true;
        // ---------- Original Method ----------
        //mSpeed = speed;
        //mHasSpeed = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.597 -0400", hash_original_method = "B58ABDA4F4570A6C6402F324866C9A78", hash_generated_method = "092A296900E41495B6AA50E91B45595A")
    public void removeSpeed() {
        mSpeed = 0.0f;
        mHasSpeed = false;
        // ---------- Original Method ----------
        //mSpeed = 0.0f;
        //mHasSpeed = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.597 -0400", hash_original_method = "D55FF6AB44947F083C797EDEE83A6188", hash_generated_method = "3F6056C0D0A9F8B09AED71BDBC18C536")
    public boolean hasBearing() {
        boolean var84BE143ADD98E834BDF5FA4ECD158FA9_1374001663 = (mHasBearing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809097547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809097547;
        // ---------- Original Method ----------
        //return mHasBearing;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.597 -0400", hash_original_method = "AC6CB3B684BB76DAFC78CFB4B9F35C9A", hash_generated_method = "91112BF545AC4F994E09A90BD5D52E7E")
    public float getBearing() {
        float var06CE0DEEB46910502FC6C4C261C865DB_1699987153 = (mBearing);
                float var546ADE640B6EDFBC8A086EF31347E768_1063848819 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1063848819;
        // ---------- Original Method ----------
        //return mBearing;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.598 -0400", hash_original_method = "8FBA12B19B970F6442007D37D9E216CC", hash_generated_method = "035B3DB29D8E98484C2E26C54EE50D52")
    public void setBearing(float bearing) {
        while
(bearing < 0.0f)        
        {
            bearing += 360.0f;
        } //End block
        while
(bearing >= 360.0f)        
        {
            bearing -= 360.0f;
        } //End block
        mBearing = bearing;
        mHasBearing = true;
        // ---------- Original Method ----------
        //while (bearing < 0.0f) {
            //bearing += 360.0f;
        //}
        //while (bearing >= 360.0f) {
            //bearing -= 360.0f;
        //}
        //mBearing = bearing;
        //mHasBearing = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.599 -0400", hash_original_method = "57889AAEA0A214C7174BC35DF28DBD1D", hash_generated_method = "8FAAFFDC9B89944657C7FF0FDF0A1A8A")
    public void removeBearing() {
        mBearing = 0.0f;
        mHasBearing = false;
        // ---------- Original Method ----------
        //mBearing = 0.0f;
        //mHasBearing = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.599 -0400", hash_original_method = "25E2CFAA647DEEE085853277B0217FAA", hash_generated_method = "ECF8CC121BFADF0F00B6AFBC28B84B90")
    public boolean hasAccuracy() {
        boolean varA5A8AB8E33E488FB5C225672205ED774_1052261557 = (mHasAccuracy);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952358788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952358788;
        // ---------- Original Method ----------
        //return mHasAccuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.600 -0400", hash_original_method = "080C41F346C9D7277489423C5A91C89D", hash_generated_method = "805766CD4617CFD36CF41DD10DF9E391")
    public float getAccuracy() {
        float var662D142255956BF41BF8EF5110A28B67_1834234876 = (mAccuracy);
                float var546ADE640B6EDFBC8A086EF31347E768_853421229 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_853421229;
        // ---------- Original Method ----------
        //return mAccuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.600 -0400", hash_original_method = "BF61AAF1E1B3170C7527B801249DD59B", hash_generated_method = "B32716322755EBBD575AAEACFC01BE90")
    public void setAccuracy(float accuracy) {
        mAccuracy = accuracy;
        mHasAccuracy = true;
        // ---------- Original Method ----------
        //mAccuracy = accuracy;
        //mHasAccuracy = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.600 -0400", hash_original_method = "10BF9B2FD08E11C5C21016EDE854825A", hash_generated_method = "53264F9A65193E66F9C1D1CBFC1FBF3D")
    public void removeAccuracy() {
        mAccuracy = 0.0f;
        mHasAccuracy = false;
        // ---------- Original Method ----------
        //mAccuracy = 0.0f;
        //mHasAccuracy = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.601 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "2792CBAB963030106443AD57B90F4A23")
    public Bundle getExtras() {
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_741141421 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_741141421.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_741141421;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.601 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "9B56A595B86963DFD04070AE7AE28FC1")
    public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? null : new Bundle(extras);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.602 -0400", hash_original_method = "5688E2364E565225F14DAE87FCAB3981", hash_generated_method = "D5F86D9520A39049117A0C179C821BC4")
    @Override
    public String toString() {
String var6F3A800E12E4FDE656C7E8769F254149_285689635 =         "Location[mProvider=" + mProvider +
            ",mTime=" + mTime +
            ",mLatitude=" + mLatitude +
            ",mLongitude=" + mLongitude +
            ",mHasAltitude=" + mHasAltitude +
            ",mAltitude=" + mAltitude +
            ",mHasSpeed=" + mHasSpeed +
            ",mSpeed=" + mSpeed +
            ",mHasBearing=" + mHasBearing +
            ",mBearing=" + mBearing +
            ",mHasAccuracy=" + mHasAccuracy +
            ",mAccuracy=" + mAccuracy +
            ",mExtras=" + mExtras + "]";
        var6F3A800E12E4FDE656C7E8769F254149_285689635.addTaint(taint);
        return var6F3A800E12E4FDE656C7E8769F254149_285689635;
        // ---------- Original Method ----------
        //return "Location[mProvider=" + mProvider +
            //",mTime=" + mTime +
            //",mLatitude=" + mLatitude +
            //",mLongitude=" + mLongitude +
            //",mHasAltitude=" + mHasAltitude +
            //",mAltitude=" + mAltitude +
            //",mHasSpeed=" + mHasSpeed +
            //",mSpeed=" + mSpeed +
            //",mHasBearing=" + mHasBearing +
            //",mBearing=" + mBearing +
            //",mHasAccuracy=" + mHasAccuracy +
            //",mAccuracy=" + mAccuracy +
            //",mExtras=" + mExtras + "]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.602 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "31EE60830DB278D5CCB0574F6A5760AB")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_737331714 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796023833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796023833;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.603 -0400", hash_original_method = "32F156010F6C4E7296DBF5DD142C1BEC", hash_generated_method = "2CA0C36603A3E001544DEF45823F352A")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeString(mProvider);
        parcel.writeLong(mTime);
        parcel.writeDouble(mLatitude);
        parcel.writeDouble(mLongitude);
        parcel.writeInt(mHasAltitude ? 1 : 0);
        parcel.writeDouble(mAltitude);
        parcel.writeInt(mHasSpeed ? 1 : 0);
        parcel.writeFloat(mSpeed);
        parcel.writeInt(mHasBearing ? 1 : 0);
        parcel.writeFloat(mBearing);
        parcel.writeInt(mHasAccuracy ? 1 : 0);
        parcel.writeFloat(mAccuracy);
        parcel.writeBundle(mExtras);
        // ---------- Original Method ----------
        //parcel.writeString(mProvider);
        //parcel.writeLong(mTime);
        //parcel.writeDouble(mLatitude);
        //parcel.writeDouble(mLongitude);
        //parcel.writeInt(mHasAltitude ? 1 : 0);
        //parcel.writeDouble(mAltitude);
        //parcel.writeInt(mHasSpeed ? 1 : 0);
        //parcel.writeFloat(mSpeed);
        //parcel.writeInt(mHasBearing ? 1 : 0);
        //parcel.writeFloat(mBearing);
        //parcel.writeInt(mHasAccuracy ? 1 : 0);
        //parcel.writeFloat(mAccuracy);
        //parcel.writeBundle(mExtras);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.603 -0400", hash_original_field = "9342CE59CBCD94918CC8867D1BDAAA24", hash_generated_field = "6F646E70B7136B5A7655BF0A1BCA8DFE")

    public static final int FORMAT_DEGREES = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.603 -0400", hash_original_field = "83AF0CDFF6E0503FC0DCE2C7FE8C16DD", hash_generated_field = "F9E0592649D425449C79A3A33FE4EFA8")

    public static final int FORMAT_MINUTES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.603 -0400", hash_original_field = "8D3587D32CB2F6E70FADE19090856F83", hash_generated_field = "E12DE7371ECF9EEF209A4502097EB80C")

    public static final int FORMAT_SECONDS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.603 -0400", hash_original_field = "7B9F8EB241F1C6244667BCC135160F6F", hash_generated_field = "30FFB99E1ED15C4F1A795AA214D4874A")

    public static final Parcelable.Creator<Location> CREATOR =
        new Parcelable.Creator<Location>() {
        public Location createFromParcel(Parcel in) {
            String provider = in.readString();
            Location l = new Location(provider);
            l.mTime = in.readLong();
            l.mLatitude = in.readDouble();
            l.mLongitude = in.readDouble();
            l.mHasAltitude = in.readInt() != 0;
            l.mAltitude = in.readDouble();
            l.mHasSpeed = in.readInt() != 0;
            l.mSpeed = in.readFloat();
            l.mHasBearing = in.readInt() != 0;
            l.mBearing = in.readFloat();
            l.mHasAccuracy = in.readInt() != 0;
            l.mAccuracy = in.readFloat();
            l.mExtras = in.readBundle();
            return l;
        }

        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    // orphaned legacy method
    public Location createFromParcel(Parcel in) {
            String provider = in.readString();
            Location l = new Location(provider);
            l.mTime = in.readLong();
            l.mLatitude = in.readDouble();
            l.mLongitude = in.readDouble();
            l.mHasAltitude = in.readInt() != 0;
            l.mAltitude = in.readDouble();
            l.mHasSpeed = in.readInt() != 0;
            l.mSpeed = in.readFloat();
            l.mHasBearing = in.readInt() != 0;
            l.mBearing = in.readFloat();
            l.mHasAccuracy = in.readInt() != 0;
            l.mAccuracy = in.readFloat();
            l.mExtras = in.readBundle();
            return l;
        }
    
    // orphaned legacy method
    public Location[] newArray(int size) {
            return new Location[size];
        }
    
}

