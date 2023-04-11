import csv

import pytest
import multiprocessing as mp
import logging
import random
import string
from http import HTTPStatus
import time
import httpx
import matplotlib.pyplot as plt
import numpy as np
import plotly.express as px
import time


def create_graph(type_req, count):
    fig, ax = plt.subplots()
    ax.set_facecolor('orange')
    plt.xlabel('Запрос')
    plt.ylabel('Кол-во')

    plt.xticks(rotation=90)

    print(type_req, count)

    plt.bar(type_req, count)
    plt.show()


def read_csv():
    with open('names.csv', newline='') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar='|')
        res = {
            'name': [],
            'count': [],
        }

        for row in spamreader:
            row = row[0].split(',')
            if row:
                res['name'].append(row[0])
                res['count'].append(row[1])

        return res


if __name__ == "__main__":
    with open('names.csv', 'w', newline='') as csvfile:
        fieldnames = ['type', 'count']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)

        writer.writeheader()

    test1 = mp.Process(target=pytest.main, args=(["./tests/cart"],))
    test2 = mp.Process(target=pytest.main, args=(["./tests/product"],))
    test3 = mp.Process(target=pytest.main, args=(["./tests/test_user"],))
    test4 = mp.Process(target=pytest.main, args=(["./tests/order"],))

    test1.start()
    test2.start()
    test3.start()
    test4.start()

    time.sleep(15)

    data = read_csv()
    data_name = data['name'][1:]
    data_count = [int(item) for item in data['count'][1:]]

    create_graph(data_name, data_count)
