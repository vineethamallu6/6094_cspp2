import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {
    private String nameOfTheMovie;
    private String dateAndTime;
    private String[] seatNumbers;
    /**
     * Constructor for the class show.
     *
     * @param      m  moviename.
     * @param      d date and time.
     * @param      s  seats string.
     */
    Show(final String m, final String d, final String[] s) {
        this.nameOfTheMovie = m;
        this.dateAndTime = d;
        this.seatNumbers = s;
    }
    /**
     * Gets the movie name.
     *
     * @return returns the movie name.
     */
    public String getMovieName() {
        return this.nameOfTheMovie;
    }
    /**
     * Gets the date and time.
     *
     * @return returns date and time.
     */
    public String getDateAndTime() {
        return this.dateAndTime;
    }
    /**
     * Gets the seat numbers.
     *
     * @return returns the seat numbers.
     */
    public String[] getSeatNumbers() {
        return this.seatNumbers;
    }
    /**
     * Sets the seat.
     *
     * @param index the index variable.
     * @param set the set variable to set the name of seat.
     */
    public void setSeat(final int index, final String set) {
        seatNumbers[index] = set;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return returns string representation of the object.
     */
    public String toString() {
        return this.nameOfTheMovie + "," + this.dateAndTime;
    }
}

class Patron {
    /**
     * username variable.
     */
    private String patronName;
    /**
     * mobile number variable.
     */
    private String mobileNumber;
    /**
     * constructor for patron class.
     *
     * @param n name of the user.
     * @param mbnum mobilenumber of the user.
     */
    Patron(final String n, final String mbnum) {
        this.patronName = n;
        this.mobileNumber = mbnum;
    }
    public String getName() {
        return this.patronName;
    }
    public String getMobileNumber() {
        return this.mobileNumber;
    }
}


class BookYourShow {
    List<Show> showDetails;
    List<String> bookedTickets;
    public BookYourShow() {
        //constructor
        showDetails = new List<Show>();
        bookedTickets = new List<String>();
    }
    public void addAShow(final Show obj) {
        showDetails.add(obj);
    }
    public Show getAShow(final String movieName, final String dateAndTime) {
        for (int i = 0; i < showDetails.size(); i++) {
            if (showDetails.get(i).getMovieName().equals(movieName)&&
                showDetails.get(i).getDateAndTime().equals(dateAndTime)) {
                return showDetails.get(i);
            }
        }
        return null;
    }
    public void bookAShow(final String movieName, final String dateAndTime, final Patron obj, final String[] seats) {
        Show movieData = getAShow(movieName, dateAndTime);
        if (movieData != null) {
            for (int i = 0; i < movieData.getSeatNumbers().length; i++) {
                for (int j = 0; j < seats.length; j++) {
                    if (seats[j].equals(movieData.getSeatNumbers()[i])) {
                        movieData.setSeat(i, "N/A");
                        bookedTickets.add(obj.getMobileNumber() + " " + movieName + " " + dateAndTime);
                    }
                }
            }
        } else {
            System.out.println("No show");
        }
    }
    public void printTickets(final String movieName, final String dateAndTime, final String mobileNumber) {
        //print the tickets
        for (int i = 0; i < bookedTickets.size(); i++) {
            if ((mobileNumber + " " + movieName + " " + dateAndTime).equals(bookedTickets.get(i))) {
                System.out.println(mobileNumber + " " + movieName + " " + dateAndTime);
                return;
            }
        }
        System.out.println("Invalid");
        return;
    }
    public void showAll() {
        //print all the available shows
        for (int i = 0; i < showDetails.size(); i++) {

            System.out.println(showDetails.get(i).toString() + "," +
                Arrays.toString(showDetails.get(i).getSeatNumbers()).replace(" ",""));
        }
    }
}

public class Solution {
    /**
     * main method for class solution.
     *
     * @param args  The arguments.
     */
   public  static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;
                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTickets(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}


