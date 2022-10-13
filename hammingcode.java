// import required classes and packages  
package javaTpoint.JavaExample;  
import java.util.*;  
  
// create HammingCodeExample class to implement the Hamming Code functionality in Java  
class HammingCodeExample {  
      
    // main() method start  
    public static void main(String args[])   
    {  
        // declare variables and array  
        int size, hammingCodeSize, errorPosition;  
        int arr[];  
        int hammingCode[];  
        // create scanner class object to take input from user  
        Scanner sc = new Scanner(System.in);  
        System.out.println("Enter the bits size for the data.");  
        size = sc.nextInt();  
        // initialize array  
        arr = new int[size];  
        // get data from user which we want to transfer   
        for(int j = 0 ; j < size ; j++) {  
            System.out.println("Enter " + (size - j) + "-bit of the data:");  
            // fill array with user entered data  
            arr[size - j - 1] = sc.nextInt();  
        }  
          
        // print the user entered data  
        System.out.println("The data which you enter is:");  
        for(int k = 0 ; k < size ; k++) {  
            System.out.print(arr[size - k - 1]);  
        }  
        System.out.println();   // for next line  
          
        // call getHammingCode() method and store its return value to the hammingCode array  
        hammingCode = getHammingCode(arr);  
        hammingCodeSize = hammingCode.length;  
          
        System.out.println("The hamming code generated for your data is:");  
        for(int i = 0 ; i < hammingCodeSize; i++) {  
            System.out.print(hammingCode[(hammingCodeSize - i - 1)]);  
        }  
        System.out.println();   // for next line  
      
        // The added parity bits are the difference b/w the original data and the returned hammingCode  
        System.out.println("For detecting error at the reciever end, enter position of a bit to alter original data "  
                + "(0 for no error):");  
        errorPosition = sc.nextInt();  
          
        // close Scanner class object  
        sc.close();  
          
        // check whether the user entered position is 0 or not.   
        if(errorPosition != 0) {  
            // alter bit of the user entered position  
            hammingCode[errorPosition - 1] = (hammingCode[errorPosition - 1] + 1) % 2;  
        }  
          
        // print sent data to the receiver  
        System.out.println("Sent Data is:");  
        for(int k = 0; k < hammingCodeSize; k++) {  
            System.out.print(hammingCode[hammingCodeSize - k - 1]);  
        }  
        System.out.println();   // for next line  
        receiveData(hammingCode, hammingCodeSize - arr.length);  
    }  
    // create getHammingCode() method that returns the hamming code for the data which we want to send  
    static int[] getHammingCode(int data[]) {  
        // declare an array that will store the hamming code for the data   
        int returnData[];  
        int size;  
        // code to get the required number of parity bits  
        int i = 0, parityBits = 0 ,j = 0, k = 0;  
        size = data.length;  
        while(i < size) {  
            // 2 power of parity bits must equal to the current position(number of bits traversed + number of parity bits + 1).  
            if(Math.pow(2, parityBits) == (i + parityBits + 1)) {  
                parityBits++;  
            }  
            else {  
                i++;  
            }  
        }  
          
        // the size of the returnData is equal to the size of the original data + the number of parity bits.  
        returnData = new int[size + parityBits];  
      
        // for indicating an unset value in parity bit location, we initialize returnData array with '2'  
      
        for(i = 1; i <= returnData.length; i++) {  
            // condition to find parity bit location  
            if(Math.pow(2, j) == i) {  
              
                returnData[(i - 1)] = 2;  
                j++;  
            }  
            else {  
                returnData[(k + j)] = data[k++];  
            }  
        }  
        // use for loop to set even parity bits at parity bit locations  
        for(i = 0; i < parityBits; i++) {  
          
            returnData[((int) Math.pow(2, i)) - 1] = getParityBit(returnData, i);  
        }  
          
        return returnData;  
    }  
      
    // create getParityBit() method that return parity bit based on the power  
    static int getParityBit(int returnData[], int pow) {  
        int parityBit = 0;  
        int size = returnData.length;  
          
        for(int i = 0; i < size; i++) {  
              
            // check whether returnData[i] contains an unset value or not  
            if(returnData[i] != 2) {  
                  
                // if not, we save the index in k by increasing 1 in its value  
                  
                int k = (i + 1);  
                  
                // convert the value of k into binary  
                String str = Integer.toBinaryString(k);  
              
                //Now, if the bit at the 2^(power) location of the binary value of index is 1,   
                // we check the value stored at that location. If the value is 1 or 0,   
                // we will calculate the parity value.  
              
                int temp = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;  
                if(temp == 1) {  
                    if(returnData[i] == 1) {  
                        parityBit = (parityBit + 1) % 2;  
                    }  
                }  
            }  
        }  
        return parityBit;  
    }  
  
    // create receiveData() method to detect error in the received data  
    static void receiveData(int data[], int parityBits) {  
          
        // declare variable pow, which we use to get the correct bits to check for parity.  
        int pow;  
        int size = data.length;       
        // declare parityArray to store the value of parity check  
        int parityArray[] = new int[parityBits];  
        // we use errorLoc string for storing the integer value of the error location.  
        String errorLoc = new String();  
        // use for loop to check the parities  
        for(pow = 0; pow < parityBits; pow++) {  
            // use for loop to extract the bit from 2^(power)  
            for(int i = 0; i < size; i++) {  
                int j = i + 1;  
                // convert the value of j into binary  
                String str = Integer.toBinaryString(j);  
                // find bit by using str  
                int bit = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;  
                if(bit == 1) {  
                    if(data[i] == 1) {  
                        parityArray[pow] = (parityArray[pow] + 1) % 2;  
                    }  
                }  
            }  
            errorLoc = parityArray[pow] + errorLoc;  
        }  
        // This gives us the parity check equation values.  
        // Using these values, we will now check if there is a single bit error and then correct it.  
        // errorLoc provides parity check eq. values which we use to check whether a single bit error is there or not  
        // if present, we correct it  
        int finalLoc = Integer.parseInt(errorLoc, 2);  
        // check whether the finalLoc value is 0 or not  
        if(finalLoc != 0) {  
            System.out.println("Error is found at location " + finalLoc + ".");  
            data[finalLoc - 1] = (data[finalLoc - 1] + 1) % 2;  
            System.out.println("After correcting the error, the code is:");  
            for(int i = 0; i < size; i++) {  
                System.out.print(data[size - i - 1]);  
            }  
            System.out.println();  
        }  
        else {  
            System.out.println("There is no error in the received data.");  
        }  
        // print the original data  
        System.out.println("The data sent from the sender:");  
        pow = parityBits - 1;  
        for(int k = size; k > 0; k--) {  
            if(Math.pow(2, pow) != k) {  
                System.out.print(data[k - 1]);  
            }  
            else {  
                // decrement value of pow  
                pow--;  
            }  
        }  
        System.out.println();   // for next line  
    }  
}  
