import java.io.File;

public class main {
    public static void main(String[] args) {
        //read bytes for creating future signature
        File source = FileUtils.getFile("E:/Java/ElektronicSignature/src/main/resources/source.txt");
        byte[] bytes = FileUtils.getBytesFromFile(source);
        //init signature
        ElectronicSignature.initSignature(bytes);
        byte[] signa = ElectronicSignature.getSignature();
        //print signature to file
        File signaFile = FileUtils.getFile("E:/Java/ElektronicSignature/src/main/resources/signature.txt");
        FileUtils.printBytesToFile(signa, signaFile);
        //checking
        System.out.println(ElectronicSignature.checkSignature(bytes, signa));
    }
}
