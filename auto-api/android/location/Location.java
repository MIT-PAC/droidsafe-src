package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Location implements Parcelable {
    private String mProvider;
    private long mTime = 0;
    private double mLatitude = 0.0;
    private double mLongitude = 0.0;
    private boolean mHasAltitude = false;
    private double mAltitude = 0.0f;
    private boolean mHasSpeed = false;
    private float mSpeed = 0.0f;
    private boolean mHasBearing = false;
    private float mBearing = 0.0f;
    private boolean mHasAccuracy = false;
    private float mAccuracy = 0.0f;
    private Bundle mExtras = null;
    private double mLat1 = 0.0;
    private double mLon1 = 0.0;
    private double mLat2 = 0.0;
    private double mLon2 = 0.0;
    private float mDistance = 0.0f;
    private float mInitialBearing = 0.0f;
    private float[] mResults = new float[2];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.911 -0400", hash_original_method = "70E7035C56BDBF9C3F6572F798B0D4BF", hash_generated_method = "77A491EB31DD79A8AB6BC68C51B173F2")
    @DSModeled(DSC.SAFE)
    public Location(String provider) {
        dsTaint.addTaint(provider);
        // ---------- Original Method ----------
        //mProvider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.911 -0400", hash_original_method = "4853EB704C822ED076EB467B9C8220F5", hash_generated_method = "1CE4FE84B1F0468B7DFEE9EE17E96BF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Location(Location l) {
        dsTaint.addTaint(l.dsTaint);
        set(l);
        // ---------- Original Method ----------
        //set(l);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.912 -0400", hash_original_method = "E894B78E8DAE7217EB8A906829737D1E", hash_generated_method = "A0151B41AA3586A1AAA8E7939F7EEBE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.912 -0400", hash_original_method = "8A60F1EB9D48909B7AC1F2F058E6CA7B", hash_generated_method = "4C2DBD9BDAA70FB2CCEAB78F464E0498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(Location l) {
        dsTaint.addTaint(l.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.913 -0400", hash_original_method = "616C057876C322A61AA799FA470B1CEA", hash_generated_method = "9802993BD0F72AB4AC58EEAAA252C63C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.914 -0400", hash_original_method = "F7D4263990E83377B0F1337DC2A9789F", hash_generated_method = "3A818996ABF9553A856DC96CD8886AE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float distanceTo(Location dest) {
        dsTaint.addTaint(dest.dsTaint);
        {
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
        } //End block
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.914 -0400", hash_original_method = "EC026D992E5F4947C061D86521AAB3B6", hash_generated_method = "E2ADC3B9545E55723573CBB47F1845CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float bearingTo(Location dest) {
        dsTaint.addTaint(dest.dsTaint);
        {
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
        } //End block
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.915 -0400", hash_original_method = "BFECE3BB8B622B00AFB7A331FE5F6AF2", hash_generated_method = "12DBDE06E19A4AAA9B5BB637FADDF6BA")
    @DSModeled(DSC.SAFE)
    public String getProvider() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.915 -0400", hash_original_method = "25D5387E6BE9F4E7F6250416A2346065", hash_generated_method = "93FBA8B2270C2D57C000ED7C0D7B9838")
    @DSModeled(DSC.SAFE)
    public void setProvider(String provider) {
        dsTaint.addTaint(provider);
        // ---------- Original Method ----------
        //mProvider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.915 -0400", hash_original_method = "997C67A326545139029C9D8F308B45E1", hash_generated_method = "66D31E185DB01B8EA8F0A4E73C4FE1BE")
    @DSModeled(DSC.SAFE)
    public long getTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.915 -0400", hash_original_method = "1825242101B57AC7053134E109B277AF", hash_generated_method = "6682133E2D1C5D2D280F535369C25825")
    @DSModeled(DSC.SAFE)
    public void setTime(long time) {
        dsTaint.addTaint(time);
        // ---------- Original Method ----------
        //mTime = time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.916 -0400", hash_original_method = "F25A3F38BD2475F276CF0768419142B9", hash_generated_method = "75A1FE36F43BEA9818D74B41ADF23054")
    @DSModeled(DSC.SAFE)
    public double getLatitude() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mLatitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.916 -0400", hash_original_method = "1F7F9B57342DE3FD3D5D55490B64EE27", hash_generated_method = "9316636EEEBB63899490D70AE6B3F1E2")
    @DSModeled(DSC.SAFE)
    public void setLatitude(double latitude) {
        dsTaint.addTaint(latitude);
        // ---------- Original Method ----------
        //mLatitude = latitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.916 -0400", hash_original_method = "7E07C4F8B2560C863B560B81405E4EA8", hash_generated_method = "9755DFAE6BE3134A946F36DBFB7DC168")
    @DSModeled(DSC.SAFE)
    public double getLongitude() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mLongitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.916 -0400", hash_original_method = "D382B7FFFC1832B1199A432F05F295AF", hash_generated_method = "8408B3398F877B5635E0CEF600548E06")
    @DSModeled(DSC.SAFE)
    public void setLongitude(double longitude) {
        dsTaint.addTaint(longitude);
        // ---------- Original Method ----------
        //mLongitude = longitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.916 -0400", hash_original_method = "8588CDCF553966E03782186D08715F65", hash_generated_method = "69F64957C54F78855DCD4FC569F06984")
    @DSModeled(DSC.SAFE)
    public boolean hasAltitude() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasAltitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.917 -0400", hash_original_method = "38598EF38BAA57E5BBA23C5814512D64", hash_generated_method = "E6E9A0C68A1D117DD1C6A6FC79E45F21")
    @DSModeled(DSC.SAFE)
    public double getAltitude() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return mAltitude;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.917 -0400", hash_original_method = "8207B2258C8D7E964A376C6D8FB9BDB2", hash_generated_method = "2B077EEAB59886151D247AA2025CB7CA")
    @DSModeled(DSC.SAFE)
    public void setAltitude(double altitude) {
        dsTaint.addTaint(altitude);
        mHasAltitude = true;
        // ---------- Original Method ----------
        //mAltitude = altitude;
        //mHasAltitude = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.917 -0400", hash_original_method = "5A565618B4FD768311EE533344239248", hash_generated_method = "3C6C4C32C0A06792221D8F9CA2011B2A")
    @DSModeled(DSC.SAFE)
    public void removeAltitude() {
        mAltitude = 0.0f;
        mHasAltitude = false;
        // ---------- Original Method ----------
        //mAltitude = 0.0f;
        //mHasAltitude = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.917 -0400", hash_original_method = "053704FA5AD46F36CEE00CE492DC93E4", hash_generated_method = "59C40952703121F1D228829E5B662786")
    @DSModeled(DSC.SAFE)
    public boolean hasSpeed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.917 -0400", hash_original_method = "CA7E551E55E608E59EEFDA2D55C22485", hash_generated_method = "618FDF83E26D0976F070152A5AF451D1")
    @DSModeled(DSC.SAFE)
    public float getSpeed() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.918 -0400", hash_original_method = "34F00EE21F4532CBE8BBCA1E84CB5B7E", hash_generated_method = "55417319FC36ACB4EA83C6C46F02C37D")
    @DSModeled(DSC.SAFE)
    public void setSpeed(float speed) {
        dsTaint.addTaint(speed);
        mHasSpeed = true;
        // ---------- Original Method ----------
        //mSpeed = speed;
        //mHasSpeed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.918 -0400", hash_original_method = "B58ABDA4F4570A6C6402F324866C9A78", hash_generated_method = "092A296900E41495B6AA50E91B45595A")
    @DSModeled(DSC.SAFE)
    public void removeSpeed() {
        mSpeed = 0.0f;
        mHasSpeed = false;
        // ---------- Original Method ----------
        //mSpeed = 0.0f;
        //mHasSpeed = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.918 -0400", hash_original_method = "D55FF6AB44947F083C797EDEE83A6188", hash_generated_method = "D5CCB1DE39AA004F1503A32A62D1F6B0")
    @DSModeled(DSC.SAFE)
    public boolean hasBearing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasBearing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.918 -0400", hash_original_method = "AC6CB3B684BB76DAFC78CFB4B9F35C9A", hash_generated_method = "1E680C49F653174D6791D10016A7E411")
    @DSModeled(DSC.SAFE)
    public float getBearing() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mBearing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.919 -0400", hash_original_method = "8FBA12B19B970F6442007D37D9E216CC", hash_generated_method = "799E939FE1C2D1E6807262430786F80F")
    @DSModeled(DSC.SAFE)
    public void setBearing(float bearing) {
        dsTaint.addTaint(bearing);
        {
            bearing += 360.0f;
        } //End block
        {
            bearing -= 360.0f;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.919 -0400", hash_original_method = "57889AAEA0A214C7174BC35DF28DBD1D", hash_generated_method = "8FAAFFDC9B89944657C7FF0FDF0A1A8A")
    @DSModeled(DSC.SAFE)
    public void removeBearing() {
        mBearing = 0.0f;
        mHasBearing = false;
        // ---------- Original Method ----------
        //mBearing = 0.0f;
        //mHasBearing = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.919 -0400", hash_original_method = "25E2CFAA647DEEE085853277B0217FAA", hash_generated_method = "66B1417586EE6211577492DD8D14CA6B")
    @DSModeled(DSC.SAFE)
    public boolean hasAccuracy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.919 -0400", hash_original_method = "080C41F346C9D7277489423C5A91C89D", hash_generated_method = "90B84274BFEDE3DDC0437DC008B4EE69")
    @DSModeled(DSC.SAFE)
    public float getAccuracy() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.919 -0400", hash_original_method = "BF61AAF1E1B3170C7527B801249DD59B", hash_generated_method = "A871A45D4B99B0199BF7345D0F73E994")
    @DSModeled(DSC.SAFE)
    public void setAccuracy(float accuracy) {
        dsTaint.addTaint(accuracy);
        mHasAccuracy = true;
        // ---------- Original Method ----------
        //mAccuracy = accuracy;
        //mHasAccuracy = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.920 -0400", hash_original_method = "10BF9B2FD08E11C5C21016EDE854825A", hash_generated_method = "53264F9A65193E66F9C1D1CBFC1FBF3D")
    @DSModeled(DSC.SAFE)
    public void removeAccuracy() {
        mAccuracy = 0.0f;
        mHasAccuracy = false;
        // ---------- Original Method ----------
        //mAccuracy = 0.0f;
        //mHasAccuracy = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.920 -0400", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "5467DB301C93271E15B2B85B3DDE4C93")
    @DSModeled(DSC.SAFE)
    public Bundle getExtras() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.920 -0400", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "A3FFA91E304602A791B523817C96CBA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        mExtras = (extras == null) ? null : new Bundle(extras);
        // ---------- Original Method ----------
        //mExtras = (extras == null) ? null : new Bundle(extras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.921 -0400", hash_original_method = "5688E2364E565225F14DAE87FCAB3981", hash_generated_method = "1C83E61D923B20E3D0F86D9FA07C50B8")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.921 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.921 -0400", hash_original_method = "32F156010F6C4E7296DBF5DD142C1BEC", hash_generated_method = "75C77A0D6CBEFE2700D0CB8EEAE90951")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
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

    
    public static final int FORMAT_DEGREES = 0;
    public static final int FORMAT_MINUTES = 1;
    public static final int FORMAT_SECONDS = 2;
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.922 -0400", hash_original_method = "DB5FDF146F5EA69FB4032FD10E69F8C9", hash_generated_method = "0F29BD7AC76EA5F7476B3F9900B82A00")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Location createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            String provider;
            provider = in.readString();
            Location l;
            l = new Location(provider);
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
            return (Location)dsTaint.getTaint();
            // ---------- Original Method ----------
            //String provider = in.readString();
            //Location l = new Location(provider);
            //l.mTime = in.readLong();
            //l.mLatitude = in.readDouble();
            //l.mLongitude = in.readDouble();
            //l.mHasAltitude = in.readInt() != 0;
            //l.mAltitude = in.readDouble();
            //l.mHasSpeed = in.readInt() != 0;
            //l.mSpeed = in.readFloat();
            //l.mHasBearing = in.readInt() != 0;
            //l.mBearing = in.readFloat();
            //l.mHasAccuracy = in.readInt() != 0;
            //l.mAccuracy = in.readFloat();
            //l.mExtras = in.readBundle();
            //return l;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.922 -0400", hash_original_method = "35E80CC5AE52EB0077990EF1C2700148", hash_generated_method = "69E556A96FD05CB9CA26E5A49E90FEDB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Location[] newArray(int size) {
            dsTaint.addTaint(size);
            Location[] varFDA08A4812187542263D234B922624AD_664989250 = (new Location[size]);
            return (Location[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Location[size];
        }

        
}; //Transformed anonymous class
}

