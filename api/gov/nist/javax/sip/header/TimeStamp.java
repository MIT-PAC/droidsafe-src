package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.TimeStampHeader;






public class TimeStamp extends SIPHeader implements TimeStampHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.496 -0500", hash_original_field = "200E26A351C67B18CDC5632502CF9A3F", hash_generated_field = "5580840BB5EA0CAD9750B3DAADA2FC56")

    private static final long serialVersionUID = -3711322366481232720L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.497 -0500", hash_original_field = "0C13BCBC5A1AAE462D7AF61529FD353C", hash_generated_field = "76B8D8E0781BF84AACE2DA76A4001EFB")

    protected long timeStamp = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.498 -0500", hash_original_field = "D167EE5E5C8BF71B96B27591550043DB", hash_generated_field = "DE842D8221161CACA08CA06721E2F557")

    protected int delay = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.499 -0500", hash_original_field = "500AF7AD3D80BC4C3A574B7252D677A2", hash_generated_field = "C6AE286F90939B3ECC1A3783181F9CAA")


    protected float delayFloat = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.500 -0500", hash_original_field = "CA7FFB4F8D811B82C28C8652BA4974CA", hash_generated_field = "496F7FE859855CC3A1459131085C2D33")


    private float timeStampFloat = -1;

    /**
     * Default Constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.502 -0500", hash_original_method = "02FBDC0E6C2AA0154E61A684C5364628", hash_generated_method = "224AF76B92873CD39BAFF4F7188111B3")
    public TimeStamp() {
        super(TIMESTAMP);
        delay = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.503 -0500", hash_original_method = "A6A60BDDB9B869E20670F0D4B71173B1", hash_generated_method = "CB83C01BC0FA1004CFB6055083D7100D")
    private String getTimeStampAsString() {
        if (timeStamp == -1 && timeStampFloat == -1)
            return "";
        else if (timeStamp != -1)
            return Long.toString(timeStamp);
        else
            return Float.toString(timeStampFloat);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.504 -0500", hash_original_method = "BFD0E29F8DBDA29B6D5527F4C53FF1F0", hash_generated_method = "ED6CEAC8FD21B02A84CB0F73C2FDA30A")
    private String getDelayAsString() {
        if (delay == -1 && delayFloat == -1)
            return "";
        else if (delay != -1)
            return Integer.toString(delay);
        else
            return Float.toString(delayFloat);
    }

    /**
     * Return canonical form of the header.
     *
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.505 -0500", hash_original_method = "9C6948D2F9ACB5C855CB1B70AF4DF1F8", hash_generated_method = "40EB47293DA39AC24518E5C7DC42B194")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer();
        String s1 = getTimeStampAsString();
        String s2 = getDelayAsString();
        if (s1.equals("") && s2.equals(""))
            return "";
        if (!s1.equals(""))
            retval.append(s1);
        if (!s2.equals(""))
            retval.append(" ").append(s2);
        return retval.toString();

    }

    /**
     * return true if delay exists
     *
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.506 -0500", hash_original_method = "085907F485A51FAD6B2086211DEE0B83", hash_generated_method = "D9F29EB632250682A89CBB9954F94F02")
    public boolean hasDelay() {
        return delay != -1;
    }

    /*
     * remove the Delay field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.507 -0500", hash_original_method = "EEC7FFF2C35A5C091F00D880A66433E4", hash_generated_method = "9D6CBAA5B1B4711AD29D26FC3B13AC19")
    public void removeDelay() {
        delay = -1;
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.508 -0500", hash_original_method = "4E9675E31226E40B31535DE558B43882", hash_generated_method = "7FCB4D348C3A341B2CEE288BF1B76C98")
    public void setTimeStamp(float timeStamp) throws InvalidArgumentException {
        if (timeStamp < 0)
            throw new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setTimeStamp(), the timeStamp parameter is <0");
        this.timeStamp = -1;
        this.timeStampFloat = timeStamp;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.509 -0500", hash_original_method = "01E7C97794DF2BDF54B9432179BAF6F0", hash_generated_method = "5B691A70EC900BD1387290E3D1501697")
    public float getTimeStamp() {
        return this.timeStampFloat == -1 ? Float.valueOf(timeStamp).floatValue()
                : this.timeStampFloat;
    }



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.510 -0500", hash_original_method = "E76077CCC1CFE0A65C8B9469FD12F639", hash_generated_method = "6A3013F75E7C29D59DCC6F2E7A9E0583")
    public float getDelay() {
        return delayFloat == -1 ? Float.valueOf(delay).floatValue() : delayFloat;
    }

    /**
     * Sets the new delay value of the TimestampHeader to the delay paramter
     * passed to this method
     *
     * @param delay -
     *            the Float.valueOf delay value
     * @throws InvalidArgumentException
     *             if the delay value argumenmt is a negative value other than
     *             <code>-1</code>.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.511 -0500", hash_original_method = "614287DF965A55EC9CE805B49E8E8F7E", hash_generated_method = "DE05C031A2E44E7C24E355A3CEE533D0")
    public void setDelay(float delay) throws InvalidArgumentException {
        if (delay < 0 && delay != -1)
            throw new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setDelay(), the delay parameter is <0");
        this.delayFloat = delay;
        this.delay = -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.512 -0500", hash_original_method = "21D089BD1FDC44EC84A18CFADDD04289", hash_generated_method = "D1AAA7D8709930CC17821C70BD7AB8B1")
    public long getTime() {
        return this.timeStamp == -1 ? (long) timeStampFloat : timeStamp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.513 -0500", hash_original_method = "BF53496596C6E194CBAA97C816B19B22", hash_generated_method = "CBF35642663A04BE3CA35224E85730E9")
    public int getTimeDelay() {
        return this.delay == -1 ? (int) delayFloat : delay;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.515 -0500", hash_original_method = "930714F3CC3A7BF7C1984F60EB3E864F", hash_generated_method = "3327D1886A2CAF65D3865DE63E9B9028")
    public void setTime(long timeStamp) throws InvalidArgumentException {
        if (timeStamp < -1)
            throw new InvalidArgumentException("Illegal timestamp");
        this.timeStamp = timeStamp;
        this.timeStampFloat = -1;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:54.516 -0500", hash_original_method = "D3E64583B8501E5C3510C5471B1277F7", hash_generated_method = "CCC64301BD9F2A8A889C35528F1F63D5")
    public void setTimeDelay(int delay) throws InvalidArgumentException {
        if (delay < -1)
            throw new InvalidArgumentException("Value out of range " + delay);
        this.delay = delay;
        this.delayFloat = -1;

    }
}

