package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StructStat {
    public long st_dev;
    public long st_ino;
    public int st_mode;
    public long st_nlink;
    public int st_uid;
    public int st_gid;
    public long st_rdev;
    public long st_size;
    public long st_atime;
    public long st_mtime;
    public long st_ctime;
    public long st_blksize;
    public long st_blocks;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.022 -0400", hash_original_method = "22486884C03B7F82D2DEC9BC949FA3E4", hash_generated_method = "17549DB1424D3C627327C69CCC9C0309")
    @DSModeled(DSC.SAFE)
     StructStat(long st_dev, long st_ino, int st_mode, long st_nlink, int st_uid, int st_gid,
            long st_rdev, long st_size, long st_atime, long st_mtime, long st_ctime,
            long st_blksize, long st_blocks) {
        dsTaint.addTaint(st_size);
        dsTaint.addTaint(st_gid);
        dsTaint.addTaint(st_blksize);
        dsTaint.addTaint(st_atime);
        dsTaint.addTaint(st_ino);
        dsTaint.addTaint(st_nlink);
        dsTaint.addTaint(st_mtime);
        dsTaint.addTaint(st_ctime);
        dsTaint.addTaint(st_mode);
        dsTaint.addTaint(st_uid);
        dsTaint.addTaint(st_dev);
        dsTaint.addTaint(st_blocks);
        dsTaint.addTaint(st_rdev);
        // ---------- Original Method ----------
        //this.st_dev = st_dev;
        //this.st_ino = st_ino;
        //this.st_mode = st_mode;
        //this.st_nlink = st_nlink;
        //this.st_uid = st_uid;
        //this.st_gid = st_gid;
        //this.st_rdev = st_rdev;
        //this.st_size = st_size;
        //this.st_atime = st_atime;
        //this.st_mtime = st_mtime;
        //this.st_ctime = st_ctime;
        //this.st_blksize = st_blksize;
        //this.st_blocks = st_blocks;
    }

    
}

