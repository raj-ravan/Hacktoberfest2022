# function to determine the class of an Ip address
def findClass(ip):
    if (ip[0] >= 0 and ip[0] <= 127):
        return "A"

    elif (ip[0] >= 128 and ip[0] <= 191):
        return "B"

    elif (ip[0] >= 192 and ip[0] <= 223):
     return "C"

    elif (ip[0] >= 224 and ip[0] <= 239):
     return "D"

    else:
     return "E"


# function to separate network and host id from the given ip address
def separate(ip, className):


# for class A network
  if (className == "A"):
    print("Network Address is : ", ip[0])
    print("Host Address is : ", ".".join(ip[1:4]))

# for class B network
  elif (className == "B"):
    print("Network Address is : ", ".".join(ip[0:2]))
    print("Host Address is : ", ".".join(ip[2:4]))

# for class C network
  elif (className == "C"):
    print("Network Address is : ", ".".join(ip[0:3]))
    print("Host Address is : ", ip[3])

  else:
    print("In this Class, IP address is not divided into Network and Host ID")

# driver's code
if __name__ == "__main__":

  ip =  input("enter the addresses")
  ip = ip.split(".")
  ip = [int(i) for i in ip]

# getting the network class
networkClass = findClass(ip)
print("Given IP address belongs to class : ", networkClass)

# printing network and host id
ip = [str(i) for i in ip]
separate(ip, networkClass)
