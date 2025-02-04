import random

def main():
    num = random.randrange(1,11)
    phrase1 = "This is the most common response!"
    phrase2 = "epic guitar solo goes here."
    phrase3 = "shinji get in the robot shinji."
    phrase4 = "JACKBOT BABYYYYYYYYYYYYYY."

    userinput = input("How are you?")
    if(num <= 4):
        print(phrase1)
    elif(num <=6 and num > 4):
        print(phrase2)
    elif(num <= 8 and num >=7):
        print(phrase3)
    else:
        print(phrase4)

main()

# loop integration
# responese based printing
