package brad.tw.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = createAnswer(3);
        //Log.d("brad", answer);

    }

    public void doGuess(View v){
    }

    // create a answer
    private String createAnswer(int n){
        HashSet<Integer> set = new HashSet<>();
        while (set.size()<n){
            set.add((int)(Math.random()*10));
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set){
            sb.append(i);
        }
        return sb.toString();
    }
    // check ?A?B
    private String checkAB(){
        return "1A2B";
    }

}
