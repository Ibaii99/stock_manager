from django.shortcuts import render, redirect, HttpResponseRedirect
import datetime
from mysite import settings
import requests
import json
import io
from PIL import Image

sessions = {}

def test(request):
    #return render(request, "index.html")
    #return render(request, "cart.html")
    #return render(request, "product-single.html")
    return render(request, "shop.html") 
    #Prueba de commit



def cart(request):
    if is_session_alive(request):
        global sessions
        sesion = sessions.get(request.COOKIES['sessionid'])
        info={
            "email": sesion.get("email"),
            "password": sesion.get('password')
        }
        
        resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/getCarrito', json=info)

        cesta = json.loads(resp.text)

        if request.method == "POST":
            if(request.POST.get("borrar") is None):
                print("--------------------")
                for key, value in request.POST.items():
                    if(key != "Guardar" and key != "Pagar" and key != "csrfmiddlewaretoken"): 
                        print(key, value)
                        z = {
                            "id_articulo": key,
                            "email": sesion.get("email"),
                            "password": sesion.get('password'),
                            "cantidad": value
                        }
                        
                        requests.post(settings.STOCK_MANAGER_API_URL +'/api/modifyCarrito', json=z)

                print("--------------------")
                    
                if( request.POST.get("Pagar") is not None and request.POST.get("Guardar") is None ):
                    return redirect("/user/cart/checkout")
            else:
                z = {
                    "id_articulo": request.POST.get("borrar"),
                    "email": sesion.get("email"),
                    "password": sesion.get('password')
                }
                
                resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/removeCarrito', json=z)
            
            resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/getCarrito', json=info)
            cesta = json.loads(resp.text)
        
        e=0
        preciototal = 0
        while (e < len(cesta.get("articulos"))):
            cesta.get("articulos")[e]["cantidad"] = cesta.get("cantidades")[e]
            
            cesta.get("articulos")[e]["precio_articulo"] =  int(cesta.get("cantidades")[e]) * float(cesta.get("articulos")[e]["oferta"])
            preciototal +=  int(cesta.get("cantidades")[e]) * cesta.get("articulos")[e]["oferta"]
            e+=1

        cesta["precio_total"] = preciototal
        return render(request, "cart.html", {"var": get_vars(request), "cesta": cesta} ) 
    
    return redirect("/user/login")

def favourites(request):
    None 
    
def pay(request):
    if is_session_alive(request):
        global sessions
        sesion = sessions.get(request.COOKIES['sessionid'])
        info={
            "email": sesion.get("email"),
            "password": sesion.get('password')
        }
        
        if request.method == "POST":
            for key, value in request.POST.items():
                if(key != "Guardar" and key != "Pagar" and key != "csrfmiddlewaretoken"): 
                    print(key, value)

                requests.post(settings.STOCK_MANAGER_API_URL +'/api/carritoToPedido', json=info)
                
            #Por ahora no vamos a hacer nada con los datos de pago vaciarCarrito
            
            return redirect("/index")
            
        return render(request, "payment.html", {"var": get_vars(request)})   
    
    return redirect("/user/login") 

def checkout(request):
    
    if is_session_alive(request):
        #carritoPrecio
        global sessions
        sesion = sessions.get(request.COOKIES['sessionid'])
        info={
            "email": sesion.get("email"),
            "password": sesion.get('password')
        }
        
        if request.method == "POST":
            return redirect("/user/cart/payment")
            
        resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/carritoPrecio', json=info)
        
        return render(request, "checkout.html", {"var": get_vars(request), "total": resp.json()["precio"]})
      
    return redirect("/user/login") 

def user(request):
    if is_session_alive(request):
        global sessions
        sesion = sessions.get(request.COOKIES['sessionid'])
        info={
            "email": sesion.get("email"),
	        "password": sesion.get('password')
        }
        resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/getCliente', json=info)
        
        # resp.json()["contrasenya_cliente"]
        
        if(request.method == 'POST'):
            if(request.POST.get("button_logout") is not None):
                close_session(request)
                return redirect("/index/")
            #TODO el cambio de datos hay que gestionarlo 
        return render(request, "profile.html", {"var": get_vars(request), "address": resp.json()["direccionCliente"], "email": resp.json()["emailCliente"], "name":resp.json()["nombreCliente"]})
     
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
            
            pagina = redirect("/index/")
            try:
                session_id = request.COOKIES['sessionid']
            
            except:
                request.session.create()
                session_id = request.session.session_key
                set_cookie(pagina, "sessionid", session_id)
            
            request.session['nombre'] = resp.json()["nombre"]
            request.session['email'] = request.POST.get('email')
            
            save_session(request, session_id, resp.json()["nombre"], request.POST.get('email'), request.POST.get('password_1') )
        
            
            
            return pagina 
            
        else:
            return render(request, "register.html", {"var": get_vars(request), "message": "Error: La contraseña ha coincidir."})
    return render(request, "register.html", {"var": get_vars(request)})

def login(request):
    if(request.method == 'POST'):
        
        info={
            "email": request.POST.get('email'),
	        "password": request.POST.get('password')
        }
        
        pagina = redirect("/index/")
        try:
            session_id = request.COOKIES['sessionid']
            
        except:
            request.session.create()
            session_id = request.session.session_key
            set_cookie(pagina, "sessionid", session_id)
        
        resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/logIn', json=info)
        
        request.session['nombre'] = resp.json()["nombre"]
        request.session['email'] = request.POST.get('email')
        
        
        save_session(request, session_id , resp.json()["nombre"], request.POST.get('email'), request.POST.get('password') )
        
        return pagina
        
    return render(request, "login.html", {"var": get_vars(request)})

def shop(request):
    if is_session_alive(request):
        sesion = sessions.get(request.COOKIES['sessionid'])
        
        if request.method == "POST":
            print( request.POST.get("anyadir"))
            z = {
                "id_articulo": request.POST.get("anyadir"),
                "email": sesion.get("email"),
                "password": sesion.get('password'),
                "cantidad": "1"
            }

            resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/addCarrito', json=z)
    
    resp = requests.get(settings.STOCK_MANAGER_API_URL +'/api/getArticulos')
    articulos = json.loads(resp.text)
    return render(request, "shop.html", {"var": get_vars(request), "articulos": articulos })

def article(request, id):
    if request.method == "POST":
        if is_session_alive(request):
            global sessions
            sesion = sessions[request.COOKIES['sessionid']]
            if (request.POST.get("boton") == "Añadir al carrito") and ( int(request.POST.get("cantidad")) > 0):
                json = {
                    "id_articulo": id,
                    "password": sesion.get("password"),
                    "email": sesion.get("email"),
                    "cantidad": request.POST.get("cantidad")
                }
                resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/addCarrito', json=json)
                
            elif request.POST.get("boton") == "Añadir a favoritos":
                json = {
                    "id_articulo": id,
                    "password": sesion.get("password"),
                    "email": sesion.get("email"),
                }
                resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/addFavoritos', json=json)
    info={
            "ID": id,
        }
    resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/getArticulo', json=info)
        
    return render(request, "product-single.html", {"var": get_vars(request), "article": resp.json()})
    
def index(request): 
    return render(request, "index.html", {"var": get_vars(request)})

#Devuelve las variables necesarias para la ejecucion generica
def get_vars(request):
    global sessions
    
    if is_session_alive(request):
        if is_data_correct(request):
            session = sessions.get(request.COOKIES['sessionid'])
            b = {
                "password": session.get("password"),
                "email": session.get("email"),
            }
            resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/tamanyoCarrito', json=b)
            
            var = {
                    "is_logged": True,
                    "name": session.get("nombre"),
                    "cart": resp.json()["tamanyo"],
                    "favourites": 0,
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
    
    sessions[session_id] = store
    
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
    
    resp = requests.post(settings.STOCK_MANAGER_API_URL +'/api/logIn', json=info)
    
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
        
def erro_handler(request, exception=None):
    # make a redirect to homepage
    # you can use the name of url or just the plain link
    return redirect('/index/') # or redirect('name-of-index-url')