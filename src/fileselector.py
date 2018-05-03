'''
5/1/2018 - Pitty
Demo to show basics of the filter mechanism.
User can select one objective (e.g., get a list of all lines in a file)
User can select 0 or more forbidden tools (e.g., Scanners)
More filter/sort options to come

Every (pre-written) file reader code block has tags associated with it to mark its objective and tools is uses, misc info as needed.
The candidate code blocks for now are Python dicts.
Actual content of code blocks is ommitted for now due to bulkiness / hassle of removing newlines

'''




###########################
## DEFINE FILTER OPTIONS ##
###########################

objectives = ["loopByWord", "loopByLine", "listOfWords", "listOfLines", "oneString"]
tools = ["TCF", "TWR", "TC", "BufferedReader", "Scanner", "java.nio", "ArrayList"]
# TFC: Try, catch, finally block. TWR: Try-with-resources, TC: Try-catch
#TODO: filter for *required* tools
#TODO: sortBy = ["Conciseness", "Experience level (beginning -> advanced)"]
#TODO: Java Version compatibility filter?


##################################################
## BUILD LIST OF READERS WITH TAGS, ANNOTATIONS ##
##################################################

allReaders = []

loopByLineTCF = {
	"name":"loopByLineTCF",
	"objective":"loopLines",
	"tools":["TCF","BufferedReader"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(loopByLineTCF)

listOfLinesTCF = {
	"name":"listOfLinesTCF",
	"descripion":"List of Lines using try-catch-finally and BufferedReader",
	"objective":"listOfLines",
	"tools":["TCF","ArrayList","BufferedReader"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(listOfLinesTCF)

#loopByLineTCF = {}
#allReaders.append(loopByLineTCF)
loopByLineTWR = {
	"name":"loopByLineTWR",
	"objective":"loopByLine",
	"tools":["TWR", "BufferedReader"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(loopByLineTWR)

loopByLineTWRDense = {
	"name":"loopByLineTWRDense",
	"objective":"loopByLine",
	"tools":["TWR"],
	"level":"advanced",
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(loopByLineTWRDense)
loopByLineTWRScanner = {
	"name":"loopByLineTWRScanner",
	"objective":"loopByLine",
	"tools":["TWR","Scanner"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(loopByLineTWRScanner)
loopByLineTCFVerbose = {
	"name":"loopByLineTCFVerbose",
	"objective":"loopByLine",
	"tools":["TCF", "BufferedReader"],
	"level":"beginner",
	"text":"newlines -> \\n, HTML esc."
} #BufferedReader
allReaders.append(loopByLineTCFVerbose)
loopByWordTWR = {
	"name":"loopByWordTWR",
	"objective":"loopByWord",
	"tools":["TWR", "BufferedReader"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(loopByWordTWR)
loopByWordTWRDense = {
	"name":"loopByWordTWRDense",
	"objective":"loopByWord",
	"tools":["TWR","BufferedReader"],
	"level":"advanced",
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(loopByWordTWRDense)
loopByWordTWRScanner = {
	"name":"loopByWordTWRScanner",
	"objective":"loopByWord",
	"tools":["TWR", "Scanner"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(loopByWordTWRScanner)
#listOfLinesTCF = {}
#allReaders.append(listOfLinesTCF)
listOfLinesTWR = {
	"name":"listOfLinesTWR",
	"objective":"listOfLines",
	"tools":["TWR", "BufferedReader", "ArrayList"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(listOfLinesTWR)
listOfLinesTWRDense = {
	"name":"listOfLinesTWRDense",
	"objective":"listOfLines",
	"tools":["TWR", "BufferedReader", "ArrayList"],
	"level":"advanced",
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(listOfLinesTWRDense)
listOfLinesTWRScanner = {
	"name":"listOfLinesTWRScanner",
	"objective":"listOfLines",
	"tools":["TWR", "Scanner", "ArrayList"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(listOfLinesTWRScanner)
listOfLinesTCFVerbose = {
	"name":"listOfLinesTCFVerbose",
	"objective":"listOfLines",
	"tools":["TCF", "BufferedReader", "ArrayList"],
	"level":"beginner",
	"text":"newlines -> \\n, HTML esc."
} #BufferedReader
allReaders.append(listOfLinesTCFVerbose)
listOfLinesDense = {
	"name":"listOfLinesDense",
	"objective":"listOfLines",
	"tools":["TC","java.nio"],
	"level":"advanced",
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(listOfLinesDense)
listOfWordsTWR = {
	"name":"listOfWordsTWR",
	"objective":"listOfWords",
	"tools":["TWR", "BufferedReader", "ArrayList"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(listOfWordsTWR)
listOfWordsTWRScanner = {
	"name":"listOfWordsTWRScanner",
	"objective":"listOfWords",
	"tools":["ArrayList"],
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(listOfWordsTWRScanner)
fileAsOneString = {
	"name":"fileAsOneString",
	"objective":"fileAsOneString",
	"tools":["java.nio"], #beware system dependance
	"difficulty":"advanced",
	"text":"newlines -> \\n, HTML esc."
}
allReaders.append(fileAsOneString)



####################################
## DEMO OF FILTERING BY SELECTION ##
####################################

print "Select one objective from ", objectives
#objective = raw_input("> ") #sublime console does not support keyboard input
objective = "loopByLine"

print "Select forbidden tools (comma-sep) from: ", tools
#forbiddenTools = raw_input("> ").split(",") #sublime console does not support keyboard input
forbiddenTools = "BufferedReader".split(", ")


print "All readers that " + objective + ", do not use ..... ", forbiddenTools
#Collect readers with matching objective
selectedReaders = [r for r in allReaders if r["objective"] == objective]
#Collect readers that DO NOT use forbidden tools
selectedReadersSloppy = []
for r in selectedReaders:
	for ft in forbiddenTools:
		if ft not in r["tools"]:
			selectedReadersSloppy.append(r)
for r in selectedReadersSloppy:
	print r["name"], r["tools"]
