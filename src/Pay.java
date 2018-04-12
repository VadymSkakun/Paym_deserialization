import java.io.*;

public class Pay {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("payments_output.txt");

            for (int i = 1; i <= 5; i++) {
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(new FileInputStream("C:/Users/jamal/Desktop/Payments/payments" + i + ".dat"));
                Payments payments1 = (Payments) objectInputStream.readObject();
                objectInputStream.close(); //TODO можно ли (корректно ли) в цикле закрывать поток?
                payments1.checkNumber = i;
                String line = payments1.customerNumber + "|" + payments1.paymentDate + "|" + payments1.amount + "|" + payments1.checkNumber;

                fw.write(line);
                fw.append('\n');
                fw.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fw.close(); //TODO правильно ли в блоке try-catch закрывать FileWriter?
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
