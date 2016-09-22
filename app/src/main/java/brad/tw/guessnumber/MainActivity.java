package brad.tw.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = createAnswer();
    }

    public void doGuess(View v){

    }

    // create a answer
    private String createAnswer(){
        return "417";
    }
    // check ?A?B
    private String checkAB(){
        return "1A2B";
    }

}
