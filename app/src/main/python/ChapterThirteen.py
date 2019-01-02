import PyPDF2

def create_word_file(file):
    try:
        pdfFileObj = open(file, 'rb')
        pdfReader = PyPDF2.PdfFileReader(pdfFileObj)
        return pdfReader.numPages
    except Exception as e:
        return str(e)



