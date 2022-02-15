package Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String url = "jdbc:mysql://localhost:3306/aqua_shop";
            String username = "root";
            String password = "ILoveMagicWands13";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ArrayList<Items> bag = new ArrayList<Items>();
            int sum = 0;

            while (true){
                label:
                while (true){
                    System.out.println("1. Fishes\n2. Reptiles\n3. Aquariums\n4. Toys\n5. Filters \n6. Sands \n7. Feed \n8. Cart and total price \n9. Exit");
                    int n = sc.nextInt();
                    ResultSet rs;
                    int id;
                    int price;
                    String name;
                    int choose;
                    switch (n){
                        case 1:
                            rs = st.executeQuery("select * from fishes");

                                while (rs.next()){
                                    id =rs.getInt(1);
                                    name = rs.getString(2);
                                    price = rs.getInt(3);
                                    System.out.println(id + ", Name: " + name + ", price: " + price);
                                }
                                rs.close();
                                choose = sc.nextInt();
                                for (rs = st.executeQuery("select name, price from fishes where id = " + choose + ";"); rs.next(); sum += price){
                                    name = rs.getString(1);
                                    price = rs.getInt(2);
                                    bag.add(new Items(name + " " + price));
                                }
                                break;
                        case 2:
                            rs = st.executeQuery("select * from reptiles");
                            while (rs.next()) {
                                id = rs.getInt(1);
                                name = rs.getString(2);
                                price = rs.getInt(3);
                                System.out.println(id + ", Name: " + name + ", price: " + price);
                            }

                            rs.close();
                            choose = sc.nextInt();
                            rs = st.executeQuery("select name, price from reptiles where id = " + choose + ";");

                                while (true) {
                                    if (!rs.next()){
                                        continue label;
                                    }
                                    name = rs.getString(1);
                                    price = rs.getInt(2);
                                    bag.add(new Items(name + " " + price));
                                    sum += price;
                                }
                        case 3:
                            rs = st.executeQuery("select * from aquarium");

                            while (rs.next()){
                                id = rs.getInt(1);
                                name = rs.getString(2);
                                price = rs.getInt(3);
                                System.out.println(id + ", Name: " + name + ", price: " + price);
                            }

                            rs.close();
                            choose = sc.nextInt();
                            rs = st.executeQuery("select name, price from aquarium where id = " + choose + ";");

                            while (true) {
                                if (!rs.next()){
                                    continue label;
                                }
                                name = rs.getString(1);
                                price = rs.getInt(2);
                                bag.add(new Items(name + " " + price));
                                sum += price;
                            }
                        case 4:
                            rs = st.executeQuery("select * from toys");

                            while(rs.next()) {
                                id = rs.getInt(1);
                                name = rs.getString(2);
                                price = rs.getInt(3);
                                System.out.println(id + ", Name: " + name + " Price: " + price);
                            }

                            rs.close();
                            choose = sc.nextInt();
                            rs = st.executeQuery("select name, price from toys where id = " + choose + ";");

                            while(true) {
                                if (!rs.next()) {
                                    continue label;
                                }

                                name = rs.getString(1);
                                price = rs.getInt(2);
                                bag.add(new Items(name + " " + price));
                                sum += price;
                            }
                        case 5:
                            rs = st.executeQuery("select * from filters");

                            while(rs.next()) {
                                id = rs.getInt(1);
                                name = rs.getString(2);
                                price = rs.getInt(3);
                                System.out.println(id + ", Name: " + name + " Price: " + price);
                            }

                            rs.close();
                            choose = sc.nextInt();
                            rs = st.executeQuery("select name, price from filters where id = " + choose + ";");

                            while(true) {
                                if (!rs.next()) {
                                    continue label;
                                }

                                name = rs.getString(1);
                                price = rs.getInt(2);
                                bag.add(new Items(name + " " + price));
                                sum += price;
                            }

                        case 6:
                            rs = st.executeQuery("select * from sands");

                            while(rs.next()) {
                                id = rs.getInt(1);
                                name = rs.getString(2);
                                price = rs.getInt(3);
                                System.out.println(id + ", Name: " + name + " Price: " + price);
                            }

                            rs.close();
                            choose = sc.nextInt();
                            rs = st.executeQuery("select name, price from sands where id = " + choose + ";");

                            while(true) {
                                if (!rs.next()) {
                                    continue label;
                                }

                                name = rs.getString(1);
                                price = rs.getInt(2);
                                bag.add(new Items(name + " " + price));
                                sum += price;
                            }

                        case 7:
                            rs = st.executeQuery("select * from feed");

                            while(rs.next()) {
                                id = rs.getInt(1);
                                name = rs.getString(2);
                                price = rs.getInt(3);
                                System.out.println(id + ", Name: " + name + " Price: " + price);
                            }

                            rs.close();
                            choose = sc.nextInt();
                            rs = st.executeQuery("select name, price from feed where id = " + choose + ";");

                            while(true) {
                                if (!rs.next()) {
                                    continue label;
                                }

                                name = rs.getString(1);
                                price = rs.getInt(2);
                                bag.add(new Items(name + " " + price));
                                sum += price;
                            }

                        case 8:
                            for(int i = 0; i < bag.size(); ++i) {
                                System.out.println(bag.get(i));
                            }

                            System.out.println(sum);
                            break;
                        case 9:
                            System.exit(0);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
