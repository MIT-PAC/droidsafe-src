package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.data.Freezable;
import java.util.Date;

public abstract class Metadata implements com.google.android.gms.common.data.Freezable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.634 -0400", hash_original_field = "70FB11B719EC92A395044A249B548EDC", hash_generated_field = "A7887348AB962DEB42697E85406F6983")

    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.638 -0400", hash_original_field = "6D89BB8313283532B86258CC3FFFDA31", hash_generated_field = "221B44D51009A33E510BC1FB64FA8FEE")

    public static final int CONTENT_AVAILABLE_LOCALLY = 1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.642 -0400", hash_original_method = "EB4CDC734908D1D1E9258CA22D5F567B", hash_generated_method = "7CA5C30B709C405945205D5B9ED04BF6")
    
public String getAlternateLink()
    {
        String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.646 -0400", hash_original_method = "D55540EB9DC9B2DCF7E51017D4274D5B", hash_generated_method = "E7695D6CB753F910F9F9E79D12AD5728")
    
public int getContentAvailability()
    {
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.650 -0400", hash_original_method = "594D327EC681FD5F5451201F1C74E06F", hash_generated_method = "A3C5C284572681230E50F979CF32DCEC")
    
public Date getCreatedDate()
    {
    	Date d = new Date();
    	d.addTaint(getTaint());
    	return d;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.653 -0400", hash_original_method = "616AF40ABC3B851F4FEB9C83D0C30582", hash_generated_method = "01A240BD11F90C3F3D10152254F081C8")
    
public String getDescription()
    {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.657 -0400", hash_original_method = "D00097497F8474B1A50D9883AEFD1956", hash_generated_method = "0EC56738ADE4F7735B2D0EF27C462D94")
    
public DriveId getDriveId()
    {
    	return new DriveId(DSUtils.FAKE_STRING, getTaintInt(), getTaintInt());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.660 -0400", hash_original_method = "4ADD1E65D82A5F3A6BBCC634017B745B", hash_generated_method = "17D2751771D04ED573289D62E790A145")
    
public String getEmbedLink()
    {
        String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.663 -0400", hash_original_method = "110472A32BEAF2D444A5305B9DF50C47", hash_generated_method = "0D8A387E26A23250ABF6EEB14A613C3B")
    
public String getFileExtension()
    {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.667 -0400", hash_original_method = "D307578E5B1352CFF222308C88A4B242", hash_generated_method = "64802DA73A32857DEC6EC7D9C593228B")
    
public long getFileSize()
    {
    	return getTaintLong();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.671 -0400", hash_original_method = "A53D40E17B267B94F9902E8BCA972EA7", hash_generated_method = "9136AAAB44CC60A97F3523420F729D89")
    
public Date getLastViewedByMeDate()
    {
    	Date d = new Date();
    	d.addTaint(getTaint());
    	return d;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.674 -0400", hash_original_method = "845B646254202C43CF23B7C6C115E811", hash_generated_method = "63FF76728A3EF27D6FDE15A9CC0A132C")
    
public String getMimeType()
    {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.678 -0400", hash_original_method = "18A124938F6B25CC0F620A6822CF18FD", hash_generated_method = "A3C5F6A040A22E4ABF899E43BBB12462")
    
public Date getModifiedByMeDate()
    {
    	Date d = new Date();
    	d.addTaint(getTaint());
    	return d;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.682 -0400", hash_original_method = "E184AF7E9A2CD8CCF26D87F6D9DE9407", hash_generated_method = "B4C8B88E79D709CC899F2297501A2EC4")
    
public Date getModifiedDate()
    {
        Date d = new Date();
    	d.addTaint(getTaint());
    	return d;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.685 -0400", hash_original_method = "049F35956968E022AE2CBB37E5B8A6F9", hash_generated_method = "C4A39122FC6896EFA6A6304E9454CABB")
    
public String getOriginalFilename()
    {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.689 -0400", hash_original_method = "B2B4D5F8E37099378FD5133610E30E67", hash_generated_method = "339EDE79B39787D0B48D63D91750EF45")
    
public boolean isPinnable()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.693 -0400", hash_original_method = "8B711A87F970EE7A5A7975D25A23A062", hash_generated_method = "1F309F16E9ADCA11A1A30CB1E8C74EA4")
    
public boolean isPinned()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.696 -0400", hash_original_method = "05F97A6BC7A956E0EC8FD0594F097453", hash_generated_method = "E1F993012CA64D84971727DFE39B83CF")
    
public long getQuotaBytesUsed()
    {
    	return getTaintLong();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.700 -0400", hash_original_method = "32913D2A259EF41B2469B5F0AA445B93", hash_generated_method = "845AD6F0076078ADF3CF457F61ABD0CA")
    
public Date getSharedWithMeDate()
    {
    	Date d = new Date();
    	d.addTaint(getTaint());
    	return d;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.704 -0400", hash_original_method = "07B9B9CC67225347D66AAAEA8290AADB", hash_generated_method = "FF47A35CA17B681F4058EC62599580C5")
    
public String getTitle()
    {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.707 -0400", hash_original_method = "F734C08DE49D87D9EBB007E3FC1A0324", hash_generated_method = "11427834ED9CEE34F5190179DBF14675")
    
public String getWebContentLink()
    {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.711 -0400", hash_original_method = "331183B1072E4D32D4DA6B7C1BC7D2D5", hash_generated_method = "F99C6219C24A12AE49B2908953C81ABA")
    
public String getWebViewLink()
    {
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.715 -0400", hash_original_method = "947AFE6122BDC78F8F06A7E5646AFCA6", hash_generated_method = "A7B6D5B8E3FF8B1F9ADCEC60153191D3")
    
public boolean isInAppFolder()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.719 -0400", hash_original_method = "77879D4B41C68C813AB17381AEA20C04", hash_generated_method = "865FE4CEB4AEFAD8832C51F6A7EE2D4B")
    
public boolean isEditable()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.722 -0400", hash_original_method = "32CBC947F3A7D2DF4BCF71124A621FB8", hash_generated_method = "E0EBB85DC5216E75A12F182A36223A19")
    
public boolean isFolder()
    {
        return "application/vnd.google-apps.folder".equals(this.getMimeType());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.725 -0400", hash_original_method = "3A5E361A43027B34FF35254C968B5E0D", hash_generated_method = "3A2C8AB067262F7A2DFF3F84F2B2566C")
    
public boolean isRestricted()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.730 -0400", hash_original_method = "A6FBECAF05C6CFEF7095F098F2614C24", hash_generated_method = "D290E44991968E802B640A1410B61248")
    
public boolean isShared()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.738 -0400", hash_original_method = "46ED447D3B047093812461913F46B738", hash_generated_method = "5185C0F3F758C46C4233992513372522")
    
public boolean isStarred()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.744 -0400", hash_original_method = "018F1E956FD245BD83E480018AB6F2B8", hash_generated_method = "954AEBF3B1EAB53B63A9FAFE7B87E788")
    
public boolean isTrashed()
    {
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.748 -0400", hash_original_method = "DD3A4C8BEAF1F9C227278DF921ECC2DF", hash_generated_method = "AFE8BDB93C4563FF31C3B13BA599EF02")
    
public boolean isViewed()
    {
    	return getTaintBoolean();
    }

    //@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.753 -0400", hash_original_method = "E1714230D574BCC5261ED1B1DCD9D5BC", hash_generated_method = "2DA81761A3ECCFE7DB2B8FC7841B0351")
    
//protected abstract java.lang.Object a(com.google.android.gms.drive.metadata.MetadataField  r0);
}
