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
    path = os.environ['APAC_HOME'] + '/android-apps/'
    droidsafe_gen_dirs = [os.path.join(dirpath, f) for dirpath, dirnames, files in os.walk(path) for f in
            fnmatch.filter(dirnames, 'droidsafe-gen')]
    

    ambg =  defaultdict(lambda : defaultdict(int))
    unambg = defaultdict(lambda : defaultdict(int))
    total = defaultdict(lambda : defaultdict(int))
    setsizesum = defaultdict(lambda : defaultdict(int))
    setsizeone = defaultdict(lambda : defaultdict(int))
   
    with open('app-stats.csv', 'wb') as app_stat_csv_file:
        app_stat_csv_writer = csv.writer(app_stat_csv_file)
        app_stat_csv_writer.writerow(["App Name", "LOCs", "String Analysis", "Class Cloning", "Points-to Analysis", "Value Analysis", "Infoflow Analysis"])

        for droidsafe_gen_dir in droidsafe_gen_dirs:
            # only keep apps that have va and app stats
            va_stat_file = os.path.join(droidsafe_gen_dir, "va-stats.csv")
            app_stat_file = os.path.join(droidsafe_gen_dir, "app-stats.csv")
            src_dir = os.path.join("/".join(droidsafe_gen_dir.split("/")[:-1]), "src")
            if not os.path.exists(va_stat_file) or os.stat(va_stat_file).st_size == 0 or not
                os.path.exists(app_stat_file) or os.stat(app_stat_file).st_size == 0 or not os.path.exists(src_dir):
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
                        unambg[cls][field] += 1
                        setsizesum[cls][field] += int(size)
                        if size == "1":
                            setsizeone[cls][field] += 1
                    total[cls][field] += 1

    # write all app va stats into global va stats file
    with open('va-stats.csv', 'wb') as csvfile:
        csvwriter = csv.writer(csvfile)
        csvwriter.writerow(["Class", "Field", "Unambiguous", "%", "Ambiguous", "%", "Avg Set Size", "Set Size 1", "%", "Total"])
        for cls, fields in total.items():
            for field, total in fields.items():
                unambg_count = unambg[cls][field]
                unambg_per = '{:.2%}'.format(float(unambg_count)/total)
                ambg_count = ambg[cls][field]
                ambg_per = '{:.2%}'.format(float(ambg_count)/total)
                if unambg_count != 0:
                    avg_setsize = setsizesum[cls][field]/unambg_count
                else:
                    avg_setsize = "n/a"
                csvwriter.writerow([cls, field, unambg_count, unambg_per, ambg_count, ambg_per, avg_setsize,
                    setsizeone[cls][field], '{:.2%}'.format(float(setsizeone[cls][field])/total), total])
    
def main(argv=None):
    settings, args = process_command_line(argv)
    # application code here, like:
    run(settings, args)
    return 0        # success

if __name__ == '__main__':
    status = main()
    sys.exit(status)
