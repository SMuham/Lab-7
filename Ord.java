import java.util.Scanner;
import java.nio.file.Paths;

public class Ord {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Paths.get("OrderDetails.txt"))) {
          
            StringBuilder fileContent = new StringBuilder();

            
            int[] rowsArray = new int[2820];     
            double[] unitPriceArray = new double[2820];
            int[] quantityArray = new int[2820];
            double[] discountArray = new double[2820];
            double[] totalPriceArray = new double[2820];

           
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent.append(line).append("\n");

                String[] values = line.split(",");
                rowsArray[i] = Integer.parseInt(values[0]);
                unitPriceArray[i] = Double.parseDouble(values[1]);
                quantityArray[i] = Integer.parseInt(values[3]);
                discountArray[i] = Double.parseDouble(values[4]);

             
                totalPriceArray[i] = calculateTotalPrice(unitPriceArray[i], quantityArray[i], discountArray[i]);

                i++;
            }

         
            
          
            for (int j = 0; j < i; j++) {
                System.out.println("Row: " + rowsArray[j] +
                        ", Unit Price: " + unitPriceArray[j] +
                        ", Quantity: " + quantityArray[j] +
                        ", Discount: " + discountArray[j] +
                        ", Total Price: " + totalPriceArray[j]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double calculateTotalPrice(double unitPrice, int quantity, double discount) {
        return unitPrice * quantity - (discount * unitPrice * quantity);
    }
}






