import openpyxl

def get_spreadsheet(file):
    spreadsheetList = []
    wb = openpyxl.load_workbook(file)
    sheet = wb['Sheet1']
    for i in range(1, 8):
        colOne = str(sheet.cell(row=i, column=1).value)
        colTwo = str(sheet.cell(row=i, column=2).value)
        colThree = str(sheet.cell(row=i, column=3).value)
        spreadsheetList.append(str(colOne +  " " + colTwo + " " + colThree ) )

    finalList = '\n'.join(spreadsheetList)
    return finalList
