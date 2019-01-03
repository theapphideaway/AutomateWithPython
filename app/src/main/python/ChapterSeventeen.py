from PIL import Image

def add_logo(filename, logo):
    try:
        logo = Image.open(logo, 'r')
        logo_w, logo_h = logo.size
        newLogo = logo.resize((int(logo_w / 6), int(logo_h / 6)))
        newLogo_w, newLogo_h = newLogo.size
        background = Image.open(filename)
        bg_w, bg_h = background.size
        background.paste(newLogo, (bg_w - newLogo_w, bg_h - newLogo_h),newLogo)
        background.save(filename)
        return "Hey I think it worked"
    except Exception as e:
        return str(e)