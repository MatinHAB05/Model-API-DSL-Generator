from django.urls import path
from . import views

urlpatterns = [
    path('users/first/<str:x>-<str:y>-<str:z>', views.sort_user, name='sort_user'),
]