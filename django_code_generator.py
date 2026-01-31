import os

class DjangoCodeGenerator:
    def __init__(self):
        self.models_code = []
        self.views_code = []
        self.urls_code = []
        self.admin_code = []
        self.serializers_code = []
        
        self.registered_models = []

    def generate(self, root_node):
        """
        Start point for creating the code from AST.
        """
        self._reset_buffers()
        self._init_imports()

        self._traverse(root_node)

        self.urls_code.append("]")

        # Register models in admin
        for model in self.registered_models:
            self.admin_code.append(f"admin.site.register({model})")

        return {
            "models.py": "\n".join(self.models_code),
            "views.py": "\n\n".join(self.views_code),
            "urls.py": "\n".join(self.urls_code),
            "admin.py": "\n".join(self.admin_code),
            "__init__.py": "" 
        }

    def _reset_buffers(self):
        self.models_code = []
        self.views_code = []
        self.urls_code = []
        self.admin_code = []
        self.registered_models = []

    def _init_imports(self):
        # --- Models Imports ---
        self.models_code.append("from django.db import models")
        self.models_code.append("from django.core.validators import MinValueValidator, MaxValueValidator, RegexValidator")
        self.models_code.append("from django.core.exceptions import ValidationError")
        self.models_code.append("from django.utils.translation import gettext_lazy as _")
        self.models_code.append("\n# Generated Models")

        # --- Views Imports ---
        self.views_code.append("import json")
        self.views_code.append("from django.http import JsonResponse, HttpResponse, HttpResponseBadRequest")
        self.views_code.append("from django.views.decorators.csrf import csrf_exempt")
        self.views_code.append("from django.db.models import Q, Count, Sum, Avg")
        self.views_code.append("from .models import *")
        
        # --- URLs Imports ---
        self.urls_code.append("from django.urls import path")
        self.urls_code.append("from . import views")
        self.urls_code.append("\nurlpatterns = [")

        # --- Admin Imports ---
        self.admin_code.append("from django.contrib import admin")
        self.admin_code.append("from .models import *")

    def _traverse(self, node):
        if not hasattr(node, 'value'): return

        node_type = node.value.get('type')
        
        if node_type == "start-program":
            for child in node.children:
                self._traverse(child)
                
        elif node_type == "model":
            self._handle_model(node)
            
        elif node_type == "enum":
            self._handle_enum(node)
            
        elif node_type == "endpoint":
            self._handle_endpoint(node)