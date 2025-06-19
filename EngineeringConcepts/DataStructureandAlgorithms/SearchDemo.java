package EngineeringConcepts.DataStructureandAlgorithms;



import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " (" + category + ")";
    }
}

class Search {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

public class SearchDemo {
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Phone", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(104, "Table", "Furniture"),
            new Product(103, "Pen", "Stationery")
        };

        
        Arrays.sort(products, (a, b) -> Integer.compare(a.productId, b.productId));

        int searchId = 104;

        
        Product foundLinear = Search.linearSearch(products, searchId);
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear : "Not found"));

       
        Product foundBinary = Search.binarySearch(products, searchId);
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary : "Not found"));
    }
}
