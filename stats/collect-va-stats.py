#!/usr/bin/env python

from subprocess import check_output
from collections import defaultdict
import csv
import sys
import optparse
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
    parser = optparse.OptionParser(formatter=optparse.TitledHelpFormatter(width=78), add_help_option=None)

    # define options here:
    parser.add_option('-h', '--help', action='help', help='Show this help message and exit.')

    settings, args = parser.parse_args(argv)

    # check number of arguments, verify values, etc.:
    if args:
        parser.error('program takes no command-line arguments; ''"%s" ignored.' % (args,))

    # further process settings & args if necessary
    return settings, args

def run(settings, args):
    path = os.environ['APAC_HOME'] + '/android-apps/engagements'
    droidsafe_gen_dirs = [os.path.join(dirpath, f) for dirpath, dirnames, files in os.walk(path) for f in
            fnmatch.filter(dirnames, 'droidsafe-gen-objsens')]
    

    ambg =  defaultdict(lambda : defaultdict(int))
    unambg = defaultdict(lambda : defaultdict(int))
    set_size_zero_dict = defaultdict(lambda : defaultdict(int))
    total_dict = defaultdict(lambda : defaultdict(int))
    setsizesum = defaultdict(lambda : defaultdict(int))
    set_size_one_dict = defaultdict(lambda : defaultdict(int))
    TARGETED_FIELDS = ["java.lang.CharSequence mText",
                       "java.lang.String uriString",
                       "java.lang.String mAction",
                       "android.net.Uri mData",
                       "android.content.ComponentName mComponent",
                       "java.lang.String mType",
                       "java.lang.String mClass"]
    
    total_of_totals = 0
    total_of_size_0 = 0
    total_of_size_1 = 0
    total_of_unambiguous = 0
    sum_of_all_set_sizes = 0

    with open('app-stats.csv', 'wb') as app_stat_csv_file:
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
            va_stat_file = os.path.join(droidsafe_gen_dir, "va-stats.csv")
            app_stat_file = os.path.join(droidsafe_gen_dir, "app-stats.csv")
            src_dir = os.path.join("/".join(droidsafe_gen_dir.split("/")[:-1]), "src")
            if not os.path.exists(va_stat_file) or os.stat(va_stat_file).st_size == 0 or \
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
            with open(va_stat_file, 'rb') as csvfile:
                statreader = csv.reader(csvfile)
                # skip headers
                next(statreader, None)

                for row in statreader:
                    if len(row) == 4:
                        field, size, methods, allocNode = row
                    else:
                        field, size, methods = row
                    field = field[1:-1]
                    cls, field = field.split(" ", 1)
                    cls = cls[:-1]
                    if size == "UNKNOWN":
                        ambg[cls][field] += 1
                    else:
                        intsize = int(size)
                        unambg[cls][field] += 1
                        if intsize > 0:
                            setsizesum[cls][field] += intsize
                            if intsize == 1:
                                set_size_one_dict[cls][field] += 1
                        else:
                            set_size_zero_dict[cls][field] += 1
                    total_dict[cls][field] += 1

    # write all app va stats into global va stats file
    with open('va-stats.csv', 'wb') as csvfile:
        csvwriter = csv.writer(csvfile)
        csvwriter.writerow(["Class", 
                            "Field", 
                            "Unambiguous", 
                            "%", 
                            "Ambiguous", 
                            "%", 
                            "Avg Set Size",
                            "Set Size 1", 
                            "%", 
                            "Set Size 0",
                            "%",
                            "Total # of values",
                            "Total"])
        for cls, fields in total_dict.items():
            for field, total in fields.items():
                set_size_zero = set_size_zero_dict[cls][field]
                set_size_one = set_size_one_dict[cls][field]
                unambg_count = unambg[cls][field]
                ambg_count = ambg[cls][field]
                over_zero_count = total-set_size_zero
                setsizesum_count = setsizesum[cls][field]
                if total == 0:
                    unambg_perc = "n/a"
                else:
                    unambg_perc = '{:.2%}'.format(float(unambg_count)/total)

                if total == 0:
                    ambg_perc = "n/a"
                else:
                    ambg_perc = '{:.2%}'.format(float(ambg_count)/total)
               
                if total == 0:
                    set_size_zero_perc = "n/a"
                else:
                    set_size_zero_perc = '{:.2%}'.format(float((set_size_zero))/total)

                if unambg_count != 0:
                    avg_setsize = float(setsizesum_count)/total
                else:
                    avg_setsize = "n/a"
                
                if over_zero_count == 0:
                    set_size_one_perc = "0%"
                else:
                    set_size_one_perc = '{:.2%}'.format(float(set_size_one)/over_zero_count)

                csvwriter.writerow([cls, field, unambg_count, unambg_perc, ambg_count, ambg_perc, avg_setsize,
                                    set_size_one, set_size_one_perc, set_size_zero, set_size_zero_perc,
                                    setsizesum_count, total])

                if field in TARGETED_FIELDS:
                     total_of_totals += total
                     total_of_size_1 += set_size_one
                     total_of_size_0 += set_size_zero
                     total_of_unambiguous += unambg_count
                     sum_of_all_set_sizes += setsizesum_count

        print "unambigious: " + '{:.2%}'.format(float(total_of_unambiguous)/total_of_totals)
        print "size 1: " + '{:.2%}'.format(float(total_of_size_1)/total_of_totals)
        print "avg size 1: " + str(float(sum_of_all_set_sizes)/(total_of_totals - total_of_size_0))

                   


def main(argv=None):
    settings, args = process_command_line(argv)
    # application code here, like:
    run(settings, args)
    return 0        # success

if __name__ == '__main__':
    status = main()
    sys.exit(status)
