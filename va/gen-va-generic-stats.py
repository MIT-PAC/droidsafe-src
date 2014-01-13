#!/usr/bin/env python

"""
Module docstring.
"""
from collections import defaultdict
import csv
import sys
import optparse
import os
import fnmatch

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
    statfiles = [os.path.join(dirpath, f) for dirpath, dirnames, files in os.walk(path) for f in fnmatch.filter(files, 'va-stats.csv')]
    print str(len(statfiles)) + " stat files found"
    statfiles = filter(lambda x: os.stat(x).st_size != 0, statfiles)
    print str(len(statfiles)) + " nonempty stat files found"

    ambg =  defaultdict(lambda : defaultdict(int))
    unambg = defaultdict(lambda : defaultdict(int))
    total = defaultdict(lambda : defaultdict(int))
    setsizesum = defaultdict(lambda : defaultdict(int))
    setsizeone = defaultdict(lambda : defaultdict(int))
   
    for statfile in statfiles:
        with open(statfile, 'rb') as csvfile:
            statreader = csv.reader(csvfile)
            # skip headers
            next(statreader, None)

            for row in statreader:
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

    with open('generic-results.csv', 'wb') as csvfile:
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
