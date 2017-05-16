package MW.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Marek on 2017-04-21.
 */
public class InputExecutiveService implements InputService{

    @Override
    public String input() {
        String string = null;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            string = br.readLine();
            if(string.indexOf(",")!=-1) { string = string.replaceAll(",","."); }
        } catch (IOException e) {

        } catch (NullPointerException e){

        }
        return string;
    }
}
