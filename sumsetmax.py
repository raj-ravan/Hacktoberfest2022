class Solution:

    def maxSum (self, w, x, b, n):

        #code here

        map={}

        for i in range (n):

            map[x[i]]=b[i]

        max_sum=-1000000

        ans_arr=''

        curr_sum=0

        temp=''

        i=0

        while i<len(w):

            #step 1

            

            if w[i] in map:

                curr_sum=curr_sum+map[w[i]]

            else:

                curr_sum=curr_sum+ord(w[i])

            temp=temp+w[i]

            i+=1

            

            #step2

            if curr_sum>max_sum:

                max_sum=curr_sum

                ans_arr=temp

            if curr_sum<0:

                curr_sum=0

                temp=''

        return ans_arr
