package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public abstract class Uri implements Parcelable, Comparable<Uri> {
	/*
	private final static int NOT_FOUND = -1;
	private static final String NOT_CACHED = new String("NOT CACHED");
	private final static int NOT_CALCULATED = -2;
	private static final String NOT_HIERARCHICAL
     = "This isn't a hierarchical URI.";
	private static final String DEFAULT_ENCODING = "UTF-8";
	*/
	
	@DSModeled(DSC.SAFE)
	public int hashCode() {
        return toString().hashCode();
    }

	@DSModeled(DSC.SAFE)
	private Uri() {}  //Prevents external subclassing.
	
	public boolean equals(Object o) {
		return true;
		/*
		if (!(o instanceof Uri)) {
            return false;
        }

        Uri other = (Uri) o;

        return toString().equals(other.toString());
        */
	}
	
	public boolean isOpaque() {
        return !isHierarchical();
    }
	public boolean isAbsolute() {
        return !isRelative();
    }
	
	@DSModeled(DSC.SAFE)
    public static Uri parse(String uriString) {
        return new StringUri(uriString);
    }
	
	/* Child classes */
	
	/*
	static abstract class AbstractPart {
		static class Representation {
            static final int BOTH = 0;
            static final int ENCODED = 1;
            static final int DECODED = 2;
        }
	}
	*/
	
	private abstract static class AbstractHierarchicalUri extends Uri {
		@DSModeled(DSC.SAFE)
		public AbstractHierarchicalUri() {
			//Does not exist in the original, created for specdump
		}
	}
	
	public static final class Builder {
		
	}
	
	private static class StringUri extends AbstractHierarchicalUri {
		static final int TYPE_ID = 1;
		
		private final String uriString;
		private DSTaintObject dsTaint = new DSTaintObject();
		
		@DSModeled(DSC.BAN)  //From original MIT markup
        private StringUri(String uriString) {
            this.uriString = uriString;
            dsTaint.addTaint(uriString);
        }
		
		@Override
		public int describeContents() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int compareTo(Uri arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getScheme() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isHierarchical() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isRelative() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getSchemeSpecificPart() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedSchemeSpecificPart() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getAuthority() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedAuthority() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUserInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedUserInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getHost() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getPort() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getPath() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedPath() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getQuery() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedQuery() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getFragment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedFragment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<String> getPathSegments() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getLastPathSegment() {
			// TODO Auto-generated method stub
			return null;
		}

		@DSModeled(DSC.SAFE)
		@Override
		public String toString() {
			return dsTaint.getTaintString();
			//return uriString;
		}

		@Override
		public Builder buildUpon() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	/*
	static abstract class AbstractPart {
		
	}
	
	static class Part extends AbstractPart {
		 static final Part NULL = new EmptyPart(null);
		 
		 private static class EmptyPart extends Part {
			 public EmptyPart(String value) {
	                //super(value, value);
	         }
		 }
	}
	
	static class PathPart extends AbstractPart {
		static final PathPart EMPTY = new PathPart("", "");
		
		private PathPart(String encoded, String decoded) {
            //super(encoded, decoded);
        }
	}
	
	private static class HierarchicalUri extends AbstractHierarchicalUri {
		private DSTaintObject dsTaint = new DSTaintObject();
		
		private HierarchicalUri(String scheme, Part authority, PathPart path,
                Part query, Part fragment) {
			dsTaint.addTaints(scheme, authority, path, query, fragment);
		}
		@Override
		public int describeContents() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int compareTo(Uri arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getScheme() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isHierarchical() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isRelative() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getSchemeSpecificPart() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedSchemeSpecificPart() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getAuthority() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedAuthority() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getUserInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedUserInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getHost() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getPort() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getPath() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedPath() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getQuery() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedQuery() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getFragment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getEncodedFragment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<String> getPathSegments() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getLastPathSegment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Builder buildUpon() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	*/
	
	/* Abstract Methods */
	public abstract String getScheme();
	public abstract boolean isHierarchical();
	public abstract boolean isRelative();
	public abstract String getSchemeSpecificPart();
	public abstract String getEncodedSchemeSpecificPart();
	public abstract String getAuthority();
	public abstract String getEncodedAuthority();
	public abstract String getUserInfo();
	public abstract String getEncodedUserInfo();
	public abstract String getHost();
	public abstract int getPort();
	public abstract String getPath();
	public abstract String getEncodedPath();
	public abstract String getQuery();
	public abstract String getEncodedQuery();
	public abstract String getFragment();
	public abstract String getEncodedFragment();
	public abstract List<String> getPathSegments();
	public abstract String getLastPathSegment();
	public abstract String toString();
	public abstract Builder buildUpon();
}