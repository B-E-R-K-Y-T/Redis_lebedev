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
def create_cart(create_user, create_product):
    json = {
        "user": create_user,
        "products": [create_product]
    }
    resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/cart", json=json)
    return resp.json()['id']


@pytest.fixture(scope="function")
def create_user(create_product):
    json = {
        "name": BaseMethods.generate_name(),
        "email": BaseMethods.generate_mail()
    }
    resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/user", json=json)
    return resp.json()['id']


class TestCreateCart(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/cart"

    def test_post(self, create_product, create_user):
        BaseMethods.load_post(url=self.url,
                              json={
                                  "test_user": create_user,
                                  "products": [create_product]
                              },
                              count=100, autotest=f"{__name__}.png", name=TestCreateCart.__name__)


class TestPutCart(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/cart"

    def test_put(self, create_product, create_user, create_cart):
        BaseMethods.load_put(url=self.url + f'/{create_cart}',
                             json={
                                 "user": create_user,
                                 "products": [create_product]
                             },
                             count=1, autotest='', name=TestPutCart.__name__)


class TestDeleteCrat(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/cart"

    def func_create_cart(self, create_user, create_product):
        json = {
            "user": create_user,
            "products": [create_product]
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/cart", json=json)
        return resp.json()['id']

    def test_delete(self, create_cart, create_product, create_user):
        BaseMethods.load_delete(url=self.url,
                                count=100, autotest=f"{__name__}.png", name=TestDeleteCrat.__name__,
                                met=self.func_create_cart, args=(create_user, create_product))


class TestGetCart(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/cart"

    def func_create_cart(self, create_user, create_product):
        json = {
            "user": create_user,
            "products": [create_product]
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/cart", json=json)
        return resp.json()['id']

    def test_get(self, create_user, create_product):
        BaseMethods.load_get(url=self.url,
                             count=100, autotest=f'{__name__}.png', name=TestGetCart.__name__,
                             met=self.func_create_cart, args=(create_user, create_product))

