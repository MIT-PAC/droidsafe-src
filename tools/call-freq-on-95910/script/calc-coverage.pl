#!/bin/perl


my $modelFileName = shift;
my $callSiteFile = shift;

syntax() if !defined $callSiteFile;

#readin modeled classes

open(my $modelFile, "<$modelFileName") || die("cannot open $modelFileName ");
open(my $callFile, "<$callSiteFile") || die("cannot open $callSiteFile ");

my %modelClasses = ();
while(<$modelFile>) {
    next if /^\s*$/;
    s/\s+$//g;

    print "### $_ already there \n" if defined($modelClasses{$_});

    $modelClasses{$_} = 1;
}


my $total = 0;


my %counterHash = ();
while(<$callFile>) {
    next if $_ !~  /\d/;
    next if /^\s*$/;
    s/\s+$//g;
    ($method, $freq) = split(/\s+/); 
    @tokens = split(";.", $method);
    $class = shift @tokens;
    $class =~ s/^L//g;
    $class =~ s/\//./g;
    # print "$freq => $class\n";

    next if $freq !~ /\d/;

    $counterHash{$class} = 0 if !defined($counterHash{$class});
    $counterHash{$class} += $freq;
    $total += $freq;
}

my %modeledHash = ();
my $unmodeled = 0;
my $counter = 0;
my $totalClasses = keys %counterHash;

print "\n##########################################################\n";
print "#Classes WITHOUT models" ;
print "\n##########################################################\n";
foreach my $class (sort keys %counterHash) {
    next if defined $modelClasses{$class};
    $unmodeled += $counterHash{$class};
    $counter++;
    print $class, "\n";
}
$percent = (100.0 * $unmodeled) / $total;

print "#classes: $counter / $totalClasses, freq: $unmodeled / $total  => $percent %\n";

print "\n##########################################################\n";
print "#Classes WITH models" ;
print "\n##########################################################\n";
my $modeled = 0;
$counter = 0;
foreach my $class (sort keys %counterHash) {
    next if !defined $modelClasses{$class};
    $modeled += $counterHash{$class};
    $counter++;
    print $class, "\n";
}

$percent = (100.0 * $modeled) / $total;
print "#classes: $counter / $totalClasses, freq: $modeled / $total => $percent %\n";

sub syntax {
    print "check-model.pl <model-class-list>  <api-call-site> \n";
    exit -1;
}
