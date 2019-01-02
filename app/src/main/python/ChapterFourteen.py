import requests
import json

def get_weather(location):
    api_key = ''
    if api_key is not '':
        url = "https://api.openweathermap.org/data/2.5/weather?q={}&units=imperial&appid={}".format(location, api_key)
        r = requests.get(url)

        weatherData = json.loads(r.text)
        tempurature = weatherData["main"]["temp"]
        return tempurature
    else:
        return "Make sure you have included your API key"