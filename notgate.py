''' A NOT Gate is a logic gate in boolean algebra which results to False(0) if the input is 1,
   and True(1) if the input is 0.
   Following is the truth table of a NOT Gate:
   |   Input   | Output  |
   |      0      |      1      | 
   |      1      |      0      | 
'''
'''Following is the code implementation of the NOT Gate'''

def NOT_Gate(input_1):
    if input_1 == 0 :
        return 1
    else:
        return 0
    
if __name__== '__main__':
    print('Truth Table of NOT Gate:')
    print('|   Input   |',' Output  |')
    print('|      0      |      ',NOT_Gate(0),'     |')
    print('|      1      |      ',NOT_Gate(1),'     |')

'''Code provided by Akshaj Vishwanathan'''          

