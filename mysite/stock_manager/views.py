from django.shortcuts import render, redirect
import datetime
from mysite import settings
import requests
import json
import io

# Create your views here.

sessions = {}


def test(request):
    #return render(request, "index.html")
    #return render(request, "cart.html")
    #return render(request, "product-single.html")
    return render(request, "shop.html") 
    #Prueba de commit

def user(request):
    if is_session_alive(request):
        sesion = sessions.get(request.COOKIES['sessionid'])
        info={
            "email": sesion.get("email"),
	        "password": sesion.get('password')
        }
        resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/get_cliente', json=info)
        
        # resp.json()["contrasenya_cliente"]
        
        if(request.method == 'POST'):
            if(request.POST.get("button_logout") is not None):
                close_session(request)
                return redirect("/index/")
            #TODO el cambio de datos hay que gestionarlo 
        return render(request, "profile.html", {"var": get_vars(request), "address": resp.json()["direccion_cliente"], "email": resp.json()["email_cliente"], "name":resp.json()["nombre_cliente"]})
    
    return redirect("/user/login")
    
def register(request):
    if(request.method == 'POST'):
        if( request.POST.get('password_1') == request.POST.get('password_2')):
            
            info = {
                "name": request.POST.get('name'),
                "email": request.POST.get('email'),
                "password": request.POST.get('password_1'),
                "address": request.POST.get('address')
            }
            
            resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/register', json=info)
            save_session(request, request.COOKIES['sessionid'], resp.json()["nombre"], request.POST.get('email'), request.POST.get('password_1') )
        
            request.session['nombre'] = resp.json()["nombre"]
            request.session['email'] = request.POST.get('email')
            
            return redirect("/index/")
            
        else:
            return render(request, "register.html", {"var": get_vars(request), "message": "Error: La contraseña ha coincidir."})
    return render(request, "register.html", {"var": get_vars(request)})

def login(request):
    if(request.method == 'POST'):
        
        info={
            "email": request.POST.get('email'),
	        "password": request.POST.get('password')
        }
        
        resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/log_in', json=info)
        
        save_session(request, request.COOKIES['sessionid'], resp.json()["nombre"], request.POST.get('email'), request.POST.get('password') )
        
        request.session['nombre'] = resp.json()["nombre"]
        request.session['email'] = request.POST.get('email')
        
        
        return redirect("/index/")
        
    return render(request, "login.html", {"var": get_vars(request)})

def shop(request):
    """
    
    {
        "caducidad": "2021-04-20T22:00:00Z[UTC]",
        "categoria": "VERDURAS",
        "descripcion": "rico pimiento",
        "id": 6,
        "nombre": "lechuga",
        "oferta": 0.95,
        "precio": 1.2,
        "stock": 400
    }
    
    """
    print(request.COOKIES)
    
    for key, value in request.session.items():
        print('{} => {}'.format(key, value))
        
    return render(request, "shop.html", {"var": get_vars(request)})

def index(request): 
    
    return render(request, "index.html", {"var": get_vars(request)})

#Devuelve las variables necesarias para la ejecucion generica
def get_vars(request):
    global sessions
    
    if is_session_alive(request):
        if is_data_correct(request):
            session = sessions.get(request.COOKIES['sessionid'])
            
            var = {
                    "is_logged": True,
                    "name": session.get("nombre"),
                    "cart": 2,
                    "favourites": 1,
            }
            
            return var
    
    var = {
            "is_logged": False,
    }
    
    return var

#Guardara el valor de la ip la informaci'on necesaria
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
    
    sessions[request.COOKIES['sessionid']] = store
    
    print(sessions)

#Borra los datos de la sesion
def close_session(request):
    global sessions
    try:
        sesion = sessions[request.COOKIES['sessionid']]
        if sesion is None:
            print("sesion does not exist")
        else:
            del sessions[request.COOKIES['sessionid']]
            del sesion
    except:
        print("No information on server")
    try:
        del request.COOKIES['sessionid']
        del request.session['email']
        del request.session['nombre']
    except:
        print("No information on client")
        
#Comprueba que la sesion de la cookie siga activa
def is_session_alive(request):
    global sessions
    try:
        sesion = sessions.get(request.COOKIES['sessionid'])
        if sesion is None:
            return False
        else:
            if ((sesion.get("ip") == get_client_ip(request)) and ( sesion.get("nombre") == request.session['nombre']) and 
                (sesion.get("email") == request.session['email']) and ( sesion.get("sessionid") == request.COOKIES['sessionid'])):
                if(sesion.get("fecha_caducidad") >= datetime.date.today()):
                    return True
                else:
                    close_session(request)
            return False
    except:
        return False

#Compruba que los datos metidos sigan siendo los correctos
def is_data_correct(request):
    global sessions
    sesion = sessions.get(request.COOKIES['sessionid'])
    info={
            "email": sesion.get("email"),
	        "password": sesion.get('password')
        }
    
    resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/log_in', json=info)
    
    if  resp.json()["nombre"] is not None and resp.json()["nombre"] != 'null':
        return True
    
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