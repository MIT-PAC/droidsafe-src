package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Date;

public final class MetadataChangeSet
{
	public static class Builder {
		private String title;
		private String mimeType;
		private String description;
        boolean pinned;
        boolean viewed;
        boolean starred;
        String  text;
        Date viewDate;


		@DSSafe
		public Builder() {
			
		}
		
		@DSSafe
		public MetadataChangeSet.Builder setDescription (String description) {
			this.description = description;
			return this;
		}
		@DSSafe
		public MetadataChangeSet.Builder setMimeType (String mimeType) {
			this.mimeType = mimeType;
			return this;
		}
		
		@DSSafe
		public MetadataChangeSet.Builder setTitle (String title) {
			this.title = title;
			return this;
		}
		
		@DSSafe
        Builder setIndexableText(String text) {
            this.text = text;
            return this;
        }
        
		@DSSafe
        Builder setLastViewedByMeDate(Date date) {
            this.viewDate = date;
            return this;
        }


		@DSSafe
        Builder setPinned(boolean pinned) {
            this.pinned = pinned;
            return this;
        }

		@DSSafe
        Builder setStarred(boolean starred) {
            this.starred = starred;
            return this;
        }

        Builder setViewed(boolean viewed) {
            this.viewed = viewed;
            return this;
        }

		public MetadataChangeSet build() {
			MetadataChangeSet set = new MetadataChangeSet(this);
			return set;
		}
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.112 -0400", hash_original_field = "A4F9C5B4953C76F5B89AA2E312760483", hash_generated_field = "41F47A62CAFFA254560ABDB7407022A5")

    public static  MetadataChangeSet HV;

	Builder builder;
    private MetadataChangeSet(Builder builder) {
    	this.builder = builder;
    }


/*    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.120 -0400", hash_original_method = "7FC1DEB925798A0FCF84E305E327906F", hash_generated_method = "9006D8BDDD4C9DF17F84AD6E97A19BAA")
    
public MetadataChangeSet(MetadataBundle  r1)
    {

        HW = MetadataBundle.a(r1);
    }*/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.124 -0400", hash_original_method = "388104B09D631AC1BDD4A8B03D8734C8", hash_generated_method = "5905724F96852B48B443DE2CB6C00717")
    
public String getDescription()
    {
    	return builder.description;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.128 -0400", hash_original_method = "86A275DE05CB819AABA6E8A90B089CE5", hash_generated_method = "8ABE65F85193203A408794AB824FF589")
    
public String getIndexableText()
    {
    	return  builder.text;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.131 -0400", hash_original_method = "2E1505B2DFC178608CA2626DA00B7B27", hash_generated_method = "24373C95F2554C21A8BA3D230B3FFA3E")
    
public Date getLastViewedByMeDate()
    {
    	return builder.viewDate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.135 -0400", hash_original_method = "38100B3CDBED93E7B61C56E974B1E7CE", hash_generated_method = "CEAC70625D727C3DCB6DDAB423ED1205")
    
public String getMimeType()
    {
    	return builder.mimeType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.139 -0400", hash_original_method = "8AC7EC7CD4EEC6CFC7CA900B2711C40A", hash_generated_method = "5E0BD2375EEFB18ECF33E602F646148F")
    
public String getTitle()
    {
    	return builder.title;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.144 -0400", hash_original_method = "2A14314029C6409A9850E3A64647E4D9", hash_generated_method = "7EBBEA4D819D86E4E55FCFF0CFB660EB")
    
public Boolean isPinned()
    {
    	return builder.pinned;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.148 -0400", hash_original_method = "CA3E2322612FCB6D1D956F44807FFFCA", hash_generated_method = "539B85C0991DF9963AF0A0CDCEB1D2CD")
    
public Boolean isStarred()
    {
    	return builder.starred;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.152 -0400", hash_original_method = "10AA3665D52DDFEC454BB45638B3150E", hash_generated_method = "82F964A74A0B1497DEA4FBDB356F72DE")
    
public Boolean isViewed()
    {

    	return builder.viewed;
    }

    
}
