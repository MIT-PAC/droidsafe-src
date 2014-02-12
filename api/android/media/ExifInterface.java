package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class ExifInterface {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.756 -0500", hash_original_method = "573AE63C3A0AF83AD37E730AD0812C4F", hash_generated_method = "676407259D5C96EB17D75B26EC89E30A")
    @DSSource(DSSourceKind.LOCATION_INFORMATION)
private static float convertRationalLatLonToFloat(
            String rationalString, String ref) {
        try {
            String [] parts = rationalString.split(",");

            String [] pair;
            pair = parts[0].split("/");
            double degrees = Double.parseDouble(pair[0].trim())
                    / Double.parseDouble(pair[1].trim());

            pair = parts[1].split("/");
            double minutes = Double.parseDouble(pair[0].trim())
                    / Double.parseDouble(pair[1].trim());

            pair = parts[2].split("/");
            double seconds = Double.parseDouble(pair[0].trim())
                    / Double.parseDouble(pair[1].trim());

            double result = degrees + (minutes / 60.0) + (seconds / 3600.0);
            if ((ref.equals("S") || ref.equals("W"))) {
                return (float) -result;
            }
            return (float) result;
        } catch (NumberFormatException e) {
            // Some of the nubmers are not valid
            throw new IllegalArgumentException();
        } catch (ArrayIndexOutOfBoundsException e) {
            // Some of the rational does not follow the correct format
            throw new IllegalArgumentException();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.622 -0500", hash_original_field = "3CC4A026E7738551DD531DE5F0698516", hash_generated_field = "83FE172D8DA0FA66CAD2FB4DF239599F")

    /** Type is int. */
    public static final String TAG_ORIENTATION = "Orientation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.625 -0500", hash_original_field = "47B43A56A558ACB2B0ACA6F59D1DBD76", hash_generated_field = "101A4811FB668EE545E803D4B2370414")

    public static final String TAG_DATETIME = "DateTime";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.627 -0500", hash_original_field = "FB73D20ACC9203DB9E0898297BC533FE", hash_generated_field = "F5B4CCDFC0D8EFD9F3AC4F9488B0D71B")

    public static final String TAG_MAKE = "Make";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.630 -0500", hash_original_field = "EE204466692033B71AA19527104AC324", hash_generated_field = "AC99FF0E4EB2B3E4FB5AA4C43F8A93CA")

    public static final String TAG_MODEL = "Model";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.633 -0500", hash_original_field = "CB0D07551BEFFE9D6D6F7E5F43030D15", hash_generated_field = "EA7B55740EC30EB732D48A803CE452BC")

    public static final String TAG_FLASH = "Flash";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.636 -0500", hash_original_field = "A9D3B5F35179772E22E2BB8E69387728", hash_generated_field = "8982FA0FF6512270E69C2B8FEA0CAF23")

    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.638 -0500", hash_original_field = "93B75453E30051FF3F1288ECB0C1433C", hash_generated_field = "58C324851FDD00E78AF846838584294E")

    public static final String TAG_IMAGE_LENGTH = "ImageLength";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.640 -0500", hash_original_field = "F5329069B9DC18F76D830883198816B6", hash_generated_field = "41F724F8F6F98D90757BF1466FD76129")

    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.644 -0500", hash_original_field = "700C644577DFD63ED06E24283684D047", hash_generated_field = "ED3A990B9E868F1814D6920EC24E08EA")

    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.647 -0500", hash_original_field = "9F4194948628C140C01C5D7BAA59FA35", hash_generated_field = "1A3E61A746842C1094B89575A74BFD92")

    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.651 -0500", hash_original_field = "56BE365C877AE7C38B5DC630D4C44AF4", hash_generated_field = "C5807D784A8E59EAC1424EA8776264C1")

    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.654 -0500", hash_original_field = "A8CEF633E9A4AB236BA9CC3FAB66F046", hash_generated_field = "1CCC79689319C47C6C7438DED9018AD3")

    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.657 -0500", hash_original_field = "B39E60518544E2E8ACA89CC416721C2A", hash_generated_field = "45BD3451CD1F1F4DB012EAD31AC691D8")

    public static final String TAG_APERTURE = "FNumber";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.660 -0500", hash_original_field = "41A04928C5BA073A6D0C28DDA2867072", hash_generated_field = "ED69C3EB609C7CAD68276A6B680BD60A")

    public static final String TAG_ISO = "ISOSpeedRatings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.663 -0500", hash_original_field = "4C91D984AB18809DA4628784A3398720", hash_generated_field = "0B96888F82A229E243E899C454C727B4")

    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.665 -0500", hash_original_field = "69F932C89B5FA66051C5E24ED33B85D3", hash_generated_field = "054F22B1CC2AE0A217DF80B4C3A95E7B")

    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.668 -0500", hash_original_field = "78D583521737A40B3E40C394C62EC757", hash_generated_field = "0118A9D9F173B0AD9487E5789584216A")

    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.670 -0500", hash_original_field = "4644E0333C7A3AF51F5221E6816D5B92", hash_generated_field = "87F4328C4767CB618220915C7AF478D2")

    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.673 -0500", hash_original_field = "D94852C58A544AFA66EC05DA774069C3", hash_generated_field = "75039B8014C6D5CC1737F639D29E129F")

    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.675 -0500", hash_original_field = "2AA3B25A89489AE2DCC9E1C599126140", hash_generated_field = "DA1EF2B43E7BDFD590A00A3AE2544CEF")

    public static final String TAG_FOCAL_LENGTH = "FocalLength";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.678 -0500", hash_original_field = "F6432F41A95FC8195058E63B95B97E36", hash_generated_field = "58503EE4AC4AE6D30017F4D27495295A")

    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.681 -0500", hash_original_field = "FF61189BB21652B1AA647AF4366BE51A", hash_generated_field = "C828CE7228710CDEF23518F65ADADABD")

    public static final int ORIENTATION_UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.683 -0500", hash_original_field = "3A017F49ECE76E8A85EA17C941CBEE70", hash_generated_field = "DF8B31ED1507AAAE9E833B86C92C48C1")

    public static final int ORIENTATION_NORMAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.685 -0500", hash_original_field = "A6C3ED3FE9E3E39F3F81002767B6F253", hash_generated_field = "19DB606936AFDB2CFE79DA536B7268A8")

    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.689 -0500", hash_original_field = "727BA6CFAF093C5695385FAECC98B405", hash_generated_field = "D87FC37D76084597EF17327A76A0DA5E")

    public static final int ORIENTATION_ROTATE_180 = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.691 -0500", hash_original_field = "42666579CDE698D2402791B92DE97239", hash_generated_field = "DD16462B5D89FFC4AAE4BBF19C1BD4AA")

    public static final int ORIENTATION_FLIP_VERTICAL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.693 -0500", hash_original_field = "4D25F8EBA1FBF12138CC1A2A90DFC0BF", hash_generated_field = "C9236C8E90CCA328179ED4C661D671A2")

    public static final int ORIENTATION_TRANSPOSE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.696 -0500", hash_original_field = "2ACCC10BBF3C1D4B96E6A0F6B2C229ED", hash_generated_field = "80D13CEDB605688612C65FA5CEE5DA14")

    public static final int ORIENTATION_ROTATE_90 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.699 -0500", hash_original_field = "20612EE535EF24DBFB784F07A3390D97", hash_generated_field = "4113D50874321B71BF0E5153D80BE028")

    public static final int ORIENTATION_TRANSVERSE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.701 -0500", hash_original_field = "F04305995809A555107C8A776C1EB55C", hash_generated_field = "71E617FEA6C0DC38205F4142DA4B0602")

    public static final int ORIENTATION_ROTATE_270 = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.704 -0500", hash_original_field = "A7E86E86F1AA0EDAD59C65F62597F9E9", hash_generated_field = "9B8E4CF6290372C2BA9E2BF3FF429632")

    // Constants used for white balance
    public static final int WHITEBALANCE_AUTO = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.707 -0500", hash_original_field = "5823096C798F429609DD7E20D3E371BB", hash_generated_field = "5D553B9F3B502118D7C36B75FB6B44A4")

    public static final int WHITEBALANCE_MANUAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.709 -0500", hash_original_field = "83F58B816019C4A4F4CC55BDA66B326F", hash_generated_field = "7067D659FE2825B749E741BAA734664B")

    private static SimpleDateFormat sFormatter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.718 -0500", hash_original_field = "3892ABA92B7F95295E8CFDAE8B79791E", hash_generated_field = "EB5BE1AEE301CB28647A518EF65E7402")

    // there can only be one user at a time for the native functions (and
    // they cannot keep state in the native code across function calls). We
    // use sLock to serialize the accesses.
    private static Object sLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.712 -0500", hash_original_field = "01856C66627D09247F481E00F22C2A41", hash_generated_field = "85FF07821F4F75AB23CF084EAB4F73FE")

    private String mFilename;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.714 -0500", hash_original_field = "3850CCEF5B1FE87BBC3EDADD93876182", hash_generated_field = "B2443E5A90D740226468DBF2C0CBD314")

    private HashMap<String, String> mAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.716 -0500", hash_original_field = "CF96104384A174E2BC812B72BE58EC64", hash_generated_field = "FD5958CEDB1B93550749B4BC88A0BB63")

    private boolean mHasThumbnail;
    
	@DSComment("Get Exif from a file")
    @DSSpec(DSCat.IO)
    public ExifInterface(String filename) throws IOException {
		addTaint(filename.getTaint());
        //mFilename = filename;
		/*
		 * DSFIXME:  loadAttributes will parse and load values obtained from a
		 * native call that pulls image attributes from the file itself and stores
		 * them in the HashMap mAttributes.  Effectively this is causing an implicit
		 * taint on attributes, since they are being loaded through a native call
		 * which is returning back a series of properties serialized as a space
		 * delimited string (ghetto!).  Access to values stored in
		 * mAttributes is controlled through the getAttribute* series of methods.
		 * This is a first stab at trying to actually taint the attributes themselves
		 */
        loadAttributes();
    }
    
	@DSComment("getting the ExifInterface is already SPEC")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.IMAGE})
    public String getAttribute(String tag) {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mAttributes.get(tag);
    }
    
    @DSSource({DSSourceKind.IMAGE})
    public int getAttributeInt(String tag, int defaultValue) {
		return getTaintInt();
	}

    /**
     * Returns the double value of the specified rational tag. If there is no
     * such tag in the JPEG file or the value cannot be parsed as double, return
     * <var>defaultValue</var>.
     *
     * @param tag the name of the tag.
     * @param defaultValue the value to return if the tag is not available.
     */
    @DSSource({DSSourceKind.IMAGE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.729 -0500", hash_original_method = "2C50E27E79C50FB255BC7327C78A0595", hash_generated_method = "BBB74CB96CAF937FBBCB988AF143A519")
    
public double getAttributeDouble(String tag, double defaultValue) {
        String value = mAttributes.get(tag);
        if (value == null) return defaultValue;
        try {
            int index = value.indexOf("/");
            if (index == -1) return defaultValue;
            double denom = Double.parseDouble(value.substring(index + 1));
            if (denom == 0) return defaultValue;
            double num = Double.parseDouble(value.substring(0, index));
            return num / denom;
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    /**
     * Set the value of the specified tag.
     *
     * @param tag the name of the tag.
     * @param value the value of the tag.
     */
    @DSComment("nothing happens until saveAttributes")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.731 -0500", hash_original_method = "B68A317BC0B14013541CB1D016F585DF", hash_generated_method = "E5B7A4C2160F0B1762C23311F5766F9A")
    
public void setAttribute(String tag, String value) {
        mAttributes.put(tag, value);
    }
    
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void loadAttributes() throws IOException {
		addTaint("string attribute taint".getTaint()); //Implicit taint for getAttribute
		//addTaint(-1.getTaint()); //Implicit taint for getAttributeInt
		//addTaint(-2.getTaint()); //Implicit taint for getAttributeDouble
	}

    /**
     * Save the tag data into the JPEG file. This is expensive because it involves
     * copying all the JPG data from one file to another and deleting the old file
     * and renaming the other. It's best to use {@link #setAttribute(String,String)}
     * to set all attributes to write and make a single call rather than multiple
     * calls for each attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.737 -0500", hash_original_method = "E3F12D245EF9212C63C10D7ABFFE8DE6", hash_generated_method = "C8FC7776E9E5EE1A9137DA1A47203F40")
    
public void saveAttributes() throws IOException {
        // format of string passed to native C code:
        // "attrCnt attr1=valueLen value1attr2=value2Len value2..."
        // example:
        // "4 attrPtr ImageLength=4 1024Model=6 FooImageWidth=4 1280Make=3 FOO"
        StringBuilder sb = new StringBuilder();
        int size = mAttributes.size();
        if (mAttributes.containsKey("hasThumbnail")) {
            --size;
        }
        sb.append(size + " ");
        for (Map.Entry<String, String> iter : mAttributes.entrySet()) {
            String key = iter.getKey();
            if (key.equals("hasThumbnail")) {
                // this is a fake attribute not saved as an exif tag
                continue;
            }
            String val = iter.getValue();
            sb.append(key + "=");
            sb.append(val.length() + " ");
            sb.append(val);
        }
        String s = sb.toString();
        synchronized (sLock) {
            saveAttributesNative(mFilename, s);
            commitChangesNative(mFilename);
        }
    }

    /**
     * Returns true if the JPEG file has a thumbnail.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.739 -0500", hash_original_method = "8ADD93432A1FBC3F2D5AE95E2101E8B1", hash_generated_method = "5B95961678D1CE45A2252124B8A179F4")
    
public boolean hasThumbnail() {
        return mHasThumbnail;
    }

    /**
     * Returns the thumbnail inside the JPEG file, or {@code null} if there is no thumbnail.
     * The returned data is in JPEG format and can be decoded using
     * {@link android.graphics.BitmapFactory#decodeByteArray(byte[],int,int)}
     */
    @DSSource({DSSourceKind.IMAGE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.742 -0500", hash_original_method = "EEA91D6F373CFE491F29E5705A223E24", hash_generated_method = "7D87F6AF051C0C4F5DECB547D74A174C")
    
public byte[] getThumbnail() {
        synchronized (sLock) {
            return getThumbnailNative(mFilename);
        }
    }

    /**
     * Stores the latitude and longitude value in a float array. The first element is
     * the latitude, and the second element is the longitude. Returns false if the
     * Exif tags are not available.
     */
    @DSComment("GPS location from recorded picture")
    @DSSpec(DSCat.SECURITY)
    @DSSource({DSSourceKind.IMAGE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.745 -0500", hash_original_method = "E57539251757696DAF9B1A2137150B59", hash_generated_method = "4EF1C3E6E9DC7AFCCD00387EE25E6D6E")
    
public boolean getLatLong(float output[]) {
        String latValue = mAttributes.get(ExifInterface.TAG_GPS_LATITUDE);
        String latRef = mAttributes.get(ExifInterface.TAG_GPS_LATITUDE_REF);
        String lngValue = mAttributes.get(ExifInterface.TAG_GPS_LONGITUDE);
        String lngRef = mAttributes.get(ExifInterface.TAG_GPS_LONGITUDE_REF);

        if (latValue != null && latRef != null && lngValue != null && lngRef != null) {
            try {
                output[0] = convertRationalLatLonToFloat(latValue, latRef);
                output[1] = convertRationalLatLonToFloat(lngValue, lngRef);
                return true;
            } catch (IllegalArgumentException e) {
                // if values are not parseable
            }
        }

        return false;
    }

    /**
     * Return the altitude in meters. If the exif tag does not exist, return
     * <var>defaultValue</var>.
     *
     * @param defaultValue the value to return if the tag is not available.
     */
    @DSSource({DSSourceKind.IMAGE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.747 -0500", hash_original_method = "7FF577F1262A20E1F7C9D9D9BE845A85", hash_generated_method = "455BC0CAADB360D042876898A2EAEE37")
    
public double getAltitude(double defaultValue) {
        double altitude = getAttributeDouble(TAG_GPS_ALTITUDE, -1);
        int ref = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);

        if (altitude >= 0 && ref >= 0) {
            return (double) (altitude * ((ref == 1) ? -1 : 1));
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns number of milliseconds since Jan. 1, 1970, midnight.
     * Returns -1 if the date time information if not available.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.750 -0500", hash_original_method = "E8E77BF544503216344BBA6B3C85FE94", hash_generated_method = "A268731B6306C3B5642516836FC513B1")
    
public long getDateTime() {
        String dateTimeString = mAttributes.get(TAG_DATETIME);
        if (dateTimeString == null) return -1;

        ParsePosition pos = new ParsePosition(0);
        try {
            Date datetime = sFormatter.parse(dateTimeString, pos);
            if (datetime == null) return -1;
            return datetime.getTime();
        } catch (IllegalArgumentException ex) {
            return -1;
        }
    }

    /**
     * Returns number of milliseconds since Jan. 1, 1970, midnight UTC.
     * Returns -1 if the date time information if not available.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.753 -0500", hash_original_method = "E20B898080FF0A84D7C05898F2A9273F", hash_generated_method = "469395D0EE5FE02AFD07DEC668A58A91")
    
public long getGpsDateTime() {
        String date = mAttributes.get(TAG_GPS_DATESTAMP);
        String time = mAttributes.get(TAG_GPS_TIMESTAMP);
        if (date == null || time == null) return -1;

        String dateTimeString = date + ' ' + time;
        if (dateTimeString == null) return -1;

        ParsePosition pos = new ParsePosition(0);
        try {
            Date datetime = sFormatter.parse(dateTimeString, pos);
            if (datetime == null) return -1;
            return datetime.getTime();
        } catch (IllegalArgumentException ex) {
            return -1;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.760 -0500", hash_original_method = "10F8297A0D98F2707B10E874747B53C0", hash_generated_method = "90628B937B986544BE88FE904F65CAF5")
    
    private boolean appendThumbnailNative(String fileName,
                String thumbnailFileName){
    	//Formerly a native method
    	addTaint(fileName.getTaint());
    	addTaint(thumbnailFileName.getTaint());
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.764 -0500", hash_original_method = "1943C005EEA560A6DA7650C63E13B4C3", hash_generated_method = "EA5F35D637E602509C693931F9B6A33F")
    
    private void saveAttributesNative(String fileName,
                String compressedAttributes){
    	//Formerly a native method
    	addTaint(fileName.getTaint());
    	addTaint(compressedAttributes.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.772 -0500", hash_original_method = "97BA6F84691FEC7044D96C3EF30411A0", hash_generated_method = "80E74A688A748996FA3E2A2FEFB9B353")
    
    private void commitChangesNative(String fileName){
    	//Formerly a native method
    	addTaint(fileName.getTaint());
    }

    static {
        System.loadLibrary("exif");
        sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:33.776 -0500", hash_original_method = "EE2CC310FEF6D1380D04E187818EEB60", hash_generated_method = "BD46D056B3CB5158CCA64FB57C0A5E4E")
    
    private byte[] getThumbnailNative(String fileName){
    	//Formerly a native method
    	addTaint(fileName.getTaint());
    	return new byte[]{getTaintByte(),};
    }

}

