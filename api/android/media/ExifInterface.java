package android.media;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;






public class ExifInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.170 -0400", hash_original_field = "8D10768D3001B3CF50E3F691611FB247", hash_generated_field = "85FF07821F4F75AB23CF084EAB4F73FE")

    private String mFilename;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.170 -0400", hash_original_field = "57D8B4049AE5C9E100E84EE9D1F3BF3E", hash_generated_field = "B2443E5A90D740226468DBF2C0CBD314")

    private HashMap<String, String> mAttributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.170 -0400", hash_original_field = "E3FE02CCD86450EB1D96C4963640A0F3", hash_generated_field = "FD5958CEDB1B93550749B4BC88A0BB63")

    private boolean mHasThumbnail;
    
    @DSModeled(value = DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
	public String getAttribute(String tag) {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mAttributes.get(tag);
    }

    
    public int getAttributeInt(String tag, int defaultValue) {
		return getTaintInt();
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.173 -0400", hash_original_method = "2C50E27E79C50FB255BC7327C78A0595", hash_generated_method = "F17D71295901622B0CD3DD84EBDF6AD3")
    public double getAttributeDouble(String tag, double defaultValue) {
        addTaint(defaultValue);
        addTaint(tag.getTaint());
        String value = mAttributes.get(tag);
        if(value == null)        
        {
        double var16830A58E1E33A4163524366BA7B701B_1252613628 = (defaultValue);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1451309769 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1451309769;
        }
        try 
        {
            int index = value.indexOf("/");
            if(index == -1)            
            {
            double var16830A58E1E33A4163524366BA7B701B_1739850249 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1480855331 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1480855331;
            }
            double denom = Double.parseDouble(value.substring(index + 1));
            if(denom == 0)            
            {
            double var16830A58E1E33A4163524366BA7B701B_2062938135 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1152232032 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1152232032;
            }
            double num = Double.parseDouble(value.substring(0, index));
            double var4A7BF976D754F111D9B21C5063257BAC_1084712317 = (num / denom);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_175409585 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_175409585;
        } //End block
        catch (NumberFormatException ex)
        {
            double var16830A58E1E33A4163524366BA7B701B_35587373 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_946904810 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_946904810;
        } //End block
        // ---------- Original Method ----------
        //String value = mAttributes.get(tag);
        //if (value == null) return defaultValue;
        //try {
            //int index = value.indexOf("/");
            //if (index == -1) return defaultValue;
            //double denom = Double.parseDouble(value.substring(index + 1));
            //if (denom == 0) return defaultValue;
            //double num = Double.parseDouble(value.substring(0, index));
            //return num / denom;
        //} catch (NumberFormatException ex) {
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.173 -0400", hash_original_method = "B68A317BC0B14013541CB1D016F585DF", hash_generated_method = "CA8EEC5E2826DE42163DED414A796FD8")
    public void setAttribute(String tag, String value) {
        addTaint(value.getTaint());
        addTaint(tag.getTaint());
        mAttributes.put(tag, value);
        // ---------- Original Method ----------
        //mAttributes.put(tag, value);
    }

    
    @DSModeled(DSC.BAN)
	private void loadAttributes() throws IOException {
		addTaint("string attribute taint".getTaint()); //Implicit taint for getAttribute
		//addTaint(-1.getTaint()); //Implicit taint for getAttributeInt
		//addTaint(-2.getTaint()); //Implicit taint for getAttributeDouble
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.175 -0400", hash_original_method = "E3F12D245EF9212C63C10D7ABFFE8DE6", hash_generated_method = "4DE4F1281AB77EB38A76064C1719F449")
    public void saveAttributes() throws IOException {
        StringBuilder sb = new StringBuilder();
        int size = mAttributes.size();
        if(mAttributes.containsKey("hasThumbnail"))        
        {
            --size;
        } //End block
        sb.append(size + " ");
for(Map.Entry<String, String> iter : mAttributes.entrySet())
        {
            String key = iter.getKey();
            if(key.equals("hasThumbnail"))            
            {
                continue;
            } //End block
            String val = iter.getValue();
            sb.append(key + "=");
            sb.append(val.length() + " ");
            sb.append(val);
        } //End block
        String s = sb.toString();
        synchronized
(sLock)        {
            saveAttributesNative(mFilename, s);
            commitChangesNative(mFilename);
        } //End block
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //int size = mAttributes.size();
        //if (mAttributes.containsKey("hasThumbnail")) {
            //--size;
        //}
        //sb.append(size + " ");
        //for (Map.Entry<String, String> iter : mAttributes.entrySet()) {
            //String key = iter.getKey();
            //if (key.equals("hasThumbnail")) {
                //continue;
            //}
            //String val = iter.getValue();
            //sb.append(key + "=");
            //sb.append(val.length() + " ");
            //sb.append(val);
        //}
        //String s = sb.toString();
        //synchronized (sLock) {
            //saveAttributesNative(mFilename, s);
            //commitChangesNative(mFilename);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.176 -0400", hash_original_method = "8ADD93432A1FBC3F2D5AE95E2101E8B1", hash_generated_method = "67421E1756BA5F547E731C0F882ABEF9")
    public boolean hasThumbnail() {
        boolean varE3FE02CCD86450EB1D96C4963640A0F3_1274069846 = (mHasThumbnail);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213376730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_213376730;
        // ---------- Original Method ----------
        //return mHasThumbnail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.177 -0400", hash_original_method = "EEA91D6F373CFE491F29E5705A223E24", hash_generated_method = "43F183504193649192E1CAF28217B9FC")
    public byte[] getThumbnail() {
        synchronized
(sLock)        {
            byte[] var634856D0121AA336180E58F896EAF747_1762457140 = (getThumbnailNative(mFilename));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1268718896 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1268718896;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sLock) {
            //return getThumbnailNative(mFilename);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.177 -0400", hash_original_method = "E57539251757696DAF9B1A2137150B59", hash_generated_method = "391354FDAEB3088143F01A8A407007F3")
    public boolean getLatLong(float output[]) {
        addTaint(output[0]);
        String latValue = mAttributes.get(ExifInterface.TAG_GPS_LATITUDE);
        String latRef = mAttributes.get(ExifInterface.TAG_GPS_LATITUDE_REF);
        String lngValue = mAttributes.get(ExifInterface.TAG_GPS_LONGITUDE);
        String lngRef = mAttributes.get(ExifInterface.TAG_GPS_LONGITUDE_REF);
        if(latValue != null && latRef != null && lngValue != null && lngRef != null)        
        {
            try 
            {
                output[0] = convertRationalLatLonToFloat(latValue, latRef);
                output[1] = convertRationalLatLonToFloat(lngValue, lngRef);
                boolean varB326B5062B2F0E69046810717534CB09_460014203 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_613566118 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_613566118;
            } //End block
            catch (IllegalArgumentException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1105685229 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428325236 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428325236;
        // ---------- Original Method ----------
        //String latValue = mAttributes.get(ExifInterface.TAG_GPS_LATITUDE);
        //String latRef = mAttributes.get(ExifInterface.TAG_GPS_LATITUDE_REF);
        //String lngValue = mAttributes.get(ExifInterface.TAG_GPS_LONGITUDE);
        //String lngRef = mAttributes.get(ExifInterface.TAG_GPS_LONGITUDE_REF);
        //if (latValue != null && latRef != null && lngValue != null && lngRef != null) {
            //try {
                //output[0] = convertRationalLatLonToFloat(latValue, latRef);
                //output[1] = convertRationalLatLonToFloat(lngValue, lngRef);
                //return true;
            //} catch (IllegalArgumentException e) {
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.178 -0400", hash_original_method = "7FF577F1262A20E1F7C9D9D9BE845A85", hash_generated_method = "A7A352464CA7B3E32349A3F041C481C2")
    public double getAltitude(double defaultValue) {
        addTaint(defaultValue);
        double altitude = getAttributeDouble(TAG_GPS_ALTITUDE, -1);
        int ref = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if(altitude >= 0 && ref >= 0)        
        {
            double varAE0AD3FB90EBF29EBD2EBA0F40F64759_541303255 = ((double) (altitude * ((ref == 1) ? -1 : 1)));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_421392299 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_421392299;
        } //End block
        else
        {
            double var16830A58E1E33A4163524366BA7B701B_2070002298 = (defaultValue);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_988731981 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_988731981;
        } //End block
        // ---------- Original Method ----------
        //double altitude = getAttributeDouble(TAG_GPS_ALTITUDE, -1);
        //int ref = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        //if (altitude >= 0 && ref >= 0) {
            //return (double) (altitude * ((ref == 1) ? -1 : 1));
        //} else {
            //return defaultValue;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.178 -0400", hash_original_method = "E8E77BF544503216344BBA6B3C85FE94", hash_generated_method = "C5528857F201221F9602AA09FD1391BC")
    public long getDateTime() {
        String dateTimeString = mAttributes.get(TAG_DATETIME);
        if(dateTimeString == null)        
        {
        long var6BB61E3B7BCE0931DA574D19D1D82C88_1961936453 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1168929169 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1168929169;
        }
        ParsePosition pos = new ParsePosition(0);
        try 
        {
            Date datetime = sFormatter.parse(dateTimeString, pos);
            if(datetime == null)            
            {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_70608230 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_22800554 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_22800554;
            }
            long varFEBB55B716E8C0C81F51A658C798AC40_846014839 = (datetime.getTime());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1756873998 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1756873998;
        } //End block
        catch (IllegalArgumentException ex)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_196369151 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_256751927 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_256751927;
        } //End block
        // ---------- Original Method ----------
        //String dateTimeString = mAttributes.get(TAG_DATETIME);
        //if (dateTimeString == null) return -1;
        //ParsePosition pos = new ParsePosition(0);
        //try {
            //Date datetime = sFormatter.parse(dateTimeString, pos);
            //if (datetime == null) return -1;
            //return datetime.getTime();
        //} catch (IllegalArgumentException ex) {
            //return -1;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.179 -0400", hash_original_method = "E20B898080FF0A84D7C05898F2A9273F", hash_generated_method = "757ED631F39FC9E8DA405744167A9C03")
    public long getGpsDateTime() {
        String date = mAttributes.get(TAG_GPS_DATESTAMP);
        String time = mAttributes.get(TAG_GPS_TIMESTAMP);
        if(date == null || time == null)        
        {
        long var6BB61E3B7BCE0931DA574D19D1D82C88_1763895028 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_737713666 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_737713666;
        }
        String dateTimeString = date + ' ' + time;
        if(dateTimeString == null)        
        {
        long var6BB61E3B7BCE0931DA574D19D1D82C88_429419599 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_446420122 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_446420122;
        }
        ParsePosition pos = new ParsePosition(0);
        try 
        {
            Date datetime = sFormatter.parse(dateTimeString, pos);
            if(datetime == null)            
            {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_435773566 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_590171971 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_590171971;
            }
            long varFEBB55B716E8C0C81F51A658C798AC40_770704450 = (datetime.getTime());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_588871833 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_588871833;
        } //End block
        catch (IllegalArgumentException ex)
        {
            long var6BB61E3B7BCE0931DA574D19D1D82C88_704308706 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_233427769 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_233427769;
        } //End block
        // ---------- Original Method ----------
        //String date = mAttributes.get(TAG_GPS_DATESTAMP);
        //String time = mAttributes.get(TAG_GPS_TIMESTAMP);
        //if (date == null || time == null) return -1;
        //String dateTimeString = date + ' ' + time;
        //if (dateTimeString == null) return -1;
        //ParsePosition pos = new ParsePosition(0);
        //try {
            //Date datetime = sFormatter.parse(dateTimeString, pos);
            //if (datetime == null) return -1;
            //return datetime.getTime();
        //} catch (IllegalArgumentException ex) {
            //return -1;
        //}
    }

    
    @DSModeled(DSC.BAN)
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
            throw new IllegalArgumentException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.180 -0400", hash_original_method = "10F8297A0D98F2707B10E874747B53C0", hash_generated_method = "640EAA3B77FED2713EC54CB88E8838E8")
    private boolean appendThumbnailNative(String fileName,
            String thumbnailFileName) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273120980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273120980;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.180 -0400", hash_original_method = "1943C005EEA560A6DA7650C63E13B4C3", hash_generated_method = "0C52AA2329BBA64696E1E6FC4874D678")
    private void saveAttributesNative(String fileName,
            String compressedAttributes) {
    }

    
    /*
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_method = "21C44A8FDEA142EAF44ED7CEC6DABF8E", hash_generated_method = "43A16705CA15F45B5C6A3BDE225AF57D")
    private String getAttributesNative(String fileName) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }
    */

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_method = "97BA6F84691FEC7044D96C3EF30411A0", hash_generated_method = "00C8985DB1983BF703BB7E7AFEB6EC82")
    private void commitChangesNative(String fileName) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_method = "EE2CC310FEF6D1380D04E187818EEB60", hash_generated_method = "11AB988F0F75743379C7895C889AEBE2")
    private byte[] getThumbnailNative(String fileName) {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1981281573 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1981281573;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_field = "44645D7221CC68513BF34CCA4FFE6328", hash_generated_field = "78033B85963022C92477D8FBD90D3B7C")

    public static final String TAG_ORIENTATION = "Orientation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_field = "EA737BF66FC80C862E36C8770254BCE0", hash_generated_field = "101A4811FB668EE545E803D4B2370414")

    public static final String TAG_DATETIME = "DateTime";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_field = "AC1F6E26D4F2F2291A1C8BD94A547229", hash_generated_field = "F5B4CCDFC0D8EFD9F3AC4F9488B0D71B")

    public static final String TAG_MAKE = "Make";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_field = "EC839659BE99ECBD18631217AD2B9F25", hash_generated_field = "AC99FF0E4EB2B3E4FB5AA4C43F8A93CA")

    public static final String TAG_MODEL = "Model";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.181 -0400", hash_original_field = "8A580CA0713CA09CC7790E2969A7D4D4", hash_generated_field = "EA7B55740EC30EB732D48A803CE452BC")

    public static final String TAG_FLASH = "Flash";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "5D5006373D4B695744AFD2057B37DBEC", hash_generated_field = "8982FA0FF6512270E69C2B8FEA0CAF23")

    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "BDF8F0F83E41395AE4535BFCD9FC77C2", hash_generated_field = "58C324851FDD00E78AF846838584294E")

    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "5840ADB6D7FCC3323E0169C18AA1498C", hash_generated_field = "41F724F8F6F98D90757BF1466FD76129")

    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "6DDEE227416628729FE842E8DA60BCBE", hash_generated_field = "ED3A990B9E868F1814D6920EC24E08EA")

    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "87A4478B7B217FD24BCAC10F9F6753C5", hash_generated_field = "1A3E61A746842C1094B89575A74BFD92")

    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "62480EE715C45DA97B8B10E9163E4A3D", hash_generated_field = "C5807D784A8E59EAC1424EA8776264C1")

    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "2173356F9A5EACA51E535F09F0513A3D", hash_generated_field = "1CCC79689319C47C6C7438DED9018AD3")

    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "A740E636EF7B2F4690DEB6379747D78C", hash_generated_field = "45BD3451CD1F1F4DB012EAD31AC691D8")

    public static final String TAG_APERTURE = "FNumber";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "5ECF4DECAE97BC552A9B2CBA43AE911A", hash_generated_field = "ED69C3EB609C7CAD68276A6B680BD60A")

    public static final String TAG_ISO = "ISOSpeedRatings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "9A122D1A1050587825275E811EEBF07C", hash_generated_field = "0B96888F82A229E243E899C454C727B4")

    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "972DD1BA1077ED8F7EF7C89D235403B3", hash_generated_field = "054F22B1CC2AE0A217DF80B4C3A95E7B")

    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "81F1C087A67C0D7860765716C50A4D84", hash_generated_field = "0118A9D9F173B0AD9487E5789584216A")

    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "9A68B17934D9F34864FF91E1F047DE63", hash_generated_field = "87F4328C4767CB618220915C7AF478D2")

    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "4A8E1A23BB8B9A22CA55DE8FE6F3FF35", hash_generated_field = "75039B8014C6D5CC1737F639D29E129F")

    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.182 -0400", hash_original_field = "EC1E52E98089F715C5A18326FCBE376C", hash_generated_field = "DA1EF2B43E7BDFD590A00A3AE2544CEF")

    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "8BBC595034236177E02E2325885F878B", hash_generated_field = "58503EE4AC4AE6D30017F4D27495295A")

    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "9FB271DB9A792392A834B83862588506", hash_generated_field = "C828CE7228710CDEF23518F65ADADABD")

    public static final int ORIENTATION_UNDEFINED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "976F40C2D5C52390EBDA80BA39654BE0", hash_generated_field = "DF8B31ED1507AAAE9E833B86C92C48C1")

    public static final int ORIENTATION_NORMAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "08B8BC087448124D5E672FB9BCD8E480", hash_generated_field = "19DB606936AFDB2CFE79DA536B7268A8")

    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "C09FBACFA6332EF1AF3DBAF52DE0AA69", hash_generated_field = "D87FC37D76084597EF17327A76A0DA5E")

    public static final int ORIENTATION_ROTATE_180 = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "BA917AA7555EECDBB4911B4FDE6D4BF4", hash_generated_field = "DD16462B5D89FFC4AAE4BBF19C1BD4AA")

    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "15E842538D3B1295E771E72FF99B29F5", hash_generated_field = "C9236C8E90CCA328179ED4C661D671A2")

    public static final int ORIENTATION_TRANSPOSE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "539A92EFF5DE50F64E17ABFC64069F83", hash_generated_field = "80D13CEDB605688612C65FA5CEE5DA14")

    public static final int ORIENTATION_ROTATE_90 = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "4021CB272EFBB622ECC497BBD3F09D25", hash_generated_field = "4113D50874321B71BF0E5153D80BE028")

    public static final int ORIENTATION_TRANSVERSE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "253C1FAEE72904D8800B296215232218", hash_generated_field = "71E617FEA6C0DC38205F4142DA4B0602")

    public static final int ORIENTATION_ROTATE_270 = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "B36BA2703BD118D0EA818D9F6C3782AA", hash_generated_field = "88A1CA26526D81DB8C4CBA87A9A1593C")

    public static final int WHITEBALANCE_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.183 -0400", hash_original_field = "CEC9C2D6535B1AA416F84753976A8D13", hash_generated_field = "5D553B9F3B502118D7C36B75FB6B44A4")

    public static final int WHITEBALANCE_MANUAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.184 -0400", hash_original_field = "FFBBC54DD7A7D8C198A149C0B0CECFE7", hash_generated_field = "7067D659FE2825B749E741BAA734664B")

    private static SimpleDateFormat sFormatter;
    static {
        System.loadLibrary("exif");
        sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:44.184 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E209496F9F2C9103A6260BCF69D3191B")

    private static Object sLock = new Object();
}

