birthdays = {'Alice': 'April 1', 'Bob': 'Dec 12', 'Carol': 'Mar 4'}
def my_dictionary():
    return birthdays

def get_birthdays(name):
    if name in birthdays:
        return birthdays[name] + ' is the birthday of ' + name
    else:
        return "Birthday information not found. Would you like to add it?"

def add_birthday(name, date):
    birthdays[name] = date
    return birthdays
