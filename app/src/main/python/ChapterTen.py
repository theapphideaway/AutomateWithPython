import random
guess = ''
def coin_toss(guess):
    while guess not in ('heads', 'tails'):
        print('Guess the coin toss! Enter heads or tails:')
    toss = random.randint(0, 1) # 0 is tails, 1 is heads
    if toss == guess:
        return'You got it!'
    else:
        return 'Nope! Guess again!'
        if toss == guess:
            print('You got it!')
        else:
            print('Nope. You are really bad at this game.')


## can you solve the errors? 
## HINT delete lines 11 - 14