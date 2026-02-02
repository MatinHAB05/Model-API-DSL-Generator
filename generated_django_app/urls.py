from django.urls import path
from . import views

urlpatterns = [
    path('users/first', views.union_user, name='union_user'),
]