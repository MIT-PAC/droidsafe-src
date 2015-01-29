#!/usr/bin/env python

from subprocess import check_output
from collections import defaultdict
import csv
import sys
import argparse
import os
import fnmatch
import xml.etree.ElementTree as ET

def process_command_line(argv):
    """
    Return a 2-tuple: (settings object, args list).
    `argv` is a list of arguments, or `None` for ``sys.argv[1:]``.
    """
    if argv is None:
        argv = sys.argv[1:]

    # initialize the parser object:
    parser = argparse.ArgumentParser()

    parser.add_argument('dir')

    args = parser.parse_args(argv)

    # further process settings & args if necessary
    return args

def run(args):
    path = os.environ['ANDROID_SRC_HOME'] + '/android-apps/engagements'
    droidsafe_gen_dirs = [os.path.join(dirpath, f) for dirpath, dirnames, files in os.walk(path) for f in
            fnmatch.filter(dirnames, args.dir)]
    
    explicit_unamb_target_count = 0
    implicit_unamb_count_nodata = 0 
    implicit_unamb_count = 0
    explicit_unamb_count = 0
    implicit_intent_count = 0
    explicit_intent_count = 0
    total_intent_count = 0
    explicit_inapp = 0

    with open('icc-app-stats.csv', 'wb') as app_stat_csv_file:
        app_stat_csv_writer = csv.writer(app_stat_csv_file)
        app_stat_csv_writer.writerow(["App Name", 
                                      "LOCs", 
                                      "String Analysis", 
                                      "Class Cloning", 
                                      "Points-to Analysis", 
                                      "Value Analysis", 
                                      "Infoflow Analysis"])

        for droidsafe_gen_dir in droidsafe_gen_dirs:
            # only keep apps that have va and app stats
            icc_stat_file = os.path.join(droidsafe_gen_dir, "icc-stats.csv")
            app_stat_file = os.path.join(droidsafe_gen_dir, "app-stats.csv")
            src_dir = os.path.join("/".join(droidsafe_gen_dir.split("/")[:-1]), "src")
            if not os.path.exists(icc_stat_file) or os.stat(icc_stat_file).st_size == 0 or \
               not os.path.exists(app_stat_file) or os.stat(app_stat_file).st_size == 0 or \
               not os.path.exists(src_dir):
                continue

            # get size of app
            size = -1
            root = ET.fromstring(check_output(["cloc", src_dir, "--quiet", "--xml", "--progress-rate", "0"]).strip())
            for language in root.iter('language'):
                if language.attrib['name'] == "Java":
                    size = language.attrib['code']
                    break
            if size == -1:
                continue

            # copy app stat info into global app stat file
            with open(app_stat_file, 'rb') as csvfile:
                statreader = csv.reader(csvfile)
                # skip headers
                next(statreader, None)

                for row in statreader:
                    app_stat_csv_writer.writerow(row[:1] + [size] + row[1:])

            # read in app va stats
            with open(icc_stat_file, 'rb') as csvfile:
                statreader = csv.reader(csvfile)
                # skip headers
                next(statreader, None)

                for row in statreader:
                    allocnode, typ, targetcount, targetcount_nodata, inapptargetcount = row
                    if typ == "EXPLICIT":
                        explicit_intent_count += 1
                        if targetcount != "UNKNOWN":
                             explicit_unamb_count += 1
                             explicit_unamb_target_count += int(targetcount)
                        if inapptargetcount != "UNKNOWN":
                             explicit_inapp += int(targetcount)
                    elif typ == "IMPLICIT":
                        implicit_intent_count += 1
                        if targetcount != "UNKNOWN":
                            implicit_unamb_count += 1
                        if targetcount_nodata:
                            implicit_unamb_count_nodata += 1
                    total_intent_count += 1

    print "total implicit intent count: " + str(implicit_intent_count) + ' ({:.2%})'.format(float(implicit_intent_count)/total_intent_count)
    print "unambiguous implicit intents: " + str(implicit_unamb_count) +' ({:.2%})'.format(float(implicit_unamb_count)/implicit_intent_count)
    print "unambiguous implicit intents (nodata): " + str(implicit_unamb_count_nodata) + ' ({:.2%})'.format(float(implicit_unamb_count_nodata)/implicit_intent_count)
    print "total explicit intent count: " + str(explicit_intent_count) + ' ({:.2%})'.format(float(explicit_intent_count)/total_intent_count)
    print "unambiguous explicit intents: " + str(explicit_unamb_count)  + ' ({:.2%})'.format(float(explicit_unamb_count)/explicit_intent_count)
    print "explicit intent in-app targets: " + '{:.2%}'.format(float(explicit_inapp)/explicit_unamb_target_count) 
    print "explicit intent target count avg: " + str(float(explicit_unamb_target_count)/explicit_unamb_count)
    print "total intent count: " + str(total_intent_count)

                   


def main(argv=None):
    args = process_command_line(argv)
    # application code here, like:
    run(args)
    return 0        # success

if __name__ == '__main__':
    status = main()
    sys.exit(status)
