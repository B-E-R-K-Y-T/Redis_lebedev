import httpx
import pytest

from tests.helper.base_methods import BaseMethods
from tests.config import PORT


@pytest.fixture(scope="function")
def create_product():
    json = {
        "name": "Пылесос на колесиках",
        "description": "Сосет пыль и катается на колесиках",
        "price": 10000,
        "imageUrl": "https://my.images.hosting/image.jpg"
    }
    resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/product", json=json)
    return resp.json()['id']


@pytest.fixture(scope="function")
def create_user(create_product):
    json = {
        "name": BaseMethods.generate_name(),
        "email": BaseMethods.generate_mail()
    }
    resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/user", json=json)
    return resp.json()['id']


@pytest.fixture(scope="function")
def create_order(create_user, create_product):
    json = {
        "user": create_user,
        "totalPrice": 10000,
        "products": [create_product]
    }
    resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/order", json=json)
    return resp.json()['id']


class TestCreateOrder(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/order"

    def test_post(self, create_product, create_user):
        BaseMethods.load_post(url=self.url,
                              json={
                                  "test_user": create_user,
                                  "total_price": "10000",
                                  "products": [create_product]
                              },
                              count=100, autotest=f"{__name__}.png", name=TestCreateOrder.__name__)


class TestPutOrder(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/order"

    def test_put(self, create_product, create_user, create_order):
        BaseMethods.load_put(url=self.url + f'/{create_order}',
                             json={
                                 "user": create_user,
                                 "totalPrice": 100000,
                                 "products": [create_product]
                             },
                             count=100, autotest=f"{__name__}.png", name=TestPutOrder.__name__)


class TestDeleteOrder(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/order"

    def func_create_order(self, create_user, create_product):
        json = {
            "user": create_user,
            "totalPrice": 10000,
            "products": [create_product]
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/order", json=json)
        return resp.json()['id']

    def test_delete(self, create_order, create_product, create_user):
        BaseMethods.load_delete(url=self.url,
                                count=100, autotest=f"{__name__}.png", name=TestDeleteOrder.__name__,
                                met=self.func_create_order, args=(create_user, create_product))


class TestGetOrder(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/order"

    def func_create_order(self, create_user, create_product):
        json = {
            "user": create_user,
            "totalPrice": 10000,
            "products": [create_product]
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/order", json=json)
        return resp.json()['id']

    def test_get(self, create_user, create_product):
        BaseMethods.load_get(url=self.url,
                             count=100, autotest=f'{__name__}.png', name=TestGetOrder.__name__,
                             met=self.func_create_order, args=(create_user, create_product))
