package com.example.demo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

	private HashMap<String,ArrayList<String>> quotes = new HashMap<>();
    private ArrayList<String> shows = new ArrayList<String>();
    private Random random;
    
    public QuotesController(){

        random = new Random();
        
        ArrayList<String> quotesGot = new ArrayList<String>();
        ArrayList<String> quotesLuci = new ArrayList<String>();
		ArrayList<String> quotesYou = new ArrayList<String>();
		ArrayList<String> quotesDTS = new ArrayList<String>();
        
        quotesGot.add("I drink, and I know things.");
        quotesGot.add("You know nothing Jon Snow");
        quotesLuci.add("Tell Me, What do You Desire?");
        quotesLuci.add("Detective!");
        quotesYou.add("I did it for You");
        quotesYou.add("I believe in love at first sight");
        quotesDTS.add("Max Max Super Max");
        quotesDTS.add("He won in Spa, HE WINS IN MONZA. CHARLES LECLERC!");

        quotes.put("Game of Thrones", quotesGot);
        shows.add("Game of Thrones");

        quotes.put("Lúcifer", quotesLuci);
        shows.add("Lúcifer");

		quotes.put("You", quotesYou);
        shows.add("You");

		quotes.put("Drive to Survive", quotesDTS);
        shows.add("Drive to Survive");
    }

    @GetMapping("/api/quote")
    public Quotes quote(@RequestParam(value = "show", defaultValue = "-1" ) String show_id){

        int id = -1;
        
        try{
            id = Integer.parseInt(show_id);
        }
        catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }
        
        if( id == -1){
            id = random.nextInt( shows.size());
        }

        String show = shows.get(id);

        ArrayList<String> show_quotes = quotes.get(show);
        int random_quote_id = random.nextInt( show_quotes.size());

        String quote = quotes.get(show).get(random_quote_id);
        
        return new Quotes(id, show, quote);
    }

    @GetMapping("api/shows")
    public ArrayList<String> shows(){
        return shows;
    }

}
