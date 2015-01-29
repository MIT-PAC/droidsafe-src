#!/usr/bin/perl
# perl script to process SUSI files and generate a file that can be used by 
# doppelganger tagger
$inFile = shift;
$prefix = shift;
$outFile = shift;

if (!defined($prefix)) {
    print "proc_susi.pl <infile> <\@DSPrefix> [<outFile>] \n";
    exit -1;
}

open(IFILE, "<$inFile") || die("Cannot open $inFile ");

if (defined($outFile)) {
    open($out, ">$outFile") || die("Cannot open $outFile");
}
else {
    $out = \*STDOUT;
}


my @catHash = ();

while(<IFILE>) {
    next if ($_ !~ /^\</);
    next if ($_ !~ />/);
    next if (/^\s*$/);
    s/android\.permission\.[A-Z_]+//g;
    #print;
    if ($_ =~ /^(\<.+?\>)\s+\(([\w_]+)\)\s*$/) {
        my $method = $1;
        my $cat = $2;
        if ($cat =~ /NO_CATEGORY/) {
            $cat = "SENSITIVE_UNCATEGORIZED";
        }
        my $kind = "$prefix". "Kind." . $cat;
        my $anno = "\@$prefix({$kind})";
        $catHash{$cat} = $anno;
        #print "=> $method - $anno \n";

        print $out "$method - $anno \n";
    }
}

my $enum = $prefix . "Kind";
print "public enum $enum { \n";

foreach $cat (sort keys %catHash) {
    print "$cat, \n";
    
}
print "UNSPECIFIED\n";

print "};\n";



