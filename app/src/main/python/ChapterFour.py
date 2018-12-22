animals =["cat", "bat", "rat", "elephant"]

def my_list():
    return animals

def item_at_index(index):
    try:
        return animals[index]
    except IndexError:
        return "Index is out of range, try again"

def delete_at_index(index):
    try:
        del animals[index]
        return animals
    except IndexError:
        return "Index is out of range, try again"

def is_in_list(item):
    return item in animals

def add_item(item):
    if item in animals:
        return
    else:
        animals.append(item)
        return animals





