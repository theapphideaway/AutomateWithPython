def get_int():
    return 123

def get_float():
    return 1.1

def get_string():
    return "Hello World"

def get_concat():
    a = "This "
    b = "is "
    c = "an "
    d = "example "
    e ="of "
    f = "string "
    g = "concatenation "
    h = "and "
    i = "variables."
    return a+b+c+d+e+f+g+h+i

def get_name_question():
    return "What is your name?"

def get_name(name):
    return "It is good to meet you, " + name

def get_name_length(name):
    return "The length of your name is: " + str(len(name))

def get_age_question():
    return "What is your age?"

def get_age(age):
    return "You will be " + str(int(age) + 1) + " in a year."

