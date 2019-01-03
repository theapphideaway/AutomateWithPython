import time

def timer(seconds):
    finalSeconds = int(seconds)
    while finalSeconds > 0:
        time.sleep(1)
        finalSeconds = finalSeconds - 1

    return "Times up!"



