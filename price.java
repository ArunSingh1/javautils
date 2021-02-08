package com.practice.exam;

public class price {
}


public class AggregateUtil {
//static methods that do the calculations..


    static double getTheAveragePriceForEachCategory(List<Double> product){
        double average = getTotalSalesValueForEachCategory(product)/(double)getNumberOfProductsInEachCategory(product);
        return Math.round(average * 100D) / 100D;
    }

    static double getTotalSalesValueForEachCategory(List<Double> product){
        double sum = 0.0;
        for(Double value : product){
            sum+=value;
        }
        return Math.round(sum * 100D) / 100D;
    }

    static int getNumberOfProductsInEachCategory(List<Double> product){
        return (product.size());
    }

    static double getTheMostExpensiveProductInEachCategory(List<Double> product){
        double highest = Double.MIN_VALUE;
        for(Double value : product){
            if(value>highest) highest = value;
        }
        return highest;
    }
}


public class DisplayUtil {
    //prints the values under each product category..
    public static void DisplayProducts( Map<String, List<Double>> db){
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String,List<Double>> entry : db.entrySet()) {
            builder = new StringBuilder();
            System.out.println(entry.getKey());
            System.out.println("----------------------------------");
            builder.append("average_price = ");
            double avrg_price = AggregateUtil.getTheAveragePriceForEachCategory(entry.getValue());
            builder.append(avrg_price);
            builder.append("\n");
            builder.append("total_sales_value = ");
            double total_sales = AggregateUtil.getTotalSalesValueForEachCategory(entry.getValue());
            builder.append(total_sales);
            builder.append("\n");
            builder.append("number_of_products = ");
            double numberOfProducts = AggregateUtil.getNumberOfProductsInEachCategory(entry.getValue());
            builder.append(numberOfProducts);
            builder.append("\n");
            builder.append("most_expensive = ");
            double mostExpensive = AggregateUtil.getTheMostExpensiveProductInEachCategory(entry.getValue());
            builder.append(mostExpensive);
            builder.append("\n");
            System.out.println(builder + "\n");

        }
    }
}


    public static void ReadFile(String path, Map<String, List<Double>> db){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            if((line = br.readLine()) != null){
                //this is the first heading..and needed to be skipped
            }
            while ((line = br.readLine()) != null) {
                String[] keys = line.split(",");
                keys[1] = keys[1].replace("\"", "");
                if(db.containsKey(keys[1])){
                    List<Double> list = db.get(keys[1]);
                    list.add(Double.valueOf(keys[2]));
                    db.put(keys[1], list);

                }
                else{
                    List<Double> list = new ArrayList<>();
                    list.add(Double.valueOf(keys[2]));
                    db.put(keys[1],list);
                }
            }

        }catch(IOException e){}
    }


}


public class ControllerClass {

    public static void main(String []args){
        Map<String, List<Double>> db = new HashMap<>();
        FileUtils.ReadFile("./Files/products.csv", db);
        DisplayUtil.DisplayProducts(db);

    }

}

