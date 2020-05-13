from django.shortcuts import render, redirect, HttpResponseRedirect
import datetime
from mysite import settings
import requests
import json
import io
import smtplib

from PIL import Image

sessions = {}

def test(request):
    #return render(request, "index.html")
    #return render(request, "cart.html")
    #return render(request, "product-single.html")
    return render(request, "shop.html") 
    #Prueba de commit

def cart(request):
    """Gestiona la visualización del carro, el borrado de articulos, el guardado de las cantidades y la posible redireccion a pagar
    
    Comprueba que la sesion este abierta, de lo contrario 
    redirige al usuario a la pagina de logearse.
    
    Si esta abierta muestra el carrito de la persona y se 
    calculan los precios de todos los articulos y de la cesta 
    en general. Pasandolos como parametro a la plantilla.
    
    Si en la visualizacion del carrito se produce un post,
    se comprueba de que tipo se trata, de eliminar un articulo,
    de guardar el cambio de unidades en la cesta, o de pasar continuar
    al pago.
    
    """
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
    """Gestiona la visualización y gestión del pago.
    
    Comprueba que la sesion este abierta, de lo contrario 
    redirige al usuario a la pagina de logearse.
    
    Calcula el precio del carrito del usuario y muestra el formulario
    para meter todos los datos de la factura y del envio.
    
    """
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
    """Gestiona el pago con tarjeta, visualiza la tarjeta y llama a la api para efectuarla.
    
    Comprueba que la sesion este abierta, de lo contrario 
    redirige al usuario a la pagina de logearse.
    
    No verifica la tarjeta de credito porque esta hecho para
    desarrollo en vez de despliegue.
        
    """
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
    """ Muestra la información del usuario y permite borrar la sesion.    
    
    Comprueba que la sesion este abierta, de lo contrario 
    redirige al usuario a la pagina de logearse.
    
    Si esta logueado muestra su información y si recibe un
    post borra la sesion.    
    
    """
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
    """Gestiona la visualizacion del formulario de registro y se encarga de registrarlo en la api.
    
    Si recibe un post comprueba los datos que recibe 
    para saber si la repeticion de la contraseña coincide
    y si coincide lo registra en la api.
    
    """
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
    """Gestiona la pagina de inicio de sesión y es la encargada de guardar la sesion en la coockie del cliente y en el front-end.
    
    Cuando recibe un post evalua los datos
    para comprobar que coincidan con los del
    usuario y si lo son registra la sesion.
    
    """
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
    """Gestiona la pagina de compra y mostrar articulos.
    
    Comprueba que la sesion este abierta, de lo contrario 
    al intentar añadir un articulo a la cesta no se hará.
    
    """
    if is_session_alive(request):
        global sessions
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
    """Gestiona la vision detallada de los datos de un articulo.
    
    Comprueba que la sesion este abierta, de lo contrario 
    al intentar añadir un articulo a la cesta no se hará.
    
    """
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
    """ Simplemente muestra la pagina de indice de la pagina.
    
    Permite postear comentarios.
    
    """
    
    if (request.method == "POST"):
        send_email("Gracias por su comentario", "Gracias por su comentario, lo hemos recibido, espere a ser contactado por email.", request.POST.get("email"))
        
        cuerpo = "Sugerencia recibida: \n%s \nEmisor: %s" % (request.POST.get("comentario"), request.POST.get("email"))
        send_email("Comentario recibido" ,cuerpo, settings.EMAIL_DESTINY_USER)
    
    
    return render(request, "index.html", {"var": get_vars(request)})

#Devuelve las variables necesarias para la ejecucion generica
def get_vars(request):
    """Devuelve las variables necesarias para la plantilla base.
    
    Comprueba que la sesion este abierta, para 
    obtener los detalles del tamaño del carrito
    y de no estar logueado lo devuelve como json.
        
    """
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
    """Recibe los datos necesarios para guardar la sesion en el front-end.
    
    Guarda:
        ip,
        nombre,
        email,
        id de la sesion,
        contraseña,
    
    La fecha de caducidad se settea al dia siguiente
    y cuando se llegue a ese dia se borrara.
    
    """
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
    """ Borra los datos de la sesion del front-end y de la coockie.   
    
    """
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
    """ Comprueba que la sesion este abierta y que sea valida, si esta caducada la borra.
    
    Devuelve:   True si esta abierta
                False si no lo esta
    """
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
    """ Comprueba que los datos del usuario sean los mismos que los de la api.
    
    """
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
    """Coge la IP del cliente de los metadatos del request.
    
    """
    x_forwarded_for = request.META.get('HTTP_X_FORWARDED_FOR')
    if x_forwarded_for:
        ip = x_forwarded_for.split(',')[0]
    else:
        ip = request.META.get('REMOTE_ADDR')
    return ip

def set_cookie(response, key, value, days_expire = 2):
    """ Metodo para crear coockies personalizadas en el cliente.
        
    """
    if days_expire is None:
        max_age = 365 * 24 * 60 * 60  #one year
    else:
        max_age = days_expire * 24 * 60 * 60 
        expires = datetime.datetime.strftime(datetime.datetime.utcnow() + datetime.timedelta(seconds=max_age), "%a, %d-%b-%Y %H:%M:%S GMT")
        response.set_cookie(key, value, max_age=max_age, expires=expires, domain=settings.SESSION_COOKIE_DOMAIN, secure=settings.SESSION_COOKIE_SECURE or None)
        
def erro_handler(request, exception=None):
    """ Redirige a la pagina de inicio si ocurre cualquier error.
    
    """
    # make a redirect to homepage
    # you can use the name of url or just the plain link
    return redirect('/index/') # or redirect('name-of-index-url')


def send_email(subject ,text, to):
    """Metodo para envío de emails a traves de gmail.
    
    Recibe: 
        Motivo del email,
        Cuerpo del email,
        y el destino
    
    """
    try:
        server = smtplib.SMTP(settings.EMAIL_HOST, settings.EMAIL_PORT)
        server.ehlo()
        server.starttls()
        server.ehlo()
        server.login(settings.EMAIL_HOST_USER, settings.EMAIL_HOST_PASSWORD)
        message = 'Subject: {}\n\n{}'.format(subject, text)
        server.sendmail(settings.EMAIL_HOST_USER, to, message)
        print("Email enviado")
        server.quit()

    except:
        print('Something went wrong...')