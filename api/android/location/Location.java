package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class Location implements Parcelable {

    /**
     * Converts a coordinate to a String representation. The outputType
     * may be one of FORMAT_DEGREES, FORMAT_MINUTES, or FORMAT_SECONDS.
     * The coordinate must be a valid double between -180.0 and 180.0.
     *
     * @throws IllegalArgumentException if coordinate is less than
     * -180.0, greater than 180.0, or is not a number.
     * @throws IllegalArgumentException if outputType is not one of
     * FORMAT_DEGREES, FORMAT_MINUTES, or FORMAT_SECONDS.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.345 -0500", hash_original_method = "F962E0B98A7E7F83554889920016ABE1", hash_generated_method = "D6B34BDE7EE79CBCAC9F5267E3309682")
    
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

        // Handle negative values
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

    /**
     * Converts a String in one of the formats described by
     * FORMAT_DEGREES, FORMAT_MINUTES, or FORMAT_SECONDS into a
     * double.
     *
     * @throws NullPointerException if coordinate is null
     * @throws IllegalArgumentException if the coordinate is not
     * in one of the valid formats.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.349 -0500", hash_original_method = "7B47425A60B4C4C2B99A4113EA8A74F1", hash_generated_method = "BD266226F3E2DF1012A52E6715BD5352")
    
public static double convert(String coordinate) {
        // IllegalArgumentException if bad syntax
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

            // deg must be in [0, 179] except for the case of -180 degrees
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.354 -0500", hash_original_method = "165EE56F2E92FA289A109F63B6B1920A", hash_generated_method = "1EA7F072BDA182110E9EEF7322654C6F")
    
private static void computeDistanceAndBearing(double lat1, double lon1,
        double lat2, double lon2, float[] results) {
        // Based on http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf
        // using the "Inverse Formula" (section 4)

        int MAXITERS = 20;
        // Convert lat/long to radians
        lat1 *= Math.PI / 180.0;
        lat2 *= Math.PI / 180.0;
        lon1 *= Math.PI / 180.0;
        lon2 *= Math.PI / 180.0;

        double a = 6378137.0; // WGS84 major axis
        double b = 6356752.3142; // WGS84 semi-major axis
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

        double lambda = L; // initial guess
        for (int iter = 0; iter < MAXITERS; iter++) {
            double lambdaOrig = lambda;
            cosLambda = Math.cos(lambda);
            sinLambda = Math.sin(lambda);
            double t1 = cosU2 * sinLambda;
            double t2 = cosU1 * sinU2 - sinU1 * cosU2 * cosLambda;
            double sinSqSigma = t1 * t1 + t2 * t2; // (14)
            sinSigma = Math.sqrt(sinSqSigma);
            cosSigma = sinU1sinU2 + cosU1cosU2 * cosLambda; // (15)
            sigma = Math.atan2(sinSigma, cosSigma); // (16)
            double sinAlpha = (sinSigma == 0) ? 0.0 :
                cosU1cosU2 * sinLambda / sinSigma; // (17)
            cosSqAlpha = 1.0 - sinAlpha * sinAlpha;
            cos2SM = (cosSqAlpha == 0) ? 0.0 :
                cosSigma - 2.0 * sinU1sinU2 / cosSqAlpha; // (18)

            double uSquared = cosSqAlpha * aSqMinusBSqOverBSq; // defn
            A = 1 + (uSquared / 16384.0) * // (3)
                (4096.0 + uSquared *
                 (-768 + uSquared * (320.0 - 175.0 * uSquared)));
            double B = (uSquared / 1024.0) * // (4)
                (256.0 + uSquared *
                 (-128.0 + uSquared * (74.0 - 47.0 * uSquared)));
            double C = (f / 16.0) *
                cosSqAlpha *
                (4.0 + f * (4.0 - 3.0 * cosSqAlpha)); // (10)
            double cos2SMSq = cos2SM * cos2SM;
            deltaSigma = B * sinSigma * // (6)
                (cos2SM + (B / 4.0) *
                 (cosSigma * (-1.0 + 2.0 * cos2SMSq) -
                  (B / 6.0) * cos2SM *
                  (-3.0 + 4.0 * sinSigma * sinSigma) *
                  (-3.0 + 4.0 * cos2SMSq)));

            lambda = L +
                (1.0 - C) * f * sinAlpha *
                (sigma + C * sinSigma *
                 (cos2SM + C * cosSigma *
                  (-1.0 + 2.0 * cos2SM * cos2SM))); // (11)

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

    /**
     * Computes the approximate distance in meters between two
     * locations, and optionally the initial and final bearings of the
     * shortest path between them.  Distance and bearing are defined using the
     * WGS84 ellipsoid.
     *
     * <p> The computed distance is stored in results[0].  If results has length
     * 2 or greater, the initial bearing is stored in results[1]. If results has
     * length 3 or greater, the final bearing is stored in results[2].
     *
     * @param startLatitude the starting latitude
     * @param startLongitude the starting longitude
     * @param endLatitude the ending latitude
     * @param endLongitude the ending longitude
     * @param results an array of floats to hold the results
     *
     * @throws IllegalArgumentException if results is null or has length < 1
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.356 -0500", hash_original_method = "8ABFD76C6BB25FBE1C10045F87B30D96", hash_generated_method = "9CA28EB8591627B94C2C841FF158C3E8")
    
public static void distanceBetween(double startLatitude, double startLongitude,
        double endLatitude, double endLongitude, float[] results) {
        if (results == null || results.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        computeDistanceAndBearing(startLatitude, startLongitude,
            endLatitude, endLongitude, results);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.279 -0500", hash_original_field = "F5D82E07A744F7EA49A9CBC822603A03", hash_generated_field = "6F646E70B7136B5A7655BF0A1BCA8DFE")

    public static final int FORMAT_DEGREES = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.282 -0500", hash_original_field = "1945F6E2137851964D16DFF254F79BF5", hash_generated_field = "F9E0592649D425449C79A3A33FE4EFA8")

    public static final int FORMAT_MINUTES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.284 -0500", hash_original_field = "863192F00103D3547953AF4D94D621F2", hash_generated_field = "E12DE7371ECF9EEF209A4502097EB80C")

    public static final int FORMAT_SECONDS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.603 -0400", hash_original_field = "7B9F8EB241F1C6244667BCC135160F6F", hash_generated_field = "30FFB99E1ED15C4F1A795AA214D4874A")

    public static final Parcelable.Creator<Location> CREATOR =
        new Parcelable.Creator<Location>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.449 -0500", hash_original_method = "DB5FDF146F5EA69FB4032FD10E69F8C9", hash_generated_method = "620B55AC234CBC6C107A09B2B3194145")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.452 -0500", hash_original_method = "35E80CC5AE52EB0077990EF1C2700148", hash_generated_method = "0AEFFFC9F681F9236D1FDE50D885788C")
        
public Location[] newArray(int size) {
            return new Location[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.286 -0500", hash_original_field = "91E507DC461800B2755826CF50C3CFFF", hash_generated_field = "644895AD43D171E05003EF08DEE63C8C")

    private String mProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.289 -0500", hash_original_field = "97E03B9680CF23049C36A6B3EB2AC160", hash_generated_field = "39CDFD59B94279CE728BDCF20E03E08D")

    private long mTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.291 -0500", hash_original_field = "1C710ECA91DA41CF85B58B6726C44AFB", hash_generated_field = "269B3D2493D0F96EF61A46FF198ABE0D")

    private double mLatitude = 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.293 -0500", hash_original_field = "60D4A8CAD2E51021FCB4383FC5672844", hash_generated_field = "2C9B2A9CE4E7FB2DE0150E4CBE0B8843")

    private double mLongitude = 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.295 -0500", hash_original_field = "C3D7BD5592AFB76229796126D5C6E313", hash_generated_field = "AB014DDDC67804474525003E8CCA6813")

    private boolean mHasAltitude = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.297 -0500", hash_original_field = "D71591974AE92DC101EB97B67090ADAA", hash_generated_field = "65AF56B9C1C08B51B31BCAF89C7F3B4F")

    private double mAltitude = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.300 -0500", hash_original_field = "D2BE3FA08082CAAFFE18CFE5057A4CF0", hash_generated_field = "8CE70E9CD9C32590583FE0B532925C61")

    private boolean mHasSpeed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.302 -0500", hash_original_field = "B7003E9D08E29157410A7095A0D72EDD", hash_generated_field = "ABFC05BB8A240BFECCDF9D843EC57200")

    private float mSpeed = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.304 -0500", hash_original_field = "0A9D73782C5608B8B87DD3545A4743D4", hash_generated_field = "F1AC4D74AE98BF26D0BA40D4270DBA80")

    private boolean mHasBearing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.306 -0500", hash_original_field = "0CBD40BE7C6BECEBA54175B8710B7C1C", hash_generated_field = "6BB038E41DD655D9B95C50E3DA08A87F")

    private float mBearing = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.308 -0500", hash_original_field = "58F542B9999FCBD19A8E4A2871A61C55", hash_generated_field = "40E3E568925ACF4851792D33B86F0123")

    private boolean mHasAccuracy = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.312 -0500", hash_original_field = "6592E6A7BF3BD501FE5BC25F7618D476", hash_generated_field = "ED55BE9EA8B3BEA284F24131E9FD0A9A")

    private float mAccuracy = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.314 -0500", hash_original_field = "5F5A32CDFB5156D2D59483EBF50BAC14", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.316 -0500", hash_original_field = "60213C8803159C19E63DF66DA840D0C2", hash_generated_field = "BF1C404778B6C0919DB84D2BE99B54D5")

    // so calls to distanceTo() and bearingTo() can share work
    private double mLat1 = 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.318 -0500", hash_original_field = "3B93EBEEABF7696A8E3DC86916116B3C", hash_generated_field = "052169D4CDC5007A7869324FC8CEAEFD")

    private double mLon1 = 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.320 -0500", hash_original_field = "C53C05F166122FFB2BB57990185071CC", hash_generated_field = "AA6D86402CD4A25FF1E0F4C41D36A40D")

    private double mLat2 = 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.322 -0500", hash_original_field = "DBB6B57E972A25143310CE45CB0A47CF", hash_generated_field = "8A9E97E6541A3C771F68B1C68C60D06D")

    private double mLon2 = 0.0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.324 -0500", hash_original_field = "CD9C35488FB578E63684479942E8EF33", hash_generated_field = "CA9178B97D08F71ACD73BBBB766149DA")

    private float mDistance = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.326 -0500", hash_original_field = "13BF8A2EB8DFBA748538473BF965061B", hash_generated_field = "95983693C31B9D94B7F8DF00068BDD2A")

    private float mInitialBearing = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.328 -0500", hash_original_field = "D760715F108458ADC30D672EF7A44021", hash_generated_field = "FC7CDADAD690A1BE9FE4854D8EF42339")

    private float[] mResults = new float[2];
    
    /**
     * Constructs a new Location.  By default, time, latitude,
     * longitude, and numSatellites are 0; hasAltitude, hasSpeed, and
     * hasBearing are false; and there is no extra information.
     *
     * @param provider the name of the location provider that generated this
     * location fix.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.333 -0500", hash_original_method = "70E7035C56BDBF9C3F6572F798B0D4BF", hash_generated_method = "E58169526819F86AAC7DAC1E5CC765D6")
    
public Location(String provider) {
        mProvider = provider;
    }

    /**
     * Constructs a new Location object that is a copy of the given
     * location.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.336 -0500", hash_original_method = "4853EB704C822ED076EB467B9C8220F5", hash_generated_method = "5C477B01822E6EE3822AEB748CCC49C7")
    
public Location(Location l) {
        set(l);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.331 -0500", hash_original_method = "E894B78E8DAE7217EB8A906829737D1E", hash_generated_method = "73178F331843DA94658E917347F3A67D")
    
public void dump(Printer pw, String prefix) {
        pw.println(prefix + "mProvider=" + mProvider + " mTime=" + mTime);
        pw.println(prefix + "mLatitude=" + mLatitude + " mLongitude=" + mLongitude);
        pw.println(prefix + "mHasAltitude=" + mHasAltitude + " mAltitude=" + mAltitude);
        pw.println(prefix + "mHasSpeed=" + mHasSpeed + " mSpeed=" + mSpeed);
        pw.println(prefix + "mHasBearing=" + mHasBearing + " mBearing=" + mBearing);
        pw.println(prefix + "mHasAccuracy=" + mHasAccuracy + " mAccuracy=" + mAccuracy);
        pw.println(prefix + "mExtras=" + mExtras);
    }

    /**
     * Sets the contents of the location to the values from the given location.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.338 -0500", hash_original_method = "8A60F1EB9D48909B7AC1F2F058E6CA7B", hash_generated_method = "0D11847C4FAC634F0F15F0182D518FC1")
    
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
    }

    /**
     * Clears the contents of the location.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.341 -0500", hash_original_method = "616C057876C322A61AA799FA470B1CEA", hash_generated_method = "B4C0ADC52292C1943A4750970639A178")
    
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
    }

    /**
     * Returns the approximate distance in meters between this
     * location and the given location.  Distance is defined using
     * the WGS84 ellipsoid.
     *
     * @param dest the destination location
     * @return the approximate distance in meters
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.359 -0500", hash_original_method = "F7D4263990E83377B0F1337DC2A9789F", hash_generated_method = "4462E72B31EDF62C36CD117457DEE7F2")
    
public float distanceTo(Location dest) {
        // See if we already have the result
        synchronized (mResults) {
            if (mLatitude != mLat1 || mLongitude != mLon1 ||
                dest.mLatitude != mLat2 || dest.mLongitude != mLon2) {
                computeDistanceAndBearing(mLatitude, mLongitude,
                    dest.mLatitude, dest.mLongitude, mResults);
                mLat1 = mLatitude;
                mLon1 = mLongitude;
                mLat2 = dest.mLatitude;
                mLon2 = dest.mLongitude;
                mDistance = mResults[0];
                mInitialBearing = mResults[1];
            }
            return mDistance;
        }
    }

    /**
     * Returns the approximate initial bearing in degrees East of true
     * North when traveling along the shortest path between this
     * location and the given location.  The shortest path is defined
     * using the WGS84 ellipsoid.  Locations that are (nearly)
     * antipodal may produce meaningless results.
     *
     * @param dest the destination location
     * @return the initial bearing in degrees
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.361 -0500", hash_original_method = "EC026D992E5F4947C061D86521AAB3B6", hash_generated_method = "FDA980A1A1FF4EB83AA2278980428DCA")
    
public float bearingTo(Location dest) {
        synchronized (mResults) {
            // See if we already have the result
            if (mLatitude != mLat1 || mLongitude != mLon1 ||
                            dest.mLatitude != mLat2 || dest.mLongitude != mLon2) {
                computeDistanceAndBearing(mLatitude, mLongitude,
                    dest.mLatitude, dest.mLongitude, mResults);
                mLat1 = mLatitude;
                mLon1 = mLongitude;
                mLat2 = dest.mLatitude;
                mLon2 = dest.mLongitude;
                mDistance = mResults[0];
                mInitialBearing = mResults[1];
            }
            return mInitialBearing;
        }
    }

    /**
     * Returns the name of the provider that generated this fix,
     * or null if it is not associated with a provider.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.363 -0500", hash_original_method = "BFECE3BB8B622B00AFB7A331FE5F6AF2", hash_generated_method = "1CDFB9AF0318DBE18124C0C7933D014A")
    
public String getProvider() {
        return mProvider;
    }

    /**
     * Sets the name of the provider that generated this fix.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.365 -0500", hash_original_method = "25D5387E6BE9F4E7F6250416A2346065", hash_generated_method = "D8D9E8F1C806C35CC05BC51205F3484D")
    
public void setProvider(String provider) {
        mProvider = provider;
    }

    /**
     * Returns the UTC time of this fix, in milliseconds since January 1,
     * 1970.
     */
    @DSComment("Data structure only")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.367 -0500", hash_original_method = "997C67A326545139029C9D8F308B45E1", hash_generated_method = "71E6372FD72C471FB7AEA62C47181467")
    
public long getTime() {
        return mTime;
    }

    /**
     * Sets the UTC time of this fix, in milliseconds since January 1,
     * 1970.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.369 -0500", hash_original_method = "1825242101B57AC7053134E109B277AF", hash_generated_method = "2A34163F914EC5EC616C0E941B8813EF")
    
public void setTime(long time) {
        mTime = time;
    }

    /**
     * Returns the latitude of this fix.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.372 -0500", hash_original_method = "F25A3F38BD2475F276CF0768419142B9", hash_generated_method = "987B43A327E4AD566B34E7F55EF98D0C")
    
public double getLatitude() {
        return mLatitude;
    }

    /**
     * Sets the latitude of this fix.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.375 -0500", hash_original_method = "1F7F9B57342DE3FD3D5D55490B64EE27", hash_generated_method = "EC3911E7EEDEB215E86576D113AF1BA5")
    
public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    /**
     * Returns the longitude of this fix.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.377 -0500", hash_original_method = "7E07C4F8B2560C863B560B81405E4EA8", hash_generated_method = "551A2DD0F2974646F82A231B1C16543B")
    
public double getLongitude() {
        return mLongitude;
    }

    /**
     * Sets the longitude of this fix.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.379 -0500", hash_original_method = "D382B7FFFC1832B1199A432F05F295AF", hash_generated_method = "0C741959BD2A7C801FE236BB69D8BD17")
    
public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    /**
     * Returns true if this fix contains altitude information, false
     * otherwise.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.381 -0500", hash_original_method = "8588CDCF553966E03782186D08715F65", hash_generated_method = "61D93F6C69B04716C494CCB5945DB85B")
    
public boolean hasAltitude() {
        return mHasAltitude;
    }

    /**
     * Returns the altitude of this fix.  If {@link #hasAltitude} is false,
     * 0.0f is returned.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.383 -0500", hash_original_method = "38598EF38BAA57E5BBA23C5814512D64", hash_generated_method = "1FA0FAED8AFB0498ABF93573DAAC0FAA")
    
public double getAltitude() {
        return mAltitude;
    }

    /**
     * Sets the altitude of this fix.  Following this call,
     * hasAltitude() will return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.386 -0500", hash_original_method = "8207B2258C8D7E964A376C6D8FB9BDB2", hash_generated_method = "92208A88CBE934B08CDDD6367BCF6C05")
    
public void setAltitude(double altitude) {
        mAltitude = altitude;
        mHasAltitude = true;
    }

    /**
     * Clears the altitude of this fix.  Following this call,
     * hasAltitude() will return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.388 -0500", hash_original_method = "5A565618B4FD768311EE533344239248", hash_generated_method = "88665A90789B2985F9D18FFADF4E89A5")
    
public void removeAltitude() {
        mAltitude = 0.0f;
        mHasAltitude = false;
    }

    /**
     * Returns true if this fix contains speed information, false
     * otherwise.  The default implementation returns false.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.391 -0500", hash_original_method = "053704FA5AD46F36CEE00CE492DC93E4", hash_generated_method = "0F2EAA8A9FA79AE5D6CEE9645500DEB9")
    
public boolean hasSpeed() {
        return mHasSpeed;
    }

    /**
     * Returns the speed of the device over ground in meters/second.
     * If hasSpeed() is false, 0.0f is returned.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.393 -0500", hash_original_method = "CA7E551E55E608E59EEFDA2D55C22485", hash_generated_method = "10317FF0C70C1810DD863DFF86B80390")
    
public float getSpeed() {
        return mSpeed;
    }

    /**
     * Sets the speed of this fix, in meters/second.  Following this
     * call, hasSpeed() will return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.396 -0500", hash_original_method = "34F00EE21F4532CBE8BBCA1E84CB5B7E", hash_generated_method = "C8D6813DAB1721B696DB0AE850252BB3")
    
public void setSpeed(float speed) {
        mSpeed = speed;
        mHasSpeed = true;
    }

    /**
     * Clears the speed of this fix.  Following this call, hasSpeed()
     * will return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.398 -0500", hash_original_method = "B58ABDA4F4570A6C6402F324866C9A78", hash_generated_method = "E149D03984F42229474A427A65B231B4")
    
public void removeSpeed() {
        mSpeed = 0.0f;
        mHasSpeed = false;
    }

    /**
     * Returns true if the provider is able to report bearing information,
     * false otherwise.  The default implementation returns false.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.401 -0500", hash_original_method = "D55FF6AB44947F083C797EDEE83A6188", hash_generated_method = "4412D78FAA6F07FFF0816FEBECD5E3BD")
    
public boolean hasBearing() {
        return mHasBearing;
    }

    /**
     * Returns the direction of travel in degrees East of true
     * North. If hasBearing() is false, 0.0 is returned.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.404 -0500", hash_original_method = "AC6CB3B684BB76DAFC78CFB4B9F35C9A", hash_generated_method = "F386D9AEFC703337DB5785310B74289E")
    
public float getBearing() {
        return mBearing;
    }

    /**
     * Sets the bearing of this fix.  Following this call, hasBearing()
     * will return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.406 -0500", hash_original_method = "8FBA12B19B970F6442007D37D9E216CC", hash_generated_method = "A889C93A4F8FFC1E9FF9A4CECF0DB8A0")
    
public void setBearing(float bearing) {
        while (bearing < 0.0f) {
            bearing += 360.0f;
        }
        while (bearing >= 360.0f) {
            bearing -= 360.0f;
        }
        mBearing = bearing;
        mHasBearing = true;
    }

    /**
     * Clears the bearing of this fix.  Following this call, hasBearing()
     * will return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.410 -0500", hash_original_method = "57889AAEA0A214C7174BC35DF28DBD1D", hash_generated_method = "6EFD19B86B030E724E05F98976AE63FA")
    
public void removeBearing() {
        mBearing = 0.0f;
        mHasBearing = false;
    }

    /**
     * Returns true if the provider is able to report accuracy information,
     * false otherwise.  The default implementation returns false.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.425 -0500", hash_original_method = "25E2CFAA647DEEE085853277B0217FAA", hash_generated_method = "E3F5D709C82F888D13DC27A9FF81A645")
    
public boolean hasAccuracy() {
        return mHasAccuracy;
    }

    /**
     * Returns the accuracy of the fix in meters. If hasAccuracy() is false,
     * 0.0 is returned.
     */
    @DSComment("Data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.430 -0500", hash_original_method = "080C41F346C9D7277489423C5A91C89D", hash_generated_method = "A4618DB2E3AC6E93C5056AB62A49CCCE")
    
public float getAccuracy() {
        return mAccuracy;
    }

    /**
     * Sets the accuracy of this fix.  Following this call, hasAccuracy()
     * will return true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.434 -0500", hash_original_method = "BF61AAF1E1B3170C7527B801249DD59B", hash_generated_method = "FCA404B4082BFFFF477D7BD405AE3CDF")
    
public void setAccuracy(float accuracy) {
        mAccuracy = accuracy;
        mHasAccuracy = true;
    }

    /**
     * Clears the accuracy of this fix.  Following this call, hasAccuracy()
     * will return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.437 -0500", hash_original_method = "10BF9B2FD08E11C5C21016EDE854825A", hash_generated_method = "47A6FDE77E057ED0571051084086F67C")
    
public void removeAccuracy() {
        mAccuracy = 0.0f;
        mHasAccuracy = false;
    }

    /**
     * Returns additional provider-specific information about the
     * location fix as a Bundle.  The keys and values are determined
     * by the provider.  If no additional information is available,
     * null is returned.
     *
     * <p> A number of common key/value pairs are listed
     * below. Providers that use any of the keys on this list must
     * provide the corresponding value as described below.
     *
     * <ul>
     * <li> satellites - the number of satellites used to derive the fix
     * </ul>
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.439 -0500", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "4808B2FAD06A275B25AB6F7116EE8421")
    
public Bundle getExtras() {
        return mExtras;
    }

    /**
     * Sets the extra information associated with this fix to the
     * given Bundle.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.441 -0500", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "7B33C94C8485B596F89F9E6A5A10A83A")
    
public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.444 -0500", hash_original_method = "5688E2364E565225F14DAE87FCAB3981", hash_generated_method = "72ADEEA58D4182F561E8E8CBF4942E15")
    
@Override public String toString() {
        return "Location[mProvider=" + mProvider +
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.457 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:01.459 -0500", hash_original_method = "32F156010F6C4E7296DBF5DD142C1BEC", hash_generated_method = "CB7EA739BF02CA35198BF71B4AFB91C5")
    
public void writeToParcel(Parcel parcel, int flags) {
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
   }
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

