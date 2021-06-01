import unittest
from Mycd import *

class TestMycd(unittest.TestCase):

    def test_first(self):
        src = "/"
        dst = "home"
        expResult = "/home"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult
    
    def test_second(self):
        src = "/abc/def"
        dst = "ghi"
        expResult = "/abc/def/ghi"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_third(self):
        src = "/abc/def"
        dst = ".."
        expResult = "/abc"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_fourth(self):
        src = "/abc/def"
        dst = "/abc"
        expResult = "/abc"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_fifth(self):
        src = "/abc/def"
        dst = "/abc/klm"
        expResult = "/abc/klm"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_sixth(self):
        src = "/abc/def"
        dst = "../.."
        expResult = "/"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_seventh(self):
        src = "/abc/def"
        dst = "../../.."
        expResult = "/"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_eighth(self):
        src = "/abc/def"
        dst = "."
        expResult = "/abc/def"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult


    def test_ninth(self):
        src = "/abc/def"
        dst = "..klm"
        expResult = "..klm: No such file or directory"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_tenth(self):
        src = "/abc/def"
        dst = "//////"
        expResult = "/"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_eleventh(self):
        src = "/abc/def"
        dst = "......"
        expResult = "......: No such file or directory"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

    def test_twelfth(self):
        src = "/abc/def"
        dst = "../gh///../klm/."
        expResult = "/abc/klm"
        actualResult = Mycd.changeDir(src, dst)
        assert expResult == actualResult

if __name__ == '__main__':
    unittest.main()
