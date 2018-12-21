def exception_handling(givenNumber):
    try:
        return givenNumber / 0
    except ZeroDivisionError:
        return "Sorry we can't divide by zero for you"

