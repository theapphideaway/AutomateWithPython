import os

def write_to_file(fos,content):
    fos.write(content.encode())
    fos.close()
    return "Did it work?"

def read_file( textFile):
    try:
        file = open(str(textFile))
        text = file.readlines()
        return text
    except Exception as e:
        return str(e)

