from django.shortcuts import render

# Create your views here.

sessions = {}


def test(request):
    return render(request, "index.html")
    #return render(request, "cart.html")
    #return render(request, "product-single.html")
    #return render(request, "shop.html") 
    #Prueba de commit





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