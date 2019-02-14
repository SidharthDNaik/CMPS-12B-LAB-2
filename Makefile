#-----------------------------------------------------------------------------
# Name: Sidharth Naik ID: 1647945 Class: 12B/M Date: January 25,2018
# Description: Compiles the javafiles File Name: Makefile
# -----------------------------------------------------------------------------

JAVASRC	= FileReverse.java
SOURCES	= README Makefile $(JAVASRC)
MAINCLASS	= FileReverse
CLASSES = FileReverse.class
JARFILE = FileReverse
SUBMIT = submit cmps012b-pt.w19 lab2

all: $(JARFILE)

$(JARFILE) : $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)
#The lines above check if the Class files exist and are up to date and constructs them

$(CLASSES): $(JAVASRC)
		javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)
#Gets rid of all the previously compiled stuff

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)

check:
	ls  /afs/cats.ucsc.edu/class/cmps012b-pt.w19/lab2/sidnaik
