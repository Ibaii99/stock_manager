from django.shortcuts import render, redirect
import datetime
from mysite import settings
import requests
import json


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
        
        headers = {'Content-Type': 'application/json'}
        info={
            "email": request.POST.get('email'),
	        "password": request.POST.get('password')
        }
        
        resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/log_in', json=info)
        #print(resp.json())
        
        save_session(request, request.COOKIES['sessionid'], resp.json()["nombre"], request.POST.get('email'), request.POST.get('password') )
        
        request.session['nombre'] = resp.json()["nombre"]
        request.session['email'] = request.POST.get('email')
        
        
        return redirect("/index/")
        
    return render(request, "login.html")

def shop(request):
    
    print(request.COOKIES)
    
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
        del request.session['email'] 
    
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
def save_session(request, session_id, user_name, email, password):
    global sessions
    
    store= {
            "ip": get_client_ip(request),
            "nombre": user_name,
            "email": email,
            "sessionid": session_id,
            "password": password,
            "fecha_caducidad": datetime.date.today()
    }
    
    sessions[get_client_ip(request)] = store
    
    print(sessions)

def close_session(request):
    global sessions
    
    try:
        
    except:
    
    try:
        sesion = sessions[get_client_ip(request)]
        
        if sesion is None:
            return True
        else:
            del sessions[sessions.index(sesion)]
            return True
    except:
        return False

def is_session_alive(request):
    global sessions
    try:
        sesion = sessions[get_client_ip(request)]
        if sesion is None:
            return False
        else:
            if ((sesion.json()["ip"] == get_client_ip(request)) and ( sesion.json()["nombre"] == request.session['nombre']) and 
                (sesion.json()["email"] == request.session['email']) and ( sesion.json()["sessionid"] == request.COOKIES['sessionid']) and
                (sesion.json()["fecha_caducidad"] >= datetime.date.today())):
                
                return True
            
            return False
    except:
        return False
    
    
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