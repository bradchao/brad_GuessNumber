package brad.tw.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private String answer;
    private TextView info;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = (TextView)findViewById(R.id.textInfo);
        input = (EditText)findViewById(R.id.editGuess);

        answer = createAnswer(3);
        //Log.d("brad", answer);

    }

    public void doGuess(View v){
        String guess = input.getText().toString();
        String result = checkAB(answer, guess);
        info.append(guess + ":" + result + "\n");
        input.setText("");
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
    private String checkAB(String a, String g){
        return "1A2B";
    }

}
