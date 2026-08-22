class Solution {
public:
    bool checkDivisibility(int n) {
     int sum=0,product=1;
     int c=n;
     while(n>0)
     {
        sum += n%10;
        product *= n%10;
        n=n/10;
     }   
     if(c%(product+sum)==0) return true;
     else return false;
    }
};