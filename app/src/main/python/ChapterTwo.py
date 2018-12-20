def get_age(age):
    if age > 0 and age < 12:
        return "You're a child."
    elif age > 12 and age < 20:
        return "You're a teenager."
    elif age > 20 and age < 65:
        return "You're an adult"
    elif age > 65 and age < 150:
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

