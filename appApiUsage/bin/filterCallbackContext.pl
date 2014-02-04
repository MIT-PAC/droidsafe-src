#!/usr/bin/perl
#  
$inName = shift @ARGV;
$outName = shift @ARGV;

#
# syntax: <infile> <outfile> 
#

if (defined($inName)) {
	open($inFile, "<$inName") || die("Cannot open $inName \n");
} else {
    $inFile = \*STDIN;
}

%hash = ();

while(<$inFile>) {
    s/\s*$//g;
    next if /^\s*$/;
    if (/Intent/) {
        my @list = ();
        $hash{_0intent} = \@list if !defined($hash{_0intent}); 
        push @{$hash{_0intent}}, $_;
        next;
    }

    if (/Bundle/) {
        my @list = ();
        $hash{_1bundle} = \@list if !defined($hash{_1bundle}); 
        push @{$hash{_1bundle}}, $_;
        next;
    }

    if (/Context/) {
        my @list = ();
        $hash{_2context} = \@list if !defined($hash{_2context}); 
        push @{$hash{_2context}}, $_;
        next;
    }

    if (/Parcelable/) {
        my @list = ();
        $hash{_3parcelable} = \@list if !defined($hash{_3parcelable}); 
        push @{$hash{_3parcelable}}, $_;
        next;
    }

    my @list = ();
    $hash{_9zothers} = \@list if !defined($hash{_9zothers}); 
    push @{$hash{_9zothers}}, $_;
}


if (defined($outName)) {
	open($outFile, ">$outName") || die("Cannot open $outName \n");
} else {
    $outFile = \*STDOUT;
}
   
foreach $comp (sort keys %hash) {
    my @list = sort @{$hash{$comp}};
    print $outFile join("\n", @list), "\n\n";
}


