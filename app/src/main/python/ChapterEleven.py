import requests
import bs4

def open_web(url):
    try:
        res = requests.get(url)
        text = res.text[:200]
        return text
    except Exception as e:
        return str(e)


def scrape_element(url):
    site = requests.get(url)
    parsedSite = bs4.BeautifulSoup(site.text, features="html.parser")
    pElements = parsedSite.select('p')
    return pElements
