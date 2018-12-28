import re



def email_search(searchText):
    emailRegrex = re.compile(r'''(
    [a-zA-Z0-9._%+-]+
    @
    [a-zA-Z0-9.-]+
    (\.[a-zA-Z]{2,4})
    )''', re.VERBOSE)

    #results =


def phone_search(text):
    phoneNumRegex = re.compile(r'''(
    (\d{3}|\(\d{3}\))?
    (\s|-|\.)?
    (\d{3})
    (\s|-|\.)
    (\d{4})
    (\s*(ext|x|ext.)\s*(\d{2,5}))?
    )''', re.VERBOSE)
    mo = phoneNumRegex.findall(text)

    matches = []

    for groups in mo:
        phoneNum = '-'.join([groups[1], groups[3], groups[5]])
        if groups[8] != '':
            phoneNum += ' x' + groups[8]

        phoneNum += "\n"

        matches.append(phoneNum)
    matches = '\n'.join(matches)


    return matches

#My number is 415-555-4242