from django.shortcuts import render
import datetime
from mysite import settings
import requests

# Create your views here.

sessions = {}


def test(request):
    #return render(request, "index.html")
    #return render(request, "cart.html")
    #return render(request, "product-single.html")
    return render(request, "shop.html") 
    #Prueba de commit

def user(request):
    if(request.method == 'POST'):
        None
    return render(request, "profile.html")

    
def register(request):
    if(request.method == 'POST'):
        None
    return render(request, "register.html")

def login(request):
    if(request.method == 'POST'):
        email = request.POST.get('email')
        password = request.POST.get('password')
        
        headers = {'Content-Type': 'application/json'}
        info={}
        resp = requests.post('http://'+settings.STOCK_MANAGER_API_URL +'/',json=info, headers=headers)
    return render(request, "login.html")

def shop(request):
    
    print(request.COOKIES)
    request.session['nombre'] = "Ibai"
    request.session['pass'] = "pass"
    
    for key, value in request.session.items():
        print('{} => {}'.format(key, value))
        
    return render(request, "shop.html")

def index(request):
    
    
    
    print(request.COOKIES)
    print(request.session)
    for key, value in request.session.items():
        print('{} => {}'.format(key, value))
        
    if 'nombre' in request.session:
        del request.session['nombre']
        del request.session['pass'] 
    
    for key, value in request.session.items():
        print('{} => {}'.format(key, value))

    print(request.COOKIES)
    
    # print("Cookies")
    # print(request.COOKIES)
    
    # print("Meta")
    # print(request.META)
    
    response = render(request, "index.html")
    
    return response

def get_vars(request):
    None

#Guardara el valor de la ip y la sesion
def save_session(request, session_id):
    global sessions
    sessions[get_client_ip(request)] = session_id


#Para conseguir la ip de un usuario y obtener asi el id de la sesion
def get_client_ip(request):
    x_forwarded_for = request.META.get('HTTP_X_FORWARDED_FOR')
    if x_forwarded_for:
        ip = x_forwarded_for.split(',')[0]
    else:
        ip = request.META.get('REMOTE_ADDR')
    return ip

def set_cookie(response, key, value, days_expire = 2):
    if days_expire is None:
        max_age = 365 * 24 * 60 * 60  #one year
    else:
        max_age = days_expire * 24 * 60 * 60 
        expires = datetime.datetime.strftime(datetime.datetime.utcnow() + datetime.timedelta(seconds=max_age), "%a, %d-%b-%Y %H:%M:%S GMT")
        response.set_cookie(key, value, max_age=max_age, expires=expires, domain=settings.SESSION_COOKIE_DOMAIN, secure=settings.SESSION_COOKIE_SECURE or None)