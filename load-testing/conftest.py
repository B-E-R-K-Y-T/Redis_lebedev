import os

import pytest


def pytest_configure():
    from dotenv import load_dotenv
    load_dotenv(dotenv_path=os.path.abspath(".env.local"))
