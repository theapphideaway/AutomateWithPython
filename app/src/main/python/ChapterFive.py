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

board = {'top-L': ' ', 'top-M': ' ', 'top-R': ' ', 'mid-L': ' ', 'mid-M': ' '
    , 'mid-R': ' ', 'low-L': ' ', 'low-M': ' ', 'low-R': ' '}

def tic_tac_toe_board():
    num1 = board['top-L']
    num2 = board['top-M']
    num3 = board['top-R']
    num4 = board['mid-L']
    num5 = board['mid-M']
    num6 = board['mid-R']
    num7 = board['low-L']
    num8 = board['low-M']
    num9 = board['low-R']


    return num1 + '|' + num2 + '|' + num3 +  '\n' + '-+-+-' + '\n' + num4 + '|' + num5 + '|' + num6 + '\n' + '-+-+-' + '\n' + num7 + '|' + num8 + '|' + num9



def play(move,mark):
    for i in range(9):
        board[move] = mark
    return tic_tac_toe_board()