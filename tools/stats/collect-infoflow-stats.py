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
    # define options here:
    parser.add_argument('-f', '--filter', help="Filter apps by app names in this file")
    parser.add_argument('dir')
    args = parser.parse_args(argv)


    # further process settings & args if necessary
    return args

def run(args):
    path = os.environ['ANDROID_SRC_HOME'] + '/android-apps/engagements'
    droidsafe_gen_dirs = [os.path.join(dirpath, f) for dirpath, dirnames, files in os.walk(path) for f in
            fnmatch.filter(dirnames, args.dir)]
    
    if args.filter:
        appnames = load_appnames_from_file(args.filter)
        filtered_tests = []
        for v in droidsafe_gen_dirs:
            for appname in appnames:
                appname = appname.lower()
                if appname in v.lower():
                    filtered_tests.append(v)
                    break
        droidsafe_gen_dirs = filtered_tests


    higher_level_flows = 0
    infoflow_set_count = 0 
    infoflow_total_size = 0

    with open('infoflow-app-stats.csv', 'wb') as app_stat_csv_file:
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
            high_level_file = os.path.join(droidsafe_gen_dir, "high-level.txt")
            info_set_size_file = os.path.join(droidsafe_gen_dir, "info-set-size.txt")
            app_stat_file = os.path.join(droidsafe_gen_dir, "app-stats.csv")
            src_dir = os.path.join("/".join(droidsafe_gen_dir.split("/")[:-1]), "src")
            if not os.path.exists(high_level_file) or os.stat(high_level_file).st_size == 0 or \
               not os.path.exists(info_set_size_file) or os.stat(info_set_size_file).st_size == 0 or \
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

            with open(high_level_file) as f:
                line = f.read().splitlines()[0]
                higher_level_flows += int(line)
 
            # read i
            with open(info_set_size_file) as f:
                line = f.read().splitlines()[0]
                infoflow_set_cnt, infoflow_size = tuple(line.split(" "))
                infoflow_set_count += int(infoflow_set_cnt)
                infoflow_total_size += int(infoflow_size)
 
    
    print "total infoflow size: " + str(infoflow_total_size)
    print "infoflow set count: " + str(infoflow_set_count)
    print "total higher-level-flows: " + str(higher_level_flows)
    print "avg infoflow set size: " + str(float(infoflow_total_size)/infoflow_set_count)
    
def load_appnames_from_file(file_name):
    if not os.path.isabs(file_name):
        file_name = os.path.abspath(file_name)

    if not os.path.isfile(file_name):
        sys.exit("Appname filter file does not exist!")

    app_names = []
    with open(file_name) as f:
        for app_name in f:
            app_names.append(app_name.lower().strip())
    return app_names  

def main(argv=None):
    args = process_command_line(argv)
    # application code here, like:
    run(args)
    return 0        # success

if __name__ == '__main__':
    status = main()
    sys.exit(status)
