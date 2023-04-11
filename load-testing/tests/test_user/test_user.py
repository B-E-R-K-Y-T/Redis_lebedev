import os
import httpx
import pytest

from tests.helper.base_methods import BaseMethods
from tests.config import PORT


@pytest.fixture(scope="function")
def create_user():
    json = {
        "name": BaseMethods.generate_name(),
        "email": BaseMethods.generate_mail()
    }
    resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/user", json=json)
    return resp.json()['id']


class TestCreateUser(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/user"

    def test_create_user(self):
        BaseMethods.load_post(url=self.url,
                              json={"name": BaseMethods.generate_name(),
                                    "email": BaseMethods.generate_mail()},
                              count=100, autotest=f"{__name__}.png", name=TestCreateUser.__name__)


class TestPutUser(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/user"

    def test_put_user(self, create_user):
        BaseMethods.load_put(url=self.url + f'/{create_user}',
                             json={
                                 "name": "Тимофей Кондаков",
                                 "email": "username@service.domain"
                             },
                             count=100, autotest=f"{__name__}.png", name=TestPutUser.__name__)


class TestDeleteUser(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/user"

    def func_create_user(self):
        json = {
            "name": BaseMethods.generate_name(),
            "email": BaseMethods.generate_mail()
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/user", json=json)
        return resp.json()['id']

    def test_delete(self):
        BaseMethods.load_delete(url=self.url,
                                count=100, autotest=f"{__name__}.png", name=TestDeleteUser.__name__,
                                met=self.func_create_user, args=())


class TestGetUser(BaseMethods):
    def setup(self):
        self.url = f"http://localhost:{PORT}/api/v1/user"

    def func_create_user(self):
        json = {
            "name": BaseMethods.generate_name(),
            "email": BaseMethods.generate_mail()
        }
        resp = httpx.post(url=f"http://localhost:{PORT}/api/v1/user", json=json)
        return resp.json()['id']

    def test_delete(self):
        BaseMethods.load_get(url=self.url,
                             count=100, autotest=f"{__name__}.png", name=TestGetUser.__name__,
                             met=self.func_create_user, args=())
