from django.db import models
from django.core.validators import MinValueValidator, MaxValueValidator, RegexValidator
from django.core.exceptions import ValidationError
from django.utils.translation import gettext_lazy as _
import datetime , time

# Generated Models

class Role(models.TextChoices):
    ADMIN = 'ADMIN', 'ADMIN'
    USER = 'USER', 'USER'
    GUEST = 'GUEST', 'GUEST'
    MANAGER = 'MANAGER', 'MANAGER'

class Person(models.Model):
    username = models.CharField(max_length=255, primary_key=True, null=False, blank=False, unique=True, validators=[RegexValidator(regex=r'...', message='Invalid format')])
    age = models.IntegerField(null=True, blank=True, validators=[MinValueValidator(8), MaxValueValidator(14)])
    role = models.CharField(max_length=50, choices=Role.choices, null=False, blank=False)
    second_role = models.CharField(max_length=50, choices=Role.choices, null=False, blank=False)
    bth = models.DateField(validators=[MinValueValidator(datetime.date.fromisoformat('2020-01-01')), MaxValueValidator(datetime.date.fromisoformat('2024-06-11'))])

    def __str__(self):
        return f'Person object ({self.pk})'

    def clean(self):
        super().clean()
        val_role = getattr(self, 'role', None)
        if val_role is not None:
            if val_role in ['ADMIN']:
                raise ValidationError({ 'role': "Value cannot be: 'ADMIN'" })
        val_second_role = getattr(self, 'second_role', None)
        if val_second_role is not None:
            if val_second_role not in ['MANAGER', 'USER']:
                raise ValidationError({ 'second_role': "Value must be one of: 'MANAGER', 'USER'" })

    def save(self, *args, **kwargs):
        self.full_clean()
        super().save(*args, **kwargs)

class Attendance(models.Model):
    username = models.ForeignKey('Person', max_length=255, primary_key=True, on_delete=models.CASCADE)
    entryTime = models.TimeField(validators=[MinValueValidator(time(0,0)), MaxValueValidator(time(12,0))])

    def __str__(self):
        return f'Attendance object ({self.pk})'

class Phone(models.Model):
    id = models.ForeignKey('Person', max_length=255, primary_key=True, on_delete=models.CASCADE)
    phone = models.CharField(max_length=255, primary_key=True, unique=True, validators=[RegexValidator(regex=r'...', message='Invalid format')])

    def __str__(self):
        return f'Phone object ({self.pk})'