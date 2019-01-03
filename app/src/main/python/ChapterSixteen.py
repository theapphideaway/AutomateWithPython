import smtplib

def send_email(username, password, recipient, subject, content):
    try:
        smtpObj = smtplib.SMTP('smtp.gmail.com', '587')
        smtpObj.ehlo()
        smtpObj.starttls()
        smtpObj.login(username, password)
        smtpObj.sendmail(username, recipient, 'Subject: {subject}\n{content}'.format(subject = subject, content = content))
        return "Email Sent"
    except Exception as e:
        return str(e + ". Make sure less secure app access is turned on.")