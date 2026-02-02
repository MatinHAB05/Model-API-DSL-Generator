import json

from django.http import JsonResponse, HttpResponse, HttpResponseBadRequest

from django.views.decorators.csrf import csrf_exempt

from django.db.models import Q, Count, Sum, Avg

from .models import *

@csrf_exempt

def union_user(request):

    if request.method != 'GET':

        return JsonResponse({'error': 'Method not allowed'}, status=405)

    # Relational Logic

    this_is_test = User.filter(name="alibaba", age__gt=18).values('name', 'lastname').filter()

    res_1 = this_is_test

    final_result = res_1

    if hasattr(final_result, 'values'):

        final_result = list(final_result.values())

    elif hasattr(final_result, '_meta'):

        final_result = {k: v for k, v in final_result.__dict__.items() if not k.startswith('_')}

    return JsonResponse(final_result, safe=False)