# Medical Entry Protocol (MEP) [UNDER CONSTRUCTION]


## About

Medical Entry Protocol (MEP) is an abstract definition of architecture for data intended for physicians and health-care workers. The goal is to attain some form of consistency such that medical entry becomes a rather unified matter. Data infrastructures indeed exist but as of now these formats mostly serve the bureaucratic process rather than the field of medicine.
// -- under construciton -- //

* MEP aims to provide
  * Single format, viewable by every physician __identically__.
  * Universal way to create, view, transfer and archive medical treatment records/ information.
  * Easily parsible information with simple database schema.
  * Format is completely open-source and code available for inspection.
  * Ability to function without __any internet access__: Internet is __never__ used, hence solving the issue of _privacy_ and _accessibility_ for the most part.

:warning: __Please note that the MEP data format is SEPARATE from the client GUI application that implements it for the end-user; and as such, although the data format is completely independent of machine constraints and can be easily implemented, the client program might not always benefit from the same guarantee__.

## The MEP Data Infrastructure
// -- will be updated -- //

## Licensing

This has to be sorted out carefully.
For now, the project plans to use these utilities:

1. OpenJDK (Java 18.0.2)
2. Tesseract OCR (Optical character recognition)
3. FreeTTS (Text-to-speech & speech-to-text capabilities)
4. CMU-Sphinx (Text-to-speech & speech-to-text capabilities)
5. PDFBox (Document formatting, generation & management)
6. Derby (Relational database interfacing)

## Current issues in MEP __Client GUI Program__ (Not the actual data format)

* Utilities that were chosen to implement text-to-speech & speech-to-text capabilities might pose compatibility issues with Java 18.
  * It would be best to avoid too many JNI calls - the more pure Java, the more portability. The JVM provides some degree of independence. If this is not possible to maintain, then it would be more convenient to implement these capabilities in C++ or plain C.
