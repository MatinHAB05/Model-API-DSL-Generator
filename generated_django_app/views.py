import json

from django.http import JsonResponse, HttpResponse, HttpResponseBadRequest

from django.views.decorators.csrf import csrf_exempt

from django.db.models import Q, Count, Sum, Avg

from .models import *