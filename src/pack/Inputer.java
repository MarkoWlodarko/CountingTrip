package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Marek on 2017-03-18.
 */
public class Inputer {

    private String string;

    public String inputer(String string){
        this.string = string;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            string = br.readLine();
        } catch (IOException e) {

        } catch (NullPointerException e){

        }
        return string;
    }
}
