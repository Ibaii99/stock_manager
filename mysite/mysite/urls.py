"""mysite URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from django.contrib.staticfiles.urls import staticfiles_urlpatterns
from django.conf import settings
import stock_manager.views as views
from django.conf.urls.static import static

urlpatterns = [
    path('admin/', admin.site.urls),
    path('test/', views.test),
    path('index/', views.index),
    path('shop/', views.shop),
    path('user/', views.user),
    path('user/login/', views.login),
    path('user/register/', views.register),
    path('user/cart/', views.cart),
    path('user/cart/checkout', views.checkout),
    path('user/cart/payment', views.pay),
    path('user/favourites/', views.favourites),
    path('article/<int:id>', views.article),
    path('', views.index),
]

handler404 = 'stock_manager.views.erro_handler'
handler500 = 'stock_manager.views.erro_handler'

urlpatterns += staticfiles_urlpatterns()
urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)