//calculates square root of given number 
//using Newton-Raphson method
public void abc(int a){
       r = a / 2;
       while ( abs( r - (a/r) ) > t ) {
       r = 0.5 * ( r + (a/r) );
       }
       System.out.println( "r = " + r );
}
