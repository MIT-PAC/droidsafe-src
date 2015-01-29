#!/usr/bin/perl

my $file = shift;
die("rmcomment <infile> [<outfile.>]\n") if (!defined($file));

open (IFILE, "<$file");

$outName = shift;

$outFile = \*STDOUT;

if (defined($outName)) {
    open($outFile, ">$outName");
}

$commentStarted = 0;
while (<IFILE>) {
    if (/\*\//) {
        $commentStarted = 0;
        next;
    }
    if (/\/\*/) {
        $commentStarted = 1;
        next;
    }

    next if ($commentStarted );

    print $outFile $_;
}



