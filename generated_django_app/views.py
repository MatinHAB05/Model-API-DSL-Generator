import json

from django.http import JsonResponse, HttpResponse, HttpResponseBadRequest

from django.views.decorators.csrf import csrf_exempt

from django.db.models import Q, Count, Sum, Avg

from .models import *

@csrf_exempt

def sort_user(request, x, y, z):

    if request.method != 'GET':

        return JsonResponse({'error': 'Method not allowed'}, status=405)

    # Relational Logic

    r_1 = User.filter(name="alibaba", age__gt=((18 * x) - (y / z)))