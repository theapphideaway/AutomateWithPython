def exception_handling(givenNumber):
    try:
        return givenNumber / 0
    except ZeroDivisionError:
        return "Sorry we can't divide by zero for you. Solve this problem by changing the source code. " \
               "This is meant to be an example of exception handling"

