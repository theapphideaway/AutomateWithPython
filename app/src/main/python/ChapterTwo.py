def get_age(age):
    if 0 < age < 12:
        return "You're a child."
    elif 12 < age < 20:
        return "You're a teenager."
    elif 20 < age < 65:
        return "You're an adult"
    elif 65 < age < 150:
        return "You're elderly"
    else:
        return "You're either dead or immortal"

def print_name(name,age):
    myWhileList = []
    spam = 0
    while spam < age:
        myWhileList.append(name)
        spam = spam + 1
    return myWhileList

def print_name_for(name, age):
    myForList = []
    for i in range(age):
        myForList.append(name)

    return myForList

