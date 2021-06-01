import sys

class Mycd:
    def changeDir(src: str, dest: str) -> str:
        destStrings = dest.split("/")
        
        destStack = []

        if(dest[0] != '/'):
            srcStrings = src.split("/")
            for chunk in srcStrings:
                if chunk != "":
                    destStack.append("/"+chunk)


        for chunk in destStrings:
            if chunk != ".." and chunk != "." and chunk != "/" and chunk != "":
                    destStack.append("/"+chunk)
            elif chunk == "..":
                #if stack isn't empty pop
                if destStack:
                    destStack.pop()

        if len(destStack) == 0:
            destStack.append("/")

        result = ""

        for chunk in destStack:
            result += chunk

        for c in result:
            if not c.isalnum() and c != "/":
                return dest + ": No such file or directory"

        return result

if __name__ == '__main__':
    print(Mycd.changeDir(sys.argv[1], sys.argv[2]))



