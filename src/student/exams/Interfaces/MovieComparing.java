package student.exams.Interfaces;
//Doplnte atributy pro Film
//
//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach
//
//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu
public class MovieComparing {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/Movies.txt");
        ArrayList<Movie> movies = new ArrayList<>();
        while (di.hasNext()){
            String line = di.readLine();
            String[] split = line.split(";");
            movies.add(new Movie(
                    split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]), Long.parseLong(split[3]))
            );
        }

        movies.sort(Movie.BY_NAME);
        for (Movie move : movies){
            System.out.println(move);
        }



        di.finishImport();


    }


}
class Movie implements Comparable<Movie>{
    String name;
    int year;
    double rating;
    long length;


    public Movie(String name, int year, double rating, long length) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", length=" + length +
                '}';
    }



    public static final Comparator<Movie> BY_NAME = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };

  //  public static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {
  //      @Override
  //      public int compare(Movie o1, Movie o2) {
  //          return ;
  //      }
  //  };




    @Override
    public int compareTo(Movie o) {
        return Integer.compare(this.year, o.year);
    }
}


