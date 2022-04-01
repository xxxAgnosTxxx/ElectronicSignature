import java.security.*;

public class ElectronicSignature {
    private static ElectronicSignature signa = new ElectronicSignature();
    private static Signature signature;
    private static KeyPair pair;

    private ElectronicSignature(){
        KeyPairGenerator generator;
        try {
            generator = KeyPairGenerator.getInstance("DSA");
            signature = Signature.getInstance("SHA256withDSA");
            generator.initialize(2048);
            pair = generator.generateKeyPair();
            signature.initSign(pair.getPrivate());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: Undefined algorithm.");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static void initSignature(byte[] bytes){
        try {
            signature.update(bytes);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getSignature(){
        try {
            return signature.sign();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        System.out.println("Signature isn't initialize.");
        return new byte[0];
    }

    public static boolean checkSignature(byte[] source, byte[] sign){
        Signature s2 = null;
        boolean check = false;
        try {
            s2 = Signature.getInstance("SHA256WithDSA");
            s2.initVerify(pair.getPublic());
            s2.update(source);
            check = s2.verify(sign);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: undefined algorithm.");
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.out.println("Invalid key.");
        }
        return check;
    }
}
