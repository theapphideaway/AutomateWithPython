import shutil
import os

def rename_file(oldFile, newFile):
    try:
        shutil.move(str(oldFile), str(newFile))
        return "Everything Worked!"
    except Exception as e:
        return str(e)

def delete_file(file):
    try:
        os.unlink(str(file))
        return "File Deleted"
    except Exception as e:
        return str(e)
