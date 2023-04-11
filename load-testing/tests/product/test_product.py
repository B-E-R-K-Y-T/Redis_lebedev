import httpx
import pytest

from tests.helper.base_methods import BaseMethods
from tests.config import PORT
from tests.helper.base_methods import create_graph
from tests.helper.base_methods import COUNTS
from tests.helper.base_methods import TYPE_REQ


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


class TestProduct(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/product"

    def test_create_product(self):
        BaseMethods.load_post(url=self.url, json={
            "name": "Пылесос на колесиках",
            "description": "Сосет пыль и катается на колесиках",
            "price": 10000,
            "imageUrl": "https://my.images.hosting/image.jpg"
        }, count=100, autotest=f"{__name__}.png", name=TestProduct.__name__)


class TestPutProduct(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/product"

    def test_put_product(self, create_product):
        BaseMethods.load_put(url=self.url + f'/{create_product}', json={
            "name": "Пылесос на колесиках",
            "description": "Сосет пыль и катается на колесиках",
            "price": 10000,
            "imageUrl": "https://my.images.hosting/image.jpg"
        }, count=100, autotest=f"{__name__}.png", name=TestPutProduct.__name__)


class TestDeleteProduct(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/product"

    def func_create_product(self):
        json = {
            "name": "Пылесос на колесиках",
            "description": "Сосет пыль и катается на колесиках",
            "price": 10000,
            "imageUrl": "https://my.images.hosting/image.jpg"
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/product", json=json)
        return resp.json()['id']

    def test_delete(self):
        BaseMethods.load_delete(url=self.url,
                                count=100, autotest=f"{__name__}.png", name=TestDeleteProduct.__name__,
                                met=self.func_create_product, args=())


class TestGetProduct(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/product"

    def func_create_product(self):
        json = {
            "name": "Пылесос на колесиках",
            "description": "Сосет пыль и катается на колесиках",
            "price": 10000,
            "imageUrl": "https://my.images.hosting/image.jpg"
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/product", json=json)
        return resp.json()['id']

    def test_delete(self):
        BaseMethods.load_get(url=self.url,
                             count=100, autotest=f"{__name__}.png", name=TestGetProduct.__name__,
                             met=self.func_create_product, args=())
