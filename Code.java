import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;

class Hotel {
    private int daysToBook;
    private int amount;
    private int rating;

    Hotel() {

    }

    //constructor
    Hotel(int daysToBook, int amount) {
        setDaysToBook(daysToBook);
        setAmount(amount);
    }

    //setter
    public boolean setDaysToBook(int daysToBook) {
        if (daysToBook>=1 && daysToBook<=7) {
            this.daysToBook = daysToBook;
            return true;
        } else {
            System.out.println("You can not book room for more than 7 days.)");
            return false;
        }
    }

    public boolean setAmount(int amount) {
        if (amount < 10000 && amount > 0) {
            Room room = new Room("Studio");
            System.out.println(room.getRoom());
            return true;
        } else if (amount >= 10000 && amount <= 25000) {
            Room room =new Room("Executive Suite");
            System.out.println(room.getRoom());
            return true;
        } else if (amount >= 50000) {
            Room room =new Room("Cabana");
            System.out.println(room.getRoom());
            return true;
        } else if ((amount >= 25001 && amount <= 49999) || amount < 0) {
            System.out.println("Invalid price range");
            return false;
        }
        return false;
    }

    public boolean giveRating(int rating) {
        if (rating>=1 && rating<=5) {
                this.rating = rating;
                System.out.println("Thank you for your valuable response. Please Visit us again!");
                return true;
            }
            else {
                System.out.println("Thanks!");
                return false;
            }
    }

    public String setRating(String answeryesno) {
        if (answeryesno.equals("yes") || answeryesno.equals("Yes") || answeryesno.equals("y") || answeryesno.equals("Y")) {
            return "yes";
        }
        else{
            System.out.println("Please visit us again!");
            return "no";
        }
    }
}
//room class
class Room {
    private String room;
    Room(String room) {
        setRoom(room);
    }

    public void setRoom(String room) {
        this.room = room;
    }
    public String getRoom(){
        return this.room;
    }
}

class User {
    private String name;
    private String cnic;
    private String birthday;
    private String photo;
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

    User(){

    }
    User(String name, String cnic, String birthday, String photo) {
        setName(name);
        setCnic(cnic);
        setBirthday(birthday);
        setPhoto(photo);
    }

    private boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (Character.isWhitespace(c)){
                continue;
            }
            if(!Character.isLetter(c)) {
                System.out.println("Name is not Alphabetical");
                return false;
            }
        }
        return true;
    }

    public boolean toTitleCase(String name) {

        String nameOrignial= name;




        //split the string by space
        String[] parts = name.split(" ");

        StringBuilder sb = new StringBuilder( name.length() );

        for(String part : parts){

            if(part.length() > 1 )
                sb.append( part.substring(0, 1).toUpperCase() )
                        .append( part.substring(1).toLowerCase() );
            else
                sb.append(part.toUpperCase());

            sb.append(" ");
        }



        if (nameOrignial.equals(sb.toString().trim())){
            System.out.println("Name is in Title Case");
            return true;
        }
        else {
            System.out.println("Name is not in Title Case");
            return false;
        }
    }

    public boolean setName(String name) {
        if ((name.length() != 0) && isAlpha(name) && toTitleCase(name)) {
            this.name = name;
            return true;
        }
        else{
            return false;
        }
    }

    private boolean dateChecker(String bday) {
        if (bday.charAt(2) != '-' && bday.charAt(5) != '-') {
            System.out.println("Invalid date format");
            return false;
        } else if (Integer.parseInt(bday.substring(0,2))<1 || Integer.parseInt(bday.substring(0,2))>31) {
            System.out.println("Invalid date entered");
            return false;
        } else if (Integer.parseInt(bday.substring(3,5))<1 || Integer.parseInt(bday.substring(3,5))>12) {
            System.out.println("Invalid month entered");
            return false;
        } else if (Integer.parseInt(bday.substring(6,10))<1900 || Integer.parseInt(bday.substring(6,10))>2022) {
            System.out.println("Invalid year entered");
            return false;
        }
        return true;
    }

    public boolean setBirthday(String birthday) {
        if (dateChecker(birthday)) {
            this.birthday = birthday;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setCnic(String cnic) {
        if (cnic.length()==13 && isNumeric(cnic)) {
            this.cnic = cnic;
            return true;
        } else {
            System.out.println("Invalid input");
            return false;
        }
    }

    public boolean setPhoto(String photo) {
        String type = photo.substring(photo.lastIndexOf(".")+1);
        //System.out.println(type);
        if (type.equals("jpeg") || type.equals("png")) {
            this.photo = photo;
            return true;
        } else {
            System.out.println("Invalid input");
            return false;
        }
    }

    private boolean isNumeric(String str) {
        long value;
        if (str == null || str.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            value = Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

}

public class Code {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);


        User user=new User();
        Hotel hotel=new Hotel();

        System.out.println("Welcome to hotel booking system!!!");

        while(true){

            //number of days
            System.out.print("Enter number of days for which you want to book room : ");
            while(true){
                int daysToBook=input.nextInt();
                if(hotel.setDaysToBook(daysToBook)) {
                    break;
                }
                else{
                    System.out.print("Enter number of days for which you want to book room : ");
                }
            }

            System.out.print("Enter amount you want to pay per day : ");
            while(true){
                int amount=input.nextInt();
                if(hotel.setAmount(amount)) {
                    break;
                }
                else{
                    System.out.print("Enter amount you want to pay per day : ");
                }
            }
            //name
            System.out.print("Enter your name : ");
            input.nextLine();
            while(true){
                String nameinput=input.nextLine();

                if(user.setName(nameinput)) {
                    break;
                }
                else{
                    System.out.print("Enter your name : ");
                }
            }
            //birthday

            System.out.print("Enter your Birthday : ");
            while(true){
                String birthDay=input.next();
                if(user.setBirthday(birthDay)) {

                    break;
                }
                else{
                    System.out.print("Enter your Birthday : ");
                }
            }

            //cnic

            System.out.print("Enter your cnic : ");
            while(true){
                String cnic=input.next();
                if(user.setCnic(cnic)) {

                    break;
                }
                else{
                    System.out.print("Enter your cnic : ");
                }
            }

            System.out.print("Enter photo of cnic : ");
            while(true){
                String path=input.next();
                if(user.setPhoto(path)) {

                    break;
                }
                else{
                    System.out.print("Enter photo of cnic : ");
                }
            }
            System.out.print("Would you like to give Rating? Yes or No ");
            while(true){
                String answer=input.next();

                if ("yes".equals(hotel.setRating(answer))){
                    System.out.println("Please enter rating between 1 and 5: ");
                    int rating = input.nextInt();
                    hotel.giveRating(rating);
                    break;
                }

            }

            break;
        }}
    }
