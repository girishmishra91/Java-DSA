class Solution {
    public double power(double x,int n){
        if(n==0) return 1.0;
        double ans=power(x,n/2);
        if(n%2==0)return ans*ans;
        else return ans*ans*x;
    }
    public double myPow(double x, int n) {
        //long N=n;
        if(n<0){
            x=1/x;
            n=-n;
        }
        return power(x,n);
    }
}