import csv
import logging
import random
import string
from http import HTTPStatus
import time
import httpx
import matplotlib.pyplot as plt
import numpy as np
import plotly.express as px

COUNTS = []
TYPE_REQ = []

RESULT = {
    'COUNTS': [],
    'TYPE_REQ': []
}
TIMER = 1


def create_graph():
    plt.xlabel('Запрос')
    plt.ylabel('Кол-во')

    plt.bar(TYPE_REQ, COUNTS)
    plt.show()


def request_time(func):
    def wrapper(*args, **kwargs):
        request_times = []
        tic = time.perf_counter()
        count = 0

        while True:
            func(*args, **kwargs)
            toc = time.perf_counter()
            # print(f"Request to {kwargs.get('url')}, spent: {toc - tic:0.4f} seconds")
            request_times.append(toc - tic)
            count += 1

            if toc - tic > TIMER:
                break

        with open('names.csv', 'a', newline='') as csvfile:
            fieldnames = ['type', 'count']
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

            writer.writerow({'type': kwargs.get('name'), 'count': count // TIMER})

    return wrapper


class BaseMethods:
    @staticmethod
    @request_time
    def load_post(count, url, json, autotest, name):
        resp = httpx.post(url=url, json=json)
        print(resp.json())
        assert resp.status_code == HTTPStatus.OK

    @staticmethod
    @request_time
    def load_put(count, url, json, autotest, name):
        resp = httpx.put(url=url, json=json)
        print(resp.json())
        assert resp.status_code == HTTPStatus.OK

    @staticmethod
    @request_time
    def load_get(count, url, name, autotest, met, args: tuple):
        resp = httpx.get(url=url + f'/{met(*args)}')
        print(resp.json())
        assert resp.status_code == HTTPStatus.OK

    @staticmethod
    @request_time
    def load_delete(count, url, name, autotest, met, args: tuple):
        resp = httpx.delete(url=url + f'/{met(*args)}')
        print(resp.json())
        assert resp.status_code == HTTPStatus.OK

    @staticmethod
    def generate_name():
        letters = string.ascii_lowercase
        rand_string = "".join(random.choice(letters) for i in range(20))
        return rand_string

    @staticmethod
    def generate_mail():
        letters = string.ascii_lowercase
        rand_string = "".join(random.choice(letters) for i in range(20))
        rand_string += "@mail.ya"
        return rand_string

    @staticmethod
    def draw_graph():
        create_graph()
