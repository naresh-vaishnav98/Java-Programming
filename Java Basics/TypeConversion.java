public class TypeConversion {
    public static void main (String[] args){
        int a = 68; // int is 4 bytes
        long b = a;  // float is 8 byte

        // Only small to big size and only compatible type of data can be converted
        System.out.println(b);

        
        
        
        
        
        // Type Casting (explicit conversion)

        float p = 3.14f; // "f" for keeping data type as float or else it takes as double
        int q = (int)p;

        System.out.println(q);


        // char to int

        char ch = 'A';
        int num = ch;

        System.out.println(num); // This will print ASCII value of the character



        // Type Promotion

        byte r = 3;
        byte s = (byte) (r * 6); // In expression byte is converted to int
        System.out.println(s);


    }
}
