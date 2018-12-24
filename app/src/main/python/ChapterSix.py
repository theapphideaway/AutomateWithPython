word = "Hello World"

def in_fun():
    return 'Hello' in 'Hello World'

def string_index():
    index = word[4]
    return index

def call_upper():
    capped = word.upper()
    return capped

def call_starts():
    start = word.startswith('He')
    return start

def call_center():
    center = word.center(20,"=")
    return center