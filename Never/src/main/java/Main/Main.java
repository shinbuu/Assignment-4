package Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String url = "jdbc:mysql://localhost:3306/aqua_shop"; // инициализируем данные для подключения:localhost это адресс папки с базами данных ,а aqua_shop - это сама база данных откуда мы будем брать значения таблиц
            String username = "root";
            String password = "ILoveMagicWands13";
            Connection conn = DriverManager.getConnection(url, username, password); //Собственно здесь уже создаем переменную conn ,которая и будет содержать подключение
            Statement st = conn.createStatement(); //Statement - это запросы в sql через jav`у
            ArrayList<Items> items = new ArrayList<Items>(); //создаем гибкий arraylist для листа покупок
            int sum = 0; // сумма для покупок 
            System.out.println("____________________________________________________"); // просто приветсвенная надпись
            System.out.println("Hello!This is the Aqua Shop!Let`s try to buy you a new aquarium with fishes ,reptiles and more!So ,please choose a thing that you need in your aquarium.");
            System.out.println("____________________________________________________");
            while (true){
                label: //эта просто название и оно нужно если юзер ввел неправильное значение ,то код продолжается
                while (true){
                    System.out.println("1. Fishes\n2. Reptiles\n3. Aquariums\n4. Toys\n5. Filters \n6. Sands \n7. Feed \n8. Cart and total price \n9. Exit"); // тут юзер выбирает что ему нужно
                    int n = sc.nextInt();
                    ResultSet rs;
                    int id;
                    int price;
                    String name;
                    int choose;
                    switch (n) { //свитч для определения выбора
                        case 1:
                            rs = st.executeQuery("select * from fishes"); //создаем соединение ,затем запрос в sql и выбираем таблицу рыб

                                while (rs.next()){
                                    id =rs.getInt(1); // получаем данные с первой колонки в таблице (id) и записываем ее в переменную id
                                    name = rs.getString(2);
                                    price = rs.getInt(3);
                                    System.out.println(id + ", Name: " + name + ", price: " + price); //выводим значения записанные таблицы в System.out.print
                                }
                                rs.close(); //закрываем соединение ибо как нам завещали "1 соединение 1 запрос"
                                choose = sc.nextInt();// сканим каких рыб выбрал юзер
                                rs = st.executeQuery("select name, price from fishes where id = " + choose + ";"); //делаем новый запрос в sql где выбираем рыб с id которые ввел юхер

                                while (true) {
                                if (!rs.next()){
                                    continue label;
                                }
                                name = rs.getString(1); //записываем в название переменной name значение из таблицы fishes где айди рыбки соответсвует id которое ввел юзер ранее
                                price = rs.getInt(2);
                                items.add(new Items(name + " " + price)); //добавляем новую покупку в гибкий arraylist
                                sum += price; //добавляем данные из переменной price к общей сумме
                                }
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
                                    items.add(new Items(name + " " + price));
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
                                items.add(new Items(name + " " + price));
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
                                items.add(new Items(name + " " + price));
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
                                items.add(new Items(name + " " + price));
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
                                items.add(new Items(name + " " + price));
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
                                items.add(new Items(name + " " + price));
                                sum += price;
                            }

                        case 8:
                            System.out.println("+_________+");
                            for(int i = 0; i < items.size(); ++i) {  //Классеека ,показываем значения из arraylista
                                System.out.println("|" + items.get(i) + "|");
                            }
                            System.out.println("+_________+");
                            System.out.println("Sum: " + sum);
                            System.out.println("____________________________________________________");
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
