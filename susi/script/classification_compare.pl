#!/usr/bin/perl -w
#
# script to put security labels on the methdo 
#
use Getopt::Long;
use IO::Handle;

$annoAtEndOfLine = 0;
$removeAnnotation = 0;
$reportFile = "none";
GetOptions(
        "end",        => \$annoAtEndOfLine,
        "remove",     => \$removeAnnotation,
        "report=s"    =>  \$reportFile);  # flag

$inName1 = shift @ARGV;
$inName2 = shift @ARGV;

if (!defined($inName2)) {
    &syntax();
    exit -1;
}

#
# syntax: <infile> <outfile> <callback_out> <change_file_out> 
#


($rsink1, $rsource1) = readFile($inName1);
($rsink2, $rsource2) = readFile($inName2);

@sourceRemoved = ();
@sinkRemoved = ();

@sourceAdded = ();
@sinkAdded = ();

@sourceLabeled = ();
@sinkLabeled = ();

@sourceChanged = ();
@sinkChanged = ();

@sourceIntact = ();
@sinkIntact = ();

foreach $sink(keys %{$rsink1}) {
    if (!defined($rsink2->{$sink})) {
        push @sinkRemoved, $sink;
        next;
    }
    if ($rsink1->{$sink} eq $rsink2->{$sink}) {
        push @sinkIntact, $sink;
        next;
    }
    if ($rsink1->{$sink} =~ /UNCATEGORIZED/) {
        push @sinkLabeled, $sink;
        next;
    }
    push @sinkChanged, $sink;
}

foreach $sink(keys %{$rsink2}) {
    if (!defined($rsink1->{$sink})) {
        push @sinkAdded, $sink;
        next;
    }
}

foreach $source(keys %{$rsource1}) {
    if (!defined($rsource2->{$source})) {
        push @sourceRemoved, $source;
        next;
    }
    if ($rsource1->{$source} eq $rsource2->{$source}) {
        push @sourceIntact, $source;
        next;
    }
    if ($rsource1->{$source} =~ /UNCATEGORIZED/) {
        push @sourceLabeled, $source;
        #print $rsource2->{$source}, "\n";
        next;
    }
    push @sourceChanged, $source;
}

foreach $source(keys %{$rsource2}) {
    if (!defined($rsource1->{$source})) {
        push @sourceAdded, $source;
        next;
    }
}

$sourceRemoved = @sourceRemoved;
$sinkRemoved = @sinkRemoved;
print "\n################ Labels removed ############# \n";
print "Source $sourceRemoved, Sink: $sinkRemoved \n";

$sourceAdded = @sourceAdded;
$sinkAdded = @sinkAdded;
print "\n################ Labels Added ############# \n";
print "Source $sourceAdded, Sink: $sinkAdded \n";

$sourceLabeled = @sourceLabeled;
$sinkLabeled = @sinkLabeled;
print "\n################ Labels Categorized ############# \n";
print "Source $sourceLabeled, Sink: $sinkLabeled \n";

$sourceChanged = @sourceChanged;
$sinkChanged = @sinkChanged;
print "\n################ Labels changed ############# \n";
print "Source $sourceChanged, Sink: $sinkChanged \n";

$sourceIntact = @sourceIntact;
$sinkIntact = @sinkIntact;
print "\n################ Labels Kept ############# \n";
print "Source $sourceIntact, Sink: $sinkIntact \n";


print "\n\n#########################################################\n";
print "#### Sublist of APIs with sink/source labels added ########\n";
print "SOURCE:  \n";
$count = 0;
foreach my $api(sort @sourceAdded) {
    $count++;
    #last if ($count == 30);
    print $api, "-",  $rsource2->{$api}, "\n";
}

print "SINK:  \n";
$count = 0;
foreach my $api(sort @sinkAdded) {
    $count++;
    #last if ($count == 30);
    print $api, "\n";
    print $api, "-",  $rsink2->{$api}, "\n";
}



print "\n\n#########################################################\n";
print "#### Sublist of APIs with sink/source labels removed ########\n";
print "SOURCE:  \n";
$count = 0;
foreach my $api(sort @sourceRemoved) {
    $count++;
    #last if ($count == 30);
    print $api, "\n";
}

print "SINK:  \n";
$count = 0;
foreach my $api(sort @sinkRemoved) {
    $count++;
    #last if ($count == 30);
    print $api, "\n";
}

print "\n\n#########################################################\n";
print "#### Sublist of APIs with sink/source labels changed ########\n";
print "SOURCE:  \n";
$count = 0;
foreach my $api(sort @sourceChanged) {
    $count++;
    print $api, " - ", $rsource1->{$api}, " -> ", $rsource2->{$api}, "\n";
}

print "SINK:  \n";
$count = 0;
foreach my $api(sort @sinkChanged) {
    $count++;
    #last if ($count == 30);
    print $api, " - ", $rsink1->{$api}, " -> ", $rsink2->{$api}, "\n";
}




#######################################################################
#
#######################################################################
sub readFile {
    my ($inName) = @_;
    my %sinkHash = ();
    my %sourceHash = ();
    open(my $inFile, "<$inName") || die("Cannot open $inName \n");

    while(<$inFile>) {
        $line = $_;

        $line =~ s/^\s+//g;
        $line =~ s/\s+$//g;

        @tokens = split(/-/, $line);
        my @outList = ();
        $method = "";
        foreach $token(@tokens) {
            $token =~ s/^\s*//g;
            $token =~ s/\s*$//g;
            if ($token =~ /</) {
                $method = $token;
            }
            else {
                push @outList, $token;
            }
        }

        foreach my $anno(@outList) {
            $anno =~ s/\@DS(Sink|Source)\(\{//g;
            $anno =~ s/\}\)//g;
            # print $anno, "\n";
            # print "$method  => $anno \n";
            if ($anno =~ /DSSink/) {
                $sinkHash{$method} = $anno;
            } elsif ($anno =~ /DSSource/)  {
                $sourceHash{$method} = $anno;
            }
        }
    }
    return (\%sinkHash, \%sourceHash);
}


exit 0;

##################################################################################
# Functions
##################################################################################

#############################################################
sub syntax() {
    print "classfication_compare <file1> <file2> \n";
    exit -1;
}


