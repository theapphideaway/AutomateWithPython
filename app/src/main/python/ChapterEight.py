import os

def write_to_file(fos, fileDir,file):
    fos.write("EVERYONE PLEASE".encode())
    fos.close()
    return "Did it work?"

def read_file(fos, fileDir,file):
    fos.read()
    fos.close()
    return "Did it work?"


##Add a function that allows the user to read the contents of the file.