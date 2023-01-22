
import java.util.*;
import java.security.*;
import java.math.*;

public class Main {

    static BigInteger p, q, n, phi_n, e, d;
    static SecureRandom securerandom;
    static int bitlength = 64;

    static String encrypt(String msg) {
        return new BigInteger(msg).modPow(e, n).toString();
    }

    static String decrypt(String cipher) {
        return new BigInteger(cipher).modPow(d, n).toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        securerandom = new SecureRandom();
        p = BigInteger.probablePrime(bitlength, securerandom);
        q = BigInteger.probablePrime(bitlength, securerandom);

        n = p.multiply(q);
        phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(bitlength / 2, securerandom);
        while (e.gcd(phi_n).compareTo(BigInteger.ONE) != 0 && e.compareTo(phi_n) < 0) {
            e.add(BigInteger.ONE);
        }

        d = e.modInverse(phi_n);

        System.out.println("p generated Number is :" + p);
        System.out.println("q generated Number is :" + q);
        System.out.println("N assigned is :" + n);
        System.out.println("Enter message\n");
        String msg = sc.next();
        String encryptmsg = encrypt(msg);
        System.out.println("Encrypted message is : " + encryptmsg);
        String decryptmsg = decrypt(encryptmsg);
        System.out.println("Encrypted message is : " + decryptmsg);

    }
}
